package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CardViewApi21Impl.java */
/* loaded from: classes.dex */
public class b implements e {
    private f p(d dVar) {
        return (f) dVar.f();
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        dVar.c(new f(colorStateList, f10));
        View g10 = dVar.g();
        g10.setClipToOutline(true);
        g10.setElevation(f11);
        o(dVar, f12);
    }

    @Override // androidx.cardview.widget.e
    public void b(d dVar, float f10) {
        p(dVar).h(f10);
    }

    @Override // androidx.cardview.widget.e
    public float c(d dVar) {
        return dVar.g().getElevation();
    }

    @Override // androidx.cardview.widget.e
    public float d(d dVar) {
        return p(dVar).d();
    }

    @Override // androidx.cardview.widget.e
    public void e(d dVar) {
        o(dVar, g(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void f(d dVar, float f10) {
        dVar.g().setElevation(f10);
    }

    @Override // androidx.cardview.widget.e
    public float g(d dVar) {
        return p(dVar).c();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList h(d dVar) {
        return p(dVar).b();
    }

    @Override // androidx.cardview.widget.e
    public void i(d dVar) {
        if (!dVar.e()) {
            dVar.a(0, 0, 0, 0);
            return;
        }
        float g10 = g(dVar);
        float d10 = d(dVar);
        int ceil = (int) Math.ceil(g.c(g10, d10, dVar.d()));
        int ceil2 = (int) Math.ceil(g.d(g10, d10, dVar.d()));
        dVar.a(ceil, ceil2, ceil, ceil2);
    }

    @Override // androidx.cardview.widget.e
    public void j() {
    }

    @Override // androidx.cardview.widget.e
    public float k(d dVar) {
        return d(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public float l(d dVar) {
        return d(dVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar) {
        o(dVar, g(dVar));
    }

    @Override // androidx.cardview.widget.e
    public void n(d dVar, ColorStateList colorStateList) {
        p(dVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public void o(d dVar, float f10) {
        p(dVar).g(f10, dVar.e(), dVar.d());
        i(dVar);
    }
}
