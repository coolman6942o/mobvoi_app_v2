package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.base.v;
import com.google.common.collect.w5;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardRowSortedTable.java */
/* loaded from: classes.dex */
public class w7<R, C, V> extends z7<R, C, V> {
    private static final long serialVersionUID = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: StandardRowSortedTable.java */
    /* loaded from: classes.dex */
    public class b extends z7<R, C, V>.h implements SortedMap<R, Map<C, V>> {
        private b() {
            super();
        }

        @Override // java.util.SortedMap
        public Comparator<? super R> comparator() {
            return w7.this.x().comparator();
        }

        @Override // java.util.SortedMap
        public R firstKey() {
            return (R) w7.this.x().firstKey();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: g */
        public SortedSet<R> b() {
            return new w5.l(this);
        }

        /* renamed from: h */
        public SortedSet<R> keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> headMap(R r10) {
            p.o(r10);
            return new w7(w7.this.x().headMap(r10), w7.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public R lastKey() {
            return (R) w7.this.x().lastKey();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> subMap(R r10, R r11) {
            p.o(r10);
            p.o(r11);
            return new w7(w7.this.x().subMap(r10, r11), w7.this.factory).rowMap();
        }

        @Override // java.util.SortedMap
        public SortedMap<R, Map<C, V>> tailMap(R r10) {
            p.o(r10);
            return new w7(w7.this.x().tailMap(r10), w7.this.factory).rowMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w7(SortedMap<R, Map<C, V>> sortedMap, v<? extends Map<C, V>> vVar) {
        super(sortedMap, vVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SortedMap<R, Map<C, V>> x() {
        return (SortedMap) this.backingMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: w */
    public SortedMap<R, Map<C, V>> p() {
        return new b();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.y, com.google.common.collect.c8
    public SortedSet<R> rowKeySet() {
        return (SortedSet) rowMap().keySet();
    }

    @Override // com.google.common.collect.z7, com.google.common.collect.c8
    public SortedMap<R, Map<C, V>> rowMap() {
        return (SortedMap) super.rowMap();
    }
}
