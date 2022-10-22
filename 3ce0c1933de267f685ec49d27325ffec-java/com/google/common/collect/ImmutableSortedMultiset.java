package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.j6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public abstract class ImmutableSortedMultiset<E> extends c5<E> implements t7<E> {
    transient ImmutableSortedMultiset<E> descendingMultiset;

    /* loaded from: classes.dex */
    public static class a<E> extends ImmutableMultiset.b<E> {
        public a(Comparator<? super E> comparator) {
            super(TreeMultiset.create((Comparator) p.o(comparator)));
        }

        /* renamed from: i */
        public a<E> e(E e10) {
            super.a(e10);
            return this;
        }

        /* renamed from: j */
        public a<E> f(E... eArr) {
            super.f(eArr);
            return this;
        }

        public a<E> k(Iterator<? extends E> it) {
            super.g(it);
            return this;
        }

        /* renamed from: l */
        public ImmutableSortedMultiset<E> h() {
            return ImmutableSortedMultiset.copyOfSorted((t7) this.f11785a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableSortedMultiset A(Comparator comparator, j6 j6Var) {
        return s(comparator, j6Var.entrySet());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(q6.g(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(t7<E> t7Var) {
        return s(t7Var.comparator(), s5.h(t7Var.entrySet()));
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(q6.g());
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) f7.NATURAL_EMPTY_MULTISET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(q6.g().j());
    }

    private static <E> ImmutableSortedMultiset<E> s(Comparator<? super E> comparator, Collection<j6.a<E>> collection) {
        if (collection.isEmpty()) {
            return t(comparator);
        }
        ImmutableList.b bVar = new ImmutableList.b(collection.size());
        long[] jArr = new long[collection.size() + 1];
        int i10 = 0;
        for (j6.a<E> aVar : collection) {
            bVar.a(aVar.a());
            int i11 = i10 + 1;
            jArr[i11] = jArr[i10] + aVar.getCount();
            i10 = i11;
        }
        return new f7(new g7(bVar.h(), comparator), jArr, 0, collection.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableSortedMultiset<E> t(Comparator<? super E> comparator) {
        if (q6.g().equals(comparator)) {
            return (ImmutableSortedMultiset<E>) f7.NATURAL_EMPTY_MULTISET;
        }
        return new f7(comparator);
    }

    public static <E> Collector<E, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(Comparator<? super E> comparator) {
        return toImmutableSortedMultiset(comparator, Function.identity(), b5.f11942a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int u(Object obj) {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void y(Function function, ToIntFunction toIntFunction, j6 j6Var, Object obj) {
        j6Var.add(p.o(function.apply(obj)), toIntFunction.applyAsInt(obj));
    }

    @Override // com.google.common.collect.t7, com.google.common.collect.q7
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public abstract /* synthetic */ int count(Object obj);

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public abstract ImmutableSortedSet<E> elementSet();

    @Override // com.google.common.collect.t7
    public abstract /* synthetic */ j6.a<E> firstEntry();

    @Override // com.google.common.collect.ImmutableMultiset, java.lang.Iterable
    public /* bridge */ /* synthetic */ void forEach(Consumer<? super E> consumer) {
        i6.a(this, consumer);
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.j6
    public /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        i6.b(this, objIntConsumer);
    }

    @Override // com.google.common.collect.t7
    public abstract ImmutableSortedMultiset<E> headMultiset(E e10, BoundType boundType);

    @Override // com.google.common.collect.t7
    public abstract /* synthetic */ j6.a<E> lastEntry();

    @Override // com.google.common.collect.t7
    @Deprecated
    public final j6.a<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t7
    @Deprecated
    public final j6.a<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.t7
    public abstract ImmutableSortedMultiset<E> tailMultiset(E e10, BoundType boundType);

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(q6.g(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new f7((g7) ImmutableSortedSet.of(comparable), new long[]{0, 1}, 0, 1);
    }

    public static <T, E> Collector<T, ?, ImmutableSortedMultiset<E>> toImmutableSortedMultiset(final Comparator<? super E> comparator, final Function<? super T, ? extends E> function, final ToIntFunction<? super T> toIntFunction) {
        p.o(comparator);
        p.o(function);
        p.o(toIntFunction);
        return Collector.of(new Supplier() { // from class: com.google.common.collect.a5
            @Override // java.util.function.Supplier
            public final Object get() {
                j6 create;
                create = TreeMultiset.create(comparator);
                return create;
            }
        }, new BiConsumer() { // from class: com.google.common.collect.x4
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ImmutableSortedMultiset.y(function, toIntFunction, (j6) obj, obj2);
            }
        }, y4.f12269a, new Function() { // from class: com.google.common.collect.z4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ImmutableSortedMultiset A;
                A = ImmutableSortedMultiset.A(comparator, (j6) obj);
                return A;
            }
        }, new Collector.Characteristics[0]);
    }

    @Override // com.google.common.collect.t7
    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            if (isEmpty()) {
                immutableSortedMultiset = t(q6.a(comparator()).j());
            } else {
                immutableSortedMultiset = new e3<>(this);
            }
            this.descendingMultiset = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.t7
    public ImmutableSortedMultiset<E> subMultiset(E e10, BoundType boundType, E e11, BoundType boundType2) {
        p.k(comparator().compare(e10, e11) <= 0, "Expected lowerBound <= upperBound but %s > %s", e10, e11);
        return tailMultiset((ImmutableSortedMultiset<E>) e10, boundType).headMultiset((ImmutableSortedMultiset<E>) e11, boundType2);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(q6.g(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(q6.g(), Arrays.asList(comparable, comparable2));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        p.o(comparator);
        return new a(comparator).k(it).h();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(q6.g(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(q6.g(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.g() ? s(comparator, immutableSortedMultiset.entrySet().asList()) : immutableSortedMultiset;
            }
        }
        ArrayList h10 = s5.h(iterable);
        TreeMultiset create = TreeMultiset.create((Comparator) p.o(comparator));
        h5.a(create, h10);
        return s(comparator, create.entrySet());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(q6.g(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList j10 = s5.j(comparableArr.length + 6);
        Collections.addAll(j10, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(j10, comparableArr);
        return copyOf(q6.g(), j10);
    }
}
