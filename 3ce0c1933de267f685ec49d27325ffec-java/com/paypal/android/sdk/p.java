package com.paypal.android.sdk;

import android.content.Context;
import android.util.Base64;
import android.util.Log;
import com.amap.api.services.core.AMapException;
import com.huawei.agconnect.exception.AGCServerException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class p {

    /* renamed from: e  reason: collision with root package name */
    private static final String f21491e = "p";

    /* renamed from: a  reason: collision with root package name */
    private Context f21492a;

    /* renamed from: b  reason: collision with root package name */
    private String f21493b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f21494c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21495d;

    public p(Context context, String str) {
        this(context, str, (byte) 0);
    }

    private p(Context context, String str, byte b10) {
        String str2 = f21491e;
        m0.l(str2, "entering Configuration url loading");
        this.f21492a = context;
        this.f21493b = str;
        String q5 = q();
        if (!"".equals(q5)) {
            m0.l(str2, "entering saveConfigDataToDisk");
            try {
                File file = new File(this.f21492a.getFilesDir(), "CONFIG_DATA");
                File file2 = new File(this.f21492a.getFilesDir(), "CONFIG_TIME");
                y1.g(file, q5);
                y1.g(file2, String.valueOf(System.currentTimeMillis()));
                m0.l(str2, "leaving saveConfigDataToDisk successfully");
            } catch (IOException e10) {
                e10.toString();
            }
            this.f21494c = new JSONObject(q5);
            m0.l(f21491e, "leaving Configuration url loading");
            return;
        }
        throw new IOException("No valid config found for " + str);
    }

    public p(Context context, boolean z10) {
        this.f21492a = context;
        this.f21493b = null;
        this.f21495d = z10;
        m0.j(3, "PRD", "confIsUpdatable=" + Boolean.toString(this.f21495d));
        this.f21494c = l();
        String str = f21491e;
        m0.l(str, "Configuation initialize, dumping config");
        m0.n(str, this.f21494c);
    }

    private JSONObject b(String str) {
        try {
            String str2 = f21491e;
            m0.l(str2, "entering getIncrementalConfig");
            JSONObject jSONObject = new JSONObject(m0.t(this.f21492a, str));
            m0.l(str2, "leaving getIncrementalConfig");
            return jSONObject;
        } catch (Exception e10) {
            m0.k(6, "PRD", "Error while loading prdc Config " + str, e10);
            return null;
        }
    }

    private static JSONObject c(JSONObject jSONObject, JSONObject jSONObject2) {
        try {
            m0.l(f21491e, "entering mergeConfig");
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                String str = f21491e;
                m0.l(str, "overridding " + next);
                jSONObject.put(next, jSONObject2.get(next));
            }
            m0.l(f21491e, "leaving mergeConfig");
            return jSONObject;
        } catch (Exception e10) {
            m0.k(6, "PRD", "Error encountered while applying prdc Config", e10);
            return null;
        }
    }

    private JSONObject l() {
        try {
            JSONObject n10 = n();
            if (n10 != null) {
                if (m0.w(n10.optString("conf_version", ""), "3.0")) {
                    if (this.f21495d) {
                        if (System.currentTimeMillis() > Long.parseLong(t()) + (n10.optLong("conf_refresh_time_interval", 0L) * 1000)) {
                            p();
                        }
                    }
                    m0.l(f21491e, "Using cached config");
                    return n10;
                }
                s();
            }
            JSONObject m10 = m();
            if (m10 == null) {
                Log.e(f21491e, "default Configuration loading failed,Using hardcoded config");
                return o();
            }
            String f10 = m0.f(this.f21492a, "prdc", null);
            if (f10 == null) {
                if (this.f21495d) {
                    p();
                }
                m0.j(3, "PRD", "prdc field not configured, using default config");
                return m10;
            }
            m0.j(3, "PRD", "prdc field is configured, loading path:" + f10);
            JSONObject b10 = b(f10);
            if (b10 == null) {
                m0.j(6, "PRD", "prdc Configuration loading failed, using default config");
                return m10;
            }
            JSONObject c10 = c(m10, b10);
            if (c10 == null) {
                m0.j(6, "PRD", "applying prdc Configuration failed, using default config");
                return m10;
            }
            m0.j(3, "PRD", "prdc configuration loaded successfully");
            return c10;
        } catch (Exception e10) {
            m0.k(6, "PRD", "Severe Error while loading config, using hard code version", e10);
            return o();
        }
    }

    private static JSONObject m() {
        String str = f21491e;
        m0.l(str, "entering getDefaultConfigurations");
        try {
            String str2 = new String(Base64.decode("eyAiY29uZl92ZXJzaW9uIjogIjMuMCIsImFzeW5jX3VwZGF0ZV90aW1lX2ludGVydmFsIjogMzYwMCwgImZvcmNlZF9mdWxsX3VwZGF0ZV90aW1lX2ludGVydmFsIjogMTgwMCwgImNvbmZfcmVmcmVzaF90aW1lX2ludGVydmFsIjogODY0MDAsICJhbmRyb2lkX2FwcHNfdG9fY2hlY2siOiBbICJjb20uZWJheS5jbGFzc2lmaWVkcy9jb20uZWJheS5hcHAuTWFpblRhYkFjdGl2aXR5IiwgImNvbS5lYmF5Lm1vYmlsZS9jb20uZWJheS5tb2JpbGUuYWN0aXZpdGllcy5lQmF5IiwgImNvbS5lYmF5LnJlZGxhc2VyL2NvbS5lYmF5LnJlZGxhc2VyLlNjYW5uZWRJdGVtc0FjdGl2aXR5IiwgImNvbS5taWxvLmFuZHJvaWQvY29tLm1pbG8uYW5kcm9pZC5hY3Rpdml0eS5Ib21lQWN0aXZpdHkiLCAiY29tLnBheXBhbC5hbmRyb2lkLnAycG1vYmlsZS9jb20ucGF5cGFsLmFuZHJvaWQucDJwbW9iaWxlLmFjdGl2aXR5LlNlbmRNb25leUFjdGl2aXR5IiwgImNvbS5yZW50L2NvbS5yZW50LmFjdGl2aXRpZXMuc2Vzc2lvbi5BY3Rpdml0eUhvbWUiLCAiY29tLnN0dWJodWIvY29tLnN0dWJodWIuQWJvdXQiLCAiY29tLnVsb2NhdGUvY29tLnVsb2NhdGUuYWN0aXZpdGllcy5TZXR0aW5ncyIsICJjb20ubm9zaHVmb3UuYW5kcm9pZC5zdS9jb20ubm9zaHVmb3UuYW5kcm9pZC5zdS5TdSIsICJzdGVyaWNzb24uYnVzeWJveC9zdGVyaWNzb24uYnVzeWJveC5BY3Rpdml0eS5NYWluQWN0aXZpdHkiLCAib3JnLnByb3h5ZHJvaWQvb3JnLnByb3h5ZHJvaWQuUHJveHlEcm9pZCIsICJjb20uYWVkLmRyb2lkdnBuL2NvbS5hZWQuZHJvaWR2cG4uTWFpbkdVSSIsICJuZXQub3BlbnZwbi5vcGVudnBuL25ldC5vcGVudnBuLm9wZW52cG4uT3BlblZQTkNsaWVudCIsICJjb20ucGhvbmVhcHBzOTkuYWFiaXByb3h5L2NvbS5waG9uZWFwcHM5OS5hYWJpcHJveHkuT3Jib3QiLCAiY29tLmV2YW5oZS5wcm94eW1hbmFnZXIucHJvL2NvbS5ldmFuaGUucHJveHltYW5hZ2VyLk1haW5BY3Rpdml0eSIsICJjb20uZXZhbmhlLnByb3h5bWFuYWdlci9jb20uZXZhbmhlLnByb3h5bWFuYWdlci5NYWluQWN0aXZpdHkiLCAiY29tLmFuZHJvbW8uZGV2MzA5MzYuYXBwNzYxOTgvY29tLmFuZHJvbW8uZGV2MzA5MzYuYXBwNzYxOTguQW5kcm9tb0Rhc2hib2FyZEFjdGl2aXR5IiwgImNvbS5tZ3JhbmphLmF1dG9wcm94eV9saXRlL2NvbS5tZ3JhbmphLmF1dG9wcm94eV9saXRlLlByb3h5TGlzdEFjdGl2aXR5IiwgImNvbS52cG5vbmVjbGljay5hbmRyb2lkL2NvbS52cG5vbmVjbGljay5hbmRyb2lkLk1haW5BY3Rpdml0eSIsICJuZXQuaGlkZW1hbi9uZXQuaGlkZW1hbi5TdGFydGVyQWN0aXZpdHkiLCAiY29tLmRvZW50ZXIuYW5kcm9pZC52cG4uZml2ZXZwbi9jb20uZG9lbnRlci5hbmRyb2lkLnZwbi5maXZldnBuLkZpdmVWcG4iLCAiY29tLnRpZ2VydnBucy5hbmRyb2lkL2NvbS50aWdlcnZwbnMuYW5kcm9pZC5NYWluQWN0aXZpdHkiLCAiY29tLnBhbmRhcG93LnZwbi9jb20ucGFuZGFwb3cudnBuLlBhbmRhUG93IiwgImNvbS5leHByZXNzdnBuLnZwbi9jb20uZXhwcmVzc3Zwbi52cG4uTWFpbkFjdGl2aXR5IiwgImNvbS5sb25kb250cnVzdG1lZGlhLnZwbi9jb20ubG9uZG9udHJ1c3RtZWRpYS52cG4uVnBuU2VydmljZUFjdGl2aXR5IiwgImZyLm1lbGVjb20uVlBOUFBUUC52MTAxL2ZyLm1lbGVjb20uVlBOUFBUUC52MTAxLlNwbGFzaFNjcmVlbiIsICJjb20uY2hlY2twb2ludC5WUE4vY29tLmNoZWNrcG9pbnQuVlBOLk1haW5IYW5kbGVyIiwgImNvbS50dW5uZWxiZWFyLmFuZHJvaWQvY29tLnR1bm5lbGJlYXIuYW5kcm9pZC5UYmVhck1haW5BY3Rpdml0eSIsICJkZS5ibGlua3Qub3BlbnZwbi9kZS5ibGlua3Qub3BlbnZwbi5NYWluQWN0aXZpdHkiLCAib3JnLmFqZWplLmZha2Vsb2NhdGlvbi9vcmcuYWplamUuZmFrZWxvY2F0aW9uLkZha2UiLCAiY29tLmxleGEuZmFrZWdwcy9jb20ubGV4YS5mYWtlZ3BzLlBpY2tQb2ludCIsICJjb20uZm9yZ290dGVucHJvamVjdHMubW9ja2xvY2F0aW9ucy9jb20uZm9yZ290dGVucHJvamVjdHMubW9ja2xvY2F0aW9ucy5NYWluIiwgImtyLndvb3QwcGlhLmdwcy9rci53b290MHBpYS5ncHMuQ2F0Y2hNZUlmVUNhbiIsICJjb20ubXkuZmFrZS5sb2NhdGlvbi9jb20ubXkuZmFrZS5sb2NhdGlvbi5jb20ubXkuZmFrZS5sb2NhdGlvbiIsICJqcC5uZXRhcnQuYXJzdGFsa2luZy9qcC5uZXRhcnQuYXJzdGFsa2luZy5NeVByZWZlcmVuY2VBY3Rpdml0eSIsICJsb2NhdGlvblBsYXkuR1BTQ2hlYXRGcmVlL2xvY2F0aW9uUGxheS5HUFNDaGVhdEZyZWUuQWN0aXZpdHlTbWFydExvY2F0aW9uIiwgIm9yZy5nb29kZXYubGF0aXR1ZGUvb3JnLmdvb2Rldi5sYXRpdHVkZS5MYXRpdHVkZUFjdGl2aXR5IiwgImNvbS5zY2hlZmZzYmxlbmQuZGV2aWNlc3Bvb2YvY29tLnNjaGVmZnNibGVuZC5kZXZpY2VzcG9vZi5EZXZpY2VTcG9vZkFjdGl2aXR5IiwgImNvbS5wcm94eUJyb3dzZXIvY29tLnByb3h5QnJvd3Nlci5OZXdQcm94eUJyb3dzZXJBY3Rpdml0eSIsICJjb20uaWNlY29sZGFwcHMucHJveHlzZXJ2ZXJwcm8vY29tLmljZWNvbGRhcHBzLnByb3h5c2VydmVycHJvLnZpZXdTdGFydCIsICJob3RzcG90c2hpZWxkLmFuZHJvaWQudnBuL2NvbS5hbmNob3JmcmVlLnVpLkhvdFNwb3RTaGllbGQiLCAiY29tLmRvZW50ZXIub25ldnBuL2NvbS5kb2VudGVyLm9uZXZwbi5WcG5TZXR0aW5ncyIsICJjb20ueWVzdnBuLmVuL2NvbS55ZXN2cG4uTWFpblRhYiIsICJjb20ub2ZmaWNld3l6ZS5wbHV0b3Zwbi9jb20ub2ZmaWNld3l6ZS5wbHV0b3Zwbi5Ib21lQWN0aXZpdHkiLCAib3JnLmFqZWplLmxvY2F0aW9uc3Bvb2ZlcnByby9vcmcuYWplamUubG9jYXRpb25zcG9vZmVycHJvLkZha2UiLCAibG9jYXRpb25QbGF5LkdQU0NoZWF0L2xvY2F0aW9uUGxheS5HUFNDaGVhdC5BY3Rpdml0eVNtYXJ0TG9jYXRpb24iIF0sICJsb2NhdGlvbl9taW5fYWNjdXJhY3kiOiA1MDAsICJsb2NhdGlvbl9tYXhfY2FjaGVfYWdlIjogMTgwMCwgInNlbmRfb25fYXBwX3N0YXJ0IjogMSwgImVuZHBvaW50X3VybCI6ICJodHRwczovL3N2Y3MucGF5cGFsLmNvbS9BY2Nlc3NDb250cm9sL0xvZ1Jpc2tNZXRhZGF0YSIsICJpbnRlcm5hbF9jYWNoZV9tYXhfYWdlIjogMzAsICJjb21wX3RpbWVvdXQiOiA2MDAgfQ==", 0), "UTF-8");
            m0.l(str, "leaving getDefaultConfigurations, Default Conf load succeed");
            return new JSONObject(str2);
        } catch (Exception e10) {
            m0.k(6, "PRD", "Read default config file exception.", e10);
            m0.l(f21491e, "leaving getDefaultConfigurations,returning null");
            return null;
        }
    }

    private JSONObject n() {
        String str = f21491e;
        m0.l(str, "entering getCachedConfiguration");
        try {
            String r10 = r();
            if (!"".equals(r10)) {
                m0.l(str, "leaving getCachedConfiguration,cached config load succeed");
                return new JSONObject(r10);
            }
        } catch (Exception e10) {
            m0.m(f21491e, "JSON Exception in creating config file", e10);
        }
        m0.l(f21491e, "leaving getCachedConfiguration,cached config load failed");
        return null;
    }

    private static JSONObject o() {
        m0.l(f21491e, "entering getHardcodedConfig");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conf_version", "3.0");
            jSONObject.put("async_update_time_interval", 3600);
            jSONObject.put("forced_full_update_time_interval", AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING);
            jSONObject.put("conf_refresh_time_interval", 86400);
            jSONObject.put("location_min_accuracy", AGCServerException.UNKNOW_EXCEPTION);
            jSONObject.put("location_max_cache_age", AMapException.CODE_AMAP_CLIENT_ERRORCODE_MISSSING);
            jSONObject.put("endpoint_url", "https://svcs.paypal.com/AccessControl/LogRiskMetadata");
        } catch (JSONException unused) {
        }
        m0.l(f21491e, "leaving getHardcodedConfig");
        return jSONObject;
    }

    private static void p() {
        m0.l(f21491e, "Loading web config");
        t.c().m();
    }

    private String q() {
        BufferedReader bufferedReader;
        Throwable th2;
        m0.l(f21491e, "entering getRemoteConfig");
        StringBuilder sb2 = new StringBuilder();
        InputStream inputStream = null;
        try {
            InputStream openStream = new URL(this.f21493b).openStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(openStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            sb2.append(readLine);
                        } else {
                            y1.f(openStream);
                            y1.f(bufferedReader);
                            m0.l(f21491e, "leaving getRemoteConfig successfully");
                            return sb2.toString();
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        inputStream = openStream;
                        y1.f(inputStream);
                        y1.f(bufferedReader);
                        throw th2;
                    }
                }
            } catch (Throwable th4) {
                th2 = th4;
                bufferedReader = null;
            }
        } catch (Throwable th5) {
            th2 = th5;
            bufferedReader = null;
        }
    }

    private String r() {
        try {
            return y1.b(new File(this.f21492a.getFilesDir(), "CONFIG_DATA"));
        } catch (IOException e10) {
            m0.m(f21491e, "Load cached config failed", e10);
            return "";
        }
    }

    private boolean s() {
        try {
            String str = f21491e;
            m0.l(str, "entering deleteCachedConfigDataFromDisk");
            File file = new File(this.f21492a.getFilesDir(), "CONFIG_DATA");
            File file2 = new File(this.f21492a.getFilesDir(), "CONFIG_TIME");
            if (file.exists()) {
                m0.l(str, "cached Config Data found, deleting");
                file.delete();
            }
            if (file2.exists()) {
                m0.l(str, "cached Config Time found, deleting");
                file.delete();
            }
            m0.l(str, "leaving deleteCachedConfigDataFromDisk");
            return true;
        } catch (Exception e10) {
            m0.m(f21491e, "error encountered while deleteCachedConfigData", e10);
            return false;
        }
    }

    private String t() {
        try {
            return y1.b(new File(this.f21492a.getFilesDir(), "CONFIG_TIME"));
        } catch (IOException unused) {
            return "";
        }
    }

    public final String a() {
        return this.f21493b;
    }

    public final String d() {
        return this.f21494c.optString("conf_version", "");
    }

    public final long e() {
        return this.f21494c.optLong("async_update_time_interval", 0L);
    }

    public final long f() {
        return this.f21494c.optLong("forced_full_update_time_interval", 0L);
    }

    public final long g() {
        return this.f21494c.optLong("comp_timeout", 0L);
    }

    public final List h() {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = this.f21494c.optJSONArray("android_apps_to_check");
        for (int i10 = 0; optJSONArray != null && i10 < optJSONArray.length(); i10++) {
            arrayList.add(optJSONArray.getString(i10));
        }
        return arrayList;
    }

    public final String i() {
        return this.f21494c.optString("endpoint_url", null);
    }

    public final boolean j() {
        return this.f21494c.optBoolean("endpoint_is_stage", false);
    }

    public final l0 k() {
        try {
            String optString = this.f21494c.optString("CDS", "");
            if (optString != null && !"".equals(optString)) {
                m0.j(3, "PRD", "CDS field was found");
                return new l0(optString.trim());
            }
            m0.j(3, "PRD", "No CDS is configured, enabling all variables");
            return l0.f21427c;
        } catch (Exception e10) {
            m0.k(6, "PRD", "Failed to decode CDS", e10);
            return l0.f21427c;
        }
    }
}
