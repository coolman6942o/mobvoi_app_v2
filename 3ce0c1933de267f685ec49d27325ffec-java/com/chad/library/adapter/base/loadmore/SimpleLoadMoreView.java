package com.chad.library.adapter.base.loadmore;

import r5.a;
import r5.b;
/* loaded from: classes.dex */
public final class SimpleLoadMoreView extends LoadMoreView {
    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    public int getLayoutId() {
        return b.f33437a;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    protected int getLoadEndViewId() {
        return a.f33434d;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    protected int getLoadFailViewId() {
        return a.f33435e;
    }

    @Override // com.chad.library.adapter.base.loadmore.LoadMoreView
    protected int getLoadingViewId() {
        return a.f33436f;
    }
}
