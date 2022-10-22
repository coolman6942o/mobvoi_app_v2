package eg;

import android.content.Context;
import android.content.SharedPreferences;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.util.FeatureUtil;
import mf.a;
/* compiled from: CertificationUtils.java */
/* loaded from: classes2.dex */
public class d {
    public static boolean a(Context context) {
        if (FeatureUtil.isWatch(context) && e(context)) {
            return c(context);
        }
        return true;
    }

    private static SharedPreferences b(Context context) {
        return context.getSharedPreferences("certification_utils", 0);
    }

    public static boolean c(Context context) {
        return b(context).getBoolean("grant_auth_key", false);
    }

    public static void d(Context context) {
        k.c("CertificationUtils", "needGrantAuth %s, hasGrantAuth %s", Boolean.valueOf(e(context)), Boolean.valueOf(c(context)));
    }

    public static boolean e(Context context) {
        if (!FeatureUtil.isWatch(context)) {
            return false;
        }
        if (TicwatchModels.isRover4G() || TicwatchModels.isRover3X()) {
            return context.getResources().getBoolean(a.f30662a);
        }
        return false;
    }
}
