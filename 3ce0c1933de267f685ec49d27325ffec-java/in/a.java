package in;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import gn.u;
/* loaded from: classes2.dex */
public class a {
    public static boolean a(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("YCAPPKEY");
                if (string != null) {
                    return string;
                }
                e("CommonUtil.getAppKey->Could not read APPKEY meta-data from AndroidManifest.xml.");
            }
        } catch (Exception e10) {
            e("CommonUtil.getAppKey->Could not read APPKEY meta-data from AndroidManifest.xml.");
            e10.printStackTrace();
        }
        return "";
    }

    public static boolean c(Context context) {
        String str;
        if (a(context, "android.permission.INTERNET")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                return true;
            }
            str = "CommonUtil.isNetworkAvailable->Network error";
        } else {
            str = "CommonUtil.isNetworkAvailable->lost----> android.permission.INTERNET";
        }
        e(str);
        return false;
    }

    public static boolean d(Context context) {
        String str;
        if (a(context, "android.permission.INTERNET")) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getTypeName().equals("WIFI")) {
                return true;
            }
            str = "CommonUtil.isNetworkTypeWifi->Network not wifi";
        } else {
            str = "CommonUtil.isNetworkTypeWifi->lost----> android.permission.INTERNET";
        }
        e(str);
        return false;
    }

    public static void e(String str) {
        if (b.f28344b) {
            u.a("yc_sdk", str);
        }
    }

    public static void f(String str, String str2) {
        if (b.f28344b) {
            u.a(str, str2);
        }
    }
}
