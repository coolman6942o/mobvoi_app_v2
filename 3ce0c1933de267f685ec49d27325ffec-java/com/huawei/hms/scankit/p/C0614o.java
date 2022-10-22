package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.C0554e;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.g;
import com.huawei.hms.scankit.aiscan.common.t;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.Map;
/* compiled from: DataMatrixReader.java */
/* renamed from: com.huawei.hms.scankit.p.o  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0614o implements t {

    /* renamed from: a  reason: collision with root package name */
    private static final z[] f14886a = new z[0];

    /* renamed from: b  reason: collision with root package name */
    private final r f14887b = new r();

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public x a(C0587g gVar, Map<EnumC0553d, ?> map) throws C0550a {
        g a10 = new C0625s(gVar.b()).a();
        try {
            C0554e a11 = this.f14887b.a(a10.a(), map);
            return new x(a11.d(), a11.c(), a10.d(), BarcodeFormat.DATA_MATRIX);
        } catch (C0550a e10) {
            if (a10.d() == null || Ka.f14565c) {
                throw e10;
            }
            double sqrt = Math.sqrt(Math.pow(a10.d()[0].b() - a10.d()[1].b(), 2.0d) + Math.pow(a10.d()[0].c() - a10.d()[1].c(), 2.0d));
            double sqrt2 = Math.sqrt(Math.pow(a10.d()[0].b() - a10.d()[3].b(), 2.0d) + Math.pow(a10.d()[0].c() - a10.d()[3].c(), 2.0d));
            if (this.f14887b.a() != null && Math.abs(sqrt - sqrt2) / sqrt < 0.1d) {
                return new x(null, null, a10.d(), BarcodeFormat.DATA_MATRIX);
            }
            throw e10;
        }
    }
}
