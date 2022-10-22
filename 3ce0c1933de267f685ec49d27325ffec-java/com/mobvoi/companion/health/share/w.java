package com.mobvoi.companion.health.share;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.R;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.health.companion.sport.view.a;
import ef.u;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.jvm.internal.i;
import so.c;
/* compiled from: HealthShareChartFragment.kt */
/* loaded from: classes2.dex */
public final class w extends RecyclerView.b0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17040a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f17041b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17042c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17043d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17044e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17045f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f17046g;

    /* renamed from: h  reason: collision with root package name */
    private final TextView f17047h;

    /* renamed from: i  reason: collision with root package name */
    private final TextView f17048i;

    /* renamed from: j  reason: collision with root package name */
    private final TextView f17049j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context, View itemView) {
        super(itemView);
        i.f(context, "context");
        i.f(itemView, "itemView");
        this.f17040a = context;
        View findViewById = itemView.findViewById(R.id.ivSportType);
        i.e(findViewById, "itemView.findViewById(R.id.ivSportType)");
        this.f17041b = (ImageView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.tvSportType);
        i.e(findViewById2, "itemView.findViewById(R.id.tvSportType)");
        this.f17042c = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.tvTimeRange);
        i.e(findViewById3, "itemView.findViewById(R.id.tvTimeRange)");
        this.f17043d = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.tvCostTime);
        i.e(findViewById4, "itemView.findViewById(R.id.tvCostTime)");
        this.f17044e = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.tvCalorieValue);
        i.e(findViewById5, "itemView.findViewById(R.id.tvCalorieValue)");
        this.f17045f = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.tvPulse);
        i.e(findViewById6, "itemView.findViewById(R.id.tvPulse)");
        this.f17046g = (TextView) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.tvDistanceValue);
        i.e(findViewById7, "itemView.findViewById(R.id.tvDistanceValue)");
        this.f17047h = (TextView) findViewById7;
        View findViewById8 = itemView.findViewById(R.id.tvDistanceUnit);
        i.e(findViewById8, "itemView.findViewById(R.id.tvDistanceUnit)");
        this.f17048i = (TextView) findViewById8;
        View findViewById9 = itemView.findViewById(R.id.tvDistanceDesc);
        i.e(findViewById9, "itemView.findViewById(R.id.tvDistanceDesc)");
        this.f17049j = (TextView) findViewById9;
    }

    private final String c(long j10) {
        long j11 = 3600000;
        long j12 = j10 / j11;
        long j13 = 60000;
        long j14 = (j10 % j11) / j13;
        long j15 = (j10 % j13) / 1000;
        StringBuilder sb2 = new StringBuilder();
        int i10 = (j12 > 10L ? 1 : (j12 == 10L ? 0 : -1));
        Object valueOf = Long.valueOf(j12);
        if (i10 < 0) {
            valueOf = i.n("0", valueOf);
        }
        sb2.append(valueOf);
        sb2.append(':');
        int i11 = (j14 > 10L ? 1 : (j14 == 10L ? 0 : -1));
        Object valueOf2 = Long.valueOf(j14);
        if (i11 < 0) {
            valueOf2 = i.n("0", valueOf2);
        }
        sb2.append(valueOf2);
        sb2.append(':');
        int i12 = (j15 > 10L ? 1 : (j15 == 10L ? 0 : -1));
        Object valueOf3 = Long.valueOf(j15);
        if (i12 < 0) {
            valueOf3 = i.n("0", valueOf3);
        }
        sb2.append(valueOf3);
        return sb2.toString();
    }

    private final String d(long j10, long j11) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM.dd HH:mm", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        StringBuilder sb2 = new StringBuilder();
        sb2.append((Object) simpleDateFormat.format(Long.valueOf(j10)));
        sb2.append('-');
        sb2.append((Object) simpleDateFormat2.format(Long.valueOf(j11)));
        return sb2.toString();
    }

    public final void a(p healthShareData) {
        int b10;
        String str;
        i.f(healthShareData, "healthShareData");
        u i10 = healthShareData.i();
        boolean m10 = healthShareData.m();
        SportType j10 = healthShareData.j();
        a.C0219a c10 = a.d().c(j10);
        this.f17042c.setText(this.f17040a.getString(c10.f18994c));
        this.f17041b.setImageResource(c10.f18992a);
        this.f17041b.setImageTintList(ColorStateList.valueOf(b.c(this.f17040a, R.color.black)));
        this.f17043d.setText(d(i10.f25989h, i10.f25990i));
        this.f17044e.setText(c(i10.f25991j));
        TextView textView = this.f17045f;
        b10 = c.b(i10.f25993l);
        textView.setText(b(b10));
        TextView textView2 = this.f17046g;
        if (healthShareData.c() <= 0) {
            str = this.f17040a.getString(R.string.home_tab_card_value_empty);
        } else {
            str = String.valueOf(healthShareData.c());
        }
        textView2.setText(str);
        if (j10.isCountType()) {
            this.f17047h.setText(String.valueOf(i10.H));
            this.f17048i.setText(this.f17040a.getString(fg.u.X4));
            this.f17049j.setText(this.f17040a.getString(fg.u.Y4));
            this.f17049j.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.sport_detail_times_icon, 0, 0, 0);
            return;
        }
        int i11 = j10.typeCode;
        if (i11 == SportType.Swimming.typeCode || i11 == SportType.AutoSwimming.typeCode || i11 == SportType.OpenWaterSwimming.typeCode) {
            this.f17047h.setText(lf.c.d(SportDataType.SwimDistance, i10.A * i10.B, m10));
            this.f17048i.setText(lf.c.a(this.f17040a.getResources(), m10, SportDataType.SwimTypeDistance));
            return;
        }
        TextView textView3 = this.f17047h;
        SportDataType sportDataType = SportDataType.Distance;
        textView3.setText(lf.c.d(sportDataType, i10.f25992k, m10));
        this.f17048i.setText(lf.c.a(this.f17040a.getResources(), m10, sportDataType));
    }

    public final String b(int i10) {
        if (i10 < 100000) {
            return String.valueOf(i10);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10 / 1000);
        sb2.append('K');
        return sb2.toString();
    }
}
