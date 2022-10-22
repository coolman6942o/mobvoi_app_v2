package com.huawei.hianalytics.mn.no.pq;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hianalytics.mn.mn.no;
import com.huawei.hianalytics.mn.no.op.no.pq;
import com.huawei.hianalytics.mn.no.uv.mn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class qr {
    public static Map<String, List<pq>> mn(Context context, String str) {
        if (context == null) {
            return null;
        }
        Map<String, ?> no2 = mn.no(context, str);
        mn(no2);
        return no(no2);
    }

    public static Map<String, List<pq>> mn(Context context, String str, String str2) {
        Map<String, List<pq>> map;
        Map<String, List<pq>> map2;
        if ("alltype".equals(str2) || TextUtils.isEmpty(str)) {
            com.huawei.hianalytics.mn.no.qr.mn.no("EventManager", "read all event records");
            map = mn(context, "stat_v2_1");
            map2 = mn(context, "cached_v2_1");
        } else {
            String mn2 = com.huawei.hianalytics.mn.no.b.qr.mn(str, str2);
            map = no(context, "stat_v2_1", mn2);
            map2 = no(context, "cached_v2_1", mn2);
        }
        return mn(map, map2);
    }

    private static Map<String, List<pq>> mn(Map<String, List<pq>> map, Map<String, List<pq>> map2) {
        if (map.size() == 0 && map2.size() == 0) {
            return new HashMap();
        }
        if (map.size() == 0) {
            return map2;
        }
        if (map2.size() == 0) {
            return map;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<pq>> entry : map.entrySet()) {
            String key = entry.getKey();
            List<pq> value = entry.getValue();
            value.addAll(map2.get(key));
            hashMap.put(key, value);
        }
        return hashMap;
    }

    private static void mn(String str, String str2, Map<String, List<pq>> map) {
        ArrayList arrayList = new ArrayList();
        try {
            if (!TextUtils.isEmpty(str2)) {
                JSONArray jSONArray = new JSONArray(str2);
                if (jSONArray.length() != 0) {
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        pq pqVar = new pq();
                        try {
                            pqVar.mn(jSONArray.getJSONObject(i10));
                            arrayList.add(pqVar);
                        } catch (JSONException unused) {
                            com.huawei.hianalytics.mn.no.qr.mn.op("EventManager", "JSON Exception happened when create data for report - readDataToRecord");
                        }
                    }
                    map.put(str, arrayList);
                }
            }
        } catch (JSONException unused2) {
            com.huawei.hianalytics.mn.no.qr.mn.op("EventManager", "When events turn to JSONArray,JSON Exception has happened");
        }
    }

    private static void mn(Map<String, ?> map) {
        Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
        Set<String> mn2 = com.huawei.hianalytics.mn.no.b.qr.mn(no.mn());
        while (it.hasNext()) {
            if (!mn2.contains(it.next().getKey())) {
                it.remove();
            }
        }
    }

    public static Map<String, List<pq>> no(Context context, String str, String str2) {
        String no2 = mn.no(context, str, str2, "");
        HashMap hashMap = new HashMap();
        mn(str2, no2, hashMap);
        return hashMap;
    }

    private static Map<String, List<pq>> no(Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            if (entry.getValue() instanceof String) {
                mn(key, (String) entry.getValue(), hashMap);
            }
        }
        return hashMap;
    }
}
