package com.mobvoi.android.common.utils;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
/* compiled from: ApplicationUtils.java */
/* loaded from: classes2.dex */
public class b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private static Application f15415a;

    /* renamed from: b  reason: collision with root package name */
    private static Handler f15416b;

    /* renamed from: c  reason: collision with root package name */
    private static String f15417c;

    /* renamed from: d  reason: collision with root package name */
    private static int f15418d;

    /* renamed from: e  reason: collision with root package name */
    private static String f15419e;

    public static int a() {
        o.e(f15415a);
        return b(f15415a);
    }

    public static int b(Context context) {
        if (TextUtils.isEmpty(f15417c)) {
            m(context);
        }
        return f15418d;
    }

    public static String c() {
        o.e(f15415a);
        return d(f15415a);
    }

    public static String d(Context context) {
        if (TextUtils.isEmpty(f15417c)) {
            m(context);
        }
        return f15417c;
    }

    public static Application e() {
        o.e(f15415a);
        return f15415a;
    }

    public static String f(Context context) {
        if (!TextUtils.isEmpty(f15419e)) {
            return f15419e;
        }
        String packageName = context.getPackageName();
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "";
        }
        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ActivityManager.RunningAppProcessInfo next = it.next();
            if (next.pid == myPid) {
                packageName = next.processName;
                break;
            }
        }
        f15419e = packageName;
        return packageName;
    }

    public static String g(String str) {
        int i10;
        int lastIndexOf = str.lastIndexOf(58);
        return (lastIndexOf <= 0 || (i10 = lastIndexOf + 1) >= str.length()) ? "" : str.substring(i10);
    }

    public static File h(String str) {
        File externalFilesDir = f15415a.getExternalFilesDir(str);
        if (externalFilesDir == null) {
            externalFilesDir = f15415a.getFilesDir();
        }
        return externalFilesDir == null ? f15415a.getCacheDir() : externalFilesDir;
    }

    public static Handler i() {
        o.e(f15416b);
        return f15416b;
    }

    public static File j() {
        return h("log");
    }

    public static void k(Application application) {
        f15415a = application;
        f15416b = new Handler();
    }

    public static boolean l(String str) {
        return TextUtils.isEmpty(g(str));
    }

    private static void m(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            f15417c = packageInfo.versionName;
            f15418d = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            k.d("ApplicationUtils", "cannot find out myself");
        }
    }
}
