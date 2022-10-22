package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.k;
/* compiled from: SmoothCalendarLayoutManager.java */
/* loaded from: classes.dex */
class n extends LinearLayoutManager {

    /* compiled from: SmoothCalendarLayoutManager.java */
    /* loaded from: classes.dex */
    class a extends k {
        a(n nVar, Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.k
        protected float v(DisplayMetrics displayMetrics) {
            return 100.0f / displayMetrics.densityDpi;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Context context, int i10, boolean z10) {
        super(context, i10, z10);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void J1(RecyclerView recyclerView, RecyclerView.y yVar, int i10) {
        a aVar = new a(this, recyclerView.getContext());
        aVar.p(i10);
        K1(aVar);
    }
}
