package com.google.common.collect;

import com.google.common.collect.j;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.NavigableSet;
import java.util.SortedSet;
/* compiled from: AbstractSortedSetMultimap.java */
/* loaded from: classes.dex */
abstract class w<K, V> extends t<K, V> {
    private static final long serialVersionUID = 430848587173315748L;

    /* JADX INFO: Access modifiers changed from: protected */
    public w(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.t, com.google.common.collect.j
    Collection<V> K(K k10, Collection<V> collection) {
        if (collection instanceof NavigableSet) {
            return new j.m(k10, (NavigableSet) collection, null);
        }
        return new j.o(k10, (SortedSet) collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: O */
    public abstract SortedSet<V> x();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: P */
    public SortedSet<V> N() {
        return (SortedSet<V>) J(x());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Q */
    public <E> SortedSet<E> J(Collection<E> collection) {
        if (collection instanceof NavigableSet) {
            return l7.i((NavigableSet) collection);
        }
        return Collections.unmodifiableSortedSet((SortedSet) collection);
    }

    @Override // com.google.common.collect.t, com.google.common.collect.o, com.google.common.collect.b6
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    public Collection<V> values() {
        return super.values();
    }

    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.b6
    public SortedSet<V> get(K k10) {
        return (SortedSet) super.get((w<K, V>) k10);
    }

    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.b6
    public SortedSet<V> removeAll(Object obj) {
        return (SortedSet) super.removeAll(obj);
    }

    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.o
    public SortedSet<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        return (SortedSet) super.replaceValues((w<K, V>) k10, (Iterable) iterable);
    }
}
