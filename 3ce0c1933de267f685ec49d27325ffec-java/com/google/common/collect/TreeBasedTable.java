package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.p;
import com.google.common.base.v;
import com.google.common.collect.w5;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class TreeBasedTable<R, C, V> extends w7<R, C, V> {
    private static final long serialVersionUID = 0;
    private final Comparator<? super C> columnComparator;

    /* loaded from: classes.dex */
    class a implements h<Map<C, V>, Iterator<C>> {
        a(TreeBasedTable treeBasedTable) {
        }

        /* renamed from: a */
        public Iterator<C> apply(Map<C, V> map) {
            return map.keySet().iterator();
        }
    }

    /* loaded from: classes.dex */
    class b extends com.google.common.collect.c<C> {

        /* renamed from: c  reason: collision with root package name */
        C f11864c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Iterator f11865d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Comparator f11866e;

        b(TreeBasedTable treeBasedTable, Iterator it, Comparator comparator) {
            this.f11865d = it;
            this.f11866e = comparator;
        }

        @Override // com.google.common.collect.c
        protected C a() {
            boolean z10;
            while (this.f11865d.hasNext()) {
                C c10 = (C) this.f11865d.next();
                C c11 = this.f11864c;
                if (c11 == null || this.f11866e.compare(c10, c11) != 0) {
                    z10 = false;
                    continue;
                } else {
                    z10 = true;
                    continue;
                }
                if (!z10) {
                    this.f11864c = c10;
                    return c10;
                }
            }
            this.f11864c = null;
            return b();
        }
    }

    /* loaded from: classes.dex */
    private static class c<C, V> implements v<TreeMap<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super C> comparator;

        c(Comparator<? super C> comparator) {
            this.comparator = comparator;
        }

        /* renamed from: a */
        public TreeMap<C, V> get() {
            return new TreeMap<>(this.comparator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends z7<R, C, V>.g implements SortedMap<C, V> {

        /* renamed from: d  reason: collision with root package name */
        final C f11867d;

        /* renamed from: e  reason: collision with root package name */
        final C f11868e;

        /* renamed from: f  reason: collision with root package name */
        transient SortedMap<C, V> f11869f;

        d(TreeBasedTable treeBasedTable, R r10) {
            this(r10, null, null);
        }

        @Override // java.util.SortedMap
        public Comparator<? super C> comparator() {
            return TreeBasedTable.this.columnComparator();
        }

        @Override // com.google.common.collect.z7.g, java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return o(obj) && super.containsKey(obj);
        }

        @Override // java.util.SortedMap
        public C firstKey() {
            if (g() != null) {
                return g().firstKey();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> headMap(C c10) {
            p.d(o(p.o(c10)));
            return new d(this.f12298a, this.f11867d, c10);
        }

        @Override // com.google.common.collect.z7.g
        void i() {
            if (p() != null && this.f11869f.isEmpty()) {
                TreeBasedTable.this.backingMap.remove(this.f12298a);
                this.f11869f = null;
                this.f12299b = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: k */
        public SortedMap<C, V> g() {
            return (SortedMap) super.g();
        }

        int l(Object obj, Object obj2) {
            return comparator().compare(obj, obj2);
        }

        @Override // java.util.SortedMap
        public C lastKey() {
            if (g() != null) {
                return g().lastKey();
            }
            throw new NoSuchElementException();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: m */
        public SortedMap<C, V> h() {
            SortedMap<C, V> p10 = p();
            if (p10 == null) {
                return null;
            }
            C c10 = this.f11867d;
            if (c10 != null) {
                p10 = p10.tailMap(c10);
            }
            C c11 = this.f11868e;
            return c11 != null ? p10.headMap(c11) : p10;
        }

        /* renamed from: n */
        public SortedSet<C> keySet() {
            return new w5.l(this);
        }

        boolean o(Object obj) {
            C c10;
            C c11;
            return obj != null && ((c10 = this.f11867d) == null || l(c10, obj) <= 0) && ((c11 = this.f11868e) == null || l(c11, obj) > 0);
        }

        SortedMap<C, V> p() {
            SortedMap<C, V> sortedMap = this.f11869f;
            if (sortedMap == null || (sortedMap.isEmpty() && TreeBasedTable.this.backingMap.containsKey(this.f12298a))) {
                this.f11869f = (SortedMap) TreeBasedTable.this.backingMap.get(this.f12298a);
            }
            return this.f11869f;
        }

        @Override // com.google.common.collect.z7.g, java.util.AbstractMap, java.util.Map
        public V put(C c10, V v10) {
            p.d(o(p.o(c10)));
            return (V) super.put(c10, v10);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> subMap(C c10, C c11) {
            p.d(o(p.o(c10)) && o(p.o(c11)));
            return new d(this.f12298a, c10, c11);
        }

        @Override // java.util.SortedMap
        public SortedMap<C, V> tailMap(C c10) {
            p.d(o(p.o(c10)));
            return new d(this.f12298a, c10, this.f11868e);
        }

        d(R r10, C c10, C c11) {
            super(r10);
            this.f11867d = c10;
            this.f11868e = c11;
            p.d(c10 == null || c11 == null || l(c10, c11) <= 0);
        }
    }

    TreeBasedTable(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        super(new TreeMap(comparator), new c(comparator2));
        this.columnComparator = comparator2;
    }

    public static <R extends Comparable, C extends Comparable, V> TreeBasedTable<R, C, V> create() {
        return new TreeBasedTable<>(q6.g(), q6.g());
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Set cellSet() {
        return super.cellSet();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.z7
    public /* bridge */ /* synthetic */ Map column(Object obj) {
        return super.column(obj);
    }

    @Deprecated
    public Comparator<? super C> columnComparator() {
        return this.columnComparator;
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.z7
    Iterator<C> o() {
        Comparator<? super C> columnComparator = columnComparator();
        return new b(this, j5.q(h5.n(this.backingMap.values(), new a(this)), columnComparator), columnComparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.z7, com.google.common.collect.y, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2, Object obj3) {
        return super.put(obj, obj2, obj3);
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ void putAll(c8 c8Var) {
        super.putAll(c8Var);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public /* bridge */ /* synthetic */ Object remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Deprecated
    public Comparator<? super R> rowComparator() {
        return rowKeySet().comparator();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(Comparator<? super R> comparator, Comparator<? super C> comparator2) {
        p.o(comparator);
        p.o(comparator2);
        return new TreeBasedTable<>(comparator, comparator2);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.c8
    public SortedMap<C, V> row(R r10) {
        return new d(this, r10);
    }

    @Override // com.google.common.collect.w7, com.google.common.collect.z7, com.google.common.collect.y, com.google.common.collect.c8
    public SortedSet<R> rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.w7, com.google.common.collect.z7, com.google.common.collect.c8
    public SortedMap<R, Map<C, V>> rowMap() {
        return super.rowMap();
    }

    public static <R, C, V> TreeBasedTable<R, C, V> create(TreeBasedTable<R, C, ? extends V> treeBasedTable) {
        TreeBasedTable<R, C, V> treeBasedTable2 = new TreeBasedTable<>(treeBasedTable.rowComparator(), treeBasedTable.columnComparator());
        treeBasedTable2.putAll(treeBasedTable);
        return treeBasedTable2;
    }
}
