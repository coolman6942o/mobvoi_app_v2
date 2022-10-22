package com.paypal.android.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class t2 {

    /* renamed from: a  reason: collision with root package name */
    private static Map f22000a;

    private static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "unknown versionName";
        }
    }

    public static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : f22000a.keySet()) {
                jSONObject.put(str, f22000a.get(str));
            }
            return jSONObject;
        } catch (JSONException e10) {
            Log.e("paypal.sdk", "Error encoding JSON", e10);
            return null;
        }
    }

    public static void c(a aVar) {
        Map map;
        String str;
        if (f22000a == null) {
            HashMap hashMap = new HashMap();
            f22000a = hashMap;
            hashMap.put("app_version", a(aVar.j()));
            f22000a.put("app_category", "1");
            if (aVar.d() == 1) {
                map = f22000a;
                str = "AndroidGSM";
            } else if (aVar.d() == 2) {
                map = f22000a;
                str = "AndroidCDMA";
            } else {
                map = f22000a;
                str = "AndroidOther";
            }
            map.put("client_platform", str);
            f22000a.put("device_app_id", aVar.f());
        }
    }
}
