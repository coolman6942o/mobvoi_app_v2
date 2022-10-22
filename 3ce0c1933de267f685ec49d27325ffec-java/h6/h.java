package h6;

import android.os.SystemClock;
/* loaded from: classes.dex */
public class h implements e {

    /* renamed from: a  reason: collision with root package name */
    private static final h f27737a = new h();

    private h() {
    }

    public static e d() {
        return f27737a;
    }

    @Override // h6.e
    public long a() {
        return System.nanoTime();
    }

    @Override // h6.e
    public long b() {
        return System.currentTimeMillis();
    }

    @Override // h6.e
    public long c() {
        return SystemClock.elapsedRealtime();
    }
}
