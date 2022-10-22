package com.google.common.math;

import java.math.RoundingMode;
/* compiled from: MathPreconditions.java */
/* loaded from: classes.dex */
final class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z10, double d10, RoundingMode roundingMode) {
        if (!z10) {
            String valueOf = String.valueOf(roundingMode);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 83);
            sb2.append("rounded value is out of range for input ");
            sb2.append(d10);
            sb2.append(" and rounding mode ");
            sb2.append(valueOf);
            throw new ArithmeticException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z10, String str, int i10, int i11) {
        if (!z10) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 36);
            sb2.append("overflow: ");
            sb2.append(str);
            sb2.append("(");
            sb2.append(i10);
            sb2.append(", ");
            sb2.append(i11);
            sb2.append(")");
            throw new ArithmeticException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(String str, int i10) {
        if (i10 >= 0) {
            return i10;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 27);
        sb2.append(str);
        sb2.append(" (");
        sb2.append(i10);
        sb2.append(") must be >= 0");
        throw new IllegalArgumentException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(String str, int i10) {
        if (i10 > 0) {
            return i10;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 26);
        sb2.append(str);
        sb2.append(" (");
        sb2.append(i10);
        sb2.append(") must be > 0");
        throw new IllegalArgumentException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(boolean z10) {
        if (!z10) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
