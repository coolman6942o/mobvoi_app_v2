package com.mobvoi.wear.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* loaded from: classes2.dex */
public class ConnectionUtils {
    public static final String KEY_CONNECTIVITY = "network_connectivity";
    public static final String KEY_SUBTYPE = "network_subtype";
    public static final String KEY_TYPE = "network_type";
    public static final int NETWORK_DISCONNECTED = -1;
    public static final int NETWORK_FAST = 2;
    public static final int NETWORK_MEDIUM = 1;
    public static final int NETWORK_SLOW = 0;
    public static final String PREF_KEY = "common_preferences";
    private static final String TAG = "ConnectionUtils";

    public static int getConnectionSpeed(int i10, int i11) {
        if (i10 == 1) {
            return 2;
        }
        if (i10 == 0) {
            switch (i11) {
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                    break;
                case 4:
                case 7:
                case 11:
                default:
                    return 0;
                case 13:
                    return 2;
                case 14:
                case 15:
                    return 1;
            }
        }
        return 1;
    }

    @TargetApi(21)
    public static int getNetworkBandwidth(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network[] allNetworks = connectivityManager.getAllNetworks();
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (!(activeNetworkInfo == null || allNetworks == null || allNetworks.length == 0)) {
            for (Network network : allNetworks) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                if (networkInfo != null && networkInfo.isConnected() && networkInfo.getType() == activeNetworkInfo.getType() && networkInfo.getSubtype() == activeNetworkInfo.getSubtype()) {
                    try {
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                        if (networkCapabilities != null) {
                            return networkCapabilities.getLinkDownstreamBandwidthKbps();
                        }
                        return 0;
                    } catch (NullPointerException unused) {
                        return 0;
                    }
                }
            }
        }
        return 0;
    }

    public static int getProxyNetworkSpeed(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_KEY, 0);
        boolean z10 = sharedPreferences.getBoolean(KEY_CONNECTIVITY, false);
        int i10 = sharedPreferences.getInt(KEY_TYPE, -1);
        int i11 = sharedPreferences.getInt(KEY_SUBTYPE, -1);
        if (!z10) {
            return -1;
        }
        return getConnectionSpeed(i10, i11);
    }

    public static boolean inAirplaneMode(Context context) {
        boolean z10 = false;
        if (SettingsProviderUtils.getIntForUserFromGlobal(context, "airplane_mode_on", 0) == 1) {
            z10 = true;
        }
        k.h(TAG, "inAirplaneMode " + z10);
        return z10;
    }

    public static boolean isMobileDataAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 0;
    }

    public static boolean isMobileDataOrWifiAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return activeNetworkInfo.getType() == 0 || activeNetworkInfo.getType() == 1;
    }

    public static boolean isNetworkAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean isTelephonyAvailable(Context context) {
        int phoneType = ((TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).getPhoneType();
        boolean inAirplaneMode = inAirplaneMode(context);
        Log.i(TAG, "phoneType=" + phoneType + " airplaneMode=" + inAirplaneMode);
        return phoneType != 0 && !inAirplaneMode;
    }

    public static void setAirplaneMode(Context context, boolean z10) {
        k.h(TAG, "setAirplaneMode " + z10);
        Settings.Global.putInt(context.getContentResolver(), "airplane_mode_on", z10 ? 1 : 0);
        Intent intent = new Intent("android.intent.action.AIRPLANE_MODE");
        intent.putExtra("state", z10);
        context.sendBroadcast(intent);
    }

    public static void storeProxyNetworkType(Context context, boolean z10, int i10, int i11) {
        SharedPreferences.Editor edit = context.getSharedPreferences(PREF_KEY, 0).edit();
        edit.putBoolean(KEY_CONNECTIVITY, z10);
        edit.putInt(KEY_TYPE, i10);
        edit.putInt(KEY_SUBTYPE, i11);
        edit.apply();
    }
}
