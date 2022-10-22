package com.google.common.collect;

import com.google.common.base.p;
import java.util.Comparator;
import java.util.SortedSet;
/* compiled from: SortedIterables.java */
/* loaded from: classes.dex */
final class r7 {
    public static <E> Comparator<? super E> a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        return comparator == null ? q6.g() : comparator;
    }

    public static boolean b(Comparator<?> comparator, Iterable<?> iterable) {
        Comparator comparator2;
        p.o(comparator);
        p.o(iterable);
        if (iterable instanceof SortedSet) {
            comparator2 = a((SortedSet) iterable);
        } else if (!(iterable instanceof q7)) {
            return false;
        } else {
            comparator2 = ((q7) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
