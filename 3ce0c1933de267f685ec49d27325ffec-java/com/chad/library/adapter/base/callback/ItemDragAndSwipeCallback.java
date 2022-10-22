package com.chad.library.adapter.base.callback;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import r5.a;
/* loaded from: classes.dex */
public class ItemDragAndSwipeCallback extends g.f {
    private BaseItemDraggableAdapter mAdapter;
    private float mMoveThreshold = 0.1f;
    private float mSwipeThreshold = 0.7f;
    private int mDragMoveFlags = 15;
    private int mSwipeMoveFlags = 32;

    public ItemDragAndSwipeCallback(BaseItemDraggableAdapter baseItemDraggableAdapter) {
        this.mAdapter = baseItemDraggableAdapter;
    }

    private boolean isViewCreateByAdapter(RecyclerView.b0 b0Var) {
        int itemViewType = b0Var.getItemViewType();
        return itemViewType == 273 || itemViewType == 546 || itemViewType == 819 || itemViewType == 1365;
    }

    @Override // androidx.recyclerview.widget.g.f
    public void clearView(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        super.clearView(recyclerView, b0Var);
        if (!isViewCreateByAdapter(b0Var)) {
            View view = b0Var.itemView;
            int i10 = a.f33431a;
            if (view.getTag(i10) != null && ((Boolean) b0Var.itemView.getTag(i10)).booleanValue()) {
                this.mAdapter.onItemDragEnd(b0Var);
                b0Var.itemView.setTag(i10, Boolean.FALSE);
            }
            View view2 = b0Var.itemView;
            int i11 = a.f33432b;
            if (view2.getTag(i11) != null && ((Boolean) b0Var.itemView.getTag(i11)).booleanValue()) {
                this.mAdapter.onItemSwipeClear(b0Var);
                b0Var.itemView.setTag(i11, Boolean.FALSE);
            }
        }
    }

    @Override // androidx.recyclerview.widget.g.f
    public float getMoveThreshold(RecyclerView.b0 b0Var) {
        return this.mMoveThreshold;
    }

    @Override // androidx.recyclerview.widget.g.f
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        if (isViewCreateByAdapter(b0Var)) {
            return g.f.makeMovementFlags(0, 0);
        }
        return g.f.makeMovementFlags(this.mDragMoveFlags, this.mSwipeMoveFlags);
    }

    @Override // androidx.recyclerview.widget.g.f
    public float getSwipeThreshold(RecyclerView.b0 b0Var) {
        return this.mSwipeThreshold;
    }

    @Override // androidx.recyclerview.widget.g.f
    public boolean isItemViewSwipeEnabled() {
        return this.mAdapter.isItemSwipeEnable();
    }

    @Override // androidx.recyclerview.widget.g.f
    public boolean isLongPressDragEnabled() {
        return false;
    }

    @Override // androidx.recyclerview.widget.g.f
    public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, float f10, float f11, int i10, boolean z10) {
        super.onChildDrawOver(canvas, recyclerView, b0Var, f10, f11, i10, z10);
        if (i10 == 1 && !isViewCreateByAdapter(b0Var)) {
            View view = b0Var.itemView;
            canvas.save();
            if (f10 > 0.0f) {
                canvas.clipRect(view.getLeft(), view.getTop(), view.getLeft() + f10, view.getBottom());
                canvas.translate(view.getLeft(), view.getTop());
            } else {
                canvas.clipRect(view.getRight() + f10, view.getTop(), view.getRight(), view.getBottom());
                canvas.translate(view.getRight() + f10, view.getTop());
            }
            this.mAdapter.onItemSwiping(canvas, b0Var, f10, f11, z10);
            canvas.restore();
        }
    }

    @Override // androidx.recyclerview.widget.g.f
    public boolean onMove(RecyclerView recyclerView, RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2) {
        return b0Var.getItemViewType() == b0Var2.getItemViewType();
    }

    @Override // androidx.recyclerview.widget.g.f
    public void onMoved(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i10, RecyclerView.b0 b0Var2, int i11, int i12, int i13) {
        super.onMoved(recyclerView, b0Var, i10, b0Var2, i11, i12, i13);
        this.mAdapter.onItemDragMoving(b0Var, b0Var2);
    }

    @Override // androidx.recyclerview.widget.g.f
    public void onSelectedChanged(RecyclerView.b0 b0Var, int i10) {
        if (i10 == 2 && !isViewCreateByAdapter(b0Var)) {
            this.mAdapter.onItemDragStart(b0Var);
            b0Var.itemView.setTag(a.f33431a, Boolean.TRUE);
        } else if (i10 == 1 && !isViewCreateByAdapter(b0Var)) {
            this.mAdapter.onItemSwipeStart(b0Var);
            b0Var.itemView.setTag(a.f33432b, Boolean.TRUE);
        }
        super.onSelectedChanged(b0Var, i10);
    }

    @Override // androidx.recyclerview.widget.g.f
    public void onSwiped(RecyclerView.b0 b0Var, int i10) {
        if (!isViewCreateByAdapter(b0Var)) {
            this.mAdapter.onItemSwiped(b0Var);
        }
    }

    public void setDragMoveFlags(int i10) {
        this.mDragMoveFlags = i10;
    }

    public void setMoveThreshold(float f10) {
        this.mMoveThreshold = f10;
    }

    public void setSwipeMoveFlags(int i10) {
        this.mSwipeMoveFlags = i10;
    }

    public void setSwipeThreshold(float f10) {
        this.mSwipeThreshold = f10;
    }
}
