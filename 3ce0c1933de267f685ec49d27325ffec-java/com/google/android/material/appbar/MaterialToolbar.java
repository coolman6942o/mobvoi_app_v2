package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.a;
import androidx.core.view.d0;
import com.google.android.material.internal.l;
import d7.b;
import d7.k;
import w7.g;
import w7.h;
/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    private static final int U = k.E;
    private Integer R;
    private boolean S;
    private boolean T;

    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f25146b0);
    }

    private Pair<Integer, Integer> R(TextView textView, TextView textView2) {
        int measuredWidth = getMeasuredWidth();
        int i10 = measuredWidth / 2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = measuredWidth - getPaddingRight();
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (!(childAt.getVisibility() == 8 || childAt == textView || childAt == textView2)) {
                if (childAt.getRight() < i10 && childAt.getRight() > paddingLeft) {
                    paddingLeft = childAt.getRight();
                }
                if (childAt.getLeft() > i10 && childAt.getLeft() < paddingRight) {
                    paddingRight = childAt.getLeft();
                }
            }
        }
        return new Pair<>(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
    }

    private void S(Context context) {
        Drawable background = getBackground();
        if (background == null || (background instanceof ColorDrawable)) {
            g gVar = new g();
            gVar.Z(ColorStateList.valueOf(background != null ? ((ColorDrawable) background).getColor() : 0));
            gVar.O(context);
            gVar.Y(d0.y(this));
            d0.x0(this, gVar);
        }
    }

    private void T(View view, Pair<Integer, Integer> pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = view.getMeasuredWidth();
        int i10 = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i11 = measuredWidth2 + i10;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i10, 0), Math.max(i11 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i10 += max;
            i11 -= max;
            view.measure(View.MeasureSpec.makeMeasureSpec(i11 - i10, 1073741824), view.getMeasuredHeightAndState());
        }
        view.layout(i10, view.getTop(), i11, view.getBottom());
    }

    private void U() {
        if (this.S || this.T) {
            TextView c10 = l.c(this);
            TextView a10 = l.a(this);
            if (c10 != null || a10 != null) {
                Pair<Integer, Integer> R = R(c10, a10);
                if (this.S && c10 != null) {
                    T(c10, R);
                }
                if (this.T && a10 != null) {
                    T(a10, R);
                }
            }
        }
    }

    private Drawable V(Drawable drawable) {
        if (drawable == null || this.R == null) {
            return drawable;
        }
        Drawable r10 = a.r(drawable.mutate());
        a.n(r10, this.R.intValue());
        return r10;
    }

    public Integer getNavigationIconTint() {
        return this.R;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        U();
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        h.d(this, f10);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(V(drawable));
    }

    public void setNavigationIconTint(int i10) {
        this.R = Integer.valueOf(i10);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    public void setSubtitleCentered(boolean z10) {
        if (this.T != z10) {
            this.T = z10;
            requestLayout();
        }
    }

    public void setTitleCentered(boolean z10) {
        if (this.S != z10) {
            this.S = z10;
            requestLayout();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MaterialToolbar(Context context, AttributeSet attributeSet, int i10) {
        super(x7.a.c(context, attributeSet, i10, r4), attributeSet, i10);
        int i11 = U;
        Context context2 = getContext();
        TypedArray h10 = com.google.android.material.internal.k.h(context2, attributeSet, d7.l.A3, i10, i11, new int[0]);
        int i12 = d7.l.B3;
        if (h10.hasValue(i12)) {
            setNavigationIconTint(h10.getColor(i12, -1));
        }
        this.S = h10.getBoolean(d7.l.D3, false);
        this.T = h10.getBoolean(d7.l.C3, false);
        h10.recycle();
        S(context2);
    }
}
