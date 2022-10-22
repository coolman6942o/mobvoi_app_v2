package com.mobvoi.companion.view.crop;

import android.content.res.Resources;
import android.graphics.RectF;
import android.util.TypedValue;
import com.mobvoi.companion.view.crop.CropWindowMoveHandler;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CropWindowHandler.java */
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: c  reason: collision with root package name */
    private float f17800c;

    /* renamed from: d  reason: collision with root package name */
    private float f17801d;

    /* renamed from: e  reason: collision with root package name */
    private float f17802e;

    /* renamed from: f  reason: collision with root package name */
    private float f17803f;

    /* renamed from: g  reason: collision with root package name */
    private float f17804g;

    /* renamed from: h  reason: collision with root package name */
    private float f17805h;

    /* renamed from: i  reason: collision with root package name */
    private float f17806i;

    /* renamed from: j  reason: collision with root package name */
    private float f17807j;

    /* renamed from: a  reason: collision with root package name */
    private final RectF f17798a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f17799b = new RectF();

    /* renamed from: k  reason: collision with root package name */
    private float f17808k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    private float f17809l = 1.0f;

    private boolean a() {
        return !r();
    }

    private CropWindowMoveHandler.Type h(float f10, float f11, float f12) {
        RectF rectF = this.f17798a;
        if (l(f10, f11, rectF.left, rectF.top, f12)) {
            return CropWindowMoveHandler.Type.TOP_LEFT;
        }
        RectF rectF2 = this.f17798a;
        if (l(f10, f11, rectF2.right, rectF2.top, f12)) {
            return CropWindowMoveHandler.Type.TOP_RIGHT;
        }
        RectF rectF3 = this.f17798a;
        if (l(f10, f11, rectF3.left, rectF3.bottom, f12)) {
            return CropWindowMoveHandler.Type.BOTTOM_LEFT;
        }
        RectF rectF4 = this.f17798a;
        if (l(f10, f11, rectF4.right, rectF4.bottom, f12)) {
            return CropWindowMoveHandler.Type.BOTTOM_RIGHT;
        }
        RectF rectF5 = this.f17798a;
        if (k(f10, f11, rectF5.left, rectF5.top, rectF5.right, rectF5.bottom) && a()) {
            return CropWindowMoveHandler.Type.CENTER;
        }
        RectF rectF6 = this.f17798a;
        if (m(f10, f11, rectF6.left, rectF6.right, rectF6.top, f12)) {
            return CropWindowMoveHandler.Type.TOP;
        }
        RectF rectF7 = this.f17798a;
        if (m(f10, f11, rectF7.left, rectF7.right, rectF7.bottom, f12)) {
            return CropWindowMoveHandler.Type.BOTTOM;
        }
        RectF rectF8 = this.f17798a;
        if (n(f10, f11, rectF8.left, rectF8.top, rectF8.bottom, f12)) {
            return CropWindowMoveHandler.Type.LEFT;
        }
        RectF rectF9 = this.f17798a;
        if (n(f10, f11, rectF9.right, rectF9.top, rectF9.bottom, f12)) {
            return CropWindowMoveHandler.Type.RIGHT;
        }
        RectF rectF10 = this.f17798a;
        if (!k(f10, f11, rectF10.left, rectF10.top, rectF10.right, rectF10.bottom) || a()) {
            return null;
        }
        return CropWindowMoveHandler.Type.CENTER;
    }

    private static boolean k(float f10, float f11, float f12, float f13, float f14, float f15) {
        return f10 > f12 && f10 < f14 && f11 > f13 && f11 < f15;
    }

    private static boolean l(float f10, float f11, float f12, float f13, float f14) {
        return Math.abs(f10 - f12) <= f14 && Math.abs(f11 - f13) <= f14;
    }

    private static boolean m(float f10, float f11, float f12, float f13, float f14, float f15) {
        return f10 > f12 && f10 < f13 && Math.abs(f11 - f14) <= f15;
    }

    private static boolean n(float f10, float f11, float f12, float f13, float f14, float f15) {
        return Math.abs(f10 - f12) <= f15 && f11 > f13 && f11 < f14;
    }

    public float b() {
        return Math.min(this.f17803f, this.f17807j / this.f17809l);
    }

    public float c() {
        return Math.min(this.f17802e, this.f17806i / this.f17808k);
    }

    public float d() {
        return Math.max(this.f17801d, this.f17805h / this.f17809l);
    }

    public float e() {
        return Math.max(this.f17800c, this.f17804g / this.f17808k);
    }

    public CropWindowMoveHandler f(float f10, float f11, float f12) {
        CropWindowMoveHandler.Type h10 = h(f10, f11, f12);
        if (h10 != null) {
            return new CropWindowMoveHandler(h10, this, f10, f11);
        }
        return null;
    }

    public RectF g() {
        this.f17799b.set(this.f17798a);
        return this.f17799b;
    }

    public float i() {
        return this.f17809l;
    }

    public float j() {
        return this.f17808k;
    }

    public void o(float f10, float f11, float f12, float f13) {
        this.f17802e = f10;
        this.f17803f = f11;
        this.f17808k = f12;
        this.f17809l = f13;
    }

    public void p() {
        float applyDimension = (int) TypedValue.applyDimension(1, 42.0f, Resources.getSystem().getDisplayMetrics());
        this.f17800c = applyDimension;
        this.f17801d = applyDimension;
        this.f17804g = 40.0f;
        this.f17805h = 40.0f;
        this.f17806i = 99999.0f;
        this.f17807j = 99999.0f;
    }

    public void q(RectF rectF) {
        this.f17798a.set(rectF);
    }

    public boolean r() {
        return this.f17798a.width() >= 100.0f && this.f17798a.height() >= 100.0f;
    }
}
