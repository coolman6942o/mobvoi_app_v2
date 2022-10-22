package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;
/* loaded from: classes.dex */
public class ImmutableListMultimap<K, V> extends ImmutableMultimap<K, V> implements q5<K, V> {
    private static final long serialVersionUID = 0;
    private transient ImmutableListMultimap<V, K> inverse;

    /* loaded from: classes.dex */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        public ImmutableListMultimap<K, V> h() {
            return (ImmutableListMultimap) super.a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a<K, V> i(ImmutableMultimap.c<K, V> cVar) {
            super.b(cVar);
            return this;
        }

        /* renamed from: j */
        public a<K, V> d(K k10, V v10) {
            super.d(k10, v10);
            return this;
        }

        /* renamed from: k */
        public a<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            super.e(entry);
            return this;
        }

        public a<K, V> l(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.f(iterable);
            return this;
        }

        /* renamed from: m */
        public a<K, V> g(K k10, Iterable<? extends V> iterable) {
            super.g(k10, iterable);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableListMultimap(ImmutableMap<K, ImmutableList<V>> immutableMap, int i10) {
        super(immutableMap, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableListMultimap<V, K> A() {
        a builder = builder();
        p8 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.d(entry.getValue(), entry.getKey());
        }
        ImmutableListMultimap<V, K> h10 = builder.h();
        h10.inverse = this;
        return h10;
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(b6<? extends K, ? extends V> b6Var) {
        if (b6Var.isEmpty()) {
            return of();
        }
        if (b6Var instanceof ImmutableListMultimap) {
            ImmutableListMultimap<K, V> immutableListMultimap = (ImmutableListMultimap) b6Var;
            if (!immutableListMultimap.t()) {
                return immutableListMultimap;
            }
        }
        return z(b6Var.asMap().entrySet(), null);
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> flatteningToImmutableListMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends Stream<? extends V>> function2) {
        return o2.s(function, function2);
    }

    public static <K, V> ImmutableListMultimap<K, V> of() {
        return j3.INSTANCE;
    }

    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> toImmutableListMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return o2.P(function, function2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableListMultimap<K, V> z(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        ImmutableList immutableList;
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i10 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            Collection<? extends V> value = entry.getValue();
            if (comparator == null) {
                immutableList = ImmutableList.copyOf((Collection) value);
            } else {
                immutableList = ImmutableList.sortedCopyOf(comparator, value);
            }
            if (!immutableList.isEmpty()) {
                bVar.d(key, immutableList);
                i10 += immutableList.size();
            }
        }
        return new ImmutableListMultimap<>(bVar.a(), i10);
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v10) {
        a builder = builder();
        builder.d(k10, v10);
        return builder.h();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableListMultimap<V, K> inverse() {
        ImmutableListMultimap<V, K> immutableListMultimap = this.inverse;
        if (immutableListMultimap != null) {
            return immutableListMultimap;
        }
        ImmutableListMultimap<V, K> A = A();
        this.inverse = A;
        return A;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.b6
    public ImmutableList<V> get(K k10) {
        ImmutableList<V> immutableList = (ImmutableList) this.map.get(k10);
        return immutableList == null ? ImmutableList.of() : immutableList;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.b6
    @Deprecated
    public final ImmutableList<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.o
    @Deprecated
    public final ImmutableList<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v10, K k11, V v11) {
        a builder = builder();
        builder.d(k10, v10);
        builder.d(k11, v11);
        return builder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().l(iterable).h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        a builder = builder();
        builder.d(k10, v10);
        builder.d(k11, v11);
        builder.d(k12, v12);
        return builder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        a builder = builder();
        builder.d(k10, v10);
        builder.d(k11, v11);
        builder.d(k12, v12);
        builder.d(k13, v13);
        return builder.h();
    }

    public static <K, V> ImmutableListMultimap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        a builder = builder();
        builder.d(k10, v10);
        builder.d(k11, v11);
        builder.d(k12, v12);
        builder.d(k13, v13);
        builder.d(k14, v14);
        return builder.h();
    }
}
