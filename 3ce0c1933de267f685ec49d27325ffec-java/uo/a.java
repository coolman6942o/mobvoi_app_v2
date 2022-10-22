package uo;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.i;
/* compiled from: PlatformThreadLocalRandom.kt */
/* loaded from: classes3.dex */
public final class a extends to.a {
    @Override // to.a
    public Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        i.e(current, "ThreadLocalRandom.current()");
        return current;
    }

    @Override // kotlin.random.Random
    public double nextDouble(double d10) {
        return ThreadLocalRandom.current().nextDouble(d10);
    }

    @Override // kotlin.random.Random
    public int nextInt(int i10, int i11) {
        return ThreadLocalRandom.current().nextInt(i10, i11);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j10) {
        return ThreadLocalRandom.current().nextLong(j10);
    }

    @Override // kotlin.random.Random
    public long nextLong(long j10, long j11) {
        return ThreadLocalRandom.current().nextLong(j10, j11);
    }
}
