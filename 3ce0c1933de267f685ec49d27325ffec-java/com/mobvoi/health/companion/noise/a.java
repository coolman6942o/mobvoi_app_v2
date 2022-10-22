package com.mobvoi.health.companion.noise;

import android.graphics.Path;
import com.mobvoi.android.common.utils.d;
import hg.f;
import java.util.List;
/* compiled from: TimeIntervalNoise.java */
/* loaded from: classes2.dex */
public class a extends f {

    /* renamed from: b  reason: collision with root package name */
    public List<b> f18364b;

    /* renamed from: c  reason: collision with root package name */
    public C0214a f18365c;

    /* compiled from: TimeIntervalNoise.java */
    /* renamed from: com.mobvoi.health.companion.noise.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0214a {

        /* renamed from: a  reason: collision with root package name */
        public long f18366a;

        /* renamed from: b  reason: collision with root package name */
        public float f18367b;

        /* renamed from: c  reason: collision with root package name */
        public float f18368c;

        /* renamed from: d  reason: collision with root package name */
        public float f18369d;

        public String toString() {
            return "HeartSummary{uploadTime=" + d.a(this.f18366a) + ", maxRate=" + this.f18367b + ", minRate=" + this.f18368c + ", avgNoise=" + this.f18369d + '}';
        }
    }

    /* compiled from: TimeIntervalNoise.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public long f18370a;

        /* renamed from: b  reason: collision with root package name */
        public long f18371b;

        /* renamed from: c  reason: collision with root package name */
        public float f18372c;

        /* renamed from: d  reason: collision with root package name */
        public float f18373d;

        /* renamed from: e  reason: collision with root package name */
        public int f18374e;

        /* renamed from: f  reason: collision with root package name */
        public Path f18375f;

        public b(float f10, float f11, int i10) {
            this.f18372c = f10;
            this.f18373d = f11;
            this.f18374e = i10;
        }

        public String toString() {
            return "RangeNoise{startTime=" + this.f18370a + ", endTime=" + this.f18371b + ", maxNoise=" + this.f18372c + ", minNoise=" + this.f18373d + ", index=" + this.f18374e + ", path=" + this.f18375f + '}';
        }
    }

    public a(long j10, List<b> list, C0214a aVar) {
        super(j10);
        this.f18364b = list;
        this.f18365c = aVar;
    }
}
