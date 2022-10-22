package com.google.common.collect;

import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableMapEntrySet.java */
/* loaded from: classes.dex */
public abstract class h4<K, V> extends ImmutableSet<Map.Entry<K, V>> {

    /* compiled from: ImmutableMapEntrySet.java */
    /* loaded from: classes.dex */
    static final class a<K, V> extends h4<K, V> {
        private final transient ImmutableList<Map.Entry<K, V>> entries;
        private final transient ImmutableMap<K, V> map;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(ImmutableMap<K, V> immutableMap, Map.Entry<K, V>[] entryArr) {
            this(immutableMap, ImmutableList.h(entryArr));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public int a(Object[] objArr, int i10) {
            return this.entries.a(objArr, i10);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super Map.Entry<K, V>> consumer) {
            this.entries.forEach(consumer);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSet
        public ImmutableList<Map.Entry<K, V>> m() {
            return new y6(this, this.entries);
        }

        @Override // com.google.common.collect.h4
        ImmutableMap<K, V> r() {
            return this.map;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
        public Spliterator<Map.Entry<K, V>> spliterator() {
            return this.entries.spliterator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(ImmutableMap<K, V> immutableMap, ImmutableList<Map.Entry<K, V>> immutableList) {
            this.map = immutableMap;
            this.entries = immutableList;
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public p8<Map.Entry<K, V>> iterator() {
            return this.entries.iterator();
        }
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        V v10 = r().get(entry.getKey());
        return v10 != null && v10.equals(entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return r().l();
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return r().hashCode();
    }

    @Override // com.google.common.collect.ImmutableSet
    boolean o() {
        return r().k();
    }

    abstract ImmutableMap<K, V> r();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return r().size();
    }
}
