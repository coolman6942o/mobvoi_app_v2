package k4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* compiled from: DeviceInfo.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f29743a = "";

    public static String a(Context context) {
        try {
            return i(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String c(Context context) {
        try {
            return l(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static int d(Context context) {
        try {
            return m(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static int e(Context context) {
        try {
            return j(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static String f(Context context) {
        try {
            return h(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static String g(Context context) {
        try {
            return h(context);
        } catch (Throwable th2) {
            d.b(th2, "DeviceInfo", "getSubscriberId");
            return "";
        }
    }

    private static String h(Context context) {
        String str = f29743a;
        if (str != null && !"".equals(str)) {
            return f29743a;
        }
        if (!b(context, "android.permission.READ_PHONE_STATE")) {
            return f29743a;
        }
        TelephonyManager n10 = n(context);
        if (n10 == null) {
            return "";
        }
        String subscriberId = n10.getSubscriberId();
        f29743a = subscriberId;
        if (subscriberId == null) {
            f29743a = "";
        }
        return f29743a;
    }

    private static String i(Context context) {
        if (!b(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        TelephonyManager n10 = n(context);
        if (n10 == null) {
            return "";
        }
        String simOperatorName = n10.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? n10.getNetworkOperatorName() : simOperatorName;
    }

    private static int j(Context context) {
        ConnectivityManager k10;
        NetworkInfo activeNetworkInfo;
        if (context == null || !b(context, "android.permission.ACCESS_NETWORK_STATE") || (k10 = k(context)) == null || (activeNetworkInfo = k10.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static ConnectivityManager k(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static String l(Context context) {
        String g10 = g(context);
        return (g10 == null || g10.length() < 5) ? "" : g10.substring(3, 5);
    }

    private static int m(Context context) {
        TelephonyManager n10;
        if (b(context, "android.permission.READ_PHONE_STATE") && (n10 = n(context)) != null) {
            return n10.getNetworkType();
        }
        return -1;
    }

    private static TelephonyManager n(Context context) {
        return (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
    }
}
