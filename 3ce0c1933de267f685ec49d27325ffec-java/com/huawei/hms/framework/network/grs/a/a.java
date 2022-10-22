package com.huawei.hms.framework.network.grs.a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b;
import com.huawei.hms.framework.network.grs.c.b.c;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.m;
import com.huawei.hms.framework.network.grs.d.e;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13822a = "a";

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Map<String, Map<String, String>>> f13823b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    private Map<String, Long> f13824c = new ConcurrentHashMap(16);

    /* renamed from: d  reason: collision with root package name */
    private c f13825d;

    /* renamed from: e  reason: collision with root package name */
    private m f13826e;

    public a(c cVar, m mVar) {
        this.f13825d = cVar;
        this.f13826e = mVar;
        mVar.a(this);
    }

    private void a(GrsBaseInfo grsBaseInfo, b bVar, Context context, String str) {
        Long l10 = this.f13824c.get(grsBaseInfo.getGrsParasKey(false, true, context));
        if (e.a(l10)) {
            bVar.a(2);
            return;
        }
        if (e.a(l10, 300000L)) {
            this.f13826e.a(new c(grsBaseInfo, context), (b) null, str);
        }
        bVar.a(1);
    }

    private void a(GrsBaseInfo grsBaseInfo, String str, Context context) {
        if (e.a(this.f13824c.get(str), 300000L)) {
            this.f13826e.a(new c(grsBaseInfo, context), (b) null, (String) null);
        }
    }

    public c a() {
        return this.f13825d;
    }

    public String a(GrsBaseInfo grsBaseInfo, String str, String str2, b bVar, Context context) {
        Map<String, String> a10 = a(grsBaseInfo, str, bVar, context);
        if (a10 == null) {
            return null;
        }
        return a10.get(str2);
    }

    public Map<String, String> a(GrsBaseInfo grsBaseInfo, String str, b bVar, Context context) {
        Map<String, Map<String, String>> map = this.f13823b.get(grsBaseInfo.getGrsParasKey(false, true, context));
        if (map == null || map.isEmpty()) {
            return new HashMap();
        }
        a(grsBaseInfo, bVar, context, str);
        return map.get(str);
    }

    public void a(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(false, true, context);
        c cVar = this.f13825d;
        cVar.b(grsParasKey + "time", "0");
        Map<String, Long> map = this.f13824c;
        map.remove(grsParasKey + "time");
        this.f13823b.remove(grsParasKey);
        this.f13826e.a(grsParasKey);
    }

    public void a(GrsBaseInfo grsBaseInfo, f fVar, Context context, c cVar) {
        if (fVar.e() == 2) {
            Logger.w(f13822a, "update cache from server failed");
        } else if (cVar.d().size() == 0) {
            String grsParasKey = grsBaseInfo.getGrsParasKey(false, true, context);
            this.f13825d.b(grsParasKey, fVar.i());
            c cVar2 = this.f13825d;
            cVar2.b(grsParasKey + "time", fVar.a());
            this.f13823b.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(fVar.i()));
            this.f13824c.put(grsParasKey, Long.valueOf(Long.parseLong(fVar.a())));
        } else {
            this.f13825d.b("geoipCountryCode", fVar.i());
            this.f13825d.b("geoipCountryCodetime", fVar.a());
        }
    }

    public m b() {
        return this.f13826e;
    }

    public void b(GrsBaseInfo grsBaseInfo, Context context) {
        String grsParasKey = grsBaseInfo.getGrsParasKey(false, true, context);
        String a10 = this.f13825d.a(grsParasKey, "");
        c cVar = this.f13825d;
        String a11 = cVar.a(grsParasKey + "time", "0");
        long j10 = 0;
        if (!TextUtils.isEmpty(a11) && a11.matches("\\d+")) {
            try {
                j10 = Long.parseLong(a11);
            } catch (NumberFormatException e10) {
                Logger.w(f13822a, "convert urlParamKey from String to Long catch NumberFormatException.", e10);
            }
        }
        this.f13823b.put(grsParasKey, com.huawei.hms.framework.network.grs.a.a(a10));
        this.f13824c.put(grsParasKey, Long.valueOf(j10));
        a(grsBaseInfo, grsParasKey, context);
    }
}
