package com.mobvoi.android.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
/* compiled from: PackageUtils.java */
/* loaded from: classes2.dex */
public class n {
    private static PackageInfo a(PackageManager packageManager, String str) {
        try {
            return packageManager.getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean b(Context context, String str) {
        return c(context.getPackageManager(), str);
    }

    public static boolean c(PackageManager packageManager, String str) {
        PackageInfo a10 = a(packageManager, str);
        return a10 != null && a10.applicationInfo.enabled;
    }
}
