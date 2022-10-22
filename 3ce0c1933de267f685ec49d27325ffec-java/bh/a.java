package bh;

import android.graphics.Color;
/* compiled from: ColorUtils.java */
/* loaded from: classes2.dex */
public class a {
    private static int a(int i10, int i11, float f10) {
        return i10 + Math.round(f10 * (i11 - i10));
    }

    public static int b(int i10, int i11, float f10) {
        return Color.rgb(a(Color.red(i10), Color.red(i11), f10), a(Color.green(i10), Color.green(i11), f10), a(Color.blue(i10), Color.blue(i11), f10));
    }

    public static int c(int[] iArr, float[] fArr, float f10) {
        int length = fArr.length;
        if (f10 <= fArr[0]) {
            return iArr[0];
        }
        int i10 = length - 1;
        if (f10 >= fArr[i10]) {
            return iArr[i10];
        }
        int i11 = 1;
        while (i11 < length && f10 > fArr[i11]) {
            if (fArr[i11] == f10) {
                return iArr[i11];
            }
            i11++;
        }
        int i12 = i11 - 1;
        return b(iArr[i12], iArr[i11], (f10 - fArr[i12]) / (fArr[i11] - fArr[i12]));
    }
}
