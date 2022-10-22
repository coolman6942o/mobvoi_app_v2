package com.mobvoi.android.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* compiled from: HardwareIdUtils.java */
@SuppressLint({"HardwareIds", "MissingPermission"})
/* loaded from: classes2.dex */
public class h {
    public static String a(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
        if (telephonyManager == null) {
            return "";
        }
        try {
            String deviceId = telephonyManager.getDeviceId();
            return deviceId != null ? deviceId : "";
        } catch (SecurityException unused) {
            return "";
        }
    }

    public static String b(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String c() {
        return Build.MODEL;
    }

    public static int d() {
        return Build.VERSION.SDK_INT;
    }

    @SuppressLint({"MissingPermission"})
    public static String e() {
        if (Build.VERSION.SDK_INT < 28) {
            return Build.SERIAL;
        }
        String str = Build.SERIAL;
        return !str.equals("unknown") ? str : Build.getSerial();
    }

    @SuppressLint({"MissingPermission"})
    public static String f() {
        try {
            return e();
        } catch (SecurityException unused) {
            return "unknown";
        }
    }

    public static String g(Context context) {
        String macAddress;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        return (wifiManager == null || (macAddress = wifiManager.getConnectionInfo().getMacAddress()) == null) ? "" : macAddress;
    }
}
