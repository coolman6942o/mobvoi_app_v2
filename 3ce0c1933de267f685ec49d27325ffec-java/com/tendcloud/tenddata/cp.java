package com.tendcloud.tenddata;

import android.os.SystemClock;
/* compiled from: td */
/* loaded from: classes2.dex */
public class cp extends ch {
    public cp() {
        a("bootTime", Long.valueOf(c()));
        a("activeTime", Long.valueOf(SystemClock.elapsedRealtime()));
        a("freeDiskSpace", Integer.valueOf(a()));
        a("batteryLevel", Integer.valueOf(j.c(ab.f22568h)));
        a("batteryState", Integer.valueOf(j.d(ab.f22568h)));
    }

    public static int a() {
        try {
            int[] s10 = j.s();
            if (s10 != null) {
                return s10[1];
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long c() {
        try {
            return System.currentTimeMillis() - SystemClock.elapsedRealtime();
        } catch (Throwable unused) {
            return -1L;
        }
    }
}
