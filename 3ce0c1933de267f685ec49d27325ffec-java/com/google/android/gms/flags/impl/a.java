package com.google.android.gms.flags.impl;

import android.content.SharedPreferences;
import android.util.Log;
/* loaded from: classes.dex */
public abstract class a<T> {

    /* renamed from: com.google.android.gms.flags.impl.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0113a extends a<Boolean> {
        public static Boolean a(SharedPreferences sharedPreferences, String str, Boolean bool) {
            try {
                return (Boolean) m6.a.a(new com.google.android.gms.flags.impl.c(sharedPreferences, str, bool));
            } catch (Exception e10) {
                String valueOf = String.valueOf(e10.getMessage());
                Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
                return bool;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a<Integer> {
        public static Integer a(SharedPreferences sharedPreferences, String str, Integer num) {
            try {
                return (Integer) m6.a.a(new com.google.android.gms.flags.impl.d(sharedPreferences, str, num));
            } catch (Exception e10) {
                String valueOf = String.valueOf(e10.getMessage());
                Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
                return num;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends a<Long> {
        public static Long a(SharedPreferences sharedPreferences, String str, Long l10) {
            try {
                return (Long) m6.a.a(new e(sharedPreferences, str, l10));
            } catch (Exception e10) {
                String valueOf = String.valueOf(e10.getMessage());
                Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
                return l10;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends a<String> {
        public static String a(SharedPreferences sharedPreferences, String str, String str2) {
            try {
                return (String) m6.a.a(new f(sharedPreferences, str, str2));
            } catch (Exception e10) {
                String valueOf = String.valueOf(e10.getMessage());
                Log.w("FlagDataUtils", valueOf.length() != 0 ? "Flag value not available, returning default: ".concat(valueOf) : new String("Flag value not available, returning default: "));
                return str2;
            }
        }
    }
}
