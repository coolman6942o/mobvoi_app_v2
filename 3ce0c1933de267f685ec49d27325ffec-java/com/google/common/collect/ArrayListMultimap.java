package com.google.common.collect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
/* loaded from: classes.dex */
public final class ArrayListMultimap<K, V> extends z<K, V> {
    private static final int DEFAULT_VALUES_PER_KEY = 3;
    private static final long serialVersionUID = 0;
    transient int expectedValuesPerKey;

    private ArrayListMultimap() {
        this(12, 3);
    }

    public static <K, V> ArrayListMultimap<K, V> create() {
        return new ArrayListMultimap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.d
    /* renamed from: M */
    public List<V> x() {
        return new ArrayList(this.expectedValuesPerKey);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ Collection entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.d, com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ List get(Object obj) {
        return super.get((ArrayListMultimap<K, V>) obj);
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ j6 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.j, com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean putAll(b6 b6Var) {
        return super.putAll(b6Var);
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.d, com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ List removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.d, com.google.common.collect.j, com.google.common.collect.o
    public /* bridge */ /* synthetic */ List replaceValues(Object obj, Iterable iterable) {
        return super.replaceValues((ArrayListMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Deprecated
    public void trimToSize() {
        Iterator<Collection<V>> it = w().values().iterator();
        while (it.hasNext()) {
            ((ArrayList) it.next()).trimToSize();
        }
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    private ArrayListMultimap(int i10, int i11) {
        super(s6.c(i10));
        p2.b(i11, "expectedValuesPerKey");
        this.expectedValuesPerKey = i11;
    }

    public static <K, V> ArrayListMultimap<K, V> create(int i10, int i11) {
        return new ArrayListMultimap<>(i10, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K, V> ArrayListMultimap<K, V> create(b6<? extends K, ? extends V> b6Var) {
        return new ArrayListMultimap<>(b6Var);
    }

    private ArrayListMultimap(b6<? extends K, ? extends V> b6Var) {
        this(b6Var.keySet().size(), b6Var instanceof ArrayListMultimap ? ((ArrayListMultimap) b6Var).expectedValuesPerKey : 3);
        putAll(b6Var);
    }
}
