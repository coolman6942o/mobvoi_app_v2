package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
/* compiled from: AppOpsManagerCompat.java */
/* loaded from: classes.dex */
public final class d {

    /* compiled from: AppOpsManagerCompat.java */
    /* loaded from: classes.dex */
    static class a {
        static int a(AppOpsManager appOpsManager, String str, int i10, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i10, str2);
        }

        static String b(Context context) {
            return context.getOpPackageName();
        }

        static AppOpsManager c(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    public static int a(Context context, int i10, String str, String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return b(context, str, str2);
        }
        AppOpsManager c10 = a.c(context);
        int a10 = a.a(c10, str, Binder.getCallingUid(), str2);
        return a10 != 0 ? a10 : a.a(c10, str, i10, a.b(context));
    }

    public static int b(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(str, str2);
        }
        return 1;
    }

    public static String c(String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return AppOpsManager.permissionToOp(str);
        }
        return null;
    }
}
