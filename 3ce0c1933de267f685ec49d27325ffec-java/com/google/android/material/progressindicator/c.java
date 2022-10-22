package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import j7.a;
/* compiled from: CircularDrawingDelegate.java */
/* loaded from: classes.dex */
final class c extends h<e> {

    /* renamed from: c  reason: collision with root package name */
    private int f11204c = 1;

    /* renamed from: d  reason: collision with root package name */
    private float f11205d;

    /* renamed from: e  reason: collision with root package name */
    private float f11206e;

    /* renamed from: f  reason: collision with root package name */
    private float f11207f;

    public c(e eVar) {
        super(eVar);
    }

    private void h(Canvas canvas, Paint paint, float f10, float f11, float f12) {
        canvas.save();
        canvas.rotate(f12);
        float f13 = this.f11207f;
        float f14 = f10 / 2.0f;
        canvas.drawRoundRect(new RectF(f13 - f14, f11, f13 + f14, -f11), f11, f11, paint);
        canvas.restore();
    }

    private int i() {
        S s10 = this.f11249a;
        return ((e) s10).f11223g + (((e) s10).f11224h * 2);
    }

    @Override // com.google.android.material.progressindicator.h
    public void a(Canvas canvas, float f10) {
        S s10;
        S s11 = this.f11249a;
        float f11 = (((e) s11).f11223g / 2.0f) + ((e) s11).f11224h;
        canvas.translate(f11, f11);
        canvas.rotate(-90.0f);
        float f12 = -f11;
        canvas.clipRect(f12, f12, f11, f11);
        this.f11204c = ((e) this.f11249a).f11225i == 0 ? 1 : -1;
        this.f11205d = ((e) s10).f11198a * f10;
        this.f11206e = ((e) s10).f11199b * f10;
        this.f11207f = (((e) s10).f11223g - ((e) s10).f11198a) / 2.0f;
        if ((this.f11250b.j() && ((e) this.f11249a).f11202e == 2) || (this.f11250b.i() && ((e) this.f11249a).f11203f == 1)) {
            this.f11207f += ((1.0f - f10) * ((e) this.f11249a).f11198a) / 2.0f;
        } else if ((this.f11250b.j() && ((e) this.f11249a).f11202e == 1) || (this.f11250b.i() && ((e) this.f11249a).f11203f == 2)) {
            this.f11207f -= ((1.0f - f10) * ((e) this.f11249a).f11198a) / 2.0f;
        }
    }

    @Override // com.google.android.material.progressindicator.h
    void b(Canvas canvas, Paint paint, float f10, float f11, int i10) {
        if (f10 != f11) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(Paint.Cap.BUTT);
            paint.setAntiAlias(true);
            paint.setColor(i10);
            paint.setStrokeWidth(this.f11205d);
            int i11 = this.f11204c;
            float f12 = f10 * 360.0f * i11;
            float f13 = (f11 >= f10 ? f11 - f10 : (1.0f + f11) - f10) * 360.0f * i11;
            float f14 = this.f11207f;
            canvas.drawArc(new RectF(-f14, -f14, f14, f14), f12, f13, false, paint);
            if (this.f11206e > 0.0f && Math.abs(f13) < 360.0f) {
                paint.setStyle(Paint.Style.FILL);
                h(canvas, paint, this.f11205d, this.f11206e, f12);
                h(canvas, paint, this.f11205d, this.f11206e, f12 + f13);
            }
        }
    }

    @Override // com.google.android.material.progressindicator.h
    void c(Canvas canvas, Paint paint) {
        int a10 = a.a(((e) this.f11249a).f11201d, this.f11250b.getAlpha());
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        paint.setColor(a10);
        paint.setStrokeWidth(this.f11205d);
        float f10 = this.f11207f;
        canvas.drawArc(new RectF(-f10, -f10, f10, f10), 0.0f, 360.0f, false, paint);
    }

    @Override // com.google.android.material.progressindicator.h
    public int d() {
        return i();
    }

    @Override // com.google.android.material.progressindicator.h
    public int e() {
        return i();
    }
}
