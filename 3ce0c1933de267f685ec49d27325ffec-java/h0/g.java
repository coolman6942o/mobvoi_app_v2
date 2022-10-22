package h0;

import android.os.Handler;
import android.os.Process;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* compiled from: RequestExecutor.java */
/* loaded from: classes.dex */
class g {

    /* compiled from: RequestExecutor.java */
    /* loaded from: classes.dex */
    private static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private String f27674a;

        /* renamed from: b  reason: collision with root package name */
        private int f27675b;

        /* compiled from: RequestExecutor.java */
        /* renamed from: h0.g$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0297a extends Thread {

            /* renamed from: a  reason: collision with root package name */
            private final int f27676a;

            C0297a(Runnable runnable, String str, int i10) {
                super(runnable, str);
                this.f27676a = i10;
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(this.f27676a);
                super.run();
            }
        }

        a(String str, int i10) {
            this.f27674a = str;
            this.f27675b = i10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new C0297a(runnable, this.f27674a, this.f27675b);
        }
    }

    /* compiled from: RequestExecutor.java */
    /* loaded from: classes.dex */
    private static class b<T> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private Callable<T> f27677a;

        /* renamed from: b  reason: collision with root package name */
        private j0.a<T> f27678b;

        /* renamed from: c  reason: collision with root package name */
        private Handler f27679c;

        /* compiled from: RequestExecutor.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ j0.a f27680a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Object f27681b;

            a(b bVar, j0.a aVar, Object obj) {
                this.f27680a = aVar;
                this.f27681b = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                this.f27680a.accept(this.f27681b);
            }
        }

        b(Handler handler, Callable<T> callable, j0.a<T> aVar) {
            this.f27677a = callable;
            this.f27678b = aVar;
            this.f27679c = handler;
        }

        @Override // java.lang.Runnable
        public void run() {
            T t10;
            try {
                t10 = this.f27677a.call();
            } catch (Exception unused) {
                t10 = null;
            }
            this.f27679c.post(new a(this, this.f27678b, t10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ThreadPoolExecutor a(String str, int i10, int i11) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, i11, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new a(str, i10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void b(Executor executor, Callable<T> callable, j0.a<T> aVar) {
        executor.execute(new b(h0.b.a(), callable, aVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T c(ExecutorService executorService, Callable<T> callable, int i10) throws InterruptedException {
        try {
            return executorService.submit(callable).get(i10, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e10) {
            throw e10;
        } catch (ExecutionException e11) {
            throw new RuntimeException(e11);
        } catch (TimeoutException unused) {
            throw new InterruptedException("timeout");
        }
    }
}
