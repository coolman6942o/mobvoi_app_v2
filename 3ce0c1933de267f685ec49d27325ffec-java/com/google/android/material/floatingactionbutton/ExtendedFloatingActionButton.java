package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.d0;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.unionpay.tsmservice.mi.data.Constant;
import d7.l;
import e7.h;
import java.util.List;
/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.b {
    private boolean A;
    private boolean B;
    private boolean C;

    /* renamed from: t  reason: collision with root package name */
    private int f10869t;

    /* renamed from: u  reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.d f10870u;

    /* renamed from: v  reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.d f10871v;

    /* renamed from: w  reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.d f10872w;

    /* renamed from: x  reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.d f10873x;

    /* renamed from: y  reason: collision with root package name */
    private final int f10874y;

    /* renamed from: z  reason: collision with root package name */
    private final CoordinatorLayout.c<ExtendedFloatingActionButton> f10875z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private boolean f10881a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.android.material.floatingactionbutton.d f10882b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f10883c;

        a(ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.d dVar, f fVar) {
            this.f10882b = dVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f10881a = true;
            this.f10882b.a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f10882b.onAnimationEnd();
            if (!this.f10881a) {
                this.f10882b.h(this.f10883c);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f10882b.onAnimationStart(animator);
            this.f10881a = false;
        }
    }

    /* loaded from: classes.dex */
    static class b extends Property<View, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            view.getLayoutParams().width = f10.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    static class c extends Property<View, Float> {
        c(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            view.getLayoutParams().height = f10.intValue();
            view.requestLayout();
        }
    }

    /* loaded from: classes.dex */
    static class d extends Property<View, Float> {
        d(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(d0.J(view));
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            d0.H0(view, f10.intValue(), view.getPaddingTop(), d0.I(view), view.getPaddingBottom());
        }
    }

    /* loaded from: classes.dex */
    static class e extends Property<View, Float> {
        e(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(View view) {
            return Float.valueOf(d0.I(view));
        }

        /* renamed from: b */
        public void set(View view, Float f10) {
            d0.H0(view, d0.J(view), view.getPaddingTop(), f10.intValue(), view.getPaddingBottom());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
    }

    static {
        new b(Float.class, Constant.KEY_WIDTH);
        new c(Float.class, Constant.KEY_HEIGHT);
        new d(Float.class, "paddingStart");
        new e(Float.class, "paddingEnd");
    }

    private boolean q() {
        return getVisibility() != 0 ? this.f10869t == 2 : this.f10869t != 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(com.google.android.material.floatingactionbutton.d dVar, f fVar) {
        if (!dVar.d()) {
            if (!t()) {
                dVar.b();
                dVar.h(fVar);
                return;
            }
            measure(0, 0);
            AnimatorSet f10 = dVar.f();
            f10.addListener(new a(this, dVar, fVar));
            for (Animator.AnimatorListener animatorListener : dVar.g()) {
                f10.addListener(animatorListener);
            }
            f10.start();
        }
    }

    private void s() {
        getTextColors();
    }

    private boolean t() {
        return (d0.X(this) || (!q() && this.C)) && !isInEditMode();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.b
    public CoordinatorLayout.c<ExtendedFloatingActionButton> getBehavior() {
        return this.f10875z;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    int getCollapsedSize() {
        int i10 = this.f10874y;
        return i10 < 0 ? (Math.min(d0.J(this), d0.I(this)) * 2) + getIconSize() : i10;
    }

    public h getExtendMotionSpec() {
        return this.f10871v.c();
    }

    public h getHideMotionSpec() {
        return this.f10873x.c();
    }

    public h getShowMotionSpec() {
        return this.f10872w.c();
    }

    public h getShrinkMotionSpec() {
        return this.f10870u.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.A && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.A = false;
            this.f10870u.b();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z10) {
        this.C = z10;
    }

    public void setExtendMotionSpec(h hVar) {
        this.f10871v.e(hVar);
    }

    public void setExtendMotionSpecResource(int i10) {
        setExtendMotionSpec(h.c(getContext(), i10));
    }

    public void setExtended(boolean z10) {
        if (this.A != z10) {
            com.google.android.material.floatingactionbutton.d dVar = z10 ? this.f10871v : this.f10870u;
            if (!dVar.d()) {
                dVar.b();
            }
        }
    }

    public void setHideMotionSpec(h hVar) {
        this.f10873x.e(hVar);
    }

    public void setHideMotionSpecResource(int i10) {
        setHideMotionSpec(h.c(getContext(), i10));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i10, int i11, int i12, int i13) {
        super.setPadding(i10, i11, i12, i13);
        if (this.A && !this.B) {
            d0.J(this);
            d0.I(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i10, int i11, int i12, int i13) {
        super.setPaddingRelative(i10, i11, i12, i13);
    }

    public void setShowMotionSpec(h hVar) {
        this.f10872w.e(hVar);
    }

    public void setShowMotionSpecResource(int i10) {
        setShowMotionSpec(h.c(getContext(), i10));
    }

    public void setShrinkMotionSpec(h hVar) {
        this.f10870u.e(hVar);
    }

    public void setShrinkMotionSpecResource(int i10) {
        setShrinkMotionSpec(h.c(getContext(), i10));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i10) {
        super.setTextColor(i10);
        s();
    }

    /* loaded from: classes.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.c<T> {

        /* renamed from: a  reason: collision with root package name */
        private Rect f10876a;

        /* renamed from: b  reason: collision with root package name */
        private f f10877b;

        /* renamed from: c  reason: collision with root package name */
        private f f10878c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f10879d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f10880e;

        public ExtendedFloatingActionButtonBehavior() {
            this.f10879d = false;
            this.f10880e = true;
        }

        private static boolean G(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.f) {
                return ((CoordinatorLayout.f) layoutParams).f() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean J(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.f10879d || this.f10880e) && ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams()).e() == view.getId();
        }

        private boolean L(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.f10876a == null) {
                this.f10876a = new Rect();
            }
            Rect rect = this.f10876a;
            com.google.android.material.internal.b.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        private boolean M(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!J(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.f) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                K(extendedFloatingActionButton);
                return true;
            }
            E(extendedFloatingActionButton);
            return true;
        }

        protected void E(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z10 = this.f10880e;
            extendedFloatingActionButton.r(z10 ? extendedFloatingActionButton.f10871v : extendedFloatingActionButton.f10872w, z10 ? this.f10878c : this.f10877b);
        }

        /* renamed from: F */
        public boolean b(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.b(coordinatorLayout, extendedFloatingActionButton, rect);
        }

        /* renamed from: H */
        public boolean h(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            } else if (!G(view)) {
                return false;
            } else {
                M(view, extendedFloatingActionButton);
                return false;
            }
        }

        /* renamed from: I */
        public boolean l(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i10) {
            List<View> r10 = coordinatorLayout.r(extendedFloatingActionButton);
            int size = r10.size();
            for (int i11 = 0; i11 < size; i11++) {
                View view = r10.get(i11);
                if (!(view instanceof AppBarLayout)) {
                    if (G(view) && M(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else if (L(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.I(extendedFloatingActionButton, i10);
            return true;
        }

        protected void K(ExtendedFloatingActionButton extendedFloatingActionButton) {
            boolean z10 = this.f10880e;
            extendedFloatingActionButton.r(z10 ? extendedFloatingActionButton.f10870u : extendedFloatingActionButton.f10873x, z10 ? this.f10878c : this.f10877b);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public void g(CoordinatorLayout.f fVar) {
            if (fVar.f2205h == 0) {
                fVar.f2205h = 80;
            }
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f25492q1);
            this.f10879d = obtainStyledAttributes.getBoolean(l.f25499r1, false);
            this.f10880e = obtainStyledAttributes.getBoolean(l.f25507s1, true);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        s();
    }
}
