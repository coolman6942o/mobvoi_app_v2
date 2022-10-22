package com.mobvoi.companion.view.crop;

import android.content.Context;
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
import com.mobvoi.companion.view.crop.CropImageView;
import com.mobvoi.companion.view.crop.CropOverlayView;
import com.mobvoi.companion.view.crop.a;
import com.mobvoi.companion.view.crop.b;
import java.lang.ref.WeakReference;
import java.util.UUID;
/* loaded from: classes2.dex */
public class CropImageView extends FrameLayout {
    private b A;
    private Uri B;
    private float E;
    private float F;
    private RectF G;
    private int H;
    private boolean I;
    private Uri J;
    private WeakReference<com.mobvoi.companion.view.crop.b> K;
    private WeakReference<com.mobvoi.companion.view.crop.a> L;

    /* renamed from: a  reason: collision with root package name */
    private final ImageView f17682a;

    /* renamed from: b  reason: collision with root package name */
    private final CropOverlayView f17683b;

    /* renamed from: e  reason: collision with root package name */
    private final ProgressBar f17686e;

    /* renamed from: h  reason: collision with root package name */
    private com.mobvoi.companion.view.crop.d f17689h;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f17690i;

    /* renamed from: j  reason: collision with root package name */
    private int f17691j;

    /* renamed from: k  reason: collision with root package name */
    private int f17692k;

    /* renamed from: n  reason: collision with root package name */
    private int f17695n;

    /* renamed from: o  reason: collision with root package name */
    private int f17696o;

    /* renamed from: p  reason: collision with root package name */
    private int f17697p;

    /* renamed from: s  reason: collision with root package name */
    private boolean f17700s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f17701t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f17702u;

    /* renamed from: w  reason: collision with root package name */
    private d f17704w;

    /* renamed from: x  reason: collision with root package name */
    private c f17705x;

    /* renamed from: y  reason: collision with root package name */
    private e f17706y;

    /* renamed from: z  reason: collision with root package name */
    private f f17707z;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f17684c = new Matrix();

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f17685d = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private final float[] f17687f = new float[8];

    /* renamed from: g  reason: collision with root package name */
    private final float[] f17688g = new float[8];

    /* renamed from: r  reason: collision with root package name */
    private boolean f17699r = false;
    private int C = 1;
    private float D = 1.0f;

    /* renamed from: q  reason: collision with root package name */
    private ScaleType f17698q = ScaleType.CENTER_INSIDE;

    /* renamed from: v  reason: collision with root package name */
    private int f17703v = 4;

    /* renamed from: l  reason: collision with root package name */
    private boolean f17693l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f17694m = false;

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
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f17708a;

        /* renamed from: b  reason: collision with root package name */
        private final Exception f17709b;

        a(Bitmap bitmap, Uri uri, Bitmap bitmap2, Uri uri2, Exception exc, float[] fArr, Rect rect, Rect rect2, int i10, int i11) {
            this.f17708a = uri2;
            this.f17709b = exc;
        }

        public Exception a() {
            return this.f17709b;
        }

