package com.mobvoi.companion.health.viewholder;

import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.HealthCircleView;
import com.mobvoi.health.companion.HealthActivity;
import com.mobvoi.health.core.data.pojo.DataType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.i;
import ph.a;
import xc.b;
import xc.f;
/* compiled from: HealthCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class HealthCardViewHolder extends i {
    private final TextView tvExerciseTitle = (TextView) this.itemView.findViewById(R.id.tv_exercise_title);
    private final TextView tvMoveTitle = (TextView) this.itemView.findViewById(R.id.tv_move_title);
    private final TextView tvStepsTitle = (TextView) this.itemView.findViewById(R.id.tv_steps_title);
    private final TextView tvExerciseValue = (TextView) this.itemView.findViewById(R.id.tv_exercise_value);
    private final TextView tvMoveValue = (TextView) this.itemView.findViewById(R.id.tv_move_value);
    private final TextView tvStepsValue = (TextView) this.itemView.findViewById(R.id.tv_steps_value);
    private final TextView tvExerciseEndFix = (TextView) this.itemView.findViewById(R.id.tv_exercise_endfix);
    private final TextView tvMoveEndFix = (TextView) this.itemView.findViewById(R.id.tv_move_endfix);
    private final TextView tvStepsEndFix = (TextView) this.itemView.findViewById(R.id.tv_steps_endfix);
    private final TextView tvNoData = (TextView) this.itemView.findViewById(R.id.tv_no_data);
    private final TextView tvTime = (TextView) this.itemView.findViewById(R.id.tv_time);
    private final HealthCircleView healthCircleView = (HealthCircleView) this.itemView.findViewById(R.id.health_circle_view);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_health_card);
        i.f(parentView, "parentView");
    }

    private final String stringToDate3(long j10) {
        return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j10));
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        String str;
        i.f(data, "data");
        if (data instanceof f) {
            f fVar = (f) data;
            if (fVar.a() != null) {
                this.tvNoData.setVisibility(8);
                this.tvTime.setVisibility(0);
                this.tvExerciseTitle.setVisibility(0);
                this.tvMoveTitle.setVisibility(0);
                this.tvStepsTitle.setVisibility(0);
                this.tvExerciseValue.setVisibility(0);
                this.tvMoveValue.setVisibility(0);
                this.tvStepsValue.setVisibility(0);
                this.tvExerciseEndFix.setVisibility(0);
                this.tvMoveEndFix.setVisibility(0);
                this.tvStepsEndFix.setVisibility(0);
                DataType dataType = DataType.Exercise;
                int b10 = a.b(fVar.a().d(dataType));
                this.tvExerciseValue.setText(String.valueOf(b10));
                TextView textView = this.tvExerciseEndFix;
                if (b10 > 1) {
                    str = com.mobvoi.android.common.utils.b.e().getString(R.string.home_tab_activity_exercise_units);
                } else {
                    str = com.mobvoi.android.common.utils.b.e().getString(R.string.home_tab_activity_exercise_unit);
                }
                textView.setText(str);
                TextView textView2 = this.tvMoveValue;
                DataType dataType2 = DataType.Active;
                textView2.setText(String.valueOf(fVar.a().d(dataType2)));
                TextView textView3 = this.tvStepsValue;
                DataType dataType3 = DataType.Step;
                textView3.setText(String.valueOf(fVar.a().d(dataType3)));
                this.tvTime.setText(stringToDate3(fVar.d()));
                this.healthCircleView.b((fVar.a().d(dataType2) * 100) / fVar.a().a(), (fVar.a().d(dataType) * 100) / (fVar.a().b() * 60), (fVar.a().d(dataType3) * 100) / fVar.a().c());
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.tvNoData.setVisibility(0);
        this.tvExerciseTitle.setVisibility(8);
        this.tvMoveTitle.setVisibility(8);
        this.tvStepsTitle.setVisibility(8);
        this.tvExerciseValue.setVisibility(8);
        this.tvMoveValue.setVisibility(8);
        this.tvStepsValue.setVisibility(8);
        this.tvExerciseEndFix.setVisibility(8);
        this.tvMoveEndFix.setVisibility(8);
        this.tvStepsEndFix.setVisibility(8);
        this.tvTime.setVisibility(8);
        this.healthCircleView.b(0, 0, 0);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        sb.a.d(getContext(), "health");
        HealthActivity.start(getContext());
    }
}
