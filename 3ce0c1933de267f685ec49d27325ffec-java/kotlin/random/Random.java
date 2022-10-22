package kotlin.random;

import com.mobvoi.wear.info.IntentInfo;
import java.io.Serializable;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import lo.b;
import to.c;
import to.d;
/* compiled from: Random.kt */
/* loaded from: classes3.dex */
public abstract class Random {
    public static final Default Default = new Default(null);
    private static final Random defaultRandom = b.f30564a.b();

    /* compiled from: Random.kt */
    /* loaded from: classes3.dex */
    public static final class Default extends Random implements Serializable {
        private Default() {
        }

        @Override // kotlin.random.Random
        public int nextBits(int i10) {
            return Random.defaultRandom.nextBits(i10);
        }

        @Override // kotlin.random.Random
        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array) {
            i.f(array, "array");
            return Random.defaultRandom.nextBytes(array);
        }

        @Override // kotlin.random.Random
        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        @Override // kotlin.random.Random
        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        @Override // kotlin.random.Random
        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        @Override // kotlin.random.Random
        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        public /* synthetic */ Default(f fVar) {
            this();
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(int i10) {
            return Random.defaultRandom.nextBytes(i10);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d10) {
            return Random.defaultRandom.nextDouble(d10);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i10) {
            return Random.defaultRandom.nextInt(i10);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j10) {
            return Random.defaultRandom.nextLong(j10);
        }

        @Override // kotlin.random.Random
        public byte[] nextBytes(byte[] array, int i10, int i11) {
            i.f(array, "array");
            return Random.defaultRandom.nextBytes(array, i10, i11);
        }

        @Override // kotlin.random.Random
        public double nextDouble(double d10, double d11) {
            return Random.defaultRandom.nextDouble(d10, d11);
        }

        @Override // kotlin.random.Random
        public int nextInt(int i10, int i11) {
            return Random.defaultRandom.nextInt(i10, i11);
        }

        @Override // kotlin.random.Random
        public long nextLong(long j10, long j11) {
            return Random.defaultRandom.nextLong(j10, j11);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 2) != 0) {
                i10 = 0;
            }
            if ((i12 & 4) != 0) {
                i11 = bArr.length;
            }
            return random.nextBytes(bArr, i10, i11);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i10);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public byte[] nextBytes(byte[] array, int i10, int i11) {
        boolean z10;
        i.f(array, "array");
        int length = array.length;
        boolean z11 = true;
        if (i10 >= 0 && length >= i10) {
            int length2 = array.length;
            if (i11 >= 0 && length2 >= i11) {
                z10 = true;
                if (!z10) {
                    if (i10 > i11) {
                        z11 = false;
                    }
                    if (z11) {
                        int i12 = (i11 - i10) / 4;
                        for (int i13 = 0; i13 < i12; i13++) {
                            int nextInt = nextInt();
                            array[i10] = (byte) nextInt;
                            array[i10 + 1] = (byte) (nextInt >>> 8);
                            array[i10 + 2] = (byte) (nextInt >>> 16);
                            array[i10 + 3] = (byte) (nextInt >>> 24);
                            i10 += 4;
                        }
                        int i14 = i11 - i10;
                        int nextBits = nextBits(i14 * 8);
                        for (int i15 = 0; i15 < i14; i15++) {
                            array[i10 + i15] = (byte) (nextBits >>> (i15 * 8));
                        }
                        return array;
                    }
                    throw new IllegalArgumentException(("fromIndex (" + i10 + ") must be not greater than toIndex (" + i11 + ").").toString());
                }
                throw new IllegalArgumentException(("fromIndex (" + i10 + ") or toIndex (" + i11 + ") are out of range: 0.." + array.length + '.').toString());
            }
        }
        z10 = false;
        if (!z10) {
        }
    }

    public double nextDouble() {
        return c.a(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return nextBits(24) / ((float) IntentInfo.FLAG_RECEIVER_INCLUDE_BACKGROUND);
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (nextInt() << 32) + nextInt();
    }

    public double nextDouble(double d10) {
        return nextDouble(0.0d, d10);
    }

    public int nextInt(int i10) {
        return nextInt(0, i10);
    }

    public long nextLong(long j10) {
        return nextLong(0L, j10);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public double nextDouble(double d10, double d11) {
        double d12;
        d.b(d10, d11);
        double d13 = d11 - d10;
        if (Double.isInfinite(d13)) {
            boolean z10 = true;
            if (!Double.isInfinite(d10) && !Double.isNaN(d10)) {
                if (Double.isInfinite(d11) || Double.isNaN(d11)) {
                    z10 = false;
                }
                if (z10) {
                    double d14 = 2;
                    double nextDouble = nextDouble() * ((d11 / d14) - (d10 / d14));
                    d12 = d10 + nextDouble + nextDouble;
                    return d12 < d11 ? Math.nextAfter(d11, Double.NEGATIVE_INFINITY) : d12;
                }
            }
        }
        d12 = d10 + (nextDouble() * d13);
        if (d12 < d11) {
        }
    }

    public int nextInt(int i10, int i11) {
        int i12;
        int nextInt;
        int i13;
        d.c(i10, i11);
        int i14 = i11 - i10;
        if (i14 > 0 || i14 == Integer.MIN_VALUE) {
            if (((-i14) & i14) == i14) {
                i12 = nextBits(d.e(i14));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i13 = nextInt % i14;
                } while ((nextInt - i13) + (i14 - 1) < 0);
                i12 = i13;
            }
            return i10 + i12;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i10 <= nextInt2 && i11 > nextInt2) {
                return nextInt2;
            }
        }
    }

    public long nextLong(long j10, long j11) {
        long j12;
        long nextLong;
        long j13;
        int nextInt;
        d.d(j10, j11);
        long j14 = j11 - j10;
        if (j14 > 0) {
            if (((-j14) & j14) == j14) {
                int i10 = (int) j14;
                int i11 = (int) (j14 >>> 32);
                if (i10 != 0) {
                    nextInt = nextBits(d.e(i10));
                } else if (i11 == 1) {
                    nextInt = nextInt();
                } else {
                    j12 = (nextBits(d.e(i11)) << 32) + nextInt();
                }
                j12 = nextInt & 4294967295L;
            } else {
                do {
                    nextLong = nextLong() >>> 1;
                    j13 = nextLong % j14;
                } while ((nextLong - j13) + (j14 - 1) < 0);
                j12 = j13;
            }
            return j10 + j12;
        }
        while (true) {
            long nextLong2 = nextLong();
            if (j10 <= nextLong2 && j11 > nextLong2) {
                return nextLong2;
            }
        }
    }

    public byte[] nextBytes(byte[] array) {
        i.f(array, "array");
        return nextBytes(array, 0, array.length);
    }

    public byte[] nextBytes(int i10) {
        return nextBytes(new byte[i10]);
    }
}
