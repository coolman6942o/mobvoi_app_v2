package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d0;
import androidx.core.view.i;
import d7.f;
import d7.l;
/* compiled from: FlowLayout.java */
/* loaded from: classes.dex */
public class c extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private int f11053a;

    /* renamed from: b  reason: collision with root package name */
    private int f11054b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11055c;

    /* renamed from: d  reason: collision with root package name */
    private int f11056d;

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private static int a(int i10, int i11, int i12) {
        if (i11 != Integer.MIN_VALUE) {
            return i11 != 1073741824 ? i12 : i10;
        }
        return Math.min(i12, i10);
    }

    private void d(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, l.L1, 0, 0);
        this.f11053a = obtainStyledAttributes.getDimensionPixelSize(l.N1, 0);
        this.f11054b = obtainStyledAttributes.getDimensionPixelSize(l.M1, 0);
        obtainStyledAttributes.recycle();
    }

    public int b(View view) {
        Object tag = view.getTag(f.f25243a0);
        if (!(tag instanceof Integer)) {
            return -1;
        }
        return ((Integer) tag).intValue();
    }

    public boolean c() {
        return this.f11055c;
    }

    protected int getItemSpacing() {
        return this.f11054b;
    }

    protected int getLineSpacing() {
        return this.f11053a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRowCount() {
        return this.f11056d;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        if (getChildCount() == 0) {
            this.f11056d = 0;
            return;
        }
        this.f11056d = 1;
        boolean z11 = d0.E(this) == 1;
        int paddingRight = z11 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z11 ? getPaddingLeft() : getPaddingRight();
        int paddingTop = getPaddingTop();
        int i16 = (i12 - i10) - paddingLeft;
        int i17 = paddingRight;
        int i18 = paddingTop;
        for (int i19 = 0; i19 < getChildCount(); i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(f.f25243a0, -1);
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i14 = i.b(marginLayoutParams);
                    i15 = i.a(marginLayoutParams);
                } else {
                    i15 = 0;
                    i14 = 0;
                }
                int measuredWidth = i17 + i14 + childAt.getMeasuredWidth();
                if (!this.f11055c && measuredWidth > i16) {
                    i18 = this.f11053a + paddingTop;
                    this.f11056d++;
                    i17 = paddingRight;
                }
                childAt.setTag(f.f25243a0, Integer.valueOf(this.f11056d - 1));
                int i20 = i17 + i14;
                int measuredWidth2 = childAt.getMeasuredWidth() + i20;
                int measuredHeight = childAt.getMeasuredHeight() + i18;
                if (z11) {
                    childAt.layout(i16 - measuredWidth2, i18, (i16 - i17) - i14, measuredHeight);
                } else {
                    childAt.layout(i20, i18, measuredWidth2, measuredHeight);
                }
                i17 += i14 + i15 + childAt.getMeasuredWidth() + this.f11054b;
                paddingTop = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        int size = View.MeasureSpec.getSize(i10);
        int mode = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i11);
        int i14 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = i14 - getPaddingRight();
        int i15 = paddingTop;
        int i16 = 0;
        for (int i17 = 0; i17 < getChildCount(); i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, i10, i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i13 = marginLayoutParams.leftMargin + 0;
                    i12 = marginLayoutParams.rightMargin + 0;
                } else {
                    i13 = 0;
                    i12 = 0;
                }
                int i18 = paddingLeft;
                if (paddingLeft + i13 + childAt.getMeasuredWidth() > paddingRight && !c()) {
                    i18 = getPaddingLeft();
                    i15 = this.f11053a + paddingTop;
                }
                int measuredWidth = i18 + i13 + childAt.getMeasuredWidth();
                paddingTop = i15 + childAt.getMeasuredHeight();
                if (measuredWidth > i16) {
                    i16 = measuredWidth;
                }
                paddingLeft = i18 + i13 + i12 + childAt.getMeasuredWidth() + this.f11054b;
                if (i17 == getChildCount() - 1) {
                    i16 += i12;
                }
            }
        }
        setMeasuredDimension(a(size, mode, i16 + getPaddingRight()), a(size2, mode2, paddingTop + getPaddingBottom()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemSpacing(int i10) {
        this.f11054b = i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineSpacing(int i10) {
        this.f11053a = i10;
    }

    public void setSingleLine(boolean z10) {
        this.f11055c = z10;
    }

    public c(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f11055c = false;
        d(context, attributeSet);
    }
}
