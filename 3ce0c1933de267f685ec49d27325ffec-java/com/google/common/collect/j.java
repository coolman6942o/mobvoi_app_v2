package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.e6;
import com.google.common.collect.j;
import com.google.common.collect.o;
import com.google.common.collect.w5;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMapBasedMultimap.java */
/* loaded from: classes.dex */
public abstract class j<K, V> extends com.google.common.collect.o<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map<K, Collection<V>> map;
    private transient int totalSize;

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    class a extends j<K, V>.d<V> {
        a(j jVar) {
            super();
        }

        @Override // com.google.common.collect.j.d
        V a(K k10, V v10) {
            return v10;
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    class b extends j<K, V>.d<Map.Entry<K, V>> {
        b(j jVar) {
            super();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Map.Entry<K, V> a(K k10, V v10) {
            return w5.e(k10, v10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    public class c extends w5.n<K, Collection<V>> {

        /* renamed from: d  reason: collision with root package name */
        final transient Map<K, Collection<V>> f12022d;

        /* compiled from: AbstractMapBasedMultimap.java */
        /* loaded from: classes.dex */
        class a extends w5.h<K, Collection<V>> {
            a() {
            }

            @Override // com.google.common.collect.w5.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return y2.c(c.this.f12022d.entrySet(), obj);
            }

            @Override // com.google.common.collect.w5.h
            Map<K, Collection<V>> e() {
                return c.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b();
            }

            @Override // com.google.common.collect.w5.h, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                j.this.I(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<Map.Entry<K, Collection<V>>> spliterator() {
                Spliterator<Map.Entry<K, Collection<V>>> spliterator = c.this.f12022d.entrySet().spliterator();
                final c cVar = c.this;
                return s2.e(spliterator, new Function() { // from class: com.google.common.collect.k
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return j.c.this.g((Map.Entry) obj);
                    }
                });
            }
        }

        /* compiled from: AbstractMapBasedMultimap.java */
        /* loaded from: classes.dex */
        class b implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: a  reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f12025a;

            /* renamed from: b  reason: collision with root package name */
            Collection<V> f12026b;

            b() {
                this.f12025a = c.this.f12022d.entrySet().iterator();
            }

            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f12025a.next();
                this.f12026b = next.getValue();
                return c.this.g(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f12025a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                p2.e(this.f12026b != null);
                this.f12025a.remove();
                j.u(j.this, this.f12026b.size());
                this.f12026b.clear();
                this.f12026b = null;
            }
        }

        c(Map<K, Collection<V>> map) {
            this.f12022d = map;
        }

        @Override // com.google.common.collect.w5.n
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f12022d == j.this.map) {
                j.this.clear();
            } else {
                j5.d(new b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return w5.o(this.f12022d, obj);
        }

        /* renamed from: e */
        public Collection<V> get(Object obj) {
            Collection<V> collection = (Collection) w5.p(this.f12022d, obj);
            if (collection == null) {
                return null;
            }
            return j.this.K(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f12022d.equals(obj);
        }

        /* renamed from: f */
        public Collection<V> remove(Object obj) {
            Collection<V> remove = this.f12022d.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> x10 = j.this.x();
            x10.addAll(remove);
            j.u(j.this, remove.size());
            remove.clear();
            return x10;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map.Entry<K, Collection<V>> g(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return w5.e(key, j.this.K(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f12022d.hashCode();
        }

        @Override // com.google.common.collect.w5.n, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return j.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f12022d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f12022d.toString();
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    private abstract class d<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f12028a;

        /* renamed from: b  reason: collision with root package name */
        K f12029b = null;

        /* renamed from: c  reason: collision with root package name */
        Collection<V> f12030c = null;

        /* renamed from: d  reason: collision with root package name */
        Iterator<V> f12031d = j5.j();

        d() {
            this.f12028a = (Iterator<Map.Entry<K, V>>) j.this.map.entrySet().iterator();
        }

        abstract T a(K k10, V v10);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12028a.hasNext() || this.f12031d.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            if (!this.f12031d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f12028a.next();
                this.f12029b = next.getKey();
                Collection<V> value = next.getValue();
                this.f12030c = value;
                this.f12031d = value.iterator();
            }
            return a(this.f12029b, this.f12031d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f12031d.remove();
            if (this.f12030c.isEmpty()) {
                this.f12028a.remove();
            }
            j.s(j.this);
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    private class e extends w5.j<K, Collection<V>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractMapBasedMultimap.java */
        /* loaded from: classes.dex */
        public class a implements Iterator<K> {

            /* renamed from: a  reason: collision with root package name */
            Map.Entry<K, Collection<V>> f12034a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Iterator f12035b;

            a(Iterator it) {
                this.f12035b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f12035b.hasNext();
            }

            @Override // java.util.Iterator
            public K next() {
                Map.Entry<K, Collection<V>> entry = (Map.Entry) this.f12035b.next();
                this.f12034a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                p2.e(this.f12034a != null);
                Collection<V> value = this.f12034a.getValue();
                this.f12035b.remove();
                j.u(j.this, value.size());
                value.clear();
                this.f12034a = null;
            }
        }

        e(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.w5.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            j5.d(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return g().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || g().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return g().keySet().hashCode();
        }

        @Override // com.google.common.collect.w5.j, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new a(g().entrySet().iterator());
        }

        @Override // com.google.common.collect.w5.j, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int i10;
            Collection<V> remove = g().remove(obj);
            if (remove != null) {
                i10 = remove.size();
                remove.clear();
                j.u(j.this, i10);
            } else {
                i10 = 0;
            }
            return i10 > 0;
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<K> spliterator() {
            return g().keySet().spliterator();
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    class f extends j<K, V>.i implements NavigableMap<K, Collection<V>> {
        f(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> ceilingEntry(K k10) {
            Map.Entry<K, Collection<V>> ceilingEntry = j().ceilingEntry(k10);
            if (ceilingEntry == null) {
                return null;
            }
            return g(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k10) {
            return j().ceilingKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new f(j().descendingMap());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = j().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return g(firstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> floorEntry(K k10) {
            Map.Entry<K, Collection<V>> floorEntry = j().floorEntry(k10);
            if (floorEntry == null) {
                return null;
            }
            return g(floorEntry);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k10) {
            return j().floorKey(k10);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> higherEntry(K k10) {
            Map.Entry<K, Collection<V>> higherEntry = j().higherEntry(k10);
            if (higherEntry == null) {
                return null;
            }
            return g(higherEntry);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k10) {
            return j().higherKey(k10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: k */
        public NavigableSet<K> h() {
            return new g(j());
        }

        /* renamed from: l */
        public NavigableMap<K, Collection<V>> headMap(K k10) {
            return headMap(k10, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = j().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return g(lastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> lowerEntry(K k10) {
            Map.Entry<K, Collection<V>> lowerEntry = j().lowerEntry(k10);
            if (lowerEntry == null) {
                return null;
            }
            return g(lowerEntry);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k10) {
            return j().lowerKey(k10);
        }

        /* renamed from: m */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        Map.Entry<K, Collection<V>> n(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> x10 = j.this.x();
            x10.addAll(next.getValue());
            it.remove();
            return w5.e(next.getKey(), j.this.J(x10));
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: o */
        public NavigableMap<K, Collection<V>> j() {
            return (NavigableMap) super.j();
        }

        /* renamed from: p */
        public NavigableMap<K, Collection<V>> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return n(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return n(descendingMap().entrySet().iterator());
        }

        /* renamed from: q */
        public NavigableMap<K, Collection<V>> tailMap(K k10) {
            return tailMap(k10, true);
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(K k10, boolean z10) {
            return new f(j().headMap(k10, z10));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(K k10, boolean z10, K k11, boolean z11) {
            return new f(j().subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(K k10, boolean z10) {
            return new f(j().tailMap(k10, z10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    public class g extends j<K, V>.C0147j implements NavigableSet<K> {
        g(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public K ceiling(K k10) {
            return h().ceilingKey(k10);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new g(h().descendingMap());
        }

        @Override // java.util.NavigableSet
        public K floor(K k10) {
            return h().floorKey(k10);
        }

        @Override // java.util.NavigableSet
        public K higher(K k10) {
            return h().higherKey(k10);
        }

        /* renamed from: i */
        public NavigableSet<K> headSet(K k10) {
            return headSet(k10, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: j */
        public NavigableMap<K, Collection<V>> h() {
            return (NavigableMap) super.h();
        }

        /* renamed from: k */
        public NavigableSet<K> subSet(K k10, K k11) {
            return subSet(k10, true, k11, false);
        }

        /* renamed from: l */
        public NavigableSet<K> tailSet(K k10) {
            return tailSet(k10, true);
        }

        @Override // java.util.NavigableSet
        public K lower(K k10) {
            return h().lowerKey(k10);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) j5.s(iterator());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) j5.s(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k10, boolean z10) {
            return new g(h().headMap(k10, z10));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k10, boolean z10, K k11, boolean z11) {
            return new g(h().subMap(k10, z10, k11, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k10, boolean z10) {
            return new g(h().tailMap(k10, z10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    public class h extends j<K, V>.l implements RandomAccess {
        h(j jVar, K k10, List<V> list, j<K, V>.k kVar) {
            super(k10, list, kVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    public class i extends j<K, V>.c implements SortedMap<K, Collection<V>> {

        /* renamed from: f  reason: collision with root package name */
        SortedSet<K> f12039f;

        i(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return j().firstKey();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h */
        public SortedSet<K> b() {
            return new C0147j(j());
        }

        public SortedMap<K, Collection<V>> headMap(K k10) {
            return new i(j().headMap(k10));
        }

        /* renamed from: i */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f12039f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> h10 = b();
            this.f12039f = h10;
            return h10;
        }

        SortedMap<K, Collection<V>> j() {
            return (SortedMap) this.f12022d;
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return j().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(K k10, K k11) {
            return new i(j().subMap(k10, k11));
        }

        public SortedMap<K, Collection<V>> tailMap(K k10) {
            return new i(j().tailMap(k10));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* renamed from: com.google.common.collect.j$j  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0147j extends j<K, V>.e implements SortedSet<K> {
        C0147j(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return h().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return h().firstKey();
        }

        SortedMap<K, Collection<V>> h() {
            return (SortedMap) super.g();
        }

        public SortedSet<K> headSet(K k10) {
            return new C0147j(h().headMap(k10));
        }

        @Override // java.util.SortedSet
        public K last() {
            return h().lastKey();
        }

        public SortedSet<K> subSet(K k10, K k11) {
            return new C0147j(h().subMap(k10, k11));
        }

        public SortedSet<K> tailSet(K k10) {
            return new C0147j(h().tailMap(k10));
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    class m extends j<K, V>.o implements NavigableSet<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public m(K k10, NavigableSet<V> navigableSet, j<K, V>.k kVar) {
            super(k10, navigableSet, kVar);
        }

        private NavigableSet<V> i(NavigableSet<V> navigableSet) {
            return new m(this.f12042a, navigableSet, b() == null ? this : b());
        }

        @Override // java.util.NavigableSet
        public V ceiling(V v10) {
            return g().ceiling(v10);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new k.a(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return i(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        public V floor(V v10) {
            return g().floor(v10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h */
        public NavigableSet<V> g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(V v10, boolean z10) {
            return i(g().headSet(v10, z10));
        }

        @Override // java.util.NavigableSet
        public V higher(V v10) {
            return g().higher(v10);
        }

        @Override // java.util.NavigableSet
        public V lower(V v10) {
            return g().lower(v10);
        }

        @Override // java.util.NavigableSet
        public V pollFirst() {
            return (V) j5.s(iterator());
        }

        @Override // java.util.NavigableSet
        public V pollLast() {
            return (V) j5.s(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(V v10, boolean z10, V v11, boolean z11) {
            return i(g().subSet(v10, z10, v11, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(V v10, boolean z10) {
            return i(g().tailSet(v10, z10));
        }
    }

    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    class n extends j<K, V>.k implements Set<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public n(K k10, Set<V> set) {
            super(k10, set, null);
        }

        @Override // com.google.common.collect.j.k, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean g10 = l7.g((Set) this.f12043b, collection);
            if (g10) {
                j.t(j.this, this.f12043b.size() - size);
                f();
            }
            return g10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    public class o extends j<K, V>.k implements SortedSet<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public o(K k10, SortedSet<V> sortedSet, j<K, V>.k kVar) {
            super(k10, sortedSet, kVar);
        }

        @Override // java.util.SortedSet
        public Comparator<? super V> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public V first() {
            e();
            return g().first();
        }

        SortedSet<V> g() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(V v10) {
            e();
            return new o(d(), g().headSet(v10), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public V last() {
            e();
            return g().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(V v10, V v11) {
            e();
            return new o(d(), g().subSet(v10, v11), b() == null ? this : b());
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(V v10) {
            e();
            return new o(d(), g().tailSet(v10), b() == null ? this : b());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j(Map<K, Collection<V>> map) {
        p.d(map.isEmpty());
        this.map = map;
    }

    private Collection<V> C(K k10) {
        Collection<V> collection = this.map.get(k10);
        if (collection != null) {
            return collection;
        }
        Collection<V> y10 = y(k10);
        this.map.put(k10, y10);
        return y10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> D(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator F(Map.Entry entry) {
        final Object key = entry.getKey();
        return s2.e(((Collection) entry.getValue()).spliterator(), new Function() { // from class: com.google.common.collect.g
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Map.Entry e10;
                e10 = w5.e(key, obj);
                return e10;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(final BiConsumer biConsumer, final Object obj, Collection collection) {
        collection.forEach(new Consumer() { // from class: com.google.common.collect.f
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                biConsumer.accept(obj, obj2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(Object obj) {
        Collection collection = (Collection) w5.q(this.map, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.totalSize -= size;
        }
    }

    static /* synthetic */ int r(j jVar) {
        int i10 = jVar.totalSize;
        jVar.totalSize = i10 + 1;
        return i10;
    }

    static /* synthetic */ int s(j jVar) {
        int i10 = jVar.totalSize;
        jVar.totalSize = i10 - 1;
        return i10;
    }

    static /* synthetic */ int t(j jVar, int i10) {
        int i11 = jVar.totalSize + i10;
        jVar.totalSize = i11;
        return i11;
    }

    static /* synthetic */ int u(j jVar, int i10) {
        int i11 = jVar.totalSize - i10;
        jVar.totalSize = i11;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<K> A() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new g((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new C0147j((SortedMap) this.map);
        }
        return new e(this.map);
    }

    Collection<V> B() {
        return (Collection<V>) J(x());
    }

    <E> Collection<E> J(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    Collection<V> K(K k10, Collection<V> collection) {
        return new k(k10, collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<V> L(K k10, List<V> list, j<K, V>.k kVar) {
        if (list instanceof RandomAccess) {
            return new h(this, k10, list, kVar);
        }
        return new l(k10, list, kVar);
    }

    @Override // com.google.common.collect.o
    Map<K, Collection<V>> a() {
        return new c(this.map);
    }

    @Override // com.google.common.collect.o
    Collection<Map.Entry<K, V>> b() {
        if (this instanceof k7) {
            return new o.b(this);
        }
        return new o.a();
    }

    @Override // com.google.common.collect.o
    Set<K> c() {
        return new e(this.map);
    }

    @Override // com.google.common.collect.b6
    public void clear() {
        for (Collection<V> collection : this.map.values()) {
            collection.clear();
        }
        this.map.clear();
        this.totalSize = 0;
    }

    @Override // com.google.common.collect.b6
    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.o
    j6<K> d() {
        return new e6.e(this);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        p.o(biConsumer);
        this.map.forEach(new BiConsumer() { // from class: com.google.common.collect.e
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                j.H(biConsumer, obj, (Collection) obj2);
            }
        });
    }

    @Override // com.google.common.collect.o
    Collection<V> g() {
        return new o.c();
    }

    @Override // com.google.common.collect.b6
    public Collection<V> get(K k10) {
        Collection<V> collection = this.map.get(k10);
        if (collection == null) {
            collection = y(k10);
        }
        return K(k10, collection);
    }

    @Override // com.google.common.collect.o
    Iterator<Map.Entry<K, V>> h() {
        return new b(this);
    }

    @Override // com.google.common.collect.o
    Spliterator<Map.Entry<K, V>> i() {
        return s2.b(this.map.entrySet().spliterator(), com.google.common.collect.i.f12014a, 64, size());
    }

    @Override // com.google.common.collect.o
    Iterator<V> j() {
        return new a(this);
    }

    @Override // com.google.common.collect.o
    Spliterator<V> k() {
        return s2.b(this.map.values().spliterator(), com.google.common.collect.h.f11998a, 64, size());
    }

    @Override // com.google.common.collect.o
    public boolean put(K k10, V v10) {
        Collection<V> collection = this.map.get(k10);
        if (collection == null) {
            Collection<V> y10 = y(k10);
            if (y10.add(v10)) {
                this.totalSize++;
                this.map.put(k10, y10);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v10)) {
            return false;
        } else {
            this.totalSize++;
            return true;
        }
    }

    @Override // com.google.common.collect.b6
    public Collection<V> removeAll(Object obj) {
        Collection<V> remove = this.map.remove(obj);
        if (remove == null) {
            return B();
        }
        Collection x10 = x();
        x10.addAll(remove);
        this.totalSize -= remove.size();
        remove.clear();
        return (Collection<V>) J(x10);
    }

    @Override // com.google.common.collect.o
    public Collection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k10);
        }
        Collection<V> C = C(k10);
        Collection x10 = x();
        x10.addAll(C);
        this.totalSize -= C.size();
        C.clear();
        while (it.hasNext()) {
            if (C.add(it.next())) {
                this.totalSize++;
            }
        }
        return (Collection<V>) J(x10);
    }

    @Override // com.google.common.collect.b6
    public int size() {
        return this.totalSize;
    }

    @Override // com.google.common.collect.o
    public Collection<V> values() {
        return super.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<K, Collection<V>> w() {
        return this.map;
    }

    abstract Collection<V> x();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<V> y(K k10) {
        return x();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, Collection<V>> z() {
        Map<K, Collection<V>> map = this.map;
        if (map instanceof NavigableMap) {
            return new f((NavigableMap) this.map);
        }
        if (map instanceof SortedMap) {
            return new i((SortedMap) this.map);
        }
        return new c(this.map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    public class k extends AbstractCollection<V> {

        /* renamed from: a  reason: collision with root package name */
        final K f12042a;

        /* renamed from: b  reason: collision with root package name */
        Collection<V> f12043b;

        /* renamed from: c  reason: collision with root package name */
        final j<K, V>.k f12044c;

        /* renamed from: d  reason: collision with root package name */
        final Collection<V> f12045d;

        k(K k10, Collection<V> collection, j<K, V>.k kVar) {
            this.f12042a = k10;
            this.f12043b = collection;
            this.f12044c = kVar;
            this.f12045d = kVar == null ? null : kVar.c();
        }

        void a() {
            j<K, V>.k kVar = this.f12044c;
            if (kVar != null) {
                kVar.a();
            } else {
                j.this.map.put(this.f12042a, this.f12043b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(V v10) {
            e();
            boolean isEmpty = this.f12043b.isEmpty();
            boolean add = this.f12043b.add(v10);
            if (add) {
                j.r(j.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f12043b.addAll(collection);
            if (addAll) {
                j.t(j.this, this.f12043b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        j<K, V>.k b() {
            return this.f12044c;
        }

        Collection<V> c() {
            return this.f12043b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size != 0) {
                this.f12043b.clear();
                j.u(j.this, size);
                f();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            e();
            return this.f12043b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            e();
            return this.f12043b.containsAll(collection);
        }

        K d() {
            return this.f12042a;
        }

        void e() {
            Collection<V> collection;
            j<K, V>.k kVar = this.f12044c;
            if (kVar != null) {
                kVar.e();
                if (this.f12044c.c() != this.f12045d) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f12043b.isEmpty() && (collection = (Collection) j.this.map.get(this.f12042a)) != null) {
                this.f12043b = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.f12043b.equals(obj);
        }

        void f() {
            j<K, V>.k kVar = this.f12044c;
            if (kVar != null) {
                kVar.f();
            } else if (this.f12043b.isEmpty()) {
                j.this.map.remove(this.f12042a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.f12043b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            e();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            e();
            boolean remove = this.f12043b.remove(obj);
            if (remove) {
                j.s(j.this);
                f();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f12043b.removeAll(collection);
            if (removeAll) {
                j.t(j.this, this.f12043b.size() - size);
                f();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            p.o(collection);
            int size = size();
            boolean retainAll = this.f12043b.retainAll(collection);
            if (retainAll) {
                j.t(j.this, this.f12043b.size() - size);
                f();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.f12043b.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            e();
            return this.f12043b.spliterator();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.f12043b.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractMapBasedMultimap.java */
        /* loaded from: classes.dex */
        public class a implements Iterator<V> {

            /* renamed from: a  reason: collision with root package name */
            final Iterator<V> f12047a;

            /* renamed from: b  reason: collision with root package name */
            final Collection<V> f12048b;

            a() {
                Collection<V> collection = k.this.f12043b;
                this.f12048b = collection;
                this.f12047a = j.D(collection);
            }

            Iterator<V> a() {
                b();
                return this.f12047a;
            }

            void b() {
                k.this.e();
                if (k.this.f12043b != this.f12048b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f12047a.hasNext();
            }

            @Override // java.util.Iterator
            public V next() {
                b();
                return this.f12047a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f12047a.remove();
                j.s(j.this);
                k.this.f();
            }

            a(Iterator<V> it) {
                this.f12048b = k.this.f12043b;
                this.f12047a = it;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractMapBasedMultimap.java */
    /* loaded from: classes.dex */
    public class l extends j<K, V>.k implements List<V> {

        /* compiled from: AbstractMapBasedMultimap.java */
        /* loaded from: classes.dex */
        private class a extends j<K, V>.k.a implements ListIterator<V> {
            a() {
                super();
            }

            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(V v10) {
                boolean isEmpty = l.this.isEmpty();
                c().add(v10);
                j.r(j.this);
                if (isEmpty) {
                    l.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(V v10) {
                c().set(v10);
            }

            public a(int i10) {
                super(l.this.g().listIterator(i10));
            }
        }

        l(K k10, List<V> list, j<K, V>.k kVar) {
            super(k10, list, kVar);
        }

        @Override // java.util.List
        public void add(int i10, V v10) {
            e();
            boolean isEmpty = c().isEmpty();
            g().add(i10, v10);
            j.r(j.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i10, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i10, collection);
            if (addAll) {
                j.t(j.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        List<V> g() {
            return (List) c();
        }

        @Override // java.util.List
        public V get(int i10) {
            e();
            return g().get(i10);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            e();
            return new a();
        }

        @Override // java.util.List
        public V remove(int i10) {
            e();
            V remove = g().remove(i10);
            j.s(j.this);
            f();
            return remove;
        }

        @Override // java.util.List
        public V set(int i10, V v10) {
            e();
            return g().set(i10, v10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i10, int i11) {
            e();
            return j.this.L(d(), g().subList(i10, i11), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i10) {
            e();
            return new a(i10);
        }
    }
}
