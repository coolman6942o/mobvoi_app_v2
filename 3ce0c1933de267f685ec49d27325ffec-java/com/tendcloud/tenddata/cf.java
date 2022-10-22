package com.tendcloud.tenddata;

import com.mobvoi.wear.twappstore.WearableAppXmlParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cf extends ch {

    /* renamed from: a  reason: collision with root package name */
    private static HashMap<String, Object> f22798a = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, Object> f22799c = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static volatile cf f22800f = null;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f22801d = {"PUSH", "EAuth"};

    /* renamed from: e  reason: collision with root package name */
    private final String[] f22802e = {"APP", "TRACKING", "GAME", "BG", "SDK"};

    private cf() {
        a("displayName", f.a().h(ab.f22568h));
        a("globalId", f.a().a(ab.f22568h));
        a(WearableAppXmlParser.VERSION_NAME_TAG, h.j());
        a(WearableAppXmlParser.VERSION_CODE_TAG, Integer.valueOf(h.i()));
        a("installTime", Long.valueOf(f.a().d(ab.f22568h)));
        a("updateTime", Long.valueOf(f.a().e(ab.f22568h)));
    }

    private ArrayList<a> c() {
        ArrayList<a> arrayList = new ArrayList<>();
        try {
            for (Map.Entry<String, Object> entry : f22798a.entrySet()) {
                arrayList.add(a.valueOf(entry.getKey().toString()));
            }
        } catch (Throwable unused) {
        }
        return arrayList;
    }

    public void a(Object obj, a aVar) {
        f22798a.put(aVar.name(), obj);
    }

    public void b(Object obj, a aVar) {
        f22799c.put(aVar.name(), obj);
    }

    public void setAppChannel(String str) {
        a("channel", str);
    }

    public void setSubmitAppId(a aVar) {
        if (aVar != null) {
            try {
                Object obj = f22798a.get(aVar.name());
                if (obj == null && f22798a.size() > 0) {
                    obj = a(aVar);
                }
                a("appKey", obj);
            } catch (Throwable unused) {
            }
        }
    }

    public void setSubmitChannelId(a aVar) {
        if (aVar != null) {
            try {
                Object obj = f22799c.get(aVar.name());
                if (obj == null && f22799c.size() > 0) {
                    obj = f22799c.get(c().get(0).name());
                }
                a("channel", obj);
            } catch (Throwable unused) {
            }
        } else {
            setAppChannel("Default");
        }
    }

    public void setUniqueId(String str) {
        a("uniqueId", str);
    }

    private Object a(a aVar) {
        JSONArray jSONArray = null;
        jSONArray = null;
        if (aVar != null) {
            try {
                if (Arrays.asList(this.f22801d).contains(aVar.name())) {
                    JSONArray jSONArray2 = new JSONArray();
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appKey", (Object) null);
                    jSONObject.put("service", (Object) null);
                    jSONArray2.put(jSONObject);
                    try {
                        if (!u.b((String) null)) {
                            a(jSONArray2, aVar);
                        }
                    } catch (Throwable unused) {
                    }
                    jSONArray = jSONArray2;
                } else if (Arrays.asList(this.f22802e).contains(aVar.name())) {
                    String a10 = ab.a(ab.f22568h, aVar);
                    boolean b10 = u.b(a10);
                    jSONArray = a10;
                    if (!b10) {
                        a((Object) a10, aVar);
                        jSONArray = a10;
                    }
                } else {
                    jSONArray = f22798a.get(c().get(0).name());
                }
            } catch (Throwable unused2) {
            }
        }
        return jSONArray;
    }

    public static cf a() {
        if (f22800f == null) {
            synchronized (by.class) {
                if (f22800f == null) {
                    f22800f = new cf();
                }
            }
        }
        return f22800f;
    }
}
