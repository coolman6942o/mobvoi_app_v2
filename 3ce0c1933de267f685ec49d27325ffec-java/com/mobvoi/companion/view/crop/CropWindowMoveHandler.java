package com.mobvoi.companion.view.crop;

import android.graphics.PointF;
import android.graphics.RectF;
/* loaded from: classes2.dex */
final class CropWindowMoveHandler {

    /* renamed from: a  reason: collision with root package name */
    private final float f17736a;

    /* renamed from: b  reason: collision with root package name */
    private final float f17737b;

    /* renamed from: c  reason: collision with root package name */
    private final float f17738c;

    /* renamed from: d  reason: collision with root package name */
    private final float f17739d;

    /* renamed from: e  reason: collision with root package name */
    private final Type f17740e;

    /* renamed from: f  reason: collision with root package name */
    private final PointF f17741f = new PointF();

    /* loaded from: classes2.dex */
    public enum Type {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f17742a;

        static {
            int[] iArr = new int[Type.values().length];
            f17742a = iArr;
            try {
                iArr[Type.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17742a[Type.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17742a[Type.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17742a[Type.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f17742a[Type.LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17742a[Type.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17742a[Type.RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17742a[Type.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17742a[Type.CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public CropWindowMoveHandler(Type type, e eVar, float f10, float f11) {
        this.f17740e = type;
        this.f17736a = eVar.e();
        this.f17737b = eVar.d();
        this.f17738c = eVar.c();
        this.f17739d = eVar.b();
        l(eVar.g(), f10, f11);
    }

    private void a(RectF rectF, float f10, RectF rectF2, int i10, float f11, float f12, boolean z10, boolean z11) {
        float f13 = i10;
        if (f10 > f13) {
            f10 = ((f10 - f13) / 1.05f) + f13;
            this.f17741f.y -= (f10 - f13) / 1.1f;
        }
        float f14 = rectF2.bottom;
        if (f10 > f14) {
            this.f17741f.y -= (f10 - f14) / 2.0f;
        }
        if (f14 - f10 < f11) {
            f10 = f14;
        }
        float f15 = rectF.top;
        float f16 = this.f17737b;
        if (f10 - f15 < f16) {
            f10 = f15 + f16;
        }
        float f17 = this.f17739d;
        if (f10 - f15 > f17) {
            f10 = f15 + f17;
        }
        if (f14 - f10 < f11) {
            f10 = f14;
        }
        if (f12 > 0.0f) {
            float f18 = (f10 - f15) * f12;
            float f19 = this.f17736a;
            if (f18 < f19) {
                f10 = Math.min(f14, f15 + (f19 / f12));
                f18 = (f10 - rectF.top) * f12;
            }
            float f20 = this.f17738c;
            if (f18 > f20) {
                f10 = Math.min(rectF2.bottom, rectF.top + (f20 / f12));
                f18 = (f10 - rectF.top) * f12;
            }
            if (!z10 || !z11) {
                if (z10) {
                    float f21 = rectF.right;
                    float f22 = rectF2.left;
                    if (f21 - f18 < f22) {
                        f10 = Math.min(rectF2.bottom, rectF.top + ((f21 - f22) / f12));
                        f18 = (f10 - rectF.top) * f12;
                    }
                }
                if (z11) {
                    float f23 = rectF.left;
                    float f24 = rectF2.right;
                    if (f18 + f23 > f24) {
                        f10 = Math.min(f10, Math.min(rectF2.bottom, rectF.top + ((f24 - f23) / f12)));
                    }
                }
            } else {
                f10 = Math.min(f10, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f12)));
            }
        }
        rectF.bottom = f10;
    }

    private void b(RectF rectF, float f10) {
        rectF.bottom = rectF.top + (rectF.width() / f10);
    }

    private void c(RectF rectF, float f10, RectF rectF2, float f11, float f12, boolean z10, boolean z11) {
        if (f10 < 0.0f) {
            f10 /= 1.05f;
            this.f17741f.x -= f10 / 1.1f;
        }
        float f13 = rectF2.left;
        if (f10 < f13) {
            this.f17741f.x -= (f10 - f13) / 2.0f;
        }
        if (f10 - f13 < f11) {
            f10 = f13;
        }
        float f14 = rectF.right;
        float f15 = this.f17736a;
        if (f14 - f10 < f15) {
            f10 = f14 - f15;
        }
        float f16 = this.f17738c;
        if (f14 - f10 > f16) {
            f10 = f14 - f16;
        }
        if (f10 - f13 < f11) {
            f10 = f13;
        }
        if (f12 > 0.0f) {
            float f17 = (f14 - f10) / f12;
            float f18 = this.f17737b;
            if (f17 < f18) {
                f10 = Math.max(f13, f14 - (f18 * f12));
                f17 = (rectF.right - f10) / f12;
            }
            float f19 = this.f17739d;
            if (f17 > f19) {
                f10 = Math.max(rectF2.left, rectF.right - (f19 * f12));
                f17 = (rectF.right - f10) / f12;
            }
            if (!z10 || !z11) {
                if (z10) {
                    float f20 = rectF.bottom;
                    float f21 = rectF2.top;
                    if (f20 - f17 < f21) {
                        f10 = Math.max(rectF2.left, rectF.right - ((f20 - f21) * f12));
                        f17 = (rectF.right - f10) / f12;
                    }
                }
                if (z11) {
                    float f22 = rectF.top;
                    float f23 = rectF2.bottom;
                    if (f17 + f22 > f23) {
                        f10 = Math.max(f10, Math.max(rectF2.left, rectF.right - ((f23 - f22) * f12)));
                    }
                }
            } else {
                f10 = Math.max(f10, Math.max(rectF2.left, rectF.right - (rectF2.height() * f12)));
            }
        }
        rectF.left = f10;
    }

    private void d(RectF rectF, float f10) {
        rectF.left = rectF.right - (rectF.height() * f10);
    }

    private void e(RectF rectF, RectF rectF2, float f10) {
        rectF.inset((rectF.width() - (rectF.height() * f10)) / 2.0f, 0.0f);
        float f11 = rectF.left;
        float f12 = rectF2.left;
        if (f11 < f12) {
            rectF.offset(f12 - f11, 0.0f);
        }
        float f13 = rectF.right;
        float f14 = rectF2.right;
        if (f13 > f14) {
            rectF.offset(f14 - f13, 0.0f);
        }
    }

    private void f(RectF rectF, float f10, RectF rectF2, int i10, float f11, float f12, boolean z10, boolean z11) {
        float f13 = i10;
        if (f10 > f13) {
            f10 = ((f10 - f13) / 1.05f) + f13;
            this.f17741f.x -= (f10 - f13) / 1.1f;
        }
        float f14 = rectF2.right;
        if (f10 > f14) {
            this.f17741f.x -= (f10 - f14) / 2.0f;
        }
        if (f14 - f10 < f11) {
            f10 = f14;
        }
        float f15 = rectF.left;
        float f16 = this.f17736a;
        if (f10 - f15 < f16) {
            f10 = f15 + f16;
        }
        float f17 = this.f17738c;
        if (f10 - f15 > f17) {
            f10 = f15 + f17;
        }
        if (f14 - f10 < f11) {
            f10 = f14;
        }
        if (f12 > 0.0f) {
            float f18 = (f10 - f15) / f12;
            float f19 = this.f17737b;
            if (f18 < f19) {
                f10 = Math.min(f14, f15 + (f19 * f12));
                f18 = (f10 - rectF.left) / f12;
            }
            float f20 = this.f17739d;
            if (f18 > f20) {
                f10 = Math.min(rectF2.right, rectF.left + (f20 * f12));
                f18 = (f10 - rectF.left) / f12;
            }
            if (!z10 || !z11) {
                if (z10) {
                    float f21 = rectF.bottom;
                    float f22 = rectF2.top;
                    if (f21 - f18 < f22) {
                        f10 = Math.min(rectF2.right, rectF.left + ((f21 - f22) * f12));
                        f18 = (f10 - rectF.left) / f12;
                    }
                }
                if (z11) {
                    float f23 = rectF.top;
                    float f24 = rectF2.bottom;
                    if (f18 + f23 > f24) {
                        f10 = Math.min(f10, Math.min(rectF2.right, rectF.left + ((f24 - f23) * f12)));
                    }
                }
            } else {
                f10 = Math.min(f10, Math.min(rectF2.right, rectF.left + (rectF2.height() * f12)));
            }
        }
        rectF.right = f10;
    }

    private void g(RectF rectF, float f10) {
        rectF.right = rectF.left + (rectF.height() * f10);
    }

    private void h(RectF rectF, float f10, RectF rectF2, float f11, float f12, boolean z10, boolean z11) {
        if (f10 < 0.0f) {
            f10 /= 1.05f;
            this.f17741f.y -= f10 / 1.1f;
        }
        float f13 = rectF2.top;
        if (f10 < f13) {
            this.f17741f.y -= (f10 - f13) / 2.0f;
        }
        if (f10 - f13 < f11) {
            f10 = f13;
        }
        float f14 = rectF.bottom;
        float f15 = this.f17737b;
        if (f14 - f10 < f15) {
            f10 = f14 - f15;
        }
        float f16 = this.f17739d;
        if (f14 - f10 > f16) {
            f10 = f14 - f16;
        }
        if (f10 - f13 < f11) {
            f10 = f13;
        }
        if (f12 > 0.0f) {
            float f17 = (f14 - f10) * f12;
            float f18 = this.f17736a;
            if (f17 < f18) {
                f10 = Math.max(f13, f14 - (f18 / f12));
                f17 = (rectF.bottom - f10) * f12;
            }
            float f19 = this.f17738c;
            if (f17 > f19) {
                f10 = Math.max(rectF2.top, rectF.bottom - (f19 / f12));
                f17 = (rectF.bottom - f10) * f12;
            }
            if (!z10 || !z11) {
                if (z10) {
                    float f20 = rectF.right;
                    float f21 = rectF2.left;
                    if (f20 - f17 < f21) {
                        f10 = Math.max(rectF2.top, rectF.bottom - ((f20 - f21) / f12));
                        f17 = (rectF.bottom - f10) * f12;
                    }
                }
                if (z11) {
                    float f22 = rectF.left;
                    float f23 = rectF2.right;
                    if (f17 + f22 > f23) {
                        f10 = Math.max(f10, Math.max(rectF2.top, rectF.bottom - ((f23 - f22) / f12)));
                    }
                }
            } else {
                f10 = Math.max(f10, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f12)));
            }
        }
        rectF.top = f10;
    }

    private void i(RectF rectF, RectF rectF2, float f10) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f10)) / 2.0f);
        float f11 = rectF.top;
        float f12 = rectF2.top;
        if (f11 < f12) {
            rectF.offset(0.0f, f12 - f11);
        }
        float f13 = rectF.bottom;
        float f14 = rectF2.bottom;
        if (f13 > f14) {
            rectF.offset(0.0f, f14 - f13);
        }
    }

    private void j(RectF rectF, float f10) {
        rectF.top = rectF.bottom - (rectF.width() / f10);
    }

    private static float k(float f10, float f11, float f12, float f13) {
        return (f12 - f10) / (f13 - f11);
    }

    private void l(RectF rectF, float f10, float f11) {
        float f12;
        float f13;
        float f14;
        float f15 = 0.0f;
        switch (a.f17742a[this.f17740e.ordinal()]) {
            case 1:
                f15 = rectF.left - f10;
                f13 = rectF.top;
                f12 = f13 - f11;
                break;
            case 2:
                f15 = rectF.right - f10;
                f13 = rectF.top;
                f12 = f13 - f11;
                break;
            case 3:
                f15 = rectF.left - f10;
                f13 = rectF.bottom;
                f12 = f13 - f11;
                break;
            case 4:
                f15 = rectF.right - f10;
                f13 = rectF.bottom;
                f12 = f13 - f11;
                break;
            case 5:
                f14 = rectF.left;
                f15 = f14 - f10;
                f12 = 0.0f;
                break;
            case 6:
                f13 = rectF.top;
                f12 = f13 - f11;
                break;
            case 7:
                f14 = rectF.right;
                f15 = f14 - f10;
                f12 = 0.0f;
                break;
            case 8:
                f13 = rectF.bottom;
                f12 = f13 - f11;
                break;
            case 9:
                f15 = rectF.centerX() - f10;
                f13 = rectF.centerY();
                f12 = f13 - f11;
                break;
            default:
                f12 = 0.0f;
                break;
        }
        PointF pointF = this.f17741f;
        pointF.x = f15;
        pointF.y = f12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0056, code lost:
        if ((r0 + r9) <= r10.bottom) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002d, code lost:
        if ((r1 + r8) <= r10.right) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n(RectF rectF, float f10, float f11, RectF rectF2, int i10, int i11, float f12) {
        float centerX = f10 - rectF.centerX();
        float centerY = f11 - rectF.centerY();
        float f13 = rectF.left;
        if (f13 + centerX >= 0.0f) {
            float f14 = rectF.right;
            if (f14 + centerX <= i10) {
                if (f13 + centerX >= rectF2.left) {
                }
            }
        }
        centerX /= 1.05f;
        this.f17741f.x -= centerX / 2.0f;
        float f15 = rectF.top;
        if (f15 + centerY >= 0.0f) {
            float f16 = rectF.bottom;
            if (f16 + centerY <= i11) {
                if (f15 + centerY >= rectF2.top) {
                }
            }
        }
        centerY /= 1.05f;
        this.f17741f.y -= centerY / 2.0f;
        rectF.offset(centerX, centerY);
        q(rectF, rectF2, f12);
    }

    private void o(RectF rectF, float f10, float f11, RectF rectF2, int i10, int i11, float f12, float f13) {
        switch (a.f17742a[this.f17740e.ordinal()]) {
            case 1:
                if (k(f10, f11, rectF.right, rectF.bottom) < f13) {
                    h(rectF, f11, rectF2, f12, f13, true, false);
                    d(rectF, f13);
                    return;
                }
                c(rectF, f10, rectF2, f12, f13, true, false);
                j(rectF, f13);
                return;
            case 2:
                if (k(rectF.left, f11, f10, rectF.bottom) < f13) {
                    h(rectF, f11, rectF2, f12, f13, false, true);
                    g(rectF, f13);
                    return;
                }
                f(rectF, f10, rectF2, i10, f12, f13, true, false);
                j(rectF, f13);
                return;
            case 3:
                if (k(f10, rectF.top, rectF.right, f11) < f13) {
                    a(rectF, f11, rectF2, i11, f12, f13, true, false);
                    d(rectF, f13);
                    return;
                }
                c(rectF, f10, rectF2, f12, f13, false, true);
                b(rectF, f13);
                return;
            case 4:
                if (k(rectF.left, rectF.top, f10, f11) < f13) {
                    a(rectF, f11, rectF2, i11, f12, f13, false, true);
                    g(rectF, f13);
                    return;
                }
                f(rectF, f10, rectF2, i10, f12, f13, false, true);
                b(rectF, f13);
                return;
            case 5:
                c(rectF, f10, rectF2, f12, f13, true, true);
                i(rectF, rectF2, f13);
                return;
            case 6:
                h(rectF, f11, rectF2, f12, f13, true, true);
                e(rectF, rectF2, f13);
                return;
            case 7:
                f(rectF, f10, rectF2, i10, f12, f13, true, true);
                i(rectF, rectF2, f13);
                return;
            case 8:
                a(rectF, f11, rectF2, i11, f12, f13, true, true);
                e(rectF, rectF2, f13);
                return;
            default:
                return;
        }
    }

    private void p(RectF rectF, float f10, float f11, RectF rectF2, int i10, int i11, float f12) {
        switch (a.f17742a[this.f17740e.ordinal()]) {
            case 1:
                h(rectF, f11, rectF2, f12, 0.0f, false, false);
                c(rectF, f10, rectF2, f12, 0.0f, false, false);
                return;
            case 2:
                h(rectF, f11, rectF2, f12, 0.0f, false, false);
                f(rectF, f10, rectF2, i10, f12, 0.0f, false, false);
                return;
            case 3:
                a(rectF, f11, rectF2, i11, f12, 0.0f, false, false);
                c(rectF, f10, rectF2, f12, 0.0f, false, false);
                return;
            case 4:
                a(rectF, f11, rectF2, i11, f12, 0.0f, false, false);
                f(rectF, f10, rectF2, i10, f12, 0.0f, false, false);
                return;
            case 5:
                c(rectF, f10, rectF2, f12, 0.0f, false, false);
                return;
            case 6:
                h(rectF, f11, rectF2, f12, 0.0f, false, false);
                return;
            case 7:
                f(rectF, f10, rectF2, i10, f12, 0.0f, false, false);
                return;
            case 8:
                a(rectF, f11, rectF2, i11, f12, 0.0f, false, false);
                return;
            default:
                return;
        }
    }

    private void q(RectF rectF, RectF rectF2, float f10) {
        float f11 = rectF.left;
        float f12 = rectF2.left;
        if (f11 < f12 + f10) {
            rectF.offset(f12 - f11, 0.0f);
        }
        float f13 = rectF.top;
        float f14 = rectF2.top;
        if (f13 < f14 + f10) {
            rectF.offset(0.0f, f14 - f13);
        }
        float f15 = rectF.right;
        float f16 = rectF2.right;
        if (f15 > f16 - f10) {
            rectF.offset(f16 - f15, 0.0f);
        }
        float f17 = rectF.bottom;
        float f18 = rectF2.bottom;
        if (f17 > f18 - f10) {
            rectF.offset(0.0f, f18 - f17);
        }
    }

    public void m(RectF rectF, float f10, float f11, RectF rectF2, int i10, int i11, float f12, boolean z10, float f13) {
        PointF pointF = this.f17741f;
        float f14 = f10 + pointF.x;
        float f15 = f11 + pointF.y;
        if (this.f17740e == Type.CENTER) {
            n(rectF, f14, f15, rectF2, i10, i11, f12);
        } else if (z10) {
            o(rectF, f14, f15, rectF2, i10, i11, f12, f13);
        } else {
            p(rectF, f14, f15, rectF2, i10, i11, f12);
        }
    }
}
