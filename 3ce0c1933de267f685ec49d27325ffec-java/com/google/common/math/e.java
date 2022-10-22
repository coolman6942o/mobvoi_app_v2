package com.google.common.math;

import com.google.common.base.p;
import java.math.RoundingMode;
/* compiled from: LongMath.java */
/* loaded from: classes.dex */
public final class e {

    /* compiled from: LongMath.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12333a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f12333a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f12333a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f12333a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f12333a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f12333a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f12333a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f12333a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f12333a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0051, code lost:
        if (r11 > 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r9 > 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0057, code lost:
        if (r9 < 0) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static long a(long j10, long j11, RoundingMode roundingMode) {
        p.o(roundingMode);
        long j12 = j10 / j11;
        long j13 = j10 - (j11 * j12);
        int i10 = (j13 > 0L ? 1 : (j13 == 0L ? 0 : -1));
        if (i10 == 0) {
            return j12;
        }
        boolean z10 = true;
        int i11 = ((int) ((j10 ^ j11) >> 63)) | 1;
        switch (a.f12333a[roundingMode.ordinal()]) {
            case 1:
                if (i10 != 0) {
                    z10 = false;
                }
                f.e(z10);
                z10 = false;
                break;
            case 2:
                z10 = false;
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
            case 7:
            case 8:
                long abs = Math.abs(j13);
                int i12 = ((abs - (Math.abs(j11) - abs)) > 0L ? 1 : ((abs - (Math.abs(j11) - abs)) == 0L ? 0 : -1));
                if (i12 == 0) {
                    boolean z11 = roundingMode == RoundingMode.HALF_UP;
                    boolean z12 = roundingMode == RoundingMode.HALF_EVEN;
                    if ((1 & j12) == 0) {
                        z10 = false;
                    }
                    z10 = (z10 & z12) | z11;
                    break;
                }
                break;
            default:
                throw new AssertionError();
        }
        return z10 ? j12 + i11 : j12;
    }
}
