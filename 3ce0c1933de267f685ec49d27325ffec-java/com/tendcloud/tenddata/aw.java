package com.tendcloud.tenddata;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.util.TelephonyUtil;
import com.tendcloud.tenddata.bh;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private static volatile aw f22666a;

    /* renamed from: b  reason: collision with root package name */
    private static String f22667b;

    /* renamed from: c  reason: collision with root package name */
    private static String f22668c;

    /* renamed from: d  reason: collision with root package name */
    private static String f22669d;

    /* renamed from: e  reason: collision with root package name */
    private static String f22670e;

    /* renamed from: f  reason: collision with root package name */
    private static String f22671f;

    /* renamed from: g  reason: collision with root package name */
    private static String f22672g;

    /* renamed from: h  reason: collision with root package name */
    private static String f22673h;

    /* renamed from: i  reason: collision with root package name */
    private static String f22674i;

    /* renamed from: j  reason: collision with root package name */
    private static String f22675j;

    /* renamed from: k  reason: collision with root package name */
    private static String f22676k;

    /* renamed from: l  reason: collision with root package name */
    private static String f22677l;

    /* renamed from: m  reason: collision with root package name */
    private static String f22678m;

    /* renamed from: n  reason: collision with root package name */
    private static String f22679n;

    /* renamed from: o  reason: collision with root package name */
    private static String f22680o;

    /* renamed from: p  reason: collision with root package name */
    private static String f22681p;

    /* renamed from: q  reason: collision with root package name */
    private static String f22682q;

    /* renamed from: r  reason: collision with root package name */
    private static String f22683r;

    /* renamed from: t  reason: collision with root package name */
    private static String f22684t;

    /* renamed from: z  reason: collision with root package name */
    private static JSONObject f22685z;

    /* renamed from: s  reason: collision with root package name */
    private String f22686s;

    /* renamed from: v  reason: collision with root package name */
    private String f22688v;

    /* renamed from: w  reason: collision with root package name */
    private int f22689w;

    /* renamed from: x  reason: collision with root package name */
    private String f22690x;

    /* renamed from: y  reason: collision with root package name */
    private JSONObject f22691y;

    /* renamed from: u  reason: collision with root package name */
    private a f22687u = a.UNKNOWN;
    private Map<String, Object> A = new TreeMap();

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public enum a {
        MALE,
        FEMALE,
        UNKNOWN
    }

    static {
        try {
            v.a().register(a());
        } catch (Throwable unused) {
        }
        f22667b = "account";
        f22668c = "accountId";
        f22669d = ContactConstant.CallsRecordKeys.NAME;
        f22670e = "gender";
        f22671f = "age";
        f22672g = "type";
        f22673h = "accountCus";
        f22674i = "property1";
        f22675j = "property2";
        f22676k = "property3";
        f22677l = "property4";
        f22678m = "property5";
        f22679n = "property6";
        f22680o = "property7";
        f22681p = "property8";
        f22682q = "property9";
        f22683r = "property10";
        f22684t = "default";
    }

    private aw() {
    }

    private boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return ((Boolean) obj).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private void b(Object obj, Object obj2, Object obj3, com.tendcloud.tenddata.a aVar) {
        try {
            c();
            Map<String, Object> b10 = b();
            b10.putAll((Map) obj);
            JSONObject jSONObject = new JSONObject(b10);
            h.setUniversalProfileInfo(jSONObject.toString());
            cc.a().setProfile(jSONObject);
            a(obj3, obj2, obj, aVar);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private void c() {
        try {
            String l10 = h.l();
            if (l10 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(l10);
                    if (jSONObject.has(f22668c)) {
                        String string = jSONObject.getString(f22668c);
                        this.f22686s = string;
                        this.A.put(f22668c, string);
                    }
                    if (jSONObject.has(f22669d)) {
                        Map<String, Object> map = this.A;
                        String str = f22669d;
                        map.put(str, jSONObject.getString(str));
                    }
                    if (jSONObject.has(f22672g)) {
                        Map<String, Object> map2 = this.A;
                        String str2 = f22672g;
                        map2.put(str2, Integer.valueOf(jSONObject.getInt(str2)));
                    }
                    if (jSONObject.has(f22670e)) {
                        Map<String, Object> map3 = this.A;
                        String str3 = f22670e;
                        map3.put(str3, Integer.valueOf(jSONObject.getInt(str3)));
                    }
                    if (jSONObject.has(f22671f)) {
                        Map<String, Object> map4 = this.A;
                        String str4 = f22671f;
                        map4.put(str4, Integer.valueOf(jSONObject.getInt(str4)));
                    }
                    if (jSONObject.has(f22674i)) {
                        Map<String, Object> map5 = this.A;
                        String str5 = f22674i;
                        map5.put(str5, jSONObject.get(str5));
                    }
                    if (jSONObject.has(f22675j)) {
                        Map<String, Object> map6 = this.A;
                        String str6 = f22675j;
                        map6.put(str6, jSONObject.get(str6));
                    }
                    if (jSONObject.has(f22676k)) {
                        Map<String, Object> map7 = this.A;
                        String str7 = f22676k;
                        map7.put(str7, jSONObject.get(str7));
                    }
                    if (jSONObject.has(f22677l)) {
                        Map<String, Object> map8 = this.A;
                        String str8 = f22677l;
                        map8.put(str8, jSONObject.get(str8));
                    }
                    if (jSONObject.has(f22678m)) {
                        Map<String, Object> map9 = this.A;
                        String str9 = f22678m;
                        map9.put(str9, jSONObject.get(str9));
                    }
                    if (jSONObject.has(f22679n)) {
                        Map<String, Object> map10 = this.A;
                        String str10 = f22679n;
                        map10.put(str10, jSONObject.get(str10));
                    }
                    if (jSONObject.has(f22680o)) {
                        Map<String, Object> map11 = this.A;
                        String str11 = f22680o;
                        map11.put(str11, jSONObject.get(str11));
                    }
                    if (jSONObject.has(f22681p)) {
                        Map<String, Object> map12 = this.A;
                        String str12 = f22681p;
                        map12.put(str12, jSONObject.get(str12));
                    }
                    if (jSONObject.has(f22682q)) {
                        Map<String, Object> map13 = this.A;
                        String str13 = f22682q;
                        map13.put(str13, jSONObject.get(str13));
                    }
                    if (jSONObject.has(f22683r)) {
                        Map<String, Object> map14 = this.A;
                        String str14 = f22683r;
                        map14.put(str14, jSONObject.get(str14));
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private void d() {
        try {
            Map<String, Object> f10 = f();
            zz.a aVar = new zz.a();
            aVar.paraMap.put("apiType", 9);
            aVar.paraMap.put("domain", f22667b);
            aVar.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "update");
            aVar.paraMap.put("data", f10);
            zz.c().obtainMessage(102, aVar).sendToTarget();
            cc.a().setProfile(new JSONObject(f10));
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private static void e() {
        h.setLastRoleName(f22684t);
        h.b(f22684t, f22685z.toString());
    }

    private Map<String, Object> f() {
        TreeMap treeMap = new TreeMap();
        try {
            treeMap.put(f22668c, this.f22686s);
            int i10 = this.f22689w;
            if (i10 != 0) {
                treeMap.put(f22671f, Integer.valueOf(i10));
            }
            if (!GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(this.f22687u.name())) {
                treeMap.put(f22670e, this.f22687u.name());
            }
            String str = this.f22688v;
            if (str != null) {
                treeMap.put(f22669d, str);
            }
            String str2 = this.f22690x;
            if (str2 != null) {
                treeMap.put(f22672g, str2);
            }
            JSONObject jSONObject = this.f22691y;
            if (jSONObject != null && jSONObject.length() > 0) {
                treeMap.put("custom", this.f22691y);
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
        return treeMap;
    }

    private static Map<String, Object> g() {
        TreeMap treeMap = new TreeMap();
        try {
            treeMap.put(ContactConstant.CallsRecordKeys.NAME, f22684t);
            JSONObject jSONObject = f22685z;
            if (jSONObject != null && jSONObject.length() > 0) {
                treeMap.put("custom", f22685z);
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
        return treeMap;
    }

    private static void h() {
        try {
            cc.a().setSubprofile(new JSONObject(g()));
            b(null);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public final void onTDEBEventAccount(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 9) {
                    aVar.paraMap.get("account");
                    com.tendcloud.tenddata.a aVar2 = (com.tendcloud.tenddata.a) aVar.paraMap.get("service");
                    Object obj = aVar.paraMap.get("data");
                    Object obj2 = aVar.paraMap.get("domain");
                    Object obj3 = aVar.paraMap.get(TelephonyUtil.KEY_SIM_ACTION);
                    Object obj4 = aVar.paraMap.get("immediate");
                    if (obj3 != null) {
                        if (!obj3.equals("login") && !obj3.equals("register")) {
                            if (obj3.equals("roleCreate")) {
                                a(String.valueOf(aVar.paraMap.get("parameter")), aVar2);
                                return;
                            } else if (obj3.equals("update")) {
                                b(obj, obj3, obj2, aVar2);
                                return;
                            }
                        }
                        a(String.valueOf(aVar.paraMap.get("accountId")), obj, obj3, obj2, aVar.paraMap.get("invitationCode"), aVar2);
                        return;
                    }
                    if (obj3 != null) {
                        a(obj2, obj3, obj, aVar2);
                        if (a(obj4)) {
                            a(aVar2);
                        }
                    }
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    public void setAccountType(String str) {
        try {
            String str2 = this.f22690x;
            if (str2 == null || !str2.equalsIgnoreCase(str)) {
                this.f22690x = str;
                d();
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public void setAge(int i10) {
        try {
            if (this.f22689w != i10) {
                this.f22689w = i10;
                d();
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public void setGender(a aVar) {
        try {
            if (this.f22687u != aVar) {
                this.f22687u = aVar;
                d();
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public void setName(String str) {
        try {
            String str2 = this.f22688v;
            if (str2 == null || !str2.equalsIgnoreCase(str)) {
                this.f22688v = str;
                d();
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private void a(com.tendcloud.tenddata.a aVar) {
        try {
            bh bhVar = new bh();
            bhVar.f22730b = bh.a.IMMEDIATELY;
            bhVar.f22729a = aVar;
            v.a().post(bhVar);
        } catch (Throwable unused) {
        }
    }

    protected static void a(Object obj, Object obj2, Object obj3, com.tendcloud.tenddata.a aVar) {
        if (aVar != null && obj != null && obj2 != null && (obj instanceof String) && (obj2 instanceof String)) {
            bi biVar = new bi();
            biVar.f22732b = String.valueOf(obj);
            biVar.f22733c = String.valueOf(obj2);
            if (obj3 != null && (obj3 instanceof Map)) {
                biVar.f22734d = (Map) obj3;
            }
            biVar.f22731a = aVar;
            v.a().post(biVar);
        }
    }

    private Map<String, Object> b() {
        try {
            String str = this.f22686s;
            if (str != null) {
                this.A.put(f22668c, str);
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
        return this.A;
    }

    public synchronized void b(String str, String str2) {
        if (this.f22691y == null) {
            this.f22691y = new JSONObject();
        }
        try {
            this.f22691y.put(str, str2);
            d();
        } catch (Throwable unused) {
        }
    }

    private void a(String str, Object obj, Object obj2, Object obj3, Object obj4, com.tendcloud.tenddata.a aVar) {
        try {
            c();
            String str2 = this.f22686s;
            if (str2 != null && !str2.equals(str)) {
                this.A.clear();
            }
            this.f22686s = str;
            TreeMap treeMap = new TreeMap();
            treeMap.put(f22668c, this.f22686s);
            treeMap.putAll((Map) obj);
            if (obj4 != null) {
                treeMap.put("invitationCode", String.valueOf(obj4));
            }
            this.A.putAll(treeMap);
            JSONObject jSONObject = new JSONObject(this.A);
            h.setUniversalProfileInfo(jSONObject.toString());
            cc.a().setProfile(jSONObject);
            a(obj3, obj2, treeMap, aVar);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public synchronized void b(String str, int i10) {
        if (this.f22691y == null) {
            this.f22691y = new JSONObject();
        }
        try {
            this.f22691y.put(str, i10);
            d();
        } catch (Throwable unused) {
        }
    }

    private static void b(com.tendcloud.tenddata.a aVar) {
        try {
            Map<String, Object> g10 = g();
            cc.a().setSubprofile(new JSONObject(g10));
            a(f22667b, "roleUpdate", g10, aVar);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private void a(String str) {
        try {
            this.f22686s = str;
            String a10 = h.a(str);
            if (a10 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(a10);
                    if (jSONObject.has(f22669d)) {
                        this.f22688v = jSONObject.getString(f22669d);
                    }
                    if (jSONObject.has(f22670e)) {
                        this.f22687u = a.valueOf(jSONObject.getString(f22670e));
                    }
                    if (jSONObject.has(f22671f)) {
                        this.f22689w = jSONObject.getInt(f22671f);
                    }
                    if (jSONObject.has(f22672g)) {
                        this.f22690x = jSONObject.getString(f22672g);
                    }
                    if (jSONObject.has(f22673h)) {
                        this.f22691y = jSONObject.getJSONObject(f22673h);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public static synchronized void a(String str, com.tendcloud.tenddata.a aVar) {
        synchronized (aw.class) {
            try {
                f22685z = new JSONObject();
                f22684t = str;
                Map<String, Object> g10 = g();
                a(f22667b, "roleCreate", g10, aVar);
                cc.a().setSubprofile(new JSONObject(g10));
            } catch (Throwable unused) {
            }
        }
    }

    public synchronized void a(String str, String str2) {
        if (f22685z == null) {
            f22685z = new JSONObject();
        }
        try {
            f22685z.put(str, str2);
            e();
            h();
        } catch (Throwable unused) {
        }
    }

    public synchronized void a(String str, int i10) {
        if (f22685z == null) {
            f22685z = new JSONObject();
        }
        try {
            f22685z.put(str, i10);
            e();
            h();
        } catch (Throwable unused) {
        }
    }

    public static aw a() {
        if (f22666a == null) {
            synchronized (aw.class) {
                if (f22666a == null) {
                    f22666a = new aw();
                }
            }
        }
        return f22666a;
    }
}
