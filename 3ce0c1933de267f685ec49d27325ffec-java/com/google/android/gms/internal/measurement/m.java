package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    protected static final Charset f9496a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    public static final Object f9497b = new Object();

    static {
        Charset.forName("ISO-8859-1");
    }

    public static boolean a(long[] jArr, long[] jArr2) {
        return (jArr == null || jArr.length == 0) ? jArr2 == null || jArr2.length == 0 : Arrays.equals(jArr, jArr2);
    }

    public static boolean b(Object[] objArr, Object[] objArr2) {
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            if (i10 >= length || objArr[i10] != null) {
                while (i11 < length2 && objArr2[i11] == null) {
                    i11++;
                }
                boolean z10 = i10 >= length;
                boolean z11 = i11 >= length2;
                if (z10 && z11) {
                    return true;
                }
                if (z10 != z11 || !objArr[i10].equals(objArr2[i11])) {
                    return false;
                }
                i10++;
                i11++;
            } else {
                i10++;
            }
        }
    }

    public static int c(long[] jArr) {
        if (jArr == null || jArr.length == 0) {
            return 0;
        }
        return Arrays.hashCode(jArr);
    }

    public static int d(Object[] objArr) {
        int length = objArr == null ? 0 : objArr.length;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            Object obj = objArr[i11];
            if (obj != null) {
                i10 = (i10 * 31) + obj.hashCode();
            }
        }
        return i10;
    }

    public static void e(i iVar, i iVar2) {
        k kVar = iVar.f9353b;
        if (kVar != null) {
            iVar2.f9353b = (k) kVar.clone();
        }
    }
}
