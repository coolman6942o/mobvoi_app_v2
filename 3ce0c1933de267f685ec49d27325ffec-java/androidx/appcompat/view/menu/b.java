package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.l0;
import androidx.appcompat.widget.m0;
import androidx.core.view.d0;
import androidx.core.view.f;
import d.g;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
public final class b extends h implements View.OnKeyListener, PopupWindow.OnDismissListener {
    private static final int B = g.f24819e;
    boolean A;

    /* renamed from: b  reason: collision with root package name */
    private final Context f645b;

    /* renamed from: c  reason: collision with root package name */
    private final int f646c;

    /* renamed from: d  reason: collision with root package name */
    private final int f647d;

    /* renamed from: e  reason: collision with root package name */
    private final int f648e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f649f;

    /* renamed from: o  reason: collision with root package name */
    private View f658o;

    /* renamed from: p  reason: collision with root package name */
    View f659p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f661r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f662s;

    /* renamed from: t  reason: collision with root package name */
    private int f663t;

    /* renamed from: u  reason: collision with root package name */
    private int f664u;

    /* renamed from: w  reason: collision with root package name */
    private boolean f666w;

    /* renamed from: x  reason: collision with root package name */
    private j.a f667x;

    /* renamed from: y  reason: collision with root package name */
    ViewTreeObserver f668y;

    /* renamed from: z  reason: collision with root package name */
    private PopupWindow.OnDismissListener f669z;

    /* renamed from: h  reason: collision with root package name */
    private final List<e> f651h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    final List<d> f652i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    final ViewTreeObserver.OnGlobalLayoutListener f653j = new a();

    /* renamed from: k  reason: collision with root package name */
    private final View.OnAttachStateChangeListener f654k = new View$OnAttachStateChangeListenerC0006b();

    /* renamed from: l  reason: collision with root package name */
    private final l0 f655l = new c();

    /* renamed from: m  reason: collision with root package name */
    private int f656m = 0;

    /* renamed from: n  reason: collision with root package name */
    private int f657n = 0;

    /* renamed from: v  reason: collision with root package name */
    private boolean f665v = false;

    /* renamed from: q  reason: collision with root package name */
    private int f660q = F();

    /* renamed from: g  reason: collision with root package name */
    final Handler f650g = new Handler();

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (b.this.b() && b.this.f652i.size() > 0 && !b.this.f652i.get(0).f677a.B()) {
                View view = b.this.f659p;
                if (view == null || !view.isShown()) {
                    b.this.dismiss();
                    return;
                }
                for (d dVar : b.this.f652i) {
                    dVar.f677a.a();
                }
            }
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: androidx.appcompat.view.menu.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class View$OnAttachStateChangeListenerC0006b implements View.OnAttachStateChangeListener {
        View$OnAttachStateChangeListenerC0006b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = b.this.f668y;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    b.this.f668y = view.getViewTreeObserver();
                }
                b bVar = b.this;
                bVar.f668y.removeGlobalOnLayoutListener(bVar.f653j);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    class c implements l0 {

        /* compiled from: CascadingMenuPopup.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d f673a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MenuItem f674b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ e f675c;

            a(d dVar, MenuItem menuItem, e eVar) {
                this.f673a = dVar;
                this.f674b = menuItem;
                this.f675c = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar = this.f673a;
                if (dVar != null) {
                    b.this.A = true;
                    dVar.f678b.e(false);
                    b.this.A = false;
                }
                if (this.f674b.isEnabled() && this.f674b.hasSubMenu()) {
                    this.f675c.N(this.f674b, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.l0
        public void e(e eVar, MenuItem menuItem) {
            d dVar = null;
            b.this.f650g.removeCallbacksAndMessages(null);
            int size = b.this.f652i.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    i10 = -1;
                    break;
                } else if (eVar == b.this.f652i.get(i10).f678b) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 != -1) {
                int i11 = i10 + 1;
                if (i11 < b.this.f652i.size()) {
                    dVar = b.this.f652i.get(i11);
                }
                b.this.f650g.postAtTime(new a(dVar, menuItem, eVar), eVar, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // androidx.appcompat.widget.l0
        public void h(e eVar, MenuItem menuItem) {
            b.this.f650g.removeCallbacksAndMessages(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public final m0 f677a;

        /* renamed from: b  reason: collision with root package name */
        public final e f678b;

        /* renamed from: c  reason: collision with root package name */
        public final int f679c;

        public d(m0 m0Var, e eVar, int i10) {
            this.f677a = m0Var;
            this.f678b = eVar;
            this.f679c = i10;
        }

        public ListView a() {
            return this.f677a.k();
        }
    }

