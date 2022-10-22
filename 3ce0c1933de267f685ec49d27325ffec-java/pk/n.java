package pk;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.gson.e;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
/* compiled from: DevicePref.java */
/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static final String f32811a = "n";

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f32812b = "";

    public static f a() {
        String string = c().getString("ute_device", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (f) new e().j(string, f.class);
    }

    public static String b() {
        f a10;
        if (TextUtils.isEmpty(f32812b) && (a10 = a()) != null) {
            f32812b = a10.a();
        }
        String str = f32811a;
        k.h(str, " getCurrentDevice currentDeviceId = " + f32812b);
        return f32812b;
    }

    private static SharedPreferences c() {
        return b.e().getSharedPreferences("young_watch", 0);
    }

    public static void d(f fVar) {
        c().edit().putString("ute_device", new e().s(fVar)).apply();
    }
}
