package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import androidx.core.view.n0;
import androidx.core.view.p;
import androidx.core.view.v;
import androidx.customview.view.AbsSavedState;
import d7.k;
import d7.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import k0.c;
import k0.f;
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements CoordinatorLayout.b {

    /* renamed from: s  reason: collision with root package name */
    private static final int f10336s = k.f25343h;

    /* renamed from: a  reason: collision with root package name */
    private int f10337a;

    /* renamed from: b  reason: collision with root package name */
    private int f10338b;

    /* renamed from: c  reason: collision with root package name */
    private int f10339c;

    /* renamed from: d  reason: collision with root package name */
    private int f10340d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10341e;

    /* renamed from: f  reason: collision with root package name */
    private int f10342f;

    /* renamed from: g  reason: collision with root package name */
    private n0 f10343g;

    /* renamed from: h  reason: collision with root package name */
    private List<c> f10344h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10345i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10346j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10347k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10348l;

    /* renamed from: m  reason: collision with root package name */
    private int f10349m;

    /* renamed from: n  reason: collision with root package name */
    private WeakReference<View> f10350n;

    /* renamed from: o  reason: collision with root package name */
    private ValueAnimator f10351o;

    /* renamed from: p  reason: collision with root package name */
    private final List<g> f10352p;

    /* renamed from: q  reason: collision with root package name */
    private int[] f10353q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f10354r;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends com.google.android.material.appbar.a<T> {

        /* renamed from: k  reason: collision with root package name */
        private int f10355k;

        /* renamed from: l  reason: collision with root package name */
        private int f10356l;

        /* renamed from: m  reason: collision with root package name */
        private ValueAnimator f10357m;

        /* renamed from: n  reason: collision with root package name */
        private SavedState f10358n;

        /* renamed from: o  reason: collision with root package name */
        private WeakReference<View> f10359o;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f10364a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f10365b;

            a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f10364a = coordinatorLayout;
                this.f10365b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.P(this.f10364a, this.f10365b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b implements k0.f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ CoordinatorLayout f10367a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f10368b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ View f10369c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f10370d;

            b(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i10) {
                this.f10367a = coordinatorLayout;
                this.f10368b = appBarLayout;
                this.f10369c = view;
                this.f10370d = i10;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // k0.f
            public boolean a(View view, f.a aVar) {
                BaseBehavior.this.q(this.f10367a, this.f10368b, this.f10369c, 0, this.f10370d, new int[]{0, 0}, 1);
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements k0.f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AppBarLayout f10372a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ boolean f10373b;

            c(BaseBehavior baseBehavior, AppBarLayout appBarLayout, boolean z10) {
                this.f10372a = appBarLayout;
                this.f10373b = z10;
            }

            @Override // k0.f
            public boolean a(View view, f.a aVar) {
                this.f10372a.setExpanded(this.f10373b);
                return true;
            }
        }

        public BaseBehavior() {
        }

        private void S(CoordinatorLayout coordinatorLayout, T t10, View view) {
            if (M() != (-t10.getTotalScrollRange()) && view.canScrollVertically(1)) {
                T(coordinatorLayout, t10, c.a.f29698h, false);
            }
            if (M() == 0) {
                return;
            }
            if (view.canScrollVertically(-1)) {
                int i10 = -t10.getDownNestedPreScrollRange();
                if (i10 != 0) {
                    d0.p0(coordinatorLayout, c.a.f29699i, null, new b(coordinatorLayout, t10, view, i10));
                    return;
                }
                return;
            }
            T(coordinatorLayout, t10, c.a.f29699i, true);
        }

        private void T(CoordinatorLayout coordinatorLayout, T t10, c.a aVar, boolean z10) {
            d0.p0(coordinatorLayout, aVar, null, new c(this, t10, z10));
        }

        private void U(CoordinatorLayout coordinatorLayout, T t10, int i10, float f10) {
            int i11;
            int abs = Math.abs(M() - i10);
            float abs2 = Math.abs(f10);
            if (abs2 > 0.0f) {
                i11 = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                i11 = (int) (((abs / t10.getHeight()) + 1.0f) * 150.0f);
            }
            V(coordinatorLayout, t10, i10, i11);
        }

        private void V(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11) {
            int M = M();
            if (M == i10) {
                ValueAnimator valueAnimator = this.f10357m;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    this.f10357m.cancel();
                    return;
                }
                return;
            }
            ValueAnimator valueAnimator2 = this.f10357m;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.f10357m = valueAnimator3;
                valueAnimator3.setInterpolator(e7.a.f25837e);
                this.f10357m.addUpdateListener(new a(coordinatorLayout, t10));
            } else {
                valueAnimator2.cancel();
            }
            this.f10357m.setDuration(Math.min(i11, 600));
            this.f10357m.setIntValues(M, i10);
            this.f10357m.start();
        }

        private boolean X(CoordinatorLayout coordinatorLayout, T t10, View view) {
            return t10.l() && coordinatorLayout.getHeight() - view.getHeight() <= t10.getHeight();
        }

        private static boolean Y(int i10, int i11) {
            return (i10 & i11) == i11;
        }

        private View Z(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = coordinatorLayout.getChildAt(i10);
                if ((childAt instanceof p) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        private static View a0(AppBarLayout appBarLayout, int i10) {
            int abs = Math.abs(i10);
            int childCount = appBarLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = appBarLayout.getChildAt(i11);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        private int b0(T t10, int i10) {
            int childCount = t10.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = t10.getChildAt(i11);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                f fVar = (f) childAt.getLayoutParams();
                if (Y(fVar.c(), 32)) {
                    top -= ((LinearLayout.LayoutParams) fVar).topMargin;
                    bottom += ((LinearLayout.LayoutParams) fVar).bottomMargin;
                }
                int i12 = -i10;
                if (top <= i12 && bottom >= i12) {
                    return i11;
                }
            }
            return -1;
        }

        private int e0(T t10, int i10) {
            int abs = Math.abs(i10);
            int childCount = t10.getChildCount();
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (i12 >= childCount) {
                    break;
                }
                View childAt = t10.getChildAt(i12);
                f fVar = (f) childAt.getLayoutParams();
                Interpolator d10 = fVar.d();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i12++;
                } else if (d10 != null) {
                    int c10 = fVar.c();
                    if ((c10 & 1) != 0) {
                        i11 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
                        if ((c10 & 2) != 0) {
                            i11 -= d0.F(childAt);
                        }
                    }
                    if (d0.B(childAt)) {
                        i11 -= t10.getTopInset();
                    }
                    if (i11 > 0) {
                        float f10 = i11;
                        return Integer.signum(i10) * (childAt.getTop() + Math.round(f10 * d10.getInterpolation((abs - childAt.getTop()) / f10)));
                    }
                }
            }
            return i10;
        }

        private boolean p0(CoordinatorLayout coordinatorLayout, T t10) {
            List<View> s10 = coordinatorLayout.s(t10);
            int size = s10.size();
            for (int i10 = 0; i10 < size; i10++) {
                CoordinatorLayout.c f10 = ((CoordinatorLayout.f) s10.get(i10).getLayoutParams()).f();
                if (f10 instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) f10).K() != 0;
                }
            }
            return false;
        }

        private void q0(CoordinatorLayout coordinatorLayout, T t10) {
            int M = M();
            int b02 = b0(t10, M);
            if (b02 >= 0) {
                View childAt = t10.getChildAt(b02);
                f fVar = (f) childAt.getLayoutParams();
                int c10 = fVar.c();
                if ((c10 & 17) == 17) {
                    int i10 = -childAt.getTop();
                    int i11 = -childAt.getBottom();
                    if (b02 == t10.getChildCount() - 1) {
                        i11 += t10.getTopInset() + t10.getPaddingTop();
                    }
                    if (Y(c10, 2)) {
                        i11 += d0.F(childAt);
                    } else if (Y(c10, 5)) {
                        int F = d0.F(childAt) + i11;
                        if (M < F) {
                            i10 = F;
                        } else {
                            i11 = F;
                        }
                    }
                    if (Y(c10, 32)) {
                        i10 += ((LinearLayout.LayoutParams) fVar).topMargin;
                        i11 -= ((LinearLayout.LayoutParams) fVar).bottomMargin;
                    }
                    if (M < (i11 + i10) / 2) {
                        i10 = i11;
                    }
                    U(coordinatorLayout, t10, e0.a.b(i10, -t10.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void r0(CoordinatorLayout coordinatorLayout, T t10) {
            d0.n0(coordinatorLayout, c.a.f29698h.b());
            d0.n0(coordinatorLayout, c.a.f29699i.b());
            View Z = Z(coordinatorLayout);
            if (Z != null && t10.getTotalScrollRange() != 0 && (((CoordinatorLayout.f) Z.getLayoutParams()).f() instanceof ScrollingViewBehavior)) {
                S(coordinatorLayout, t10, Z);
            }
        }

        private void s0(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, boolean z10) {
            View a02 = a0(t10, i10);
            boolean z11 = false;
            if (a02 != null) {
                int c10 = ((f) a02.getLayoutParams()).c();
                if ((c10 & 1) != 0) {
                    int F = d0.F(a02);
                    z11 = true;
                    if (i11 <= 0 || (c10 & 12) == 0 ? !((c10 & 2) == 0 || (-i10) < (a02.getBottom() - F) - t10.getTopInset()) : (-i10) >= (a02.getBottom() - F) - t10.getTopInset()) {
                    }
                }
            }
            if (t10.n()) {
                z11 = t10.x(Z(coordinatorLayout));
            }
            boolean u10 = t10.u(z11);
            if (z10 || (u10 && p0(coordinatorLayout, t10))) {
                t10.jumpDrawablesToCurrentState();
            }
        }

        @Override // com.google.android.material.appbar.a
        int M() {
            return E() + this.f10355k;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: W */
        public boolean H(T t10) {
            WeakReference<View> weakReference = this.f10359o;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return view != null && view.isShown() && !view.canScrollVertically(-1);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: c0 */
        public int K(T t10) {
            return -t10.getDownNestedScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: d0 */
        public int L(T t10) {
            return t10.getTotalScrollRange();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f0 */
        public void N(CoordinatorLayout coordinatorLayout, T t10) {
            q0(coordinatorLayout, t10);
            if (t10.n()) {
                t10.u(t10.x(Z(coordinatorLayout)));
            }
        }

        /* renamed from: g0 */
        public boolean l(CoordinatorLayout coordinatorLayout, T t10, int i10) {
            int i11;
            boolean l10 = super.l(coordinatorLayout, t10, i10);
            int pendingAction = t10.getPendingAction();
            SavedState savedState = this.f10358n;
            if (savedState == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z10 = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i12 = -t10.getUpNestedPreScrollRange();
                        if (z10) {
                            U(coordinatorLayout, t10, i12, 0.0f);
                        } else {
                            P(coordinatorLayout, t10, i12);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z10) {
                            U(coordinatorLayout, t10, 0, 0.0f);
                        } else {
                            P(coordinatorLayout, t10, 0);
                        }
                    }
                }
            } else if (savedState.f10360c) {
                P(coordinatorLayout, t10, -t10.getTotalScrollRange());
            } else {
                View childAt = t10.getChildAt(savedState.f10361d);
                int i13 = -childAt.getBottom();
                if (this.f10358n.f10363f) {
                    i11 = d0.F(childAt) + t10.getTopInset();
                } else {
                    i11 = Math.round(childAt.getHeight() * this.f10358n.f10362e);
                }
                P(coordinatorLayout, t10, i13 + i11);
            }
            t10.q();
            this.f10358n = null;
            G(e0.a.b(E(), -t10.getTotalScrollRange(), 0));
            s0(coordinatorLayout, t10, E(), 0, true);
            t10.o(E());
            r0(coordinatorLayout, t10);
            return l10;
        }

        /* renamed from: h0 */
        public boolean m(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, int i12, int i13) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) t10.getLayoutParams())).height != -2) {
                return super.m(coordinatorLayout, t10, i10, i11, i12, i13);
            }
            coordinatorLayout.J(t10, i10, i11, View.MeasureSpec.makeMeasureSpec(0, 0), i13);
            return true;
        }

        /* renamed from: i0 */
        public void q(CoordinatorLayout coordinatorLayout, T t10, View view, int i10, int i11, int[] iArr, int i12) {
            int i13;
            int i14;
            if (i11 != 0) {
                if (i11 < 0) {
                    i14 = -t10.getTotalScrollRange();
                    i13 = t10.getDownNestedPreScrollRange() + i14;
                } else {
                    i14 = -t10.getUpNestedPreScrollRange();
                    i13 = 0;
                }
                int i15 = i14;
                int i16 = i13;
                if (i15 != i16) {
                    iArr[1] = O(coordinatorLayout, t10, i11, i15, i16);
                }
            }
            if (t10.n()) {
                t10.u(t10.x(view));
            }
        }

        /* renamed from: j0 */
        public void t(CoordinatorLayout coordinatorLayout, T t10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
            if (i13 < 0) {
                iArr[1] = O(coordinatorLayout, t10, i13, -t10.getDownNestedScrollRange(), 0);
            }
            if (i13 == 0) {
                r0(coordinatorLayout, t10);
            }
        }

        /* renamed from: k0 */
        public void x(CoordinatorLayout coordinatorLayout, T t10, Parcelable parcelable) {
            if (parcelable instanceof SavedState) {
                SavedState savedState = (SavedState) parcelable;
                this.f10358n = savedState;
                super.x(coordinatorLayout, t10, savedState.a());
                return;
            }
            super.x(coordinatorLayout, t10, parcelable);
            this.f10358n = null;
        }

        /* renamed from: l0 */
        public Parcelable y(CoordinatorLayout coordinatorLayout, T t10) {
            Parcelable y10 = super.y(coordinatorLayout, t10);
            int E = E();
            int childCount = t10.getChildCount();
            boolean z10 = false;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = t10.getChildAt(i10);
                int bottom = childAt.getBottom() + E;
                if (childAt.getTop() + E <= 0 && bottom >= 0) {
                    SavedState savedState = new SavedState(y10);
                    savedState.f10360c = (-E()) >= t10.getTotalScrollRange();
                    savedState.f10361d = i10;
                    if (bottom == d0.F(childAt) + t10.getTopInset()) {
                        z10 = true;
                    }
                    savedState.f10363f = z10;
                    savedState.f10362e = bottom / childAt.getHeight();
                    return savedState;
                }
            }
            return y10;
        }

        /* renamed from: m0 */
        public boolean A(CoordinatorLayout coordinatorLayout, T t10, View view, View view2, int i10, int i11) {
            ValueAnimator valueAnimator;
            boolean z10 = (i10 & 2) != 0 && (t10.n() || X(coordinatorLayout, t10, view));
            if (z10 && (valueAnimator = this.f10357m) != null) {
                valueAnimator.cancel();
            }
            this.f10359o = null;
            this.f10356l = i11;
            return z10;
        }

        /* renamed from: n0 */
        public void C(CoordinatorLayout coordinatorLayout, T t10, View view, int i10) {
            if (this.f10356l == 0 || i10 == 1) {
                q0(coordinatorLayout, t10);
                if (t10.n()) {
                    t10.u(t10.x(view));
                }
            }
            this.f10359o = new WeakReference<>(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: o0 */
        public int Q(CoordinatorLayout coordinatorLayout, T t10, int i10, int i11, int i12) {
            int M = M();
            int i13 = 0;
            if (i11 == 0 || M < i11 || M > i12) {
                this.f10355k = 0;
            } else {
                int b10 = e0.a.b(i10, i11, i12);
                if (M != b10) {
                    int e02 = t10.j() ? e0(t10, b10) : b10;
                    boolean G = G(e02);
                    i13 = M - b10;
                    this.f10355k = b10 - e02;
                    int i14 = 1;
                    if (G) {
                        while (i13 < t10.getChildCount()) {
                            f fVar = (f) t10.getChildAt(i13).getLayoutParams();
                            d b11 = fVar.b();
                            if (!(b11 == null || (fVar.c() & 1) == 0)) {
                                b11.a(t10, t10.getChildAt(i13), E());
                            }
                            i13++;
                        }
                    }
                    if (!G && t10.j()) {
                        coordinatorLayout.f(t10);
                    }
                    t10.o(E());
                    if (b10 < M) {
                        i14 = -1;
                    }
                    s0(coordinatorLayout, t10, b10, i14, false);
                }
            }
            r0(coordinatorLayout, t10);
            return i13;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: classes.dex */
        public static class SavedState extends AbsSavedState {
            public static final Parcelable.Creator<SavedState> CREATOR = new a();

            /* renamed from: c  reason: collision with root package name */
            boolean f10360c;

            /* renamed from: d  reason: collision with root package name */
            int f10361d;

            /* renamed from: e  reason: collision with root package name */
            float f10362e;

            /* renamed from: f  reason: collision with root package name */
            boolean f10363f;

            /* loaded from: classes.dex */
            static class a implements Parcelable.ClassLoaderCreator<SavedState> {
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
                boolean z10 = true;
                this.f10360c = parcel.readByte() != 0;
                this.f10361d = parcel.readInt();
                this.f10362e = parcel.readFloat();
                this.f10363f = parcel.readByte() == 0 ? false : z10;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i10) {
                super.writeToParcel(parcel, i10);
                parcel.writeByte(this.f10360c ? (byte) 1 : (byte) 0);
                parcel.writeInt(this.f10361d);
                parcel.writeFloat(this.f10362e);
                parcel.writeByte(this.f10363f ? (byte) 1 : (byte) 0);
            }

            public SavedState(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends com.google.android.material.appbar.b {
        public ScrollingViewBehavior() {
        }

        private static int R(AppBarLayout appBarLayout) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) appBarLayout.getLayoutParams()).f();
            if (f10 instanceof BaseBehavior) {
                return ((BaseBehavior) f10).M();
            }
            return 0;
        }

        private void S(View view, View view2) {
            CoordinatorLayout.c f10 = ((CoordinatorLayout.f) view2.getLayoutParams()).f();
            if (f10 instanceof BaseBehavior) {
                d0.e0(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) f10).f10355k) + M()) - I(view2));
            }
        }

        private void T(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.n()) {
                    appBarLayout.u(appBarLayout.x(view));
                }
            }
        }

        @Override // com.google.android.material.appbar.b
        float J(View view) {
            int i10;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int R = R(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + R > downNestedPreScrollRange) && (i10 = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (R / i10) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.google.android.material.appbar.b
        int L(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.L(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: Q */
        public AppBarLayout H(List<View> list) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                View view = list.get(i10);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean h(CoordinatorLayout coordinatorLayout, View view, View view2) {
            S(view, view2);
            T(view, view2);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void i(CoordinatorLayout coordinatorLayout, View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                d0.n0(coordinatorLayout, c.a.f29698h.b());
                d0.n0(coordinatorLayout, c.a.f29699i.b());
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean w(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z10) {
            AppBarLayout Q = H(coordinatorLayout.r(view));
            if (Q != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f10392d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    Q.r(false, !z10);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f25375b4);
            O(obtainStyledAttributes.getDimensionPixelSize(l.f25383c4, 0));
            obtainStyledAttributes.recycle();
        }
    }

    /* loaded from: classes.dex */
    class a implements v {
        a() {
        }

        @Override // androidx.core.view.v
        public n0 a(View view, n0 n0Var) {
            return AppBarLayout.this.p(n0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ w7.g f10375a;

        b(w7.g gVar) {
            this.f10375a = gVar;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            this.f10375a.Y(floatValue);
            if (AppBarLayout.this.f10354r instanceof w7.g) {
                ((w7.g) AppBarLayout.this.f10354r).Y(floatValue);
            }
            for (g gVar : AppBarLayout.this.f10352p) {
                gVar.a(floatValue, this.f10375a.A());
            }
        }
    }

    /* loaded from: classes.dex */
    public interface c<T extends AppBarLayout> {
        void a(T t10, int i10);
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public abstract void a(AppBarLayout appBarLayout, View view, float f10);
    }

    /* loaded from: classes.dex */
    public static class e extends d {

        /* renamed from: a  reason: collision with root package name */
        private final Rect f10377a = new Rect();

        /* renamed from: b  reason: collision with root package name */
        private final Rect f10378b = new Rect();

        private static void b(Rect rect, AppBarLayout appBarLayout, View view) {
            view.getDrawingRect(rect);
            appBarLayout.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(0, -appBarLayout.getTopInset());
        }

        @Override // com.google.android.material.appbar.AppBarLayout.d
        public void a(AppBarLayout appBarLayout, View view, float f10) {
            b(this.f10377a, appBarLayout, view);
            float abs = this.f10377a.top - Math.abs(f10);
            if (abs <= 0.0f) {
                float a10 = 1.0f - e0.a.a(Math.abs(abs / this.f10377a.height()), 0.0f, 1.0f);
                float height = (-abs) - ((this.f10377a.height() * 0.3f) * (1.0f - (a10 * a10)));
                view.setTranslationY(height);
                view.getDrawingRect(this.f10378b);
                this.f10378b.offset(0, (int) (-height));
                d0.A0(view, this.f10378b);
                return;
            }
            d0.A0(view, null);
            view.setTranslationY(0.0f);
        }
    }

    /* loaded from: classes.dex */
    public interface g {
        void a(float f10, int i10);
    }

    /* loaded from: classes.dex */
    public interface h extends c<AppBarLayout> {
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.f25145b);
    }

    private void A() {
        setWillNotDraw(!w());
    }

    private void e() {
        WeakReference<View> weakReference = this.f10350n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f10350n = null;
    }

    private View f(View view) {
        int i10;
        if (this.f10350n == null && (i10 = this.f10349m) != -1) {
            View findViewById = view != null ? view.findViewById(i10) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.f10349m);
            }
            if (findViewById != null) {
                this.f10350n = new WeakReference<>(findViewById);
            }
        }
        WeakReference<View> weakReference = this.f10350n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private boolean k() {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (((f) getChildAt(i10).getLayoutParams()).e()) {
                return true;
            }
        }
        return false;
    }

    private void m() {
        this.f10338b = -1;
        this.f10339c = -1;
        this.f10340d = -1;
    }

    private void s(boolean z10, boolean z11, boolean z12) {
        int i10 = 0;
        int i11 = (z10 ? 1 : 2) | (z11 ? 4 : 0);
        if (z12) {
            i10 = 8;
        }
        this.f10342f = i11 | i10;
        requestLayout();
    }

    private boolean t(boolean z10) {
        if (this.f10346j == z10) {
            return false;
        }
        this.f10346j = z10;
        refreshDrawableState();
        return true;
    }

    private boolean w() {
        return this.f10354r != null && getTopInset() > 0;
    }

    private boolean y() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        return childAt.getVisibility() != 8 && !d0.B(childAt);
    }

    private void z(w7.g gVar, boolean z10) {
        float dimension = getResources().getDimension(d7.d.f25182a);
        float f10 = z10 ? 0.0f : dimension;
        if (!z10) {
            dimension = 0.0f;
        }
        ValueAnimator valueAnimator = this.f10351o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f10, dimension);
        this.f10351o = ofFloat;
        ofFloat.setDuration(getResources().getInteger(d7.g.f25280a));
        this.f10351o.setInterpolator(e7.a.f25833a);
        this.f10351o.addUpdateListener(new b(gVar));
        this.f10351o.start();
    }

    public void c(c cVar) {
        if (this.f10344h == null) {
            this.f10344h = new ArrayList();
        }
        if (cVar != null && !this.f10344h.contains(cVar)) {
            this.f10344h.add(cVar);
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof f;
    }

    public void d(h hVar) {
        c(hVar);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (w()) {
            int save = canvas.save();
            canvas.translate(0.0f, -this.f10337a);
            this.f10354r.draw(canvas);
            canvas.restoreToCount(save);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f10354r;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public f generateDefaultLayoutParams() {
        return new f(-1, -2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<AppBarLayout> getBehavior() {
        return new Behavior();
    }

    int getDownNestedPreScrollRange() {
        int i10;
        int F;
        int i11 = this.f10339c;
        if (i11 != -1) {
            return i11;
        }
        int i12 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            f fVar = (f) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i13 = fVar.f10379a;
            if ((i13 & 5) == 5) {
                int i14 = ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
                if ((i13 & 8) != 0) {
                    F = d0.F(childAt);
                } else if ((i13 & 2) != 0) {
                    F = measuredHeight - d0.F(childAt);
                } else {
                    i10 = i14 + measuredHeight;
                    if (childCount == 0 && d0.B(childAt)) {
                        i10 = Math.min(i10, measuredHeight - getTopInset());
                    }
                    i12 += i10;
                }
                i10 = i14 + F;
                if (childCount == 0) {
                    i10 = Math.min(i10, measuredHeight - getTopInset());
                }
                i12 += i10;
            } else if (i12 > 0) {
                break;
            }
        }
        int max = Math.max(0, i12);
        this.f10339c = max;
        return max;
    }

    int getDownNestedScrollRange() {
        int i10 = this.f10340d;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
            int i13 = fVar.f10379a;
            if ((i13 & 1) == 0) {
                break;
            }
            i12 += measuredHeight;
            if ((i13 & 2) != 0) {
                i12 -= d0.F(childAt);
                break;
            }
            i11++;
        }
        int max = Math.max(0, i12);
        this.f10340d = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.f10349m;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int F = d0.F(this);
        if (F == 0) {
            int childCount = getChildCount();
            F = childCount >= 1 ? d0.F(getChildAt(childCount - 1)) : 0;
            if (F == 0) {
                return getHeight() / 3;
            }
        }
        return (F * 2) + topInset;
    }

    int getPendingAction() {
        return this.f10342f;
    }

    public Drawable getStatusBarForeground() {
        return this.f10354r;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        n0 n0Var = this.f10343g;
        if (n0Var != null) {
            return n0Var.m();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i10 = this.f10338b;
        if (i10 != -1) {
            return i10;
        }
        int childCount = getChildCount();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            }
            View childAt = getChildAt(i11);
            f fVar = (f) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i13 = fVar.f10379a;
            if ((i13 & 1) == 0) {
                break;
            }
            i12 += measuredHeight + ((LinearLayout.LayoutParams) fVar).topMargin + ((LinearLayout.LayoutParams) fVar).bottomMargin;
            if (i11 == 0 && d0.B(childAt)) {
                i12 -= getTopInset();
            }
            if ((i13 & 2) != 0) {
                i12 -= d0.F(childAt);
                break;
            }
            i11++;
        }
        int max = Math.max(0, i12);
        this.f10338b = max;
        return max;
    }

    int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    /* renamed from: h */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new f((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new f((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new f(layoutParams);
    }

    boolean j() {
        return this.f10341e;
    }

    boolean l() {
        return getTotalScrollRange() != 0;
    }

    public boolean n() {
        return this.f10348l;
    }

    void o(int i10) {
        this.f10337a = i10;
        if (!willNotDraw()) {
            d0.k0(this);
        }
        List<c> list = this.f10344h;
        if (list != null) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                c cVar = this.f10344h.get(i11);
                if (cVar != null) {
                    cVar.a(this, i10);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w7.h.e(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        if (this.f10353q == null) {
            this.f10353q = new int[4];
        }
        int[] iArr = this.f10353q;
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + iArr.length);
        boolean z10 = this.f10346j;
        int i11 = d7.b.U;
        if (!z10) {
            i11 = -i11;
        }
        iArr[0] = i11;
        iArr[1] = (!z10 || !this.f10347k) ? -d7.b.V : d7.b.V;
        int i12 = d7.b.S;
        if (!z10) {
            i12 = -i12;
        }
        iArr[2] = i12;
        iArr[3] = (!z10 || !this.f10347k) ? -d7.b.R : d7.b.R;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        boolean z11 = true;
        if (d0.B(this) && y()) {
            int topInset = getTopInset();
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                d0.e0(getChildAt(childCount), topInset);
            }
        }
        m();
        this.f10341e = false;
        int childCount2 = getChildCount();
        int i14 = 0;
        while (true) {
            if (i14 >= childCount2) {
                break;
            } else if (((f) getChildAt(i14).getLayoutParams()).d() != null) {
                this.f10341e = true;
                break;
            } else {
                i14++;
            }
        }
        Drawable drawable = this.f10354r;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (!this.f10345i) {
            if (!this.f10348l && !k()) {
                z11 = false;
            }
            t(z11);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i11);
        if (mode != 1073741824 && d0.B(this) && y()) {
            int measuredHeight = getMeasuredHeight();
            if (mode == Integer.MIN_VALUE) {
                measuredHeight = e0.a.b(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(i11));
            } else if (mode == 0) {
                measuredHeight += getTopInset();
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
        m();
    }

    n0 p(n0 n0Var) {
        n0 n0Var2 = d0.B(this) ? n0Var : null;
        if (!j0.c.a(this.f10343g, n0Var2)) {
            this.f10343g = n0Var2;
            A();
            requestLayout();
        }
        return n0Var;
    }

    void q() {
        this.f10342f = 0;
    }

    public void r(boolean z10, boolean z11) {
        s(z10, z11, true);
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        w7.h.d(this, f10);
    }

    public void setExpanded(boolean z10) {
        r(z10, d0.X(this));
    }

    public void setLiftOnScroll(boolean z10) {
        this.f10348l = z10;
    }

    public void setLiftOnScrollTargetViewId(int i10) {
        this.f10349m = i10;
        e();
    }

    public void setLiftableOverrideEnabled(boolean z10) {
        this.f10345i = z10;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i10) {
        if (i10 == 1) {
            super.setOrientation(i10);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.f10354r;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.f10354r = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.f10354r.setState(getDrawableState());
                }
                androidx.core.graphics.drawable.a.m(this.f10354r, d0.E(this));
                this.f10354r.setVisible(getVisibility() == 0, false);
                this.f10354r.setCallback(this);
            }
            A();
            d0.k0(this);
        }
    }

    public void setStatusBarForegroundColor(int i10) {
        setStatusBarForeground(new ColorDrawable(i10));
    }

    public void setStatusBarForegroundResource(int i10) {
        setStatusBarForeground(e.a.b(getContext(), i10));
    }

    @Deprecated
    public void setTargetElevation(float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            com.google.android.material.appbar.e.b(this, f10);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        boolean z10 = i10 == 0;
        Drawable drawable = this.f10354r;
        if (drawable != null) {
            drawable.setVisible(z10, false);
        }
    }

    boolean u(boolean z10) {
        return v(z10, !this.f10345i);
    }

    boolean v(boolean z10, boolean z11) {
        if (!z11 || this.f10347k == z10) {
            return false;
        }
        this.f10347k = z10;
        refreshDrawableState();
        if (!this.f10348l || !(getBackground() instanceof w7.g)) {
            return true;
        }
        z((w7.g) getBackground(), z10);
        return true;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f10354r;
    }

    boolean x(View view) {
        View f10 = f(view);
        if (f10 != null) {
            view = f10;
        }
        return view != null && (view.canScrollVertically(-1) || view.getScrollY() > 0);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AppBarLayout(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f10336s;
        this.f10338b = -1;
        this.f10339c = -1;
        this.f10340d = -1;
        this.f10342f = 0;
        this.f10352p = new ArrayList();
        Context context2 = getContext();
        setOrientation(1);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 21) {
            if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
                com.google.android.material.appbar.e.a(this);
            }
            com.google.android.material.appbar.e.c(this, attributeSet, i10, i11);
        }
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, l.f25362a, i10, i11, new int[0]);
        d0.x0(this, h10.getDrawable(l.f25370b));
        if (getBackground() instanceof ColorDrawable) {
            w7.g gVar = new w7.g();
            gVar.Z(ColorStateList.valueOf(((ColorDrawable) getBackground()).getColor()));
            gVar.O(context2);
            d0.x0(this, gVar);
        }
        int i13 = l.f25402f;
        if (h10.hasValue(i13)) {
            s(h10.getBoolean(i13, false), false, false);
        }
        if (i12 >= 21) {
            int i14 = l.f25394e;
            if (h10.hasValue(i14)) {
                com.google.android.material.appbar.e.b(this, h10.getDimensionPixelSize(i14, 0));
            }
        }
        if (i12 >= 26) {
            int i15 = l.f25386d;
            if (h10.hasValue(i15)) {
                setKeyboardNavigationCluster(h10.getBoolean(i15, false));
            }
            int i16 = l.f25378c;
            if (h10.hasValue(i16)) {
                setTouchscreenBlocksFocus(h10.getBoolean(i16, false));
            }
        }
        this.f10348l = h10.getBoolean(l.f25410g, false);
        this.f10349m = h10.getResourceId(l.f25418h, -1);
        setStatusBarForeground(h10.getDrawable(l.f25426i));
        h10.recycle();
        d0.G0(this, new a());
    }

    /* loaded from: classes.dex */
    public static class f extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        int f10379a;

        /* renamed from: b  reason: collision with root package name */
        private d f10380b;

        /* renamed from: c  reason: collision with root package name */
        Interpolator f10381c;

        public f(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f10379a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f25434j);
            this.f10379a = obtainStyledAttributes.getInt(l.f25450l, 0);
            f(a(obtainStyledAttributes.getInt(l.f25442k, 0)));
            int i10 = l.f25458m;
            if (obtainStyledAttributes.hasValue(i10)) {
                this.f10381c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(i10, 0));
            }
            obtainStyledAttributes.recycle();
        }

        private d a(int i10) {
            if (i10 != 1) {
                return null;
            }
            return new e();
        }

        public d b() {
            return this.f10380b;
        }

        public int c() {
            return this.f10379a;
        }

        public Interpolator d() {
            return this.f10381c;
        }

        boolean e() {
            int i10 = this.f10379a;
            return (i10 & 1) == 1 && (i10 & 10) != 0;
        }

        public void f(d dVar) {
            this.f10380b = dVar;
        }

        public f(int i10, int i11) {
            super(i10, i11);
            this.f10379a = 1;
        }

        public f(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f10379a = 1;
        }

        public f(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f10379a = 1;
        }

        public f(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f10379a = 1;
        }
    }
}
