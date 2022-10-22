package rx;

import java.util.concurrent.TimeUnit;
import rx.internal.schedulers.e;
/* compiled from: Scheduler.java */
/* loaded from: classes3.dex */
public abstract class f {

    /* compiled from: Scheduler.java */
    /* loaded from: classes3.dex */
    public static abstract class a implements j {
        public long a() {
            return System.currentTimeMillis();
        }

        public abstract j b(yp.a aVar);

        public abstract j c(yp.a aVar, long j10, TimeUnit timeUnit);

        public j d(yp.a aVar, long j10, long j11, TimeUnit timeUnit) {
            return e.a(this, aVar, j10, j11, timeUnit, null);
        }
    }

    public abstract a a();

    public long b() {
        return System.currentTimeMillis();
    }
}
