package com.mobvoi.wear.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.provider.Settings;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.Constants;
/* loaded from: classes2.dex */
public class WatchWifiHelper {
    private static final String TAG = "WatchWifiHelper";

    private WatchWifiHelper() {
    }

    public static boolean isWifiAutoEnabled(Context context) {
        return SettingsProviderUtils.getIntForUserFromSystem(context, Constants.Setting.WIFI_AUTO_ENABLED, 0) == 1;
    }

    public static boolean isWifiConfigured(Context context) {
        return SettingsProviderUtils.getIntForUserFromSystem(context, Constants.Setting.WIFI_CONFIGURED, 0) == 1;
    }

    public static boolean isWifiEnabled(Context context) {
        return ((WifiManager) context.getSystemService("wifi")).isWifiEnabled();
    }

    public static void setWifiAutoEnabled(Context context, boolean z10, String str) {
        k.a(TAG, "setWifiAutoEnabled: " + z10 + ", reason: " + str);
        if (isWifiEnabled(context)) {
            Settings.System.putInt(context.getContentResolver(), Constants.Setting.WIFI_AUTO_ENABLED, 0);
        }
    }

    public static void setWifiConfigured(Context context, boolean z10) {
        k.a(TAG, "setWifiConfigured: " + z10);
        Settings.System.putInt(context.getContentResolver(), Constants.Setting.WIFI_CONFIGURED, z10 ? 1 : 0);
    }

    @SuppressLint({"MissingPermission"})
    public static void setWifiEnabled(Context context, boolean z10) {
        ((WifiManager) context.getSystemService("wifi")).setWifiEnabled(z10);
    }
}
