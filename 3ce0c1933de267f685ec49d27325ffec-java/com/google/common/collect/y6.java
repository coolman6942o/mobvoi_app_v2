package com.google.common.collect;

import java.util.function.Consumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableAsList.java */
/* loaded from: classes.dex */
public class y6<E> extends z3<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y6(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i10) {
        return this.delegateList.a(objArr, i10);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object[] b() {
        return this.delegateList.b();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int c() {
        return this.delegateList.c();
    }

    @Override // com.google.common.collect.ImmutableCollection
    int d() {
        return this.delegateList.d();
    }

    @Override // com.google.common.collect.ImmutableList, java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        this.delegateList.forEach(consumer);
    }

    @Override // java.util.List
    public E get(int i10) {
        return this.delegateList.get(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.z3
    public ImmutableCollection<E> l() {
        return this.delegate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList<? extends E> m() {
        return this.delegateList;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public q8<E> listIterator(int i10) {
        return (q8<? extends E>) this.delegateList.listIterator(i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y6(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.h(objArr));
    }
}
