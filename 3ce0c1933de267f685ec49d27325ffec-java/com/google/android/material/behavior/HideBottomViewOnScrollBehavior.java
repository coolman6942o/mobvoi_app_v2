package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    private int f10445a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f10446b = 2;

    /* renamed from: c  reason: collision with root package name */
    private int f10447c = 0;

    /* renamed from: d  reason: collision with root package name */
    private ViewPropertyAnimator f10448d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.this.f10448d = null;
        }
    }

    public HideBottomViewOnScrollBehavior() {
    }

    private void F(V v10, int i10, long j10, TimeInterpolator timeInterpolator) {
        this.f10448d = v10.animate().translationY(i10).setInterpolator(timeInterpolator).setDuration(j10).setListener(new a());
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v10, View view, View view2, int i10, int i11) {
        return i10 == 2;
    }

    public boolean G() {
        return this.f10446b == 1;
    }

    public boolean H() {
        return this.f10446b == 2;
    }

    public void I(V v10, int i10) {
        this.f10447c = i10;
        if (this.f10446b == 1) {
            v10.setTranslationY(this.f10445a + i10);
        }
    }

    public void J(V v10) {
        K(v10, true);
    }

    public void K(V v10, boolean z10) {
        if (!G()) {
            ViewPropertyAnimator viewPropertyAnimator = this.f10448d;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v10.clearAnimation();
            }
            this.f10446b = 1;
            int i10 = this.f10445a + this.f10447c;
            if (z10) {
                F(v10, i10, 175L, e7.a.f25835c);
            } else {
                v10.setTranslationY(i10);
            }
        }
    }

    public void L(V v10) {
        M(v10, true);
    }

    public void M(V v10, boolean z10) {
        if (!H()) {
            ViewPropertyAnimator viewPropertyAnimator = this.f10448d;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                v10.clearAnimation();
            }
            this.f10446b = 2;
            if (z10) {
                F(v10, 0, 225L, e7.a.f25836d);
            } else {
                v10.setTranslationY(0);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, V v10, int i10) {
        this.f10445a = v10.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v10.getLayoutParams()).bottomMargin;
        return super.l(coordinatorLayout, v10, i10);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void t(CoordinatorLayout coordinatorLayout, V v10, View view, int i10, int i11, int i12, int i13, int i14, int[] iArr) {
        if (i11 > 0) {
            J(v10);
        } else if (i11 < 0) {
            L(v10);
        }
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
