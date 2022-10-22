package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.view.menu.j;
import androidx.core.view.d0;
import androidx.core.view.n0;
import androidx.core.view.r;
import androidx.core.view.s;
import androidx.core.view.t;
import androidx.core.view.u;
import d.f;
@SuppressLint({"UnknownNullness"})
/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements e0, t, r, s {
    static final int[] F = {d.a.f24714b, 16842841};
    ViewPropertyAnimator A;

    /* renamed from: a  reason: collision with root package name */
    private int f815a;

    /* renamed from: c  reason: collision with root package name */
    private ContentFrameLayout f817c;

    /* renamed from: d  reason: collision with root package name */
    ActionBarContainer f818d;

    /* renamed from: e  reason: collision with root package name */
    private f0 f819e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f820f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f821g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f822h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f823i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f824j;

    /* renamed from: k  reason: collision with root package name */
    boolean f825k;

    /* renamed from: l  reason: collision with root package name */
    private int f826l;

    /* renamed from: m  reason: collision with root package name */
    private int f827m;

    /* renamed from: u  reason: collision with root package name */
    private n0 f835u;

    /* renamed from: v  reason: collision with root package name */
    private n0 f836v;

    /* renamed from: w  reason: collision with root package name */
    private n0 f837w;

    /* renamed from: x  reason: collision with root package name */
    private n0 f838x;

    /* renamed from: y  reason: collision with root package name */
    private d f839y;

    /* renamed from: z  reason: collision with root package name */
    private OverScroller f840z;

    /* renamed from: b  reason: collision with root package name */
    private int f816b = 0;

    /* renamed from: n  reason: collision with root package name */
    private final Rect f828n = new Rect();

    /* renamed from: o  reason: collision with root package name */
    private final Rect f829o = new Rect();

    /* renamed from: p  reason: collision with root package name */
    private final Rect f830p = new Rect();

    /* renamed from: q  reason: collision with root package name */
    private final Rect f831q = new Rect();

    /* renamed from: r  reason: collision with root package name */
    private final Rect f832r = new Rect();

    /* renamed from: s  reason: collision with root package name */
    private final Rect f833s = new Rect();

    /* renamed from: t  reason: collision with root package name */
    private final Rect f834t = new Rect();
    final AnimatorListenerAdapter B = new a();
    private final Runnable C = new b();
    private final Runnable D = new c();
    private final u E = new u(this);

    /* loaded from: classes.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f825k = false;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = null;
            actionBarOverlayLayout.f825k = false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f818d.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionBarOverlayLayout.this.u();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.A = actionBarOverlayLayout.f818d.animate().translationY(-ActionBarOverlayLayout.this.f818d.getHeight()).setListener(ActionBarOverlayLayout.this.B);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();

        void c(boolean z10);

        void d();

        void e();

        void f(int i10);
    }

    /* loaded from: classes.dex */
    public static class e extends ViewGroup.MarginLayoutParams {
        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(int i10, int i11) {
            super(i10, i11);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        n0 n0Var = n0.f2580b;
        this.f835u = n0Var;
        this.f836v = n0Var;
        this.f837w = n0Var;
        this.f838x = n0Var;
        v(context);
    }

    private void A() {
        u();
        this.C.run();
    }

    private boolean B(float f10) {
        this.f840z.fling(0, 0, 0, (int) f10, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return this.f840z.getFinalY() > this.f818d.getHeight();
    }

    private void p() {
        u();
        this.D.run();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean q(View view, Rect rect, boolean z10, boolean z11, boolean z12, boolean z13) {
        boolean z14;
        e eVar = (e) view.getLayoutParams();
        if (z10) {
            int i10 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
            int i11 = rect.left;
            if (i10 != i11) {
                ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i11;
                z14 = true;
                if (z11) {
                    int i12 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                    int i13 = rect.top;
                    if (i12 != i13) {
                        ((ViewGroup.MarginLayoutParams) eVar).topMargin = i13;
                        z14 = true;
                    }
                }
                if (z13) {
                    int i14 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                    int i15 = rect.right;
                    if (i14 != i15) {
                        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i15;
                        z14 = true;
                    }
                }
                if (z12) {
                    int i16 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                    int i17 = rect.bottom;
                    if (i16 != i17) {
                        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i17;
                        return true;
                    }
                }
                return z14;
            }
        }
        z14 = false;
        if (z11) {
        }
        if (z13) {
        }
        if (z12) {
        }
        return z14;
    }

    private f0 t(View view) {
        if (view instanceof f0) {
            return (f0) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    private void v(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(F);
        boolean z10 = false;
        this.f815a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f820f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z10 = true;
        }
        this.f821g = z10;
        this.f840z = new OverScroller(context);
    }

    private void x() {
        u();
        postDelayed(this.D, 600L);
    }

    private void y() {
        u();
        postDelayed(this.C, 600L);
    }

    @Override // androidx.appcompat.widget.e0
    public void a(Menu menu, j.a aVar) {
        z();
        this.f819e.a(menu, aVar);
    }

    @Override // androidx.appcompat.widget.e0
    public boolean b() {
        z();
        return this.f819e.b();
    }

    @Override // androidx.appcompat.widget.e0
    public void c() {
        z();
        this.f819e.c();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean d() {
        z();
        return this.f819e.d();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f820f != null && !this.f821g) {
            int bottom = this.f818d.getVisibility() == 0 ? (int) (this.f818d.getBottom() + this.f818d.getTranslationY() + 0.5f) : 0;
            this.f820f.setBounds(0, bottom, getWidth(), this.f820f.getIntrinsicHeight() + bottom);
            this.f820f.draw(canvas);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public boolean e() {
        z();
        return this.f819e.e();
    }

    @Override // androidx.appcompat.widget.e0
    public boolean f() {
        z();
        return this.f819e.f();
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        z();
        boolean q5 = q(this.f818d, rect, true, true, false, true);
        this.f831q.set(rect);
        e1.a(this, this.f831q, this.f828n);
        if (!this.f832r.equals(this.f831q)) {
            this.f832r.set(this.f831q);
            q5 = true;
        }
        if (!this.f829o.equals(this.f828n)) {
            this.f829o.set(this.f828n);
            q5 = true;
        }
        if (q5) {
            requestLayout();
        }
        return true;
    }

    @Override // androidx.appcompat.widget.e0
    public boolean g() {
        z();
        return this.f819e.g();
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f818d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.E.a();
    }

    public CharSequence getTitle() {
        z();
        return this.f819e.getTitle();
    }

    @Override // androidx.appcompat.widget.e0
    public void h(int i10) {
        z();
        if (i10 == 2) {
            this.f819e.w();
        } else if (i10 == 5) {
            this.f819e.x();
        } else if (i10 == 109) {
            setOverlayMode(true);
        }
    }

    @Override // androidx.appcompat.widget.e0
    public void i() {
        z();
        this.f819e.h();
    }

    @Override // androidx.core.view.s
    public void j(View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        k(view, i10, i11, i12, i13, i14);
    }

    @Override // androidx.core.view.r
    public void k(View view, int i10, int i11, int i12, int i13, int i14) {
        if (i14 == 0) {
            onNestedScroll(view, i10, i11, i12, i13);
        }
    }

    @Override // androidx.core.view.r
    public boolean l(View view, View view2, int i10, int i11) {
        return i11 == 0 && onStartNestedScroll(view, view2, i10);
    }

    @Override // androidx.core.view.r
    public void m(View view, View view2, int i10, int i11) {
        if (i11 == 0) {
            onNestedScrollAccepted(view, view2, i10);
        }
    }

    @Override // androidx.core.view.r
    public void n(View view, int i10) {
        if (i10 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // androidx.core.view.r
    public void o(View view, int i10, int i11, int[] iArr, int i12) {
        if (i12 == 0) {
            onNestedPreScroll(view, i10, i11, iArr);
        }
    }

    @Override // android.view.View
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        z();
        n0 x10 = n0.x(windowInsets, this);
        boolean q5 = q(this.f818d, new Rect(x10.k(), x10.m(), x10.l(), x10.j()), true, true, false, true);
        d0.h(this, x10, this.f828n);
        Rect rect = this.f828n;
        n0 n10 = x10.n(rect.left, rect.top, rect.right, rect.bottom);
        this.f835u = n10;
        boolean z10 = true;
        if (!this.f836v.equals(n10)) {
            this.f836v = this.f835u;
            q5 = true;
        }
        if (!this.f829o.equals(this.f828n)) {
            this.f829o.set(this.f828n);
        } else {
            z10 = q5;
        }
        if (z10) {
            requestLayout();
        }
        return x10.a().c().b().v();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        v(getContext());
        d0.q0(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i15 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i16 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i15, i16, measuredWidth + i15, measuredHeight + i16);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        z();
        measureChildWithMargins(this.f818d, i10, 0, i11, 0);
        e eVar = (e) this.f818d.getLayoutParams();
        int max = Math.max(0, this.f818d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f818d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f818d.getMeasuredState());
        boolean z10 = (d0.Q(this) & 256) != 0;
        if (z10) {
            i12 = this.f815a;
            if (this.f823i && this.f818d.getTabContainer() != null) {
                i12 += this.f815a;
            }
        } else {
            i12 = this.f818d.getVisibility() != 8 ? this.f818d.getMeasuredHeight() : 0;
        }
        this.f830p.set(this.f828n);
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 21) {
            this.f837w = this.f835u;
        } else {
            this.f833s.set(this.f831q);
        }
        if (!this.f822h && !z10) {
            Rect rect = this.f830p;
            rect.top += i12;
            rect.bottom += 0;
            if (i13 >= 21) {
                this.f837w = this.f837w.n(0, i12, 0, 0);
            }
        } else if (i13 >= 21) {
            this.f837w = new n0.b(this.f837w).c(b0.b.b(this.f837w.k(), this.f837w.m() + i12, this.f837w.l(), this.f837w.j() + 0)).a();
        } else {
            Rect rect2 = this.f833s;
            rect2.top += i12;
            rect2.bottom += 0;
        }
        q(this.f817c, this.f830p, true, true, true, true);
        if (i13 >= 21 && !this.f838x.equals(this.f837w)) {
            n0 n0Var = this.f837w;
            this.f838x = n0Var;
            d0.i(this.f817c, n0Var);
        } else if (i13 < 21 && !this.f834t.equals(this.f833s)) {
            this.f834t.set(this.f833s);
            this.f817c.a(this.f833s);
        }
        measureChildWithMargins(this.f817c, i10, 0, i11, 0);
        e eVar2 = (e) this.f817c.getLayoutParams();
        int max3 = Math.max(max, this.f817c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f817c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f817c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(max3 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i10, combineMeasuredStates2), View.resolveSizeAndState(Math.max(max4 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i11, combineMeasuredStates2 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onNestedFling(View view, float f10, float f11, boolean z10) {
        if (!this.f824j || !z10) {
            return false;
        }
        if (B(f11)) {
            p();
        } else {
            A();
        }
        this.f825k = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onNestedPreFling(View view, float f10, float f11) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onNestedPreScroll(View view, int i10, int i11, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onNestedScroll(View view, int i10, int i11, int i12, int i13) {
        int i14 = this.f826l + i11;
        this.f826l = i14;
        setActionBarHideOffset(i14);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onNestedScrollAccepted(View view, View view2, int i10) {
        this.E.b(view, view2, i10);
        this.f826l = getActionBarHideOffset();
        u();
        d dVar = this.f839y;
        if (dVar != null) {
            dVar.e();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public boolean onStartNestedScroll(View view, View view2, int i10) {
        if ((i10 & 2) == 0 || this.f818d.getVisibility() != 0) {
            return false;
        }
        return this.f824j;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.t
    public void onStopNestedScroll(View view) {
        if (this.f824j && !this.f825k) {
            if (this.f826l <= this.f818d.getHeight()) {
                y();
            } else {
                x();
            }
        }
        d dVar = this.f839y;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.view.View
    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i10) {
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i10);
        }
        z();
        int i11 = this.f827m ^ i10;
        this.f827m = i10;
        boolean z10 = false;
        boolean z11 = (i10 & 4) == 0;
        if ((i10 & 256) != 0) {
            z10 = true;
        }
        d dVar = this.f839y;
        if (dVar != null) {
            dVar.c(!z10);
            if (z11 || !z10) {
                this.f839y.a();
            } else {
                this.f839y.d();
            }
        }
        if ((i11 & 256) != 0 && this.f839y != null) {
            d0.q0(this);
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        this.f816b = i10;
        d dVar = this.f839y;
        if (dVar != null) {
            dVar.f(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: r */
    public e generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    /* renamed from: s */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public void setActionBarHideOffset(int i10) {
        u();
        this.f818d.setTranslationY(-Math.max(0, Math.min(i10, this.f818d.getHeight())));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.f839y = dVar;
        if (getWindowToken() != null) {
            this.f839y.f(this.f816b);
            int i10 = this.f827m;
            if (i10 != 0) {
                onWindowSystemUiVisibilityChanged(i10);
                d0.q0(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z10) {
        this.f823i = z10;
    }

    public void setHideOnContentScrollEnabled(boolean z10) {
        if (z10 != this.f824j) {
            this.f824j = z10;
            if (!z10) {
                u();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i10) {
        z();
        this.f819e.setIcon(i10);
    }

    public void setLogo(int i10) {
        z();
        this.f819e.m(i10);
    }

    public void setOverlayMode(boolean z10) {
        this.f822h = z10;
        this.f821g = z10 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z10) {
    }

    public void setUiOptions(int i10) {
    }

    @Override // androidx.appcompat.widget.e0
    public void setWindowCallback(Window.Callback callback) {
        z();
        this.f819e.setWindowCallback(callback);
    }

    @Override // androidx.appcompat.widget.e0
    public void setWindowTitle(CharSequence charSequence) {
        z();
        this.f819e.setWindowTitle(charSequence);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    void u() {
        removeCallbacks(this.C);
        removeCallbacks(this.D);
        ViewPropertyAnimator viewPropertyAnimator = this.A;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public boolean w() {
        return this.f822h;
    }

    void z() {
        if (this.f817c == null) {
            this.f817c = (ContentFrameLayout) findViewById(f.f24790b);
            this.f818d = (ActionBarContainer) findViewById(f.f24791c);
            this.f819e = t(findViewById(f.f24789a));
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        z();
        this.f819e.setIcon(drawable);
    }
}
