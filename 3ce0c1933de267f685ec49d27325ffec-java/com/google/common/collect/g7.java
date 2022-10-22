package com.google.common.collect;

import com.google.common.base.p;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RegularImmutableSortedSet.java */
/* loaded from: classes.dex */
public final class g7<E> extends ImmutableSortedSet<E> {
    static final g7<Comparable> NATURAL_EMPTY_SET = new g7<>(ImmutableList.of(), q6.g());
    private final transient ImmutableList<E> elements;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g7(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.elements = immutableList;
    }

    private int F(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.elements, obj, G());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g7<E> B(int i10, int i11) {
        if (i10 == 0 && i11 == size()) {
            return this;
        }
        if (i10 < i11) {
            return new g7<>(this.elements.subList(i10, i11), this.comparator);
        }
        return ImmutableSortedSet.t(this.comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C(E e10, boolean z10) {
        int binarySearch = Collections.binarySearch(this.elements, p.o(e10), comparator());
        return binarySearch >= 0 ? z10 ? binarySearch + 1 : binarySearch : ~binarySearch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int D(E e10, boolean z10) {
        int binarySearch = Collections.binarySearch(this.elements, p.o(e10), comparator());
        return binarySearch >= 0 ? z10 ? binarySearch : binarySearch + 1 : ~binarySearch;
    }

    Comparator<Object> G() {
        return this.comparator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i10) {
        return this.elements.a(objArr, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object[] b() {
        return this.elements.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int c() {
        return this.elements.c();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e10) {
        int D = D(e10, true);
        if (D == size()) {
            return null;
        }
        return this.elements.get(D);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return F(obj) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof j6) {
            collection = ((j6) collection).elementSet();
        }
        if (!r7.b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        p8<E> it = iterator();
        Iterator<?> it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        E next2 = it.next();
        while (true) {
            try {
                int z10 = z(next2, next);
                if (z10 < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (z10 == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (z10 > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int d() {
        return this.elements.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034 A[Catch: ClassCastException | NoSuchElementException -> 0x0046, TryCatch #0 {ClassCastException | NoSuchElementException -> 0x0046, blocks: (B:17:0x002a, B:18:0x002e, B:20:0x0034, B:22:0x003e), top: B:29:0x002a }] */
    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!r7.b(this.comparator, set)) {
            return containsAll(set);
        }
        Iterator<E> it = set.iterator();
        try {
            p8<E> it2 = iterator();
            while (it2.hasNext()) {
                E next = it2.next();
                E next2 = it.next();
                if (next2 == null || z(next, next2) != 0) {
                    return false;
                }
                while (it2.hasNext()) {
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (!isEmpty()) {
            return this.elements.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e10) {
        int C = C(e10, true) - 1;
        if (C == -1) {
            return null;
        }
        return this.elements.get(C);
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer<? super E> consumer) {
        this.elements.forEach(consumer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean g() {
        return this.elements.g();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e10) {
        int D = D(e10, false);
        if (D == size()) {
            return null;
        }
        return this.elements.get(D);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.elements, obj, G());
            if (binarySearch >= 0) {
                return binarySearch;
            }
            return -1;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (!isEmpty()) {
            return this.elements.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e10) {
        int C = C(e10, false) - 1;
        if (C == -1) {
            return null;
        }
        return this.elements.get(C);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> m() {
        return size() <= 1 ? this.elements : new u4(this, this.elements);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> s() {
        Comparator reverseOrder = Collections.reverseOrder(this.comparator);
        if (isEmpty()) {
            return ImmutableSortedSet.t(reverseOrder);
        }
        return new g7(this.elements.reverse(), reverseOrder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable
    public Spliterator<E> spliterator() {
        return asList().spliterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> u(E e10, boolean z10) {
        return B(0, C(e10, z10));
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> w(E e10, boolean z10, E e11, boolean z11) {
        return y(e10, z10).u(e11, z11);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> y(E e10, boolean z10) {
        return B(D(e10, z10), size());
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public p8<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public p8<E> iterator() {
        return this.elements.iterator();
    }
}
