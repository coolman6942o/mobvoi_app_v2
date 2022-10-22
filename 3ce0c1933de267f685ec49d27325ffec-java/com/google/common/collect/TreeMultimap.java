package com.google.common.collect;

import com.google.common.base.p;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.BiConsumer;
/* loaded from: classes.dex */
public class TreeMultimap<K, V> extends u<K, V> {
    private static final long serialVersionUID = 0;
    private transient Comparator<? super K> keyComparator;
    private transient Comparator<? super V> valueComparator;

    TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        super(new TreeMap(comparator));
        this.keyComparator = comparator;
        this.valueComparator = comparator2;
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create() {
        return new TreeMultimap<>(q6.g(), q6.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.w
    /* renamed from: O */
    public SortedSet<V> x() {
        return new TreeSet(this.valueComparator);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.o
    Map<K, Collection<V>> a() {
        return z();
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

    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.t, com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.j
    public /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.o, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Deprecated
    public Comparator<? super K> keyComparator() {
        return this.keyComparator;
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ j6 keys() {
        return super.keys();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.o
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

    @Override // com.google.common.collect.w, com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ SortedSet removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.w, com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.o
    public /* bridge */ /* synthetic */ SortedSet replaceValues(Object obj, Iterable iterable) {
        return super.replaceValues((TreeMultimap<K, V>) obj, iterable);
    }

    @Override // com.google.common.collect.j, com.google.common.collect.b6
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public Comparator<? super V> valueComparator() {
        return this.valueComparator;
    }

    @Override // com.google.common.collect.w, com.google.common.collect.j, com.google.common.collect.o
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.j
    public Collection<V> y(K k10) {
        if (k10 == 0) {
            keyComparator().compare(k10, k10);
        }
        return super.y(k10);
    }

    public static <K, V> TreeMultimap<K, V> create(Comparator<? super K> comparator, Comparator<? super V> comparator2) {
        return new TreeMultimap<>((Comparator) p.o(comparator), (Comparator) p.o(comparator2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.o
    public /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    public static <K extends Comparable, V extends Comparable> TreeMultimap<K, V> create(b6<? extends K, ? extends V> b6Var) {
        return new TreeMultimap<>(q6.g(), q6.g(), b6Var);
    }

    @Override // com.google.common.collect.u, com.google.common.collect.w, com.google.common.collect.t, com.google.common.collect.o, com.google.common.collect.b6
    public NavigableMap<K, Collection<V>> asMap() {
        return (NavigableMap) super.asMap();
    }

    @Override // com.google.common.collect.u, com.google.common.collect.o, com.google.common.collect.b6
    public NavigableSet<K> keySet() {
        return (NavigableSet) super.keySet();
    }

    private TreeMultimap(Comparator<? super K> comparator, Comparator<? super V> comparator2, b6<? extends K, ? extends V> b6Var) {
        this(comparator, comparator2);
        putAll(b6Var);
    }

    @Override // com.google.common.collect.w, com.google.common.collect.t, com.google.common.collect.j, com.google.common.collect.b6
    public NavigableSet<V> get(K k10) {
        return (NavigableSet) super.get((TreeMultimap<K, V>) k10);
    }
}
