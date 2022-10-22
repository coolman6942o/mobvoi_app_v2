package com.google.common.collect;

import java.util.Set;
/* compiled from: JdkBackedImmutableSet.java */
/* loaded from: classes.dex */
final class o5<E> extends f5<E> {
    private final Set<?> delegate;
    private final ImmutableList<E> delegateList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o5(Set<?> set, ImmutableList<E> immutableList) {
        this.delegate = set;
        this.delegateList = immutableList;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.delegate.contains(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.f5
    public E get(int i10) {
        return this.delegateList.get(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.delegateList.size();
    }
}
