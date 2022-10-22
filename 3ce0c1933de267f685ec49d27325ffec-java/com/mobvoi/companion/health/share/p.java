package com.mobvoi.companion.health.share;

import com.mobvoi.health.common.data.pojo.SportType;
import ef.a0;
import ef.b0;
import ef.f;
import ef.f0;
import ef.u;
import gh.a;
import java.util.List;
import kotlin.jvm.internal.i;
import xf.h;
/* compiled from: HealthShareChartViewModel.kt */
/* loaded from: classes2.dex */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    private final List<h> f16993a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a0> f16994b;

    /* renamed from: c  reason: collision with root package name */
    private final List<b0> f16995c;

    /* renamed from: d  reason: collision with root package name */
    private final List<a> f16996d;

    /* renamed from: e  reason: collision with root package name */
    private final List<f0> f16997e;

    /* renamed from: f  reason: collision with root package name */
    private final f f16998f;

    /* renamed from: g  reason: collision with root package name */
    private final u f16999g;

    /* renamed from: h  reason: collision with root package name */
    private final int f17000h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17001i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f17002j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f17003k;

    /* renamed from: l  reason: collision with root package name */
    private final SportType f17004l;

    /* renamed from: m  reason: collision with root package name */
    private final int f17005m;

    /* JADX WARN: Multi-variable type inference failed */
    public p(List<? extends h> heartRateList, List<? extends a0> paceList, List<? extends b0> speedList, List<? extends a> segmentData, List<? extends f0> strokeData, f healthSportsSummary, u sportSummary, int i10, int i11, boolean z10, boolean z11, SportType sportType, int i12) {
        i.f(heartRateList, "heartRateList");
        i.f(paceList, "paceList");
        i.f(speedList, "speedList");
        i.f(segmentData, "segmentData");
        i.f(strokeData, "strokeData");
        i.f(healthSportsSummary, "healthSportsSummary");
        i.f(sportSummary, "sportSummary");
        i.f(sportType, "sportType");
        this.f16993a = heartRateList;
        this.f16994b = paceList;
        this.f16995c = speedList;
        this.f16996d = segmentData;
        this.f16997e = strokeData;
        this.f16998f = healthSportsSummary;
        this.f16999g = sportSummary;
        this.f17000h = i10;
        this.f17001i = i11;
        this.f17002j = z10;
        this.f17003k = z11;
        this.f17004l = sportType;
        this.f17005m = i12;
    }

    public final int a() {
        return this.f17000h;
    }

    public final f b() {
        return this.f16998f;
    }

    public final int c() {
        return this.f17005m;
    }

    public final List<h> d() {
        return this.f16993a;
    }

    public final List<a0> e() {
        return this.f16994b;
    }

    public final int f() {
        return this.f17001i;
    }

    public final List<a> g() {
        return this.f16996d;
    }

    public final List<b0> h() {
        return this.f16995c;
    }

    public final u i() {
        return this.f16999g;
    }

    public final SportType j() {
        return this.f17004l;
    }

    public final List<f0> k() {
        return this.f16997e;
    }

    public final boolean l() {
        return this.f17002j;
    }

    public final boolean m() {
        return this.f17003k;
    }
}
