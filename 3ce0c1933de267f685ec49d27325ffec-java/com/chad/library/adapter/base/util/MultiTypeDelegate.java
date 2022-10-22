package com.chad.library.adapter.base.util;

import android.util.SparseIntArray;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import java.util.List;
/* loaded from: classes.dex */
public abstract class MultiTypeDelegate<T> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    private boolean autoMode;
    private SparseIntArray layouts;
    private boolean selfMode;

    public MultiTypeDelegate(SparseIntArray sparseIntArray) {
        this.layouts = sparseIntArray;
    }

    private void addItemType(int i10, int i11) {
        if (this.layouts == null) {
            this.layouts = new SparseIntArray();
        }
        this.layouts.put(i10, i11);
    }

    private void checkMode(boolean z10) {
        if (z10) {
            throw new RuntimeException("Don't mess two register mode");
        }
    }

    public final int getDefItemViewType(List<T> list, int i10) {
        T t10 = list.get(i10);
        return t10 != null ? getItemType(t10) : DEFAULT_VIEW_TYPE;
    }

    protected abstract int getItemType(T t10);

    public final int getLayoutId(int i10) {
        return this.layouts.get(i10, BaseMultiItemQuickAdapter.TYPE_NOT_FOUND);
    }

    public MultiTypeDelegate registerItemType(int i10, int i11) {
        this.selfMode = true;
        checkMode(this.autoMode);
        addItemType(i10, i11);
        return this;
    }

    public MultiTypeDelegate registerItemTypeAutoIncrease(int... iArr) {
        this.autoMode = true;
        checkMode(this.selfMode);
        for (int i10 = 0; i10 < iArr.length; i10++) {
            addItemType(i10, iArr[i10]);
        }
        return this;
    }

    public MultiTypeDelegate() {
    }
}
