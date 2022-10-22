package com.mobvoi.companion.health.share;

import android.app.Application;
import android.text.TextUtils;
import androidx.lifecycle.h0;
import androidx.lifecycle.w;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.wear.util.UnitsUtility;
import ef.a0;
import ef.b0;
import ef.f;
import ef.f0;
import ef.p;
import ef.q;
import ef.u;
import fh.c;
import fh.d;
import fh.g;
import hf.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import nf.j;
import nf.k;
import nf.m;
import xf.h;
/* compiled from: HealthShareChartViewModel.kt */
/* loaded from: classes2.dex */
public final class HealthShareChartViewModel extends androidx.lifecycle.b {
    public static final a Companion = new a(null);
    private final int age;
    private Iterable<? extends p> currentPoints;
    private u currentSummary;
    private int heartRateAverage;
    private final fh.a heartRateDataAnalyzer;
    private final boolean isBandSportType;
    private final boolean isImperial;
    private final m registrationHub;
    private final String sportId;
    private final SportType sportType;
    private final String sportTypeName;
    private final f sportSummary = new f();
    private final we.b<b0> speedDataAnalyzer = new d();
    private final we.b<a0> paceDataAnalyzer = new c();
    private final we.b<gh.a> segmentDataAnalyzer = new fh.f();
    private final we.b<f0> strokeDataAnalyzer = new g();
    private final w<p> healthShareData = new w<>();

    /* compiled from: HealthShareChartViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final HealthShareChartViewModel a(androidx.fragment.app.f activity, String sportId, String sportTypeName) {
            i.f(activity, "activity");
            i.f(sportId, "sportId");
            i.f(sportTypeName, "sportTypeName");
            Application application = activity.getApplication();
            i.e(application, "activity.application");
            return (HealthShareChartViewModel) new h0(activity, new n(application, sportId, sportTypeName)).a(HealthShareChartViewModel.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HealthShareChartViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements qo.p<u, Iterable<? extends p>, io.m> {
        b() {
            super(2);
        }

        public final void a(u summary, Iterable<? extends p> points) {
            i.f(summary, "summary");
            i.f(points, "points");
            List<h> heartRateData = HealthShareChartViewModel.this.heartRateDataAnalyzer.a(points);
            List paceData = HealthShareChartViewModel.this.paceDataAnalyzer.a(points);
            List speedData = HealthShareChartViewModel.this.speedDataAnalyzer.a(points);
            ((fh.f) HealthShareChartViewModel.this.segmentDataAnalyzer).g(summary.A);
            List segmentData = HealthShareChartViewModel.this.segmentDataAnalyzer.a(points);
            ((g) HealthShareChartViewModel.this.strokeDataAnalyzer).g(summary.A);
            List strokeData = HealthShareChartViewModel.this.strokeDataAnalyzer.a(points);
            int a10 = bh.f.a((int) Math.ceil(UnitsUtility.Time.ms2min(summary.f25991j)));
            w<p> healthShareData = HealthShareChartViewModel.this.getHealthShareData();
            i.e(heartRateData, "heartRateData");
            i.e(paceData, "paceData");
            i.e(speedData, "speedData");
            i.e(segmentData, "segmentData");
            i.e(strokeData, "strokeData");
            healthShareData.m(new p(heartRateData, paceData, speedData, segmentData, strokeData, HealthShareChartViewModel.this.sportSummary, summary, HealthShareChartViewModel.this.age, a10, HealthShareChartViewModel.this.isBandSportType, HealthShareChartViewModel.this.isImperial, HealthShareChartViewModel.this.sportType, HealthShareChartViewModel.this.heartRateAverage));
        }

        @Override // qo.p
        public /* bridge */ /* synthetic */ io.m invoke(u uVar, Iterable<? extends p> iterable) {
            a(uVar, iterable);
            return io.m.f28349a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthShareChartViewModel(Application application, String sportId, String sportTypeName) {
        super(application);
        i.f(application, "application");
        i.f(sportId, "sportId");
        i.f(sportTypeName, "sportTypeName");
        this.sportId = sportId;
        this.sportTypeName = sportTypeName;
        Enum valueOf = Enum.valueOf(SportType.class, sportTypeName);
        i.e(valueOf, "valueOf(SportType::class.java, sportTypeName)");
        SportType sportType = (SportType) valueOf;
        this.sportType = sportType;
        m mVar = new m();
        this.registrationHub = mVar;
        fh.a aVar = new fh.a();
        this.heartRateDataAnalyzer = aVar;
        this.isBandSportType = bh.f.d(sportType);
        this.isImperial = !com.mobvoi.companion.base.settings.a.isUnitMetric(application);
        int i10 = xf.i.a("", "", "", ah.c.a().o(application).f208a).f36548d;
        this.age = i10;
        aVar.k(i10);
        mVar.a(j.c(yg.f.X().N(), new k() { // from class: com.mobvoi.companion.health.share.m
            @Override // nf.k
            public final void i(nf.h hVar, Object obj) {
                HealthShareChartViewModel.m8_init_$lambda1(HealthShareChartViewModel.this, hVar, (Collection) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m8_init_$lambda1(HealthShareChartViewModel this$0, nf.h hVar, Collection data) {
        i.f(this$0, "this$0");
        i.f(data, "data");
        Iterator it = data.iterator();
        while (it.hasNext()) {
            u uVar = (u) it.next();
            if (TextUtils.equals(uVar.f25984c, this$0.sportId)) {
                this$0.currentSummary = uVar;
                if (this$0.sportType != SportType.Swimming) {
                    this$0.heartRateAverage = uVar.f25994m;
                }
                this$0.updateDetails();
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: querySportData$lambda-2  reason: not valid java name */
    public static final void m9querySportData$lambda2(HealthShareChartViewModel this$0, q qVar, Throwable th2) {
        i.f(this$0, "this$0");
        if (qVar == null) {
            qVar = new q();
        }
        this$0.currentPoints = qVar.c();
        this$0.updateDetails();
    }

    private final void updateDetails() {
        o.a(this.currentSummary, this.currentPoints, new b());
    }

    public final w<p> getHealthShareData() {
        return this.healthShareData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.f0
    public void onCleared() {
        super.onCleared();
        this.registrationHub.clear();
    }

    public final void querySportData() {
        yg.f.X().E(this.sportId, new o() { // from class: com.mobvoi.companion.health.share.l
            @Override // hf.o
            public final void a(Object obj, Throwable th2) {
                HealthShareChartViewModel.m9querySportData$lambda2(HealthShareChartViewModel.this, (q) obj, th2);
            }
        });
    }
}
