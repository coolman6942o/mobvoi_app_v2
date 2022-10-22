package com.google.common.primitives;

import com.google.common.base.p;
/* compiled from: UnsignedInts.java */
/* loaded from: classes.dex */
public final class j {
    public static int a(int i10, int i11) {
        return d.d(c(i10), c(i11));
    }

    public static int b(int i10, int i11) {
        return (int) (f(i10) / f(i11));
    }

    static int c(int i10) {
        return i10 ^ Integer.MIN_VALUE;
    }

    public static int d(String str, int i10) {
        p.o(str);
        long parseLong = Long.parseLong(str, i10);
        if ((4294967295L & parseLong) == parseLong) {
            return (int) parseLong;
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 69);
        sb2.append("Input ");
        sb2.append(str);
        sb2.append(" in base ");
        sb2.append(i10);
        sb2.append(" is not in the range of an unsigned integer");
        throw new NumberFormatException(sb2.toString());
    }

    public static int e(int i10, int i11) {
        return (int) (f(i10) % f(i11));
    }

    public static long f(int i10) {
        return i10 & 4294967295L;
    }

    public static String g(int i10, int i11) {
        return Long.toString(i10 & 4294967295L, i11);
    }
}
