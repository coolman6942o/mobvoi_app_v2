package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.theartofdev.edmodo.cropper.CropOverlayView;
import com.theartofdev.edmodo.cropper.a;
import com.theartofdev.edmodo.cropper.b;
import java.lang.ref.WeakReference;
import java.util.UUID;
/* loaded from: classes2.dex */
public class CropImageView extends FrameLayout {
    private c A;
    private Uri B;
    private float E;
    private float F;
    private RectF G;
    private int H;
    private boolean I;
    private Uri J;
    private WeakReference<com.theartofdev.edmodo.cropper.b> K;
    private WeakReference<com.theartofdev.edmodo.cropper.a> L;

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f23087a;

    /* renamed from: b  reason: collision with root package name */
    private final CropOverlayView f23088b;

    /* renamed from: e  reason: collision with root package name */
    private final ProgressBar f23091e;

    /* renamed from: h  reason: collision with root package name */
    private com.theartofdev.edmodo.cropper.d f23094h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f23095i;

    /* renamed from: j  reason: collision with root package name */
    private int f23096j;

    /* renamed from: k  reason: collision with root package name */
    private int f23097k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f23098l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f23099m;

    /* renamed from: n  reason: collision with root package name */
    private int f23100n;

    /* renamed from: o  reason: collision with root package name */
    private int f23101o;

    /* renamed from: p  reason: collision with root package name */
    private int f23102p;

    /* renamed from: q  reason: collision with root package name */
    private ScaleType f23103q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f23104r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f23105s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f23106t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f23107u;

    /* renamed from: v  reason: collision with root package name */
    private int f23108v;

    /* renamed from: w  reason: collision with root package name */
    private e f23109w;

    /* renamed from: x  reason: collision with root package name */
    private d f23110x;

    /* renamed from: y  reason: collision with root package name */
    private f f23111y;

    /* renamed from: z  reason: collision with root package name */
    private g f23112z;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f23089c = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f23090d = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private final float[] f23092f = new float[8];

    /* renamed from: g  reason: collision with root package name */
    private final float[] f23093g = new float[8];
    private int C = 1;
    private float D = 1.0f;

    /* loaded from: classes2.dex */
    public enum CropShape {
        RECTANGLE,
        OVAL
    }

    /* loaded from: classes2.dex */
    public enum Guidelines {
        OFF,
        ON_TOUCH,
        ON
    }

    /* loaded from: classes2.dex */
    public enum RequestSizeOptions {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    /* loaded from: classes2.dex */
    public enum ScaleType {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    /* loaded from: classes2.dex */
    class a implements CropOverlayView.b {
        a() {
        }

