package com.laser.tsm.sdk.util;

import android.graphics.Color;
import android.util.Log;
/* loaded from: classes2.dex */
public class LogUtil {
    private static final String BOUNDARY = "==>";
    public static final int LEVEL_LOG_D = 2;
    public static final int LEVEL_LOG_E = 3;
    public static final int LEVEL_LOG_I = 1;
    public static final int LEVEL_LOG_V = 4;
    private static final String TAG = "leisenIface";
    public static boolean isDebug = true;
    public static LogCallBack mLogCallback;

    private LogUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void d(String str) {
        if (isDebug) {
            Log.d(TAG, BOUNDARY + str);
        }
        LogCallBack logCallBack = mLogCallback;
        if (logCallBack != null) {
            logCallBack.log(2, TAG, str);
        }
    }

    public static void e(String str) {
        if (isDebug) {
            Log.e(TAG, BOUNDARY + str);
        }
        LogCallBack logCallBack = mLogCallback;
        if (logCallBack != null) {
            logCallBack.log(3, TAG, str);
        }
    }

    public static int getLevelColor(int i10) {
        if (i10 == 1) {
            return Color.parseColor("#007F00");
        }
        if (i10 == 2) {
            return Color.parseColor("#00007F");
        }
        if (i10 == 3) {
            return Color.parseColor("#FF0000");
        }
        if (i10 != 4) {
            return 0;
        }
        return Color.parseColor("#00003A");
    }

    public static String getLevelDesc(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? "" : "V" : "E" : "D" : "I";
    }

    public static void i(String str) {
        if (isDebug) {
            Log.i(TAG, BOUNDARY + str);
        }
        LogCallBack logCallBack = mLogCallback;
        if (logCallBack != null) {
            logCallBack.log(1, TAG, str);
        }
    }

    public static void setLogNotifyCallback(LogCallBack logCallBack) {
        mLogCallback = logCallBack;
    }

    public static void v(String str) {
        if (isDebug) {
            Log.v(TAG, BOUNDARY + str);
        }
        LogCallBack logCallBack = mLogCallback;
        if (logCallBack != null) {
            logCallBack.log(4, TAG, str);
        }
    }

    public static void d(String str, String str2) {
        if (isDebug) {
            Log.d(str, BOUNDARY + str2);
        }
        LogCallBack logCallBack = mLogCallback;
        if (logCallBack != null) {
            logCallBack.log(2, str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (isDebug) {
            Log.e(str, BOUNDARY + str2);
        }
        LogCallBack logCallBack = mLogCallback;
        if (logCallBack != null) {
            logCallBack.log(3, str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (isDebug) {
            Log.i(str, BOUNDARY + str2);
        }
        LogCallBack logCallBack = mLogCallback;
        if (logCallBack != null) {
            logCallBack.log(1, str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (isDebug) {
            Log.v(str, BOUNDARY + str2);
        }
        LogCallBack logCallBack = mLogCallback;
        if (logCallBack != null) {
            logCallBack.log(4, str, str2);
        }
    }
}
