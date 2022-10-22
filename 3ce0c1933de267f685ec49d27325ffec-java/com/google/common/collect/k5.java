package com.google.common.collect;

import com.google.common.collect.h4;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JdkBackedImmutableBiMap.java */
/* loaded from: classes.dex */
public final class k5<K, V> extends ImmutableBiMap<K, V> {
    private final Map<V, K> backwardDelegate;
    private final transient ImmutableList<Map.Entry<K, V>> entries;
    private final Map<K, V> forwardDelegate;
    private transient k5<V, K> inverse;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: JdkBackedImmutableBiMap.java */
    /* loaded from: classes.dex */
    public final class b extends ImmutableList<Map.Entry<V, K>> {
        private b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return false;
        }

        /* renamed from: l */
        public Map.Entry<V, K> get(int i10) {
            Map.Entry entry = (Map.Entry) k5.this.entries.get(i10);
            return w5.e(entry.getValue(), entry.getKey());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return k5.this.entries.size();
        }
    }

    private k5(ImmutableList<Map.Entry<K, V>> immutableList, Map<K, V> map, Map<V, K> map2) {
        this.entries = immutableList;
        this.forwardDelegate = map;
        this.backwardDelegate = map2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableBiMap<K, V> q(int i10, Map.Entry<K, V>[] entryArr) {
        HashMap l10 = w5.l(i10);
        HashMap l11 = w5.l(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            g4 s10 = c7.s(entryArr[i11]);
            entryArr[i11] = s10;
            Object putIfAbsent = l10.putIfAbsent(s10.getKey(), s10.getValue());
            if (putIfAbsent == null) {
                Object putIfAbsent2 = l11.putIfAbsent(s10.getValue(), s10.getKey());
                if (putIfAbsent2 != null) {
                    String valueOf = String.valueOf(putIfAbsent2);
                    String valueOf2 = String.valueOf(s10.getValue());
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
                    sb2.append(valueOf);
                    sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb2.append(valueOf2);
                    throw ImmutableMap.b(HealthDataProviderContracts.NAME_VALUE, sb2.toString(), entryArr[i11]);
                }
            } else {
                String valueOf3 = String.valueOf(s10.getKey());
                String valueOf4 = String.valueOf(putIfAbsent);
                StringBuilder sb3 = new StringBuilder(valueOf3.length() + 1 + valueOf4.length());
                sb3.append(valueOf3);
                sb3.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb3.append(valueOf4);
                throw ImmutableMap.b("key", sb3.toString(), entryArr[i11]);
            }
        }
        return new k5(ImmutableList.i(entryArr, i10), l10, l11);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> g() {
        return new h4.a(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return this.forwardDelegate.get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> h() {
        return new j4(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean l() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.entries.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableBiMap
    public ImmutableBiMap<V, K> inverse() {
        k5<V, K> k5Var = this.inverse;
        if (k5Var != null) {
            return k5Var;
        }
        k5<V, K> k5Var2 = new k5<>(new b(), this.backwardDelegate, this.forwardDelegate);
        this.inverse = k5Var2;
        k5Var2.inverse = this;
        return k5Var2;
    }
}
