package o0;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.g;
import androidx.core.view.d0;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;
import java.util.List;
import k0.d;
import k0.e;
import o0.b;
/* compiled from: ExploreByTouchHelper.java */
/* loaded from: classes.dex */
public abstract class a extends androidx.core.view.a {

    /* renamed from: n  reason: collision with root package name */
    private static final Rect f31360n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: o  reason: collision with root package name */
    private static final b.a<k0.c> f31361o = new C0417a();

    /* renamed from: p  reason: collision with root package name */
    private static final b.AbstractC0418b<g<k0.c>, k0.c> f31362p = new b();

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f31367h;

    /* renamed from: i  reason: collision with root package name */
    private final View f31368i;

    /* renamed from: j  reason: collision with root package name */
    private c f31369j;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f31363d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f31364e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f31365f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final int[] f31366g = new int[2];

    /* renamed from: k  reason: collision with root package name */
    int f31370k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    int f31371l = Integer.MIN_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private int f31372m = Integer.MIN_VALUE;

    /* compiled from: ExploreByTouchHelper.java */
    /* renamed from: o0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0417a implements b.a<k0.c> {
        C0417a() {
        }

        /* renamed from: b */
        public void a(k0.c cVar, Rect rect) {
            cVar.m(rect);
        }
    }

    /* compiled from: ExploreByTouchHelper.java */
    /* loaded from: classes.dex */
    class b implements b.AbstractC0418b<g<k0.c>, k0.c> {
        b() {
        }

        /* renamed from: c */
        public k0.c a(g<k0.c> gVar, int i10) {
            return gVar.m(i10);
        }

        /* renamed from: d */
        public int b(g<k0.c> gVar) {
            return gVar.l();
        }
    }

    /* compiled from: ExploreByTouchHelper.java */
    /* loaded from: classes.dex */
    private class c extends d {
        c() {
        }

        @Override // k0.d
        public k0.c b(int i10) {
            return k0.c.P(a.this.H(i10));
        }

        @Override // k0.d
        public k0.c d(int i10) {
            int i11 = i10 == 2 ? a.this.f31370k : a.this.f31371l;
            if (i11 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i11);
        }

        @Override // k0.d
        public boolean f(int i10, int i11, Bundle bundle) {
            return a.this.P(i10, i11, bundle);
        }
    }

    public a(View view) {
        if (view != null) {
            this.f31368i = view;
            this.f31367h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (d0.C(view) == 0) {
                d0.E0(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private static Rect D(View view, int i10, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i10 == 17) {
            rect.set(width, 0, width, height);
        } else if (i10 == 33) {
            rect.set(0, height, width, height);
        } else if (i10 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i10 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private boolean E(Rect rect) {
        if (rect == null || rect.isEmpty() || this.f31368i.getWindowVisibility() != 0) {
            return false;
        }
        ViewParent parent = this.f31368i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    private static int F(int i10) {
        if (i10 == 19) {
            return 33;
        }
        if (i10 != 21) {
            return i10 != 22 ? 130 : 66;
        }
        return 17;
    }

    private boolean G(int i10, Rect rect) {
        k0.c cVar;
        g<k0.c> y10 = y();
        int i11 = this.f31371l;
        int i12 = Integer.MIN_VALUE;
        k0.c e10 = i11 == Integer.MIN_VALUE ? null : y10.e(i11);
        if (i10 == 1 || i10 == 2) {
            cVar = (k0.c) o0.b.d(y10, f31362p, f31361o, e10, i10, d0.E(this.f31368i) == 1, false);
        } else if (i10 == 17 || i10 == 33 || i10 == 66 || i10 == 130) {
            Rect rect2 = new Rect();
            int i13 = this.f31371l;
            if (i13 != Integer.MIN_VALUE) {
                z(i13, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.f31368i, i10, rect2);
            }
            cVar = (k0.c) o0.b.c(y10, f31362p, f31361o, e10, rect2, i10);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (cVar != null) {
            i12 = y10.i(y10.g(cVar));
        }
        return T(i12);
    }

    private boolean Q(int i10, int i11, Bundle bundle) {
        if (i11 == 1) {
            return T(i10);
        }
        if (i11 == 2) {
            return o(i10);
        }
        if (i11 == 64) {
            return S(i10);
        }
        if (i11 != 128) {
            return J(i10, i11, bundle);
        }
        return n(i10);
    }

    private boolean R(int i10, Bundle bundle) {
        return d0.i0(this.f31368i, i10, bundle);
    }

    private boolean S(int i10) {
        int i11;
        if (!this.f31367h.isEnabled() || !this.f31367h.isTouchExplorationEnabled() || (i11 = this.f31370k) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            n(i11);
        }
        this.f31370k = i10;
        this.f31368i.invalidate();
        U(i10, 32768);
        return true;
    }

    private void V(int i10) {
        int i11 = this.f31372m;
        if (i11 != i10) {
            this.f31372m = i10;
            U(i10, 128);
            U(i11, 256);
        }
    }

    private boolean n(int i10) {
        if (this.f31370k != i10) {
            return false;
        }
        this.f31370k = Integer.MIN_VALUE;
        this.f31368i.invalidate();
        U(i10, WXMediaMessage.THUMB_LENGTH_LIMIT);
        return true;
    }

    private boolean p() {
        int i10 = this.f31371l;
        return i10 != Integer.MIN_VALUE && J(i10, 16, null);
    }

    private AccessibilityEvent q(int i10, int i11) {
        if (i10 != -1) {
            return r(i10, i11);
        }
        return s(i11);
    }

    private AccessibilityEvent r(int i10, int i11) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i11);
        k0.c H = H(i10);
        obtain.getText().add(H.w());
        obtain.setContentDescription(H.r());
        obtain.setScrollable(H.J());
        obtain.setPassword(H.I());
        obtain.setEnabled(H.E());
        obtain.setChecked(H.C());
        L(i10, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(H.p());
            e.c(obtain, this.f31368i, i10);
            obtain.setPackageName(this.f31368i.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private AccessibilityEvent s(int i10) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i10);
        this.f31368i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private k0.c t(int i10) {
        k0.c N = k0.c.N();
        N.g0(true);
        N.i0(true);
        N.a0("android.view.View");
        Rect rect = f31360n;
        N.W(rect);
        N.X(rect);
        N.p0(this.f31368i);
        N(i10, N);
        if (N.w() == null && N.r() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        N.m(this.f31364e);
        if (!this.f31364e.equals(rect)) {
            int k10 = N.k();
            if ((k10 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((k10 & 128) == 0) {
                N.n0(this.f31368i.getContext().getPackageName());
                N.x0(this.f31368i, i10);
                if (this.f31370k == i10) {
                    N.U(true);
                    N.a(128);
                } else {
                    N.U(false);
                    N.a(64);
                }
                boolean z10 = this.f31371l == i10;
                if (z10) {
                    N.a(2);
                } else if (N.F()) {
                    N.a(1);
                }
                N.j0(z10);
                this.f31368i.getLocationOnScreen(this.f31366g);
                N.n(this.f31363d);
                if (this.f31363d.equals(rect)) {
                    N.m(this.f31363d);
                    if (N.f29693b != -1) {
                        k0.c N2 = k0.c.N();
                        for (int i11 = N.f29693b; i11 != -1; i11 = N2.f29693b) {
                            N2.q0(this.f31368i, -1);
                            N2.W(f31360n);
                            N(i11, N2);
                            N2.m(this.f31364e);
                            Rect rect2 = this.f31363d;
                            Rect rect3 = this.f31364e;
                            rect2.offset(rect3.left, rect3.top);
                        }
                        N2.R();
                    }
                    this.f31363d.offset(this.f31366g[0] - this.f31368i.getScrollX(), this.f31366g[1] - this.f31368i.getScrollY());
                }
                if (this.f31368i.getLocalVisibleRect(this.f31365f)) {
                    this.f31365f.offset(this.f31366g[0] - this.f31368i.getScrollX(), this.f31366g[1] - this.f31368i.getScrollY());
                    if (this.f31363d.intersect(this.f31365f)) {
                        N.X(this.f31363d);
                        if (E(this.f31363d)) {
                            N.B0(true);
                        }
                    }
                }
                return N;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private k0.c u() {
        k0.c O = k0.c.O(this.f31368i);
        d0.g0(this.f31368i, O);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (O.o() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                O.d(this.f31368i, ((Integer) arrayList.get(i10)).intValue());
            }
            return O;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private g<k0.c> y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        g<k0.c> gVar = new g<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            gVar.j(arrayList.get(i10).intValue(), t(arrayList.get(i10).intValue()));
        }
        return gVar;
    }

    private void z(int i10, Rect rect) {
        H(i10).m(rect);
    }

    public final int A() {
        return this.f31371l;
    }

    protected abstract int B(float f10, float f11);

    protected abstract void C(List<Integer> list);

    k0.c H(int i10) {
        if (i10 == -1) {
            return u();
        }
        return t(i10);
    }

    public final void I(boolean z10, int i10, Rect rect) {
        int i11 = this.f31371l;
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (z10) {
            G(i10, rect);
        }
    }

    protected abstract boolean J(int i10, int i11, Bundle bundle);

    protected void K(AccessibilityEvent accessibilityEvent) {
    }

    protected void L(int i10, AccessibilityEvent accessibilityEvent) {
    }

    protected abstract void M(k0.c cVar);

    protected abstract void N(int i10, k0.c cVar);

    protected abstract void O(int i10, boolean z10);

    boolean P(int i10, int i11, Bundle bundle) {
        if (i10 != -1) {
            return Q(i10, i11, bundle);
        }
        return R(i11, bundle);
    }

    public final boolean T(int i10) {
        int i11;
        if ((!this.f31368i.isFocused() && !this.f31368i.requestFocus()) || (i11 = this.f31371l) == i10) {
            return false;
        }
        if (i11 != Integer.MIN_VALUE) {
            o(i11);
        }
        if (i10 == Integer.MIN_VALUE) {
            return false;
        }
        this.f31371l = i10;
        O(i10, true);
        U(i10, 8);
        return true;
    }

    public final boolean U(int i10, int i11) {
        ViewParent parent;
        if (i10 == Integer.MIN_VALUE || !this.f31367h.isEnabled() || (parent = this.f31368i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.f31368i, q(i10, i11));
    }

    @Override // androidx.core.view.a
    public d b(View view) {
        if (this.f31369j == null) {
            this.f31369j = new c();
        }
        return this.f31369j;
    }

    @Override // androidx.core.view.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        K(accessibilityEvent);
    }

    @Override // androidx.core.view.a
    public void g(View view, k0.c cVar) {
        super.g(view, cVar);
        M(cVar);
    }

    public final boolean o(int i10) {
        if (this.f31371l != i10) {
            return false;
        }
        this.f31371l = Integer.MIN_VALUE;
        O(i10, false);
        U(i10, 8);
        return true;
    }

    public final boolean v(MotionEvent motionEvent) {
        if (!this.f31367h.isEnabled() || !this.f31367h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int B = B(motionEvent.getX(), motionEvent.getY());
            V(B);
            return B != Integer.MIN_VALUE;
        } else if (action != 10 || this.f31372m == Integer.MIN_VALUE) {
            return false;
        } else {
            V(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean w(KeyEvent keyEvent) {
        int i10 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int F = F(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z10 = false;
                        while (i10 < repeatCount && G(F, null)) {
                            i10++;
                            z10 = true;
                        }
                        return z10;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            p();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return G(2, null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return G(1, null);
            }
            return false;
        }
    }

    public final int x() {
        return this.f31370k;
    }
}
