package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.c8;
import java.util.LinkedHashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SparseImmutableTable.java */
/* loaded from: classes.dex */
public final class v7<R, C, V> extends h7<R, C, V> {
    static final ImmutableTable<Object, Object, Object> EMPTY = new v7(ImmutableList.of(), ImmutableSet.of(), ImmutableSet.of());
    private final int[] cellColumnInRowIndices;
    private final int[] cellRowIndices;
    private final ImmutableMap<C, ImmutableMap<R, V>> columnMap;
    private final ImmutableMap<R, ImmutableMap<C, V>> rowMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public v7(ImmutableList<c8.a<R, C, V>> immutableList, ImmutableSet<R> immutableSet, ImmutableSet<C> immutableSet2) {
        ImmutableMap f10 = w5.f(immutableSet);
        LinkedHashMap m10 = w5.m();
        p8<R> it = immutableSet.iterator();
        while (it.hasNext()) {
            m10.put(it.next(), new LinkedHashMap());
        }
        LinkedHashMap m11 = w5.m();
        p8<C> it2 = immutableSet2.iterator();
        while (it2.hasNext()) {
            m11.put(it2.next(), new LinkedHashMap());
        }
        int[] iArr = new int[immutableList.size()];
        int[] iArr2 = new int[immutableList.size()];
        for (int i10 = 0; i10 < immutableList.size(); i10++) {
            c8.a<R, C, V> aVar = immutableList.get(i10);
            R b10 = aVar.b();
            C a10 = aVar.a();
            V value = aVar.getValue();
            iArr[i10] = ((Integer) f10.get(b10)).intValue();
            Map map = (Map) m10.get(b10);
            iArr2[i10] = map.size();
            n(b10, a10, map.put(a10, value), value);
            ((Map) m11.get(a10)).put(b10, value);
        }
        this.cellRowIndices = iArr;
        this.cellColumnInRowIndices = iArr2;
        ImmutableMap.b bVar = new ImmutableMap.b(m10.size());
        for (Map.Entry entry : m10.entrySet()) {
            bVar.d(entry.getKey(), ImmutableMap.copyOf((Map) entry.getValue()));
        }
        this.rowMap = bVar.a();
        ImmutableMap.b bVar2 = new ImmutableMap.b(m11.size());
        for (Map.Entry entry2 : m11.entrySet()) {
            bVar2.d(entry2.getKey(), ImmutableMap.copyOf((Map) entry2.getValue()));
        }
        this.columnMap = bVar2.a();
    }

    @Override // com.google.common.collect.h7
    c8.a<R, C, V> r(int i10) {
        Map.Entry<R, ImmutableMap<C, V>> entry = this.rowMap.entrySet().asList().get(this.cellRowIndices[i10]);
        Map.Entry<C, V> entry2 = entry.getValue().entrySet().asList().get(this.cellColumnInRowIndices[i10]);
        return ImmutableTable.j(entry.getKey(), entry2.getKey(), entry2.getValue());
    }

    @Override // com.google.common.collect.h7
    V s(int i10) {
        int i11 = this.cellRowIndices[i10];
        return this.rowMap.values().asList().get(i11).values().asList().get(this.cellColumnInRowIndices[i10]);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.c8
    public int size() {
        return this.cellRowIndices.length;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.c8
    public ImmutableMap<C, Map<R, V>> columnMap() {
        return ImmutableMap.copyOf((Map) this.columnMap);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.c8
    public ImmutableMap<R, Map<C, V>> rowMap() {
        return ImmutableMap.copyOf((Map) this.rowMap);
    }
}
