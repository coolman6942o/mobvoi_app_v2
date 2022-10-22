package n7;

import android.content.Context;
import android.graphics.Color;
import t7.b;
/* compiled from: ElevationOverlayProvider.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: f  reason: collision with root package name */
    private static final int f31050f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a  reason: collision with root package name */
    private final boolean f31051a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31052b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31053c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31054d;

    /* renamed from: e  reason: collision with root package name */
    private final float f31055e;

    public a(Context context) {
        this(b.b(context, d7.b.f25165u, false), j7.a.b(context, d7.b.f25164t, 0), j7.a.b(context, d7.b.f25163s, 0), j7.a.b(context, d7.b.f25161q, 0), context.getResources().getDisplayMetrics().density);
    }

    private boolean e(int i10) {
        return b0.a.j(i10, 255) == this.f31054d;
    }

    public float a(float f10) {
        float f11 = this.f31055e;
        if (f11 <= 0.0f || f10 <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f10 / f11)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    public int b(int i10, float f10) {
        int i11;
        float a10 = a(f10);
        int alpha = Color.alpha(i10);
        int h10 = j7.a.h(b0.a.j(i10, 255), this.f31052b, a10);
        if (a10 > 0.0f && (i11 = this.f31053c) != 0) {
            h10 = j7.a.g(h10, b0.a.j(i11, f31050f));
        }
        return b0.a.j(h10, alpha);
    }

    public int c(int i10, float f10) {
        return (!this.f31051a || !e(i10)) ? i10 : b(i10, f10);
    }

    public boolean d() {
        return this.f31051a;
    }

    public a(boolean z10, int i10, int i11, int i12, float f10) {
        this.f31051a = z10;
        this.f31052b = i10;
        this.f31053c = i11;
        this.f31054d = i12;
        this.f31055e = f10;
    }
}
