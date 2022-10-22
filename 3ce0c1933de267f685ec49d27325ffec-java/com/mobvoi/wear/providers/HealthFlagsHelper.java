package com.mobvoi.wear.providers;

import android.annotation.SuppressLint;
import android.content.Context;
import com.mobvoi.android.common.provider.a;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.util.AwUtils;
import com.mobvoi.wear.util.FeatureUtil;
import com.mobvoi.wear.util.WatchInfoUtils;
/* loaded from: classes2.dex */
public class HealthFlagsHelper {
    private static final boolean ENABLE_NETWORK_SYNC = true;
    private static final boolean ENABLE_TIC_CYCLE;
    public static final String FLAG_AUTO_MOTION = "auto_motion";
    public static final String FLAG_HR_WARNING = "hr_warning";
    public static final String FLAG_NETWORK_SYNC = "network_sync";
    public static final String FLAG_TIC_CYCLE = "tic_cycle";
    public static final String TABLE_FEATURE = "flags_feature";
    private static final String TAG = "HealthFlagsHelper";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile HealthFlagsHelper sInstance;
    private a infoClient;

    static {
        ENABLE_TIC_CYCLE = TicwatchModels.isSakura() && AwUtils.isAwLe(b.e());
    }

    private HealthFlagsHelper(Context context) {
        this.infoClient = new a(context, HealthSettingsProviderHelper.SETTINGS_PROVIDER_AUTH);
    }

    public static HealthFlagsHelper getInstance(Context context) {
        if (sInstance == null) {
            synchronized (HealthFlagsHelper.class) {
                if (sInstance == null) {
                    sInstance = new HealthFlagsHelper(context);
                }
            }
        }
        return sInstance;
    }

    private static boolean isAutoMotionAvailable() {
        return !WatchInfoUtils.isTicwearSystem();
    }

    public static boolean isFeatureAvailableDefault(String str) {
        str.hashCode();
        char c10 = 65535;
        switch (str.hashCode()) {
            case -1415582650:
                if (str.equals("auto_motion")) {
                    c10 = 0;
                    break;
                }
                break;
            case -416376331:
                if (str.equals("tic_cycle")) {
                    c10 = 1;
                    break;
                }
                break;
            case -19487220:
                if (str.equals(FLAG_NETWORK_SYNC)) {
                    c10 = 2;
                    break;
                }
                break;
            case 333756775:
                if (str.equals(FLAG_HR_WARNING)) {
                    c10 = 3;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                return isAutoMotionAvailable();
            case 1:
                return ENABLE_TIC_CYCLE;
            case 2:
                return true;
            case 3:
                return isHrWarningAvailable();
            default:
                k.s(TAG, "Flag %s not support, the feature maybe incomplete!", str);
                return false;
        }
    }

    public static boolean isFeatureEnabled(String str) {
        if (!FeatureUtil.isWatch(b.e())) {
            return true;
        }
        return getInstance(b.e()).infoClient.a(TABLE_FEATURE, str, isFeatureAvailableDefault(str));
    }

    public static boolean isHrWarningAvailable() {
        return !WatchInfoUtils.isTicwearSystem() && !TicwatchModels.isMooneye();
    }

    public static void setFeatureEnabled(String str, boolean z10) {
        if (z10 == isFeatureAvailableDefault(str)) {
            getInstance(b.e()).infoClient.q(TABLE_FEATURE, str);
        } else {
            getInstance(b.e()).infoClient.i(TABLE_FEATURE, str, z10);
        }
    }
}
