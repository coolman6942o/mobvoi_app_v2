package yd;

import android.content.SharedPreferences;
import com.mobvoi.android.common.utils.b;
/* compiled from: CompanionPreferenceHelper.java */
/* loaded from: classes2.dex */
public class c {
    public static void a() {
        SharedPreferences.Editor edit = b().edit();
        edit.remove("companion_info");
        edit.remove("device_name");
        edit.remove("display_icon_type");
        edit.remove("room_list");
        edit.remove("zone_list");
        edit.remove("update_list");
        edit.remove("store_url");
        edit.apply();
    }

    private static SharedPreferences b() {
        return b.e().getSharedPreferences("companion_info", 0);
    }

    public static boolean c() {
        return b().getBoolean("develop_server", false);
    }

    public static void d(boolean z10) {
        b().edit().putBoolean("develop_server", z10).apply();
    }
}
