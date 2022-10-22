package com.mobvoi.health.companion.heartrate.ui;

import android.graphics.Path;
import com.mobvoi.android.common.utils.d;
import hg.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: TimeIntervalHeartRates.java */
/* loaded from: classes2.dex */
public class c extends f {

    /* renamed from: b  reason: collision with root package name */
    public List<b> f18272b;

    /* renamed from: c  reason: collision with root package name */
    public a f18273c;

    /* renamed from: d  reason: collision with root package name */
    public Map<Integer, List<rh.a>> f18274d;

    /* renamed from: e  reason: collision with root package name */
    public List<rh.a> f18275e;

    /* renamed from: f  reason: collision with root package name */
    public List<rh.a> f18276f;

    /* renamed from: g  reason: collision with root package name */
    public List<rh.a> f18277g;

    /* renamed from: h  reason: collision with root package name */
    public List<rh.a> f18278h;

    /* compiled from: TimeIntervalHeartRates.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f18279a;

        /* renamed from: b  reason: collision with root package name */
        public float f18280b;

        /* renamed from: c  reason: collision with root package name */
        public float f18281c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f18282d;

        /* renamed from: e  reason: collision with root package name */
        public int f18283e;

        /* renamed from: f  reason: collision with root package name */
        public int f18284f;

        /* renamed from: g  reason: collision with root package name */
        public int f18285g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f18286h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f18287i = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f18288j = -1;

        public String toString() {
            return "HeartSummary{uploadTime=" + d.a(this.f18279a) + ", maxRate=" + this.f18280b + ", minRate=" + this.f18281c + ", restRate=" + this.f18283e + ", showRest=" + this.f18282d + ", averageRate=" + this.f18284f + ", maxRateIndex=" + this.f18287i + ", minRateIndex=" + this.f18288j + ", lowLimitCount=" + this.f18285g + ", upperLimitCount=" + this.f18286h + '}';
        }
    }

    /* compiled from: TimeIntervalHeartRates.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f18289a;

        /* renamed from: b  reason: collision with root package name */
        public long f18290b;

        /* renamed from: c  reason: collision with root package name */
        public float f18291c;

        /* renamed from: d  reason: collision with root package name */
        public float f18292d;

        /* renamed from: e  reason: collision with root package name */
        public int f18293e;

        /* renamed from: f  reason: collision with root package name */
        public int f18294f;

        /* renamed from: g  reason: collision with root package name */
        public int f18295g;

        /* renamed from: h  reason: collision with root package name */
        public Path f18296h;

        public String toString() {
            return "RangeHeartRate{startTime=" + this.f18289a + ", endTime=" + this.f18290b + ", maxRate=" + this.f18291c + ", minRate=" + this.f18292d + ", restRate=" + this.f18293e + ", averageRate=" + this.f18294f + ", index=" + this.f18295g + '}';
        }
    }

    public c(long j10) {
        super(j10);
        this.f18272b = new ArrayList();
        this.f18273c = new a();
    }

    public c(long j10, List<b> list, a aVar) {
        super(j10);
        this.f18272b = list;
        this.f18273c = aVar;
    }
}
