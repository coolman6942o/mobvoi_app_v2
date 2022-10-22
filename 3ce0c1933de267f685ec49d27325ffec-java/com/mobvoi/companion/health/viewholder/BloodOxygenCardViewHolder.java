package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.oxygen.BloodOxygenDetailActivity;
import java.util.List;
import jh.h;
import kotlin.jvm.internal.i;
import qf.a;
import so.c;
import xc.b;
import xc.d;
/* compiled from: BloodOxygenCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class BloodOxygenCardViewHolder extends i {
    private final String emptyValueStr;
    private final TextView tvAverageTitle = (TextView) this.itemView.findViewById(R.id.tv_average_title);
    private final TextView tvLatestValue = (TextView) this.itemView.findViewById(R.id.tv_latest_value);
    private final TextView tvState = (TextView) this.itemView.findViewById(R.id.tv_state);
    private final TextView tvMaxValue = (TextView) this.itemView.findViewById(R.id.tv_max_value);
    private final TextView tvMinValue = (TextView) this.itemView.findViewById(R.id.tv_min_value);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BloodOxygenCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_blood_oxygen_card);
        i.f(parentView, "parentView");
        String string = getContext().getString(R.string.home_tab_card_value_empty);
        i.e(string, "context.getString(R.string.home_tab_card_value_empty)");
        this.emptyValueStr = string;
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        int b10;
        int i10;
        int i11;
        i.f(data, "data");
        if (data instanceof d) {
            d dVar = (d) data;
            List<? extends a> a10 = dVar.a();
            if (a10 != null && (a10.isEmpty() ^ true)) {
                this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_average));
                float f10 = Float.POSITIVE_INFINITY;
                float f11 = 0.0f;
                float f12 = 0.0f;
                for (a aVar : dVar.a()) {
                    f12 = Math.max(f12, aVar.e());
                    f10 = Math.min(f10, aVar.e());
                    f11 += aVar.e();
                }
                float size = f11 / dVar.a().size();
                TextView textView = this.tvMaxValue;
                Context context = getContext();
                int i12 = R.string.home_tab_blood_oxygen_with_unit;
                textView.setText(context.getString(i12, Integer.valueOf((int) f12)));
                this.tvMinValue.setText(getContext().getString(i12, Integer.valueOf((int) f10)));
                TextView textView2 = this.tvLatestValue;
                Context context2 = getContext();
                b10 = c.b(size);
                textView2.setText(context2.getString(i12, Integer.valueOf(b10)));
                this.tvState.setVisibility(0);
                int i13 = (size > 95.0f ? 1 : (size == 95.0f ? 0 : -1));
                if (i13 >= 0) {
                    i10 = R.string.home_tab_blood_oxygen_state_normal;
                } else {
                    i10 = R.string.home_tab_blood_oxygen_state_low;
                }
                this.tvState.setText(getContext().getString(i10));
                if (i13 >= 0) {
                    i11 = R.color.home_tab_blood_oxygen_normal_color;
                } else {
                    i11 = R.color.home_tab_blood_oxygen_low_color;
                }
                this.tvState.setTextColor(androidx.core.content.b.c(getContext(), i11));
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_no_data));
        this.tvLatestValue.setText(this.emptyValueStr);
        this.tvMaxValue.setText(this.emptyValueStr);
        this.tvMinValue.setText(this.emptyValueStr);
        this.tvState.setVisibility(8);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        sb.a.d(getContext(), "bloodOxygen");
        h.q0(getContext(), BloodOxygenDetailActivity.class);
    }
}
