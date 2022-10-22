package a4;

import android.content.Context;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import s3.e;
import y3.a;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static String f86a;

    public static String a(Context context) {
        String str;
        if (TextUtils.isEmpty(f86a)) {
            try {
                str = context.getApplicationContext().getPackageName();
            } catch (Throwable th2) {
                d.d(th2);
                str = "";
            }
            f86a = (str + "0000000000000000000000000000").substring(0, 24);
        }
        return f86a;
    }

    public static synchronized String b(a aVar, Context context, String str, String str2) {
        String str3;
        synchronized (f.class) {
            str3 = null;
            try {
                String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
                if (!TextUtils.isEmpty(string)) {
                    str3 = e.a(a(context), string, str);
                }
                if (!TextUtils.isEmpty(string) && TextUtils.isEmpty(str3)) {
                    p3.a.h(aVar, "cp", "TriDesEncryptError", String.format("%s,%s", str, string));
                }
            } catch (Exception e10) {
                d.d(e10);
            }
        }
        return str3;
    }

    public static synchronized void c(a aVar, Context context, String str, String str2) {
        synchronized (f.class) {
            try {
                String c10 = e.c(a(context), str2, str);
                if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(c10)) {
                    p3.a.h(aVar, "cp", "TriDesDecryptError", String.format("%s,%s", str, str2));
                }
                PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, c10).apply();
            } catch (Throwable th2) {
                d.d(th2);
            }
        }
    }
}
