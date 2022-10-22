package ph;

import java.util.concurrent.TimeUnit;
/* compiled from: HealthDataUtils.java */
/* loaded from: classes2.dex */
public class a {
    public static int a(long j10) {
        return (int) Math.round((j10 * 1.0d) / TimeUnit.MINUTES.toMillis(1L));
    }

    public static int b(int i10) {
        return Math.round(i10 / 60.0f);
    }
}
