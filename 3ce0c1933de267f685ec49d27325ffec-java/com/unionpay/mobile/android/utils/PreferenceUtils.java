package com.unionpay.mobile.android.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class PreferenceUtils {
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        if (com.unionpay.mobile.android.utils.c.a(r3) != false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
        r2 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0027, code lost:
        if (com.unionpay.mobile.android.utils.c.a(r3) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UnionPayPluginEx_v2.pref", 0);
        String str = "";
        String string = sharedPreferences.getString("uid", str);
        String string2 = sharedPreferences.getString("tag1", str);
        if (TextUtils.isEmpty(string)) {
            return !TextUtils.isEmpty(string2) ? a(string2) : str;
        }
        if (string.length() != 32) {
            string = a(string);
            if (string.length() == 32) {
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.remove("uid");
            edit.commit();
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            a(context, str, "tag1");
            return str;
        }
    }

    public static String a(Context context, String str) {
        return a(context.getSharedPreferences("UnionPayPluginEx_v2.pref", 0).getString(str, ""));
    }

    private static String a(String str) {
        String b10 = b(str, ("6972c2be8559884c23456789abcdef12123456786789abcd").substring(0, 32));
        return (b10 != null && b10.endsWith("6972c2be8559884c")) ? b10.substring(0, b10.length() - 16) : "";
    }

    private static String a(String str, String str2) {
        try {
            return b.a(e.a(b.a(str2), str.getBytes("utf-8")));
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str, String str2) {
        String substring = ("6972c2be8559884c23456789abcdef12123456786789abcd").substring(0, 32);
        String a10 = a(str + "6972c2be8559884c", substring);
        if (a10 == null) {
            a10 = "";
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("UnionPayPluginEx_v2.pref", 0).edit();
        edit.putString(str2, a10);
        edit.commit();
    }

    public static String b(Context context) {
        return b(context, "last_pay_method", "tag2");
    }

    private static String b(Context context, String str, String str2) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("UnionPayPluginEx_v2.pref", 0);
        String string = sharedPreferences.getString(str, "");
        String string2 = sharedPreferences.getString(str2, "");
        if (TextUtils.isEmpty(string)) {
            return !TextUtils.isEmpty(string2) ? a(string2) : "";
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.remove(str);
        edit.commit();
        return "";
    }

    private static String b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new String(e.b(b.a(str2), b.a(str)), "utf-8").trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void b(Context context, String str) {
        a(context, str, "tag1");
    }

    public static String c(Context context) {
        return b(context, "last_user", "tag3");
    }

    public static void c(Context context, String str) {
        a(context, str, "tag2");
    }

    public static void d(Context context, String str) {
        a(context, str, "tag3");
    }

    public static native String decPrefData(String str, String str2);

    public static native String forConfig(int i10, String str);
}