        @Override // com.theartofdev.edmodo.cropper.CropOverlayView.b
        public void a(boolean z10) {
            CropImageView.this.k(z10, true);
            e eVar = CropImageView.this.f23109w;
            if (eVar != null && !z10) {
                eVar.a(CropImageView.this.getCropRect());
            }
            d dVar = CropImageView.this.f23110x;
            if (dVar != null && z10) {
                dVar.a(CropImageView.this.getCropRect());
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f23114a;

        /* renamed from: b  reason: collision with root package name */
        private final Uri f23115b;

        /* renamed from: c  reason: collision with root package name */
        private final Exception f23116c;

        /* renamed from: d  reason: collision with root package name */
        private final float[] f23117d;

        /* renamed from: e  reason: collision with root package name */
        private final Rect f23118e;

        /* renamed from: f  reason: collision with root package name */
        private final Rect f23119f;

        /* renamed from: g  reason: collision with root package name */
        private final int f23120g;

        /* renamed from: h  reason: collision with root package name */
        private final int f23121h;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i10, int i11) {
            this.f23114a = uri;
            this.f23115b = uri2;
            this.f23116c = exc;
            this.f23117d = fArr;
            this.f23118e = rect;
            this.f23119f = rect2;
            this.f23120g = i10;
            this.f23121h = i11;
        }

        public float[] a() {
            return this.f23117d;
        }

        public Rect b() {
            return this.f23118e;
        }

        public Exception c() {
            return this.f23116c;
        }

        public Uri d() {
            return this.f23114a;
        }

        public int e() {
            return this.f23120g;
        }

        public int f() {
            return this.f23121h;
        }

        public Uri g() {
            return this.f23115b;
        }

        public Rect h() {
            return this.f23119f;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void q(CropImageView cropImageView, b bVar);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(Rect rect);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(Rect rect);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface g {
        void o(CropImageView cropImageView, Uri uri, Exception exc);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Bundle bundleExtra;
        this.f23104r = false;
        this.f23105s = true;
        this.f23106t = true;
        this.f23107u = true;
        CropImageOptions cropImageOptions = null;
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        if (!(intent == null || (bundleExtra = intent.getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE")) == null)) {
            cropImageOptions = (CropImageOptions) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        }
        if (cropImageOptions == null) {
            cropImageOptions = new CropImageOptions();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zm.e.f37637a, 0, 0);
                try {
                    int i10 = zm.e.f37648l;
                    cropImageOptions.f23072l = obtainStyledAttributes.getBoolean(i10, cropImageOptions.f23072l);
                    int i11 = zm.e.f37638b;
                    cropImageOptions.f23073m = obtainStyledAttributes.getInteger(i11, cropImageOptions.f23073m);
                    cropImageOptions.f23074n = obtainStyledAttributes.getInteger(zm.e.f37639c, cropImageOptions.f23074n);
                    cropImageOptions.f23065e = ScaleType.values()[obtainStyledAttributes.getInt(zm.e.A, cropImageOptions.f23065e.ordinal())];
                    cropImageOptions.f23068h = obtainStyledAttributes.getBoolean(zm.e.f37640d, cropImageOptions.f23068h);
                    cropImageOptions.f23069i = obtainStyledAttributes.getBoolean(zm.e.f37661y, cropImageOptions.f23069i);
                    cropImageOptions.f23070j = obtainStyledAttributes.getInteger(zm.e.f37656t, cropImageOptions.f23070j);
                    cropImageOptions.f23061a = CropShape.values()[obtainStyledAttributes.getInt(zm.e.B, cropImageOptions.f23061a.ordinal())];
                    cropImageOptions.f23064d = Guidelines.values()[obtainStyledAttributes.getInt(zm.e.f37650n, cropImageOptions.f23064d.ordinal())];
                    cropImageOptions.f23062b = obtainStyledAttributes.getDimension(zm.e.E, cropImageOptions.f23062b);
                    cropImageOptions.f23063c = obtainStyledAttributes.getDimension(zm.e.F, cropImageOptions.f23063c);
                    cropImageOptions.f23071k = obtainStyledAttributes.getFloat(zm.e.f37653q, cropImageOptions.f23071k);
                    cropImageOptions.f23075o = obtainStyledAttributes.getDimension(zm.e.f37647k, cropImageOptions.f23075o);
                    cropImageOptions.f23076p = obtainStyledAttributes.getInteger(zm.e.f37646j, cropImageOptions.f23076p);
                    int i12 = zm.e.f37645i;
                    cropImageOptions.f23077q = obtainStyledAttributes.getDimension(i12, cropImageOptions.f23077q);
                    cropImageOptions.f23078r = obtainStyledAttributes.getDimension(zm.e.f37644h, cropImageOptions.f23078r);
                    cropImageOptions.f23079s = obtainStyledAttributes.getDimension(zm.e.f37643g, cropImageOptions.f23079s);
                    cropImageOptions.f23080t = obtainStyledAttributes.getInteger(zm.e.f37642f, cropImageOptions.f23080t);
                    cropImageOptions.f23081u = obtainStyledAttributes.getDimension(zm.e.f37652p, cropImageOptions.f23081u);
                    cropImageOptions.f23082v = obtainStyledAttributes.getInteger(zm.e.f37651o, cropImageOptions.f23082v);
                    cropImageOptions.f23083w = obtainStyledAttributes.getInteger(zm.e.f37641e, cropImageOptions.f23083w);
                    cropImageOptions.f23066f = obtainStyledAttributes.getBoolean(zm.e.C, this.f23105s);
                    cropImageOptions.f23067g = obtainStyledAttributes.getBoolean(zm.e.D, this.f23106t);
                    cropImageOptions.f23077q = obtainStyledAttributes.getDimension(i12, cropImageOptions.f23077q);
                    cropImageOptions.f23084x = (int) obtainStyledAttributes.getDimension(zm.e.f37660x, cropImageOptions.f23084x);
                    cropImageOptions.f23085y = (int) obtainStyledAttributes.getDimension(zm.e.f37659w, cropImageOptions.f23085y);
                    cropImageOptions.f23086z = (int) obtainStyledAttributes.getFloat(zm.e.f37658v, cropImageOptions.f23086z);
                    cropImageOptions.A = (int) obtainStyledAttributes.getFloat(zm.e.f37657u, cropImageOptions.A);
                    cropImageOptions.B = (int) obtainStyledAttributes.getFloat(zm.e.f37655s, cropImageOptions.B);
                    cropImageOptions.C = (int) obtainStyledAttributes.getFloat(zm.e.f37654r, cropImageOptions.C);
                    int i13 = zm.e.f37649m;
                    cropImageOptions.S = obtainStyledAttributes.getBoolean(i13, cropImageOptions.S);
                    cropImageOptions.T = obtainStyledAttributes.getBoolean(i13, cropImageOptions.T);
                    this.f23104r = obtainStyledAttributes.getBoolean(zm.e.f37662z, this.f23104r);
                    if (obtainStyledAttributes.hasValue(i11) && obtainStyledAttributes.hasValue(i11) && !obtainStyledAttributes.hasValue(i10)) {
                        cropImageOptions.f23072l = true;
                    }
                } finally {
                    obtainStyledAttributes.recycle();
                }
            }
        }
        cropImageOptions.a();
        this.f23103q = cropImageOptions.f23065e;
        this.f23107u = cropImageOptions.f23068h;
        this.f23108v = cropImageOptions.f23070j;
        this.f23105s = cropImageOptions.f23066f;
        this.f23106t = cropImageOptions.f23067g;
        this.f23098l = cropImageOptions.S;
        this.f23099m = cropImageOptions.T;
        View inflate = LayoutInflater.from(context).inflate(zm.b.b_res_0x7f0e007c, (ViewGroup) this, true);
        ImageView imageView = (ImageView) inflate.findViewById(zm.a.f37635c);
        this.f23087a = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) inflate.findViewById(zm.a.f37633a);
        this.f23088b = cropOverlayView;
        cropOverlayView.setCropWindowChangeListener(new a());
        cropOverlayView.setInitialAttributeValues(cropImageOptions);
        this.f23091e = (ProgressBar) inflate.findViewById(zm.a.f37634b);
        s();
    }

    private void d(float f10, float f11, boolean z10, boolean z11) {
        if (this.f23095i != null) {
            float f12 = 0.0f;
            if (f10 > 0.0f && f11 > 0.0f) {
                this.f23089c.invert(this.f23090d);
                RectF cropWindowRect = this.f23088b.getCropWindowRect();
                this.f23090d.mapRect(cropWindowRect);
                this.f23089c.reset();
                this.f23089c.postTranslate((f10 - this.f23095i.getWidth()) / 2.0f, (f11 - this.f23095i.getHeight()) / 2.0f);
                l();
                int i10 = this.f23097k;
                if (i10 > 0) {
                    this.f23089c.postRotate(i10, com.theartofdev.edmodo.cropper.c.q(this.f23092f), com.theartofdev.edmodo.cropper.c.r(this.f23092f));
                    l();
                }
                float min = Math.min(f10 / com.theartofdev.edmodo.cropper.c.x(this.f23092f), f11 / com.theartofdev.edmodo.cropper.c.t(this.f23092f));
                ScaleType scaleType = this.f23103q;
                if (scaleType == ScaleType.FIT_CENTER || ((scaleType == ScaleType.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.f23107u))) {
                    this.f23089c.postScale(min, min, com.theartofdev.edmodo.cropper.c.q(this.f23092f), com.theartofdev.edmodo.cropper.c.r(this.f23092f));
                    l();
                }
                float f13 = this.f23098l ? -this.D : this.D;
                float f14 = this.f23099m ? -this.D : this.D;
                this.f23089c.postScale(f13, f14, com.theartofdev.edmodo.cropper.c.q(this.f23092f), com.theartofdev.edmodo.cropper.c.r(this.f23092f));
                l();
                this.f23089c.mapRect(cropWindowRect);
                if (z10) {
                    this.E = f10 > com.theartofdev.edmodo.cropper.c.x(this.f23092f) ? 0.0f : Math.max(Math.min((f10 / 2.0f) - cropWindowRect.centerX(), -com.theartofdev.edmodo.cropper.c.u(this.f23092f)), getWidth() - com.theartofdev.edmodo.cropper.c.v(this.f23092f)) / f13;
                    if (f11 <= com.theartofdev.edmodo.cropper.c.t(this.f23092f)) {
                        f12 = Math.max(Math.min((f11 / 2.0f) - cropWindowRect.centerY(), -com.theartofdev.edmodo.cropper.c.w(this.f23092f)), getHeight() - com.theartofdev.edmodo.cropper.c.p(this.f23092f)) / f14;
                    }
                    this.F = f12;
                } else {
                    this.E = Math.min(Math.max(this.E * f13, -cropWindowRect.left), (-cropWindowRect.right) + f10) / f13;
                    this.F = Math.min(Math.max(this.F * f14, -cropWindowRect.top), (-cropWindowRect.bottom) + f11) / f14;
                }
                this.f23089c.postTranslate(this.E * f13, this.F * f14);
                cropWindowRect.offset(this.E * f13, this.F * f14);
                this.f23088b.setCropWindowRect(cropWindowRect);
                l();
                this.f23088b.invalidate();
                if (z11) {
                    this.f23094h.a(this.f23092f, this.f23089c);
                    this.f23087a.startAnimation(this.f23094h);
                } else {
                    this.f23087a.setImageMatrix(this.f23089c);
                }
                u(false);
            }
        }
    }

    private void e() {
        Bitmap bitmap = this.f23095i;
        if (bitmap != null && (this.f23102p > 0 || this.B != null)) {
            bitmap.recycle();
        }
        this.f23095i = null;
        this.f23102p = 0;
        this.B = null;
        this.C = 1;
        this.f23097k = 0;
        this.D = 1.0f;
        this.E = 0.0f;
        this.F = 0.0f;
        this.f23089c.reset();
        this.J = null;
        this.f23087a.setImageBitmap(null);
        r();
    }

    private static int j(int i10, int i11, int i12) {
        return i10 == 1073741824 ? i11 : i10 == Integer.MIN_VALUE ? Math.min(i12, i11) : i12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void k(boolean z10, boolean z11) {
        float f10;
        int width = getWidth();
        int height = getHeight();
        if (this.f23095i != null && width > 0 && height > 0) {
            RectF cropWindowRect = this.f23088b.getCropWindowRect();
            if (!z10) {
                float f11 = 1.0f;
                if (this.f23107u || this.D > 1.0f) {
                    if (this.D < this.f23108v) {
                        float f12 = width;
                        if (cropWindowRect.width() < f12 * 0.5f) {
                            float f13 = height;
                            if (cropWindowRect.height() < 0.5f * f13) {
                                f10 = Math.min(this.f23108v, Math.min(f12 / ((cropWindowRect.width() / this.D) / 0.64f), f13 / ((cropWindowRect.height() / this.D) / 0.64f)));
                                if (this.D > 1.0f) {
                                    float f14 = width;
                                    if (cropWindowRect.width() > f14 * 0.65f || cropWindowRect.height() > height * 0.65f) {
                                        f10 = Math.max(1.0f, Math.min(f14 / ((cropWindowRect.width() / this.D) / 0.51f), height / ((cropWindowRect.height() / this.D) / 0.51f)));
                                    }
                                }
                                if (this.f23107u) {
                                    f11 = f10;
                                }
                                if (f11 > 0.0f && f11 != this.D) {
                                    if (z11) {
                                        if (this.f23094h == null) {
                                            this.f23094h = new com.theartofdev.edmodo.cropper.d(this.f23087a, this.f23088b);
                                        }
                                        this.f23094h.b(this.f23092f, this.f23089c);
                                    }
                                    this.D = f11;
                                    d(width, height, true, z11);
                                }
                            }
                        }
                    }
                    f10 = 0.0f;
                    if (this.D > 1.0f) {
                    }
                    if (this.f23107u) {
                    }
                    if (f11 > 0.0f) {
                        if (z11) {
                        }
                        this.D = f11;
                        d(width, height, true, z11);
                    }
                }
            } else if (cropWindowRect.left < 0.0f || cropWindowRect.top < 0.0f || cropWindowRect.right > width || cropWindowRect.bottom > height) {
                d(width, height, false, false);
            }
            f fVar = this.f23111y;
            if (fVar != null && !z10) {
                fVar.a();
            }
        }
    }

    private void l() {
        float[] fArr = this.f23092f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = this.f23095i.getWidth();
        float[] fArr2 = this.f23092f;
        fArr2[3] = 0.0f;
        fArr2[4] = this.f23095i.getWidth();
        this.f23092f[5] = this.f23095i.getHeight();
        float[] fArr3 = this.f23092f;
        fArr3[6] = 0.0f;
        fArr3[7] = this.f23095i.getHeight();
        this.f23089c.mapPoints(this.f23092f);
        float[] fArr4 = this.f23093g;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        fArr4[2] = 100.0f;
        fArr4[3] = 0.0f;
        fArr4[4] = 100.0f;
        fArr4[5] = 100.0f;
        fArr4[6] = 0.0f;
        fArr4[7] = 100.0f;
        this.f23089c.mapPoints(fArr4);
    }

    private void q(Bitmap bitmap, int i10, Uri uri, int i11, int i12) {
        Bitmap bitmap2 = this.f23095i;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.f23087a.clearAnimation();
            e();
            this.f23095i = bitmap;
            this.f23087a.setImageBitmap(bitmap);
            this.B = uri;
            this.f23102p = i10;
            this.C = i11;
            this.f23097k = i12;
            d(getWidth(), getHeight(), true, false);
            CropOverlayView cropOverlayView = this.f23088b;
            if (cropOverlayView != null) {
                cropOverlayView.r();
                r();
            }
        }
    }

    private void r() {
        CropOverlayView cropOverlayView = this.f23088b;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.f23105s || this.f23095i == null) ? 4 : 0);
        }
    }

