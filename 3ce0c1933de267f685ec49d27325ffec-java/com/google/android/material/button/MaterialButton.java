package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.e;
import androidx.core.view.d0;
import androidx.core.widget.j;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.m;
import d7.k;
import d7.l;
import java.util.Iterator;
import java.util.LinkedHashSet;
import t7.c;
import w7.h;
import w7.n;
/* loaded from: classes.dex */
public class MaterialButton extends e implements Checkable, n {

    /* renamed from: q  reason: collision with root package name */
    private static final int[] f10571q = {16842911};

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f10572r = {16842912};

    /* renamed from: s  reason: collision with root package name */
    private static final int f10573s = k.f25351p;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.android.material.button.a f10574d;

    /* renamed from: e  reason: collision with root package name */
    private final LinkedHashSet<a> f10575e;

    /* renamed from: f  reason: collision with root package name */
    private b f10576f;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f10577g;

    /* renamed from: h  reason: collision with root package name */
    private ColorStateList f10578h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f10579i;

    /* renamed from: j  reason: collision with root package name */
    private int f10580j;

    /* renamed from: k  reason: collision with root package name */
    private int f10581k;

    /* renamed from: l  reason: collision with root package name */
    private int f10582l;

    /* renamed from: m  reason: collision with root package name */
    private int f10583m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f10584n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f10585o;

    /* renamed from: p  reason: collision with root package name */
    private int f10586p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: c  reason: collision with root package name */
        boolean f10587c;

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

