package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.temperature.TemperatureDetailActivity;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import java.util.List;
import jh.h;
import kotlin.jvm.internal.i;
import qf.a;
import xc.b;
import xc.d;
/* compiled from: TemperatureCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class TemperatureCardViewHolder extends i {
    private final String emptyValueStr;
    private final TextView tvAverageTitle = (TextView) this.itemView.findViewById(R.id.tv_average_title);
    private final TextView tvLatestValue = (TextView) this.itemView.findViewById(R.id.tv_latest_value);
    private final TextView tvState = (TextView) this.itemView.findViewById(R.id.tv_state);
    private final TextView tvMaxValue = (TextView) this.itemView.findViewById(R.id.tv_max_value);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TemperatureCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_temperature);
        i.f(parentView, "parentView");
        String string = getContext().getString(R.string.home_tab_card_value_empty);
        i.e(string, "context.getString(R.string.home_tab_card_value_empty)");
        this.emptyValueStr = string;
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        i.f(data, "data");
        if (data instanceof d) {
            d dVar = (d) data;
            List<? extends a> a10 = dVar.a();
            if (a10 != null && (a10.isEmpty() ^ true)) {
                this.tvState.setVisibility(0);
                this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_latest));
                float e10 = dVar.a().get(dVar.a().size() - 1).e();
                float f10 = 0.0f;
                for (a aVar : dVar.a()) {
                    f10 = Math.max(f10, aVar.e());
                }
                String str = i.b(com.mobvoi.companion.base.settings.a.getTempUnit(com.mobvoi.android.common.utils.b.e()), "celsius") ? "°C" : "°F";
                TextView textView = this.tvLatestValue;
                Context context = getContext();
                int i10 = R.string.home_tab_temperature_with_unit;
                textView.setText(context.getString(i10, Float.valueOf(ih.a.a(e10)), str));
                this.tvState.setText(getContext().getString(R.string.home_tab_temperature_state_normal));
                this.tvMaxValue.setText(getContext().getString(i10, Float.valueOf(ih.a.a(f10)), str));
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_no_data));
        this.tvLatestValue.setText(this.emptyValueStr);
        this.tvMaxValue.setText(this.emptyValueStr);
        this.tvState.setVisibility(8);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        sb.a.d(getContext(), SettingConstants.TEMPERATURE);
        h.q0(getContext(), TemperatureDetailActivity.class);
    }
}
