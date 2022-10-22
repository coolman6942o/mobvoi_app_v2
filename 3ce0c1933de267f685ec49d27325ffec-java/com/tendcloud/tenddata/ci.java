package com.tendcloud.tenddata;

import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.contacts.ContactConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class ci extends ch {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22804a = "TalkingData";

    /* renamed from: c  reason: collision with root package name */
    public static final String f22805c = "test_1230";

    /* renamed from: d  reason: collision with root package name */
    public static final int f22806d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static final int f22807e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static final int f22808f = 2;

    /* renamed from: g  reason: collision with root package name */
    public static final int f22809g = 3;

    /* renamed from: h  reason: collision with root package name */
    public static final int f22810h = 4;

    /* renamed from: i  reason: collision with root package name */
    public static final int f22811i = 5;

    /* renamed from: j  reason: collision with root package name */
    public static final int f22812j = 6;

    /* renamed from: k  reason: collision with root package name */
    public static final int f22813k = 7;

    /* renamed from: l  reason: collision with root package name */
    public static final int f22814l = 8;

    /* renamed from: n  reason: collision with root package name */
    private static String f22815n = "";

    /* renamed from: o  reason: collision with root package name */
    private static int f22816o = 4;

    /* renamed from: m  reason: collision with root package name */
    private final String f22817m = "Android";

    public ci() {
        a("version", (Object) 5);
        a("minorVersion", (Object) 0);
        a("build", (Object) 0);
        if (!u.b(ab.f22583w)) {
            try {
                a("jobNum", Integer.valueOf(Integer.parseInt(ab.f22583w)));
            } catch (Throwable unused) {
            }
        }
        a("partner", f22805c);
        a("platform", "Android");
        a("type", f22804a);
        a("framework", f22815n);
        int i10 = f22816o;
        if (i10 > 0) {
            a(Constants.WatchfaceMarket.MARKET_ENTER_FROM, Integer.valueOf(i10));
        }
    }

    public String a() {
        return f22815n;
    }

    public void setFrameWork(String str) {
        f22815n = str;
    }

    public void a(String str, String str2, String str3) {
        JSONArray jSONArray;
        if (this.f22803b.isNull("features")) {
            jSONArray = new JSONArray();
        } else {
            try {
                jSONArray = this.f22803b.getJSONArray("features");
            } catch (JSONException e10) {
                e10.printStackTrace();
                jSONArray = null;
            }
        }
        if (jSONArray != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(ContactConstant.CallsRecordKeys.NAME, str);
                jSONObject.put("version", str2);
                jSONObject.put("minorVersion", str3);
                jSONArray.put(jSONObject);
            } catch (JSONException e11) {
                e11.printStackTrace();
                bf.postSDKError(e11);
            }
            a("features", jSONArray);
        }
    }
}
