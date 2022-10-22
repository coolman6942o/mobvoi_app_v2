package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.b;
import com.huawei.hms.framework.network.grs.c.b.c;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13818a = "a";

    /* renamed from: b  reason: collision with root package name */
    private GrsBaseInfo f13819b;

    /* renamed from: c  reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.a.a f13820c;

    /* renamed from: d  reason: collision with root package name */
    private m f13821d;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.huawei.hms.framework.network.grs.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0179a implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a  reason: collision with root package name */
        String f13827a;

        /* renamed from: b  reason: collision with root package name */
        Map<String, String> f13828b;

        /* renamed from: c  reason: collision with root package name */
        IQueryUrlsCallBack f13829c;

        /* renamed from: d  reason: collision with root package name */
        Context f13830d;

        /* renamed from: e  reason: collision with root package name */
        GrsBaseInfo f13831e;

        /* renamed from: f  reason: collision with root package name */
        com.huawei.hms.framework.network.grs.a.a f13832f;

        C0179a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.a aVar) {
            this.f13827a = str;
            this.f13828b = map;
            this.f13829c = iQueryUrlsCallBack;
            this.f13830d = context;
            this.f13831e = grsBaseInfo;
            this.f13832f = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            Map<String, String> map = this.f13828b;
            if (map != null && !map.isEmpty()) {
                this.f13829c.onCallBackSuccess(this.f13828b);
            } else if (this.f13828b == null) {
                Logger.i(a.f13818a, "access local config for return a domain.");
                this.f13829c.onCallBackSuccess(com.huawei.hms.framework.network.grs.b.b.a(this.f13830d.getPackageName(), this.f13831e).a(this.f13830d, this.f13832f, this.f13831e, this.f13827a, true));
            } else {
                this.f13829c.onCallBackFail(-3);
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(f fVar) {
            Map<String, String> a10 = a.a(fVar.i(), this.f13827a);
            if (a10.isEmpty()) {
                Map<String, String> map = this.f13828b;
                if (map != null && !map.isEmpty()) {
                    this.f13829c.onCallBackSuccess(this.f13828b);
                    return;
                } else if (this.f13828b == null) {
                    Logger.i(a.f13818a, "access local config for return a domain.");
                    a10 = com.huawei.hms.framework.network.grs.b.b.a(this.f13830d.getPackageName(), this.f13831e).a(this.f13830d, this.f13832f, this.f13831e, this.f13827a, true);
                } else {
                    this.f13829c.onCallBackFail(-5);
                    return;
                }
            }
            this.f13829c.onCallBackSuccess(a10);
        }
    }

    /* loaded from: classes.dex */
    private static class b implements com.huawei.hms.framework.network.grs.b {

        /* renamed from: a  reason: collision with root package name */
        String f13834a;

        /* renamed from: b  reason: collision with root package name */
        String f13835b;

        /* renamed from: c  reason: collision with root package name */
        IQueryUrlCallBack f13836c;

        /* renamed from: d  reason: collision with root package name */
        String f13837d;

        /* renamed from: e  reason: collision with root package name */
        Context f13838e;

        /* renamed from: f  reason: collision with root package name */
        GrsBaseInfo f13839f;

        /* renamed from: g  reason: collision with root package name */
        com.huawei.hms.framework.network.grs.a.a f13840g;

        b(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, String str3, Context context, GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.a aVar) {
            this.f13834a = str;
            this.f13835b = str2;
            this.f13836c = iQueryUrlCallBack;
            this.f13837d = str3;
            this.f13838e = context;
            this.f13839f = grsBaseInfo;
            this.f13840g = aVar;
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a() {
            if (!TextUtils.isEmpty(this.f13837d)) {
                this.f13836c.onCallBackSuccess(this.f13837d);
            } else if (TextUtils.isEmpty(this.f13837d)) {
                Logger.i(a.f13818a, "access local config for return a domain.");
                this.f13836c.onCallBackSuccess(com.huawei.hms.framework.network.grs.b.b.a(this.f13838e.getPackageName(), this.f13839f).a(this.f13838e, this.f13840g, this.f13839f, this.f13834a, this.f13835b, true));
            } else {
                this.f13836c.onCallBackFail(-3);
            }
        }

        @Override // com.huawei.hms.framework.network.grs.b
        public void a(f fVar) {
            String a10 = a.a(fVar.i(), this.f13834a, this.f13835b);
            if (TextUtils.isEmpty(a10)) {
                if (!TextUtils.isEmpty(this.f13837d)) {
                    this.f13836c.onCallBackSuccess(this.f13837d);
                    return;
                } else if (TextUtils.isEmpty(this.f13837d)) {
                    Logger.i(a.f13818a, "access local config for return a domain.");
                    a10 = com.huawei.hms.framework.network.grs.b.b.a(this.f13838e.getPackageName(), this.f13839f).a(this.f13838e, this.f13840g, this.f13839f, this.f13834a, this.f13835b, true);
                } else {
                    this.f13836c.onCallBackFail(-5);
                    return;
                }
            }
            this.f13836c.onCallBackSuccess(a10);
        }
    }

    public a(GrsBaseInfo grsBaseInfo, com.huawei.hms.framework.network.grs.a.a aVar, m mVar) {
        this.f13819b = grsBaseInfo;
        this.f13820c = aVar;
        this.f13821d = mVar;
    }

    public static CountryCodeBean a(Context context, boolean z10) {
        return new CountryCodeBean(context, z10);
    }

    private String a(String str, String str2, b bVar, Context context) {
        String a10 = this.f13820c.a(this.f13819b, str, str2, bVar, context);
        if (TextUtils.isEmpty(a10)) {
            return com.huawei.hms.framework.network.grs.b.b.a(context.getPackageName(), this.f13819b).a(context, this.f13820c, this.f13819b, str, str2, false);
        }
        Logger.i(f13818a, "get url from sp is not empty.");
        return a10;
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).getJSONObject(str2).getString(str3);
        } catch (JSONException e10) {
            Logger.w(f13818a, "Method{getServiceNameUrl} query url from SP occur an JSONException", e10);
            return "";
        }
    }

    public static Map<String, Map<String, String>> a(String str) {
        HashMap hashMap = new HashMap(16);
        if (TextUtils.isEmpty(str)) {
            Logger.v(f13818a, "isSpExpire jsonValue is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, a(jSONObject.getJSONObject(obj)));
            }
            return hashMap;
        } catch (JSONException e10) {
            Logger.w(f13818a, "getServicesUrlsMap occur a JSONException", e10);
            return hashMap;
        }
    }

    private Map<String, String> a(String str, b bVar, Context context) {
        Map<String, String> a10 = this.f13820c.a(this.f13819b, str, bVar, context);
        return (a10 == null || a10.isEmpty()) ? com.huawei.hms.framework.network.grs.b.b.a(context.getPackageName(), this.f13819b).a(context, this.f13820c, this.f13819b, str, false) : a10;
    }

    public static Map<String, String> a(String str, String str2) {
        HashMap hashMap = new HashMap();
        if (TextUtils.isEmpty(str)) {
            Logger.v(f13818a, "isSpExpire jsonValue is null.");
            return hashMap;
        }
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject(str2);
            if (jSONObject == null) {
                Logger.v(f13818a, "getServiceNameUrls jsObject null.");
                return hashMap;
            }
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.get(obj).toString());
            }
            return hashMap;
        } catch (JSONException e10) {
            Logger.w(f13818a, "Method{getServiceNameUrls} query url from SP occur an JSONException", e10);
            return hashMap;
        }
    }

    public static Map<String, String> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap(16);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.get(obj).toString());
            }
            return hashMap;
        } catch (JSONException e10) {
            Logger.w(f13818a, "getServiceUrls occur a JSONException", e10);
            return hashMap;
        }
    }

    private void a(String str, Map<String, String> map, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        this.f13821d.a(new c(this.f13819b, context), new C0179a(str, map, iQueryUrlsCallBack, context, this.f13819b, this.f13820c), str);
    }

    public String a(Context context, String str) {
        f a10 = this.f13821d.a(new c(this.f13819b, context), str);
        return a10 == null ? "" : a10.i();
    }

    public String a(String str, String str2, Context context) {
        b bVar = new b();
        String a10 = a(str, str2, bVar, context);
        if (!bVar.a() || TextUtils.isEmpty(a10)) {
            String a11 = a(a(context, str), str, str2);
            if (!TextUtils.isEmpty(a11)) {
                Logger.i(f13818a, "get url is from remote server");
                return a11;
            } else if (!TextUtils.isEmpty(a10)) {
                return a10;
            } else {
                Logger.i(f13818a, "access local config for return a domain.");
                return com.huawei.hms.framework.network.grs.b.b.a(context.getPackageName(), this.f13819b).a(context, this.f13820c, this.f13819b, str, str2, true);
            }
        } else {
            Logger.v(f13818a, "get unexpired cache localUrl{%s}", a10);
            return a10;
        }
    }

    public Map<String, String> a(String str, Context context) {
        b bVar = new b();
        Map<String, String> a10 = a(str, bVar, context);
        if (bVar.a() && a10 != null && !a10.isEmpty()) {
            return a10;
        }
        Map<String, String> a11 = a(a(context, str), str);
        if (!a11.isEmpty()) {
            Logger.i(f13818a, "get url is from remote server");
            return a11;
        } else if (a10 == null || !a10.isEmpty()) {
            return a10;
        } else {
            Logger.i(f13818a, "access local config for return a domain.");
            return com.huawei.hms.framework.network.grs.b.b.a(context.getPackageName(), this.f13819b).a(context, this.f13820c, this.f13819b, str, true);
        }
    }

    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack, Context context) {
        b bVar = new b();
        Map<String, String> a10 = a(str, bVar, context);
        if (!bVar.a()) {
            a(str, a10, iQueryUrlsCallBack, context);
        } else if (a10 == null || a10.isEmpty()) {
            iQueryUrlsCallBack.onCallBackFail(-5);
        } else {
            iQueryUrlsCallBack.onCallBackSuccess(a10);
        }
    }

    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack, Context context) {
        b bVar = new b();
        String a10 = a(str, str2, bVar, context);
        if (!bVar.a()) {
            this.f13821d.a(new c(this.f13819b, context), new b(str, str2, iQueryUrlCallBack, a10, context, this.f13819b, this.f13820c), str);
        } else if (TextUtils.isEmpty(a10)) {
            iQueryUrlCallBack.onCallBackFail(-5);
        } else {
            iQueryUrlCallBack.onCallBackSuccess(a10);
        }
    }
}
