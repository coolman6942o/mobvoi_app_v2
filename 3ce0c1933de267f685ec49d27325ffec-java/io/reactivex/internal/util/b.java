package io.reactivex.internal.util;

import fo.a;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: BackpressureHelper.java */
/* loaded from: classes3.dex */
public final class b {
    public static long a(AtomicLong atomicLong, long j10) {
        long j11;
        do {
            j11 = atomicLong.get();
            if (j11 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j11, b(j11, j10)));
        return j11;
    }

    public static long b(long j10, long j11) {
        long j12 = j10 + j11;
        if (j12 < 0) {
            return Long.MAX_VALUE;
        }
        return j12;
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
                a.s(new IllegalStateException("More produced than requested: " + j12));
                j12 = 0L;
            }
        } while (!atomicLong.compareAndSet(j11, j12));
        return j12;
    }
}
