package com.mobvoi.android.common.utils;

import android.content.Context;
/* compiled from: SharedPrefsUtils.java */
/* loaded from: classes2.dex */
public class q {
    public static boolean a(Context context, String str, String str2, boolean z10) {
        return context.getSharedPreferences(str, 0).getBoolean(str2, z10);
    }

    public static int b(Context context, String str, String str2, int i10) {
        return context.getSharedPreferences(str, 0).getInt(str2, i10);
    }

    public static long c(Context context, String str, String str2, long j10) {
        return context.getSharedPreferences(str, 0).getLong(str2, j10);
    }

    public static String d(Context context, String str, String str2, String str3) {
        return context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void e(Context context, String str, String str2, boolean z10) {
        context.getSharedPreferences(str, 0).edit().putBoolean(str2, z10).apply();
    }

    public static void f(Context context, String str, String str2, int i10) {
        context.getSharedPreferences(str, 0).edit().putInt(str2, i10).apply();
    }

    public static void g(Context context, String str, String str2, long j10) {
        context.getSharedPreferences(str, 0).edit().putLong(str2, j10).apply();
    }

    public static void h(Context context, String str, String str2, String str3) {
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }

    public static void i(Context context, String str, String str2) {
        context.getSharedPreferences(str, 0).edit().remove(str2).apply();
    }
}
