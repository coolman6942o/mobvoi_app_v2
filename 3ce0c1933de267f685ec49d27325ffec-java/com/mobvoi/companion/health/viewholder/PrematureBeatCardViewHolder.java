package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobvoi.android.common.ui.widget.c;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.heartrate.ui.detail.HeartRateDetailActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.i;
import rh.a;
import xc.b;
import xc.h;
/* compiled from: PrematureBeatCardViewHolder.kt */
/* loaded from: classes2.dex */
public final class PrematureBeatCardViewHolder extends i {
    private final ImageView ivNotice = (ImageView) this.itemView.findViewById(R.id.iv_notice);
    private final TextView tvValue = (TextView) this.itemView.findViewById(R.id.tv_value);
    private final ImageView ivLogo = (ImageView) this.itemView.findViewById(R.id.logo);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PrematureBeatCardViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_heart_health);
        i.f(parentView, "parentView");
    }

    private final String getTimeString(long j10) {
        String format = new SimpleDateFormat(getContext().getString(R.string.time_format_month_day_time), Locale.getDefault()).format(new Date(j10));
        i.e(format, "simpleDateFormat.format(Date(mills))");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBindData$lambda-1  reason: not valid java name */
    public static final void m13onBindData$lambda1(PrematureBeatCardViewHolder this$0, View view) {
        i.f(this$0, "this$0");
        new c.b(this$0.getContext()).f(R.string.laboratory_function).c(R.string.laboratory_function_desc).b(R.string.got_it).g();
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        i.f(data, "data");
        this.ivLogo.setImageResource(R.drawable.detail_heart_premature_beat_icon);
        if ((data instanceof h) && data.c()) {
            TextView textView = this.tvValue;
            Context context = getContext();
            int i10 = R.string.heart_premature_beat_day_warn;
            Object[] objArr = new Object[1];
            a a10 = ((h) data).a();
            objArr[0] = a10 == null ? null : getTimeString(a10.f33515b);
            textView.setText(context.getString(i10, objArr));
        }
        this.ivNotice.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.health.viewholder.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PrematureBeatCardViewHolder.m13onBindData$lambda1(PrematureBeatCardViewHolder.this, view);
            }
        });
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        a a10;
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
        sb.a.d(getContext(), "prematureBeatCard");
        jh.h.q0(getContext(), HeartRateDetailActivity.class);
        if ((data instanceof h) && data.c() && (a10 = ((h) data).a()) != null) {
            long j10 = a10.f33515b;
            SharedPreferences sharedPreferences = getContext().getSharedPreferences("vpa_health_cards", 0);
            if (sharedPreferences.getLong("vpa_heart_health_premature_beat", -1L) != j10) {
                sharedPreferences.edit().putLong("vpa_heart_health_premature_beat", j10).apply();
            }
        }
        controlInterface.removeItem(i10);
    }
}
