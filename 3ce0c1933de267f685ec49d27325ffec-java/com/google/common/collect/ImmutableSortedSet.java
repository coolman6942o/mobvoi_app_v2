package com.google.common.collect;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.common.base.p;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public abstract class ImmutableSortedSet<E> extends d5<E> implements NavigableSet<E>, q7<E> {
    static final int SPLITERATOR_CHARACTERISTICS = 1301;
    final transient Comparator<? super E> comparator;
    transient ImmutableSortedSet<E> descendingSet;

    /* loaded from: classes.dex */
    class a extends Spliterators.AbstractSpliterator<E> {

        /* renamed from: a  reason: collision with root package name */
        final p8<E> f11805a;

        a(long j10, int i10) {
            super(j10, i10);
            this.f11805a = ImmutableSortedSet.this.iterator();
        }

        @Override // java.util.Spliterator
        public Comparator<? super E> getComparator() {
            return ImmutableSortedSet.this.comparator;
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super E> consumer) {
            if (!this.f11805a.hasNext()) {
                return false;
            }
            consumer.accept((E) this.f11805a.next());
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static final class b<E> extends ImmutableSet.a<E> {

        /* renamed from: c  reason: collision with root package name */
        private final Comparator<? super E> f11807c;

        /* renamed from: d  reason: collision with root package name */
        private E[] f11808d = (E[]) new Object[4];

        /* renamed from: e  reason: collision with root package name */
        private int f11809e = 0;

        public b(Comparator<? super E> comparator) {
            super(true);
            this.f11807c = (Comparator) p.o(comparator);
        }

        private void o() {
            int i10 = this.f11809e;
            if (i10 != 0) {
                Arrays.sort(this.f11808d, 0, i10, this.f11807c);
                int i11 = 1;
                int i12 = 1;
                while (true) {
                    int i13 = this.f11809e;
                    if (i11 < i13) {
                        Comparator<? super E> comparator = this.f11807c;
                        E[] eArr = this.f11808d;
                        int compare = comparator.compare((Object) eArr[i12 - 1], (Object) eArr[i11]);
                        if (compare < 0) {
                            E[] eArr2 = this.f11808d;
                            i12++;
                            eArr2[i12] = eArr2[i11];
                        } else if (compare > 0) {
                            String valueOf = String.valueOf(this.f11807c);
                            StringBuilder sb2 = new StringBuilder(valueOf.length() + 48);
                            sb2.append("Comparator ");
                            sb2.append(valueOf);
                            sb2.append(" compare method violates its contract");
                            throw new AssertionError(sb2.toString());
                        }
                        i11++;
                    } else {
                        Arrays.fill(this.f11808d, i12, i13, (Object) null);
                        this.f11809e = i12;
                        return;
                    }
                }
            }
        }

        @Override // com.google.common.collect.ImmutableSet.a
        void i() {
            E[] eArr = this.f11808d;
            this.f11808d = (E[]) Arrays.copyOf(eArr, eArr.length);
        }

        /* renamed from: k */
        public b<E> e(E e10) {
            p.o(e10);
            j();
            if (this.f11809e == this.f11808d.length) {
                o();
                int i10 = this.f11809e;
                int d10 = ImmutableCollection.a.d(i10, i10 + 1);
                E[] eArr = this.f11808d;
                if (d10 > eArr.length) {
                    this.f11808d = (E[]) Arrays.copyOf(eArr, d10);
                }
            }
            E[] eArr2 = this.f11808d;
            int i11 = this.f11809e;
            this.f11809e = i11 + 1;
            eArr2[i11] = e10;
            return this;
        }

        /* renamed from: l */
        public b<E> f(Iterator<? extends E> it) {
            super.f(it);
            return this;
        }

        /* renamed from: m */
        public ImmutableSortedSet<E> g() {
            o();
            if (this.f11809e == 0) {
                return ImmutableSortedSet.t(this.f11807c);
            }
            this.f11795b = true;
            return new g7(ImmutableList.i(this.f11808d, this.f11809e), this.f11807c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: n */
        public b<E> h(ImmutableSet.a<E> aVar) {
            j();
            b bVar = (b) aVar;
            for (int i10 = 0; i10 < bVar.f11809e; i10++) {
                e(bVar.f11808d[i10]);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    static int A(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        return r(q6.g(), comparableArr.length, (Comparable[]) comparableArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator a10 = r7.a(sortedSet);
        ImmutableList copyOf = ImmutableList.copyOf((Collection) sortedSet);
        if (copyOf.isEmpty()) {
            return t(a10);
        }
        return new g7(copyOf, a10);
    }

    public static <E extends Comparable<?>> b<E> naturalOrder() {
        return new b<>(q6.g());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return g7.NATURAL_EMPTY_SET;
    }

    public static <E> b<E> orderedBy(Comparator<E> comparator) {
        return new b<>(comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> ImmutableSortedSet<E> r(Comparator<? super E> comparator, int i10, E... eArr) {
        if (i10 == 0) {
            return t(comparator);
        }
        p6.c(eArr, i10);
        Arrays.sort(eArr, 0, i10, comparator);
        int i11 = 1;
        for (int i12 = 1; i12 < i10; i12++) {
            Object obj = (Object) eArr[i12];
            if (comparator.compare(obj, (Object) eArr[i11 - 1]) != 0) {
                i11++;
                eArr[i11] = obj;
            }
        }
        Arrays.fill(eArr, i11, i10, (Object) null);
        return new g7(ImmutableList.i(eArr, i11), comparator);
    }

    public static <E extends Comparable<?>> b<E> reverseOrder() {
        return new b<>(Collections.reverseOrder());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> g7<E> t(Comparator<? super E> comparator) {
        if (q6.g().equals(comparator)) {
            return (g7<E>) g7.NATURAL_EMPTY_SET;
        }
        return new g7<>(ImmutableList.of(), comparator);
    }

    public static <E> Collector<E, ?, ImmutableSortedSet<E>> toImmutableSortedSet(Comparator<? super E> comparator) {
        return o2.Z(comparator);
    }

    @Override // java.util.NavigableSet
    public E ceiling(E e10) {
        return (E) h5.e(tailSet((ImmutableSortedSet<E>) e10, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.q7
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public abstract p8<E> descendingIterator();

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    public E floor(E e10) {
        return (E) j5.o(headSet((ImmutableSortedSet<E>) e10, true).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    public E higher(E e10) {
        return (E) h5.e(tailSet((ImmutableSortedSet<E>) e10, false), null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int indexOf(Object obj);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract p8<E> iterator();

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public E lower(E e10) {
        return (E) j5.o(headSet((ImmutableSortedSet<E>) e10, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    abstract ImmutableSortedSet<E> s();

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return new a(size(), BaseQuickAdapter.EMPTY_VIEW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> u(E e10, boolean z10);

    abstract ImmutableSortedSet<E> w(E e10, boolean z10, E e11, boolean z11);

    abstract ImmutableSortedSet<E> y(E e10, boolean z10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int z(Object obj, Object obj2) {
        return A(this.comparator, obj, obj2);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(q6.g(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable) {
        return new g7(ImmutableList.of(comparable), q6.g());
    }

    @Override // java.util.NavigableSet
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> s10 = s();
        this.descendingSet = s10;
        s10.descendingSet = this;
        return s10;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2) {
        return r(q6.g(), 2, comparable, comparable2);
    }

    public ImmutableSortedSet<E> headSet(E e10) {
        return headSet((ImmutableSortedSet<E>) e10, false);
    }

    public ImmutableSortedSet<E> subSet(E e10, E e11) {
        return subSet((boolean) e10, true, (boolean) e11, false);
    }

    public ImmutableSortedSet<E> tailSet(E e10) {
        return tailSet((ImmutableSortedSet<E>) e10, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) q6.g(), (Collection) collection);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return r(q6.g(), 3, comparable, comparable2, comparable3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableSortedSet<E> headSet(E e10, boolean z10) {
        return u(p.o(e10), z10);
    }

    public ImmutableSortedSet<E> subSet(E e10, boolean z10, E e11, boolean z11) {
        p.o(e10);
        p.o(e11);
        p.d(this.comparator.compare(e10, e11) <= 0);
        return w(e10, z10, e11, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ImmutableSortedSet<E> tailSet(E e10, boolean z10) {
        return y(p.o(e10), z10);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return r(q6.g(), 4, comparable, comparable2, comparable3, comparable4);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(q6.g(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return r(q6.g(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        int length = comparableArr.length + 6;
        Comparable[] comparableArr2 = new Comparable[length];
        comparableArr2[0] = comparable;
        comparableArr2[1] = comparable2;
        comparableArr2[2] = comparable3;
        comparableArr2[3] = comparable4;
        comparableArr2[4] = comparable5;
        comparableArr2[5] = comparable6;
        System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
        return r(q6.g(), length, comparableArr2);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        return new b(comparator).f(it).g();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        p.o(comparator);
        if (r7.b(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.g()) {
                return immutableSortedSet;
            }
        }
        Object[] k10 = h5.k(iterable);
        return r(comparator, k10.length, k10);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }
}
