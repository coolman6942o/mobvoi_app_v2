package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import com.huawei.hms.scankit.util.b;
import java.util.ArrayList;
import java.util.List;
/* compiled from: MultipleBarcodeDetector.java */
/* renamed from: com.huawei.hms.scankit.p.x  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0640x {

    /* renamed from: a  reason: collision with root package name */
    public List<C0634v> f14999a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private int f15000b = 0;

    public void a(boolean z10, byte[] bArr, int i10, int i11, int i12, boolean z11) {
        float[] multiBarcodeDetect = LoadOpencvJNIUtil.multiBarcodeDetect(bArr, i10, i11, i12, z11);
        if (multiBarcodeDetect != null) {
            this.f15000b = multiBarcodeDetect.length / 10;
        } else {
            this.f15000b = 0;
        }
        for (int i13 = 0; i13 < this.f15000b; i13++) {
            int i14 = i13 * 10;
            if (b.a(multiBarcodeDetect, i14)) {
                int i15 = i14 + 1;
                if (b.a(multiBarcodeDetect, i15)) {
                    int i16 = i14 + 2;
                    if (b.a(multiBarcodeDetect, i16)) {
                        int i17 = i14 + 3;
                        if (b.a(multiBarcodeDetect, i17)) {
                            int i18 = i14 + 4;
                            if (b.a(multiBarcodeDetect, i18)) {
                                int i19 = i14 + 5;
                                if (b.a(multiBarcodeDetect, i19)) {
                                    int i20 = i14 + 6;
                                    if (b.a(multiBarcodeDetect, i20)) {
                                        int i21 = i14 + 7;
                                        if (b.a(multiBarcodeDetect, i21)) {
                                            int i22 = i14 + 8;
                                            if (b.a(multiBarcodeDetect, i22)) {
                                                int i23 = i14 + 9;
                                                if (b.a(multiBarcodeDetect, i23)) {
                                                    this.f14999a.add(new C0634v(z10, multiBarcodeDetect[i14], multiBarcodeDetect[i15], multiBarcodeDetect[i16], multiBarcodeDetect[i17], multiBarcodeDetect[i18], multiBarcodeDetect[i19], multiBarcodeDetect[i20], multiBarcodeDetect[i21], multiBarcodeDetect[i22], multiBarcodeDetect[i23]));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
