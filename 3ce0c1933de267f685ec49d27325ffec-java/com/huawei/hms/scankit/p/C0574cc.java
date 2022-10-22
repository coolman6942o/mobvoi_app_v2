package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;
/* compiled from: ITFWriter.java */
/* renamed from: com.huawei.hms.scankit.p.cc  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0574cc extends AbstractC0578dc {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f14756a = {1, 1, 1, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f14757b = {3, 1, 1};

    @Override // com.huawei.hms.scankit.p.AbstractC0578dc, com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got " + barcodeFormat);
    }

    @Override // com.huawei.hms.scankit.p.AbstractC0578dc
    public boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length <= 80) {
            boolean[] zArr = new boolean[(length * 9) + 9];
            int a10 = AbstractC0578dc.a(zArr, 0, f14756a, true);
            for (int i10 = 0; i10 < length; i10 += 2) {
                int digit = Character.digit(str.charAt(i10), 10);
                int digit2 = Character.digit(str.charAt(i10 + 1), 10);
                int[] iArr = new int[10];
                for (int i11 = 0; i11 < 5; i11++) {
                    int i12 = i11 * 2;
                    int[][] iArr2 = E.f14502d;
                    iArr[i12] = iArr2[digit][i11];
                    iArr[i12 + 1] = iArr2[digit2][i11];
                }
                a10 += AbstractC0578dc.a(zArr, a10, iArr, true);
            }
            AbstractC0578dc.a(zArr, a10, f14757b, true);
            return zArr;
        } else {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length);
        }
    }
}
