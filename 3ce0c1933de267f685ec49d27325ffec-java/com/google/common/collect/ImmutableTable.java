package com.google.common.collect;

import com.google.common.base.l;
import com.google.common.base.p;
import com.google.common.collect.c8;
import com.google.common.collect.m8;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.unionpay.tsmservice.mi.data.Constant;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public abstract class ImmutableTable<R, C, V> extends y<R, C, V> implements Serializable {

    /* loaded from: classes.dex */
    public static final class a<R, C, V> {

        /* renamed from: a  reason: collision with root package name */
        private final List<c8.a<R, C, V>> f11810a = s5.g();

        /* renamed from: b  reason: collision with root package name */
        private Comparator<? super R> f11811b;

        /* renamed from: c  reason: collision with root package name */
        private Comparator<? super C> f11812c;

        public ImmutableTable<R, C, V> a() {
            int size = this.f11810a.size();
            if (size == 0) {
                return ImmutableTable.of();
            }
            if (size != 1) {
                return h7.o(this.f11810a, this.f11811b, this.f11812c);
            }
            return new p7((c8.a) h5.h(this.f11810a));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a<R, C, V> b(a<R, C, V> aVar) {
            this.f11810a.addAll(aVar.f11810a);
            return this;
        }

        public a<R, C, V> c(c8.a<? extends R, ? extends C, ? extends V> aVar) {
            if (aVar instanceof m8.c) {
                p.p(aVar.b(), Constant.KEY_ROW);
                p.p(aVar.a(), "column");
                p.p(aVar.getValue(), HealthDataProviderContracts.NAME_VALUE);
                this.f11810a.add(aVar);
            } else {
                d(aVar.b(), aVar.a(), aVar.getValue());
            }
            return this;
        }

        public a<R, C, V> d(R r10, C c10, V v10) {
            this.f11810a.add(ImmutableTable.j(r10, c10, v10));
            return this;
        }
    }

    public static <R, C, V> a<R, C, V> builder() {
        return new a<>();
    }

    public static <R, C, V> ImmutableTable<R, C, V> copyOf(c8<? extends R, ? extends C, ? extends V> c8Var) {
        if (c8Var instanceof ImmutableTable) {
            return (ImmutableTable) c8Var;
        }
        return k(c8Var.cellSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R, C, V> c8.a<R, C, V> j(R r10, C c10, V v10) {
        return m8.b(p.p(r10, "rowKey"), p.p(c10, "columnKey"), p.p(v10, HealthDataProviderContracts.NAME_VALUE));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <R, C, V> ImmutableTable<R, C, V> k(Iterable<? extends c8.a<? extends R, ? extends C, ? extends V>> iterable) {
        a builder = builder();
        for (c8.a<? extends R, ? extends C, ? extends V> aVar : iterable) {
            builder.c(aVar);
        }
        return builder.a();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of() {
        return (ImmutableTable<R, C, V>) v7.EMPTY;
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3) {
        return l8.k(function, function2, function3);
    }

    @Override // com.google.common.collect.y
    final Spliterator<c8.a<R, C, V>> b() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.y
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c8
    public abstract ImmutableMap<C, Map<R, V>> columnMap();

    @Override // com.google.common.collect.y
    public boolean contains(Object obj, Object obj2) {
        return get(obj, obj2) != null;
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean containsColumn(Object obj) {
        return super.containsColumn(obj);
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean containsRow(Object obj) {
        return super.containsRow(obj);
    }

    @Override // com.google.common.collect.y
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.y
    final Iterator<V> g() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public /* bridge */ /* synthetic */ Object get(Object obj, Object obj2) {
        return super.get(obj, obj2);
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public final p8<c8.a<R, C, V>> a() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: l */
    public abstract ImmutableSet<c8.a<R, C, V>> c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public abstract ImmutableCollection<V> d();

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    @Deprecated
    public final V put(R r10, C c10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y
    @Deprecated
    public final void putAll(c8<? extends R, ? extends C, ? extends V> c8Var) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.y
    @Deprecated
    public final V remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.c8
    public abstract ImmutableMap<R, Map<C, V>> rowMap();

    @Override // com.google.common.collect.c8
    public abstract /* synthetic */ int size();

    @Override // com.google.common.collect.y
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <R, C, V> ImmutableTable<R, C, V> of(R r10, C c10, V v10) {
        return new p7(r10, c10, v10);
    }

    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> toImmutableTable(Function<? super T, ? extends R> function, Function<? super T, ? extends C> function2, Function<? super T, ? extends V> function3, BinaryOperator<V> binaryOperator) {
        return l8.l(function, function2, function3, binaryOperator);
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public ImmutableSet<c8.a<R, C, V>> cellSet() {
        return (ImmutableSet) super.cellSet();
    }

    public ImmutableMap<R, V> column(C c10) {
        p.p(c10, "columnKey");
        return (ImmutableMap) l.a((ImmutableMap) columnMap().get(c10), ImmutableMap.of());
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public ImmutableSet<C> columnKeySet() {
        return columnMap().keySet();
    }

    @Override // com.google.common.collect.c8
    public ImmutableMap<C, V> row(R r10) {
        p.p(r10, "rowKey");
        return (ImmutableMap) l.a((ImmutableMap) rowMap().get(r10), ImmutableMap.of());
    }

    @Override // com.google.common.collect.y, com.google.common.collect.c8
    public ImmutableSet<R> rowKeySet() {
        return rowMap().keySet();
    }

    @Override // com.google.common.collect.y
    public ImmutableCollection<V> values() {
        return (ImmutableCollection) super.values();
    }
}
