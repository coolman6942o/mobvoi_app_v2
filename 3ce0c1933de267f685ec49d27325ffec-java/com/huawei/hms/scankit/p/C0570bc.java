package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import java.util.Map;
/* compiled from: EAN8Writer.java */
/* renamed from: com.huawei.hms.scankit.p.bc  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0570bc extends AbstractC0586fc {
    @Override // com.huawei.hms.scankit.p.AbstractC0578dc, com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.EAN_8) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0578dc
    public boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + M.b(str);
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
        boolean[] zArr = new boolean[67];
        int a10 = AbstractC0578dc.a(zArr, 0, M.f14588a, true) + 0;
        for (int i10 = 0; i10 <= 3; i10++) {
            a10 += AbstractC0578dc.a(zArr, a10, M.f14591d[Character.digit(str.charAt(i10), 10)], false);
        }
        int a11 = a10 + AbstractC0578dc.a(zArr, a10, M.f14589b, false);
        for (int i11 = 4; i11 <= 7; i11++) {
            a11 += AbstractC0578dc.a(zArr, a11, M.f14591d[Character.digit(str.charAt(i11), 10)], true);
        }
        AbstractC0578dc.a(zArr, a11, M.f14588a, true);
        return zArr;
    }
}
