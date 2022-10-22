package com.theartofdev.edmodo.cropper;

import android.graphics.RectF;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.theartofdev.edmodo.cropper.CropWindowMoveHandler;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CropWindowHandler.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    private float f23213c;

    /* renamed from: d  reason: collision with root package name */
    private float f23214d;

    /* renamed from: e  reason: collision with root package name */
    private float f23215e;

    /* renamed from: f  reason: collision with root package name */
    private float f23216f;

    /* renamed from: g  reason: collision with root package name */
    private float f23217g;

    /* renamed from: h  reason: collision with root package name */
    private float f23218h;

    /* renamed from: i  reason: collision with root package name */
    private float f23219i;

    /* renamed from: j  reason: collision with root package name */
    private float f23220j;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f23211a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f23212b = new RectF();

    /* renamed from: k  reason: collision with root package name */
    private float f23221k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f23222l = 1.0f;

    private boolean a() {
        return !s();
    }

    private CropWindowMoveHandler.Type g(float f10, float f11) {
        float width = this.f23211a.width() / 6.0f;
        RectF rectF = this.f23211a;
        float f12 = rectF.left;
        float f13 = f12 + width;
        float f14 = f12 + (width * 5.0f);
        float height = rectF.height() / 6.0f;
        float f15 = this.f23211a.top;
        float f16 = f15 + height;
        float f17 = f15 + (height * 5.0f);
        if (f10 < f13) {
            if (f11 < f16) {
                return CropWindowMoveHandler.Type.TOP_LEFT;
            }
            if (f11 < f17) {
                return CropWindowMoveHandler.Type.LEFT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        } else if (f10 < f14) {
            if (f11 < f16) {
                return CropWindowMoveHandler.Type.TOP;
            }
            if (f11 < f17) {
                return CropWindowMoveHandler.Type.CENTER;
            }
            return CropWindowMoveHandler.Type.BOTTOM;
        } else if (f11 < f16) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        } else {
            if (f11 < f17) {
                return CropWindowMoveHandler.Type.RIGHT;
            }
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
    }

    private CropWindowMoveHandler.Type i(float f10, float f11, float f12) {
        RectF rectF = this.f23211a;
        if (m(f10, f11, rectF.left, rectF.top, f12)) {
            return CropWindowMoveHandler.Type.TOP_LEFT;
        }
        RectF rectF2 = this.f23211a;
        if (m(f10, f11, rectF2.right, rectF2.top, f12)) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        }
        RectF rectF3 = this.f23211a;
        if (m(f10, f11, rectF3.left, rectF3.bottom, f12)) {
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        }
        RectF rectF4 = this.f23211a;
        if (m(f10, f11, rectF4.right, rectF4.bottom, f12)) {
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
        RectF rectF5 = this.f23211a;
        if (l(f10, f11, rectF5.left, rectF5.top, rectF5.right, rectF5.bottom) && a()) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        RectF rectF6 = this.f23211a;
        if (n(f10, f11, rectF6.left, rectF6.right, rectF6.top, f12)) {
            return CropWindowMoveHandler.Type.TOP;
        }
        RectF rectF7 = this.f23211a;
        if (n(f10, f11, rectF7.left, rectF7.right, rectF7.bottom, f12)) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        RectF rectF8 = this.f23211a;
        if (o(f10, f11, rectF8.left, rectF8.top, rectF8.bottom, f12)) {
            return CropWindowMoveHandler.Type.LEFT;
        }
        RectF rectF9 = this.f23211a;
        if (o(f10, f11, rectF9.right, rectF9.top, rectF9.bottom, f12)) {
            return CropWindowMoveHandler.Type.RIGHT;
        }
        RectF rectF10 = this.f23211a;
        if (!l(f10, f11, rectF10.left, rectF10.top, rectF10.right, rectF10.bottom) || a()) {
            return null;
        }
        return CropWindowMoveHandler.Type.CENTER;
    }

    private static boolean l(float f10, float f11, float f12, float f13, float f14, float f15) {
        return f10 > f12 && f10 < f14 && f11 > f13 && f11 < f15;
    }

    private static boolean m(float f10, float f11, float f12, float f13, float f14) {
        return Math.abs(f10 - f12) <= f14 && Math.abs(f11 - f13) <= f14;
    }

    private static boolean n(float f10, float f11, float f12, float f13, float f14, float f15) {
        return f10 > f12 && f10 < f13 && Math.abs(f11 - f14) <= f15;
    }

    private static boolean o(float f10, float f11, float f12, float f13, float f14, float f15) {
        return Math.abs(f10 - f12) <= f15 && f11 > f13 && f11 < f14;
    }

    public float b() {
        return Math.min(this.f23216f, this.f23220j / this.f23222l);
    }

    public float c() {
        return Math.min(this.f23215e, this.f23219i / this.f23221k);
    }

    public float d() {
        return Math.max(this.f23214d, this.f23218h / this.f23222l);
    }

    public float e() {
        return Math.max(this.f23213c, this.f23217g / this.f23221k);
    }

    public CropWindowMoveHandler f(float f10, float f11, float f12, CropImageView.CropShape cropShape) {
        CropWindowMoveHandler.Type type;
        if (cropShape == CropImageView.CropShape.OVAL) {
            type = g(f10, f11);
        } else {
            type = i(f10, f11, f12);
        }
        if (type != null) {
            return new CropWindowMoveHandler(type, this, f10, f11);
        }
        return null;
    }

    public RectF h() {
        this.f23212b.set(this.f23211a);
        return this.f23212b;
    }

    public float j() {
        return this.f23222l;
    }

    public float k() {
        return this.f23221k;
    }

    public void p(float f10, float f11, float f12, float f13) {
        this.f23215e = f10;
        this.f23216f = f11;
        this.f23221k = f12;
        this.f23222l = f13;
    }

    public void q(CropImageOptions cropImageOptions) {
        this.f23213c = cropImageOptions.f23084x;
        this.f23214d = cropImageOptions.f23085y;
        this.f23217g = cropImageOptions.f23086z;
        this.f23218h = cropImageOptions.A;
        this.f23219i = cropImageOptions.B;
        this.f23220j = cropImageOptions.C;
    }

    public void r(RectF rectF) {
        this.f23211a.set(rectF);
    }

    public boolean s() {
        return this.f23211a.width() >= 100.0f && this.f23211a.height() >= 100.0f;
    }
}
