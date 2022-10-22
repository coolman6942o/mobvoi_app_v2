package com.mobvoi.vpa.vpacommonlib;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ChildViewHeightLayout.java */
/* loaded from: classes2.dex */
class a extends ViewGroup {
    public a(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int childCount = getChildCount();
        int i14 = 0;
        int i15 = 0;
        while (i14 < childCount) {
            View childAt = getChildAt(i14);
            int measuredHeight = childAt.getMeasuredHeight() + i15;
            childAt.layout(0, i15, childAt.getMeasuredWidth(), measuredHeight);
            i14++;
            i15 = measuredHeight;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        if (getChildCount() == 0) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE);
            super.onMeasure(makeMeasureSpec, makeMeasureSpec);
            return;
        }
        measureChildren(i10, i11);
        View childAt = getChildAt(0);
        setMeasuredDimension(childAt.getMeasuredWidth(), childAt.getMeasuredHeight());
    }
}
