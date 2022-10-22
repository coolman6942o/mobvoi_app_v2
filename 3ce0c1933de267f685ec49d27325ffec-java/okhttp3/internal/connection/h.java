package okhttp3.internal.connection;

import io.m;
import ip.d;
import ip.e;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okhttp3.d0;
import okhttp3.internal.connection.e;
/* compiled from: RealConnectionPool.kt */
/* loaded from: classes3.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final long f32016a;

    /* renamed from: b  reason: collision with root package name */
    private final d f32017b;

    /* renamed from: c  reason: collision with root package name */
    private final b f32018c = new b(gp.b.f27633i + " ConnectionPool");

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentLinkedQueue<f> f32019d = new ConcurrentLinkedQueue<>();

    /* renamed from: e  reason: collision with root package name */
    private final int f32020e;

    /* compiled from: RealConnectionPool.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: RealConnectionPool.kt */
    /* loaded from: classes3.dex */
    public static final class b extends ip.a {
        b(String str) {
            super(str, false, 2, null);
        }

        @Override // ip.a
        public long f() {
            return h.this.b(System.nanoTime());
        }
    }

    static {
        new a(null);
    }

    public h(e taskRunner, int i10, long j10, TimeUnit timeUnit) {
        i.f(taskRunner, "taskRunner");
        i.f(timeUnit, "timeUnit");
        this.f32020e = i10;
        this.f32016a = timeUnit.toNanos(j10);
        this.f32017b = taskRunner.i();
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j10).toString());
        }
    }

    private final int d(f fVar, long j10) {
        if (!gp.b.f27632h || Thread.holdsLock(fVar)) {
            List<Reference<e>> o10 = fVar.o();
            int i10 = 0;
            while (i10 < o10.size()) {
                Reference<e> reference = o10.get(i10);
                if (reference.get() != null) {
                    i10++;
                } else {
                    okhttp3.internal.platform.h.f32213c.g().m("A connection to " + fVar.A().a().l() + " was leaked. Did you forget to close a response body?", ((e.b) reference).a());
                    o10.remove(i10);
                    fVar.D(true);
                    if (o10.isEmpty()) {
                        fVar.C(j10 - this.f32016a);
                        return 0;
                    }
                }
            }
            return o10.size();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(fVar);
        throw new AssertionError(sb2.toString());
    }

    public final boolean a(okhttp3.a address, e call, List<d0> list, boolean z10) {
        i.f(address, "address");
        i.f(call, "call");
        Iterator<f> it = this.f32019d.iterator();
        while (it.hasNext()) {
            f connection = it.next();
            i.e(connection, "connection");
            synchronized (connection) {
                if (z10) {
                    if (!connection.w()) {
                        m mVar = m.f28349a;
                    }
                }
                if (connection.u(address, list)) {
                    call.c(connection);
                    return true;
                }
                m mVar2 = m.f28349a;
            }
        }
        return false;
    }

    public final long b(long j10) {
        Iterator<f> it = this.f32019d.iterator();
        int i10 = 0;
        f fVar = null;
        long j11 = Long.MIN_VALUE;
        int i11 = 0;
        while (it.hasNext()) {
            f connection = it.next();
            i.e(connection, "connection");
            synchronized (connection) {
                if (d(connection, j10) > 0) {
                    i11++;
                } else {
                    i10++;
                    long p10 = j10 - connection.p();
                    if (p10 > j11) {
                        m mVar = m.f28349a;
                        fVar = connection;
                        j11 = p10;
                    } else {
                        m mVar2 = m.f28349a;
                    }
                }
            }
        }
        long j12 = this.f32016a;
        if (j11 >= j12 || i10 > this.f32020e) {
            i.d(fVar);
            synchronized (fVar) {
                if (!fVar.o().isEmpty()) {
                    return 0L;
                }
                if (fVar.p() + j11 != j10) {
                    return 0L;
                }
                fVar.D(true);
                this.f32019d.remove(fVar);
                gp.b.k(fVar.E());
                if (this.f32019d.isEmpty()) {
                    this.f32017b.a();
                }
                return 0L;
            }
        } else if (i10 > 0) {
            return j12 - j11;
        } else {
            if (i11 > 0) {
                return j12;
            }
            return -1L;
        }
    }

    public final boolean c(f connection) {
        i.f(connection, "connection");
        if (gp.b.f27632h && !Thread.holdsLock(connection)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "Thread.currentThread()");
            sb2.append(currentThread.getName());
            sb2.append(" MUST hold lock on ");
            sb2.append(connection);
            throw new AssertionError(sb2.toString());
        } else if (connection.q() || this.f32020e == 0) {
            connection.D(true);
            this.f32019d.remove(connection);
            if (!this.f32019d.isEmpty()) {
                return true;
            }
            this.f32017b.a();
            return true;
        } else {
            d.j(this.f32017b, this.f32018c, 0L, 2, null);
            return false;
        }
    }

    public final void e(f connection) {
        i.f(connection, "connection");
        if (!gp.b.f27632h || Thread.holdsLock(connection)) {
            this.f32019d.add(connection);
            d.j(this.f32017b, this.f32018c, 0L, 2, null);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(connection);
        throw new AssertionError(sb2.toString());
    }
}
