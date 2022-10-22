package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.f;
import androidx.core.view.d0;
import com.google.android.material.chip.a;
import com.google.android.material.internal.m;
import d7.j;
import d7.k;
import d7.l;
import e7.h;
import java.util.List;
import k0.c;
import t7.d;
import w7.n;
/* loaded from: classes.dex */
public class Chip extends f implements a.AbstractC0121a, n {

    /* renamed from: v  reason: collision with root package name */
    private static final int f10659v = k.f25354s;

    /* renamed from: w  reason: collision with root package name */
    private static final Rect f10660w = new Rect();

    /* renamed from: x  reason: collision with root package name */
    private static final int[] f10661x = {16842913};

    /* renamed from: y  reason: collision with root package name */
    private static final int[] f10662y = {16842911};

    /* renamed from: e  reason: collision with root package name */
    private com.google.android.material.chip.a f10663e;

    /* renamed from: f  reason: collision with root package name */
    private InsetDrawable f10664f;

    /* renamed from: g  reason: collision with root package name */
    private RippleDrawable f10665g;

    /* renamed from: h  reason: collision with root package name */
    private View.OnClickListener f10666h;

    /* renamed from: i  reason: collision with root package name */
    private CompoundButton.OnCheckedChangeListener f10667i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10668j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10669k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f10670l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f10671m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10672n;

    /* renamed from: o  reason: collision with root package name */
    private int f10673o;

    /* renamed from: p  reason: collision with root package name */
    private int f10674p;

    /* renamed from: q  reason: collision with root package name */
    private final c f10675q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f10676r;

    /* renamed from: s  reason: collision with root package name */
    private final Rect f10677s;

    /* renamed from: t  reason: collision with root package name */
    private final RectF f10678t;

    /* renamed from: u  reason: collision with root package name */
    private final t7.f f10679u;

    /* loaded from: classes.dex */
    class a extends t7.f {
        a() {
        }

        @Override // t7.f
        public void a(int i10) {
        }

        @Override // t7.f
        public void b(Typeface typeface, boolean z10) {
            Chip chip = Chip.this;
            chip.setText(chip.f10663e.O2() ? Chip.this.f10663e.k1() : Chip.this.getText());
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ViewOutlineProvider {
        b() {
        }

        @Override // android.view.ViewOutlineProvider
        @TargetApi(21)
        public void getOutline(View view, Outline outline) {
            if (Chip.this.f10663e != null) {
                Chip.this.f10663e.getOutline(outline);
            } else {
                outline.setAlpha(0.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends o0.a {
        c(Chip chip) {
            super(chip);
        }

        @Override // o0.a
        protected int B(float f10, float f11) {
            return (!Chip.this.m() || !Chip.this.getCloseIconTouchBounds().contains(f10, f11)) ? 0 : 1;
        }

        @Override // o0.a
        protected void C(List<Integer> list) {
            list.add(0);
            if (Chip.this.m() && Chip.this.r() && Chip.this.f10666h != null) {
                list.add(1);
            }
        }

        @Override // o0.a
        protected boolean J(int i10, int i11, Bundle bundle) {
            if (i11 != 16) {
                return false;
            }
            if (i10 == 0) {
                return Chip.this.performClick();
            }
            if (i10 == 1) {
                return Chip.this.s();
            }
            return false;
        }

        @Override // o0.a
        protected void M(k0.c cVar) {
            cVar.Y(Chip.this.q());
            cVar.b0(Chip.this.isClickable());
            cVar.a0(Chip.this.getAccessibilityClassName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                cVar.z0(text);
            } else {
                cVar.e0(text);
            }
        }

        @Override // o0.a
        protected void N(int i10, k0.c cVar) {
            CharSequence charSequence = "";
            if (i10 == 1) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    cVar.e0(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i11 = j.f25327r;
                    Object[] objArr = new Object[1];
                    if (!TextUtils.isEmpty(text)) {
                        charSequence = text;
                    }
                    objArr[0] = charSequence;
                    cVar.e0(context.getString(i11, objArr).trim());
                }
                cVar.W(Chip.this.getCloseIconTouchBoundsInt());
                cVar.b(c.a.f29697g);
                cVar.g0(Chip.this.isEnabled());
                return;
            }
            cVar.e0(charSequence);
            cVar.W(Chip.f10660w);
        }

        @Override // o0.a
        protected void O(int i10, boolean z10) {
            if (i10 == 1) {
                Chip.this.f10671m = z10;
                Chip.this.refreshDrawableState();
            }
        }
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.f25154j);
    }

    private void A() {
        TextPaint paint = getPaint();
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            paint.drawableState = aVar.getState();
        }
        d textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.n(getContext(), paint, this.f10679u);
        }
    }

    private void B(AttributeSet attributeSet) {
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
                Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            } else if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            } else if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
                Log.w("Chip", "Chip text must be vertically center and start aligned");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f10678t.setEmpty();
        if (m() && this.f10666h != null) {
            this.f10663e.b1(this.f10678t);
        }
        return this.f10678t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f10677s.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f10677s;
    }

