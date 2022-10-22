package com.huawei.hms.scankit.p;

import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.aiscan.common.x;
/* compiled from: ProductResultParser.java */
/* renamed from: com.huawei.hms.scankit.p.ob  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0616ob extends AbstractC0619pb {
    @Override // com.huawei.hms.scankit.p.AbstractC0619pb
    public HmsScan b(x xVar) {
        int a10 = AbstractC0619pb.a(xVar.b());
        if (a10 != HmsScanBase.EAN13_SCAN_TYPE && a10 != HmsScanBase.EAN8_SCAN_TYPE && a10 != HmsScanBase.UPCCODE_A_SCAN_TYPE && a10 != HmsScanBase.UPCCODE_E_SCAN_TYPE) {
            return null;
        }
        String a11 = AbstractC0619pb.a(xVar);
        if (!AbstractC0619pb.a(a11, a11.length())) {
            return null;
        }
        return new HmsScan(a11, AbstractC0619pb.a(xVar.b()), a11, HmsScan.ARTICLE_NUMBER_FORM, xVar.e(), AbstractC0619pb.a(xVar.f()), null, null);
    }
}
