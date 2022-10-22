package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.heartrate.ui.detail.HeartRateDetailActivity;
import kotlin.jvm.internal.i;
import sb.a;
import so.c;
import xc.b;
/* compiled from: McuHeartRateCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class McuHeartRateCardViewHolder extends i {
    private final String emptyValueStr;
    private final TextView tvAverageTitle = (TextView) this.itemView.findViewById(R.id.tv_average_title);
    private final TextView tvLatestValue = (TextView) this.itemView.findViewById(R.id.tv_latest_value);
    private final TextView tvMaxValue = (TextView) this.itemView.findViewById(R.id.tv_max_value);
    private final TextView tvMinValue = (TextView) this.itemView.findViewById(R.id.tv_min_value);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McuHeartRateCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_pulse_card);
        i.f(parentView, "parentView");
        String string = getContext().getString(R.string.home_tab_card_value_empty);
        i.e(string, "context.getString(R.string.home_tab_card_value_empty)");
        this.emptyValueStr = string;
    }

    private final String ifZeroReturnEmptyStr(Context context, int i10) {
        if (i10 != 0) {
            return String.valueOf(i10);
        }
        String string = context.getString(R.string.home_tab_card_value_empty);
        i.e(string, "{\n            context.getString(R.string.home_tab_card_value_empty)\n        }");
        return string;
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        int b10;
        int b11;
        i.f(data, "data");
        if (data instanceof xc.i) {
            xc.i iVar = (xc.i) data;
            if (iVar.a() != null) {
                this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_average));
                TextView textView = this.tvMaxValue;
                Context context = getContext();
                b10 = c.b(iVar.a().f18273c.f18280b);
                textView.setText(ifZeroReturnEmptyStr(context, b10));
                TextView textView2 = this.tvMinValue;
                Context context2 = getContext();
                b11 = c.b(iVar.a().f18273c.f18281c);
                textView2.setText(ifZeroReturnEmptyStr(context2, b11));
                this.tvLatestValue.setText(ifZeroReturnEmptyStr(getContext(), iVar.a().f18273c.f18284f));
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.tvAverageTitle.setText(getContext().getString(R.string.home_tab_no_data));
        this.tvLatestValue.setText(this.emptyValueStr);
        this.tvMaxValue.setText(this.emptyValueStr);
        this.tvMinValue.setText(this.emptyValueStr);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        a.d(getContext(), "mcuHr");
        HeartRateDetailActivity.M0(getContext(), true);
    }
}
