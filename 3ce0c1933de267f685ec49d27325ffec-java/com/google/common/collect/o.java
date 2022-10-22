package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.e6;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMultimap.java */
/* loaded from: classes.dex */
public abstract class o<K, V> implements b6<K, V> {
    private transient Map<K, Collection<V>> asMap;
    private transient Collection<Map.Entry<K, V>> entries;
    private transient Set<K> keySet;
    private transient j6<K> keys;
    private transient Collection<V> values;

    /* compiled from: AbstractMultimap.java */
    /* loaded from: classes.dex */
    class a extends e6.d<K, V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public a() {
        }

        @Override // com.google.common.collect.e6.d
        b6<K, V> a() {
            return o.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return o.this.h();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return o.this.i();
        }
    }

    /* compiled from: AbstractMultimap.java */
    /* loaded from: classes.dex */
    class b extends o<K, V>.a implements Set<Map.Entry<K, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b(o oVar) {
            super();
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return l7.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return l7.b(this);
        }
    }

    /* compiled from: AbstractMultimap.java */
    /* loaded from: classes.dex */
    class c extends AbstractCollection<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            o.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return o.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return o.this.j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return o.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return o.this.k();
        }
    }

    abstract Map<K, Collection<V>> a();

    @Override // com.google.common.collect.b6
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.asMap;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> a10 = a();
        this.asMap = a10;
        return a10;
    }

    abstract Collection<Map.Entry<K, V>> b();

    abstract Set<K> c();

    @Override // com.google.common.collect.b6
    public boolean containsEntry(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean containsValue(Object obj) {
        for (Collection<V> collection : asMap().values()) {
            if (collection.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract j6<K> d();

    @Override // com.google.common.collect.b6
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.entries;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> b10 = b();
        this.entries = b10;
        return b10;
    }

    public boolean equals(Object obj) {
        return e6.a(this, obj);
    }

    abstract Collection<V> g();

    abstract Iterator<Map.Entry<K, V>> h();

    public int hashCode() {
        return asMap().hashCode();
    }

    Spliterator<Map.Entry<K, V>> i() {
        return Spliterators.spliterator(h(), size(), this instanceof k7 ? 1 : 0);
    }

    @Override // com.google.common.collect.b6
    public boolean isEmpty() {
        return size() == 0;
    }

    Iterator<V> j() {
        return w5.v(entries().iterator());
    }

    Spliterator<V> k() {
        return Spliterators.spliterator(j(), size(), 0);
    }

    @Override // com.google.common.collect.b6
    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        Set<K> c10 = c();
        this.keySet = c10;
        return c10;
    }

    public j6<K> keys() {
        j6<K> j6Var = this.keys;
        if (j6Var != null) {
            return j6Var;
        }
        j6<K> d10 = d();
        this.keys = d10;
        return d10;
    }

    public boolean put(K k10, V v10) {
        return get(k10).add(v10);
    }

    public boolean putAll(K k10, Iterable<? extends V> iterable) {
        p.o(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k10).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && j5.a(get(k10), it);
    }

    @Override // com.google.common.collect.b6
    public boolean remove(Object obj, Object obj2) {
        Collection<V> collection = asMap().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public Collection<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        p.o(iterable);
        Collection<V> removeAll = removeAll(k10);
        putAll(k10, iterable);
        return removeAll;
    }

    public String toString() {
        return asMap().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> g10 = g();
        this.values = g10;
        return g10;
    }

    @Override // com.google.common.collect.b6
    public boolean putAll(b6<? extends K, ? extends V> b6Var) {
        boolean z10 = false;
        for (Map.Entry<? extends K, ? extends V> entry : b6Var.entries()) {
            z10 |= put(entry.getKey(), entry.getValue());
        }
        return z10;
    }
}
