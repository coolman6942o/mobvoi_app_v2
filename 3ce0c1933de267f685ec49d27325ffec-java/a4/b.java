package a4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.alipay.sdk.util.e;
/* loaded from: classes.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f83b;

    /* renamed from: a  reason: collision with root package name */
    public String f84a;

    public b(Context context) {
        try {
            try {
                String macAddress = ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
                this.f84a = macAddress;
                if (!TextUtils.isEmpty(macAddress)) {
                    return;
                }
            } catch (Exception e10) {
                d.d(e10);
                if (!TextUtils.isEmpty(this.f84a)) {
                    return;
                }
            }
            this.f84a = "00:00:00:00:00:00";
        } catch (Throwable th2) {
            if (TextUtils.isEmpty(this.f84a)) {
                this.f84a = "00:00:00:00:00:00";
            }
            throw th2;
        }
    }

    public static b a(Context context) {
        if (f83b == null) {
            f83b = new b(context);
        }
        return f83b;
    }

    public static String d(Context context) {
        if (context == null) {
            return "";
        }
        try {
            return context.getResources().getConfiguration().locale.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static e e(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 0) {
                return e.a(activeNetworkInfo.getSubtype());
            }
            if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
                return e.NONE;
            }
            return e.WIFI;
        } catch (Exception unused) {
            return e.NONE;
        }
    }

    public String b() {
        return "000000000000000";
    }

    public String c() {
        return "000000000000000";
    }

    public String f() {
        return this.f84a;
    }
}
