package com.mobvoi.android.common.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: DeviceIdUtil.java */
@SuppressLint({"HardwareIds"})
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static int f15427a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static String f15428b;

    static String a(Context context) {
        String str;
        try {
            StringBuilder sb2 = new StringBuilder();
            String g10 = h.g(context);
            if ("02:00:00:00:00:00".equals(g10)) {
                sb2.append(h.c());
                sb2.append(h.f());
            } else {
                sb2.append(g10);
            }
            sb2.append(h.a(context));
            str = j(sb2.toString()).substring(0, 32);
        } catch (Exception e10) {
            k.e("DeviceIdUtil", "generatePhoneDeviceId failed", e10);
            str = "illegal_device_id";
        }
        k.c("DeviceIdUtil", "generatePhoneDeviceId: %s", str);
        return str;
    }

    static String b(Context context) {
        String str;
        String str2;
        String c10 = h.c();
        String b10 = h.b(context);
        String str3 = c10 + "#" + b10;
        if (h.d() <= 23) {
            str = h.f();
            str3 = str3 + "#" + str;
        } else {
            str = "";
        }
        try {
            str2 = f.l(str3).substring(0, 32);
        } catch (Exception e10) {
            k.e("DeviceIdUtil", "failed to generate device ID", e10);
            str2 = "illegal_device_id";
        }
        k.c("DeviceIdUtil", "generatePhoneDeviceIdV2, model=[%s], androidId=[%s], serial=[%s], deviceId=[%s]", c10, b10, str, str2);
        return str2;
    }

    private static String c(Context context) {
        return context.getSharedPreferences("com_mobvoi_devices_id", 0).getString("com_mobvoi_log_devices_id", "");
    }

    private static String d(Context context) {
        String string = Build.VERSION.SDK_INT < 23 ? Settings.System.getString(context.getContentResolver(), "com_mobvoi_log_devices_id") : null;
        return r.b(string) ? c(context) : string;
    }

    @SuppressLint({"MissingPermission"})
    public static String e(Context context) {
        if (!r.b(f15428b)) {
            return f15428b;
        }
        synchronized (e.class) {
            String d10 = d(context);
            if (r.b(d10)) {
                if (f15427a == 2) {
                    d10 = b(context);
                } else {
                    d10 = a(context);
                }
                if ("illegal_device_id".equals(d10)) {
                    return "illegal_device_id";
                }
                i(context, d10);
            }
            f15428b = d10;
            return d10;
        }
    }

    public static boolean f(String str) {
        return r.b(str) || "illegal_device_id".equals(str);
    }

    public static void g(int i10) {
        f15427a = i10;
        k.c("DeviceIdUtil", "initForPhone: %d", Integer.valueOf(i10));
    }

    private static void h(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com_mobvoi_devices_id", 0).edit();
        edit.putString("com_mobvoi_log_devices_id", str);
        edit.apply();
    }

    private static void i(Context context, String str) {
        h(context, str);
    }

    private static String j(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(str.getBytes("iso-8859-1"), 0, str.length());
        return f.d(messageDigest.digest(), false);
    }
}
