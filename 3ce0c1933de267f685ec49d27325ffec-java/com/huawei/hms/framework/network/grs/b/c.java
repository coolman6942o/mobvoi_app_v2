package com.huawei.hms.framework.network.grs.b;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.a;
import com.huawei.hms.framework.network.grs.local.model.b;
import com.huawei.hms.framework.network.grs.local.model.d;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.providers.OtaColumn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c extends a {
    public c(Context context) {
        if (a("grs_sdk_global_route_config.json", context, false) == 0) {
            this.f13846d = true;
        }
    }

    @Override // com.huawei.hms.framework.network.grs.b.a
    public int a(String str) {
        this.f13843a = new a();
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("application");
            String string = jSONObject.getString(ContactConstant.CallsRecordKeys.NAME);
            long j10 = jSONObject.getLong("cacheControl");
            JSONArray jSONArray = jSONObject.getJSONArray(SharedWearInfoHelper.TaskInfo.KEY_SERVICES);
            this.f13843a.b(string);
            this.f13843a.a(j10);
            if (jSONArray != null) {
                if (jSONArray.length() != 0) {
                    return 0;
                }
            }
            return -1;
        } catch (JSONException e10) {
            Logger.w("LocalManagerV1", "parse appbean failed maybe json style is wrong.", e10);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0073 A[Catch: JSONException -> 0x008d, LOOP:1: B:28:0x006d->B:30:0x0073, LOOP_END, TryCatch #0 {JSONException -> 0x008d, blocks: (B:6:0x000e, B:7:0x0019, B:9:0x001f, B:11:0x0033, B:13:0x003c, B:17:0x004e, B:19:0x0054, B:21:0x005b, B:22:0x005e, B:24:0x0065, B:28:0x006d, B:30:0x0073, B:31:0x007f, B:32:0x0086), top: B:40:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<b> a(JSONArray jSONArray, JSONObject jSONObject) {
        HashSet hashSet;
        int i10;
        if (jSONObject == null || jSONObject.length() == 0) {
            return new ArrayList();
        }
        try {
            ArrayList arrayList = new ArrayList(16);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                b bVar = new b();
                bVar.b(next);
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                bVar.c(jSONObject2.getString(ContactConstant.CallsRecordKeys.NAME));
                bVar.a(jSONObject2.getString(OtaColumn.COLUMN_DESCRIPTION));
                JSONArray jSONArray2 = null;
                String str = "countries";
                if (jSONObject2.has("countriesOrAreas")) {
                    str = "countriesOrAreas";
                } else if (!jSONObject2.has(str)) {
                    Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
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
                jSONArray2 = jSONObject2.getJSONArray(str);
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
            Logger.w("LocalManagerV1", "parse countryGroups failed maybe json style is wrong.", e10);
            return new ArrayList();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0033 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034 A[Catch: JSONException -> 0x00b0, TryCatch #0 {JSONException -> 0x00b0, blocks: (B:3:0x0010, B:6:0x001f, B:9:0x0026, B:11:0x002d, B:14:0x0034, B:16:0x003b, B:17:0x003f, B:19:0x0045, B:21:0x0059, B:23:0x0062, B:27:0x0073, B:29:0x0079, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:38:0x0093, B:40:0x0099, B:41:0x00a5), top: B:47:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099 A[Catch: JSONException -> 0x00b0, LOOP:1: B:38:0x0093->B:40:0x0099, LOOP_END, TryCatch #0 {JSONException -> 0x00b0, blocks: (B:3:0x0010, B:6:0x001f, B:9:0x0026, B:11:0x002d, B:14:0x0034, B:16:0x003b, B:17:0x003f, B:19:0x0045, B:21:0x0059, B:23:0x0062, B:27:0x0073, B:29:0x0079, B:31:0x0080, B:32:0x0084, B:34:0x008b, B:38:0x0093, B:40:0x0099, B:41:0x00a5), top: B:47:0x0010 }] */
    @Override // com.huawei.hms.framework.network.grs.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(String str) {
        JSONObject jSONObject;
        JSONArray jSONArray;
        HashSet hashSet;
        int i10;
        String str2 = "countryOrAreaGroups";
        this.f13844b = new ArrayList(16);
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (!jSONObject2.has(str2)) {
                if (jSONObject2.has("countryGroups")) {
                    str2 = "countryGroups";
                } else {
                    Logger.e("LocalManagerV1", "maybe local config json is wrong because the default countryOrAreaGroups isn't config.");
                    jSONObject = null;
                    if (jSONObject != null) {
                        return -1;
                    }
                    if (jSONObject.length() != 0) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            b bVar = new b();
                            bVar.b(next);
                            JSONObject jSONObject3 = jSONObject.getJSONObject(next);
                            bVar.c(jSONObject3.getString(ContactConstant.CallsRecordKeys.NAME));
                            bVar.a(jSONObject3.getString(OtaColumn.COLUMN_DESCRIPTION));
                            String str3 = "countries";
                            if (jSONObject3.has("countriesOrAreas")) {
                                str3 = "countriesOrAreas";
                            } else if (!jSONObject3.has(str3)) {
                                Logger.w("LocalManagerV1", "current country or area group has not config countries or areas.");
                                jSONArray = null;
                                hashSet = new HashSet(16);
                                if (!(jSONArray == null || jSONArray.length() == 0)) {
                                    for (i10 = 0; i10 < jSONArray.length(); i10++) {
                                        hashSet.add((String) jSONArray.get(i10));
                                    }
                                    bVar.a(hashSet);
                                    this.f13844b.add(bVar);
                                }
                                return -1;
                            }
                            jSONArray = jSONObject3.getJSONArray(str3);
                            hashSet = new HashSet(16);
                            if (jSONArray == null) {
                                while (i10 < jSONArray.length()) {
                                }
                                bVar.a(hashSet);
                                this.f13844b.add(bVar);
                            }
                            return -1;
                        }
                    }
                    return 0;
                }
            }
            jSONObject = jSONObject2.getJSONObject(str2);
            if (jSONObject != null) {
            }
        } catch (JSONException e10) {
            Logger.w("LocalManagerV1", "parse countrygroup failed maybe json style is wrong.", e10);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0097 A[Catch: JSONException -> 0x0102, LOOP:2: B:30:0x0091->B:32:0x0097, LOOP_END, TryCatch #0 {JSONException -> 0x0102, blocks: (B:3:0x000a, B:5:0x0013, B:6:0x001b, B:8:0x0022, B:10:0x0038, B:12:0x0043, B:14:0x004c, B:15:0x0050, B:17:0x0056, B:21:0x006b, B:23:0x0071, B:25:0x0078, B:27:0x007d, B:29:0x0082, B:30:0x0091, B:32:0x0097, B:33:0x00af, B:34:0x00c4, B:36:0x00cf, B:37:0x00d4, B:39:0x00da, B:40:0x00de, B:42:0x00e5, B:43:0x00e8, B:45:0x00ef, B:46:0x00f6), top: B:52:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ef A[Catch: JSONException -> 0x0102, TryCatch #0 {JSONException -> 0x0102, blocks: (B:3:0x000a, B:5:0x0013, B:6:0x001b, B:8:0x0022, B:10:0x0038, B:12:0x0043, B:14:0x004c, B:15:0x0050, B:17:0x0056, B:21:0x006b, B:23:0x0071, B:25:0x0078, B:27:0x007d, B:29:0x0082, B:30:0x0091, B:32:0x0097, B:33:0x00af, B:34:0x00c4, B:36:0x00cf, B:37:0x00d4, B:39:0x00da, B:40:0x00de, B:42:0x00e5, B:43:0x00e8, B:45:0x00ef, B:46:0x00f6), top: B:52:0x000a }] */
    @Override // com.huawei.hms.framework.network.grs.b.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(String str) {
        JSONObject jSONObject;
        String str2;
        Iterator<String> keys;
        String str3 = "countryOrAreaGroup";
        try {
            JSONObject jSONObject2 = new JSONObject(str).getJSONObject(SharedWearInfoHelper.TaskInfo.KEY_SERVICES);
            Iterator<String> keys2 = jSONObject2.keys();
            while (true) {
                if (!keys2.hasNext()) {
                    return 0;
                }
                String next = keys2.next();
                com.huawei.hms.framework.network.grs.local.model.c cVar = new com.huawei.hms.framework.network.grs.local.model.c();
                cVar.b(next);
                if (!this.f13847e.contains(next)) {
                    this.f13847e.add(next);
                    JSONObject jSONObject3 = jSONObject2.getJSONObject(next);
                    cVar.c(jSONObject3.getString("routeBy"));
                    JSONArray jSONArray = jSONObject3.getJSONArray("servings");
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject4 = (JSONObject) jSONArray.get(i10);
                        d dVar = new d();
                        String str4 = "countryGroup";
                        if (jSONObject4.has(str3)) {
                            str4 = str3;
                        } else if (!jSONObject4.has(str4)) {
                            Logger.v("LocalManagerV1", "maybe this service routeBy is unconditional.");
                            str2 = "no-country";
                            dVar.a(str2);
                            JSONObject jSONObject5 = jSONObject4.getJSONObject("addresses");
                            HashMap hashMap = new HashMap(16);
                            keys = jSONObject5.keys();
                            while (keys.hasNext()) {
                                str3 = str3;
                                String next2 = keys.next();
                                jSONObject2 = jSONObject2;
                                hashMap.put(next2, jSONObject5.getString(next2));
                            }
                            str3 = str3;
                            jSONObject2 = jSONObject2;
                            dVar.a(hashMap);
                            cVar.a(dVar.b(), dVar);
                        }
                        str2 = jSONObject4.getString(str4);
                        dVar.a(str2);
                        JSONObject jSONObject52 = jSONObject4.getJSONObject("addresses");
                        HashMap hashMap2 = new HashMap(16);
                        keys = jSONObject52.keys();
                        while (keys.hasNext()) {
                        }
                        str3 = str3;
                        jSONObject2 = jSONObject2;
                        dVar.a(hashMap2);
                        cVar.a(dVar.b(), dVar);
                    }
                    str3 = str3;
                    jSONObject2 = jSONObject2;
                    List<b> list = null;
                    if (jSONObject3.has("countryOrAreaGroups")) {
                        jSONObject = jSONObject3.getJSONObject("countryOrAreaGroups");
                    } else if (jSONObject3.has("countryGroups")) {
                        jSONObject = jSONObject3.getJSONObject("countryGroups");
                    } else {
                        Logger.v("LocalManagerV1", "service use default countryOrAreaGroup");
                        cVar.a(list);
                        if (this.f13843a == null) {
                            this.f13843a = new a();
                        }
                        this.f13843a.a(next, cVar);
                    }
                    list = a((JSONArray) null, jSONObject);
                    cVar.a(list);
                    if (this.f13843a == null) {
                    }
                    this.f13843a.a(next, cVar);
                }
            }
        } catch (JSONException e10) {
            Logger.w("LocalManagerV1", "parse 1.0 services failed maybe because of json style.please check!", e10);
            return -1;
        }
    }
}
