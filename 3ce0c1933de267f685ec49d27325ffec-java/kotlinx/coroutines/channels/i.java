package kotlinx.coroutines.channels;

import io.m;
import java.util.concurrent.locks.ReentrantLock;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o;
import qo.l;
/* compiled from: ConflatedChannel.kt */
/* loaded from: classes3.dex */
public class i<E> extends a<E> {

    /* renamed from: e  reason: collision with root package name */
    private final ReentrantLock f30159e = new ReentrantLock();

    /* renamed from: f  reason: collision with root package name */
    private Object f30160f = b.f30134a;

    public i(l<? super E, m> lVar) {
        super(lVar);
    }

    private final UndeliveredElementException J(Object obj) {
        l<E, m> lVar;
        Object obj2 = this.f30160f;
        UndeliveredElementException undeliveredElementException = null;
        if (!(obj2 == b.f30134a || (lVar = this.f30141b) == null)) {
            undeliveredElementException = r.d(lVar, obj2, null, 2, null);
        }
        this.f30160f = obj;
        return undeliveredElementException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.a
    public boolean B(k<? super E> kVar) {
        ReentrantLock reentrantLock = this.f30159e;
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
        return this.f30160f == b.f30134a;
    }

    @Override // kotlinx.coroutines.channels.a
    protected Object G() {
        ReentrantLock reentrantLock = this.f30159e;
        reentrantLock.lock();
        try {
            Object obj = this.f30160f;
            w wVar = b.f30134a;
            if (obj == wVar) {
                Object j10 = j();
                if (j10 == null) {
                    j10 = b.f30137d;
                }
                return j10;
            }
            this.f30160f = wVar;
            m mVar = m.f28349a;
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.c
    protected String i() {
        return "(value=" + this.f30160f + ')';
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean p() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.c
    protected final boolean q() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    public Object s(E e10) {
        m<E> w10;
        w f10;
        ReentrantLock reentrantLock = this.f30159e;
        reentrantLock.lock();
        try {
            h<?> j10 = j();
            if (j10 != null) {
                return j10;
            }
            if (this.f30160f == b.f30134a) {
                do {
                    w10 = w();
                    if (w10 != null) {
                        if (w10 instanceof h) {
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
                m mVar = m.f28349a;
                reentrantLock.unlock();
                w10.e(e10);
                return w10.a();
            }
            UndeliveredElementException J = J(e10);
            if (J == null) {
                return b.f30135b;
            }
            throw J;
        } finally {
            reentrantLock.unlock();
        }
    }
}
