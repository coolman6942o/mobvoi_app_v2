package com.google.common.collect;

import com.google.common.collect.j6;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DescendingImmutableSortedMultiset.java */
/* loaded from: classes.dex */
public final class e3<E> extends ImmutableSortedMultiset<E> {
    private final transient ImmutableSortedMultiset<E> forward;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e3(ImmutableSortedMultiset<E> immutableSortedMultiset) {
        this.forward = immutableSortedMultiset;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public int count(Object obj) {
        return this.forward.count(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.t7
    public j6.a<E> firstEntry() {
        return this.forward.lastEntry();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return this.forward.g();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    j6.a<E> l(int i10) {
        return this.forward.entrySet().asList().reverse().get(i10);
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.t7
    public j6.a<E> lastEntry() {
        return this.forward.firstEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.j6
    public int size() {
        return this.forward.size();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.t7
    public ImmutableSortedMultiset<E> descendingMultiset() {
        return this.forward;
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.t7
    public ImmutableSortedMultiset<E> headMultiset(E e10, BoundType boundType) {
        return this.forward.tailMultiset((ImmutableSortedMultiset<E>) e10, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.t7
    public ImmutableSortedMultiset<E> tailMultiset(E e10, BoundType boundType) {
        return this.forward.headMultiset((ImmutableSortedMultiset<E>) e10, boundType).descendingMultiset();
    }

    @Override // com.google.common.collect.ImmutableSortedMultiset, com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public ImmutableSortedSet<E> elementSet() {
        return this.forward.elementSet().descendingSet();
    }
}
