package com.google.common.collect;

import com.google.common.collect.c8;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Spliterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractTable.java */
/* loaded from: classes.dex */
public abstract class y<R, C, V> implements c8<R, C, V> {
    private transient Set<c8.a<R, C, V>> cellSet;
    private transient Collection<V> values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTable.java */
    /* loaded from: classes.dex */
    public class a extends n8<c8.a<R, C, V>, V> {
        a(y yVar, Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: b */
        public V a(c8.a<R, C, V> aVar) {
            return aVar.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTable.java */
    /* loaded from: classes.dex */
    public class b extends AbstractSet<c8.a<R, C, V>> {
        b() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            y.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof c8.a)) {
                return false;
            }
            c8.a aVar = (c8.a) obj;
            Map map = (Map) w5.p(y.this.rowMap(), aVar.b());
            return map != null && y2.c(map.entrySet(), w5.e(aVar.a(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<c8.a<R, C, V>> iterator() {
            return y.this.a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof c8.a)) {
                return false;
            }
            c8.a aVar = (c8.a) obj;
            Map map = (Map) w5.p(y.this.rowMap(), aVar.b());
            return map != null && y2.d(map.entrySet(), w5.e(aVar.a(), aVar.getValue()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return y.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable, java.util.Set
        public Spliterator<c8.a<R, C, V>> spliterator() {
            return y.this.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTable.java */
    /* loaded from: classes.dex */
    public class c extends AbstractCollection<V> {
        c() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            y.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return y.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return y.this.g();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return y.this.size();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Spliterator<V> spliterator() {
            return y.this.h();
        }
    }

    abstract Iterator<c8.a<R, C, V>> a();

    abstract Spliterator<c8.a<R, C, V>> b();

    Set<c8.a<R, C, V>> c() {
        return new b();
    }

    @Override // com.google.common.collect.c8
    public Set<c8.a<R, C, V>> cellSet() {
        Set<c8.a<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        Set<c8.a<R, C, V>> c10 = c();
        this.cellSet = c10;
        return c10;
    }

    public void clear() {
        j5.d(cellSet().iterator());
    }

    @Override // com.google.common.collect.c8
    public Set<C> columnKeySet() {
        return columnMap().keySet();
    }

    public boolean contains(Object obj, Object obj2) {
        Map map = (Map) w5.p(rowMap(), obj);
        return map != null && w5.o(map, obj2);
    }

    public boolean containsColumn(Object obj) {
        return w5.o(columnMap(), obj);
    }

    public boolean containsRow(Object obj) {
        return w5.o(rowMap(), obj);
    }

    public boolean containsValue(Object obj) {
        for (Map<C, V> map : rowMap().values()) {
            if (map.containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    Collection<V> d() {
        return new c();
    }

    public boolean equals(Object obj) {
        return m8.a(this, obj);
    }

    Iterator<V> g() {
        return new a(this, cellSet().iterator());
    }

    @Override // com.google.common.collect.c8
    public V get(Object obj, Object obj2) {
        Map map = (Map) w5.p(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) w5.p(map, obj2);
    }

    Spliterator<V> h() {
        return s2.e(b(), x.f12252a);
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.google.common.collect.c8
    public V put(R r10, C c10, V v10) {
        return row(r10).put(c10, v10);
    }

    public void putAll(c8<? extends R, ? extends C, ? extends V> c8Var) {
        for (c8.a<? extends R, ? extends C, ? extends V> aVar : c8Var.cellSet()) {
            put(aVar.b(), aVar.a(), aVar.getValue());
        }
    }

    public V remove(Object obj, Object obj2) {
        Map map = (Map) w5.p(rowMap(), obj);
        if (map == null) {
            return null;
        }
        return (V) w5.q(map, obj2);
    }

    @Override // com.google.common.collect.c8
    public Set<R> rowKeySet() {
        return rowMap().keySet();
    }

    public String toString() {
        return rowMap().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        Collection<V> d10 = d();
        this.values = d10;
        return d10;
    }
}
