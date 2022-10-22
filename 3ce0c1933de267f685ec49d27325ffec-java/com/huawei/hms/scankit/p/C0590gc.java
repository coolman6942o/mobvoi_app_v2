package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import java.util.Map;
/* compiled from: UPCEWriter.java */
/* renamed from: com.huawei.hms.scankit.p.gc  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0590gc extends AbstractC0586fc {
    @Override // com.huawei.hms.scankit.p.AbstractC0578dc, com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_E) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0578dc
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + M.b(N.b(str));
            } catch (C0550a e10) {
                throw new IllegalArgumentException(e10);
            }
        } else if (length == 8) {
            try {
                if (!M.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (C0550a unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got " + length);
        }
        int digit = Character.digit(str.charAt(0), 10);
        if (digit == 0 || digit == 1) {
            int i10 = N.f14596i[digit][Character.digit(str.charAt(7), 10)];
            boolean[] zArr = new boolean[51];
            int a10 = AbstractC0578dc.a(zArr, 0, M.f14588a, true) + 0;
            for (int i11 = 1; i11 <= 6; i11++) {
                int digit2 = Character.digit(str.charAt(i11), 10);
                if (((i10 >> (6 - i11)) & 1) == 1) {
                    digit2 += 10;
                }
                a10 += AbstractC0578dc.a(zArr, a10, M.f14592e[digit2], false);
            }
            AbstractC0578dc.a(zArr, a10, M.f14590c, false);
            return zArr;
        }
        throw new IllegalArgumentException("Number system must be 0 or 1");
    }
}
