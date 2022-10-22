package uk;

import android.content.Context;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.util.AwUtils;
/* compiled from: HealthSettingsProviderHelper.java */
/* loaded from: classes2.dex */
public final /* synthetic */ class b {
    public static boolean a(Context context) {
        return AwUtils.isAwLe(context) || TicwatchModels.isTicwatch();
    }

    public static boolean b(Context context) {
        return TicwatchModels.isTicwatch();
    }

    public static boolean c(Context context) {
        return false;
    }
}
