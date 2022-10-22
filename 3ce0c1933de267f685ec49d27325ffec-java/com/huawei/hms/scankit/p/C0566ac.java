package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import java.util.Map;
/* compiled from: EAN13Writer.java */
/* renamed from: com.huawei.hms.scankit.p.ac  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0566ac extends AbstractC0586fc {
    @Override // com.huawei.hms.scankit.p.AbstractC0578dc, com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_13) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0578dc
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + M.b(str);
            } catch (C0550a e10) {
                throw new IllegalArgumentException(e10);
            }
        } else if (length == 13) {
            try {
                if (!M.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (C0550a unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got " + length);
        }
        int i10 = C.f14471h[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int a10 = AbstractC0578dc.a(zArr, 0, M.f14588a, true) + 0;
        for (int i11 = 1; i11 <= 6; i11++) {
            int digit = Character.digit(str.charAt(i11), 10);
            if (((i10 >> (6 - i11)) & 1) == 1) {
                digit += 10;
            }
            a10 += AbstractC0578dc.a(zArr, a10, M.f14592e[digit], false);
        }
        int a11 = a10 + AbstractC0578dc.a(zArr, a10, M.f14589b, false);
        for (int i12 = 7; i12 <= 12; i12++) {
            a11 += AbstractC0578dc.a(zArr, a11, M.f14591d[Character.digit(str.charAt(i12), 10)], true);
        }
        AbstractC0578dc.a(zArr, a11, M.f14588a, true);
        return zArr;
    }
}
