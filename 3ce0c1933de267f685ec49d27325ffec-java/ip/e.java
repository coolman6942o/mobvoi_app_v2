package ip;

import io.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: TaskRunner.kt */
/* loaded from: classes3.dex */
public final class e {

    /* renamed from: i  reason: collision with root package name */
    private static final Logger f29319i;

    /* renamed from: b  reason: collision with root package name */
    private boolean f29322b;

    /* renamed from: c  reason: collision with root package name */
    private long f29323c;

    /* renamed from: g  reason: collision with root package name */
    private final a f29327g;

    /* renamed from: j  reason: collision with root package name */
    public static final b f29320j = new b(null);

    /* renamed from: h  reason: collision with root package name */
    public static final e f29318h = new e(new c(gp.b.J(gp.b.f27633i + " TaskRunner", true)));

    /* renamed from: a  reason: collision with root package name */
    private int f29321a = 10000;

    /* renamed from: d  reason: collision with root package name */
    private final List<ip.d> f29324d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final List<ip.d> f29325e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f29326f = new d();

    /* compiled from: TaskRunner.kt */
    /* loaded from: classes3.dex */
    public interface a {
        long a();

        void b(e eVar, long j10);

        void c(e eVar);

        void execute(Runnable runnable);
    }

    /* compiled from: TaskRunner.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public final Logger a() {
            return e.f29319i;
        }

        public /* synthetic */ b(f fVar) {
            this();
        }
    }

    /* compiled from: TaskRunner.kt */
    /* loaded from: classes3.dex */
    public static final class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadPoolExecutor f29328a;

        public c(ThreadFactory threadFactory) {
            i.f(threadFactory, "threadFactory");
            this.f29328a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override // ip.e.a
        public long a() {
            return System.nanoTime();
        }

        @Override // ip.e.a
        public void b(e taskRunner, long j10) throws InterruptedException {
            i.f(taskRunner, "taskRunner");
            long j11 = j10 / 1000000;
            long j12 = j10 - (1000000 * j11);
            if (j11 > 0 || j10 > 0) {
                taskRunner.wait(j11, (int) j12);
            }
        }

        @Override // ip.e.a
        public void c(e taskRunner) {
            i.f(taskRunner, "taskRunner");
            taskRunner.notify();
        }

        @Override // ip.e.a
        public void execute(Runnable runnable) {
            i.f(runnable, "runnable");
            this.f29328a.execute(runnable);
        }
    }

    /* compiled from: TaskRunner.kt */
    /* loaded from: classes3.dex */
    public static final class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ip.a d10;
            while (true) {
                synchronized (e.this) {
                    d10 = e.this.d();
                }
                if (d10 != null) {
                    ip.d d11 = d10.d();
                    i.d(d11);
                    long j10 = -1;
                    boolean isLoggable = e.f29320j.a().isLoggable(Level.FINE);
                    if (isLoggable) {
                        j10 = d11.h().g().a();
                        ip.b.c(d10, d11, "starting");
                    }
                    try {
                        e.this.j(d10);
                        m mVar = m.f28349a;
                        if (isLoggable) {
                            long a10 = d11.h().g().a() - j10;
                            ip.b.c(d10, d11, "finished run in " + ip.b.b(a10));
                        }
                    } catch (Throwable th2) {
                        if (isLoggable) {
                            long a11 = d11.h().g().a() - j10;
                            ip.b.c(d10, d11, "failed a run in " + ip.b.b(a11));
                        }
                        throw th2;
                    }
                } else {
                    return;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(e.class.getName());
        i.e(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f29319i = logger;
    }

    public e(a backend) {
        i.f(backend, "backend");
        this.f29327g = backend;
    }

    private final void c(ip.a aVar, long j10) {
        if (!gp.b.f27632h || Thread.holdsLock(this)) {
            ip.d d10 = aVar.d();
            i.d(d10);
            if (d10.c() == aVar) {
                boolean d11 = d10.d();
                d10.m(false);
                d10.l(null);
                this.f29324d.remove(d10);
                if (j10 != -1 && !d11 && !d10.g()) {
                    d10.k(aVar, j10, true);
                }
                if (!d10.e().isEmpty()) {
                    this.f29325e.add(d10);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    private final void e(ip.a aVar) {
        if (!gp.b.f27632h || Thread.holdsLock(this)) {
            aVar.g(-1L);
            ip.d d10 = aVar.d();
            i.d(d10);
            d10.e().remove(aVar);
            this.f29325e.remove(d10);
            d10.l(aVar);
            this.f29324d.add(d10);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(ip.a aVar) {
        if (!gp.b.f27632h || !Thread.holdsLock(this)) {
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "currentThread");
            String name = currentThread.getName();
            currentThread.setName(aVar.b());
            try {
                long f10 = aVar.f();
                synchronized (this) {
                    c(aVar, f10);
                    m mVar = m.f28349a;
                }
                currentThread.setName(name);
            } catch (Throwable th2) {
                synchronized (this) {
                    c(aVar, -1L);
                    m mVar2 = m.f28349a;
                    currentThread.setName(name);
                    throw th2;
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread2 = Thread.currentThread();
            i.e(currentThread2, "Thread.currentThread()");
            sb2.append(currentThread2.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
    }

    public final ip.a d() {
        boolean z10;
        if (!gp.b.f27632h || Thread.holdsLock(this)) {
            while (!this.f29325e.isEmpty()) {
                long a10 = this.f29327g.a();
                long j10 = Long.MAX_VALUE;
                Iterator<ip.d> it = this.f29325e.iterator();
                ip.a aVar = null;
                while (true) {
                    if (!it.hasNext()) {
                        z10 = false;
                        break;
                    }
                    ip.a aVar2 = it.next().e().get(0);
                    long max = Math.max(0L, aVar2.c() - a10);
                    if (max > 0) {
                        j10 = Math.min(max, j10);
                    } else if (aVar != null) {
                        z10 = true;
                        break;
                    } else {
                        aVar = aVar2;
                    }
                }
                if (aVar != null) {
                    e(aVar);
                    if (z10 || (!this.f29322b && (!this.f29325e.isEmpty()))) {
                        this.f29327g.execute(this.f29326f);
                    }
                    return aVar;
                } else if (this.f29322b) {
                    if (j10 < this.f29323c - a10) {
                        this.f29327g.c(this);
                    }
                    return null;
                } else {
                    this.f29322b = true;
                    this.f29323c = a10 + j10;
                    try {
                        try {
                            this.f29327g.b(this, j10);
                        } catch (InterruptedException unused) {
                            f();
                        }
                    } finally {
                        this.f29322b = false;
                    }
                }
            }
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public final void f() {
        for (int size = this.f29324d.size() - 1; size >= 0; size--) {
            this.f29324d.get(size).b();
        }
        for (int size2 = this.f29325e.size() - 1; size2 >= 0; size2--) {
            ip.d dVar = this.f29325e.get(size2);
            dVar.b();
            if (dVar.e().isEmpty()) {
                this.f29325e.remove(size2);
            }
        }
    }

    public final a g() {
        return this.f29327g;
    }

    public final void h(ip.d taskQueue) {
        i.f(taskQueue, "taskQueue");
        if (!gp.b.f27632h || Thread.holdsLock(this)) {
            if (taskQueue.c() == null) {
                if (!taskQueue.e().isEmpty()) {
                    gp.b.a(this.f29325e, taskQueue);
                } else {
                    this.f29325e.remove(taskQueue);
                }
            }
            if (this.f29322b) {
                this.f29327g.c(this);
            } else {
                this.f29327g.execute(this.f29326f);
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(this);
            throw new AssertionError(sb2.toString());
        }
    }

    public final ip.d i() {
        int i10;
        synchronized (this) {
            i10 = this.f29321a;
            this.f29321a = i10 + 1;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('Q');
        sb2.append(i10);
        return new ip.d(this, sb2.toString());
    }
}
