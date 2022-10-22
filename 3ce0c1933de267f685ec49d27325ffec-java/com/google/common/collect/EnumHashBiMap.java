package com.google.common.collect;

import com.google.common.base.p;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
/* loaded from: classes.dex */
public final class EnumHashBiMap<K extends Enum<K>, V> extends a<K, V> {
    private static final long serialVersionUID = 0;
    private transient Class<K> keyType;

    private EnumHashBiMap(Class<K> cls) {
        super(new EnumMap(cls), w5.l(cls.getEnumConstants().length));
        this.keyType = cls;
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> cls) {
        return new EnumHashBiMap<>(cls);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a
    public /* bridge */ /* synthetic */ Object forcePut(Object obj, Object obj2) {
        return forcePut((EnumHashBiMap<K, V>) ((Enum) obj), (Enum) obj2);
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((EnumHashBiMap<K, V>) ((Enum) obj), (Enum) obj2);
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

    @Override // com.google.common.collect.a, com.google.common.collect.o3, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> create = create(EnumBiMap.w(map));
        create.putAll(map);
        return create;
    }

    public V forcePut(K k10, V v10) {
        return (V) super.forcePut((EnumHashBiMap<K, V>) k10, (K) v10);
    }

    public V put(K k10, V v10) {
        return (V) super.put((EnumHashBiMap<K, V>) k10, (K) v10);
    }
}
