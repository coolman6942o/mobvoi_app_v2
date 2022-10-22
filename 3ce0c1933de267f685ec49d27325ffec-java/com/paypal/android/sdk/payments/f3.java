package com.paypal.android.sdk.payments;

import com.huawei.hms.scankit.C0559e;
import com.paypal.android.sdk.ev;
import com.paypal.android.sdk.ez;
import com.paypal.android.sdk.g3;
import com.paypal.android.sdk.s0;
import com.paypal.android.sdk.y1;
import java.util.Map;
/* loaded from: classes2.dex */
final class f3 extends g3 {
    public f3(PayPalService payPalService) {
        super(new k1(payPalService));
    }

    @Override // com.paypal.android.sdk.payments.g3
    protected final String a() {
        return "msdk";
    }

    @Override // com.paypal.android.sdk.payments.g3
    protected final void d(String str, Map map) {
        if (!f().a().f20999a.a()) {
            f().a().f20999a = new ev();
        }
        map.put("v49", str);
        map.put("v51", f().d().d().h());
        map.put("v52", g3.f21311a + " " + g3.f21313c);
        map.put("v53", g3.f21314d);
        map.put("clid", f().c());
        map.put("apid", f().d().d().f() + "|" + str + "|" + f().g());
        f().b(new s0(f().a().f20999a.b(), map));
    }

    @Override // com.paypal.android.sdk.payments.g3
    protected final void e(Map map, ez ezVar, String str, String str2) {
        map.put("g", f().f());
        map.put("vers", g3.f21311a + ":" + f().e() + ":");
        map.put("srce", "msdk");
        map.put("sv", "mobile");
        map.put("bchn", "msdk");
        map.put("adte", "FALSE");
        map.put("bzsr", "mobile");
        if (y1.m(str)) {
            map.put("calc", str);
        }
        if (y1.m(str2)) {
            map.put("prid", str2);
        }
        map.put(C0559e.f14347a, ezVar.b() ? "cl" : "im");
    }
}
