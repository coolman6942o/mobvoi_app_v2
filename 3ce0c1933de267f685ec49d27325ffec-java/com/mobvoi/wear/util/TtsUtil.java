package com.mobvoi.wear.util;

import android.content.Context;
import android.text.TextUtils;
/* loaded from: classes2.dex */
public class TtsUtil {
    private static final String[] IPHONE7_MODELS = {"iPhone9,1", "iPhone9,2", "iPhone9,3", "iPhone9,4"};
    private static final String TAG = "TtsUtil";

    public static boolean isSupportDevice(Context context, String str) {
        if (!WatchInfoUtils.isTicwearSystem() || !WatchInfoUtils.isIosPaired(context)) {
            return true;
        }
        for (String str2 : IPHONE7_MODELS) {
            if (TextUtils.equals(str2, str)) {
                return false;
            }
        }
        return true;
    }
}
