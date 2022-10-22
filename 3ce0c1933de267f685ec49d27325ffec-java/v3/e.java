package v3;

import a4.c;
import a4.d;
import a4.i;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.mobvoi.companion.common.analytics.Module;
import com.mobvoi.wear.util.TelephonyUtil;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import r3.b;
import u3.a;
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    public boolean f35585a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35586b = true;

    public static String b(a.b bVar, String str) {
        Map<String, List<String>> map;
        List<String> list;
        if (bVar == null || str == null || (map = bVar.f35287a) == null || (list = map.get(str)) == null) {
            return null;
        }
        return TextUtils.join(",", list);
    }

    public static JSONObject f(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("type", str);
        jSONObject2.put(Constant.KEY_METHOD, str2);
        jSONObject.put(TelephonyUtil.KEY_SIM_ACTION, jSONObject2);
        return jSONObject;
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("data");
            if (!jSONObject.has(Constant.KEY_PARAMS)) {
                return false;
            }
            String optString = jSONObject.getJSONObject(Constant.KEY_PARAMS).optString("public_key", null);
            if (TextUtils.isEmpty(optString)) {
                return false;
            }
            b.d(optString);
            return true;
        } catch (JSONException e10) {
            d.d(e10);
            return false;
        }
    }

    public static boolean l(a.b bVar) {
        return Boolean.valueOf(b(bVar, "msp-gzip")).booleanValue();
    }

    public String a(HashMap<String, String> hashMap, HashMap<String, String> hashMap2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (hashMap != null) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                jSONObject2.put(entry.getKey(), entry.getValue());
            }
        }
        if (hashMap2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                jSONObject3.put(entry2.getKey(), entry2.getValue());
            }
            jSONObject2.put(Constant.KEY_PARAMS, jSONObject3);
        }
        jSONObject.put("data", jSONObject2);
        return jSONObject.toString();
    }

    public String c(y3.a aVar, String str, JSONObject jSONObject) {
        y3.b e10 = y3.b.e();
        z3.a a10 = z3.a.a(e10.c());
        JSONObject a11 = c.a(new JSONObject(), jSONObject);
        try {
            a11.put("external_info", str);
            a11.put("tid", a10.g());
            a11.put("user_agent", e10.a().c(aVar, a10));
            a11.put("has_alipay", com.alipay.sdk.util.b.A(aVar, e10.c(), o3.a.f31407d));
            a11.put("has_msp_app", com.alipay.sdk.util.b.U(e10.c()));
            a11.put("app_key", "2014052600006128");
            a11.put("utdid", e10.d());
            a11.put("new_client_key", a10.f());
            a11.put("pa", b.e(e10.c()));
        } catch (Throwable th2) {
            p3.a.d(aVar, "biz", "BodyErr", th2);
            d.d(th2);
        }
        return a11.toString();
    }

    public Map<String, String> d(boolean z10, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msp-gzip", String.valueOf(z10));
        hashMap.put("Operation-Type", "alipay.msp.cashier.dispatch.bytes");
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put("Version", "2.0");
        hashMap.put("AppId", "TAOBAO");
        hashMap.put("Msp-Param", a.a(str));
        hashMap.put("des-mode", "CBC");
        return hashMap;
    }

    public abstract JSONObject e() throws JSONException;

    public b g(y3.a aVar, Context context) throws Throwable {
        return h(aVar, context, "");
    }

    public b h(y3.a aVar, Context context, String str) throws Throwable {
        return i(aVar, context, str, i.a(context));
    }

    public b i(y3.a aVar, Context context, String str, String str2) throws Throwable {
        return j(aVar, context, str, str2, true);
    }

    public b j(y3.a aVar, Context context, String str, String str2, boolean z10) throws Throwable {
        d.f("mspl", "Packet: " + str2);
        c cVar = new c(this.f35586b);
        b bVar = new b(m(), c(aVar, str, e()));
        Map<String, String> d10 = d(false, str);
        d d11 = cVar.d(bVar, this.f35585a, d10.get("iSr"));
        a.b b10 = a.b(context, new a.C0511a(str2, d(d11.b(), str), d11.a()));
        if (b10 != null) {
            b c10 = cVar.c(new d(l(b10), b10.f35288b), d10.get("iSr"));
            return (c10 == null || !k(c10.b()) || !z10) ? c10 : j(aVar, context, str, str2, false);
        }
        throw new RuntimeException("Response is null.");
    }

    public String m() throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(Module.DEVICE, Build.MODEL);
        hashMap.put("namespace", "com.alipay.mobilecashier");
        hashMap.put("api_name", "com.alipay.mcpay");
        hashMap.put("api_version", n());
        return a(hashMap, new HashMap<>());
    }

    public String n() {
        return "4.9.0";
    }
}
