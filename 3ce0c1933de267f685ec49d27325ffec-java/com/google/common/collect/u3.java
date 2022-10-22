package com.google.common.collect;

import java.util.Comparator;
import java.util.SortedSet;
/* compiled from: ForwardingSortedSet.java */
/* loaded from: classes.dex */
public abstract class u3<E> extends t3<E> implements SortedSet<E> {
    @Override // java.util.SortedSet
    public Comparator<? super E> comparator() {
        return l().comparator();
    }

    @Override // java.util.SortedSet
    public E first() {
        return l().first();
    }

    @Override // java.util.SortedSet
    public SortedSet<E> headSet(E e10) {
        return l().headSet(e10);
    }

    @Override // java.util.SortedSet
    public E last() {
        return l().last();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public abstract SortedSet<E> l();

    @Override // java.util.SortedSet
    public SortedSet<E> subSet(E e10, E e11) {
        return l().subSet(e10, e11);
    }

    @Override // java.util.SortedSet
    public SortedSet<E> tailSet(E e10) {
        return l().tailSet(e10);
    }
}
