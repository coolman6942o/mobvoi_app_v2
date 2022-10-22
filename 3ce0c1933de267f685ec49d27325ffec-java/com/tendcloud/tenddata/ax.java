package com.tendcloud.tenddata;

import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ax f22692a;

    static {
        try {
            v.a().register(a());
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private ax() {
    }

    public static ax a() {
        if (f22692a == null) {
            synchronized (ax.class) {
                if (f22692a == null) {
                    f22692a = new ax();
                }
            }
        }
        return f22692a;
    }

    public final void onTDEBEventAppEvent(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 2) {
                    a aVar2 = (a) aVar.paraMap.get("service");
                    TreeMap treeMap = new TreeMap();
                    String valueOf = String.valueOf(aVar.paraMap.get("eventId"));
                    Object obj = aVar.paraMap.get(HealthDataProviderContracts.NAME_VALUE);
                    Map<String, Object> map = ab.f22565e;
                    if (map.size() > 0) {
                        treeMap.putAll(map);
                    }
                    Object obj2 = aVar.paraMap.get("map");
                    if (obj2 != null && (obj2 instanceof Map)) {
                        treeMap.putAll((Map) obj2);
                    }
                    bi biVar = new bi();
                    biVar.f22732b = "appEvent";
                    biVar.f22733c = valueOf;
                    biVar.f22731a = aVar2;
                    TreeMap treeMap2 = new TreeMap();
                    Object obj3 = aVar.paraMap.get("eventLabel");
                    if (obj3 != null) {
                        treeMap2.put("eventLabel", String.valueOf(obj3));
                    }
                    treeMap2.put("eventParam", new JSONObject(a(treeMap)));
                    if (obj instanceof Double) {
                        treeMap2.put(HealthDataProviderContracts.NAME_VALUE, obj);
                    }
                    biVar.f22734d = treeMap2;
                    v.a().post(biVar);
                }
            } catch (NumberFormatException e10) {
                bf.postSDKError(e10);
            }
        }
    }

    private Map<String, Object> a(Map<String, Object> map) {
        TreeMap treeMap = new TreeMap();
        if (map != null) {
            try {
                if (map.size() != 0) {
                    int i10 = 0;
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (entry.getValue() instanceof Number) {
                            treeMap.put(entry.getKey(), entry.getValue());
                        } else {
                            treeMap.put(u.a(String.valueOf(entry.getKey())), u.a(String.valueOf(entry.getValue())));
                        }
                        i10++;
                        if (i10 == 50) {
                            break;
                        }
                    }
                } else {
                    return treeMap;
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
        return treeMap;
    }
}
