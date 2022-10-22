package kotlinx.coroutines;

import io.m;
import qo.l;
/* compiled from: CancellableContinuationImpl.kt */
/* loaded from: classes3.dex */
final class g1 extends k {

    /* renamed from: a  reason: collision with root package name */
    private final l<Throwable, m> f30187a;

    /* JADX WARN: Multi-variable type inference failed */
    public g1(l<? super Throwable, m> lVar) {
        this.f30187a = lVar;
    }

    @Override // kotlinx.coroutines.l
    public void a(Throwable th2) {
        this.f30187a.invoke(th2);
    }

    @Override // qo.l
    public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
        a(th2);
        return m.f28349a;
    }

    public String toString() {
        return "InvokeOnCancel[" + o0.a(this.f30187a) + '@' + o0.b(this) + ']';
    }
}
