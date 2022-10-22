package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.sleep.SleepDetailActivity;
import com.mobvoi.health.companion.sleep.view.SleepTypeView;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.i;
import sb.a;
import xc.b;
import xc.m;
import zj.d;
/* compiled from: SleepCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class SleepCardViewHolder extends i {
    private final String emptyValueStr;
    private final TextView tvHourValue = (TextView) this.itemView.findViewById(R.id.tv_hour_value);
    private final TextView tvMinuteValue = (TextView) this.itemView.findViewById(R.id.tv_minute_value);
    private final TextView tvSleepQuality = (TextView) this.itemView.findViewById(R.id.tv_sleep_percent);
    private final SleepTypeView sleepChartView = (SleepTypeView) this.itemView.findViewById(R.id.sleep_chart);
    private final TextView tvStartTime = (TextView) this.itemView.findViewById(R.id.tv_sleep_start_time);
    private final TextView tvEndTime = (TextView) this.itemView.findViewById(R.id.tv_sleep_end_time);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SleepCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_sleep_card);
        i.f(parentView, "parentView");
        String string = getContext().getString(R.string.home_tab_card_value_empty);
        i.e(string, "context.getString(R.string.home_tab_card_value_empty)");
        this.emptyValueStr = string;
    }

    private final String formatDate(long j10) {
        String format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j10));
        i.e(format, "SimpleDateFormat(\"HH:mm\", Locale.getDefault()).format(Date(time))");
        return format;
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        i.f(data, "data");
        if (data instanceof m) {
            m mVar = (m) data;
            Collection<? extends SleepRecord> a10 = mVar.a();
            if (a10 != null && (a10.isEmpty() ^ true)) {
                long j10 = 0;
                Integer num = null;
                SleepRecord sleepRecord = null;
                for (SleepRecord sleepRecord2 : mVar.a()) {
                    SleepRecord.TimeType timeType = SleepRecord.TimeType.InBed;
                    long g10 = sleepRecord2.g(timeType);
                    if (g10 > j10) {
                        j10 = g10;
                    }
                    if (sleepRecord == null || sleepRecord2.g(timeType) > sleepRecord.g(timeType)) {
                        sleepRecord = sleepRecord2;
                    }
                }
                if (sleepRecord != null) {
                    num = Integer.valueOf(sleepRecord.f20743g);
                }
                int d10 = d.d(j10);
                this.tvHourValue.setText(String.valueOf(d10 / 60));
                this.tvMinuteValue.setText(String.valueOf(d10 % 60));
                this.tvSleepQuality.setText(getContext().getString(R.string.home_tab_sleep_quality, num));
                this.sleepChartView.setSleepRecord(sleepRecord);
                if (sleepRecord == null) {
                    TextView textView = this.tvStartTime;
                    Context context = getContext();
                    int i10 = R.string.home_tab_sleep_time_no_data;
                    textView.setText(context.getString(i10));
                    this.tvEndTime.setText(getContext().getString(i10));
                    return;
                }
                this.tvStartTime.setText(formatDate(sleepRecord.f20740d));
                this.tvEndTime.setText(formatDate(sleepRecord.f20741e));
            }
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.tvHourValue.setText(this.emptyValueStr);
        this.tvMinuteValue.setText(this.emptyValueStr);
        this.tvSleepQuality.setText(getContext().getString(R.string.home_tab_today_no_data));
        TextView textView = this.tvStartTime;
        Context context = getContext();
        int i10 = R.string.home_tab_sleep_time_no_data;
        textView.setText(context.getString(i10));
        this.tvEndTime.setText(getContext().getString(i10));
        this.sleepChartView.setSleepRecord(null);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        a.d(getContext(), "sleep");
        if (data instanceof m) {
            SleepDetailActivity.p1(getContext(), ((m) data).d());
        }
    }
}
