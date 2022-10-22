package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.collect.s5;
import com.google.common.primitives.d;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.Predicate;
/* compiled from: Lists.java */
/* loaded from: classes.dex */
public final class s5 {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Lists.java */
    /* loaded from: classes.dex */
    public static class a<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final h<? super F, ? extends T> function;

        /* compiled from: Lists.java */
        /* renamed from: com.google.common.collect.s5$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0148a extends o8<F, T> {
            C0148a(ListIterator listIterator) {
                super(listIterator);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.n8
            public T a(F f10) {
                return a.this.function.apply(f10);
            }
        }

        a(List<F> list, h<? super F, ? extends T> hVar) {
            this.fromList = (List) p.o(list);
            this.function = (h) p.o(hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean b(Predicate predicate, Object obj) {
            return predicate.test(this.function.apply(obj));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i10) {
            return this.function.apply((F) this.fromList.get(i10));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new C0148a(this.fromList.listIterator(i10));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i10) {
            return this.function.apply((F) this.fromList.remove(i10));
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super T> predicate) {
            p.o(predicate);
            return this.fromList.removeIf(new Predicate() { // from class: com.google.common.collect.r5
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean b10;
                    b10 = s5.a.this.b(predicate, obj);
                    return b10;
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Lists.java */
    /* loaded from: classes.dex */
    public static class b<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final h<? super F, ? extends T> function;

        /* compiled from: Lists.java */
        /* loaded from: classes.dex */
        class a extends o8<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.n8
            public T a(F f10) {
                return b.this.function.apply(f10);
            }
        }

        b(List<F> list, h<? super F, ? extends T> hVar) {
            this.fromList = (List) p.o(list);
            this.function = (h) p.o(hVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ boolean b(Predicate predicate, Object obj) {
            return predicate.test(this.function.apply(obj));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i10) {
            return new a(this.fromList.listIterator(i10));
        }

        @Override // java.util.Collection
        public boolean removeIf(final Predicate<? super T> predicate) {
            p.o(predicate);
            return this.fromList.removeIf(new Predicate() { // from class: com.google.common.collect.t5
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean b10;
                    b10 = s5.b.this.b(predicate, obj);
                    return b10;
                }
            });
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    static int a(int i10) {
        p2.b(i10, "arraySize");
        return d.h(i10 + 5 + (i10 / 10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(List<?> list, Object obj) {
        if (obj == p.o(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return j5.g(list.iterator(), list2.iterator());
        }
        for (int i10 = 0; i10 < size; i10++) {
            if (!m.a(list.get(i10), list2.get(i10))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return d(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (m.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int d(List<?> list, Object obj) {
        int size = list.size();
        int i10 = 0;
        if (obj == null) {
            while (i10 < size) {
                if (list.get(i10) == null) {
                    return i10;
                }
                i10++;
            }
            return -1;
        }
        while (i10 < size) {
            if (obj.equals(list.get(i10))) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return f(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (m.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int f(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ArrayList<E> g() {
        return new ArrayList<>();
    }

    public static <E> ArrayList<E> h(Iterable<? extends E> iterable) {
        p.o(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>((Collection) iterable);
        }
        return i(iterable.iterator());
    }

    public static <E> ArrayList<E> i(Iterator<? extends E> it) {
        ArrayList<E> g10 = g();
        j5.a(g10, it);
        return g10;
    }

    public static <E> ArrayList<E> j(int i10) {
        p2.b(i10, "initialArraySize");
        return new ArrayList<>(i10);
    }

    public static <E> ArrayList<E> k(int i10) {
        return new ArrayList<>(a(i10));
    }

    public static <F, T> List<T> l(List<F> list, h<? super F, ? extends T> hVar) {
        if (list instanceof RandomAccess) {
            return new a(list, hVar);
        }
        return new b(list, hVar);
    }
}
