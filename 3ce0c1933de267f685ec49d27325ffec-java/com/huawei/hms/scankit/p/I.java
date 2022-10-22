package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import java.util.Map;
/* compiled from: UPCAReader.java */
/* loaded from: classes2.dex */
public final class I extends M {

    /* renamed from: h  reason: collision with root package name */
    private final M f14544h = new C();

    @Override // com.huawei.hms.scankit.p.M
    public boolean a(int i10, int i11, C0591h hVar) {
        return hVar.a(i11, (i11 - i10) + i11, false, false);
    }

    @Override // com.huawei.hms.scankit.p.M
    public x a(int i10, C0591h hVar, int[] iArr, Map<EnumC0553d, ?> map) throws C0550a {
        return a(this.f14544h.a(i10, hVar, iArr, map));
    }

    @Override // com.huawei.hms.scankit.p.M, com.huawei.hms.scankit.p.H
    public x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a {
        return a(this.f14544h.a(i10, hVar, map));
    }

    @Override // com.huawei.hms.scankit.p.H, com.huawei.hms.scankit.aiscan.common.t
    public x a(C0587g gVar, Map<EnumC0553d, ?> map) throws C0550a {
        return a(this.f14544h.a(gVar, map));
    }

    @Override // com.huawei.hms.scankit.p.M
    BarcodeFormat a() {
        return BarcodeFormat.UPC_A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.huawei.hms.scankit.p.M
    public int a(C0591h hVar, int[] iArr, StringBuilder sb2) throws C0550a {
        return this.f14544h.a(hVar, iArr, sb2);
    }

    private static x a(x xVar) throws C0550a {
        String g10 = xVar.g();
        if (g10.charAt(0) == '0') {
            return new x(g10.substring(1), null, xVar.f(), BarcodeFormat.UPC_A);
        }
        throw C0550a.a();
    }

    @Override // com.huawei.hms.scankit.p.M
    boolean a(int[] iArr, int[] iArr2) throws C0550a {
        return Math.abs(((int) Math.round(((double) (iArr2[1] - iArr[0])) / (((double) ((iArr2[1] - iArr2[0]) + (iArr[1] - iArr[0]))) / 6.0d))) + (-113)) <= 5;
    }
}
