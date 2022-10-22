package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: Multimap.java */
/* loaded from: classes.dex */
public interface b6<K, V> {
    Map<K, Collection<V>> asMap();

    void clear();

    boolean containsEntry(Object obj, Object obj2);

    boolean containsKey(Object obj);

    Collection<Map.Entry<K, V>> entries();

    Collection<V> get(K k10);

    boolean isEmpty();

    Set<K> keySet();

    boolean putAll(b6<? extends K, ? extends V> b6Var);

    boolean remove(Object obj, Object obj2);

    Collection<V> removeAll(Object obj);

    int size();
}
