package com.huawei.hms.scankit.p;

import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import java.util.Map;
/* compiled from: UPCAWriter.java */
/* renamed from: com.huawei.hms.scankit.p.ec  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0582ec implements AbstractC0648zb {

    /* renamed from: a  reason: collision with root package name */
    private final C0566ac f14787a = new C0566ac();

    @Override // com.huawei.hms.scankit.p.AbstractC0648zb
    public C0595i a(String str, BarcodeFormat barcodeFormat, int i10, int i11, Map<tc, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.UPC_A) {
            C0566ac acVar = this.f14787a;
            return acVar.a('0' + str, BarcodeFormat.EAN_13, i10, i11, map);
        }
        throw new IllegalArgumentException("Can only encode UPC-A, but got " + barcodeFormat);
    }
}
