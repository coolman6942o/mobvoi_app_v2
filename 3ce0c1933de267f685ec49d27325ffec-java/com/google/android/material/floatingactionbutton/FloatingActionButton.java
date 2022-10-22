package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.j;
import androidx.appcompat.widget.p;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.b0;
import androidx.core.view.d0;
import androidx.core.widget.o;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.b;
import com.google.android.material.internal.m;
import com.google.android.material.internal.n;
import com.google.android.material.stateful.ExtendableSavedState;
import d7.k;
import d7.l;
import e7.h;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingActionButton extends n implements b0, o, o7.a, w7.n, CoordinatorLayout.b {

    /* renamed from: r  reason: collision with root package name */
    private static final int f10884r = k.f25346k;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f10885b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f10886c;

    /* renamed from: d  reason: collision with root package name */
    private ColorStateList f10887d;

    /* renamed from: e  reason: collision with root package name */
    private PorterDuff.Mode f10888e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f10889f;

    /* renamed from: g  reason: collision with root package name */
    private int f10890g;

    /* renamed from: h  reason: collision with root package name */
    private int f10891h;

    /* renamed from: i  reason: collision with root package name */
    private int f10892i;

    /* renamed from: j  reason: collision with root package name */
    private int f10893j;

    /* renamed from: k  reason: collision with root package name */
    private int f10894k;

    /* renamed from: l  reason: collision with root package name */
    boolean f10895l;

    /* renamed from: m  reason: collision with root package name */
    final Rect f10896m;

    /* renamed from: n  reason: collision with root package name */
    private final Rect f10897n;

    /* renamed from: o  reason: collision with root package name */
    private final p f10898o;

    /* renamed from: p  reason: collision with root package name */
    private final o7.b f10899p;

    /* renamed from: q  reason: collision with root package name */
    private com.google.android.material.floatingactionbutton.b f10900q;

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements b.k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f10904a;

        a(b bVar) {
            this.f10904a = bVar;
        }

        @Override // com.google.android.material.floatingactionbutton.b.k
        public void a() {
            this.f10904a.b(FloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.b.k
        public void b() {
            this.f10904a.a(FloatingActionButton.this);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public void a(FloatingActionButton floatingActionButton) {
        }

        public void b(FloatingActionButton floatingActionButton) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements v7.b {
        c() {
        }

        @Override // v7.b
        public void a(int i10, int i11, int i12, int i13) {
            FloatingActionButton.this.f10896m.set(i10, i11, i12, i13);
            FloatingActionButton floatingActionButton = FloatingActionButton.this;
            floatingActionButton.setPadding(i10 + floatingActionButton.f10893j, i11 + FloatingActionButton.this.f10893j, i12 + FloatingActionButton.this.f10893j, i13 + FloatingActionButton.this.f10893j);
        }

        @Override // v7.b
        public boolean b() {
            return FloatingActionButton.this.f10895l;
        }

        @Override // v7.b
        public void c(Drawable drawable) {
            if (drawable != null) {
                FloatingActionButton.super.setBackgroundDrawable(drawable);
            }
        }
    }

    /* loaded from: classes.dex */
    class d<T extends FloatingActionButton> implements b.j {

        /* renamed from: a  reason: collision with root package name */
        private final e7.k<T> f10907a;

        d(e7.k<T> kVar) {
            this.f10907a = kVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.b.j
        public void a() {
            this.f10907a.b(FloatingActionButton.this);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.floatingactionbutton.b.j
        public void b() {
            this.f10907a.a(FloatingActionButton.this);
        }

        public boolean equals(Object obj) {
            return (obj instanceof d) && ((d) obj).f10907a.equals(this.f10907a);
        }

        public int hashCode() {
            return this.f10907a.hashCode();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d7.b.f25167w);
    }

    private com.google.android.material.floatingactionbutton.b g() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new com.google.android.material.floatingactionbutton.c(this, new c());
        }
        return new com.google.android.material.floatingactionbutton.b(this, new c());
    }

    private com.google.android.material.floatingactionbutton.b getImpl() {
        if (this.f10900q == null) {
            this.f10900q = g();
        }
        return this.f10900q;
    }

    private int j(int i10) {
        int i11 = this.f10892i;
        if (i11 != 0) {
            return i11;
        }
        Resources resources = getResources();
        if (i10 != -1) {
            if (i10 != 1) {
                return resources.getDimensionPixelSize(d7.d.f25200j);
            }
            return resources.getDimensionPixelSize(d7.d.f25198i);
        } else if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return j(1);
        } else {
            return j(0);
        }
    }

    private void p(Rect rect) {
        int i10 = rect.left;
        Rect rect2 = this.f10896m;
        rect.left = i10 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    private void q() {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            ColorStateList colorStateList = this.f10887d;
            if (colorStateList == null) {
                androidx.core.graphics.drawable.a.c(drawable);
                return;
            }
            int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
            PorterDuff.Mode mode = this.f10888e;
            if (mode == null) {
                mode = PorterDuff.Mode.SRC_IN;
            }
            drawable.mutate().setColorFilter(j.e(colorForState, mode));
        }
    }

    private static int r(int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i10, size);
        }
        if (mode == 0) {
            return i10;
        }
        if (mode == 1073741824) {
            return size;
        }
        throw new IllegalArgumentException();
    }

    private b.k v(b bVar) {
        if (bVar == null) {
            return null;
        }
        return new a(bVar);
    }

    public void d(Animator.AnimatorListener animatorListener) {
        getImpl().e(animatorListener);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().E(getDrawableState());
    }

    public void e(Animator.AnimatorListener animatorListener) {
        getImpl().f(animatorListener);
    }

    public void f(e7.k<? extends FloatingActionButton> kVar) {
        getImpl().g(new d(kVar));
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f10885b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f10886c;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<FloatingActionButton> getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().n();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().q();
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().t();
    }

    public Drawable getContentBackground() {
        return getImpl().m();
    }

    public int getCustomSize() {
        return this.f10892i;
    }

    public int getExpandedComponentIdHint() {
        return this.f10899p.b();
    }

    public h getHideMotionSpec() {
        return getImpl().p();
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f10889f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f10889f;
    }

    public w7.k getShapeAppearanceModel() {
        return (w7.k) j0.h.g(getImpl().u());
    }

    public h getShowMotionSpec() {
        return getImpl().v();
    }

    public int getSize() {
        return this.f10891h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSizeDimension() {
        return j(this.f10891h);
    }

    @Override // androidx.core.view.b0
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // androidx.core.view.b0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // androidx.core.widget.o
    public ColorStateList getSupportImageTintList() {
        return this.f10887d;
    }

    @Override // androidx.core.widget.o
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f10888e;
    }

    public boolean getUseCompatPadding() {
        return this.f10895l;
    }

    @Deprecated
    public boolean h(Rect rect) {
        if (!d0.X(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        p(rect);
        return true;
    }

    public void i(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        p(rect);
    }

    @Override // o7.a
    public boolean isExpanded() {
        return this.f10899p.c();
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().A();
    }

    public void k() {
        l(null);
    }

    public void l(b bVar) {
        m(bVar, true);
    }

    void m(b bVar, boolean z10) {
        getImpl().w(v(bVar), z10);
    }

    public boolean n() {
        return getImpl().y();
    }

    public boolean o() {
        return getImpl().z();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().B();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().D();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i10, int i11) {
        int sizeDimension = getSizeDimension();
        this.f10893j = (sizeDimension - this.f10894k) / 2;
        getImpl().f0();
        int min = Math.min(r(sizeDimension, i10), r(sizeDimension, i11));
        Rect rect = this.f10896m;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        this.f10899p.d((Bundle) j0.h.g(extendableSavedState.f11333c.get("expandableWidgetHelper")));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        extendableSavedState.f11333c.put("expandableWidgetHelper", this.f10899p.e());
        return extendableSavedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || !h(this.f10897n) || this.f10897n.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void s() {
        t(null);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f10885b != colorStateList) {
            this.f10885b = colorStateList;
            getImpl().L(colorStateList);
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f10886c != mode) {
            this.f10886c = mode;
            getImpl().M(mode);
        }
    }

    public void setCompatElevation(float f10) {
        getImpl().N(f10);
    }

    public void setCompatElevationResource(int i10) {
        setCompatElevation(getResources().getDimension(i10));
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        getImpl().Q(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i10) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i10));
    }

    public void setCompatPressedTranslationZ(float f10) {
        getImpl().U(f10);
    }

    public void setCompatPressedTranslationZResource(int i10) {
        setCompatPressedTranslationZ(getResources().getDimension(i10));
    }

    public void setCustomSize(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        } else if (i10 != this.f10892i) {
            this.f10892i = i10;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        getImpl().g0(f10);
    }

    public void setEnsureMinTouchTargetSize(boolean z10) {
        if (z10 != getImpl().o()) {
            getImpl().O(z10);
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i10) {
        this.f10899p.f(i10);
    }

    public void setHideMotionSpec(h hVar) {
        getImpl().P(hVar);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(h.c(getContext(), i10));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            getImpl().e0();
            if (this.f10887d != null) {
                q();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i10) {
        this.f10898o.i(i10);
        q();
    }

    public void setMaxImageSize(int i10) {
        this.f10894k = i10;
        getImpl().S(i10);
    }

    public void setRippleColor(int i10) {
        setRippleColor(ColorStateList.valueOf(i10));
    }

    @Override // android.view.View
    public void setScaleX(float f10) {
        super.setScaleX(f10);
        getImpl().I();
    }

    @Override // android.view.View
    public void setScaleY(float f10) {
        super.setScaleY(f10);
        getImpl().I();
    }

    public void setShadowPaddingEnabled(boolean z10) {
        getImpl().W(z10);
    }

    @Override // w7.n
    public void setShapeAppearanceModel(w7.k kVar) {
        getImpl().X(kVar);
    }

    public void setShowMotionSpec(h hVar) {
        getImpl().Y(hVar);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(h.c(getContext(), i10));
    }

    public void setSize(int i10) {
        this.f10892i = 0;
        if (i10 != this.f10891h) {
            this.f10891h = i10;
            requestLayout();
        }
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // androidx.core.view.b0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // androidx.core.widget.o
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f10887d != colorStateList) {
            this.f10887d = colorStateList;
            q();
        }
    }

    @Override // androidx.core.widget.o
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f10888e != mode) {
            this.f10888e = mode;
            q();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f10) {
        super.setTranslationX(f10);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationY(float f10) {
        super.setTranslationY(f10);
        getImpl().J();
    }

    @Override // android.view.View
    public void setTranslationZ(float f10) {
        super.setTranslationZ(f10);
        getImpl().J();
    }

    public void setUseCompatPadding(boolean z10) {
        if (this.f10895l != z10) {
            this.f10895l = z10;
            getImpl().C();
        }
    }

    @Override // com.google.android.material.internal.n, android.widget.ImageView, android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
    }

    public void t(b bVar) {
        u(bVar, true);
    }

    void u(b bVar, boolean z10) {
        getImpl().c0(v(bVar), z10);
    }

    /* loaded from: classes.dex */
    protected static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f10901a;

        /* renamed from: b  reason: collision with root package name */
        private b f10902b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f10903c;

        public BaseBehavior() {
            this.f10903c = true;
        }

        private static boolean F(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private void G(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i10;
            Rect rect = floatingActionButton.f10896m;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                CoordinatorLayout.f fVar = (CoordinatorLayout.f) floatingActionButton.getLayoutParams();
                int i11 = 0;
                if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin) {
                    i10 = rect.right;
                } else {
                    i10 = floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
                }
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                    i11 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                    i11 = -rect.top;
                }
                if (i11 != 0) {
                    d0.e0(floatingActionButton, i11);
                }
                if (i10 != 0) {
                    d0.d0(floatingActionButton, i10);
                }
            }
        }

        private boolean J(View view, FloatingActionButton floatingActionButton) {
            return this.f10903c && ((CoordinatorLayout.f) floatingActionButton.getLayoutParams()).e() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        private boolean K(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!J(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f10901a == null) {
                this.f10901a = new Rect();
            }
            Rect rect = this.f10901a;
            com.google.android.material.internal.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m(this.f10902b, false);
                return true;
            }
            floatingActionButton.u(this.f10902b, false);
            return true;
        }

        private boolean L(View view, FloatingActionButton floatingActionButton) {
            if (!J(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.m(this.f10902b, false);
                return true;
            }
            floatingActionButton.u(this.f10902b, false);
            return true;
        }

        /* renamed from: E */
        public boolean b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f10896m;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* renamed from: H */
        public boolean h(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                K(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            } else if (!F(view)) {
                return false;
            } else {
                L(view, floatingActionButton);
                return false;
            }
        }

        /* renamed from: I */
        public boolean l(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i10) {
            List<View> r10 = coordinatorLayout.r(floatingActionButton);
            int size = r10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = r10.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (F(view) && L(view, floatingActionButton)) {
                        break;
                    }
                } else if (K(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.I(floatingActionButton, i10);
            G(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f2205h == 0) {
                fVar.f2205h = 80;
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.J1);
            this.f10903c = obtainStyledAttributes.getBoolean(l.K1, true);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FloatingActionButton(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r6), attributeSet, i10);
        int i11 = f10884r;
        this.f10896m = new Rect();
        this.f10897n = new Rect();
        Context context2 = getContext();
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, l.f25515t1, i10, i11, new int[0]);
        this.f10885b = t7.c.a(context2, h10, l.f25531v1);
        this.f10886c = m.e(h10.getInt(l.f25539w1, -1), null);
        this.f10889f = t7.c.a(context2, h10, l.G1);
        this.f10891h = h10.getInt(l.B1, -1);
        this.f10892i = h10.getDimensionPixelSize(l.A1, 0);
        this.f10890g = h10.getDimensionPixelSize(l.f25547x1, 0);
        float dimension = h10.getDimension(l.f25555y1, 0.0f);
        float dimension2 = h10.getDimension(l.D1, 0.0f);
        float dimension3 = h10.getDimension(l.F1, 0.0f);
        this.f10895l = h10.getBoolean(l.I1, false);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d7.d.f25207m0);
        setMaxImageSize(h10.getDimensionPixelSize(l.E1, 0));
        h b10 = h.b(context2, h10, l.H1);
        h b11 = h.b(context2, h10, l.C1);
        w7.k m10 = w7.k.g(context2, attributeSet, i10, i11, w7.k.f36064m).m();
        boolean z10 = h10.getBoolean(l.f25563z1, false);
        setEnabled(h10.getBoolean(l.f25523u1, true));
        h10.recycle();
        p pVar = new p(this);
        this.f10898o = pVar;
        pVar.g(attributeSet, i10);
        this.f10899p = new o7.b(this);
        getImpl().X(m10);
        getImpl().x(this.f10885b, this.f10886c, this.f10889f, this.f10890g);
        getImpl().T(dimensionPixelSize);
        getImpl().N(dimension);
        getImpl().Q(dimension2);
        getImpl().U(dimension3);
        getImpl().Y(b10);
        getImpl().P(b11);
        getImpl().O(z10);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f10889f != colorStateList) {
            this.f10889f = colorStateList;
            getImpl().V(this.f10889f);
        }
    }
}
