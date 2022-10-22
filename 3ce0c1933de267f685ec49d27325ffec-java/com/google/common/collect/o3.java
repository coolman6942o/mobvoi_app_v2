package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* compiled from: ForwardingMap.java */
/* loaded from: classes.dex */
public abstract class o3<K, V> extends r3 implements Map<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public abstract Map<K, V> a();

    public void clear() {
        a().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return a().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return a().containsValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String d() {
        return w5.r(this);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return a().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return obj == this || a().equals(obj);
    }

    @Override // java.util.Map
    public V get(Object obj) {
        return a().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return a().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return a().isEmpty();
    }

    public Set<K> keySet() {
        return a().keySet();
    }

    public V put(K k10, V v10) {
        return a().put(k10, v10);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a().putAll(map);
    }

    public V remove(Object obj) {
        return a().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return a().size();
    }

    public Collection<V> values() {
        return a().values();
    }
}
