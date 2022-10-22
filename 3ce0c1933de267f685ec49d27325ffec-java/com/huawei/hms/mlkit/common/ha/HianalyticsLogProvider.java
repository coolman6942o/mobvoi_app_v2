package com.huawei.hms.mlkit.common.ha;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Pair;
import com.huawei.hms.framework.common.SystemPropUtils;
import com.huawei.hms.framework.network.grs.GrsApi;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.mlkit.common.ha.annotation.KeepHa;
import com.huawei.hms.mlkit.common.ha.event.BaseInfoGatherEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;
/* loaded from: classes2.dex */
public class HianalyticsLogProvider {

    /* renamed from: d  reason: collision with root package name */
    private static volatile Map<String, Long> f14051d = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private static Map<String, Timer> f14052g = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private static volatile HianalyticsLogProvider f14053j = new HianalyticsLogProvider();

    /* renamed from: e  reason: collision with root package name */
    private Context f14057e;

    /* renamed from: f  reason: collision with root package name */
    private a f14058f;

    /* renamed from: h  reason: collision with root package name */
    private GrsBaseInfo f14059h;

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f14054a = false;

    /* renamed from: b  reason: collision with root package name */
    private volatile boolean f14055b = true;

    /* renamed from: c  reason: collision with root package name */
    private String f14056c = null;

    /* renamed from: i  reason: collision with root package name */
    private Map<String, Map<String, Long>> f14060i = new HashMap();

    private HianalyticsLogProvider() {
    }

    private static boolean a(String str, Context context) {
        try {
            if (context != null) {
                return (context.getPackageManager().getPackageInfo(str, 0).applicationInfo.flags & 1) != 0;
            }
            b.c("HaLogProvider", "Context not initialized");
            return false;
        } catch (Exception e10) {
            b.b("HaLogProvider", "isPackageInternal Exception e: ".concat(String.valueOf(e10)));
            return false;
        }
    }

    private boolean b() {
        if ("CN".equalsIgnoreCase(c())) {
            return false;
        }
        if (this.f14058f != null) {
            b.c("HaLogProvider", "forbiddenHiLog openHa = " + this.f14058f.f14065e);
            return !this.f14058f.f14065e;
        }
        b.c("HaLogProvider", "forbiddenHiLog openHa is empty, appInfo is null");
        return true;
    }

    private static String c() {
        String str = GrsBaseInfo.CountryCodeSource.UNKNOWN;
        String property = SystemPropUtils.getProperty("get", "ro.hw.country", "android.os.SystemProperties", str);
        if (!"eu".equalsIgnoreCase(property) && !"la".equalsIgnoreCase(property)) {
            str = property;
        }
        b.c("HaLogProvider", "forbiddenHiLog.getVenderCountry=".concat(String.valueOf(str)));
        return str;
    }

    @KeepHa
    public static HianalyticsLogProvider getInstance() {
        return f14053j;
    }

    @KeepHa
    public String getTransId() {
        String str = this.f14056c;
        return str == null ? "" : str;
    }

    @KeepHa
    public void initTimer(String str) {
        if (this.f14056c == null) {
            this.f14056c = UUID.randomUUID().toString();
        }
        if (f14052g.get(str) == null) {
            Timer timer = new Timer();
            timer.schedule(new e(), 0L, 5000L);
            f14052g.put(str, timer);
            b.a("HaLogProvider", "init timer, timer=" + timer + ",moduleName=" + str);
        }
        a(str);
    }

    @KeepHa
    public HianalyticsLog logBegin(Context context, Bundle bundle) {
        this.f14057e = context.getApplicationContext();
        this.f14058f = d.a(context, bundle);
        HianalyticsLog hianalyticsLog = new HianalyticsLog();
        if (a() || !a(context)) {
            return hianalyticsLog;
        }
        hianalyticsLog.f14037h = String.valueOf(System.currentTimeMillis());
        return hianalyticsLog;
    }

    @KeepHa
    public void logEnd(HianalyticsLog hianalyticsLog) {
        if (!a() && hianalyticsLog.f14037h != null) {
            String str = hianalyticsLog.f14048s;
            Map<String, Long> map = this.f14060i.get(str);
            long j10 = 0;
            if (map == null) {
                map = new HashMap<>();
                map.put("allCnt", 0L);
                map.put("costTimeAll", 0L);
                this.f14060i.put(str, map);
            }
            map.put("allCnt", Long.valueOf((map.get("allCnt") == null ? 0L : map.get("allCnt").longValue()) + 1));
            long longValue = map.get("failCnt") == null ? 0L : map.get("failCnt").longValue();
            if (!hianalyticsLog.f14041l) {
                map.put("failCnt", Long.valueOf(longValue + 1));
            }
            map.put("costTimeAll", Long.valueOf((map.get("costTimeAll") == null ? 0L : map.get("costTimeAll").longValue()) + (System.currentTimeMillis() - Long.parseLong(hianalyticsLog.f14037h))));
            this.f14060i.put(str, map);
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = hianalyticsLog.f14048s;
            Long l10 = f14051d.get(str2);
            if (l10 == null) {
                l10 = 0L;
                f14051d.put(str2, l10);
            }
            if (this.f14055b || currentTimeMillis - l10.longValue() > 1000) {
                hianalyticsLog.f14036g = String.valueOf(currentTimeMillis - Long.parseLong(hianalyticsLog.f14037h));
                a aVar = this.f14058f;
                hianalyticsLog.f14030a = aVar.f14061a;
                hianalyticsLog.f14031b = aVar.f14062b;
                hianalyticsLog.f14032c = aVar.f14063c;
                hianalyticsLog.f14043n = aVar.f14064d;
                hianalyticsLog.f14039j = d.a(this.f14057e);
                hianalyticsLog.f14045p = d.a();
                hianalyticsLog.f14046q = d.b();
                hianalyticsLog.f14047r = d.c();
                hianalyticsLog.f14050u = d.d();
                hianalyticsLog.f14033d = d.e();
                hianalyticsLog.f14044o = this.f14058f.f14066f;
                hianalyticsLog.f14049t = "";
                hianalyticsLog.f14038i = this.f14056c;
                hianalyticsLog.f14040k = d.b(this.f14057e);
                LinkedHashMap<String, String> a10 = d.a(hianalyticsLog);
                Map<String, Long> map2 = this.f14060i.get(str2);
                long longValue2 = map2.get("allCnt") == null ? 0L : map2.get("allCnt").longValue();
                a10.put("allCnt", String.valueOf(longValue2));
                long longValue3 = map2.get("failCnt") == null ? 0L : map2.get("failCnt").longValue();
                a10.put("failCnt", String.valueOf(longValue3));
                long longValue4 = map2.get("costTimeAll") == null ? 0L : map2.get("costTimeAll").longValue();
                if (longValue2 != 0) {
                    j10 = longValue4 / longValue2;
                }
                a10.put("costTime", String.valueOf(j10));
                a10.put("lastCallTime", String.valueOf(System.currentTimeMillis()));
                a10.put("result", String.format("{0:%s}", String.valueOf(longValue2 - longValue3)));
                c cVar = c.f14068a;
                c.a(1, "60001", a10);
                c cVar2 = c.f14068a;
                c.a(0, "60001", a10);
                this.f14055b = false;
                b.c("HaLogProvider", a10.toString());
                f14051d.put(str2, Long.valueOf(currentTimeMillis));
                a(str2);
            }
        }
    }

