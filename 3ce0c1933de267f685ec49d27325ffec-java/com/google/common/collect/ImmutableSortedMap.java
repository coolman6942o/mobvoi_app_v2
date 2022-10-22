package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSortedMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public final class ImmutableSortedMap<K, V> extends w4<K, V> implements NavigableMap<K, V> {
    private static final long serialVersionUID = 0;
    private transient ImmutableSortedMap<K, V> descendingMap;
    private final transient g7<K> keySet;
    private final transient ImmutableList<V> valueList;
    private static final Comparator<Comparable> NATURAL_ORDER = q6.g();
    private static final ImmutableSortedMap<Comparable, Object> NATURAL_EMPTY_MAP = new ImmutableSortedMap<>(ImmutableSortedSet.t(q6.g()), ImmutableList.of());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Comparator<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Comparator f11803a;

        a(Comparator comparator) {
            this.f11803a = comparator;
        }

        /* renamed from: a */
        public int compare(Map.Entry<K, V> entry, Map.Entry<K, V> entry2) {
            return this.f11803a.compare(entry.getKey(), entry2.getKey());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends h4<K, V> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends z3<Map.Entry<K, V>> {
            a() {
            }

            @Override // com.google.common.collect.z3
            ImmutableCollection<Map.Entry<K, V>> l() {
                return b.this;
            }

            /* renamed from: m */
            public Map.Entry<K, V> get(int i10) {
                return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.keySet.asList().get(i10), ImmutableSortedMap.this.valueList.get(i10));
            }

            @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
            public Spliterator<Map.Entry<K, V>> spliterator() {
                return s2.c(size(), 1297, new IntFunction() { // from class: com.google.common.collect.v4
                    @Override // java.util.function.IntFunction
                    public final Object apply(int i10) {
                        return ImmutableSortedMap.b.a.this.get(i10);
                    }
                });
            }
        }

        b() {
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
            asList().forEach(consumer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> m() {
            return new a();
        }

        @Override // com.google.common.collect.h4
        ImmutableMap<K, V> r() {
            return ImmutableSortedMap.this;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return asList().spliterator();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public p8<Map.Entry<K, V>> iterator() {
            return asList().iterator();
        }
    }

    /* loaded from: classes.dex */
    public static class c<K, V> extends ImmutableMap.b<K, V> {

        /* renamed from: e  reason: collision with root package name */
        private final Comparator<? super K> f11804e;

        public c(Comparator<? super K> comparator) {
            this.f11804e = (Comparator) p.o(comparator);
        }

        /* renamed from: h */
        public ImmutableSortedMap<K, V> a() {
            int i10 = this.f11768c;
            if (i10 != 0) {
                return i10 != 1 ? ImmutableSortedMap.v(this.f11804e, false, this.f11767b, i10) : ImmutableSortedMap.x(this.f11804e, this.f11767b[0].getKey(), this.f11767b[0].getValue());
            }
            return ImmutableSortedMap.t(this.f11804e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: i */
        public c<K, V> b(ImmutableMap.b<K, V> bVar) {
            super.b(bVar);
            return this;
        }

        /* renamed from: j */
        public c<K, V> d(K k10, V v10) {
            super.d(k10, v10);
            return this;
        }

        /* renamed from: k */
        public c<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            super.e(entry);
            return this;
        }

        /* renamed from: l */
        public c<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.f(iterable);
            return this;
        }

        /* renamed from: m */
        public c<K, V> g(Map<? extends K, ? extends V> map) {
            super.g(map);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedMap(g7<K> g7Var, ImmutableList<V> immutableList) {
        this(g7Var, immutableList, null);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        return s(map, (q6) NATURAL_ORDER);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOfSorted(SortedMap<K, ? extends V> sortedMap) {
        Comparator<? super K> comparator = sortedMap.comparator();
        if (comparator == null) {
            comparator = NATURAL_ORDER;
        }
        if (sortedMap instanceof ImmutableSortedMap) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) sortedMap;
            if (!immutableSortedMap.l()) {
                return immutableSortedMap;
            }
        }
        return u(comparator, true, sortedMap.entrySet());
    }

    public static <K extends Comparable<?>, V> c<K, V> naturalOrder() {
        return new c<>(q6.g());
    }

    public static <K, V> ImmutableSortedMap<K, V> of() {
        return (ImmutableSortedMap<K, V>) NATURAL_EMPTY_MAP;
    }

    public static <K, V> c<K, V> orderedBy(Comparator<K> comparator) {
        return new c<>(comparator);
    }

    public static <K extends Comparable<?>, V> c<K, V> reverseOrder() {
        return new c<>(q6.g().j());
    }

    private static <K, V> ImmutableSortedMap<K, V> s(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z10;
        boolean z11 = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                z10 = comparator.equals(comparator2);
            } else if (comparator == NATURAL_ORDER) {
                z10 = true;
            }
            z11 = z10;
        }
        if (z11 && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.l()) {
                return immutableSortedMap;
            }
        }
        return u(comparator, z11, map.entrySet());
    }

    static <K, V> ImmutableSortedMap<K, V> t(Comparator<? super K> comparator) {
        if (q6.g().equals(comparator)) {
            return of();
        }
        return new ImmutableSortedMap<>(ImmutableSortedSet.t(comparator), ImmutableList.of());
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return o2.X(comparator, function, function2);
    }

    private static <K, V> ImmutableSortedMap<K, V> u(Comparator<? super K> comparator, boolean z10, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) h5.l(iterable, ImmutableMap.EMPTY_ENTRY_ARRAY);
        return v(comparator, z10, entryArr, entryArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> ImmutableSortedMap<K, V> v(Comparator<? super K> comparator, boolean z10, Map.Entry<K, V>[] entryArr, int i10) {
        if (i10 == 0) {
            return t(comparator);
        }
        if (i10 == 1) {
            return x(comparator, entryArr[0].getKey(), entryArr[0].getValue());
        }
        Object[] objArr = new Object[i10];
        Object[] objArr2 = new Object[i10];
        if (z10) {
            for (int i11 = 0; i11 < i10; i11++) {
                K key = entryArr[i11].getKey();
                V value = entryArr[i11].getValue();
                p2.a(key, value);
                objArr[i11] = key;
                objArr2[i11] = value;
            }
        } else {
            Arrays.sort(entryArr, 0, i10, new a(comparator));
            Object key2 = entryArr[0].getKey();
            objArr[0] = key2;
            objArr2[0] = entryArr[0].getValue();
            p2.a(objArr[0], objArr2[0]);
            int i12 = 1;
            while (i12 < i10) {
                Object key3 = entryArr[i12].getKey();
                V value2 = entryArr[i12].getValue();
                p2.a(key3, value2);
                objArr[i12] = key3;
                objArr2[i12] = value2;
                ImmutableMap.a(comparator.compare(key2, key3) != 0, "key", entryArr[i12 - 1], entryArr[i12]);
                i12++;
                key2 = key3;
            }
        }
        return new ImmutableSortedMap<>(new g7(new b7(objArr), comparator), new b7(objArr2));
    }

    private ImmutableSortedMap<K, V> w(int i10, int i11) {
        if (i10 == 0 && i11 == size()) {
            return this;
        }
        if (i10 == i11) {
            return t(comparator());
        }
        return new ImmutableSortedMap<>(this.keySet.B(i10, i11), this.valueList.subList(i10, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> ImmutableSortedMap<K, V> x(Comparator<? super K> comparator, K k10, V v10) {
        return new ImmutableSortedMap<>(new g7(ImmutableList.of(k10), (Comparator) p.o(comparator)), ImmutableList.of(v10));
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> y(Map.Entry<K, V>... entryArr) {
        return v(q6.g(), false, entryArr, entryArr.length);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k10) {
        return tailMap((ImmutableSortedMap<K, V>) k10, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k10) {
        return (K) w5.i(ceilingEntry(k10));
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        return keySet().comparator();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(0);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k10) {
        return headMap((ImmutableSortedMap<K, V>) k10, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k10) {
        return (K) w5.i(floorEntry(k10));
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        p.o(biConsumer);
        ImmutableList<K> asList = this.keySet.asList();
        for (int i10 = 0; i10 < size(); i10++) {
            biConsumer.accept((K) asList.get(i10), (V) this.valueList.get(i10));
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> g() {
        return isEmpty() ? ImmutableSet.of() : new b();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        int indexOf = this.keySet.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.valueList.get(indexOf);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> h() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k10) {
        return tailMap((ImmutableSortedMap<K, V>) k10, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k10) {
        return (K) w5.i(higherEntry(k10));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> i() {
        throw new AssertionError("should never be called");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean l() {
        return this.keySet.g() || this.valueList.g();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return entrySet().asList().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k10) {
        return headMap((ImmutableSortedMap<K, V>) k10, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k10) {
        return (K) w5.i(lowerEntry(k10));
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public int size() {
        return this.valueList.size();
    }

    ImmutableSortedMap(g7<K> g7Var, ImmutableList<V> immutableList, ImmutableSortedMap<K, V> immutableSortedMap) {
        this.keySet = g7Var;
        this.valueList = immutableList;
        this.descendingMap = immutableSortedMap;
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj) {
        return x(q6.g(), comparable, obj);
    }

    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> toImmutableSortedMap(Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        return o2.Y(comparator, function, function2, binaryOperator);
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.keySet.descendingSet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.descendingMap;
        if (immutableSortedMap != null) {
            return immutableSortedMap;
        }
        if (isEmpty()) {
            return t(q6.a(comparator()).j());
        }
        return new ImmutableSortedMap<>((g7) this.keySet.descendingSet(), this.valueList.reverse(), this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @Override // java.util.NavigableMap
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.keySet;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableCollection<V> values() {
        return this.valueList;
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return s(map, (Comparator) p.o(comparator));
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2) {
        return y(ImmutableMap.j(comparable, obj), ImmutableMap.j(comparable2, obj2));
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> headMap(K k10) {
        return headMap((ImmutableSortedMap<K, V>) k10, false);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.keySet;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> subMap(K k10, K k11) {
        return subMap((boolean) k10, true, (boolean) k11, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public ImmutableSortedMap<K, V> tailMap(K k10) {
        return tailMap((ImmutableSortedMap<K, V>) k10, true);
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return copyOf(iterable, (q6) NATURAL_ORDER);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3) {
        return y(ImmutableMap.j(comparable, obj), ImmutableMap.j(comparable2, obj2), ImmutableMap.j(comparable3, obj3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> headMap(K k10, boolean z10) {
        return w(0, this.keySet.C(p.o(k10), z10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
        p.o(k10);
        p.o(k11);
        p.k(comparator().compare(k10, k11) <= 0, "expected fromKey <= toKey but %s > %s", k10, k11);
        return headMap((ImmutableSortedMap<K, V>) k11, z11).tailMap((ImmutableSortedMap<K, V>) k10, z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableMap
    public ImmutableSortedMap<K, V> tailMap(K k10, boolean z10) {
        return w(this.keySet.D(p.o(k10), z10), size());
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4) {
        return y(ImmutableMap.j(comparable, obj), ImmutableMap.j(comparable2, obj2), ImmutableMap.j(comparable3, obj3), ImmutableMap.j(comparable4, obj4));
    }

    public static <K, V> ImmutableSortedMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return u((Comparator) p.o(comparator), false, iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <K::Ljava/lang/Comparable<-TK;>;V:Ljava/lang/Object;>(TK;TV;TK;TV;TK;TV;TK;TV;TK;TV;)Lcom/google/common/collect/ImmutableSortedMap<TK;TV;>; */
    public static ImmutableSortedMap of(Comparable comparable, Object obj, Comparable comparable2, Object obj2, Comparable comparable3, Object obj3, Comparable comparable4, Object obj4, Comparable comparable5, Object obj5) {
        return y(ImmutableMap.j(comparable, obj), ImmutableMap.j(comparable2, obj2), ImmutableMap.j(comparable3, obj3), ImmutableMap.j(comparable4, obj4), ImmutableMap.j(comparable5, obj5));
    }
}
