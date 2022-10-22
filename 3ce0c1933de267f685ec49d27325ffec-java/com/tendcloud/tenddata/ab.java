package com.tendcloud.tenddata;

import android.content.Context;
import android.os.Handler;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import java.io.File;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: td */
/* loaded from: classes2.dex */
public class ab {
    public static final String A = "TD_init_custom";
    public static final String B = "TD_sdk_last_send_time_wifi";
    public static final String C = "TD_sdk_last_send_time_mobile_data";
    public static final String D = "isDeveloper";
    public static final int J = 104857600;
    static final String L = "All";
    public static final String N = "v1.0.0";
    public static final String S = "Android+TD+V5.0.0 gp";
    static long T = 0;
    public static final int W = 1800000;
    public static final long Y = 30000;
    public static final int Z = 100;

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f22554a = false;

    /* renamed from: aa  reason: collision with root package name */
    public static final String f22555aa = "TD_APP_ID";

    /* renamed from: ab  reason: collision with root package name */
    public static final String f22556ab = "TD_CHANNEL_ID";

    /* renamed from: ad  reason: collision with root package name */
    private static final String f22558ad = "+V";

    /* renamed from: ae  reason: collision with root package name */
    private static final int f22559ae = 120;

    /* renamed from: af  reason: collision with root package name */
    private static final int f22560af = 30;

    /* renamed from: ag  reason: collision with root package name */
    private static final int f22561ag = 1000;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f22562b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f22563c = true;

    /* renamed from: j  reason: collision with root package name */
    public static final int f22570j = 1;

    /* renamed from: k  reason: collision with root package name */
    public static final String f22571k = "Android+";

    /* renamed from: l  reason: collision with root package name */
    public static FileChannel f22572l = null;

    /* renamed from: t  reason: collision with root package name */
    public static String f22580t = null;

    /* renamed from: u  reason: collision with root package name */
    public static final String f22581u = "TD";

    /* renamed from: v  reason: collision with root package name */
    public static final String f22582v = "TDLog";

    /* renamed from: w  reason: collision with root package name */
    public static final String f22583w = "1041";

    /* renamed from: x  reason: collision with root package name */
    public static final String f22584x = "TD_app_pefercen_profile";

    /* renamed from: y  reason: collision with root package name */
    public static final String f22585y = "TD_appId_";

    /* renamed from: z  reason: collision with root package name */
    public static final String f22586z = "TD_channelId";

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicBoolean f22564d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public static final Map<String, Object> f22565e = new TreeMap();

    /* renamed from: f  reason: collision with root package name */
    public static boolean f22566f = false;

    /* renamed from: g  reason: collision with root package name */
    public static long f22567g = 0;

    /* renamed from: h  reason: collision with root package name */
    public static Context f22568h = null;

    /* renamed from: i  reason: collision with root package name */
    public static Handler f22569i = null;

    /* renamed from: m  reason: collision with root package name */
    public static long f22573m = 0;

    /* renamed from: n  reason: collision with root package name */
    public static boolean f22574n = false;

    /* renamed from: o  reason: collision with root package name */
    public static int f22575o = -1;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f22576p = true;

    /* renamed from: q  reason: collision with root package name */
    public static boolean f22577q = true;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f22578r = false;

    /* renamed from: s  reason: collision with root package name */
    public static long f22579s = 5000;

