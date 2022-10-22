package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.l;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public final class h<E> extends o implements m<E> {

    /* renamed from: d  reason: collision with root package name */
    public final Throwable f30158d;

    public h(Throwable th2) {
        this.f30158d = th2;
    }

    /* renamed from: A */
    public h<E> a() {
        return this;
    }

    /* renamed from: B */
    public h<E> x() {
        return this;
    }

    public final Throwable C() {
        Throwable th2 = this.f30158d;
        return th2 == null ? new ClosedReceiveChannelException("Channel was closed") : th2;
    }

    public final Throwable D() {
        Throwable th2 = this.f30158d;
        return th2 == null ? new ClosedSendChannelException("Channel was closed") : th2;
    }

    @Override // kotlinx.coroutines.channels.m
    public void e(E e10) {
    }

    @Override // kotlinx.coroutines.channels.m
    public w f(E e10, l.b bVar) {
        return o.f30262a;
    }

    @Override // kotlinx.coroutines.internal.l
    public String toString() {
        return "Closed@" + o0.b(this) + '[' + this.f30158d + ']';
    }

    @Override // kotlinx.coroutines.channels.o
    public void w() {
    }

    @Override // kotlinx.coroutines.channels.o
    public w y(l.b bVar) {
        return o.f30262a;
    }
}
