package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.j6;
import com.google.common.collect.m6;
import com.google.common.primitives.d;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JdkBackedImmutableMultiset.java */
/* loaded from: classes.dex */
public final class n5<E> extends ImmutableMultiset<E> {
    private final Map<E, Integer> delegateMap;
    private transient ImmutableSet<E> elementSet;
    private final ImmutableList<j6.a<E>> entries;
    private final long size;

    private n5(Map<E, Integer> map, ImmutableList<j6.a<E>> immutableList, long j10) {
        this.delegateMap = map;
        this.entries = immutableList;
        this.size = j10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMultiset<E> n(Collection<? extends j6.a<? extends E>> collection) {
        j6.a[] aVarArr = (j6.a[]) collection.toArray(new j6.a[0]);
        HashMap l10 = w5.l(aVarArr.length);
        long j10 = 0;
        for (int i10 = 0; i10 < aVarArr.length; i10++) {
            j6.a aVar = aVarArr[i10];
            int count = aVar.getCount();
            j10 += count;
            Object o10 = p.o(aVar.a());
            l10.put(o10, Integer.valueOf(count));
            if (!(aVar instanceof m6.e)) {
                aVarArr[i10] = m6.g(o10, count);
            }
        }
        return new n5(l10, ImmutableList.h(aVarArr), j10);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public int count(Object obj) {
        return this.delegateMap.getOrDefault(obj, 0).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    j6.a<E> l(int i10) {
        return this.entries.get(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public int size() {
        return d.h(this.size);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableMultiset.c cVar = new ImmutableMultiset.c(this.entries, this);
        this.elementSet = cVar;
        return cVar;
    }
}
