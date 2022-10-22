package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.m0;
import androidx.core.view.d0;
import d.d;
import d.g;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardMenuPopup.java */
/* loaded from: classes.dex */
public final class l extends h implements PopupWindow.OnDismissListener, View.OnKeyListener {

    /* renamed from: v  reason: collision with root package name */
    private static final int f769v = g.f24827m;

    /* renamed from: b  reason: collision with root package name */
    private final Context f770b;

    /* renamed from: c  reason: collision with root package name */
    private final e f771c;

    /* renamed from: d  reason: collision with root package name */
    private final d f772d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f773e;

    /* renamed from: f  reason: collision with root package name */
    private final int f774f;

    /* renamed from: g  reason: collision with root package name */
    private final int f775g;

    /* renamed from: h  reason: collision with root package name */
    private final int f776h;

    /* renamed from: i  reason: collision with root package name */
    final m0 f777i;

    /* renamed from: l  reason: collision with root package name */
    private PopupWindow.OnDismissListener f780l;

    /* renamed from: m  reason: collision with root package name */
    private View f781m;

    /* renamed from: n  reason: collision with root package name */
    View f782n;

    /* renamed from: o  reason: collision with root package name */
    private j.a f783o;

    /* renamed from: p  reason: collision with root package name */
    ViewTreeObserver f784p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f785q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f786r;

    /* renamed from: s  reason: collision with root package name */
    private int f787s;

    /* renamed from: u  reason: collision with root package name */
    private boolean f789u;

    /* renamed from: j  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f778j = new a();

    /* renamed from: k  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f779k = new b();

    /* renamed from: t  reason: collision with root package name */
    private int f788t = 0;

    /* compiled from: StandardMenuPopup.java */
    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (l.this.b() && !l.this.f777i.B()) {
                View view = l.this.f782n;
                if (view == null || !view.isShown()) {
                    l.this.dismiss();
                } else {
                    l.this.f777i.a();
                }
            }
        }
    }

    /* compiled from: StandardMenuPopup.java */
    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = l.this.f784p;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    l.this.f784p = view.getViewTreeObserver();
                }
                l lVar = l.this;
                lVar.f784p.removeGlobalOnLayoutListener(lVar.f778j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public l(Context context, e eVar, View view, int i10, int i11, boolean z10) {
        this.f770b = context;
        this.f771c = eVar;
        this.f773e = z10;
        this.f772d = new d(eVar, LayoutInflater.from(context), z10, f769v);
        this.f775g = i10;
        this.f776h = i11;
        Resources resources = context.getResources();
        this.f774f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.f24751d));
        this.f781m = view;
        this.f777i = new m0(context, null, i10, i11);
        eVar.c(this, context);
    }

    private boolean B() {
        View view;
        if (b()) {
            return true;
        }
        if (this.f785q || (view = this.f781m) == null) {
            return false;
        }
        this.f782n = view;
        this.f777i.K(this);
        this.f777i.L(this);
        this.f777i.J(true);
        View view2 = this.f782n;
        boolean z10 = this.f784p == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.f784p = viewTreeObserver;
        if (z10) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f778j);
        }
        view2.addOnAttachStateChangeListener(this.f779k);
        this.f777i.D(view2);
        this.f777i.G(this.f788t);
        if (!this.f786r) {
            this.f787s = h.q(this.f772d, null, this.f770b, this.f774f);
            this.f786r = true;
        }
        this.f777i.F(this.f787s);
        this.f777i.I(2);
        this.f777i.H(p());
        this.f777i.a();
        ListView k10 = this.f777i.k();
        k10.setOnKeyListener(this);
        if (this.f789u && this.f771c.z() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f770b).inflate(g.f24826l, (ViewGroup) k10, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f771c.z());
            }
            frameLayout.setEnabled(false);
            k10.addHeaderView(frameLayout, null, false);
        }
        this.f777i.p(this.f772d);
        this.f777i.a();
        return true;
    }

    @Override // j.e
    public void a() {
        if (!B()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // j.e
    public boolean b() {
        return !this.f785q && this.f777i.b();
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(e eVar, boolean z10) {
        if (eVar == this.f771c) {
            dismiss();
            j.a aVar = this.f783o;
            if (aVar != null) {
                aVar.c(eVar, z10);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(boolean z10) {
        this.f786r = false;
        d dVar = this.f772d;
        if (dVar != null) {
            dVar.notifyDataSetChanged();
        }
    }

    @Override // j.e
    public void dismiss() {
        if (b()) {
            this.f777i.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f783o = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
    }

    @Override // j.e
    public ListView k() {
        return this.f777i.k();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        if (mVar.hasVisibleItems()) {
            i iVar = new i(this.f770b, mVar, this.f782n, this.f773e, this.f775g, this.f776h);
            iVar.j(this.f783o);
            iVar.g(h.z(mVar));
            iVar.i(this.f780l);
            this.f780l = null;
            this.f771c.e(false);
            int d10 = this.f777i.d();
            int o10 = this.f777i.o();
            if ((Gravity.getAbsoluteGravity(this.f788t, d0.E(this.f781m)) & 7) == 5) {
                d10 += this.f781m.getWidth();
            }
            if (iVar.n(d10, o10)) {
                j.a aVar = this.f783o;
                if (aVar == null) {
                    return true;
                }
                aVar.d(mVar);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable m() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.h
    public void n(e eVar) {
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.f785q = true;
        this.f771c.close();
        ViewTreeObserver viewTreeObserver = this.f784p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.f784p = this.f782n.getViewTreeObserver();
            }
            this.f784p.removeGlobalOnLayoutListener(this.f778j);
            this.f784p = null;
        }
        this.f782n.removeOnAttachStateChangeListener(this.f779k);
        PopupWindow.OnDismissListener onDismissListener = this.f780l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i10, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i10 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.h
    public void r(View view) {
        this.f781m = view;
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(boolean z10) {
        this.f772d.d(z10);
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(int i10) {
        this.f788t = i10;
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(int i10) {
        this.f777i.f(i10);
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(PopupWindow.OnDismissListener onDismissListener) {
        this.f780l = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void x(boolean z10) {
        this.f789u = z10;
    }

    @Override // androidx.appcompat.view.menu.h
    public void y(int i10) {
        this.f777i.l(i10);
    }
}