    private d getTextAppearance() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.l1();
        }
        return null;
    }

    private void i(com.google.android.material.chip.a aVar) {
        aVar.s2(this);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    private int[] j() {
        ?? isEnabled = isEnabled();
        int i10 = isEnabled;
        if (this.f10671m) {
            i10 = isEnabled + 1;
        }
        int i11 = i10;
        if (this.f10670l) {
            i11 = i10 + 1;
        }
        int i12 = i11;
        if (this.f10669k) {
            i12 = i11 + 1;
        }
        int i13 = i12;
        if (isChecked()) {
            i13 = i12 + 1;
        }
        int[] iArr = new int[i13];
        int i14 = 0;
        if (isEnabled()) {
            iArr[0] = 16842910;
            i14 = 1;
        }
        if (this.f10671m) {
            iArr[i14] = 16842908;
            i14++;
        }
        if (this.f10670l) {
            iArr[i14] = 16843623;
            i14++;
        }
        if (this.f10669k) {
            iArr[i14] = 16842919;
            i14++;
        }
        if (isChecked()) {
            iArr[i14] = 16842913;
        }
        return iArr;
    }

    private void l() {
        if (getBackgroundDrawable() == this.f10664f && this.f10663e.getCallback() == null) {
            this.f10663e.setCallback(this.f10664f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean m() {
        com.google.android.material.chip.a aVar = this.f10663e;
        return (aVar == null || aVar.U0() == null) ? false : true;
    }

    private void n(Context context, AttributeSet attributeSet, int i10) {
        TypedArray h10 = com.google.android.material.internal.k.h(context, attributeSet, l.f25419h0, i10, f10659v, new int[0]);
        this.f10672n = h10.getBoolean(l.O0, false);
        this.f10674p = (int) Math.ceil(h10.getDimension(l.C0, (float) Math.ceil(m.b(getContext(), 48))));
        h10.recycle();
    }

    private void o() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new b());
        }
    }

    private void p(int i10, int i11, int i12, int i13) {
        this.f10664f = new InsetDrawable((Drawable) this.f10663e, i10, i11, i12, i13);
    }

    private void setCloseIconHovered(boolean z10) {
        if (this.f10670l != z10) {
            this.f10670l = z10;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z10) {
        if (this.f10669k != z10) {
            this.f10669k = z10;
            refreshDrawableState();
        }
    }

    private void t() {
        if (this.f10664f != null) {
            this.f10664f = null;
            setMinWidth(0);
            setMinHeight((int) getChipMinHeight());
            x();
        }
    }

    private void v(com.google.android.material.chip.a aVar) {
        if (aVar != null) {
            aVar.s2(null);
        }
    }

    private void w() {
        if (!m() || !r() || this.f10666h == null) {
            d0.t0(this, null);
            this.f10676r = false;
            return;
        }
        d0.t0(this, this.f10675q);
        this.f10676r = true;
    }

    private void x() {
        if (u7.b.f35338a) {
            y();
            return;
        }
        this.f10663e.N2(true);
        d0.x0(this, getBackgroundDrawable());
        z();
        l();
    }

    private void y() {
        this.f10665g = new RippleDrawable(u7.b.d(this.f10663e.i1()), getBackgroundDrawable(), null);
        this.f10663e.N2(false);
        d0.x0(this, this.f10665g);
        z();
    }

    private void z() {
        com.google.android.material.chip.a aVar;
        if (!TextUtils.isEmpty(getText()) && (aVar = this.f10663e) != null) {
            int M0 = (int) (aVar.M0() + this.f10663e.m1() + this.f10663e.t0());
            int R0 = (int) (this.f10663e.R0() + this.f10663e.n1() + this.f10663e.p0());
            if (this.f10664f != null) {
                Rect rect = new Rect();
                this.f10664f.getPadding(rect);
                R0 += rect.left;
                M0 += rect.right;
            }
            d0.H0(this, R0, getPaddingTop(), M0, getPaddingBottom());
        }
    }

    @Override // com.google.android.material.chip.a.AbstractC0121a
    public void a() {
        k(this.f10674p);
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (!this.f10676r) {
            return super.dispatchHoverEvent(motionEvent);
        }
        return this.f10675q.v(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (!this.f10676r) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if (!this.f10675q.w(keyEvent) || this.f10675q.A() == Integer.MIN_VALUE) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.f, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        com.google.android.material.chip.a aVar = this.f10663e;
        if ((aVar == null || !aVar.s1()) ? false : this.f10663e.o2(j())) {
            invalidate();
        }
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!q()) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return (!(parent instanceof ChipGroup) || !((ChipGroup) parent).p()) ? "android.widget.CompoundButton" : "android.widget.RadioButton";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.f10664f;
        return insetDrawable == null ? this.f10663e : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.I0();
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.J0();
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.K0();
        }
        return null;
    }

    public float getChipCornerRadius() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return Math.max(0.0f, aVar.L0());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.f10663e;
    }

    public float getChipEndPadding() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.M0();
        }
        return 0.0f;
    }

    public Drawable getChipIcon() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.N0();
        }
        return null;
    }

    public float getChipIconSize() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.O0();
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.P0();
        }
        return null;
    }

    public float getChipMinHeight() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.Q0();
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.R0();
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.S0();
        }
        return null;
    }

    public float getChipStrokeWidth() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.T0();
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    public Drawable getCloseIcon() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.U0();
        }
        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.V0();
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.W0();
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.X0();
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.Y0();
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.a1();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.e1();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (!this.f10676r || !(this.f10675q.A() == 1 || this.f10675q.x() == 1)) {
            super.getFocusedRect(rect);
        } else {
            rect.set(getCloseIconTouchBoundsInt());
        }
    }

    public h getHideMotionSpec() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.f1();
        }
        return null;
    }

    public float getIconEndPadding() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.g1();
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.h1();
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.i1();
        }
        return null;
    }

    public w7.k getShapeAppearanceModel() {
        return this.f10663e.E();
    }

    public h getShowMotionSpec() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.j1();
        }
        return null;
    }

    public float getTextEndPadding() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.m1();
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            return aVar.n1();
        }
        return 0.0f;
    }

    public boolean k(int i10) {
        this.f10674p = i10;
        int i11 = 0;
        if (!u()) {
            if (this.f10664f != null) {
                t();
            } else {
                x();
            }
            return false;
        }
        int max = Math.max(0, i10 - this.f10663e.getIntrinsicHeight());
        int max2 = Math.max(0, i10 - this.f10663e.getIntrinsicWidth());
        if (max2 > 0 || max > 0) {
            int i12 = max2 > 0 ? max2 / 2 : 0;
            if (max > 0) {
                i11 = max / 2;
            }
            if (this.f10664f != null) {
                Rect rect = new Rect();
                this.f10664f.getPadding(rect);
                if (rect.top == i11 && rect.bottom == i11 && rect.left == i12 && rect.right == i12) {
                    x();
                    return true;
                }
            }
            if (Build.VERSION.SDK_INT >= 16) {
                if (getMinHeight() != i10) {
                    setMinHeight(i10);
                }
                if (getMinWidth() != i10) {
                    setMinWidth(i10);
                }
            } else {
                setMinHeight(i10);
                setMinWidth(i10);
            }
            p(i12, i11, i12, i11);
            x();
            return true;
        }
        if (this.f10664f != null) {
            t();
        } else {
            x();
        }
        return false;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        w7.h.f(this, this.f10663e);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (isChecked()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, f10661x);
        }
        if (q()) {
            CheckBox.mergeDrawableStates(onCreateDrawableState, f10662y);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        super.onFocusChanged(z10, i10, rect);
        if (this.f10676r) {
            this.f10675q.I(z10, i10, rect);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        accessibilityNodeInfo.setCheckable(q());
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            k0.c.D0(accessibilityNodeInfo).d0(c.C0359c.a(chipGroup.b(this), 1, chipGroup.c() ? chipGroup.o(this) : -1, 1, false, isChecked()));
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i10) {
        if (!getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) || !isEnabled()) {
            return null;
        }
        return PointerIcon.getSystemIcon(getContext(), 1002);
    }

    @Override // android.widget.TextView, android.view.View
    @TargetApi(17)
    public void onRtlPropertiesChanged(int i10) {
        super.onRtlPropertiesChanged(i10);
        if (this.f10673o != i10) {
            this.f10673o = i10;
            z();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
        if (r0 != 3) goto L21;
     */
    @Override // android.widget.TextView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z10;
        int actionMasked = motionEvent.getActionMasked();
        boolean contains = getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY());
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.f10669k) {
                        if (!contains) {
                            setCloseIconPressed(false);
                        }
                        z10 = true;
                    }
                }
                z10 = false;
            } else if (this.f10669k) {
                s();
                z10 = true;
                setCloseIconPressed(false);
            }
            z10 = false;
            setCloseIconPressed(false);
        } else {
            if (contains) {
                setCloseIconPressed(true);
                z10 = true;
            }
            z10 = false;
        }
        return z10 || super.onTouchEvent(motionEvent);
    }

    public boolean q() {
        com.google.android.material.chip.a aVar = this.f10663e;
        return aVar != null && aVar.r1();
    }

    public boolean r() {
        com.google.android.material.chip.a aVar = this.f10663e;
        return aVar != null && aVar.t1();
    }

    public boolean s() {
        boolean z10 = false;
        playSoundEffect(0);
        View.OnClickListener onClickListener = this.f10666h;
        if (onClickListener != null) {
            onClickListener.onClick(this);
            z10 = true;
        }
        if (this.f10676r) {
            this.f10675q.U(1, 1);
        }
        return z10;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f10665g) {
            super.setBackground(drawable);
        } else {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.f10665g) {
            super.setBackgroundDrawable(drawable);
        } else {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
        }
    }

    @Override // androidx.appcompat.widget.f, android.view.View
    public void setBackgroundResource(int i10) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean z10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.A1(z10);
        }
    }

    public void setCheckableResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.B1(i10);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener;
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar == null) {
            this.f10668j = z10;
        } else if (aVar.r1()) {
            boolean isChecked = isChecked();
            super.setChecked(z10);
            if (isChecked != z10 && (onCheckedChangeListener = this.f10667i) != null) {
                onCheckedChangeListener.onCheckedChanged(this, z10);
            }
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.C1(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z10) {
        setCheckedIconVisible(z10);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i10) {
        setCheckedIconVisible(i10);
    }

    public void setCheckedIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.D1(i10);
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.E1(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.F1(i10);
        }
    }

    public void setCheckedIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.G1(i10);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.I1(colorStateList);
        }
    }

    public void setChipBackgroundColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.J1(i10);
        }
    }

    @Deprecated
    public void setChipCornerRadius(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.K1(f10);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.L1(i10);
        }
    }

    public void setChipDrawable(com.google.android.material.chip.a aVar) {
        com.google.android.material.chip.a aVar2 = this.f10663e;
        if (aVar2 != aVar) {
            v(aVar2);
            this.f10663e = aVar;
            aVar.D2(false);
            i(this.f10663e);
            k(this.f10674p);
        }
    }

    public void setChipEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.M1(f10);
        }
    }

    public void setChipEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.N1(i10);
        }
    }

    public void setChipIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.O1(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z10) {
        setChipIconVisible(z10);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i10) {
        setChipIconVisible(i10);
    }

    public void setChipIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.P1(i10);
        }
    }

    public void setChipIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.Q1(f10);
        }
    }

    public void setChipIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.R1(i10);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.S1(colorStateList);
        }
    }

    public void setChipIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.T1(i10);
        }
    }

    public void setChipIconVisible(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.U1(i10);
        }
    }

    public void setChipMinHeight(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.W1(f10);
        }
    }

    public void setChipMinHeightResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.X1(i10);
        }
    }

    public void setChipStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.Y1(f10);
        }
    }

    public void setChipStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.Z1(i10);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.a2(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.b2(i10);
        }
    }

    public void setChipStrokeWidth(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.c2(f10);
        }
    }

    public void setChipStrokeWidthResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.d2(i10);
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i10) {
        setText(getResources().getString(i10));
    }

    public void setCloseIcon(Drawable drawable) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.f2(drawable);
        }
        w();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.g2(charSequence);
        }
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z10) {
        setCloseIconVisible(z10);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i10) {
        setCloseIconVisible(i10);
    }

    public void setCloseIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.h2(f10);
        }
    }

    public void setCloseIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.i2(i10);
        }
    }

    public void setCloseIconResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.j2(i10);
        }
        w();
    }

    public void setCloseIconSize(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.k2(f10);
        }
    }

    public void setCloseIconSizeResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.l2(i10);
        }
    }

    public void setCloseIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.m2(f10);
        }
    }

    public void setCloseIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.n2(i10);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.p2(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.q2(i10);
        }
    }

    public void setCloseIconVisible(int i10) {
        setCloseIconVisible(getResources().getBoolean(i10));
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i12 == 0) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(i10, i11, i12, i13);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i10, int i11, int i12, int i13) {
        if (i10 != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (i12 == 0) {
            super.setCompoundDrawablesWithIntrinsicBounds(i10, i11, i12, i13);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.Y(f10);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f10663e != null) {
            if (truncateAt != TextUtils.TruncateAt.MARQUEE) {
                super.setEllipsize(truncateAt);
                com.google.android.material.chip.a aVar = this.f10663e;
                if (aVar != null) {
                    aVar.t2(truncateAt);
                    return;
                }
                return;
            }
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        this.f10672n = z10;
        k(this.f10674p);
    }

    @Override // android.widget.TextView
    public void setGravity(int i10) {
        if (i10 != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i10);
        }
    }

    public void setHideMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.u2(hVar);
        }
    }

    public void setHideMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.v2(i10);
        }
    }

    public void setIconEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.w2(f10);
        }
    }

    public void setIconEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.x2(i10);
        }
    }

    public void setIconStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.y2(f10);
        }
    }

    public void setIconStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.z2(i10);
        }
    }

    @Override // android.view.View
    public void setLayoutDirection(int i10) {
        if (this.f10663e != null && Build.VERSION.SDK_INT >= 17) {
            super.setLayoutDirection(i10);
        }
    }

    @Override // android.widget.TextView
    public void setLines(int i10) {
        if (i10 <= 1) {
            super.setLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i10) {
        if (i10 <= 1) {
            super.setMaxLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i10) {
        super.setMaxWidth(i10);
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.A2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i10) {
        if (i10 <= 1) {
            super.setMinLines(i10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f10667i = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f10666h = onClickListener;
        w();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.B2(colorStateList);
        }
        if (!this.f10663e.p1()) {
            y();
        }
    }

    public void setRippleColorResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.C2(i10);
            if (!this.f10663e.p1()) {
                y();
            }
        }
    }

    @Override // w7.n
    public void setShapeAppearanceModel(w7.k kVar) {
        this.f10663e.setShapeAppearanceModel(kVar);
    }

    public void setShowMotionSpec(h hVar) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.E2(hVar);
        }
    }

    public void setShowMotionSpecResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.F2(i10);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z10) {
        if (z10) {
            super.setSingleLine(z10);
            return;
        }
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            if (charSequence == null) {
                charSequence = "";
            }
            super.setText(aVar.O2() ? null : charSequence, bufferType);
            com.google.android.material.chip.a aVar2 = this.f10663e;
            if (aVar2 != null) {
                aVar2.G2(charSequence);
            }
        }
    }

    public void setTextAppearance(d dVar) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.H2(dVar);
        }
        A();
    }

    public void setTextAppearanceResource(int i10) {
        setTextAppearance(getContext(), i10);
    }

    public void setTextEndPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.J2(f10);
        }
    }

    public void setTextEndPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.K2(i10);
        }
    }

    public void setTextStartPadding(float f10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.L2(f10);
        }
    }

    public void setTextStartPaddingResource(int i10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.M2(i10);
        }
    }

    public boolean u() {
        return this.f10672n;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Chip(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = f10659v;
        this.f10677s = new Rect();
        this.f10678t = new RectF();
        this.f10679u = new a();
        Context context2 = getContext();
        B(attributeSet);
        com.google.android.material.chip.a y02 = com.google.android.material.chip.a.y0(context2, attributeSet, i10, i11);
        n(context2, attributeSet, i10);
        setChipDrawable(y02);
        y02.Y(d0.y(this));
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, l.f25419h0, i10, i11, new int[0]);
        if (Build.VERSION.SDK_INT < 23) {
            setTextColor(t7.c.a(context2, h10, l.f25443k0));
        }
        boolean hasValue = h10.hasValue(l.T0);
        h10.recycle();
        this.f10675q = new c(this);
        w();
        if (!hasValue) {
            o();
        }
        setChecked(this.f10668j);
        setText(y02.k1());
        setEllipsize(y02.e1());
        A();
        if (!this.f10663e.O2()) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        z();
        if (u()) {
            setMinHeight(this.f10674p);
        }
        this.f10673o = d0.E(this);
    }

    public void setCloseIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.r2(z10);
        }
        w();
    }

    public void setCheckedIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.H1(z10);
        }
    }

    public void setChipIconVisible(boolean z10) {
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.V1(z10);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        } else if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        } else {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i10) {
        super.setTextAppearance(context, i10);
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.I2(i10);
        }
        A();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i10) {
        super.setTextAppearance(i10);
        com.google.android.material.chip.a aVar = this.f10663e;
        if (aVar != null) {
            aVar.I2(i10);
        }
        A();
    }
}
