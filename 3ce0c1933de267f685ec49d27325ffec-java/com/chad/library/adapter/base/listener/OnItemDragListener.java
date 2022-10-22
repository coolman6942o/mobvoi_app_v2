package com.chad.library.adapter.base.listener;

import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public interface OnItemDragListener {
    void onItemDragEnd(RecyclerView.b0 b0Var, int i10);

    void onItemDragMoving(RecyclerView.b0 b0Var, int i10, RecyclerView.b0 b0Var2, int i11);

    void onItemDragStart(RecyclerView.b0 b0Var, int i10);
}
