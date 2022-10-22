package com.mobvoi.assistant.account.data.sp;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
/* compiled from: SPHelperImpl.java */
/* loaded from: classes2.dex */
class a {

    /* renamed from: a  reason: collision with root package name */
    private static SoftReference<Map<String, Object>> f15646a;

    private static void a() {
        Map<String, Object> map;
        SoftReference<Map<String, Object>> softReference = f15646a;
        if (softReference != null && (map = softReference.get()) != null) {
            map.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        SharedPreferences.Editor edit = k(context).edit();
        edit.clear();
        edit.commit();
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Context context, String str) {
        SharedPreferences k10 = k(context);
        if (k10 == null) {
            return false;
        }
        return k10.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(Context context, String str, String str2) {
        Object g10 = g(str);
        if (g10 != null) {
            return g10 + "";
        }
        Object m10 = m(context, str, str2);
        p(str, m10);
        return m10 + "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, ?> e(Context context) {
        return k(context).getAll();
    }

    static boolean f(Context context, String str, boolean z10) {
        SharedPreferences k10 = k(context);
        return k10 == null ? z10 : k10.getBoolean(str, z10);
    }

    private static Object g(String str) {
        Map<String, Object> map;
        SoftReference<Map<String, Object>> softReference = f15646a;
        if (softReference == null || (map = softReference.get()) == null) {
            return null;
        }
        return map.get(str);
    }

    static float h(Context context, String str, float f10) {
        SharedPreferences k10 = k(context);
        return k10 == null ? f10 : k10.getFloat(str, f10);
    }

    static int i(Context context, String str, int i10) {
        SharedPreferences k10 = k(context);
        return k10 == null ? i10 : k10.getInt(str, i10);
    }

    static long j(Context context, String str, long j10) {
        SharedPreferences k10 = k(context);
        return k10 == null ? j10 : k10.getLong(str, j10);
    }

    private static SharedPreferences k(Context context) {
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences("SPHelper_sp_main", 0);
    }

    static String l(Context context, String str, String str2) {
        SharedPreferences k10 = k(context);
        return k10 == null ? str2 : k10.getString(str, str2);
    }

    private static Object m(Context context, String str, String str2) {
        if (!c(context, str)) {
            return null;
        }
        if (str2.equalsIgnoreCase("string")) {
            return l(context, str, null);
        }
        if (str2.equalsIgnoreCase("boolean")) {
            return Boolean.valueOf(f(context, str, false));
        }
        if (str2.equalsIgnoreCase("int")) {
            return Integer.valueOf(i(context, str, 0));
        }
        if (str2.equalsIgnoreCase("long")) {
            return Long.valueOf(j(context, str, 0L));
        }
        if (str2.equalsIgnoreCase("float")) {
            return Float.valueOf(h(context, str, 0.0f));
        }
        if (str2.equalsIgnoreCase("string_set")) {
            return l(context, str, null);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void n(Context context, String str) {
        SharedPreferences k10 = k(context);
        if (k10 != null) {
            SharedPreferences.Editor edit = k10.edit();
            edit.remove(str);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized <T> void o(Context context, String str, T t10) {
        synchronized (a.class) {
            SharedPreferences k10 = k(context);
            if (k10 != null) {
                if (!t10.equals(g(str))) {
                    SharedPreferences.Editor edit = k10.edit();
                    if (t10 instanceof Boolean) {
                        edit.putBoolean(str, ((Boolean) t10).booleanValue());
                    }
                    if (t10 instanceof String) {
                        edit.putString(str, (String) t10);
                    }
                    if (t10 instanceof Integer) {
                        edit.putInt(str, ((Integer) t10).intValue());
                    }
                    if (t10 instanceof Long) {
                        edit.putLong(str, ((Long) t10).longValue());
                    }
                    if (t10 instanceof Float) {
                        edit.putFloat(str, ((Float) t10).floatValue());
                    }
                    edit.commit();
                    p(str, t10);
                }
            }
        }
    }

    private static void p(String str, Object obj) {
        Map<String, Object> map;
        SoftReference<Map<String, Object>> softReference = f15646a;
        if (softReference == null) {
            map = new HashMap<>();
            f15646a = new SoftReference<>(map);
        } else {
            map = softReference.get();
            if (map == null) {
                map = new HashMap<>();
                f15646a = new SoftReference<>(map);
            }
        }
        map.put(str, obj);
    }
}
