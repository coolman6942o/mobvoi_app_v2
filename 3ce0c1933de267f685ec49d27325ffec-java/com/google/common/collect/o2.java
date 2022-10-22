package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.d6;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/* compiled from: CollectCollectors.java */
/* loaded from: classes.dex */
final class o2 {

    /* renamed from: a  reason: collision with root package name */
    private static final Collector<Object, ?, ImmutableList<Object>> f12138a = Collector.of(z1.f12273a, m2.f12118a, k0.f12079a, e1.f11965a, new Collector.Characteristics[0]);

    /* renamed from: b  reason: collision with root package name */
    private static final Collector<Object, ?, ImmutableSet<Object>> f12139b = Collector.of(d2.f11952a, h0.f11999a, p0.f12145a, j1.f12056a, new Collector.Characteristics[0]);

    /* renamed from: c  reason: collision with root package name */
    private static final Collector<Range<Comparable<?>>, ?, ImmutableRangeSet<Comparable<?>>> f12140c = Collector.of(c2.f11949a, n2.f12130a, o0.f12136a, i1.f12016a, new Collector.Characteristics[0]);

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(Function function, Function function2, ImmutableBiMap.a aVar, Object obj) {
        aVar.d(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void C(Function function, Function function2, ImmutableListMultimap.a aVar, Object obj) {
        aVar.d(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(Function function, Function function2, ImmutableMap.b bVar, Object obj) {
        bVar.d(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void E(Function function, ToIntFunction toIntFunction, j6 j6Var, Object obj) {
        j6Var.add(p.o(function.apply(obj)), toIntFunction.applyAsInt(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableMultiset G(j6 j6Var) {
        return ImmutableMultiset.j(j6Var.entrySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void H(Function function, Function function2, ImmutableRangeMap.c cVar, Object obj) {
        cVar.c((Range) function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void I(Function function, Function function2, ImmutableSetMultimap.a aVar, Object obj) {
        aVar.d(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableSortedMap.c J(Comparator comparator) {
        return new ImmutableSortedMap.c(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(Function function, Function function2, ImmutableSortedMap.c cVar, Object obj) {
        cVar.d(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ TreeMap L(Comparator comparator) {
        return new TreeMap(comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableSortedSet.b M(Comparator comparator) {
        return new ImmutableSortedSet.b(comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> N(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        p.o(function);
        p.o(function2);
        return Collector.of(g2.f11989a, new BiConsumer() { // from class: com.google.common.collect.g0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                o2.B(function, function2, (ImmutableBiMap.a) obj, obj2);
            }
        }, j0.f12055a, d1.f11951a, new Collector.Characteristics[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Collector<E, ?, ImmutableList<E>> O() {
        return (Collector<E, ?, ImmutableList<E>>) f12138a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> P(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        p.p(function, "keyFunction");
        p.p(function2, "valueFunction");
        return Collector.of(a2.f11929a, new BiConsumer() { // from class: com.google.common.collect.r0
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                o2.C(function, function2, (ImmutableListMultimap.a) obj, obj2);
            }
        }, l0.f12087a, f1.f11980a, new Collector.Characteristics[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> Q(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        p.o(function);
        p.o(function2);
        return Collector.of(h2.f12001a, new BiConsumer() { // from class: com.google.common.collect.c1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                o2.D(function, function2, (ImmutableMap.b) obj, obj2);
            }
        }, m0.f12116a, g1.f11988a, new Collector.Characteristics[0]);
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> R(Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        p.o(function);
        p.o(function2);
        p.o(binaryOperator);
        return Collectors.collectingAndThen(Collectors.toMap(function, function2, binaryOperator, i2.f12017a), r1.f12156a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> S(final Function<? super T, ? extends E> function, final ToIntFunction<? super T> toIntFunction) {
        p.o(function);
        p.o(toIntFunction);
        return Collector.of(f2.f11981a, new BiConsumer() { // from class: com.google.common.collect.l2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                o2.E(function, toIntFunction, (j6) obj, obj2);
            }
        }, v0.f12201a, p1.f12146a, new Collector.Characteristics[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> T(final Function<? super T, Range<K>> function, final Function<? super T, ? extends V> function2) {
        p.o(function);
        p.o(function2);
        return Collector.of(b2.f11941a, new BiConsumer() { // from class: com.google.common.collect.n1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                o2.H(function, function2, (ImmutableRangeMap.c) obj, obj2);
            }
        }, n0.f12127a, h1.f12000a, new Collector.Characteristics[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> U() {
        return (Collector<Range<E>, ?, ImmutableRangeSet<E>>) f12140c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Collector<E, ?, ImmutableSet<E>> V() {
        return (Collector<E, ?, ImmutableSet<E>>) f12139b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> W(final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        p.p(function, "keyFunction");
        p.p(function2, "valueFunction");
        return Collector.of(e2.f11966a, new BiConsumer() { // from class: com.google.common.collect.y1
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                o2.I(function, function2, (ImmutableSetMultimap.a) obj, obj2);
            }
        }, q0.f12149a, k1.f12080a, new Collector.Characteristics[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> X(final Comparator<? super K> comparator, final Function<? super T, ? extends K> function, final Function<? super T, ? extends V> function2) {
        p.o(comparator);
        p.o(function);
        p.o(function2);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.v1
            @Override // java.util.function.Supplier
            public final Object get() {
                ImmutableSortedMap.c J;
                J = o2.J(comparator);
                return J;
            }
        }, new BiConsumer() { // from class: com.google.common.collect.j2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                o2.K(function, function2, (ImmutableSortedMap.c) obj, obj2);
            }
        }, s0.f12163a, l1.f12088a, Collector.Characteristics.UNORDERED);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> Y(final Comparator<? super K> comparator, Function<? super T, ? extends K> function, Function<? super T, ? extends V> function2, BinaryOperator<V> binaryOperator) {
        p.o(comparator);
        p.o(function);
        p.o(function2);
        p.o(binaryOperator);
        return Collectors.collectingAndThen(Collectors.toMap(function, function2, binaryOperator, new Supplier() { // from class: com.google.common.collect.x1
            @Override // java.util.function.Supplier
            public final Object get() {
                TreeMap L;
                L = o2.L(comparator);
                return L;
            }
        }), s1.f12164a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Collector<E, ?, ImmutableSortedSet<E>> Z(final Comparator<? super E> comparator) {
        p.o(comparator);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.w1
            @Override // java.util.function.Supplier
            public final Object get() {
                ImmutableSortedSet.b M;
                M = o2.M(comparator);
                return M;
            }
        }, i0.f12015a, t0.f12182a, m1.f12117a, new Collector.Characteristics[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> s(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2) {
        p.o(function);
        p.o(function2);
        Function a1Var = new Function() { // from class: com.google.common.collect.a1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object v10;
                v10 = o2.v(function, obj);
                return v10;
            }
        };
        Function b1Var = new Function() { // from class: com.google.common.collect.b1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Stream w10;
                w10 = o2.w(function2, obj);
                return w10;
            }
        };
        final d6.d<Object, Object> a10 = d6.a().a();
        Objects.requireNonNull(a10);
        return Collectors.collectingAndThen(u(a1Var, b1Var, new Supplier() { // from class: com.google.common.collect.t1
            @Override // java.util.function.Supplier
            public final Object get() {
                return d6.d.this.c();
            }
        }), o1.f12137a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> t(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2) {
        p.o(function);
        p.o(function2);
        Function y0Var = new Function() { // from class: com.google.common.collect.y0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Object x10;
                x10 = o2.x(function, obj);
                return x10;
            }
        };
        Function z0Var = new Function() { // from class: com.google.common.collect.z0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Stream y10;
                y10 = o2.y(function2, obj);
                return y10;
            }
        };
        final d6.f<Object, Object> d10 = d6.a().d();
        Objects.requireNonNull(d10);
        return Collectors.collectingAndThen(u(y0Var, z0Var, new Supplier() { // from class: com.google.common.collect.u1
            @Override // java.util.function.Supplier
            public final Object get() {
                return d6.f.this.c();
            }
        }), q1.f12150a);
    }

    static <T, K, V, M extends b6<K, V>> Collector<T, ?, M> u(final Function<? super T, ? extends K> function, final Function<? super T, ? extends Stream<? extends V>> function2, Supplier<M> supplier) {
        p.o(function);
        p.o(function2);
        p.o(supplier);
        return Collector.of(supplier, new BiConsumer() { // from class: com.google.common.collect.k2
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                o2.z(function, function2, (b6) obj, obj2);
            }
        }, u0.f12189a, new Collector.Characteristics[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object v(Function function, Object obj) {
        return p.o(function.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream w(Function function, Object obj) {
        return ((Stream) function.apply(obj)).peek(x0.f12253a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object x(Function function, Object obj) {
        return p.o(function.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream y(Function function, Object obj) {
        return ((Stream) function.apply(obj)).peek(x0.f12253a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(Function function, Function function2, b6 b6Var, Object obj) {
        final Collection collection = b6Var.get(function.apply(obj));
        Objects.requireNonNull(collection);
        ((Stream) function2.apply(obj)).forEachOrdered(new Consumer() { // from class: com.google.common.collect.w0
            @Override // java.util.function.Consumer
            public final void accept(Object obj2) {
                collection.add(obj2);
            }
        });
    }
}
