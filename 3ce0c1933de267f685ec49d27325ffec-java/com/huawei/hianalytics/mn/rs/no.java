package com.huawei.hianalytics.mn.rs;

import android.content.Context;
import com.huawei.hianalytics.mn.no.qr.mn;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public final class no {

    /* renamed from: mn  reason: collision with root package name */
    private static no f13644mn;

    /* renamed from: no  reason: collision with root package name */
    private Context f13645no;

    /* renamed from: op  reason: collision with root package name */
    private final Object f13646op = new Object();

    private no() {
    }

    public static no mn() {
        if (f13644mn == null) {
            no();
        }
        return f13644mn;
    }

    private JSONObject mn(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
            } catch (JSONException unused) {
                mn.pq("HiAnalyticsEventManager", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    private static synchronized void no() {
        synchronized (no.class) {
            if (f13644mn == null) {
                f13644mn = new no();
            }
        }
    }

    public final void mn(Context context) {
        synchronized (this.f13646op) {
            if (this.f13645no == null) {
                this.f13645no = context;
                com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn(context);
            }
        }
    }

    public final void mn(String str, int i10) {
        com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn(str, i10);
    }

    public final void mn(String str, int i10, String str2, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn(str, i10, str2, mn(linkedHashMap));
    }

    public final void mn(String str, Context context) {
        com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn(str, context.getClass().getCanonicalName(), new JSONObject());
    }

    public final void mn(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            mn.op("HiAnalyticsEventManager", "onEvent():JSON structure Exception!");
        }
    }

    public final void mn(String str, Context context, LinkedHashMap<String, String> linkedHashMap) {
        JSONObject mn2 = mn(linkedHashMap);
        com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn(str, context.getClass().getCanonicalName(), mn2);
    }

    public final void mn(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn(str, str2, mn(linkedHashMap));
    }

    public final void no(String str, int i10, String str2, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.a.mn.mn.mn().mn(str, i10, str2, mn(linkedHashMap), System.currentTimeMillis());
    }

    public final void no(String str, Context context) {
        com.huawei.hianalytics.mn.no.a.mn.mn.mn().no(str, context.getClass().getCanonicalName(), new JSONObject());
    }

    public final void no(String str, Context context, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.a.mn.mn.mn().no(str, context.getClass().getCanonicalName(), mn(linkedHashMap));
    }

    public final void no(String str, String str2, LinkedHashMap<String, String> linkedHashMap) {
        com.huawei.hianalytics.mn.no.a.mn.mn.mn().no(str, str2, mn(linkedHashMap));
    }
}
