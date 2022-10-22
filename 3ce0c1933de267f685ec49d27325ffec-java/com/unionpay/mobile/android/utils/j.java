package com.unionpay.mobile.android.utils;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class j {
    public static String a(JSONArray jSONArray, int i10) {
        if (jSONArray != null && i10 >= 0 && i10 < jSONArray.length()) {
            try {
                return jSONArray.getString(i10);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return "";
    }

    public static String a(JSONObject jSONObject, String str) {
        if (f(jSONObject, str)) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
                k.c("uppay", j.class.toString() + " get " + str + " failed!!");
            }
        }
        return "";
    }

    public static int b(JSONObject jSONObject, String str) {
        if (f(jSONObject, str)) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
                k.c("uppay", j.class.toString() + " get " + str + " failed!!");
            }
        }
        return 0;
    }

    public static Object b(JSONArray jSONArray, int i10) {
        if (jSONArray != null && i10 < jSONArray.length() && i10 >= 0) {
            try {
                return jSONArray.get(i10);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return null;
    }

    public static JSONObject c(JSONObject jSONObject, String str) {
        if (f(jSONObject, str)) {
            try {
                return jSONObject.getJSONObject(str);
            } catch (JSONException unused) {
                k.c("uppay", j.class.toString() + " get " + str + " failed!!");
            }
        }
        return null;
    }

    public static JSONArray d(JSONObject jSONObject, String str) {
        if (f(jSONObject, str)) {
            try {
                return jSONObject.getJSONArray(str);
            } catch (JSONException unused) {
                k.c("uppay", j.class.toString() + " get " + str + " failed!!");
            }
        }
        return null;
    }

    public static List<JSONArray> e(JSONObject jSONObject, String str) {
        ArrayList arrayList = new ArrayList(1);
        JSONArray d10 = d(jSONObject, str);
        for (int i10 = 0; d10 != null && i10 < d10.length(); i10++) {
            arrayList.add((JSONArray) b(d10, i10));
        }
        return arrayList;
    }

    private static boolean f(JSONObject jSONObject, String str) {
        return jSONObject != null && jSONObject.has(str);
    }
}
