package com.google.common.util.concurrent;

import com.google.common.base.p;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;
/* loaded from: classes.dex */
public final class AtomicLongMap<K> implements Serializable {
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, Long> map;

    private AtomicLongMap(ConcurrentHashMap<K, Long> concurrentHashMap) {
        this.map = (ConcurrentHashMap) p.o(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    private Map<K, Long> i() {
        return Collections.unmodifiableMap(this.map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long l(AtomicLong atomicLong, LongUnaryOperator longUnaryOperator, Object obj, Long l10) {
        long longValue = l10 == null ? 0L : l10.longValue();
        atomicLong.set(longValue);
        return Long.valueOf(longUnaryOperator.applyAsLong(longValue));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ long m(long j10, long j11) {
        return j10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean n(Long l10) {
        return l10.longValue() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long o(LongUnaryOperator longUnaryOperator, Object obj, Long l10) {
        return Long.valueOf(longUnaryOperator.applyAsLong(l10 == null ? 0L : l10.longValue()));
    }

    public long accumulateAndGet(K k10, final long j10, final LongBinaryOperator longBinaryOperator) {
        p.o(longBinaryOperator);
        return updateAndGet(k10, new LongUnaryOperator() { // from class: com.google.common.util.concurrent.g
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j11) {
                long applyAsLong;
                applyAsLong = longBinaryOperator.applyAsLong(j11, j10);
                return applyAsLong;
            }
        });
    }

    public long addAndGet(K k10, long j10) {
        return accumulateAndGet(k10, j10, d.f12398a);
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Long> i10 = i();
        this.asMap = i10;
        return i10;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    public long decrementAndGet(K k10) {
        return addAndGet(k10, -1L);
    }

    public long get(K k10) {
        return this.map.getOrDefault(k10, 0L).longValue();
    }

    public long getAndAccumulate(K k10, final long j10, final LongBinaryOperator longBinaryOperator) {
        p.o(longBinaryOperator);
        return getAndUpdate(k10, new LongUnaryOperator() { // from class: com.google.common.util.concurrent.f
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j11) {
                long applyAsLong;
                applyAsLong = longBinaryOperator.applyAsLong(j11, j10);
                return applyAsLong;
            }
        });
    }

    public long getAndAdd(K k10, long j10) {
        return getAndAccumulate(k10, j10, d.f12398a);
    }

    public long getAndDecrement(K k10) {
        return getAndAdd(k10, -1L);
    }

    public long getAndIncrement(K k10) {
        return getAndAdd(k10, 1L);
    }

    public long getAndUpdate(K k10, final LongUnaryOperator longUnaryOperator) {
        p.o(longUnaryOperator);
        final AtomicLong atomicLong = new AtomicLong();
        this.map.compute(k10, new BiFunction() { // from class: com.google.common.util.concurrent.b
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Long l10;
                l10 = AtomicLongMap.l(atomicLong, longUnaryOperator, obj, (Long) obj2);
                return l10;
            }
        });
        return atomicLong.get();
    }

    public long incrementAndGet(K k10) {
        return addAndGet(k10, 1L);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    boolean p(K k10, long j10) {
        return this.map.remove(k10, Long.valueOf(j10));
    }

    public long put(K k10, final long j10) {
        return getAndUpdate(k10, new LongUnaryOperator() { // from class: com.google.common.util.concurrent.e
            @Override // java.util.function.LongUnaryOperator
            public final long applyAsLong(long j11) {
                long m10;
                m10 = AtomicLongMap.m(j10, j11);
                return m10;
            }
        });
    }

    public void putAll(Map<? extends K, ? extends Long> map) {
        map.forEach(new BiConsumer() { // from class: com.google.common.util.concurrent.a
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                AtomicLongMap.this.put(obj, ((Long) obj2).longValue());
            }
        });
    }

    public long remove(K k10) {
        Long remove = this.map.remove(k10);
        if (remove == null) {
            return 0L;
        }
        return remove.longValue();
    }

    public void removeAllZeros() {
        this.map.values().removeIf(h.f12404a);
    }

    public boolean removeIfZero(K k10) {
        return p(k10, 0L);
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        return this.map.values().stream().mapToLong(i.f12405a).sum();
    }

    public String toString() {
        return this.map.toString();
    }

    public long updateAndGet(K k10, final LongUnaryOperator longUnaryOperator) {
        p.o(longUnaryOperator);
        return this.map.compute(k10, new BiFunction() { // from class: com.google.common.util.concurrent.c
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                Long o10;
                o10 = AtomicLongMap.o(longUnaryOperator, obj, (Long) obj2);
                return o10;
            }
        }).longValue();
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> create = create();
        create.putAll(map);
        return create;
    }
}
