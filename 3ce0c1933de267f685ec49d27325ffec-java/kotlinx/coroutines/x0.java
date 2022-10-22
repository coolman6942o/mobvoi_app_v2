package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.f;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.n;
import kotlinx.coroutines.internal.w;
import vo.d;
/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class x0 extends y0 {

    /* renamed from: e  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30348e = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_queue");

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30349f = AtomicReferenceFieldUpdater.newUpdater(x0.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable, Comparable<a>, u0, c0 {

        /* renamed from: a  reason: collision with root package name */
        public long f30350a;

        /* renamed from: b  reason: collision with root package name */
        private Object f30351b;

        /* renamed from: c  reason: collision with root package name */
        private int f30352c;

        @Override // kotlinx.coroutines.internal.c0
        public void a(b0<?> b0Var) {
            w wVar;
            Object obj = this.f30351b;
            wVar = a1.f30117a;
            if (obj != wVar) {
                this.f30351b = b0Var;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        @Override // kotlinx.coroutines.internal.c0
        public b0<?> c() {
            Object obj = this.f30351b;
            if (obj instanceof b0) {
                return (b0) obj;
            }
            return null;
        }

        @Override // kotlinx.coroutines.internal.c0
        public void d(int i10) {
            this.f30352c = i10;
        }

        @Override // kotlinx.coroutines.u0
        public final synchronized void dispose() {
            w wVar;
            w wVar2;
            Object obj = this.f30351b;
            wVar = a1.f30117a;
            if (obj != wVar) {
                b bVar = obj instanceof b ? (b) obj : null;
                if (bVar != null) {
                    bVar.g(this);
                }
                wVar2 = a1.f30117a;
                this.f30351b = wVar2;
            }
        }

        @Override // kotlinx.coroutines.internal.c0
        public int e() {
            return this.f30352c;
        }

        /* renamed from: f */
        public int compareTo(a aVar) {
            int i10 = ((this.f30350a - aVar.f30350a) > 0L ? 1 : ((this.f30350a - aVar.f30350a) == 0L ? 0 : -1));
            if (i10 > 0) {
                return 1;
            }
            return i10 < 0 ? -1 : 0;
        }

        public final synchronized int g(long j10, b bVar, x0 x0Var) {
            w wVar;
            Object obj = this.f30351b;
            wVar = a1.f30117a;
            if (obj == wVar) {
                return 2;
            }
            synchronized (bVar) {
                a b10 = bVar.b();
                if (x0Var.M0()) {
                    return 1;
                }
                if (b10 == null) {
                    bVar.f30353b = j10;
                } else {
                    long j11 = b10.f30350a;
                    if (j11 - j10 < 0) {
                        j10 = j11;
                    }
                    if (j10 - bVar.f30353b > 0) {
                        bVar.f30353b = j10;
                    }
                }
                long j12 = this.f30350a;
                long j13 = bVar.f30353b;
                if (j12 - j13 < 0) {
                    this.f30350a = j13;
                }
                bVar.a(this);
                return 0;
            }
        }

        public final boolean h(long j10) {
            return j10 - this.f30350a >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f30350a + ']';
        }
    }

    /* compiled from: EventLoop.common.kt */
    /* loaded from: classes3.dex */
    public static final class b extends b0<a> {

        /* renamed from: b  reason: collision with root package name */
        public long f30353b;

        public b(long j10) {
            this.f30353b = j10;
        }
    }

    private final void I0() {
        w wVar;
        w wVar2;
        if (!n0.a() || M0()) {
            while (true) {
                Object obj = this._queue;
                if (obj == null) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f30348e;
                    wVar = a1.f30118b;
                    if (atomicReferenceFieldUpdater.compareAndSet(this, null, wVar)) {
                        return;
                    }
                } else if (obj instanceof n) {
                    ((n) obj).d();
                    return;
                } else {
                    wVar2 = a1.f30118b;
                    if (obj != wVar2) {
                        n nVar = new n(8, true);
                        nVar.a((Runnable) obj);
                        if (f30348e.compareAndSet(this, obj, nVar)) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new AssertionError();
        }
    }

    private final Runnable J0() {
        w wVar;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (obj instanceof n) {
                n nVar = (n) obj;
                Object j10 = nVar.j();
                if (j10 != n.f30229h) {
                    return (Runnable) j10;
                }
                f30348e.compareAndSet(this, obj, nVar.i());
            } else {
                wVar = a1.f30118b;
                if (obj == wVar) {
                    return null;
                }
                if (f30348e.compareAndSet(this, obj, null)) {
                    return (Runnable) obj;
                }
            }
        }
    }

    private final boolean L0(Runnable runnable) {
        w wVar;
        while (true) {
            Object obj = this._queue;
            if (M0()) {
                return false;
            }
            if (obj == null) {
                if (f30348e.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof n) {
                n nVar = (n) obj;
                int a10 = nVar.a(runnable);
                if (a10 == 0) {
                    return true;
                }
                if (a10 == 1) {
                    f30348e.compareAndSet(this, obj, nVar.i());
                } else if (a10 == 2) {
                    return false;
                }
            } else {
                wVar = a1.f30118b;
                if (obj == wVar) {
                    return false;
                }
                n nVar2 = new n(8, true);
                nVar2.a((Runnable) obj);
                nVar2.a(runnable);
                if (f30348e.compareAndSet(this, obj, nVar2)) {
                    return true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean M0() {
        return this._isCompleted;
    }

    private final void O0() {
        c.a();
        long nanoTime = System.nanoTime();
        while (true) {
            b bVar = (b) this._delayed;
            a i10 = bVar == null ? null : bVar.i();
            if (i10 != null) {
                A0(nanoTime, i10);
            } else {
                return;
            }
        }
    }

    private final int R0(long j10, a aVar) {
        if (M0()) {
            return 1;
        }
        b bVar = (b) this._delayed;
        if (bVar == null) {
            f30349f.compareAndSet(this, null, new b(j10));
            Object obj = this._delayed;
            i.d(obj);
            bVar = (b) obj;
        }
        return aVar.g(j10, bVar, this);
    }

    private final void S0(boolean z10) {
        this._isCompleted = z10 ? 1 : 0;
    }

    private final boolean T0(a aVar) {
        b bVar = (b) this._delayed;
        return (bVar == null ? null : bVar.e()) == aVar;
    }

    public final void K0(Runnable runnable) {
        if (L0(runnable)) {
            G0();
        } else {
            p0.f30264g.K0(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean N0() {
        w wVar;
        if (!r0()) {
            return false;
        }
        b bVar = (b) this._delayed;
        if (bVar != null && !bVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof n) {
                return ((n) obj).g();
            }
            wVar = a1.f30118b;
            if (obj != wVar) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P0() {
        this._queue = null;
        this._delayed = null;
    }

    @Override // kotlinx.coroutines.g0
    public final void Q(f fVar, Runnable runnable) {
        K0(runnable);
    }

    public final void Q0(long j10, a aVar) {
        int R0 = R0(j10, aVar);
        if (R0 != 0) {
            if (R0 == 1) {
                A0(j10, aVar);
            } else if (R0 != 2) {
                throw new IllegalStateException("unexpected result".toString());
            }
        } else if (T0(aVar)) {
            G0();
        }
    }

    @Override // kotlinx.coroutines.w0
    protected long j0() {
        w wVar;
        if (super.j0() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof n)) {
                wVar = a1.f30118b;
                return obj == wVar ? Long.MAX_VALUE : 0L;
            } else if (!((n) obj).g()) {
                return 0L;
            }
        }
        b bVar = (b) this._delayed;
        a e10 = bVar == null ? null : bVar.e();
        if (e10 == null) {
            return Long.MAX_VALUE;
        }
        long j10 = e10.f30350a;
        c.a();
        return d.d(j10 - System.nanoTime(), 0L);
    }

    @Override // kotlinx.coroutines.w0
    protected void shutdown() {
        a2.f30119a.c();
        S0(true);
        I0();
        do {
        } while (t0() <= 0);
        O0();
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    @Override // kotlinx.coroutines.w0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long t0() {
        Runnable J0;
        a aVar;
        if (u0()) {
            return 0L;
        }
        b bVar = (b) this._delayed;
        if (bVar == null || bVar.d()) {
            J0 = J0();
            if (J0 != null) {
                return j0();
            }
            J0.run();
            return 0L;
        }
        c.a();
        long nanoTime = System.nanoTime();
        do {
            synchronized (bVar) {
                a b10 = bVar.b();
                aVar = null;
                if (b10 != null) {
                    a aVar2 = b10;
                    if (aVar2.h(nanoTime) ? L0(aVar2) : false) {
                        aVar = bVar.h(0);
                    }
                }
            }
        } while (aVar != null);
        J0 = J0();
        if (J0 != null) {
        }
    }
}
