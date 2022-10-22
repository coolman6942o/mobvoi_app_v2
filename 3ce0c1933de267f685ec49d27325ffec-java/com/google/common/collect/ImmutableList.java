package com.google.common.collect;

import com.google.common.base.p;
import com.google.common.collect.ImmutableCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
/* loaded from: classes.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends com.google.common.collect.b<E> {
        a(int i10, int i11) {
            super(i10, i11);
        }

        @Override // com.google.common.collect.b
        protected E a(int i10) {
            return ImmutableList.this.get(i10);
        }
    }

    /* loaded from: classes.dex */
    public static final class b<E> extends ImmutableCollection.a<E> {

        /* renamed from: a  reason: collision with root package name */
        Object[] f11762a;

        /* renamed from: b  reason: collision with root package name */
        private int f11763b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f11764c;

        public b() {
            this(4);
        }

        private void f(Object[] objArr, int i10) {
            j(this.f11763b + i10);
            System.arraycopy(objArr, 0, this.f11762a, this.f11763b, i10);
            this.f11763b += i10;
        }

        private void j(int i10) {
            Object[] objArr = this.f11762a;
            if (objArr.length < i10) {
                this.f11762a = Arrays.copyOf(objArr, ImmutableCollection.a.d(objArr.length, i10));
                this.f11764c = false;
            } else if (this.f11764c) {
                this.f11762a = Arrays.copyOf(objArr, objArr.length);
                this.f11764c = false;
            }
        }

        /* renamed from: e */
        public b<E> a(E e10) {
            p.o(e10);
            j(this.f11763b + 1);
            Object[] objArr = this.f11762a;
            int i10 = this.f11763b;
            this.f11763b = i10 + 1;
            objArr[i10] = e10;
            return this;
        }

        public b<E> g(Iterator<? extends E> it) {
            super.c(it);
            return this;
        }

        public ImmutableList<E> h() {
            this.f11764c = true;
            return ImmutableList.i(this.f11762a, this.f11763b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b<E> i(b<E> bVar) {
            p.o(bVar);
            f(bVar.f11762a, bVar.f11763b);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i10) {
            this.f11762a = new Object[i10];
            this.f11763b = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> forwardList;

        c(ImmutableList<E> immutableList) {
            this.forwardList = immutableList;
        }

        private int l(int i10) {
            return (size() - 1) - i10;
        }

        private int m(int i10) {
            return size() - i10;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return this.forwardList.contains(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return this.forwardList.g();
        }

        @Override // java.util.List
        public E get(int i10) {
            p.m(i10, size());
            return this.forwardList.get(l(i10));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(Object obj) {
            int lastIndexOf = this.forwardList.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return l(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(Object obj) {
            int indexOf = this.forwardList.indexOf(obj);
            if (indexOf >= 0) {
                return l(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.forwardList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.forwardList.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return ImmutableList.super.listIterator(i10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i10, int i11) {
            p.t(i10, i11, size());
            return this.forwardList.subList(m(i11), m(i10)).reverse();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        d(int i10, int i11) {
            this.offset = i10;
            this.length = i11;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // java.util.List
        public E get(int i10) {
            p.m(i10, this.length);
            return ImmutableList.this.get(i10 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i10) {
            return ImmutableList.super.listIterator(i10);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i10, int i11) {
            p.t(i10, i11, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i12 = this.offset;
            return immutableList.subList(i10 + i12, i11 + i12);
        }
    }

    public static <E> b<E> builder() {
        return new b<>();
    }

    public static <E> b<E> builderWithExpectedSize(int i10) {
        p2.b(i10, "expectedSize");
        return new b<>(i10);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        p.o(iterable);
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> h(Object[] objArr) {
        return i(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> i(Object[] objArr, int i10) {
        if (i10 == 0) {
            return of();
        }
        if (i10 == 1) {
            return of(objArr[0]);
        }
        if (i10 < objArr.length) {
            objArr = Arrays.copyOf(objArr, i10);
        }
        return new b7(objArr);
    }

    private static <E> ImmutableList<E> j(Object... objArr) {
        return h(p6.b(objArr));
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) b7.EMPTY;
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) h5.l(iterable, new Comparable[0]);
        p6.b(comparableArr);
        Arrays.sort(comparableArr);
        return h(comparableArr);
    }

    public static <E> Collector<E, ?, ImmutableList<E>> toImmutableList() {
        return o2.O();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i10) {
        int size = size();
        for (int i11 = 0; i11 < size; i11++) {
            objArr[i10 + i11] = get(i11);
        }
        return i10 + size;
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i10, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return s5.b(this, obj);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        p.o(consumer);
        int size = size();
        for (int i10 = 0; i10 < size; i10++) {
            consumer.accept(get(i10));
        }
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i10 = 1;
        for (int i11 = 0; i11 < size; i11++) {
            i10 = ~(~((i10 * 31) + get(i11).hashCode()));
        }
        return i10;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return s5.c(this, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList<E> k(int i10, int i11) {
        return new d(i10, i11 - i10);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return s5.e(this, obj);
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void replaceAll(UnaryOperator<E> unaryOperator) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        return size() <= 1 ? this : new c(this);
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i10, E e10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void sort(Comparator<? super E> comparator) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return s2.c(size(), 1296, new e4(this));
    }

    public static <E> ImmutableList<E> of(E e10) {
        return new n7(e10);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i10, int i11) {
        p.t(i10, i11, size());
        int i12 = i11 - i10;
        if (i12 == size()) {
            return this;
        }
        if (i12 == 0) {
            return of();
        }
        if (i12 == 1) {
            return of((Object) get(i10));
        }
        return k(i10, i11);
    }

    public static <E> ImmutableList<E> of(E e10, E e11) {
        return j(e10, e11);
    }

    @Override // java.util.List
    public q8<E> listIterator() {
        return listIterator(0);
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12) {
        return j(e10, e11, e12);
    }

    @Override // java.util.List
    public q8<E> listIterator(int i10) {
        return new a(size(), i10);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return j(collection.toArray());
        }
        ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
        return asList.g() ? h(asList.toArray()) : asList;
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13) {
        return j(e10, e11, e12, e13);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        p.o(comparator);
        Object[] k10 = h5.k(iterable);
        p6.b(k10);
        Arrays.sort(k10, comparator);
        return h(k10);
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13, E e14) {
        return j(e10, e11, e12, e13, e14);
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13, E e14, E e15) {
        return j(e10, e11, e12, e13, e14, e15);
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16) {
        return j(e10, e11, e12, e13, e14, e15, e16);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new b().a(next).g(it).h();
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17) {
        return j(e10, e11, e12, e13, e14, e15, e16, e17);
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18) {
        return j(e10, e11, e12, e13, e14, e15, e16, e17, e18);
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19) {
        return j(e10, e11, e12, e13, e14, e15, e16, e17, e18, e19);
    }

    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e20) {
        return j(e10, e11, e12, e13, e14, e15, e16, e17, e18, e19, e20);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e10, E e11, E e12, E e13, E e14, E e15, E e16, E e17, E e18, E e19, E e20, E e21, E... eArr) {
        p.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e10;
        objArr[1] = e11;
        objArr[2] = e12;
        objArr[3] = e13;
        objArr[4] = e14;
        objArr[5] = e15;
        objArr[6] = e16;
        objArr[7] = e17;
        objArr[8] = e18;
        objArr[9] = e19;
        objArr[10] = e20;
        objArr[11] = e21;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return j(objArr);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return j((Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
