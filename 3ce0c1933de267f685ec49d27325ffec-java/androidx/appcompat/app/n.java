package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.q0;
import androidx.core.view.d0;
import androidx.core.view.i0;
import androidx.core.view.j0;
import androidx.core.view.k0;
import androidx.core.view.l0;
import com.mobvoi.wear.lpa.LpaConstants;
import d.f;
import d.j;
import i.b;
import i.g;
import i.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
/* compiled from: WindowDecorActionBar.java */
/* loaded from: classes.dex */
public class n extends androidx.appcompat.app.a implements ActionBarOverlayLayout.d {
    private static final Interpolator B = new AccelerateInterpolator();
    private static final Interpolator C = new DecelerateInterpolator();

    /* renamed from: a  reason: collision with root package name */
    Context f570a;

    /* renamed from: b  reason: collision with root package name */
    private Context f571b;

    /* renamed from: c  reason: collision with root package name */
    ActionBarOverlayLayout f572c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarContainer f573d;

    /* renamed from: e  reason: collision with root package name */
    f0 f574e;

    /* renamed from: f  reason: collision with root package name */
    ActionBarContextView f575f;

    /* renamed from: g  reason: collision with root package name */
    View f576g;

    /* renamed from: h  reason: collision with root package name */
    q0 f577h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f578i;

    /* renamed from: j  reason: collision with root package name */
    d f579j;

    /* renamed from: k  reason: collision with root package name */
    i.b f580k;

    /* renamed from: l  reason: collision with root package name */
    b.a f581l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f582m;

    /* renamed from: o  reason: collision with root package name */
    private boolean f584o;

    /* renamed from: r  reason: collision with root package name */
    boolean f587r;

    /* renamed from: s  reason: collision with root package name */
    boolean f588s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f589t;

    /* renamed from: v  reason: collision with root package name */
    h f591v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f592w;

    /* renamed from: x  reason: collision with root package name */
    boolean f593x;

    /* renamed from: n  reason: collision with root package name */
    private ArrayList<a.b> f583n = new ArrayList<>();

    /* renamed from: p  reason: collision with root package name */
    private int f585p = 0;

    /* renamed from: q  reason: collision with root package name */
    boolean f586q = true;

    /* renamed from: u  reason: collision with root package name */
    private boolean f590u = true;

    /* renamed from: y  reason: collision with root package name */
    final j0 f594y = new a();

