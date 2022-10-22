package com.huawei.hms.framework.network.grs.c.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.c.b.d;
import com.huawei.hms.framework.network.grs.d.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13855a = "a";

    /* renamed from: b  reason: collision with root package name */
    private static d f13856b;

    public static synchronized d a(Context context) {
        synchronized (a.class) {
            d dVar = f13856b;
            if (dVar != null) {
                return dVar;
            }
            String a10 = c.a("grs_sdk_server_config.json", context);
            ArrayList arrayList = null;
            if (TextUtils.isEmpty(a10)) {
                return null;
            }
            try {
                JSONObject jSONObject = new JSONObject(a10).getJSONObject("grs_server");
                JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                if (jSONArray != null && jSONArray.length() > 0) {
                    arrayList = new ArrayList();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        arrayList.add(jSONArray.get(i10).toString());
                    }
                }
                d dVar2 = new d();
                f13856b = dVar2;
                dVar2.a(arrayList);
                f13856b.b(jSONObject.getString("grs_query_endpoint_1.0"));
                f13856b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                f13856b.a(jSONObject.getInt("grs_query_timeout"));
            } catch (JSONException e10) {
                Logger.w(f13855a, "getGrsServerBean catch JSONException", e10);
            }
            return f13856b;
        }
    }
}
