package com.google.common.collect;

import java.lang.Comparable;
import java.util.Set;
/* compiled from: RangeSet.java */
/* loaded from: classes.dex */
public interface w6<C extends Comparable> {
    void add(Range<C> range);

    void addAll(Iterable<Range<C>> iterable);

    Set<Range<C>> asRanges();

    w6<C> complement();

    boolean encloses(Range<C> range);

    boolean enclosesAll(Iterable<Range<C>> iterable);

    boolean isEmpty();

    void remove(Range<C> range);

    void removeAll(w6<C> w6Var);

    void removeAll(Iterable<Range<C>> iterable);

    w6<C> subRangeSet(Range<C> range);
}
