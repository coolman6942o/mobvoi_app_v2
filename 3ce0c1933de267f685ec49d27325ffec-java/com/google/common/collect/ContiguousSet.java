package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableSortedSet;
import java.lang.Comparable;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final h3<C> domain;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContiguousSet(h3<C> h3Var) {
        super(q6.g());
        this.domain = h3Var;
    }

    @Deprecated
    public static <E> ImmutableSortedSet.b<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int i10, int i11) {
        return create(Range.closed(Integer.valueOf(i10), Integer.valueOf(i11)), h3.b());
    }

    public static ContiguousSet<Integer> closedOpen(int i10, int i11) {
        return create(Range.closedOpen(Integer.valueOf(i10), Integer.valueOf(i11)), h3.b());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, h3<C> h3Var) {
        p.o(range);
        p.o(h3Var);
        try {
            Range<C> intersection = !range.hasLowerBound() ? range.intersection(Range.atLeast(h3Var.g())) : range;
            if (!range.hasUpperBound()) {
                intersection = intersection.intersection(Range.atMost(h3Var.d()));
            }
            if (intersection.isEmpty() || Range.b(range.lowerBound.n(h3Var), range.upperBound.l(h3Var)) > 0) {
                return new i3(h3Var);
            }
            return new x6(intersection, h3Var);
        } catch (NoSuchElementException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: B */
    public abstract ContiguousSet<C> u(C c10, boolean z10);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: C */
    public abstract ContiguousSet<C> w(C c10, boolean z10, C c11, boolean z11);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: D */
    public abstract ContiguousSet<C> y(C c10, boolean z10);

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<C> s() {
        return new f3(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    public static ContiguousSet<Long> closed(long j10, long j11) {
        return create(Range.closed(Long.valueOf(j10), Long.valueOf(j11)), h3.c());
    }

    public static ContiguousSet<Long> closedOpen(long j10, long j11) {
        return create(Range.closedOpen(Long.valueOf(j10), Long.valueOf(j11)), h3.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> headSet(C c10) {
        return u((Comparable) p.o(c10), false);
    }

    public ContiguousSet<C> subSet(C c10, C c11) {
        p.o(c10);
        p.o(c11);
        p.d(comparator().compare(c10, c11) <= 0);
        return w(c10, true, c11, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> tailSet(C c10) {
        return y((Comparable) p.o(c10), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> headSet(C c10, boolean z10) {
        return u((Comparable) p.o(c10), z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> tailSet(C c10, boolean z10) {
        return y((Comparable) p.o(c10), z10);
    }

    public ContiguousSet<C> subSet(C c10, boolean z10, C c11, boolean z11) {
        p.o(c10);
        p.o(c11);
        p.d(comparator().compare(c10, c11) <= 0);
        return w(c10, z10, c11, z11);
    }
}
