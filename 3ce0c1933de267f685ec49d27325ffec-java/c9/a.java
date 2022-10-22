package c9;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.b;
import com.google.zxing.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* compiled from: Detector.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f5634a = {0, 4, 1, 5};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f5635b = {6, 2, 7, 3};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f5636c = {8, 1, 1, 1, 1, 1, 1, 3};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f5637d = {7, 1, 1, 3, 1, 1, 1, 2, 1};

    private static void a(i[] iVarArr, i[] iVarArr2, int[] iArr) {
        for (int i10 = 0; i10 < iArr.length; i10++) {
            iVarArr[iArr[i10]] = iVarArr2[i10];
        }
    }

    public static b b(b bVar, Map<DecodeHintType, ?> map, boolean z10) throws NotFoundException {
        com.google.zxing.common.b a10 = bVar.a();
        List<i[]> c10 = c(z10, a10);
        if (c10.isEmpty()) {
            a10 = a10.clone();
            a10.l();
            c10 = c(z10, a10);
        }
        return new b(a10, c10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r5 == 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
        r4 = r0.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r4.hasNext() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        r5 = (com.google.zxing.i[]) r4.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r5[1] == null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
        r3 = (int) java.lang.Math.max(r3, r5[1].d());
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0041, code lost:
        if (r5[3] == null) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0043, code lost:
        r3 = java.lang.Math.max(r3, (int) r5[3].d());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static List<i[]> c(boolean z10, com.google.zxing.common.b bVar) {
        int i10;
        float f10;
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 0;
        loop0: while (true) {
            int i13 = i12;
            while (true) {
                if (i11 >= bVar.g()) {
                    break loop0;
                }
                i[] f11 = f(bVar, i11, i12);
                if (f11[0] != null || f11[3] != null) {
                    arrayList.add(f11);
                    if (!z10) {
                        break loop0;
                    }
                    if (f11[2] != null) {
                        i10 = (int) f11[2].c();
                        f10 = f11[2].d();
                    } else {
                        i10 = (int) f11[4].c();
                        f10 = f11[4].d();
                    }
                    i11 = (int) f10;
                    i12 = i10;
                    i13 = 1;
                } else {
                    break;
                }
            }
            i11 += 5;
            i12 = 0;
        }
        return arrayList;
    }

    private static int[] d(com.google.zxing.common.b bVar, int i10, int i11, int i12, boolean z10, int[] iArr, int[] iArr2) {
        Arrays.fill(iArr2, 0, iArr2.length, 0);
        int i13 = 0;
        while (bVar.d(i10, i11) && i10 > 0) {
            i13++;
            if (i13 >= 3) {
                break;
            }
            i10--;
        }
        int length = iArr.length;
        boolean z11 = z10;
        int i14 = 0;
        int i15 = i10;
        while (i10 < i12) {
            if (bVar.d(i10, i11) ^ z11) {
                iArr2[i14] = iArr2[i14] + 1;
            } else {
                int i16 = length - 1;
                if (i14 != i16) {
                    i14++;
                } else if (g(iArr2, iArr, 0.8f) < 0.42f) {
                    return new int[]{i15, i10};
                } else {
                    i15 += iArr2[0] + iArr2[1];
                    int i17 = length - 2;
                    System.arraycopy(iArr2, 2, iArr2, 0, i17);
                    iArr2[i17] = 0;
                    iArr2[i16] = 0;
                    i14--;
                }
                iArr2[i14] = 1;
                z11 = !z11;
            }
            i10++;
        }
        if (i14 != length - 1 || g(iArr2, iArr, 0.8f) >= 0.42f) {
            return null;
        }
        return new int[]{i15, i10 - 1};
    }

    private static i[] e(com.google.zxing.common.b bVar, int i10, int i11, int i12, int i13, int[] iArr) {
        int i14;
        boolean z10;
        int i15;
        int i16;
        int i17;
        i[] iVarArr = new i[4];
        int[] iArr2 = new int[iArr.length];
        int i18 = i12;
        while (true) {
            if (i18 >= i10) {
                z10 = false;
                break;
            }
            int[] d10 = d(bVar, i13, i18, i11, false, iArr, iArr2);
            if (d10 != null) {
                int i19 = i18;
                int[] iArr3 = d10;
                while (true) {
                    if (i19 <= 0) {
                        i17 = i19;
                        break;
                    }
                    int i20 = i19 - 1;
                    int[] d11 = d(bVar, i13, i20, i11, false, iArr, iArr2);
                    if (d11 == null) {
                        i17 = i20 + 1;
                        break;
                    }
                    iArr3 = d11;
                    i19 = i20;
                }
                float f10 = i17;
                iVarArr[0] = new i(iArr3[0], f10);
                iVarArr[1] = new i(iArr3[1], f10);
                z10 = true;
                i18 = i17;
            } else {
                i18 += 5;
            }
        }
        int i21 = i18 + 1;
        if (z10) {
            int[] iArr4 = {(int) iVarArr[0].c(), (int) iVarArr[1].c()};
            int i22 = i21;
            int i23 = 0;
            while (true) {
                if (i22 >= i10) {
                    i15 = i23;
                    i16 = i22;
                    break;
                }
                i15 = i23;
                i16 = i22;
                int[] d12 = d(bVar, iArr4[0], i22, i11, false, iArr, iArr2);
                if (d12 == null || Math.abs(iArr4[0] - d12[0]) >= 5 || Math.abs(iArr4[1] - d12[1]) >= 5) {
                    if (i15 > 25) {
                        break;
                    }
                    i23 = i15 + 1;
                } else {
                    iArr4 = d12;
                    i23 = 0;
                }
                i22 = i16 + 1;
            }
            i21 = i16 - (i15 + 1);
            float f11 = i21;
            iVarArr[2] = new i(iArr4[0], f11);
            iVarArr[3] = new i(iArr4[1], f11);
        }
        if (i21 - i18 < 10) {
            for (i14 = 0; i14 < 4; i14++) {
                iVarArr[i14] = null;
            }
        }
        return iVarArr;
    }

    private static i[] f(com.google.zxing.common.b bVar, int i10, int i11) {
        int g10 = bVar.g();
        int k10 = bVar.k();
        i[] iVarArr = new i[8];
        a(iVarArr, e(bVar, g10, k10, i10, i11, f5636c), f5634a);
        if (iVarArr[4] != null) {
            i11 = (int) iVarArr[4].c();
            i10 = (int) iVarArr[4].d();
        }
        a(iVarArr, e(bVar, g10, k10, i10, i11, f5637d), f5635b);
        return iVarArr;
    }

    private static float g(int[] iArr, int[] iArr2, float f10) {
        int length = iArr.length;
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            i10 += iArr[i12];
            i11 += iArr2[i12];
        }
        if (i10 < i11) {
            return Float.POSITIVE_INFINITY;
        }
        float f11 = i10;
        float f12 = f11 / i11;
        float f13 = f10 * f12;
        float f14 = 0.0f;
        for (int i13 = 0; i13 < length; i13++) {
            float f15 = iArr2[i13] * f12;
            float f16 = iArr[i13];
            float f17 = f16 > f15 ? f16 - f15 : f15 - f16;
            if (f17 > f13) {
                return Float.POSITIVE_INFINITY;
            }
            f14 += f17;
        }
        return f14 / f11;
    }
}
