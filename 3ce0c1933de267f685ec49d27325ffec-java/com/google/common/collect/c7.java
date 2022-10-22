package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.g4;
import com.google.common.collect.h4;
import java.util.Map;
import java.util.function.BiConsumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableMap.java */
/* loaded from: classes.dex */
public final class c7<K, V> extends ImmutableMap<K, V> {
    static final ImmutableMap<Object, Object> EMPTY = new c7(ImmutableMap.EMPTY_ENTRY_ARRAY, null, 0);
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_HASH_BUCKET_LENGTH = 8;
    static final double MAX_LOAD_FACTOR = 1.2d;
    private static final long serialVersionUID = 0;
    final transient Map.Entry<K, V>[] entries;
    private final transient int mask;
    private final transient g4<K, V>[] table;

    /* compiled from: RegularImmutableMap.java */
    /* loaded from: classes.dex */
    private static final class a<K> extends f5<K> {
        private final c7<K, ?> map;

        a(c7<K, ?> c7Var) {
            this.map = c7Var;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.f5
        public K get(int i10) {
            return this.map.entries[i10].getKey();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }
    }

    /* compiled from: RegularImmutableMap.java */
    /* loaded from: classes.dex */
    private static final class b<K, V> extends ImmutableList<V> {
        final c7<K, V> map;

        b(c7<K, V> c7Var) {
            this.map = c7Var;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return true;
        }

        @Override // java.util.List
        public V get(int i10) {
            return this.map.entries[i10].getValue();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.map.size();
        }
    }

    private c7(Map.Entry<K, V>[] entryArr, g4<K, V>[] g4VarArr, int i10) {
        this.entries = entryArr;
        this.table = g4VarArr;
        this.mask = i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(Object obj, Map.Entry<?, ?> entry, g4<?, ?> g4Var) {
        int i10 = 0;
        while (g4Var != null) {
            ImmutableMap.a(!obj.equals(g4Var.getKey()), "key", entry, g4Var);
            i10++;
            g4Var = g4Var.h();
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableMap<K, V> p(Map.Entry<K, V>... entryArr) {
        return q(entryArr.length, entryArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableMap<K, V> q(int i10, Map.Entry<K, V>[] entryArr) {
        g4 g4Var;
        p.r(i10, entryArr.length);
        if (i10 == 0) {
            return (c7) EMPTY;
        }
        Map.Entry<K, V>[] g10 = i10 == entryArr.length ? entryArr : g4.g(i10);
        int a10 = y3.a(i10, MAX_LOAD_FACTOR);
        g4[] g11 = g4.g(a10);
        int i11 = a10 - 1;
        for (int i12 = 0; i12 < i10; i12++) {
            Map.Entry<K, V> entry = entryArr[i12];
            K key = entry.getKey();
            V value = entry.getValue();
            p2.a(key, value);
            int c10 = y3.c(key.hashCode()) & i11;
            g4 g4Var2 = g11[c10];
            if (g4Var2 == null) {
                g4Var = t(entry, key, value);
            } else {
                g4Var = new g4.b(key, value, g4Var2);
            }
            g11[c10] = g4Var;
            g10[i12] = g4Var;
            if (o(key, g4Var, g4Var2) > 8) {
                return m5.p(i10, entryArr);
            }
        }
        return new c7(g10, g11, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <V> V r(Object obj, g4<?, V>[] g4VarArr, int i10) {
        if (!(obj == null || g4VarArr == null)) {
            for (g4<?, V> g4Var = g4VarArr[i10 & y3.c(obj.hashCode())]; g4Var != null; g4Var = g4Var.h()) {
                if (obj.equals(g4Var.getKey())) {
                    return g4Var.getValue();
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> g4<K, V> s(Map.Entry<K, V> entry) {
        return t(entry, entry.getKey(), entry.getValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> g4<K, V> t(Map.Entry<K, V> entry, K k10, V v10) {
        return (entry instanceof g4) && ((g4) entry).j() ? (g4) entry : new g4<>(k10, v10);
    }

    @Override // java.util.Map
    public void forEach(BiConsumer<? super K, ? super V> biConsumer) {
        Map.Entry<K, V>[] entryArr;
        p.o(biConsumer);
        for (Map.Entry<K, V> entry : this.entries) {
            biConsumer.accept((K) entry.getKey(), (V) entry.getValue());
        }
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> g() {
        return new h4.a(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return (V) r(obj, this.table, this.mask);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> h() {
        return new a(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> i() {
        return new b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean l() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.length;
    }
}
