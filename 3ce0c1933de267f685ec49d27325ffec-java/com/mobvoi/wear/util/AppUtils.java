package com.mobvoi.wear.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
/* loaded from: classes2.dex */
public class AppUtils {
    private static final int FLAG_PRIVILEGED;

    static {
        if (Build.VERSION.SDK_INT < 23) {
            FLAG_PRIVILEGED = 1073741824;
        } else {
            FLAG_PRIVILEGED = 8;
        }
    }

    public static ApplicationInfo getApplicationInfo(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static boolean isPrivateApp(Context context, String str) {
        ApplicationInfo applicationInfo = getApplicationInfo(context, str);
        if (applicationInfo != null) {
            return isPrivateApp(applicationInfo);
        }
        return false;
    }

    public static boolean isSystemApp(Context context, String str) {
        ApplicationInfo applicationInfo = getApplicationInfo(context, str);
        if (applicationInfo != null) {
            return isSystemApp(applicationInfo);
        }
        return false;
    }

    public static boolean isPrivateApp(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & FLAG_PRIVILEGED) != 0;
    }

    public static boolean isSystemApp(ApplicationInfo applicationInfo) {
        return (applicationInfo.flags & 1) != 0;
    }
}
