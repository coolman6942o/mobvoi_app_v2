package com.mobvoi.wear.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.common.base.TicwatchModels;
/* loaded from: classes2.dex */
public class FeatureUtil {
    private static final String BT_HEADSET_ACTION = "android.bluetooth.IBluetoothHeadsetClient";

    public static boolean isSupportHfp(Context context) {
        Intent intent = new Intent(BT_HEADSET_ACTION);
        PackageManager packageManager = context.getPackageManager();
        return packageManager.resolveService(intent, 0) != null && packageManager.hasSystemFeature("android.hardware.audio.output");
    }

    public static boolean isWatch(Context context) {
        return Build.VERSION.SDK_INT >= 20 && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
    }

    public static boolean supportGps(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.location.gps");
    }

    public static boolean supportMotionBiking(Context context) {
        return context.getPackageManager().hasSystemFeature(Constants.Feature.HARDWARE_MOTION_BIKING);
    }

    public static boolean supportMotionFastWalkV2(Context context) {
        return context.getPackageManager().hasSystemFeature(Constants.Feature.HARDWARE_MOTION_FAST_WALK_V2);
    }

    public static boolean supportMotionSwimming(Context context) {
        return context.getPackageManager().hasSystemFeature(Constants.Feature.HARDWARE_MOTION_SWIMMING);
    }

    public static boolean supportTelephony(Context context) {
        return context.getPackageManager().hasSystemFeature("android.hardware.telephony");
    }

    public static boolean supportWaterproof(Context context) {
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature(Constants.Feature.HARDWARE_SWIMMING_QUALIFIED);
        return !hasSystemFeature ? TicwatchModels.supportWaterproof(Build.MODEL) : hasSystemFeature;
    }
}
