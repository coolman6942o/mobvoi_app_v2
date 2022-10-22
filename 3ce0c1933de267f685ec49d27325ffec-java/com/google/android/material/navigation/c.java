package com.google.android.material.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.k;
import androidx.core.view.d0;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.i;
import j0.g;
import java.util.HashSet;
import k0.c;
import n1.b;
import n1.o;
import n1.q;
/* compiled from: NavigationBarMenuView.java */
/* loaded from: classes.dex */
public abstract class c extends ViewGroup implements k {
    private static final int[] C = {16842912};
    private static final int[] D = {-16842910};
    private NavigationBarPresenter A;
    private e B;

    /* renamed from: a  reason: collision with root package name */
    private final q f11152a;

    /* renamed from: e  reason: collision with root package name */
    private int f11156e;

    /* renamed from: f  reason: collision with root package name */
    private com.google.android.material.navigation.a[] f11157f;

    /* renamed from: i  reason: collision with root package name */
    private ColorStateList f11160i;

    /* renamed from: j  reason: collision with root package name */
    private int f11161j;

    /* renamed from: k  reason: collision with root package name */
    private ColorStateList f11162k;

    /* renamed from: m  reason: collision with root package name */
    private int f11164m;

    /* renamed from: n  reason: collision with root package name */
    private int f11165n;

    /* renamed from: o  reason: collision with root package name */
    private Drawable f11166o;

    /* renamed from: p  reason: collision with root package name */
    private int f11167p;

    /* renamed from: t  reason: collision with root package name */
    private boolean f11171t;

    /* renamed from: u  reason: collision with root package name */
    private int f11172u;

    /* renamed from: v  reason: collision with root package name */
    private int f11173v;

    /* renamed from: w  reason: collision with root package name */
    private int f11174w;

    /* renamed from: x  reason: collision with root package name */
    private w7.k f11175x;

    /* renamed from: z  reason: collision with root package name */
    private ColorStateList f11177z;

    /* renamed from: c  reason: collision with root package name */
    private final j0.e<com.google.android.material.navigation.a> f11154c = new g(5);

    /* renamed from: d  reason: collision with root package name */
    private final SparseArray<View.OnTouchListener> f11155d = new SparseArray<>(5);

    /* renamed from: g  reason: collision with root package name */
    private int f11158g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f11159h = 0;

    /* renamed from: q  reason: collision with root package name */
    private SparseArray<BadgeDrawable> f11168q = new SparseArray<>(5);

    /* renamed from: r  reason: collision with root package name */
    private int f11169r = -1;

    /* renamed from: s  reason: collision with root package name */
    private int f11170s = -1;

    /* renamed from: y  reason: collision with root package name */
    private boolean f11176y = false;

    /* renamed from: l  reason: collision with root package name */
    private final ColorStateList f11163l = e(16842808);

    /* renamed from: b  reason: collision with root package name */
    private final View.OnClickListener f11153b = new a();

