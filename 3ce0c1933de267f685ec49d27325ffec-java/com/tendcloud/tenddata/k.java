package com.tendcloud.tenddata;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.unionpay.tsmservice.mi.data.Constant;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import s5.a;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static TelephonyManager f22939a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f22940b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f22941c = false;

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, String> f22942d;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f22942d = hashMap;
        try {
            Context context = ab.f22568h;
            if (context != null) {
                f22939a = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
                hashMap.put("imei1", a(ab.f22568h, 0));
                if (m.B(ab.f22568h) == 2) {
                    hashMap.put("imei2", a(ab.f22568h, 1));
                }
                hashMap.put("imsi", g(ab.f22568h));
                hashMap.put("androidId", e(ab.f22568h));
                hashMap.put(Constant.KEY_MAC, d(ab.f22568h));
                hashMap.put("ethMac", b());
                hashMap.put("dummy0", a());
                hashMap.put("serialNo", c(ab.f22568h));
            }
        } catch (Throwable unused) {
        }
    }

    private k() {
    }

    public static String c(Context context) {
        try {
            if (u.a(9) && u.b(26)) {
                return Build.SERIAL;
            }
            if (!u.a(26) || !u.b(context, "android.permission.READ_PHONE_STATE")) {
                return null;
            }
            return Build.getSerial();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String d(Context context) {
        Throwable th2;
        String str;
        String str2 = null;
        try {
            if (u.a(23)) {
                str = d();
            } else {
                str = j(context);
            }
            try {
                if (u.j(str)) {
                    return null;
                }
                return str;
            } catch (Throwable th3) {
                th2 = th3;
                str2 = str;
                bf.postSDKError(th2);
                return str2;
            }
        } catch (Throwable th4) {
            th2 = th4;
        }
    }

    private static String e() {
        return null;
    }

    public static String e(Context context) {
        try {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String f(Context context) {
        HashMap<String, String> hashMap;
        String str;
        try {
            if (m.B(context) == 2) {
                hashMap = f22942d;
                str = "imei2";
            } else {
                hashMap = f22942d;
                str = "imei1";
            }
            return hashMap.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String g(Context context) {
        try {
            if (u.b(context, "android.permission.READ_PHONE_STATE")) {
                return f22939a.getSubscriberId();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String h(Context context) {
        try {
            if (!u.b(context, "android.permission.READ_PHONE_STATE")) {
                return null;
            }
            String str = "";
            if (m.B(context) == 2) {
                try {
                    HashMap<String, String> hashMap = f22942d;
                    hashMap.get("imei1");
                    str = hashMap.get("imei2");
                } catch (Exception unused) {
                }
            }
            return u.b(str) ? f22942d.get("imei1") : str;
        } catch (Throwable unused2) {
            return null;
        }
    }

    private static String i(Context context) {
        try {
            if (u.b(context, "android.permission.READ_PHONE_STATE")) {
                return f22939a.getSimSerialNumber();
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String j(Context context) {
        WifiManager wifiManager;
        WifiInfo connectionInfo;
        String macAddress;
        try {
            if (!u.b(context, "android.permission.ACCESS_WIFI_STATE") || (wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi")) == null || !wifiManager.isWifiEnabled() || (connectionInfo = wifiManager.getConnectionInfo()) == null || (macAddress = connectionInfo.getMacAddress()) == null) {
                return null;
            }
            return macAddress.toUpperCase().trim();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(String str) {
        return f22942d.get(str);
    }

    public static String b(final Context context) {
        try {
            if (!f22941c) {
                s.f22998a.execute(new Runnable() { // from class: com.tendcloud.tenddata.k.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            boolean unused = k.f22941c = true;
                            String unused2 = k.f22940b = (String) a.C0494a.class.getMethod("getId", new Class[0]).invoke(a.class.getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context), new Object[0]);
                        } catch (Throwable unused3) {
                        }
                    }
                });
            }
            return f22940b;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
        try {
            String a10 = a(Constant.KEY_MAC);
            if (!u.b(a10)) {
                a10 = String.valueOf(Long.parseLong(a10.replaceAll(":", ""), 16));
            }
            String a11 = a("androidId");
            String a12 = a("imeis");
            String a13 = a("imsi");
            String a14 = a("simId");
            String a15 = i.a(context);
            String c10 = c();
            String a16 = a("serialNo");
            StringBuilder sb2 = new StringBuilder(170);
            sb2.append(2);
            sb2.append("|");
            sb2.append(a10);
            sb2.append("|");
            sb2.append(a11);
            sb2.append("|");
            sb2.append(a12);
            sb2.append("|");
            sb2.append(a13);
            sb2.append("|");
            sb2.append(a14);
            sb2.append("|");
            sb2.append(a15);
            sb2.append("|");
            sb2.append(c10);
            sb2.append("|");
            sb2.append(a16);
            return sb2.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b() {
        String str;
        Throwable th2;
        try {
            str = e();
            try {
                if (u.j(str)) {
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                bf.postSDKError(th2);
                return str;
            }
        } catch (Throwable th4) {
            th2 = th4;
            str = null;
        }
        return str;
    }

    private static String c() {
        try {
            return co.a().c();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String d() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb2 = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        sb2.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i10])));
                    }
                    if (sb2.length() > 0) {
                        sb2.deleteCharAt(sb2.length() - 1);
                    }
                    return sb2.toString().toUpperCase().trim();
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String c(int i10) {
        try {
            String a10 = a(i10);
            if (u.b(a10)) {
                return null;
            }
            return u.c(a10);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String b(int i10) {
        String str;
        try {
            if (i10 == 1) {
                str = a("imei2");
            } else {
                str = a("imei1");
            }
            if (u.b(str)) {
                return null;
            }
            return u.c(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    String hostAddress = inetAddresses.nextElement().getHostAddress();
                    if (hostAddress.contains("dummy")) {
                        return hostAddress.split("%")[0];
                    }
                }
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static String a(Context context, int i10) {
        if (u.b(context, "android.permission.READ_PHONE_STATE")) {
            if (u.a(26)) {
                try {
                    return f22939a.getImei(i10);
                } catch (Throwable unused) {
                }
            } else if (u.a(23)) {
                return f22939a.getDeviceId(i10);
            } else {
                return f22939a.getDeviceId();
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(int i10) {
        if (u.a(26)) {
            try {
                return f22939a.getMeid(i10);
            } catch (Throwable unused) {
            }
        }
        return "";
    }
}
