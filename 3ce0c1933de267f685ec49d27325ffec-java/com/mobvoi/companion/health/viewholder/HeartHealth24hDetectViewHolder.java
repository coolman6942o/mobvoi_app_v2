package com.mobvoi.companion.health.viewholder;

import android.view.ViewGroup;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.heartrate.ui.detail.HeartRateDetailActivity;
import jh.h;
import kotlin.jvm.internal.i;
import sb.a;
import xc.b;
/* compiled from: HeartHealth24hDetectViewHolder.kt */
/* loaded from: classes2.dex */
public final class HeartHealth24hDetectViewHolder extends i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HeartHealth24hDetectViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_heart_24h_detect);
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
        a.d(getContext(), "pluse");
        h.q0(getContext(), HeartRateDetailActivity.class);
    }
}
