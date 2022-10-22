package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
/* compiled from: EAN8Reader.java */
/* loaded from: classes2.dex */
public final class D extends M {

    /* renamed from: h  reason: collision with root package name */
    private final int[] f14488h = new int[4];

    private int b(C0591h hVar, int[] iArr, int i10, int[][] iArr2) throws C0550a {
        H.a(hVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.43f;
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
        return hVar.a(i11, ((int) ((i11 - i10) * 1.5d)) + i11, false, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.scankit.p.M
    public int a(C0591h hVar, int[] iArr, StringBuilder sb2) throws C0550a {
        int[] iArr2 = this.f14488h;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int d10 = hVar.d();
        int i10 = iArr[1];
        for (int i11 = 0; i11 < 4 && i10 < d10; i11++) {
            sb2.append((char) (b(hVar, iArr2, i10, M.f14591d) + 48));
            for (int i12 : iArr2) {
                i10 += i12;
            }
        }
        int i13 = M.a(hVar, i10, true, M.f14589b)[1];
        for (int i14 = 0; i14 < 4 && i13 < d10; i14++) {
            sb2.append((char) (b(hVar, iArr2, i13, M.f14591d) + 48));
            for (int i15 : iArr2) {
                i13 += i15;
            }
        }
        return i13;
    }

    @Override // com.huawei.hms.scankit.p.M
    BarcodeFormat a() {
        return BarcodeFormat.EAN_8;
    }

    @Override // com.huawei.hms.scankit.p.M
    boolean a(int[] iArr, int[] iArr2) throws C0550a {
        return ((double) Math.abs(((int) Math.round(((double) (iArr2[1] - iArr[0])) / (((double) ((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0]))) / 6.0d))) + (-67))) <= 6.7d && Math.abs(1.0d - ((((double) (iArr[1] - iArr[0])) / 3.0d) / (((double) (iArr2[1] - iArr2[0])) / 3.0d))) < 0.2d;
    }
}
