package com.unionpay.mobile.android.utils;

import android.util.Log;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static int f24152a = Integer.MAX_VALUE;

    private static int a(int i10, String str, String str2) {
        if (!(str == null || str2 == null)) {
            if (i10 == 2) {
                return Log.v(str, str2);
            }
            if (i10 == 3) {
                return Log.d(str, str2);
            }
            if (i10 == 4) {
                return Log.i(str, str2);
            }
            if (i10 == 5) {
                return Log.w(str, str2);
            }
            if (i10 == 6) {
                return Log.e(str, str2);
            }
        }
        return 0;
    }

    public static int a(String str, String str2) {
        if (f24152a > 3) {
            return 0;
        }
        a(3, str, str2);
        return 0;
    }

    public static int b(String str, String str2) {
        if (f24152a > 4) {
            return 0;
        }
        a(4, str, str2);
        return 0;
    }

    public static int c(String str, String str2) {
        if (f24152a <= 6) {
            return a(6, str, str2);
        }
        return 0;
    }
}
