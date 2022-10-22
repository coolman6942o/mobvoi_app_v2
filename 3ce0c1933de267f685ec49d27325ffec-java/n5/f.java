package n5;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.SystemClock;
/* compiled from: LogTime.java */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final double f31037a;

    static {
        double d10 = 1.0d;
        if (Build.VERSION.SDK_INT >= 17) {
            d10 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f31037a = d10;
    }

    public static double a(long j10) {
        return (b() - j10) * f31037a;
    }

    @TargetApi(17)
    public static long b() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }
}
