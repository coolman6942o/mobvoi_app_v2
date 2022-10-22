package com.alipay.apmobilesecuritysdk.d;

import android.content.Context;
import c4.a;
import com.alipay.apmobilesecuritysdk.e.e;
import com.alipay.apmobilesecuritysdk.e.f;
import com.unionpay.tsmservice.mi.data.Constant;
import e4.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class c {
    public static Map<String, String> a(Context context) {
        b d10 = b.d();
        HashMap hashMap = new HashMap();
        f a10 = e.a(context);
        String b10 = b.b(context);
        String e10 = b.e(context);
        String w10 = b.w(context);
        String A = b.A(context);
        if (a10 != null) {
            if (a.d(b10)) {
                b10 = a10.a();
            }
            if (a.d(e10)) {
                e10 = a10.b();
            }
            if (a.d(w10)) {
                w10 = a10.c();
            }
            if (a.d(A)) {
                A = a10.e();
            }
        }
        f fVar = new f(b10, e10, w10, "", A);
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("imei", fVar.a());
                jSONObject.put("imsi", fVar.b());
                jSONObject.put(Constant.KEY_MAC, fVar.c());
                jSONObject.put("bluetoothmac", fVar.d());
                jSONObject.put("gsi", fVar.e());
                String jSONObject2 = jSONObject.toString();
                com.alipay.apmobilesecuritysdk.f.a.a("device_feature_file_name", "device_feature_file_key", jSONObject2);
                com.alipay.apmobilesecuritysdk.f.a.a(context, "device_feature_prefs_name", "device_feature_prefs_key", jSONObject2);
            } catch (Exception e11) {
                com.alipay.apmobilesecuritysdk.c.a.a(e11);
            }
        }
        hashMap.put("AD1", b10);
        hashMap.put("AD2", e10);
        hashMap.put("AD3", b.m(context));
        hashMap.put("AD5", b.q(context));
        hashMap.put("AD6", b.s(context));
        hashMap.put("AD7", b.u(context));
        hashMap.put("AD8", w10);
        hashMap.put("AD9", b.y(context));
        hashMap.put("AD10", A);
        hashMap.put("AD11", b.j());
        hashMap.put("AD12", d10.a());
        hashMap.put("AD13", b.l());
        hashMap.put("AD14", b.p());
        hashMap.put("AD15", b.r());
        hashMap.put("AD16", b.t());
        hashMap.put("AD17", "");
        hashMap.put("AD19", b.C(context));
        hashMap.put("AD20", b.v());
        hashMap.put("AD22", "");
        hashMap.put("AD23", b.G(context));
        hashMap.put("AD24", a.l(b.o(context)));
        hashMap.put("AD26", b.k(context));
        hashMap.put("AD27", b.F());
        hashMap.put("AD28", b.J());
        hashMap.put("AD29", b.N());
        hashMap.put("AD30", b.H());
        hashMap.put("AD31", b.L());
        hashMap.put("AD32", b.B());
        hashMap.put("AD33", b.D());
        hashMap.put("AD34", b.K(context));
        hashMap.put("AD35", b.M(context));
        hashMap.put("AD36", b.I(context));
        hashMap.put("AD37", b.z());
        hashMap.put("AD38", b.x());
        hashMap.put("AD39", b.g(context));
        hashMap.put("AD40", b.i(context));
        hashMap.put("AD41", b.f());
        hashMap.put("AD42", b.h());
        hashMap.put("AL3", b.E(context));
        return hashMap;
    }
}
