package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.d0;
import androidx.core.view.i;
import androidx.core.view.l;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class Toolbar extends ViewGroup {
    private ColorStateList A;
    private boolean B;
    private boolean C;
    private final ArrayList<View> D;
    private final ArrayList<View> E;
    private final int[] F;
    final l G;
    private ArrayList<MenuItem> H;
    f I;
    private final ActionMenuView.e J;
    private z0 K;
    private ActionMenuPresenter L;
    private d M;
    private j.a N;
    private e.a O;
    private boolean P;
    private final Runnable Q;

    /* renamed from: a  reason: collision with root package name */
    private ActionMenuView f1020a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f1021b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f1022c;

    /* renamed from: d  reason: collision with root package name */
    private ImageButton f1023d;

    /* renamed from: e  reason: collision with root package name */
    private ImageView f1024e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f1025f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f1026g;

    /* renamed from: h  reason: collision with root package name */
    ImageButton f1027h;

    /* renamed from: i  reason: collision with root package name */
    View f1028i;

    /* renamed from: j  reason: collision with root package name */
    private Context f1029j;

    /* renamed from: k  reason: collision with root package name */
    private int f1030k;

    /* renamed from: l  reason: collision with root package name */
    private int f1031l;

    /* renamed from: m  reason: collision with root package name */
    private int f1032m;

    /* renamed from: n  reason: collision with root package name */
    int f1033n;

    /* renamed from: o  reason: collision with root package name */
    private int f1034o;

    /* renamed from: p  reason: collision with root package name */
    private int f1035p;

    /* renamed from: q  reason: collision with root package name */
    private int f1036q;

    /* renamed from: r  reason: collision with root package name */
    private int f1037r;

    /* renamed from: s  reason: collision with root package name */
    private int f1038s;

    /* renamed from: t  reason: collision with root package name */
    private p0 f1039t;

    /* renamed from: u  reason: collision with root package name */
    private int f1040u;

    /* renamed from: v  reason: collision with root package name */
    private int f1041v;

    /* renamed from: w  reason: collision with root package name */
    private int f1042w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f1043x;

    /* renamed from: y  reason: collision with root package name */
    private CharSequence f1044y;

    /* renamed from: z  reason: collision with root package name */
    private ColorStateList f1045z;

    /* loaded from: classes.dex */
    class a implements ActionMenuView.e {
        a() {
        }

        @Override // androidx.appcompat.widget.ActionMenuView.e
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (Toolbar.this.G.i(menuItem)) {
                return true;
            }
            f fVar = Toolbar.this.I;
            if (fVar != null) {
                return fVar.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.Q();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Toolbar.this.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d implements j {

        /* renamed from: a  reason: collision with root package name */
        androidx.appcompat.view.menu.e f1051a;

        /* renamed from: b  reason: collision with root package name */
        g f1052b;

        d() {
        }

        @Override // androidx.appcompat.view.menu.j
        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
        }

        @Override // androidx.appcompat.view.menu.j
        public void d(boolean z10) {
            if (this.f1052b != null) {
                androidx.appcompat.view.menu.e eVar = this.f1051a;
                boolean z11 = false;
                if (eVar != null) {
                    int size = eVar.size();
                    int i10 = 0;
                    while (true) {
                        if (i10 >= size) {
                            break;
                        } else if (this.f1051a.getItem(i10) == this.f1052b) {
                            z11 = true;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z11) {
                    f(this.f1051a, this.f1052b);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean e() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean f(androidx.appcompat.view.menu.e eVar, g gVar) {
            View view = Toolbar.this.f1028i;
            if (view instanceof i.c) {
                ((i.c) view).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f1028i);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f1027h);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f1028i = null;
            toolbar3.a();
            this.f1052b = null;
            Toolbar.this.requestLayout();
            gVar.r(false);
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean g(androidx.appcompat.view.menu.e eVar, g gVar) {
            Toolbar.this.g();
            ViewParent parent = Toolbar.this.f1027h.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1027h);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f1027h);
            }
            Toolbar.this.f1028i = gVar.getActionView();
            this.f1052b = gVar;
            ViewParent parent2 = Toolbar.this.f1028i.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f1028i);
                }
                e m10 = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                m10.f512a = 8388611 | (toolbar4.f1033n & 112);
                m10.f1054b = 2;
                toolbar4.f1028i.setLayoutParams(m10);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f1028i);
            }
            Toolbar.this.I();
            Toolbar.this.requestLayout();
            gVar.r(true);
            View view = Toolbar.this.f1028i;
            if (view instanceof i.c) {
                ((i.c) view).c();
            }
            return true;
        }

        @Override // androidx.appcompat.view.menu.j
        public int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.j
        public void i(Context context, androidx.appcompat.view.menu.e eVar) {
            g gVar;
            androidx.appcompat.view.menu.e eVar2 = this.f1051a;
            if (!(eVar2 == null || (gVar = this.f1052b) == null)) {
                eVar2.f(gVar);
            }
            this.f1051a = eVar;
        }

        @Override // androidx.appcompat.view.menu.j
        public void j(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.j
        public boolean l(m mVar) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.j
        public Parcelable m() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.Q);
    }

    private int C(View view, int i10, int[] iArr, int i11) {
        e eVar = (e) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = i10 + Math.max(0, i12);
        iArr[0] = Math.max(0, -i12);
        int q5 = q(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, q5, max + measuredWidth, view.getMeasuredHeight() + q5);
        return max + measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
    }

    private int D(View view, int i10, int[] iArr, int i11) {
        e eVar = (e) view.getLayoutParams();
        int i12 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i10 - Math.max(0, i12);
        iArr[1] = Math.max(0, -i12);
        int q5 = q(view, i11);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, q5, max, view.getMeasuredHeight() + q5);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    private int E(View view, int i10, int i11, int i12, int i13, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i14 = marginLayoutParams.leftMargin - iArr[0];
        int i15 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i14) + Math.max(0, i15);
        iArr[0] = Math.max(0, -i14);
        iArr[1] = Math.max(0, -i15);
        view.measure(ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + max + i11, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    private void F(View view, int i10, int i11, int i12, int i13, int i14) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i11, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i12, getPaddingTop() + getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i13, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i14 >= 0) {
            if (mode != 0) {
                i14 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i14);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i14, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    private void G() {
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        this.G.h(getMenu(), getMenuInflater());
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.H = currentMenuItems2;
    }

    private void H() {
        removeCallbacks(this.Q);
        post(this.Q);
    }

    private boolean O() {
        if (!this.P) {
            return false;
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (P(childAt) && childAt.getMeasuredWidth() > 0 && childAt.getMeasuredHeight() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean P(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    private void b(List<View> list, int i10) {
        boolean z10 = d0.E(this) == 1;
        int childCount = getChildCount();
        int b10 = androidx.core.view.f.b(i10, d0.E(this));
        list.clear();
        if (z10) {
            for (int i11 = childCount - 1; i11 >= 0; i11--) {
                View childAt = getChildAt(i11);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f1054b == 0 && P(childAt) && p(eVar.f512a) == b10) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f1054b == 0 && P(childAt2) && p(eVar2.f512a) == b10) {
                list.add(childAt2);
            }
        }
    }

    private void c(View view, boolean z10) {
        e eVar;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            eVar = generateDefaultLayoutParams();
        } else if (!checkLayoutParams(layoutParams)) {
            eVar = generateLayoutParams(layoutParams);
        } else {
            eVar = (e) layoutParams;
        }
        eVar.f1054b = 1;
        if (!z10 || this.f1028i == null) {
            addView(view, eVar);
            return;
        }
        view.setLayoutParams(eVar);
        this.E.add(view);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i10 = 0; i10 < menu.size(); i10++) {
            arrayList.add(menu.getItem(i10));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new i.g(getContext());
    }

    private void h() {
        if (this.f1039t == null) {
            this.f1039t = new p0();
        }
    }

    private void i() {
        if (this.f1024e == null) {
            this.f1024e = new q(getContext());
        }
    }

    private void j() {
        k();
        if (this.f1020a.N() == null) {
            androidx.appcompat.view.menu.e eVar = (androidx.appcompat.view.menu.e) this.f1020a.getMenu();
            if (this.M == null) {
                this.M = new d();
            }
            this.f1020a.setExpandedActionViewsExclusive(true);
            eVar.c(this.M, this.f1029j);
        }
    }

    private void k() {
        if (this.f1020a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext());
            this.f1020a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1030k);
            this.f1020a.setOnMenuItemClickListener(this.J);
            this.f1020a.O(this.N, this.O);
            e m10 = generateDefaultLayoutParams();
            m10.f512a = 8388613 | (this.f1033n & 112);
            this.f1020a.setLayoutParams(m10);
            c(this.f1020a, false);
        }
    }

    private void l() {
        if (this.f1023d == null) {
            this.f1023d = new o(getContext(), null, d.a.P);
            e m10 = generateDefaultLayoutParams();
            m10.f512a = 8388611 | (this.f1033n & 112);
            this.f1023d.setLayoutParams(m10);
        }
    }

    private int p(int i10) {
        int E = d0.E(this);
        int b10 = androidx.core.view.f.b(i10, E) & 7;
        return (b10 == 1 || b10 == 3 || b10 == 5) ? b10 : E == 1 ? 5 : 3;
    }

    private int q(View view, int i10) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i11 = i10 > 0 ? (measuredHeight - i10) / 2 : 0;
        int r10 = r(eVar.f512a);
        if (r10 == 48) {
            return getPaddingTop() - i11;
        }
        if (r10 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i11;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i12 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i13 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (i12 < i13) {
            i12 = i13;
        } else {
            int i14 = (((height - paddingBottom) - measuredHeight) - i12) - paddingTop;
            int i15 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i14 < i15) {
                i12 = Math.max(0, i12 - (i15 - i14));
            }
        }
        return paddingTop + i12;
    }

    private int r(int i10) {
        int i11 = i10 & 112;
        return (i11 == 16 || i11 == 48 || i11 == 80) ? i11 : this.f1042w & 112;
    }

    private int s(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return i.b(marginLayoutParams) + i.a(marginLayoutParams);
    }

    private int t(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int u(List<View> list, int[] iArr) {
        int i10 = iArr[0];
        int i11 = iArr[1];
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        while (i12 < size) {
            View view = list.get(i12);
            e eVar = (e) view.getLayoutParams();
            int i14 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - i10;
            int i15 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - i11;
            int max = Math.max(0, i14);
            int max2 = Math.max(0, i15);
            int max3 = Math.max(0, -i14);
            int max4 = Math.max(0, -i15);
            i13 += max + view.getMeasuredWidth() + max2;
            i12++;
            i11 = max4;
            i10 = max3;
        }
        return i13;
    }

    private boolean z(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    public boolean A() {
        ActionMenuView actionMenuView = this.f1020a;
        return actionMenuView != null && actionMenuView.I();
    }

    public boolean B() {
        ActionMenuView actionMenuView = this.f1020a;
        return actionMenuView != null && actionMenuView.J();
    }

    void I() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (!(((e) childAt.getLayoutParams()).f1054b == 2 || childAt == this.f1020a)) {
                removeViewAt(childCount);
                this.E.add(childAt);
            }
        }
    }

    public void J(int i10, int i11) {
        h();
        this.f1039t.g(i10, i11);
    }

    public void K(androidx.appcompat.view.menu.e eVar, ActionMenuPresenter actionMenuPresenter) {
        if (eVar != null || this.f1020a != null) {
            k();
            androidx.appcompat.view.menu.e N = this.f1020a.N();
            if (N != eVar) {
                if (N != null) {
                    N.Q(this.L);
                    N.Q(this.M);
                }
                if (this.M == null) {
                    this.M = new d();
                }
                actionMenuPresenter.I(true);
                if (eVar != null) {
                    eVar.c(actionMenuPresenter, this.f1029j);
                    eVar.c(this.M, this.f1029j);
                } else {
                    actionMenuPresenter.i(this.f1029j, null);
                    this.M.i(this.f1029j, null);
                    actionMenuPresenter.d(true);
                    this.M.d(true);
                }
                this.f1020a.setPopupTheme(this.f1030k);
                this.f1020a.setPresenter(actionMenuPresenter);
                this.L = actionMenuPresenter;
            }
        }
    }

    public void L(j.a aVar, e.a aVar2) {
        this.N = aVar;
        this.O = aVar2;
        ActionMenuView actionMenuView = this.f1020a;
        if (actionMenuView != null) {
            actionMenuView.O(aVar, aVar2);
        }
    }

    public void M(Context context, int i10) {
        this.f1032m = i10;
        TextView textView = this.f1022c;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public void N(Context context, int i10) {
        this.f1031l = i10;
        TextView textView = this.f1021b;
        if (textView != null) {
            textView.setTextAppearance(context, i10);
        }
    }

    public boolean Q() {
        ActionMenuView actionMenuView = this.f1020a;
        return actionMenuView != null && actionMenuView.P();
    }

    void a() {
        for (int size = this.E.size() - 1; size >= 0; size--) {
            addView(this.E.get(size));
        }
        this.E.clear();
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public boolean d() {
        ActionMenuView actionMenuView;
        return getVisibility() == 0 && (actionMenuView = this.f1020a) != null && actionMenuView.K();
    }

    public void e() {
        d dVar = this.M;
        g gVar = dVar == null ? null : dVar.f1052b;
        if (gVar != null) {
            gVar.collapseActionView();
        }
    }

    public void f() {
        ActionMenuView actionMenuView = this.f1020a;
        if (actionMenuView != null) {
            actionMenuView.B();
        }
    }

    void g() {
        if (this.f1027h == null) {
            o oVar = new o(getContext(), null, d.a.P);
            this.f1027h = oVar;
            oVar.setImageDrawable(this.f1025f);
            this.f1027h.setContentDescription(this.f1026g);
            e m10 = generateDefaultLayoutParams();
            m10.f512a = 8388611 | (this.f1033n & 112);
            m10.f1054b = 2;
            this.f1027h.setLayoutParams(m10);
            this.f1027h.setOnClickListener(new c());
        }
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f1027h;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f1027h;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        p0 p0Var = this.f1039t;
        if (p0Var != null) {
            return p0Var.a();
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i10 = this.f1041v;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        p0 p0Var = this.f1039t;
        if (p0Var != null) {
            return p0Var.b();
        }
        return 0;
    }

    public int getContentInsetRight() {
        p0 p0Var = this.f1039t;
        if (p0Var != null) {
            return p0Var.c();
        }
        return 0;
    }

    public int getContentInsetStart() {
        p0 p0Var = this.f1039t;
        if (p0Var != null) {
            return p0Var.d();
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i10 = this.f1040u;
        return i10 != Integer.MIN_VALUE ? i10 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        androidx.appcompat.view.menu.e N;
        ActionMenuView actionMenuView = this.f1020a;
        if ((actionMenuView == null || (N = actionMenuView.N()) == null || !N.hasVisibleItems()) ? false : true) {
            return Math.max(getContentInsetEnd(), Math.max(this.f1041v, 0));
        }
        return getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        if (d0.E(this) == 1) {
            return getCurrentContentInsetEnd();
        }
        return getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        if (d0.E(this) == 1) {
            return getCurrentContentInsetStart();
        }
        return getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        if (getNavigationIcon() != null) {
            return Math.max(getContentInsetStart(), Math.max(this.f1040u, 0));
        }
        return getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f1024e;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f1024e;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        j();
        return this.f1020a.getMenu();
    }

    View getNavButtonView() {
        return this.f1023d;
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f1023d;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f1023d;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.L;
    }

    public Drawable getOverflowIcon() {
        j();
        return this.f1020a.getOverflowIcon();
    }

    Context getPopupContext() {
        return this.f1029j;
    }

    public int getPopupTheme() {
        return this.f1030k;
    }

    public CharSequence getSubtitle() {
        return this.f1044y;
    }

    final TextView getSubtitleTextView() {
        return this.f1022c;
    }

    public CharSequence getTitle() {
        return this.f1043x;
    }

    public int getTitleMarginBottom() {
        return this.f1038s;
    }

    public int getTitleMarginEnd() {
        return this.f1036q;
    }

    public int getTitleMarginStart() {
        return this.f1035p;
    }

    public int getTitleMarginTop() {
        return this.f1037r;
    }

    final TextView getTitleTextView() {
        return this.f1021b;
    }

    public f0 getWrapper() {
        if (this.K == null) {
            this.K = new z0(this, true);
        }
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: m */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    /* renamed from: n */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof e) {
            return new e((e) layoutParams);
        }
        if (layoutParams instanceof a.C0005a) {
            return new e((a.C0005a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new e((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new e(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Q);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:104:0x029f A[LOOP:0: B:103:0x029d->B:104:0x029f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02c1 A[LOOP:1: B:106:0x02bf->B:107:0x02c1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02fa A[LOOP:2: B:114:0x02f8->B:115:0x02fa, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0227  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        boolean P;
        boolean P2;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int size;
        int i22;
        int size2;
        int i23;
        int i24;
        int size3;
        TextView textView;
        TextView textView2;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        boolean z11 = d0.E(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i33 = width - paddingRight;
        int[] iArr = this.F;
        iArr[1] = 0;
        iArr[0] = 0;
        int F = d0.F(this);
        int min = F >= 0 ? Math.min(F, i13 - i11) : 0;
        if (!P(this.f1023d)) {
            i15 = paddingLeft;
        } else if (z11) {
            i14 = D(this.f1023d, i33, iArr, min);
            i15 = paddingLeft;
            if (P(this.f1027h)) {
                if (z11) {
                    i14 = D(this.f1027h, i14, iArr, min);
                } else {
                    i15 = C(this.f1027h, i15, iArr, min);
                }
            }
            if (P(this.f1020a)) {
                if (z11) {
                    i15 = C(this.f1020a, i15, iArr, min);
                } else {
                    i14 = D(this.f1020a, i14, iArr, min);
                }
            }
            int currentContentInsetLeft = getCurrentContentInsetLeft();
            int currentContentInsetRight = getCurrentContentInsetRight();
            iArr[0] = Math.max(0, currentContentInsetLeft - i15);
            iArr[1] = Math.max(0, currentContentInsetRight - (i33 - i14));
            int max = Math.max(i15, currentContentInsetLeft);
            int min2 = Math.min(i14, i33 - currentContentInsetRight);
            if (P(this.f1028i)) {
                if (z11) {
                    min2 = D(this.f1028i, min2, iArr, min);
                } else {
                    max = C(this.f1028i, max, iArr, min);
                }
            }
            if (P(this.f1024e)) {
                if (z11) {
                    min2 = D(this.f1024e, min2, iArr, min);
                } else {
                    max = C(this.f1024e, max, iArr, min);
                }
            }
            P = P(this.f1021b);
            P2 = P(this.f1022c);
            if (!P) {
                e eVar = (e) this.f1021b.getLayoutParams();
                i16 = paddingRight;
                i17 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + this.f1021b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin + 0;
            } else {
                i16 = paddingRight;
                i17 = 0;
            }
            if (!P2) {
                e eVar2 = (e) this.f1022c.getLayoutParams();
                i18 = width;
                i17 += ((ViewGroup.MarginLayoutParams) eVar2).topMargin + this.f1022c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin;
            } else {
                i18 = width;
            }
            if (!P || P2) {
                if (!P) {
                    textView = this.f1021b;
                } else {
                    textView = this.f1022c;
                }
                if (!P2) {
                    textView2 = this.f1022c;
                } else {
                    textView2 = this.f1021b;
                }
                e eVar3 = (e) textView.getLayoutParams();
                e eVar4 = (e) textView2.getLayoutParams();
                boolean z12 = (!P && this.f1021b.getMeasuredWidth() > 0) || (P2 && this.f1022c.getMeasuredWidth() > 0);
                i25 = this.f1042w & 112;
                i20 = paddingLeft;
                if (i25 != 48) {
                    i26 = max;
                    i19 = min;
                    i27 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin + this.f1037r;
                } else if (i25 != 80) {
                    int i34 = (((height - paddingTop) - paddingBottom) - i17) / 2;
                    int i35 = ((ViewGroup.MarginLayoutParams) eVar3).topMargin;
                    i19 = min;
                    int i36 = this.f1037r;
                    i26 = max;
                    if (i34 < i35 + i36) {
                        i34 = i35 + i36;
                    } else {
                        int i37 = (((height - paddingBottom) - i17) - i34) - paddingTop;
                        int i38 = ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin;
                        int i39 = this.f1038s;
                        if (i37 < i38 + i39) {
                            i34 = Math.max(0, i34 - ((((ViewGroup.MarginLayoutParams) eVar4).bottomMargin + i39) - i37));
                        }
                    }
                    i27 = paddingTop + i34;
                } else {
                    i26 = max;
                    i19 = min;
                    i27 = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin) - this.f1038s) - i17;
                }
                if (!z11) {
                    int i40 = (z12 ? this.f1035p : 0) - iArr[1];
                    min2 -= Math.max(0, i40);
                    iArr[1] = Math.max(0, -i40);
                    if (P) {
                        int measuredWidth = min2 - this.f1021b.getMeasuredWidth();
                        int measuredHeight = this.f1021b.getMeasuredHeight() + i27;
                        this.f1021b.layout(measuredWidth, i27, min2, measuredHeight);
                        i31 = measuredWidth - this.f1036q;
                        i27 = measuredHeight + ((ViewGroup.MarginLayoutParams) ((e) this.f1021b.getLayoutParams())).bottomMargin;
                    } else {
                        i31 = min2;
                    }
                    if (P2) {
                        int i41 = i27 + ((ViewGroup.MarginLayoutParams) ((e) this.f1022c.getLayoutParams())).topMargin;
                        this.f1022c.layout(min2 - this.f1022c.getMeasuredWidth(), i41, min2, this.f1022c.getMeasuredHeight() + i41);
                        i32 = min2 - this.f1036q;
                    } else {
                        i32 = min2;
                    }
                    if (z12) {
                        min2 = Math.min(i31, i32);
                    }
                    max = i26;
                } else {
                    if (z12) {
                        i28 = this.f1035p;
                        i21 = 0;
                    } else {
                        i21 = 0;
                        i28 = 0;
                    }
                    int i42 = i28 - iArr[i21];
                    max = i26 + Math.max(i21, i42);
                    iArr[i21] = Math.max(i21, -i42);
                    if (P) {
                        int measuredWidth2 = this.f1021b.getMeasuredWidth() + max;
                        int measuredHeight2 = this.f1021b.getMeasuredHeight() + i27;
                        this.f1021b.layout(max, i27, measuredWidth2, measuredHeight2);
                        i29 = measuredWidth2 + this.f1036q;
                        i27 = measuredHeight2 + ((ViewGroup.MarginLayoutParams) ((e) this.f1021b.getLayoutParams())).bottomMargin;
                    } else {
                        i29 = max;
                    }
                    if (P2) {
                        int i43 = i27 + ((ViewGroup.MarginLayoutParams) ((e) this.f1022c.getLayoutParams())).topMargin;
                        int measuredWidth3 = this.f1022c.getMeasuredWidth() + max;
                        this.f1022c.layout(max, i43, measuredWidth3, this.f1022c.getMeasuredHeight() + i43);
                        i30 = measuredWidth3 + this.f1036q;
                    } else {
                        i30 = max;
                    }
                    if (z12) {
                        max = Math.max(i29, i30);
                    }
                    b(this.D, 3);
                    size = this.D.size();
                    for (i22 = i21; i22 < size; i22++) {
                        max = C(this.D.get(i22), max, iArr, i19);
                    }
                    int i44 = i19;
                    b(this.D, 5);
                    size2 = this.D.size();
                    for (i23 = i21; i23 < size2; i23++) {
                        min2 = D(this.D.get(i23), min2, iArr, i44);
                    }
                    b(this.D, 1);
                    int u10 = u(this.D, iArr);
                    i24 = (i20 + (((i18 - i20) - i16) / 2)) - (u10 / 2);
                    int i45 = u10 + i24;
                    if (i24 >= max) {
                        max = i45 > min2 ? i24 - (i45 - min2) : i24;
                    }
                    size3 = this.D.size();
                    while (i21 < size3) {
                        max = C(this.D.get(i21), max, iArr, i44);
                        i21++;
                    }
                    this.D.clear();
                    return;
                }
            } else {
                i20 = paddingLeft;
                i19 = min;
            }
            i21 = 0;
            b(this.D, 3);
            size = this.D.size();
            while (i22 < size) {
            }
            int i442 = i19;
            b(this.D, 5);
            size2 = this.D.size();
            while (i23 < size2) {
            }
            b(this.D, 1);
            int u102 = u(this.D, iArr);
            i24 = (i20 + (((i18 - i20) - i16) / 2)) - (u102 / 2);
            int i452 = u102 + i24;
            if (i24 >= max) {
            }
            size3 = this.D.size();
            while (i21 < size3) {
            }
            this.D.clear();
            return;
        } else {
            i15 = C(this.f1023d, paddingLeft, iArr, min);
        }
        i14 = i33;
        if (P(this.f1027h)) {
        }
        if (P(this.f1020a)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i15);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i33 - i14));
        int max2 = Math.max(i15, currentContentInsetLeft2);
        int min22 = Math.min(i14, i33 - currentContentInsetRight2);
        if (P(this.f1028i)) {
        }
        if (P(this.f1024e)) {
        }
        P = P(this.f1021b);
        P2 = P(this.f1022c);
        if (!P) {
        }
        if (!P2) {
        }
        if (!P) {
        }
        if (!P) {
        }
        if (!P2) {
        }
        e eVar32 = (e) textView.getLayoutParams();
        e eVar42 = (e) textView2.getLayoutParams();
        if (!P) {
        }
        i25 = this.f1042w & 112;
        i20 = paddingLeft;
        if (i25 != 48) {
        }
        if (!z11) {
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int[] iArr = this.F;
        boolean b10 = e1.b(this);
        int i19 = 0;
        int i20 = !b10 ? 1 : 0;
        if (P(this.f1023d)) {
            F(this.f1023d, i10, 0, i11, 0, this.f1034o);
            i14 = this.f1023d.getMeasuredWidth() + s(this.f1023d);
            i13 = Math.max(0, this.f1023d.getMeasuredHeight() + t(this.f1023d));
            i12 = View.combineMeasuredStates(0, this.f1023d.getMeasuredState());
        } else {
            i14 = 0;
            i13 = 0;
            i12 = 0;
        }
        if (P(this.f1027h)) {
            F(this.f1027h, i10, 0, i11, 0, this.f1034o);
            i14 = this.f1027h.getMeasuredWidth() + s(this.f1027h);
            i13 = Math.max(i13, this.f1027h.getMeasuredHeight() + t(this.f1027h));
            i12 = View.combineMeasuredStates(i12, this.f1027h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = 0 + Math.max(currentContentInsetStart, i14);
        iArr[b10 ? 1 : 0] = Math.max(0, currentContentInsetStart - i14);
        if (P(this.f1020a)) {
            F(this.f1020a, i10, max, i11, 0, this.f1034o);
            i15 = this.f1020a.getMeasuredWidth() + s(this.f1020a);
            i13 = Math.max(i13, this.f1020a.getMeasuredHeight() + t(this.f1020a));
            i12 = View.combineMeasuredStates(i12, this.f1020a.getMeasuredState());
        } else {
            i15 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = max + Math.max(currentContentInsetEnd, i15);
        iArr[i20] = Math.max(0, currentContentInsetEnd - i15);
        if (P(this.f1028i)) {
            max2 += E(this.f1028i, i10, max2, i11, 0, iArr);
            i13 = Math.max(i13, this.f1028i.getMeasuredHeight() + t(this.f1028i));
            i12 = View.combineMeasuredStates(i12, this.f1028i.getMeasuredState());
        }
        if (P(this.f1024e)) {
            max2 += E(this.f1024e, i10, max2, i11, 0, iArr);
            i13 = Math.max(i13, this.f1024e.getMeasuredHeight() + t(this.f1024e));
            i12 = View.combineMeasuredStates(i12, this.f1024e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            if (((e) childAt.getLayoutParams()).f1054b == 0 && P(childAt)) {
                max2 += E(childAt, i10, max2, i11, 0, iArr);
                i13 = Math.max(i13, childAt.getMeasuredHeight() + t(childAt));
                i12 = View.combineMeasuredStates(i12, childAt.getMeasuredState());
            }
        }
        int i22 = this.f1037r + this.f1038s;
        int i23 = this.f1035p + this.f1036q;
        if (P(this.f1021b)) {
            E(this.f1021b, i10, max2 + i23, i11, i22, iArr);
            i17 = this.f1021b.getMeasuredWidth() + s(this.f1021b);
            i16 = this.f1021b.getMeasuredHeight() + t(this.f1021b);
            i18 = View.combineMeasuredStates(i12, this.f1021b.getMeasuredState());
        } else {
            i16 = 0;
            i18 = i12;
            i17 = 0;
        }
        if (P(this.f1022c)) {
            i17 = Math.max(i17, E(this.f1022c, i10, max2 + i23, i11, i16 + i22, iArr));
            i16 += this.f1022c.getMeasuredHeight() + t(this.f1022c);
            i18 = View.combineMeasuredStates(i18, this.f1022c.getMeasuredState());
        }
        int max3 = Math.max(i13, i16);
        int paddingLeft = max2 + i17 + getPaddingLeft() + getPaddingRight();
        int paddingTop = max3 + getPaddingTop() + getPaddingBottom();
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i10, (-16777216) & i18);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i11, i18 << 16);
        if (!O()) {
            i19 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i19);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        ActionMenuView actionMenuView = this.f1020a;
        androidx.appcompat.view.menu.e N = actionMenuView != null ? actionMenuView.N() : null;
        int i10 = savedState.f1046c;
        if (!(i10 == 0 || this.M == null || N == null || (findItem = N.findItem(i10)) == null)) {
            findItem.expandActionView();
        }
        if (savedState.f1047d) {
            H();
        }
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i10) {
        if (Build.VERSION.SDK_INT >= 17) {
            super.onRtlPropertiesChanged(i10);
        }
        h();
        p0 p0Var = this.f1039t;
        boolean z10 = true;
        if (i10 != 1) {
            z10 = false;
        }
        p0Var.f(z10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        g gVar;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        d dVar = this.M;
        if (!(dVar == null || (gVar = dVar.f1052b) == null)) {
            savedState.f1046c = gVar.getItemId();
        }
        savedState.f1047d = B();
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.B = false;
        }
        return true;
    }

    public void setCollapseContentDescription(int i10) {
        setCollapseContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setCollapseIcon(int i10) {
        setCollapseIcon(e.a.b(getContext(), i10));
    }

    public void setCollapsible(boolean z10) {
        this.P = z10;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f1041v) {
            this.f1041v = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i10) {
        if (i10 < 0) {
            i10 = Integer.MIN_VALUE;
        }
        if (i10 != this.f1040u) {
            this.f1040u = i10;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i10) {
        setLogo(e.a.b(getContext(), i10));
    }

    public void setLogoDescription(int i10) {
        setLogoDescription(getContext().getText(i10));
    }

    public void setNavigationContentDescription(int i10) {
        setNavigationContentDescription(i10 != 0 ? getContext().getText(i10) : null);
    }

    public void setNavigationIcon(int i10) {
        setNavigationIcon(e.a.b(getContext(), i10));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        l();
        this.f1023d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.I = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        j();
        this.f1020a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i10) {
        if (this.f1030k != i10) {
            this.f1030k = i10;
            if (i10 == 0) {
                this.f1029j = getContext();
            } else {
                this.f1029j = new ContextThemeWrapper(getContext(), i10);
            }
        }
    }

    public void setSubtitle(int i10) {
        setSubtitle(getContext().getText(i10));
    }

    public void setSubtitleTextColor(int i10) {
        setSubtitleTextColor(ColorStateList.valueOf(i10));
    }

    public void setTitle(int i10) {
        setTitle(getContext().getText(i10));
    }

    public void setTitleMarginBottom(int i10) {
        this.f1038s = i10;
        requestLayout();
    }

    public void setTitleMarginEnd(int i10) {
        this.f1036q = i10;
        requestLayout();
    }

    public void setTitleMarginStart(int i10) {
        this.f1035p = i10;
        requestLayout();
    }

    public void setTitleMarginTop(int i10) {
        this.f1037r = i10;
        requestLayout();
    }

    public void setTitleTextColor(int i10) {
        setTitleTextColor(ColorStateList.valueOf(i10));
    }

    public boolean v() {
        d dVar = this.M;
        return (dVar == null || dVar.f1052b == null) ? false : true;
    }

    public boolean w() {
        ActionMenuView actionMenuView = this.f1020a;
        return actionMenuView != null && actionMenuView.H();
    }

    public void x(int i10) {
        getMenuInflater().inflate(i10, getMenu());
    }

    public void y() {
        Iterator<MenuItem> it = this.H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(it.next().getItemId());
        }
        G();
    }

    /* loaded from: classes.dex */
    public static class e extends a.C0005a {

        /* renamed from: b  reason: collision with root package name */
        int f1054b;

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1054b = 0;
        }

        void a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(int i10, int i11) {
            super(i10, i11);
            this.f1054b = 0;
            this.f512a = 8388627;
        }

        public e(e eVar) {
            super((a.C0005a) eVar);
            this.f1054b = 0;
            this.f1054b = eVar.f1054b;
        }

        public e(a.C0005a aVar) {
            super(aVar);
            this.f1054b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1054b = 0;
            a(marginLayoutParams);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1054b = 0;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f1042w = 8388627;
        this.D = new ArrayList<>();
        this.E = new ArrayList<>();
        this.F = new int[2];
        this.G = new l(new Runnable() { // from class: androidx.appcompat.widget.y0
            @Override // java.lang.Runnable
            public final void run() {
                Toolbar.this.y();
            }
        });
        this.H = new ArrayList<>();
        this.J = new a();
        this.Q = new b();
        Context context2 = getContext();
        int[] iArr = d.j.f24898i3;
        x0 v10 = x0.v(context2, attributeSet, iArr, i10, 0);
        d0.r0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        this.f1031l = v10.n(d.j.K3, 0);
        this.f1032m = v10.n(d.j.B3, 0);
        this.f1042w = v10.l(d.j.f24903j3, this.f1042w);
        this.f1033n = v10.l(d.j.f24908k3, 48);
        int e10 = v10.e(d.j.E3, 0);
        int i11 = d.j.J3;
        e10 = v10.s(i11) ? v10.e(i11, e10) : e10;
        this.f1038s = e10;
        this.f1037r = e10;
        this.f1036q = e10;
        this.f1035p = e10;
        int e11 = v10.e(d.j.H3, -1);
        if (e11 >= 0) {
            this.f1035p = e11;
        }
        int e12 = v10.e(d.j.G3, -1);
        if (e12 >= 0) {
            this.f1036q = e12;
        }
        int e13 = v10.e(d.j.I3, -1);
        if (e13 >= 0) {
            this.f1037r = e13;
        }
        int e14 = v10.e(d.j.F3, -1);
        if (e14 >= 0) {
            this.f1038s = e14;
        }
        this.f1034o = v10.f(d.j.f24963v3, -1);
        int e15 = v10.e(d.j.f24943r3, Integer.MIN_VALUE);
        int e16 = v10.e(d.j.f24923n3, Integer.MIN_VALUE);
        int f10 = v10.f(d.j.f24933p3, 0);
        int f11 = v10.f(d.j.f24938q3, 0);
        h();
        this.f1039t.e(f10, f11);
        if (!(e15 == Integer.MIN_VALUE && e16 == Integer.MIN_VALUE)) {
            this.f1039t.g(e15, e16);
        }
        this.f1040u = v10.e(d.j.f24948s3, Integer.MIN_VALUE);
        this.f1041v = v10.e(d.j.f24928o3, Integer.MIN_VALUE);
        this.f1025f = v10.g(d.j.f24918m3);
        this.f1026g = v10.p(d.j.f24913l3);
        CharSequence p10 = v10.p(d.j.D3);
        if (!TextUtils.isEmpty(p10)) {
            setTitle(p10);
        }
        CharSequence p11 = v10.p(d.j.A3);
        if (!TextUtils.isEmpty(p11)) {
            setSubtitle(p11);
        }
        this.f1029j = getContext();
        setPopupTheme(v10.n(d.j.f24983z3, 0));
        Drawable g10 = v10.g(d.j.f24978y3);
        if (g10 != null) {
            setNavigationIcon(g10);
        }
        CharSequence p12 = v10.p(d.j.f24973x3);
        if (!TextUtils.isEmpty(p12)) {
            setNavigationContentDescription(p12);
        }
        Drawable g11 = v10.g(d.j.f24953t3);
        if (g11 != null) {
            setLogo(g11);
        }
        CharSequence p13 = v10.p(d.j.f24958u3);
        if (!TextUtils.isEmpty(p13)) {
            setLogoDescription(p13);
        }
        int i12 = d.j.L3;
        if (v10.s(i12)) {
            setTitleTextColor(v10.c(i12));
        }
        int i13 = d.j.C3;
        if (v10.s(i13)) {
            setSubtitleTextColor(v10.c(i13));
        }
        int i14 = d.j.f24968w3;
        if (v10.s(i14)) {
            x(v10.n(i14, 0));
        }
        v10.w();
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f1027h;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            this.f1027h.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f1027h;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f1025f);
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            i();
            if (!z(this.f1024e)) {
                c(this.f1024e, true);
            }
        } else {
            ImageView imageView = this.f1024e;
            if (imageView != null && z(imageView)) {
                removeView(this.f1024e);
                this.E.remove(this.f1024e);
            }
        }
        ImageView imageView2 = this.f1024e;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            i();
        }
        ImageView imageView = this.f1024e;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            l();
        }
        ImageButton imageButton = this.f1023d;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
            a1.a(this.f1023d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            l();
            if (!z(this.f1023d)) {
                c(this.f1023d, true);
            }
        } else {
            ImageButton imageButton = this.f1023d;
            if (imageButton != null && z(imageButton)) {
                removeView(this.f1023d);
                this.E.remove(this.f1023d);
            }
        }
        ImageButton imageButton2 = this.f1023d;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1022c == null) {
                Context context = getContext();
                b0 b0Var = new b0(context);
                this.f1022c = b0Var;
                b0Var.setSingleLine();
                this.f1022c.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1032m;
                if (i10 != 0) {
                    this.f1022c.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f1022c.setTextColor(colorStateList);
                }
            }
            if (!z(this.f1022c)) {
                c(this.f1022c, true);
            }
        } else {
            TextView textView = this.f1022c;
            if (textView != null && z(textView)) {
                removeView(this.f1022c);
                this.E.remove(this.f1022c);
            }
        }
        TextView textView2 = this.f1022c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1044y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f1022c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f1021b == null) {
                Context context = getContext();
                b0 b0Var = new b0(context);
                this.f1021b = b0Var;
                b0Var.setSingleLine();
                this.f1021b.setEllipsize(TextUtils.TruncateAt.END);
                int i10 = this.f1031l;
                if (i10 != 0) {
                    this.f1021b.setTextAppearance(context, i10);
                }
                ColorStateList colorStateList = this.f1045z;
                if (colorStateList != null) {
                    this.f1021b.setTextColor(colorStateList);
                }
            }
            if (!z(this.f1021b)) {
                c(this.f1021b, true);
            }
        } else {
            TextView textView = this.f1021b;
            if (textView != null && z(textView)) {
                removeView(this.f1021b);
                this.E.remove(this.f1021b);
            }
        }
        TextView textView2 = this.f1021b;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.f1043x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.f1045z = colorStateList;
        TextView textView = this.f1021b;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        int f1046c;

        /* renamed from: d  reason: collision with root package name */
        boolean f1047d;

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
            this.f1046c = parcel.readInt();
            this.f1047d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f1046c);
            parcel.writeInt(this.f1047d ? 1 : 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }
}
