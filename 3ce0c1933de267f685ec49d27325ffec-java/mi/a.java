package mi;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.e;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import pk.f;
/* compiled from: DevicePref.java */
/* loaded from: classes2.dex */
public final class a {
    public static f a() {
        String string = b().getString("ute_device", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (f) new e().j(string, f.class);
    }

    private static SharedPreferences b() {
        return b.e().getSharedPreferences("watch_lite", 0);
    }

    public static void c() {
        b().edit().putString("ute_device", null).apply();
    }

    public static void d(f fVar) {
        String s10 = new e().s(fVar);
        k.c("DevicePref", "saveCurrentDevice %s", s10);
        b().edit().putString("ute_device", s10).apply();
    }
}
