package g9;

import android.content.Context;
import android.content.SharedPreferences;
/* compiled from: PreferencesUtils.java */
/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f27306a = "sp_pref";

    public static String a(Context context, String str) {
        return b(context, str, null);
    }

    public static String b(Context context, String str, String str2) {
        return context.getSharedPreferences(f27306a, 0).getString(str, str2);
    }

    public static boolean c(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(f27306a, 0).edit();
        edit.putString(str, str2);
        return edit.commit();
    }
}
