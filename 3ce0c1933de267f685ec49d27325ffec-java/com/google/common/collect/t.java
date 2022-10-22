package com.google.common.collect;

import com.google.common.collect.j;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
/* compiled from: AbstractSetMultimap.java */
/* loaded from: classes.dex */
abstract class t<K, V> extends j<K, V> implements k7<K, V> {
    private static final long serialVersionUID = 7431625294878419160L;

    /* JADX INFO: Access modifiers changed from: protected */
    public t(Map<K, Collection<V>> map) {
        super(map);
    }

    @Override // com.google.common.collect.j
    <E> Collection<E> J(Collection<E> collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // com.google.common.collect.j
    Collection<V> K(K k10, Collection<V> collection) {
        return new j.n(k10, (Set) collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: M */
    public abstract Set<V> x();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: N */
    public Set<V> B() {
        return Collections.emptySet();
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

    @Override // com.google.common.collect.j, com.google.common.collect.o, com.google.common.collect.b6
    public Set<Map.Entry<K, V>> entries() {
        return (Set) super.entries();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public Set<V> get(K k10) {
        return (Set) super.get((t<K, V>) k10);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public Set<V> removeAll(Object obj) {
        return (Set) super.removeAll(obj);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    public Set<V> replaceValues(K k10, Iterable<? extends V> iterable) {
        return (Set) super.replaceValues((t<K, V>) k10, (Iterable) iterable);
    }
}
