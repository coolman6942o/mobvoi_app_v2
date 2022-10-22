package com.mobvoi.wear.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.common.R;
import com.mobvoi.wear.info.SharedWearInfoHelper;
/* loaded from: classes2.dex */
public class AwUtils {
    private static final int ANDROID_BLUETOOTH_MODE = 1;
    private static final String BLUETOOTH_MODE = "bluetooth_mode";
    private static final String BLUETOOTH_MODE_URI = "content://com.google.android.wearable.settings/bluetooth_mode";
    private static final String FEATURE_CN_GOOGLE = "cn.google";
    private static final String FEATURE_SIDEWINDER = "com.google.sidewinder";
    private static final int IOS_BLUETOOTH_MODE = 2;
    public static final String RETAIL_MODE_CATEGORY = "com.google.android.clockwork.RETAIL";
    private static final String TAG = "AwUtils";
    public static final String TEST_MODE_ACTION = "com.google.android.clockwork.action.TEST_MODE";

    public static void disableAmbient(FragmentManager fragmentManager) {
        Fragment g02 = fragmentManager.g0("android.support.wearable.ambient.AmbientMode");
        if (g02 != null) {
            fragmentManager.l().r(g02).j();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x004f, code lost:
        if (r6 != null) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getPhoneDeviceType(Context context) {
        Cursor query = context.getContentResolver().query(Uri.parse(BLUETOOTH_MODE_URI), null, null, null, null);
        try {
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        while (!BLUETOOTH_MODE.equals(query.getString(0))) {
                            if (!query.moveToNext()) {
                            }
                        }
                        int i10 = query.getInt(1);
                        if (i10 != 1) {
                            return i10 != 2 ? 0 : 2;
                        }
                        return 1;
                    }
                } catch (Exception e10) {
                    e10.printStackTrace();
                    return 0;
                }
            }
        } finally {
            query.close();
        }
    }

    public static String getWearOsName(Context context) {
        return context.getString(R.string.android_wear_name);
    }

    public static boolean isAwLe(Context context) {
        PackageManager packageManager = context.getPackageManager();
        return packageManager.hasSystemFeature(FEATURE_CN_GOOGLE) || packageManager.hasSystemFeature(FEATURE_SIDEWINDER);
    }

    public static boolean isRetailMode(Context context) {
        if (WatchInfoUtils.isTicwearSystem()) {
            return false;
        }
        try {
            return context.getPackageManager().getComponentEnabledSetting(new ComponentName("com.google.android.apps.wearable.settings", "com.google.android.clockwork.settings.RetailStatusService")) == 1;
        } catch (Exception e10) {
            k.r(TAG, "No RetailStatusService?", e10, new Object[0]);
            return false;
        }
    }

    public static boolean isTestMode(Context context) {
        return SharedWearInfoHelper.getInstance(context).isTestMode();
    }

    public static void setTestMode(Context context, boolean z10) {
        SharedWearInfoHelper.getInstance(context).setTestMode(z10);
    }
}
