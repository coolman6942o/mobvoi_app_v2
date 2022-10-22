package com.chad.library.adapter.base;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseSectionQuickAdapter<T extends SectionEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    protected static final int SECTION_HEADER_VIEW = 1092;
    protected int mSectionHeadResId;

    public BaseSectionQuickAdapter(int i10, int i11, List<T> list) {
        super(i10, list);
        this.mSectionHeadResId = i11;
    }

    protected abstract void convertHead(K k10, T t10);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    protected int getDefItemViewType(int i10) {
        if (((SectionEntity) this.mData.get(i10)).isHeader) {
            return SECTION_HEADER_VIEW;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int i10) {
        return super.isFixedViewType(i10) || i10 == SECTION_HEADER_VIEW;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.b0 b0Var, int i10) {
        onBindViewHolder((BaseSectionQuickAdapter<T, K>) ((BaseViewHolder) b0Var), i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        if (i10 == SECTION_HEADER_VIEW) {
            return createBaseViewHolder(getItemView(this.mSectionHeadResId, viewGroup));
        }
        return (K) super.onCreateDefViewHolder(viewGroup, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void onBindViewHolder(K k10, int i10) {
        if (k10.getItemViewType() != SECTION_HEADER_VIEW) {
            super.onBindViewHolder((BaseSectionQuickAdapter<T, K>) k10, i10);
            return;
        }
        setFullSpan(k10);
        convertHead(k10, (SectionEntity) getItem(i10 - getHeaderLayoutCount()));
    }
}
