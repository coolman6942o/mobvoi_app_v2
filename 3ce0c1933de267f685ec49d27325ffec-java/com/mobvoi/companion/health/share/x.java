package com.mobvoi.companion.health.share;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.R;
import com.mobvoi.health.companion.sport.view.HealthSportSwimmingView;
import ef.u;
import kotlin.jvm.internal.i;
/* compiled from: HealthShareChartFragment.kt */
/* loaded from: classes2.dex */
public final class x extends RecyclerView.b0 {

    /* renamed from: a  reason: collision with root package name */
    private final HealthSportSwimmingView f17050a;

    /* renamed from: b  reason: collision with root package name */
    private final View f17051b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(View itemView) {
        super(itemView);
        i.f(itemView, "itemView");
        View findViewById = itemView.findViewById(R.id.swimming_view);
        i.e(findViewById, "itemView.findViewById(R.id.swimming_view)");
        this.f17050a = (HealthSportSwimmingView) findViewById;
        View findViewById2 = itemView.findViewById(R.id.swimLogo);
        i.e(findViewById2, "itemView.findViewById(R.id.swimLogo)");
        this.f17051b = findViewById2;
    }

    public final void a(p healthShareData, boolean z10) {
        i.f(healthShareData, "healthShareData");
        this.f17051b.setVisibility(z10 ? 0 : 8);
        u i10 = healthShareData.i();
        this.f17050a.c(i10.B, i10.A);
        this.f17050a.setSwimmingSegment(healthShareData.g());
        this.f17050a.setDetailed(true);
        this.f17050a.d(healthShareData.k(), null);
    }
}
