package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import androidx.viewpager.widget.a;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.widget.DiscoveryPageIndicator;
import com.mobvoi.companion.health.widget.autoviewpager.AutoScrollViewPager;
import io.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.i;
import tc.n;
import xc.b;
import xc.g;
/* compiled from: HealthCardReportViewHolder.kt */
/* loaded from: classes2.dex */
public final class HealthCardReportViewHolder extends i {
    private final AutoScrollViewPager bannerView;
    private final DiscoveryPageIndicator indicator = (DiscoveryPageIndicator) this.itemView.findViewById(R.id.indicator);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthCardReportViewHolder(ViewGroup viewParent) {
        super(viewParent, R.layout.layout_health_card_report);
        i.f(viewParent, "viewParent");
        AutoScrollViewPager autoScrollViewPager = (AutoScrollViewPager) this.itemView.findViewById(R.id.banner_view);
        Context context = autoScrollViewPager.getContext();
        i.e(context, "context");
        autoScrollViewPager.setAdapter(new e(context, new ArrayList()));
        m mVar = m.f28349a;
        this.bannerView = autoScrollViewPager;
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> cardData) {
        i.f(cardData, "cardData");
        if (cardData instanceof g) {
            int i10 = 0;
            this.itemView.setVisibility(0);
            List<n> a10 = ((g) cardData).a();
            if (a10 == null) {
                a10 = new ArrayList<>();
            }
            this.bannerView.setOffscreenPageLimit(a10.size() + 1);
            a adapter = this.bannerView.getAdapter();
            Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.mobvoi.companion.health.viewholder.AutoScrollVpAdapter");
            e eVar = (e) adapter;
            eVar.w(a10);
            eVar.j();
            DiscoveryPageIndicator discoveryPageIndicator = this.indicator;
            if (a10.size() > 1) {
                discoveryPageIndicator.setIndicatorCount(a10.size());
                discoveryPageIndicator.setViewPager(this.bannerView);
            }
            discoveryPageIndicator.setVisibility(a10.size() > 1 ? 0 : 8);
            AutoScrollViewPager autoScrollViewPager = this.bannerView;
            if (a10.size() > 1) {
                i10 = 1;
            }
            autoScrollViewPager.setCurrentItem(i10);
        }
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
        this.itemView.setVisibility(8);
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
    }
}
