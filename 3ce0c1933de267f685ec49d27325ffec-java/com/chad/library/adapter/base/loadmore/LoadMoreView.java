package com.chad.library.adapter.base.loadmore;

import com.chad.library.adapter.base.BaseViewHolder;
/* loaded from: classes.dex */
public abstract class LoadMoreView {
    public static final int STATUS_DEFAULT = 1;
    public static final int STATUS_END = 4;
    public static final int STATUS_FAIL = 3;
    public static final int STATUS_LOADING = 2;
    private int mLoadMoreStatus = 1;
    private boolean mLoadMoreEndGone = false;

    private void visibleLoadEnd(BaseViewHolder baseViewHolder, boolean z10) {
        int loadEndViewId = getLoadEndViewId();
        if (loadEndViewId != 0) {
            baseViewHolder.setVisible(loadEndViewId, z10);
        }
    }

    private void visibleLoadFail(BaseViewHolder baseViewHolder, boolean z10) {
        baseViewHolder.setVisible(getLoadFailViewId(), z10);
    }

    private void visibleLoading(BaseViewHolder baseViewHolder, boolean z10) {
        baseViewHolder.setVisible(getLoadingViewId(), z10);
    }

    public void convert(BaseViewHolder baseViewHolder) {
        int i10 = this.mLoadMoreStatus;
        if (i10 == 1) {
            visibleLoading(baseViewHolder, false);
            visibleLoadFail(baseViewHolder, false);
            visibleLoadEnd(baseViewHolder, false);
        } else if (i10 == 2) {
            visibleLoading(baseViewHolder, true);
            visibleLoadFail(baseViewHolder, false);
            visibleLoadEnd(baseViewHolder, false);
        } else if (i10 == 3) {
            visibleLoading(baseViewHolder, false);
            visibleLoadFail(baseViewHolder, true);
            visibleLoadEnd(baseViewHolder, false);
        } else if (i10 == 4) {
            visibleLoading(baseViewHolder, false);
            visibleLoadFail(baseViewHolder, false);
            visibleLoadEnd(baseViewHolder, true);
        }
    }

    public abstract int getLayoutId();

    protected abstract int getLoadEndViewId();

    protected abstract int getLoadFailViewId();

    public int getLoadMoreStatus() {
        return this.mLoadMoreStatus;
    }

    protected abstract int getLoadingViewId();

    @Deprecated
    public boolean isLoadEndGone() {
        return this.mLoadMoreEndGone;
    }

    public final boolean isLoadEndMoreGone() {
        if (getLoadEndViewId() == 0) {
            return true;
        }
        return this.mLoadMoreEndGone;
    }

    public final void setLoadMoreEndGone(boolean z10) {
        this.mLoadMoreEndGone = z10;
    }

    public void setLoadMoreStatus(int i10) {
        this.mLoadMoreStatus = i10;
    }
}
