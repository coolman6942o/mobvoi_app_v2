package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.o;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import java.util.Collections;
import java.util.List;
import r5.a;
/* loaded from: classes.dex */
public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final String ERROR_NOT_SAME_ITEMTOUCHHELPER = "Item drag and item swipe should pass the same ItemTouchHelper";
    private static final int NO_TOGGLE_VIEW = 0;
    protected g mItemTouchHelper;
    protected OnItemDragListener mOnItemDragListener;
    protected OnItemSwipeListener mOnItemSwipeListener;
    protected View.OnLongClickListener mOnToggleViewLongClickListener;
    protected View.OnTouchListener mOnToggleViewTouchListener;
    protected int mToggleViewId = 0;
    protected boolean itemDragEnabled = false;
    protected boolean itemSwipeEnabled = false;
    protected boolean mDragOnLongPress = true;

    public BaseItemDraggableAdapter(List<T> list) {
        super(list);
    }

    private boolean inRange(int i10) {
        return i10 >= 0 && i10 < this.mData.size();
    }

    public void disableDragItem() {
        this.itemDragEnabled = false;
        this.mItemTouchHelper = null;
    }

    public void disableSwipeItem() {
        this.itemSwipeEnabled = false;
    }

    public void enableDragItem(g gVar) {
        enableDragItem(gVar, 0, true);
    }

    public void enableSwipeItem() {
        this.itemSwipeEnabled = true;
    }

    public int getViewHolderPosition(RecyclerView.b0 b0Var) {
        return b0Var.getAdapterPosition() - getHeaderLayoutCount();
    }

    public boolean isItemDraggable() {
        return this.itemDragEnabled;
    }

    public boolean isItemSwipeEnable() {
        return this.itemSwipeEnabled;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.b0 b0Var, int i10) {
        onBindViewHolder((BaseItemDraggableAdapter<T, K>) ((BaseViewHolder) b0Var), i10);
    }

    public void onItemDragEnd(RecyclerView.b0 b0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null && this.itemDragEnabled) {
            onItemDragListener.onItemDragEnd(b0Var, getViewHolderPosition(b0Var));
        }
    }

    public void onItemDragMoving(RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2) {
        int viewHolderPosition = getViewHolderPosition(b0Var);
        int viewHolderPosition2 = getViewHolderPosition(b0Var2);
        if (inRange(viewHolderPosition) && inRange(viewHolderPosition2)) {
            if (viewHolderPosition < viewHolderPosition2) {
                int i10 = viewHolderPosition;
                while (i10 < viewHolderPosition2) {
                    int i11 = i10 + 1;
                    Collections.swap(this.mData, i10, i11);
                    i10 = i11;
                }
            } else {
                for (int i12 = viewHolderPosition; i12 > viewHolderPosition2; i12--) {
                    Collections.swap(this.mData, i12, i12 - 1);
                }
            }
            notifyItemMoved(b0Var.getAdapterPosition(), b0Var2.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null && this.itemDragEnabled) {
            onItemDragListener.onItemDragMoving(b0Var, viewHolderPosition, b0Var2, viewHolderPosition2);
        }
    }

    public void onItemDragStart(RecyclerView.b0 b0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null && this.itemDragEnabled) {
            onItemDragListener.onItemDragStart(b0Var, getViewHolderPosition(b0Var));
        }
    }

    public void onItemSwipeClear(RecyclerView.b0 b0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener != null && this.itemSwipeEnabled) {
            onItemSwipeListener.clearView(b0Var, getViewHolderPosition(b0Var));
        }
    }

    public void onItemSwipeStart(RecyclerView.b0 b0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener != null && this.itemSwipeEnabled) {
            onItemSwipeListener.onItemSwipeStart(b0Var, getViewHolderPosition(b0Var));
        }
    }

    public void onItemSwiped(RecyclerView.b0 b0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener != null && this.itemSwipeEnabled) {
            onItemSwipeListener.onItemSwiped(b0Var, getViewHolderPosition(b0Var));
        }
        int viewHolderPosition = getViewHolderPosition(b0Var);
        if (inRange(viewHolderPosition)) {
            this.mData.remove(viewHolderPosition);
            notifyItemRemoved(b0Var.getAdapterPosition());
        }
    }

    public void onItemSwiping(Canvas canvas, RecyclerView.b0 b0Var, float f10, float f11, boolean z10) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener != null && this.itemSwipeEnabled) {
            onItemSwipeListener.onItemSwipeMoving(canvas, b0Var, f10, f11, z10);
        }
    }

    public void setOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    public void setToggleDragOnLongPress(boolean z10) {
        this.mDragOnLongPress = z10;
        if (z10) {
            this.mOnToggleViewTouchListener = null;
            this.mOnToggleViewLongClickListener = new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
                    g gVar = baseItemDraggableAdapter.mItemTouchHelper;
                    if (gVar == null || !baseItemDraggableAdapter.itemDragEnabled) {
                        return true;
                    }
                    gVar.E((RecyclerView.b0) view.getTag(a.f33433c));
                    return true;
                }
            };
            return;
        }
        this.mOnToggleViewTouchListener = new View.OnTouchListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (o.c(motionEvent) != 0) {
                    return false;
                }
                BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
                if (baseItemDraggableAdapter.mDragOnLongPress) {
                    return false;
                }
                g gVar = baseItemDraggableAdapter.mItemTouchHelper;
                if (gVar == null || !baseItemDraggableAdapter.itemDragEnabled) {
                    return true;
                }
                gVar.E((RecyclerView.b0) view.getTag(a.f33433c));
                return true;
            }
        };
        this.mOnToggleViewLongClickListener = null;
    }

    public void setToggleViewId(int i10) {
        this.mToggleViewId = i10;
    }

    public void enableDragItem(g gVar, int i10, boolean z10) {
        this.itemDragEnabled = true;
        this.mItemTouchHelper = gVar;
        setToggleViewId(i10);
        setToggleDragOnLongPress(z10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onBindViewHolder(K k10, int i10) {
        super.onBindViewHolder((BaseItemDraggableAdapter<T, K>) k10, i10);
        int itemViewType = k10.getItemViewType();
        if (this.mItemTouchHelper != null && this.itemDragEnabled && itemViewType != 546 && itemViewType != 273 && itemViewType != 1365 && itemViewType != 819) {
            int i11 = this.mToggleViewId;
            if (i11 != 0) {
                View view = k10.getView(i11);
                if (view != null) {
                    view.setTag(a.f33433c, k10);
                    if (this.mDragOnLongPress) {
                        view.setOnLongClickListener(this.mOnToggleViewLongClickListener);
                    } else {
                        view.setOnTouchListener(this.mOnToggleViewTouchListener);
                    }
                }
            } else {
                k10.itemView.setTag(a.f33433c, k10);
                k10.itemView.setOnLongClickListener(this.mOnToggleViewLongClickListener);
            }
        }
    }

    public BaseItemDraggableAdapter(int i10, List<T> list) {
        super(i10, list);
    }
}
