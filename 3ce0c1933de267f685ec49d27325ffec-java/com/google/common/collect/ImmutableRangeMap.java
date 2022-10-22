package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.s7;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public class ImmutableRangeMap<K extends Comparable<?>, V> implements u6<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    private final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends ImmutableList<Range<K>> {
        final /* synthetic */ int val$len;
        final /* synthetic */ int val$off;
        final /* synthetic */ Range val$range;

        a(int i10, int i11, Range range) {
            this.val$len = i10;
            this.val$off = i11;
            this.val$range = range;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean g() {
            return true;
        }

        /* renamed from: l */
        public Range<K> get(int i10) {
            p.m(i10, this.val$len);
            return (i10 == 0 || i10 == this.val$len + (-1)) ? ((Range) ImmutableRangeMap.this.ranges.get(i10 + this.val$off)).intersection(this.val$range) : (Range) ImmutableRangeMap.this.ranges.get(i10 + this.val$off);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.val$len;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends ImmutableRangeMap<K, V> {
        final /* synthetic */ ImmutableRangeMap val$outer;
        final /* synthetic */ Range val$range;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ImmutableRangeMap immutableRangeMap, ImmutableList immutableList, ImmutableList immutableList2, Range range, ImmutableRangeMap immutableRangeMap2) {
            super(immutableList, immutableList2);
            this.val$range = range;
            this.val$outer = immutableRangeMap2;
        }

        @Override // com.google.common.collect.ImmutableRangeMap
        public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
            return ImmutableRangeMap.super.asDescendingMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap, com.google.common.collect.u6
        public /* bridge */ /* synthetic */ Map asMapOfRanges() {
            return ImmutableRangeMap.super.asMapOfRanges();
        }

        @Override // com.google.common.collect.ImmutableRangeMap
        public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
            if (this.val$range.isConnected(range)) {
                return this.val$outer.subRangeMap((Range) range.intersection(this.val$range));
            }
            return ImmutableRangeMap.of();
        }
    }

    /* loaded from: classes.dex */
    public static final class c<K extends Comparable<?>, V> {

        /* renamed from: a  reason: collision with root package name */
        private final List<Map.Entry<Range<K>, V>> f11786a = s5.g();

        public ImmutableRangeMap<K, V> a() {
            Collections.sort(this.f11786a, Range.g().h());
            ImmutableList.b bVar = new ImmutableList.b(this.f11786a.size());
            ImmutableList.b bVar2 = new ImmutableList.b(this.f11786a.size());
            for (int i10 = 0; i10 < this.f11786a.size(); i10++) {
                Range<K> key = this.f11786a.get(i10).getKey();
                if (i10 > 0) {
                    Range<K> key2 = this.f11786a.get(i10 - 1).getKey();
                    if (key.isConnected(key2) && !key.intersection(key2).isEmpty()) {
                        String valueOf = String.valueOf(key2);
                        String valueOf2 = String.valueOf(key);
                        StringBuilder sb2 = new StringBuilder(valueOf.length() + 47 + valueOf2.length());
                        sb2.append("Overlapping ranges: range ");
                        sb2.append(valueOf);
                        sb2.append(" overlaps with entry ");
                        sb2.append(valueOf2);
                        throw new IllegalArgumentException(sb2.toString());
                    }
                }
                bVar.a(key);
                bVar2.a(this.f11786a.get(i10).getValue());
            }
            return new ImmutableRangeMap<>(bVar.h(), bVar2.h());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c<K, V> b(c<K, V> cVar) {
            this.f11786a.addAll(cVar.f11786a);
            return this;
        }

        public c<K, V> c(Range<K> range, V v10) {
            p.o(range);
            p.o(v10);
            p.j(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.f11786a.add(w5.e(range, v10));
            return this;
        }
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public static <K extends Comparable<?>, V> c<K, V> builder() {
        return new c<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(u6<K, ? extends V> u6Var) {
        if (u6Var instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) u6Var;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = u6Var.asMapOfRanges();
        ImmutableList.b bVar = new ImmutableList.b(asMapOfRanges.size());
        ImmutableList.b bVar2 = new ImmutableList.b(asMapOfRanges.size());
        for (Map.Entry<Range<K>, ? extends V> entry : asMapOfRanges.entrySet()) {
            bVar.a(entry.getKey());
            bVar2.a(entry.getValue());
        }
        return new ImmutableRangeMap<>(bVar.h(), bVar2.h());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return (ImmutableRangeMap<K, V>) EMPTY;
    }

    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(Function<? super T, Range<K>> function, Function<? super T, ? extends V> function2) {
        return o2.T(function, function2);
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(Object obj) {
        if (obj instanceof u6) {
            return asMapOfRanges().equals(((u6) obj).asMapOfRanges());
        }
        return false;
    }

    public V get(K k10) {
        int a10 = s7.a(this.ranges, Range.d(), c3.d(k10), s7.c.ANY_PRESENT, s7.b.NEXT_LOWER);
        if (a10 != -1 && this.ranges.get(a10).contains(k10)) {
            return this.values.get(a10);
        }
        return null;
    }

    public Map.Entry<Range<K>, V> getEntry(K k10) {
        int a10 = s7.a(this.ranges, Range.d(), c3.d(k10), s7.c.ANY_PRESENT, s7.b.NEXT_LOWER);
        if (a10 == -1) {
            return null;
        }
        Range<K> range = this.ranges.get(a10);
        if (range.contains(k10)) {
            return w5.e(range, this.values.get(a10));
        }
        return null;
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Deprecated
    public final void merge(Range<K> range, V v10, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void put(Range<K> range, V v10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(u6<K, V> u6Var) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putCoalescing(Range<K> range, V v10) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> span() {
        if (!this.ranges.isEmpty()) {
            ImmutableList<Range<K>> immutableList = this.ranges;
            return Range.c(this.ranges.get(0).lowerBound, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v10) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v10));
    }

    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new g7(this.ranges.reverse(), Range.g().j()), this.values.reverse());
    }

    @Override // com.google.common.collect.u6
    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new g7(this.ranges, Range.g()), this.values);
    }

    public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
        if (((Range) p.o(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.ranges;
        h i10 = Range.i();
        c3<K> c3Var = range.lowerBound;
        s7.c cVar = s7.c.FIRST_AFTER;
        s7.b bVar = s7.b.NEXT_HIGHER;
        int a10 = s7.a(immutableList, i10, c3Var, cVar, bVar);
        int a11 = s7.a(this.ranges, Range.d(), range.upperBound, s7.c.ANY_PRESENT, bVar);
        if (a10 >= a11) {
            return of();
        }
        return new b(this, new a(a11 - a10, a10, range), this.values.subList(a10, a11), range, this);
    }
}
