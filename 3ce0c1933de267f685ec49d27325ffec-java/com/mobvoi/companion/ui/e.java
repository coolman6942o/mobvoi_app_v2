package com.mobvoi.companion.ui;

import android.view.View;
import com.mobvoi.android.common.json.JsonBean;
/* compiled from: WearRecycleItemInfo.java */
/* loaded from: classes2.dex */
public class e implements JsonBean {
    public int iconResId;
    public boolean isBeta;
    public boolean isEndable = true;
    public boolean isNew;
    public boolean isWatchFace;
    public View.OnClickListener onClickListener;
    public int titleResId;

    public e() {
    }

    public e(int i10, int i11, View.OnClickListener onClickListener) {
        this.titleResId = i10;
        this.iconResId = i11;
        this.onClickListener = onClickListener;
    }

    public e(int i10, int i11, boolean z10, View.OnClickListener onClickListener) {
        this.titleResId = i10;
        this.iconResId = i11;
        this.isNew = z10;
        this.onClickListener = onClickListener;
    }
}
