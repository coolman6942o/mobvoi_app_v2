package com.huawei.hms.framework.network.grs.c.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private GrsBaseInfo f13870a;

    /* renamed from: b  reason: collision with root package name */
    private Context f13871b;

    /* renamed from: c  reason: collision with root package name */
    private Set<String> f13872c = new HashSet();

    public c(GrsBaseInfo grsBaseInfo, Context context) {
        this.f13870a = grsBaseInfo;
        this.f13871b = context;
    }

    private String e() {
        HashSet<String> hashSet = new HashSet();
        a a10 = b.a(this.f13871b.getPackageName(), this.f13870a).a();
        if (a10 == null) {
            Logger.w("GrsRequestInfo", "get local assets appGrs is null.");
            return "";
        }
        Map<String, com.huawei.hms.framework.network.grs.local.model.c> b10 = a10.b();
        if (b10 != null && !b10.isEmpty()) {
            for (Map.Entry<String, com.huawei.hms.framework.network.grs.local.model.c> entry : b10.entrySet()) {
                hashSet.add(entry.getValue().b());
            }
            if (hashSet.isEmpty()) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (String str : hashSet) {
                jSONArray.put(str);
            }
            try {
                jSONObject.put(SharedWearInfoHelper.TaskInfo.KEY_SERVICES, jSONArray);
                Logger.v("GrsRequestInfo", "post service list is:%s,and appName is:%s", jSONObject.toString(), a10.a());
                return jSONObject.toString();
            } catch (JSONException unused) {
            }
        }
        return "";
    }

    private String f() {
        Logger.v("GrsRequestInfo", "getGeoipService enter");
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String str : this.f13872c) {
            jSONArray.put(str);
        }
        try {
            jSONObject.put(SharedWearInfoHelper.TaskInfo.KEY_SERVICES, jSONArray);
            Logger.v("GrsRequestInfo", "post query service list is:%s", jSONObject.toString());
            return jSONObject.toString();
        } catch (JSONException unused) {
            return "";
        }
    }

    public Context a() {
        return this.f13871b;
    }

    public void a(String str) {
        this.f13872c.add(str);
    }

    public GrsBaseInfo b() {
        return this.f13870a;
    }

    public String c() {
        return this.f13872c.size() == 0 ? e() : f();
    }

    public Set<String> d() {
        return this.f13872c;
    }
}
