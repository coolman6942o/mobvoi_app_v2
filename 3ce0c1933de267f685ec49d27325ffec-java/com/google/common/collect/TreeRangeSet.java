package com.google.common.collect;

import com.google.common.base.l;
import com.google.common.base.p;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class TreeRangeSet<C extends Comparable<?>> extends r<C> implements Serializable {
    private transient Set<Range<C>> asDescendingSetOfRanges;
    private transient Set<Range<C>> asRanges;
    private transient w6<C> complement;
    final NavigableMap<c3<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes.dex */
    final class b extends m3<Range<C>> implements Set<Range<C>> {

        /* renamed from: a  reason: collision with root package name */
        final Collection<Range<C>> f11890a;

        b(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.f11890a = collection;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.m3
        /* renamed from: b */
        public Collection<Range<C>> a() {
            return this.f11890a;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return l7.a(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return l7.b(this);
        }
    }

    /* loaded from: classes.dex */
    private final class c extends TreeRangeSet<C> {
        c() {
            super(new d(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.r, com.google.common.collect.w6
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.w6
        public w6<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.r
        public boolean contains(C c10) {
            return !TreeRangeSet.this.contains(c10);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.r, com.google.common.collect.w6
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d<C extends Comparable<?>> extends q<c3<C>, Range<C>> {

        /* renamed from: a  reason: collision with root package name */
        private final NavigableMap<c3<C>, Range<C>> f11891a;

        /* renamed from: b  reason: collision with root package name */
        private final NavigableMap<c3<C>, Range<C>> f11892b;

        /* renamed from: c  reason: collision with root package name */
        private final Range<c3<C>> f11893c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends com.google.common.collect.c<Map.Entry<c3<C>, Range<C>>> {

            /* renamed from: c  reason: collision with root package name */
            c3<C> f11894c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ c3 f11895d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ r6 f11896e;

            a(c3 c3Var, r6 r6Var) {
                this.f11895d = c3Var;
                this.f11896e = r6Var;
                this.f11894c = c3Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<c3<C>, Range<C>> a() {
                Range range;
                if (d.this.f11893c.upperBound.m(this.f11894c) || this.f11894c == c3.a()) {
                    return (Map.Entry) b();
                }
                if (this.f11896e.hasNext()) {
                    Range range2 = (Range) this.f11896e.next();
                    range = Range.c(this.f11894c, range2.lowerBound);
                    this.f11894c = range2.upperBound;
                } else {
                    range = Range.c(this.f11894c, c3.a());
                    this.f11894c = c3.a();
                }
                return w5.e(range.lowerBound, range);
            }
        }

        /* loaded from: classes.dex */
        class b extends com.google.common.collect.c<Map.Entry<c3<C>, Range<C>>> {

            /* renamed from: c  reason: collision with root package name */
            c3<C> f11898c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ c3 f11899d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ r6 f11900e;

            b(c3 c3Var, r6 r6Var) {
                this.f11899d = c3Var;
                this.f11900e = r6Var;
                this.f11898c = c3Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<c3<C>, Range<C>> a() {
                if (this.f11898c == c3.c()) {
                    return (Map.Entry) b();
                }
                if (this.f11900e.hasNext()) {
                    Range range = (Range) this.f11900e.next();
                    Range c10 = Range.c(range.upperBound, this.f11898c);
                    this.f11898c = range.lowerBound;
                    if (d.this.f11893c.lowerBound.m(c10.lowerBound)) {
                        return w5.e(c10.lowerBound, c10);
                    }
                } else if (d.this.f11893c.lowerBound.m(c3.c())) {
                    Range c11 = Range.c(c3.c(), this.f11898c);
                    this.f11898c = c3.c();
                    return w5.e(c3.c(), c11);
                }
                return (Map.Entry) b();
            }
        }

        d(NavigableMap<c3<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        private NavigableMap<c3<C>, Range<C>> l(Range<c3<C>> range) {
            if (!this.f11893c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new d(this.f11891a, range.intersection(this.f11893c));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w5.i
        public Iterator<Map.Entry<c3<C>, Range<C>>> a() {
            Collection<Range<C>> collection;
            c3 c3Var;
            if (this.f11893c.hasLowerBound()) {
                collection = this.f11892b.tailMap(this.f11893c.lowerEndpoint(), this.f11893c.lowerBoundType() == BoundType.CLOSED).values();
            } else {
                collection = this.f11892b.values();
            }
            r6 r10 = j5.r(collection.iterator());
            if (this.f11893c.contains(c3.c()) && (!r10.hasNext() || ((Range) r10.peek()).lowerBound != c3.c())) {
                c3Var = c3.c();
            } else if (!r10.hasNext()) {
                return j5.h();
            } else {
                c3Var = ((Range) r10.next()).upperBound;
            }
            return new a(c3Var, r10);
        }

        @Override // java.util.SortedMap
        public Comparator<? super c3<C>> comparator() {
            return q6.g();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.q
        Iterator<Map.Entry<c3<C>, Range<C>>> g() {
            c3<C> c3Var;
            c3<C> c3Var2;
            if (this.f11893c.hasUpperBound()) {
                c3Var = this.f11893c.upperEndpoint();
            } else {
                c3Var = c3.a();
            }
            r6 r10 = j5.r(this.f11892b.headMap(c3Var, this.f11893c.hasUpperBound() && this.f11893c.upperBoundType() == BoundType.CLOSED).descendingMap().values().iterator());
            if (r10.hasNext()) {
                if (((Range) r10.peek()).upperBound == c3.a()) {
                    c3Var2 = ((Range) r10.next()).lowerBound;
                } else {
                    c3Var2 = this.f11891a.higherKey(((Range) r10.peek()).upperBound);
                }
            } else if (!this.f11893c.contains(c3.c()) || this.f11891a.containsKey(c3.c())) {
                return j5.h();
            } else {
                c3Var2 = this.f11891a.higherKey(c3.c());
            }
            return new b((c3) l.a(c3Var2, c3.a()), r10);
        }

        /* renamed from: i */
        public Range<C> get(Object obj) {
            if (obj instanceof c3) {
                try {
                    c3<C> c3Var = (c3) obj;
                    Map.Entry<c3<C>, Range<C>> firstEntry = tailMap(c3Var, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(c3Var)) {
                        return firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: j */
        public NavigableMap<c3<C>, Range<C>> headMap(c3<C> c3Var, boolean z10) {
            return l(Range.upTo(c3Var, BoundType.b(z10)));
        }

        /* renamed from: k */
        public NavigableMap<c3<C>, Range<C>> subMap(c3<C> c3Var, boolean z10, c3<C> c3Var2, boolean z11) {
            return l(Range.range(c3Var, BoundType.b(z10), c3Var2, BoundType.b(z11)));
        }

        /* renamed from: m */
        public NavigableMap<c3<C>, Range<C>> tailMap(c3<C> c3Var, boolean z10) {
            return l(Range.downTo(c3Var, BoundType.b(z10)));
        }

        @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
        public int size() {
            return j5.w(a());
        }

        private d(NavigableMap<c3<C>, Range<C>> navigableMap, Range<c3<C>> range) {
            this.f11891a = navigableMap;
            this.f11892b = new e(navigableMap);
            this.f11893c = range;
        }
    }

    /* loaded from: classes.dex */
    private final class f extends TreeRangeSet<C> {
        private final Range<C> restriction;

        f(Range<C> range) {
            super(new g(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.restriction = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.r, com.google.common.collect.w6
        public void add(Range<C> range) {
            p.k(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.r
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.r
        public boolean contains(C c10) {
            return this.restriction.contains(c10) && TreeRangeSet.this.contains(c10);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.r, com.google.common.collect.w6
        public boolean encloses(Range<C> range) {
            Range b10;
            return !this.restriction.isEmpty() && this.restriction.encloses(range) && (b10 = TreeRangeSet.this.b(range)) != null && !b10.intersection(this.restriction).isEmpty();
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.r
        public Range<C> rangeContaining(C c10) {
            Range<C> rangeContaining;
            if (this.restriction.contains(c10) && (rangeContaining = TreeRangeSet.this.rangeContaining(c10)) != null) {
                return rangeContaining.intersection(this.restriction);
            }
            return null;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.r, com.google.common.collect.w6
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.w6
        public w6<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            if (range.isConnected(this.restriction)) {
                return new f(this.restriction.intersection(range));
            }
            return ImmutableRangeSet.of();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class g<C extends Comparable<?>> extends q<c3<C>, Range<C>> {

        /* renamed from: a  reason: collision with root package name */
        private final Range<c3<C>> f11908a;

        /* renamed from: b  reason: collision with root package name */
        private final Range<C> f11909b;

        /* renamed from: c  reason: collision with root package name */
        private final NavigableMap<c3<C>, Range<C>> f11910c;

        /* renamed from: d  reason: collision with root package name */
        private final NavigableMap<c3<C>, Range<C>> f11911d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends com.google.common.collect.c<Map.Entry<c3<C>, Range<C>>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Iterator f11912c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ c3 f11913d;

            a(Iterator it, c3 c3Var) {
                this.f11912c = it;
                this.f11913d = c3Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<c3<C>, Range<C>> a() {
                if (!this.f11912c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f11912c.next();
                if (this.f11913d.m(range.lowerBound)) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(g.this.f11909b);
                return w5.e(intersection.lowerBound, intersection);
            }
        }

        /* loaded from: classes.dex */
        class b extends com.google.common.collect.c<Map.Entry<c3<C>, Range<C>>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Iterator f11915c;

            b(Iterator it) {
                this.f11915c = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<c3<C>, Range<C>> a() {
                if (!this.f11915c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f11915c.next();
                if (g.this.f11909b.lowerBound.compareTo(range.upperBound) >= 0) {
                    return (Map.Entry) b();
                }
                Range intersection = range.intersection(g.this.f11909b);
                if (g.this.f11908a.contains(intersection.lowerBound)) {
                    return w5.e(intersection.lowerBound, intersection);
                }
                return (Map.Entry) b();
            }
        }

        private NavigableMap<c3<C>, Range<C>> m(Range<c3<C>> range) {
            if (!range.isConnected(this.f11908a)) {
                return ImmutableSortedMap.of();
            }
            return new g(this.f11908a.intersection(range), this.f11909b, this.f11910c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w5.i
        public Iterator<Map.Entry<c3<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (this.f11909b.isEmpty()) {
                return j5.h();
            }
            if (this.f11908a.upperBound.m(this.f11909b.lowerBound)) {
                return j5.h();
            }
            boolean z10 = false;
            if (this.f11908a.lowerBound.m(this.f11909b.lowerBound)) {
                it = this.f11911d.tailMap(this.f11909b.lowerBound, false).values().iterator();
            } else {
                NavigableMap<c3<C>, Range<C>> navigableMap = this.f11910c;
                c3<C> k10 = this.f11908a.lowerBound.k();
                if (this.f11908a.lowerBoundType() == BoundType.CLOSED) {
                    z10 = true;
                }
                it = navigableMap.tailMap(k10, z10).values().iterator();
            }
            return new a(it, (c3) q6.g().d(this.f11908a.upperBound, c3.d(this.f11909b.upperBound)));
        }

        @Override // java.util.SortedMap
        public Comparator<? super c3<C>> comparator() {
            return q6.g();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.q
        Iterator<Map.Entry<c3<C>, Range<C>>> g() {
            if (this.f11909b.isEmpty()) {
                return j5.h();
            }
            c3 c3Var = (c3) q6.g().d(this.f11908a.upperBound, c3.d(this.f11909b.upperBound));
            return new b(this.f11910c.headMap((c3) c3Var.k(), c3Var.u() == BoundType.CLOSED).descendingMap().values().iterator());
        }

        /* renamed from: j */
        public Range<C> get(Object obj) {
            if (obj instanceof c3) {
                try {
                    c3<C> c3Var = (c3) obj;
                    if (this.f11908a.contains(c3Var) && c3Var.compareTo(this.f11909b.lowerBound) >= 0 && c3Var.compareTo(this.f11909b.upperBound) < 0) {
                        if (c3Var.equals(this.f11909b.lowerBound)) {
                            Range range = (Range) w5.w(this.f11910c.floorEntry(c3Var));
                            if (range != null && range.upperBound.compareTo(this.f11909b.lowerBound) > 0) {
                                return range.intersection(this.f11909b);
                            }
                        } else {
                            Range range2 = (Range) this.f11910c.get(c3Var);
                            if (range2 != null) {
                                return range2.intersection(this.f11909b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: k */
        public NavigableMap<c3<C>, Range<C>> headMap(c3<C> c3Var, boolean z10) {
            return m(Range.upTo(c3Var, BoundType.b(z10)));
        }

        /* renamed from: l */
        public NavigableMap<c3<C>, Range<C>> subMap(c3<C> c3Var, boolean z10, c3<C> c3Var2, boolean z11) {
            return m(Range.range(c3Var, BoundType.b(z10), c3Var2, BoundType.b(z11)));
        }

        /* renamed from: n */
        public NavigableMap<c3<C>, Range<C>> tailMap(c3<C> c3Var, boolean z10) {
            return m(Range.downTo(c3Var, BoundType.b(z10)));
        }

        @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
        public int size() {
            return j5.w(a());
        }

        private g(Range<c3<C>> range, Range<C> range2, NavigableMap<c3<C>, Range<C>> navigableMap) {
            this.f11908a = (Range) p.o(range);
            this.f11909b = (Range) p.o(range2);
            this.f11910c = (NavigableMap) p.o(navigableMap);
            this.f11911d = new e(navigableMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<C> b(Range<C> range) {
        p.o(range);
        Map.Entry<c3<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry == null || !floorEntry.getValue().encloses(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void c(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public void add(Range<C> range) {
        p.o(range);
        if (!range.isEmpty()) {
            c3<C> c3Var = range.lowerBound;
            c3<C> c3Var2 = range.upperBound;
            Map.Entry<c3<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(c3Var);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo(c3Var) >= 0) {
                    if (value.upperBound.compareTo(c3Var2) >= 0) {
                        c3Var2 = value.upperBound;
                    }
                    c3Var = value.lowerBound;
                }
            }
            Map.Entry<c3<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(c3Var2);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (value2.upperBound.compareTo(c3Var2) >= 0) {
                    c3Var2 = value2.upperBound;
                }
            }
            this.rangesByLowerBound.subMap(c3Var, c3Var2).clear();
            c(Range.c(c3Var, c3Var2));
        }
    }

    @Override // com.google.common.collect.r
    public /* bridge */ /* synthetic */ void addAll(w6 w6Var) {
        super.addAll(w6Var);
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public /* bridge */ /* synthetic */ void addAll(Iterable<Range<C>> iterable) {
        v6.a(this, iterable);
    }

    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.asDescendingSetOfRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.descendingMap().values());
        this.asDescendingSetOfRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.w6
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.asRanges;
        if (set != null) {
            return set;
        }
        b bVar = new b(this, this.rangesByLowerBound.values());
        this.asRanges = bVar;
        return bVar;
    }

    @Override // com.google.common.collect.r
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.w6
    public w6<C> complement() {
        w6<C> w6Var = this.complement;
        if (w6Var != null) {
            return w6Var;
        }
        c cVar = new c();
        this.complement = cVar;
        return cVar;
    }

    @Override // com.google.common.collect.r
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public boolean encloses(Range<C> range) {
        p.o(range);
        Map.Entry<c3<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        return floorEntry != null && floorEntry.getValue().encloses(range);
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

    @Override // com.google.common.collect.r
    public boolean intersects(Range<C> range) {
        p.o(range);
        Map.Entry<c3<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<c3<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        return lowerEntry != null && lowerEntry.getValue().isConnected(range) && !lowerEntry.getValue().intersection(range).isEmpty();
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.r
    public Range<C> rangeContaining(C c10) {
        p.o(c10);
        Map.Entry<c3<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(c3.d(c10));
        if (floorEntry == null || !floorEntry.getValue().contains(c10)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public void remove(Range<C> range) {
        p.o(range);
        if (!range.isEmpty()) {
            Map.Entry<c3<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
            if (lowerEntry != null) {
                Range<C> value = lowerEntry.getValue();
                if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                    if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                        c(Range.c(range.upperBound, value.upperBound));
                    }
                    c(Range.c(value.lowerBound, range.lowerBound));
                }
            }
            Map.Entry<c3<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
            if (floorEntry != null) {
                Range<C> value2 = floorEntry.getValue();
                if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                    c(Range.c(range.upperBound, value2.upperBound));
                }
            }
            this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
        }
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public /* bridge */ /* synthetic */ void removeAll(w6 w6Var) {
        super.removeAll(w6Var);
    }

    @Override // com.google.common.collect.r, com.google.common.collect.w6
    public /* bridge */ /* synthetic */ void removeAll(Iterable<Range<C>> iterable) {
        v6.c(this, iterable);
    }

    public Range<C> span() {
        Map.Entry<c3<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<c3<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return Range.c(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.w6
    public w6<C> subRangeSet(Range<C> range) {
        return range.equals(Range.all()) ? this : new f(range);
    }

    private TreeRangeSet(NavigableMap<c3<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(w6<C> w6Var) {
        TreeRangeSet<C> create = create();
        create.addAll(w6Var);
        return create;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e<C extends Comparable<?>> extends q<c3<C>, Range<C>> {

        /* renamed from: a  reason: collision with root package name */
        private final NavigableMap<c3<C>, Range<C>> f11902a;

        /* renamed from: b  reason: collision with root package name */
        private final Range<c3<C>> f11903b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends com.google.common.collect.c<Map.Entry<c3<C>, Range<C>>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Iterator f11904c;

            a(Iterator it) {
                this.f11904c = it;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<c3<C>, Range<C>> a() {
                if (!this.f11904c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f11904c.next();
                if (e.this.f11903b.upperBound.m(range.upperBound)) {
                    return (Map.Entry) b();
                }
                return w5.e(range.upperBound, range);
            }
        }

        /* loaded from: classes.dex */
        class b extends com.google.common.collect.c<Map.Entry<c3<C>, Range<C>>> {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ r6 f11906c;

            b(r6 r6Var) {
                this.f11906c = r6Var;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            /* renamed from: d */
            public Map.Entry<c3<C>, Range<C>> a() {
                if (!this.f11906c.hasNext()) {
                    return (Map.Entry) b();
                }
                Range range = (Range) this.f11906c.next();
                if (e.this.f11903b.lowerBound.m(range.upperBound)) {
                    return w5.e(range.upperBound, range);
                }
                return (Map.Entry) b();
            }
        }

        e(NavigableMap<c3<C>, Range<C>> navigableMap) {
            this.f11902a = navigableMap;
            this.f11903b = Range.all();
        }

        private NavigableMap<c3<C>, Range<C>> l(Range<c3<C>> range) {
            if (range.isConnected(this.f11903b)) {
                return new e(this.f11902a, range.intersection(this.f11903b));
            }
            return ImmutableSortedMap.of();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.w5.i
        public Iterator<Map.Entry<c3<C>, Range<C>>> a() {
            Iterator<Range<C>> it;
            if (!this.f11903b.hasLowerBound()) {
                it = this.f11902a.values().iterator();
            } else {
                Map.Entry<c3<C>, Range<C>> lowerEntry = this.f11902a.lowerEntry(this.f11903b.lowerEndpoint());
                if (lowerEntry == null) {
                    it = this.f11902a.values().iterator();
                } else if (this.f11903b.lowerBound.m(lowerEntry.getValue().upperBound)) {
                    it = this.f11902a.tailMap(lowerEntry.getKey(), true).values().iterator();
                } else {
                    it = this.f11902a.tailMap(this.f11903b.lowerEndpoint(), true).values().iterator();
                }
            }
            return new a(it);
        }

        @Override // java.util.SortedMap
        public Comparator<? super c3<C>> comparator() {
            return q6.g();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        @Override // com.google.common.collect.q
        Iterator<Map.Entry<c3<C>, Range<C>>> g() {
            Collection<Range<C>> collection;
            if (this.f11903b.hasUpperBound()) {
                collection = this.f11902a.headMap(this.f11903b.upperEndpoint(), false).descendingMap().values();
            } else {
                collection = this.f11902a.descendingMap().values();
            }
            r6 r10 = j5.r(collection.iterator());
            if (r10.hasNext() && this.f11903b.upperBound.m(((Range) r10.peek()).upperBound)) {
                r10.next();
            }
            return new b(r10);
        }

        /* renamed from: i */
        public Range<C> get(Object obj) {
            Map.Entry<c3<C>, Range<C>> lowerEntry;
            if (obj instanceof c3) {
                try {
                    c3<C> c3Var = (c3) obj;
                    if (this.f11903b.contains(c3Var) && (lowerEntry = this.f11902a.lowerEntry(c3Var)) != null && lowerEntry.getValue().upperBound.equals(c3Var)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f11903b.equals(Range.all())) {
                return this.f11902a.isEmpty();
            }
            return !a().hasNext();
        }

        /* renamed from: j */
        public NavigableMap<c3<C>, Range<C>> headMap(c3<C> c3Var, boolean z10) {
            return l(Range.upTo(c3Var, BoundType.b(z10)));
        }

        /* renamed from: k */
        public NavigableMap<c3<C>, Range<C>> subMap(c3<C> c3Var, boolean z10, c3<C> c3Var2, boolean z11) {
            return l(Range.range(c3Var, BoundType.b(z10), c3Var2, BoundType.b(z11)));
        }

        /* renamed from: m */
        public NavigableMap<c3<C>, Range<C>> tailMap(c3<C> c3Var, boolean z10) {
            return l(Range.downTo(c3Var, BoundType.b(z10)));
        }

        @Override // com.google.common.collect.w5.i, java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.f11903b.equals(Range.all())) {
                return this.f11902a.size();
            }
            return j5.w(a());
        }

        private e(NavigableMap<c3<C>, Range<C>> navigableMap, Range<c3<C>> range) {
            this.f11902a = navigableMap;
            this.f11903b = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }
}
