package com.mobvoi.companion.health.share;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.R;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.health.companion.sport.view.PaceView;
import ef.a0;
import ef.f;
import java.util.List;
import kotlin.jvm.internal.i;
import lf.a;
import lf.b;
import lf.c;
/* compiled from: HealthShareChartFragment.kt */
/* loaded from: classes2.dex */
public final class u extends RecyclerView.b0 {

    /* renamed from: a  reason: collision with root package name */
    private final PaceView f17031a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f17032b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17033c;

    /* renamed from: d  reason: collision with root package name */
    private final View f17034d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(View itemView) {
        super(itemView);
        i.f(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.pace_diagram);
        i.e(findViewById, "itemView.findViewById(R.id.pace_diagram)");
        this.f17031a = (PaceView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.pace_max);
        i.e(findViewById2, "itemView.findViewById(R.id.pace_max)");
        this.f17032b = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.pace_average);
        i.e(findViewById3, "itemView.findViewById(R.id.pace_average)");
        this.f17033c = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.paceLogo);
        i.e(findViewById4, "itemView.findViewById(R.id.paceLogo)");
        this.f17034d = findViewById4;
    }

    public final void a(Context context, p healthShareData, boolean z10) {
        String str;
        String str2;
        i.f(context, "context");
        i.f(healthShareData, "healthShareData");
        this.f17034d.setVisibility(z10 ? 0 : 8);
        List<a0> e10 = healthShareData.e();
        f b10 = healthShareData.b();
        boolean l10 = healthShareData.l();
        boolean m10 = healthShareData.m();
        b.b(healthShareData.i());
        boolean e11 = bh.f.e(e10);
        a.c(e10, b10);
        if (!l10 || !e11) {
            this.f17031a.c(e10, b10.f25934r, healthShareData.f());
        } else {
            this.f17031a.setVisibility(8);
        }
        Resources resources = context.getResources();
        SportDataType sportDataType = SportDataType.Pace;
        String a10 = c.a(resources, m10, sportDataType);
        if (!l10) {
            float f10 = 60;
            float f11 = 1000;
            float f12 = (b10.f25935s * f10) / f11;
            TextView textView = this.f17032b;
            if (e11) {
                str = context.getString(R.string.health_sport_detail_pace_max_invalid, a10);
            } else {
                str = context.getString(R.string.health_sport_detail_pace_max_other, c.d(sportDataType, f12, m10), a10);
            }
            textView.setText(str);
            float f13 = (b10.f25933q * f10) / f11;
            TextView textView2 = this.f17033c;
            if (e11) {
                str2 = context.getString(R.string.health_sport_detail_pace_average_invalid, a10);
            } else {
                str2 = context.getString(R.string.health_sport_detail_pace_average, c.d(sportDataType, f13, m10), a10);
            }
            textView2.setText(str2);
        }
    }
}
