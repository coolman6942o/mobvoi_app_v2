package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.g;
import com.huawei.hms.scankit.aiscan.common.m;
import com.huawei.hms.scankit.aiscan.common.t;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.Map;
/* compiled from: QRCodeReader.java */
/* loaded from: classes2.dex */
public class Ha implements t {

    /* renamed from: a  reason: collision with root package name */
    private final C0641xa f14539a = new C0641xa();

    public static void a(m mVar) {
        int a10 = mVar.a();
        if (a10 == mVar.c() && a10 == 805) {
            Ka.f14579q[0] = true;
        }
    }

    public static void a(m mVar, x xVar) {
        boolean z10;
        int a10 = mVar.a();
        int c10 = mVar.c();
        while (true) {
            if (Ka.f14580r.size() == 0) {
                z10 = false;
                break;
            }
            int intValue = Ka.f14580r.pop().intValue();
            if (intValue != 0 && a10 % intValue == 0) {
                z10 = true;
                break;
            }
        }
        if ((a10 == c10 && z10) && xVar != null && xVar.f() != null) {
            if ((Math.max(Math.max(xVar.f()[0].b(), xVar.f()[1].b()), xVar.f()[2].b()) - Math.min(Math.min(xVar.f()[0].b(), xVar.f()[1].b()), xVar.f()[2].b())) * (Math.max(Math.max(xVar.f()[0].c(), xVar.f()[1].c()), xVar.f()[2].c()) - Math.min(Math.min(xVar.f()[0].c(), xVar.f()[1].c()), xVar.f()[2].c())) > a10 * c10 * 0.8d) {
                Ka.f14579q[1] = true;
            }
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public final x a(C0587g gVar, Map<EnumC0553d, ?> map) throws C0550a {
        C0554e eVar;
        boolean z10 = true;
        Ka.f14568f++;
        try {
            g a10 = new C0644ya(gVar.b()).a(map);
            int a11 = a(a10);
            boolean z11 = a11 > 0;
            try {
                eVar = this.f14539a.a(a10.a(), map);
                z10 = false;
            } catch (Exception unused) {
                eVar = null;
            }
            if (Ka.f14565c) {
                if (z10 && a11 >= 2) {
                    return new x(null, null, a10.b(), BarcodeFormat.QR_CODE);
                }
            } else if (z10 && z11) {
                return new x(null, null, a10.b(), BarcodeFormat.QR_CODE);
            }
            if (z10) {
                throw C0550a.a();
            } else if (eVar == null) {
                return null;
            } else {
                z[] d10 = a10.d();
                if (eVar.b() instanceof Ga) {
                    ((Ga) eVar.b()).a(d10);
                }
                x xVar = new x(eVar.d(), eVar.c(), d10, BarcodeFormat.QR_CODE);
                xVar.b(a10.b());
                return xVar;
            }
        } catch (C0550a unused2) {
            throw C0550a.a();
        }
    }

    private int a(g gVar) {
        Ka.f14567e = gVar.c();
        C0595i a10 = gVar.a();
        int[] iArr = {3, a10.d() - 4, 3};
        int[] iArr2 = {3, 3, a10.b() - 4};
        int i10 = 0;
        for (int i11 = 0; i11 < 3; i11++) {
            if (a(a10, iArr[i11], iArr2[i11])) {
                i10++;
            }
        }
        return i10;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [int, boolean] */
    private boolean a(C0595i iVar, int i10, int i11) {
        if (iVar == null || iVar.b() < 21 || iVar.d() < 21) {
            return false;
        }
        ?? b10 = iVar.b(i10, i11);
        int i12 = b10;
        if (iVar.b(i10 + 1, i11)) {
            i12 = b10 + 1;
        }
        int i13 = i12;
        if (!iVar.b(i10 + 2, i11)) {
            i13 = i12 + 1;
        }
        int i14 = i13;
        if (iVar.b(i10 + 3, i11)) {
            i14 = i13 + 1;
        }
        int i15 = i14;
        if (iVar.b(i10 - 1, i11)) {
            i15 = i14 + 1;
        }
        int i16 = i15;
        if (!iVar.b(i10 - 2, i11)) {
            i16 = i15 + 1;
        }
        int i17 = i16;
        if (iVar.b(i10 - 3, i11)) {
            i17 = i16 + 1;
        }
        int i18 = i17;
        if (iVar.b(i10, i11 + 1)) {
            i18 = i17 + 1;
        }
        int i19 = i18;
        if (!iVar.b(i10, i11 + 2)) {
            i19 = i18 + 1;
        }
        int i20 = i19;
        if (iVar.b(i10, i11 + 3)) {
            i20 = i19 + 1;
        }
        int i21 = i20;
        if (iVar.b(i10, i11 - 1)) {
            i21 = i20 + 1;
        }
        int i22 = i21;
        if (!iVar.b(i10, i11 - 2)) {
            i22 = i21 + 1;
        }
        int i23 = i22;
        if (iVar.b(i10, i11 - 3)) {
            i23 = i22 + 1;
        }
        return i23 > 10;
    }
}
