package com.chad.library.adapter.base.listener;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
/* loaded from: classes.dex */
public abstract class OnItemChildClickListener extends SimpleClickListener {
    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        onSimpleItemChildClick(baseQuickAdapter, view, i10);
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
    }

    @Override // com.chad.library.adapter.base.listener.SimpleClickListener
    public void onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
    }

    public abstract void onSimpleItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10);
}
