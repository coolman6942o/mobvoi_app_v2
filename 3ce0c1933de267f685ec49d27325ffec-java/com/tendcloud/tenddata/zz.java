package com.tendcloud.tenddata;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.lpa.LpaConstants;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.mobvoi.wear.providers.OtaColumn;
import com.mobvoi.wear.util.TelephonyUtil;
import com.tendcloud.tenddata.af;
import com.unionpay.tsmservice.data.Constant;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class zz implements ao {

    /* renamed from: a  reason: collision with root package name */
    public static String f23039a = null;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f23040b = false;

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f23041c = false;

    /* renamed from: d  reason: collision with root package name */
    static boolean f23042d = false;

    /* renamed from: e  reason: collision with root package name */
    public static b f23043e = null;

    /* renamed from: f  reason: collision with root package name */
    public static final int f23044f = 102;

    /* renamed from: g  reason: collision with root package name */
    private static volatile zz f23045g = null;

    /* renamed from: h  reason: collision with root package name */
    private static String f23046h = null;

    /* renamed from: i  reason: collision with root package name */
    private static String f23047i = null;

    /* renamed from: j  reason: collision with root package name */
    private static String f23048j = null;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f23049k = false;

    /* renamed from: l  reason: collision with root package name */
    private static final int f23050l = 101;

    /* renamed from: m  reason: collision with root package name */
    private static final int f23051m = 103;

    /* renamed from: n  reason: collision with root package name */
    private static Handler f23052n;

    /* renamed from: o  reason: collision with root package name */
    private static final HandlerThread f23053o;

    /* renamed from: p  reason: collision with root package name */
    private static Handler f23054p;

    /* renamed from: q  reason: collision with root package name */
    private static final HandlerThread f23055q;

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class a {
        public HashMap<String, Object> paraMap = new HashMap<>();
    }

    static {
        HandlerThread handlerThread = new HandlerThread("ProcessingThread", 10);
        f23053o = handlerThread;
        f23054p = null;
        HandlerThread handlerThread2 = new HandlerThread("PauseEventThread", 10);
        f23055q = handlerThread2;
        handlerThread.start();
        f23052n = new Handler(handlerThread.getLooper()) { // from class: com.tendcloud.tenddata.zz.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                by.a();
                bx.a();
                Object obj = message.obj;
                if (obj != null && (obj instanceof a)) {
                    try {
                        v.a().post((a) obj);
                    } catch (Throwable unused) {
                    }
                }
            }
        };
        handlerThread2.start();
        f23054p = new Handler(handlerThread2.getLooper()) { // from class: com.tendcloud.tenddata.zz.12
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                try {
                    com.tendcloud.tenddata.a aVar = (com.tendcloud.tenddata.a) message.obj;
                    if (ab.f22575o == 1) {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 11);
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        aVar2.paraMap.put("sessionEnd", 1);
                        aVar2.paraMap.put("service", aVar);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        ab.X.set(true);
                        ab.f22575o = 2;
                    }
                } catch (Exception e10) {
                    bf.postSDKError(e10);
                }
            }
        };
    }

    public zz() {
        f23045g = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized zz a() {
        zz zzVar;
        synchronized (zz.class) {
            if (f23045g == null) {
                synchronized (zz.class) {
                    if (f23045g == null) {
                        f23045g = new zz();
                    }
                }
            }
            zzVar = f23045g;
        }
        return zzVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Handler b() {
        return f23054p;
    }

    public static Handler c() {
        return f23052n;
    }

    @Override // com.tendcloud.tenddata.ao
    public Context d() {
        try {
            return ab.f22568h;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void e() {
        try {
            g.f22893a = false;
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void h(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onPreviewFinished called --> profileId: " + str + " content: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.50
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "preview");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "finished");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("content", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void i(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onFreeFinished called --> profileId: " + str + " content: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.51
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "free");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "finished");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("content", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void j(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onLevelPass called --> profileId: " + str + " levelId: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.52
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "level");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "pass");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("levelId", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void k(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onAchievementUnlock called --> profileId: " + str + " achievementId: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.53
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "achievement");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "unlock");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("achievementId", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void removeGlobalKV(String str) {
        if (!f23040b) {
            g.eForDeveloper("SDK have not been initialized");
            return;
        }
        if (str != null) {
            g.iForDeveloper("removeGlobalKV# key:" + str);
        }
        ab.f22565e.remove(str);
    }

    @Override // com.tendcloud.tenddata.ao
    public String b(Context context, com.tendcloud.tenddata.a aVar) {
        if (context != null) {
            try {
                if (!f23040b) {
                    g.iForDeveloper("SDK have not been initialized");
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return i.a(context);
    }

    @Override // com.tendcloud.tenddata.ao
    public String c(Context context, com.tendcloud.tenddata.a aVar) {
        return ab.a(context, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public String d(Context context, com.tendcloud.tenddata.a aVar) {
        return ab.b(context, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void e(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onContact called --> profileId: " + str + " content: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.42
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "service");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "contact");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("content", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void f(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onTrialFinished called --> profileId: " + str + " content: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.48
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "trial");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "finished");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("content", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void g(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onGuideFinished called --> profileId: " + str + " content: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.49
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "guide");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "finished");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("content", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(boolean z10) {
        try {
            ab.f22566f = z10;
            g.iForDeveloper(" setReportUncaughtExceptions: " + z10);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void d(final String str, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onReceiveDeepLink: url could not be null or empty");
            } else {
                g.iForDeveloper("onReceiveDeepLink --> link: " + str);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.30
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            cc.a().setDeepLink(URLEncoder.encode(str, "utf-8"));
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", OtaColumn.COLUMN_APP);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "deeplink");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("link", str);
                            aVar2.paraMap.put("data", treeMap);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public String b(Context context) {
        try {
            return i.a(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(final String str, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("createRole called --> roleName: " + str);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.29
                @Override // java.lang.Runnable
                public void run() {
                    a aVar2 = new a();
                    aVar2.paraMap.put("apiType", 9);
                    aVar2.paraMap.put("domain", "account");
                    aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "roleCreate");
                    aVar2.paraMap.put("parameter", str);
                    aVar2.paraMap.put("service", aVar);
                    Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(Activity activity, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (!f23049k) {
                a(activity);
                c.b(activity, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, com.tendcloud.tenddata.a aVar) {
        a(context, (String) null, (String) null, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public String e(Context context, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            }
            return co.a().c();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, String str2, com.tendcloud.tenddata.a aVar) {
        a(context, str, str2, (String) null, aVar);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, String str2, String str3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (context == null) {
                g.iForDeveloper("Init failed Context is null");
            } else if (!u.b(context, "android.permission.INTERNET")) {
                g.eForDeveloper("[SDKInit] Permission \"android.permission.INTERNET\" is needed.");
            } else if (aVar == null) {
                g.eForDeveloper("Failed to initialize!");
            } else if (!f23040b) {
                ab.f22568h = context.getApplicationContext();
                f23046h = str;
                f23048j = str2;
                f23039a = str3;
                Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                String a10 = u.a(bundle, ab.f22555aa);
                String a11 = u.a(bundle, "TD_CHANNEL_ID");
                if (u.b(a10)) {
                    a10 = f23046h;
                }
                f23046h = a10;
                if (u.b(a11)) {
                    a11 = f23048j;
                }
                f23048j = a11;
                ab.c(f23039a, aVar);
                String a12 = u.a(context, "ChannelConfig.json");
                if (u.b(a12)) {
                    a12 = f23048j;
                }
                f23048j = a12;
                f23048j = !u.b(a12) ? f23048j : "Default";
                if (u.b(f23046h)) {
                    g.eForDeveloper("[SDKInit] TD AppId is null");
                    return;
                }
                String trim = f23046h.trim();
                f23046h = trim;
                f23048j = "play.google.com";
                ab.a(trim, "play.google.com", aVar);
                ba.a();
                ay.a().a(f23046h, f23048j, aVar);
                a(context);
                az.a();
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.23
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            bd.a();
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 1);
                            String str4 = "";
                            aVar2.paraMap.put("appId", zz.f23046h != null ? zz.f23046h : str4);
                            HashMap<String, Object> hashMap = aVar2.paraMap;
                            if (zz.f23048j != null) {
                                str4 = zz.f23048j;
                            }
                            hashMap.put("channelId", str4);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "init");
                            Message.obtain(zz.c(), 101, aVar2).sendToTarget();
                            if (u.a(ab.f22568h)) {
                                c.a(aVar);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                f23040b = true;
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(final String str, final int i10, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onCredit called --> profileId: " + str + " amount: " + i10 + " content: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.36
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "business");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "credit");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("amount", Integer.valueOf(i10));
                        treeMap.put("content", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void d(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onPunch called --> profileId: " + str + " punchId: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.39
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER);
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "punch");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("punchId", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(Context context, String str, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                if (u.b(str)) {
                    str = activity.getLocalClassName();
                }
                if ((activity.getChangingConfigurations() & 128) == 128) {
                    f23042d = true;
                    return;
                }
            }
            a(context, str, 5, aVar);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onShare called --> profileId: " + str + " ,content: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.38
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER);
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "share");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("content", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final af.ProfileType profileType, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onLogin: profileId could not be null or empty");
            } else {
                g.iForDeveloper("onLogin called --> profileId is " + str + " ，profile is " + profileType + " , name is " + str2);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.4
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 9);
                            aVar2.paraMap.put("domain", "account");
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "login");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("accountId", str);
                            af.ProfileType profileType2 = profileType;
                            if (profileType2 != null) {
                                aVar2.paraMap.put("type", profileType2.name());
                            }
                            String str3 = str2;
                            if (str3 != null) {
                                aVar2.paraMap.put(ContactConstant.CallsRecordKeys.NAME, str3);
                            }
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void c(final String str, final String str2, final long j10, final int i10, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onBrowse called --> profileId: " + str + " content: " + str2 + " begin: " + j10 + " duration: " + i10);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.46
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "browse");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "detail");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("content", str2);
                        treeMap.put("begin", Long.valueOf(j10));
                        treeMap.put("duration", Integer.valueOf(i10));
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onRegister: profileId could not be null or empty");
            } else {
                g.iForDeveloper("onRegister called --> profileId is " + str);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.7
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 9);
                            aVar2.paraMap.put("domain", "account");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "register");
                            aVar2.paraMap.put("accountId", str);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final String str2, final int i10, final String str3, final String str4, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                g.iForDeveloper("onPay called --> profileId: " + str + " ,orderid: " + str2 + " ,amount: " + i10 + " ,currencyType: " + str3 + " ,payType: " + str4);
                if (str3 != null && str3.trim().length() == 3) {
                    u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.15
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "recharge");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i10));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                g.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            g.eForDeveloper("onPay: profileId could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Activity activity, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (!f23049k || !ab.I) {
                a(activity);
                c.a(activity, aVar);
                ab.I = true;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final int i10, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && !str.isEmpty()) {
                g.iForDeveloper("onCancelOrder called --> orderId: " + str + " ,amount: " + i10 + " ,currencyType: " + str2);
                if (str2 != null && str2.trim().length() == 3) {
                    u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.22
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                                aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "cancelOrder");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("orderId", str);
                                treeMap.put("amount", Integer.valueOf(i10));
                                treeMap.put("currencyType", str2);
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                g.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            g.eForDeveloper("onCancelOrder: orderId could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Activity activity, String str, String str2, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            a(activity);
            a(activity, aVar);
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, String str, com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (f23042d) {
                f23042d = false;
            } else {
                if (u.b(str) && (context instanceof Activity)) {
                    str = ((Activity) context).getLocalClassName();
                }
                a(context, str, 4, aVar);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onFavorite called --> category: " + str + " content: " + str2);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.37
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER);
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "favorites");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("category", str);
                        treeMap.put("content", str2);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final String str2, final String str3, final int i10, final String str4, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onBooking called --> profileId: " + str + " bookingId: " + str2 + " category: " + str3 + " amount: " + i10 + " content: " + str4);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.41
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER);
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "booking");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("bookingId", str2);
                        treeMap.put("category", str3);
                        treeMap.put("amount", Integer.valueOf(i10));
                        treeMap.put("content", str4);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private void a(Context context, final String str, final int i10, final com.tendcloud.tenddata.a aVar) {
        u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.34
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (zz.f23040b) {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", Integer.valueOf(i10));
                        aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                        HashMap<String, Object> hashMap = aVar2.paraMap;
                        String str2 = str;
                        hashMap.put("pageName", str2 == null ? "" : u.a(str2));
                        aVar2.paraMap.put("service", aVar);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    }
                } catch (Throwable unused) {
                }
            }
        });
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final String str, final String str2, final Map<String, Object> map, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onEvent()# event id is empty.");
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onEvent being called! eventId: ");
                sb2.append(str);
                int index = aVar.index();
                String str3 = LpaConstants.VALUE_NULL;
                if (index != 3) {
                    sb2.append(", eventLabel: ");
                    sb2.append(str2 == null ? str3 : str2);
                }
                sb2.append(", eventMap: ");
                if (map != null) {
                    str3 = map.toString();
                }
                sb2.append(str3);
                g.iForDeveloper(sb2.toString());
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.45
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("apiType", 2);
                            aVar2.paraMap.put("eventId", u.a(str));
                            HashMap<String, Object> hashMap = aVar2.paraMap;
                            String str4 = str2;
                            hashMap.put("eventLabel", str4 == null ? null : u.a(str4));
                            aVar2.paraMap.put("map", map);
                            aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void b(final String str, final String str2, final long j10, final int i10, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onRead called --> profileId: " + str + " book: " + str2 + " begin: " + j10 + " duration: " + i10);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.44
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "article");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "read");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("book", str2);
                        treeMap.put("begin", Long.valueOf(j10));
                        treeMap.put("duration", Integer.valueOf(i10));
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final String str, final String str2, final Map<String, Object> map, final double d10, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onEvent()# event id is empty.");
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onEvent being called! eventId: ");
                sb2.append(str);
                int index = aVar.index();
                String str3 = LpaConstants.VALUE_NULL;
                if (index != 3) {
                    sb2.append(", eventLabel: ");
                    sb2.append(str2 == null ? str3 : str2);
                }
                sb2.append(", eventMap: ");
                if (map != null) {
                    str3 = map.toString();
                }
                sb2.append(str3);
                sb2.append(", value: ");
                sb2.append(d10);
                g.iForDeveloper(sb2.toString());
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.54
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("apiType", 2);
                            aVar2.paraMap.put("eventId", u.a(str));
                            HashMap<String, Object> hashMap = aVar2.paraMap;
                            String str4 = str2;
                            hashMap.put("eventLabel", str4 == null ? null : u.a(str4));
                            aVar2.paraMap.put("map", map);
                            aVar2.paraMap.put(HealthDataProviderContracts.NAME_VALUE, Double.valueOf(d10));
                            aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final String str, final Map<String, Object> map, final double d10, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onEvent()# event id is empty.");
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onEvent being called! eventId: ");
                sb2.append(str);
                sb2.append(", eventMap: ");
                sb2.append(map == null ? LpaConstants.VALUE_NULL : map.toString());
                sb2.append(", value: ");
                sb2.append(d10);
                g.iForDeveloper(sb2.toString());
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.55
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("apiType", 2);
                            aVar2.paraMap.put("eventId", u.a(str));
                            aVar2.paraMap.put("map", map);
                            aVar2.paraMap.put(HealthDataProviderContracts.NAME_VALUE, Double.valueOf(d10));
                            aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(Context context, final Throwable th2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (th2 != null) {
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.56
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 3);
                            aVar2.paraMap.put("occurTime", String.valueOf(System.currentTimeMillis()));
                            aVar2.paraMap.put("throwable", th2);
                            aVar2.paraMap.put("service", aVar);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(String str, Object obj) {
        if (!f23040b) {
            g.eForDeveloper("SDK have not been initialized");
            return;
        }
        if (!(str == null || obj == null)) {
            g.iForDeveloper("setGlobalKV# key:" + str + " value:" + obj.toString());
        }
        ab.f22565e.put(str, obj);
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onLogin: profileId could not be null or empty");
            } else {
                g.iForDeveloper("onLogin called --> profileId is " + str);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.57
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 9);
                            aVar2.paraMap.put("domain", "account");
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "login");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("accountId", str);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final af.ProfileType profileType, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onRegister: profileId could not be null or empty");
            } else {
                g.iForDeveloper("onRegister called --> profileId is " + str + " ，type is " + profileType + " , name is " + str2);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 9);
                            aVar2.paraMap.put("domain", "account");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "register");
                            aVar2.paraMap.put("accountId", str);
                            af.ProfileType profileType2 = profileType;
                            if (profileType2 != null) {
                                aVar2.paraMap.put("type", profileType2.name());
                            }
                            String str3 = str2;
                            if (str3 != null) {
                                aVar2.paraMap.put(ContactConstant.CallsRecordKeys.NAME, str3);
                            }
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final TalkingDataProfile talkingDataProfile, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onRegister: profileId could not be null or empty");
            } else {
                if (talkingDataProfile != null) {
                    g.iForDeveloper("onRegister called --> profileId is " + str + " ，profile is " + u.a(talkingDataProfile).toString() + " , invitationCode is " + str2);
                } else {
                    g.iForDeveloper("onRegister called --> profileId is " + str + " , invitationCode is " + str2);
                }
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.3
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 9);
                            aVar2.paraMap.put("domain", "account");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "register");
                            aVar2.paraMap.put("accountId", str);
                            aVar2.paraMap.put("invitationCode", str2);
                            aVar2.paraMap.put("data", u.a(talkingDataProfile));
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final TalkingDataProfile talkingDataProfile, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onLogin: profileId could not be null or empty");
            } else {
                if (talkingDataProfile != null) {
                    g.iForDeveloper("onLogin called --> profileId is " + str + " ，profile is " + u.a(talkingDataProfile).toString());
                } else {
                    g.iForDeveloper("onLogin called --> profileId is " + str);
                }
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.5
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 9);
                            aVar2.paraMap.put("domain", "account");
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "login");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("accountId", str);
                            aVar2.paraMap.put("data", u.a(talkingDataProfile));
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataProfile talkingDataProfile, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onProfileUpdate called --> profile is " + u.a(talkingDataProfile).toString());
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 9);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "update");
                        aVar2.paraMap.put("data", u.a(talkingDataProfile));
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (TextUtils.isEmpty(str)) {
                g.eForDeveloper("onRegister: profileId could not be null or empty");
            } else {
                g.iForDeveloper("onRegister called --> profileId is " + str + " invitationCode: " + str2);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 9);
                            aVar2.paraMap.put("domain", "account");
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "register");
                            aVar2.paraMap.put("accountId", str);
                            aVar2.paraMap.put("invitationCode", str2);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onCreateCard called --> profileId: " + str + " method: " + str2 + "  content: " + str3);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.9
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "account");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "card");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put(Constant.KEY_METHOD, str2);
                        treeMap.put("content", str3);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final int i10, final int i11, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onAddItemToShoppingCart called --> itemId: " + str + " ,category: " + str2 + " ,name: " + str3 + " ,unitPrice: " + i10 + " ,amount: " + i11);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.10
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 8);
                        aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "addItem");
                        aVar2.paraMap.put("service", aVar);
                        TreeMap treeMap = new TreeMap();
                        if (aVar.name().equals("APP")) {
                            if (!TextUtils.isEmpty(str)) {
                                treeMap.put("id", str);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                treeMap.put("category", str2);
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                treeMap.put(ContactConstant.CallsRecordKeys.NAME, str3);
                            }
                            treeMap.put("unitPrice", Integer.valueOf(i10));
                            treeMap.put(ContactConstant.CallsRecordKeys.COUNT, Integer.valueOf(i11));
                        } else {
                            treeMap.put("id", str);
                            treeMap.put("category", str2);
                            treeMap.put(ContactConstant.CallsRecordKeys.NAME, str3);
                            treeMap.put("unitPrice", Integer.valueOf(i10));
                            treeMap.put(ContactConstant.CallsRecordKeys.COUNT, Integer.valueOf(i11));
                        }
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final int i10, final String str2, final String str3, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && !str.isEmpty()) {
                g.iForDeveloper("onOrderPaySucc called --> orderid: " + str + " ,amount: " + i10 + " ,currencyType: " + str2 + " ,payType: " + str3);
                if (str2 != null && str2.trim().length() == 3) {
                    u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.11
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                                aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "pay");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("orderId", str);
                                treeMap.put("amount", Integer.valueOf(i10));
                                treeMap.put("currencyType", str2);
                                treeMap.put("payType", str3);
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                g.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            g.eForDeveloper("onOrderPaySucc: orderId could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataOrder talkingDataOrder, final String str, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (talkingDataOrder == null) {
                g.eForDeveloper("onPay: order could not be null or empty");
            } else {
                g.iForDeveloper("onOrderPaySucc called --> order: " + talkingDataOrder.toString() + " ,paymentType: " + str + " ,profileId: " + str2);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.13
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "pay");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("accountId", str2);
                            treeMap.put("orderId", talkingDataOrder.getString("keyOrderId"));
                            treeMap.put("amount", Integer.valueOf(talkingDataOrder.optInt("keyTotalPrice")));
                            String optString = talkingDataOrder.optString("keyCurrencyType");
                            if (TextUtils.isEmpty(optString)) {
                                optString = Constant.KEY_CURRENCYTYPE_CNY;
                            }
                            treeMap.put("currencyType", optString);
                            if (!TextUtils.isEmpty(str)) {
                                treeMap.put("payType", str);
                            }
                            aVar2.paraMap.put("data", treeMap);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final int i10, final String str3, final String str4, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                g.iForDeveloper("onOrderPaySucc called --> profileId: " + str + " ,orderid: " + str2 + " ,amount: " + i10 + " ,currencyType: " + str3 + " ,payType: " + str4);
                if (str3 != null && str3.trim().length() == 3) {
                    u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.14
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                                aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "recharge");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i10));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                g.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            g.eForDeveloper("onOrderPaySucc: profileId could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final int i10, final String str3, final String str4, final String str5, final int i11, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str2 != null && str2.trim().length() > 0) {
                g.iForDeveloper("onPay called --> profileId: " + str + " ,orderid: " + str2 + " ,amount: " + i10 + " ,currencyType: " + str3 + " ,payType: " + str4 + " ,itemId: " + str5 + " ,itemCount: " + i11);
                if (str3 != null && str3.trim().length() == 3) {
                    u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.16
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                                aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "currencyPurchase");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i10));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                treeMap.put("itemId", str5);
                                treeMap.put("itemCount", Integer.valueOf(i11));
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                g.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            g.eForDeveloper("onPay: orderId could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final int i10, final String str3, final String str4, final cu cuVar, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                if (cuVar == null) {
                    g.eForDeveloper("onPay: order could not be null");
                    return;
                }
                g.iForDeveloper("onPay called --> profileId: " + str + " ,orderid: " + str2 + " ,amount: " + i10 + " ,currencyType: " + str3 + " ,payType: " + str4 + " ,order: " + cuVar.toString());
                if (str3 != null && str3.trim().length() == 3) {
                    u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.17
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONArray jSONArray;
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                                aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "recharge");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", str2);
                                treeMap.put("amount", Integer.valueOf(i10));
                                treeMap.put("currencyType", str3);
                                treeMap.put("payType", str4);
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("orderId", cuVar.getString("keyOrderId"));
                                jSONObject.put("amount", cuVar.getInt("keyTotalPrice"));
                                jSONObject.put("currencyType", cuVar.getString("keyCurrencyType"));
                                if (cuVar.has("keyOrderDetail") && (jSONArray = cuVar.getJSONArray("keyOrderDetail")) != null && jSONArray.length() > 0) {
                                    jSONObject.put("items", jSONArray);
                                }
                                treeMap.put("order", jSONObject);
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                g.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            g.eForDeveloper("onPay: profileId could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final cu cuVar, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                if (cuVar != null && !cuVar.optString("keyOrderId").isEmpty()) {
                    g.iForDeveloper("onPay called --> profileId: " + str + " ,payType: " + str2 + " ,order: " + cuVar.toString());
                    u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.18
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONArray jSONArray;
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                                aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "pay");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                if (aVar.name().equals("APP")) {
                                    treeMap.put("orderId", cuVar.getString("keyOrderId"));
                                    if (!TextUtils.isEmpty(str2)) {
                                        treeMap.put("payType", str2);
                                    }
                                    treeMap.put("amount", Integer.valueOf(cuVar.optInt("keyTotalPrice")));
                                    String optString = cuVar.optString("keyCurrencyType");
                                    if (TextUtils.isEmpty(optString)) {
                                        optString = Constant.KEY_CURRENCYTYPE_CNY;
                                    }
                                    treeMap.put("currencyType", optString);
                                } else {
                                    treeMap.put("payType", str2);
                                    treeMap.put("orderId", cuVar.getString("keyOrderId"));
                                    treeMap.put("amount", Integer.valueOf(cuVar.optInt("keyTotalPrice")));
                                    treeMap.put("currencyType", cuVar.optString("keyCurrencyType"));
                                }
                                if (cuVar.has("keyOrderDetail") && (jSONArray = cuVar.getJSONArray("keyOrderDetail")) != null && jSONArray.length() > 0) {
                                    treeMap.put("items", jSONArray);
                                }
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                g.eForDeveloper("onPay: order or orderID could not be null or empty");
                return;
            }
            g.eForDeveloper("onPay: profileId could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final cu cuVar, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && str.trim().length() > 0) {
                if (cuVar != null && !cuVar.optString("keyOrderId").isEmpty()) {
                    g.iForDeveloper("onPlaceOrder called --> profileId: " + str + " ,order: " + cuVar.toString());
                    u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.19
                        @Override // java.lang.Runnable
                        public void run() {
                            JSONArray jSONArray;
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                                aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "placeOrder");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("accountId", str);
                                treeMap.put("orderId", cuVar.getString("keyOrderId"));
                                treeMap.put("amount", Integer.valueOf(cuVar.optInt("keyTotalPrice")));
                                if (aVar.name().equals("TRACKING")) {
                                    treeMap.put("currencyType", cuVar.optString("keyCurrencyType"));
                                } else if (aVar.name().equals("APP")) {
                                    String optString = cuVar.optString("keyCurrencyType");
                                    if (TextUtils.isEmpty(optString)) {
                                        optString = Constant.KEY_CURRENCYTYPE_CNY;
                                    }
                                    treeMap.put("currencyType", optString);
                                }
                                if (cuVar.has("keyOrderDetail") && (jSONArray = cuVar.getJSONArray("keyOrderDetail")) != null && jSONArray.length() > 0) {
                                    treeMap.put("items", jSONArray);
                                }
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                g.eForDeveloper("onPlaceOrder: order or orderID could not be null or empty");
                return;
            }
            g.eForDeveloper("onPlaceOrder: profileId could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final int i10, final String str2, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (str != null && !str.isEmpty()) {
                g.iForDeveloper("onPlaceOrder called --> orderId: " + str + " ,amount: " + i10 + " ,currencyType: " + str2);
                if (str2 != null && str2.trim().length() == 3) {
                    u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.20
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                a aVar2 = new a();
                                aVar2.paraMap.put("apiType", 8);
                                aVar2.paraMap.put("service", aVar);
                                aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                                aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "placeOrder");
                                TreeMap treeMap = new TreeMap();
                                treeMap.put("orderId", str);
                                treeMap.put("amount", Integer.valueOf(i10));
                                treeMap.put("currencyType", str2);
                                aVar2.paraMap.put("data", treeMap);
                                Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                g.eForDeveloper("currencyType length must be 3 likes CNY so so");
                return;
            }
            g.eForDeveloper("onPlaceOrder: orderId could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataOrder talkingDataOrder, final String str, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (talkingDataOrder != null && !talkingDataOrder.optString("keyOrderId").isEmpty()) {
                g.iForDeveloper("onPlaceOrder called --> order: " + talkingDataOrder.toString() + " ,profileId: " + str);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.21
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONArray jSONArray;
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "placeOrder");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("accountId", str);
                            treeMap.put("orderId", talkingDataOrder.getString("keyOrderId"));
                            treeMap.put("amount", Integer.valueOf(talkingDataOrder.optInt("keyTotalPrice")));
                            String optString = talkingDataOrder.optString("keyCurrencyType");
                            if (TextUtils.isEmpty(optString)) {
                                optString = Constant.KEY_CURRENCYTYPE_CNY;
                            }
                            treeMap.put("currencyType", optString);
                            if (talkingDataOrder.has("keyOrderDetail") && (jSONArray = talkingDataOrder.getJSONArray("keyOrderDetail")) != null && jSONArray.length() > 0) {
                                treeMap.put("items", jSONArray);
                            }
                            aVar2.paraMap.put("data", treeMap);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            g.eForDeveloper("onPlaceOrder: order or orderID could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataOrder talkingDataOrder, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            if (talkingDataOrder != null && !talkingDataOrder.optString("keyOrderId").isEmpty()) {
                g.iForDeveloper("onCancelOrder called --> order: " + talkingDataOrder.toString());
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.24
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "cancelOrder");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("orderId", talkingDataOrder.getString("keyOrderId"));
                            treeMap.put("amount", Integer.valueOf(talkingDataOrder.optInt("keyTotalPrice")));
                            String optString = talkingDataOrder.optString("keyCurrencyType");
                            if (TextUtils.isEmpty(optString)) {
                                optString = Constant.KEY_CURRENCYTYPE_CNY;
                            }
                            treeMap.put("currencyType", optString);
                            aVar2.paraMap.put("data", treeMap);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            g.eForDeveloper("onCancelOrder: order or orderID could not be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final int i10, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onViewItem called --> itemId: " + str + " ,category: " + str2 + " ,name: " + str3 + " ,unitPrice: " + i10);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.25
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 8);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "viewItem");
                        TreeMap treeMap = new TreeMap();
                        if (aVar.name().equals("APP")) {
                            if (!TextUtils.isEmpty(str)) {
                                treeMap.put("id", str);
                            }
                            if (!TextUtils.isEmpty(str2)) {
                                treeMap.put("category", str2);
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                treeMap.put(ContactConstant.CallsRecordKeys.NAME, str3);
                            }
                            treeMap.put("unitPrice", Integer.valueOf(i10));
                        } else {
                            treeMap.put("id", str);
                            treeMap.put("category", str2);
                            treeMap.put(ContactConstant.CallsRecordKeys.NAME, str3);
                            treeMap.put("unitPrice", Integer.valueOf(i10));
                        }
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final cv cvVar, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onViewShoppingCart called --> shoppingCart: " + cvVar);
            if (cvVar != null && cvVar.length() > 0) {
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.26
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "viewItems");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("items", cvVar);
                            aVar2.paraMap.put("data", treeMap);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            g.eForDeveloper("viewShoppingCart# shoppingCart can't be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataShoppingCart talkingDataShoppingCart, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onViewShoppingCart called --> shoppingCart: " + talkingDataShoppingCart);
            if (talkingDataShoppingCart != null && talkingDataShoppingCart.length() > 0) {
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.27
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 8);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", Constants.Setting.KEY_SUPPORT_MFI);
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "viewItems");
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("items", talkingDataShoppingCart);
                            aVar2.paraMap.put("data", treeMap);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
                return;
            }
            g.eForDeveloper("viewShoppingCart# shoppingCart can't be null or empty");
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private void a(final Context context) {
        if (u.a(14)) {
            Application application = null;
            try {
                Context context2 = ab.f22568h;
                if (context2 instanceof Activity) {
                    application = ((Activity) context2).getApplication();
                } else if (context2 instanceof Application) {
                    application = (Application) context2;
                }
                if (application != null && !f23049k) {
                    b bVar = new b();
                    f23043e = bVar;
                    application.registerActivityLifecycleCallbacks(bVar);
                    f23049k = true;
                }
            } catch (Throwable unused) {
            }
        } else {
            try {
                u.a(Class.forName("android.app.ActivityManagerNative"), new q() { // from class: com.tendcloud.tenddata.zz.28
                    @Override // com.tendcloud.tenddata.q
                    public void afterMethodInvoked(Object obj, Method method, Object[] objArr, Object obj2) {
                    }

                    @Override // com.tendcloud.tenddata.q
                    public void beforeMethodInvoke(Object obj, Method method, Object[] objArr) {
                        String name = method.getName();
                        if (!(context instanceof Activity)) {
                            return;
                        }
                        if (name.equalsIgnoreCase("activityPaused")) {
                            c.b((Activity) context, com.tendcloud.tenddata.a.UNIVERSAL);
                        } else if (name.equalsIgnoreCase("activityIdle")) {
                            c.a((Activity) context, com.tendcloud.tenddata.a.UNIVERSAL);
                        }
                    }
                }, "gDefault", "android.app.IActivityManager");
                f23049k = true;
            } catch (Throwable th2) {
                g.eForDeveloper("registerActivityLifecycleListener " + th2.getMessage());
            }
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final cw cwVar, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (cwVar == null) {
                g.eForDeveloper("TDSearch cannot be null ");
            } else {
                g.iForDeveloper("onSearch called --> search: " + cwVar);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.31
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 17);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", "ad");
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "search");
                            aVar2.paraMap.put("data", u.a(cwVar));
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final TalkingDataSearch talkingDataSearch, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (talkingDataSearch == null) {
                g.eForDeveloper("TDSearch cannot be null ");
            } else {
                g.iForDeveloper("onSearch called --> search: " + talkingDataSearch);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.32
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 17);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", "ad");
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "search");
                            aVar2.paraMap.put("data", u.a(talkingDataSearch));
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final cx cxVar, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (cxVar == null) {
                g.eForDeveloper("TDTransaction cannot be null ");
            } else {
                g.iForDeveloper("TDTransaction called --> profileId: " + str + " onTransaction: " + cxVar);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.33
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 17);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", "business");
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "transaction");
                            Map<String, Object> a10 = u.a(cxVar);
                            a10.put("accountId", str);
                            aVar2.paraMap.put("data", a10);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final TalkingDataTransaction talkingDataTransaction, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
            } else if (talkingDataTransaction == null) {
                g.eForDeveloper("TDTransaction cannot be null ");
            } else {
                g.iForDeveloper("TDTransaction called --> profileId: " + str + " onTransaction: " + talkingDataTransaction);
                u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.35
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            a aVar2 = new a();
                            aVar2.paraMap.put("apiType", 17);
                            aVar2.paraMap.put("service", aVar);
                            aVar2.paraMap.put("domain", "business");
                            aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "transaction");
                            Map<String, Object> a10 = u.a(talkingDataTransaction);
                            a10.put("accountId", str);
                            aVar2.paraMap.put("data", a10);
                            Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final int i10, final String str4, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onReservation called --> profileId: " + str + " reservationId: " + str2 + " category: " + str3 + " amount: " + i10 + " term: " + str4);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.40
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER);
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "reservation");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("reservationId", str2);
                        treeMap.put("category", str3);
                        treeMap.put("amount", Integer.valueOf(i10));
                        treeMap.put("term", str4);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final long j10, final int i10, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onLearn called --> profileId: " + str + " course: " + str2 + " begin: " + j10 + " duration: " + i10);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.43
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "course");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "learn");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("course", str2);
                        treeMap.put("begin", Long.valueOf(j10));
                        treeMap.put("duration", Integer.valueOf(i10));
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    @Override // com.tendcloud.tenddata.ao
    public void a(final String str, final String str2, final String str3, final String str4, final com.tendcloud.tenddata.a aVar) {
        try {
            if (!f23040b) {
                g.eForDeveloper("SDK have not been initialized");
                return;
            }
            g.iForDeveloper("onChargeBack called --> profileId: " + str + " orderId: " + str2 + " reason: " + str3 + " type: " + str4);
            u.execute(new Runnable() { // from class: com.tendcloud.tenddata.zz.47
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a aVar2 = new a();
                        aVar2.paraMap.put("apiType", 17);
                        aVar2.paraMap.put("service", aVar);
                        aVar2.paraMap.put("domain", "order");
                        aVar2.paraMap.put(TelephonyUtil.KEY_SIM_ACTION, "chargeback");
                        TreeMap treeMap = new TreeMap();
                        treeMap.put("accountId", str);
                        treeMap.put("orderId", str2);
                        treeMap.put("reason", str3);
                        treeMap.put("type", str4);
                        aVar2.paraMap.put("data", treeMap);
                        Message.obtain(zz.c(), 102, aVar2).sendToTarget();
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }
}
