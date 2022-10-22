package com.google.common.collect;

import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.j6;
import com.google.common.collect.m6;
import com.google.common.primitives.d;
import java.util.Arrays;
import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableMultiset.java */
/* loaded from: classes.dex */
public class d7<E> extends ImmutableMultiset<E> {
    static final ImmutableMultiset<Object> EMPTY = n(ImmutableList.of());
    static final double HASH_FLOODING_FPP = 0.001d;
    static final int MAX_HASH_BUCKET_LENGTH = 9;
    static final double MAX_LOAD_FACTOR = 1.0d;
    private transient ImmutableSet<E> elementSet;
    private final transient m6.e<E>[] entries;
    private final transient int hashCode;
    private final transient m6.e<E>[] hashTable;
    private final transient int size;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RegularImmutableMultiset.java */
    /* loaded from: classes.dex */
    public static final class a<E> extends m6.e<E> {
        private final m6.e<E> nextInBucket;

        a(E e10, int i10, m6.e<E> eVar) {
            super(e10, i10);
            this.nextInBucket = eVar;
        }

        @Override // com.google.common.collect.m6.e
        public m6.e<E> b() {
            return this.nextInBucket;
        }
    }

    private d7(m6.e<E>[] eVarArr, m6.e<E>[] eVarArr2, int i10, int i11, ImmutableSet<E> immutableSet) {
        this.entries = eVarArr;
        this.hashTable = eVarArr2;
        this.size = i10;
        this.hashCode = i11;
        this.elementSet = immutableSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableMultiset<E> n(Collection<? extends j6.a<? extends E>> collection) {
        m6.e eVar;
        int size = collection.size();
        m6.e[] eVarArr = new m6.e[size];
        if (size == 0) {
            return new d7(eVarArr, null, 0, 0, ImmutableSet.of());
        }
        int a10 = y3.a(size, MAX_LOAD_FACTOR);
        int i10 = a10 - 1;
        m6.e[] eVarArr2 = new m6.e[a10];
        long j10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (j6.a<? extends E> aVar : collection) {
            Object o10 = p.o(aVar.a());
            int count = aVar.getCount();
            int hashCode = o10.hashCode();
            int c10 = y3.c(hashCode) & i10;
            m6.e eVar2 = eVarArr2[c10];
            if (eVar2 != null) {
                eVar = new a(o10, count, eVar2);
            } else if ((aVar instanceof m6.e) && !(aVar instanceof a)) {
                eVar = (m6.e) aVar;
            } else {
                eVar = new m6.e(o10, count);
            }
            i11 += hashCode ^ count;
            i12++;
            eVarArr[i12] = eVar;
            eVarArr2[c10] = eVar;
            j10 += count;
        }
        if (o(eVarArr2)) {
            return n5.n(ImmutableList.h(eVarArr));
        }
        return new d7(eVarArr, eVarArr2, d.h(j10), i11, null);
    }

    private static boolean o(m6.e<?>[] eVarArr) {
        for (m6.e<?> eVar : eVarArr) {
            int i10 = 0;
            for (; eVar != null; eVar = eVar.b()) {
                i10++;
                if (i10 > 9) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public int count(Object obj) {
        m6.e<E>[] eVarArr = this.hashTable;
        if (!(obj == null || eVarArr == null)) {
            for (m6.e<E> eVar = eVarArr[y3.d(obj) & (eVarArr.length - 1)]; eVar != null; eVar = eVar.b()) {
                if (m.a(obj, eVar.a())) {
                    return eVar.getCount();
                }
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection, com.google.common.collect.j6
    public int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    j6.a<E> l(int i10) {
        return this.entries[i10];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public int size() {
        return this.size;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableMultiset.c cVar = new ImmutableMultiset.c(Arrays.asList(this.entries), this);
        this.elementSet = cVar;
        return cVar;
    }
}