    /* compiled from: NavigationBarMenuView.java */
    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            androidx.appcompat.view.menu.g itemData = ((com.google.android.material.navigation.a) view).getItemData();
            if (!c.this.B.O(itemData, c.this.A, 0)) {
                itemData.setChecked(true);
            }
        }
    }

    public c(Context context) {
        super(context);
        b bVar = new b();
        this.f11152a = bVar;
        bVar.m0(0);
        bVar.U(q7.a.d(getContext(), d7.b.K, getResources().getInteger(d7.g.f25281b)));
        bVar.W(q7.a.e(getContext(), d7.b.L, e7.a.f25834b));
        bVar.e0(new i());
        d0.E0(this, 1);
    }

    private Drawable f() {
        if (this.f11175x == null || this.f11177z == null) {
            return null;
        }
        w7.g gVar = new w7.g(this.f11175x);
        gVar.Z(this.f11177z);
        return gVar;
    }

    private com.google.android.material.navigation.a getNewItem() {
        com.google.android.material.navigation.a b10 = this.f11154c.b();
        return b10 == null ? g(getContext()) : b10;
    }

    private boolean i(int i10) {
        return i10 != -1;
    }

    private void j() {
        HashSet hashSet = new HashSet();
        for (int i10 = 0; i10 < this.B.size(); i10++) {
            hashSet.add(Integer.valueOf(this.B.getItem(i10).getItemId()));
        }
        for (int i11 = 0; i11 < this.f11168q.size(); i11++) {
            int keyAt = this.f11168q.keyAt(i11);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.f11168q.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(com.google.android.material.navigation.a aVar) {
        BadgeDrawable badgeDrawable;
        int id2 = aVar.getId();
        if (i(id2) && (badgeDrawable = this.f11168q.get(id2)) != null) {
            aVar.setBadge(badgeDrawable);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void b(e eVar) {
        this.B = eVar;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void d() {
        removeAllViews();
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                if (aVar != null) {
                    this.f11154c.a(aVar);
                    aVar.h();
                }
            }
        }
        if (this.B.size() == 0) {
            this.f11158g = 0;
            this.f11159h = 0;
            this.f11157f = null;
            return;
        }
        j();
        this.f11157f = new com.google.android.material.navigation.a[this.B.size()];
        boolean h10 = h(this.f11156e, this.B.G().size());
        for (int i10 = 0; i10 < this.B.size(); i10++) {
            this.A.k(true);
            this.B.getItem(i10).setCheckable(true);
            this.A.k(false);
            com.google.android.material.navigation.a newItem = getNewItem();
            this.f11157f[i10] = newItem;
            newItem.setIconTintList(this.f11160i);
            newItem.setIconSize(this.f11161j);
            newItem.setTextColor(this.f11163l);
            newItem.setTextAppearanceInactive(this.f11164m);
            newItem.setTextAppearanceActive(this.f11165n);
            newItem.setTextColor(this.f11162k);
            int i11 = this.f11169r;
            if (i11 != -1) {
                newItem.setItemPaddingTop(i11);
            }
            int i12 = this.f11170s;
            if (i12 != -1) {
                newItem.setItemPaddingBottom(i12);
            }
            newItem.setActiveIndicatorWidth(this.f11172u);
            newItem.setActiveIndicatorHeight(this.f11173v);
            newItem.setActiveIndicatorMarginHorizontal(this.f11174w);
            newItem.setActiveIndicatorDrawable(f());
            newItem.setActiveIndicatorResizeable(this.f11176y);
            newItem.setActiveIndicatorEnabled(this.f11171t);
            Drawable drawable = this.f11166o;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.f11167p);
            }
            newItem.setShifting(h10);
            newItem.setLabelVisibilityMode(this.f11156e);
            androidx.appcompat.view.menu.g gVar = (androidx.appcompat.view.menu.g) this.B.getItem(i10);
            newItem.e(gVar, 0);
            newItem.setItemPosition(i10);
            int itemId = gVar.getItemId();
            newItem.setOnTouchListener(this.f11155d.get(itemId));
            newItem.setOnClickListener(this.f11153b);
            int i13 = this.f11158g;
            if (i13 != 0 && itemId == i13) {
                this.f11159h = i10;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.B.size() - 1, this.f11159h);
        this.f11159h = min;
        this.B.getItem(min).setChecked(true);
    }

    public ColorStateList e(int i10) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i10, typedValue, true)) {
            return null;
        }
        ColorStateList a10 = e.a.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(d.a.f24737y, typedValue, true)) {
            return null;
        }
        int i11 = typedValue.data;
        int defaultColor = a10.getDefaultColor();
        int[] iArr = D;
        return new ColorStateList(new int[][]{iArr, C, ViewGroup.EMPTY_STATE_SET}, new int[]{a10.getColorForState(iArr, defaultColor), i11, defaultColor});
    }

    protected abstract com.google.android.material.navigation.a g(Context context);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.f11168q;
    }

    public ColorStateList getIconTintList() {
        return this.f11160i;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f11177z;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.f11171t;
    }

    public int getItemActiveIndicatorHeight() {
        return this.f11173v;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f11174w;
    }

    public w7.k getItemActiveIndicatorShapeAppearance() {
        return this.f11175x;
    }

    public int getItemActiveIndicatorWidth() {
        return this.f11172u;
    }

    public Drawable getItemBackground() {
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr == null || aVarArr.length <= 0) {
            return this.f11166o;
        }
        return aVarArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.f11167p;
    }

    public int getItemIconSize() {
        return this.f11161j;
    }

    public int getItemPaddingBottom() {
        return this.f11170s;
    }

    public int getItemPaddingTop() {
        return this.f11169r;
    }

    public int getItemTextAppearanceActive() {
        return this.f11165n;
    }

    public int getItemTextAppearanceInactive() {
        return this.f11164m;
    }

    public ColorStateList getItemTextColor() {
        return this.f11162k;
    }

    public int getLabelVisibilityMode() {
        return this.f11156e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e getMenu() {
        return this.B;
    }

    public int getSelectedItemId() {
        return this.f11158g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.f11159h;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h(int i10, int i11) {
        if (i10 == -1) {
            if (i11 > 3) {
                return true;
            }
        } else if (i10 == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i10) {
        int size = this.B.size();
        for (int i11 = 0; i11 < size; i11++) {
            MenuItem item = this.B.getItem(i11);
            if (i10 == item.getItemId()) {
                this.f11158g = i10;
                this.f11159h = i11;
                item.setChecked(true);
                return;
            }
        }
    }

    public void l() {
        e eVar = this.B;
        if (!(eVar == null || this.f11157f == null)) {
            int size = eVar.size();
            if (size != this.f11157f.length) {
                d();
                return;
            }
            int i10 = this.f11158g;
            for (int i11 = 0; i11 < size; i11++) {
                MenuItem item = this.B.getItem(i11);
                if (item.isChecked()) {
                    this.f11158g = item.getItemId();
                    this.f11159h = i11;
                }
            }
            if (i10 != this.f11158g) {
                o.a(this, this.f11152a);
            }
            boolean h10 = h(this.f11156e, this.B.G().size());
            for (int i12 = 0; i12 < size; i12++) {
                this.A.k(true);
                this.f11157f[i12].setLabelVisibilityMode(this.f11156e);
                this.f11157f[i12].setShifting(h10);
                this.f11157f[i12].e((androidx.appcompat.view.menu.g) this.B.getItem(i12), 0);
                this.A.k(false);
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        k0.c.D0(accessibilityNodeInfo).c0(c.b.a(1, this.B.G().size(), false, 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.f11168q = sparseArray;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setBadge(sparseArray.get(aVar.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f11160i = colorStateList;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f11177z = colorStateList;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorDrawable(f());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f11171t = z10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorEnabled(z10);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.f11173v = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorHeight(i10);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.f11174w = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorMarginHorizontal(i10);
            }
        }
    }

    protected void setItemActiveIndicatorResizeable(boolean z10) {
        this.f11176y = z10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorResizeable(z10);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(w7.k kVar) {
        this.f11175x = kVar;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorDrawable(f());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.f11172u = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setActiveIndicatorWidth(i10);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.f11166o = drawable;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i10) {
        this.f11167p = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemBackground(i10);
            }
        }
    }

    public void setItemIconSize(int i10) {
        this.f11161j = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setIconSize(i10);
            }
        }
    }

    public void setItemPaddingBottom(int i10) {
        this.f11170s = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemPaddingBottom(i10);
            }
        }
    }

    public void setItemPaddingTop(int i10) {
        this.f11169r = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setItemPaddingTop(i10);
            }
        }
    }

    public void setItemTextAppearanceActive(int i10) {
        this.f11165n = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setTextAppearanceActive(i10);
                ColorStateList colorStateList = this.f11162k;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i10) {
        this.f11164m = i10;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setTextAppearanceInactive(i10);
                ColorStateList colorStateList = this.f11162k;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f11162k = colorStateList;
        com.google.android.material.navigation.a[] aVarArr = this.f11157f;
        if (aVarArr != null) {
            for (com.google.android.material.navigation.a aVar : aVarArr) {
                aVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i10) {
        this.f11156e = i10;
    }

    public void setPresenter(NavigationBarPresenter navigationBarPresenter) {
        this.A = navigationBarPresenter;
    }
}
