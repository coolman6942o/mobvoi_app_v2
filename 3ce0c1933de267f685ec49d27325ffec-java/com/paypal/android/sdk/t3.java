package com.paypal.android.sdk;

import com.mobvoi.wear.contacts.ContactConstant;
import java.math.BigDecimal;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class t3 {

    /* renamed from: a  reason: collision with root package name */
    private String f22001a;

    /* renamed from: b  reason: collision with root package name */
    private Integer f22002b;

    /* renamed from: c  reason: collision with root package name */
    private BigDecimal f22003c;

    /* renamed from: d  reason: collision with root package name */
    private String f22004d;

    /* renamed from: e  reason: collision with root package name */
    private String f22005e;

    public t3(String str, Integer num, BigDecimal bigDecimal, String str2, String str3) {
        this.f22001a = str;
        this.f22002b = num;
        this.f22003c = bigDecimal;
        this.f22004d = str2;
        this.f22005e = str3;
    }

    public static JSONArray a(t3[] t3VarArr) {
        if (t3VarArr == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (t3 t3Var : t3VarArr) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.accumulate("quantity", Integer.toString(t3Var.f22002b.intValue()));
            jSONObject.accumulate(ContactConstant.CallsRecordKeys.NAME, t3Var.f22001a);
            jSONObject.accumulate("price", t3Var.f22003c.toString());
            jSONObject.accumulate("currency", t3Var.f22004d);
            jSONObject.accumulate("sku", t3Var.f22005e);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
