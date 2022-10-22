package com.google.common.collect;

import com.google.common.base.l;
import com.google.common.base.p;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Stream;
/* loaded from: classes.dex */
public class ImmutableSetMultimap<K, V> extends ImmutableMultimap<K, V> implements k7<K, V> {
    private static final long serialVersionUID = 0;
    private final transient ImmutableSet<V> emptySet;
    private transient ImmutableSet<Map.Entry<K, V>> entries;
    private transient ImmutableSetMultimap<V, K> inverse;

    /* loaded from: classes.dex */
    public static final class a<K, V> extends ImmutableMultimap.c<K, V> {
        @Override // com.google.common.collect.ImmutableMultimap.c
        Collection<V> c() {
            return s6.g();
        }

        public ImmutableSetMultimap<K, V> h() {
            Collection entrySet = this.f11779a.entrySet();
            Comparator<? super K> comparator = this.f11780b;
            if (comparator != null) {
                entrySet = q6.a(comparator).h().b(entrySet);
            }
            return ImmutableSetMultimap.B(entrySet, this.f11781c);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b<K, V> extends ImmutableSet<Map.Entry<K, V>> {
        private final transient ImmutableSetMultimap<K, V> multimap;

        b(ImmutableSetMultimap<K, V> immutableSetMultimap) {
            this.multimap = immutableSetMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.multimap.containsEntry(entry.getKey(), entry.getValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public p8<Map.Entry<K, V>> iterator() {
            return this.multimap.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSetMultimap(ImmutableMap<K, ImmutableSet<V>> immutableMap, int i10, Comparator<? super V> comparator) {
        super(immutableMap, i10);
        this.emptySet = A(comparator);
    }

    private static <V> ImmutableSet<V> A(Comparator<? super V> comparator) {
        if (comparator == null) {
            return ImmutableSet.of();
        }
        return ImmutableSortedSet.t(comparator);
    }

    static <K, V> ImmutableSetMultimap<K, V> B(Collection<? extends Map.Entry<? extends K, ? extends Collection<? extends V>>> collection, Comparator<? super V> comparator) {
        if (collection.isEmpty()) {
            return of();
        }
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i10 = 0;
        for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : collection) {
            K key = entry.getKey();
            ImmutableSet D = D(comparator, entry.getValue());
            if (!D.isEmpty()) {
                bVar.d(key, D);
                i10 += D.size();
            }
        }
        return new ImmutableSetMultimap<>(bVar.a(), i10, comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private ImmutableSetMultimap<V, K> C() {
        a builder = builder();
        p8 it = entries().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.d(entry.getValue(), entry.getKey());
        }
        ImmutableSetMultimap<V, K> h10 = builder.h();
        h10.inverse = this;
        return h10;
    }

    private static <V> ImmutableSet<V> D(Comparator<? super V> comparator, Collection<? extends V> collection) {
        if (comparator == null) {
            return ImmutableSet.copyOf((Collection) collection);
        }
        return ImmutableSortedSet.copyOf((Comparator) comparator, (Collection) collection);
    }

    public static <K, V> a<K, V> builder() {
        return new a<>();
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(b6<? extends K, ? extends V> b6Var) {
        return z(b6Var, null);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> flatteningToImmutableSetMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends Stream<? extends V>> function2) {
        return o2.t(function, function2);
    }

    public static <K, V> ImmutableSetMultimap<K, V> of() {
        return k3.INSTANCE;
    }

    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> toImmutableSetMultimap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return o2.W(function, function2);
    }

    private static <K, V> ImmutableSetMultimap<K, V> z(b6<? extends K, ? extends V> b6Var, Comparator<? super V> comparator) {
        p.o(b6Var);
        if (b6Var.isEmpty() && comparator == null) {
            return of();
        }
        if (b6Var instanceof ImmutableSetMultimap) {
            ImmutableSetMultimap<K, V> immutableSetMultimap = (ImmutableSetMultimap) b6Var;
            if (!immutableSetMultimap.t()) {
                return immutableSetMultimap;
            }
        }
        return B(b6Var.asMap().entrySet(), comparator);
    }

    public static <K, V> ImmutableSetMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new a().l(iterable).h();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v10) {
        a builder = builder();
        builder.d(k10, v10);
        return builder.h();
    }

    @Override // com.google.common.collect.ImmutableMultimap
    public ImmutableSetMultimap<V, K> inverse() {
        ImmutableSetMultimap<V, K> immutableSetMultimap = this.inverse;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<V, K> C = C();
        this.inverse = C;
        return C;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.o, com.google.common.collect.b6
    public ImmutableSet<Map.Entry<K, V>> entries() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entries;
        if (immutableSet != null) {
            return immutableSet;
        }
        b bVar = new b(this);
        this.entries = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.b6
    public ImmutableSet<V> get(K k10) {
        return (ImmutableSet) l.a((ImmutableSet) this.map.get(k10), this.emptySet);
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.b6
    @Deprecated
    public final ImmutableSet<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMultimap, com.google.common.collect.o
    @Deprecated
    public final ImmutableSet<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v10, K k11, V v11) {
        a builder = builder();
        builder.d(k10, v10);
        builder.d(k11, v11);
        return builder.h();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        a builder = builder();
        builder.d(k10, v10);
        builder.d(k11, v11);
        builder.d(k12, v12);
        return builder.h();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        a builder = builder();
        builder.d(k10, v10);
        builder.d(k11, v11);
        builder.d(k12, v12);
        builder.d(k13, v13);
        return builder.h();
    }

    public static <K, V> ImmutableSetMultimap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        a builder = builder();
        builder.d(k10, v10);
        builder.d(k11, v11);
        builder.d(k12, v12);
        builder.d(k13, v13);
        builder.d(k14, v14);
        return builder.h();
    }
}
