package com.huawei.hms.framework.common;

import java.util.Objects;
/* loaded from: classes.dex */
public class CheckParamUtils {
    private static final String TAG = "CheckParamUtils";

    public static <T> T checkNotNull(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }

    public static int checkNumParam(int i10, int i11, int i12, int i13, String str) {
        if (i10 > i12 || i10 < i11) {
            return i13;
        }
        Logger.d(TAG, str);
        return i10;
    }

    public static long checkNumParam(long j10, long j11, long j12, long j13, String str) {
        if (j10 > j12 || j10 < j11) {
            return j13;
        }
        Logger.d(TAG, str);
        return j10;
    }

    public static void checkOffsetAndCount(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
