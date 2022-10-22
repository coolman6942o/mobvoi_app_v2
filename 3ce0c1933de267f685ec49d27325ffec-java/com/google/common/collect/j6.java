package com.google.common.collect;

import java.util.Collection;
import java.util.Set;
import java.util.function.ObjIntConsumer;
/* compiled from: Multiset.java */
/* loaded from: classes.dex */
public interface j6<E> extends Collection<E> {

    /* compiled from: Multiset.java */
    /* loaded from: classes.dex */
    public interface a<E> {
        E a();

        int getCount();

        String toString();
    }

    int add(E e10, int i10);

    @Override // java.util.Collection
    boolean add(E e10);

    @Override // java.util.Collection, com.google.common.collect.j6
    boolean contains(Object obj);

    @Override // java.util.Collection
    boolean containsAll(Collection<?> collection);

    int count(Object obj);

    Set<E> elementSet();

    Set<a<E>> entrySet();

    @Override // com.google.common.collect.j6
    boolean equals(Object obj);

    void forEachEntry(ObjIntConsumer<? super E> objIntConsumer);

    @Override // com.google.common.collect.j6
    int hashCode();

    int remove(Object obj, int i10);

    @Override // java.util.Collection
    boolean remove(Object obj);

    int setCount(E e10, int i10);

    boolean setCount(E e10, int i10, int i11);

    @Override // java.util.Collection, com.google.common.collect.j6
    int size();
}
