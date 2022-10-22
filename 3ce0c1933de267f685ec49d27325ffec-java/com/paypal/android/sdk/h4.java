package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
public class h4 {

    /* renamed from: d  reason: collision with root package name */
    private static final Map f21334d;

    /* renamed from: e  reason: collision with root package name */
    private static final Set f21335e;

    /* renamed from: f  reason: collision with root package name */
    private static /* synthetic */ boolean f21336f = true;

    /* renamed from: a  reason: collision with root package name */
    private Map f21337a = new LinkedHashMap();

    /* renamed from: b  reason: collision with root package name */
    private y4 f21338b;

    /* renamed from: c  reason: collision with root package name */
    private Class f21339c;

    static {
        HashMap hashMap = new HashMap();
        f21334d = hashMap;
        HashSet hashSet = new HashSet();
        f21335e = hashSet;
        hashMap.put("zh_CN", "zh-Hans");
        hashMap.put("zh_TW", "zh-Hant_TW");
        hashMap.put("zh_HK", "zh-Hant");
        hashMap.put("en_UK", "en_GB");
        hashMap.put("en_IE", "en_GB");
        hashMap.put("iw_IL", "he");
        hashMap.put("no", "nb");
        hashSet.add("he");
        hashSet.add("ar");
    }

    public h4(Class cls, List list) {
        this.f21339c = cls;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            y4 y4Var = (y4) it.next();
            String a10 = y4Var.a();
            if (a10 == null) {
                throw new RuntimeException("Null localeName");
            } else if (!this.f21337a.containsKey(a10)) {
                this.f21337a.put(a10, y4Var);
                e(a10);
            } else {
                throw new RuntimeException("Locale " + a10 + " already added");
            }
        }
        d(null);
    }

    private void e(String str) {
        Enum[] enumArr;
        y4 y4Var = (y4) this.f21337a.get(str);
        ArrayList arrayList = new ArrayList();
        for (Enum r52 : (Enum[]) this.f21339c.getEnumConstants()) {
            String str2 = "[" + str + "," + r52 + "]";
            if (y4Var.a(r52, null) == null) {
                arrayList.add("Missing " + str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private y4 f(String str) {
        String str2;
        y4 y4Var = null;
        if (str == null || str.length() < 2) {
            return null;
        }
        Map map = f21334d;
        if (map.containsKey(str)) {
            y4Var = (y4) this.f21337a.get((String) map.get(str));
        }
        if (y4Var == null) {
            if (str.contains("_")) {
                str2 = str;
            } else {
                str2 = str + "_" + Locale.getDefault().getCountry();
            }
            y4Var = (y4) this.f21337a.get(str2);
        }
        if (y4Var == null) {
            y4Var = (y4) this.f21337a.get(str);
        }
        if (y4Var != null) {
            return y4Var;
        }
        return (y4) this.f21337a.get(str.substring(0, 2));
    }

    public final String a() {
        return this.f21338b.a();
    }

    public final String b(Enum r42) {
        y4 y4Var = this.f21338b;
        String upperCase = Locale.getDefault().getCountry().toUpperCase(Locale.US);
        String a10 = y4Var.a(r42, upperCase);
        if (a10 == null) {
            this.f21338b.a();
            r42.toString();
            a10 = ((y4) this.f21337a.get("en")).a(r42, upperCase);
        }
        if (a10 != null) {
            return a10;
        }
        r42.toString();
        return r42.toString();
    }

    public final String c(String str, Enum r42) {
        String a10 = this.f21338b.a(str);
        return a10 != null ? a10 : String.format(b(r42), str);
    }

    public final void d(String str) {
        y4 y4Var = null;
        this.f21338b = null;
        if (str != null) {
            y4Var = f(str);
        }
        if (y4Var == null) {
            y4Var = f(Locale.getDefault().toString());
        }
        if (y4Var == null) {
            y4Var = (y4) this.f21337a.get("en");
        }
        boolean z10 = f21336f;
        if (z10 || y4Var != null) {
            this.f21338b = y4Var;
            if (z10 || y4Var != null) {
                this.f21338b.a();
                return;
            }
            throw new AssertionError();
        }
        throw new AssertionError();
    }
}
