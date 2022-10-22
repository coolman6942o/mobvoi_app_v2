package com.google.common.collect;

import com.google.common.collect.j6;
import com.google.common.collect.m6;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedSet;
/* compiled from: SortedMultisets.java */
/* loaded from: classes.dex */
final class u7 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SortedMultisets.java */
    /* loaded from: classes.dex */
    public static class a<E> extends m6.c<E> implements SortedSet<E> {

        /* renamed from: a  reason: collision with root package name */
        private final t7<E> f12199a;

        a(t7<E> t7Var) {
            this.f12199a = t7Var;
        }

        @Override // java.util.SortedSet
        public Comparator<? super E> comparator() {
            return e().comparator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f */
        public final t7<E> e() {
            return this.f12199a;
        }

        @Override // java.util.SortedSet
        public E first() {
            return (E) u7.d(e().firstEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> headSet(E e10) {
            return e().headMultiset(e10, BoundType.OPEN).elementSet();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return m6.e(e().entrySet().iterator());
        }

        @Override // java.util.SortedSet
        public E last() {
            return (E) u7.d(e().lastEntry());
        }

        @Override // java.util.SortedSet
        public SortedSet<E> subSet(E e10, E e11) {
            return e().subMultiset(e10, BoundType.CLOSED, e11, BoundType.OPEN).elementSet();
        }

        @Override // java.util.SortedSet
        public SortedSet<E> tailSet(E e10) {
            return e().tailMultiset(e10, BoundType.CLOSED).elementSet();
        }
    }

    /* compiled from: SortedMultisets.java */
    /* loaded from: classes.dex */
    static class b<E> extends a<E> implements NavigableSet<E> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b(t7<E> t7Var) {
            super(t7Var);
        }

        @Override // java.util.NavigableSet
        public E ceiling(E e10) {
            return (E) u7.c(e().tailMultiset(e10, BoundType.CLOSED).firstEntry());
        }

        @Override // java.util.NavigableSet
        public Iterator<E> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> descendingSet() {
            return new b(e().descendingMultiset());
        }

        @Override // java.util.NavigableSet
        public E floor(E e10) {
            return (E) u7.c(e().headMultiset(e10, BoundType.CLOSED).lastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> headSet(E e10, boolean z10) {
            return new b(e().headMultiset(e10, BoundType.b(z10)));
        }

        @Override // java.util.NavigableSet
        public E higher(E e10) {
            return (E) u7.c(e().tailMultiset(e10, BoundType.OPEN).firstEntry());
        }

        @Override // java.util.NavigableSet
        public E lower(E e10) {
            return (E) u7.c(e().headMultiset(e10, BoundType.OPEN).lastEntry());
        }

        @Override // java.util.NavigableSet
        public E pollFirst() {
            return (E) u7.c(e().pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public E pollLast() {
            return (E) u7.c(e().pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> subSet(E e10, boolean z10, E e11, boolean z11) {
            return new b(e().subMultiset(e10, BoundType.b(z10), e11, BoundType.b(z11)));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<E> tailSet(E e10, boolean z10) {
            return new b(e().tailMultiset(e10, BoundType.b(z10)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> E c(j6.a<E> aVar) {
        if (aVar == null) {
            return null;
        }
        return aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> E d(j6.a<E> aVar) {
        if (aVar != null) {
            return aVar.a();
        }
        throw new NoSuchElementException();
    }
}
