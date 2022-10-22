package com.unionpay.utils;

import android.content.Context;
import android.content.SharedPreferences;
import java.security.MessageDigest;
/* loaded from: classes2.dex */
public class UPUtils {
    public static String a(Context context, String str) {
        String string = context.getSharedPreferences("UnionPayPluginEx.pref", 0).getString(str, "");
        String b10 = b(string, ("0000000023456789abcdef12123456786789abcd").substring(0, 32));
        return (b10 != null && b10.endsWith("00000000")) ? b10.substring(0, b10.length() - 8) : "";
    }

    public static String a(String str) {
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.reset();
            messageDigest.update(bytes);
            return a.a(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    private static String a(String str, String str2) {
        try {
            return a.a(d.a(a.a(str2), str.getBytes("utf-8")));
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str, String str2) {
        String substring = ("0000000023456789abcdef12123456786789abcd").substring(0, 32);
        String a10 = a(str + "00000000", substring);
        if (a10 == null) {
            a10 = "";
        }
        SharedPreferences.Editor edit = context.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
        edit.putString(str2, a10);
        edit.commit();
    }

    private static String b(String str, String str2) {
        try {
            return new String(d.b(a.a(str2), a.a(str)), "utf-8").trim();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void b(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("UnionPayPluginEx.pref", 0).edit();
        edit.remove(str);
        edit.commit();
    }

    public static native String forConfig(int i10, String str);

    public static native String forUrl(int i10);

    public static native String forWap(int i10, String str);

    public static native String getIssuer(int i10);

    public static native String getSubject(int i10);

    public static native String getTalkingDataIdForAssist(int i10);
}
