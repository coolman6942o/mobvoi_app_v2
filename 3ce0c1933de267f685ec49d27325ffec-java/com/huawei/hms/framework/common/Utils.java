package com.huawei.hms.framework.common;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class Utils {
    public static long getCurrentTime(boolean z10) {
        return z10 ? SystemClock.elapsedRealtime() : System.currentTimeMillis();
    }
}
