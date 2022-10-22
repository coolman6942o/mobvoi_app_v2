package yd;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.R;
/* compiled from: ApplicationUtil.java */
/* loaded from: classes2.dex */
public class b {
    public static String a(Context context) {
        try {
            PackageManager packageManager = context.getApplicationContext().getPackageManager();
            return (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        } catch (PackageManager.NameNotFoundException e10) {
            k.a("ApplicationUtil", e10.getMessage());
            return "";
        }
    }

    public static String b() {
        try {
            Application e10 = com.mobvoi.android.common.utils.b.e();
            return String.valueOf(e10.getPackageManager().getPackageInfo(e10.getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException e11) {
            Log.d("ApplicationUtil", "Error when get version code.", e11);
            return null;
        }
    }

    public static boolean c(Context context) {
        if (context != null) {
            return context.getResources().getBoolean(R.bool.is_oversea);
        }
        return false;
    }
}
