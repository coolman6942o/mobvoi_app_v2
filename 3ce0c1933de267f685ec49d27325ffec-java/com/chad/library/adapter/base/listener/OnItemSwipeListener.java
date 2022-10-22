package com.chad.library.adapter.base.listener;

import android.graphics.Canvas;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public interface OnItemSwipeListener {
    void clearView(RecyclerView.b0 b0Var, int i10);

    void onItemSwipeMoving(Canvas canvas, RecyclerView.b0 b0Var, float f10, float f11, boolean z10);

    void onItemSwipeStart(RecyclerView.b0 b0Var, int i10);

    void onItemSwiped(RecyclerView.b0 b0Var, int i10);
}
