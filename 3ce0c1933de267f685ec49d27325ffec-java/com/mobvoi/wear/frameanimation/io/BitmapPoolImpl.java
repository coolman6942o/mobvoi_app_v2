package com.mobvoi.wear.frameanimation.io;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.mobvoi.wear.frameanimation.FrameAnimation;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy;
import io.m;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import ko.a;
import kotlin.jvm.internal.i;
import vo.f;
/* compiled from: BitmapPoolImpl.kt */
/* loaded from: classes2.dex */
public class BitmapPoolImpl implements BitmapPool {
    private ThreadLocal<BitmapDecoder> decoders;
    private Thread dispatcherThread;
    private final Context mContext;
    private final ThreadPoolExecutor mDecodeThreadPool;
    private final LinkedBlockingQueue<WeakReference<Bitmap>> mInBitmapPool;
    private final LinkedBlockingQueue<Bitmap> mPool;
    private RepeatStrategy mRepeatStrategy;
    private final int poolSize;
    private volatile boolean restartNextDecode;
    private final int skipInBitmapCount;
    private volatile int state;
    private final BlockingQueue<Runnable> workQueue;
    private AtomicInteger mIndex = new AtomicInteger();
    private final Semaphore permit = new Semaphore(1);
    private final ConcurrentSkipListMap<Integer, Bitmap> tempBitmapStore = new ConcurrentSkipListMap<>();
    private final String TAG = getClass().getSimpleName();
    private final ReusableCountDownLatch mCountDownLatch = new ReusableCountDownLatch();

