package com.mobvoi.wear.util;

import com.mobvoi.android.common.utils.k;
/* loaded from: classes2.dex */
public class LogUtils {
    private static final int MAX_LOG_TAG_LENGTH = 23;

    private LogUtils() {
    }

    public static void LOGD(String str, String str2) {
        k.a(str, str2);
    }

    public static void LOGE(String str, String str2) {
        k.d(str, str2);
    }

    public static void LOGI(String str, String str2) {
        k.h(str, str2);
    }

    public static void LOGW(String str, String str2) {
        k.q(str, str2);
    }

    public static String makeLogTag(String str) {
        return str.length() > 23 ? str.substring(0, 23) : str;
    }

    public static void LOGD(String str, String str2, Throwable th2) {
        k.b(str, str2, th2);
    }

    public static void LOGE(String str, String str2, Throwable th2) {
        k.e(str, str2, th2);
    }

    public static void LOGW(String str, String str2, Throwable th2) {
        k.r(str, str2, th2, new Object[0]);
    }
}
