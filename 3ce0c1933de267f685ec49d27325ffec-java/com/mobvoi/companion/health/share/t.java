package com.mobvoi.companion.health.share;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.sport.view.HeartRateView;
import ef.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import lf.a;
import xf.h;
/* compiled from: HealthShareChartFragment.kt */
/* loaded from: classes2.dex */
public final class t extends RecyclerView.b0 {

    /* renamed from: a  reason: collision with root package name */
    private final HeartRateView f17026a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f17027b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17028c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17029d;

    /* renamed from: e  reason: collision with root package name */
    private final TicWatchLogoView f17030e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(View itemView) {
        super(itemView);
        i.f(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.heartRateDiagram);
        i.e(findViewById, "itemView.findViewById(R.id.heartRateDiagram)");
        this.f17026a = (HeartRateView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.heartRateImprove);
        i.e(findViewById2, "itemView.findViewById(R.id.heartRateImprove)");
        this.f17027b = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.heartRateLossweight);
        i.e(findViewById3, "itemView.findViewById(R.id.heartRateLossweight)");
        this.f17028c = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.heart_rate_average);
        i.e(findViewById4, "itemView.findViewById(R.id.heart_rate_average)");
        this.f17029d = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.heartRateLogo);
        i.e(findViewById5, "itemView.findViewById(R.id.heartRateLogo)");
        this.f17030e = (TicWatchLogoView) findViewById5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(Context context, p healthShareData, boolean z10) {
        String str;
        List list;
        String str2;
        String str3;
        i.f(context, "context");
        i.f(healthShareData, "healthShareData");
        this.f17030e.setVisibility(z10 ? 0 : 8);
        List<h> d10 = healthShareData.d();
        int a10 = healthShareData.a();
        f b10 = healthShareData.b();
        int f10 = healthShareData.f();
        int c10 = healthShareData.c();
        TextView textView = this.f17029d;
        if (c10 <= 0) {
            str = context.getString(R.string.health_sport_detail_heartrate_average_invalid);
        } else {
            str = context.getString(R.string.health_sport_detail_heartrate_average, Integer.valueOf(c10));
        }
        textView.setText(str);
        boolean e10 = bh.f.e(d10);
        List arrayList = new ArrayList();
        if (!e10) {
            arrayList.addAll(d10);
            List b11 = a.b(arrayList, a10, b10);
            i.e(b11, "analyseHeartRate(uiHeartRates, age, sportSummary)");
            list = b11;
        } else {
            list = arrayList;
        }
        this.f17026a.k(list, a10, b10.f25926j, b10.f25927k, b10.f25923g, b10.f25922f, f10);
        TextView textView2 = this.f17027b;
        if (e10) {
            str2 = context.getString(R.string.health_sport_detail_heartrate_improve_time_invalid);
        } else {
            str2 = context.getString(R.string.health_sport_detail_heartrate_improve_time, Integer.valueOf(b10.f25925i));
        }
        textView2.setText(str2);
        TextView textView3 = this.f17028c;
        if (e10) {
            str3 = context.getString(R.string.health_sport_detail_heartrate_lossWeight_time_invalid);
        } else {
            str3 = context.getString(R.string.health_sport_detail_heartrate_lossWeight_time, Integer.valueOf(b10.f25924h));
        }
        textView3.setText(str3);
    }
}
