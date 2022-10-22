package com.huawei.hms.scankit.p;

import android.content.Context;
import android.util.Log;
import com.alipay.sdk.app.PayTask;
import com.huawei.hianalytics.scankit.HiAnalytics;
import com.huawei.hianalytics.scankit.HiAnalyticsConf;
import com.huawei.hianalytics.scankit.HiAnalyticsTools;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: HiAnalyticsLogExecutor.java */
/* renamed from: com.huawei.hms.scankit.p.bb  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0569bb {

    /* renamed from: a  reason: collision with root package name */
    private static volatile C0569bb f14743a = new C0569bb();

    /* renamed from: d  reason: collision with root package name */
    private volatile boolean f14746d;

    /* renamed from: e  reason: collision with root package name */
    private volatile long f14747e;

    /* renamed from: b  reason: collision with root package name */
    private Timer f14744b = new Timer();

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f14745c = true;

    /* renamed from: f  reason: collision with root package name */
    private final Lock f14748f = new ReentrantLock();

    /* renamed from: g  reason: collision with root package name */
    private List<a> f14749g = new ArrayList(5);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HiAnalyticsLogExecutor.java */
    /* renamed from: com.huawei.hms.scankit.p.bb$a */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        private String f14750a;

        /* renamed from: b  reason: collision with root package name */
        private LinkedHashMap<String, String> f14751b;

        /* synthetic */ a(C0569bb bbVar, String str, LinkedHashMap linkedHashMap, C0565ab abVar) {
            this(str, linkedHashMap);
        }

        private a(String str, LinkedHashMap<String, String> linkedHashMap) {
            this.f14750a = str;
            this.f14751b = linkedHashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HiAnalyticsLogExecutor.java */
    /* renamed from: com.huawei.hms.scankit.p.bb$b */
    /* loaded from: classes2.dex */
    public class b extends TimerTask {
        private b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                C0569bb.this.f14745c = true;
                HiAnalytics.onReport();
            } catch (Exception e10) {
                com.huawei.hms.scankit.util.a.b("ScanHiAnalytics", e10.getMessage());
            }
        }

        /* synthetic */ b(C0569bb bbVar, C0565ab abVar) {
            this();
        }
    }

    private C0569bb() {
    }

    private synchronized void b(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.f14746d) {
            c(str, linkedHashMap);
        } else if (this.f14749g.size() < 100) {
            this.f14749g.add(new a(this, str, linkedHashMap, null));
        }
    }

    private void c(String str, LinkedHashMap<String, String> linkedHashMap) {
        HiAnalytics.onEvent(0, str, linkedHashMap);
        HiAnalytics.onEvent(1, str, linkedHashMap);
        if (this.f14745c) {
            this.f14745c = false;
            this.f14744b.schedule(new b(this, null), PayTask.f6879j);
        }
        com.huawei.hms.scankit.util.a.a("ScanHiAnalytics", linkedHashMap.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.f14748f.tryLock() && !this.f14746d) {
            try {
                Context context = DynamicModuleInitializer.getContext();
                if (context != null) {
                    String a10 = a(context);
                    if (a10 != null && !a10.isEmpty()) {
                        HiAnalyticsTools.enableLog();
                        new HiAnalyticsConf.Builder(context).setEnableImei(false).setEnableUUID(false).setCollectURL(0, a10).setCollectURL(1, a10).create();
                        b();
                    }
                }
            } finally {
                this.f14748f.unlock();
            }
        }
    }

    public static C0569bb a() {
        return f14743a;
    }

    public void a(String str, LinkedHashMap<String, String> linkedHashMap) {
        if (this.f14746d) {
            c(str, linkedHashMap);
            return;
        }
        b(str, linkedHashMap);
        c();
    }

    private synchronized void b() {
        this.f14746d = true;
        for (a aVar : this.f14749g) {
            c(aVar.f14750a, aVar.f14751b);
        }
        this.f14749g = null;
    }

    private void c() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f14747e > 6000) {
            this.f14747e = currentTimeMillis;
            new C0565ab(this, "ScanHiAnalytics").start();
        }
    }

    private String a(Context context) {
        try {
            GrsBaseInfo grsBaseInfo = new GrsBaseInfo();
            String a10 = new La(context, false).a();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("getCollectURL:localCountryCode ");
            sb2.append(a10);
            Log.i("ScanHiAnalytics", sb2.toString());
            if (a10 != null && !a10.isEmpty() && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equals(a10)) {
                grsBaseInfo.setSerCountry(a10.toUpperCase(Locale.ENGLISH));
            }
            String synGetGrsUrl = new GrsClient(context, grsBaseInfo).synGetGrsUrl("com.huawei.cloud.mlkithianalytics", "ROOT");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("grs get url success: ");
            sb3.append(synGetGrsUrl);
            sb3.append("  countryCode = ");
            sb3.append(grsBaseInfo.getSerCountry());
            Log.i("ScanHiAnalytics", sb3.toString());
            return synGetGrsUrl;
        } catch (RuntimeException | Exception unused) {
            return null;
        }
    }
}
