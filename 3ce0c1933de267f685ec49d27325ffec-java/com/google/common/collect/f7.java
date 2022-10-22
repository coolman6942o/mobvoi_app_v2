package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.j6;
import com.google.common.primitives.d;
import java.util.Comparator;
import java.util.function.ObjIntConsumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableSortedMultiset.java */
/* loaded from: classes.dex */
public final class f7<E> extends ImmutableSortedMultiset<E> {
    private final transient long[] cumulativeCounts;
    final transient g7<E> elementSet;
    private final transient int length;
    private final transient int offset;
    private static final long[] ZERO_CUMULATIVE_COUNTS = {0};
    static final ImmutableSortedMultiset<Comparable> NATURAL_EMPTY_MULTISET = new f7(q6.g());

    /* JADX INFO: Access modifiers changed from: package-private */
    public f7(Comparator<? super E> comparator) {
        this.elementSet = ImmutableSortedSet.t(comparator);
        this.cumulativeCounts = ZERO_CUMULATIVE_COUNTS;
        this.offset = 0;
        this.length = 0;
    }

    private int B(int i10) {
        long[] jArr = this.cumulativeCounts;
        int i11 = this.offset;
        return (int) (jArr[(i11 + i10) + 1] - jArr[i11 + i10]);
    }

    ImmutableSortedMultiset<E> C(int i10, int i11) {
        p.t(i10, i11, this.length);
        if (i10 == i11) {
            return ImmutableSortedMultiset.t(comparator());
        }
        return (i10 == 0 && i11 == this.length) ? this : new f7(this.elementSet.B(i10, i11), this.cumulativeCounts, this.offset + i10, i11 - i10);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public int count(Object obj) {
        int indexOf = this.elementSet.indexOf(obj);
        if (indexOf >= 0) {
            return B(indexOf);
        }
        return 0;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.t7
    public j6.a<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return l(0);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        p.o(objIntConsumer);
        for (int i10 = 0; i10 < this.length; i10++) {
            objIntConsumer.accept((E) this.elementSet.asList().get(i10), B(i10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return this.offset > 0 || this.length < this.cumulativeCounts.length - 1;
    }

    @Override // com.google.common.collect.ImmutableMultiset
    j6.a<E> l(int i10) {
        return m6.g(this.elementSet.asList().get(i10), B(i10));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.t7
    public j6.a<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return l(this.length - 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public int size() {
        long[] jArr = this.cumulativeCounts;
        int i10 = this.offset;
        return d.h(jArr[this.length + i10] - jArr[i10]);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.t7
    public ImmutableSortedMultiset<E> headMultiset(E e10, BoundType boundType) {
        return C(0, this.elementSet.C(e10, p.o(boundType) == BoundType.CLOSED));
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.t7
    public ImmutableSortedMultiset<E> tailMultiset(E e10, BoundType boundType) {
        return C(this.elementSet.D(e10, p.o(boundType) == BoundType.CLOSED), this.length);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public ImmutableSortedSet<E> elementSet() {
        return this.elementSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f7(g7<E> g7Var, long[] jArr, int i10, int i11) {
        this.elementSet = g7Var;
        this.cumulativeCounts = jArr;
        this.offset = i10;
        this.length = i11;
    }
}
