package com.unionpay.mobile.android.utils;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.unionpay.mobile.android.global.a;
import java.io.File;
import java.net.NetworkInterface;
import java.util.Locale;
import java.util.TimeZone;
/* loaded from: classes2.dex */
public final class f {
    public static String a() {
        return Locale.getDefault().toString().startsWith("zh") ? "zh_CN" : "en_US";
    }

    public static String a(Context context) {
        String packageName;
        return (context == null || !(context instanceof Activity) || (packageName = ((Activity) context).getPackageName()) == null) ? "" : packageName;
    }

    private static String a(String str) {
        try {
            byte[] hardwareAddress = NetworkInterface.getByName(str).getHardwareAddress();
            if (hardwareAddress == null) {
                return "";
            }
            StringBuilder sb2 = new StringBuilder();
            int length = hardwareAddress.length;
            for (int i10 = 0; i10 < length; i10++) {
                sb2.append(String.format("%02x:", Byte.valueOf(hardwareAddress[i10])));
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            return sb2.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String b() {
        return new File("/system/bin/su").exists() ? "1" : "0";
    }

    public static final String b(Context context) {
        String macAddress;
        if (Build.VERSION.SDK_INT < 23) {
            try {
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
                macAddress = (connectionInfo == null || connectionInfo.getMacAddress() == null) ? "" : connectionInfo.getMacAddress();
                if (macAddress == null || macAddress.length() == 0) {
                    macAddress = a("wlan0");
                }
            } catch (Exception unused) {
            }
            return (macAddress == null || macAddress == "") ? "" : macAddress.replaceAll(":", "");
        }
        macAddress = a("wlan0");
        if (macAddress == null) {
            return "";
        }
    }

    public static String c() {
        String trim = Build.MODEL.trim();
        if (trim != null) {
            trim.replace(" ", "");
        }
        return trim;
    }

    public static String c(Context context) {
        String str;
        try {
            str = new File("/system/bin/su").exists() ? b(context) : ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getDeviceId();
        } catch (Exception unused) {
            str = "";
        }
        return (str == null || str.length() == 0) ? PreferenceUtils.a(context) : str;
    }

    public static String d() {
        return (a.I + MessageProxyConstants.NODE_ID_ANY + a.f23329t).trim();
    }

    public static String d(Context context) {
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getSubscriberId();
            return subscriberId == null ? "" : subscriberId;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", String.class, String.class).invoke(cls.newInstance(), "gsm.version.baseband", "no message");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            return "disConnect";
        }
        if (activeNetworkInfo.getType() != 0) {
            return activeNetworkInfo.getType() == 1 ? "wifi" : "other";
        }
        if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
            return "mobile";
        }
        return "mobile:" + activeNetworkInfo.getExtraInfo();
    }

    public static Location f(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(SharedWearInfoHelper.LocationInfo.TABLE);
        Location location = null;
        try {
            if (locationManager.isProviderEnabled("gps")) {
                location = locationManager.getLastKnownLocation("gps");
                if (location == null && locationManager.isProviderEnabled("network")) {
                    return locationManager.getLastKnownLocation("network");
                }
            } else if (locationManager.isProviderEnabled("network")) {
                location = locationManager.getLastKnownLocation("network");
            }
        } catch (Exception unused) {
        }
        return location;
    }

    public static String f() {
        return TimeZone.getDefault().getDisplayName(false, 0);
    }

    public static String g(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getLine1Number();
        } catch (Exception unused) {
            return "";
        }
    }
}
