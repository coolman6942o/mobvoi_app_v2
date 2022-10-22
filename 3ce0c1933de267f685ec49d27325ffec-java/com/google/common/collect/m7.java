package com.google.common.collect;

import com.google.common.base.p;
import java.util.Map;
import java.util.function.BiConsumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingletonImmutableBiMap.java */
/* loaded from: classes.dex */
public final class m7<K, V> extends ImmutableBiMap<K, V> {
    private final transient ImmutableBiMap<V, K> inverse;
    private transient ImmutableBiMap<V, K> lazyInverse;
    final transient K singleKey;
    final transient V singleValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m7(K k10, V v10) {
        p2.a(k10, v10);
        this.singleKey = k10;
        this.singleValue = v10;
        this.inverse = null;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.singleKey.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(Object obj) {
        return this.singleValue.equals(obj);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        ((BiConsumer) p.o(biConsumer)).accept(this.singleKey, this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> g() {
        return ImmutableSet.of(w5.e(this.singleKey, this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        if (this.singleKey.equals(obj)) {
            return this.singleValue;
        }
        return null;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> h() {
        return ImmutableSet.of(this.singleKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean l() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableBiMap
    public ImmutableBiMap<V, K> inverse() {
        ImmutableBiMap<V, K> immutableBiMap = this.inverse;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        ImmutableBiMap<V, K> immutableBiMap2 = this.lazyInverse;
        if (immutableBiMap2 != null) {
            return immutableBiMap2;
        }
        m7 m7Var = new m7(this.singleValue, this.singleKey, this);
        this.lazyInverse = m7Var;
        return m7Var;
    }

    private m7(K k10, V v10, ImmutableBiMap<V, K> immutableBiMap) {
        this.singleKey = k10;
        this.singleValue = v10;
        this.inverse = immutableBiMap;
    }
}
