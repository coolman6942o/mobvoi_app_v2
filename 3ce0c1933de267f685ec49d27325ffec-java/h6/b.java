package h6;

import b6.h;
import java.lang.reflect.Array;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class b {
    public static <T> T[] a(T[]... tArr) {
        if (tArr.length == 0) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
        }
        int i10 = 0;
        for (T[] tArr2 : tArr) {
            i10 += tArr2.length;
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], i10);
        int length = tArr[0].length;
        for (int i11 = 1; i11 < tArr.length; i11++) {
            T[] tArr4 = tArr[i11];
            System.arraycopy(tArr4, 0, tArr3, length, tArr4.length);
            length += tArr4.length;
        }
        return tArr3;
    }

    public static <T> boolean b(T[] tArr, T t10) {
        int length = tArr != null ? tArr.length : 0;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                i10 = -1;
                break;
            } else if (h.a(tArr[i10], t10)) {
                break;
            } else {
                i10++;
            }
        }
        return i10 >= 0;
    }

    public static <T> T[] c(T[] tArr, T... tArr2) {
        int i10;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || tArr2.length == 0) {
            return (T[]) Arrays.copyOf(tArr, tArr.length);
        }
        T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length));
        if (tArr2.length == 1) {
            i10 = 0;
            for (T t10 : tArr) {
                if (!h.a(tArr2[0], t10)) {
                    i10++;
                    tArr3[i10] = t10;
                }
            }
        } else {
            int i11 = 0;
            for (T t11 : tArr) {
                if (!b(tArr2, t11)) {
                    i11++;
                    tArr3[i11] = t11;
                }
            }
            i10 = i11;
        }
        if (tArr3 == null) {
            return null;
        }
        return i10 != tArr3.length ? (T[]) Arrays.copyOf(tArr3, i10) : tArr3;
    }

    public static void d(StringBuilder sb2, double[] dArr) {
        int length = dArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Double.toString(dArr[i10]));
        }
    }

    public static void e(StringBuilder sb2, float[] fArr) {
        int length = fArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Float.toString(fArr[i10]));
        }
    }

    public static void f(StringBuilder sb2, int[] iArr) {
        int length = iArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Integer.toString(iArr[i10]));
        }
    }

    public static void g(StringBuilder sb2, long[] jArr) {
        int length = jArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Long.toString(jArr[i10]));
        }
    }

    public static <T> void h(StringBuilder sb2, T[] tArr) {
        int length = tArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(tArr[i10].toString());
        }
    }

    public static void i(StringBuilder sb2, boolean[] zArr) {
        int length = zArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append(Boolean.toString(zArr[i10]));
        }
    }

    public static void j(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            if (i10 != 0) {
                sb2.append(",");
            }
            sb2.append("\"");
            sb2.append(strArr[i10]);
            sb2.append("\"");
        }
    }
}
