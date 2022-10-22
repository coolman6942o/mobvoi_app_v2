package com.google.common.collect;

import com.google.common.collect.j6;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
/* compiled from: SortedMultiset.java */
/* loaded from: classes.dex */
public interface t7<E> extends q7<E>, q7 {
    @Override // com.google.common.collect.q7
    Comparator<? super E> comparator();

    t7<E> descendingMultiset();

    NavigableSet<E> elementSet();

    Set<j6.a<E>> entrySet();

    j6.a<E> firstEntry();

    t7<E> headMultiset(E e10, BoundType boundType);

    j6.a<E> lastEntry();

    j6.a<E> pollFirstEntry();

    j6.a<E> pollLastEntry();

    t7<E> subMultiset(E e10, BoundType boundType, E e11, BoundType boundType2);

    t7<E> tailMultiset(E e10, BoundType boundType);
}
