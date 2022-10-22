package com.mobvoi.health.companion.oxygen;

import android.graphics.Path;
import com.mobvoi.android.common.utils.d;
import hg.f;
import java.util.List;
/* compiled from: TimeIntervalBloodOxygen.java */
/* loaded from: classes2.dex */
public class a extends f {

    /* renamed from: b  reason: collision with root package name */
    public List<b> f18415b;

    /* renamed from: c  reason: collision with root package name */
    public final C0215a f18416c;

    /* compiled from: TimeIntervalBloodOxygen.java */
    /* renamed from: com.mobvoi.health.companion.oxygen.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0215a {

        /* renamed from: a  reason: collision with root package name */
        public long f18417a;

        /* renamed from: b  reason: collision with root package name */
        public int f18418b;

        /* renamed from: c  reason: collision with root package name */
        public int f18419c;

        /* renamed from: d  reason: collision with root package name */
        public float f18420d;

        /* renamed from: e  reason: collision with root package name */
        public float f18421e;

        /* renamed from: f  reason: collision with root package name */
        public float f18422f;

        /* renamed from: g  reason: collision with root package name */
        public int f18423g;

        public String toString() {
            return "BloodOxygenSummary{uploadTime=" + d.a(this.f18417a) + ", max=" + this.f18420d + ", min=" + this.f18421e + ", avg=" + this.f18422f + ", lowLimitCount=" + this.f18423g + '}';
        }
    }

    /* compiled from: TimeIntervalBloodOxygen.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f18424a;

        /* renamed from: b  reason: collision with root package name */
        public float f18425b;

        /* renamed from: c  reason: collision with root package name */
        public int f18426c;

        /* renamed from: d  reason: collision with root package name */
        public Path f18427d;

        public b(float f10, float f11, int i10) {
            this.f18424a = f10;
            this.f18425b = f11;
            this.f18426c = i10;
        }

        public String toString() {
            return "RangeBloodOxygen{, max=" + this.f18424a + ", min=" + this.f18425b + ", index=" + this.f18426c + '}';
        }
    }

    public a(long j10, C0215a aVar, List<b> list) {
        super(j10);
        this.f18416c = aVar;
        this.f18415b = list;
    }
}
