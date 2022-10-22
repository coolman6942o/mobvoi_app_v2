package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
/* compiled from: UPCEReader.java */
/* loaded from: classes2.dex */
public final class N extends M {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f14595h = {1, 1, 1, 1, 1, 1};

    /* renamed from: i  reason: collision with root package name */
    public static final int[][] f14596i = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: j  reason: collision with root package name */
    private final int[] f14597j = new int[4];

    private int b(C0591h hVar, int[] iArr, int i10, int[][] iArr2) throws C0550a {
        H.a(hVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.45f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float a10 = H.a(iArr, iArr2[i12], 0.7f);
            if (a10 < f10) {
                i11 = i12;
                f10 = a10;
            }
        }
        if (i11 >= 0) {
            return i11;
        }
        throw C0550a.a();
    }

    @Override // com.huawei.hms.scankit.p.M
    public boolean a(int i10, int i11, C0591h hVar) {
        return hVar.a(i11, (i11 - i10) + i11, false, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.scankit.p.M
    public int a(C0591h hVar, int[] iArr, StringBuilder sb2) throws C0550a {
        int[][] iArr2;
        int[] iArr3 = this.f14597j;
        int i10 = 0;
        iArr3[0] = 0;
        iArr3[1] = 0;
        iArr3[2] = 0;
        iArr3[3] = 0;
        int d10 = hVar.d();
        int i11 = iArr[1];
        float f10 = 10000.0f;
        int i12 = 0;
        int i13 = 0;
        float f11 = 0.0f;
        while (i12 < 6 && i11 < d10) {
            int b10 = b(hVar, iArr3, i11, M.f14592e);
            sb2.append((char) ((b10 % 10) + 48));
            int i14 = i10;
            float f12 = 0.0f;
            while (true) {
                if (i14 >= M.f14592e[b10].length) {
                    break;
                }
                f12 += iArr2[b10][i14];
                i14++;
            }
            float f13 = (((iArr3[i10] + iArr3[1]) + iArr3[2]) + iArr3[3]) / f12;
            if (f13 > f11) {
                f11 = f13;
            }
            if (f13 < f10) {
                f10 = f13;
            }
            int length = iArr3.length;
            while (i10 < length) {
                i11 += iArr3[i10];
                i10++;
            }
            if (b10 >= 10) {
                i13 |= 1 << (5 - i12);
            }
            i12++;
            i10 = 0;
        }
        if (f11 / f10 <= 2.89d) {
            a(sb2, i13);
            return i11;
        }
        throw C0550a.a();
    }

    public static String b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb2 = new StringBuilder(12);
        sb2.append(str.charAt(0));
        char c10 = cArr[5];
        switch (c10) {
            case '0':
            case '1':
            case '2':
                sb2.append(cArr, 0, 2);
                sb2.append(c10);
                sb2.append("0000");
                sb2.append(cArr, 2, 3);
                break;
            case '3':
                sb2.append(cArr, 0, 3);
                sb2.append("00000");
                sb2.append(cArr, 3, 2);
                break;
            case '4':
                sb2.append(cArr, 0, 4);
                sb2.append("00000");
                sb2.append(cArr[4]);
                break;
            default:
                sb2.append(cArr, 0, 5);
                sb2.append("0000");
                sb2.append(c10);
                break;
        }
        if (str.length() >= 8) {
            sb2.append(str.charAt(7));
        }
        return sb2.toString();
    }

    @Override // com.huawei.hms.scankit.p.M
    protected int[] a(C0591h hVar, int i10) throws C0550a {
        return M.a(hVar, i10, true, f14595h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.scankit.p.M
    public boolean a(String str) throws C0550a {
        return super.a(b(str));
    }

    private static void a(StringBuilder sb2, int i10) throws C0550a {
        for (int i11 = 0; i11 <= 1; i11++) {
            for (int i12 = 0; i12 < 10; i12++) {
                if (i10 == f14596i[i11][i12]) {
                    sb2.insert(0, (char) (i11 + 48));
                    sb2.append((char) (i12 + 48));
                    return;
                }
            }
        }
        throw C0550a.a();
    }

    @Override // com.huawei.hms.scankit.p.M
    BarcodeFormat a() {
        return BarcodeFormat.UPC_E;
    }

    @Override // com.huawei.hms.scankit.p.M
    boolean a(int[] iArr, int[] iArr2) throws C0550a {
        return ((double) Math.abs(((int) Math.round(((double) (iArr2[1] - iArr[0])) / (((double) ((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0]))) / 9.0d))) + (-51))) <= 10.200000000000001d && Math.abs(1.0d - ((((double) (iArr[1] - iArr[0])) / 3.0d) / (((double) (iArr2[1] - iArr2[0])) / 6.0d))) < 0.2d;
    }
}
