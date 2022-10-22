package com.google.common.collect;

import com.google.common.base.p;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;
/* compiled from: Sets.java */
/* loaded from: classes.dex */
public final class l7 {

    /* compiled from: Sets.java */
    /* loaded from: classes.dex */
    static abstract class a<E> extends AbstractSet<E> {
        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<?> collection) {
            return l7.g(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) p.o(collection));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Sets.java */
    /* loaded from: classes.dex */
    public static final class b<E> extends u3<E> implements NavigableSet<E>, Serializable {
        private static final long serialVersionUID = 0;
        private final NavigableSet<E> delegate;
        private transient b<E> descendingSet;
        private final SortedSet<E> unmodifiableDelegate;

        b(NavigableSet<E> navigableSet) {
            this.delegate = (NavigableSet) p.o(navigableSet);
            this.unmodifiableDelegate = Collections.unmodifiableSortedSet(navigableSet);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e10) {
            return this.delegate.ceiling(e10);
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return j5.z(this.delegate.descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            b<E> bVar = this.descendingSet;
            if (bVar != null) {
                return bVar;
            }
            b<E> bVar2 = new b<>(this.delegate.descendingSet());
            this.descendingSet = bVar2;
            bVar2.descendingSet = this;
            return bVar2;
        }

        @Override // java.util.NavigableSet
        public E floor(E e10) {
            return this.delegate.floor(e10);
        }

        @Override // java.lang.Iterable
        public void forEach(Consumer<? super E> consumer) {
            this.delegate.forEach(consumer);
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e10, boolean z10) {
            return l7.i(this.delegate.headSet(e10, z10));
        }

        @Override // java.util.NavigableSet
        public E higher(E e10) {
            return this.delegate.higher(e10);
        }

        @Override // java.util.NavigableSet
        public E lower(E e10) {
            return this.delegate.lower(e10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.u3
        /* renamed from: n */
        public SortedSet<E> l() {
            return this.unmodifiableDelegate;
        }

        @Override // java.util.Collection
        public Stream<E> parallelStream() {
            return this.delegate.parallelStream();
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean removeIf(Predicate<? super E> predicate) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public Stream<E> stream() {
            return this.delegate.stream();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e10, boolean z10, E e11, boolean z11) {
            return l7.i(this.delegate.subSet(e10, z10, e11, z11));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e10, boolean z10) {
            return l7.i(this.delegate.tailSet(e10, z10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i10 = ~(~(i10 + (next != null ? next.hashCode() : 0)));
        }
        return i10;
    }

    public static <E> HashSet<E> c() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> d(int i10) {
        return new HashSet<>(w5.b(i10));
    }

    public static <E> LinkedHashSet<E> e() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> f(int i10) {
        return new LinkedHashSet<>(w5.b(i10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(Set<?> set, Collection<?> collection) {
        p.o(collection);
        if (collection instanceof j6) {
            collection = ((j6) collection).elementSet();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return h(set, collection.iterator());
        }
        return j5.t(set.iterator(), collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean h(Set<?> set, Iterator<?> it) {
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= set.remove(it.next());
        }
        return z10;
    }

    public static <E> NavigableSet<E> i(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof b)) ? navigableSet : new b(navigableSet);
    }
}
