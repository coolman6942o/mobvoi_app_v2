package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.Arrays;
import java.util.Map;
/* compiled from: ITFReader.java */
/* loaded from: classes2.dex */
public final class E extends H {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14499a = {6, 8, 10, 12, 14};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14500b = {1, 1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f14501c = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    /* renamed from: d  reason: collision with root package name */
    public static final int[][] f14502d = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    /* renamed from: e  reason: collision with root package name */
    private int f14503e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f14504f = -1;

    private int[] b(C0591h hVar) throws C0550a {
        int c10 = c(hVar);
        while (true) {
            int[] c11 = c(hVar, c10, f14500b);
            this.f14503e = (c11[1] - c11[0]) / 4;
            if (a(hVar, c11[0])) {
                return c11;
            }
            c10 = c11[2];
        }
    }

    private static int c(C0591h hVar) throws C0550a {
        int d10 = hVar.d();
        int b10 = hVar.b(0);
        if (b10 != d10) {
            return b10;
        }
        throw C0550a.a();
    }

    @Override // com.huawei.hms.scankit.p.H
    public x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a, C0550a {
        boolean z10;
        int[] b10 = b(hVar);
        int[] a10 = a(hVar);
        StringBuilder sb2 = new StringBuilder(20);
        a(hVar, b10[1], a10[0], sb2);
        String sb3 = sb2.toString();
        int[] iArr = f14499a;
        int length = sb3.length();
        int length2 = iArr.length;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i11 >= length2) {
                z10 = false;
                break;
            }
            int i13 = iArr[i11];
            if (length == i13) {
                z10 = true;
                break;
            }
            if (i13 > i12) {
                i12 = i13;
            }
            i11++;
        }
        if (!z10 && length > i12) {
            z10 = true;
        }
        if (z10) {
            float f10 = i10;
            return new x(sb3, null, new z[]{new z(b10[0], f10), new z(a10[1], f10)}, BarcodeFormat.ITF);
        }
        throw C0550a.a();
    }

    private int[] c(C0591h hVar, int i10, int[] iArr) throws C0550a {
        int i11;
        char c10;
        int[] iArr2;
        int length = iArr.length;
        int[] iArr3 = new int[length];
        int d10 = hVar.d();
        char c11 = 0;
        int i12 = i10;
        int i13 = i12;
        boolean z10 = false;
        int i14 = 0;
        while (i12 < d10) {
            if (hVar.a(i12) == z10) {
                if (i14 == length - 1) {
                    Arrays.sort((int[]) iArr3.clone());
                    i11 = d10;
                    if (((iArr2[2] + iArr2[3]) * 0.5d) / ((iArr2[c11] + iArr2[1]) * 0.5d) >= 4.0d || (iArr2[3] * 1.0d) / iArr2[0] > 3.0d) {
                        c10 = 0;
                        i13 += iArr3[0] + iArr3[1];
                        int i15 = i14 - 1;
                        System.arraycopy(iArr3, 2, iArr3, 0, i15);
                        iArr3[i15] = 0;
                        iArr3[i14] = 0;
                        i14--;
                    } else {
                        int[] iArr4 = new int[10];
                        H.a(hVar, i12, iArr4);
                        this.f14504f = -1;
                        for (int i16 = 0; i16 < 10; i16++) {
                            if (iArr4[i16] > this.f14504f) {
                                this.f14504f = iArr4[i16];
                            }
                        }
                        return new int[]{i13, i12, i13 + iArr3[0] + iArr3[1]};
                    }
                } else {
                    i11 = d10;
                    c10 = c11;
                    i14++;
                }
                iArr3[i14] = 1;
                z10 = !z10;
            } else if (i14 < 0 || i14 >= length) {
                throw C0550a.a();
            } else {
                iArr3[i14] = iArr3[i14] + 1;
                i11 = d10;
                c10 = c11;
            }
            i12++;
            c11 = c10;
            d10 = i11;
        }
        throw C0550a.a();
    }

    private int[] b(C0591h hVar, int i10, int[] iArr) throws C0550a {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int d10 = hVar.d();
        int i11 = i10;
        int i12 = i11;
        boolean z10 = false;
        int i13 = 0;
        while (i11 < d10) {
            if (hVar.a(i11) == z10) {
                if (i13 != length - 1) {
                    i13++;
                } else if (Math.min(iArr2[0], iArr2[1]) == 0 || Math.max(iArr2[0], iArr2[1]) == 0) {
                    throw C0550a.a();
                } else {
                    float f10 = (iArr2[2] * 2.0f) / (iArr2[0] + iArr2[1]);
                    if (((float) Math.max(iArr2[0], iArr2[1])) / ((float) Math.min(iArr2[0], iArr2[1])) <= 3.0f && ((double) f10) > 1.5d && f10 < 4.0f) {
                        return new int[]{i12, i11, i12 + iArr2[0] + iArr2[1]};
                    }
                    i12 += iArr2[0] + iArr2[1];
                    int i14 = i13 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i14);
                    iArr2[i14] = 0;
                    iArr2[i13] = 0;
                    i13--;
                }
                iArr2[i13] = 1;
                z10 = !z10;
            } else if (i13 < 0 || i13 >= length) {
                throw C0550a.a();
            } else {
                iArr2[i13] = iArr2[i13] + 1;
            }
            i11++;
        }
        throw C0550a.a();
    }

    private static void a(C0591h hVar, int i10, int i11, StringBuilder sb2) throws C0550a {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i10 < i11) {
            H.a(hVar, i10, iArr);
            int i12 = -1;
            int i13 = 10000;
            for (int i14 = 0; i14 < 10; i14++) {
                if (i12 <= iArr[i14]) {
                    i12 = iArr[i14];
                }
                if (i13 >= iArr[i14]) {
                    i13 = iArr[i14];
                }
            }
            if (i12 / i13 <= 8) {
                for (int i15 = 0; i15 < 5; i15++) {
                    int i16 = i15 * 2;
                    iArr2[i15] = iArr[i16];
                    iArr3[i15] = iArr[i16 + 1];
                }
                sb2.append((char) (b(iArr2) + 48));
                sb2.append((char) (b(iArr3) + 48));
                for (int i17 = 0; i17 < 10; i17++) {
                    i10 += iArr[i17];
                }
            } else {
                throw C0550a.a();
            }
        }
        if (i10 != i11) {
            throw C0550a.a();
        }
    }

    private static int b(int[] iArr) throws C0550a {
        int length = f14502d.length;
        float f10 = 0.3f;
        int i10 = -1;
        for (int i11 = 0; i11 < length; i11++) {
            float a10 = H.a(iArr, f14502d[i11], 0.75f);
            if (a10 < f10) {
                i10 = i11;
                f10 = a10;
            } else if (Math.abs(a10 - f10) < 1.0E-7d) {
                i10 = -1;
            }
        }
        if (i10 >= 0) {
            return i10 % 10;
        }
        throw C0550a.a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean a(C0591h hVar, int i10) {
        int i11 = this.f14503e * 10;
        int i12 = (int) (this.f14504f * 1.5d);
        if (i11 < i12) {
            i11 = i12;
        }
        for (int i13 = i10 - 1; i11 > 0 && i13 >= 0 && !hVar.a(i13); i13--) {
            i11--;
        }
        return true;
    }

    private int[] a(C0591h hVar) throws C0550a {
        try {
            hVar.g();
            int c10 = c(hVar);
            while (true) {
                int[] b10 = b(hVar, c10, f14501c[0]);
                if (a(hVar, b10[0])) {
                    int i10 = b10[0];
                    b10[0] = hVar.d() - b10[1];
                    b10[1] = hVar.d() - i10;
                    return b10;
                }
                c10 = b10[2];
            }
        } finally {
            hVar.g();
        }
    }
}
