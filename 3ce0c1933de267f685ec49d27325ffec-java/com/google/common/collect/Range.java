package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.p;
import com.google.common.base.q;
import com.google.common.base.r;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
/* loaded from: classes.dex */
public final class Range<C extends Comparable> extends t6 implements r<C> {
    private static final Range<Comparable> ALL = new Range<>(c3.c(), c3.a());
    private static final long serialVersionUID = 0;
    final c3<C> lowerBound;
    final c3<C> upperBound;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11861a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f11861a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11861a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    static class b implements h<Range, c3> {

        /* renamed from: a  reason: collision with root package name */
        static final b f11862a = new b();

        b() {
        }

        /* renamed from: a */
        public c3 apply(Range range) {
            return range.lowerBound;
        }
    }

    /* loaded from: classes.dex */
    private static class c extends q6<Range<?>> implements Serializable {
        static final q6<Range<?>> INSTANCE = new c();
        private static final long serialVersionUID = 0;

        private c() {
        }

        /* renamed from: k */
        public int compare(Range<?> range, Range<?> range2) {
            return a3.f().d(range.lowerBound, range2.lowerBound).d(range.upperBound, range2.upperBound).e();
        }
    }

    /* loaded from: classes.dex */
    static class d implements h<Range, c3> {

        /* renamed from: a  reason: collision with root package name */
        static final d f11863a = new d();

        d() {
        }

        /* renamed from: a */
        public c3 apply(Range range) {
            return range.upperBound;
        }
    }

    private Range(c3<C> c3Var, c3<C> c3Var2) {
        this.lowerBound = (c3) p.o(c3Var);
        this.upperBound = (c3) p.o(c3Var2);
        if (c3Var.compareTo(c3Var2) > 0 || c3Var == c3.a() || c3Var2 == c3.c()) {
            String valueOf = String.valueOf(h(c3Var, c3Var2));
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid range: ".concat(valueOf) : new String("Invalid range: "));
        }
    }

