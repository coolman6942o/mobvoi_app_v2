package com.google.common.collect;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
/* compiled from: ImmutableBiMapFauxverideShim.java */
/* loaded from: classes.dex */
abstract class a4<K, V> extends ImmutableMap<K, V> {
    @Deprecated
    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        throw new UnsupportedOperationException();
    }
}
