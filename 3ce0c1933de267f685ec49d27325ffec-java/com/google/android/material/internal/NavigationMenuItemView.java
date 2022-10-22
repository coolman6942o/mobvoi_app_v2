package com.google.android.material.internal;

import a0.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.k;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.a1;
import androidx.core.view.d0;
import androidx.core.widget.j;
import d7.d;
import d7.e;
import d7.f;
import k0.c;
/* loaded from: classes.dex */
public class NavigationMenuItemView extends d implements k.a {
    private static final int[] F = {16842912};
    private g A;
    private ColorStateList B;
    private boolean C;
    private Drawable D;
    private final androidx.core.view.a E;

    /* renamed from: v  reason: collision with root package name */
    private int f11006v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f11007w;

    /* renamed from: x  reason: collision with root package name */
    boolean f11008x;

    /* renamed from: y  reason: collision with root package name */
    private final CheckedTextView f11009y;

    /* renamed from: z  reason: collision with root package name */
    private FrameLayout f11010z;

    /* loaded from: classes.dex */
    class a extends androidx.core.view.a {
        a() {
        }

        @Override // androidx.core.view.a
        public void g(View view, c cVar) {
            super.g(view, cVar);
            cVar.Y(NavigationMenuItemView.this.f11008x);
        }
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void B() {
        if (D()) {
            this.f11009y.setVisibility(8);
            FrameLayout frameLayout = this.f11010z;
            if (frameLayout != null) {
                LinearLayoutCompat.a aVar = (LinearLayoutCompat.a) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) aVar).width = -1;
                this.f11010z.setLayoutParams(aVar);
                return;
            }
            return;
        }
        this.f11009y.setVisibility(0);
        FrameLayout frameLayout2 = this.f11010z;
        if (frameLayout2 != null) {
            LinearLayoutCompat.a aVar2 = (LinearLayoutCompat.a) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) aVar2).width = -2;
            this.f11010z.setLayoutParams(aVar2);
        }
    }

    private StateListDrawable C() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(d.a.f24735w, typedValue, true)) {
            return null;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(F, new ColorDrawable(typedValue.data));
        stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
        return stateListDrawable;
    }

    private boolean D() {
        return this.A.getTitle() == null && this.A.getIcon() == null && this.A.getActionView() != null;
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f11010z == null) {
                this.f11010z = (FrameLayout) ((ViewStub) findViewById(f.f25252f)).inflate();
            }
            this.f11010z.removeAllViews();
            this.f11010z.addView(view);
        }
    }

    @Override // androidx.appcompat.view.menu.k.a
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.k.a
    public void e(g gVar, int i10) {
        this.A = gVar;
        if (gVar.getItemId() > 0) {
            setId(gVar.getItemId());
        }
        setVisibility(gVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            d0.x0(this, C());
        }
        setCheckable(gVar.isCheckable());
        setChecked(gVar.isChecked());
        setEnabled(gVar.isEnabled());
        setTitle(gVar.getTitle());
        setIcon(gVar.getIcon());
        setActionView(gVar.getActionView());
        setContentDescription(gVar.getContentDescription());
        a1.a(this, gVar.getTooltipText());
        B();
    }

    @Override // androidx.appcompat.view.menu.k.a
    public g getItemData() {
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        g gVar = this.A;
        if (gVar != null && gVar.isCheckable() && this.A.isChecked()) {
            ViewGroup.mergeDrawableStates(onCreateDrawableState, F);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.f11008x != z10) {
            this.f11008x = z10;
            this.E.l(this.f11009y, 2048);
        }
    }

    public void setChecked(boolean z10) {
        refreshDrawableState();
        this.f11009y.setChecked(z10);
    }

    public void setHorizontalPadding(int i10) {
        setPadding(i10, getPaddingTop(), i10, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.C) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = androidx.core.graphics.drawable.a.r(drawable).mutate();
                androidx.core.graphics.drawable.a.o(drawable, this.B);
            }
            int i10 = this.f11006v;
            drawable.setBounds(0, 0, i10, i10);
        } else if (this.f11007w) {
            if (this.D == null) {
                Drawable f10 = h.f(getResources(), e.f25241h, getContext().getTheme());
                this.D = f10;
                if (f10 != null) {
                    int i11 = this.f11006v;
                    f10.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.D;
        }
        j.l(this.f11009y, drawable, null, null, null);
    }

    public void setIconPadding(int i10) {
        this.f11009y.setCompoundDrawablePadding(i10);
    }

    public void setIconSize(int i10) {
        this.f11006v = i10;
    }

    void setIconTintList(ColorStateList colorStateList) {
        this.B = colorStateList;
        this.C = colorStateList != null;
        g gVar = this.A;
        if (gVar != null) {
            setIcon(gVar.getIcon());
        }
    }

    public void setMaxLines(int i10) {
        this.f11009y.setMaxLines(i10);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.f11007w = z10;
    }

    public void setTextAppearance(int i10) {
        j.q(this.f11009y, i10);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f11009y.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f11009y.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a aVar = new a();
        this.E = aVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(d7.h.f25289g, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(d.f25202k));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(f.f25254g);
        this.f11009y = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        d0.t0(checkedTextView, aVar);
    }
}
