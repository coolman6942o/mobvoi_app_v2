package com.tendcloud.tenddata;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cu extends JSONObject {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22850a = "keyOrderId";

    /* renamed from: b  reason: collision with root package name */
    public static final String f22851b = "keyTotalPrice";

    /* renamed from: c  reason: collision with root package name */
    public static final String f22852c = "keyCurrencyType";

    /* renamed from: d  reason: collision with root package name */
    public static final String f22853d = "keyOrderDetail";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22854e = "id";

    /* renamed from: f  reason: collision with root package name */
    private static final String f22855f = "category";

    /* renamed from: g  reason: collision with root package name */
    private static final String f22856g = "name";

    /* renamed from: h  reason: collision with root package name */
    private static final String f22857h = "unitPrice";

    /* renamed from: i  reason: collision with root package name */
    private static final String f22858i = "count";

    /* renamed from: j  reason: collision with root package name */
    private JSONArray f22859j = null;

    private cu(String str, int i10, String str2) {
        try {
            put("keyOrderId", str);
            put("keyTotalPrice", i10);
            put("keyCurrencyType", str2);
        } catch (JSONException unused) {
        }
    }

    public static cu a(String str, int i10, String str2) {
        try {
            g.iForDeveloper("createOrder called --> orderId: " + str + " ,totalPrice: " + i10 + " ,currencyType: " + str2);
            if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("createOrder: orderId could not be null or empty");
            }
            if (TextUtils.isEmpty(str2) || str2.trim().length() != 3) {
                g.eForDeveloper("createOrder: currencyType length must be 3 ,likes CNY");
            }
        } catch (Throwable unused) {
        }
        return new cu(str, i10, str2);
    }

    private cu() {
    }

    public synchronized cu a(String str, String str2, int i10, int i11) {
        try {
            if (this.f22859j == null) {
                JSONArray jSONArray = new JSONArray();
                this.f22859j = jSONArray;
                put("keyOrderDetail", jSONArray);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f22855f, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("name", str2);
            }
            jSONObject.put(f22857h, i10);
            jSONObject.put("count", i11);
            this.f22859j.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }

    public synchronized cu a(String str, String str2, String str3, int i10, int i11) {
        try {
            if (this.f22859j == null) {
                JSONArray jSONArray = new JSONArray();
                this.f22859j = jSONArray;
                put("keyOrderDetail", jSONArray);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f22854e, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f22855f, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("name", str3);
            }
            jSONObject.put(f22857h, i10);
            jSONObject.put("count", i11);
            this.f22859j.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }
}
