package com.mobvoi.companion.health.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.companion.health.HealthCircleView;
import com.mobvoi.health.companion.HealthActivity;
import com.mobvoi.health.core.data.pojo.DataType;
import com.mobvoi.wear.util.UnitsUtility;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import xc.b;
import xc.k;
/* compiled from: McuActivityCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class McuActivityCardViewHolder extends i {
    private final TextView tvCalorieTitle = (TextView) this.itemView.findViewById(R.id.tv_calorie_title);
    private final TextView tvStepsTitle = (TextView) this.itemView.findViewById(R.id.tv_steps_title);
    private final TextView tvDistanceTitle = (TextView) this.itemView.findViewById(R.id.tv_distance_title);
    private final TextView tvCalorieValue = (TextView) this.itemView.findViewById(R.id.tv_calorie_value);
    private final TextView tvStepsValue = (TextView) this.itemView.findViewById(R.id.tv_steps_value);
    private final TextView tvDistanceValue = (TextView) this.itemView.findViewById(R.id.tv_distance_value);
    private final TextView tvCalorieUnit = (TextView) this.itemView.findViewById(R.id.tv_calorie_unit);
    private final TextView tvStepsUnit = (TextView) this.itemView.findViewById(R.id.tv_steps_unit);
    private final TextView tvDistanceUnit = (TextView) this.itemView.findViewById(R.id.tv_distance_unit);
    private final TextView tvNoData = (TextView) this.itemView.findViewById(R.id.tv_no_data);
    private final TextView tvTime = (TextView) this.itemView.findViewById(R.id.tv_time);
    private final HealthCircleView healthCircleView = (HealthCircleView) this.itemView.findViewById(R.id.health_circle_view);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public McuActivityCardViewHolder(ViewGroup viewParent) {
        super(viewParent, R.layout.layout_home_tab_mcu_activity_card);
        i.f(viewParent, "viewParent");
    }

    private final String stringToDate3(long j10) {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j10));
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        int i10;
        float f10;
        i.f(data, "data");
        if (data instanceof k) {
            k kVar = (k) data;
            if (kVar.a() != null) {
                boolean b10 = i.b("imperial", a.getUnit(getContext()));
                this.tvNoData.setVisibility(8);
                this.tvTime.setVisibility(0);
                this.tvCalorieTitle.setVisibility(0);
                this.tvDistanceTitle.setVisibility(0);
                this.tvStepsTitle.setVisibility(0);
                this.tvCalorieValue.setVisibility(0);
                this.tvDistanceValue.setVisibility(0);
                this.tvStepsValue.setVisibility(0);
                this.tvCalorieUnit.setVisibility(0);
                this.tvDistanceUnit.setVisibility(0);
                this.tvStepsUnit.setVisibility(0);
                this.tvCalorieUnit.setText(getContext().getString(R.string.health_sport_data_unit_calorie));
                this.tvStepsUnit.setText(getContext().getString(R.string.health_detail_item_step_unit));
                if (b10) {
                    i10 = R.string.health_detail_distance_miles_tip;
                } else {
                    i10 = R.string.health_detail_distance_tip;
                }
                this.tvDistanceUnit.setText(getContext().getString(i10));
                this.tvCalorieValue.setText(String.valueOf(kVar.a().b(DataType.Calorie)));
                TextView textView = this.tvStepsValue;
                DataType dataType = DataType.Step;
                textView.setText(String.valueOf(kVar.a().b(dataType)));
                float b11 = kVar.a().b(DataType.Distance);
                if (b10) {
                    f10 = UnitsUtility.Length.m2mile(b11);
                } else {
                    f10 = UnitsUtility.Length.m2km(b11);
                }
                TextView textView2 = this.tvDistanceValue;
                n nVar = n.f30086a;
                String string = getContext().getString(R.string.distance_formatter_value);
                i.e(string, "context.getString(R.string.distance_formatter_value)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Float.valueOf(f10)}, 1));
                i.e(format, "java.lang.String.format(format, *args)");
                textView2.setText(format);
                this.tvTime.setText(stringToDate3(kVar.d()));
                int b12 = (kVar.a().b(dataType) * 100) / kVar.a().a();
                this.healthCircleView.b(b12, b12, b12);
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.tvNoData.setVisibility(0);
        this.tvCalorieTitle.setVisibility(8);
        this.tvDistanceTitle.setVisibility(8);
        this.tvStepsTitle.setVisibility(8);
        this.tvCalorieValue.setVisibility(8);
        this.tvDistanceValue.setVisibility(8);
        this.tvStepsValue.setVisibility(8);
        this.tvCalorieUnit.setVisibility(8);
        this.tvDistanceUnit.setVisibility(8);
        this.tvStepsUnit.setVisibility(8);
        this.tvTime.setVisibility(8);
        this.healthCircleView.b(0, 0, 0);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        sb.a.d(getContext(), "mcuActivity");
        HealthActivity.start(getContext());
    }
}
