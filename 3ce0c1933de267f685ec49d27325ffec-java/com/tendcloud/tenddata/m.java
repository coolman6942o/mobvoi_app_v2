package com.tendcloud.tenddata;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.mobvoi.wear.ble.BleProtocol;
import com.mobvoi.wear.companion.setup.settings.SettingConstants;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.tts.LocalTtsPlayer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    static final String f22944a = "www.qqq.com";

    /* renamed from: b  reason: collision with root package name */
    static final int f22945b = 80;

    /* renamed from: c  reason: collision with root package name */
    private static TelephonyManager f22946c = null;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f22947d;

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f22948e = {GrsBaseInfo.CountryCodeSource.UNKNOWN, "GPRS", "EDGE", "UMTS", "CDMA", "EVDO_0", "EVDO_A", "1xRTT", "HSDPA", "HSUPA", "HSPA", "IDEN", "EVDO_B", "LTE", "EHRPD", "HSPAP"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f22949f = {"NONE", "GSM", "CDMA", "SIP"};

    /* renamed from: g  reason: collision with root package name */
    private static a f22950g = null;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f22951h = false;

    /* renamed from: i  reason: collision with root package name */
    private static final long f22952i = 300000;

    /* renamed from: j  reason: collision with root package name */
    private static long f22953j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile boolean f22954k;

    /* renamed from: l  reason: collision with root package name */
    private static volatile boolean f22955l;

    /* renamed from: m  reason: collision with root package name */
    private static JSONArray f22956m;

    /* renamed from: n  reason: collision with root package name */
    private static JSONArray f22957n;

    /* renamed from: o  reason: collision with root package name */
    private static volatile boolean f22958o;

    /* renamed from: p  reason: collision with root package name */
    private static volatile boolean f22959p;

    /* renamed from: q  reason: collision with root package name */
    private static volatile boolean f22960q;

    /* renamed from: r  reason: collision with root package name */
    private static JSONArray f22961r;

    /* renamed from: s  reason: collision with root package name */
    private static JSONArray f22962s;

    /* renamed from: t  reason: collision with root package name */
    private static JSONArray f22963t;

    /* renamed from: u  reason: collision with root package name */
    private static boolean f22964u;

    /* renamed from: v  reason: collision with root package name */
    private static b f22965v;

    /* renamed from: w  reason: collision with root package name */
    private static JSONArray f22966w;

    /* renamed from: x  reason: collision with root package name */
    private static volatile boolean f22967x;

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        private Context context;
        private Object lock;
        private BroadcastReceiver receiver;

        public a(Context context, Object obj, BroadcastReceiver broadcastReceiver) {
            this.context = context;
            this.lock = obj;
            this.receiver = broadcastReceiver;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (this.lock) {
                    this.lock.notifyAll();
                    this.context.unregisterReceiver(this.receiver);
                }
            } catch (Throwable unused) {
            }
        }

        public void unRegisterReceiver() {
            BroadcastReceiver broadcastReceiver = this.receiver;
            if (broadcastReceiver != null) {
                try {
                    this.context.unregisterReceiver(broadcastReceiver);
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class b extends BroadcastReceiver {
        private CountDownLatch latch = new CountDownLatch(1);

        b() {
        }

        void await() {
            try {
                this.latch.await(2000L, TimeUnit.MILLISECONDS);
            } catch (Throwable th2) {
                g.eForInternal(th2);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction()) && this.latch.getCount() > 0) {
                this.latch.countDown();
            }
        }

        void reset() {
            this.latch = new CountDownLatch(1);
        }
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f22947d = hashMap;
        if (ab.f22568h != null) {
            String[] a10 = a();
            hashMap.put("ip", a10[0]);
            hashMap.put("ipv6", a10[1]);
            hashMap.put("cell_ip", a10[2]);
            hashMap.put("cell_ipv6", a10[3]);
            hashMap.put("bssid", q(ab.f22568h));
            hashMap.put("ssid", w(ab.f22568h));
        }
        f22951h = false;
        f22953j = -300000L;
        f22954k = false;
        f22955l = false;
        f22956m = new JSONArray();
        f22957n = new JSONArray();
        f22958o = false;
        f22959p = false;
        f22960q = false;
        f22961r = new JSONArray();
        f22962s = new JSONArray();
        f22963t = new JSONArray();
        f22964u = false;
        f22965v = new b();
        f22966w = new JSONArray();
        f22967x = false;
    }

    public static JSONArray A(Context context) {
        if (f22966w.length() > 0 || f22967x) {
            return f22966w;
        }
        if (!u.b(context, "android.permission.READ_PHONE_STATE")) {
            return f22966w;
        }
        C(context);
        return f22966w;
    }

    public static int B(Context context) {
        try {
            if (!u.a(23)) {
                return A(context).length();
            }
            if (f22946c == null) {
                a(context);
            }
            return f22946c.getPhoneCount();
        } catch (Throwable unused) {
            return 0;
        }
    }

    private static void C(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            ArrayList arrayList = new ArrayList();
            if (u.a(22)) {
                SubscriptionManager subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service");
                try {
                    JSONObject a10 = a(context, subscriptionManager, 0);
                    if (u.a(26)) {
                        try {
                            a10.put("imei", k.a("imei1"));
                            a10.put("imei5", k.b(0));
                        } catch (Throwable unused) {
                        }
                        try {
                            a10.put("meid", k.a(0));
                            a10.put("meid5", k.c(0));
                        } catch (Throwable unused2) {
                        }
                    } else {
                        a10.put("imei", k.a("imei1"));
                        a10.put("imei5", k.b(0));
                    }
                    if (a10.length() > 0) {
                        f22966w.put(a10);
                    }
                } catch (Throwable unused3) {
                }
                JSONObject a11 = a(context, subscriptionManager, 1);
                if (telephonyManager != null) {
                    if (u.a(26)) {
                        try {
                            a11.put("imei", k.a("imei2"));
                            a11.put("imei5", k.b(1));
                        } catch (Throwable unused4) {
                        }
                        try {
                            a11.put("meid", k.a(1));
                            a11.put("meid5", k.c(1));
                        } catch (Throwable unused5) {
                        }
                    } else {
                        a11.put("imei", k.a("imei2"));
                        a11.put("imei5", k.b(1));
                    }
                }
                if (a11.length() > 0) {
                    f22966w.put(a11);
                }
            } else {
                String str = "";
                String deviceId = telephonyManager != null ? telephonyManager.getDeviceId() : str;
                if (c(deviceId.trim()).booleanValue()) {
                    arrayList.add(deviceId.trim());
                    JSONObject a12 = a(telephonyManager, deviceId);
                    if (a12 != null) {
                        f22966w.put(a12);
                    }
                }
                try {
                    TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone1");
                    String deviceId2 = telephonyManager2 != null ? telephonyManager2.getDeviceId() : str;
                    if (deviceId2 != null && c(deviceId2).booleanValue() && !arrayList.contains(deviceId2)) {
                        arrayList.add(deviceId2);
                        JSONObject a13 = a(telephonyManager2, deviceId2);
                        if (a13 != null) {
                            f22966w.put(a13);
                        }
                    }
                } catch (Throwable unused6) {
                }
                try {
                    TelephonyManager telephonyManager3 = (TelephonyManager) context.getSystemService("phone2");
                    if (telephonyManager3 != null) {
                        str = telephonyManager3.getDeviceId();
                    }
                    if (str != null && c(str).booleanValue() && !arrayList.contains(str)) {
                        arrayList.add(str);
                        JSONObject a14 = a(telephonyManager3, str);
                        if (a14 != null) {
                            f22966w.put(a14);
                        }
                    }
                } catch (Throwable unused7) {
                }
                JSONArray G = G(context);
                JSONArray F = F(context);
                if (F != null) {
                    G = F;
                }
                JSONArray E = E(context);
                if (E != null) {
                    G = E;
                }
                JSONArray D = D(context);
                if (D != null) {
                    G = D;
                }
                if (G != null && G.length() > 0) {
                    for (int i10 = 0; i10 < G.length(); i10++) {
                        JSONObject jSONObject = G.getJSONObject(i10);
                        String string = jSONObject.getString("imei");
                        if (!arrayList.contains(string)) {
                            arrayList.add(string);
                            f22966w.put(jSONObject);
                        }
                    }
                }
            }
        } catch (Throwable unused8) {
        }
        f22967x = true;
    }

    private static JSONArray D(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            Class<?> cls = Class.forName("com.android.internal.telephony.Phone");
            Field field = cls.getField("GEMINI_SIM_1");
            field.setAccessible(true);
            Integer num = (Integer) field.get(null);
            Field field2 = cls.getField("GEMINI_SIM_2");
            field2.setAccessible(true);
            Integer num2 = (Integer) field2.get(null);
            Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceIdGemini", Integer.TYPE);
            if (!(telephonyManager == null || declaredMethod == null)) {
                String trim = ((String) declaredMethod.invoke(telephonyManager, num)).trim();
                String trim2 = ((String) declaredMethod.invoke(telephonyManager, num2)).trim();
                if (c(trim).booleanValue()) {
                    jSONArray.put(a(TelephonyManager.class, telephonyManager, num, trim, "Gemini"));
                }
                if (c(trim2).booleanValue()) {
                    jSONArray.put(a(TelephonyManager.class, telephonyManager, num2, trim2, "Gemini"));
                }
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static JSONArray E(Context context) {
        JSONObject a10;
        JSONObject a11;
        try {
            JSONArray jSONArray = new JSONArray();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            Class<?> cls = Class.forName("com.android.internal.telephony.Phone");
            Field field = cls.getField("GEMINI_SIM_1");
            field.setAccessible(true);
            Integer num = (Integer) field.get(null);
            Field field2 = cls.getField("GEMINI_SIM_2");
            field2.setAccessible(true);
            Integer num2 = (Integer) field2.get(null);
            Method method = TelephonyManager.class.getMethod("getDefault", Integer.TYPE);
            TelephonyManager telephonyManager2 = (TelephonyManager) method.invoke(telephonyManager, num);
            TelephonyManager telephonyManager3 = (TelephonyManager) method.invoke(telephonyManager, num2);
            String trim = telephonyManager2.getDeviceId().trim();
            String trim2 = telephonyManager3.getDeviceId().trim();
            if (c(trim).booleanValue() && (a11 = a(telephonyManager2, trim)) != null) {
                jSONArray.put(a11);
            }
            if (c(trim2).booleanValue() && (a10 = a(telephonyManager3, trim2)) != null) {
                jSONArray.put(a10);
            }
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONArray F(Context context) {
        JSONObject a10;
        JSONObject a11;
        try {
            JSONArray jSONArray = new JSONArray();
            Class<?> cls = Class.forName("com.android.internal.telephony.PhoneFactory");
            Method method = cls.getMethod("getServiceName", String.class, Integer.TYPE);
            Object[] objArr = {SharedWearInfoHelper.PhoneInfo.TABLE, 1};
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
            String trim = telephonyManager.getDeviceId().trim();
            TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService((String) method.invoke(cls, objArr));
            String trim2 = telephonyManager2.getDeviceId().trim();
            if (c(trim).booleanValue() && (a11 = a(telephonyManager, trim)) != null) {
                jSONArray.put(a11);
            }
            if (c(trim2).booleanValue() && (a10 = a(telephonyManager2, trim2)) != null) {
                jSONArray.put(a10);
            }
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONArray G(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            Class<?> cls = Class.forName("android.telephony.MSimTelephonyManager");
            Object systemService = context.getSystemService("phone_msim");
            Method method = cls.getMethod("getDeviceId", Integer.TYPE);
            String trim = ((String) method.invoke(systemService, 0)).trim();
            String trim2 = ((String) method.invoke(systemService, 1)).trim();
            if (c(trim).booleanValue()) {
                jSONArray.put(a(cls, systemService, 0, trim, ""));
            }
            if (c(trim2).booleanValue()) {
                jSONArray.put(a(cls, systemService, 1, trim2, ""));
            }
            return jSONArray;
        } catch (Throwable unused) {
            return null;
        }
    }

    static void a(Context context) {
        try {
            f22946c = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String b(int i10) {
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return "2G";
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return "3G";
            case 13:
            case 18:
                return "4G";
        }
    }

    private static void b(String[] strArr) {
        Enumeration<InetAddress> inetAddresses;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces != null) {
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (nextElement.getName().toLowerCase().startsWith("wlan") && (inetAddresses = nextElement.getInetAddresses()) != null) {
                    while (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement2 = inetAddresses.nextElement();
                        if (nextElement2 != null && !nextElement2.isLoopbackAddress()) {
                            String hostAddress = nextElement2.getHostAddress();
                            if (!TextUtils.isEmpty(hostAddress)) {
                                if (nextElement2 instanceof Inet4Address) {
                                    strArr[0] = hostAddress;
                                } else if (nextElement2 instanceof Inet6Address) {
                                    int indexOf = hostAddress.indexOf("%");
                                    if (indexOf > 0) {
                                        hostAddress = hostAddress.substring(0, indexOf);
                                    }
                                    strArr[1] = hostAddress;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean c(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (!u.b(context, "android.permission.ACCESS_NETWORK_STATE") || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
                return false;
            }
            return activeNetworkInfo.isAvailable();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean d(Context context) {
        try {
            if (i(context)) {
                return true;
            }
            return ((WifiManager) context.getSystemService("wifi")).isWifiEnabled();
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return false;
        }
    }

    public static boolean e(Context context) {
        try {
            if (f22946c == null) {
                a(context);
            }
            return f22946c.getSimState() == 5;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean f(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke((ConnectivityManager) context.getSystemService("connectivity"), new Object[0])).booleanValue();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean g(Context context) {
        try {
            return u.a(17) ? Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1 : Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) == 1;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            if (f22946c == null) {
                a(context);
            }
            int simState = f22946c.getSimState();
            return (1 == simState || simState == 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean i(Context context) {
        ConnectivityManager connectivityManager;
        NetworkCapabilities networkCapabilities;
        if (context == null && (context = ab.f22568h) == null) {
            return false;
        }
        try {
            if (!u.b(context, "android.permission.ACCESS_NETWORK_STATE") || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
                return false;
            }
            if (u.a(29)) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                return (activeNetwork == null || (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) == null || !networkCapabilities.hasTransport(1)) ? false : true;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType() && activeNetworkInfo.isConnected();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean j(Context context) {
        if (context == null && (context = ab.f22568h) == null) {
            return false;
        }
        try {
            if (f22946c == null) {
                a(context);
            }
            return f22946c.getDataState() == 2;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String k(Context context) {
        return !b(context) ? LocalTtsPlayer.Mode.MODE_OFFLINE : i(context) ? "WIFI" : a(n(context));
    }

    public static String l(Context context) {
        return !b(context) ? "offline" : i(context) ? "wifi" : "cellular";
    }

    public static String m(Context context) {
        if ((context != null || (context = ab.f22568h) != null) && b(context)) {
            return i(context) ? "WIFI" : b(n(context));
        }
        return GrsBaseInfo.CountryCodeSource.UNKNOWN;
    }

    public static int n(Context context) {
        if (context == null) {
            try {
                context = ab.f22568h;
                if (context == null) {
                    return 0;
                }
            } catch (Throwable unused) {
                return 0;
            }
        }
        if (f22946c == null) {
            a(context);
        }
        return f22946c.getNetworkType();
    }

    public static String o(Context context) {
        try {
            if (f22946c == null) {
                a(context);
            }
            return f22946c.getNetworkOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String p(Context context) {
        try {
            if (f22946c == null) {
                a(context);
            }
            return f22946c.getSimOperator();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String q(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        if (wifiManager == null || !u.b(context, "android.permission.ACCESS_WIFI_STATE") || (connectionInfo = wifiManager.getConnectionInfo()) == null) {
            return null;
        }
        return connectionInfo.getBSSID();
    }

    public static String r(Context context) {
        try {
            if (f22946c == null) {
                a(context);
            }
            return f22946c.getNetworkCountryIso();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String s(Context context) {
        try {
            if (f22946c == null) {
                a(context);
            }
            return f22946c.getNetworkOperatorName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String t(Context context) {
        try {
            if (f22946c == null) {
                a(context);
            }
            return f22946c.getSimOperatorName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void tryGetDoubleSimInfoReCheck(Context context) {
        try {
            if (f22966w.length() <= 0 && !f22967x) {
                C(context);
            }
        } catch (Throwable th2) {
            g.eForInternal(th2);
        }
    }

    public static JSONArray u(Context context) {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", "wifi");
            jSONObject.put("available", d(context));
            jSONObject.put("connected", i(context));
            jSONObject.put("current", y(context));
            jSONObject.put("scannable", z(context));
            jSONObject.put("configured", x(context));
            jSONArray.put(jSONObject);
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", "cellular");
            jSONObject2.put("available", e(context));
            jSONObject2.put("connected", j(context));
            jSONObject2.put("current", a(context, false));
            jSONObject2.put("scannable", v(context));
            jSONArray.put(jSONObject2);
        } catch (Throwable unused2) {
        }
        if (jSONArray.length() > 0) {
            return jSONArray;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0153 A[Catch: all -> 0x0188, TryCatch #1 {all -> 0x0188, blocks: (B:29:0x0060, B:31:0x007b, B:32:0x009b, B:34:0x009f, B:35:0x00fe, B:37:0x0102, B:39:0x0124, B:41:0x0128, B:45:0x0153, B:47:0x0158, B:49:0x015f, B:51:0x0164, B:53:0x016b, B:55:0x0172, B:56:0x0182), top: B:82:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0158 A[Catch: all -> 0x0188, TryCatch #1 {all -> 0x0188, blocks: (B:29:0x0060, B:31:0x007b, B:32:0x009b, B:34:0x009f, B:35:0x00fe, B:37:0x0102, B:39:0x0124, B:41:0x0128, B:45:0x0153, B:47:0x0158, B:49:0x015f, B:51:0x0164, B:53:0x016b, B:55:0x0172, B:56:0x0182), top: B:82:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x015f A[Catch: all -> 0x0188, TryCatch #1 {all -> 0x0188, blocks: (B:29:0x0060, B:31:0x007b, B:32:0x009b, B:34:0x009f, B:35:0x00fe, B:37:0x0102, B:39:0x0124, B:41:0x0128, B:45:0x0153, B:47:0x0158, B:49:0x015f, B:51:0x0164, B:53:0x016b, B:55:0x0172, B:56:0x0182), top: B:82:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0164 A[Catch: all -> 0x0188, TryCatch #1 {all -> 0x0188, blocks: (B:29:0x0060, B:31:0x007b, B:32:0x009b, B:34:0x009f, B:35:0x00fe, B:37:0x0102, B:39:0x0124, B:41:0x0128, B:45:0x0153, B:47:0x0158, B:49:0x015f, B:51:0x0164, B:53:0x016b, B:55:0x0172, B:56:0x0182), top: B:82:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016b A[Catch: all -> 0x0188, TryCatch #1 {all -> 0x0188, blocks: (B:29:0x0060, B:31:0x007b, B:32:0x009b, B:34:0x009f, B:35:0x00fe, B:37:0x0102, B:39:0x0124, B:41:0x0128, B:45:0x0153, B:47:0x0158, B:49:0x015f, B:51:0x0164, B:53:0x016b, B:55:0x0172, B:56:0x0182), top: B:82:0x0060 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0172 A[Catch: all -> 0x0188, TryCatch #1 {all -> 0x0188, blocks: (B:29:0x0060, B:31:0x007b, B:32:0x009b, B:34:0x009f, B:35:0x00fe, B:37:0x0102, B:39:0x0124, B:41:0x0128, B:45:0x0153, B:47:0x0158, B:49:0x015f, B:51:0x0164, B:53:0x016b, B:55:0x0172, B:56:0x0182), top: B:82:0x0060 }] */
    @TargetApi(18)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static JSONArray v(Context context) {
        Context context2;
        List<NeighboringCellInfo> neighboringCellInfo;
        JSONObject jSONObject;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        String str;
        CellSignalStrengthGsm cellSignalStrengthGsm;
        int i15;
        CellSignalStrengthGsm cellSignalStrengthGsm2;
        CellSignalStrengthWcdma cellSignalStrengthWcdma;
        if (context == null) {
            context2 = ab.f22568h;
            if (context2 == null) {
                return null;
            }
        } else {
            context2 = context;
        }
        if (!(u.b(context2, "android.permission.ACCESS_COARSE_LOCATION") || u.b(context2, "android.permission.ACCESS_FINE_LOCATION"))) {
            return null;
        }
        if (f22957n.length() > 0 || f22955l) {
            return f22957n;
        }
        try {
            if (f22946c == null) {
                a(context2);
            }
            JSONArray jSONArray = new JSONArray();
            if (u.a(17)) {
                List<CellInfo> allCellInfo = f22946c.getAllCellInfo();
                if (allCellInfo != null) {
                    for (CellInfo cellInfo : allCellInfo) {
                        try {
                            jSONObject = new JSONObject();
                            jSONObject.put("registered", cellInfo.isRegistered());
                            jSONObject.put("ts", cellInfo.getTimeStamp());
                        } catch (Throwable unused) {
                        }
                        if (cellInfo instanceof CellInfoGsm) {
                            str = "GSM";
                            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
                            i12 = cellIdentity.getLac();
                            i11 = cellIdentity.getCid();
                            int mcc = cellIdentity.getMcc();
                            i13 = cellIdentity.getMnc();
                            i14 = mcc;
                            i15 = -1;
                            cellSignalStrengthGsm2 = cellInfoGsm.getCellSignalStrength();
                        } else {
                            if (cellInfo instanceof CellInfoCdma) {
                                str = "CDMA";
                                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                                CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
                                i12 = cellIdentity2.getSystemId();
                                i11 = cellIdentity2.getNetworkId();
                                i10 = cellIdentity2.getBasestationId();
                                CellSignalStrengthCdma cellSignalStrength = cellInfoCdma.getCellSignalStrength();
                                jSONObject.put("cdmaDbm", cellSignalStrength.getCdmaDbm());
                                jSONObject.put("cdmaDbm", cellSignalStrength.getCdmaDbm());
                                jSONObject.put("cdmaEcio", cellSignalStrength.getCdmaEcio());
                                jSONObject.put("evdoDbm", cellSignalStrength.getEvdoDbm());
                                jSONObject.put("evdoEcio", cellSignalStrength.getEvdoEcio());
                                jSONObject.put("evdoSnr", cellSignalStrength.getEvdoSnr());
                                jSONObject.put(SharedWearInfoHelper.LocationInfo.TABLE, a(cellIdentity2.getLatitude(), cellIdentity2.getLongitude()));
                                i15 = -1;
                                i14 = -1;
                                i13 = -1;
                                cellSignalStrengthGsm = cellSignalStrength;
                            } else {
                                if (cellInfo instanceof CellInfoWcdma) {
                                    str = "WCDMA";
                                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                                    CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                                    i12 = cellIdentity3.getLac();
                                    i11 = cellIdentity3.getCid();
                                    i10 = cellIdentity3.getPsc();
                                    i14 = cellIdentity3.getMcc();
                                    i13 = cellIdentity3.getMnc();
                                    cellSignalStrengthWcdma = cellInfoWcdma.getCellSignalStrength();
                                } else if (cellInfo instanceof CellInfoLte) {
                                    str = "LTE";
                                    CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                                    CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                                    i12 = cellIdentity4.getTac();
                                    i11 = cellIdentity4.getPci();
                                    i10 = cellIdentity4.getCi();
                                    i14 = cellIdentity4.getMcc();
                                    i13 = cellIdentity4.getMnc();
                                    cellSignalStrengthWcdma = cellInfoLte.getCellSignalStrength();
                                } else {
                                    i15 = -1;
                                    cellSignalStrengthGsm2 = null;
                                    str = null;
                                    i14 = -1;
                                    i13 = -1;
                                    i12 = -1;
                                    i11 = -1;
                                }
                                i15 = -1;
                                cellSignalStrengthGsm = cellSignalStrengthWcdma;
                            }
                            if (i12 != i15) {
                                jSONObject.put("systemId", i12);
                            }
                            if (i11 != i15) {
                                jSONObject.put("networkId", i11);
                            }
                            if (i10 != i15) {
                                jSONObject.put("basestationId", i10);
                            }
                            if (i14 != i15) {
                                jSONObject.put("mcc", i14);
                            }
                            if (i13 != i15) {
                                jSONObject.put("mnc", i13);
                            }
                            if (cellSignalStrengthGsm != null) {
                                jSONObject.put("asuLevel", cellSignalStrengthGsm.getAsuLevel());
                                jSONObject.put("dbm", cellSignalStrengthGsm.getDbm());
                            }
                            jSONObject.put("type", str);
                            jSONArray.put(jSONObject);
                        }
                        i10 = -1;
                        cellSignalStrengthGsm = cellSignalStrengthGsm2;
                        if (i12 != i15) {
                        }
                        if (i11 != i15) {
                        }
                        if (i10 != i15) {
                        }
                        if (i14 != i15) {
                        }
                        if (i13 != i15) {
                        }
                        if (cellSignalStrengthGsm != null) {
                        }
                        jSONObject.put("type", str);
                        jSONArray.put(jSONObject);
                    }
                }
            } else if (u.a(5) && u.f23007c && (neighboringCellInfo = f22946c.getNeighboringCellInfo()) != null) {
                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("systemId", neighboringCellInfo2.getLac());
                        jSONObject2.put("netId", neighboringCellInfo2.getCid());
                        jSONObject2.put("basestationId", neighboringCellInfo2.getPsc());
                        jSONObject2.put("asuLevel", neighboringCellInfo2.getRssi());
                        jSONObject2.put("type", neighboringCellInfo2.getNetworkType());
                        jSONArray.put(jSONObject2);
                    } catch (Throwable unused2) {
                    }
                }
            }
            f22955l = true;
            f22957n.put(a(jSONArray, 20));
            return f22957n;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return null;
        }
    }

    public static String w(Context context) {
        WifiInfo connectionInfo;
        try {
            if (!u.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (!wifiManager.isWifiEnabled() || !i(context) || (connectionInfo = wifiManager.getConnectionInfo()) == null || connectionInfo.getSSID() == null) {
                return null;
            }
            return connectionInfo.getSSID();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONArray x(Context context) {
        List<WifiConfiguration> configuredNetworks;
        if (ab.P) {
            return null;
        }
        if (f22962s.length() > 0 || f22959p) {
            return f22962s;
        }
        try {
            if (u.b(context, "android.permission.ACCESS_WIFI_STATE") && (configuredNetworks = ((WifiManager) context.getSystemService("wifi")).getConfiguredNetworks()) != null) {
                JSONArray jSONArray = new JSONArray();
                for (WifiConfiguration wifiConfiguration : configuredNetworks) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("networkId", wifiConfiguration.networkId);
                        jSONObject.put(BleProtocol.PRIORITY, wifiConfiguration.priority);
                        jSONObject.put(ContactConstant.CallsRecordKeys.NAME, wifiConfiguration.SSID);
                        jSONObject.put("id", wifiConfiguration.BSSID);
                        jSONArray.put(jSONObject);
                    } catch (Throwable unused) {
                    }
                }
                f22959p = true;
                f22962s.put(b(jSONArray, 30));
                return f22962s;
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public static JSONArray y(Context context) {
        WifiInfo connectionInfo;
        if (ab.P) {
            return null;
        }
        if (f22961r.length() > 0 || f22958o) {
            return f22961r;
        }
        try {
            if (u.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager.isWifiEnabled() && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    String bssid = connectionInfo.getBSSID();
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(ContactConstant.CallsRecordKeys.NAME, connectionInfo.getSSID());
                        jSONObject.put("id", bssid);
                        jSONObject.put("level", connectionInfo.getRssi());
                        jSONObject.put("hidden", connectionInfo.getHiddenSSID());
                        jSONObject.put("ip", connectionInfo.getIpAddress());
                        jSONObject.put("speed", connectionInfo.getLinkSpeed());
                        jSONObject.put("networkId", connectionInfo.getNetworkId());
                        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
                        if (dhcpInfo != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("dns1", dhcpInfo.dns1);
                            jSONObject2.put("dns2", dhcpInfo.dns2);
                            jSONObject2.put("gw", dhcpInfo.gateway);
                            jSONObject2.put("ip", dhcpInfo.ipAddress);
                            jSONObject2.put("mask", dhcpInfo.netmask);
                            jSONObject2.put("server", dhcpInfo.serverAddress);
                            jSONObject2.put("leaseDuration", dhcpInfo.leaseDuration);
                            jSONObject.put("dhcp", jSONObject2);
                        }
                    } catch (Throwable unused) {
                    }
                    f22958o = true;
                    f22961r.put(jSONObject);
                    return f22961r;
                }
            }
        } catch (Throwable unused2) {
        }
        return null;
    }

    public static synchronized JSONArray z(Context context) {
        synchronized (m.class) {
            if (!u.f23007c) {
                return null;
            }
            if (ab.P) {
                return null;
            }
            if (f22962s.length() > 0 || f22960q) {
                return f22961r;
            }
            try {
                if (u.b(context, "android.permission.ACCESS_WIFI_STATE")) {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    if (wifiManager.isWifiEnabled() || (Build.VERSION.SDK_INT >= 18 && wifiManager.isScanAlwaysAvailable())) {
                        if (u.b(context, "android.permission.CHANGE_WIFI_STATE") && !f22964u) {
                            try {
                                context.registerReceiver(f22965v, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                            } catch (Throwable unused) {
                            }
                            f22964u = true;
                        }
                        wifiManager.startScan();
                        f22965v.await();
                        List<ScanResult> scanResults = wifiManager.getScanResults();
                        f22965v.reset();
                        if (scanResults != null) {
                            ArrayList arrayList = new ArrayList();
                            for (ScanResult scanResult : scanResults) {
                                if (scanResult.level >= -85) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("id", scanResult.BSSID);
                                        jSONObject.put(ContactConstant.CallsRecordKeys.NAME, scanResult.SSID);
                                        jSONObject.put("level", scanResult.level);
                                        jSONObject.put("freq", scanResult.frequency);
                                        if (u.a(17)) {
                                            jSONObject.put("ts", scanResult.timestamp);
                                            jSONObject.put("scanTs", (System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (scanResult.timestamp / 1000));
                                        }
                                        arrayList.add(jSONObject);
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                            f22960q = true;
                            f22963t.put(a(arrayList, 20));
                            return f22963t;
                        }
                    }
                }
            } catch (Throwable unused3) {
            }
            return null;
        }
    }

    public static String a(String str) {
        return f22947d.get(str);
    }

    public static String[] a() {
        String[] strArr = {null, null, null, null};
        if (ab.Q) {
            return strArr;
        }
        boolean i10 = i(ab.f22568h);
        boolean j10 = j(ab.f22568h);
        if (i10 || j10) {
            try {
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
            if (i10) {
                b(strArr);
            } else {
                if (j10) {
                    a(strArr);
                }
                return strArr;
            }
            return strArr;
        }
        g.iForInternal("no-network");
        return strArr;
    }

    private static String c(int i10) {
        if (i10 >= 0) {
            String[] strArr = f22949f;
            if (i10 < strArr.length) {
                return strArr[i10];
            }
        }
        return String.valueOf(i10);
    }

    private static Boolean c(String str) {
        try {
            Integer valueOf = Integer.valueOf(str.length());
            if (valueOf.intValue() > 10 && valueOf.intValue() < 20 && !b(str.trim()).booleanValue()) {
                return Boolean.TRUE;
            }
        } catch (Throwable unused) {
        }
        return Boolean.FALSE;
    }

    private static void a(String[] strArr) {
        Enumeration<InetAddress> inetAddresses;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces != null) {
            ArrayList arrayList = new ArrayList();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface nextElement = networkInterfaces.nextElement();
                if (!nextElement.isLoopback()) {
                    String lowerCase = nextElement.getName().toLowerCase();
                    if (!lowerCase.startsWith("wlan") && !lowerCase.startsWith("eth") && !lowerCase.startsWith("dummy") && (inetAddresses = nextElement.getInetAddresses()) != null && inetAddresses.hasMoreElements()) {
                        arrayList.add(Collections.list(inetAddresses));
                    }
                }
            }
            if (arrayList.size() != 0) {
                Collections.sort(arrayList, new Comparator<List<InetAddress>>() { // from class: com.tendcloud.tenddata.m.1
                    public int compare(List<InetAddress> list, List<InetAddress> list2) {
                        return list.size() - list2.size();
                    }
                });
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    for (InetAddress inetAddress : (List) arrayList.get(size)) {
                        if (!inetAddress.isLinkLocalAddress() && !inetAddress.isLoopbackAddress()) {
                            if (inetAddress instanceof Inet4Address) {
                                strArr[2] = inetAddress.getHostAddress();
                            } else if (inetAddress instanceof Inet6Address) {
                                String hostAddress = inetAddress.getHostAddress();
                                if (!hostAddress.contains("ff:fe")) {
                                    strArr[3] = hostAddress;
                                }
                            }
                        }
                    }
                    if (strArr[2] != null || strArr[3] != null) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
        if (r7 == null) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context) {
        Socket socket;
        ConnectivityManager connectivityManager;
        try {
            if (u.b(context, "android.permission.ACCESS_NETWORK_STATE") && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
                if (u.a(29)) {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null) {
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                        return networkCapabilities != null && networkCapabilities.hasCapability(12);
                    }
                } else {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                    NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
                    if (networkInfo == null || !networkInfo.getState().equals(NetworkInfo.State.UNKNOWN)) {
                        return false;
                    }
                }
            }
            if (SystemClock.elapsedRealtime() - f22953j > f22952i) {
                f22953j = SystemClock.elapsedRealtime();
                Socket socket2 = null;
                try {
                    if (b()) {
                        socket = new Socket(Proxy.getDefaultHost(), Proxy.getDefaultPort());
                    } else {
                        socket = new Socket(f22944a, 80);
                    }
                    socket2 = socket;
                    f22951h = true;
                } catch (Throwable unused) {
                    f22951h = false;
                }
                try {
                    socket2.close();
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
        return f22951h;
    }

    private static String a(int i10) {
        if (i10 >= 0) {
            String[] strArr = f22948e;
            if (i10 < strArr.length) {
                return strArr[i10];
            }
        }
        return String.valueOf(i10);
    }

    public static JSONArray a(Context context, boolean z10) {
        CdmaCellLocation cdmaCellLocation;
        if (context == null) {
            try {
                context = ab.f22568h;
                if (context == null) {
                    return null;
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
                return null;
            }
        }
        if (f22956m.length() <= 0 && !f22954k) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", n(context));
            jSONObject.put("mcc", o(context));
            jSONObject.put("operator", s(context));
            jSONObject.put(SettingConstants.COUNTRY, r(context));
            if (u.b(context, "android.permission.ACCESS_COARSE_LOCATION") || u.b(context, "android.permission.ACCESS_FINE_LOCATION")) {
                if (f22946c == null) {
                    a(context);
                }
                if (u.f23007c || z10) {
                    CellLocation cellLocation = f22946c.getCellLocation();
                    if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        if (gsmCellLocation != null) {
                            jSONObject.put("systemId", gsmCellLocation.getLac());
                            jSONObject.put("networkId", gsmCellLocation.getCid());
                            if (u.a(9)) {
                                jSONObject.put("basestationId", gsmCellLocation.getPsc());
                            }
                        }
                    } else if ((cellLocation instanceof CdmaCellLocation) && (cdmaCellLocation = (CdmaCellLocation) cellLocation) != null) {
                        jSONObject.put("systemId", cdmaCellLocation.getSystemId());
                        jSONObject.put("networkId", cdmaCellLocation.getNetworkId());
                        jSONObject.put("basestationId", cdmaCellLocation.getBaseStationId());
                        jSONObject.put(SharedWearInfoHelper.LocationInfo.TABLE, a(cdmaCellLocation.getBaseStationLatitude(), cdmaCellLocation.getBaseStationLongitude()));
                    }
                }
            }
            f22954k = true;
            f22956m.put(jSONObject);
            return f22956m;
        }
        return f22956m;
    }

    public static boolean b() {
        try {
            if (u.a(11)) {
                return !TextUtils.isEmpty(System.getProperty("http.proxyHost"));
            }
            return !TextUtils.isEmpty(Proxy.getDefaultHost());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static JSONArray b(JSONArray jSONArray, int i10) {
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(jSONArray.optJSONObject(i11));
            }
            Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.tendcloud.tenddata.m.3
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    try {
                        return jSONObject.getInt("networkId") - jSONObject2.getInt("networkId");
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            if (arrayList.size() <= i10) {
                i10 = arrayList.size();
            }
            return new JSONArray((Collection) arrayList.subList(0, i10));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Boolean b(String str) {
        char c10 = '0';
        try {
            if (str.length() > 0) {
                c10 = str.charAt(0);
            }
            Boolean bool = Boolean.TRUE;
            for (int i10 = 0; i10 < str.length(); i10++) {
                if (c10 != str.charAt(i10)) {
                    return Boolean.FALSE;
                }
            }
            return bool;
        } catch (Throwable unused) {
            return Boolean.FALSE;
        }
    }

    public static JSONArray a(JSONArray jSONArray, int i10) {
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(jSONArray.optJSONObject(i11));
            }
            Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.tendcloud.tenddata.m.2
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    try {
                        return jSONObject2.getInt("asuLevel") - jSONObject.getInt("asuLevel");
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            if (arrayList.size() <= i10) {
                i10 = arrayList.size();
            }
            return new JSONArray((Collection) arrayList.subList(0, i10));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static JSONObject a(int i10, int i11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SharedWearInfoHelper.LocationInfo.KEY_LAT, i10);
            jSONObject.put(SharedWearInfoHelper.LocationInfo.KEY_LNG, i11);
            jSONObject.put("unit", "qd");
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public static JSONArray a(ArrayList arrayList, int i10) {
        try {
            Collections.sort(arrayList, new Comparator<JSONObject>() { // from class: com.tendcloud.tenddata.m.4
                public int compare(JSONObject jSONObject, JSONObject jSONObject2) {
                    try {
                        return jSONObject2.getInt("level") - jSONObject.getInt("level");
                    } catch (Throwable unused) {
                        return 0;
                    }
                }
            });
            if (arrayList.size() <= i10) {
                i10 = arrayList.size();
            }
            return new JSONArray((Collection) arrayList.subList(0, i10));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONArray a(BitSet bitSet) {
        if (bitSet == null || bitSet.cardinality() < 1) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        int i10 = 0;
        while (true) {
            int nextSetBit = bitSet.nextSetBit(i10);
            if (nextSetBit < 0) {
                return jSONArray;
            }
            jSONArray.put(nextSetBit);
            i10 = nextSetBit + 1;
        }
    }

    private static JSONObject a(TelephonyManager telephonyManager, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("imei", str.trim());
            jSONObject.put("imei5", u.c(str.trim()));
            String str2 = "";
            jSONObject.put("subscriberId", telephonyManager.getSubscriberId() == null ? str2 : telephonyManager.getSubscriberId());
            jSONObject.put("simSerialNumber", telephonyManager.getSimSerialNumber() == null ? str2 : telephonyManager.getSimSerialNumber());
            jSONObject.put("dataState", telephonyManager.getDataState());
            jSONObject.put("networkType", a(telephonyManager.getNetworkType()));
            jSONObject.put("networkOperator", telephonyManager.getNetworkOperator());
            jSONObject.put("phoneType", c(telephonyManager.getPhoneType()));
            jSONObject.put("simOperator", telephonyManager.getSimOperator() == null ? str2 : telephonyManager.getSimOperator());
            jSONObject.put("simOperatorName", telephonyManager.getSimOperatorName() == null ? str2 : telephonyManager.getSimOperatorName());
            if (telephonyManager.getSimCountryIso() != null) {
                str2 = telephonyManager.getSimCountryIso();
            }
            jSONObject.put("simCountryIso", str2);
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONObject a(Context context, SubscriptionManager subscriptionManager, int i10) {
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex;
        JSONObject jSONObject = new JSONObject();
        try {
            if (u.a(22) && (activeSubscriptionInfoForSimSlotIndex = subscriptionManager.getActiveSubscriptionInfoForSimSlotIndex(i10)) != null) {
                String str = "";
                jSONObject.put("simSerialNumber", activeSubscriptionInfoForSimSlotIndex.getIccId() == null ? str : activeSubscriptionInfoForSimSlotIndex.getIccId());
                jSONObject.put("simOperator", activeSubscriptionInfoForSimSlotIndex.getMcc() + "0" + activeSubscriptionInfoForSimSlotIndex.getMnc());
                jSONObject.put("simOperatorName", activeSubscriptionInfoForSimSlotIndex.getCarrierName() == null ? str : activeSubscriptionInfoForSimSlotIndex.getCarrierName());
                if (activeSubscriptionInfoForSimSlotIndex.getCountryIso() != null) {
                    str = activeSubscriptionInfoForSimSlotIndex.getCountryIso();
                }
                jSONObject.put("simCountryIso", str);
                jSONObject.put("subscriberId", k.a("imsi"));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private static JSONObject a(Class<?> cls, Object obj, Integer num, String str, String str2) {
        String str3 = "";
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("imei", str);
        jSONObject.put("imei5", u.c(str));
        try {
            Method method = cls.getMethod("getSubscriberId" + str2, Integer.TYPE);
            jSONObject.put("subscriberId", method.invoke(obj, num) == null ? str3 : ((String) method.invoke(obj, num)).trim());
        } catch (Throwable unused) {
        }
        try {
            Method method2 = cls.getMethod("getSimSerialNumber" + str2, Integer.TYPE);
            jSONObject.put("simSerialNumber", method2.invoke(obj, num) == null ? str3 : ((String) method2.invoke(obj, num)).trim());
        } catch (Throwable unused2) {
        }
        try {
            jSONObject.put("dataState", (Integer) cls.getMethod("getDataState" + str2, Integer.TYPE).invoke(obj, num));
        } catch (Throwable unused3) {
        }
        try {
            jSONObject.put("networkType", a(((Integer) cls.getMethod("getNetworkType" + str2, Integer.TYPE).invoke(obj, num)).intValue()));
        } catch (Throwable unused4) {
        }
        try {
            jSONObject.put("networkOperator", (String) cls.getMethod("getNetworkOperator" + str2, Integer.TYPE).invoke(obj, num));
        } catch (Throwable unused5) {
        }
        try {
            jSONObject.put("phoneType", c(((Integer) cls.getMethod("getPhoneType" + str2, Integer.TYPE).invoke(obj, num)).intValue()));
        } catch (Throwable unused6) {
        }
        try {
            Method method3 = cls.getMethod("getSimOperator" + str2, Integer.TYPE);
            jSONObject.put("simOperator", method3.invoke(obj, num) == null ? str3 : ((String) method3.invoke(obj, num)).trim());
        } catch (Throwable unused7) {
        }
        try {
            Method method4 = cls.getMethod("getSimOperatorName" + str2, Integer.TYPE);
            if (method4.invoke(obj, num) != null) {
                str3 = ((String) method4.invoke(obj, num)).trim();
            }
            jSONObject.put("simOperatorName", str3);
        } catch (Throwable unused8) {
        }
        return jSONObject;
    }
}
