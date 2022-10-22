package eg;

import android.content.Context;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.mobvoi.wear.util.FeatureUtil;
import com.mobvoi.wear.util.WatchInfoUtils;
/* compiled from: PermissionUtils.java */
/* loaded from: classes2.dex */
public class g {
    public static boolean a(Context context) {
        if (!FeatureUtil.supportTelephony(context) || WatchInfoUtils.isGlobalVersion(context)) {
            return true;
        }
        return ((Boolean) h.a(context, "health_common_pref").b("cmiit_perm_grant", Boolean.TRUE)).booleanValue();
    }

    public static boolean b(Context context) {
        return SharedWearInfoHelper.getInstance(context).isGdprDataEnabled(SharedWearInfoHelper.GdprInfo.KEY_DATA_SYNC);
    }
}
