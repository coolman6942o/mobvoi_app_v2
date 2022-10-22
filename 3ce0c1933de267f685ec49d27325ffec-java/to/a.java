package to;

import kotlin.jvm.internal.i;
import kotlin.random.Random;
/* compiled from: PlatformRandom.kt */
/* loaded from: classes3.dex */
public abstract class a extends Random {
    public abstract java.util.Random a();

    @Override // kotlin.random.Random
    public int nextBits(int i10) {
        return d.f(a().nextInt(), i10);
    }

    @Override // kotlin.random.Random
    public boolean nextBoolean() {
        return a().nextBoolean();
    }

    @Override // kotlin.random.Random
    public byte[] nextBytes(byte[] array) {
        i.f(array, "array");
        a().nextBytes(array);
        return array;
    }

    @Override // kotlin.random.Random
    public double nextDouble() {
        return a().nextDouble();
    }

    @Override // kotlin.random.Random
    public float nextFloat() {
        return a().nextFloat();
    }

    @Override // kotlin.random.Random
    public int nextInt() {
        return a().nextInt();
    }

    @Override // kotlin.random.Random
    public long nextLong() {
        return a().nextLong();
    }

    @Override // kotlin.random.Random
    public int nextInt(int i10) {
        return a().nextInt(i10);
    }
}
