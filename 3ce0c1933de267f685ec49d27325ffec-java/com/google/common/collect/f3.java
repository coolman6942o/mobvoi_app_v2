package com.google.common.collect;
/* compiled from: DescendingImmutableSortedSet.java */
/* loaded from: classes.dex */
final class f3<E> extends ImmutableSortedSet<E> {
    private final ImmutableSortedSet<E> forward;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f3(ImmutableSortedSet<E> immutableSortedSet) {
        super(q6.a(immutableSortedSet.comparator()).j());
        this.forward = immutableSortedSet;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e10) {
        return this.forward.floor(e10);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.forward.contains(obj);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e10) {
        return this.forward.ceiling(e10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return this.forward.g();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e10) {
        return this.forward.lower(e10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        int indexOf = this.forward.indexOf(obj);
        return indexOf == -1 ? indexOf : (size() - 1) - indexOf;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e10) {
        return this.forward.higher(e10);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> s() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.forward.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> u(E e10, boolean z10) {
        return this.forward.tailSet((ImmutableSortedSet<E>) e10, z10).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> w(E e10, boolean z10, E e11, boolean z11) {
        return this.forward.subSet((boolean) e11, z11, (boolean) e10, z10).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> y(E e10, boolean z10) {
        return this.forward.headSet((ImmutableSortedSet<E>) e10, z10).descendingSet();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public p8<E> descendingIterator() {
        return this.forward.iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        return this.forward;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<E> iterator() {
        return this.forward.descendingIterator();
    }
}
