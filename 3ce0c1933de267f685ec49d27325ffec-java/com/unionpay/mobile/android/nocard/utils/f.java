package com.unionpay.mobile.android.nocard.utils;

import android.text.TextUtils;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.mobile.android.model.a;
import com.unionpay.mobile.android.model.b;
import com.unionpay.mobile.android.model.e;
import com.unionpay.mobile.android.utils.j;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class f {
    public static int a(b bVar, JSONObject jSONObject) {
        JSONArray jSONArray;
        bVar.bt = j.a(jSONObject, "promotion_change_info");
        bVar.f23550z = j.d(jSONObject, "rules");
        bVar.f23501ad = j.d(jSONObject, "available_area_codes");
        bVar.D = j.d(jSONObject, "entrust_rules");
        bVar.E = j.a(jSONObject, "pre_cmd");
        bVar.A = j.a(jSONObject, "title");
        bVar.C = j.c(jSONObject, "rules_button");
        bVar.f23509al = j.c(jSONObject, "service_checkbox");
        bVar.f23510am = j.c(jSONObject, "bind_card_checkbox");
        String a10 = j.a(jSONObject, "timeout_msg");
        if (a10 != null && !TextUtils.isEmpty(a10)) {
            bVar.f23508ak = a10;
        }
        bVar.f23540p = new HashMap<>();
        JSONObject c10 = j.c(jSONObject, "f55");
        String a11 = j.a(c10, "order_amount");
        HashMap<String, String> hashMap = bVar.f23540p;
        if (a11 == null || a11.length() <= 0) {
            a11 = Constant.DEFAULT_BALANCE;
        }
        hashMap.put("trans_amt", a11);
        String a12 = j.a(c10, "order_currency");
        HashMap<String, String> hashMap2 = bVar.f23540p;
        if (a12 == null || a12.length() <= 0) {
            a12 = "0156";
        }
        hashMap2.put("trans currcy code", a12);
        String a13 = j.a(c10, "trans_type");
        HashMap<String, String> hashMap3 = bVar.f23540p;
        if (a13 == null || a13.length() <= 0) {
            a13 = "00";
        }
        hashMap3.put("trans_type", a13);
        String a14 = j.a(c10, "mer_name");
        HashMap<String, String> hashMap4 = bVar.f23540p;
        if (a14 == null || a14.length() <= 0) {
            a14 = "";
        }
        hashMap4.put("mer_name", a14);
        bVar.f23514aq = j.a(jSONObject, Constant.KEY_PAN);
        bVar.f23519bf = j.a(jSONObject, "encrypt_key");
        bVar.f23520bg = j.a(jSONObject, "auth_id");
        String a15 = j.a(jSONObject, "fail_continue");
        if (a15 != null && a15.equalsIgnoreCase("0")) {
            bVar.F = true;
        }
        JSONArray jSONArray2 = bVar.f23550z;
        return ((jSONArray2 == null || jSONArray2.length() <= 0) && ((jSONArray = bVar.D) == null || jSONArray.length() <= 0)) ? 2 : 0;
    }

    public static int a(b bVar, JSONObject jSONObject, boolean z10) {
        if (!z10) {
            bVar.G = jSONObject;
        }
        return a(bVar, jSONObject);
    }

    public static e a(JSONObject jSONObject) {
        com.unionpay.mobile.android.model.f fVar = new com.unionpay.mobile.android.model.f();
        fVar.a("promotion", j.c(jSONObject, "promotion"));
        fVar.a("instalment", j.c(jSONObject, "instalment"));
        fVar.a("promotion_instalment_msgbox", j.c(jSONObject, "promotion_instalment_msgbox"));
        return fVar;
    }

    public static boolean a(JSONArray jSONArray) {
        String a10;
        String a11;
        boolean z10 = false;
        if (jSONArray != null) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i10);
                    a10 = j.a(jSONObject, "type");
                    a11 = j.a(jSONObject, "readonly");
                } catch (JSONException e10) {
                    e10.printStackTrace();
                }
                if (Constant.KEY_PAN.equalsIgnoreCase(a10)) {
                    z10 = "true".equalsIgnoreCase(a11);
                    break;
                }
                continue;
            }
        }
        return z10;
    }

    public static int b(b bVar, JSONObject jSONObject) {
        int i10 = jSONObject == null ? 2 : 0;
        if (bVar.f23499ab == null) {
            bVar.f23499ab = new ArrayList();
        }
        bVar.f23499ab.clear();
        List<JSONArray> e10 = j.e(jSONObject, "user_cards");
        if (e10.size() > 0) {
            for (int i11 = 0; i11 < e10.size(); i11++) {
                bVar.f23499ab.add(new a(j.a(e10.get(i11), 0), j.a(e10.get(i11), 1), j.a(e10.get(i11), 2), (byte) 0));
            }
        }
        bVar.f23501ad = j.d(jSONObject, "available_area_codes");
        bVar.bt = j.a(jSONObject, "promotion_change_info");
        bVar.f23500ac = j.d(jSONObject, "user_info");
        bVar.f23550z = j.d(jSONObject, "rules");
        bVar.Z = j.c(jSONObject, "service_url");
        bVar.f23498aa = j.c(jSONObject, "bind_url");
        bVar.f23502ae = j.a(jSONObject, "empty_info");
        bVar.aY = j.a(jSONObject, "add_card_tip");
        bVar.f23514aq = j.a(jSONObject, Constant.KEY_PAN);
        return i10;
    }

    public static boolean c(b bVar, JSONObject jSONObject) {
        bVar.aF = null;
        JSONObject c10 = j.c(jSONObject, "cardExpireMsgBox");
        bVar.aF = c10;
        if (c10 == null) {
            bVar.aF = j.c(jSONObject, "openByCounterMsgBox");
        }
        if (bVar.aF == null) {
            bVar.aF = j.c(jSONObject, "restrictPayMsgBox");
        }
        JSONObject jSONObject2 = bVar.aF;
        if (jSONObject2 == null) {
            return false;
        }
        bVar.aG = j.a(jSONObject2, "title");
        bVar.aH = j.a(bVar.aF, "text");
        JSONObject c11 = j.c(bVar.aF, "func");
        JSONObject c12 = j.c(bVar.aF, Constant.CASH_LOAD_CANCEL);
        bVar.aK = j.a(c11, "label");
        bVar.aL = j.a(c11, TelephonyUtil.KEY_SIM_ACTION);
        bVar.aI = j.a(c12, "label");
        bVar.aJ = j.a(c12, TelephonyUtil.KEY_SIM_ACTION);
        return true;
    }
}
