package w4;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.mobvoi.wear.util.TelephonyUtil;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: GlideExecutor.java */
/* loaded from: classes.dex */
public final class a implements ExecutorService {

    /* renamed from: b  reason: collision with root package name */
    private static final long f35992b = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: c  reason: collision with root package name */
    private static volatile int f35993c;

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f35994a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GlideExecutor.java */
    /* renamed from: w4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class ThreadFactoryC0519a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final String f35995a;

        /* renamed from: b  reason: collision with root package name */
        final b f35996b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f35997c;

        /* renamed from: d  reason: collision with root package name */
        private int f35998d;

        /* compiled from: GlideExecutor.java */
        /* renamed from: w4.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0520a extends Thread {
            C0520a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (ThreadFactoryC0519a.this.f35997c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th2) {
                    ThreadFactoryC0519a.this.f35996b.a(th2);
                }
            }
        }

        ThreadFactoryC0519a(String str, b bVar, boolean z10) {
            this.f35995a = str;
            this.f35996b = bVar;
            this.f35997c = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            C0520a aVar;
            aVar = new C0520a(runnable, "glide-" + this.f35995a + "-thread-" + this.f35998d);
            this.f35998d = this.f35998d + 1;
            return aVar;
        }
    }

    /* compiled from: GlideExecutor.java */
    /* loaded from: classes.dex */
    public interface b {

        /* renamed from: a  reason: collision with root package name */
        public static final b f36000a;

        /* renamed from: b  reason: collision with root package name */
        public static final b f36001b;

        /* compiled from: GlideExecutor.java */
        /* renamed from: w4.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0521a implements b {
            C0521a() {
            }

            @Override // w4.a.b
            public void a(Throwable th2) {
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: w4.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0522b implements b {
            C0522b() {
            }

            @Override // w4.a.b
            public void a(Throwable th2) {
                if (th2 != null && Log.isLoggable("GlideExecutor", 6)) {
                    Log.e("GlideExecutor", "Request threw uncaught throwable", th2);
                }
            }
        }

        /* compiled from: GlideExecutor.java */
        /* loaded from: classes.dex */
        class c implements b {
            c() {
            }

            @Override // w4.a.b
            public void a(Throwable th2) {
                if (th2 != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th2);
                }
            }
        }

        static {
            new C0521a();
            C0522b bVar = new C0522b();
            f36000a = bVar;
            new c();
            f36001b = bVar;
        }

        void a(Throwable th2);
    }

    a(ExecutorService executorService) {
        this.f35994a = executorService;
    }

    public static int a() {
        if (f35993c == 0) {
            f35993c = Math.min(4, w4.b.a());
        }
        return f35993c;
    }

    public static a b() {
        return c(a() >= 4 ? 2 : 1, b.f36001b);
    }

    public static a c(int i10, b bVar) {
        return new a(new ThreadPoolExecutor(i10, i10, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0519a("animation", bVar, true)));
    }

    public static a d() {
        return e(1, "disk-cache", b.f36001b);
    }

    public static a e(int i10, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i10, i10, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0519a(str, bVar, true)));
    }

    public static a f() {
        return g(a(), TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE, b.f36001b);
    }

    public static a g(int i10, String str, b bVar) {
        return new a(new ThreadPoolExecutor(i10, i10, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new ThreadFactoryC0519a(str, bVar, false)));
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f35992b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new ThreadFactoryC0519a("source-unlimited", b.f36001b, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f35994a.awaitTermination(j10, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f35994a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f35994a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f35994a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f35994a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f35994a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f35994a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.f35994a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f35994a.submit(runnable);
    }

    public String toString() {
        return this.f35994a.toString();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException {
        return this.f35994a.invokeAll(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j10, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f35994a.invokeAny(collection, j10, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t10) {
        return this.f35994a.submit(runnable, t10);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f35994a.submit(callable);
    }
}
