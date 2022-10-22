package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.c8;
import java.util.Map;
/* compiled from: SingletonImmutableTable.java */
/* loaded from: classes.dex */
class p7<R, C, V> extends ImmutableTable<R, C, V> {
    final C singleColumnKey;
    final R singleRowKey;
    final V singleValue;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p7(R r10, C c10, V v10) {
        this.singleRowKey = (R) p.o(r10);
        this.singleColumnKey = (C) p.o(c10);
        this.singleValue = (V) p.o(v10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: l */
    public ImmutableSet<c8.a<R, C, V>> c() {
        return ImmutableSet.of(ImmutableTable.j(this.singleRowKey, this.singleColumnKey, this.singleValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: m */
    public ImmutableCollection<V> d() {
        return ImmutableSet.of(this.singleValue);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.c8
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableTable
    public ImmutableMap<R, V> column(C c10) {
        p.o(c10);
        if (containsColumn(c10)) {
            return ImmutableMap.of(this.singleRowKey, (Object) this.singleValue);
        }
        return ImmutableMap.of();
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.c8
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.of(this.singleColumnKey, ImmutableMap.of(this.singleRowKey, (Object) this.singleValue));
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.c8
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.of(this.singleRowKey, ImmutableMap.of(this.singleColumnKey, (Object) this.singleValue));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public p7(c8.a<R, C, V> aVar) {
        this(aVar.b(), aVar.a(), aVar.getValue());
    }
}
