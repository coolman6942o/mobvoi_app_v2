package nf;

import com.mobvoi.android.common.utils.k;
/* compiled from: MVPViewModel.java */
/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    private m f31236a;

    public void a() {
        k.c("mvp.vm.base", "%s: dispose", getClass().getSimpleName());
        if (this.f31236a != null) {
            k.s("mvp.vm.base", "%s: Disposing without calling unsubscribeFromDataStore first", getClass().getSimpleName());
            d();
        }
    }

    public final void b() {
        k.c("mvp.vm.base", "%s: subscribeToDataStore", getClass().getSimpleName());
        d();
        m mVar = new m();
        this.f31236a = mVar;
        c(mVar);
    }

    protected abstract void c(m mVar);

    public void d() {
        k.c("mvp.vm.base", "%s: unsubscribeFromDataStore", getClass().getSimpleName());
        m mVar = this.f31236a;
        if (mVar != null) {
            mVar.clear();
            this.f31236a = null;
        }
    }
}
