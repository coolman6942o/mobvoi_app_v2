package com.bumptech.glide.load.resource.bitmap;

import android.os.Build;
/* loaded from: classes.dex */
public abstract class DownsampleStrategy {

    /* renamed from: c  reason: collision with root package name */
    public static final DownsampleStrategy f8065c;

    /* renamed from: e  reason: collision with root package name */
    public static final DownsampleStrategy f8067e;

    /* renamed from: f  reason: collision with root package name */
    public static final q4.d<DownsampleStrategy> f8068f;

    /* renamed from: g  reason: collision with root package name */
    static final boolean f8069g;

    /* renamed from: a  reason: collision with root package name */
    public static final DownsampleStrategy f8063a = new e();

    /* renamed from: b  reason: collision with root package name */
    public static final DownsampleStrategy f8064b = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final DownsampleStrategy f8066d = new f();

    /* loaded from: classes.dex */
    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* loaded from: classes.dex */
    private static class a extends DownsampleStrategy {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            int min = Math.min(i11 / i13, i10 / i12);
            if (min == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(min);
        }
    }

    /* loaded from: classes.dex */
    private static class b extends DownsampleStrategy {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            int ceil = (int) Math.ceil(Math.max(i11 / i13, i10 / i12));
            int i14 = 1;
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i14 = 0;
            }
            return 1.0f / (max << i14);
        }
    }

    /* loaded from: classes.dex */
    private static class c extends DownsampleStrategy {
        c() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            if (b(i10, i11, i12, i13) == 1.0f) {
                return SampleSizeRounding.QUALITY;
            }
            return DownsampleStrategy.f8063a.a(i10, i11, i12, i13);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            return Math.min(1.0f, DownsampleStrategy.f8063a.b(i10, i11, i12, i13));
        }
    }

    /* loaded from: classes.dex */
    private static class d extends DownsampleStrategy {
        d() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            return Math.max(i12 / i10, i13 / i11);
        }
    }

    /* loaded from: classes.dex */
    private static class e extends DownsampleStrategy {
        e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            if (DownsampleStrategy.f8069g) {
                return SampleSizeRounding.QUALITY;
            }
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            if (DownsampleStrategy.f8069g) {
                return Math.min(i12 / i10, i13 / i11);
            }
            int max = Math.max(i11 / i13, i10 / i12);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(max);
        }
    }

    /* loaded from: classes.dex */
    private static class f extends DownsampleStrategy {
        f() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public SampleSizeRounding a(int i10, int i11, int i12, int i13) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        public float b(int i10, int i11, int i12, int i13) {
            return 1.0f;
        }
    }

    static {
        new a();
        new b();
        d dVar = new d();
        f8065c = dVar;
        f8067e = dVar;
        f8068f = q4.d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", dVar);
        f8069g = Build.VERSION.SDK_INT >= 19;
    }

    public abstract SampleSizeRounding a(int i10, int i11, int i12, int i13);

    public abstract float b(int i10, int i11, int i12, int i13);
}
