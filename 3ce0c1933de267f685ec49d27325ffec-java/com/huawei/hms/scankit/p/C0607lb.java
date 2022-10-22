package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.x;
/* compiled from: ISBNResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.lb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0607lb extends AbstractC0619pb {
    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        if (AbstractC0619pb.a(xVar.b()) != HmsScanBase.EAN13_SCAN_TYPE) {
            return null;
        }
        String a10 = AbstractC0619pb.a(xVar);
        if (a10.length() != 13) {
            return null;
        }
        if (a10.startsWith("978") || a10.startsWith("979")) {
            return new HmsScan(xVar.g(), AbstractC0619pb.a(xVar.b()), a10, HmsScan.ISBN_NUMBER_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, null);
        }
        return null;
    }
}
