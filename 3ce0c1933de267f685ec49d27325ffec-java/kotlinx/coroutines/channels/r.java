package kotlinx.coroutines.channels;

import io.m;
import qo.l;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public final class r<E> extends q<E> {

    /* renamed from: f  reason: collision with root package name */
    public final l<E, m> f30163f;

    /* JADX WARN: Multi-variable type inference failed */
    public r(E e10, kotlinx.coroutines.m<? super m> mVar, l<? super E, m> lVar) {
        super(e10, mVar);
        this.f30163f = lVar;
    }

    @Override // kotlinx.coroutines.internal.l
    public boolean s() {
        if (!super.s()) {
            return false;
        }
        z();
        return true;
    }

    @Override // kotlinx.coroutines.channels.o
    public void z() {
        kotlinx.coroutines.internal.r.b(this.f30163f, x(), this.f30162e.getContext());
    }
}
