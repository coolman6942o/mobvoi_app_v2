package com.google.common.math;

import java.math.RoundingMode;
/* compiled from: DoubleMath.java */
/* loaded from: classes.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DoubleMath.java */
    /* renamed from: com.google.common.math.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0155a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12325a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f12325a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12325a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12325a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12325a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12325a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12325a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12325a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12325a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    static {
        Math.log(2.0d);
    }

    public static boolean a(double d10) {
        return b.c(d10) && (d10 == 0.0d || 52 - Long.numberOfTrailingZeros(b.b(d10)) <= Math.getExponent(d10));
    }

    static double b(double d10, RoundingMode roundingMode) {
        if (b.c(d10)) {
            switch (C0155a.f12325a[roundingMode.ordinal()]) {
                case 1:
                    f.e(a(d10));
                    return d10;
                case 2:
                    return (d10 >= 0.0d || a(d10)) ? d10 : ((long) d10) - 1;
                case 3:
                    return (d10 <= 0.0d || a(d10)) ? d10 : ((long) d10) + 1;
                case 4:
                    return d10;
                case 5:
                    if (a(d10)) {
                        return d10;
                    }
                    return ((long) d10) + (d10 > 0.0d ? 1 : -1);
                case 6:
                    return Math.rint(d10);
                case 7:
                    double rint = Math.rint(d10);
                    return Math.abs(d10 - rint) == 0.5d ? d10 + Math.copySign(0.5d, d10) : rint;
                case 8:
                    double rint2 = Math.rint(d10);
                    return Math.abs(d10 - rint2) == 0.5d ? d10 : rint2;
                default:
                    throw new AssertionError();
            }
        } else {
            throw new ArithmeticException("input is infinite or NaN");
        }
    }

    public static long c(double d10, RoundingMode roundingMode) {
        double b10 = b(d10, roundingMode);
        boolean z10 = true;
        boolean z11 = (-9.223372036854776E18d) - b10 < 1.0d;
        if (b10 >= 9.223372036854776E18d) {
            z10 = false;
        }
        f.a(z11 & z10, d10, roundingMode);
        return (long) b10;
    }
}
