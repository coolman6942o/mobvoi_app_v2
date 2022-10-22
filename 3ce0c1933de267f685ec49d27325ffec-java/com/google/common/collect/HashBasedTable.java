package com.google.common.collect;

import com.google.common.base.v;
import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class HashBasedTable<R, C, V> extends z7<R, C, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a<C, V> implements v<Map<C, V>>, Serializable {
        private static final long serialVersionUID = 0;
        final int expectedSize;

        a(int i10) {
            this.expectedSize = i10;
        }

        /* renamed from: a */
        public Map<C, V> get() {
            return w5.n(this.expectedSize);
        }
    }

    HashBasedTable(Map<R, Map<C, V>> map, a<C, V> aVar) {
        super(map, aVar);
    }

    public static <R, C, V> HashBasedTable<R, C, V> create() {
        return new HashBasedTable<>(new LinkedHashMap(), new a(0));
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

    @Override // com.google.common.collect.z7, com.google.common.collect.y, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Set columnKeySet() {
        return super.columnKeySet();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Map columnMap() {
        return super.columnMap();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public boolean contains(Object obj, Object obj2) {
        return super.contains(obj, obj2);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.y
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y, com.google.common.collect.c8
    public V get(Object obj, Object obj2) {
        return (V) super.get(obj, obj2);
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
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
    public V remove(Object obj, Object obj2) {
        return (V) super.remove(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.z7, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Map row(Object obj) {
        return super.row(obj);
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Set rowKeySet() {
        return super.rowKeySet();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Map rowMap() {
        return super.rowMap();
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

    public static <R, C, V> HashBasedTable<R, C, V> create(int i10, int i11) {
        p2.b(i11, "expectedCellsPerRow");
        return new HashBasedTable<>(w5.n(i10), new a(i11));
    }

    public static <R, C, V> HashBasedTable<R, C, V> create(c8<? extends R, ? extends C, ? extends V> c8Var) {
        HashBasedTable<R, C, V> create = create();
        create.putAll(c8Var);
        return create;
    }
}
