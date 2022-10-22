package com.google.common.collect;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImmutableAsList.java */
/* loaded from: classes.dex */
public abstract class z3<E> extends ImmutableList<E> {
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return l().contains(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return l().g();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return l().isEmpty();
    }

    abstract ImmutableCollection<E> l();

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return l().size();
    }
}
