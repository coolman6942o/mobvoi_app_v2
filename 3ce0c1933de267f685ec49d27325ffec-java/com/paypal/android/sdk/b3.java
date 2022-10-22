package com.paypal.android.sdk;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class b3 {

    /* renamed from: a  reason: collision with root package name */
    private static List f21009a = Arrays.asList("AU", "BR", "CA", "ES", "FR", "GB", "IT", "MY", "SG", "US");

    /* renamed from: b  reason: collision with root package name */
    private static Pattern f21010b = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,} *$");

    /* renamed from: c  reason: collision with root package name */
    private static Pattern f21011c = Pattern.compile("^[0-9]{4,8}$");

    /* renamed from: d  reason: collision with root package name */
    private static Pattern f21012d = Pattern.compile("^\\+?[0-9]{7,14}$");

    /* renamed from: e  reason: collision with root package name */
    private static Pattern f21013e = Pattern.compile("[ .\\-\\(\\)]*");

    /* renamed from: f  reason: collision with root package name */
    private static Pattern f21014f = Pattern.compile("^\\+?0+$");

    /* renamed from: g  reason: collision with root package name */
    private static /* synthetic */ boolean f21015g = true;

    public static boolean a(String str) {
        if (f21015g || str != null) {
            return f21010b.matcher(str).matches();
        }
        throw new AssertionError();
    }

    public static boolean b(String str) {
        if (f21015g || str != null) {
            return f21011c.matcher(str).matches();
        }
        throw new AssertionError();
    }

    public static boolean c(String str) {
        return str.length() >= 8;
    }

    public static boolean d(String str) {
        if (f21015g || str != null) {
            String replaceAll = f21013e.matcher(str).replaceAll("");
            return f21012d.matcher(replaceAll).matches() && !f21014f.matcher(replaceAll).matches();
        }
        throw new AssertionError();
    }

    public static String e(String str) {
        return f21013e.matcher(str).replaceAll("");
    }

    public static boolean f(String str) {
        if (y1.i(str)) {
            return false;
        }
        return f21009a.contains(str.toUpperCase());
    }
}
