package com.google.common.math;

import java.math.RoundingMode;
/* compiled from: IntMath.java */
/* loaded from: classes.dex */
public final class c {

    /* compiled from: IntMath.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12326a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f12326a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12326a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12326a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12326a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12326a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12326a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12326a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12326a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static int a(int i10, int i11) {
        long j10 = i10 + i11;
        int i12 = (int) j10;
        f.b(j10 == ((long) i12), "checkedAdd", i10, i11);
        return i12;
    }

    public static boolean b(int i10) {
        boolean z10 = false;
        boolean z11 = i10 > 0;
        if ((i10 & (i10 - 1)) == 0) {
            z10 = true;
        }
        return z11 & z10;
    }

    static int c(int i10, int i11) {
        return (~(~(i10 - i11))) >>> 31;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int d(int i10, RoundingMode roundingMode) {
        f.d("x", i10);
        switch (a.f12326a[roundingMode.ordinal()]) {
            case 1:
                f.e(b(i10));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i10 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i10);
                return (31 - numberOfLeadingZeros) + c((-1257966797) >>> numberOfLeadingZeros, i10);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static int e(int i10, RoundingMode roundingMode) {
        int c10;
        f.c("x", i10);
        int f10 = f(i10);
        switch (a.f12326a[roundingMode.ordinal()]) {
            case 1:
                f.e(f10 * f10 == i10);
                return f10;
            case 2:
            case 3:
                return f10;
            case 4:
            case 5:
                c10 = c(f10 * f10, i10);
                return f10 + c10;
            case 6:
            case 7:
            case 8:
                c10 = c((f10 * f10) + f10, i10);
                return f10 + c10;
            default:
                throw new AssertionError();
        }
    }

    private static int f(int i10) {
        return (int) Math.sqrt(i10);
    }
}
