package com.huawei.hianalytics.mn.no.no;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.huawei.hianalytics.mn.no.qr.mn;
/* loaded from: classes.dex */
public class op {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static String mn(int i10, String str) {
        switch (i10) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
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
                break;
            case 13:
                return "4G";
            default:
                if (!str.equalsIgnoreCase("TD-SCDMA") && !str.equalsIgnoreCase("WCDMA") && !str.equalsIgnoreCase("CDMA2000")) {
                    return str;
                }
                break;
        }
        return "3G";
    }

    public static String mn(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) != 0) {
            mn.op("hmsSdk", "not have network state phone permission!");
            return "";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) {
            return "";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "WIFI";
        }
        if (activeNetworkInfo.getType() == 0) {
            String subtypeName = activeNetworkInfo.getSubtypeName();
            mn.no("hmsSdk", "Network getSubtypeName : ".concat(String.valueOf(subtypeName)));
            return mn(activeNetworkInfo.getSubtype(), subtypeName);
        } else if (activeNetworkInfo.getType() != 16) {
            return "";
        } else {
            mn.op("hmsSdk", "type name = ".concat("COMPANION_PROXY"));
            return "COMPANION_PROXY";
        }
    }
}
