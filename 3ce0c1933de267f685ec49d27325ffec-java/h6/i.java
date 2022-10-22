package h6;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import com.mobvoi.wear.common.base.Constants;
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f27738a;

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f27739b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f27740c;

    @TargetApi(21)
    public static boolean a(Context context) {
        if (f27739b == null) {
            f27739b = Boolean.valueOf(n.g() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f27739b.booleanValue();
    }

    public static boolean b() {
        return Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_USER.equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean c(Context context) {
        if (f27738a == null) {
            f27738a = Boolean.valueOf(n.f() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f27738a.booleanValue();
    }

    @TargetApi(26)
    public static boolean d(Context context) {
        if (!c(context)) {
            return false;
        }
        if (n.h()) {
            return a(context) && !n.i();
        }
        return true;
    }

    public static boolean e(Context context) {
        if (f27740c == null) {
            f27740c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f27740c.booleanValue();
    }
}
