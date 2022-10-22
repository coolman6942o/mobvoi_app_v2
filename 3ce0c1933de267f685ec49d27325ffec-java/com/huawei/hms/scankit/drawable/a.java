package com.huawei.hms.scankit.drawable;

import android.view.animation.Interpolator;
import java.math.BigDecimal;
/* compiled from: CubicBezierInterpolator.java */
/* loaded from: classes2.dex */
public class a implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private static final BigDecimal f14337a;

    /* renamed from: b  reason: collision with root package name */
    private static final BigDecimal f14338b;

    /* renamed from: c  reason: collision with root package name */
    private static final float f14339c;

    /* renamed from: d  reason: collision with root package name */
    private float f14340d;

    /* renamed from: e  reason: collision with root package name */
    private float f14341e;

    /* renamed from: f  reason: collision with root package name */
    private float f14342f;

    /* renamed from: g  reason: collision with root package name */
    private float f14343g;

    static {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(1.0f));
        f14337a = bigDecimal;
        BigDecimal bigDecimal2 = new BigDecimal(Long.toString(4000L));
        f14338b = bigDecimal2;
        f14339c = bigDecimal.divide(bigDecimal2, 20, 4).floatValue();
    }

    public a(float f10, float f11, float f12, float f13) {
        this.f14340d = 0.0f;
        this.f14341e = 0.0f;
        this.f14342f = 0.0f;
        this.f14343g = 0.0f;
        this.f14340d = f10;
        this.f14341e = f11;
        this.f14342f = f12;
        this.f14343g = f13;
    }

    private long a(float f10) {
        long j10 = 0;
        long j11 = 4000;
        while (j10 <= j11) {
            long j12 = (j10 + j11) >>> 1;
            int i10 = (b(f14339c * ((float) j12)) > f10 ? 1 : (b(f14339c * ((float) j12)) == f10 ? 0 : -1));
            if (i10 < 0) {
                j10 = j12 + 1;
            } else if (i10 <= 0) {
                return j12;
            } else {
                j11 = j12 - 1;
            }
        }
        return j10;
    }

    private float b(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.f14340d) + (f12 * f10 * f10 * this.f14342f) + (f10 * f10 * f10);
    }

    private float c(float f10) {
        float f11 = 1.0f - f10;
        float f12 = 3.0f * f11;
        return (f11 * f12 * f10 * this.f14341e) + (f12 * f10 * f10 * this.f14343g) + (f10 * f10 * f10);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        return c(f14339c * ((float) a(f10)));
    }

    public String toString() {
        return a();
    }

    private String a() {
        return "CubicBezierInterpolator  mControlPoint1x = " + this.f14340d + ", mControlPoint1y = " + this.f14341e + ", mControlPoint2x = " + this.f14342f + ", mControlPoint2y = " + this.f14343g;
    }
}
