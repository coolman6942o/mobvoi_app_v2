package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.LinearLayoutCompat;
/* loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements e.b, k {
    e A;

    /* renamed from: p  reason: collision with root package name */
    private androidx.appcompat.view.menu.e f870p;

    /* renamed from: q  reason: collision with root package name */
    private Context f871q;

    /* renamed from: r  reason: collision with root package name */
    private int f872r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f873s;

    /* renamed from: t  reason: collision with root package name */
    private ActionMenuPresenter f874t;

    /* renamed from: u  reason: collision with root package name */
    private j.a f875u;

    /* renamed from: v  reason: collision with root package name */
    e.a f876v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f877w;

    /* renamed from: x  reason: collision with root package name */
    private int f878x;

    /* renamed from: y  reason: collision with root package name */
    private int f879y;

    /* renamed from: z  reason: collision with root package name */
    private int f880z;

    /* loaded from: classes.dex */
    public interface a {
        boolean a();

        boolean b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements j.a {
        b() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends LinearLayoutCompat.a {
        @ViewDebug.ExportedProperty

        /* renamed from: a  reason: collision with root package name */
        public boolean f881a;
        @ViewDebug.ExportedProperty

        /* renamed from: b  reason: collision with root package name */
        public int f882b;
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public int f883c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f884d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f885e;

        /* renamed from: f  reason: collision with root package name */
        boolean f886f;

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f881a = cVar.f881a;
        }

        public c(int i10, int i11) {
            super(i10, i11);
            this.f881a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements e.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            e eVar2 = ActionMenuView.this.A;
            return eVar2 != null && eVar2.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            e.a aVar = ActionMenuView.this.f876v;
            if (aVar != null) {
                aVar.b(eVar);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface e {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(View view, int i10, int i11, int i12, int i13) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i12) - i13, View.MeasureSpec.getMode(i12));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z10 = true;
        boolean z11 = actionMenuItemView != null && actionMenuItemView.f();
        int i14 = 2;
        if (i11 <= 0 || (z11 && i11 < 2)) {
            i14 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 * i10, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i15 = measuredWidth / i10;
            if (measuredWidth % i10 != 0) {
                i15++;
            }
            if (!z11 || i15 >= 2) {
                i14 = i15;
            }
        }
        if (cVar.f881a || !z11) {
            z10 = false;
        }
        cVar.f884d = z10;
        cVar.f882b = i14;
        view.measure(View.MeasureSpec.makeMeasureSpec(i10 * i14, 1073741824), makeMeasureSpec);
        return i14;
    }

    /* JADX WARN: Type inference failed for: r14v10, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    private void M(int i10, int i11) {
        int i12;
        boolean z10;
        int i13;
        int i14;
        int i15;
        boolean z11;
        boolean z12;
        int i16;
        ?? r14;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i11, paddingTop, -2);
        int i17 = size - paddingLeft;
        int i18 = this.f879y;
        int i19 = i17 / i18;
        int i20 = i17 % i18;
        if (i19 == 0) {
            setMeasuredDimension(i17, 0);
            return;
        }
        int i21 = i18 + (i20 / i19);
        int childCount = getChildCount();
        int i22 = 0;
        boolean z13 = false;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        long j10 = 0;
        for (int i26 = 0; i26 < childCount; i26++) {
            View childAt = getChildAt(i26);
            size2 = size2;
            if (childAt.getVisibility() != 8) {
                boolean z14 = childAt instanceof ActionMenuItemView;
                int i27 = i23 + 1;
                if (z14) {
                    int i28 = this.f880z;
                    i16 = i27;
                    r14 = 0;
                    childAt.setPadding(i28, 0, i28, 0);
                } else {
                    i16 = i27;
                    r14 = 0;
                }
                c cVar = (c) childAt.getLayoutParams();
                cVar.f886f = r14;
                int i29 = r14 == true ? 1 : 0;
                int i30 = r14 == true ? 1 : 0;
                cVar.f883c = i29;
                cVar.f882b = r14;
                cVar.f884d = r14;
                ((LinearLayout.LayoutParams) cVar).leftMargin = r14;
                ((LinearLayout.LayoutParams) cVar).rightMargin = r14;
                cVar.f885e = z14 && ((ActionMenuItemView) childAt).f();
                int L = L(childAt, i21, cVar.f881a ? 1 : i19, childMeasureSpec, paddingTop);
                i24 = Math.max(i24, L);
                if (cVar.f884d) {
                    i25++;
                }
                if (cVar.f881a) {
                    z13 = true;
                }
                i19 -= L;
                i22 = Math.max(i22, childAt.getMeasuredHeight());
                if (L == 1) {
                    j10 |= 1 << i26;
                    i22 = i22;
                }
                i23 = i16;
            }
        }
        int i31 = size2;
        boolean z15 = z13 && i23 == 2;
        boolean z16 = false;
        while (i25 > 0 && i19 > 0) {
            int i32 = Integer.MAX_VALUE;
            int i33 = 0;
            long j11 = 0;
            for (int i34 = 0; i34 < childCount; i34++) {
                z16 = z16;
                c cVar2 = (c) getChildAt(i34).getLayoutParams();
                i22 = i22;
                if (cVar2.f884d) {
                    int i35 = cVar2.f882b;
                    if (i35 < i32) {
                        j11 = 1 << i34;
                        i32 = i35;
                        i33 = 1;
                    } else if (i35 == i32) {
                        j11 |= 1 << i34;
                        i33++;
                    }
                }
            }
            z10 = z16;
            i13 = i22;
            j10 |= j11;
            if (i33 > i19) {
                i14 = mode;
                i12 = i17;
                break;
            }
            int i36 = i32 + 1;
            int i37 = 0;
            while (i37 < childCount) {
                View childAt2 = getChildAt(i37);
                c cVar3 = (c) childAt2.getLayoutParams();
                i17 = i17;
                mode = mode;
                long j12 = 1 << i37;
                if ((j11 & j12) == 0) {
                    if (cVar3.f882b == i36) {
                        j10 |= j12;
                    }
                    z12 = z15;
                } else {
                    if (!z15 || !cVar3.f885e || i19 != 1) {
                        z12 = z15;
                    } else {
                        int i38 = this.f880z;
                        z12 = z15;
                        childAt2.setPadding(i38 + i21, 0, i38, 0);
                    }
                    cVar3.f882b++;
                    cVar3.f886f = true;
                    i19--;
                }
                i37++;
                z15 = z12;
            }
            i22 = i13;
            z16 = true;
        }
        i14 = mode;
        i12 = i17;
        z10 = z16;
        i13 = i22;
        boolean z17 = !z13 && i23 == 1;
        if (i19 <= 0 || j10 == 0 || (i19 >= i23 - 1 && !z17 && i24 <= 1)) {
            i15 = 0;
            z11 = z10;
        } else {
            float bitCount = Long.bitCount(j10);
            if (!z17) {
                i15 = 0;
                if ((j10 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f885e) {
                    bitCount -= 0.5f;
                }
                int i39 = childCount - 1;
                if ((j10 & (1 << i39)) != 0 && !((c) getChildAt(i39).getLayoutParams()).f885e) {
                    bitCount -= 0.5f;
                }
            } else {
                i15 = 0;
            }
            int i40 = bitCount > 0.0f ? (int) ((i19 * i21) / bitCount) : i15;
            z11 = z10;
            for (int i41 = i15; i41 < childCount; i41++) {
                if ((j10 & (1 << i41)) != 0) {
                    View childAt3 = getChildAt(i41);
                    c cVar4 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar4.f883c = i40;
                        cVar4.f886f = true;
                        if (i41 == 0 && !cVar4.f885e) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = (-i40) / 2;
                        }
                        z11 = true;
                    } else if (cVar4.f881a) {
                        cVar4.f883c = i40;
                        cVar4.f886f = true;
                        ((LinearLayout.LayoutParams) cVar4).rightMargin = (-i40) / 2;
                        z11 = true;
                    } else {
                        if (i41 != 0) {
                            ((LinearLayout.LayoutParams) cVar4).leftMargin = i40 / 2;
                        }
                        if (i41 != childCount - 1) {
                            ((LinearLayout.LayoutParams) cVar4).rightMargin = i40 / 2;
                        }
                    }
                }
            }
        }
        if (z11) {
            for (int i42 = i15; i42 < childCount; i42++) {
                View childAt4 = getChildAt(i42);
                c cVar5 = (c) childAt4.getLayoutParams();
                if (cVar5.f886f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar5.f882b * i21) + cVar5.f883c, 1073741824), childMeasureSpec);
                }
            }
        }
        if (i14 != 1073741824) {
            i31 = i13;
        }
        setMeasuredDimension(i12, i31);
    }

    public void B() {
        ActionMenuPresenter actionMenuPresenter = this.f874t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.A();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C */
    public c m() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    /* renamed from: D */
    public c n(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: E */
    public c o(ViewGroup.LayoutParams layoutParams) {
        c cVar;
        if (layoutParams == null) {
            return m();
        }
        if (layoutParams instanceof c) {
            cVar = new c((c) layoutParams);
        } else {
            cVar = new c(layoutParams);
        }
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public c F() {
        c C = m();
        C.f881a = true;
        return C;
    }

    protected boolean G(int i10) {
        boolean z10 = false;
        if (i10 == 0) {
            return false;
        }
        View childAt = getChildAt(i10 - 1);
        View childAt2 = getChildAt(i10);
        if (i10 < getChildCount() && (childAt instanceof a)) {
            z10 = false | ((a) childAt).a();
        }
        return (i10 <= 0 || !(childAt2 instanceof a)) ? z10 : z10 | ((a) childAt2).b();
    }

    public boolean H() {
        ActionMenuPresenter actionMenuPresenter = this.f874t;
        return actionMenuPresenter != null && actionMenuPresenter.D();
    }

    public boolean I() {
        ActionMenuPresenter actionMenuPresenter = this.f874t;
        return actionMenuPresenter != null && actionMenuPresenter.F();
    }

    public boolean J() {
        ActionMenuPresenter actionMenuPresenter = this.f874t;
        return actionMenuPresenter != null && actionMenuPresenter.G();
    }

    public boolean K() {
        return this.f873s;
    }

    public androidx.appcompat.view.menu.e N() {
        return this.f870p;
    }

    public void O(j.a aVar, e.a aVar2) {
        this.f875u = aVar;
        this.f876v = aVar2;
    }

    public boolean P() {
        ActionMenuPresenter actionMenuPresenter = this.f874t;
        return actionMenuPresenter != null && actionMenuPresenter.M();
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(g gVar) {
        return this.f870p.N(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(androidx.appcompat.view.menu.e eVar) {
        this.f870p = eVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public Menu getMenu() {
        if (this.f870p == null) {
            Context context = getContext();
            androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
            this.f870p = eVar;
            eVar.V(new d());
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.f874t = actionMenuPresenter;
            actionMenuPresenter.L(true);
            ActionMenuPresenter actionMenuPresenter2 = this.f874t;
            j.a aVar = this.f875u;
            if (aVar == null) {
                aVar = new b();
            }
            actionMenuPresenter2.h(aVar);
            this.f870p.c(this.f874t, this.f871q);
            this.f874t.J(this);
        }
        return this.f870p;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f874t.C();
    }

    public int getPopupTheme() {
        return this.f872r;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.f874t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.d(false);
            if (this.f874t.G()) {
                this.f874t.D();
                this.f874t.M();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        B();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        if (!this.f877w) {
            super.onLayout(z10, i10, i11, i12, i13);
            return;
        }
        int childCount = getChildCount();
        int i16 = (i13 - i11) / 2;
        int dividerWidth = getDividerWidth();
        int i17 = i12 - i10;
        int paddingRight = (i17 - getPaddingRight()) - getPaddingLeft();
        boolean b10 = e1.b(this);
        int i18 = 0;
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt = getChildAt(i20);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f881a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (G(i20)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (b10) {
                        i14 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        i15 = i14 + measuredWidth;
                    } else {
                        i15 = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        i14 = i15 - measuredWidth;
                    }
                    int i21 = i16 - (measuredHeight / 2);
                    childAt.layout(i14, i21, i15, measuredHeight + i21);
                    paddingRight -= measuredWidth;
                    i18 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    G(i20);
                    i19++;
                }
            }
        }
        if (childCount == 1 && i18 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i22 = (i17 / 2) - (measuredWidth2 / 2);
            int i23 = i16 - (measuredHeight2 / 2);
            childAt2.layout(i22, i23, measuredWidth2 + i22, measuredHeight2 + i23);
            return;
        }
        int i24 = i19 - (i18 ^ 1);
        int max = Math.max(0, i24 > 0 ? paddingRight / i24 : 0);
        if (b10) {
            int width = getWidth() - getPaddingRight();
            for (int i25 = 0; i25 < childCount; i25++) {
                View childAt3 = getChildAt(i25);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f881a) {
                    int i26 = width - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i27 = i16 - (measuredHeight3 / 2);
                    childAt3.layout(i26 - measuredWidth3, i27, i26, measuredHeight3 + i27);
                    width = i26 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i28 = 0; i28 < childCount; i28++) {
            View childAt4 = getChildAt(i28);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f881a) {
                int i29 = paddingLeft + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i30 = i16 - (measuredHeight4 / 2);
                childAt4.layout(i29, i30, i29 + measuredWidth4, measuredHeight4 + i30);
                paddingLeft = i29 + measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + max;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i10, int i11) {
        androidx.appcompat.view.menu.e eVar;
        boolean z10 = this.f877w;
        boolean z11 = View.MeasureSpec.getMode(i10) == 1073741824;
        this.f877w = z11;
        if (z10 != z11) {
            this.f878x = 0;
        }
        int size = View.MeasureSpec.getSize(i10);
        if (!(!this.f877w || (eVar = this.f870p) == null || size == this.f878x)) {
            this.f878x = size;
            eVar.M(true);
        }
        int childCount = getChildCount();
        if (!this.f877w || childCount <= 0) {
            for (int i12 = 0; i12 < childCount; i12++) {
                c cVar = (c) getChildAt(i12).getLayoutParams();
                ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
            }
            super.onMeasure(i10, i11);
            return;
        }
        M(i10, i11);
    }

    public void setExpandedActionViewsExclusive(boolean z10) {
        this.f874t.I(z10);
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.A = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f874t.K(drawable);
    }

    public void setOverflowReserved(boolean z10) {
        this.f873s = z10;
    }

    public void setPopupTheme(int i10) {
        if (this.f872r != i10) {
            this.f872r = i10;
            if (i10 == 0) {
                this.f871q = getContext();
            } else {
                this.f871q = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f874t = actionMenuPresenter;
        actionMenuPresenter.J(this);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.f879y = (int) (56.0f * f10);
        this.f880z = (int) (f10 * 4.0f);
        this.f871q = context;
        this.f872r = 0;
    }
}
