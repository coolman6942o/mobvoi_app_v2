package kotlinx.coroutines;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.i;
import kotlin.text.s;
import vo.f;
/* compiled from: CommonPool.kt */
/* loaded from: classes3.dex */
public final class x extends b1 {

    /* renamed from: b  reason: collision with root package name */
    public static final x f30345b = new x();

    /* renamed from: c  reason: collision with root package name */
    private static final int f30346c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f30347d;
    private static volatile Executor pool;

    static {
        String str;
        int i10;
        Integer i11;
        try {
            str = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            str = null;
        }
        if (str == null) {
            i10 = -1;
        } else {
            i11 = s.i(str);
            if (i11 == null || i11.intValue() < 1) {
                throw new IllegalStateException(i.n("Expected positive number in kotlinx.coroutines.default.parallelism, but has ", str).toString());
            }
            i10 = i11.intValue();
        }
        f30346c = i10;
    }

    private x() {
    }

    private final ExecutorService h0() {
        final AtomicInteger atomicInteger = new AtomicInteger();
        return Executors.newFixedThreadPool(m0(), new ThreadFactory() { // from class: kotlinx.coroutines.w
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread i02;
                i02 = x.i0(atomicInteger, runnable);
                return i02;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread i0(AtomicInteger atomicInteger, Runnable runnable) {
        Thread thread = new Thread(runnable, i.n("CommonPool-worker-", Integer.valueOf(atomicInteger.incrementAndGet())));
        thread.setDaemon(true);
        return thread;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ExecutorService j0() {
        Class<?> cls;
        ExecutorService executorService;
        Object invoke;
        if (System.getSecurityManager() != null) {
            return h0();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return h0();
        }
        if (!f30347d && f30346c < 0) {
            try {
                invoke = cls.getMethod("commonPool", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused2) {
            }
            if (invoke instanceof ExecutorService) {
                executorService = (ExecutorService) invoke;
                if (executorService != null) {
                    if (!f30345b.o0(cls, executorService)) {
                        executorService = null;
                    }
                    if (executorService != null) {
                        return executorService;
                    }
                }
            }
            executorService = null;
            if (executorService != null) {
            }
        }
        try {
            Object newInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f30345b.m0()));
            if (newInstance instanceof ExecutorService) {
                executorService2 = (ExecutorService) newInstance;
            }
        } catch (Throwable unused3) {
        }
        return executorService2 == null ? h0() : executorService2;
    }

    private final synchronized Executor k0() {
        Executor executor;
        executor = pool;
        if (executor == null) {
            executor = j0();
            pool = executor;
        }
        return executor;
    }

    private final int m0() {
        int c10;
        Integer valueOf = Integer.valueOf(f30346c);
        if (!(valueOf.intValue() > 0)) {
            valueOf = null;
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        c10 = f.c(Runtime.getRuntime().availableProcessors() - 1, 1);
        return c10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0() {
    }

    @Override // kotlinx.coroutines.g0
    public void Q(kotlin.coroutines.f fVar, Runnable runnable) {
        try {
            Executor executor = pool;
            if (executor == null) {
                executor = k0();
            }
            c.a();
            executor.execute(runnable);
        } catch (RejectedExecutionException unused) {
            c.a();
            p0.f30264g.K0(runnable);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    public final boolean o0(Class<?> cls, ExecutorService executorService) {
        executorService.submit(v.f30339a);
        Integer num = null;
        try {
            Object invoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (invoke instanceof Integer) {
                num = (Integer) invoke;
            }
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }

    @Override // kotlinx.coroutines.g0
    public String toString() {
        return "CommonPool";
    }
}
