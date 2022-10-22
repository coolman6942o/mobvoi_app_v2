package com.mobvoi.mcuwatch.ui.onlinedial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
/* loaded from: classes2.dex */
public class CustomDialGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f19868a;

    public CustomDialGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f19868a = false;
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i10, int i11) {
        this.f19868a = true;
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }
}
