package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import d7.b;
import d7.h;
/* loaded from: classes.dex */
public class Snackbar extends BaseTransientBottomBar<Snackbar> {

    /* renamed from: x  reason: collision with root package name */
    private static final int[] f11318x = {b.O, b.Q};

    /* renamed from: v  reason: collision with root package name */
    private final AccessibilityManager f11319v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f11320w;

    /* loaded from: classes.dex */
    public static final class SnackbarLayout extends BaseTransientBottomBar.v {
        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.widget.FrameLayout, android.view.View
        public void onMeasure(int i10, int i11) {
            super.onMeasure(i10, i11);
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getLayoutParams().width == -1) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824));
                }
            }
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setBackground(Drawable drawable) {
            super.setBackground(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundDrawable(Drawable drawable) {
            super.setBackgroundDrawable(drawable);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintList(ColorStateList colorStateList) {
            super.setBackgroundTintList(colorStateList);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setBackgroundTintMode(PorterDuff.Mode mode) {
            super.setBackgroundTintMode(mode);
        }

        @Override // com.google.android.material.snackbar.BaseTransientBottomBar.v, android.view.View
        public /* bridge */ /* synthetic */ void setOnClickListener(View.OnClickListener onClickListener) {
            super.setOnClickListener(onClickListener);
        }
    }

    private Snackbar(Context context, ViewGroup viewGroup, View view, a aVar) {
        super(context, viewGroup, view, aVar);
        this.f11319v = (AccessibilityManager) viewGroup.getContext().getSystemService("accessibility");
    }

    private static ViewGroup W(View view) {
        ViewGroup viewGroup = null;
        while (!(view instanceof CoordinatorLayout)) {
            if (view instanceof FrameLayout) {
                if (view.getId() == 16908290) {
                    return (ViewGroup) view;
                }
                viewGroup = (ViewGroup) view;
            }
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent instanceof View) {
                    view = (View) parent;
                    continue;
                } else {
                    view = null;
                    continue;
                }
            }
            if (view == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view;
    }

    private static boolean X(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f11318x);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        return (resourceId == -1 || resourceId2 == -1) ? false : true;
    }

    public static Snackbar Y(View view, CharSequence charSequence, int i10) {
        return Z(null, view, charSequence, i10);
    }

    private static Snackbar Z(Context context, View view, CharSequence charSequence, int i10) {
        ViewGroup W = W(view);
        if (W != null) {
            if (context == null) {
                context = W.getContext();
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) LayoutInflater.from(context).inflate(X(context) ? h.f25306x : h.f25286d, W, false);
            Snackbar snackbar = new Snackbar(context, W, snackbarContentLayout, snackbarContentLayout);
            snackbar.a0(charSequence);
            snackbar.K(i10);
            return snackbar;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void O() {
        super.O();
    }

    public Snackbar a0(CharSequence charSequence) {
        ((SnackbarContentLayout) this.f11269c.getChildAt(0)).getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar b0(int i10) {
        ((SnackbarContentLayout) this.f11269c.getChildAt(0)).getMessageView().setTextColor(i10);
        return this;
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public void s() {
        super.s();
    }

    @Override // com.google.android.material.snackbar.BaseTransientBottomBar
    public int w() {
        int w10 = super.w();
        if (w10 == -2) {
            return -2;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return this.f11319v.getRecommendedTimeoutMillis(w10, (this.f11320w ? 4 : 0) | 1 | 2);
        } else if (!this.f11320w || !this.f11319v.isTouchExplorationEnabled()) {
            return w10;
        } else {
            return -2;
        }
    }
}
