package n4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* compiled from: DeviceInfo.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f31010a = "";

    private static TelephonyManager a(Context context) {
        return (TelephonyManager) context.getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE);
    }

    public static String b(Context context) {
        try {
            return j(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    private static boolean c(Context context, String str) {
        return context != null && context.checkCallingOrSelfPermission(str) == 0;
    }

    public static String d(Context context) {
        try {
            return m(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        try {
            return n(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static int f(Context context) {
        try {
            return k(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return -1;
        }
    }

    public static String g(Context context) {
        try {
            return i(context);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public static String h(Context context) {
        try {
            return i(context);
        } catch (Throwable th2) {
            c.b(th2, "DeviceInfo", "getSubscriberId");
            return "";
        }
    }

    private static String i(Context context) {
        String str = f31010a;
        if (str != null && !"".equals(str)) {
            return f31010a;
        }
        if (!c(context, "android.permission.READ_PHONE_STATE")) {
            return f31010a;
        }
        TelephonyManager a10 = a(context);
        if (a10 == null) {
            return "";
        }
        String subscriberId = a10.getSubscriberId();
        f31010a = subscriberId;
        if (subscriberId == null) {
            f31010a = "";
        }
        return f31010a;
    }

    private static String j(Context context) {
        if (!c(context, "android.permission.READ_PHONE_STATE")) {
            return null;
        }
        TelephonyManager a10 = a(context);
        if (a10 == null) {
            return "";
        }
        String simOperatorName = a10.getSimOperatorName();
        return TextUtils.isEmpty(simOperatorName) ? a10.getNetworkOperatorName() : simOperatorName;
    }

    private static int k(Context context) {
        ConnectivityManager l10;
        NetworkInfo activeNetworkInfo;
        if (context == null || !c(context, "android.permission.ACCESS_NETWORK_STATE") || (l10 = l(context)) == null || (activeNetworkInfo = l10.getActiveNetworkInfo()) == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }

    private static ConnectivityManager l(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    private static String m(Context context) {
        String h10 = h(context);
        return (h10 == null || h10.length() < 5) ? "" : h10.substring(3, 5);
    }

    private static int n(Context context) {
        TelephonyManager a10;
        if (c(context, "android.permission.READ_PHONE_STATE") && (a10 = a(context)) != null) {
            return a10.getNetworkType();
        }
        return -1;
    }
}
