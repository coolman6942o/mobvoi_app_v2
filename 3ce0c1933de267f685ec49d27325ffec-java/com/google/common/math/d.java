package com.google.common.math;

import com.google.common.base.p;
/* compiled from: LinearTransformation.java */
/* loaded from: classes.dex */
public abstract class d {

    /* compiled from: LinearTransformation.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final double f12327a;

        /* renamed from: b  reason: collision with root package name */
        private final double f12328b;

        public d a(double d10) {
            p.d(!Double.isNaN(d10));
            if (com.google.common.math.b.c(d10)) {
                return new C0156d(d10, this.f12328b - (this.f12327a * d10));
            }
            return new e(this.f12327a);
        }

        private b(double d10, double d11) {
            this.f12327a = d10;
            this.f12328b = d11;
        }
    }

    /* compiled from: LinearTransformation.java */
    /* loaded from: classes.dex */
    private static final class c extends d {

        /* renamed from: a  reason: collision with root package name */
        static final c f12329a = new c();

        private c() {
        }

        public String toString() {
            return "NaN";
        }
    }

    /* compiled from: LinearTransformation.java */
    /* renamed from: com.google.common.math.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class C0156d extends d {

        /* renamed from: a  reason: collision with root package name */
        final double f12330a;

        /* renamed from: b  reason: collision with root package name */
        final double f12331b;

        C0156d(double d10, double d11) {
            this.f12330a = d10;
            this.f12331b = d11;
        }

        public String toString() {
            return String.format("y = %g * x + %g", Double.valueOf(this.f12330a), Double.valueOf(this.f12331b));
        }
    }

    /* compiled from: LinearTransformation.java */
    /* loaded from: classes.dex */
    private static final class e extends d {

        /* renamed from: a  reason: collision with root package name */
        final double f12332a;

        e(double d10) {
            this.f12332a = d10;
        }

        public String toString() {
            return String.format("x = %g", Double.valueOf(this.f12332a));
        }
    }

    public static d a() {
        return c.f12329a;
    }

    public static d b(double d10) {
        p.d(com.google.common.math.b.c(d10));
        return new C0156d(0.0d, d10);
    }

    public static b c(double d10, double d11) {
        p.d(com.google.common.math.b.c(d10) && com.google.common.math.b.c(d11));
        return new b(d10, d11);
    }

    public static d d(double d10) {
        p.d(com.google.common.math.b.c(d10));
        return new e(d10);
    }
}
