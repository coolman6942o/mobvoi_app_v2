package com.google.common.util.concurrent;

import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
/* loaded from: classes.dex */
public class AtomicDouble extends Number {
    private static final long serialVersionUID = 0;
    private static final AtomicLongFieldUpdater<AtomicDouble> updater = AtomicLongFieldUpdater.newUpdater(AtomicDouble.class, HealthDataProviderContracts.NAME_VALUE);
    private volatile transient long value;

    public AtomicDouble(double d10) {
        this.value = Double.doubleToRawLongBits(d10);
    }

    public final double addAndGet(double d10) {
        long j10;
        double longBitsToDouble;
        do {
            j10 = this.value;
            longBitsToDouble = Double.longBitsToDouble(j10) + d10;
        } while (!updater.compareAndSet(this, j10, Double.doubleToRawLongBits(longBitsToDouble)));
        return longBitsToDouble;
    }

    public final boolean compareAndSet(double d10, double d11) {
        return updater.compareAndSet(this, Double.doubleToRawLongBits(d10), Double.doubleToRawLongBits(d11));
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return get();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) get();
    }

    public final double get() {
        return Double.longBitsToDouble(this.value);
    }

    public final double getAndAdd(double d10) {
        long j10;
        double longBitsToDouble;
        do {
            j10 = this.value;
            longBitsToDouble = Double.longBitsToDouble(j10);
        } while (!updater.compareAndSet(this, j10, Double.doubleToRawLongBits(longBitsToDouble + d10)));
        return longBitsToDouble;
    }

    public final double getAndSet(double d10) {
        return Double.longBitsToDouble(updater.getAndSet(this, Double.doubleToRawLongBits(d10)));
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) get();
    }

    public final void lazySet(double d10) {
        updater.lazySet(this, Double.doubleToRawLongBits(d10));
    }

    @Override // java.lang.Number
    public long longValue() {
        return (long) get();
    }

    public final void set(double d10) {
        this.value = Double.doubleToRawLongBits(d10);
    }

    public String toString() {
        return Double.toString(get());
    }

    public final boolean weakCompareAndSet(double d10, double d11) {
        return updater.weakCompareAndSet(this, Double.doubleToRawLongBits(d10), Double.doubleToRawLongBits(d11));
    }

    public AtomicDouble() {
    }
}
