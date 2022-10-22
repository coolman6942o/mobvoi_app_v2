package com.google.common.primitives;

import com.google.common.base.p;
import java.math.BigInteger;
/* loaded from: classes.dex */
public final class UnsignedLong extends Number implements Comparable<UnsignedLong> {
    private static final long UNSIGNED_MASK = Long.MAX_VALUE;
    private final long value;
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);

    private UnsignedLong(long j10) {
        this.value = j10;
    }

    public static UnsignedLong fromLongBits(long j10) {
        return new UnsignedLong(j10);
    }

    public static UnsignedLong valueOf(long j10) {
        p.h(j10 >= 0, "value (%s) is outside the range for an unsigned long value", j10);
        return fromLongBits(j10);
    }

    public BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & UNSIGNED_MASK);
        return this.value < 0 ? valueOf.setBit(63) : valueOf;
    }

    public UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(k.b(this.value, ((UnsignedLong) p.o(unsignedLong)).value));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        long j10 = this.value;
        double d10 = UNSIGNED_MASK & j10;
        return j10 < 0 ? d10 + 9.223372036854776E18d : d10;
    }

    public boolean equals(Object obj) {
        return (obj instanceof UnsignedLong) && this.value == ((UnsignedLong) obj).value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        long j10 = this.value;
        float f10 = (float) (UNSIGNED_MASK & j10);
        return j10 < 0 ? f10 + 9.223372E18f : f10;
    }

    public int hashCode() {
        return f.e(this.value);
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    public UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value - ((UnsignedLong) p.o(unsignedLong)).value);
    }

    public UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(k.e(this.value, ((UnsignedLong) p.o(unsignedLong)).value));
    }

    public UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value + ((UnsignedLong) p.o(unsignedLong)).value);
    }

    public UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.value * ((UnsignedLong) p.o(unsignedLong)).value);
    }

    public String toString() {
        return k.f(this.value);
    }

    public int compareTo(UnsignedLong unsignedLong) {
        p.o(unsignedLong);
        return k.a(this.value, unsignedLong.value);
    }

    public String toString(int i10) {
        return k.g(this.value, i10);
    }

    public static UnsignedLong valueOf(BigInteger bigInteger) {
        p.o(bigInteger);
        p.j(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    public static UnsignedLong valueOf(String str, int i10) {
        return fromLongBits(k.d(str, i10));
    }
}
