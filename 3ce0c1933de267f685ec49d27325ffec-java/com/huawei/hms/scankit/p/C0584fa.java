package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.t;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: PDF417Reader.java */
/* renamed from: com.huawei.hms.scankit.p.fa  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0584fa implements t {

    /* renamed from: a  reason: collision with root package name */
    private static final x[] f14789a = new x[0];

    private static int b(z zVar, z zVar2) {
        if (zVar == null || zVar2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(zVar.b() - zVar2.b());
    }

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public x a(C0587g gVar, Map<EnumC0553d, ?> map) throws C0550a {
        x[] a10 = a(gVar, map, false);
        if (a10.length != 0 && a10[0] != null) {
            return a10[0];
        }
        throw C0550a.a();
    }

    private static int b(z[] zVarArr) {
        return Math.min(Math.min(b(zVarArr[0], zVarArr[4]), (b(zVarArr[6], zVarArr[2]) * 17) / 18), Math.min(b(zVarArr[1], zVarArr[5]), (b(zVarArr[7], zVarArr[3]) * 17) / 18));
    }

    private static x[] a(C0587g gVar, Map<EnumC0553d, ?> map, boolean z10) throws C0550a {
        ArrayList arrayList = new ArrayList();
        C0580ea a10 = Y.a(gVar, map, z10);
        for (z[] zVarArr : a10.b()) {
            C0554e a11 = C0592ha.a(a10.a(), zVarArr[4], zVarArr[5], zVarArr[6], zVarArr[7], b(zVarArr), a(zVarArr), map);
            if (Y.a()) {
                for (int i10 = 0; i10 < zVarArr.length; i10++) {
                    if (zVarArr[i10] != null) {
                        zVarArr[i10] = new z((gVar.e() - 1) - zVarArr[i10].b(), (gVar.c() - 1) - zVarArr[i10].c());
                    }
                }
            }
            if (zVarArr.length == 8) {
                if (zVarArr[0] == null && zVarArr[1] == null && zVarArr[4] == null && zVarArr[5] == null) {
                    zVarArr[0] = zVarArr[6];
                    zVarArr[1] = zVarArr[7];
                    zVarArr[4] = zVarArr[2];
                    zVarArr[5] = zVarArr[3];
                } else if (zVarArr[2] == null && zVarArr[3] == null && zVarArr[6] == null && zVarArr[7] == null) {
                    zVarArr[2] = zVarArr[4];
                    zVarArr[3] = zVarArr[5];
                    zVarArr[6] = zVarArr[0];
                    zVarArr[7] = zVarArr[1];
                }
                arrayList.add(new x(a11.d(), a11.c(), zVarArr, BarcodeFormat.PDF_417));
            } else {
                throw C0550a.a("pdf417 points size incorrect!");
            }
        }
        return (x[]) arrayList.toArray(f14789a);
    }

    private static int a(z zVar, z zVar2) {
        if (zVar == null || zVar2 == null) {
            return 0;
        }
        return (int) Math.abs(zVar.b() - zVar2.b());
    }

    private static int a(z[] zVarArr) {
        return Math.max(Math.max(a(zVarArr[0], zVarArr[4]), (a(zVarArr[6], zVarArr[2]) * 17) / 18), Math.max(a(zVarArr[1], zVarArr[5]), (a(zVarArr[7], zVarArr[3]) * 17) / 18));
    }
}
