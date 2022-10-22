package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.A;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.t;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.Map;
/* compiled from: AztecReader.java */
/* renamed from: com.huawei.hms.scankit.p.b  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0567b implements t {
    @Override // com.huawei.hms.scankit.aiscan.common.t
    public x a(C0587g gVar, Map<EnumC0553d, ?> map) throws C0550a {
        z[] zVarArr;
        C0550a e10;
        A a10;
        C0579e eVar = new C0579e(gVar.b());
        C0554e eVar2 = null;
        try {
            C0563a a11 = eVar.a(false);
            zVarArr = a11.d();
            try {
                eVar2 = new C0575d().a(a11, map);
                e10 = null;
            } catch (C0550a e11) {
                e10 = e11;
            }
        } catch (C0550a e12) {
            e10 = e12;
            zVarArr = null;
        }
        if (eVar2 == null) {
            try {
                C0563a a12 = eVar.a(true);
                zVarArr = a12.d();
                eVar2 = new C0575d().a(a12, map);
            } catch (C0550a e13) {
                if (!(zVarArr == null || Ka.f14565c)) {
                    return new x(null, null, 0, (z[]) zVarArr.clone(), BarcodeFormat.AZTEC, System.currentTimeMillis());
                }
                if (e10 != null) {
                    throw e10;
                }
                throw e13;
            }
        }
        z[] zVarArr2 = zVarArr;
        if (!(map == null || (a10 = (A) map.get(EnumC0553d.NEED_RESULT_POINT_CALLBACK)) == null || zVarArr2 == null)) {
            for (z zVar : zVarArr2) {
                a10.a(zVar);
            }
        }
        return new x(eVar2.d(), eVar2.c(), eVar2.a(), zVarArr2, BarcodeFormat.AZTEC, System.currentTimeMillis());
    }
}
