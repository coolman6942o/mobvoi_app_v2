package com.tendcloud.tenddata;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class TalkingDataOrder extends JSONObject {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22485a = "id";

    /* renamed from: b  reason: collision with root package name */
    private static final String f22486b = "category";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22487c = "name";

    /* renamed from: d  reason: collision with root package name */
    private static final String f22488d = "unitPrice";

    /* renamed from: e  reason: collision with root package name */
    private static final String f22489e = "count";
    public static final String keyCurrencyType = "keyCurrencyType";
    public static final String keyOrderDetail = "keyOrderDetail";
    public static final String keyOrderId = "keyOrderId";
    public static final String keyTotalPrice = "keyTotalPrice";

    /* renamed from: f  reason: collision with root package name */
    private JSONArray f22490f = null;

    private TalkingDataOrder(String str, int i10, String str2) {
        try {
            put("keyOrderId", str);
            put("keyTotalPrice", i10);
            put("keyCurrencyType", str2);
        } catch (JSONException unused) {
        }
    }

    public static TalkingDataOrder createOrder(String str, int i10, String str2) {
        try {
            g.iForDeveloper("createOrder called --> orderId: " + str + " ,totalPrice: " + i10 + " ,currencyType: " + str2);
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(str)) {
            g.eForDeveloper("createOrder: orderId could not be null or empty");
            return null;
        }
        if (TextUtils.isEmpty(str2) || str2.trim().length() != 3) {
            g.eForDeveloper("createOrder: currencyType length must be 3 ,likes CNY");
            return null;
        }
        return new TalkingDataOrder(str, i10, str2);
    }

    public synchronized TalkingDataOrder addItem(String str, String str2, int i10, int i11) {
        try {
            if (this.f22490f == null) {
                JSONArray jSONArray = new JSONArray();
                this.f22490f = jSONArray;
                put("keyOrderDetail", jSONArray);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f22486b, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("name", str2);
            }
            jSONObject.put(f22488d, i10);
            jSONObject.put("count", i11);
            this.f22490f.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }

    private TalkingDataOrder() {
    }

    public synchronized TalkingDataOrder addItem(String str, String str2, String str3, int i10, int i11) {
        try {
            if (this.f22490f == null) {
                JSONArray jSONArray = new JSONArray();
                this.f22490f = jSONArray;
                put("keyOrderDetail", jSONArray);
            }
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put(f22485a, str);
            }
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(f22486b, str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("name", str3);
            }
            jSONObject.put(f22488d, i10);
            jSONObject.put("count", i11);
            this.f22490f.put(jSONObject);
        } catch (JSONException unused) {
        }
        return this;
    }
}
