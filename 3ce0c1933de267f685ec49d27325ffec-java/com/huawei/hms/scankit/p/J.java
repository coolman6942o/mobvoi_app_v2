package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UPCEANExtension2Support.java */
/* loaded from: classes2.dex */
public final class J {

    /* renamed from: a  reason: collision with root package name */
    private final int[] f14558a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    private final StringBuilder f14559b = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public x a(int i10, C0591h hVar, int[] iArr) throws C0550a {
        StringBuilder sb2 = this.f14559b;
        sb2.setLength(0);
        float f10 = i10;
        return new x(sb2.toString(), null, new z[]{new z((iArr[0] + iArr[1]) / 2.0f, f10), new z(a(hVar, iArr, sb2), f10)}, BarcodeFormat.UPC_EAN_EXTENSION);
    }

    private int a(C0591h hVar, int[] iArr, StringBuilder sb2) throws C0550a {
        int[] iArr2 = this.f14558a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int d10 = hVar.d();
        int i10 = iArr[1];
        int i11 = 0;
        for (int i12 = 0; i12 < 2 && i10 < d10; i12++) {
            int a10 = M.a(hVar, iArr2, i10, M.f14592e);
            sb2.append((char) ((a10 % 10) + 48));
            for (int i13 : iArr2) {
                i10 += i13;
            }
            if (a10 >= 10) {
                i11 |= 1 << (1 - i12);
            }
            if (i12 != 1) {
                i10 = hVar.c(hVar.b(i10));
            }
        }
        if (sb2.length() == 2) {
            try {
                if (Integer.parseInt(sb2.toString()) % 4 == i11) {
                    return i10;
                }
                throw C0550a.a();
            } catch (NumberFormatException unused) {
                throw C0550a.a();
            }
        } else {
            throw C0550a.a();
        }
    }
}
