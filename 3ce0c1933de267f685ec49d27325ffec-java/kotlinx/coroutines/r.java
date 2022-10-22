package kotlinx.coroutines;

import io.m;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class r extends k1 {

    /* renamed from: e  reason: collision with root package name */
    public final n<?> f30283e;

    public r(n<?> nVar) {
        this.f30283e = nVar;
    }

    @Override // qo.l
    public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
        w(th2);
        return m.f28349a;
    }

    @Override // kotlinx.coroutines.c0
    public void w(Throwable th2) {
        n<?> nVar = this.f30283e;
        nVar.D(nVar.u(x()));
    }
}
