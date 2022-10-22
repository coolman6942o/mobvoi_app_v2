package com.mobvoi.companion.health.share;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.R;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.health.companion.sport.view.SpeedView;
import com.mobvoi.wear.util.UnitsUtility;
import ef.b0;
import ef.f;
import java.util.List;
import kotlin.jvm.internal.i;
import lf.a;
import lf.b;
import lf.c;
/* compiled from: HealthShareChartFragment.kt */
/* loaded from: classes2.dex */
public final class v extends RecyclerView.b0 {

    /* renamed from: a  reason: collision with root package name */
    private final View f17035a;

    /* renamed from: b  reason: collision with root package name */
    private final SpeedView f17036b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17037c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17038d;

    /* renamed from: e  reason: collision with root package name */
    private final View f17039e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(View itemView) {
        super(itemView);
        i.f(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.speed_summary);
        i.e(findViewById, "itemView.findViewById(R.id.speed_summary)");
        this.f17035a = findViewById;
        View findViewById2 = itemView.findViewById(R.id.speed_diagram);
        i.e(findViewById2, "itemView.findViewById(R.id.speed_diagram)");
        this.f17036b = (SpeedView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.speed_max);
        i.e(findViewById3, "itemView.findViewById(R.id.speed_max)");
        this.f17037c = (TextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.speed_average);
        i.e(findViewById4, "itemView.findViewById(R.id.speed_average)");
        this.f17038d = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.speedLogo);
        i.e(findViewById5, "itemView.findViewById(R.id.speedLogo)");
        this.f17039e = findViewById5;
    }

    public final void a(Context context, p healthShareData, boolean z10) {
        float f10;
        String str;
        String str2;
        int b10;
        i.f(context, "context");
        i.f(healthShareData, "healthShareData");
        this.f17039e.setVisibility(z10 ? 0 : 8);
        List<b0> h10 = healthShareData.h();
        f b11 = healthShareData.b();
        int f11 = healthShareData.f();
        boolean m10 = healthShareData.m();
        boolean e10 = bh.f.e(h10);
        if (!e10 || !healthShareData.j().isAutoSport()) {
            a.d(h10, b11);
            float c10 = b.c(healthShareData.i());
            if (m10) {
                f10 = UnitsUtility.Speed.mPs2milePh(c10);
            } else {
                f10 = UnitsUtility.Speed.mPs2kmPh(c10);
            }
            b11.f25930n = f10;
            this.f17036b.g(h10, b11.f25932p, b11.f25931o, f11);
            String a10 = c.a(context.getResources(), m10, SportDataType.Speed);
            TextView textView = this.f17037c;
            if (e10) {
                str = context.getString(R.string.health_sport_detail_speed_max_invalid, a10);
            } else {
                int i10 = R.string.health_sport_detail_speed_max;
                b10 = so.c.b(b11.f25931o);
                str = context.getString(i10, Integer.valueOf(b10), a10);
            }
            textView.setText(str);
            TextView textView2 = this.f17038d;
            if (e10) {
                str2 = context.getString(R.string.health_sport_detail_speed_average_invalid, a10);
            } else {
                str2 = context.getString(R.string.health_sport_detail_speed_average, Float.valueOf(b11.f25930n), a10);
            }
            textView2.setText(str2);
            return;
        }
        this.f17035a.setVisibility(8);
    }
}
