package com.google.common.collect;

import java.util.Comparator;
import java.util.Objects;
import java.util.Spliterator;
/* compiled from: ImmutableSortedAsList.java */
/* loaded from: classes.dex */
final class u4<E> extends y6<E> implements q7<E> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public u4(ImmutableSortedSet<E> immutableSortedSet, ImmutableList<E> immutableList) {
        super(immutableSortedSet, immutableList);
    }

    @Override // com.google.common.collect.q7
    public Comparator<? super E> comparator() {
        return l().comparator();
    }

    @Override // com.google.common.collect.z3, com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(Object obj) {
        int indexOf = l().indexOf(obj);
        if (indexOf < 0 || !get(indexOf).equals(obj)) {
            return -1;
        }
        return indexOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList
    public ImmutableList<E> k(int i10, int i11) {
        return new g7(super.k(i10, i11), comparator()).asList();
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(Object obj) {
        return indexOf(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public ImmutableSortedSet<E> l() {
        return (ImmutableSortedSet) super.l();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        int size = size();
        ImmutableList<? extends E> m10 = m();
        Objects.requireNonNull(m10);
        return s2.d(size, 1301, new e4(m10), comparator());
    }
}