    /* renamed from: ac  reason: collision with root package name */
    private static HashMap<String, Object> f22557ac = new HashMap<>();
    public static String E = "Default";
    public static String F = "";
    public static boolean G = false;
    public static String H = null;
    public static boolean I = false;
    static final String K = "WiFi";
    static String M = K;
    public static boolean O = false;
    public static boolean P = false;
    public static boolean Q = false;
    public static boolean R = false;
    public static int U = 2;
    public static AtomicInteger V = new AtomicInteger(0);
    public static final AtomicBoolean X = new AtomicBoolean(false);

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public class a {
        public static final int DST_FILE = 2;
        public static final int DST_SQLITE = 1;

        public a() {
        }
    }

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class b {
        public static final int API_MYNA_INIT = 90;
        public static final int API_MYNA_START = 91;
        public static final int API_MYNA_STOP = 92;
        public static final int API_ON_ERROR = 3;
        public static final int API_ON_EVENT = 2;
        public static final int API_ON_INIT = 1;
        public static final int API_ON_PAGE_END = 5;
        public static final int API_ON_PAGE_START = 4;
        public static final int API_TYPE_ACCOUNT = 9;
        public static final int API_TYPE_BRAND_GROWTH = 16;
        public static final int API_TYPE_CUST_LOCATION = 14;
        public static final int API_TYPE_GAME = 6;
        public static final int API_TYPE_GAME_SESSION_END = 15;
        public static final int API_TYPE_GAME_SESSION_START = 12;
        public static final int API_TYPE_IAP = 8;
        public static final int API_TYPE_INDUSTRY = 17;
        public static final int API_TYPE_SESSION_END = 11;
        public static final int API_TYPE_SESSION_PAUSE = 13;
        public static final int API_TYPE_SESSION_START = 10;
        public static final int API_TYPE_TRACKING = 7;
    }

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public class c {
        public static final int SDT_JSON = 2;
        public static final int SDT_MP = 1;
        public static final int SDT_PB = 3;
        public static final int SDT_UNKNOWN = -1;

        public c() {
        }
    }

    public static String a(Context context, com.tendcloud.tenddata.a aVar) {
        if (context == null || aVar == null) {
            g.dForInternal("Context or Service is null");
            return "";
        }
        String str = (String) f22557ac.get(aVar.name());
        if (!u.b(str)) {
            return str;
        }
        return o.b(context, f22584x, f22585y + aVar.name(), "");
    }

    public static String b(Context context, com.tendcloud.tenddata.a aVar) {
        if (u.b(E) || E.equals("Default")) {
            E = o.b(context, f22584x, f22586z + aVar.name(), "Default");
        }
        return E;
    }

    public static String c(Context context, com.tendcloud.tenddata.a aVar) {
        try {
            if (u.b(F)) {
                F = o.b(context, f22584x, A + aVar.name(), "");
            }
        } catch (Throwable unused) {
        }
        return F;
    }

