package kotlinx.coroutines.channels;

import io.m;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.h;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o;
import qo.l;
/* compiled from: ArrayChannel.kt */
/* loaded from: classes3.dex */
public class d<E> extends kotlinx.coroutines.channels.a<E> {

    /* renamed from: e  reason: collision with root package name */
    private final int f30145e;

    /* renamed from: f  reason: collision with root package name */
    private final BufferOverflow f30146f;

    /* renamed from: g  reason: collision with root package name */
    private final ReentrantLock f30147g;

    /* renamed from: h  reason: collision with root package name */
    private Object[] f30148h;

    /* renamed from: i  reason: collision with root package name */
    private int f30149i;
    private volatile /* synthetic */ int size;

    /* compiled from: ArrayChannel.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f30150a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            f30150a = iArr;
        }
    }

    public d(int i10, BufferOverflow bufferOverflow, l<? super E, m> lVar) {
        super(lVar);
        this.f30145e = i10;
        this.f30146f = bufferOverflow;
        if (i10 < 1 ? false : true) {
            this.f30147g = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i10, 8)];
            h.j(objArr, b.f30134a, 0, 0, 6, null);
            m mVar = m.f28349a;
            this.f30148h = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i10 + " was specified").toString());
    }

    private final void J(int i10, E e10) {
        if (i10 < this.f30145e) {
            K(i10);
            Object[] objArr = this.f30148h;
            objArr[(this.f30149i + i10) % objArr.length] = e10;
            return;
        }
        if (n0.a()) {
            if (!(this.f30146f == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.f30148h;
        int i11 = this.f30149i;
        objArr2[i11 % objArr2.length] = null;
        objArr2[(i10 + i11) % objArr2.length] = e10;
        this.f30149i = (i11 + 1) % objArr2.length;
    }

    private final void K(int i10) {
        Object[] objArr = this.f30148h;
        if (i10 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f30145e);
            Object[] objArr2 = new Object[min];
            if (i10 > 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    Object[] objArr3 = this.f30148h;
                    objArr2[i11] = objArr3[(this.f30149i + i11) % objArr3.length];
                    if (i12 >= i10) {
                        break;
                    }
                    i11 = i12;
                }
            }
            h.i(objArr2, b.f30134a, i10, min);
            this.f30148h = objArr2;
            this.f30149i = 0;
        }
    }

    private final w L(int i10) {
        if (i10 < this.f30145e) {
            this.size = i10 + 1;
            return null;
        }
        int i11 = a.f30150a[this.f30146f.ordinal()];
        if (i11 == 1) {
            return b.f30136c;
        }
        if (i11 == 2) {
            return b.f30135b;
        }
        if (i11 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public boolean B(k<? super E> kVar) {
        ReentrantLock reentrantLock = this.f30147g;
        reentrantLock.lock();
        try {
            return super.B(kVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean C() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.a
    protected final boolean D() {
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.a
    protected Object G() {
        ReentrantLock reentrantLock = this.f30147g;
        reentrantLock.lock();
        try {
            int i10 = this.size;
            if (i10 == 0) {
                Object j10 = j();
                if (j10 == null) {
                    j10 = b.f30137d;
                }
                return j10;
            }
            Object[] objArr = this.f30148h;
            int i11 = this.f30149i;
            Object obj = objArr[i11];
            o oVar = null;
            objArr[i11] = null;
            this.size = i10 - 1;
            Object obj2 = b.f30137d;
            boolean z10 = false;
            if (i10 == this.f30145e) {
                o oVar2 = null;
                while (true) {
                    o x10 = x();
                    if (x10 == null) {
                        oVar = oVar2;
                        break;
                    }
                    w y10 = x10.y(null);
                    if (y10 != null) {
                        if (n0.a()) {
                            if (y10 == o.f30262a) {
                                z10 = true;
                            }
                            if (!z10) {
                                throw new AssertionError();
                            }
                        }
                        obj2 = x10.x();
                        z10 = true;
                        oVar = x10;
                    } else {
                        x10.z();
                        oVar2 = x10;
                    }
                }
            }
            if (obj2 != b.f30137d && !(obj2 instanceof h)) {
                this.size = i10;
                Object[] objArr2 = this.f30148h;
                objArr2[(this.f30149i + i10) % objArr2.length] = obj2;
            }
            this.f30149i = (this.f30149i + 1) % this.f30148h.length;
            m mVar = m.f28349a;
            if (z10) {
                i.d(oVar);
                oVar.w();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    public Object h(o oVar) {
        ReentrantLock reentrantLock = this.f30147g;
        reentrantLock.lock();
        try {
            return super.h(oVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.c
    protected String i() {
        return "(buffer:capacity=" + this.f30145e + ",size=" + this.size + ')';
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean p() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean q() {
        return this.size == this.f30145e && this.f30146f == BufferOverflow.SUSPEND;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    public Object s(E e10) {
        m<E> w10;
        w f10;
        ReentrantLock reentrantLock = this.f30147g;
        reentrantLock.lock();
        try {
            int i10 = this.size;
            h<?> j10 = j();
            if (j10 != null) {
                return j10;
            }
            w L = L(i10);
            if (L != null) {
                return L;
            }
            if (i10 == 0) {
                do {
                    w10 = w();
                    if (w10 != null) {
                        if (w10 instanceof h) {
                            this.size = i10;
                            return w10;
                        }
                        f10 = w10.f(e10, null);
                    }
                } while (f10 == null);
                if (n0.a()) {
                    if (!(f10 == o.f30262a)) {
                        throw new AssertionError();
                    }
                }
                this.size = i10;
                m mVar = m.f28349a;
                reentrantLock.unlock();
                w10.e(e10);
                return w10.a();
            }
            J(i10, e10);
            return b.f30135b;
        } finally {
            reentrantLock.unlock();
        }
    }
}
