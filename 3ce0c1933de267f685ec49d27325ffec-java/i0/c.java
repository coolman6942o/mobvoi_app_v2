package i0;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* compiled from: ICUCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static Method f27987a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f27988b;

    static {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 21) {
            try {
                Class<?> cls = Class.forName("libcore.icu.ICU");
                f27987a = cls.getMethod("getScript", String.class);
                f27988b = cls.getMethod("addLikelySubtags", String.class);
            } catch (Exception e10) {
                f27987a = null;
                f27988b = null;
                Log.w("ICUCompat", e10);
            }
        } else if (i10 < 24) {
            try {
                f27988b = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e11) {
                throw new IllegalStateException(e11);
            }
        }
    }

    private static String a(Locale locale) {
        String locale2 = locale.toString();
        try {
            Method method = f27988b;
            if (method != null) {
                return (String) method.invoke(null, locale2);
            }
        } catch (IllegalAccessException e10) {
            Log.w("ICUCompat", e10);
        } catch (InvocationTargetException e11) {
            Log.w("ICUCompat", e11);
        }
        return locale2;
    }

    private static String b(String str) {
        try {
            Method method = f27987a;
            if (method != null) {
                return (String) method.invoke(null, str);
            }
        } catch (IllegalAccessException e10) {
            Log.w("ICUCompat", e10);
        } catch (InvocationTargetException e11) {
            Log.w("ICUCompat", e11);
        }
        return null;
    }

    public static String c(Locale locale) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            return ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        }
        if (i10 >= 21) {
            try {
                return ((Locale) f27988b.invoke(null, locale)).getScript();
            } catch (IllegalAccessException e10) {
                Log.w("ICUCompat", e10);
                return locale.getScript();
            } catch (InvocationTargetException e11) {
                Log.w("ICUCompat", e11);
                return locale.getScript();
            }
        } else {
            String a10 = a(locale);
            if (a10 != null) {
                return b(a10);
            }
            return null;
        }
    }
}
