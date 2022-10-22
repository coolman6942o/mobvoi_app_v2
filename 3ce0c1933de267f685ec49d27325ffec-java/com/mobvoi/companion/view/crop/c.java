package com.mobvoi.companion.view.crop;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.util.Pair;
import com.huawei.hms.ml.camera.CameraConfig;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.view.crop.CropImageView;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
/* compiled from: BitmapUtils.java */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    static final Rect f17776a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    static final RectF f17777b = new RectF();

    /* renamed from: c  reason: collision with root package name */
    static final RectF f17778c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    static final float[] f17779d = new float[6];

    /* renamed from: e  reason: collision with root package name */
    static final float[] f17780e = new float[6];

    /* renamed from: f  reason: collision with root package name */
    private static int f17781f;

    /* renamed from: g  reason: collision with root package name */
    static Pair<String, WeakReference<Bitmap>> f17782g;

    /* compiled from: BitmapUtils.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f17783a;

        /* renamed from: b  reason: collision with root package name */
        final int f17784b;

        a(Bitmap bitmap, int i10) {
            this.f17783a = bitmap;
            this.f17784b = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapUtils.java */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f17785a;

        /* renamed from: b  reason: collision with root package name */
        final int f17786b;

        b(Bitmap bitmap, int i10) {
            this.f17785a = bitmap;
            this.f17786b = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b A(Bitmap bitmap, Context context, Uri uri) {
        androidx.exifinterface.media.a aVar = null;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream != null) {
                androidx.exifinterface.media.a aVar2 = new androidx.exifinterface.media.a(openInputStream);
                try {
                    openInputStream.close();
                } catch (Exception unused) {
                }
                aVar = aVar2;
            }
        } catch (Exception unused2) {
        }
        return aVar != null ? B(bitmap, aVar) : new b(bitmap, 0);
    }

    static b B(Bitmap bitmap, androidx.exifinterface.media.a aVar) {
        int c10 = aVar.c("Orientation", 1);
        return new b(bitmap, c10 != 3 ? c10 != 6 ? c10 != 8 ? 0 : 270 : 90 : CameraConfig.CAMERA_THIRD_DEGREE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void C(Context context, Bitmap bitmap, Uri uri, Bitmap.CompressFormat compressFormat, int i10) throws FileNotFoundException {
        OutputStream outputStream = null;
        try {
            outputStream = context.getContentResolver().openOutputStream(uri);
            bitmap.compress(compressFormat, i10, outputStream);
        } finally {
            c(outputStream);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri D(Context context, Bitmap bitmap, Uri uri) {
        boolean z10 = true;
        try {
            if (uri == null) {
                uri = Uri.fromFile(File.createTempFile("aic_state_store_temp", ".jpg", context.getCacheDir()));
            } else if (new File(uri.getPath()).exists()) {
                z10 = false;
            }
            if (z10) {
                C(context, bitmap, uri, Bitmap.CompressFormat.JPEG, 95);
            }
            return uri;
        } catch (Exception e10) {
            k.r("AIC", "Failed to write bitmap to temp file for image-cropper save instance state", e10, new Object[0]);
            return null;
        }
    }

    private static int a(int i10, int i11) {
        if (f17781f == 0) {
            f17781f = o();
        }
        int i12 = 1;
        if (f17781f > 0) {
            while (true) {
                int i13 = i11 / i12;
                int i14 = f17781f;
                if (i13 <= i14 && i10 / i12 <= i14) {
                    break;
                }
                i12 *= 2;
            }
        }
        return i12;
    }

    private static int b(int i10, int i11, int i12, int i13) {
        int i14 = 1;
        if (i11 > i13 || i10 > i12) {
            while ((i11 / 2) / i14 > i13 && (i10 / 2) / i14 > i12) {
                i14 *= 2;
            }
        }
        return i14;
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a d(Context context, Uri uri, float[] fArr, int i10, int i11, int i12, boolean z10, int i13, int i14, int i15, int i16, boolean z11, boolean z12) {
        int i17 = 1;
        do {
            try {
                return e(context, uri, fArr, i10, i11, i12, z10, i13, i14, i15, i16, z11, z12, i17);
            } catch (OutOfMemoryError e10) {
                i17 *= 2;
                if (i17 > 16) {
                    throw new RuntimeException("Failed to handle OOM by sampling (" + i17 + "): " + uri + "\r\n" + e10.getMessage(), e10);
                }
            }
        } while (i17 > 16);
        throw new RuntimeException("Failed to handle OOM by sampling (" + i17 + "): " + uri + "\r\n" + e10.getMessage(), e10);
    }

    private static a e(Context context, Uri uri, float[] fArr, int i10, int i11, int i12, boolean z10, int i13, int i14, int i15, int i16, boolean z11, boolean z12, int i17) {
        OutOfMemoryError e10;
        Bitmap bitmap;
        Rect s10 = s(fArr, i11, i12, z10, i13, i14);
        int width = i15 > 0 ? i15 : s10.width();
        int height = i16 > 0 ? i16 : s10.height();
        Bitmap bitmap2 = null;
        int i18 = 1;
        try {
            a m10 = m(context, uri, s10, width, height, i17);
            bitmap2 = m10.f17783a;
            i18 = m10.f17784b;
        } catch (Exception unused) {
        }
        if (bitmap2 == null) {
            return f(context, uri, fArr, i10, z10, i13, i14, i17, s10, width, height, z11, z12);
        }
        try {
            Bitmap z13 = z(bitmap2, i10, z11, z12);
            try {
                if (i10 % 90 != 0) {
                    z13 = i(z13, fArr, s10, i10, z10, i13, i14);
                }
                return new a(z13, i18);
            } catch (OutOfMemoryError e11) {
                e10 = e11;
                bitmap2 = bitmap;
                if (bitmap2 != null) {
                    bitmap2.recycle();
                }
                throw e10;
            }
        } catch (OutOfMemoryError e12) {
            e10 = e12;
        }
    }

    /* JADX WARN: Finally extract failed */
    private static a f(Context context, Uri uri, float[] fArr, int i10, boolean z10, int i11, int i12, int i13, Rect rect, int i14, int i15, boolean z11, boolean z12) {
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int b10 = b(rect.width(), rect.height(), i14, i15) * i13;
            options.inSampleSize = b10;
            Bitmap j10 = j(context.getContentResolver(), uri, options);
            if (j10 != null) {
                try {
                    int length = fArr.length;
                    float[] fArr2 = new float[length];
                    System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                    for (int i16 = 0; i16 < length; i16++) {
                        fArr2[i16] = fArr2[i16] / options.inSampleSize;
                    }
                    bitmap = h(j10, fArr2, i10, z10, i11, i12, 1.0f, z11, z12);
                    if (bitmap != j10) {
                        j10.recycle();
                    }
                } catch (Throwable th2) {
                    j10.recycle();
                    throw th2;
                }
            }
            return new a(bitmap, b10);
        } catch (Exception e10) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e10.getMessage(), e10);
        } catch (OutOfMemoryError e11) {
            if (0 != 0) {
                bitmap.recycle();
            }
            throw e11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a g(Bitmap bitmap, float[] fArr, int i10, boolean z10, int i11, int i12, boolean z11, boolean z12) {
        int i13 = 1;
        do {
            try {
                return new a(h(bitmap, fArr, i10, z10, i11, i12, 1.0f / i13, z11, z12), i13);
            } catch (OutOfMemoryError e10) {
                i13 *= 2;
                if (i13 > 8) {
                    throw e10;
                }
            }
        } while (i13 > 8);
        throw e10;
    }

    private static Bitmap h(Bitmap bitmap, float[] fArr, int i10, boolean z10, int i11, int i12, float f10, boolean z11, boolean z12) {
        float f11 = f10;
        Rect s10 = s(fArr, bitmap.getWidth(), bitmap.getHeight(), z10, i11, i12);
        Matrix matrix = new Matrix();
        matrix.setRotate(i10, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
        float f12 = z11 ? -f11 : f11;
        if (z12) {
            f11 = -f11;
        }
        matrix.postScale(f12, f11);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, s10.left, s10.top, s10.width(), s10.height(), matrix, true);
        if (createBitmap == bitmap) {
            createBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        return i10 % 90 != 0 ? i(createBitmap, fArr, s10, i10, z10, i11, i12) : createBitmap;
    }

    private static Bitmap i(Bitmap bitmap, float[] fArr, Rect rect, int i10, boolean z10, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        int i16;
        if (i10 % 90 == 0) {
            return bitmap;
        }
        double radians = Math.toRadians(i10);
        if (i10 < 90 || (i10 > 180 && i10 < 270)) {
            i13 = rect.left;
        } else {
            i13 = rect.right;
        }
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i18 < fArr.length) {
                if (fArr[i18] >= i13 - 1 && fArr[i18] <= i13 + 1) {
                    int i19 = i18 + 1;
                    i17 = (int) Math.abs(Math.sin(radians) * (rect.bottom - fArr[i19]));
                    i15 = (int) Math.abs(Math.cos(radians) * (fArr[i19] - rect.top));
                    i16 = (int) Math.abs((fArr[i19] - rect.top) / Math.sin(radians));
                    i14 = (int) Math.abs((rect.bottom - fArr[i19]) / Math.cos(radians));
                    break;
                }
                i18 += 2;
            } else {
                i14 = 0;
                i15 = 0;
                i16 = 0;
                break;
            }
        }
        rect.set(i17, i15, i16 + i17, i14 + i15);
        if (z10) {
            n(rect, i11, i12);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX WARN: Finally extract failed */
    private static Bitmap j(ContentResolver contentResolver, Uri uri, BitmapFactory.Options options) throws FileNotFoundException {
        do {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = contentResolver.openInputStream(uri);
                    Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, f17776a, options);
                    c(inputStream);
                    return decodeStream;
                } catch (OutOfMemoryError unused) {
                    options.inSampleSize *= 2;
                    c(inputStream);
                    if (options.inSampleSize > 512) {
                        throw new RuntimeException("Failed to decode image: " + uri);
                    }
                }
            } catch (Throwable th2) {
                c(inputStream);
                throw th2;
            }
        } while (options.inSampleSize > 512);
        throw new RuntimeException("Failed to decode image: " + uri);
    }

    private static BitmapFactory.Options k(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        Throwable th2;
        InputStream inputStream;
        try {
            inputStream = contentResolver.openInputStream(uri);
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, f17776a, options);
                options.inJustDecodeBounds = false;
                c(inputStream);
                return options;
            } catch (Throwable th3) {
                th2 = th3;
                c(inputStream);
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            inputStream = null;
        }
    }

    public static a l(Context context, Uri uri, int i10, int i11) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            BitmapFactory.Options k10 = k(contentResolver, uri);
            int i12 = k10.outWidth;
            if (i12 == -1 && k10.outHeight == -1) {
                throw new RuntimeException("File is not a picture");
            }
            k10.inSampleSize = Math.max(b(i12, k10.outHeight, i10, i11), a(k10.outWidth, k10.outHeight));
            return new a(j(contentResolver, uri, k10), k10.inSampleSize);
        } catch (Exception e10) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e10.getMessage(), e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a m(Context context, Uri uri, Rect rect, int i10, int i11, int i12) {
        BitmapRegionDecoder bitmapRegionDecoder;
        Exception e10;
        int i13;
        InputStream inputStream = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = i12 * b(rect.width(), rect.height(), i10, i11);
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                bitmapRegionDecoder = BitmapRegionDecoder.newInstance(openInputStream, false);
                do {
                    try {
                        try {
                            a aVar = new a(bitmapRegionDecoder.decodeRegion(rect, options), options.inSampleSize);
                            c(openInputStream);
                            bitmapRegionDecoder.recycle();
                            return aVar;
                        } catch (OutOfMemoryError unused) {
                            i13 = options.inSampleSize * 2;
                            options.inSampleSize = i13;
                            if (i13 > 512) {
                                c(openInputStream);
                                if (bitmapRegionDecoder != null) {
                                }
                                return new a(null, 1);
                            }
                        }
                    } catch (Exception e11) {
                        e10 = e11;
                        inputStream = openInputStream;
                        try {
                            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e10.getMessage(), e10);
                        } catch (Throwable th2) {
                            th = th2;
                            c(inputStream);
                            if (bitmapRegionDecoder != null) {
                                bitmapRegionDecoder.recycle();
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = openInputStream;
                        c(inputStream);
                        if (bitmapRegionDecoder != null) {
                        }
                        throw th;
                    }
                } while (i13 > 512);
                c(openInputStream);
                if (bitmapRegionDecoder != null) {
                    bitmapRegionDecoder.recycle();
                }
                return new a(null, 1);
            } catch (Exception e12) {
                e10 = e12;
                bitmapRegionDecoder = null;
            } catch (Throwable th4) {
                th = th4;
                bitmapRegionDecoder = null;
            }
        } catch (Exception e13) {
            e10 = e13;
            bitmapRegionDecoder = null;
        } catch (Throwable th5) {
            th = th5;
            bitmapRegionDecoder = null;
        }
    }

    private static void n(Rect rect, int i10, int i11) {
        if (i10 == i11 && rect.width() != rect.height()) {
            if (rect.height() > rect.width()) {
                rect.bottom -= rect.height() - rect.width();
            } else {
                rect.right -= rect.width() - rect.height();
            }
        }
    }

    private static int o() {
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
            egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, iArr[0], iArr);
            int[] iArr2 = new int[1];
            int i10 = 0;
            for (int i11 = 0; i11 < iArr[0]; i11++) {
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i11], 12332, iArr2);
                if (i10 < iArr2[0]) {
                    i10 = iArr2[0];
                }
            }
            egl10.eglTerminate(eglGetDisplay);
            return Math.max(i10, 2048);
        } catch (Exception unused) {
            return 2048;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float p(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float q(float[] fArr) {
        return (v(fArr) + u(fArr)) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float r(float[] fArr) {
        return (p(fArr) + w(fArr)) / 2.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Rect s(float[] fArr, int i10, int i11, boolean z10, int i12, int i13) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, u(fArr))), Math.round(Math.max(0.0f, w(fArr))), Math.round(Math.min(i10, v(fArr))), Math.round(Math.min(i11, p(fArr))));
        if (z10) {
            n(rect, i12, i13);
        }
        return rect;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float t(float[] fArr) {
        return p(fArr) - w(fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float u(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float v(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float w(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float x(float[] fArr) {
        return v(fArr) - u(fArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bitmap y(Bitmap bitmap, int i10, int i11, CropImageView.RequestSizeOptions requestSizeOptions) {
        if (i10 > 0 && i11 > 0) {
            try {
                CropImageView.RequestSizeOptions requestSizeOptions2 = CropImageView.RequestSizeOptions.RESIZE_FIT;
                if (requestSizeOptions == requestSizeOptions2 || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_INSIDE || requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                    Bitmap bitmap2 = null;
                    if (requestSizeOptions == CropImageView.RequestSizeOptions.RESIZE_EXACT) {
                        bitmap2 = Bitmap.createScaledBitmap(bitmap, i10, i11, false);
                    } else {
                        float width = bitmap.getWidth();
                        float height = bitmap.getHeight();
                        float max = Math.max(width / i10, height / i11);
                        if (max > 1.0f || requestSizeOptions == requestSizeOptions2) {
                            bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (width / max), (int) (height / max), false);
                        }
                    }
                    if (bitmap2 != null) {
                        if (bitmap2 != bitmap) {
                            bitmap.recycle();
                        }
                        return bitmap2;
                    }
                }
            } catch (Exception e10) {
                k.r("AIC", "Failed to resize cropped image, return bitmap before resize", e10, new Object[0]);
            }
        }
        return bitmap;
    }

    private static Bitmap z(Bitmap bitmap, int i10, boolean z10, boolean z11) {
        if (i10 <= 0 && !z10 && !z11) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate(i10);
        float f10 = -1.0f;
        float f11 = z10 ? -1.0f : 1.0f;
        if (!z11) {
            f10 = 1.0f;
        }
        matrix.postScale(f11, f10);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }
}
