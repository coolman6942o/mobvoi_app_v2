package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.j6;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
/* loaded from: classes.dex */
public abstract class ImmutableMultimap<K, V> extends d0<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final transient ImmutableMap<K, ? extends ImmutableCollection<V>> map;
    final transient int size;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends p8<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        final Iterator<? extends Map.Entry<K, ? extends ImmutableCollection<V>>> f11772a;

        /* renamed from: b  reason: collision with root package name */
        K f11773b = null;

        /* renamed from: c  reason: collision with root package name */
        Iterator<V> f11774c = j5.h();

        a() {
            this.f11772a = ImmutableMultimap.this.map.entrySet().iterator();
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            if (!this.f11774c.hasNext()) {
                Map.Entry<K, ? extends ImmutableCollection<V>> next = this.f11772a.next();
                this.f11773b = next.getKey();
                this.f11774c = next.getValue().iterator();
            }
            return w5.e(this.f11773b, this.f11774c.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11774c.hasNext() || this.f11772a.hasNext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends p8<V> {

        /* renamed from: a  reason: collision with root package name */
        Iterator<? extends ImmutableCollection<V>> f11776a;

        /* renamed from: b  reason: collision with root package name */
        Iterator<V> f11777b = j5.h();

        b() {
            this.f11776a = ImmutableMultimap.this.map.values().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f11777b.hasNext() || this.f11776a.hasNext();
        }

        @Override // java.util.Iterator
        public V next() {
            if (!this.f11777b.hasNext()) {
                this.f11777b = this.f11776a.next().iterator();
            }
            return this.f11777b.next();
        }
    }

    /* loaded from: classes.dex */
    public static class c<K, V> {

        /* renamed from: a  reason: collision with root package name */
        Map<K, Collection<V>> f11779a = s6.h();

        /* renamed from: b  reason: collision with root package name */
        Comparator<? super K> f11780b;

        /* renamed from: c  reason: collision with root package name */
        Comparator<? super V> f11781c;

        public ImmutableMultimap<K, V> a() {
            Collection entrySet = this.f11779a.entrySet();
            Comparator<? super K> comparator = this.f11780b;
            if (comparator != null) {
                entrySet = q6.a(comparator).h().b(entrySet);
            }
            return ImmutableListMultimap.z(entrySet, this.f11781c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            for (Map.Entry<K, Collection<V>> entry : cVar.f11779a.entrySet()) {
                g(entry.getKey(), entry.getValue());
            }
            return this;
        }

        Collection<V> c() {
            return new ArrayList();
        }

        public c<K, V> d(K k10, V v10) {
            p2.a(k10, v10);
            Collection<V> collection = this.f11779a.get(k10);
            if (collection == null) {
                Map<K, Collection<V>> map = this.f11779a;
                Collection<V> c10 = c();
                map.put(k10, c10);
                collection = c10;
            }
            collection.add(v10);
            return this;
        }

        public c<K, V> e(Map.Entry<? extends K, ? extends V> entry) {
            return d(entry.getKey(), entry.getValue());
        }

        public c<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            for (Map.Entry<? extends K, ? extends V> entry : iterable) {
                e(entry);
            }
            return this;
        }

        public c<K, V> g(K k10, Iterable<? extends V> iterable) {
            if (k10 == null) {
                String valueOf = String.valueOf(h5.m(iterable));
                throw new NullPointerException(valueOf.length() != 0 ? "null key in entry: null=".concat(valueOf) : new String("null key in entry: null="));
            }
            Collection<V> collection = this.f11779a.get(k10);
            if (collection != null) {
                for (V v10 : iterable) {
                    p2.a(k10, v10);
                    collection.add(v10);
                }
                return this;
            }
            Iterator<? extends V> it = iterable.iterator();
            if (!it.hasNext()) {
                return this;
            }
            Collection<V> c10 = c();
            while (it.hasNext()) {
                V next = it.next();
                p2.a(k10, next);
                c10.add(next);
            }
            this.f11779a.put(k10, c10);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;
        final ImmutableMultimap<K, V> multimap;

        d(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
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
            return this.multimap.t();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public p8<Map.Entry<K, V>> iterator() {
            return this.multimap.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends ImmutableMultiset<K> {
        e() {
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
        public int count(Object obj) {
            ImmutableCollection<V> immutableCollection = ImmutableMultimap.this.map.get(obj);
            if (immutableCollection == null) {
                return 0;
            }
            return immutableCollection.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableMultiset
        j6.a<K> l(int i10) {
            Map.Entry<K, ? extends ImmutableCollection<V>> entry = ImmutableMultimap.this.map.entrySet().asList().get(i10);
            return m6.g(entry.getKey(), entry.getValue().size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
        public ImmutableSet<K> elementSet() {
            return ImmutableMultimap.this.keySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class f<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;
        private final transient ImmutableMultimap<K, V> multimap;

        f(ImmutableMultimap<K, V> immutableMultimap) {
            this.multimap = immutableMultimap;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int a(Object[] objArr, int i10) {
            p8<? extends ImmutableCollection<V>> it = this.multimap.map.values().iterator();
            while (it.hasNext()) {
                i10 = it.next().a(objArr, i10);
            }
            return i10;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.multimap.containsValue(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.multimap.size();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public p8<V> iterator() {
            return this.multimap.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableMultimap(ImmutableMap<K, ? extends ImmutableCollection<V>> immutableMap, int i10) {
        this.map = immutableMap;
        this.size = i10;
    }

    public static <K, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(b6<? extends K, ? extends V> b6Var) {
        if (b6Var instanceof ImmutableMultimap) {
            ImmutableMultimap<K, V> immutableMultimap = (ImmutableMultimap) b6Var;
            if (!immutableMultimap.t()) {
                return immutableMultimap;
            }
        }
        return ImmutableListMultimap.copyOf((b6) b6Var);
    }

    public static <K, V> ImmutableMultimap<K, V> of() {
        return ImmutableListMultimap.of();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator v(Map.Entry entry) {
        final Object key = entry.getKey();
        return s2.e(((Collection) entry.getValue()).spliterator(), new Function() { // from class: com.google.common.collect.p4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Map.Entry e10;
                e10 = w5.e(key, obj);
                return e10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(final BiConsumer biConsumer, final Object obj, Collection collection) {
        collection.forEach(new Consumer() { // from class: com.google.common.collect.o4
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                biConsumer.accept(obj, obj2);
            }
        });
    }

    @Override // com.google.common.collect.o
    Map<K, Collection<V>> a() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.o
    Set<K> c() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.b6
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.b6
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.o
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        p.o(biConsumer);
        asMap().forEach(new BiConsumer() { // from class: com.google.common.collect.n4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableMultimap.x(biConsumer, obj, (Collection) obj2);
            }
        });
    }

    @Override // com.google.common.collect.b6
    public abstract ImmutableCollection<V> get(K k10);

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.o
    Spliterator<Map.Entry<K, V>> i() {
        return s2.b(asMap().entrySet().spliterator(), q4.f12153a, (this instanceof k7 ? 1 : 0) | 64, size());
    }

    public abstract ImmutableMultimap<V, K> inverse();

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public ImmutableCollection<Map.Entry<K, V>> b() {
        return new d(this);
    }

    @Override // com.google.common.collect.o
    @Deprecated
    public boolean put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.o
    @Deprecated
    public boolean putAll(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public ImmutableMultiset<K> d() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public ImmutableCollection<V> g() {
        return new f(this);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    @Deprecated
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public p8<Map.Entry<K, V>> h() {
        return new a();
    }

    @Override // com.google.common.collect.b6
    public int size() {
        return this.size;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t() {
        return this.map.l();
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y */
    public p8<V> j() {
        return new b();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v10) {
        return ImmutableListMultimap.of((Object) k10, (Object) v10);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public ImmutableMap<K, Collection<V>> asMap() {
        return (ImmutableMap<K, ? extends ImmutableCollection<V>>) this.map;
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public ImmutableCollection<Map.Entry<K, V>> entries() {
        return (ImmutableCollection) super.entries();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public ImmutableSet<K> keySet() {
        return this.map.keySet();
    }

    @Override // com.google.common.collect.o
    public ImmutableMultiset<K> keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    @Deprecated
    public boolean putAll(b6<? extends K, ? extends V> b6Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.b6
    @Deprecated
    public ImmutableCollection<V> removeAll(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.o
    @Deprecated
    public ImmutableCollection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.o
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v10, K k11, V v11) {
        return ImmutableListMultimap.of((Object) k10, (Object) v10, (Object) k11, (Object) v11);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        return ImmutableListMultimap.of((Object) k10, (Object) v10, (Object) k11, (Object) v11, (Object) k12, (Object) v12);
    }

    public static <K, V> ImmutableMultimap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return ImmutableListMultimap.copyOf((Iterable) iterable);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        return ImmutableListMultimap.of((Object) k10, (Object) v10, (Object) k11, (Object) v11, (Object) k12, (Object) v12, (Object) k13, (Object) v13);
    }

    public static <K, V> ImmutableMultimap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        return ImmutableListMultimap.of((Object) k10, (Object) v10, (Object) k11, (Object) v11, (Object) k12, (Object) v12, (Object) k13, (Object) v13, (Object) k14, (Object) v14);
    }
}
