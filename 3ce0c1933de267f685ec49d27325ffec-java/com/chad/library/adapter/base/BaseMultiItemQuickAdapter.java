package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseMultiItemQuickAdapter<T extends MultiItemEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;

    public BaseMultiItemQuickAdapter(List<T> list) {
        super(list);
    }

    private int getLayoutId(int i10) {
        return this.layouts.get(i10, TYPE_NOT_FOUND);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addItemType(int i10, int i11) {
        if (this.layouts == null) {
            this.layouts = new SparseIntArray();
        }
        this.layouts.put(i10, i11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int getDefItemViewType(int i10) {
        Object obj = this.mData.get(i10);
        return obj instanceof MultiItemEntity ? ((MultiItemEntity) obj).getItemType() : DEFAULT_VIEW_TYPE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        return createBaseViewHolder(viewGroup, getLayoutId(i10));
    }

    protected void setDefaultViewTypeLayout(int i10) {
        addItemType(DEFAULT_VIEW_TYPE, i10);
    }
}
