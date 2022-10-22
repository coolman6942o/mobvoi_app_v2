package rg;
/* compiled from: PressureUtil.java */
/* loaded from: classes2.dex */
public class b {
    public static double a(int[] iArr, double d10, int i10, int i11) {
        if (iArr.length - 1 < i10) {
            return 0.0d;
        }
        double d11 = d10;
        if (d10 <= 0.0d) {
            for (int i12 : iArr) {
                d11 += i12;
            }
        }
        double pow = Math.pow(10.0d, i11);
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i13 = 0; i13 < iArr.length; i13++) {
            dArr[i13] = (iArr[i13] / d11) * pow * 100.0d;
        }
        double d12 = 100.0d * pow;
        int length2 = iArr.length;
        double[] dArr2 = new double[length2];
        for (int i14 = 0; i14 < length; i14++) {
            dArr2[i14] = Math.floor(dArr[i14]);
        }
        double d13 = 0.0d;
        for (int i15 = 0; i15 < length2; i15++) {
            d13 += dArr2[i15];
        }
        int length3 = iArr.length;
        double[] dArr3 = new double[length3];
        for (int i16 = 0; i16 < length2; i16++) {
            dArr3[i16] = dArr[i16] - dArr2[i16];
        }
        while (d13 < d12) {
            int i17 = 0;
            double d14 = 0.0d;
            for (int i18 = 0; i18 < length3; i18++) {
                if (dArr3[i18] > d14) {
                    d14 = dArr3[i18];
                    i17 = i18;
                }
            }
            dArr2[i17] = dArr2[i17] + 1.0d;
            dArr3[i17] = 0.0d;
            d13 += 1.0d;
        }
        return dArr2[i10] / pow;
    }
}
