package k;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: DefaultTaskExecutor.java */
/* loaded from: classes.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    private final Object f29684a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f29685b = Executors.newFixedThreadPool(4, new a(this));

    /* renamed from: c  reason: collision with root package name */
    private volatile Handler f29686c;

    /* compiled from: DefaultTaskExecutor.java */
    /* loaded from: classes.dex */
    class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f29687a = new AtomicInteger(0);

        a(b bVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", Integer.valueOf(this.f29687a.getAndIncrement())));
            return thread;
        }
    }

    private static Handler e(Looper looper) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 28) {
            return Handler.createAsync(looper);
        }
        if (i10 >= 16) {
            try {
                return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            } catch (InvocationTargetException unused2) {
                return new Handler(looper);
            }
        }
        return new Handler(looper);
    }

    @Override // k.c
    public void a(Runnable runnable) {
        this.f29685b.execute(runnable);
    }

    @Override // k.c
    public boolean c() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // k.c
    public void d(Runnable runnable) {
        if (this.f29686c == null) {
            synchronized (this.f29684a) {
                if (this.f29686c == null) {
                    this.f29686c = e(Looper.getMainLooper());
                }
            }
        }
        this.f29686c.post(runnable);
    }
}
