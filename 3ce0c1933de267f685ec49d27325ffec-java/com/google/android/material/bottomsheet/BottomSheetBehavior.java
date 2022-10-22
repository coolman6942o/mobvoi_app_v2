package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import androidx.core.view.n0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.m;
import d7.j;
import d7.k;
import d7.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import k0.c;
import k0.f;
import o0.d;
/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.c<V> {
    private static final int Z = k.f25345j;
    int A;
    float B;
    int C;
    float D;
    boolean E;
    private boolean F;
    private boolean G;
    int H;
    o0.d I;
    private boolean J;
    private int K;
    private boolean L;
    private int M;
    int N;
    int O;
    WeakReference<V> P;
    WeakReference<View> Q;
    private final ArrayList<f> R;
    private VelocityTracker S;
    int T;
    private int U;
    boolean V;
    private Map<View, Integer> W;
    private int X;
    private final d.c Y;

    /* renamed from: a  reason: collision with root package name */
    private int f10508a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10509b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10510c;

    /* renamed from: d  reason: collision with root package name */
    private float f10511d;

    /* renamed from: e  reason: collision with root package name */
    private int f10512e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10513f;

    /* renamed from: g  reason: collision with root package name */
    private int f10514g;

    /* renamed from: h  reason: collision with root package name */
    private int f10515h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10516i;

    /* renamed from: j  reason: collision with root package name */
    private w7.g f10517j;

    /* renamed from: k  reason: collision with root package name */
    private int f10518k;

    /* renamed from: l  reason: collision with root package name */
    private int f10519l;

    /* renamed from: m  reason: collision with root package name */
    private int f10520m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10521n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10522o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f10523p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f10524q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10525r;

    /* renamed from: s  reason: collision with root package name */
    private int f10526s;

    /* renamed from: t  reason: collision with root package name */
    private int f10527t;

    /* renamed from: u  reason: collision with root package name */
    private w7.k f10528u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f10529v;

    /* renamed from: w  reason: collision with root package name */
    private BottomSheetBehavior<V>.g f10530w;

    /* renamed from: x  reason: collision with root package name */
    private ValueAnimator f10531x;

    /* renamed from: y  reason: collision with root package name */
    int f10532y;

    /* renamed from: z  reason: collision with root package name */
    int f10533z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f10539a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10540b;

        a(View view, int i10) {
            this.f10539a = view;
            this.f10540b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.D0(this.f10539a, this.f10540b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f10517j != null) {
                BottomSheetBehavior.this.f10517j.a0(floatValue);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements m.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f10543a;

        c(boolean z10) {
            this.f10543a = z10;
        }

        @Override // com.google.android.material.internal.m.d
        public n0 a(View view, n0 n0Var, m.e eVar) {
            BottomSheetBehavior.this.f10527t = n0Var.m();
            boolean d10 = m.d(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.f10522o) {
                BottomSheetBehavior.this.f10526s = n0Var.j();
                paddingBottom = eVar.f11103d + BottomSheetBehavior.this.f10526s;
            }
            if (BottomSheetBehavior.this.f10523p) {
                paddingLeft = (d10 ? eVar.f11102c : eVar.f11100a) + n0Var.k();
            }
            if (BottomSheetBehavior.this.f10524q) {
                paddingRight = (d10 ? eVar.f11100a : eVar.f11102c) + n0Var.l();
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.f10543a) {
                BottomSheetBehavior.this.f10520m = n0Var.g().f4962d;
            }
            if (BottomSheetBehavior.this.f10522o || this.f10543a) {
                BottomSheetBehavior.this.O0(false);
            }
            return n0Var;
        }
    }

    /* loaded from: classes.dex */
    class d extends d.c {

        /* renamed from: a  reason: collision with root package name */
        private long f10545a;

        d() {
        }

        private boolean n(View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.O + bottomSheetBehavior.e0()) / 2;
        }

        @Override // o0.d.c
        public int a(View view, int i10, int i11) {
            return view.getLeft();
        }

        @Override // o0.d.c
        public int b(View view, int i10, int i11) {
            int e02 = BottomSheetBehavior.this.e0();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return e0.a.b(i10, e02, bottomSheetBehavior.E ? bottomSheetBehavior.O : bottomSheetBehavior.C);
        }

        @Override // o0.d.c
        public int e(View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.E) {
                return bottomSheetBehavior.O;
            }
            return bottomSheetBehavior.C;
        }

        @Override // o0.d.c
        public void j(int i10) {
            if (i10 == 1 && BottomSheetBehavior.this.G) {
                BottomSheetBehavior.this.B0(1);
            }
        }

        @Override // o0.d.c
        public void k(View view, int i10, int i11, int i12, int i13) {
            BottomSheetBehavior.this.a0(i11);
        }

        @Override // o0.d.c
        public void l(View view, float f10, float f11) {
            int i10;
            int i11 = 6;
            i11 = 3;
            i11 = 4;
            if (f11 >= 0.0f) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                if (!bottomSheetBehavior.E || !bottomSheetBehavior.H0(view, f11)) {
                    if (f11 == 0.0f || Math.abs(f10) > Math.abs(f11)) {
                        int top = view.getTop();
                        if (!BottomSheetBehavior.this.f10509b) {
                            BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                            int i12 = bottomSheetBehavior2.A;
                            if (top < i12) {
                                if (top < Math.abs(top - bottomSheetBehavior2.C)) {
                                    i10 = BottomSheetBehavior.this.e0();
                                } else if (BottomSheetBehavior.this.I0()) {
                                    i10 = BottomSheetBehavior.this.C;
                                } else {
                                    i10 = BottomSheetBehavior.this.A;
                                }
                            } else if (Math.abs(top - i12) >= Math.abs(top - BottomSheetBehavior.this.C)) {
                                i10 = BottomSheetBehavior.this.C;
                            } else if (BottomSheetBehavior.this.I0()) {
                                i10 = BottomSheetBehavior.this.C;
                            } else {
                                i10 = BottomSheetBehavior.this.A;
                            }
                        } else if (Math.abs(top - BottomSheetBehavior.this.f10533z) < Math.abs(top - BottomSheetBehavior.this.C)) {
                            i10 = BottomSheetBehavior.this.f10533z;
                        } else {
                            i10 = BottomSheetBehavior.this.C;
                        }
                    } else if (BottomSheetBehavior.this.f10509b) {
                        i10 = BottomSheetBehavior.this.C;
                    } else {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - BottomSheetBehavior.this.A) >= Math.abs(top2 - BottomSheetBehavior.this.C)) {
                            i10 = BottomSheetBehavior.this.C;
                        } else if (BottomSheetBehavior.this.I0()) {
                            i10 = BottomSheetBehavior.this.C;
                        } else {
                            i10 = BottomSheetBehavior.this.A;
                        }
                    }
                } else if ((Math.abs(f10) < Math.abs(f11) && f11 > 500.0f) || n(view)) {
                    i10 = BottomSheetBehavior.this.O;
                    i11 = 5;
                } else if (BottomSheetBehavior.this.f10509b) {
                    i10 = BottomSheetBehavior.this.f10533z;
                } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.e0()) < Math.abs(view.getTop() - BottomSheetBehavior.this.A)) {
                    i10 = BottomSheetBehavior.this.e0();
                } else {
                    i10 = BottomSheetBehavior.this.A;
                }
            } else if (BottomSheetBehavior.this.f10509b) {
                i10 = BottomSheetBehavior.this.f10533z;
            } else {
                int top3 = view.getTop();
                long currentTimeMillis = System.currentTimeMillis() - this.f10545a;
                if (BottomSheetBehavior.this.I0()) {
                    BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                    if (bottomSheetBehavior3.F0(currentTimeMillis, (top3 * 100.0f) / bottomSheetBehavior3.O)) {
                        i10 = BottomSheetBehavior.this.f10532y;
                    } else {
                        i10 = BottomSheetBehavior.this.C;
                    }
                } else {
                    BottomSheetBehavior bottomSheetBehavior4 = BottomSheetBehavior.this;
                    int i13 = bottomSheetBehavior4.A;
                    if (top3 > i13) {
                        i10 = i13;
                    } else {
                        i10 = bottomSheetBehavior4.e0();
                    }
                }
            }
            BottomSheetBehavior bottomSheetBehavior5 = BottomSheetBehavior.this;
            bottomSheetBehavior5.K0(view, i11, i10, bottomSheetBehavior5.J0());
        }

        @Override // o0.d.c
        public boolean m(View view, int i10) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i11 = bottomSheetBehavior.H;
            if (i11 == 1 || bottomSheetBehavior.V) {
                return false;
            }
            if (i11 == 3 && bottomSheetBehavior.T == i10) {
                WeakReference<View> weakReference = bottomSheetBehavior.Q;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.f10545a = System.currentTimeMillis();
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.P;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements k0.f {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f10547a;

        e(int i10) {
            this.f10547a = i10;
        }

        @Override // k0.f
        public boolean a(View view, f.a aVar) {
            BottomSheetBehavior.this.A0(this.f10547a);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract void a(View view, float f10);

        public abstract void b(View view, int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final View f10549a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10550b;

        /* renamed from: c  reason: collision with root package name */
        int f10551c;

        g(View view, int i10) {
            this.f10549a = view;
            this.f10551c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            o0.d dVar = BottomSheetBehavior.this.I;
            if (dVar == null || !dVar.m(true)) {
                BottomSheetBehavior.this.B0(this.f10551c);
            } else {
                d0.l0(this.f10549a, this);
            }
            this.f10550b = false;
        }
    }

    public BottomSheetBehavior() {
        this.f10508a = 0;
        this.f10509b = true;
        this.f10510c = false;
        this.f10518k = -1;
        this.f10519l = -1;
        this.f10530w = null;
        this.B = 0.5f;
        this.D = -1.0f;
        this.G = true;
        this.H = 4;
        this.R = new ArrayList<>();
        this.X = -1;
        this.Y = new d();
    }

    private void C0(View view) {
        boolean z10 = Build.VERSION.SDK_INT >= 29 && !i0() && !this.f10513f;
        if (this.f10522o || this.f10523p || this.f10524q || z10) {
            m.a(view, new c(z10));
        }
    }

    private void E0(int i10) {
        V v10 = this.P.get();
        if (v10 != null) {
            ViewParent parent = v10.getParent();
            if (parent == null || !parent.isLayoutRequested() || !d0.W(v10)) {
                D0(v10, i10);
            } else {
                v10.post(new a(v10, i10));
            }
        }
    }

    private boolean G0() {
        return this.I != null && (this.G || this.H == 1);
    }

    private void L0() {
        V v10;
        WeakReference<V> weakReference = this.P;
        if (weakReference != null && (v10 = weakReference.get()) != null) {
            d0.n0(v10, 524288);
            d0.n0(v10, 262144);
            d0.n0(v10, 1048576);
            int i10 = this.X;
            if (i10 != -1) {
                d0.n0(v10, i10);
            }
            int i11 = 6;
            if (!this.f10509b && this.H != 6) {
                this.X = R(v10, j.f25310a, 6);
            }
            if (this.E && this.H != 5) {
                l0(v10, c.a.f29702l, 5);
            }
            int i12 = this.H;
            if (i12 == 3) {
                if (this.f10509b) {
                    i11 = 4;
                }
                l0(v10, c.a.f29701k, i11);
            } else if (i12 == 4) {
                if (this.f10509b) {
                    i11 = 3;
                }
                l0(v10, c.a.f29700j, i11);
            } else if (i12 == 6) {
                l0(v10, c.a.f29701k, 4);
                l0(v10, c.a.f29700j, 3);
            }
        }
    }

    private void M0(int i10) {
        ValueAnimator valueAnimator;
        if (i10 != 2) {
            boolean z10 = i10 == 3;
            if (this.f10529v != z10) {
                this.f10529v = z10;
                if (this.f10517j != null && (valueAnimator = this.f10531x) != null) {
                    if (valueAnimator.isRunning()) {
                        this.f10531x.reverse();
                        return;
                    }
                    float f10 = z10 ? 0.0f : 1.0f;
                    this.f10531x.setFloatValues(1.0f - f10, f10);
                    this.f10531x.start();
                }
            }
        }
    }

    private void N0(boolean z10) {
        Map<View, Integer> map;
        WeakReference<V> weakReference = this.P;
        if (weakReference != null) {
            ViewParent parent = weakReference.get().getParent();
            if (parent instanceof CoordinatorLayout) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
                int childCount = coordinatorLayout.getChildCount();
                if (Build.VERSION.SDK_INT >= 16 && z10) {
                    if (this.W == null) {
                        this.W = new HashMap(childCount);
                    } else {
                        return;
                    }
                }
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = coordinatorLayout.getChildAt(i10);
                    if (childAt != this.P.get()) {
                        if (z10) {
                            if (Build.VERSION.SDK_INT >= 16) {
                                this.W.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                            }
                            if (this.f10510c) {
                                d0.E0(childAt, 4);
                            }
                        } else if (this.f10510c && (map = this.W) != null && map.containsKey(childAt)) {
                            d0.E0(childAt, this.W.get(childAt).intValue());
                        }
                    }
                }
                if (!z10) {
                    this.W = null;
                } else if (this.f10510c) {
                    this.P.get().sendAccessibilityEvent(8);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(boolean z10) {
        V v10;
        if (this.P != null) {
            T();
            if (this.H == 4 && (v10 = this.P.get()) != null) {
                if (z10) {
                    E0(this.H);
                } else {
                    v10.requestLayout();
                }
            }
        }
    }

    private int R(V v10, int i10, int i11) {
        return d0.c(v10, v10.getResources().getString(i10), W(i11));
    }

    private void T() {
        int V = V();
        if (this.f10509b) {
            this.C = Math.max(this.O - V, this.f10533z);
        } else {
            this.C = this.O - V;
        }
    }

    private void U() {
        this.A = (int) (this.O * (1.0f - this.B));
    }

    private int V() {
        int i10;
        if (this.f10513f) {
            return Math.min(Math.max(this.f10514g, this.O - ((this.N * 9) / 16)), this.M) + this.f10526s;
        }
        if (this.f10521n || this.f10522o || (i10 = this.f10520m) <= 0) {
            return this.f10512e + this.f10526s;
        }
        return Math.max(this.f10512e, i10 + this.f10515h);
    }

    private k0.f W(int i10) {
        return new e(i10);
    }

    private void X(Context context, AttributeSet attributeSet, boolean z10) {
        Y(context, attributeSet, z10, null);
    }

    private void Y(Context context, AttributeSet attributeSet, boolean z10, ColorStateList colorStateList) {
        if (this.f10516i) {
            this.f10528u = w7.k.e(context, attributeSet, d7.b.f25151g, Z).m();
            w7.g gVar = new w7.g(this.f10528u);
            this.f10517j = gVar;
            gVar.O(context);
            if (!z10 || colorStateList == null) {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(16842801, typedValue, true);
                this.f10517j.setTint(typedValue.data);
                return;
            }
            this.f10517j.Z(colorStateList);
        }
    }

    private void Z() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f10531x = ofFloat;
        ofFloat.setDuration(500L);
        this.f10531x.addUpdateListener(new b());
    }

    public static <V extends View> BottomSheetBehavior<V> c0(V v10) {
        ViewGroup.LayoutParams layoutParams = v10.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.f) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) layoutParams).f();
            if (f10 instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) f10;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    private int d0(int i10, int i11, int i12, int i13) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, i11, i13);
        if (i12 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i12), 1073741824);
        }
        if (size != 0) {
            i12 = Math.min(size, i12);
        }
        return View.MeasureSpec.makeMeasureSpec(i12, Integer.MIN_VALUE);
    }

    private float h0() {
        VelocityTracker velocityTracker = this.S;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f10511d);
        return this.S.getYVelocity(this.T);
    }

    private void l0(V v10, c.a aVar, int i10) {
        d0.p0(v10, aVar, null, W(i10));
    }

    private void m0() {
        this.T = -1;
        VelocityTracker velocityTracker = this.S;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.S = null;
        }
    }

    private void n0(SavedState savedState) {
        int i10 = this.f10508a;
        if (i10 != 0) {
            if (i10 == -1 || (i10 & 1) == 1) {
                this.f10512e = savedState.f10535d;
            }
            if (i10 == -1 || (i10 & 2) == 2) {
                this.f10509b = savedState.f10536e;
            }
            if (i10 == -1 || (i10 & 4) == 4) {
                this.E = savedState.f10537f;
            }
            if (i10 == -1 || (i10 & 8) == 8) {
                this.F = savedState.f10538g;
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        this.K = 0;
        this.L = false;
        return (i10 & 2) != 0;
    }

    public void A0(int i10) {
        if (i10 != this.H) {
            if (this.P != null) {
                E0(i10);
            } else if (i10 == 4 || i10 == 3 || i10 == 6 || (this.E && i10 == 5)) {
                this.H = i10;
            }
        }
    }

    void B0(int i10) {
        V v10;
        if (this.H != i10) {
            this.H = i10;
            if (!(i10 == 4 || i10 == 3 || i10 == 6)) {
                boolean z10 = this.E;
            }
            WeakReference<V> weakReference = this.P;
            if (!(weakReference == null || (v10 = weakReference.get()) == null)) {
                if (i10 == 3) {
                    N0(true);
                } else if (i10 == 6 || i10 == 5 || i10 == 4) {
                    N0(false);
                }
                M0(i10);
                for (int i11 = 0; i11 < this.R.size(); i11++) {
                    this.R.get(i11).b(v10, i10);
                }
                L0();
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void C(CoordinatorLayout coordinatorLayout, V v10, View view, int i10) {
        int i11;
        WeakReference<View> weakReference;
        int i12 = 3;
        if (v10.getTop() == e0()) {
            B0(3);
        } else if (!j0() || ((weakReference = this.Q) != null && view == weakReference.get() && this.L)) {
            i12 = 4;
            if (this.K > 0) {
                if (this.f10509b) {
                    i11 = this.f10533z;
                } else {
                    int top = v10.getTop();
                    int i13 = this.A;
                    if (top > i13) {
                        i12 = 6;
                        i11 = i13;
                    } else {
                        i11 = e0();
                    }
                }
            } else if (this.E && H0(v10, h0())) {
                i11 = this.O;
                i12 = 5;
            } else if (this.K == 0) {
                int top2 = v10.getTop();
                if (!this.f10509b) {
                    int i14 = this.A;
                    if (top2 < i14) {
                        if (top2 < Math.abs(top2 - this.C)) {
                            i11 = e0();
                        } else if (I0()) {
                            i11 = this.C;
                        } else {
                            i11 = this.A;
                            i12 = 6;
                        }
                    } else if (Math.abs(top2 - i14) < Math.abs(top2 - this.C)) {
                        i11 = this.A;
                        i12 = 6;
                    } else {
                        i11 = this.C;
                    }
                } else if (Math.abs(top2 - this.f10533z) < Math.abs(top2 - this.C)) {
                    i11 = this.f10533z;
                } else {
                    i11 = this.C;
                }
            } else if (this.f10509b) {
                i11 = this.C;
            } else {
                int top3 = v10.getTop();
                if (Math.abs(top3 - this.A) < Math.abs(top3 - this.C)) {
                    i11 = this.A;
                    i12 = 6;
                } else {
                    i11 = this.C;
                }
            }
            K0(v10, i12, i11, false);
            this.L = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean D(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        if (!v10.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.H == 1 && actionMasked == 0) {
            return true;
        }
        if (G0()) {
            this.I.F(motionEvent);
        }
        if (actionMasked == 0) {
            m0();
        }
        if (this.S == null) {
            this.S = VelocityTracker.obtain();
        }
        this.S.addMovement(motionEvent);
        if (G0() && actionMasked == 2 && !this.J && Math.abs(this.U - motionEvent.getY()) > this.I.z()) {
            this.I.b(v10, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.J;
    }

    void D0(View view, int i10) {
        int i11;
        int i12;
        if (i10 == 4) {
            i11 = this.C;
        } else if (i10 == 6) {
            int i13 = this.A;
            if (!this.f10509b || i13 > (i12 = this.f10533z)) {
                i11 = i13;
            } else {
                i10 = 3;
                i11 = i12;
            }
        } else if (i10 == 3) {
            i11 = e0();
        } else if (!this.E || i10 != 5) {
            Log.w("BottomSheetBehavior", "The bottom sheet may be in an invalid state. Ensure `hideable` is true when using `STATE_HIDDEN`.");
            return;
        } else {
            i11 = this.O;
        }
        K0(view, i10, i11, false);
    }

    public boolean F0(long j10, float f10) {
        return false;
    }

    boolean H0(View view, float f10) {
        if (this.F) {
            return true;
        }
        if (view.getTop() < this.C) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f10 * 0.1f)) - ((float) this.C)) / ((float) V()) > 0.5f;
    }

    public boolean I0() {
        return false;
    }

    public boolean J0() {
        return true;
    }

    void K0(View view, int i10, int i11, boolean z10) {
        o0.d dVar = this.I;
        if (dVar != null && (!z10 ? dVar.Q(view, view.getLeft(), i11) : dVar.O(view.getLeft(), i11))) {
            B0(2);
            M0(i10);
            if (this.f10530w == null) {
                this.f10530w = new g(view, i10);
            }
            if (!((g) this.f10530w).f10550b) {
                BottomSheetBehavior<V>.g gVar = this.f10530w;
                gVar.f10551c = i10;
                d0.l0(view, gVar);
                ((g) this.f10530w).f10550b = true;
                return;
            }
            this.f10530w.f10551c = i10;
            return;
        }
        B0(i10);
    }

    public void S(f fVar) {
        if (!this.R.contains(fVar)) {
            this.R.add(fVar);
        }
    }

    void a0(int i10) {
        float f10;
        float f11;
        V v10 = this.P.get();
        if (!(v10 == null || this.R.isEmpty())) {
            int i11 = this.C;
            if (i10 > i11 || i11 == e0()) {
                int i12 = this.C;
                f10 = i12 - i10;
                f11 = this.O - i12;
            } else {
                int i13 = this.C;
                f10 = i13 - i10;
                f11 = i13 - e0();
            }
            float f12 = f10 / f11;
            for (int i14 = 0; i14 < this.R.size(); i14++) {
                this.R.get(i14).a(v10, f12);
            }
        }
    }

    View b0(View view) {
        if (d0.Y(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View b02 = b0(viewGroup.getChildAt(i10));
            if (b02 != null) {
                return b02;
            }
        }
        return null;
    }

    public int e0() {
        if (this.f10509b) {
            return this.f10533z;
        }
        return Math.max(this.f10532y, this.f10525r ? 0 : this.f10527t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w7.g f0() {
        return this.f10517j;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        super.g(fVar);
        this.P = null;
        this.I = null;
    }

    public int g0() {
        return this.H;
    }

    public boolean i0() {
        return this.f10521n;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void j() {
        super.j();
        this.P = null;
        this.I = null;
    }

    public boolean j0() {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v10, MotionEvent motionEvent) {
        o0.d dVar;
        if (!v10.isShown() || !this.G) {
            this.J = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            m0();
        }
        if (this.S == null) {
            this.S = VelocityTracker.obtain();
        }
        this.S.addMovement(motionEvent);
        View view = null;
        if (actionMasked == 0) {
            int x10 = (int) motionEvent.getX();
            this.U = (int) motionEvent.getY();
            if (this.H != 2) {
                WeakReference<View> weakReference = this.Q;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && coordinatorLayout.B(view2, x10, this.U)) {
                    this.T = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.V = true;
                }
            }
            this.J = this.T == -1 && !coordinatorLayout.B(v10, x10, this.U);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.V = false;
            this.T = -1;
            if (this.J) {
                this.J = false;
                return false;
            }
        }
        if (!this.J && (dVar = this.I) != null && dVar.P(motionEvent)) {
            return true;
        }
        WeakReference<View> weakReference2 = this.Q;
        if (weakReference2 != null) {
            view = weakReference2.get();
        }
        return actionMasked == 2 && view != null && !this.J && this.H != 1 && !coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY()) && this.I != null && Math.abs(((float) this.U) - motionEvent.getY()) > ((float) this.I.z());
    }

    public void k0(f fVar) {
        this.R.remove(fVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        w7.g gVar;
        if (d0.B(coordinatorLayout) && !d0.B(v10)) {
            v10.setFitsSystemWindows(true);
        }
        if (this.P == null) {
            this.f10514g = coordinatorLayout.getResources().getDimensionPixelSize(d7.d.f25196h);
            C0(v10);
            this.P = new WeakReference<>(v10);
            if (this.f10516i && (gVar = this.f10517j) != null) {
                d0.x0(v10, gVar);
            }
            w7.g gVar2 = this.f10517j;
            if (gVar2 != null) {
                float f10 = this.D;
                if (f10 == -1.0f) {
                    f10 = d0.y(v10);
                }
                gVar2.Y(f10);
                boolean z10 = this.H == 3;
                this.f10529v = z10;
                this.f10517j.a0(z10 ? 0.0f : 1.0f);
            }
            L0();
            if (d0.C(v10) == 0) {
                d0.E0(v10, 1);
            }
        }
        if (this.I == null) {
            this.I = o0.d.o(coordinatorLayout, this.Y);
        }
        int top = v10.getTop();
        coordinatorLayout.I(v10, i10);
        this.N = coordinatorLayout.getWidth();
        this.O = coordinatorLayout.getHeight();
        int height = v10.getHeight();
        this.M = height;
        int i11 = this.O;
        int i12 = i11 - height;
        int i13 = this.f10527t;
        if (i12 < i13) {
            if (this.f10525r) {
                this.M = i11;
            } else {
                this.M = i11 - i13;
            }
        }
        this.f10533z = Math.max(0, i11 - this.M);
        U();
        T();
        int i14 = this.H;
        if (i14 == 3) {
            d0.e0(v10, e0());
        } else if (i14 == 6) {
            d0.e0(v10, this.A);
        } else if (this.E && i14 == 5) {
            d0.e0(v10, this.O);
        } else if (i14 == 4) {
            d0.e0(v10, this.C);
        } else if (i14 == 1 || i14 == 2) {
            d0.e0(v10, top - v10.getTop());
        }
        this.Q = new WeakReference<>(b0(v10));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean m(CoordinatorLayout coordinatorLayout, V v10, int i10, int i11, int i12, int i13) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v10.getLayoutParams();
        v10.measure(d0(i10, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, this.f10518k, marginLayoutParams.width), d0(i12, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, this.f10519l, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean o(CoordinatorLayout coordinatorLayout, V v10, View view, float f10, float f11) {
        WeakReference<View> weakReference;
        if (!j0() || (weakReference = this.Q) == null || view != weakReference.get()) {
            return false;
        }
        return this.H != 3 || super.o(coordinatorLayout, v10, view, f10, f11);
    }

    public void o0(boolean z10) {
        this.G = z10;
    }

    public void p0(int i10) {
        if (i10 >= 0) {
            this.f10532y = i10;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void q(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 != 1) {
            WeakReference<View> weakReference = this.Q;
            View view2 = weakReference != null ? weakReference.get() : null;
            if (!j0() || view == view2) {
                int top = v10.getTop();
                int i13 = top - i11;
                if (i11 > 0) {
                    if (i13 < e0()) {
                        iArr[1] = top - e0();
                        d0.e0(v10, -iArr[1]);
                        B0(3);
                    } else if (this.G) {
                        iArr[1] = i11;
                        d0.e0(v10, -i11);
                        B0(1);
                    } else {
                        return;
                    }
                } else if (i11 < 0 && !view.canScrollVertically(-1)) {
                    int i14 = this.C;
                    if (i13 > i14 && !this.E) {
                        iArr[1] = top - i14;
                        d0.e0(v10, -iArr[1]);
                        B0(4);
                    } else if (this.G) {
                        iArr[1] = i11;
                        d0.e0(v10, -i11);
                        B0(1);
                    } else {
                        return;
                    }
                }
                a0(v10.getTop());
                this.K = i11;
                this.L = true;
            }
        }
    }

    public void q0(boolean z10) {
        if (this.f10509b != z10) {
            this.f10509b = z10;
            if (this.P != null) {
                T();
            }
            B0((!this.f10509b || this.H != 6) ? this.H : 3);
            L0();
        }
    }

    public void r0(boolean z10) {
        this.f10521n = z10;
    }

    public void s0(float f10) {
        if (f10 <= 0.0f || f10 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.B = f10;
        if (this.P != null) {
            U();
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
    }

    public void t0(boolean z10) {
        if (this.E != z10) {
            this.E = z10;
            if (!z10 && this.H == 5) {
                A0(4);
            }
            L0();
        }
    }

    public void u0(int i10) {
        this.f10519l = i10;
    }

    public void v0(int i10) {
        this.f10518k = i10;
    }

    public void w0(int i10) {
        x0(i10, false);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void x(CoordinatorLayout coordinatorLayout, V v10, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.x(coordinatorLayout, v10, savedState.a());
        n0(savedState);
        int i10 = savedState.f10534c;
        if (i10 == 1 || i10 == 2) {
            this.H = 4;
        } else {
            this.H = i10;
        }
    }

    public final void x0(int i10, boolean z10) {
        boolean z11 = true;
        if (i10 == -1) {
            if (!this.f10513f) {
                this.f10513f = true;
            }
            z11 = false;
        } else {
            if (this.f10513f || this.f10512e != i10) {
                this.f10513f = false;
                this.f10512e = Math.max(0, i10);
            }
            z11 = false;
        }
        if (z11) {
            O0(z10);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public Parcelable y(CoordinatorLayout coordinatorLayout, V v10) {
        return new SavedState(super.y(coordinatorLayout, v10), (BottomSheetBehavior<?>) this);
    }

    public void y0(int i10) {
        this.f10508a = i10;
    }

    public void z0(boolean z10) {
        this.F = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        final int f10534c;

        /* renamed from: d  reason: collision with root package name */
        int f10535d;

        /* renamed from: e  reason: collision with root package name */
        boolean f10536e;

        /* renamed from: f  reason: collision with root package name */
        boolean f10537f;

        /* renamed from: g  reason: collision with root package name */
        boolean f10538g;

        /* loaded from: classes.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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
            this.f10534c = parcel.readInt();
            this.f10535d = parcel.readInt();
            boolean z10 = false;
            this.f10536e = parcel.readInt() == 1;
            this.f10537f = parcel.readInt() == 1;
            this.f10538g = parcel.readInt() == 1 ? true : z10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f10534c);
            parcel.writeInt(this.f10535d);
            parcel.writeInt(this.f10536e ? 1 : 0);
            parcel.writeInt(this.f10537f ? 1 : 0);
            parcel.writeInt(this.f10538g ? 1 : 0);
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.f10534c = bottomSheetBehavior.H;
            this.f10535d = ((BottomSheetBehavior) bottomSheetBehavior).f10512e;
            this.f10536e = ((BottomSheetBehavior) bottomSheetBehavior).f10509b;
            this.f10537f = bottomSheetBehavior.E;
            this.f10538g = ((BottomSheetBehavior) bottomSheetBehavior).F;
        }
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i10;
        this.f10508a = 0;
        this.f10509b = true;
        this.f10510c = false;
        this.f10518k = -1;
        this.f10519l = -1;
        this.f10530w = null;
        this.B = 0.5f;
        this.D = -1.0f;
        this.G = true;
        this.H = 4;
        this.R = new ArrayList<>();
        this.X = -1;
        this.Y = new d();
        this.f10515h = context.getResources().getDimensionPixelSize(d7.d.f25209n0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.M);
        this.f10516i = obtainStyledAttributes.hasValue(l.f25395e0);
        int i11 = l.Q;
        boolean hasValue = obtainStyledAttributes.hasValue(i11);
        if (hasValue) {
            Y(context, attributeSet, hasValue, t7.c.a(context, obtainStyledAttributes, i11));
        } else {
            X(context, attributeSet, hasValue);
        }
        Z();
        if (Build.VERSION.SDK_INT >= 21) {
            this.D = obtainStyledAttributes.getDimension(l.P, -1.0f);
        }
        int i12 = l.N;
        if (obtainStyledAttributes.hasValue(i12)) {
            v0(obtainStyledAttributes.getDimensionPixelSize(i12, -1));
        }
        int i13 = l.O;
        if (obtainStyledAttributes.hasValue(i13)) {
            u0(obtainStyledAttributes.getDimensionPixelSize(i13, -1));
        }
        int i14 = l.W;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i14);
        if (peekValue == null || (i10 = peekValue.data) != -1) {
            w0(obtainStyledAttributes.getDimensionPixelSize(i14, -1));
        } else {
            w0(i10);
        }
        t0(obtainStyledAttributes.getBoolean(l.V, false));
        r0(obtainStyledAttributes.getBoolean(l.Z, false));
        q0(obtainStyledAttributes.getBoolean(l.T, true));
        z0(obtainStyledAttributes.getBoolean(l.Y, false));
        o0(obtainStyledAttributes.getBoolean(l.R, true));
        y0(obtainStyledAttributes.getInt(l.X, 0));
        s0(obtainStyledAttributes.getFloat(l.U, 0.5f));
        int i15 = l.S;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i15);
        if (peekValue2 == null || peekValue2.type != 16) {
            p0(obtainStyledAttributes.getDimensionPixelOffset(i15, 0));
        } else {
            p0(peekValue2.data);
        }
        this.f10522o = obtainStyledAttributes.getBoolean(l.f25363a0, false);
        this.f10523p = obtainStyledAttributes.getBoolean(l.f25371b0, false);
        this.f10524q = obtainStyledAttributes.getBoolean(l.f25379c0, false);
        this.f10525r = obtainStyledAttributes.getBoolean(l.f25387d0, true);
        obtainStyledAttributes.recycle();
        this.f10511d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
