package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
/* compiled from: BackpressureUtils.java */
/* loaded from: classes3.dex */
public final class a {
    public static long a(long j10, long j11) {
        long j12 = j10 + j11;
        if (j12 < 0) {
            return Long.MAX_VALUE;
        }
        return j12;
    }

    public static long b(AtomicLong atomicLong, long j10) {
        long j11;
        do {
            j11 = atomicLong.get();
        } while (!atomicLong.compareAndSet(j11, a(j11, j10)));
        return j11;
    }

    public static long c(AtomicLong atomicLong, long j10) {
        long j11;
        long j12;
        do {
            j11 = atomicLong.get();
            if (j11 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j12 = j11 - j10;
            if (j12 < 0) {
                throw new IllegalStateException("More produced than requested: " + j12);
            }
        } while (!atomicLong.compareAndSet(j11, j12));
        return j12;
    }

    public static boolean d(long j10) {
        int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
        if (i10 >= 0) {
            return i10 != 0;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j10);
    }
}
