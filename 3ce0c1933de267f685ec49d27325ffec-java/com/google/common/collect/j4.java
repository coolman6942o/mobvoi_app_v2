package com.google.common.collect;

import com.google.common.base.p;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableMapKeySet.java */
/* loaded from: classes.dex */
public final class j4<K, V> extends f5<K> {
    private final ImmutableMap<K, V> map;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j4(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.f5, java.lang.Iterable
    public void forEach(final Consumer<? super K> consumer) {
        p.o(consumer);
        this.map.forEach(new BiConsumer() { // from class: com.google.common.collect.i4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                consumer.accept(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.f5
    public K get(int i10) {
        return this.map.entrySet().asList().get(i10).getKey();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.f5, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<K> spliterator() {
        return this.map.n();
    }

    @Override // com.google.common.collect.f5, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<K> iterator() {
        return this.map.m();
    }
}