    private void s() {
        int i10 = 0;
        boolean z10 = this.f23106t && ((this.f23095i == null && this.K != null) || this.L != null);
        ProgressBar progressBar = this.f23091e;
        if (!z10) {
            i10 = 4;
        }
        progressBar.setVisibility(i10);
    }

    private void u(boolean z10) {
        if (this.f23095i != null && !z10) {
            this.f23088b.t(getWidth(), getHeight(), (this.C * 100.0f) / com.theartofdev.edmodo.cropper.c.x(this.f23093g), (this.C * 100.0f) / com.theartofdev.edmodo.cropper.c.t(this.f23093g));
        }
        this.f23088b.s(z10 ? null : this.f23092f, getWidth(), getHeight());
    }

    public void f() {
        this.f23098l = !this.f23098l;
        d(getWidth(), getHeight(), true, false);
    }

    public void g() {
        this.f23099m = !this.f23099m;
        d(getWidth(), getHeight(), true, false);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.f23088b.getAspectRatioX()), Integer.valueOf(this.f23088b.getAspectRatioY()));
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.f23088b.getCropWindowRect();
        float[] fArr = new float[8];
        float f10 = cropWindowRect.left;
        fArr[0] = f10;
        float f11 = cropWindowRect.top;
        fArr[1] = f11;
        float f12 = cropWindowRect.right;
        fArr[2] = f12;
        fArr[3] = f11;
        fArr[4] = f12;
        float f13 = cropWindowRect.bottom;
        fArr[5] = f13;
        fArr[6] = f10;
        fArr[7] = f13;
        this.f23089c.invert(this.f23090d);
        this.f23090d.mapPoints(fArr);
        for (int i10 = 0; i10 < 8; i10++) {
            fArr[i10] = fArr[i10] * this.C;
        }
        return fArr;
    }

    public Rect getCropRect() {
        int i10 = this.C;
        Bitmap bitmap = this.f23095i;
        if (bitmap == null) {
            return null;
        }
        return com.theartofdev.edmodo.cropper.c.s(getCropPoints(), bitmap.getWidth() * i10, i10 * bitmap.getHeight(), this.f23088b.m(), this.f23088b.getAspectRatioX(), this.f23088b.getAspectRatioY());
    }

    public CropShape getCropShape() {
        return this.f23088b.getCropShape();
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.f23088b;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public Bitmap getCroppedImage() {
        return h(0, 0, RequestSizeOptions.NONE);
    }

    public void getCroppedImageAsync() {
        i(0, 0, RequestSizeOptions.NONE);
    }

    public Guidelines getGuidelines() {
        return this.f23088b.getGuidelines();
    }

    public int getImageResource() {
        return this.f23102p;
    }

    public Uri getImageUri() {
        return this.B;
    }

    public int getMaxZoom() {
        return this.f23108v;
    }

    public int getRotatedDegrees() {
        return this.f23097k;
    }

    public ScaleType getScaleType() {
        return this.f23103q;
    }

    public Rect getWholeImageRect() {
        int i10 = this.C;
        Bitmap bitmap = this.f23095i;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i10, bitmap.getHeight() * i10);
    }

    public Bitmap h(int i10, int i11, RequestSizeOptions requestSizeOptions) {
        Bitmap bitmap;
        int i12;
        if (this.f23095i == null) {
            return null;
        }
        this.f23087a.clearAnimation();
        RequestSizeOptions requestSizeOptions2 = RequestSizeOptions.NONE;
        int i13 = 0;
        int i14 = requestSizeOptions != requestSizeOptions2 ? i10 : 0;
        if (requestSizeOptions != requestSizeOptions2) {
            i13 = i11;
        }
        if (this.B == null || (this.C <= 1 && requestSizeOptions != RequestSizeOptions.SAMPLING)) {
            i12 = i14;
            bitmap = com.theartofdev.edmodo.cropper.c.g(this.f23095i, getCropPoints(), this.f23097k, this.f23088b.m(), this.f23088b.getAspectRatioX(), this.f23088b.getAspectRatioY(), this.f23098l, this.f23099m).f23196a;
        } else {
            i12 = i14;
            bitmap = com.theartofdev.edmodo.cropper.c.d(getContext(), this.B, getCropPoints(), this.f23097k, this.f23095i.getWidth() * this.C, this.f23095i.getHeight() * this.C, this.f23088b.m(), this.f23088b.getAspectRatioX(), this.f23088b.getAspectRatioY(), i14, i13, this.f23098l, this.f23099m).f23196a;
        }
        return com.theartofdev.edmodo.cropper.c.y(bitmap, i12, i13, requestSizeOptions);
    }

    public void i(int i10, int i11, RequestSizeOptions requestSizeOptions) {
        if (this.A != null) {
            t(i10, i11, requestSizeOptions, null, null, 0);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(a.C0260a aVar) {
        this.L = null;
        s();
        c cVar = this.A;
        if (cVar != null) {
            cVar.q(this, new b(this.f23095i, this.B, aVar.f23175a, aVar.f23176b, aVar.f23177c, getCropPoints(), getCropRect(), getWholeImageRect(), getRotatedDegrees(), aVar.f23178d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(b.a aVar) {
        this.K = null;
        s();
        if (aVar.f23188e == null) {
            int i10 = aVar.f23187d;
            this.f23096j = i10;
            q(aVar.f23185b, 0, aVar.f23184a, aVar.f23186c, i10);
        }
        g gVar = this.f23112z;
        if (gVar != null) {
            gVar.o(this, aVar.f23184a, aVar.f23188e);
        }
    }

    public void o(int i10) {
        int i11;
        if (this.f23095i != null) {
            if (i10 < 0) {
                i11 = (i10 % 360) + 360;
            } else {
                i11 = i10 % 360;
            }
            boolean z10 = !this.f23088b.m() && ((i11 > 45 && i11 < 135) || (i11 > 215 && i11 < 305));
            RectF rectF = com.theartofdev.edmodo.cropper.c.f23191c;
            rectF.set(this.f23088b.getCropWindowRect());
            float height = (z10 ? rectF.height() : rectF.width()) / 2.0f;
            float width = (z10 ? rectF.width() : rectF.height()) / 2.0f;
            if (z10) {
                boolean z11 = this.f23098l;
                this.f23098l = this.f23099m;
                this.f23099m = z11;
            }
            this.f23089c.invert(this.f23090d);
            float[] fArr = com.theartofdev.edmodo.cropper.c.f23192d;
            fArr[0] = rectF.centerX();
            fArr[1] = rectF.centerY();
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 1.0f;
            fArr[5] = 0.0f;
            this.f23090d.mapPoints(fArr);
            this.f23097k = (this.f23097k + i11) % 360;
            d(getWidth(), getHeight(), true, false);
            Matrix matrix = this.f23089c;
            float[] fArr2 = com.theartofdev.edmodo.cropper.c.f23193e;
            matrix.mapPoints(fArr2, fArr);
            float sqrt = (float) (this.D / Math.sqrt(Math.pow(fArr2[4] - fArr2[2], 2.0d) + Math.pow(fArr2[5] - fArr2[3], 2.0d)));
            this.D = sqrt;
            this.D = Math.max(sqrt, 1.0f);
            d(getWidth(), getHeight(), true, false);
            this.f23089c.mapPoints(fArr2, fArr);
            double sqrt2 = Math.sqrt(Math.pow(fArr2[4] - fArr2[2], 2.0d) + Math.pow(fArr2[5] - fArr2[3], 2.0d));
            float f10 = (float) (height * sqrt2);
            float f11 = (float) (width * sqrt2);
            rectF.set(fArr2[0] - f10, fArr2[1] - f11, fArr2[0] + f10, fArr2[1] + f11);
            this.f23088b.r();
            this.f23088b.setCropWindowRect(rectF);
            d(getWidth(), getHeight(), true, false);
            k(false, false);
            this.f23088b.i();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f23100n <= 0 || this.f23101o <= 0) {
            u(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.f23100n;
        layoutParams.height = this.f23101o;
        setLayoutParams(layoutParams);
        if (this.f23095i != null) {
            float f10 = i12 - i10;
            float f11 = i13 - i11;
            d(f10, f11, true, false);
            if (this.G != null) {
                int i14 = this.H;
                if (i14 != this.f23096j) {
                    this.f23097k = i14;
                    d(f10, f11, true, false);
                }
                this.f23089c.mapRect(this.G);
                this.f23088b.setCropWindowRect(this.G);
                k(false, false);
                this.f23088b.i();
                this.G = null;
            } else if (this.I) {
                this.I = false;
                k(false, false);
            }
        } else {
            u(true);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        super.onMeasure(i10, i11);
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size2 = View.MeasureSpec.getSize(i11);
        Bitmap bitmap = this.f23095i;
        if (bitmap != null) {
            if (size2 == 0) {
                size2 = bitmap.getHeight();
            }
            double width = size < this.f23095i.getWidth() ? size / this.f23095i.getWidth() : Double.POSITIVE_INFINITY;
            double height = size2 < this.f23095i.getHeight() ? size2 / this.f23095i.getHeight() : Double.POSITIVE_INFINITY;
            if (width == Double.POSITIVE_INFINITY && height == Double.POSITIVE_INFINITY) {
                i13 = this.f23095i.getWidth();
                i12 = this.f23095i.getHeight();
            } else if (width <= height) {
                i12 = (int) (this.f23095i.getHeight() * width);
                i13 = size;
            } else {
                i13 = (int) (this.f23095i.getWidth() * height);
                i12 = size2;
            }
            int j10 = j(mode, size, i13);
            int j11 = j(mode2, size2, i12);
            this.f23100n = j10;
            this.f23101o = j11;
            setMeasuredDimension(j10, j11);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.K == null && this.B == null && this.f23095i == null && this.f23102p == 0) {
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Pair<String, WeakReference<Bitmap>> pair = com.theartofdev.edmodo.cropper.c.f23195g;
                        Bitmap bitmap = (pair == null || !((String) pair.first).equals(string)) ? null : (Bitmap) ((WeakReference) com.theartofdev.edmodo.cropper.c.f23195g.second).get();
                        com.theartofdev.edmodo.cropper.c.f23195g = null;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            q(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                        }
                    }
                    if (this.B == null) {
                        setImageUriAsync(uri);
                    }
                } else {
                    int i10 = bundle.getInt("LOADED_IMAGE_RESOURCE");
                    if (i10 > 0) {
                        setImageResource(i10);
                    } else {
                        Uri uri2 = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                        if (uri2 != null) {
                            setImageUriAsync(uri2);
                        }
                    }
                }
                int i11 = bundle.getInt("DEGREES_ROTATED");
                this.H = i11;
                this.f23097k = i11;
                Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
                if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                    this.f23088b.setInitialCropWindowRect(rect);
                }
                RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                    this.G = rectF;
                }
                this.f23088b.setCropShape(CropShape.valueOf(bundle.getString("CROP_SHAPE")));
                this.f23107u = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.f23108v = bundle.getInt("CROP_MAX_ZOOM");
                this.f23098l = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.f23099m = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        com.theartofdev.edmodo.cropper.b bVar;
        if (this.B == null && this.f23095i == null && this.f23102p < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.B;
        if (this.f23104r && uri == null && this.f23102p < 1) {
            uri = com.theartofdev.edmodo.cropper.c.D(getContext(), this.f23095i, this.J);
            this.J = uri;
        }
        if (!(uri == null || this.f23095i == null)) {
            String uuid = UUID.randomUUID().toString();
            com.theartofdev.edmodo.cropper.c.f23195g = new Pair<>(uuid, new WeakReference(this.f23095i));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        WeakReference<com.theartofdev.edmodo.cropper.b> weakReference = this.K;
        if (!(weakReference == null || (bVar = weakReference.get()) == null)) {
            bundle.putParcelable("LOADING_IMAGE_URI", bVar.b());
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.f23102p);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.C);
        bundle.putInt("DEGREES_ROTATED", this.f23097k);
        bundle.putParcelable("INITIAL_CROP_RECT", this.f23088b.getInitialCropWindowRect());
        RectF rectF = com.theartofdev.edmodo.cropper.c.f23191c;
        rectF.set(this.f23088b.getCropWindowRect());
        this.f23089c.invert(this.f23090d);
        this.f23090d.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        bundle.putString("CROP_SHAPE", this.f23088b.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.f23107u);
        bundle.putInt("CROP_MAX_ZOOM", this.f23108v);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.f23098l);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.f23099m);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.I = i12 > 0 && i13 > 0;
    }

    public void p(Uri uri, Bitmap.CompressFormat compressFormat, int i10, int i11, int i12, RequestSizeOptions requestSizeOptions) {
        if (this.A != null) {
            t(i11, i12, requestSizeOptions, uri, compressFormat, i10);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public void setAutoZoomEnabled(boolean z10) {
        if (this.f23107u != z10) {
            this.f23107u = z10;
            k(false, false);
            this.f23088b.invalidate();
        }
    }

    public void setCropRect(Rect rect) {
        this.f23088b.setInitialCropWindowRect(rect);
    }

    public void setCropShape(CropShape cropShape) {
        this.f23088b.setCropShape(cropShape);
    }

    public void setFixedAspectRatio(boolean z10) {
        this.f23088b.setFixedAspectRatio(z10);
    }

    public void setFlippedHorizontally(boolean z10) {
        if (this.f23098l != z10) {
            this.f23098l = z10;
            d(getWidth(), getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z10) {
        if (this.f23099m != z10) {
            this.f23099m = z10;
            d(getWidth(), getHeight(), true, false);
        }
    }

    public void setGuidelines(Guidelines guidelines) {
        this.f23088b.setGuidelines(guidelines);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f23088b.setInitialCropWindowRect(null);
        q(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i10) {
        if (i10 != 0) {
            this.f23088b.setInitialCropWindowRect(null);
            q(BitmapFactory.decodeResource(getResources(), i10), i10, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference<com.theartofdev.edmodo.cropper.b> weakReference = this.K;
            com.theartofdev.edmodo.cropper.b bVar = weakReference != null ? weakReference.get() : null;
            if (bVar != null) {
                bVar.cancel(true);
            }
            e();
            this.G = null;
            this.H = 0;
            this.f23088b.setInitialCropWindowRect(null);
            WeakReference<com.theartofdev.edmodo.cropper.b> weakReference2 = new WeakReference<>(new com.theartofdev.edmodo.cropper.b(this, uri));
            this.K = weakReference2;
            weakReference2.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            s();
        }
    }

    public void setMaxZoom(int i10) {
        if (this.f23108v != i10 && i10 > 0) {
            this.f23108v = i10;
            k(false, false);
            this.f23088b.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z10) {
        if (this.f23088b.u(z10)) {
            k(false, false);
            this.f23088b.invalidate();
        }
    }

    public void setOnCropImageCompleteListener(c cVar) {
        this.A = cVar;
    }

    public void setOnCropWindowChangedListener(f fVar) {
        this.f23111y = fVar;
    }

    public void setOnSetCropOverlayMovedListener(d dVar) {
        this.f23110x = dVar;
    }

    public void setOnSetCropOverlayReleasedListener(e eVar) {
        this.f23109w = eVar;
    }

    public void setOnSetImageUriCompleteListener(g gVar) {
        this.f23112z = gVar;
    }

    public void setRotatedDegrees(int i10) {
        int i11 = this.f23097k;
        if (i11 != i10) {
            o(i10 - i11);
        }
    }

    public void setSaveBitmapToInstanceState(boolean z10) {
        this.f23104r = z10;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != this.f23103q) {
            this.f23103q = scaleType;
            this.D = 1.0f;
            this.F = 0.0f;
            this.E = 0.0f;
            this.f23088b.r();
            requestLayout();
        }
    }

    public void setShowCropOverlay(boolean z10) {
        if (this.f23105s != z10) {
            this.f23105s = z10;
            r();
        }
    }

    public void setShowProgressBar(boolean z10) {
        if (this.f23106t != z10) {
            this.f23106t = z10;
            s();
        }
    }

    public void setSnapRadius(float f10) {
        if (f10 >= 0.0f) {
            this.f23088b.setSnapRadius(f10);
        }
    }

    public void t(int i10, int i11, RequestSizeOptions requestSizeOptions, Uri uri, Bitmap.CompressFormat compressFormat, int i12) {
        CropImageView cropImageView;
        Bitmap bitmap = this.f23095i;
        if (bitmap != null) {
            this.f23087a.clearAnimation();
            WeakReference<com.theartofdev.edmodo.cropper.a> weakReference = this.L;
            com.theartofdev.edmodo.cropper.a aVar = weakReference != null ? weakReference.get() : null;
            if (aVar != null) {
                aVar.cancel(true);
            }
            RequestSizeOptions requestSizeOptions2 = RequestSizeOptions.NONE;
            int i13 = requestSizeOptions != requestSizeOptions2 ? i10 : 0;
            int i14 = requestSizeOptions != requestSizeOptions2 ? i11 : 0;
            int width = bitmap.getWidth() * this.C;
            int height = bitmap.getHeight();
            int i15 = this.C;
            int i16 = height * i15;
            if (this.B == null || (i15 <= 1 && requestSizeOptions != RequestSizeOptions.SAMPLING)) {
                cropImageView = this;
                cropImageView.L = new WeakReference<>(new com.theartofdev.edmodo.cropper.a(this, bitmap, getCropPoints(), this.f23097k, this.f23088b.m(), this.f23088b.getAspectRatioX(), this.f23088b.getAspectRatioY(), i13, i14, this.f23098l, this.f23099m, requestSizeOptions, uri, compressFormat, i12));
            } else {
                this.L = new WeakReference<>(new com.theartofdev.edmodo.cropper.a(this, this.B, getCropPoints(), this.f23097k, width, i16, this.f23088b.m(), this.f23088b.getAspectRatioX(), this.f23088b.getAspectRatioY(), i13, i14, this.f23098l, this.f23099m, requestSizeOptions, uri, compressFormat, i12));
                cropImageView = this;
            }
            cropImageView.L.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            s();
        }
    }
}