    private static <T> SortedSet<T> a(Iterable<T> iterable) {
        return (SortedSet) iterable;
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c10) {
        return c(c3.d(c10), c3.a());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c10) {
        return c(c3.c(), c3.b(c10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Range<C> c(c3<C> c3Var, c3<C> c3Var2) {
        return new Range<>(c3Var, c3Var2);
    }

    public static <C extends Comparable<?>> Range<C> closed(C c10, C c11) {
        return c(c3.d(c10), c3.b(c11));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c10, C c11) {
        return c(c3.d(c10), c3.d(c11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> h<Range<C>, c3<C>> d() {
        return b.f11862a;
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c10, BoundType boundType) {
        int i10 = a.f11861a[boundType.ordinal()];
        if (i10 == 1) {
            return greaterThan(c10);
        }
        if (i10 == 2) {
            return atLeast(c10);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        p.o(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet a10 = a(iterable);
            Comparator comparator = a10.comparator();
            if (q6.g().equals(comparator) || comparator == null) {
                return closed((Comparable) a10.first(), (Comparable) a10.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) p.o(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) p.o(it.next());
            comparable = (Comparable) q6.g().d(comparable, comparable3);
            comparable2 = (Comparable) q6.g().c(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> q6<Range<C>> g() {
        return (q6<Range<C>>) c.INSTANCE;
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c10) {
        return c(c3.b(c10), c3.a());
    }

    private static String h(c3<?> c3Var, c3<?> c3Var2) {
        StringBuilder sb2 = new StringBuilder(16);
        c3Var.i(sb2);
        sb2.append("..");
        c3Var2.j(sb2);
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> h<Range<C>, c3<C>> i() {
        return d.f11863a;
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c10) {
        return c(c3.c(), c3.d(c10));
    }

    public static <C extends Comparable<?>> Range<C> open(C c10, C c11) {
        return c(c3.b(c10), c3.d(c11));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c10, C c11) {
        return c(c3.b(c10), c3.b(c11));
    }

    public static <C extends Comparable<?>> Range<C> range(C c10, BoundType boundType, C c11, BoundType boundType2) {
        p.o(boundType);
        p.o(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        return c(boundType == boundType3 ? c3.b(c10) : c3.d(c10), boundType2 == boundType3 ? c3.d(c11) : c3.b(c11));
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c10) {
        return closed(c10, c10);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c10, BoundType boundType) {
        int i10 = a.f11861a[boundType.ordinal()];
        if (i10 == 1) {
            return lessThan(c10);
        }
        if (i10 == 2) {
            return atMost(c10);
        }
        throw new AssertionError();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.r
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object obj) {
        return apply((Range<C>) ((Comparable) obj));
    }

    public Range<C> canonical(h3<C> h3Var) {
        p.o(h3Var);
        c3<C> g10 = this.lowerBound.g(h3Var);
        c3<C> g11 = this.upperBound.g(h3Var);
        return (g10 == this.lowerBound && g11 == this.upperBound) ? this : c(g10, g11);
    }

    public boolean contains(C c10) {
        p.o(c10);
        return this.lowerBound.m(c10) && !this.upperBound.m(c10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (h5.i(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet a10 = a(iterable);
            Comparator comparator = a10.comparator();
            if (q6.g().equals(comparator) || comparator == null) {
                return contains((Comparable) a10.first()) && contains((Comparable) a10.last());
            }
        }
        for (C c10 : iterable) {
            if (!contains(c10)) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo(range.lowerBound) <= 0 && this.upperBound.compareTo(range.upperBound) >= 0;
    }

    @Override // com.google.common.base.r
    public boolean equals(Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    public Range<C> gap(Range<C> range) {
        if (this.lowerBound.compareTo(range.upperBound) >= 0 || range.lowerBound.compareTo(this.upperBound) >= 0) {
            boolean z10 = this.lowerBound.compareTo(range.lowerBound) < 0;
            Range<C> range2 = z10 ? this : range;
            if (!z10) {
                range = this;
            }
            return c(range2.upperBound, range.lowerBound);
        }
        String valueOf = String.valueOf(this);
        String valueOf2 = String.valueOf(range);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 39 + valueOf2.length());
        sb2.append("Ranges have a nonempty intersection: ");
        sb2.append(valueOf);
        sb2.append(", ");
        sb2.append(valueOf2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public boolean hasLowerBound() {
        return this.lowerBound != c3.c();
    }

    public boolean hasUpperBound() {
        return this.upperBound != c3.a();
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        int h10 = this.lowerBound.compareTo(range.lowerBound);
        int h11 = this.upperBound.compareTo(range.upperBound);
        if (h10 >= 0 && h11 <= 0) {
            return this;
        }
        if (h10 <= 0 && h11 >= 0) {
            return range;
        }
        return c(h10 >= 0 ? this.lowerBound : range.lowerBound, h11 <= 0 ? this.upperBound : range.upperBound);
    }

    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo(range.upperBound) <= 0 && range.lowerBound.compareTo(this.upperBound) <= 0;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.q();
    }

    public C lowerEndpoint() {
        return this.lowerBound.k();
    }

    public Range<C> span(Range<C> range) {
        int h10 = this.lowerBound.compareTo(range.lowerBound);
        int h11 = this.upperBound.compareTo(range.upperBound);
        if (h10 <= 0 && h11 >= 0) {
            return this;
        }
        if (h10 >= 0 && h11 <= 0) {
            return range;
        }
        return c(h10 <= 0 ? this.lowerBound : range.lowerBound, h11 >= 0 ? this.upperBound : range.upperBound);
    }

    /* JADX WARN: Unknown type variable: T in type: T */
    @Override // com.google.common.base.r, java.util.function.Predicate
    public /* bridge */ /* synthetic */ boolean test(T t10) {
        return q.a(this, t10);
    }

    public String toString() {
        return h(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.u();
    }

    public C upperEndpoint() {
        return this.upperBound.k();
    }

    @Deprecated
    public boolean apply(C c10) {
        return contains(c10);
    }
}
