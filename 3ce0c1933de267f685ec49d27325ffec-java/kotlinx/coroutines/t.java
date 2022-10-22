package kotlinx.coroutines;

import io.m;
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class t extends k1 implements s {

    /* renamed from: e  reason: collision with root package name */
    public final u f30335e;

    public t(u uVar) {
        this.f30335e = uVar;
    }

    @Override // kotlinx.coroutines.s
    public boolean b(Throwable th2) {
        return x().z(th2);
    }

    @Override // kotlinx.coroutines.s
    public j1 getParent() {
        return x();
    }

    @Override // qo.l
    public /* bridge */ /* synthetic */ m invoke(Throwable th2) {
        w(th2);
        return m.f28349a;
    }

    @Override // kotlinx.coroutines.c0
    public void w(Throwable th2) {
        this.f30335e.q(x());
    }
}
