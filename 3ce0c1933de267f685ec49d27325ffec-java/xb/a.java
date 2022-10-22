package xb;

import android.content.SharedPreferences;
import com.mobvoi.companion.aw.base.App;
/* compiled from: CompanionPreferenceHelper.java */
/* loaded from: classes2.dex */
public class a {
    public static void a() {
        SharedPreferences.Editor edit = c().edit();
        edit.remove("companion_info");
        edit.remove("device_name");
        edit.remove("display_icon_type");
        edit.remove("room_list");
        edit.remove("zone_list");
        edit.remove("update_list");
        edit.remove("store_url");
        edit.apply();
    }

    public static boolean b() {
        return c().getBoolean("companion_info", true);
    }

    private static SharedPreferences c() {
        return App.d().getSharedPreferences("companion_info", 0);
    }

    public static void d(boolean z10) {
        c().edit().putBoolean("companion_info", z10).apply();
    }
}
