package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.d0;
import androidx.core.view.i0;
import androidx.core.view.k0;
import d.e;
import d.f;
import d.h;
/* compiled from: ToolbarWidgetWrapper.java */
/* loaded from: classes.dex */
public class z0 implements f0 {

    /* renamed from: a  reason: collision with root package name */
    Toolbar f1373a;

    /* renamed from: b  reason: collision with root package name */
    private int f1374b;

    /* renamed from: c  reason: collision with root package name */
    private View f1375c;

    /* renamed from: d  reason: collision with root package name */
    private View f1376d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1377e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f1378f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f1379g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1380h;

    /* renamed from: i  reason: collision with root package name */
    CharSequence f1381i;

    /* renamed from: j  reason: collision with root package name */
    private CharSequence f1382j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f1383k;

    /* renamed from: l  reason: collision with root package name */
    Window.Callback f1384l;

    /* renamed from: m  reason: collision with root package name */
    boolean f1385m;

    /* renamed from: n  reason: collision with root package name */
    private ActionMenuPresenter f1386n;

    /* renamed from: o  reason: collision with root package name */
    private int f1387o;

    /* renamed from: p  reason: collision with root package name */
    private int f1388p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f1389q;

    /* compiled from: ToolbarWidgetWrapper.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final j.a f1390a;

        a() {
            this.f1390a = new j.a(z0.this.f1373a.getContext(), 0, 16908332, 0, 0, z0.this.f1381i);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            z0 z0Var = z0.this;
            Window.Callback callback = z0Var.f1384l;
            if (callback != null && z0Var.f1385m) {
                callback.onMenuItemSelected(0, this.f1390a);
            }
        }
    }

    /* compiled from: ToolbarWidgetWrapper.java */
    /* loaded from: classes.dex */
    class b extends k0 {

        /* renamed from: a  reason: collision with root package name */
        private boolean f1392a = false;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1393b;

        b(int i10) {
            this.f1393b = i10;
        }

        @Override // androidx.core.view.k0, androidx.core.view.j0
        public void a(View view) {
            this.f1392a = true;
        }

        @Override // androidx.core.view.j0
        public void b(View view) {
            if (!this.f1392a) {
                z0.this.f1373a.setVisibility(this.f1393b);
            }
        }

        @Override // androidx.core.view.k0, androidx.core.view.j0
        public void c(View view) {
            z0.this.f1373a.setVisibility(0);
        }
    }

    public z0(Toolbar toolbar, boolean z10) {
        this(toolbar, z10, h.f24835a, e.f24776n);
    }

    private int A() {
        if (this.f1373a.getNavigationIcon() == null) {
            return 11;
        }
        this.f1389q = this.f1373a.getNavigationIcon();
        return 15;
    }

    private void G(CharSequence charSequence) {
        this.f1381i = charSequence;
        if ((this.f1374b & 8) != 0) {
            this.f1373a.setTitle(charSequence);
            if (this.f1380h) {
                d0.w0(this.f1373a.getRootView(), charSequence);
            }
        }
    }

    private void H() {
        if ((this.f1374b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f1383k)) {
            this.f1373a.setNavigationContentDescription(this.f1388p);
        } else {
            this.f1373a.setNavigationContentDescription(this.f1383k);
        }
    }

