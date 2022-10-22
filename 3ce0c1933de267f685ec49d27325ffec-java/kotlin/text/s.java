package kotlin.text;

import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversions.kt */
/* loaded from: classes3.dex */
public class s extends r {
    public static Integer i(String toIntOrNull) {
        i.f(toIntOrNull, "$this$toIntOrNull");
        return j(toIntOrNull, 10);
    }

    public static final Integer j(String toIntOrNull, int i10) {
        boolean z10;
        int i11;
        i.f(toIntOrNull, "$this$toIntOrNull");
        b.a(i10);
        int length = toIntOrNull.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char charAt = toIntOrNull.charAt(0);
        int i13 = -2147483647;
        int i14 = 1;
        if (i.h(charAt, 48) >= 0) {
            z10 = false;
            i14 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i13 = Integer.MIN_VALUE;
                z10 = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z10 = false;
            }
        }
        int i15 = -59652323;
        while (i14 < length) {
            int b10 = b.b(toIntOrNull.charAt(i14), i10);
            if (b10 < 0) {
                return null;
            }
            if ((i12 < i15 && (i15 != -59652323 || i12 < (i15 = i13 / i10))) || (i11 = i12 * i10) < i13 + b10) {
                return null;
            }
            i12 = i11 - b10;
            i14++;
        }
        return z10 ? Integer.valueOf(i12) : Integer.valueOf(-i12);
    }

    public static Long k(String toLongOrNull) {
        i.f(toLongOrNull, "$this$toLongOrNull");
        return l(toLongOrNull, 10);
    }

    public static final Long l(String toLongOrNull, int i10) {
        i.f(toLongOrNull, "$this$toLongOrNull");
        b.a(i10);
        int length = toLongOrNull.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char charAt = toLongOrNull.charAt(0);
        long j10 = -9223372036854775807L;
        boolean z10 = true;
        if (i.h(charAt, 48) >= 0) {
            z10 = false;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                j10 = Long.MIN_VALUE;
                i11 = 1;
            } else if (charAt != '+') {
                return null;
            } else {
                z10 = false;
                i11 = 1;
            }
        }
        long j11 = -256204778801521550L;
        long j12 = 0;
        long j13 = -256204778801521550L;
        while (i11 < length) {
            int b10 = b.b(toLongOrNull.charAt(i11), i10);
            if (b10 < 0) {
                return null;
            }
            if (j12 < j13) {
                if (j13 == j11) {
                    j13 = j10 / i10;
                    if (j12 < j13) {
                    }
                }
                return null;
            }
            long j14 = j12 * i10;
            long j15 = b10;
            if (j14 < j10 + j15) {
                return null;
            }
            j12 = j14 - j15;
            i11++;
            j11 = -256204778801521550L;
        }
        return z10 ? Long.valueOf(j12) : Long.valueOf(-j12);
    }
}
