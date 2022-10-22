package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableSortedMapFauxverideShim.java */
/* loaded from: classes.dex */
public abstract class w4<K, V> extends ImmutableMap<K, V> {
    @Deprecated
    public static <K, V> ImmutableSortedMap.c<K, V> builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap.c<K, V> builderWithExpectedSize(int i10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        throw new UnsupportedOperationException();
    }
}
