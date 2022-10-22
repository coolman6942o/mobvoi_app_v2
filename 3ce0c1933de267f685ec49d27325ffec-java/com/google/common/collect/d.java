package com.google.common.collect;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
/* compiled from: AbstractListMultimap.java */
/* loaded from: classes.dex */
abstract class d<K, V> extends j<K, V> implements q5<K, V> {
    private static final long serialVersionUID = 6588350623831699109L;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.j
    <E> Collection<E> J(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // com.google.common.collect.j
    Collection<V> K(K k10, Collection<V> collection) {
        return L(k10, (List) collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: M */
    public abstract List<V> x();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: N */
    public List<V> B() {
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public Map<K, Collection<V>> asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.o
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    public boolean put(K k10, V v10) {
        return super.put(k10, v10);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public List<V> get(K k10) {
        return (List) super.get((d<K, V>) k10);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public List<V> removeAll(Object obj) {
        return (List) super.removeAll(obj);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    public List<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        return (List) super.replaceValues((d<K, V>) k10, (Iterable) iterable);
    }
}
