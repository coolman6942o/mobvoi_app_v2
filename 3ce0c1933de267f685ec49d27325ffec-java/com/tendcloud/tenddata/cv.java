package com.tendcloud.tenddata;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cv extends JSONArray {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22860a = "id";

    /* renamed from: b  reason: collision with root package name */
    private static final String f22861b = "category";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22862c = "name";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22863d = "unitPrice";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22864e = "count";

    private cv() {
    }

    public static cv a() {
        return new cv();
    }

    public synchronized cv a(String str, String str2, String str3, int i10, int i11) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f22860a, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f22861b, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("name", str3);
            }
            jSONObject.put(f22863d, i10);
            jSONObject.put("count", i11);
            put(jSONObject);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return this;
    }
}
