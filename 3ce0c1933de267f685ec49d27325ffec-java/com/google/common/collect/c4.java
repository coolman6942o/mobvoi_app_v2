package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableMap;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BiConsumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableEnumMap.java */
/* loaded from: classes.dex */
public final class c4<K extends Enum<K>, V> extends ImmutableMap.c<K, V> {
    private final transient EnumMap<K, V> delegate;

    private c4(EnumMap<K, V> enumMap) {
        this.delegate = enumMap;
        p.d(!enumMap.isEmpty());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K extends Enum<K>, V> ImmutableMap<K, V> p(EnumMap<K, V> enumMap) {
        int size = enumMap.size();
        if (size == 0) {
            return ImmutableMap.of();
        }
        if (size != 1) {
            return new c4(enumMap);
        }
        Map.Entry entry = (Map.Entry) h5.h(enumMap.entrySet());
        return ImmutableMap.of((Enum) entry.getKey(), entry.getValue());
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(Object obj) {
        return this.delegate.containsKey(obj);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c4) {
            obj = ((c4) obj).delegate;
        }
        return this.delegate.equals(obj);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        this.delegate.forEach(biConsumer);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return this.delegate.get(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean l() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public p8<K> m() {
        return j5.z(this.delegate.keySet().iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public Spliterator<K> n() {
        return this.delegate.keySet().spliterator();
    }

    @Override // com.google.common.collect.ImmutableMap.c
    p8<Map.Entry<K, V>> o() {
        return w5.t(this.delegate.entrySet().iterator());
    }

    @Override // java.util.Map
    public int size() {
        return this.delegate.size();
    }
}
