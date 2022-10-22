package com.alipay.apmobilesecuritysdk.e;

import android.content.Context;
import com.alipay.apmobilesecuritysdk.f.a;
import com.unionpay.tsmservice.mi.data.Constant;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class e {
    public static f a(Context context) {
        if (context == null) {
            return null;
        }
        String a10 = a.a(context, "device_feature_prefs_name", "device_feature_prefs_key");
        if (c4.a.d(a10)) {
            a10 = a.a("device_feature_file_name", "device_feature_file_key");
        }
        if (c4.a.d(a10)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(a10);
            f fVar = new f();
            fVar.a(jSONObject.getString("imei"));
            fVar.b(jSONObject.getString("imsi"));
            fVar.c(jSONObject.getString(Constant.KEY_MAC));
            fVar.d(jSONObject.getString("bluetoothmac"));
            fVar.e(jSONObject.getString("gsi"));
            return fVar;
        } catch (Exception e10) {
            com.alipay.apmobilesecuritysdk.c.a.a(e10);
            return null;
        }
    }
}
