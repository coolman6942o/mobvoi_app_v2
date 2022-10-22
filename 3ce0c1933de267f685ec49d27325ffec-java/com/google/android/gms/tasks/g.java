package com.google.android.gms.tasks;
/* loaded from: classes.dex */
final class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ b f10157a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ f f10158b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, b bVar) {
        this.f10158b = fVar;
        this.f10157a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar;
        s sVar2;
        s sVar3;
        a aVar;
        s sVar4;
        s sVar5;
        if (this.f10157a.m()) {
            sVar5 = this.f10158b.f10156c;
            sVar5.t();
            return;
        }
        try {
            aVar = this.f10158b.f10155b;
            Object a10 = aVar.a(this.f10157a);
            sVar4 = this.f10158b.f10156c;
            sVar4.q(a10);
        } catch (RuntimeExecutionException e10) {
            if (e10.getCause() instanceof Exception) {
                sVar2 = this.f10158b.f10156c;
                sVar2.p((Exception) e10.getCause());
                return;
            }
            sVar = this.f10158b.f10156c;
            sVar.p(e10);
        } catch (Exception e11) {
            sVar3 = this.f10158b.f10156c;
            sVar3.p(e11);
        }
    }
}
