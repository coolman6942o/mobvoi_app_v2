package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import b6.o;
import com.mobvoi.wear.common.base.Constants;
import h6.i;
import h6.n;
import h6.p;
import h6.q;
import j6.c;
import java.util.concurrent.atomic.AtomicBoolean;
import z5.b;
/* loaded from: classes.dex */
public class e {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f8830a = 12451000;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f8831b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8832c = false;

    /* renamed from: d  reason: collision with root package name */
    static final AtomicBoolean f8833d = new AtomicBoolean();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f8834e = new AtomicBoolean();

    @Deprecated
    public static void a(Context context) {
        if (!f8833d.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(10436);
                }
            } catch (SecurityException unused) {
            }
        }
    }

    @Deprecated
    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static String c(int i10) {
        return ConnectionResult.L0(i10);
    }

    public static Context d(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources e(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean f(Context context) {
        try {
            if (!f8832c) {
                PackageInfo d10 = c.a(context).d("com.google.android.gms", 64);
                f.a(context);
                if (d10 == null || f.f(d10, false) || !f.f(d10, true)) {
                    f8831b = false;
                } else {
                    f8831b = true;
                }
            }
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e10);
        } finally {
            f8832c = true;
        }
        return f8831b || !i.b();
    }

    @Deprecated
    public static int g(Context context, int i10) {
        try {
            context.getResources().getString(b.f37287a);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f8834e.get()) {
            int b10 = o.b(context);
            if (b10 != 0) {
                int i11 = f8830a;
                if (b10 != i11) {
                    StringBuilder sb2 = new StringBuilder(320);
                    sb2.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    sb2.append(i11);
                    sb2.append(" but found ");
                    sb2.append(b10);
                    sb2.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                    throw new IllegalStateException(sb2.toString());
                }
            } else {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        return n(context, !i.d(context) && !i.e(context), i10);
    }

    @Deprecated
    public static boolean h(Context context, int i10) {
        return p.a(context, i10);
    }

    @Deprecated
    public static boolean i(Context context, int i10) {
        if (i10 == 18) {
            return true;
        }
        if (i10 == 1) {
            return k(context, "com.google.android.gms");
        }
        return false;
    }

    @TargetApi(18)
    public static boolean j(Context context) {
        Bundle applicationRestrictions;
        return n.d() && (applicationRestrictions = ((UserManager) context.getSystemService(Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER)).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public static boolean k(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (n.g()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        if (equals) {
            return applicationInfo.enabled;
        }
        return applicationInfo.enabled && !j(context);
    }

    @Deprecated
    public static boolean l(int i10) {
        return i10 == 1 || i10 == 2 || i10 == 3 || i10 == 9;
    }

    @TargetApi(19)
    @Deprecated
    public static boolean m(Context context, int i10, String str) {
        return p.b(context, i10, str);
    }

    private static int n(Context context, boolean z10, int i10) {
        b6.i.a(i10 >= 0);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z10) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            f.a(context);
            if (!f.f(packageInfo2, true)) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            } else if (z10 && (!f.f(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                return 9;
            } else if (q.a(packageInfo2.versionCode) < q.a(i10)) {
                int i11 = packageInfo2.versionCode;
                StringBuilder sb2 = new StringBuilder(77);
                sb2.append("Google Play services out of date.  Requires ");
                sb2.append(i10);
                sb2.append(" but found ");
                sb2.append(i11);
                Log.w("GooglePlayServicesUtil", sb2.toString());
                return 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e10) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e10);
                        return 1;
                    }
                }
                return !applicationInfo.enabled ? 3 : 0;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }
}
