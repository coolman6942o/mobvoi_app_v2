package com.google.protobuf;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: MapField.java */
/* loaded from: classes.dex */
public class c0<K, V> implements j0 {

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f13180a;

    /* renamed from: b  reason: collision with root package name */
    private volatile d f13181b;

    /* renamed from: c  reason: collision with root package name */
    private c<K, V> f13182c;

    /* renamed from: d  reason: collision with root package name */
    private List<d0> f13183d;

    /* renamed from: e  reason: collision with root package name */
    private final a<K, V> f13184e;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapField.java */
    /* loaded from: classes.dex */
    public interface a<K, V> {
        d0 a(K k10, V v10);

        d0 b();

        void c(d0 d0Var, Map<K, V> map);
    }

    /* compiled from: MapField.java */
    /* loaded from: classes.dex */
    private static class b<K, V> implements a<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final a0<K, V> f13185a;

        public b(a0<K, V> a0Var) {
            this.f13185a = a0Var;
        }

        @Override // com.google.protobuf.c0.a
        public d0 a(K k10, V v10) {
            return this.f13185a.newBuilderForType().n(k10).p(v10).buildPartial();
        }

        @Override // com.google.protobuf.c0.a
        public d0 b() {
            return this.f13185a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.protobuf.c0.a
        public void c(d0 d0Var, Map<K, V> map) {
            a0 a0Var = (a0) d0Var;
            map.put(a0Var.h(), a0Var.i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapField.java */
    /* loaded from: classes.dex */
    public static class c<K, V> implements Map<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final j0 f13186a;

        /* renamed from: b  reason: collision with root package name */
        private final Map<K, V> f13187b;

        /* compiled from: MapField.java */
        /* loaded from: classes.dex */
        private static class a<E> implements Collection<E> {

            /* renamed from: a  reason: collision with root package name */
            private final j0 f13188a;

            /* renamed from: b  reason: collision with root package name */
            private final Collection<E> f13189b;

            a(j0 j0Var, Collection<E> collection) {
                this.f13188a = j0Var;
                this.f13189b = collection;
            }

            @Override // java.util.Collection
            public boolean add(E e10) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public void clear() {
                this.f13188a.a();
                this.f13189b.clear();
            }

            @Override // java.util.Collection
            public boolean contains(Object obj) {
                return this.f13189b.contains(obj);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.f13189b.containsAll(collection);
            }

            @Override // java.util.Collection
            public boolean equals(Object obj) {
                return this.f13189b.equals(obj);
            }

            @Override // java.util.Collection
            public int hashCode() {
                return this.f13189b.hashCode();
            }

            @Override // java.util.Collection
            public boolean isEmpty() {
                return this.f13189b.isEmpty();
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f13188a, this.f13189b.iterator());
            }

            @Override // java.util.Collection
            public boolean remove(Object obj) {
                this.f13188a.a();
                return this.f13189b.remove(obj);
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.f13188a.a();
                return this.f13189b.removeAll(collection);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.f13188a.a();
                return this.f13189b.retainAll(collection);
            }

            @Override // java.util.Collection
            public int size() {
                return this.f13189b.size();
            }

            @Override // java.util.Collection
            public Object[] toArray() {
                return this.f13189b.toArray();
            }

            public String toString() {
                return this.f13189b.toString();
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.f13189b.toArray(tArr);
            }
        }

        /* compiled from: MapField.java */
        /* loaded from: classes.dex */
        private static class b<E> implements Iterator<E> {

            /* renamed from: a  reason: collision with root package name */
            private final j0 f13190a;

            /* renamed from: b  reason: collision with root package name */
            private final Iterator<E> f13191b;

            b(j0 j0Var, Iterator<E> it) {
                this.f13190a = j0Var;
                this.f13191b = it;
            }

            public boolean equals(Object obj) {
                return this.f13191b.equals(obj);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f13191b.hasNext();
            }

            public int hashCode() {
                return this.f13191b.hashCode();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.f13191b.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f13190a.a();
                this.f13191b.remove();
            }

            public String toString() {
                return this.f13191b.toString();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: MapField.java */
        /* renamed from: com.google.protobuf.c0$c$c  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0172c<E> implements Set<E> {

            /* renamed from: a  reason: collision with root package name */
            private final j0 f13192a;

            /* renamed from: b  reason: collision with root package name */
            private final Set<E> f13193b;

            C0172c(j0 j0Var, Set<E> set) {
                this.f13192a = j0Var;
                this.f13193b = set;
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(E e10) {
                this.f13192a.a();
                return this.f13193b.add(e10);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection<? extends E> collection) {
                this.f13192a.a();
                return this.f13193b.addAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.f13192a.a();
                this.f13193b.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object obj) {
                return this.f13193b.contains(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.f13193b.containsAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(Object obj) {
                return this.f13193b.equals(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public int hashCode() {
                return this.f13193b.hashCode();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return this.f13193b.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f13192a, this.f13193b.iterator());
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(Object obj) {
                this.f13192a.a();
                return this.f13193b.remove(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.f13192a.a();
                return this.f13193b.removeAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.f13192a.a();
                return this.f13193b.retainAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.f13193b.size();
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                return this.f13193b.toArray();
            }

            public String toString() {
                return this.f13193b.toString();
            }

            @Override // java.util.Set, java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.f13193b.toArray(tArr);
            }
        }

        c(j0 j0Var, Map<K, V> map) {
            this.f13186a = j0Var;
            this.f13187b = map;
        }

        @Override // java.util.Map
        public void clear() {
            this.f13186a.a();
            this.f13187b.clear();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.f13187b.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.f13187b.containsValue(obj);
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new C0172c(this.f13186a, this.f13187b.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return this.f13187b.equals(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.f13187b.get(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.f13187b.hashCode();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.f13187b.isEmpty();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new C0172c(this.f13186a, this.f13187b.keySet());
        }

        @Override // java.util.Map
        public V put(K k10, V v10) {
            this.f13186a.a();
            return this.f13187b.put(k10, v10);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.f13186a.a();
            this.f13187b.putAll(map);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            this.f13186a.a();
            return this.f13187b.remove(obj);
        }

        @Override // java.util.Map
        public int size() {
            return this.f13187b.size();
        }

        public String toString() {
            return this.f13187b.toString();
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new a(this.f13186a, this.f13187b.values());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MapField.java */
    /* loaded from: classes.dex */
    public enum d {
        MAP,
        LIST,
        BOTH
    }

    private c0(a<K, V> aVar, d dVar, Map<K, V> map) {
        this.f13184e = aVar;
        this.f13180a = true;
        this.f13181b = dVar;
        this.f13182c = new c<>(this, map);
        this.f13183d = null;
    }

    private d0 c(K k10, V v10) {
        return this.f13184e.a(k10, v10);
    }

    private c<K, V> d(List<d0> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (d0 d0Var : list) {
            f(d0Var, linkedHashMap);
        }
        return new c<>(this, linkedHashMap);
    }

    private List<d0> e(c<K, V> cVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, V> entry : cVar.entrySet()) {
            arrayList.add(c(entry.getKey(), entry.getValue()));
        }
        return arrayList;
    }

    private void f(d0 d0Var, Map<K, V> map) {
        this.f13184e.c(d0Var, map);
    }

    public static <K, V> c0<K, V> h(a0<K, V> a0Var) {
        return new c0<>(a0Var, d.MAP, Collections.emptyMap());
    }

    public static <K, V> c0<K, V> q(a0<K, V> a0Var) {
        return new c0<>(a0Var, d.MAP, new LinkedHashMap());
    }

    @Override // com.google.protobuf.j0
    public void a() {
        if (!n()) {
            throw new UnsupportedOperationException();
        }
    }

    public void b() {
        this.f13182c = new c<>(this, new LinkedHashMap());
        this.f13181b = d.MAP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c0)) {
            return false;
        }
        return MapFieldLite.k(j(), ((c0) obj).j());
    }

    public c0<K, V> g() {
        return new c0<>(this.f13184e, d.MAP, MapFieldLite.g(j()));
    }

    public int hashCode() {
        return MapFieldLite.a(j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<d0> i() {
        d dVar = this.f13181b;
        d dVar2 = d.MAP;
        if (dVar == dVar2) {
            synchronized (this) {
                if (this.f13181b == dVar2) {
                    this.f13183d = e(this.f13182c);
                    this.f13181b = d.BOTH;
                }
            }
        }
        return Collections.unmodifiableList(this.f13183d);
    }

    public Map<K, V> j() {
        d dVar = this.f13181b;
        d dVar2 = d.LIST;
        if (dVar == dVar2) {
            synchronized (this) {
                if (this.f13181b == dVar2) {
                    this.f13182c = d(this.f13183d);
                    this.f13181b = d.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap(this.f13182c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0 k() {
        return this.f13184e.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<d0> l() {
        d dVar = this.f13181b;
        d dVar2 = d.LIST;
        if (dVar != dVar2) {
            if (this.f13181b == d.MAP) {
                this.f13183d = e(this.f13182c);
            }
            this.f13182c = null;
            this.f13181b = dVar2;
        }
        return this.f13183d;
    }

    public Map<K, V> m() {
        d dVar = this.f13181b;
        d dVar2 = d.MAP;
        if (dVar != dVar2) {
            if (this.f13181b == d.LIST) {
                this.f13182c = d(this.f13183d);
            }
            this.f13183d = null;
            this.f13181b = dVar2;
        }
        return this.f13182c;
    }

    public boolean n() {
        return this.f13180a;
    }

    public void o() {
        this.f13180a = false;
    }

    public void p(c0<K, V> c0Var) {
        m().putAll(MapFieldLite.g(c0Var.j()));
    }

    private c0(a0<K, V> a0Var, d dVar, Map<K, V> map) {
        this(new b(a0Var), dVar, map);
    }
}
