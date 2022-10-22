package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.g4;
import com.google.common.collect.h4;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableBiMap.java */
/* loaded from: classes.dex */
public class z6<K, V> extends ImmutableBiMap<K, V> {
    static final z6<Object, Object> EMPTY = new z6<>(null, null, ImmutableMap.EMPTY_ENTRY_ARRAY, 0, 0);
    static final double MAX_LOAD_FACTOR = 1.2d;
    final transient Map.Entry<K, V>[] entries;
    private final transient int hashCode;
    private transient ImmutableBiMap<V, K> inverse;
    private final transient g4<K, V>[] keyTable;
    private final transient int mask;
    private final transient g4<K, V>[] valueTable;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RegularImmutableBiMap.java */
    /* loaded from: classes.dex */
    public final class b extends ImmutableBiMap<V, K> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: RegularImmutableBiMap.java */
        /* loaded from: classes.dex */
        public final class a extends h4<V, K> {

            /* compiled from: RegularImmutableBiMap.java */
            /* renamed from: com.google.common.collect.z6$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            class C0151a extends z3<Map.Entry<V, K>> {
                C0151a() {
                }

                @Override // com.google.common.collect.z3
                ImmutableCollection<Map.Entry<V, K>> l() {
                    return a.this;
                }

                /* renamed from: m */
                public Map.Entry<V, K> get(int i10) {
                    Map.Entry<K, V> entry = z6.this.entries[i10];
                    return w5.e(entry.getValue(), entry.getKey());
                }
            }

            a() {
            }

            @Override // java.lang.Iterable
            public void forEach(Consumer<? super Map.Entry<V, K>> consumer) {
                asList().forEach(consumer);
            }

            @Override // com.google.common.collect.h4, com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
            public int hashCode() {
                return z6.this.hashCode;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableSet
            public ImmutableList<Map.Entry<V, K>> m() {
                return new C0151a();
            }

            @Override // com.google.common.collect.h4, com.google.common.collect.ImmutableSet
            boolean o() {
                return true;
            }

            @Override // com.google.common.collect.h4
            ImmutableMap<V, K> r() {
                return b.this;
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
            public p8<Map.Entry<V, K>> iterator() {
                return (p8<Map.Entry<K, V>>) asList().iterator();
            }
        }

        private b() {
        }

        @Override // java.util.Map
        public void forEach(final BiConsumer<? super V, ? super K> biConsumer) {
            p.o(biConsumer);
            z6.this.forEach(new BiConsumer() { // from class: com.google.common.collect.a7
                @Override // java.util.function.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    biConsumer.accept(obj2, obj);
                }
            });
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<Map.Entry<V, K>> g() {
            return new a();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public K get(Object obj) {
            if (!(obj == null || z6.this.valueTable == null)) {
                for (g4 g4Var = z6.this.valueTable[y3.c(obj.hashCode()) & z6.this.mask]; g4Var != null; g4Var = g4Var.i()) {
                    if (obj.equals(g4Var.getValue())) {
                        return g4Var.getKey();
                    }
                }
            }
            return null;
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet<V> h() {
            return new j4(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap
        public boolean l() {
            return false;
        }

        @Override // java.util.Map
        public int size() {
            return inverse().size();
        }

        @Override // com.google.common.collect.ImmutableBiMap
        public ImmutableBiMap<K, V> inverse() {
            return z6.this;
        }
    }

    private z6(g4<K, V>[] g4VarArr, g4<K, V>[] g4VarArr2, Map.Entry<K, V>[] entryArr, int i10, int i11) {
        this.keyTable = g4VarArr;
        this.valueTable = g4VarArr2;
        this.entries = entryArr;
        this.mask = i10;
        this.hashCode = i11;
    }

    private static int s(Object obj, Map.Entry<?, ?> entry, g4<?, ?> g4Var) {
        int i10 = 0;
        while (g4Var != null) {
            ImmutableMap.a(!obj.equals(g4Var.getValue()), HealthDataProviderContracts.NAME_VALUE, entry, g4Var);
            i10++;
            g4Var = g4Var.i();
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableBiMap<K, V> t(Map.Entry<K, V>... entryArr) {
        return u(entryArr.length, entryArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableBiMap<K, V> u(int i10, Map.Entry<K, V>[] entryArr) {
        g4 g4Var;
        int i11 = i10;
        Map.Entry<K, V>[] entryArr2 = entryArr;
        p.r(i11, entryArr2.length);
        int a10 = y3.a(i11, MAX_LOAD_FACTOR);
        int i12 = a10 - 1;
        g4[] g10 = g4.g(a10);
        g4[] g11 = g4.g(a10);
        g4[] g12 = i11 == entryArr2.length ? entryArr2 : g4.g(i10);
        int i13 = 0;
        int i14 = 0;
        while (i13 < i11) {
            Map.Entry<K, V> entry = entryArr2[i13];
            K key = entry.getKey();
            V value = entry.getValue();
            p2.a(key, value);
            int hashCode = key.hashCode();
            int hashCode2 = value.hashCode();
            int c10 = y3.c(hashCode) & i12;
            int c11 = y3.c(hashCode2) & i12;
            g4 g4Var2 = g10[c10];
            int o10 = c7.o(key, entry, g4Var2);
            g4 g4Var3 = g11[c11];
            i12 = i12;
            int s10 = s(value, entry, g4Var3);
            int i15 = i14;
            if (o10 > 8 || s10 > 8) {
                return k5.q(i10, entryArr);
            }
            if (g4Var3 == null && g4Var2 == null) {
                g4Var = c7.t(entry, key, value);
            } else {
                g4Var = new g4.a(key, value, g4Var2, g4Var3);
            }
            g10[c10] = g4Var;
            g11[c11] = g4Var;
            g12[i13] = g4Var;
            i14 = i15 + (hashCode ^ hashCode2);
            i13++;
            i11 = i10;
            entryArr2 = entryArr;
        }
        return new z6(g10, g11, g12, i12, i14);
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
        if (isEmpty()) {
            return ImmutableSet.of();
        }
        return new h4.a(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        g4<K, V>[] g4VarArr = this.keyTable;
        if (g4VarArr == null) {
            return null;
        }
        return (V) c7.r(obj, g4VarArr, this.mask);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> h() {
        return new j4(this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return this.hashCode;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean k() {
        return true;
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

    @Override // com.google.common.collect.ImmutableBiMap
    public ImmutableBiMap<V, K> inverse() {
        if (isEmpty()) {
            return ImmutableBiMap.of();
        }
        ImmutableBiMap<V, K> immutableBiMap = this.inverse;
        if (immutableBiMap != null) {
            return immutableBiMap;
        }
        b bVar = new b();
        this.inverse = bVar;
        return bVar;
    }
}
