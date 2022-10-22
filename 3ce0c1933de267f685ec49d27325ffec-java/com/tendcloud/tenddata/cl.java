package com.tendcloud.tenddata;

import com.unionpay.tsmservice.mi.data.Constant;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cl extends ch {
    public cl() {
        a("tid", i.a(ab.f22568h));
    }

    public void a() {
        a("serialNo", k.a("serialNo"));
        JSONArray a10 = ay.a().a("AdID");
        if (a10 != null) {
            a("adId", k.b(ab.f22568h));
            if (a10.length() > 0) {
                ct.a().a("AdID", a10);
            }
        } else {
            a("adId", this.f22803b);
        }
        JSONArray a11 = ay.a().a("IMEI", ct.a().f22848a, ct.a().f22849b);
        if (a11 != null) {
            try {
                JSONArray A = m.A(ab.f22568h);
                JSONArray jSONArray = new JSONArray();
                JSONArray jSONArray2 = new JSONArray();
                JSONArray jSONArray3 = new JSONArray();
                JSONArray jSONArray4 = new JSONArray();
                if (A != null && A.length() > 0) {
                    JSONObject jSONObject = A.getJSONObject(0);
                    if (jSONObject.has("imei")) {
                        jSONArray.put(jSONObject.get("imei"));
                    }
                    if (jSONObject.has("imei5")) {
                        jSONArray2.put(jSONObject.get("imei5"));
                    }
                    if (jSONObject.has("meid")) {
                        jSONArray3.put(jSONObject.get("meid"));
                    }
                    if (jSONObject.has("meid5")) {
                        jSONArray4.put(jSONObject.get("meid5"));
                    }
                    if (A.length() == 2) {
                        JSONObject jSONObject2 = A.getJSONObject(1);
                        if (jSONObject2.has("imei")) {
                            jSONArray.put(jSONObject2.get("imei"));
                        }
                        if (jSONObject2.has("imei5")) {
                            jSONArray2.put(jSONObject2.get("imei5"));
                        }
                        if (jSONObject2.has("meid")) {
                            jSONArray3.put(jSONObject2.get("meid"));
                        }
                        if (jSONObject2.has("meid5")) {
                            jSONArray4.put(jSONObject2.get("meid5"));
                        }
                    }
                }
                a("imeis", jSONArray);
                a("imeis5", jSONArray2);
                a("meids", jSONArray3);
                a("meids5", jSONArray4);
            } catch (Exception unused) {
            }
            if (a11.length() > 0) {
                ct.a().a("IMEI", a11);
            }
        } else {
            a("imeis", this.f22803b);
        }
        JSONArray a12 = ay.a().a("MacAddress");
        if (a12 != null) {
            JSONArray jSONArray5 = new JSONArray();
            jSONArray5.put(k.a(Constant.KEY_MAC));
            a("wifiMacs", jSONArray5);
            JSONArray jSONArray6 = new JSONArray();
            jSONArray6.put(k.a("ethMac"));
            a("ethMacs", jSONArray6);
            if (a12.length() > 0) {
                ct.a().a("MacAddress", a12);
            }
        } else {
            a("wifiMacs", this.f22803b);
        }
        JSONArray a13 = ay.a().a("AndroidId");
        if (a13 != null) {
            a("androidId", k.a("androidId"));
            if (a13.length() > 0) {
                ct.a().a("AndroidId", a13);
            }
        } else {
            a("androidId", this.f22803b);
        }
        a("msaIds", co.a().b());
    }
}
