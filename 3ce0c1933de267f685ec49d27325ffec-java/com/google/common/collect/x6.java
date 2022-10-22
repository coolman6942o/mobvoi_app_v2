package com.google.common.collect;

import com.google.common.base.p;
import java.lang.Comparable;
import java.util.Collection;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularContiguousSet.java */
/* loaded from: classes.dex */
public final class x6<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegularContiguousSet.java */
    /* loaded from: classes.dex */
    public class a extends s<C> {

        /* renamed from: b  reason: collision with root package name */
        final C f12259b;

        a(Comparable comparable) {
            super(comparable);
            this.f12259b = (C) x6.this.last();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b */
        public C a(C c10) {
            if (x6.G(c10, this.f12259b)) {
                return null;
            }
            return x6.this.domain.h(c10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegularContiguousSet.java */
    /* loaded from: classes.dex */
    public class b extends s<C> {

        /* renamed from: b  reason: collision with root package name */
        final C f12261b;

        b(Comparable comparable) {
            super(comparable);
            this.f12261b = (C) x6.this.first();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: b */
        public C a(C c10) {
            if (x6.G(c10, this.f12261b)) {
                return null;
            }
            return x6.this.domain.j(c10);
        }
    }

    /* compiled from: RegularContiguousSet.java */
    /* loaded from: classes.dex */
    class c extends z3<C> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: m */
        public ImmutableSortedSet<C> l() {
            return x6.this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: n */
        public C get(int i10) {
            p.m(i10, size());
            x6 x6Var = x6.this;
            return (C) x6Var.domain.i(x6Var.first(), i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x6(Range<C> range, h3<C> h3Var) {
        super(h3Var);
        this.range = range;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean G(Comparable<?> comparable, Comparable<?> comparable2) {
        return comparable2 != null && Range.b(comparable, comparable2) == 0;
    }

    private ContiguousSet<C> J(Range<C> range) {
        if (this.range.isConnected(range)) {
            return ContiguousSet.create(this.range.intersection(range), this.domain);
        }
        return new i3(this.domain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: B */
    public ContiguousSet<C> u(C c10, boolean z10) {
        return J(Range.upTo(c10, BoundType.b(z10)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: C */
    public ContiguousSet<C> w(C c10, boolean z10, C c11, boolean z11) {
        if (c10.compareTo(c11) != 0 || z10 || z11) {
            return J(Range.range(c10, BoundType.b(z10), c11, BoundType.b(z11)));
        }
        return new i3(this.domain);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ContiguousSet
    /* renamed from: D */
    public ContiguousSet<C> y(C c10, boolean z10) {
        return J(Range.downTo(c10, BoundType.b(z10)));
    }

    /* renamed from: H */
    public C first() {
        return this.range.lowerBound.n(this.domain);
    }

    /* renamed from: K */
    public C last() {
        return this.range.upperBound.l(this.domain);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        return y2.a(this, collection);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x6) {
            x6 x6Var = (x6) obj;
            if (this.domain.equals(x6Var.domain)) {
                return first().equals(x6Var.first()) && last().equals(x6Var.last());
            }
        }
        return super.equals(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public int hashCode() {
        return l7.b(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        if (contains(obj)) {
            return (int) this.domain.a(first(), (Comparable) obj);
        }
        return -1;
    }

    @Override // com.google.common.collect.ContiguousSet
    public ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        p.o(contiguousSet);
        p.d(this.domain.equals(contiguousSet.domain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) q6.g().c(first(), (Comparable) contiguousSet.first());
        Comparable comparable2 = (Comparable) q6.g().d(last(), (Comparable) contiguousSet.last());
        if (comparable.compareTo(comparable2) <= 0) {
            return ContiguousSet.create(Range.closed(comparable, comparable2), this.domain);
        }
        return new i3(this.domain);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<C> m() {
        if (this.domain.supportsFastOffset) {
            return new c();
        }
        return super.m();
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range() {
        BoundType boundType = BoundType.CLOSED;
        return range(boundType, boundType);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        long a10 = this.domain.a(first(), last());
        if (a10 >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) a10) + 1;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public p8<C> descendingIterator() {
        return new b(last());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<C> iterator() {
        return new a(first());
    }

    @Override // com.google.common.collect.ContiguousSet
    public Range<C> range(BoundType boundType, BoundType boundType2) {
        return Range.c(this.range.lowerBound.v(boundType, this.domain), this.range.upperBound.w(boundType2, this.domain));
    }
}