    private void I() {
        if ((this.f1374b & 4) != 0) {
            Toolbar toolbar = this.f1373a;
            Drawable drawable = this.f1379g;
            if (drawable == null) {
                drawable = this.f1389q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.f1373a.setNavigationIcon((Drawable) null);
    }

    private void J() {
        Drawable drawable;
        int i10 = this.f1374b;
        if ((i10 & 2) == 0) {
            drawable = null;
        } else if ((i10 & 1) != 0) {
            drawable = this.f1378f;
            if (drawable == null) {
                drawable = this.f1377e;
            }
        } else {
            drawable = this.f1377e;
        }
        this.f1373a.setLogo(drawable);
    }

    public void B(View view) {
        View view2 = this.f1376d;
        if (!(view2 == null || (this.f1374b & 16) == 0)) {
            this.f1373a.removeView(view2);
        }
        this.f1376d = view;
        if (view != null && (this.f1374b & 16) != 0) {
            this.f1373a.addView(view);
        }
    }

    public void C(int i10) {
        if (i10 != this.f1388p) {
            this.f1388p = i10;
            if (TextUtils.isEmpty(this.f1373a.getNavigationContentDescription())) {
                v(this.f1388p);
            }
        }
    }

    public void D(Drawable drawable) {
        this.f1378f = drawable;
        J();
    }

    public void E(CharSequence charSequence) {
        this.f1383k = charSequence;
        H();
    }

    public void F(CharSequence charSequence) {
        this.f1382j = charSequence;
        if ((this.f1374b & 8) != 0) {
            this.f1373a.setSubtitle(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void a(Menu menu, j.a aVar) {
        if (this.f1386n == null) {
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(this.f1373a.getContext());
            this.f1386n = actionMenuPresenter;
            actionMenuPresenter.r(f.f24795g);
        }
        this.f1386n.h(aVar);
        this.f1373a.K((androidx.appcompat.view.menu.e) menu, this.f1386n);
    }

    @Override // androidx.appcompat.widget.f0
    public boolean b() {
        return this.f1373a.B();
    }

    @Override // androidx.appcompat.widget.f0
    public void c() {
        this.f1385m = true;
    }

    @Override // androidx.appcompat.widget.f0
    public void collapseActionView() {
        this.f1373a.e();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean d() {
        return this.f1373a.d();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean e() {
        return this.f1373a.A();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean f() {
        return this.f1373a.w();
    }

    @Override // androidx.appcompat.widget.f0
    public boolean g() {
        return this.f1373a.Q();
    }

    @Override // androidx.appcompat.widget.f0
    public Context getContext() {
        return this.f1373a.getContext();
    }

    @Override // androidx.appcompat.widget.f0
    public CharSequence getTitle() {
        return this.f1373a.getTitle();
    }

    @Override // androidx.appcompat.widget.f0
    public void h() {
        this.f1373a.f();
    }

    @Override // androidx.appcompat.widget.f0
    public void i(q0 q0Var) {
        View view = this.f1375c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.f1373a;
            if (parent == toolbar) {
                toolbar.removeView(this.f1375c);
            }
        }
        this.f1375c = q0Var;
        if (q0Var != null && this.f1387o == 2) {
            this.f1373a.addView(q0Var, 0);
            Toolbar.e eVar = (Toolbar.e) this.f1375c.getLayoutParams();
            ((ViewGroup.MarginLayoutParams) eVar).width = -2;
            ((ViewGroup.MarginLayoutParams) eVar).height = -2;
            eVar.f512a = 8388691;
            q0Var.setAllowCollapse(true);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public boolean j() {
        return this.f1373a.v();
    }

    @Override // androidx.appcompat.widget.f0
    public void k(int i10) {
        View view;
        int i11 = this.f1374b ^ i10;
        this.f1374b = i10;
        if (i11 != 0) {
            if ((i11 & 4) != 0) {
                if ((i10 & 4) != 0) {
                    H();
                }
                I();
            }
            if ((i11 & 3) != 0) {
                J();
            }
            if ((i11 & 8) != 0) {
                if ((i10 & 8) != 0) {
                    this.f1373a.setTitle(this.f1381i);
                    this.f1373a.setSubtitle(this.f1382j);
                } else {
                    this.f1373a.setTitle((CharSequence) null);
                    this.f1373a.setSubtitle((CharSequence) null);
                }
            }
            if ((i11 & 16) != 0 && (view = this.f1376d) != null) {
                if ((i10 & 16) != 0) {
                    this.f1373a.addView(view);
                } else {
                    this.f1373a.removeView(view);
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.f0
    public Menu l() {
        return this.f1373a.getMenu();
    }

    @Override // androidx.appcompat.widget.f0
    public void m(int i10) {
        D(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.f0
    public int n() {
        return this.f1387o;
    }

    @Override // androidx.appcompat.widget.f0
    public i0 o(int i10, long j10) {
        return d0.e(this.f1373a).a(i10 == 0 ? 1.0f : 0.0f).d(j10).f(new b(i10));
    }

    @Override // androidx.appcompat.widget.f0
    public void p(int i10) {
        y(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.f0
    public void q(j.a aVar, e.a aVar2) {
        this.f1373a.L(aVar, aVar2);
    }

    @Override // androidx.appcompat.widget.f0
    public void r(int i10) {
        this.f1373a.setVisibility(i10);
    }

    @Override // androidx.appcompat.widget.f0
    public ViewGroup s() {
        return this.f1373a;
    }

    @Override // androidx.appcompat.widget.f0
    public void setIcon(int i10) {
        setIcon(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    @Override // androidx.appcompat.widget.f0
    public void setTitle(CharSequence charSequence) {
        this.f1380h = true;
        G(charSequence);
    }

    @Override // androidx.appcompat.widget.f0
    public void setWindowCallback(Window.Callback callback) {
        this.f1384l = callback;
    }

    @Override // androidx.appcompat.widget.f0
    public void setWindowTitle(CharSequence charSequence) {
        if (!this.f1380h) {
            G(charSequence);
        }
    }

    @Override // androidx.appcompat.widget.f0
    public void t(boolean z10) {
    }

    @Override // androidx.appcompat.widget.f0
    public int u() {
        return this.f1374b;
    }

    @Override // androidx.appcompat.widget.f0
    public void v(int i10) {
        E(i10 == 0 ? null : getContext().getString(i10));
    }

    @Override // androidx.appcompat.widget.f0
    public void w() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.f0
    public void x() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.f0
    public void y(Drawable drawable) {
        this.f1379g = drawable;
        I();
    }

    @Override // androidx.appcompat.widget.f0
    public void z(boolean z10) {
        this.f1373a.setCollapsible(z10);
    }

    public z0(Toolbar toolbar, boolean z10, int i10, int i11) {
        Drawable drawable;
        this.f1387o = 0;
        this.f1388p = 0;
        this.f1373a = toolbar;
        this.f1381i = toolbar.getTitle();
        this.f1382j = toolbar.getSubtitle();
        this.f1380h = this.f1381i != null;
        this.f1379g = toolbar.getNavigationIcon();
        x0 v10 = x0.v(toolbar.getContext(), null, d.j.f24854a, d.a.f24715c, 0);
        this.f1389q = v10.g(d.j.f24909l);
        if (z10) {
            CharSequence p10 = v10.p(d.j.f24939r);
            if (!TextUtils.isEmpty(p10)) {
                setTitle(p10);
            }
            CharSequence p11 = v10.p(d.j.f24929p);
            if (!TextUtils.isEmpty(p11)) {
                F(p11);
            }
            Drawable g10 = v10.g(d.j.f24919n);
            if (g10 != null) {
                D(g10);
            }
            Drawable g11 = v10.g(d.j.f24914m);
            if (g11 != null) {
                setIcon(g11);
            }
            if (this.f1379g == null && (drawable = this.f1389q) != null) {
                y(drawable);
            }
            k(v10.k(d.j.f24889h, 0));
            int n10 = v10.n(d.j.f24884g, 0);
            if (n10 != 0) {
                B(LayoutInflater.from(this.f1373a.getContext()).inflate(n10, (ViewGroup) this.f1373a, false));
                k(this.f1374b | 16);
            }
            int m10 = v10.m(d.j.f24899j, 0);
            if (m10 > 0) {
                ViewGroup.LayoutParams layoutParams = this.f1373a.getLayoutParams();
                layoutParams.height = m10;
                this.f1373a.setLayoutParams(layoutParams);
            }
            int e10 = v10.e(d.j.f24879f, -1);
            int e11 = v10.e(d.j.f24874e, -1);
            if (e10 >= 0 || e11 >= 0) {
                this.f1373a.J(Math.max(e10, 0), Math.max(e11, 0));
            }
            int n11 = v10.n(d.j.f24944s, 0);
            if (n11 != 0) {
                Toolbar toolbar2 = this.f1373a;
                toolbar2.N(toolbar2.getContext(), n11);
            }
            int n12 = v10.n(d.j.f24934q, 0);
            if (n12 != 0) {
                Toolbar toolbar3 = this.f1373a;
                toolbar3.M(toolbar3.getContext(), n12);
            }
            int n13 = v10.n(d.j.f24924o, 0);
            if (n13 != 0) {
                this.f1373a.setPopupTheme(n13);
            }
        } else {
            this.f1374b = A();
        }
        v10.w();
        C(i10);
        this.f1383k = this.f1373a.getNavigationContentDescription();
        this.f1373a.setNavigationOnClickListener(new a());
    }

    @Override // androidx.appcompat.widget.f0
    public void setIcon(Drawable drawable) {
        this.f1377e = drawable;
        J();
    }
}
