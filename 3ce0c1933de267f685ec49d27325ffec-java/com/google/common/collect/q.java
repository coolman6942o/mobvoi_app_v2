package com.google.common.collect;

import com.google.common.collect.w5;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractNavigableMap.java */
/* loaded from: classes.dex */
public abstract class q<K, V> extends w5.i<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractNavigableMap.java */
    /* loaded from: classes.dex */
    public final class b extends w5.f<K, V> {
        private b() {
        }

        @Override // com.google.common.collect.w5.f
        Iterator<Map.Entry<K, V>> h() {
            return q.this.g();
        }

        @Override // com.google.common.collect.w5.f
        NavigableMap<K, V> i() {
            return q.this;
        }
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k10) {
        return tailMap(k10, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k10) {
        return (K) w5.i(ceilingEntry(k10));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return new b();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) j5.o(a(), null);
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k10) {
        return headMap(k10, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k10) {
        return (K) w5.i(floorEntry(k10));
    }

    abstract Iterator<Map.Entry<K, V>> g();

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K k10) {
        return headMap(k10, false);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k10) {
        return tailMap(k10, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k10) {
        return (K) w5.i(higherEntry(k10));
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        return navigableKeySet();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) j5.o(g(), null);
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k10) {
        return headMap(k10, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k10) {
        return (K) w5.i(lowerEntry(k10));
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return new w5.k(this);
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) j5.s(a());
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) j5.s(g());
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(K k10, K k11) {
        return subMap(k10, true, k11, false);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(K k10) {
        return tailMap(k10, true);
    }
}
