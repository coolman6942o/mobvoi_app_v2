package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.l;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.m;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public class q<E> extends o {

    /* renamed from: d  reason: collision with root package name */
    private final E f30161d;

    /* renamed from: e  reason: collision with root package name */
    public final m<io.m> f30162e;

    /* JADX WARN: Multi-variable type inference failed */
    public q(E e10, m<? super io.m> mVar) {
        this.f30161d = e10;
        this.f30162e = mVar;
    }

    @Override // kotlinx.coroutines.internal.l
    public String toString() {
        return o0.a(this) + '@' + o0.b(this) + '(' + x() + ')';
    }

    @Override // kotlinx.coroutines.channels.o
    public void w() {
        this.f30162e.k(o.f30262a);
    }

    @Override // kotlinx.coroutines.channels.o
    public E x() {
        return this.f30161d;
    }

    @Override // kotlinx.coroutines.channels.o
    public w y(l.b bVar) {
        Object a10 = this.f30162e.a(io.m.f28349a, null);
        if (a10 == null) {
            return null;
        }
        if (n0.a()) {
            if (!(a10 == o.f30262a)) {
                throw new AssertionError();
            }
        }
        return o.f30262a;
    }
}
