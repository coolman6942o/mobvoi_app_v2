package com.unionpay.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class i {
    public static Object a(JSONArray jSONArray, int i10) {
        if (jSONArray != null && i10 < jSONArray.length() && i10 >= 0) {
            try {
                return jSONArray.get(i10);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static String a(JSONObject jSONObject, String str) {
        if (c(jSONObject, str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
                j.b("uppay", i.class.toString() + " get " + str + " failed!!");
            }
        }
        return "";
    }

    public static JSONArray b(JSONObject jSONObject, String str) {
        if (c(jSONObject, str)) {
            try {
                return jSONObject.getJSONArray(str);
            } catch (JSONException unused) {
                j.b("uppay", i.class.toString() + " get " + str + " failed!!");
            }
        }
        return null;
    }

    private static boolean c(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }
}
