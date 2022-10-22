package androidx.fragment.app;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import j0.h;
/* compiled from: FragmentController.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final k<?> f3142a;

    private i(k<?> kVar) {
        this.f3142a = kVar;
    }

    public static i b(k<?> kVar) {
        return new i((k) h.h(kVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        k<?> kVar = this.f3142a;
        kVar.f3147d.j(kVar, kVar, fragment);
    }

    public void c() {
        this.f3142a.f3147d.v();
    }

    public void d(Configuration configuration) {
        this.f3142a.f3147d.x(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f3142a.f3147d.y(menuItem);
    }

    public void f() {
        this.f3142a.f3147d.z();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f3142a.f3147d.A(menu, menuInflater);
    }

    public void h() {
        this.f3142a.f3147d.B();
    }

    public void i() {
        this.f3142a.f3147d.D();
    }

    public void j(boolean z10) {
        this.f3142a.f3147d.E(z10);
    }

    public boolean k(MenuItem menuItem) {
        return this.f3142a.f3147d.H(menuItem);
    }

    public void l(Menu menu) {
        this.f3142a.f3147d.I(menu);
    }

    public void m() {
        this.f3142a.f3147d.K();
    }

    public void n(boolean z10) {
        this.f3142a.f3147d.L(z10);
    }

    public boolean o(Menu menu) {
        return this.f3142a.f3147d.M(menu);
    }

    public void p() {
        this.f3142a.f3147d.O();
    }

    public void q() {
        this.f3142a.f3147d.P();
    }

    public void r() {
        this.f3142a.f3147d.R();
    }

    public boolean s() {
        return this.f3142a.f3147d.Y(true);
    }

    public FragmentManager t() {
        return this.f3142a.f3147d;
    }

    public void u() {
        this.f3142a.f3147d.T0();
    }

    public View v(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f3142a.f3147d.v0().onCreateView(view, str, context, attributeSet);
    }
}
