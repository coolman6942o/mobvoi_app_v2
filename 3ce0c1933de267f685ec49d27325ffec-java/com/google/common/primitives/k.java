package com.google.common.primitives;

import com.google.common.base.p;
import java.math.BigInteger;
/* compiled from: UnsignedLongs.java */
/* loaded from: classes.dex */
public final class k {

    /* compiled from: UnsignedLongs.java */
    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final long[] f12355a = new long[37];

        /* renamed from: b  reason: collision with root package name */
        static final int[] f12356b = new int[37];

        /* renamed from: c  reason: collision with root package name */
        static final int[] f12357c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i10 = 2; i10 <= 36; i10++) {
                long j10 = i10;
                f12355a[i10] = k.b(-1L, j10);
                f12356b[i10] = (int) k.e(-1L, j10);
                f12357c[i10] = bigInteger.toString(i10).length() - 1;
            }
        }

        static boolean a(long j10, int i10, int i11) {
            if (j10 < 0) {
                return true;
            }
            long[] jArr = f12355a;
            if (j10 < jArr[i11]) {
                return false;
            }
            return j10 > jArr[i11] || i10 > f12356b[i11];
        }
    }

    public static int a(long j10, long j11) {
        return f.c(c(j10), c(j11));
    }

    public static long b(long j10, long j11) {
        if (j11 < 0) {
            return a(j10, j11) < 0 ? 0L : 1L;
        }
        if (j10 >= 0) {
            return j10 / j11;
        }
        int i10 = 1;
        long j12 = ((j10 >>> 1) / j11) << 1;
        if (a(j10 - (j12 * j11), j11) < 0) {
            i10 = 0;
        }
        return j12 + i10;
    }

    private static long c(long j10) {
        return j10 ^ Long.MIN_VALUE;
    }

    public static long d(String str, int i10) {
        p.o(str);
        if (str.length() == 0) {
            throw new NumberFormatException("empty string");
        } else if (i10 < 2 || i10 > 36) {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("illegal radix: ");
            sb2.append(i10);
            throw new NumberFormatException(sb2.toString());
        } else {
            int i11 = a.f12357c[i10] - 1;
            long j10 = 0;
            for (int i12 = 0; i12 < str.length(); i12++) {
                int digit = Character.digit(str.charAt(i12), i10);
                if (digit == -1) {
                    throw new NumberFormatException(str);
                } else if (i12 <= i11 || !a.a(j10, digit, i10)) {
                    j10 = (j10 * i10) + digit;
                } else {
                    throw new NumberFormatException(str.length() != 0 ? "Too large for unsigned long: ".concat(str) : new String("Too large for unsigned long: "));
                }
            }
            return j10;
        }
    }

    public static long e(long j10, long j11) {
        if (j11 < 0) {
            return a(j10, j11) < 0 ? j10 : j10 - j11;
        }
        if (j10 >= 0) {
            return j10 % j11;
        }
        long j12 = j10 - ((((j10 >>> 1) / j11) << 1) * j11);
        if (a(j12, j11) < 0) {
            j11 = 0;
        }
        return j12 - j11;
    }

    public static String f(long j10) {
        return g(j10, 10);
    }

    public static String g(long j10, int i10) {
        long j11;
        p.f(i10 >= 2 && i10 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i10);
        int i11 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i11 == 0) {
            return "0";
        }
        if (i11 > 0) {
            return Long.toString(j10, i10);
        }
        int i12 = 64;
        char[] cArr = new char[64];
        int i13 = i10 - 1;
        if ((i10 & i13) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i10);
            do {
                i12--;
                cArr[i12] = Character.forDigit(((int) j10) & i13, i10);
                j10 >>>= numberOfTrailingZeros;
            } while (j10 != 0);
        } else {
            if ((i10 & 1) == 0) {
                j11 = (j10 >>> 1) / (i10 >>> 1);
            } else {
                j11 = b(j10, i10);
            }
            long j12 = i10;
            cArr[63] = Character.forDigit((int) (j10 - (j11 * j12)), i10);
            i12 = 63;
            while (j11 > 0) {
                i12--;
                cArr[i12] = Character.forDigit((int) (j11 % j12), i10);
                j11 /= j12;
            }
        }
        return new String(cArr, i12, 64 - i12);
    }
}
