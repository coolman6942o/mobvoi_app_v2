package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.x0;
import androidx.core.view.d0;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.k;
import d7.d;
import d7.l;
import w7.g;
import w7.h;
/* loaded from: classes.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.android.material.navigation.b f11111a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.material.navigation.c f11112b;

    /* renamed from: c  reason: collision with root package name */
    private final NavigationBarPresenter f11113c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f11114d;

    /* renamed from: e  reason: collision with root package name */
    private MenuInflater f11115e;

    /* renamed from: f  reason: collision with root package name */
    private c f11116f;

    /* renamed from: g  reason: collision with root package name */
    private b f11117g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        Bundle f11118c;

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

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel, ClassLoader classLoader) {
            this.f11118c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeBundle(this.f11118c);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader == null ? getClass().getClassLoader() : classLoader);
        }
    }

    /* loaded from: classes.dex */
    class a implements e.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(e eVar, MenuItem menuItem) {
            if (NavigationBarView.this.f11117g == null || menuItem.getItemId() != NavigationBarView.this.getSelectedItemId()) {
                return NavigationBarView.this.f11116f != null && !NavigationBarView.this.f11116f.a(menuItem);
            }
            NavigationBarView.this.f11117g.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(e eVar) {
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(MenuItem menuItem);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(MenuItem menuItem);
    }

    public NavigationBarView(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(x7.a.c(context, attributeSet, i10, i11), attributeSet, i10);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f11113c = navigationBarPresenter;
        Context context2 = getContext();
        int[] iArr = l.K3;
        int i12 = l.V3;
        int i13 = l.U3;
        x0 i14 = k.i(context2, attributeSet, iArr, i10, i11, i12, i13);
        com.google.android.material.navigation.b bVar = new com.google.android.material.navigation.b(context2, getClass(), getMaxItemCount());
        this.f11111a = bVar;
        com.google.android.material.navigation.c d10 = d(context2);
        this.f11112b = d10;
        navigationBarPresenter.b(d10);
        navigationBarPresenter.a(1);
        d10.setPresenter(navigationBarPresenter);
        bVar.b(navigationBarPresenter);
        navigationBarPresenter.i(getContext(), bVar);
        int i15 = l.Q3;
        if (i14.s(i15)) {
            d10.setIconTintList(i14.c(i15));
        } else {
            d10.setIconTintList(d10.e(16842808));
        }
        setItemIconSize(i14.f(l.P3, getResources().getDimensionPixelSize(d.f25211o0)));
        if (i14.s(i12)) {
            setItemTextAppearanceInactive(i14.n(i12, 0));
        }
        if (i14.s(i13)) {
            setItemTextAppearanceActive(i14.n(i13, 0));
        }
        int i16 = l.W3;
        if (i14.s(i16)) {
            setItemTextColor(i14.c(i16));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            d0.x0(this, c(context2));
        }
        int i17 = l.S3;
        if (i14.s(i17)) {
            setItemPaddingTop(i14.f(i17, 0));
        }
        int i18 = l.R3;
        if (i14.s(i18)) {
            setItemPaddingBottom(i14.f(i18, 0));
        }
        int i19 = l.M3;
        if (i14.s(i19)) {
            setElevation(i14.f(i19, 0));
        }
        androidx.core.graphics.drawable.a.o(getBackground().mutate(), t7.c.b(context2, i14, l.L3));
        setLabelVisibilityMode(i14.l(l.X3, -1));
        int n10 = i14.n(l.O3, 0);
        if (n10 != 0) {
            d10.setItemBackgroundRes(n10);
        } else {
            setItemRippleColor(t7.c.b(context2, i14, l.T3));
        }
        int n11 = i14.n(l.N3, 0);
        if (n11 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(n11, l.E3);
            setItemActiveIndicatorWidth(obtainStyledAttributes.getDimensionPixelSize(l.G3, 0));
            setItemActiveIndicatorHeight(obtainStyledAttributes.getDimensionPixelSize(l.F3, 0));
            setItemActiveIndicatorMarginHorizontal(obtainStyledAttributes.getDimensionPixelOffset(l.I3, 0));
            setItemActiveIndicatorColor(t7.c.a(context2, obtainStyledAttributes, l.H3));
            setItemActiveIndicatorShapeAppearance(w7.k.b(context2, obtainStyledAttributes.getResourceId(l.J3, 0), 0).m());
            obtainStyledAttributes.recycle();
        }
        int i20 = l.Y3;
        if (i14.s(i20)) {
            e(i14.n(i20, 0));
        }
        i14.w();
        addView(d10);
        bVar.V(new a());
    }

    private g c(Context context) {
        g gVar = new g();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            gVar.Z(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        gVar.O(context);
        return gVar;
    }

    private MenuInflater getMenuInflater() {
        if (this.f11115e == null) {
            this.f11115e = new i.g(getContext());
        }
        return this.f11115e;
    }

    protected abstract com.google.android.material.navigation.c d(Context context);

    public void e(int i10) {
        this.f11113c.k(true);
        getMenuInflater().inflate(i10, this.f11111a);
        this.f11113c.k(false);
        this.f11113c.d(true);
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.f11112b.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.f11112b.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f11112b.getItemActiveIndicatorMarginHorizontal();
    }

    public w7.k getItemActiveIndicatorShapeAppearance() {
        return this.f11112b.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.f11112b.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.f11112b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f11112b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f11112b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f11112b.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.f11112b.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.f11112b.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.f11114d;
    }

    public int getItemTextAppearanceActive() {
        return this.f11112b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f11112b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f11112b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f11112b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f11111a;
    }

    public androidx.appcompat.view.menu.k getMenuView() {
        return this.f11112b;
    }

    public NavigationBarPresenter getPresenter() {
        return this.f11113c;
    }

    public int getSelectedItemId() {
        return this.f11112b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f11111a.S(savedState.f11118c);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f11118c = bundle;
        this.f11111a.U(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.setElevation(f10);
        }
        h.d(this, f10);
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.f11112b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z10) {
        this.f11112b.setItemActiveIndicatorEnabled(z10);
    }

    public void setItemActiveIndicatorHeight(int i10) {
        this.f11112b.setItemActiveIndicatorHeight(i10);
    }

    public void setItemActiveIndicatorMarginHorizontal(int i10) {
        this.f11112b.setItemActiveIndicatorMarginHorizontal(i10);
    }

    public void setItemActiveIndicatorShapeAppearance(w7.k kVar) {
        this.f11112b.setItemActiveIndicatorShapeAppearance(kVar);
    }

    public void setItemActiveIndicatorWidth(int i10) {
        this.f11112b.setItemActiveIndicatorWidth(i10);
    }

    public void setItemBackground(Drawable drawable) {
        this.f11112b.setItemBackground(drawable);
        this.f11114d = null;
    }

    public void setItemBackgroundResource(int i10) {
        this.f11112b.setItemBackgroundRes(i10);
        this.f11114d = null;
    }

    public void setItemIconSize(int i10) {
        this.f11112b.setItemIconSize(i10);
    }

    public void setItemIconSizeRes(int i10) {
        setItemIconSize(getResources().getDimensionPixelSize(i10));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f11112b.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(int i10) {
        this.f11112b.setItemPaddingBottom(i10);
    }

    public void setItemPaddingTop(int i10) {
        this.f11112b.setItemPaddingTop(i10);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        if (this.f11114d != colorStateList) {
            this.f11114d = colorStateList;
            if (colorStateList == null) {
                this.f11112b.setItemBackground(null);
                return;
            }
            ColorStateList a10 = u7.b.a(colorStateList);
            if (Build.VERSION.SDK_INT >= 21) {
                this.f11112b.setItemBackground(new RippleDrawable(a10, null, null));
                return;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(1.0E-5f);
            Drawable r10 = androidx.core.graphics.drawable.a.r(gradientDrawable);
            androidx.core.graphics.drawable.a.o(r10, a10);
            this.f11112b.setItemBackground(r10);
        } else if (colorStateList == null && this.f11112b.getItemBackground() != null) {
            this.f11112b.setItemBackground(null);
        }
    }

    public void setItemTextAppearanceActive(int i10) {
        this.f11112b.setItemTextAppearanceActive(i10);
    }

    public void setItemTextAppearanceInactive(int i10) {
        this.f11112b.setItemTextAppearanceInactive(i10);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f11112b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i10) {
        if (this.f11112b.getLabelVisibilityMode() != i10) {
            this.f11112b.setLabelVisibilityMode(i10);
            this.f11113c.d(false);
        }
    }

    public void setOnItemReselectedListener(b bVar) {
        this.f11117g = bVar;
    }

    public void setOnItemSelectedListener(c cVar) {
        this.f11116f = cVar;
    }

    public void setSelectedItemId(int i10) {
        MenuItem findItem = this.f11111a.findItem(i10);
        if (findItem != null && !this.f11111a.O(findItem, this.f11113c, 0)) {
            findItem.setChecked(true);
        }
    }
}
