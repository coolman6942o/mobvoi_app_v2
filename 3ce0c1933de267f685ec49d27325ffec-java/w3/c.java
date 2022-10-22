package w3;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import v3.b;
import v3.e;
import y3.a;
/* loaded from: classes.dex */
public class c extends e {
    @Override // v3.e
    public String c(a aVar, String str, JSONObject jSONObject) {
        return str;
    }

    @Override // v3.e
    public Map<String, String> d(boolean z10, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("msp-gzip", String.valueOf(z10));
        hashMap.put("content-type", "application/octet-stream");
        hashMap.put("des-mode", "CBC");
        return hashMap;
    }

    @Override // v3.e
    public JSONObject e() throws JSONException {
        return null;
    }

    @Override // v3.e
    public b h(a aVar, Context context, String str) throws Throwable {
        return j(aVar, context, str, "https://mcgw.alipay.com/sdklog.do", true);
    }

    @Override // v3.e
    public String m() throws JSONException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("api_name", "/sdk/log");
        hashMap.put("api_version", "1.0.0");
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("log_v", "1.0");
        return a(hashMap, hashMap2);
    }
}