    @KeepHa
    public void postEvent(Context context, int i10, BaseInfoGatherEvent baseInfoGatherEvent) {
        this.f14057e = context.getApplicationContext();
        if (this.f14056c == null) {
            this.f14056c = UUID.randomUUID().toString();
        }
        this.f14058f = d.a(context, baseInfoGatherEvent.getAppInfo());
        if (a()) {
            b.a("HaLogProvider", "HA is forbidden!");
        } else if (!a(context)) {
            b.c("HaLogProvider", "HA initializ fail!");
        } else {
            if ((i10 & 1) == 1) {
                c cVar = c.f14068a;
                c.a(1, baseInfoGatherEvent.getEventId(), baseInfoGatherEvent.getEventData(context));
            }
            if ((i10 & 2) == 2) {
                c cVar2 = c.f14068a;
                c.a(0, baseInfoGatherEvent.getEventId(), baseInfoGatherEvent.getEventData(context));
            }
            if ((i10 & 4) == 4) {
                c cVar3 = c.f14068a;
                c.a(2, baseInfoGatherEvent.getEventId(), baseInfoGatherEvent.getEventData(context));
            }
        }
    }

    @KeepHa
    public void reportAndCancelTimer() {
    }

    @KeepHa
    public void reportAndCancelTimer(String str) {
        if (this.f14056c != null) {
            this.f14056c = null;
        }
        this.f14055b = true;
        f14051d.clear();
        Timer timer = f14052g.get(str);
        if (timer != null) {
            if (!a()) {
                c cVar = c.f14068a;
                c.a();
            }
            b.a("HaLogProvider", "cancel timer, timer=" + timer + ",moduleName=" + str);
            timer.cancel();
            f14052g.remove(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    @KeepHa
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean sdkForbiddenHiLog(Context context) {
        Pair pair;
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent("com.huawei.hms.core.aidlservice"), 128);
        if (queryIntentServices.size() != 0) {
            Iterator<ResolveInfo> it = queryIntentServices.iterator();
            if (it.hasNext()) {
                ResolveInfo next = it.next();
                pair = new Pair(next.serviceInfo.applicationInfo.packageName, next);
                if ((pair != null ? false : a((String) pair.first, context)) || this.f14058f == null) {
                    return false;
                }
                b.c("HaLogProvider", "forbiddenHiLog openHa = " + this.f14058f.f14065e);
                return b();
            }
        }
        pair = null;
        if (pair != null ? false : a((String) pair.first, context)) {
        }
        return false;
    }

    private boolean a(Context context) {
        if (a() || this.f14054a) {
            return true;
        }
        b.c("HaLogProvider", "initlizeHaSdk APK mode,BUILD_MODE=APK");
        if (this.f14059h == null) {
            this.f14059h = new GrsBaseInfo();
            String str = this.f14058f.f14066f;
            b.a("HaLogProvider", "initGrsBaseInfo CountryCode = ".concat(String.valueOf(str)));
            if (str != null && !str.isEmpty() && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(str)) {
                this.f14059h.setSerCountry(str.toUpperCase(Locale.ENGLISH));
            }
        }
        GrsApi.grsSdkInit(context, this.f14059h);
        String synGetGrsUrl = GrsApi.synGetGrsUrl("com.huawei.cloud.mlkithianalytics", "ROOT");
        b.c("HaLogProvider", "GrsApi.synGetGrsUrl=" + synGetGrsUrl + ",BuildConfig.HIA_MODE=com.huawei.cloud.mlkithianalytics");
        this.f14054a = true;
        if (synGetGrsUrl == null || synGetGrsUrl.isEmpty()) {
            b.c("HaLogProvider", "grs get url is empty, countryCode=" + this.f14059h.getSerCountry());
            return false;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(synGetGrsUrl);
        c cVar = c.f14068a;
        return c.a(context, arrayList);
    }

    private boolean a() {
        return b();
    }

    private void a(String str) {
        if (this.f14060i.containsKey(str)) {
            this.f14060i.remove(str);
        }
    }
}
