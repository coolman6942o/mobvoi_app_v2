package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.h4;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JdkBackedImmutableMap.java */
/* loaded from: classes.dex */
public final class m5<K, V> extends ImmutableMap<K, V> {
    private final transient Map<K, V> delegateMap;
    private final transient ImmutableList<Map.Entry<K, V>> entries;

    m5(Map<K, V> map, ImmutableList<Map.Entry<K, V>> immutableList) {
        this.delegateMap = map;
        this.entries = immutableList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> ImmutableMap<K, V> p(int i10, Map.Entry<K, V>[] entryArr) {
        HashMap l10 = w5.l(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            entryArr[i11] = c7.s(entryArr[i11]);
            Object putIfAbsent = l10.putIfAbsent(entryArr[i11].getKey(), entryArr[i11].getValue());
            if (putIfAbsent != null) {
                Map.Entry<K, V> entry = entryArr[i11];
                String valueOf = String.valueOf(entryArr[i11].getKey());
                String valueOf2 = String.valueOf(putIfAbsent);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
                sb2.append(valueOf);
                sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb2.append(valueOf2);
                throw ImmutableMap.b("key", entry, sb2.toString());
            }
        }
        return new m5(l10, ImmutableList.i(entryArr, i10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(BiConsumer biConsumer, Map.Entry entry) {
        biConsumer.accept(entry.getKey(), entry.getValue());
    }

    @Override // java.util.Map
    public void forEach(final BiConsumer<? super K, ? super V> biConsumer) {
        p.o(biConsumer);
        this.entries.forEach(new Consumer() { // from class: com.google.common.collect.l5
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                m5.q(biConsumer, (Map.Entry) obj);
            }
        });
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> g() {
        return new h4.a(this, this.entries);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(Object obj) {
        return this.delegateMap.get(obj);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> h() {
        return new j4(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> i() {
        return new m4(this);
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
}