    public b(Context context, View view, int i10, int i11, boolean z10) {
        this.f645b = context;
        this.f658o = view;
        this.f647d = i10;
        this.f648e = i11;
        this.f649f = z10;
        Resources resources = context.getResources();
        this.f646c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.d.f24751d));
    }

    private m0 B() {
        m0 m0Var = new m0(this.f645b, null, this.f647d, this.f648e);
        m0Var.T(this.f655l);
        m0Var.L(this);
        m0Var.K(this);
        m0Var.D(this.f658o);
        m0Var.G(this.f657n);
        m0Var.J(true);
        m0Var.I(2);
        return m0Var;
    }

    private int C(e eVar) {
        int size = this.f652i.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (eVar == this.f652i.get(i10).f678b) {
                return i10;
            }
        }
        return -1;
    }

    private MenuItem D(e eVar, e eVar2) {
        int size = eVar.size();
        for (int i10 = 0; i10 < size; i10++) {
            MenuItem item = eVar.getItem(i10);
            if (item.hasSubMenu() && eVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View E(d dVar, e eVar) {
        int i10;
        androidx.appcompat.view.menu.d dVar2;
        int firstVisiblePosition;
        MenuItem D = D(dVar.f678b, eVar);
        if (D == null) {
            return null;
        }
        ListView a10 = dVar.a();
        ListAdapter adapter = a10.getAdapter();
        int i11 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i10 = headerViewListAdapter.getHeadersCount();
            dVar2 = (androidx.appcompat.view.menu.d) headerViewListAdapter.getWrappedAdapter();
        } else {
            dVar2 = (androidx.appcompat.view.menu.d) adapter;
            i10 = 0;
        }
        int count = dVar2.getCount();
        while (true) {
            if (i11 >= count) {
                i11 = -1;
                break;
            } else if (D == dVar2.getItem(i11)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 != -1 && (firstVisiblePosition = (i11 + i10) - a10.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a10.getChildCount()) {
            return a10.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int F() {
        return d0.E(this.f658o) == 1 ? 0 : 1;
    }

    private int G(int i10) {
        List<d> list = this.f652i;
        ListView a10 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a10.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f659p.getWindowVisibleDisplayFrame(rect);
        return this.f660q == 1 ? (iArr[0] + a10.getWidth()) + i10 > rect.right ? 0 : 1 : iArr[0] - i10 < 0 ? 1 : 0;
    }

    private void H(e eVar) {
        View view;
        d dVar;
        int i10;
        int i11;
        int i12;
        LayoutInflater from = LayoutInflater.from(this.f645b);
        androidx.appcompat.view.menu.d dVar2 = new androidx.appcompat.view.menu.d(eVar, from, this.f649f, B);
        if (!b() && this.f665v) {
            dVar2.d(true);
        } else if (b()) {
            dVar2.d(h.z(eVar));
        }
        int q5 = h.q(dVar2, null, this.f645b, this.f646c);
        m0 B2 = B();
        B2.p(dVar2);
        B2.F(q5);
        B2.G(this.f657n);
        if (this.f652i.size() > 0) {
            List<d> list = this.f652i;
            dVar = list.get(list.size() - 1);
            view = E(dVar, eVar);
        } else {
            dVar = null;
            view = null;
        }
        if (view != null) {
            B2.U(false);
            B2.R(null);
            int G = G(q5);
            boolean z10 = G == 1;
            this.f660q = G;
            if (Build.VERSION.SDK_INT >= 26) {
                B2.D(view);
                i11 = 0;
                i10 = 0;
            } else {
                int[] iArr = new int[2];
                this.f658o.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.f657n & 7) == 5) {
                    iArr[0] = iArr[0] + this.f658o.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i10 = iArr2[0] - iArr[0];
                i11 = iArr2[1] - iArr[1];
            }
            if ((this.f657n & 5) == 5) {
                if (!z10) {
                    q5 = view.getWidth();
                    i12 = i10 - q5;
                }
                i12 = i10 + q5;
            } else {
                if (z10) {
                    q5 = view.getWidth();
                    i12 = i10 + q5;
                }
                i12 = i10 - q5;
            }
            B2.f(i12);
            B2.M(true);
            B2.l(i11);
        } else {
            if (this.f661r) {
                B2.f(this.f663t);
            }
            if (this.f662s) {
                B2.l(this.f664u);
            }
            B2.H(p());
        }
        this.f652i.add(new d(B2, eVar, this.f660q));
        B2.a();
        ListView k10 = B2.k();
        k10.setOnKeyListener(this);
        if (dVar == null && this.f666w && eVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(g.f24826l, (ViewGroup) k10, false);
            frameLayout.setEnabled(false);
            ((TextView) frameLayout.findViewById(16908310)).setText(eVar.z());
            k10.addHeaderView(frameLayout, null, false);
            B2.a();
        }
    }

    @Override // j.e
    public void a() {
        if (!b()) {
            for (e eVar : this.f651h) {
                H(eVar);
            }
            this.f651h.clear();
            View view = this.f658o;
            this.f659p = view;
            if (view != null) {
                boolean z10 = this.f668y == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.f668y = viewTreeObserver;
                if (z10) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f653j);
                }
                this.f659p.addOnAttachStateChangeListener(this.f654k);
            }
        }
    }

    @Override // j.e
    public boolean b() {
        return this.f652i.size() > 0 && this.f652i.get(0).f677a.b();
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(e eVar, boolean z10) {
        int C = C(eVar);
        if (C >= 0) {
            int i10 = C + 1;
            if (i10 < this.f652i.size()) {
                this.f652i.get(i10).f678b.e(false);
            }
            d remove = this.f652i.remove(C);
            remove.f678b.Q(this);
            if (this.A) {
                remove.f677a.S(null);
                remove.f677a.E(0);
            }
            remove.f677a.dismiss();
            int size = this.f652i.size();
            if (size > 0) {
                this.f660q = this.f652i.get(size - 1).f679c;
            } else {
                this.f660q = F();
            }
            if (size == 0) {
                dismiss();
                j.a aVar = this.f667x;
                if (aVar != null) {
                    aVar.c(eVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.f668y;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.f668y.removeGlobalOnLayoutListener(this.f653j);
                    }
                    this.f668y = null;
                }
                this.f659p.removeOnAttachStateChangeListener(this.f654k);
                this.f669z.onDismiss();
            } else if (z10) {
                this.f652i.get(0).f678b.e(false);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(boolean z10) {
        for (d dVar : this.f652i) {
            h.A(dVar.a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // j.e
    public void dismiss() {
        int size = this.f652i.size();
        if (size > 0) {
            d[] dVarArr = (d[]) this.f652i.toArray(new d[size]);
            for (int i10 = size - 1; i10 >= 0; i10--) {
                d dVar = dVarArr[i10];
                if (dVar.f677a.b()) {
                    dVar.f677a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f667x = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
    }

    @Override // j.e
    public ListView k() {
        if (this.f652i.isEmpty()) {
            return null;
        }
        List<d> list = this.f652i;
        return list.get(list.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        for (d dVar : this.f652i) {
            if (mVar == dVar.f678b) {
                dVar.a().requestFocus();
                return true;
            }
        }
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        n(mVar);
        j.a aVar = this.f667x;
        if (aVar != null) {
            aVar.d(mVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable m() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.h
    public void n(e eVar) {
        eVar.c(this, this.f645b);
        if (b()) {
            H(eVar);
        } else {
            this.f651h.add(eVar);
        }
    }

    @Override // androidx.appcompat.view.menu.h
    protected boolean o() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        d dVar;
        int size = this.f652i.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f652i.get(i10);
            if (!dVar.f677a.b()) {
                break;
            }
            i10++;
        }
        if (dVar != null) {
            dVar.f678b.e(false);
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
        if (this.f658o != view) {
            this.f658o = view;
            this.f657n = f.b(this.f656m, d0.E(view));
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void t(boolean z10) {
        this.f665v = z10;
    }

    @Override // androidx.appcompat.view.menu.h
    public void u(int i10) {
        if (this.f656m != i10) {
            this.f656m = i10;
            this.f657n = f.b(i10, d0.E(this.f658o));
        }
    }

    @Override // androidx.appcompat.view.menu.h
    public void v(int i10) {
        this.f661r = true;
        this.f663t = i10;
    }

    @Override // androidx.appcompat.view.menu.h
    public void w(PopupWindow.OnDismissListener onDismissListener) {
        this.f669z = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.h
    public void x(boolean z10) {
        this.f666w = z10;
    }

    @Override // androidx.appcompat.view.menu.h
    public void y(int i10) {
        this.f662s = true;
        this.f664u = i10;
    }
}
