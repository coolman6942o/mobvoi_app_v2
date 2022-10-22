package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.base.r;
import com.google.common.base.s;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.l7;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
/* compiled from: Maps.java */
/* loaded from: classes.dex */
public final class w5 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    public class a extends n8<Map.Entry<K, V>, K> {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, K] */
        /* renamed from: b */
        public K a(Map.Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    public class b extends n8<Map.Entry<K, V>, V> {
        b(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r1v1, types: [V, java.lang.Object] */
        /* renamed from: b */
        public V a(Map.Entry<K, V> entry) {
            return entry.getValue();
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    class c extends n8<K, Map.Entry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.common.base.h f12238b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Iterator it, com.google.common.base.h hVar) {
            super(it);
            this.f12238b = hVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public Map.Entry<K, V> a(K k10) {
            return w5.e(k10, this.f12238b.apply(k10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    public class d extends com.google.common.collect.n<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Map.Entry f12239a;

        d(Map.Entry entry) {
            this.f12239a = entry;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, K] */
        @Override // com.google.common.collect.n, java.util.Map.Entry
        public K getKey() {
            return this.f12239a.getKey();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [V, java.lang.Object] */
        @Override // com.google.common.collect.n, java.util.Map.Entry
        public V getValue() {
            return this.f12239a.getValue();
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    class e extends p8<Map.Entry<K, V>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f12240a;

        e(Iterator it) {
            this.f12240a = it;
        }

        /* renamed from: a */
        public Map.Entry<K, V> next() {
            return w5.s((Map.Entry) this.f12240a.next());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12240a.hasNext();
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    static abstract class f<K, V> extends o3<K, V> implements NavigableMap<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private transient Comparator<? super K> f12241a;

        /* renamed from: b  reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f12242b;

        /* renamed from: c  reason: collision with root package name */
        private transient NavigableSet<K> f12243c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Maps.java */
        /* loaded from: classes.dex */
        public class a extends h<K, V> {
            a() {
            }

            @Override // com.google.common.collect.w5.h
            Map<K, V> e() {
                return f.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return f.this.h();
            }
        }

        private static <T> q6<T> j(Comparator<T> comparator) {
            return q6.a(comparator).j();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.o3
        /* renamed from: b */
        public final Map<K, V> a() {
            return i();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> ceilingEntry(K k10) {
            return i().floorEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K ceilingKey(K k10) {
            return i().floorKey(k10);
        }

        @Override // java.util.SortedMap
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.f12241a;
            if (comparator != null) {
                return comparator;
            }
            Comparator<? super K> comparator2 = i().comparator();
            if (comparator2 == null) {
                comparator2 = q6.g();
            }
            q6 j10 = j(comparator2);
            this.f12241a = j10;
            return j10;
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return i().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> descendingMap() {
            return i();
        }

        @Override // com.google.common.collect.o3, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f12242b;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> g10 = g();
            this.f12242b = g10;
            return g10;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> firstEntry() {
            return i().lastEntry();
        }

        @Override // java.util.SortedMap
        public K firstKey() {
            return i().lastKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> floorEntry(K k10) {
            return i().ceilingEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K floorKey(K k10) {
            return i().ceilingKey(k10);
        }

        Set<Map.Entry<K, V>> g() {
            return new a();
        }

        abstract Iterator<Map.Entry<K, V>> h();

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> headMap(K k10, boolean z10) {
            return i().tailMap(k10, z10).descendingMap();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> higherEntry(K k10) {
            return i().lowerEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K higherKey(K k10) {
            return i().lowerKey(k10);
        }

        abstract NavigableMap<K, V> i();

        @Override // com.google.common.collect.o3, java.util.Map
        public Set<K> keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lastEntry() {
            return i().firstEntry();
        }

        @Override // java.util.SortedMap
        public K lastKey() {
            return i().firstKey();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> lowerEntry(K k10) {
            return i().higherEntry(k10);
        }

        @Override // java.util.NavigableMap
        public K lowerKey(K k10) {
            return i().higherKey(k10);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.f12243c;
            if (navigableSet != null) {
                return navigableSet;
            }
            k kVar = new k(this);
            this.f12243c = kVar;
            return kVar;
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollFirstEntry() {
            return i().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public Map.Entry<K, V> pollLastEntry() {
            return i().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> subMap(K k10, boolean z10, K k11, boolean z11) {
            return i().subMap(k11, z11, k10, z10).descendingMap();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, V> tailMap(K k10, boolean z10) {
            return i().headMap(k10, z10).descendingMap();
        }

        @Override // com.google.common.collect.r3
        public String toString() {
            return d();
        }

        @Override // com.google.common.collect.o3, java.util.Map
        public Collection<V> values() {
            return new m(this);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> headMap(K k10) {
            return headMap(k10, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> subMap(K k10, K k11) {
            return subMap(k10, true, k11, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public SortedMap<K, V> tailMap(K k10) {
            return tailMap(k10, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    public static abstract class g extends Enum<g> implements com.google.common.base.h<Map.Entry<?, ?>, Object> {
        public static final g KEY = new a("KEY", 0);
        public static final g VALUE = new b("VALUE", 1);
        private static final /* synthetic */ g[] $VALUES = a();

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Maps.java */
        /* loaded from: classes.dex */
        final class a extends g {
            a(String str, int i10) {
                super(str, i10, null);
            }

            /* renamed from: b */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier removed */
        /* compiled from: Maps.java */
        /* loaded from: classes.dex */
        final class b extends g {
            b(String str, int i10) {
                super(str, i10, null);
            }

            /* renamed from: b */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }

        private g(String str, int i10) {
        }

        private static /* synthetic */ g[] a() {
            return new g[]{KEY, VALUE};
        }

        public static g valueOf(String str) {
            return (g) Enum.valueOf(g.class, str);
        }

        public static g[] values() {
            return (g[]) $VALUES.clone();
        }

        /* synthetic */ g(String str, int i10, a aVar) {
            this(str, i10);
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    static abstract class h<K, V> extends l7.a<Map.Entry<K, V>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object p10 = w5.p(e(), key);
            if (com.google.common.base.m.a(p10, entry.getValue())) {
                return p10 != null || e().containsKey(key);
            }
            return false;
        }

        abstract Map<K, V> e();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return e().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj)) {
                return e().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.l7.a, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) p.o(collection));
            } catch (UnsupportedOperationException unused) {
                return l7.h(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.l7.a, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) p.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet d10 = l7.d(collection.size());
                for (Object obj : collection) {
                    if (contains(obj)) {
                        d10.add(((Map.Entry) obj).getKey());
                    }
                }
                return e().keySet().retainAll(d10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return e().size();
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    static abstract class i<K, V> extends AbstractMap<K, V> {

        /* compiled from: Maps.java */
        /* loaded from: classes.dex */
        class a extends h<K, V> {
            a() {
            }

            @Override // com.google.common.collect.w5.h
            Map<K, V> e() {
                return i.this;
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
                i.this.d(consumer);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return i.this.a();
            }

            @Override // java.util.Collection, java.lang.Iterable, java.util.Set
            public Spliterator<Map.Entry<K, V>> spliterator() {
                return i.this.b();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> a();

        Spliterator<Map.Entry<K, V>> b() {
            return Spliterators.spliterator(a(), size(), 65);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            j5.d(a());
        }

        void d(Consumer<? super Map.Entry<K, V>> consumer) {
            a().forEachRemaining(consumer);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new a();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public abstract int size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    public static class j<K, V> extends l7.a<K> {

        /* renamed from: a  reason: collision with root package name */
        final Map<K, V> f12246a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(Map<K, V> map) {
            this.f12246a = (Map) p.o(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return g().containsKey(obj);
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super K> consumer) {
            p.o(consumer);
            this.f12246a.forEach(new BiConsumer() { // from class: com.google.common.collect.x5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    consumer.accept(obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Map<K, V> g() {
            return this.f12246a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return g().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return w5.h(g().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            g().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    public static class k<K, V> extends l<K, V> implements NavigableSet<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public k(NavigableMap<K, V> navigableMap) {
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
            return h().descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public K floor(K k10) {
            return h().floorKey(k10);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(K k10, boolean z10) {
            return h().headMap(k10, z10).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public K higher(K k10) {
            return h().higherKey(k10);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: i */
        public NavigableMap<K, V> h() {
            return (NavigableMap) this.f12246a;
        }

        @Override // java.util.NavigableSet
        public K lower(K k10) {
            return h().lowerKey(k10);
        }

        @Override // java.util.NavigableSet
        public K pollFirst() {
            return (K) w5.i(h().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public K pollLast() {
            return (K) w5.i(h().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(K k10, boolean z10, K k11, boolean z11) {
            return h().subMap(k10, z10, k11, z11).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(K k10, boolean z10) {
            return h().tailMap(k10, z10).navigableKeySet();
        }

        @Override // com.google.common.collect.w5.l, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> headSet(K k10) {
            return headSet(k10, false);
        }

        @Override // com.google.common.collect.w5.l, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> subSet(K k10, K k11) {
            return subSet(k10, true, k11, false);
        }

        @Override // com.google.common.collect.w5.l, java.util.SortedSet, java.util.NavigableSet
        public SortedSet<K> tailSet(K k10) {
            return tailSet(k10, true);
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    static class l<K, V> extends j<K, V> implements SortedSet<K> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public l(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public Comparator<? super K> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public K first() {
            return g().firstKey();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: h */
        public SortedMap<K, V> g() {
            return (SortedMap) super.g();
        }

        public SortedSet<K> headSet(K k10) {
            return new l(g().headMap(k10));
        }

        @Override // java.util.SortedSet
        public K last() {
            return g().lastKey();
        }

        public SortedSet<K> subSet(K k10, K k11) {
            return new l(g().subMap(k10, k11));
        }

        public SortedSet<K> tailSet(K k10) {
            return new l(g().tailMap(k10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    public static class m<K, V> extends AbstractCollection<V> {

        /* renamed from: a  reason: collision with root package name */
        final Map<K, V> f12247a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public m(Map<K, V> map) {
            this.f12247a = (Map) p.o(map);
        }

        final Map<K, V> c() {
            return this.f12247a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            c().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return c().containsValue(obj);
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super V> consumer) {
            p.o(consumer);
            this.f12247a.forEach(new BiConsumer() { // from class: com.google.common.collect.y5
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    consumer.accept(obj2);
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return c().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return w5.v(c().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry<K, V> entry : c().entrySet()) {
                    if (com.google.common.base.m.a(obj, entry.getValue())) {
                        c().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) p.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet c10 = l7.c();
                for (Map.Entry<K, V> entry : c().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        c10.add(entry.getKey());
                    }
                }
                return c().keySet().removeAll(c10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) p.o(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet c10 = l7.c();
                for (Map.Entry<K, V> entry : c().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        c10.add(entry.getKey());
                    }
                }
                return c().keySet().retainAll(c10);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return c().size();
        }
    }

    /* compiled from: Maps.java */
    /* loaded from: classes.dex */
    static abstract class n<K, V> extends AbstractMap<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private transient Set<Map.Entry<K, V>> f12248a;

        /* renamed from: b  reason: collision with root package name */
        private transient Set<K> f12249b;

        /* renamed from: c  reason: collision with root package name */
        private transient Collection<V> f12250c;

        abstract Set<Map.Entry<K, V>> a();

        Set<K> b() {
            return new j(this);
        }

        Collection<V> d() {
            return new m(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.f12248a;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a10 = a();
            this.f12248a = a10;
            return a10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            Set<K> set = this.f12249b;
            if (set != null) {
                return set;
            }
            Set<K> b10 = b();
            this.f12249b = b10;
            return b10;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection<V> values() {
            Collection<V> collection = this.f12250c;
            if (collection != null) {
                return collection;
            }
            Collection<V> d10 = d();
            this.f12250c = d10;
            return d10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<Map.Entry<K, V>> a(Set<K> set, com.google.common.base.h<? super K, V> hVar) {
        return new c(set.iterator(), hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i10) {
        if (i10 < 3) {
            p2.b(i10, "expectedSize");
            return i10 + 1;
        } else if (i10 < 1073741824) {
            return (int) ((i10 / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> boolean c(Collection<Map.Entry<K, V>> collection, Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.contains(s((Map.Entry) obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static <K, V> Map.Entry<K, V> e(K k10, V v10) {
        return new b4(k10, v10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMap<E, Integer> f(Collection<E> collection) {
        ImmutableMap.b bVar = new ImmutableMap.b(collection.size());
        int i10 = 0;
        for (E e10 : collection) {
            i10++;
            bVar.d(e10, Integer.valueOf(i10));
        }
        return bVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> com.google.common.base.h<Map.Entry<K, ?>, K> g() {
        return g.KEY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<K> h(Iterator<Map.Entry<K, V>> it) {
        return new a(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> K i(Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> r<Map.Entry<K, ?>> j(r<? super K> rVar) {
        return s.b(rVar, g());
    }

    public static <K, V> HashMap<K, V> k() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> l(int i10) {
        return new HashMap<>(b(i10));
    }

    public static <K, V> LinkedHashMap<K, V> m() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> n(int i10) {
        return new LinkedHashMap<>(b(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean o(Map<?, ?> map, Object obj) {
        p.o(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V p(Map<?, V> map, Object obj) {
        p.o(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V q(Map<?, V> map, Object obj) {
        p.o(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String r(Map<?, ?> map) {
        StringBuilder b10 = y2.b(map.size());
        b10.append('{');
        boolean z10 = true;
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if (!z10) {
                b10.append(", ");
            }
            z10 = false;
            b10.append(entry.getKey());
            b10.append('=');
            b10.append(entry.getValue());
        }
        b10.append('}');
        return b10.toString();
    }

    static <K, V> Map.Entry<K, V> s(Map.Entry<? extends K, ? extends V> entry) {
        p.o(entry);
        return new d(entry);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> p8<Map.Entry<K, V>> t(Iterator<Map.Entry<K, V>> it) {
        return new e(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> com.google.common.base.h<Map.Entry<?, V>, V> u() {
        return g.VALUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> Iterator<V> v(Iterator<Map.Entry<K, V>> it) {
        return new b(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V w(Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> r<Map.Entry<?, V>> x(r<? super V> rVar) {
        return s.b(rVar, u());
    }
}
