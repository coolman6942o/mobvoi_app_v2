package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;
/* loaded from: classes2.dex */
public class OnlineDialGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    public boolean f19586a;

    public OnlineDialGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        this.f19586a = false;
        super.onLayout(z10, i10, i11, i12, i13);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i10, int i11) {
        this.f19586a = true;
        super.onMeasure(i10, i11);
    }
}
