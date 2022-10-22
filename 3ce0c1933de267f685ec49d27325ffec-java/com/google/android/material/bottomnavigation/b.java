package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.e;
import androidx.core.view.d0;
import com.google.android.material.navigation.a;
import com.google.android.material.navigation.c;
import d7.d;
/* compiled from: BottomNavigationMenuView.java */
/* loaded from: classes.dex */
public class b extends c {
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private boolean I;
    private int[] J = new int[5];

    public b(Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.E = resources.getDimensionPixelSize(d.f25188d);
        this.F = resources.getDimensionPixelSize(d.f25190e);
        this.G = resources.getDimensionPixelSize(d.f25184b);
        this.H = resources.getDimensionPixelSize(d.f25186c);
    }

    @Override // com.google.android.material.navigation.c
    protected a g(Context context) {
        return new a(context);
    }

    public boolean m() {
        return this.I;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = i12 - i10;
        int i15 = i13 - i11;
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                if (d0.E(this) == 1) {
                    int i18 = i14 - i16;
                    childAt.layout(i18 - childAt.getMeasuredWidth(), 0, i18, i15);
                } else {
                    childAt.layout(i16, 0, childAt.getMeasuredWidth() + i16, i15);
                }
                i16 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        e menu = getMenu();
        int size = View.MeasureSpec.getSize(i10);
        int size2 = menu.G().size();
        int childCount = getChildCount();
        int size3 = View.MeasureSpec.getSize(i11);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
        if (!h(getLabelVisibilityMode(), size2) || !m()) {
            int min = Math.min(size / (size2 == 0 ? 1 : size2), this.G);
            int i12 = size - (size2 * min);
            for (int i13 = 0; i13 < childCount; i13++) {
                if (getChildAt(i13).getVisibility() != 8) {
                    int[] iArr = this.J;
                    iArr[i13] = min;
                    if (i12 > 0) {
                        iArr[i13] = iArr[i13] + 1;
                        i12--;
                    }
                } else {
                    this.J[i13] = 0;
                }
            }
        } else {
            View childAt = getChildAt(getSelectedItemPosition());
            int i14 = this.H;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.G, Integer.MIN_VALUE), makeMeasureSpec);
                i14 = Math.max(i14, childAt.getMeasuredWidth());
            }
            int i15 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min2 = Math.min(size - (this.F * i15), Math.min(i14, this.G));
            int i16 = size - min2;
            int min3 = Math.min(i16 / (i15 == 0 ? 1 : i15), this.E);
            int i17 = i16 - (i15 * min3);
            int i18 = 0;
            while (i18 < childCount) {
                if (getChildAt(i18).getVisibility() != 8) {
                    this.J[i18] = i18 == getSelectedItemPosition() ? min2 : min3;
                    if (i17 > 0) {
                        int[] iArr2 = this.J;
                        iArr2[i18] = iArr2[i18] + 1;
                        i17--;
                    }
                } else {
                    this.J[i18] = 0;
                }
                i18++;
            }
        }
        int i19 = 0;
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt2 = getChildAt(i20);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.J[i20], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i19 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i19, View.MeasureSpec.makeMeasureSpec(i19, 1073741824), 0), View.resolveSizeAndState(size3, i11, 0));
    }

    public void setItemHorizontalTranslationEnabled(boolean z10) {
        this.I = z10;
    }
}
