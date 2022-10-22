package com.google.common.collect;

import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.collect.j6;
import com.google.common.collect.l7;
import com.mobvoi.wear.contacts.ContactConstant;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.function.ObjIntConsumer;
/* compiled from: Multisets.java */
/* loaded from: classes.dex */
public final class m6 {

    /* compiled from: Multisets.java */
    /* loaded from: classes.dex */
    class a extends n8<j6.a<E>, E> {
        a(Iterator it) {
            super(it);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r1v1, types: [E, java.lang.Object] */
        /* renamed from: b */
        public E a(j6.a<E> aVar) {
            return aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Multisets.java */
    /* loaded from: classes.dex */
    public static abstract class b<E> implements j6.a<E> {
        public boolean equals(Object obj) {
            if (!(obj instanceof j6.a)) {
                return false;
            }
            j6.a aVar = (j6.a) obj;
            return getCount() == aVar.getCount() && m.a(a(), aVar.a());
        }

        public int hashCode() {
            E a10 = a();
            return (a10 == null ? 0 : a10.hashCode()) ^ getCount();
        }

        @Override // com.google.common.collect.j6.a
        public String toString() {
            String valueOf = String.valueOf(a());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 14);
            sb2.append(valueOf);
            sb2.append(" x ");
            sb2.append(count);
            return sb2.toString();
        }
    }

    /* compiled from: Multisets.java */
    /* loaded from: classes.dex */
    static abstract class c<E> extends l7.a<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return e().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return e().containsAll(collection);
        }

        abstract j6<E> e();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return e().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return e().remove(obj, Integer.MAX_VALUE) > 0;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return e().entrySet().size();
        }
    }

    /* compiled from: Multisets.java */
    /* loaded from: classes.dex */
    static abstract class d<E> extends l7.a<j6.a<E>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            e().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof j6.a)) {
                return false;
            }
            j6.a aVar = (j6.a) obj;
            return aVar.getCount() > 0 && e().count(aVar.a()) == aVar.getCount();
        }

        abstract j6<E> e();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof j6.a) {
                j6.a aVar = (j6.a) obj;
                E e10 = (E) aVar.a();
                int count = aVar.getCount();
                if (count != 0) {
                    return e().setCount(e10, count, 0);
                }
            }
            return false;
        }
    }

    /* compiled from: Multisets.java */
    /* loaded from: classes.dex */
    static class e<E> extends b<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;
        private final E element;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(E e10, int i10) {
            this.element = e10;
            this.count = i10;
            p2.b(i10, ContactConstant.CallsRecordKeys.COUNT);
        }

        @Override // com.google.common.collect.j6.a
        public final E a() {
            return this.element;
        }

        public e<E> b() {
            return null;
        }

        @Override // com.google.common.collect.j6.a
        public final int getCount() {
            return this.count;
        }
    }

    /* compiled from: Multisets.java */
    /* loaded from: classes.dex */
    static final class f<E> implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private final j6<E> f12121a;

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<j6.a<E>> f12122b;

        /* renamed from: c  reason: collision with root package name */
        private j6.a<E> f12123c;

        /* renamed from: d  reason: collision with root package name */
        private int f12124d;

        /* renamed from: e  reason: collision with root package name */
        private int f12125e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f12126f;

        f(j6<E> j6Var, Iterator<j6.a<E>> it) {
            this.f12121a = j6Var;
            this.f12122b = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12124d > 0 || this.f12122b.hasNext();
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                if (this.f12124d == 0) {
                    j6.a<E> next = this.f12122b.next();
                    this.f12123c = next;
                    int count = next.getCount();
                    this.f12124d = count;
                    this.f12125e = count;
                }
                this.f12124d--;
                this.f12126f = true;
                return this.f12123c.a();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f12126f);
            if (this.f12125e == 1) {
                this.f12122b.remove();
            } else {
                this.f12121a.remove(this.f12123c.a());
            }
            this.f12125e--;
            this.f12126f = false;
        }
    }

    private static <E> boolean b(final j6<E> j6Var, j6<? extends E> j6Var2) {
        if (j6Var2.isEmpty()) {
            return false;
        }
        Objects.requireNonNull(j6Var);
        j6Var2.forEachEntry(new ObjIntConsumer() { // from class: com.google.common.collect.l6
            @Override // java.util.function.ObjIntConsumer
            public final void accept(Object obj, int i10) {
                j6.this.add(obj, i10);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean c(j6<E> j6Var, Collection<? extends E> collection) {
        p.o(j6Var);
        p.o(collection);
        if (collection instanceof j6) {
            return b(j6Var, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return j5.a(j6Var, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> j6<T> d(Iterable<T> iterable) {
        return (j6) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Iterator<E> e(Iterator<j6.a<E>> it) {
        return new a(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(j6<?> j6Var, Object obj) {
        if (obj == j6Var) {
            return true;
        }
        if (obj instanceof j6) {
            j6 j6Var2 = (j6) obj;
            if (j6Var.size() == j6Var2.size() && j6Var.entrySet().size() == j6Var2.entrySet().size()) {
                for (j6.a aVar : j6Var2.entrySet()) {
                    if (j6Var.count(aVar.a()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> j6.a<E> g(E e10, int i10) {
        return new e(e10, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(Iterable<?> iterable) {
        if (iterable instanceof j6) {
            return ((j6) iterable).elementSet().size();
        }
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Iterator<E> i(j6<E> j6Var) {
        return new f(j6Var, j6Var.entrySet().iterator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Spliterator j(j6.a aVar) {
        return Collections.nCopies(aVar.getCount(), aVar.a()).spliterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean k(j6<?> j6Var, Collection<?> collection) {
        if (collection instanceof j6) {
            collection = ((j6) collection).elementSet();
        }
        return j6Var.elementSet().removeAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean l(j6<?> j6Var, Collection<?> collection) {
        p.o(collection);
        if (collection instanceof j6) {
            collection = ((j6) collection).elementSet();
        }
        return j6Var.elementSet().retainAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> int m(j6<E> j6Var, E e10, int i10) {
        p2.b(i10, ContactConstant.CallsRecordKeys.COUNT);
        int count = j6Var.count(e10);
        int i11 = i10 - count;
        if (i11 > 0) {
            j6Var.add(e10, i11);
        } else if (i11 < 0) {
            j6Var.remove(e10, -i11);
        }
        return count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean n(j6<E> j6Var, E e10, int i10, int i11) {
        p2.b(i10, "oldCount");
        p2.b(i11, "newCount");
        if (j6Var.count(e10) != i10) {
            return false;
        }
        j6Var.setCount(e10, i11);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Spliterator<E> o(j6<E> j6Var) {
        Spliterator<j6.a<E>> spliterator = j6Var.entrySet().spliterator();
        return s2.b(spliterator, k6.f12084a, (spliterator.characteristics() & 1296) | 64, j6Var.size());
    }
}