    /* renamed from: z  reason: collision with root package name */
    final j0 f595z = new b();
    final l0 A = new c();

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    class a extends k0 {
        a() {
        }

        @Override // androidx.core.view.j0
        public void b(View view) {
            View view2;
            n nVar = n.this;
            if (nVar.f586q && (view2 = nVar.f576g) != null) {
                view2.setTranslationY(0.0f);
                n.this.f573d.setTranslationY(0.0f);
            }
            n.this.f573d.setVisibility(8);
            n.this.f573d.setTransitioning(false);
            n nVar2 = n.this;
            nVar2.f591v = null;
            nVar2.E();
            ActionBarOverlayLayout actionBarOverlayLayout = n.this.f572c;
            if (actionBarOverlayLayout != null) {
                d0.q0(actionBarOverlayLayout);
            }
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    class b extends k0 {
        b() {
        }

        @Override // androidx.core.view.j0
        public void b(View view) {
            n nVar = n.this;
            nVar.f591v = null;
            nVar.f573d.requestLayout();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    class c implements l0 {
        c() {
        }

        @Override // androidx.core.view.l0
        public void a(View view) {
            ((View) n.this.f573d.getParent()).invalidate();
        }
    }

    /* compiled from: WindowDecorActionBar.java */
    /* loaded from: classes.dex */
    public class d extends i.b implements e.a {

        /* renamed from: c  reason: collision with root package name */
        private final Context f599c;

        /* renamed from: d  reason: collision with root package name */
        private final e f600d;

        /* renamed from: e  reason: collision with root package name */
        private b.a f601e;

        /* renamed from: f  reason: collision with root package name */
        private WeakReference<View> f602f;

        public d(Context context, b.a aVar) {
            this.f599c = context;
            this.f601e = aVar;
            e W = new e(context).W(1);
            this.f600d = W;
            W.V(this);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            b.a aVar = this.f601e;
            if (aVar != null) {
                return aVar.a(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
            if (this.f601e != null) {
                k();
                n.this.f575f.l();
            }
        }

        @Override // i.b
        public void c() {
            n nVar = n.this;
            if (nVar.f579j == this) {
                if (!n.D(nVar.f587r, nVar.f588s, false)) {
                    n nVar2 = n.this;
                    nVar2.f580k = this;
                    nVar2.f581l = this.f601e;
                } else {
                    this.f601e.b(this);
                }
                this.f601e = null;
                n.this.C(false);
                n.this.f575f.g();
                n nVar3 = n.this;
                nVar3.f572c.setHideOnContentScrollEnabled(nVar3.f593x);
                n.this.f579j = null;
            }
        }

        @Override // i.b
        public View d() {
            WeakReference<View> weakReference = this.f602f;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // i.b
        public Menu e() {
            return this.f600d;
        }

        @Override // i.b
        public MenuInflater f() {
            return new g(this.f599c);
        }

        @Override // i.b
        public CharSequence g() {
            return n.this.f575f.getSubtitle();
        }

        @Override // i.b
        public CharSequence i() {
            return n.this.f575f.getTitle();
        }

        @Override // i.b
        public void k() {
            if (n.this.f579j == this) {
                this.f600d.h0();
                try {
                    this.f601e.c(this, this.f600d);
                } finally {
                    this.f600d.g0();
                }
            }
        }

        @Override // i.b
        public boolean l() {
            return n.this.f575f.j();
        }

        @Override // i.b
        public void m(View view) {
            n.this.f575f.setCustomView(view);
            this.f602f = new WeakReference<>(view);
        }

        @Override // i.b
        public void n(int i10) {
            o(n.this.f570a.getResources().getString(i10));
        }

        @Override // i.b
        public void o(CharSequence charSequence) {
            n.this.f575f.setSubtitle(charSequence);
        }

        @Override // i.b
        public void q(int i10) {
            r(n.this.f570a.getResources().getString(i10));
        }

        @Override // i.b
        public void r(CharSequence charSequence) {
            n.this.f575f.setTitle(charSequence);
        }

        @Override // i.b
        public void s(boolean z10) {
            super.s(z10);
            n.this.f575f.setTitleOptional(z10);
        }

        public boolean t() {
            this.f600d.h0();
            try {
                return this.f601e.d(this, this.f600d);
            } finally {
                this.f600d.g0();
            }
        }
    }

    public n(Activity activity, boolean z10) {
        new ArrayList();
        View decorView = activity.getWindow().getDecorView();
        K(decorView);
        if (!z10) {
            this.f576g = decorView.findViewById(16908290);
        }
    }

    static boolean D(boolean z10, boolean z11, boolean z12) {
        if (z12) {
            return true;
        }
        return !z10 && !z11;
    }

    private f0 H(View view) {
        if (view instanceof f0) {
            return (f0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Can't make a decor toolbar out of ");
        sb2.append(view != null ? view.getClass().getSimpleName() : LpaConstants.VALUE_NULL);
        throw new IllegalStateException(sb2.toString());
    }

    private void J() {
        if (this.f589t) {
            this.f589t = false;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f572c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(false);
            }
            S(false);
        }
    }

    private void K(View view) {
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(f.f24804p);
        this.f572c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        this.f574e = H(view.findViewById(f.f24789a));
        this.f575f = (ActionBarContextView) view.findViewById(f.f24794f);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(f.f24791c);
        this.f573d = actionBarContainer;
        f0 f0Var = this.f574e;
        if (f0Var == null || this.f575f == null || actionBarContainer == null) {
            throw new IllegalStateException(n.class.getSimpleName() + " can only be used with a compatible window decor layout");
        }
        this.f570a = f0Var.getContext();
        boolean z10 = (this.f574e.u() & 4) != 0;
        if (z10) {
            this.f578i = true;
        }
        i.a b10 = i.a.b(this.f570a);
        P(b10.a() || z10);
        N(b10.g());
        TypedArray obtainStyledAttributes = this.f570a.obtainStyledAttributes(null, j.f24854a, d.a.f24715c, 0);
        if (obtainStyledAttributes.getBoolean(j.f24904k, false)) {
            O(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(j.f24894i, 0);
        if (dimensionPixelSize != 0) {
            M(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private void N(boolean z10) {
        this.f584o = z10;
        if (!z10) {
            this.f574e.i(null);
            this.f573d.setTabContainer(this.f577h);
        } else {
            this.f573d.setTabContainer(null);
            this.f574e.i(this.f577h);
        }
        boolean z11 = true;
        boolean z12 = I() == 2;
        q0 q0Var = this.f577h;
        if (q0Var != null) {
            if (z12) {
                q0Var.setVisibility(0);
                ActionBarOverlayLayout actionBarOverlayLayout = this.f572c;
                if (actionBarOverlayLayout != null) {
                    d0.q0(actionBarOverlayLayout);
                }
            } else {
                q0Var.setVisibility(8);
            }
        }
        this.f574e.z(!this.f584o && z12);
        ActionBarOverlayLayout actionBarOverlayLayout2 = this.f572c;
        if (this.f584o || !z12) {
            z11 = false;
        }
        actionBarOverlayLayout2.setHasNonEmbeddedTabs(z11);
    }

    private boolean Q() {
        return d0.X(this.f573d);
    }

    private void R() {
        if (!this.f589t) {
            this.f589t = true;
            ActionBarOverlayLayout actionBarOverlayLayout = this.f572c;
            if (actionBarOverlayLayout != null) {
                actionBarOverlayLayout.setShowingForActionMode(true);
            }
            S(false);
        }
    }

    private void S(boolean z10) {
        if (D(this.f587r, this.f588s, this.f589t)) {
            if (!this.f590u) {
                this.f590u = true;
                G(z10);
            }
        } else if (this.f590u) {
            this.f590u = false;
            F(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public void A(CharSequence charSequence) {
        this.f574e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.a
    public i.b B(b.a aVar) {
        d dVar = this.f579j;
        if (dVar != null) {
            dVar.c();
        }
        this.f572c.setHideOnContentScrollEnabled(false);
        this.f575f.k();
        d dVar2 = new d(this.f575f.getContext(), aVar);
        if (!dVar2.t()) {
            return null;
        }
        this.f579j = dVar2;
        dVar2.k();
        this.f575f.h(dVar2);
        C(true);
        return dVar2;
    }

    public void C(boolean z10) {
        i0 i0Var;
        i0 i0Var2;
        if (z10) {
            R();
        } else {
            J();
        }
        if (Q()) {
            if (z10) {
                i0Var = this.f574e.o(4, 100L);
                i0Var2 = this.f575f.f(0, 200L);
            } else {
                i0Var2 = this.f574e.o(0, 200L);
                i0Var = this.f575f.f(8, 100L);
            }
            h hVar = new h();
            hVar.d(i0Var, i0Var2);
            hVar.h();
        } else if (z10) {
            this.f574e.r(4);
            this.f575f.setVisibility(0);
        } else {
            this.f574e.r(0);
            this.f575f.setVisibility(8);
        }
    }

    void E() {
        b.a aVar = this.f581l;
        if (aVar != null) {
            aVar.b(this.f580k);
            this.f580k = null;
            this.f581l = null;
        }
    }

    public void F(boolean z10) {
        View view;
        int[] iArr;
        h hVar = this.f591v;
        if (hVar != null) {
            hVar.a();
        }
        if (this.f585p != 0 || (!this.f592w && !z10)) {
            this.f594y.b(null);
            return;
        }
        this.f573d.setAlpha(1.0f);
        this.f573d.setTransitioning(true);
        h hVar2 = new h();
        float f10 = -this.f573d.getHeight();
        if (z10) {
            this.f573d.getLocationInWindow(new int[]{0, 0});
            f10 -= iArr[1];
        }
        i0 k10 = d0.e(this.f573d).k(f10);
        k10.i(this.A);
        hVar2.c(k10);
        if (this.f586q && (view = this.f576g) != null) {
            hVar2.c(d0.e(view).k(f10));
        }
        hVar2.f(B);
        hVar2.e(250L);
        hVar2.g(this.f594y);
        this.f591v = hVar2;
        hVar2.h();
    }

    public void G(boolean z10) {
        View view;
        View view2;
        int[] iArr;
        h hVar = this.f591v;
        if (hVar != null) {
            hVar.a();
        }
        this.f573d.setVisibility(0);
        if (this.f585p != 0 || (!this.f592w && !z10)) {
            this.f573d.setAlpha(1.0f);
            this.f573d.setTranslationY(0.0f);
            if (this.f586q && (view = this.f576g) != null) {
                view.setTranslationY(0.0f);
            }
            this.f595z.b(null);
        } else {
            this.f573d.setTranslationY(0.0f);
            float f10 = -this.f573d.getHeight();
            if (z10) {
                this.f573d.getLocationInWindow(new int[]{0, 0});
                f10 -= iArr[1];
            }
            this.f573d.setTranslationY(f10);
            h hVar2 = new h();
            i0 k10 = d0.e(this.f573d).k(0.0f);
            k10.i(this.A);
            hVar2.c(k10);
            if (this.f586q && (view2 = this.f576g) != null) {
                view2.setTranslationY(f10);
                hVar2.c(d0.e(this.f576g).k(0.0f));
            }
            hVar2.f(C);
            hVar2.e(250L);
            hVar2.g(this.f595z);
            this.f591v = hVar2;
            hVar2.h();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f572c;
        if (actionBarOverlayLayout != null) {
            d0.q0(actionBarOverlayLayout);
        }
    }

    public int I() {
        return this.f574e.n();
    }

    public void L(int i10, int i11) {
        int u10 = this.f574e.u();
        if ((i11 & 4) != 0) {
            this.f578i = true;
        }
        this.f574e.k((i10 & i11) | ((~i11) & u10));
    }

    public void M(float f10) {
        d0.B0(this.f573d, f10);
    }

    public void O(boolean z10) {
        if (!z10 || this.f572c.w()) {
            this.f593x = z10;
            this.f572c.setHideOnContentScrollEnabled(z10);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void P(boolean z10) {
        this.f574e.t(z10);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void a() {
        if (this.f588s) {
            this.f588s = false;
            S(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void b() {
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void c(boolean z10) {
        this.f586q = z10;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void d() {
        if (!this.f588s) {
            this.f588s = true;
            S(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void e() {
        h hVar = this.f591v;
        if (hVar != null) {
            hVar.a();
            this.f591v = null;
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.d
    public void f(int i10) {
        this.f585p = i10;
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        f0 f0Var = this.f574e;
        if (f0Var == null || !f0Var.j()) {
            return false;
        }
        this.f574e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z10) {
        if (z10 != this.f582m) {
            this.f582m = z10;
            int size = this.f583n.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f583n.get(i10).a(z10);
            }
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f574e.u();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        if (this.f571b == null) {
            TypedValue typedValue = new TypedValue();
            this.f570a.getTheme().resolveAttribute(d.a.f24719g, typedValue, true);
            int i10 = typedValue.resourceId;
            if (i10 != 0) {
                this.f571b = new ContextThemeWrapper(this.f570a, i10);
            } else {
                this.f571b = this.f570a;
            }
        }
        return this.f571b;
    }

    @Override // androidx.appcompat.app.a
    public void l() {
        if (!this.f587r) {
            this.f587r = true;
            S(false);
        }
    }

    @Override // androidx.appcompat.app.a
    public void n(Configuration configuration) {
        N(i.a.b(this.f570a).g());
    }

    @Override // androidx.appcompat.app.a
    public boolean p(int i10, KeyEvent keyEvent) {
        Menu e10;
        d dVar = this.f579j;
        if (dVar == null || (e10 = dVar.e()) == null) {
            return false;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z10 = false;
        }
        e10.setQwertyMode(z10);
        return e10.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
        if (!this.f578i) {
            t(z10);
        }
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z10) {
        L(z10 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z10) {
        L(z10 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void v(int i10) {
        this.f574e.v(i10);
    }

    @Override // androidx.appcompat.app.a
    public void w(int i10) {
        this.f574e.p(i10);
    }

    @Override // androidx.appcompat.app.a
    public void x(Drawable drawable) {
        this.f574e.y(drawable);
    }

    @Override // androidx.appcompat.app.a
    public void y(boolean z10) {
        h hVar;
        this.f592w = z10;
        if (!z10 && (hVar = this.f591v) != null) {
            hVar.a();
        }
    }

    @Override // androidx.appcompat.app.a
    public void z(CharSequence charSequence) {
        this.f574e.setTitle(charSequence);
    }

    public n(Dialog dialog) {
        new ArrayList();
        K(dialog.getWindow().getDecorView());
    }
}
