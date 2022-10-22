package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.n0;
/* compiled from: LockFreeTaskQueue.kt */
/* loaded from: classes3.dex */
public final class n<E> {
    private volatile /* synthetic */ Object _next = null;
    private volatile /* synthetic */ long _state = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f30230a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30231b;

    /* renamed from: c  reason: collision with root package name */
    private final int f30232c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ AtomicReferenceArray f30233d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f30226e = new a(null);

    /* renamed from: h  reason: collision with root package name */
    public static final w f30229h = new w("REMOVE_FROZEN");

    /* renamed from: f  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30227f = AtomicReferenceFieldUpdater.newUpdater(n.class, Object.class, "_next");

    /* renamed from: g  reason: collision with root package name */
    private static final /* synthetic */ AtomicLongFieldUpdater f30228g = AtomicLongFieldUpdater.newUpdater(n.class, "_state");

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final int a(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j10, int i10) {
            return d(j10, 1073741823L) | (i10 << 0);
        }

        public final long c(long j10, int i10) {
            return d(j10, 1152921503533105152L) | (i10 << 30);
        }

        public final long d(long j10, long j11) {
            return j10 & (~j11);
        }
    }

    /* compiled from: LockFreeTaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f30234a;

        public b(int i10) {
            this.f30234a = i10;
        }
    }

    public n(int i10, boolean z10) {
        this.f30230a = i10;
        this.f30231b = z10;
        int i11 = i10 - 1;
        this.f30232c = i11;
        this.f30233d = new AtomicReferenceArray(i10);
        boolean z11 = false;
        if (i11 <= 1073741823) {
            if (!((i10 & i11) == 0 ? true : z11)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final n<E> b(long j10) {
        n<E> nVar = new n<>(this.f30230a * 2, this.f30231b);
        int i10 = (int) ((1073741823 & j10) >> 0);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.f30232c;
            if ((i10 & i12) != (i11 & i12)) {
                Object obj = this.f30233d.get(i12 & i10);
                if (obj == null) {
                    obj = new b(i10);
                }
                nVar.f30233d.set(nVar.f30232c & i10, obj);
                i10++;
            } else {
                nVar._state = f30226e.d(j10, 1152921504606846976L);
                return nVar;
            }
        }
    }

    private final n<E> c(long j10) {
        while (true) {
            n<E> nVar = (n) this._next;
            if (nVar != null) {
                return nVar;
            }
            f30227f.compareAndSet(this, null, b(j10));
        }
    }

    private final n<E> e(int i10, E e10) {
        Object obj = this.f30233d.get(this.f30232c & i10);
        if (!(obj instanceof b) || ((b) obj).f30234a != i10) {
            return null;
        }
        this.f30233d.set(i10 & this.f30232c, e10);
        return this;
    }

    private final long h() {
        long j10;
        long j11;
        do {
            j10 = this._state;
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            j11 = j10 | 1152921504606846976L;
        } while (!f30228g.compareAndSet(this, j10, j11));
        return j11;
    }

    private final n<E> k(int i10, int i11) {
        long j10;
        a aVar;
        int i12;
        do {
            j10 = this._state;
            aVar = f30226e;
            boolean z10 = false;
            i12 = (int) ((1073741823 & j10) >> 0);
            if (n0.a()) {
                if (i12 == i10) {
                    z10 = true;
                }
                if (!z10) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j10) != 0) {
                return i();
            }
        } while (!f30228g.compareAndSet(this, j10, aVar.b(j10, i11)));
        this.f30233d.set(this.f30232c & i12, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int a(E e10) {
        while (true) {
            long j10 = this._state;
            if ((3458764513820540928L & j10) != 0) {
                return f30226e.a(j10);
            }
            a aVar = f30226e;
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f30232c;
            if (((i11 + 2) & i12) == (i10 & i12)) {
                return 1;
            }
            if (!this.f30231b && this.f30233d.get(i11 & i12) != null) {
                int i13 = this.f30230a;
                if (i13 < 1024 || ((i11 - i10) & 1073741823) > (i13 >> 1)) {
                    break;
                }
            } else if (f30228g.compareAndSet(this, j10, aVar.c(j10, (i11 + 1) & 1073741823))) {
                this.f30233d.set(i11 & i12, e10);
                n<E> nVar = this;
                while ((nVar._state & 1152921504606846976L) != 0 && (nVar = nVar.i().e(i11, e10)) != null) {
                }
                return 0;
            }
        }
    }

    public final boolean d() {
        long j10;
        do {
            j10 = this._state;
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!f30228g.compareAndSet(this, j10, j10 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j10 = this._state;
        return (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j10) >> 0))) & 1073741823;
    }

    public final boolean g() {
        long j10 = this._state;
        return ((int) ((1073741823 & j10) >> 0)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    public final n<E> i() {
        return c(h());
    }

    public final Object j() {
        while (true) {
            long j10 = this._state;
            if ((1152921504606846976L & j10) != 0) {
                return f30229h;
            }
            a aVar = f30226e;
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = (int) ((1152921503533105152L & j10) >> 30);
            int i12 = this.f30232c;
            if ((i11 & i12) == (i10 & i12)) {
                return null;
            }
            Object obj = this.f30233d.get(i12 & i10);
            if (obj == null) {
                if (this.f30231b) {
                    return null;
                }
            } else if (obj instanceof b) {
                return null;
            } else {
                int i13 = (i10 + 1) & 1073741823;
                if (f30228g.compareAndSet(this, j10, aVar.b(j10, i13))) {
                    this.f30233d.set(this.f30232c & i10, null);
                    return obj;
                } else if (this.f30231b) {
                    n<E> nVar = this;
                    do {
                        nVar = nVar.k(i10, i13);
                    } while (nVar != null);
                    return obj;
                }
            }
        }
    }
}