        public Uri b() {
            return this.f17708a;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onCropImageComplete(CropImageView cropImageView, a aVar);
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(Rect rect);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void a(Rect rect);
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    /* loaded from: classes2.dex */
    public interface f {
        void onSetImageUriComplete(CropImageView cropImageView, Uri uri, Exception exc);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f17700s = true;
        this.f17701t = true;
        this.f17702u = true;
        this.f17702u = true;
        this.f17700s = true;
        this.f17701t = true;
        View inflate = LayoutInflater.from(context).inflate(gc.e.f27358e, (ViewGroup) this, true);
        ImageView imageView = (ImageView) inflate.findViewById(gc.d.f27332c);
        this.f17682a = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        CropOverlayView cropOverlayView = (CropOverlayView) inflate.findViewById(gc.d.f27330a);
        this.f17683b = cropOverlayView;
        cropOverlayView.setCropWindowChangeListener(new CropOverlayView.b() { // from class: be.a
            @Override // com.mobvoi.companion.view.crop.CropOverlayView.b
            public final void a(boolean z10) {
                CropImageView.this.h(z10);
            }
        });
        cropOverlayView.u();
        this.f17686e = (ProgressBar) inflate.findViewById(gc.d.f27331b);
        q();
    }

    private void b(float f10, float f11, boolean z10, boolean z11) {
        if (this.f17690i != null) {
            float f12 = 0.0f;
            if (f10 > 0.0f && f11 > 0.0f) {
                this.f17684c.invert(this.f17685d);
                RectF cropWindowRect = this.f17683b.getCropWindowRect();
                this.f17685d.mapRect(cropWindowRect);
                this.f17684c.reset();
                this.f17684c.postTranslate((f10 - this.f17690i.getWidth()) / 2.0f, (f11 - this.f17690i.getHeight()) / 2.0f);
                i();
                int i10 = this.f17692k;
                if (i10 > 0) {
                    this.f17684c.postRotate(i10, com.mobvoi.companion.view.crop.c.q(this.f17687f), com.mobvoi.companion.view.crop.c.r(this.f17687f));
                    i();
                }
                float min = Math.min(f10 / com.mobvoi.companion.view.crop.c.x(this.f17687f), f11 / com.mobvoi.companion.view.crop.c.t(this.f17687f));
                ScaleType scaleType = this.f17698q;
                if (scaleType == ScaleType.FIT_CENTER || ((scaleType == ScaleType.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.f17702u))) {
                    this.f17684c.postScale(min, min, com.mobvoi.companion.view.crop.c.q(this.f17687f), com.mobvoi.companion.view.crop.c.r(this.f17687f));
                    i();
                }
                float f13 = this.f17693l ? -this.D : this.D;
                float f14 = this.f17694m ? -this.D : this.D;
                this.f17684c.postScale(f13, f14, com.mobvoi.companion.view.crop.c.q(this.f17687f), com.mobvoi.companion.view.crop.c.r(this.f17687f));
                i();
                this.f17684c.mapRect(cropWindowRect);
                if (z10) {
                    this.E = f10 > com.mobvoi.companion.view.crop.c.x(this.f17687f) ? 0.0f : Math.max(Math.min((f10 / 2.0f) - cropWindowRect.centerX(), -com.mobvoi.companion.view.crop.c.u(this.f17687f)), getWidth() - com.mobvoi.companion.view.crop.c.v(this.f17687f)) / f13;
                    if (f11 <= com.mobvoi.companion.view.crop.c.t(this.f17687f)) {
                        f12 = Math.max(Math.min((f11 / 2.0f) - cropWindowRect.centerY(), -com.mobvoi.companion.view.crop.c.w(this.f17687f)), getHeight() - com.mobvoi.companion.view.crop.c.p(this.f17687f)) / f14;
                    }
                    this.F = f12;
                } else {
                    this.E = Math.min(Math.max(this.E * f13, -cropWindowRect.left), (-cropWindowRect.right) + f10) / f13;
                    this.F = Math.min(Math.max(this.F * f14, -cropWindowRect.top), (-cropWindowRect.bottom) + f11) / f14;
                }
                this.f17684c.postTranslate(this.E * f13, this.F * f14);
                cropWindowRect.offset(this.E * f13, this.F * f14);
                this.f17683b.setCropWindowRect(cropWindowRect);
                i();
                this.f17683b.invalidate();
                if (z11) {
                    this.f17689h.a(this.f17687f, this.f17684c);
                    this.f17682a.startAnimation(this.f17689h);
                } else {
                    this.f17682a.setImageMatrix(this.f17684c);
                }
                s(false);
            }
        }
    }

    private void c() {
        Bitmap bitmap = this.f17690i;
        if (bitmap != null && (this.f17697p > 0 || this.B != null)) {
            bitmap.recycle();
        }
        this.f17690i = null;
        this.f17697p = 0;
        this.B = null;
        this.C = 1;
        this.f17692k = 0;
        this.D = 1.0f;
        this.E = 0.0f;
        this.F = 0.0f;
        this.f17684c.reset();
        this.J = null;
        this.f17682a.setImageBitmap(null);
        p();
    }

    private static int f(int i10, int i11, int i12) {
        return i10 == 1073741824 ? i11 : i10 == Integer.MIN_VALUE ? Math.min(i12, i11) : i12;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(boolean z10, boolean z11) {
        float f10;
        int width = getWidth();
        int height = getHeight();
        if (this.f17690i != null && width > 0 && height > 0) {
            RectF cropWindowRect = this.f17683b.getCropWindowRect();
            if (!z10) {
                float f11 = 1.0f;
                if (this.f17702u || this.D > 1.0f) {
                    if (this.D < this.f17703v) {
                        float f12 = width;
                        if (cropWindowRect.width() < f12 * 0.5f) {
                            float f13 = height;
                            if (cropWindowRect.height() < 0.5f * f13) {
                                f10 = Math.min(this.f17703v, Math.min(f12 / ((cropWindowRect.width() / this.D) / 0.64f), f13 / ((cropWindowRect.height() / this.D) / 0.64f)));
                                if (this.D > 1.0f) {
                                    float f14 = width;
                                    if (cropWindowRect.width() > f14 * 0.65f || cropWindowRect.height() > height * 0.65f) {
                                        f10 = Math.max(1.0f, Math.min(f14 / ((cropWindowRect.width() / this.D) / 0.51f), height / ((cropWindowRect.height() / this.D) / 0.51f)));
                                    }
                                }
                                if (this.f17702u) {
                                    f11 = f10;
                                }
                                if (f11 > 0.0f && f11 != this.D) {
                                    if (z11) {
                                        if (this.f17689h == null) {
                                            this.f17689h = new com.mobvoi.companion.view.crop.d(this.f17682a, this.f17683b);
                                        }
                                        this.f17689h.b(this.f17687f, this.f17684c);
                                    }
                                    this.D = f11;
                                    b(width, height, true, z11);
                                }
                            }
                        }
                    }
                    f10 = 0.0f;
                    if (this.D > 1.0f) {
                    }
                    if (this.f17702u) {
                    }
                    if (f11 > 0.0f) {
                        if (z11) {
                        }
                        this.D = f11;
                        b(width, height, true, z11);
                    }
                }
            } else if (cropWindowRect.left < 0.0f || cropWindowRect.top < 0.0f || cropWindowRect.right > width || cropWindowRect.bottom > height) {
                b(width, height, false, false);
            }
            e eVar = this.f17706y;
            if (eVar != null && !z10) {
                eVar.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(boolean z10) {
        g(z10, true);
        d dVar = this.f17704w;
        if (dVar != null && !z10) {
            dVar.a(getCropRect());
        }
        c cVar = this.f17705x;
        if (cVar != null && z10) {
            cVar.a(getCropRect());
        }
    }

    private void i() {
        float[] fArr = this.f17687f;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = this.f17690i.getWidth();
        float[] fArr2 = this.f17687f;
        fArr2[3] = 0.0f;
        fArr2[4] = this.f17690i.getWidth();
        this.f17687f[5] = this.f17690i.getHeight();
        float[] fArr3 = this.f17687f;
        fArr3[6] = 0.0f;
        fArr3[7] = this.f17690i.getHeight();
        this.f17684c.mapPoints(this.f17687f);
        float[] fArr4 = this.f17688g;
        fArr4[0] = 0.0f;
        fArr4[1] = 0.0f;
        fArr4[2] = 100.0f;
        fArr4[3] = 0.0f;
        fArr4[4] = 100.0f;
        fArr4[5] = 100.0f;
        fArr4[6] = 0.0f;
        fArr4[7] = 100.0f;
        this.f17684c.mapPoints(fArr4);
    }

    private void o(Bitmap bitmap, int i10, Uri uri, int i11, int i12) {
        Bitmap bitmap2 = this.f17690i;
        if (bitmap2 == null || !bitmap2.equals(bitmap)) {
            this.f17682a.clearAnimation();
            c();
            this.f17690i = bitmap;
            this.f17682a.setImageBitmap(bitmap);
            this.B = uri;
            this.f17697p = i10;
            this.C = i11;
            this.f17692k = i12;
            b(getWidth(), getHeight(), true, false);
            CropOverlayView cropOverlayView = this.f17683b;
            if (cropOverlayView != null) {
                cropOverlayView.r();
                p();
            }
        }
    }

    private void p() {
        CropOverlayView cropOverlayView = this.f17683b;
        if (cropOverlayView != null) {
            cropOverlayView.setVisibility((!this.f17700s || this.f17690i == null) ? 4 : 0);
        }
    }

    private void q() {
        int i10 = 0;
        boolean z10 = this.f17701t && ((this.f17690i == null && this.K != null) || this.L != null);
        ProgressBar progressBar = this.f17686e;
        if (!z10) {
            i10 = 4;
        }
        progressBar.setVisibility(i10);
    }

    private void s(boolean z10) {
        if (this.f17690i != null && !z10) {
            this.f17683b.t(getWidth(), getHeight(), (this.C * 100.0f) / com.mobvoi.companion.view.crop.c.x(this.f17688g), (this.C * 100.0f) / com.mobvoi.companion.view.crop.c.t(this.f17688g));
        }
        this.f17683b.s(z10 ? null : this.f17687f, getWidth(), getHeight());
    }

    public Bitmap d(int i10, int i11, RequestSizeOptions requestSizeOptions) {
        Bitmap bitmap;
        int i12;
        if (this.f17690i == null) {
            return null;
        }
        this.f17682a.clearAnimation();
        RequestSizeOptions requestSizeOptions2 = RequestSizeOptions.NONE;
        int i13 = 0;
        int i14 = requestSizeOptions != requestSizeOptions2 ? i10 : 0;
        if (requestSizeOptions != requestSizeOptions2) {
            i13 = i11;
        }
        if (this.B == null || (this.C <= 1 && requestSizeOptions != RequestSizeOptions.SAMPLING)) {
            i12 = i14;
            bitmap = com.mobvoi.companion.view.crop.c.g(this.f17690i, getCropPoints(), this.f17692k, this.f17683b.m(), this.f17683b.getAspectRatioX(), this.f17683b.getAspectRatioY(), this.f17693l, this.f17694m).f17783a;
        } else {
            i12 = i14;
            bitmap = com.mobvoi.companion.view.crop.c.d(getContext(), this.B, getCropPoints(), this.f17692k, this.f17690i.getWidth() * this.C, this.f17690i.getHeight() * this.C, this.f17683b.m(), this.f17683b.getAspectRatioX(), this.f17683b.getAspectRatioY(), i14, i13, this.f17693l, this.f17694m).f17783a;
        }
        return com.mobvoi.companion.view.crop.c.y(bitmap, i12, i13, requestSizeOptions);
    }

    public void e(int i10, int i11, RequestSizeOptions requestSizeOptions) {
        if (this.A != null) {
            r(i10, i11, requestSizeOptions, null, null, 0);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair<>(Integer.valueOf(this.f17683b.getAspectRatioX()), Integer.valueOf(this.f17683b.getAspectRatioY()));
    }

    public float[] getCropPoints() {
        RectF cropWindowRect = this.f17683b.getCropWindowRect();
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
        this.f17684c.invert(this.f17685d);
        this.f17685d.mapPoints(fArr);
        for (int i10 = 0; i10 < 8; i10++) {
            fArr[i10] = fArr[i10] * this.C;
        }
        return fArr;
    }

    public Rect getCropRect() {
        int i10 = this.C;
        Bitmap bitmap = this.f17690i;
        if (bitmap == null) {
            return null;
        }
        return com.mobvoi.companion.view.crop.c.s(getCropPoints(), bitmap.getWidth() * i10, i10 * bitmap.getHeight(), this.f17683b.m(), this.f17683b.getAspectRatioX(), this.f17683b.getAspectRatioY());
    }

    public RectF getCropWindowRect() {
        CropOverlayView cropOverlayView = this.f17683b;
        if (cropOverlayView == null) {
            return null;
        }
        return cropOverlayView.getCropWindowRect();
    }

    public Bitmap getCroppedImage() {
        return d(0, 0, RequestSizeOptions.NONE);
    }

    public void getCroppedImageAsync() {
        e(0, 0, RequestSizeOptions.NONE);
    }

    public int getImageResource() {
        return this.f17697p;
    }

    public Uri getImageUri() {
        return this.B;
    }

    public int getMaxZoom() {
        return this.f17703v;
    }

    public int getRotatedDegrees() {
        return this.f17692k;
    }

    public ScaleType getScaleType() {
        return this.f17698q;
    }

    public Rect getWholeImageRect() {
        int i10 = this.C;
        Bitmap bitmap = this.f17690i;
        if (bitmap == null) {
            return null;
        }
        return new Rect(0, 0, bitmap.getWidth() * i10, bitmap.getHeight() * i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(a.C0211a aVar) {
        this.L = null;
        q();
        b bVar = this.A;
        if (bVar != null) {
            bVar.onCropImageComplete(this, new a(this.f17690i, this.B, aVar.f17762a, aVar.f17763b, aVar.f17764c, getCropPoints(), getCropRect(), getWholeImageRect(), getRotatedDegrees(), aVar.f17765d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(b.a aVar) {
        this.K = null;
        q();
        if (aVar.f17775e == null) {
            int i10 = aVar.f17774d;
            this.f17691j = i10;
            o(aVar.f17772b, 0, aVar.f17771a, aVar.f17773c, i10);
        }
        f fVar = this.f17707z;
        if (fVar != null) {
            fVar.onSetImageUriComplete(this, aVar.f17771a, aVar.f17775e);
        }
    }

    public void l(int i10) {
        int i11;
        if (this.f17690i != null) {
            if (i10 < 0) {
                i11 = (i10 % 360) + 360;
            } else {
                i11 = i10 % 360;
            }
            boolean z10 = !this.f17683b.m() && ((i11 > 45 && i11 < 135) || (i11 > 215 && i11 < 305));
            RectF rectF = com.mobvoi.companion.view.crop.c.f17778c;
            rectF.set(this.f17683b.getCropWindowRect());
            float height = (z10 ? rectF.height() : rectF.width()) / 2.0f;
            float width = (z10 ? rectF.width() : rectF.height()) / 2.0f;
            if (z10) {
                boolean z11 = this.f17693l;
                this.f17693l = this.f17694m;
                this.f17694m = z11;
            }
            this.f17684c.invert(this.f17685d);
            float[] fArr = com.mobvoi.companion.view.crop.c.f17779d;
            fArr[0] = rectF.centerX();
            fArr[1] = rectF.centerY();
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 1.0f;
            fArr[5] = 0.0f;
            this.f17685d.mapPoints(fArr);
            this.f17692k = (this.f17692k + i11) % 360;
            b(getWidth(), getHeight(), true, false);
            Matrix matrix = this.f17684c;
            float[] fArr2 = com.mobvoi.companion.view.crop.c.f17780e;
            matrix.mapPoints(fArr2, fArr);
            float sqrt = (float) (this.D / Math.sqrt(Math.pow(fArr2[4] - fArr2[2], 2.0d) + Math.pow(fArr2[5] - fArr2[3], 2.0d)));
            this.D = sqrt;
            this.D = Math.max(sqrt, 1.0f);
            b(getWidth(), getHeight(), true, false);
            this.f17684c.mapPoints(fArr2, fArr);
            double sqrt2 = Math.sqrt(Math.pow(fArr2[4] - fArr2[2], 2.0d) + Math.pow(fArr2[5] - fArr2[3], 2.0d));
            float f10 = (float) (height * sqrt2);
            float f11 = (float) (width * sqrt2);
            rectF.set(fArr2[0] - f10, fArr2[1] - f11, fArr2[0] + f10, fArr2[1] + f11);
            this.f17683b.r();
            this.f17683b.setCropWindowRect(rectF);
            b(getWidth(), getHeight(), true, false);
            g(false, false);
            this.f17683b.i();
        }
    }

    public void m(Uri uri) {
        n(uri, Bitmap.CompressFormat.JPEG, 90, 0, 0, RequestSizeOptions.NONE);
    }

    public void n(Uri uri, Bitmap.CompressFormat compressFormat, int i10, int i11, int i12, RequestSizeOptions requestSizeOptions) {
        if (this.A != null) {
            r(i11, i12, requestSizeOptions, uri, compressFormat, i10);
            return;
        }
        throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        super.onLayout(z10, i10, i11, i12, i13);
        if (this.f17695n <= 0 || this.f17696o <= 0) {
            s(true);
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.f17695n;
        layoutParams.height = this.f17696o;
        setLayoutParams(layoutParams);
        if (this.f17690i != null) {
            float f10 = i12 - i10;
            float f11 = i13 - i11;
            b(f10, f11, true, false);
            if (this.G != null) {
                int i14 = this.H;
                if (i14 != this.f17691j) {
                    this.f17692k = i14;
                    b(f10, f11, true, false);
                }
                this.f17684c.mapRect(this.G);
                this.f17683b.setCropWindowRect(this.G);
                g(false, false);
                this.f17683b.i();
                this.G = null;
            } else if (this.I) {
                this.I = false;
                g(false, false);
            }
        } else {
            s(true);
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
        Bitmap bitmap = this.f17690i;
        if (bitmap != null) {
            if (size2 == 0) {
                size2 = bitmap.getHeight();
            }
            double width = size < this.f17690i.getWidth() ? size / this.f17690i.getWidth() : Double.POSITIVE_INFINITY;
            double height = size2 < this.f17690i.getHeight() ? size2 / this.f17690i.getHeight() : Double.POSITIVE_INFINITY;
            if (width == Double.POSITIVE_INFINITY && height == Double.POSITIVE_INFINITY) {
                i13 = this.f17690i.getWidth();
                i12 = this.f17690i.getHeight();
            } else if (width <= height) {
                i12 = (int) (this.f17690i.getHeight() * width);
                i13 = size;
            } else {
                i13 = (int) (this.f17690i.getWidth() * height);
                i12 = size2;
            }
            int f10 = f(mode, size, i13);
            int f11 = f(mode2, size2, i12);
            this.f17695n = f10;
            this.f17696o = f11;
            setMeasuredDimension(f10, f11);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.K == null && this.B == null && this.f17690i == null && this.f17697p == 0) {
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Pair<String, WeakReference<Bitmap>> pair = com.mobvoi.companion.view.crop.c.f17782g;
                        Bitmap bitmap = (pair == null || !((String) pair.first).equals(string)) ? null : (Bitmap) ((WeakReference) com.mobvoi.companion.view.crop.c.f17782g.second).get();
                        com.mobvoi.companion.view.crop.c.f17782g = null;
                        if (bitmap != null && !bitmap.isRecycled()) {
                            o(bitmap, 0, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
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
                this.f17692k = i11;
                Rect rect = (Rect) bundle.getParcelable("INITIAL_CROP_RECT");
                if (rect != null && (rect.width() > 0 || rect.height() > 0)) {
                    this.f17683b.setInitialCropWindowRect(rect);
                }
                RectF rectF = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                if (rectF != null && (rectF.width() > 0.0f || rectF.height() > 0.0f)) {
                    this.G = rectF;
                }
                this.f17702u = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.f17703v = bundle.getInt("CROP_MAX_ZOOM");
                this.f17693l = bundle.getBoolean("CROP_FLIP_HORIZONTALLY");
                this.f17694m = bundle.getBoolean("CROP_FLIP_VERTICALLY");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        com.mobvoi.companion.view.crop.b bVar;
        if (this.B == null && this.f17690i == null && this.f17697p < 1) {
            return super.onSaveInstanceState();
        }
        Bundle bundle = new Bundle();
        Uri uri = this.B;
        if (this.f17699r && uri == null && this.f17697p < 1) {
            uri = com.mobvoi.companion.view.crop.c.D(getContext(), this.f17690i, this.J);
            this.J = uri;
        }
        if (!(uri == null || this.f17690i == null)) {
            String uuid = UUID.randomUUID().toString();
            com.mobvoi.companion.view.crop.c.f17782g = new Pair<>(uuid, new WeakReference(this.f17690i));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        WeakReference<com.mobvoi.companion.view.crop.b> weakReference = this.K;
        if (!(weakReference == null || (bVar = weakReference.get()) == null)) {
            bundle.putParcelable("LOADING_IMAGE_URI", bVar.b());
        }
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", uri);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.f17697p);
        bundle.putInt("LOADED_SAMPLE_SIZE", this.C);
        bundle.putInt("DEGREES_ROTATED", this.f17692k);
        bundle.putParcelable("INITIAL_CROP_RECT", this.f17683b.getInitialCropWindowRect());
        RectF rectF = com.mobvoi.companion.view.crop.c.f17778c;
        rectF.set(this.f17683b.getCropWindowRect());
        this.f17684c.invert(this.f17685d);
        this.f17685d.mapRect(rectF);
        bundle.putParcelable("CROP_WINDOW_RECT", rectF);
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.f17702u);
        bundle.putInt("CROP_MAX_ZOOM", this.f17703v);
        bundle.putBoolean("CROP_FLIP_HORIZONTALLY", this.f17693l);
        bundle.putBoolean("CROP_FLIP_VERTICALLY", this.f17694m);
        return bundle;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.I = i12 > 0 && i13 > 0;
    }

    public void r(int i10, int i11, RequestSizeOptions requestSizeOptions, Uri uri, Bitmap.CompressFormat compressFormat, int i12) {
        CropImageView cropImageView;
        Bitmap bitmap = this.f17690i;
        if (bitmap != null) {
            this.f17682a.clearAnimation();
            WeakReference<com.mobvoi.companion.view.crop.a> weakReference = this.L;
            com.mobvoi.companion.view.crop.a aVar = weakReference != null ? weakReference.get() : null;
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
                cropImageView.L = new WeakReference<>(new com.mobvoi.companion.view.crop.a(this, bitmap, getCropPoints(), this.f17692k, this.f17683b.m(), this.f17683b.getAspectRatioX(), this.f17683b.getAspectRatioY(), i13, i14, this.f17693l, this.f17694m, requestSizeOptions, uri, compressFormat, i12));
            } else {
                this.L = new WeakReference<>(new com.mobvoi.companion.view.crop.a(this, this.B, getCropPoints(), this.f17692k, width, i16, this.f17683b.m(), this.f17683b.getAspectRatioX(), this.f17683b.getAspectRatioY(), i13, i14, this.f17693l, this.f17694m, requestSizeOptions, uri, compressFormat, i12));
                cropImageView = this;
            }
            cropImageView.L.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            q();
        }
    }

    public void setAutoZoomEnabled(boolean z10) {
        if (this.f17702u != z10) {
            this.f17702u = z10;
            g(false, false);
            this.f17683b.invalidate();
        }
    }

    public void setCropRect(Rect rect) {
        this.f17683b.setInitialCropWindowRect(rect);
    }

    public void setFixedAspectRatio(boolean z10) {
        this.f17683b.setFixedAspectRatio(z10);
    }

    public void setFlippedHorizontally(boolean z10) {
        if (this.f17693l != z10) {
            this.f17693l = z10;
            b(getWidth(), getHeight(), true, false);
        }
    }

    public void setFlippedVertically(boolean z10) {
        if (this.f17694m != z10) {
            this.f17694m = z10;
            b(getWidth(), getHeight(), true, false);
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f17683b.setInitialCropWindowRect(null);
        o(bitmap, 0, null, 1, 0);
    }

    public void setImageResource(int i10) {
        if (i10 != 0) {
            this.f17683b.setInitialCropWindowRect(null);
            o(BitmapFactory.decodeResource(getResources(), i10), i10, null, 1, 0);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            WeakReference<com.mobvoi.companion.view.crop.b> weakReference = this.K;
            com.mobvoi.companion.view.crop.b bVar = weakReference != null ? weakReference.get() : null;
            if (bVar != null) {
                bVar.cancel(true);
            }
            c();
            this.G = null;
            this.H = 0;
            this.f17683b.setInitialCropWindowRect(null);
            WeakReference<com.mobvoi.companion.view.crop.b> weakReference2 = new WeakReference<>(new com.mobvoi.companion.view.crop.b(this, uri));
            this.K = weakReference2;
            weakReference2.get().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            q();
        }
    }

    public void setMaxZoom(int i10) {
        if (this.f17703v != i10 && i10 > 0) {
            this.f17703v = i10;
            g(false, false);
            this.f17683b.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z10) {
        if (this.f17683b.v(z10)) {
            g(false, false);
            this.f17683b.invalidate();
        }
    }

    public void setOnCropImageCompleteListener(b bVar) {
        this.A = bVar;
    }

    public void setOnCropWindowChangedListener(e eVar) {
        this.f17706y = eVar;
    }

    public void setOnSetCropOverlayMovedListener(c cVar) {
        this.f17705x = cVar;
    }

    public void setOnSetCropOverlayReleasedListener(d dVar) {
        this.f17704w = dVar;
    }

    public void setOnSetImageUriCompleteListener(f fVar) {
        this.f17707z = fVar;
    }

    public void setRotatedDegrees(int i10) {
        int i11 = this.f17692k;
        if (i11 != i10) {
            l(i10 - i11);
        }
    }

    public void setSaveBitmapToInstanceState(boolean z10) {
        this.f17699r = z10;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != this.f17698q) {
            this.f17698q = scaleType;
            this.D = 1.0f;
            this.F = 0.0f;
            this.E = 0.0f;
            this.f17683b.r();
            requestLayout();
        }
    }

    public void setShowCropOverlay(boolean z10) {
        if (this.f17700s != z10) {
            this.f17700s = z10;
            p();
        }
    }

    public void setShowProgressBar(boolean z10) {
        if (this.f17701t != z10) {
            this.f17701t = z10;
            q();
        }
    }

    public void setSnapRadius(float f10) {
        if (f10 >= 0.0f) {
            this.f17683b.setSnapRadius(f10);
        }
    }
}
