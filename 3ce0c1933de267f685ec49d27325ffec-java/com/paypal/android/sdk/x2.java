package com.paypal.android.sdk;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class x2 {

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap f22055a = new y2();

    /* renamed from: b  reason: collision with root package name */
    private static Map f22056b;

    public static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : f22056b.keySet()) {
                jSONObject.put(str, f22056b.get(str));
            }
            return jSONObject;
        } catch (JSONException e10) {
            Log.e("paypal.sdk", "Error encoding JSON", e10);
            return null;
        }
    }

    public static void b(a aVar) {
        if (f22056b == null) {
            HashMap hashMap = new HashMap();
            f22056b = hashMap;
            hashMap.put("device_identifier", y1.c(aVar.i()));
            f22056b.put("device_type", "Android");
            f22056b.put("device_name", y1.c(Build.DEVICE));
            f22056b.put("device_model", y1.c(Build.MODEL));
            Map map = f22056b;
            String str = (String) f22055a.get(Integer.valueOf(aVar.d()));
            if (TextUtils.isEmpty(str)) {
                str = "ANDROIDGSM_UNDEFINED";
            }
            map.put("device_key_type", str);
            f22056b.put("device_os", "Android");
            f22056b.put("device_os_version", y1.c(Build.VERSION.RELEASE));
            Map map2 = f22056b;
            String str2 = Build.PRODUCT;
            map2.put("is_device_simulator", Boolean.toString(str2.equals("sdk") || str2.equals("google_sdk") || Build.FINGERPRINT.contains("generic")));
        }
    }
}
