package com.google.common.collect;

import com.google.common.base.m;
import java.util.Map;
/* compiled from: ForwardingMapEntry.java */
/* loaded from: classes.dex */
public abstract class p3<K, V> extends r3 implements Map.Entry<K, V> {
    protected abstract Map.Entry<K, V> b();

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return m.a(getKey(), entry.getKey()) && m.a(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        return b().equals(obj);
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return b().getKey();
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return b().getValue();
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return b().hashCode();
    }

    public V setValue(V v10) {
        return b().setValue(v10);
    }
}
