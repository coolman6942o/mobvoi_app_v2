package com.huawei.hms.scankit.p;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.List;
/* compiled from: ParticleEffect.java */
/* loaded from: classes2.dex */
public class Ac {

    /* renamed from: a  reason: collision with root package name */
    private long f14435a = 0;

    /* renamed from: b  reason: collision with root package name */
    private long f14436b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f14437c;

    /* renamed from: d  reason: collision with root package name */
    private int f14438d;

    /* renamed from: e  reason: collision with root package name */
    private int f14439e;

    /* renamed from: f  reason: collision with root package name */
    private float f14440f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f14441g;

    /* renamed from: h  reason: collision with root package name */
    private Bc f14442h;

    public Ac(Bc bc2, Rect rect, int i10, float f10, int[] iArr) {
        this.f14437c = 0;
        this.f14438d = 0;
        this.f14442h = bc2;
        this.f14441g = rect;
        this.f14439e = i10;
        if (iArr != null && iArr.length >= 2) {
            this.f14437c = iArr[0];
            this.f14438d = iArr[1];
        }
        this.f14440f = f10;
        c();
    }

    private void a() {
        Bc bc2 = this.f14442h;
        if (bc2 != null) {
            bc2.a();
        }
    }

    private int b() {
        float a10 = Ic.a(1.0f);
        int red = Color.red(this.f14437c);
        int blue = Color.blue(this.f14437c);
        int green = Color.green(this.f14437c);
        return Color.rgb((int) (red + ((Color.red(this.f14438d) - red) * a10) + 0.5f), (int) (green + ((Color.green(this.f14438d) - green) * a10) + 0.5f), (int) (blue + ((Color.blue(this.f14438d) - blue) * a10) + 0.5f));
    }

    private void c() {
        Rect rect;
        a();
        this.f14436b = 0L;
        this.f14435a = System.currentTimeMillis();
        Bc bc2 = this.f14442h;
        if (bc2 != null && (rect = this.f14441g) != null) {
            bc2.a(rect, this.f14439e);
        }
    }

    public void a(Canvas canvas, Rect rect) {
        if (this.f14442h != null && canvas != null && rect != null) {
            long currentTimeMillis = this.f14436b + (System.currentTimeMillis() - this.f14435a);
            this.f14436b = currentTimeMillis;
            this.f14442h.a(currentTimeMillis);
            List<zc> b10 = this.f14442h.b();
            if (b10 != null && !b10.isEmpty()) {
                a(canvas, rect, b10);
                this.f14435a = System.currentTimeMillis();
            }
        }
    }

    private void a(Canvas canvas, Rect rect, List<zc> list) {
        for (zc zcVar : list) {
            Paint paint = new Paint();
            if (zcVar.b() == 0) {
                zcVar.b(b());
            }
            paint.setColor(zcVar.b());
            boolean z10 = zcVar.d() > ((float) Math.max(rect.top, rect.bottom)) || zcVar.d() < ((float) Math.min(rect.top, rect.bottom));
            float f10 = 0.0f;
            if (!(rect.height() == 0 || rect.width() == 0 || z10)) {
                f10 = (rect.bottom - zcVar.d()) / rect.height();
            }
            int a10 = (int) (zcVar.a() * Math.abs(f10));
            if (a10 > 0) {
                paint.setAlpha(a10);
                canvas.drawCircle(zcVar.c(), zcVar.d(), zcVar.f() * this.f14440f, paint);
            }
        }
    }
}
