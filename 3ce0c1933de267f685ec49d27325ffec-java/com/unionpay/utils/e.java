package com.unionpay.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.net.NetworkInterface;
/* loaded from: classes2.dex */
public final class e {
    public static String a() {
        try {
            return Build.getRadioVersion();
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String a(Context context) {
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

    @SuppressLint({"NewApi"})
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

    public static String b(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getDeviceId();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String c(Context context) {
        try {
            String subscriberId = ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getSubscriberId();
            return subscriberId == null ? "" : subscriberId;
        } catch (Exception unused) {
            return "";
        }
    }

    public static Location d(Context context) {
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

    public static String e(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getLine1Number();
        } catch (Exception unused) {
            return "";
        }
    }
}
