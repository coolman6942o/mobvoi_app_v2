package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
/* compiled from: EAN13Reader.java */
/* loaded from: classes2.dex */
public final class C extends M {

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f14471h = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    /* renamed from: j  reason: collision with root package name */
    private String f14473j = "";

    /* renamed from: i  reason: collision with root package name */
    private final int[] f14472i = new int[4];

    @Override // com.huawei.hms.scankit.p.M
    boolean a(int i10, int i11, C0591h hVar) {
        return hVar.a(i11, (i11 - i10) + i11, false, false);
    }

    @Override // com.huawei.hms.scankit.p.M
    protected int a(C0591h hVar, int[] iArr, StringBuilder sb2) throws C0550a {
        int[] iArr2 = this.f14472i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int d10 = hVar.d();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 6 && i10 < d10; i12++) {
            int a10 = M.a(hVar, iArr2, i10, M.f14592e);
            sb2.append((char) ((a10 % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (a10 >= 10) {
                i11 |= 1 << (5 - i12);
            }
        }
        a(sb2, i11);
        this.f14473j = sb2.substring(0, 1);
        int i14 = M.a(hVar, i10, true, M.f14589b)[1];
        for (int i15 = 0; i15 < 6 && i14 < d10; i15++) {
            sb2.append((char) (M.a(hVar, iArr2, i14, M.f14591d) + 48));
            for (int i16 : iArr2) {
                i14 += i16;
            }
        }
        if (a(sb2)) {
            return i14;
        }
        throw C0550a.a();
    }

    @Override // com.huawei.hms.scankit.p.M
    BarcodeFormat a() {
        return BarcodeFormat.EAN_13;
    }

    private static void a(StringBuilder sb2, int i10) throws C0550a {
        for (int i11 = 0; i11 < 10; i11++) {
            if (i10 == f14471h[i11]) {
                sb2.insert(0, (char) (i11 + 48));
                return;
            }
        }
        throw C0550a.a();
    }

    private static boolean a(StringBuilder sb2) {
        int charAt = sb2.charAt(sb2.length() - 1) - '0';
        int i10 = 0;
        for (int i11 = 0; i11 < sb2.length() - 1; i11++) {
            i10 += i11 % 2 == 0 ? sb2.charAt(i11) - '0' : (sb2.charAt(i11) - '0') * 3;
        }
        return (i10 + charAt) % 10 == 0;
    }

    @Override // com.huawei.hms.scankit.p.M
    boolean a(int[] iArr, int[] iArr2) throws C0550a {
        int round = (int) Math.round((iArr2[1] - iArr[0]) / (((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0])) / 6.0d));
        return this.f14473j.equals("0") ? ((double) Math.abs(round + (-95))) <= 18.05d || ((double) Math.abs(round + (-113))) <= 21.47d : ((double) Math.abs(round + (-95))) <= 18.05d;
    }
}
