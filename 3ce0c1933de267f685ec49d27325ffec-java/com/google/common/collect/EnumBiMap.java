package com.google.common.collect;

import com.google.common.base.p;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
/* loaded from: classes.dex */
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends a<K, V> {
    private static final long serialVersionUID = 0;
    private transient Class<K> keyType;
    private transient Class<V> valueType;

    private EnumBiMap(Class<K> cls, Class<V> cls2) {
        super(new EnumMap(cls), new EnumMap(cls2));
        this.keyType = cls;
        this.valueType = cls2;
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> cls, Class<V> cls2) {
        return new EnumBiMap<>(cls, cls2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K extends Enum<K>> Class<K> w(Map<K, ?> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap) map).keyType();
        }
        p.d(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    private static <V extends Enum<V>> Class<V> y(Map<?, V> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).valueType;
        }
        p.d(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }

    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.a
    public /* bridge */ /* synthetic */ Object forcePut(Object obj, Object obj2) {
        return super.forcePut(obj, obj2);
    }

    @Override // com.google.common.collect.a
    public /* bridge */ /* synthetic */ e0 inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public Class<K> keyType() {
        return this.keyType;
    }

    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.a, java.util.Map
    public /* bridge */ /* synthetic */ void replaceAll(BiFunction biFunction) {
        super.replaceAll(biFunction);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: t */
    public K k(K k10) {
        return (K) p.o(k10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: u */
    public V l(V v10) {
        return (V) p.o(v10);
    }

    public Class<V> valueType() {
        return this.valueType;
    }

    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> map) {
        EnumBiMap<K, V> create = create(w(map), y(map));
        create.putAll(map);
        return create;
    }
}
