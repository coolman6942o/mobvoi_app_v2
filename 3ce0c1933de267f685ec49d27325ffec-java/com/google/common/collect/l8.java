package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.l8;
import com.google.common.collect.m8;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import com.unionpay.tsmservice.mi.data.Constant;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
/* compiled from: TableCollectors.java */
/* loaded from: classes.dex */
final class l8 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TableCollectors.java */
    /* loaded from: classes.dex */
    public static final class b<R, C, V> {

        /* renamed from: a  reason: collision with root package name */
        final List<c<R, C, V>> f12098a;

        /* renamed from: b  reason: collision with root package name */
        final c8<R, C, c<R, C, V>> f12099b;

        private b() {
            this.f12098a = new ArrayList();
            this.f12099b = HashBasedTable.create();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b<R, C, V> a(b<R, C, V> bVar, BinaryOperator<V> binaryOperator) {
            for (c<R, C, V> cVar : bVar.f12098a) {
                b(cVar.b(), cVar.a(), cVar.getValue(), binaryOperator);
            }
            return this;
        }

        void b(R r10, C c10, V v10, BinaryOperator<V> binaryOperator) {
            c<R, C, V> cVar = this.f12099b.get(r10, c10);
            if (cVar == null) {
                c<R, C, V> cVar2 = new c<>(r10, c10, v10);
                this.f12098a.add(cVar2);
                this.f12099b.put(r10, c10, cVar2);
                return;
            }
            cVar.c(v10, binaryOperator);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ImmutableTable<R, C, V> c() {
            return ImmutableTable.k(this.f12098a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TableCollectors.java */
    /* loaded from: classes.dex */
    public static final class c<R, C, V> extends m8.b<R, C, V> {

        /* renamed from: a  reason: collision with root package name */
        private final R f12100a;

        /* renamed from: b  reason: collision with root package name */
        private final C f12101b;

        /* renamed from: c  reason: collision with root package name */
        private V f12102c;

        c(R r10, C c10, V v10) {
            this.f12100a = (R) p.p(r10, Constant.KEY_ROW);
            this.f12101b = (C) p.p(c10, "column");
            this.f12102c = (V) p.p(v10, HealthDataProviderContracts.NAME_VALUE);
        }

        @Override // com.google.common.collect.c8.a
        public C a() {
            return this.f12101b;
        }

        @Override // com.google.common.collect.c8.a
        public R b() {
            return this.f12100a;
        }

        void c(V v10, BinaryOperator<V> binaryOperator) {
            p.p(v10, HealthDataProviderContracts.NAME_VALUE);
            this.f12102c = (V) p.p(binaryOperator.apply(this.f12102c, v10), "mergeFunction.apply");
        }

        @Override // com.google.common.collect.c8.a
        public V getValue() {
            return this.f12102c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(Function function, Function function2, Function function3, ImmutableTable.a aVar, Object obj) {
        aVar.d(function.apply(obj), function2.apply(obj), function3.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b g() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(Function function, Function function2, Function function3, BinaryOperator binaryOperator, b bVar, Object obj) {
        bVar.b(function.apply(obj), function2.apply(obj), function3.apply(obj), binaryOperator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> k(final Function<? super T, ? extends R> function, final Function<? super T, ? extends C> function2, final Function<? super T, ? extends V> function3) {
        p.p(function, "rowFunction");
        p.p(function2, "columnFunction");
        p.p(function3, "valueFunction");
        return Collector.of(k8.f12085a, new BiConsumer() { // from class: com.google.common.collect.d8
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                l8.f(function, function2, function3, (ImmutableTable.a) obj, obj2);
            }
        }, g8.f11997a, h8.f12013a, new Collector.Characteristics[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, R, C, V> Collector<T, ?, ImmutableTable<R, C, V>> l(final Function<? super T, ? extends R> function, final Function<? super T, ? extends C> function2, final Function<? super T, ? extends V> function3, final BinaryOperator<V> binaryOperator) {
        p.p(function, "rowFunction");
        p.p(function2, "columnFunction");
        p.p(function3, "valueFunction");
        p.p(binaryOperator, "mergeFunction");
        return Collector.of(j8.f12077a, new BiConsumer() { // from class: com.google.common.collect.e8
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                l8.h(function, function2, function3, binaryOperator, (l8.b) obj, obj2);
            }
        }, new BinaryOperator() { // from class: com.google.common.collect.f8
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                l8.b a10;
                a10 = ((l8.b) obj).a((l8.b) obj2, binaryOperator);
                return a10;
            }
        }, i8.f12021a, new Collector.Characteristics[0]);
    }
}
