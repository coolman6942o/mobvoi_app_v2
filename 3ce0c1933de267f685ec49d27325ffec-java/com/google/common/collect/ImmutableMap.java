package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableCollection;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.Spliterator;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] EMPTY_ENTRY_ARRAY = new Map.Entry[0];
    private transient ImmutableSet<Map.Entry<K, V>> entrySet;
    private transient ImmutableSet<K> keySet;
    private transient ImmutableSetMultimap<K, V> multimapView;
    private transient ImmutableCollection<V> values;

    /* loaded from: classes.dex */
    class a extends p8<K> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p8 f11765a;

        a(ImmutableMap immutableMap, p8 p8Var) {
            this.f11765a = p8Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11765a.hasNext();
        }

        @Override // java.util.Iterator
        public K next() {
            return (K) ((Map.Entry) this.f11765a.next()).getKey();
        }
    }

    /* loaded from: classes.dex */
    public static class b<K, V> {

        /* renamed from: a  reason: collision with root package name */
        Comparator<? super V> f11766a;

        /* renamed from: b  reason: collision with root package name */
        Map.Entry<K, V>[] f11767b;

        /* renamed from: c  reason: collision with root package name */
        int f11768c;

        /* renamed from: d  reason: collision with root package name */
        boolean f11769d;

        public b() {
            this(4);
        }

        private void c(int i10) {
            Map.Entry<K, V>[] entryArr = this.f11767b;
            if (i10 > entryArr.length) {
                this.f11767b = (Map.Entry[]) Arrays.copyOf(entryArr, ImmutableCollection.a.d(entryArr.length, i10));
                this.f11769d = false;
            }
        }

        public ImmutableMap<K, V> a() {
            if (this.f11766a != null) {
                if (this.f11769d) {
                    this.f11767b = (Map.Entry[]) Arrays.copyOf(this.f11767b, this.f11768c);
                }
                Arrays.sort(this.f11767b, 0, this.f11768c, q6.a(this.f11766a).i(w5.u()));
            }
            int i10 = this.f11768c;
            if (i10 == 0) {
                return ImmutableMap.of();
            }
            if (i10 == 1) {
                return ImmutableMap.of((Object) this.f11767b[0].getKey(), (Object) this.f11767b[0].getValue());
            }
            this.f11769d = true;
            return c7.q(i10, this.f11767b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b<K, V> b(b<K, V> bVar) {
            p.o(bVar);
            c(this.f11768c + bVar.f11768c);
            System.arraycopy(bVar.f11767b, 0, this.f11767b, this.f11768c, bVar.f11768c);
            this.f11768c += bVar.f11768c;
            return this;
        }

        public b<K, V> d(K k10, V v10) {
            c(this.f11768c + 1);
            Map.Entry<K, V> j10 = ImmutableMap.j(k10, v10);
            Map.Entry<K, V>[] entryArr = this.f11767b;
            int i10 = this.f11768c;
            this.f11768c = i10 + 1;
            entryArr[i10] = j10;
            return this;
        }

        public b<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            return d(entry.getKey(), entry.getValue());
        }

        public b<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                c(this.f11768c + ((Collection) iterable).size());
            }
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                e(entry);
            }
            return this;
        }

        public b<K, V> g(Map<? extends K, ? extends V> map) {
            return f(map.entrySet());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i10) {
            this.f11767b = new Map.Entry[i10];
            this.f11768c = 0;
            this.f11769d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c<K, V> extends ImmutableMap<K, V> {

        /* loaded from: classes.dex */
        class a extends h4<K, V> {
            a() {
            }

            @Override // com.google.common.collect.h4
            ImmutableMap<K, V> r() {
                return c.this;
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public p8<Map.Entry<K, V>> iterator() {
                return c.this.o();
            }
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return ImmutableMap.super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<K, V>> g() {
            return new a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public ImmutableSet<K> h() {
            return new j4(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableCollection<V> i() {
            return new m4(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return ImmutableMap.super.keySet();
        }

        abstract p8<Map.Entry<K, V>> o();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Collection values() {
            return ImmutableMap.super.values();
        }
    }

    /* loaded from: classes.dex */
    private final class d extends c<K, ImmutableSet<V>> {

        /* loaded from: classes.dex */
        class a extends p8<Map.Entry<K, ImmutableSet<V>>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Iterator f11770a;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: com.google.common.collect.ImmutableMap$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class C0141a extends n<K, ImmutableSet<V>> {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Map.Entry f11771a;

                C0141a(a aVar, Map.Entry entry) {
                    this.f11771a = entry;
                }

                /* renamed from: g */
                public ImmutableSet<V> getValue() {
                    return ImmutableSet.of(this.f11771a.getValue());
                }

                @Override // com.google.common.collect.n, java.util.Map.Entry
                public K getKey() {
                    return (K) this.f11771a.getKey();
                }
            }

            a(d dVar, Iterator it) {
                this.f11770a = it;
            }

            /* renamed from: a */
            public Map.Entry<K, ImmutableSet<V>> next() {
                return new C0141a(this, (Map.Entry) this.f11770a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f11770a.hasNext();
            }
        }

        private d() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.c, com.google.common.collect.ImmutableMap
        public ImmutableSet<K> h() {
            return ImmutableMap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean k() {
            return ImmutableMap.this.k();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean l() {
            return ImmutableMap.this.l();
        }

        @Override // com.google.common.collect.ImmutableMap.c
        p8<Map.Entry<K, ImmutableSet<V>>> o() {
            return new a(this, ImmutableMap.this.entrySet().iterator());
        }

        /* renamed from: p */
        public ImmutableSet<V> get(Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.of(obj2);
        }

        @Override // java.util.Map
        public int size() {
            return ImmutableMap.this.size();
        }

        /* synthetic */ d(ImmutableMap immutableMap, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z10, String str, Map.Entry<?, ?> entry, Map.Entry<?, ?> entry2) {
        if (!z10) {
            throw b(str, entry, entry2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IllegalArgumentException b(String str, Object obj, Object obj2) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 34 + valueOf.length() + valueOf2.length());
        sb2.append("Multiple entries with same ");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(valueOf);
        sb2.append(" and ");
        sb2.append(valueOf2);
        return new IllegalArgumentException(sb2.toString());
    }

    public static <K, V> b<K, V> builder() {
        return new b<>();
    }

    public static <K, V> b<K, V> builderWithExpectedSize(int i10) {
        p2.b(i10, "expectedSize");
        return new b<>(i10);
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.l()) {
                return immutableMap;
            }
        } else if (map instanceof EnumMap) {
            return d((EnumMap) map);
        }
        return copyOf(map.entrySet());
    }

    private static <K extends Enum<K>, V> ImmutableMap<K, V> d(EnumMap<K, ? extends V> enumMap) {
        EnumMap enumMap2 = new EnumMap((EnumMap) enumMap);
        for (Map.Entry<K, V> entry : enumMap2.entrySet()) {
            p2.a(entry.getKey(), entry.getValue());
        }
        return c4.p(enumMap2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Map.Entry<K, V> j(K k10, V v10) {
        p2.a(k10, v10);
        return new AbstractMap.SimpleImmutableEntry(k10, v10);
    }

    public static <K, V> ImmutableMap<K, V> of() {
        return (ImmutableMap<K, V>) c7.EMPTY;
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2) {
        return o2.Q(function, function2);
    }

    public ImmutableSetMultimap<K, V> asMultimap() {
        if (isEmpty()) {
            return ImmutableSetMultimap.of();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.multimapView;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new d(this, null), size(), null);
        this.multimapView = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V compute(K k10, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfAbsent(K k10, Function<? super K, ? extends V> function) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V computeIfPresent(K k10, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return w5.d(this, obj);
    }

    abstract ImmutableSet<Map.Entry<K, V>> g();

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v10) {
        V v11 = get(obj);
        return v11 != null ? v11 : v10;
    }

    abstract ImmutableSet<K> h();

    @Override // java.util.Map
    public int hashCode() {
        return l7.b(entrySet());
    }

    abstract ImmutableCollection<V> i();

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean k() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean l();

    /* JADX INFO: Access modifiers changed from: package-private */
    public p8<K> m() {
        return new a(this, entrySet().iterator());
    }

    @Override // java.util.Map
    @Deprecated
    public final V merge(K k10, V v10, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Spliterator<K> n() {
        return s2.e(entrySet().spliterator(), f4.f11982a);
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V putIfAbsent(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean replace(K k10, V v10, V v11) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return w5.r(this);
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10) {
        return ImmutableBiMap.of((Object) k10, (Object) v10);
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        return o2.R(function, function2, binaryOperator);
    }

    @Override // java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> g10 = g();
        this.entrySet = g10;
        return g10;
    }

    @Override // java.util.Map
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.keySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> h10 = h();
        this.keySet = h10;
        return h10;
    }

    @Override // java.util.Map
    @Deprecated
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V replace(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.values;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> i10 = i();
        this.values = i10;
        return i10;
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11) {
        return c7.p(j(k10, v10), j(k11, v11));
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        return c7.p(j(k10, v10), j(k11, v11), j(k12, v12));
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        return c7.p(j(k10, v10), j(k11, v11), j(k12, v12), j(k13, v13));
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) h5.l(iterable, EMPTY_ENTRY_ARRAY);
        int length = entryArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return c7.p(entryArr);
        }
        Map.Entry entry = entryArr[0];
        return of(entry.getKey(), entry.getValue());
    }

    public static <K, V> ImmutableMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return c7.p(j(k10, v10), j(k11, v11), j(k12, v12), j(k13, v13), j(k14, v14));
    }
}
