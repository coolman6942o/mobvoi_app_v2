package com.mobvoi.health.companion.sleep;

import android.graphics.Path;
import com.mobvoi.sleep.data.pojo.SleepRecord;
import hg.f;
import java.util.List;
/* compiled from: TimeIntervalSleep.java */
/* loaded from: classes2.dex */
public class c extends f {

    /* renamed from: b  reason: collision with root package name */
    public List<a> f18622b;

    /* renamed from: c  reason: collision with root package name */
    public d f18623c;

    /* renamed from: d  reason: collision with root package name */
    public b f18624d;

    /* compiled from: TimeIntervalSleep.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f18625a;

        /* renamed from: b  reason: collision with root package name */
        public long f18626b;

        /* renamed from: c  reason: collision with root package name */
        public long f18627c;

        /* renamed from: d  reason: collision with root package name */
        public long f18628d;

        /* renamed from: e  reason: collision with root package name */
        public long f18629e;

        /* renamed from: f  reason: collision with root package name */
        public long f18630f;

        /* renamed from: g  reason: collision with root package name */
        public int f18631g;

        /* renamed from: h  reason: collision with root package name */
        public Path f18632h;

        /* renamed from: i  reason: collision with root package name */
        public Path f18633i;

        /* renamed from: j  reason: collision with root package name */
        public Path f18634j;

        /* renamed from: k  reason: collision with root package name */
        public Path f18635k;

        public String toString() {
            return "RangeSleep{wake=" + this.f18625a + ", rem=" + this.f18626b + ", lightSleep=" + this.f18627c + ", deepSleep=" + this.f18628d + ", fallSleep=" + this.f18629e + ", inBedTotal=" + this.f18630f + ", index=" + this.f18631g + '}';
        }
    }

    /* compiled from: TimeIntervalSleep.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public List<SleepRecord> f18636a;

        /* renamed from: b  reason: collision with root package name */
        public SleepRecord f18637b;

        /* renamed from: c  reason: collision with root package name */
        public int f18638c;

        /* renamed from: d  reason: collision with root package name */
        public int f18639d;

        /* renamed from: e  reason: collision with root package name */
        public int f18640e;

        /* renamed from: f  reason: collision with root package name */
        public int f18641f;

        /* renamed from: g  reason: collision with root package name */
        public int f18642g;

        /* renamed from: h  reason: collision with root package name */
        public long f18643h = 0;

        /* renamed from: i  reason: collision with root package name */
        public long f18644i = 0;

        /* renamed from: j  reason: collision with root package name */
        public long f18645j = 0;

        /* renamed from: k  reason: collision with root package name */
        public long f18646k = 0;

        /* renamed from: l  reason: collision with root package name */
        public long f18647l = 0;

        public String toString() {
            return "SleepDySummary{  aWakPercent=" + this.f18638c + ", remPercent=" + this.f18639d + ", lightPercent=" + this.f18640e + ", deepPercent=" + this.f18641f + ", fallSleepPercent=" + this.f18642g + ", aWakeTime=" + this.f18643h + ", remTime=" + this.f18644i + ", lightSleepTime=" + this.f18645j + ", deepSleepTime=" + this.f18646k + ", fallAsleep=" + this.f18647l + '}';
        }
    }

    /* compiled from: TimeIntervalSleep.java */
    /* renamed from: com.mobvoi.health.companion.sleep.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0218c {

        /* renamed from: a  reason: collision with root package name */
        public float f18648a;

        /* renamed from: b  reason: collision with root package name */
        public SleepRecord.TimeType f18649b;

        /* renamed from: c  reason: collision with root package name */
        public Path f18650c;
    }

    /* compiled from: TimeIntervalSleep.java */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f18651a;

        /* renamed from: b  reason: collision with root package name */
        public long f18652b;

        /* renamed from: c  reason: collision with root package name */
        public long f18653c;

        /* renamed from: d  reason: collision with root package name */
        public int f18654d;

        /* renamed from: e  reason: collision with root package name */
        public long f18655e;

        /* renamed from: f  reason: collision with root package name */
        public int f18656f;

        /* renamed from: k  reason: collision with root package name */
        public int f18661k;

        /* renamed from: l  reason: collision with root package name */
        public int f18662l;

        /* renamed from: m  reason: collision with root package name */
        public int f18663m;

        /* renamed from: n  reason: collision with root package name */
        public int f18664n;

        /* renamed from: o  reason: collision with root package name */
        public int f18665o;

        /* renamed from: t  reason: collision with root package name */
        public int f18670t;

        /* renamed from: u  reason: collision with root package name */
        public long f18671u;

        /* renamed from: v  reason: collision with root package name */
        public long f18672v;

        /* renamed from: w  reason: collision with root package name */
        public long f18673w;

        /* renamed from: g  reason: collision with root package name */
        public long f18657g = 0;

        /* renamed from: h  reason: collision with root package name */
        public long f18658h = 0;

        /* renamed from: i  reason: collision with root package name */
        public long f18659i = 0;

        /* renamed from: j  reason: collision with root package name */
        public long f18660j = 0;

        /* renamed from: p  reason: collision with root package name */
        public long f18666p = 0;

        /* renamed from: q  reason: collision with root package name */
        public long f18667q = 0;

        /* renamed from: r  reason: collision with root package name */
        public long f18668r = 0;

        /* renamed from: s  reason: collision with root package name */
        public long f18669s = 0;

        public String toString() {
            return "SleepSummary{avgGetUpTime=" + this.f18652b + ", avgFallSleepTime=" + this.f18653c + ", avgScore=" + this.f18654d + ", avgDuration=" + this.f18655e + ", avgHartRate=" + this.f18656f + ", maxSleepDuration=" + this.f18657g + ", maxSleepDate=" + this.f18658h + ", mixSleepDuration=" + this.f18659i + ", minSleepDate=" + this.f18660j + ", aWakPercent=" + this.f18661k + ", remPercent=" + this.f18662l + ", lightPercent=" + this.f18663m + ", deepPercent=" + this.f18664n + ", fallSleepPercent=" + this.f18665o + ", compareAvgScore=" + this.f18670t + ", compareAvgGetUpTime=" + this.f18671u + ", compareAvgFallSleepTime=" + this.f18672v + ", compareAvgSleepDuration=" + this.f18673w + '}';
        }
    }

    public c(long j10) {
        super(j10);
    }

    public c(long j10, List<a> list, d dVar) {
        super(j10);
        this.f18622b = list;
        this.f18623c = dVar;
    }
}
