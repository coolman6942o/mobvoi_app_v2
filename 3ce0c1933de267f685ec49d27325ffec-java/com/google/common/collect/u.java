package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
/* compiled from: AbstractSortedKeySortedSetMultimap.java */
/* loaded from: classes.dex */
abstract class u<K, V> extends w<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    Set<K> c() {
        return A();
    }

    @Override // com.google.common.collect.w, com.google.common.collect.t, com.google.common.collect.o, com.google.common.collect.b6
    public SortedMap<K, Collection<V>> asMap() {
        return (SortedMap) super.asMap();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }
}
