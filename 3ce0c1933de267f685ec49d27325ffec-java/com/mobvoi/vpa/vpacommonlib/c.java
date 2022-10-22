package com.mobvoi.vpa.vpacommonlib;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
/* compiled from: ViewUtils.java */
/* loaded from: classes2.dex */
class c {
    public static ViewGroup.LayoutParams a(ViewGroup viewGroup, int i10, int i11) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = null;
        RecyclerView.LayoutManager layoutManager = viewGroup instanceof RecyclerView ? ((RecyclerView) viewGroup).getLayoutManager() : null;
        if (layoutManager instanceof LinearLayoutManager) {
            if (((LinearLayoutManager) layoutManager).n2() == 1) {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            } else {
                layoutParams = new ViewGroup.LayoutParams(-2, -1);
            }
            layoutParams2 = layoutParams;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).s2() == 1) {
                layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
            } else {
                layoutParams2 = new ViewGroup.LayoutParams(-2, -1);
            }
        }
        return layoutParams2 == null ? new ViewGroup.LayoutParams(-1, -2) : layoutParams2;
    }
}
