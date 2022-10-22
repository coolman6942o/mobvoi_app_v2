package com.mobvoi.health.companion.pressure;

import android.graphics.Path;
import com.mobvoi.android.common.utils.d;
import fg.o;
import hg.f;
import java.util.List;
/* compiled from: TimeIntervalPressure.java */
/* loaded from: classes2.dex */
public class a extends f {

    /* renamed from: b  reason: collision with root package name */
    public List<b> f18473b;

    /* renamed from: c  reason: collision with root package name */
    public final C0216a f18474c;

    /* compiled from: TimeIntervalPressure.java */
    /* renamed from: com.mobvoi.health.companion.pressure.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0216a {

        /* renamed from: a  reason: collision with root package name */
        public long f18475a;

        /* renamed from: b  reason: collision with root package name */
        public float f18476b;

        /* renamed from: c  reason: collision with root package name */
        public float f18477c;

        /* renamed from: d  reason: collision with root package name */
        public float f18478d;

        /* renamed from: e  reason: collision with root package name */
        public int f18479e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f18480f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f18481g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f18482h = 0;

        public String toString() {
            return "HeartSummary{uploadTime = " + d.a(this.f18475a) + "max =" + this.f18476b + ", min =" + this.f18477c + ", avg =" + this.f18478d + ", relaxPercent=" + this.f18479e + ", lowPercent=" + this.f18480f + ", mediumPercent=" + this.f18481g + ", highPercent=" + this.f18482h + '}';
        }
    }

    /* compiled from: TimeIntervalPressure.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f18483a;

        /* renamed from: b  reason: collision with root package name */
        public int f18484b;

        /* renamed from: c  reason: collision with root package name */
        public Path f18485c;

        public b(float f10, int i10) {
            this.f18483a = f10;
            this.f18484b = i10;
        }

        public String toString() {
            return "RangePressure{maxPressure=" + this.f18483a + ", index=" + this.f18484b + '}';
        }
    }

    public a(long j10, C0216a aVar, List<b> list) {
        super(j10);
        this.f18474c = aVar;
        this.f18473b = list;
    }

    public static int a(float f10) {
        if (f10 >= 75.0f) {
            return o.f26475o0;
        }
        if (f10 >= 50.0f && f10 < 75.0f) {
            return o.f26479q0;
        }
        if (f10 < 25.0f || f10 >= 50.0f) {
            return o.f26481r0;
        }
        return o.f26477p0;
    }
}