        private void b(Parcel parcel) {
            boolean z10 = true;
            if (parcel.readInt() != 1) {
                z10 = false;
            }
            this.f10587c = z10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f10587c ? 1 : 0);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            b(parcel);
        }
    }

    /* loaded from: classes.dex */
    public interface a {
        void a(MaterialButton materialButton, boolean z10);
    }

    /* loaded from: classes.dex */
    interface b {
        void a(MaterialButton materialButton, boolean z10);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.f25170z);
    }

    private boolean c() {
        int i10 = this.f10586p;
        return i10 == 3 || i10 == 4;
    }

    private boolean d() {
        int i10 = this.f10586p;
        return i10 == 1 || i10 == 2;
    }

    private boolean e() {
        int i10 = this.f10586p;
        return i10 == 16 || i10 == 32;
    }

    private boolean f() {
        return d0.E(this) == 1;
    }

    private boolean g() {
        com.google.android.material.button.a aVar = this.f10574d;
        return aVar != null && !aVar.o();
    }

    private String getA11yClassName() {
        return (b() ? CompoundButton.class : Button.class).getName();
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(charSequence, 0, charSequence.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String charSequence = getText().toString();
        if (getTransformationMethod() != null) {
            charSequence = getTransformationMethod().getTransformation(charSequence, this).toString();
        }
        return Math.min((int) paint.measureText(charSequence), getLayout().getEllipsizedWidth());
    }

    private void i() {
        if (d()) {
            j.l(this, this.f10579i, null, null, null);
        } else if (c()) {
            j.l(this, null, null, this.f10579i, null);
        } else if (e()) {
            j.l(this, null, this.f10579i, null, null);
        }
    }

    private void j(boolean z10) {
        Drawable drawable = this.f10579i;
        boolean z11 = true;
        if (drawable != null) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f10579i = mutate;
            androidx.core.graphics.drawable.a.o(mutate, this.f10578h);
            PorterDuff.Mode mode = this.f10577g;
            if (mode != null) {
                androidx.core.graphics.drawable.a.p(this.f10579i, mode);
            }
            int i10 = this.f10580j;
            if (i10 == 0) {
                i10 = this.f10579i.getIntrinsicWidth();
            }
            int i11 = this.f10580j;
            if (i11 == 0) {
                i11 = this.f10579i.getIntrinsicHeight();
            }
            Drawable drawable2 = this.f10579i;
            int i12 = this.f10581k;
            int i13 = this.f10582l;
            drawable2.setBounds(i12, i13, i10 + i12, i11 + i13);
            this.f10579i.setVisible(true, z10);
        }
        if (z10) {
            i();
            return;
        }
        Drawable[] a10 = j.a(this);
        Drawable drawable3 = a10[0];
        Drawable drawable4 = a10[1];
        Drawable drawable5 = a10[2];
        if ((!d() || drawable3 == this.f10579i) && ((!c() || drawable5 == this.f10579i) && (!e() || drawable4 == this.f10579i))) {
            z11 = false;
        }
        if (z11) {
            i();
        }
    }

    private void k(int i10, int i11) {
        if (this.f10579i != null && getLayout() != null) {
            if (d() || c()) {
                this.f10582l = 0;
                int i12 = this.f10586p;
                boolean z10 = true;
                if (i12 == 1 || i12 == 3) {
                    this.f10581k = 0;
                    j(false);
                    return;
                }
                int i13 = this.f10580j;
                if (i13 == 0) {
                    i13 = this.f10579i.getIntrinsicWidth();
                }
                int textWidth = (((((i10 - getTextWidth()) - d0.I(this)) - i13) - this.f10583m) - d0.J(this)) / 2;
                boolean f10 = f();
                if (this.f10586p != 4) {
                    z10 = false;
                }
                if (f10 != z10) {
                    textWidth = -textWidth;
                }
                if (this.f10581k != textWidth) {
                    this.f10581k = textWidth;
                    j(false);
                }
            } else if (e()) {
                this.f10581k = 0;
                if (this.f10586p == 16) {
                    this.f10582l = 0;
                    j(false);
                    return;
                }
                int i14 = this.f10580j;
                if (i14 == 0) {
                    i14 = this.f10579i.getIntrinsicHeight();
                }
                int textHeight = (((((i11 - getTextHeight()) - getPaddingTop()) - i14) - this.f10583m) - getPaddingBottom()) / 2;
                if (this.f10582l != textHeight) {
                    this.f10582l = textHeight;
                    j(false);
                }
            }
        }
    }

    public void a(a aVar) {
        this.f10575e.add(aVar);
    }

    public boolean b() {
        com.google.android.material.button.a aVar = this.f10574d;
        return aVar != null && aVar.p();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (g()) {
            return this.f10574d.b();
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.f10579i;
    }

    public int getIconGravity() {
        return this.f10586p;
    }

    public int getIconPadding() {
        return this.f10583m;
    }

    public int getIconSize() {
        return this.f10580j;
    }

    public ColorStateList getIconTint() {
        return this.f10578h;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.f10577g;
    }

    public int getInsetBottom() {
        return this.f10574d.c();
    }

    public int getInsetTop() {
        return this.f10574d.d();
    }

    public ColorStateList getRippleColor() {
        if (g()) {
            return this.f10574d.h();
        }
        return null;
    }

    public w7.k getShapeAppearanceModel() {
        if (g()) {
            return this.f10574d.i();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (g()) {
            return this.f10574d.j();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (g()) {
            return this.f10574d.k();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.e, androidx.core.view.b0
    public ColorStateList getSupportBackgroundTintList() {
        if (g()) {
            return this.f10574d.l();
        }
        return super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.e, androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (g()) {
            return this.f10574d.m();
        }
        return super.getSupportBackgroundTintMode();
    }

    public void h(a aVar) {
        this.f10575e.remove(aVar);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f10584n;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (g()) {
            h.f(this, this.f10574d.f());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 2);
        if (b()) {
            Button.mergeDrawableStates(onCreateDrawableState, f10571q);
        }
        if (isChecked()) {
            Button.mergeDrawableStates(onCreateDrawableState, f10572r);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(b());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.e, android.widget.TextView, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        com.google.android.material.button.a aVar;
        super.onLayout(z10, i10, i11, i12, i13);
        if (Build.VERSION.SDK_INT == 21 && (aVar = this.f10574d) != null) {
            aVar.H(i13 - i11, i12 - i10);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setChecked(savedState.f10587c);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f10587c = this.f10584n;
        return savedState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        k(i10, i11);
    }

    @Override // androidx.appcompat.widget.e, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        super.onTextChanged(charSequence, i10, i11, i12);
        k(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.f10579i != null) {
            if (this.f10579i.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        if (g()) {
            this.f10574d.r(i10);
        } else {
            super.setBackgroundColor(i10);
        }
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!g()) {
            super.setBackgroundDrawable(drawable);
        } else if (drawable != getBackground()) {
            Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.f10574d.s();
            super.setBackgroundDrawable(drawable);
        } else {
            getBackground().setState(drawable.getState());
        }
    }

    @Override // androidx.appcompat.widget.e, android.view.View
    public void setBackgroundResource(int i10) {
        setBackgroundDrawable(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z10) {
        if (g()) {
            this.f10574d.t(z10);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (b() && isEnabled() && this.f10584n != z10) {
            this.f10584n = z10;
            refreshDrawableState();
            if (!this.f10585o) {
                this.f10585o = true;
                Iterator<a> it = this.f10575e.iterator();
                while (it.hasNext()) {
                    it.next().a(this, this.f10584n);
                }
                this.f10585o = false;
            }
        }
    }

    public void setCornerRadius(int i10) {
        if (g()) {
            this.f10574d.u(i10);
        }
    }

    public void setCornerRadiusResource(int i10) {
        if (g()) {
            setCornerRadius(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        if (g()) {
            this.f10574d.f().Y(f10);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.f10579i != drawable) {
            this.f10579i = drawable;
            j(true);
            k(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i10) {
        if (this.f10586p != i10) {
            this.f10586p = i10;
            k(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i10) {
        if (this.f10583m != i10) {
            this.f10583m = i10;
            setCompoundDrawablePadding(i10);
        }
    }

    public void setIconResource(int i10) {
        setIcon(i10 != 0 ? e.a.b(getContext(), i10) : null);
    }

    public void setIconSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        } else if (this.f10580j != i10) {
            this.f10580j = i10;
            j(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.f10578h != colorStateList) {
            this.f10578h = colorStateList;
            j(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.f10577g != mode) {
            this.f10577g = mode;
            j(false);
        }
    }

    public void setIconTintResource(int i10) {
        setIconTint(e.a.a(getContext(), i10));
    }

    public void setInsetBottom(int i10) {
        this.f10574d.v(i10);
    }

    public void setInsetTop(int i10) {
        this.f10574d.w(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(b bVar) {
        this.f10576f = bVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        b bVar = this.f10576f;
        if (bVar != null) {
            bVar.a(this, z10);
        }
        super.setPressed(z10);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (g()) {
            this.f10574d.x(colorStateList);
        }
    }

    public void setRippleColorResource(int i10) {
        if (g()) {
            setRippleColor(e.a.a(getContext(), i10));
        }
    }

    @Override // w7.n
    public void setShapeAppearanceModel(w7.k kVar) {
        if (g()) {
            this.f10574d.y(kVar);
            return;
        }
        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z10) {
        if (g()) {
            this.f10574d.z(z10);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (g()) {
            this.f10574d.A(colorStateList);
        }
    }

    public void setStrokeColorResource(int i10) {
        if (g()) {
            setStrokeColor(e.a.a(getContext(), i10));
        }
    }

    public void setStrokeWidth(int i10) {
        if (g()) {
            this.f10574d.B(i10);
        }
    }

    public void setStrokeWidthResource(int i10) {
        if (g()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i10));
        }
    }

    @Override // androidx.appcompat.widget.e, androidx.core.view.b0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (g()) {
            this.f10574d.C(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.e, androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (g()) {
            this.f10574d.D(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f10584n);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialButton(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r6), attributeSet, i10);
        int i11 = f10573s;
        this.f10575e = new LinkedHashSet<>();
        boolean z10 = false;
        this.f10584n = false;
        this.f10585o = false;
        Context context2 = getContext();
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, l.Z1, i10, i11, new int[0]);
        this.f10583m = h10.getDimensionPixelSize(l.f25461m2, 0);
        this.f10577g = m.e(h10.getInt(l.f25485p2, -1), PorterDuff.Mode.SRC_IN);
        this.f10578h = c.a(getContext(), h10, l.f25477o2);
        this.f10579i = c.d(getContext(), h10, l.f25445k2);
        this.f10586p = h10.getInteger(l.f25453l2, 1);
        this.f10580j = h10.getDimensionPixelSize(l.f25469n2, 0);
        com.google.android.material.button.a aVar = new com.google.android.material.button.a(this, w7.k.e(context2, attributeSet, i10, i11).m());
        this.f10574d = aVar;
        aVar.q(h10);
        h10.recycle();
        setCompoundDrawablePadding(this.f10583m);
        j(this.f10579i != null ? true : z10);
    }
}
