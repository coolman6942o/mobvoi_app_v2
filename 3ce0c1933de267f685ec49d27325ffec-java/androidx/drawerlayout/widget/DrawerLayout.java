package androidx.drawerlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.d0;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.List;
import k0.c;
import k0.f;
import o0.d;
/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup implements o0.c {
    private static final int[] L = {16843828};
    static final int[] M = {16842931};
    static final boolean N;
    private static final boolean O;
    private static boolean P;
    private CharSequence A;
    private Object B;
    private boolean C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private Drawable G;
    private final ArrayList<View> H;
    private Rect I;
    private Matrix J;
    private final k0.f K;

    /* renamed from: a  reason: collision with root package name */
    private final d f2736a;

    /* renamed from: b  reason: collision with root package name */
    private float f2737b;

    /* renamed from: c  reason: collision with root package name */
    private int f2738c;

    /* renamed from: d  reason: collision with root package name */
    private int f2739d;

    /* renamed from: e  reason: collision with root package name */
    private float f2740e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f2741f;

    /* renamed from: g  reason: collision with root package name */
    private final o0.d f2742g;

    /* renamed from: h  reason: collision with root package name */
    private final o0.d f2743h;

    /* renamed from: i  reason: collision with root package name */
    private final g f2744i;

    /* renamed from: j  reason: collision with root package name */
    private final g f2745j;

    /* renamed from: k  reason: collision with root package name */
    private int f2746k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2747l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2748m;

    /* renamed from: n  reason: collision with root package name */
    private int f2749n;

    /* renamed from: o  reason: collision with root package name */
    private int f2750o;

    /* renamed from: p  reason: collision with root package name */
    private int f2751p;

    /* renamed from: q  reason: collision with root package name */
    private int f2752q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f2753r;

    /* renamed from: s  reason: collision with root package name */
    private e f2754s;

    /* renamed from: t  reason: collision with root package name */
    private List<e> f2755t;

    /* renamed from: u  reason: collision with root package name */
    private float f2756u;

    /* renamed from: v  reason: collision with root package name */
    private float f2757v;

    /* renamed from: w  reason: collision with root package name */
    private Drawable f2758w;

    /* renamed from: x  reason: collision with root package name */
    private Drawable f2759x;

    /* renamed from: y  reason: collision with root package name */
    private Drawable f2760y;

    /* renamed from: z  reason: collision with root package name */
    private CharSequence f2761z;

    /* loaded from: classes.dex */
    class a implements k0.f {
        a() {
        }

        @Override // k0.f
        public boolean a(View view, f.a aVar) {
            if (!DrawerLayout.this.B(view) || DrawerLayout.this.q(view) == 2) {
                return false;
            }
            DrawerLayout.this.e(view);
            return true;
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnApplyWindowInsetsListener {
        b(DrawerLayout drawerLayout) {
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            ((DrawerLayout) view).P(windowInsets, windowInsets.getSystemWindowInsetTop() > 0);
            return windowInsets.consumeSystemWindowInsets();
        }
    }

    /* loaded from: classes.dex */
    class c extends androidx.core.view.a {

        /* renamed from: d  reason: collision with root package name */
        private final Rect f2768d = new Rect();

        c() {
        }

        private void n(k0.c cVar, ViewGroup viewGroup) {
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                if (DrawerLayout.z(childAt)) {
                    cVar.c(childAt);
                }
            }
        }

        private void o(k0.c cVar, k0.c cVar2) {
            Rect rect = this.f2768d;
            cVar2.n(rect);
            cVar.X(rect);
            cVar.B0(cVar2.M());
            cVar.n0(cVar2.u());
            cVar.a0(cVar2.p());
            cVar.e0(cVar2.r());
            cVar.g0(cVar2.E());
            cVar.j0(cVar2.G());
            cVar.U(cVar2.A());
            cVar.u0(cVar2.K());
            cVar.a(cVar2.k());
        }

        @Override // androidx.core.view.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            if (accessibilityEvent.getEventType() != 32) {
                return super.a(view, accessibilityEvent);
            }
            List<CharSequence> text = accessibilityEvent.getText();
            View o10 = DrawerLayout.this.o();
            if (o10 == null) {
                return true;
            }
            CharSequence r10 = DrawerLayout.this.r(DrawerLayout.this.s(o10));
            if (r10 == null) {
                return true;
            }
            text.add(r10);
            return true;
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            super.f(view, accessibilityEvent);
            accessibilityEvent.setClassName("androidx.drawerlayout.widget.DrawerLayout");
        }

        @Override // androidx.core.view.a
        public void g(View view, k0.c cVar) {
            if (DrawerLayout.N) {
                super.g(view, cVar);
            } else {
                k0.c P = k0.c.P(cVar);
                super.g(view, P);
                cVar.w0(view);
                ViewParent K = d0.K(view);
                if (K instanceof View) {
                    cVar.p0((View) K);
                }
                o(cVar, P);
                P.R();
                n(cVar, (ViewGroup) view);
            }
            cVar.a0("androidx.drawerlayout.widget.DrawerLayout");
            cVar.i0(false);
            cVar.j0(false);
            cVar.S(c.a.f29695e);
            cVar.S(c.a.f29696f);
        }

        @Override // androidx.core.view.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            if (DrawerLayout.N || DrawerLayout.z(view)) {
                return super.i(viewGroup, view, accessibilityEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    static final class d extends androidx.core.view.a {
        d() {
        }

        @Override // androidx.core.view.a
        public void g(View view, k0.c cVar) {
            super.g(view, cVar);
            if (!DrawerLayout.z(view)) {
                cVar.p0(null);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        void a(View view);

        void b(View view);

        void c(int i10);

        void d(View view, float f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g extends d.c {

        /* renamed from: a  reason: collision with root package name */
        private final int f2774a;

        /* renamed from: b  reason: collision with root package name */
        private o0.d f2775b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f2776c = new a();

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                g.this.o();
            }
        }

        g(int i10) {
            this.f2774a = i10;
        }

        private void n() {
            int i10 = 3;
            if (this.f2774a == 3) {
                i10 = 5;
            }
            View m10 = DrawerLayout.this.m(i10);
            if (m10 != null) {
                DrawerLayout.this.e(m10);
            }
        }

        @Override // o0.d.c
        public int a(View view, int i10, int i11) {
            if (DrawerLayout.this.d(view, 3)) {
                return Math.max(-view.getWidth(), Math.min(i10, 0));
            }
            int width = DrawerLayout.this.getWidth();
            return Math.max(width - view.getWidth(), Math.min(i10, width));
        }

        @Override // o0.d.c
        public int b(View view, int i10, int i11) {
            return view.getTop();
        }

        @Override // o0.d.c
        public int d(View view) {
            if (DrawerLayout.this.C(view)) {
                return view.getWidth();
            }
            return 0;
        }

        @Override // o0.d.c
        public void f(int i10, int i11) {
            View view;
            if ((i10 & 1) == 1) {
                view = DrawerLayout.this.m(3);
            } else {
                view = DrawerLayout.this.m(5);
            }
            if (view != null && DrawerLayout.this.q(view) == 0) {
                this.f2775b.b(view, i11);
            }
        }

        @Override // o0.d.c
        public boolean g(int i10) {
            return false;
        }

        @Override // o0.d.c
        public void h(int i10, int i11) {
            DrawerLayout.this.postDelayed(this.f2776c, 160L);
        }

        @Override // o0.d.c
        public void i(View view, int i10) {
            ((f) view.getLayoutParams()).f2772c = false;
            n();
        }

        @Override // o0.d.c
        public void j(int i10) {
            DrawerLayout.this.U(i10, this.f2775b.v());
        }

        @Override // o0.d.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            int width = view.getWidth();
            float width2 = (DrawerLayout.this.d(view, 3) ? i10 + width : DrawerLayout.this.getWidth() - i10) / width;
            DrawerLayout.this.R(view, width2);
            view.setVisibility(width2 == 0.0f ? 4 : 0);
            DrawerLayout.this.invalidate();
        }

        @Override // o0.d.c
        public void l(View view, float f10, float f11) {
            int i10;
            float t10 = DrawerLayout.this.t(view);
            int width = view.getWidth();
            if (DrawerLayout.this.d(view, 3)) {
                int i11 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
                i10 = (i11 > 0 || (i11 == 0 && t10 > 0.5f)) ? 0 : -width;
            } else {
                int width2 = DrawerLayout.this.getWidth();
                if (f10 < 0.0f || (f10 == 0.0f && t10 > 0.5f)) {
                    width2 -= width;
                }
                i10 = width2;
            }
            this.f2775b.O(i10, view.getTop());
            DrawerLayout.this.invalidate();
        }

        @Override // o0.d.c
        public boolean m(View view, int i10) {
            return DrawerLayout.this.C(view) && DrawerLayout.this.d(view, this.f2774a) && DrawerLayout.this.q(view) == 0;
        }

        void o() {
            View view;
            int i10;
            int x10 = this.f2775b.x();
            int i11 = 0;
            boolean z10 = this.f2774a == 3;
            if (z10) {
                view = DrawerLayout.this.m(3);
                if (view != null) {
                    i11 = -view.getWidth();
                }
                i10 = i11 + x10;
            } else {
                view = DrawerLayout.this.m(5);
                i10 = DrawerLayout.this.getWidth() - x10;
            }
            if (view == null) {
                return;
            }
            if (((z10 && view.getLeft() < i10) || (!z10 && view.getLeft() > i10)) && DrawerLayout.this.q(view) == 0) {
                this.f2775b.Q(view, i10, view.getTop());
                ((f) view.getLayoutParams()).f2772c = true;
                DrawerLayout.this.invalidate();
                n();
                DrawerLayout.this.c();
            }
        }

        public void p() {
            DrawerLayout.this.removeCallbacks(this.f2776c);
        }

        public void q(o0.d dVar) {
            this.f2775b = dVar;
        }
    }

    static {
        boolean z10 = true;
        int i10 = Build.VERSION.SDK_INT;
        N = i10 >= 19;
        O = i10 >= 21;
        if (i10 < 29) {
            z10 = false;
        }
        P = z10;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, r0.a.f33282a);
    }

    private boolean E(float f10, float f11, View view) {
        if (this.I == null) {
            this.I = new Rect();
        }
        view.getHitRect(this.I);
        return this.I.contains((int) f10, (int) f11);
    }

    private void F(Drawable drawable, int i10) {
        if (drawable != null && androidx.core.graphics.drawable.a.h(drawable)) {
            androidx.core.graphics.drawable.a.m(drawable, i10);
        }
    }

    private Drawable M() {
        int E = d0.E(this);
        if (E == 0) {
            Drawable drawable = this.D;
            if (drawable != null) {
                F(drawable, E);
                return this.D;
            }
        } else {
            Drawable drawable2 = this.E;
            if (drawable2 != null) {
                F(drawable2, E);
                return this.E;
            }
        }
        return this.F;
    }

    private Drawable N() {
        int E = d0.E(this);
        if (E == 0) {
            Drawable drawable = this.E;
            if (drawable != null) {
                F(drawable, E);
                return this.E;
            }
        } else {
            Drawable drawable2 = this.D;
            if (drawable2 != null) {
                F(drawable2, E);
                return this.D;
            }
        }
        return this.G;
    }

    private void O() {
        if (!O) {
            this.f2759x = M();
            this.f2760y = N();
        }
    }

    private void S(View view) {
        c.a aVar = c.a.f29702l;
        d0.n0(view, aVar.b());
        if (B(view) && q(view) != 2) {
            d0.p0(view, aVar, null, this.K);
        }
    }

    private void T(View view, boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((z10 || C(childAt)) && (!z10 || childAt != view)) {
                d0.E0(childAt, 4);
            } else {
                d0.E0(childAt, 1);
            }
        }
    }

    private boolean l(MotionEvent motionEvent, View view) {
        if (!view.getMatrix().isIdentity()) {
            MotionEvent u10 = u(motionEvent, view);
            boolean dispatchGenericMotionEvent = view.dispatchGenericMotionEvent(u10);
            u10.recycle();
            return dispatchGenericMotionEvent;
        }
        float scrollX = getScrollX() - view.getLeft();
        float scrollY = getScrollY() - view.getTop();
        motionEvent.offsetLocation(scrollX, scrollY);
        boolean dispatchGenericMotionEvent2 = view.dispatchGenericMotionEvent(motionEvent);
        motionEvent.offsetLocation(-scrollX, -scrollY);
        return dispatchGenericMotionEvent2;
    }

    private MotionEvent u(MotionEvent motionEvent, View view) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(getScrollX() - view.getLeft(), getScrollY() - view.getTop());
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            if (this.J == null) {
                this.J = new Matrix();
            }
            matrix.invert(this.J);
            obtain.transform(this.J);
        }
        return obtain;
    }

    static String v(int i10) {
        return (i10 & 3) == 3 ? "LEFT" : (i10 & 5) == 5 ? "RIGHT" : Integer.toHexString(i10);
    }

    private static boolean w(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    private boolean x() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((f) getChildAt(i10).getLayoutParams()).f2772c) {
                return true;
            }
        }
        return false;
    }

    private boolean y() {
        return o() != null;
    }

    static boolean z(View view) {
        return (d0.C(view) == 4 || d0.C(view) == 2) ? false : true;
    }

    boolean A(View view) {
        return ((f) view.getLayoutParams()).f2770a == 0;
    }

    public boolean B(View view) {
        if (C(view)) {
            return (((f) view.getLayoutParams()).f2773d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    boolean C(View view) {
        int b10 = androidx.core.view.f.b(((f) view.getLayoutParams()).f2770a, d0.E(view));
        return ((b10 & 3) == 0 && (b10 & 5) == 0) ? false : true;
    }

    public boolean D(View view) {
        if (C(view)) {
            return ((f) view.getLayoutParams()).f2771b > 0.0f;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    void G(View view, float f10) {
        float t10 = t(view);
        float width = view.getWidth();
        int i10 = ((int) (width * f10)) - ((int) (t10 * width));
        if (!d(view, 3)) {
            i10 = -i10;
        }
        view.offsetLeftAndRight(i10);
        R(view, f10);
    }

    public void H(int i10) {
        I(i10, true);
    }

    public void I(int i10, boolean z10) {
        View m10 = m(i10);
        if (m10 != null) {
            K(m10, z10);
            return;
        }
        throw new IllegalArgumentException("No drawer view found with gravity " + v(i10));
    }

    public void J(View view) {
        K(view, true);
    }

    public void K(View view, boolean z10) {
        if (C(view)) {
            f fVar = (f) view.getLayoutParams();
            if (this.f2748m) {
                fVar.f2771b = 1.0f;
                fVar.f2773d = 1;
                T(view, true);
                S(view);
            } else if (z10) {
                fVar.f2773d |= 2;
                if (d(view, 3)) {
                    this.f2742g.Q(view, 0, view.getTop());
                } else {
                    this.f2743h.Q(view, getWidth() - view.getWidth(), view.getTop());
                }
            } else {
                G(view, 1.0f);
                U(0, view);
                view.setVisibility(0);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void L(e eVar) {
        List<e> list;
        if (eVar != null && (list = this.f2755t) != null) {
            list.remove(eVar);
        }
    }

    public void P(Object obj, boolean z10) {
        this.B = obj;
        this.C = z10;
        setWillNotDraw(!z10 && getBackground() == null);
        requestLayout();
    }

    public void Q(int i10, int i11) {
        View m10;
        int b10 = androidx.core.view.f.b(i11, d0.E(this));
        if (i11 == 3) {
            this.f2749n = i10;
        } else if (i11 == 5) {
            this.f2750o = i10;
        } else if (i11 == 8388611) {
            this.f2751p = i10;
        } else if (i11 == 8388613) {
            this.f2752q = i10;
        }
        if (i10 != 0) {
            (b10 == 3 ? this.f2742g : this.f2743h).a();
        }
        if (i10 == 1) {
            View m11 = m(b10);
            if (m11 != null) {
                e(m11);
            }
        } else if (i10 == 2 && (m10 = m(b10)) != null) {
            J(m10);
        }
    }

    void R(View view, float f10) {
        f fVar = (f) view.getLayoutParams();
        if (f10 != fVar.f2771b) {
            fVar.f2771b = f10;
            k(view, f10);
        }
    }

    void U(int i10, View view) {
        int A = this.f2742g.A();
        int A2 = this.f2743h.A();
        int i11 = 2;
        if (A == 1 || A2 == 1) {
            i11 = 1;
        } else if (!(A == 2 || A2 == 2)) {
            i11 = 0;
        }
        if (view != null && i10 == 0) {
            float f10 = ((f) view.getLayoutParams()).f2771b;
            if (f10 == 0.0f) {
                i(view);
            } else if (f10 == 1.0f) {
                j(view);
            }
        }
        if (i11 != this.f2746k) {
            this.f2746k = i11;
            List<e> list = this.f2755t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2755t.get(size).c(i11);
                }
            }
        }
    }

    @Override // o0.c
    public void a() {
        H(8388611);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        if (getDescendantFocusability() != 393216) {
            int childCount = getChildCount();
            boolean z10 = false;
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (!C(childAt)) {
                    this.H.add(childAt);
                } else if (B(childAt)) {
                    childAt.addFocusables(arrayList, i10, i11);
                    z10 = true;
                }
            }
            if (!z10) {
                int size = this.H.size();
                for (int i13 = 0; i13 < size; i13++) {
                    View view = this.H.get(i13);
                    if (view.getVisibility() == 0) {
                        view.addFocusables(arrayList, i10, i11);
                    }
                }
            }
            this.H.clear();
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i10, layoutParams);
        if (n() != null || C(view)) {
            d0.E0(view, 4);
        } else {
            d0.E0(view, 1);
        }
        if (!N) {
            d0.t0(view, this.f2736a);
        }
    }

    public void b(e eVar) {
        if (eVar != null) {
            if (this.f2755t == null) {
                this.f2755t = new ArrayList();
            }
            this.f2755t.add(eVar);
        }
    }

    void c() {
        if (!this.f2753r) {
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                getChildAt(i10).dispatchTouchEvent(obtain);
            }
            obtain.recycle();
            this.f2753r = true;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof f) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        int childCount = getChildCount();
        float f10 = 0.0f;
        for (int i10 = 0; i10 < childCount; i10++) {
            f10 = Math.max(f10, ((f) getChildAt(i10).getLayoutParams()).f2771b);
        }
        this.f2740e = f10;
        boolean m10 = this.f2742g.m(true);
        boolean m11 = this.f2743h.m(true);
        if (m10 || m11) {
            d0.k0(this);
        }
    }

    boolean d(View view, int i10) {
        return (s(view) & i10) == i10;
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.f2740e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        for (int i10 = childCount - 1; i10 >= 0; i10--) {
            View childAt = getChildAt(i10);
            if (E(x10, y10, childAt) && !A(childAt) && l(motionEvent, childAt)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    protected boolean drawChild(Canvas canvas, View view, long j10) {
        int i10;
        int height = getHeight();
        boolean A = A(view);
        int width = getWidth();
        int save = canvas.save();
        int i11 = 0;
        if (A) {
            int childCount = getChildCount();
            int i12 = 0;
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                if (childAt != view && childAt.getVisibility() == 0 && w(childAt) && C(childAt) && childAt.getHeight() >= height) {
                    if (d(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i12) {
                            i12 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i12, 0, width, getHeight());
            i11 = i12;
        }
        boolean drawChild = super.drawChild(canvas, view, j10);
        canvas.restoreToCount(save);
        float f10 = this.f2740e;
        if (f10 > 0.0f && A) {
            this.f2741f.setColor((this.f2739d & 16777215) | (((int) ((((-16777216) & i10) >>> 24) * f10)) << 24));
            canvas.drawRect(i11, 0.0f, width, getHeight(), this.f2741f);
        } else if (this.f2759x != null && d(view, 3)) {
            int intrinsicWidth = this.f2759x.getIntrinsicWidth();
            int right2 = view.getRight();
            float max = Math.max(0.0f, Math.min(right2 / this.f2742g.x(), 1.0f));
            this.f2759x.setBounds(right2, view.getTop(), intrinsicWidth + right2, view.getBottom());
            this.f2759x.setAlpha((int) (max * 255.0f));
            this.f2759x.draw(canvas);
        } else if (this.f2760y != null && d(view, 5)) {
            int intrinsicWidth2 = this.f2760y.getIntrinsicWidth();
            int left2 = view.getLeft();
            float max2 = Math.max(0.0f, Math.min((getWidth() - left2) / this.f2743h.x(), 1.0f));
            this.f2760y.setBounds(left2 - intrinsicWidth2, view.getTop(), left2, view.getBottom());
            this.f2760y.setAlpha((int) (max2 * 255.0f));
            this.f2760y.draw(canvas);
        }
        return drawChild;
    }

    public void e(View view) {
        f(view, true);
    }

    public void f(View view, boolean z10) {
        if (C(view)) {
            f fVar = (f) view.getLayoutParams();
            if (this.f2748m) {
                fVar.f2771b = 0.0f;
                fVar.f2773d = 0;
            } else if (z10) {
                fVar.f2773d |= 4;
                if (d(view, 3)) {
                    this.f2742g.Q(view, -view.getWidth(), view.getTop());
                } else {
                    this.f2743h.Q(view, getWidth(), view.getTop());
                }
            } else {
                G(view, 0.0f);
                U(0, view);
                view.setVisibility(4);
            }
            invalidate();
            return;
        }
        throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
    }

    public void g() {
        h(false);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new f(-1, -1);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof f) {
            return new f((f) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    public float getDrawerElevation() {
        if (O) {
            return this.f2737b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.f2758w;
    }

    void h(boolean z10) {
        boolean z11;
        int childCount = getChildCount();
        boolean z12 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            f fVar = (f) childAt.getLayoutParams();
            if (C(childAt) && (!z10 || fVar.f2772c)) {
                int width = childAt.getWidth();
                if (d(childAt, 3)) {
                    z11 = this.f2742g.Q(childAt, -width, childAt.getTop());
                } else {
                    z11 = this.f2743h.Q(childAt, getWidth(), childAt.getTop());
                }
                z12 |= z11;
                fVar.f2772c = false;
            }
        }
        this.f2744i.p();
        this.f2745j.p();
        if (z12) {
            invalidate();
        }
    }

    void i(View view) {
        View rootView;
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f2773d & 1) == 1) {
            fVar.f2773d = 0;
            List<e> list = this.f2755t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2755t.get(size).b(view);
                }
            }
            T(view, false);
            S(view);
            if (hasWindowFocus() && (rootView = getRootView()) != null) {
                rootView.sendAccessibilityEvent(32);
            }
        }
    }

    void j(View view) {
        f fVar = (f) view.getLayoutParams();
        if ((fVar.f2773d & 1) == 0) {
            fVar.f2773d = 1;
            List<e> list = this.f2755t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2755t.get(size).a(view);
                }
            }
            T(view, true);
            S(view);
            if (hasWindowFocus()) {
                sendAccessibilityEvent(32);
            }
        }
    }

    void k(View view, float f10) {
        List<e> list = this.f2755t;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f2755t.get(size).d(view, f10);
            }
        }
    }

    View m(int i10) {
        int b10 = androidx.core.view.f.b(i10, d0.E(this)) & 7;
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if ((s(childAt) & 7) == b10) {
                return childAt;
            }
        }
        return null;
    }

    View n() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if ((((f) childAt.getLayoutParams()).f2773d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    View o() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (C(childAt) && D(childAt)) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2748m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2748m = true;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Object obj;
        super.onDraw(canvas);
        if (this.C && this.f2758w != null) {
            int systemWindowInsetTop = (Build.VERSION.SDK_INT < 21 || (obj = this.B) == null) ? 0 : ((WindowInsets) obj).getSystemWindowInsetTop();
            if (systemWindowInsetTop > 0) {
                this.f2758w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
                this.f2758w.draw(canvas);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
        if (r0 != 3) goto L12;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        View t10;
        int actionMasked = motionEvent.getActionMasked();
        boolean P2 = this.f2742g.P(motionEvent) | this.f2743h.P(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f2742g.d(3)) {
                        this.f2744i.p();
                        this.f2745j.p();
                    }
                }
                z10 = false;
            }
            h(true);
            this.f2753r = false;
            z10 = false;
        } else {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f2756u = x10;
            this.f2757v = y10;
            z10 = this.f2740e > 0.0f && (t10 = this.f2742g.t((int) x10, (int) y10)) != null && A(t10);
            this.f2753r = false;
        }
        return P2 || z10 || x() || this.f2753r;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (i10 != 4 || !y()) {
            return super.onKeyDown(i10, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i10, KeyEvent keyEvent) {
        if (i10 != 4) {
            return super.onKeyUp(i10, keyEvent);
        }
        View o10 = o();
        if (o10 != null && q(o10) == 0) {
            g();
        }
        return o10 != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        WindowInsets rootWindowInsets;
        float f10;
        int i14;
        int i15;
        boolean z11 = true;
        this.f2747l = true;
        int i16 = i12 - i10;
        int childCount = getChildCount();
        int i17 = 0;
        while (i17 < childCount) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (A(childAt)) {
                    int i18 = ((ViewGroup.MarginLayoutParams) fVar).leftMargin;
                    childAt.layout(i18, ((ViewGroup.MarginLayoutParams) fVar).topMargin, childAt.getMeasuredWidth() + i18, ((ViewGroup.MarginLayoutParams) fVar).topMargin + childAt.getMeasuredHeight());
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (d(childAt, 3)) {
                        float f11 = measuredWidth;
                        i14 = (-measuredWidth) + ((int) (fVar.f2771b * f11));
                        f10 = (measuredWidth + i14) / f11;
                    } else {
                        float f12 = measuredWidth;
                        f10 = (i16 - i15) / f12;
                        i14 = i16 - ((int) (fVar.f2771b * f12));
                    }
                    boolean z12 = f10 != fVar.f2771b ? z11 : false;
                    int i19 = fVar.f2770a & 112;
                    if (i19 == 16) {
                        int i20 = i13 - i11;
                        int i21 = (i20 - measuredHeight) / 2;
                        int i22 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        if (i21 < i22) {
                            i21 = i22;
                        } else {
                            int i23 = i21 + measuredHeight;
                            int i24 = ((ViewGroup.MarginLayoutParams) fVar).bottomMargin;
                            if (i23 > i20 - i24) {
                                i21 = (i20 - i24) - measuredHeight;
                            }
                        }
                        childAt.layout(i14, i21, measuredWidth + i14, measuredHeight + i21);
                    } else if (i19 != 80) {
                        int i25 = ((ViewGroup.MarginLayoutParams) fVar).topMargin;
                        childAt.layout(i14, i25, measuredWidth + i14, measuredHeight + i25);
                    } else {
                        int i26 = i13 - i11;
                        childAt.layout(i14, (i26 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i14, i26 - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin);
                    }
                    if (z12) {
                        R(childAt, f10);
                    }
                    int i27 = fVar.f2771b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i27) {
                        childAt.setVisibility(i27);
                    }
                }
            }
            i17++;
            z11 = true;
        }
        if (P && (rootWindowInsets = getRootWindowInsets()) != null) {
            b0.b i28 = n0.w(rootWindowInsets).i();
            o0.d dVar = this.f2742g;
            dVar.L(Math.max(dVar.w(), i28.f4959a));
            o0.d dVar2 = this.f2743h;
            dVar2.L(Math.max(dVar2.w(), i28.f4961c));
        }
        this.f2747l = false;
        this.f2748m = false;
    }

    @Override // android.view.View
    @SuppressLint({"WrongConstant"})
    protected void onMeasure(int i10, int i11) {
        int s10;
        int mode = View.MeasureSpec.getMode(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        if (!(mode == 1073741824 && mode2 == 1073741824)) {
            if (isInEditMode()) {
                if (mode == 0) {
                    size = 300;
                }
                if (mode2 == 0) {
                    size2 = 300;
                }
            } else {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
        }
        setMeasuredDimension(size, size2);
        int i12 = 0;
        boolean z10 = this.B != null && d0.B(this);
        int E = d0.E(this);
        int childCount = getChildCount();
        int i13 = 0;
        boolean z11 = false;
        boolean z12 = false;
        while (i13 < childCount) {
            View childAt = getChildAt(i13);
            if (childAt.getVisibility() != 8) {
                f fVar = (f) childAt.getLayoutParams();
                if (z10) {
                    int b10 = androidx.core.view.f.b(fVar.f2770a, E);
                    if (d0.B(childAt)) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            WindowInsets windowInsets = (WindowInsets) this.B;
                            if (b10 == 3) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), i12, windowInsets.getSystemWindowInsetBottom());
                            } else if (b10 == 5) {
                                windowInsets = windowInsets.replaceSystemWindowInsets(i12, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                            }
                            childAt.dispatchApplyWindowInsets(windowInsets);
                        }
                    } else if (Build.VERSION.SDK_INT >= 21) {
                        WindowInsets windowInsets2 = (WindowInsets) this.B;
                        if (b10 == 3) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), i12, windowInsets2.getSystemWindowInsetBottom());
                        } else if (b10 == 5) {
                            windowInsets2 = windowInsets2.replaceSystemWindowInsets(i12, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                        }
                        ((ViewGroup.MarginLayoutParams) fVar).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                        ((ViewGroup.MarginLayoutParams) fVar).topMargin = windowInsets2.getSystemWindowInsetTop();
                        ((ViewGroup.MarginLayoutParams) fVar).rightMargin = windowInsets2.getSystemWindowInsetRight();
                        ((ViewGroup.MarginLayoutParams) fVar).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                    }
                }
                if (A(childAt)) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) fVar).leftMargin) - ((ViewGroup.MarginLayoutParams) fVar).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) fVar).topMargin) - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, 1073741824));
                } else if (C(childAt)) {
                    if (O) {
                        float y10 = d0.y(childAt);
                        float f10 = this.f2737b;
                        if (y10 != f10) {
                            d0.B0(childAt, f10);
                        }
                    }
                    int i14 = (s(childAt) & 7) == 3 ? 1 : i12;
                    if ((i14 == 0 || !z11) && (i14 != 0 || !z12)) {
                        if (i14 != 0) {
                            z11 = true;
                        } else {
                            z12 = true;
                        }
                        childAt.measure(ViewGroup.getChildMeasureSpec(i10, this.f2738c + ((ViewGroup.MarginLayoutParams) fVar).leftMargin + ((ViewGroup.MarginLayoutParams) fVar).rightMargin, ((ViewGroup.MarginLayoutParams) fVar).width), ViewGroup.getChildMeasureSpec(i11, ((ViewGroup.MarginLayoutParams) fVar).topMargin + ((ViewGroup.MarginLayoutParams) fVar).bottomMargin, ((ViewGroup.MarginLayoutParams) fVar).height));
                        i13++;
                        i12 = 0;
                    } else {
                        throw new IllegalStateException("Child drawer has absolute gravity " + v(s10) + " but this DrawerLayout already has a drawer view along that edge");
                    }
                } else {
                    throw new IllegalStateException("Child " + childAt + " at index " + i13 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                }
            }
            i13++;
            i12 = 0;
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        View m10;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        int i10 = savedState.f2762c;
        if (!(i10 == 0 || (m10 = m(i10)) == null)) {
            J(m10);
        }
        int i11 = savedState.f2763d;
        if (i11 != 3) {
            Q(i11, 3);
        }
        int i12 = savedState.f2764e;
        if (i12 != 3) {
            Q(i12, 5);
        }
        int i13 = savedState.f2765f;
        if (i13 != 3) {
            Q(i13, 8388611);
        }
        int i14 = savedState.f2766g;
        if (i14 != 3) {
            Q(i14, 8388613);
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        O();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            f fVar = (f) getChildAt(i10).getLayoutParams();
            int i11 = fVar.f2773d;
            boolean z10 = true;
            boolean z11 = i11 == 1;
            if (i11 != 2) {
                z10 = false;
            }
            if (z11 || z10) {
                savedState.f2762c = fVar.f2770a;
                break;
            }
        }
        savedState.f2763d = this.f2749n;
        savedState.f2764e = this.f2750o;
        savedState.f2765f = this.f2751p;
        savedState.f2766g = this.f2752q;
        return savedState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
        if (q(r7) != 2) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f2742g.F(motionEvent);
        this.f2743h.F(motionEvent);
        int action = motionEvent.getAction() & 255;
        boolean z10 = false;
        if (action == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            this.f2756u = x10;
            this.f2757v = y10;
            this.f2753r = false;
        } else if (action == 1) {
            float x11 = motionEvent.getX();
            float y11 = motionEvent.getY();
            View t10 = this.f2742g.t((int) x11, (int) y11);
            if (t10 != null && A(t10)) {
                float f10 = x11 - this.f2756u;
                float f11 = y11 - this.f2757v;
                int z11 = this.f2742g.z();
                if ((f10 * f10) + (f11 * f11) < z11 * z11) {
                    View n10 = n();
                    if (n10 != null) {
                    }
                }
            }
            z10 = true;
            h(z10);
        } else if (action == 3) {
            h(true);
            this.f2753r = false;
        }
        return true;
    }

    public int p(int i10) {
        int E = d0.E(this);
        if (i10 == 3) {
            int i11 = this.f2749n;
            if (i11 != 3) {
                return i11;
            }
            int i12 = E == 0 ? this.f2751p : this.f2752q;
            if (i12 != 3) {
                return i12;
            }
            return 0;
        } else if (i10 == 5) {
            int i13 = this.f2750o;
            if (i13 != 3) {
                return i13;
            }
            int i14 = E == 0 ? this.f2752q : this.f2751p;
            if (i14 != 3) {
                return i14;
            }
            return 0;
        } else if (i10 == 8388611) {
            int i15 = this.f2751p;
            if (i15 != 3) {
                return i15;
            }
            int i16 = E == 0 ? this.f2749n : this.f2750o;
            if (i16 != 3) {
                return i16;
            }
            return 0;
        } else if (i10 != 8388613) {
            return 0;
        } else {
            int i17 = this.f2752q;
            if (i17 != 3) {
                return i17;
            }
            int i18 = E == 0 ? this.f2750o : this.f2749n;
            if (i18 != 3) {
                return i18;
            }
            return 0;
        }
    }

    public int q(View view) {
        if (C(view)) {
            return p(((f) view.getLayoutParams()).f2770a);
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public CharSequence r(int i10) {
        int b10 = androidx.core.view.f.b(i10, d0.E(this));
        if (b10 == 3) {
            return this.f2761z;
        }
        if (b10 == 5) {
            return this.A;
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z10) {
        super.requestDisallowInterceptTouchEvent(z10);
        if (z10) {
            h(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (!this.f2747l) {
            super.requestLayout();
        }
    }

    int s(View view) {
        return androidx.core.view.f.b(((f) view.getLayoutParams()).f2770a, d0.E(this));
    }

    public void setDrawerElevation(float f10) {
        this.f2737b = f10;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (C(childAt)) {
                d0.B0(childAt, this.f2737b);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(e eVar) {
        e eVar2 = this.f2754s;
        if (eVar2 != null) {
            L(eVar2);
        }
        if (eVar != null) {
            b(eVar);
        }
        this.f2754s = eVar;
    }

    public void setDrawerLockMode(int i10) {
        Q(i10, 3);
        Q(i10, 5);
    }

    public void setScrimColor(int i10) {
        this.f2739d = i10;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.f2758w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i10) {
        this.f2758w = new ColorDrawable(i10);
        invalidate();
    }

    float t(View view) {
        return ((f) view.getLayoutParams()).f2771b;
    }

    /* JADX WARN: Finally extract failed */
    public DrawerLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        TypedArray obtainStyledAttributes;
        this.f2736a = new d();
        this.f2739d = -1728053248;
        this.f2741f = new Paint();
        this.f2748m = true;
        this.f2749n = 3;
        this.f2750o = 3;
        this.f2751p = 3;
        this.f2752q = 3;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.K = new a();
        setDescendantFocusability(262144);
        float f10 = getResources().getDisplayMetrics().density;
        this.f2738c = (int) ((64.0f * f10) + 0.5f);
        float f11 = f10 * 400.0f;
        g gVar = new g(3);
        this.f2744i = gVar;
        g gVar2 = new g(5);
        this.f2745j = gVar2;
        o0.d n10 = o0.d.n(this, 1.0f, gVar);
        this.f2742g = n10;
        n10.M(1);
        n10.N(f11);
        gVar.q(n10);
        o0.d n11 = o0.d.n(this, 1.0f, gVar2);
        this.f2743h = n11;
        n11.M(2);
        n11.N(f11);
        gVar2.q(n11);
        setFocusableInTouchMode(true);
        d0.E0(this, 1);
        d0.t0(this, new c());
        setMotionEventSplittingEnabled(false);
        if (d0.B(this)) {
            if (Build.VERSION.SDK_INT >= 21) {
                setOnApplyWindowInsetsListener(new b(this));
                setSystemUiVisibility(1280);
                obtainStyledAttributes = context.obtainStyledAttributes(L);
                try {
                    this.f2758w = obtainStyledAttributes.getDrawable(0);
                    obtainStyledAttributes.recycle();
                } catch (Throwable th2) {
                    throw th2;
                }
            } else {
                this.f2758w = null;
            }
        }
        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r0.c.f33284a, i10, 0);
        try {
            int i11 = r0.c.f33285b;
            if (obtainStyledAttributes.hasValue(i11)) {
                this.f2737b = obtainStyledAttributes.getDimension(i11, 0.0f);
            } else {
                this.f2737b = getResources().getDimension(r0.b.f33283a);
            }
            obtainStyledAttributes.recycle();
            this.H = new ArrayList<>();
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public void setStatusBarBackground(int i10) {
        this.f2758w = i10 != 0 ? androidx.core.content.b.e(getContext(), i10) : null;
        invalidate();
    }

    /* loaded from: classes.dex */
    public static class f extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2770a;

        /* renamed from: b  reason: collision with root package name */
        float f2771b;

        /* renamed from: c  reason: collision with root package name */
        boolean f2772c;

        /* renamed from: d  reason: collision with root package name */
        int f2773d;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2770a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, DrawerLayout.M);
            this.f2770a = obtainStyledAttributes.getInt(0, 0);
            obtainStyledAttributes.recycle();
        }

        public f(int i10, int i11) {
            super(i10, i11);
            this.f2770a = 0;
        }

        public f(f fVar) {
            super((ViewGroup.MarginLayoutParams) fVar);
            this.f2770a = 0;
            this.f2770a = fVar.f2770a;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2770a = 0;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f2770a = 0;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f2762c;

        /* renamed from: d  reason: collision with root package name */
        int f2763d;

        /* renamed from: e  reason: collision with root package name */
        int f2764e;

        /* renamed from: f  reason: collision with root package name */
        int f2765f;

        /* renamed from: g  reason: collision with root package name */
        int f2766g;

        /* loaded from: classes.dex */
        class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: b */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: c */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2762c = 0;
            this.f2762c = parcel.readInt();
            this.f2763d = parcel.readInt();
            this.f2764e = parcel.readInt();
            this.f2765f = parcel.readInt();
            this.f2766g = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f2762c);
            parcel.writeInt(this.f2763d);
            parcel.writeInt(this.f2764e);
            parcel.writeInt(this.f2765f);
            parcel.writeInt(this.f2766g);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
            this.f2762c = 0;
        }
    }
}
