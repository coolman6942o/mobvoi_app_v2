package com.google.common.collect;

import java.io.Serializable;
/* compiled from: ImmutableEntry.java */
/* loaded from: classes.dex */
class b4<K, V> extends n<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final K key;
    final V value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b4(K k10, V v10) {
        this.key = k10;
        this.value = v10;
    }

    @Override // com.google.common.collect.n, java.util.Map.Entry
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.n, java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.n, java.util.Map.Entry
    public final V setValue(V v10) {
        throw new UnsupportedOperationException();
    }
}
