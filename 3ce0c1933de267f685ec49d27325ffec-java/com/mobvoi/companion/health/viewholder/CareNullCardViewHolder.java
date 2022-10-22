package com.mobvoi.companion.health.viewholder;

import android.view.ViewGroup;
import com.mobvoi.companion.R;
import kotlin.jvm.internal.i;
import xc.b;
/* compiled from: CareNullCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class CareNullCardViewHolder extends i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CareNullCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_null_card);
        i.f(parentView, "parentView");
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        i.f(data, "data");
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
    }
}
