package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import n5.j;
import n5.k;
import q4.d;
import t4.c;
import u4.e;
/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: h  reason: collision with root package name */
    public static final d<Boolean> f8082h;

    /* renamed from: i  reason: collision with root package name */
    public static final d<Boolean> f8083i;

    /* renamed from: a  reason: collision with root package name */
    private final e f8088a;

    /* renamed from: b  reason: collision with root package name */
    private final DisplayMetrics f8089b;

    /* renamed from: c  reason: collision with root package name */
    private final u4.b f8090c;

    /* renamed from: d  reason: collision with root package name */
    private final List<ImageHeaderParser> f8091d;

    /* renamed from: e  reason: collision with root package name */
    private final j f8092e = j.a();

    /* renamed from: f  reason: collision with root package name */
    public static final d<DecodeFormat> f8080f = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", DecodeFormat.DEFAULT);

    /* renamed from: g  reason: collision with root package name */
    public static final d<PreferredColorSpace> f8081g = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", PreferredColorSpace.SRGB);

    /* renamed from: j  reason: collision with root package name */
    private static final Set<String> f8084j = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));

    /* renamed from: k  reason: collision with root package name */
    private static final b f8085k = new a();

    /* renamed from: l  reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f8086l = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));

    /* renamed from: m  reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f8087m = k.e(0);

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.f.b
        public void a(e eVar, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.f.b
        public void b() {
        }
    }

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(e eVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        d<DownsampleStrategy> dVar = DownsampleStrategy.f8068f;
        Boolean bool = Boolean.FALSE;
        f8082h = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f8083i = d.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
    }

    public f(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, e eVar, u4.b bVar) {
        this.f8091d = list;
        this.f8089b = (DisplayMetrics) j.d(displayMetrics);
        this.f8088a = (e) j.d(eVar);
        this.f8090c = (u4.b) j.d(bVar);
    }

    private static int a(double d10) {
        int j10 = j(d10);
        int u10 = u(j10 * d10);
        return u((d10 / (u10 / j10)) * u10);
    }

    private void b(InputStream inputStream, DecodeFormat decodeFormat, boolean z10, boolean z11, BitmapFactory.Options options, int i10, int i11) {
        if (!this.f8092e.e(i10, i11, options, z10, z11)) {
            if (decodeFormat == DecodeFormat.PREFER_ARGB_8888 || Build.VERSION.SDK_INT == 16) {
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                return;
            }
            boolean z12 = false;
            try {
                z12 = com.bumptech.glide.load.a.b(this.f8091d, inputStream, this.f8090c).hasAlpha();
            } catch (IOException e10) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + decodeFormat, e10);
                }
            }
            Bitmap.Config config = z12 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
            }
        }
    }

    private static void c(ImageHeaderParser.ImageType imageType, InputStream inputStream, b bVar, e eVar, DownsampleStrategy downsampleStrategy, int i10, int i11, int i12, int i13, int i14, BitmapFactory.Options options) throws IOException {
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        double d10;
        if (i11 > 0 && i12 > 0) {
            if (o(i10)) {
                i15 = i11;
                i16 = i12;
            } else {
                i16 = i11;
                i15 = i12;
            }
            float b10 = downsampleStrategy.b(i16, i15, i13, i14);
            if (b10 > 0.0f) {
                DownsampleStrategy.SampleSizeRounding a10 = downsampleStrategy.a(i16, i15, i13, i14);
                if (a10 != null) {
                    float f10 = i16;
                    float f11 = i15;
                    int u10 = i16 / u(b10 * f10);
                    int u11 = i15 / u(b10 * f11);
                    DownsampleStrategy.SampleSizeRounding sampleSizeRounding = DownsampleStrategy.SampleSizeRounding.MEMORY;
                    if (a10 == sampleSizeRounding) {
                        i17 = Math.max(u10, u11);
                    } else {
                        i17 = Math.min(u10, u11);
                    }
                    int i21 = Build.VERSION.SDK_INT;
                    if (i21 > 23 || !f8084j.contains(options.outMimeType)) {
                        int max = Math.max(1, Integer.highestOneBit(i17));
                        if (a10 == sampleSizeRounding && max < 1.0f / b10) {
                            max <<= 1;
                        }
                        i18 = max;
                    } else {
                        i18 = 1;
                    }
                    options.inSampleSize = i18;
                    if (imageType == ImageHeaderParser.ImageType.JPEG) {
                        float min = Math.min(i18, 8);
                        i19 = (int) Math.ceil(f10 / min);
                        i20 = (int) Math.ceil(f11 / min);
                        int i22 = i18 / 8;
                        if (i22 > 0) {
                            i19 /= i22;
                            i20 /= i22;
                        }
                    } else {
                        if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                            float f12 = i18;
                            i19 = (int) Math.floor(f10 / f12);
                            d10 = Math.floor(f11 / f12);
                        } else if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                            if (i21 >= 24) {
                                float f13 = i18;
                                i19 = Math.round(f10 / f13);
                                i20 = Math.round(f11 / f13);
                            } else {
                                float f14 = i18;
                                i19 = (int) Math.floor(f10 / f14);
                                d10 = Math.floor(f11 / f14);
                            }
                        } else if (i16 % i18 == 0 && i15 % i18 == 0) {
                            i19 = i16 / i18;
                            i20 = i15 / i18;
                        } else {
                            int[] k10 = k(inputStream, options, bVar, eVar);
                            i19 = k10[0];
                            i20 = k10[1];
                        }
                        i20 = (int) d10;
                    }
                    double b11 = downsampleStrategy.b(i19, i20, i13, i14);
                    if (i21 >= 19) {
                        options.inTargetDensity = a(b11);
                        options.inDensity = j(b11);
                    }
                    if (p(options)) {
                        options.inScaled = true;
                    } else {
                        options.inTargetDensity = 0;
                        options.inDensity = 0;
                    }
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculate scaling, source: [" + i11 + "x" + i12 + "], degreesToRotate: " + i10 + ", target: [" + i13 + "x" + i14 + "], power of two scaled: [" + i19 + "x" + i20 + "], exact scale factor: " + b10 + ", power of 2 sample size: " + i18 + ", adjusted scale factor: " + b11 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException("Cannot round with null rounding");
            }
            throw new IllegalArgumentException("Cannot scale with factor: " + b10 + " from: " + downsampleStrategy + ", source: [" + i11 + "x" + i12 + "], target: [" + i13 + "x" + i14 + "]");
        } else if (Log.isLoggable("Downsampler", 3)) {
            Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i13 + "x" + i14 + "]");
        }
    }

    private Bitmap f(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean z10, int i10, int i11, boolean z11, b bVar) throws IOException {
        int i12;
        int i13;
        int i14;
        f fVar;
        int i15;
        ColorSpace colorSpace;
        int i16;
        int i17;
        long b10 = n5.f.b();
        int[] k10 = k(inputStream, options, bVar, this.f8088a);
        boolean z12 = false;
        int i18 = k10[0];
        int i19 = k10[1];
        String str = options.outMimeType;
        boolean z13 = (i18 == -1 || i19 == -1) ? false : z10;
        int a10 = com.bumptech.glide.load.a.a(this.f8091d, inputStream, this.f8090c);
        int j10 = o.j(a10);
        boolean m10 = o.m(a10);
        if (i10 == Integer.MIN_VALUE) {
            i13 = i11;
            i12 = o(j10) ? i19 : i18;
        } else {
            i13 = i11;
            i12 = i10;
        }
        if (i13 == Integer.MIN_VALUE) {
            i14 = o(j10) ? i18 : i19;
        } else {
            i14 = i13;
        }
        ImageHeaderParser.ImageType b11 = com.bumptech.glide.load.a.b(this.f8091d, inputStream, this.f8090c);
        c(b11, inputStream, bVar, this.f8088a, downsampleStrategy, j10, i18, i19, i12, i14, options);
        b(inputStream, decodeFormat, z13, m10, options, i12, i14);
        int i20 = Build.VERSION.SDK_INT;
        boolean z14 = i20 >= 19;
        if (options.inSampleSize == 1 || z14) {
            fVar = this;
            if (fVar.w(b11)) {
                if (i18 < 0 || i19 < 0 || !z11 || !z14) {
                    float f10 = p(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i21 = options.inSampleSize;
                    float f11 = i21;
                    float f12 = f10;
                    i17 = Math.round(((int) Math.ceil(i18 / f11)) * f12);
                    i16 = Math.round(((int) Math.ceil(i19 / f11)) * f12);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + i17 + "x" + i16 + "] for source [" + i18 + "x" + i19 + "], sampleSize: " + i21 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f12);
                    }
                } else {
                    i17 = i12;
                    i16 = i14;
                }
                if (i17 > 0 && i16 > 0) {
                    v(options, fVar.f8088a, i17, i16);
                }
            }
        } else {
            fVar = this;
        }
        if (i20 >= 28) {
            if (preferredColorSpace == PreferredColorSpace.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) {
                z12 = true;
            }
            options.inPreferredColorSpace = ColorSpace.get(z12 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
        } else if (i20 >= 26) {
            options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        Bitmap g10 = g(inputStream, options, bVar, fVar.f8088a);
        bVar.a(fVar.f8088a, g10);
        if (Log.isLoggable("Downsampler", 2)) {
            i15 = a10;
            q(i18, i19, str, options, g10, i10, i11, b10);
        } else {
            i15 = a10;
        }
        Bitmap bitmap = null;
        if (g10 != null) {
            g10.setDensity(fVar.f8089b.densityDpi);
            bitmap = o.n(fVar.f8088a, g10, i15);
            if (!g10.equals(bitmap)) {
                fVar.f8088a.c(g10);
            }
        }
        return bitmap;
    }

    private static Bitmap g(InputStream inputStream, BitmapFactory.Options options, b bVar, e eVar) throws IOException {
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            bVar.b();
        }
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        String str = options.outMimeType;
        o.i().lock();
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                o.i().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e10) {
                IOException r10 = r(e10, i10, i11, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", r10);
                }
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        eVar.c(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap g10 = g(inputStream, options, bVar, eVar);
                        o.i().unlock();
                        return g10;
                    } catch (IOException unused) {
                        throw r10;
                    }
                } else {
                    throw r10;
                }
            }
        } catch (Throwable th2) {
            o.i().unlock();
            throw th2;
        }
    }

    @TargetApi(19)
    private static String h(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = "";
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options poll;
        synchronized (f.class) {
            Queue<BitmapFactory.Options> queue = f8087m;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                t(poll);
            }
        }
        return poll;
    }

    private static int j(double d10) {
        if (d10 > 1.0d) {
            d10 = 1.0d / d10;
        }
        return (int) Math.round(d10 * 2.147483647E9d);
    }

    private static int[] k(InputStream inputStream, BitmapFactory.Options options, b bVar, e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        g(inputStream, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String l(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    private static boolean o(int i10) {
        return i10 == 90 || i10 == 270;
    }

    private static boolean p(BitmapFactory.Options options) {
        int i10;
        int i11 = options.inTargetDensity;
        return i11 > 0 && (i10 = options.inDensity) > 0 && i11 != i10;
    }

    private static void q(int i10, int i11, String str, BitmapFactory.Options options, Bitmap bitmap, int i12, int i13, long j10) {
        Log.v("Downsampler", "Decoded " + h(bitmap) + " from [" + i10 + "x" + i11 + "] " + str + " with inBitmap " + l(options) + " for [" + i12 + "x" + i13 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + n5.f.a(j10));
    }

    private static IOException r(IllegalArgumentException illegalArgumentException, int i10, int i11, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i10 + ", outHeight: " + i11 + ", outMimeType: " + str + ", inBitmap: " + l(options), illegalArgumentException);
    }

    private static void s(BitmapFactory.Options options) {
        t(options);
        Queue<BitmapFactory.Options> queue = f8087m;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void t(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int u(double d10) {
        return (int) (d10 + 0.5d);
    }

    @TargetApi(26)
    private static void v(BitmapFactory.Options options, e eVar, int i10, int i11) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig != Bitmap.Config.HARDWARE) {
            config = options.outConfig;
        } else {
            return;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.e(i10, i11, config);
    }

    private boolean w(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f8086l.contains(imageType);
    }

    public c<Bitmap> d(InputStream inputStream, int i10, int i11, q4.e eVar) throws IOException {
        return e(inputStream, i10, i11, eVar, f8085k);
    }

    public c<Bitmap> e(InputStream inputStream, int i10, int i11, q4.e eVar, b bVar) throws IOException {
        j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f8090c.e(WXMediaMessage.THUMB_LENGTH_LIMIT, byte[].class);
        BitmapFactory.Options i12 = i();
        i12.inTempStorage = bArr;
        DecodeFormat decodeFormat = (DecodeFormat) eVar.c(f8080f);
        PreferredColorSpace preferredColorSpace = (PreferredColorSpace) eVar.c(f8081g);
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) eVar.c(DownsampleStrategy.f8068f);
        boolean booleanValue = ((Boolean) eVar.c(f8082h)).booleanValue();
        d<Boolean> dVar = f8083i;
        try {
            return a5.c.f(f(inputStream, i12, downsampleStrategy, decodeFormat, preferredColorSpace, eVar.c(dVar) != null && ((Boolean) eVar.c(dVar)).booleanValue(), i10, i11, booleanValue, bVar), this.f8088a);
        } finally {
            s(i12);
            this.f8090c.d(bArr);
        }
    }

    public boolean m(InputStream inputStream) {
        return true;
    }

    public boolean n(ByteBuffer byteBuffer) {
        return true;
    }
}
