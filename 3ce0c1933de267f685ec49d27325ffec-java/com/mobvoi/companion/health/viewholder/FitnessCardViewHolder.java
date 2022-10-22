package com.mobvoi.companion.health.viewholder;

import android.content.Intent;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.sport.SportDetailActivity;
import jh.h;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import so.c;
import xc.b;
import xc.n;
/* compiled from: FitnessCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class FitnessCardViewHolder extends i {
    public static final String ACTION_SYNC_MCU_WATCH_SPORT = "com.mobvoi.mcu.ACTION_SYNC_MCU_WATCH_SPORT";
    public static final a Companion = new a(null);
    private final TextView tvNoData = (TextView) this.itemView.findViewById(R.id.tv_no_data);
    private final TextView tvTotalTimeTitle = (TextView) this.itemView.findViewById(R.id.tv_total_time_title);
    private final TextView tvCalorieCostTitle = (TextView) this.itemView.findViewById(R.id.tv_calorie_cost_title);
    private final TextView tvHourValue = (TextView) this.itemView.findViewById(R.id.tv_hour_value);
    private final TextView tvHourEndFix = (TextView) this.itemView.findViewById(R.id.tv_hour_endfix);
    private final TextView tvMinuteValue = (TextView) this.itemView.findViewById(R.id.tv_minute_value);
    private final TextView tvMinuteEndFix = (TextView) this.itemView.findViewById(R.id.tv_minute_endfix);
    private final TextView tvCalorieEndFix = (TextView) this.itemView.findViewById(R.id.tv_calorie_endfix);
    private final TextView tvCalorieValue = (TextView) this.itemView.findViewById(R.id.tv_calorie_value);

    /* compiled from: FitnessCardViewHolder.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FitnessCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_fitness_card);
        i.f(parentView, "parentView");
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        int b10;
        i.f(data, "data");
        if (data instanceof n) {
            n nVar = (n) data;
            if (nVar.a() != null) {
                this.tvNoData.setVisibility(8);
                this.tvTotalTimeTitle.setVisibility(0);
                this.tvCalorieCostTitle.setVisibility(0);
                this.tvHourValue.setVisibility(0);
                this.tvHourEndFix.setVisibility(0);
                this.tvMinuteValue.setVisibility(0);
                this.tvMinuteEndFix.setVisibility(0);
                this.tvCalorieEndFix.setVisibility(0);
                this.tvCalorieValue.setVisibility(0);
                int e10 = nVar.e();
                int f10 = nVar.f();
                this.tvHourValue.setText(String.valueOf(e10));
                this.tvMinuteValue.setText(String.valueOf(f10));
                if (nVar.d() <= 0.0f) {
                    this.tvCalorieValue.setText(getContext().getString(R.string.home_tab_card_value_empty));
                    return;
                }
                TextView textView = this.tvCalorieValue;
                b10 = c.b(nVar.d());
                textView.setText(String.valueOf(b10));
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.tvNoData.setVisibility(0);
        this.tvTotalTimeTitle.setVisibility(8);
        this.tvCalorieCostTitle.setVisibility(8);
        this.tvHourValue.setVisibility(8);
        this.tvHourEndFix.setVisibility(8);
        this.tvMinuteValue.setVisibility(8);
        this.tvMinuteEndFix.setVisibility(8);
        this.tvCalorieEndFix.setVisibility(8);
        this.tvCalorieValue.setVisibility(8);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, com.mobvoi.companion.health.viewholder.a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        sb.a.d(getContext(), "fitness");
        h.q0(getContext(), SportDetailActivity.class);
        getContext().getApplicationContext().sendBroadcast(new Intent(ACTION_SYNC_MCU_WATCH_SPORT));
    }
}
