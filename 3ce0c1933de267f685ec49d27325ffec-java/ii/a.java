package ii;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.mobvoi.android.common.utils.b;
/* compiled from: TicLitePreferenceHelper.java */
/* loaded from: classes2.dex */
public class a {
    public static String a() {
        return c().getString("bin_id", "");
    }

    public static String b() {
        return c().getString("key_firebase_token", "");
    }

    private static SharedPreferences c() {
        return PreferenceManager.getDefaultSharedPreferences(b.e());
    }

    public static boolean d() {
        return c().getBoolean("upload_notification", false);
    }

    public static void e(String str) {
        c().edit().putString("bin_id", str).apply();
    }

    public static void f(String str) {
        c().edit().putString("key_firebase_token", str).apply();
    }
}
