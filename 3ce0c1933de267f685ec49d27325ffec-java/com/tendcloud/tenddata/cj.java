package com.tendcloud.tenddata;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cj extends ch {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22818a = "accounts";

    public void a() {
        a(f22818a, t.d(ab.f22568h));
    }

    public void c() {
        try {
            JSONObject jSONObject = (JSONObject) b();
            if (jSONObject.has(f22818a)) {
                JSONArray jSONArray = jSONObject.getJSONArray(f22818a);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    if ("sim".equals(jSONArray.getJSONObject(i10).getString("type"))) {
                        JSONArray a10 = ay.a().a("IMEI", ct.a().f22848a, ct.a().f22849b);
                        if (a10 != null) {
                            jSONArray.getJSONObject(i10).put("extra", m.A(ab.f22568h));
                            if (a10.length() > 0) {
                                ct.a().a("IMEI", a10);
                            }
                        } else {
                            JSONArray jSONArray2 = jSONArray.getJSONObject(i10).getJSONArray("extra");
                            if (jSONArray2 != null) {
                                for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                                    a("imei", jSONArray2.getJSONObject(i11));
                                }
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void setUserAccount(cd cdVar) {
        if (cdVar != null && cdVar.b() != null) {
            if (this.f22803b.isNull(f22818a)) {
                new JSONArray().put(cdVar.b());
                a(f22818a, cdVar.b());
                return;
            }
            try {
                this.f22803b.getJSONArray(f22818a).put(cdVar.b());
            } catch (JSONException e10) {
                bf.postSDKError(e10);
                e10.printStackTrace();
            }
        }
    }
}