    private static boolean d(com.tendcloud.tenddata.a aVar) {
        if (f22568h == null || !aVar.name().equals("APP")) {
            return false;
        }
        File filesDir = f22568h.getFilesDir();
        try {
            File file = new File(filesDir, "td_database3test_1230");
            File file2 = new File(filesDir, "td_database1test_1230");
            File file3 = new File(filesDir, aa.f22550v);
            File file4 = new File(file3, "td_database3test_1230");
            File file5 = new File(file3, "td_database1test_1230");
            if (!file.exists() && !file2.exists() && !file4.exists()) {
                if (!file5.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean e(com.tendcloud.tenddata.a aVar) {
        if (f22568h == null || !aVar.name().equals("GAME")) {
            return false;
        }
        File filesDir = f22568h.getFilesDir();
        try {
            File file = new File(filesDir, "td_database0test_1230");
            File file2 = new File(filesDir, "td_database1test_1230");
            File file3 = new File(filesDir, aa.f22550v);
            File file4 = new File(file3, "td_database0test_1230");
            File file5 = new File(file3, "td_database1test_1230");
            if (!file2.exists() && !file.exists() && !file5.exists()) {
                if (!file4.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setConfigurationDisable(int i10) {
        boolean z10 = false;
        try {
            O = (i10 & 1) != 0;
            P = (i10 & 2) != 0;
            Q = (i10 & 4) != 0;
            if ((i10 & 8) != 0) {
                z10 = true;
            }
            R = z10;
        } catch (Throwable unused) {
        }
    }

    public static void setDeveloperMode(boolean z10) {
        try {
            o.a(f22568h, f22584x, D, z10 ? 1L : 0L);
        } catch (Throwable unused) {
        }
    }

    public static void b(String str, com.tendcloud.tenddata.a aVar) {
        Context context = f22568h;
        o.a(context, f22584x, f22586z + aVar.name(), str);
    }

    public static void c(String str, com.tendcloud.tenddata.a aVar) {
        try {
            Context context = f22568h;
            o.a(context, f22584x, A + aVar.name(), str);
        } catch (Throwable unused) {
        }
    }

    public static void a(String str, com.tendcloud.tenddata.a aVar) {
        if (aVar != null) {
            f22557ac.put(aVar.name(), str);
            Context context = f22568h;
            o.a(context, f22584x, f22585y + aVar.name(), str);
        }
    }

    public static boolean b() {
        try {
            return o.b(f22568h, f22584x, D, 0L) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c() {
        try {
            return new ci().a();
        } catch (Throwable unused) {
            return "Native";
        }
    }

    private static boolean b(com.tendcloud.tenddata.a aVar) {
        if (f22568h == null || !aVar.name().equals("SDK")) {
            return false;
        }
        File filesDir = f22568h.getFilesDir();
        try {
            File file = new File(filesDir, "td_database0test_1230");
            File file2 = new File(filesDir, "td_database1test_1230");
            File file3 = new File(filesDir, "td_database3test_1230");
            File file4 = new File(filesDir, aa.f22550v);
            File file5 = new File(file4, "td_database0test_1230");
            File file6 = new File(file4, "td_database1test_1230");
            File file7 = new File(file4, "td_database3test_1230");
            if ((file3.exists() || file7.exists()) && !file2.exists() && !file6.exists() && !file.exists()) {
                return !file5.exists();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean c(com.tendcloud.tenddata.a aVar) {
        if (f22568h == null || !aVar.name().equals("TRACKING")) {
            return false;
        }
        File filesDir = f22568h.getFilesDir();
        try {
            File file = new File(filesDir, "td_database3test_1230");
            File file2 = new File(filesDir, "td_database0test_1230");
            File file3 = new File(filesDir, aa.f22550v);
            File file4 = new File(file3, "td_database3test_1230");
            File file5 = new File(file3, "td_database0test_1230");
            if (!file.exists() && !file2.exists() && !file4.exists()) {
                if (!file5.exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int[] a() {
        return new int[]{BasicBrowserActivity.DEFAULT_DELAYED_MILLIS, 30000};
    }

    public static void a(String str, String str2, com.tendcloud.tenddata.a aVar) {
        if (f22568h != null) {
            f22569i = new Handler(f22568h.getMainLooper());
        }
        f22567g = System.currentTimeMillis();
        if (str != null && !str.trim().isEmpty() && str.contains("-")) {
            str = null;
            try {
                str = str.split("-")[1];
            } catch (Throwable unused) {
            }
        }
        if (str2 != null && !str2.trim().isEmpty()) {
            E = str2;
        }
        a(str, aVar);
        b(E, aVar);
        cf.a().a((Object) str, aVar);
        cf.a().b(E, aVar);
        a(dz.f22888a);
    }

    private static boolean d(Context context, com.tendcloud.tenddata.a aVar) {
        try {
            if (f22568h == null) {
                return true;
            }
            if ((!aVar.name().equals("TRACKING") && !aVar.name().equals("SDK")) || !context.getSharedPreferences("talkingdata_file_prefence", 0).getBoolean("actived", false)) {
                return true;
            }
            h.a(false, aVar);
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void a(int i10) {
        try {
            ci ciVar = new ci();
            switch (i10) {
                case 1:
                    ciVar.setFrameWork("Cocos2d");
                    break;
                case 2:
                    ciVar.setFrameWork("Unity");
                    break;
                case 3:
                    ciVar.setFrameWork("AIR");
                    break;
                case 4:
                    ciVar.setFrameWork("PhoneGap");
                    break;
                case 5:
                    ciVar.setFrameWork("APICloud");
                    break;
                case 6:
                    ciVar.setFrameWork("Hybrid");
                    break;
                case 7:
                    ciVar.setFrameWork("ReactNative");
                    break;
                case 8:
                    ciVar.setFrameWork("Flutter");
                    break;
                default:
                    ciVar.setFrameWork("Native");
                    break;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean a(com.tendcloud.tenddata.a aVar) {
        Context context;
        try {
            context = f22568h;
        } catch (Throwable unused) {
        }
        if (context == null || aVar == null) {
            return false;
        }
        if (a(context)) {
            return h.e(aVar) == 1;
        }
        if (h.e(aVar) == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - h.d(aVar) > f22579s * 4) {
                h.a(false, aVar);
            } else if (currentTimeMillis - h.e() <= f22579s * 4) {
                return d(f22568h, aVar);
            } else {
                if (c(aVar) || e(aVar) || d(aVar) || b(aVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean a(Context context) {
        try {
            return f.a().d(context) == f.a().e(context);
        } catch (Throwable unused) {
            return false;
        }
    }
}
