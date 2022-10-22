package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.b;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActionMenuPresenter extends androidx.appcompat.view.menu.a implements b.a {
    private b A;
    int C;

    /* renamed from: j  reason: collision with root package name */
    d f844j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f845k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f846l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f847m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f848n;

    /* renamed from: o  reason: collision with root package name */
    private int f849o;

    /* renamed from: p  reason: collision with root package name */
    private int f850p;

    /* renamed from: q  reason: collision with root package name */
    private int f851q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f852r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f853s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f854t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f855u;

    /* renamed from: v  reason: collision with root package name */
    private int f856v;

    /* renamed from: x  reason: collision with root package name */
    e f858x;

    /* renamed from: y  reason: collision with root package name */
    a f859y;

    /* renamed from: z  reason: collision with root package name */
    c f860z;

    /* renamed from: w  reason: collision with root package name */
    private final SparseBooleanArray f857w = new SparseBooleanArray();
    final f B = new f();

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public int f861a;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f861a);
        }

        SavedState(Parcel parcel) {
            this.f861a = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends i {
        public a(Context context, m mVar, View view) {
            super(context, mVar, view, false, d.a.f24724l);
            if (!((g) mVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.f844j;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).f643h : view2);
            }
            j(ActionMenuPresenter.this.B);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.f859y = null;
            actionMenuPresenter.C = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public j.e a() {
            a aVar = ActionMenuPresenter.this.f859y;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private e f864a;

        public c(e eVar) {
            this.f864a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).f638c != null) {
                ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).f638c.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).f643h;
            if (!(view == null || view.getWindowToken() == null || !this.f864a.m())) {
                ActionMenuPresenter.this.f858x = this.f864a;
            }
            ActionMenuPresenter.this.f860z = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends q implements ActionMenuView.a {

        /* loaded from: classes.dex */
        class a extends j0 {
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
            }

            @Override // androidx.appcompat.widget.j0
            public j.e b() {
                e eVar = ActionMenuPresenter.this.f858x;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.j0
            public boolean c() {
                ActionMenuPresenter.this.M();
                return true;
            }

            @Override // androidx.appcompat.widget.j0
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.f860z != null) {
                    return false;
                }
                actionMenuPresenter.D();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, d.a.f24723k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            a1.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.M();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i10, int i11, int i12, int i13) {
            boolean frame = super.setFrame(i10, i11, i12, i13);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends i {
        public e(Context context, androidx.appcompat.view.menu.e eVar, View view, boolean z10) {
            super(context, eVar, view, z10, d.a.f24724l);
            h(8388613);
            j(ActionMenuPresenter.this.B);
        }

        @Override // androidx.appcompat.view.menu.i
        protected void e() {
            if (((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).f638c != null) {
                ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).f638c.close();
            }
            ActionMenuPresenter.this.f858x = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements j.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (eVar instanceof m) {
                eVar.F().e(false);
            }
            j.a o10 = ActionMenuPresenter.this.o();
            if (o10 != null) {
                o10.c(eVar, z10);
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            if (eVar == ((androidx.appcompat.view.menu.a) ActionMenuPresenter.this).f638c) {
                return false;
            }
            ActionMenuPresenter.this.C = ((m) eVar).getItem().getItemId();
            j.a o10 = ActionMenuPresenter.this.o();
            if (o10 != null) {
                return o10.d(eVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, d.g.f24817c, d.g.f24816b);
    }

    private View B(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f643h;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof k.a) && ((k.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        return D() | E();
    }

    public Drawable C() {
        d dVar = this.f844j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.f846l) {
            return this.f845k;
        }
        return null;
    }

    public boolean D() {
        k kVar;
        c cVar = this.f860z;
        if (cVar == null || (kVar = this.f643h) == null) {
            e eVar = this.f858x;
            if (eVar == null) {
                return false;
            }
            eVar.b();
            return true;
        }
        ((View) kVar).removeCallbacks(cVar);
        this.f860z = null;
        return true;
    }

    public boolean E() {
        a aVar = this.f859y;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean F() {
        return this.f860z != null || G();
    }

    public boolean G() {
        e eVar = this.f858x;
        return eVar != null && eVar.d();
    }

    public void H(Configuration configuration) {
        if (!this.f852r) {
            this.f851q = i.a.b(this.f637b).d();
        }
        androidx.appcompat.view.menu.e eVar = this.f638c;
        if (eVar != null) {
            eVar.M(true);
        }
    }

    public void I(boolean z10) {
        this.f855u = z10;
    }

    public void J(ActionMenuView actionMenuView) {
        this.f643h = actionMenuView;
        actionMenuView.b(this.f638c);
    }

    public void K(Drawable drawable) {
        d dVar = this.f844j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        this.f846l = true;
        this.f845k = drawable;
    }

    public void L(boolean z10) {
        this.f847m = z10;
        this.f848n = true;
    }

    public boolean M() {
        androidx.appcompat.view.menu.e eVar;
        if (!this.f847m || G() || (eVar = this.f638c) == null || this.f643h == null || this.f860z != null || eVar.B().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f637b, this.f638c, this.f844j, true));
        this.f860z = cVar;
        ((View) this.f643h).post(cVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.a
    public void b(g gVar, k.a aVar) {
        aVar.e(gVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f643h);
        if (this.A == null) {
            this.A = new b();
        }
        actionMenuItemView.setPopupCallback(this.A);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
        A();
        super.c(eVar, z10);
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void d(boolean z10) {
        super.d(z10);
        ((View) this.f643h).requestLayout();
        androidx.appcompat.view.menu.e eVar = this.f638c;
        boolean z11 = false;
        if (eVar != null) {
            ArrayList<g> u10 = eVar.u();
            int size = u10.size();
            for (int i10 = 0; i10 < size; i10++) {
                androidx.core.view.b b10 = u10.get(i10).b();
                if (b10 != null) {
                    b10.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.e eVar2 = this.f638c;
        ArrayList<g> B = eVar2 != null ? eVar2.B() : null;
        if (this.f847m && B != null) {
            int size2 = B.size();
            if (size2 == 1) {
                z11 = !B.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z11 = true;
            }
        }
        if (z11) {
            if (this.f844j == null) {
                this.f844j = new d(this.f636a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f844j.getParent();
            if (viewGroup != this.f643h) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f844j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f643h;
                actionMenuView.addView(this.f844j, actionMenuView.F());
            }
        } else {
            d dVar = this.f844j;
            if (dVar != null) {
                ViewParent parent = dVar.getParent();
                k kVar = this.f643h;
                if (parent == kVar) {
                    ((ViewGroup) kVar).removeView(this.f844j);
                }
            }
        }
        ((ActionMenuView) this.f643h).setOverflowReserved(this.f847m);
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        int i10;
        ArrayList<g> arrayList;
        int i11;
        int i12;
        int i13;
        boolean z10;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.e eVar = actionMenuPresenter.f638c;
        View view = null;
        boolean z11 = false;
        if (eVar != null) {
            arrayList = eVar.G();
            i10 = arrayList.size();
        } else {
            arrayList = null;
            i10 = 0;
        }
        int i14 = actionMenuPresenter.f851q;
        int i15 = actionMenuPresenter.f850p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f643h;
        boolean z12 = false;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < i10; i18++) {
            g gVar = arrayList.get(i18);
            if (gVar.o()) {
                i16++;
            } else if (gVar.n()) {
                i17++;
            } else {
                z12 = true;
            }
            if (actionMenuPresenter.f855u && gVar.isActionViewExpanded()) {
                i14 = 0;
            }
        }
        if (actionMenuPresenter.f847m && (z12 || i17 + i16 > i14)) {
            i14--;
        }
        int i19 = i14 - i16;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.f857w;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.f853s) {
            int i20 = actionMenuPresenter.f856v;
            i11 = i15 / i20;
            i12 = i20 + ((i15 % i20) / i11);
        } else {
            i12 = 0;
            i11 = 0;
        }
        int i21 = 0;
        int i22 = 0;
        while (i21 < i10) {
            g gVar2 = arrayList.get(i21);
            if (gVar2.o()) {
                View p10 = actionMenuPresenter.p(gVar2, view, viewGroup);
                if (actionMenuPresenter.f853s) {
                    int i23 = z11 ? 1 : 0;
                    int i24 = z11 ? 1 : 0;
                    i11 -= ActionMenuView.L(p10, i12, i11, makeMeasureSpec, i23);
                } else {
                    p10.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = p10.getMeasuredWidth();
                i15 -= measuredWidth;
                if (i22 == 0) {
                    i22 = measuredWidth;
                }
                int groupId = gVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                gVar2.u(true);
                z10 = z11;
                i13 = i10;
            } else if (gVar2.n()) {
                int groupId2 = gVar2.getGroupId();
                boolean z13 = sparseBooleanArray.get(groupId2);
                boolean z14 = (i19 > 0 || z13) && i15 > 0 && (!actionMenuPresenter.f853s || i11 > 0);
                boolean z15 = z14;
                i13 = i10;
                if (z14) {
                    View p11 = actionMenuPresenter.p(gVar2, null, viewGroup);
                    if (actionMenuPresenter.f853s) {
                        int L = ActionMenuView.L(p11, i12, i11, makeMeasureSpec, 0);
                        i11 -= L;
                        if (L == 0) {
                            z15 = false;
                        }
                    } else {
                        p11.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z16 = z15;
                    int measuredWidth2 = p11.getMeasuredWidth();
                    i15 -= measuredWidth2;
                    if (i22 == 0) {
                        i22 = measuredWidth2;
                    }
                    z14 = z16 & (!actionMenuPresenter.f853s ? i15 + i22 > 0 : i15 >= 0);
                }
                if (z14 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z13) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i25 = 0; i25 < i21; i25++) {
                        g gVar3 = arrayList.get(i25);
                        if (gVar3.getGroupId() == groupId2) {
                            if (gVar3.l()) {
                                i19++;
                            }
                            gVar3.u(false);
                        }
                    }
                }
                if (z14) {
                    i19--;
                }
                gVar2.u(z14);
                z10 = false;
            } else {
                boolean z17 = z11 ? 1 : 0;
                Object[] objArr = z11 ? 1 : 0;
                z10 = z17;
                i13 = i10;
                gVar2.u(z10);
            }
            i21++;
            z11 = z10;
            i10 = i13;
            view = null;
            actionMenuPresenter = this;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public void i(Context context, androidx.appcompat.view.menu.e eVar) {
        super.i(context, eVar);
        Resources resources = context.getResources();
        i.a b10 = i.a.b(context);
        if (!this.f848n) {
            this.f847m = b10.h();
        }
        if (!this.f854t) {
            this.f849o = b10.c();
        }
        if (!this.f852r) {
            this.f851q = b10.d();
        }
        int i10 = this.f849o;
        if (this.f847m) {
            if (this.f844j == null) {
                d dVar = new d(this.f636a);
                this.f844j = dVar;
                if (this.f846l) {
                    dVar.setImageDrawable(this.f845k);
                    this.f845k = null;
                    this.f846l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f844j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i10 -= this.f844j.getMeasuredWidth();
        } else {
            this.f844j = null;
        }
        this.f850p = i10;
        this.f856v = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
        int i10;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i10 = ((SavedState) parcelable).f861a) > 0 && (findItem = this.f638c.findItem(i10)) != null) {
            l((m) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.a, androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        boolean z10 = false;
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        m mVar2 = mVar;
        while (mVar2.i0() != this.f638c) {
            mVar2 = (m) mVar2.i0();
        }
        View B = B(mVar2.getItem());
        if (B == null) {
            return false;
        }
        this.C = mVar.getItem().getItemId();
        int size = mVar.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                break;
            }
            MenuItem item = mVar.getItem(i10);
            if (item.isVisible() && item.getIcon() != null) {
                z10 = true;
                break;
            }
            i10++;
        }
        a aVar = new a(this.f637b, mVar, B);
        this.f859y = aVar;
        aVar.g(z10);
        this.f859y.k();
        super.l(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable m() {
        SavedState savedState = new SavedState();
        savedState.f861a = this.C;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean n(ViewGroup viewGroup, int i10) {
        if (viewGroup.getChildAt(i10) == this.f844j) {
            return false;
        }
        return super.n(viewGroup, i10);
    }

    @Override // androidx.appcompat.view.menu.a
    public View p(g gVar, View view, ViewGroup viewGroup) {
        View actionView = gVar.getActionView();
        if (actionView == null || gVar.j()) {
            actionView = super.p(gVar, view, viewGroup);
        }
        actionView.setVisibility(gVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.o(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.a
    public k q(ViewGroup viewGroup) {
        k kVar = this.f643h;
        k q5 = super.q(viewGroup);
        if (kVar != q5) {
            ((ActionMenuView) q5).setPresenter(this);
        }
        return q5;
    }

    @Override // androidx.appcompat.view.menu.a
    public boolean s(int i10, g gVar) {
        return gVar.l();
    }
}
