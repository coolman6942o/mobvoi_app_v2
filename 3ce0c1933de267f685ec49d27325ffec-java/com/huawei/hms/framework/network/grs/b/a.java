package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.d.c;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.providers.OtaColumn;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected com.huawei.hms.framework.network.grs.local.model.a f13843a;

    /* renamed from: b  reason: collision with root package name */
    protected List<b> f13844b;

    /* renamed from: c  reason: collision with root package name */
    protected Map<String, String> f13845c = new ConcurrentHashMap(16);

    /* renamed from: d  reason: collision with root package name */
    protected boolean f13846d = false;

    /* renamed from: e  reason: collision with root package name */
    protected Set<String> f13847e = new HashSet(16);

    private int a(Context context) {
        int i10 = -1;
        try {
            String[] list = context.getAssets().list("");
            if (list != null && list.length > 0) {
                for (String str : list) {
                    if (Pattern.matches("^grs_sdk_global_route_config_[a-zA-Z]+\\.json$", str) && g(c.a(str, context)) == 0) {
                        Logger.i("AbstractLocalManager", "load SDK_CONFIG_FILE sucess.");
                        i10 = 0;
                    }
                }
            }
        } catch (IOException unused) {
            Logger.w("AbstractLocalManager", "list assets files fail,please check if according to our standard config json files.");
        }
        return i10;
    }

    private int a(String str, Context context) {
        if (f(c.a(str, context)) != 0) {
            return -1;
        }
        Logger.i("AbstractLocalManager", "load APP_CONFIG_FILE success.");
        return 0;
    }

    private Map<String, String> a(List<b> list, GrsBaseInfo grsBaseInfo, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(16);
        concurrentHashMap.put("no_route_country", "no-country");
        for (b bVar : list) {
            if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                concurrentHashMap.put(grsBaseInfo.getIssueCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                concurrentHashMap.put(grsBaseInfo.getRegCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                concurrentHashMap.put(grsBaseInfo.getSerCountry(), bVar.b());
            }
            if (bVar.a().contains(str)) {
                Logger.v("AbstractLocalManager", "get countryGroupID from geoIp");
                concurrentHashMap.put(str, bVar.b());
            }
        }
        return concurrentHashMap;
    }

    private int f(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int b10 = b(str);
        if (b10 != 0) {
            return b10;
        }
        int a10 = a(str);
        return a10 != 0 ? a10 : e(str);
    }

    private int g(String str) {
        int c10;
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        List<b> list = this.f13844b;
        return ((list == null || list.isEmpty()) && (c10 = c(str)) != 0) ? c10 : d(str);
    }

    public abstract int a(String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, Context context, boolean z10) {
        if (a(str, context) != 0 && z10) {
            return -1;
        }
        a(context);
        return 0;
    }

    public com.huawei.hms.framework.network.grs.local.model.a a() {
        return this.f13843a;
    }

    public String a(Context context, com.huawei.hms.framework.network.grs.a.a aVar, GrsBaseInfo grsBaseInfo, String str, String str2, boolean z10) {
        Map<String, String> a10 = a(context, aVar, grsBaseInfo, str, z10);
        if (a10 != null) {
            return a10.get(str2);
        }
        Logger.w("AbstractLocalManager", "addresses not found by routeby in local config{%s}", str);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0071 A[Catch: JSONException -> 0x008d, LOOP:1: B:30:0x006b->B:32:0x0071, LOOP_END, TryCatch #0 {JSONException -> 0x008d, blocks: (B:6:0x000e, B:7:0x0017, B:9:0x001d, B:11:0x0028, B:13:0x0031, B:15:0x003a, B:19:0x004c, B:21:0x0052, B:23:0x0059, B:24:0x005c, B:26:0x0063, B:30:0x006b, B:32:0x0071, B:33:0x007d, B:34:0x0086), top: B:42:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<b> a(JSONArray jSONArray) {
        HashSet hashSet;
        int i10;
        if (jSONArray == null || jSONArray.length() == 0) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList(16);
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i11);
                b bVar = new b();
                bVar.b(jSONObject.getString("id"));
                bVar.c(jSONObject.getString(ContactConstant.CallsRecordKeys.NAME));
                bVar.a(jSONObject.getString(OtaColumn.COLUMN_DESCRIPTION));
                JSONArray jSONArray2 = null;
                String str = "countries";
                if (jSONObject.has("countriesOrAreas")) {
                    str = "countriesOrAreas";
                } else if (!jSONObject.has(str)) {
                    Logger.w("AbstractLocalManager", "current country or area group has not config countries or areas.");
                    hashSet = new HashSet(16);
                    if (!(jSONArray2 == null || jSONArray2.length() == 0)) {
                        for (i10 = 0; i10 < jSONArray2.length(); i10++) {
                            hashSet.add((String) jSONArray2.get(i10));
                        }
                        bVar.a(hashSet);
                        arrayList.add(bVar);
                    }
                    return new ArrayList();
                }
                jSONArray2 = jSONObject.getJSONArray(str);
                hashSet = new HashSet(16);
                if (jSONArray2 == null) {
                    while (i10 < jSONArray2.length()) {
                    }
                    bVar.a(hashSet);
                    arrayList.add(bVar);
                }
                return new ArrayList();
            }
            return arrayList;
        } catch (JSONException e10) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong.", e10);
            return new ArrayList();
        }
    }

    public Map<String, String> a(Context context, com.huawei.hms.framework.network.grs.a.a aVar, GrsBaseInfo grsBaseInfo, String str, boolean z10) {
        if (!this.f13846d) {
            return null;
        }
        com.huawei.hms.framework.network.grs.local.model.a aVar2 = this.f13843a;
        if (aVar2 == null) {
            Logger.w("AbstractLocalManager", "application data is null.");
            return null;
        }
        com.huawei.hms.framework.network.grs.local.model.c a10 = aVar2.a(str);
        if (a10 == null) {
            Logger.w("AbstractLocalManager", "service not found in local config{%s}", str);
            return null;
        }
        String a11 = f.a(context, aVar, a10.c(), grsBaseInfo, z10);
        if (a11 == null) {
            Logger.w("AbstractLocalManager", "country not found by routeby in local config{%s}", a10.c());
            return null;
        }
        List<b> a12 = a10.a();
        d a13 = a10.a(((a12 == null || a12.size() == 0) ? this.f13845c : a(a12, grsBaseInfo, a11)).get(a11));
        if (a13 == null) {
            return null;
        }
        return a13.a();
    }

    public boolean a(GrsBaseInfo grsBaseInfo) {
        this.f13845c.put("no_route_country", "no-country");
        List<b> list = this.f13844b;
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (b bVar : this.f13844b) {
            if (bVar.a().contains(grsBaseInfo.getIssueCountry())) {
                this.f13845c.put(grsBaseInfo.getIssueCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getRegCountry())) {
                this.f13845c.put(grsBaseInfo.getRegCountry(), bVar.b());
            }
            if (bVar.a().contains(grsBaseInfo.getSerCountry())) {
                this.f13845c.put(grsBaseInfo.getSerCountry(), bVar.b());
            }
        }
        return true;
    }

    public abstract int b(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008b A[LOOP:2: B:20:0x0085->B:22:0x008b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(JSONArray jSONArray) {
        String str;
        Iterator<String> keys;
        if (!(jSONArray == null || jSONArray.length() == 0)) {
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                String string = jSONObject.getString(ContactConstant.CallsRecordKeys.NAME);
                cVar.b(string);
                if (!this.f13847e.contains(string)) {
                    this.f13847e.add(string);
                    cVar.c(jSONObject.getString("routeBy"));
                    JSONArray jSONArray2 = jSONObject.getJSONArray("servings");
                    for (int i11 = 0; i11 < jSONArray2.length(); i11++) {
                        JSONObject jSONObject2 = (JSONObject) jSONArray2.get(i11);
                        d dVar = new d();
                        String str2 = "countryOrAreaGroup";
                        if (!jSONObject2.has(str2)) {
                            str2 = "countryGroup";
                            if (!jSONObject2.has(str2)) {
                                Logger.v("AbstractLocalManager", "maybe this service routeBy is unconditional.");
                                str = "no-country";
                                dVar.a(str);
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("addresses");
                                HashMap hashMap = new HashMap(16);
                                keys = jSONObject3.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    hashMap.put(next, jSONObject3.getString(next));
                                }
                                dVar.a(hashMap);
                                cVar.a(dVar.b(), dVar);
                            }
                        }
                        str = jSONObject2.getString(str2);
                        dVar.a(str);
                        JSONObject jSONObject32 = jSONObject2.getJSONObject("addresses");
                        HashMap hashMap2 = new HashMap(16);
                        keys = jSONObject32.keys();
                        while (keys.hasNext()) {
                        }
                        dVar.a(hashMap2);
                        cVar.a(dVar.b(), dVar);
                    }
                    List<b> list = null;
                    String str3 = "countryOrAreaGroups";
                    if (!jSONObject.has(str3)) {
                        str3 = "countryGroups";
                        if (!jSONObject.has(str3)) {
                            Logger.i("AbstractLocalManager", "service use default countryOrAreaGroup");
                            cVar.a(list);
                            if (this.f13843a == null) {
                                this.f13843a = new com.huawei.hms.framework.network.grs.local.model.a();
                            }
                            this.f13843a.a(string, cVar);
                        }
                    }
                    list = a(jSONObject.getJSONArray(str3));
                    cVar.a(list);
                    if (this.f13843a == null) {
                    }
                    this.f13843a.a(string, cVar);
                }
            }
        }
    }

    public boolean b() {
        return this.f13846d;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031 A[Catch: JSONException -> 0x003c, TRY_LEAVE, TryCatch #0 {JSONException -> 0x003c, blocks: (B:3:0x000e, B:6:0x001d, B:9:0x0024, B:11:0x002b, B:14:0x0031), top: B:19:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int c(String str) {
        String str2 = "countryOrAreaGroups";
        this.f13844b = new ArrayList(16);
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = null;
            if (!jSONObject.has(str2)) {
                if (jSONObject.has("countryGroups")) {
                    str2 = "countryGroups";
                } else {
                    Logger.e("AbstractLocalManager", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                    if (jSONArray != null) {
                        return -1;
                    }
                    this.f13844b.addAll(a(jSONArray));
                    return 0;
                }
            }
            jSONArray = jSONObject.getJSONArray(str2);
            if (jSONArray != null) {
            }
        } catch (JSONException e10) {
            Logger.w("AbstractLocalManager", "parse countrygroup failed maybe json style is wrong.", e10);
            return -1;
        }
    }

    public int d(String str) {
        try {
            b(new JSONObject(str).getJSONArray(SharedWearInfoHelper.TaskInfo.KEY_SERVICES));
            return 0;
        } catch (JSONException e10) {
            Logger.w("AbstractLocalManager", "parse 2.0 services failed maybe because of json style.please check!", e10);
            return -1;
        }
    }

    public abstract int e(String str);
}