    public BitmapPoolImpl(Context context) {
        int c10;
        i.f(context, "context");
        this.mContext = context;
        c10 = f.c(Math.min(Runtime.getRuntime().availableProcessors() - 1, 4), 2);
        this.poolSize = c10;
        this.mPool = new LinkedBlockingQueue<>(c10);
        this.mInBitmapPool = new LinkedBlockingQueue<>(c10);
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(c10 * 2);
        this.workQueue = arrayBlockingQueue;
        this.skipInBitmapCount = c10;
        final AtomicInteger atomicInteger = new AtomicInteger();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(c10, c10, 30L, TimeUnit.SECONDS, arrayBlockingQueue, new ThreadFactory() { // from class: com.mobvoi.wear.frameanimation.io.b
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread;
                thread = BitmapPoolImpl.m15_init_$lambda1(atomicInteger, runnable);
                return thread;
            }
        });
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        m mVar = m.f28349a;
        this.mDecodeThreadPool = threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final Thread m15_init_$lambda1(AtomicInteger ac2, Runnable runnable) {
        i.f(ac2, "$ac");
        Thread thread = new Thread(runnable);
        thread.setName("FA-" + ac2.getAndIncrement() + "DecodeThread");
        return thread;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearAndStop() {
        this.mPool.clear();
        this.decoders = null;
        this.mRepeatStrategy = null;
        this.mInBitmapPool.clear();
        this.mIndex.set(0);
        this.state = 0;
        this.tempBitmapStore.clear();
        this.permit.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void decodeBitmap() {
        int i10 = 0;
        if (this.restartNextDecode) {
            this.mIndex.set(0);
            this.restartNextDecode = false;
        }
        this.mCountDownLatch.setCount(this.poolSize);
        int i11 = this.poolSize;
        if (i11 > 0) {
            do {
                i10++;
                try {
                    this.mDecodeThreadPool.execute(new Runnable() { // from class: com.mobvoi.wear.frameanimation.io.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            BitmapPoolImpl.m16decodeBitmap$lambda3(BitmapPoolImpl.this);
                        }
                    });
                    continue;
                } catch (RejectedExecutionException unused) {
                }
            } while (i10 < i11);
            this.mCountDownLatch.await();
            insertPool(this.tempBitmapStore);
        }
        this.mCountDownLatch.await();
        insertPool(this.tempBitmapStore);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: decodeBitmap$lambda-3  reason: not valid java name */
    public static final void m16decodeBitmap$lambda3(BitmapPoolImpl this$0) {
        int andIncrement;
        ThreadLocal<BitmapDecoder> threadLocal;
        i.f(this$0, "this$0");
        try {
            try {
                andIncrement = this$0.mIndex.getAndIncrement();
                threadLocal = this$0.decoders;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            if (threadLocal != null) {
                i.d(threadLocal);
                BitmapDecoder bitmapDecoder = threadLocal.get();
                if (bitmapDecoder == null) {
                    bitmapDecoder = new BitmapDecoderImpl(this$0.mContext);
                    ThreadLocal<BitmapDecoder> threadLocal2 = this$0.decoders;
                    i.d(threadLocal2);
                    threadLocal2.set(bitmapDecoder);
                }
                RepeatStrategy repeatStrategy = this$0.mRepeatStrategy;
                Bitmap bitmap = null;
                FrameAnimation.PathData nextFrameResource = repeatStrategy == null ? null : repeatStrategy.getNextFrameResource(andIncrement);
                if (nextFrameResource == null) {
                    this$0.stop();
                } else {
                    WeakReference<Bitmap> poll = this$0.mInBitmapPool.poll();
                    if (poll != null) {
                        bitmap = poll.get();
                    }
                    Bitmap decodeBitmap = bitmapDecoder.decodeBitmap(nextFrameResource, bitmap);
                    if (this$0.state == 2 && !Thread.currentThread().isInterrupted() && decodeBitmap != null) {
                        this$0.tempBitmapStore.put(Integer.valueOf(andIncrement), decodeBitmap);
                    }
                }
            }
        } finally {
            this$0.mCountDownLatch.countDown();
        }
    }

    private final void insertPool(ConcurrentSkipListMap<Integer, Bitmap> concurrentSkipListMap) {
        Set<Map.Entry<Integer, Bitmap>> entrySet = concurrentSkipListMap.entrySet();
        i.e(entrySet, "map.entries");
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            i.e(entry, "(_, value)");
            this.mPool.put((Bitmap) entry.getValue());
        }
        concurrentSkipListMap.clear();
    }

    private final void relay(RepeatStrategy repeatStrategy) {
        this.mRepeatStrategy = repeatStrategy;
        this.restartNextDecode = true;
    }

    @Override // com.mobvoi.wear.frameanimation.io.BitmapPool
    public RepeatStrategy getRepeatStrategy() {
        return this.mRepeatStrategy;
    }

    @Override // com.mobvoi.wear.frameanimation.io.BitmapPool
    public void recycle(Bitmap bitmap) {
        i.f(bitmap, "bitmap");
        if (this.state == 2 && this.skipInBitmapCount <= this.mIndex.get()) {
            this.mInBitmapPool.offer(new WeakReference<>(bitmap));
        }
    }

    @Override // com.mobvoi.wear.frameanimation.io.BitmapPool
    public void release() {
        stop();
        this.mDecodeThreadPool.shutdownNow();
    }

    @Override // com.mobvoi.wear.frameanimation.io.BitmapPool
    public void start(RepeatStrategy repeatStrategy, int i10) {
        i.f(repeatStrategy, "repeatStrategy");
        if (this.mDecodeThreadPool.isShutdown()) {
            throw new IllegalStateException("can't start animation after release");
        } else if (this.state == 2) {
            relay(repeatStrategy);
        } else {
            this.state = 1;
            if (!this.permit.tryAcquire(100L, TimeUnit.MILLISECONDS)) {
                Log.e(this.TAG, "start failed, get acquire took too long time");
                stop();
                return;
            }
            this.state = 2;
            this.mIndex.set(i10);
            this.decoders = new ThreadLocal<>();
            this.mRepeatStrategy = repeatStrategy;
            this.dispatcherThread = a.b(true, false, null, "FA-DispatcherThread", 0, new BitmapPoolImpl$start$1(this), 22, null);
        }
    }

    @Override // com.mobvoi.wear.frameanimation.io.BitmapPool
    public void stop() {
        if (this.state == 2) {
            Thread thread = this.dispatcherThread;
            if (thread != null) {
                thread.interrupt();
            }
            this.state = 3;
            this.workQueue.clear();
        }
    }

    @Override // com.mobvoi.wear.frameanimation.io.BitmapPool
    public Bitmap take() {
        if (this.state == 2 || this.state == 1) {
            return this.mPool.take();
        }
        return null;
    }
}
