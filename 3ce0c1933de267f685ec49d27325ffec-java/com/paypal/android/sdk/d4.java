package com.paypal.android.sdk;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class d4 implements t4 {

    /* renamed from: a  reason: collision with root package name */
    private String f21105a = z3.a(ft.PREFERRED_PAYMENT_METHOD);

    /* renamed from: b  reason: collision with root package name */
    private g4 f21106b;

    private d4(JSONObject jSONObject) {
        this.f21106b = new g4(jSONObject.optJSONArray("funding_sources"), jSONObject.optJSONObject("backup_funding_instrument"));
    }

    public static ArrayList b(JSONObject jSONObject, JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            d4 d4Var = new d4(jSONObject);
            if (d4Var.h()) {
                arrayList.add(d4Var);
            }
        }
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    d4 d4Var2 = new d4(jSONArray.getJSONObject(i10));
                    if (d4Var2.h()) {
                        arrayList.add(d4Var2);
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return arrayList;
    }

    private boolean h() {
        return this.f21106b.f() > 0;
    }

    @Override // com.paypal.android.sdk.t4
    public final String a() {
        return this.f21106b.e();
    }

    @Override // com.paypal.android.sdk.t4
    public final String b() {
        return this.f21105a;
    }

    @Override // com.paypal.android.sdk.t4
    public final String c() {
        return this.f21106b.b();
    }

    @Override // com.paypal.android.sdk.t4
    public final String d() {
        return this.f21106b.d();
    }

    @Override // com.paypal.android.sdk.t4
    public final boolean e() {
        return this.f21106b.c();
    }

    public final g4 f() {
        return this.f21106b;
    }

    public final boolean g() {
        return this.f21106b.f() == 1;
    }
}
