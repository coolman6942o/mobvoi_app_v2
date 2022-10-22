package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import d7.b;
import d7.k;
import d7.l;
import w7.h;
import w7.n;
/* loaded from: classes.dex */
public class MaterialCardView extends CardView implements Checkable, n {

    /* renamed from: o  reason: collision with root package name */
    private static final int[] f10630o = {16842911};

    /* renamed from: p  reason: collision with root package name */
    private static final int[] f10631p = {16842912};

    /* renamed from: q  reason: collision with root package name */
    private static final int[] f10632q = {b.T};

    /* renamed from: r  reason: collision with root package name */
    private static final int f10633r = k.f25352q;

    /* renamed from: j  reason: collision with root package name */
    private final com.google.android.material.card.a f10634j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10635k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10636l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10637m;

    /* renamed from: n  reason: collision with root package name */
    private a f10638n;

    /* loaded from: classes.dex */
    public interface a {
        void a(MaterialCardView materialCardView, boolean z10);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.E);
    }

    private RectF getBoundsAsRectF() {
        RectF rectF = new RectF();
        rectF.set(this.f10634j.j().getBounds());
        return rectF;
    }

    private void h() {
        if (Build.VERSION.SDK_INT > 26) {
            this.f10634j.i();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public ColorStateList getCardBackgroundColor() {
        return this.f10634j.k();
    }

    public ColorStateList getCardForegroundColor() {
        return this.f10634j.l();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCardViewRadius() {
        return super.getRadius();
    }

    public Drawable getCheckedIcon() {
        return this.f10634j.m();
    }

    public int getCheckedIconMargin() {
        return this.f10634j.n();
    }

    public int getCheckedIconSize() {
        return this.f10634j.o();
    }

    public ColorStateList getCheckedIconTint() {
        return this.f10634j.p();
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingBottom() {
        return this.f10634j.z().bottom;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingLeft() {
        return this.f10634j.z().left;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingRight() {
        return this.f10634j.z().right;
    }

    @Override // androidx.cardview.widget.CardView
    public int getContentPaddingTop() {
        return this.f10634j.z().top;
    }

    public float getProgress() {
        return this.f10634j.t();
    }

    @Override // androidx.cardview.widget.CardView
    public float getRadius() {
        return this.f10634j.r();
    }

    public ColorStateList getRippleColor() {
        return this.f10634j.u();
    }

    public w7.k getShapeAppearanceModel() {
        return this.f10634j.v();
    }

    @Deprecated
    public int getStrokeColor() {
        return this.f10634j.w();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.f10634j.x();
    }

    public int getStrokeWidth() {
        return this.f10634j.y();
    }

    public boolean i() {
        com.google.android.material.card.a aVar = this.f10634j;
        return aVar != null && aVar.C();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f10636l;
    }

    public boolean j() {
        return this.f10637m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i10, int i11, int i12, int i13) {
        super.f(i10, i11, i12, i13);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.f(this, this.f10634j.j());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 3);
        if (i()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f10630o);
        }
        if (isChecked()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f10631p);
        }
        if (j()) {
            FrameLayout.mergeDrawableStates(onCreateDrawableState, f10632q);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("androidx.cardview.widget.CardView");
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("androidx.cardview.widget.CardView");
        accessibilityNodeInfo.setCheckable(i());
        accessibilityNodeInfo.setClickable(isClickable());
        accessibilityNodeInfo.setChecked(isChecked());
    }

    @Override // androidx.cardview.widget.CardView, android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        this.f10634j.E(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (this.f10635k) {
            if (!this.f10634j.B()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.f10634j.F(true);
            }
            super.setBackgroundDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundInternal(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(int i10) {
        this.f10634j.G(ColorStateList.valueOf(i10));
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardElevation(float f10) {
        super.setCardElevation(f10);
        this.f10634j.Z();
    }

    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.f10634j.H(colorStateList);
    }

    public void setCheckable(boolean z10) {
        this.f10634j.I(z10);
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (this.f10636l != z10) {
            toggle();
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        this.f10634j.K(drawable);
    }

    public void setCheckedIconMargin(int i10) {
        this.f10634j.L(i10);
    }

    public void setCheckedIconMarginResource(int i10) {
        if (i10 != -1) {
            this.f10634j.L(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconResource(int i10) {
        this.f10634j.K(e.a.b(getContext(), i10));
    }

    public void setCheckedIconSize(int i10) {
        this.f10634j.M(i10);
    }

    public void setCheckedIconSizeResource(int i10) {
        if (i10 != 0) {
            this.f10634j.M(getResources().getDimensionPixelSize(i10));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.f10634j.N(colorStateList);
    }

    @Override // android.view.View
    public void setClickable(boolean z10) {
        super.setClickable(z10);
        com.google.android.material.card.a aVar = this.f10634j;
        if (aVar != null) {
            aVar.X();
        }
    }

    public void setDragged(boolean z10) {
        if (this.f10637m != z10) {
            this.f10637m = z10;
            refreshDrawableState();
            h();
            invalidate();
        }
    }

    @Override // androidx.cardview.widget.CardView
    public void setMaxCardElevation(float f10) {
        super.setMaxCardElevation(f10);
        this.f10634j.b0();
    }

    public void setOnCheckedChangeListener(a aVar) {
        this.f10638n = aVar;
    }

    @Override // androidx.cardview.widget.CardView
    public void setPreventCornerOverlap(boolean z10) {
        super.setPreventCornerOverlap(z10);
        this.f10634j.b0();
        this.f10634j.Y();
    }

    public void setProgress(float f10) {
        this.f10634j.P(f10);
    }

    @Override // androidx.cardview.widget.CardView
    public void setRadius(float f10) {
        super.setRadius(f10);
        this.f10634j.O(f10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        this.f10634j.Q(colorStateList);
    }

    public void setRippleColorResource(int i10) {
        this.f10634j.Q(e.a.a(getContext(), i10));
    }

    @Override // w7.n
    public void setShapeAppearanceModel(w7.k kVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            setClipToOutline(kVar.u(getBoundsAsRectF()));
        }
        this.f10634j.R(kVar);
    }

    public void setStrokeColor(int i10) {
        setStrokeColor(ColorStateList.valueOf(i10));
    }

    public void setStrokeWidth(int i10) {
        this.f10634j.T(i10);
        invalidate();
    }

    @Override // androidx.cardview.widget.CardView
    public void setUseCompatPadding(boolean z10) {
        super.setUseCompatPadding(z10);
        this.f10634j.b0();
        this.f10634j.Y();
    }

    @Override // android.widget.Checkable
    public void toggle() {
        if (i() && isEnabled()) {
            this.f10636l = !this.f10636l;
            refreshDrawableState();
            h();
            this.f10634j.J(this.f10636l);
            a aVar = this.f10638n;
            if (aVar != null) {
                aVar.a(this, this.f10636l);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialCardView(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r6), attributeSet, i10);
        int i11 = f10633r;
        this.f10636l = false;
        this.f10637m = false;
        this.f10635k = true;
        TypedArray h10 = com.google.android.material.internal.k.h(getContext(), attributeSet, l.R2, i10, i11, new int[0]);
        com.google.android.material.card.a aVar = new com.google.android.material.card.a(this, attributeSet, i10, i11);
        this.f10634j = aVar;
        aVar.G(super.getCardBackgroundColor());
        aVar.U(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        aVar.D(h10);
        h10.recycle();
    }

    @Override // androidx.cardview.widget.CardView
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.f10634j.G(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        this.f10634j.S(colorStateList);
        invalidate();
    }
}
