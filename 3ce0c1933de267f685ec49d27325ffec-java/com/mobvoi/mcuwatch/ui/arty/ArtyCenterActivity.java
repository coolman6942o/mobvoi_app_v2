package com.mobvoi.mcuwatch.ui.arty;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.Insight;
import com.cardiex.arty.lite.models.coach.InsightType;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.health.common.data.db.c;
import com.mobvoi.mcuwatch.engine.v;
import com.mobvoi.mcuwatch.ui.arty.ArtyCenterActivity;
import com.mobvoi.mcuwatch.ui.arty.adapter.ArtyCenterAdapter;
import gg.c;
import gg.e;
import ig.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import nf.j;
import nf.m;
import sh.h;
import sh.i;
import sh.k;
import ti.a;
/* loaded from: classes2.dex */
public class ArtyCenterActivity extends d implements SwipeRefreshLayout.j {

    /* renamed from: a  reason: collision with root package name */
    RecyclerView f19296a;

    /* renamed from: b  reason: collision with root package name */
    SwipeRefreshLayout f19297b;

    /* renamed from: c  reason: collision with root package name */
    e f19298c;

    /* renamed from: e  reason: collision with root package name */
    ArtyCenterAdapter f19300e;

    /* renamed from: g  reason: collision with root package name */
    private long f19302g;

    /* renamed from: h  reason: collision with root package name */
    private int f19303h;

    /* renamed from: d  reason: collision with root package name */
    List<a> f19299d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final m f19301f = new m();

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(Map map) {
        long j10 = 0;
        for (Map.Entry entry : map.entrySet()) {
            if (j10 < ((Long) entry.getKey()).longValue()) {
                j10 = ((Long) entry.getKey()).longValue();
            }
        }
        List<c> list = (List) map.get(Long.valueOf(j10));
        if (j10 > 0 && list != null) {
            long j11 = list.get(0).f27462f;
            if (eg.c.a(System.currentTimeMillis()).getTimeInMillis() != eg.c.a(j11).getTimeInMillis()) {
                setSubtitle("");
            } else {
                setSubtitle(String.format(getResources().getString(k.N), eg.k.d(j11, "HH:mm")));
            }
            if (j11 != this.f19302g) {
                a aVar = this.f19299d.get(0);
                aVar.b(list);
                this.f19302g = j11;
                this.f19300e.setData(0, aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(c.a aVar) {
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(Insight[] insightArr) {
        int i10;
        Advice advice;
        if (insightArr == null || insightArr.length <= 0) {
            i10 = 0;
        } else {
            i10 = 0;
            for (Insight insight : insightArr) {
                if (insight.getType() == InsightType.ADVICE && (advice = insight.getAdvice()) != null && !advice.isSeen()) {
                    i10++;
                }
            }
        }
        com.mobvoi.android.common.utils.k.c("ArtyCenterActivity", "getInsight count:%d", Integer.valueOf(i10));
        if (i10 != this.f19303h) {
            this.f19303h = i10;
            a aVar = this.f19299d.get(1);
            aVar.f35165d = i10;
            this.f19300e.setData(1, aVar);
        }
    }

    private void O() {
        long timeInMillis = eg.c.a(System.currentTimeMillis()).getTimeInMillis() + TimeUnit.HOURS.toMillis(24L);
        this.f19298c.L(timeInMillis - 604800000, timeInMillis, 0);
    }

    protected void K() {
        this.f19301f.clear();
        e eVar = new e();
        this.f19298c = eVar;
        this.f19301f.a(j.b(eVar.t(), new j.a() { // from class: ri.c
            @Override // nf.j.a
            public final void call(Object obj) {
                ArtyCenterActivity.this.L((Map) obj);
            }
        }));
        this.f19301f.a(j.b(b.J().z().t(), new j.a() { // from class: ri.b
            @Override // nf.j.a
            public final void call(Object obj) {
                ArtyCenterActivity.this.M((c.a) obj);
            }
        }));
        this.f19301f.a(j.b(ad.a.f168a.g(), new j.a() { // from class: ri.d
            @Override // nf.j.a
            public final void call(Object obj) {
                ArtyCenterActivity.this.N((Insight[]) obj);
            }
        }));
        O();
        v.f19226a.l();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return i.h_res_0x7f0e0026;
    }

    protected void initView() {
        this.f19296a = (RecyclerView) findViewById(h.f34725z2);
        this.f19297b = (SwipeRefreshLayout) findViewById(h.f34613a3);
        setTitle(getString(k.y_res_0x7f1400ff));
        this.f19299d.add(new a(1));
        this.f19299d.add(new a(2));
        this.f19299d.add(new a(3));
        this.f19299d.add(new a(4));
        ArtyCenterAdapter artyCenterAdapter = new ArtyCenterAdapter(this.f19299d);
        this.f19300e = artyCenterAdapter;
        artyCenterAdapter.bindToRecyclerView(this.f19296a);
        this.f19296a.setLayoutManager(new LinearLayoutManager(this));
        this.f19297b.setOnRefreshListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        K();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m mVar = this.f19301f;
        if (mVar != null && !mVar.d()) {
            this.f19301f.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        ad.a.f168a.e();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void y() {
        v.f19226a.l();
        this.f19297b.setRefreshing(false);
    }
}
