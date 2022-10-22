package com.mobvoi.companion.health.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.HomePressureChart;
import com.mobvoi.health.companion.pressure.PressureDetailActivity;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.math.BigDecimal;
import java.util.List;
import jh.h;
import kotlin.jvm.internal.i;
import qf.a;
import xc.b;
import xc.d;
/* compiled from: PressureCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class PressureCardViewHolder extends i {
    private final String emptyValueStr;
    private final TextView tvAverageTitle = (TextView) this.itemView.findViewById(R.id.tv_average_title);
    private final TextView tvAverageValue = (TextView) this.itemView.findViewById(R.id.tv_latest_value);
    private final TextView tvState = (TextView) this.itemView.findViewById(R.id.tv_state);
    private final HomePressureChart pressureChart = (HomePressureChart) this.itemView.findViewById(R.id.pressure_chart);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PressureCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_pressure);
        i.f(parentView, "parentView");
        String string = getContext().getString(R.string.home_tab_card_value_empty);
        i.e(string, "context.getString(R.string.home_tab_card_value_empty)");
        this.emptyValueStr = string;
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        int i10;
        int i11;
        i.f(data, "data");
        if (data instanceof d) {
            d dVar = (d) data;
            List<? extends a> a10 = dVar.a();
            int i12 = 1;
            boolean z10 = false;
            if (a10 != null && (a10.isEmpty() ^ true)) {
                this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_average));
                float f10 = 0.0f;
                for (a aVar : dVar.a()) {
                    f10 += aVar.e();
                }
                int intValue = new BigDecimal(f10 / dVar.a().size()).setScale(0, 4).intValue();
                this.tvAverageValue.setText(String.valueOf(intValue));
                this.tvState.setVisibility(0);
                if (intValue >= 75) {
                    i10 = R.string.home_tab_pressure_state_high;
                } else if (50 <= intValue && intValue <= 74) {
                    i10 = R.string.home_tab_pressure_state_middle;
                } else if (25 <= intValue && intValue <= 49) {
                    i10 = R.string.home_tab_pressure_state_low;
                } else {
                    i10 = R.string.home_tab_pressure_state_relax;
                }
                this.tvState.setText(getContext().getString(i10));
                if (intValue >= 75) {
                    i11 = R.color.home_tab_pressure_high_color;
                } else if (50 <= intValue && intValue <= 74) {
                    i11 = R.color.home_tab_pressure_normal_color;
                } else if (25 <= intValue && intValue <= 49) {
                    i11 = R.color.home_tab_pressure_middle_color;
                } else {
                    i11 = R.color.home_tab_pressure_low_color;
                }
                this.tvState.setTextColor(androidx.core.content.b.c(getContext(), i11));
                if (intValue >= 75) {
                    i12 = 4;
                } else if (50 <= intValue && intValue <= 74) {
                    i12 = 3;
                } else {
                    if (25 <= intValue && intValue <= 49) {
                        z10 = true;
                    }
                    if (z10) {
                        i12 = 2;
                    }
                }
                this.pressureChart.setPressureLevel(i12);
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_no_data));
        this.tvAverageValue.setText(this.emptyValueStr);
        this.tvState.setVisibility(8);
        this.pressureChart.setPressureLevel(0);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        sb.a.d(getContext(), HealthDataProviderContracts.NAME_LAST_PRESSURE);
        h.q0(getContext(), PressureDetailActivity.class);
    }
}
