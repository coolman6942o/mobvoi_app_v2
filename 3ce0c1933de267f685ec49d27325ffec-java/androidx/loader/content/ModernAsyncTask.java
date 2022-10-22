package androidx.loader.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadFactory f3367f;

    /* renamed from: g  reason: collision with root package name */
    private static final BlockingQueue<Runnable> f3368g;

    /* renamed from: h  reason: collision with root package name */
    public static final Executor f3369h;

    /* renamed from: i  reason: collision with root package name */
    private static f f3370i;

    /* renamed from: a  reason: collision with root package name */
    private final g<Params, Result> f3371a;

    /* renamed from: b  reason: collision with root package name */
    private final FutureTask<Result> f3372b;

    /* renamed from: c  reason: collision with root package name */
    private volatile Status f3373c = Status.PENDING;

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f3374d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f3375e = new AtomicBoolean();

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes.dex */
    static class a implements ThreadFactory {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f3376a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f3376a.getAndIncrement());
        }
    }

    /* loaded from: classes.dex */
    class b extends g<Params, Result> {
        b() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            ModernAsyncTask.this.f3375e.set(true);
            Result result = null;
            try {
                Process.setThreadPriority(10);
                result = (Result) ModernAsyncTask.this.b(this.f3382a);
                Binder.flushPendingCommands();
                return result;
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends FutureTask<Result> {
        c(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                ModernAsyncTask.this.m(get());
            } catch (InterruptedException e10) {
                Log.w("AsyncTask", e10);
            } catch (CancellationException unused) {
                ModernAsyncTask.this.m(null);
            } catch (ExecutionException e11) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e11.getCause());
            } catch (Throwable th2) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th2);
            }
        }
    }

    /* loaded from: classes.dex */
    static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3379a;

        static {
            int[] iArr = new int[Status.values().length];
            f3379a = iArr;
            try {
                iArr[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3379a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class e<Data> {

        /* renamed from: a  reason: collision with root package name */
        final ModernAsyncTask f3380a;

        /* renamed from: b  reason: collision with root package name */
        final Data[] f3381b;

        e(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f3380a = modernAsyncTask;
            this.f3381b = dataArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f extends Handler {
        f() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e eVar = (e) message.obj;
            int i10 = message.what;
            if (i10 == 1) {
                eVar.f3380a.d(eVar.f3381b[0]);
            } else if (i10 == 2) {
                eVar.f3380a.k(eVar.f3381b);
            }
        }
    }

    /* loaded from: classes.dex */
    private static abstract class g<Params, Result> implements Callable<Result> {

        /* renamed from: a  reason: collision with root package name */
        Params[] f3382a;

        g() {
        }
    }

    static {
        a aVar = new a();
        f3367f = aVar;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(10);
        f3368g = linkedBlockingQueue;
        f3369h = new ThreadPoolExecutor(5, 128, 1L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModernAsyncTask() {
        b bVar = new b();
        this.f3371a = bVar;
        this.f3372b = new c(bVar);
    }

    private static Handler e() {
        f fVar;
        synchronized (ModernAsyncTask.class) {
            if (f3370i == null) {
                f3370i = new f();
            }
            fVar = f3370i;
        }
        return fVar;
    }

    public final boolean a(boolean z10) {
        this.f3374d.set(true);
        return this.f3372b.cancel(z10);
    }

    protected abstract Result b(Params... paramsArr);

    public final ModernAsyncTask<Params, Progress, Result> c(Executor executor, Params... paramsArr) {
        if (this.f3373c != Status.PENDING) {
            int i10 = d.f3379a[this.f3373c.ordinal()];
            if (i10 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            } else if (i10 != 2) {
                throw new IllegalStateException("We should never reach this state");
            } else {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        } else {
            this.f3373c = Status.RUNNING;
            j();
            this.f3371a.f3382a = paramsArr;
            executor.execute(this.f3372b);
            return this;
        }
    }

    void d(Result result) {
        if (f()) {
            h(result);
        } else {
            i(result);
        }
        this.f3373c = Status.FINISHED;
    }

    public final boolean f() {
        return this.f3374d.get();
    }

    protected void g() {
    }

    protected void h(Result result) {
        g();
    }

    protected void i(Result result) {
    }

    protected void j() {
    }

    protected void k(Progress... progressArr) {
    }

    Result l(Result result) {
        e().obtainMessage(1, new e(this, result)).sendToTarget();
        return result;
    }

    void m(Result result) {
        if (!this.f3375e.get()) {
            l(result);
        }
    }
}
