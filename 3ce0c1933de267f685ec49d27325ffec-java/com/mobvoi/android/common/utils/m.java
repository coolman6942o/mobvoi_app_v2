package com.mobvoi.android.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
/* compiled from: NetworkUtils.java */
/* loaded from: classes2.dex */
public class m {
    public static NetworkInfo a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            k.q("NetworkUtils", "failed to get connectivity service");
            return null;
        }
        try {
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception e10) {
            k.r("NetworkUtils", "failed to get active network info", e10, new Object[0]);
            return null;
        }
    }

    public static boolean b(Context context) {
        NetworkInfo a10 = a(context);
        return a10 != null && a10.isConnected();
    }

    public static boolean c(Context context) {
        WifiInfo connectionInfo;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        return (!wifiManager.isWifiEnabled() || (connectionInfo = wifiManager.getConnectionInfo()) == null || connectionInfo.getNetworkId() == -1) ? false : true;
    }
}
