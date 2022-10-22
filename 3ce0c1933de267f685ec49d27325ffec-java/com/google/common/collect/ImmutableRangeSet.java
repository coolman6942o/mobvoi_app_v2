package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.s7;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public final class ImmutableRangeSet<C extends Comparable> extends r<C> implements Serializable {
    private transient ImmutableRangeSet<C> complement;
    private final transient ImmutableList<Range<C>> ranges;
    private static final ImmutableRangeSet<Comparable<?>> EMPTY = new ImmutableRangeSet<>(ImmutableList.of());
    private static final ImmutableRangeSet<Comparable<?>> ALL = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ImmutableList<Range<C>> {
        final /* synthetic */ int val$fromIndex;
        final /* synthetic */ int val$length;
        final /* synthetic */ Range val$range;

        a(int i10, int i11, Range range) {
            this.val$length = i10;
            this.val$fromIndex = i11;
            this.val$range = range;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return true;
        }

        /* renamed from: l */
        public Range<C> get(int i10) {
            p.m(i10, this.val$length);
            return (i10 == 0 || i10 == this.val$length + (-1)) ? ((Range) ImmutableRangeSet.this.ranges.get(i10 + this.val$fromIndex)).intersection(this.val$range) : (Range) ImmutableRangeSet.this.ranges.get(i10 + this.val$fromIndex);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$length;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b extends ImmutableSortedSet<C> {
        private final h3<C> domain;
        private transient Integer size;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends com.google.common.collect.c<C> {

            /* renamed from: c  reason: collision with root package name */
            final Iterator<Range<C>> f11787c;

            /* renamed from: d  reason: collision with root package name */
            Iterator<C> f11788d = j5.h();

            a() {
                this.f11787c = ImmutableRangeSet.this.ranges.iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public C a() {
                while (!this.f11788d.hasNext()) {
                    if (!this.f11787c.hasNext()) {
                        return (C) b();
                    }
                    this.f11788d = ContiguousSet.create(this.f11787c.next(), b.this.domain).iterator();
                }
                return this.f11788d.next();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.collect.ImmutableRangeSet$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0142b extends com.google.common.collect.c<C> {

            /* renamed from: c  reason: collision with root package name */
            final Iterator<Range<C>> f11790c;

            /* renamed from: d  reason: collision with root package name */
            Iterator<C> f11791d = j5.h();

            C0142b() {
                this.f11790c = ImmutableRangeSet.this.ranges.reverse().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public C a() {
                while (!this.f11791d.hasNext()) {
                    if (!this.f11790c.hasNext()) {
                        return (C) b();
                    }
                    this.f11791d = ContiguousSet.create(this.f11790c.next(), b.this.domain).descendingIterator();
                }
                return this.f11791d.next();
            }
        }

        b(h3<C> h3Var) {
            super(q6.g());
            this.domain = h3Var;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: C */
        public ImmutableSortedSet<C> u(C c10, boolean z10) {
            return D(Range.upTo(c10, BoundType.b(z10)));
        }

        ImmutableSortedSet<C> D(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet(this.domain);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: F */
        public ImmutableSortedSet<C> w(C c10, boolean z10, C c11, boolean z11) {
            if (z10 || z11 || Range.b(c10, c11) != 0) {
                return D(Range.range(c10, BoundType.b(z10), c11, BoundType.b(z11)));
            }
            return ImmutableSortedSet.of();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: G */
        public ImmutableSortedSet<C> y(C c10, boolean z10) {
            return D(Range.downTo(c10, BoundType.b(z10)));
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return ImmutableRangeSet.this.ranges.g();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSortedSet
        public int indexOf(Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Comparable comparable = (Comparable) obj;
            long j10 = 0;
            p8 it = ImmutableRangeSet.this.ranges.iterator();
            while (it.hasNext()) {
                Range range = (Range) it.next();
                if (range.contains(comparable)) {
                    return com.google.common.primitives.d.h(j10 + ContiguousSet.create(range, this.domain).indexOf(comparable));
                }
                j10 += ContiguousSet.create(range, this.domain).size();
            }
            throw new AssertionError("impossible");
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        ImmutableSortedSet<C> s() {
            return new f3(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer num = this.size;
            if (num == null) {
                long j10 = 0;
                p8 it = ImmutableRangeSet.this.ranges.iterator();
                while (it.hasNext()) {
                    j10 += ContiguousSet.create((Range) it.next(), this.domain).size();
                    if (j10 >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(com.google.common.primitives.d.h(j10));
                this.size = num;
            }
            return num.intValue();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.ranges.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        public p8<C> descendingIterator() {
            return new C0142b();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public p8<C> iterator() {
            return new a();
        }
    }

    /* loaded from: classes.dex */
    public static class c<C extends Comparable<?>> {

        /* renamed from: a  reason: collision with root package name */
        private final List<Range<C>> f11793a = s5.g();

        public c<C> a(Range<C> range) {
            p.j(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.f11793a.add(range);
            return this;
        }

        public c<C> b(Iterable<Range<C>> iterable) {
            for (Range<C> range : iterable) {
                a(range);
            }
            return this;
        }

        public ImmutableRangeSet<C> c() {
            ImmutableList.b bVar = new ImmutableList.b(this.f11793a.size());
            Collections.sort(this.f11793a, Range.g());
            r6 r10 = j5.r(this.f11793a.iterator());
            while (r10.hasNext()) {
                Range range = (Range) r10.next();
                while (r10.hasNext()) {
                    Range<C> range2 = (Range) r10.peek();
                    if (range.isConnected(range2)) {
                        p.k(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                        range = range.span((Range) r10.next());
                    }
                }
                bVar.a(range);
            }
            ImmutableList h10 = bVar.h();
            if (h10.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (h10.size() != 1 || !((Range) h5.h(h10)).equals(Range.all())) {
                return new ImmutableRangeSet<>(h10);
            }
            return ImmutableRangeSet.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c<C> d(c<C> cVar) {
            b(cVar.f11793a);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class d extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        d() {
            boolean hasLowerBound = ((Range) ImmutableRangeSet.this.ranges.get(0)).hasLowerBound();
            this.positiveBoundedBelow = hasLowerBound;
            boolean hasUpperBound = ((Range) h5.f(ImmutableRangeSet.this.ranges)).hasUpperBound();
            this.positiveBoundedAbove = hasUpperBound;
            int size = ImmutableRangeSet.this.ranges.size() - 1;
            size = hasLowerBound ? size + 1 : size;
            this.size = hasUpperBound ? size + 1 : size;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return true;
        }

        /* renamed from: l */
        public Range<C> get(int i10) {
            c3<C> c3Var;
            c3<C> c3Var2;
            p.m(i10, this.size);
            if (this.positiveBoundedBelow) {
                c3Var = i10 == 0 ? c3.c() : ((Range) ImmutableRangeSet.this.ranges.get(i10 - 1)).upperBound;
            } else {
                c3Var = ((Range) ImmutableRangeSet.this.ranges.get(i10)).upperBound;
            }
            if (!this.positiveBoundedAbove || i10 != this.size - 1) {
                c3Var2 = ((Range) ImmutableRangeSet.this.ranges.get(i10 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
            } else {
                c3Var2 = c3.a();
            }
            return Range.c(c3Var, c3Var2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.ranges = immutableList;
    }

    static <C extends Comparable> ImmutableRangeSet<C> b() {
        return ALL;
    }

    public static <C extends Comparable<?>> c<C> builder() {
        return new c<>();
    }

    private ImmutableList<Range<C>> c(Range<C> range) {
        int i10;
        if (this.ranges.isEmpty() || range.isEmpty()) {
            return ImmutableList.of();
        }
        if (range.encloses(span())) {
            return this.ranges;
        }
        int a10 = range.hasLowerBound() ? s7.a(this.ranges, Range.i(), range.lowerBound, s7.c.FIRST_AFTER, s7.b.NEXT_HIGHER) : 0;
        if (range.hasUpperBound()) {
            i10 = s7.a(this.ranges, Range.d(), range.upperBound, s7.c.FIRST_PRESENT, s7.b.NEXT_HIGHER);
        } else {
            i10 = this.ranges.size();
        }
        int i11 = i10 - a10;
        if (i11 == 0) {
            return ImmutableList.of();
        }
        return new a(i11, a10, range);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(w6<C> w6Var) {
        p.o(w6Var);
        if (w6Var.isEmpty()) {
            return of();
        }
        if (w6Var.encloses(Range.all())) {
            return b();
        }
        if (w6Var instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) w6Var;
            if (!immutableRangeSet.d()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) w6Var.asRanges()));
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return EMPTY;
    }

    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> toImmutableRangeSet() {
        return o2.U();
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.r
    @Deprecated
    public void addAll(w6<C> w6Var) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(h3<C> h3Var) {
        p.o(h3Var);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(h3Var);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    h3Var.d();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new b(h3Var);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    @Override // com.google.common.collect.r
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.r
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    boolean d() {
        return this.ranges.g();
    }

    public ImmutableRangeSet<C> difference(w6<C> w6Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(w6Var);
        return copyOf(create);
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public boolean encloses(Range<C> range) {
        int b10 = s7.b(this.ranges, Range.d(), range.lowerBound, q6.g(), s7.c.ANY_PRESENT, s7.b.NEXT_LOWER);
        return b10 != -1 && this.ranges.get(b10).encloses(range);
    }

    @Override // com.google.common.collect.r
    public /* bridge */ /* synthetic */ boolean enclosesAll(w6 w6Var) {
        return super.enclosesAll(w6Var);
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable<Range<C>> iterable) {
        return v6.b(this, iterable);
    }

    @Override // com.google.common.collect.r
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(w6<C> w6Var) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(w6Var.complement());
        return copyOf(create);
    }

    @Override // com.google.common.collect.r
    public boolean intersects(Range<C> range) {
        int b10 = s7.b(this.ranges, Range.d(), range.lowerBound, q6.g(), s7.c.ANY_PRESENT, s7.b.NEXT_HIGHER);
        if (b10 < this.ranges.size() && this.ranges.get(b10).isConnected(range) && !this.ranges.get(b10).intersection(range).isEmpty()) {
            return true;
        }
        if (b10 > 0) {
            int i10 = b10 - 1;
            if (this.ranges.get(i10).isConnected(range) && !this.ranges.get(i10).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public boolean isEmpty() {
        return this.ranges.isEmpty();
    }

    @Override // com.google.common.collect.r
    public Range<C> rangeContaining(C c10) {
        int b10 = s7.b(this.ranges, Range.d(), c3.d(c10), q6.g(), s7.c.ANY_PRESENT, s7.b.NEXT_LOWER);
        if (b10 == -1) {
            return null;
        }
        Range<C> range = this.ranges.get(b10);
        if (range.contains(c10)) {
            return range;
        }
        return null;
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    @Deprecated
    public void removeAll(w6<C> w6Var) {
        throw new UnsupportedOperationException();
    }

    public Range<C> span() {
        if (!this.ranges.isEmpty()) {
            c3<C> c3Var = this.ranges.get(0).lowerBound;
            ImmutableList<Range<C>> immutableList = this.ranges;
            return Range.c(c3Var, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public ImmutableRangeSet<C> union(w6<C> w6Var) {
        return unionOf(h5.c(asRanges(), w6Var.asRanges()));
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        p.o(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return b();
        }
        return new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new g7(this.ranges.reverse(), Range.g().j());
    }

    @Override // com.google.common.collect.w6
    public ImmutableSet<Range<C>> asRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableSet.of();
        }
        return new g7(this.ranges, Range.g());
    }

    @Override // com.google.common.collect.w6
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.complement;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.ranges.isEmpty()) {
            ImmutableRangeSet<C> b10 = b();
            this.complement = b10;
            return b10;
        } else if (this.ranges.size() != 1 || !this.ranges.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new d(), this);
            this.complement = immutableRangeSet2;
            return immutableRangeSet2;
        } else {
            ImmutableRangeSet<C> of2 = of();
            this.complement = of2;
            return of2;
        }
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.w6
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(c(range));
            }
        }
        return of();
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.ranges = immutableList;
        this.complement = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new c().b(iterable).c();
    }
}
