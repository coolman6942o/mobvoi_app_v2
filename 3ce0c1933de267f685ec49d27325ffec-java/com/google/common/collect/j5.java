package com.google.common.collect;

import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.base.r;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
/* compiled from: Iterators.java */
/* loaded from: classes.dex */
public final class j5 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Iterators.java */
    /* loaded from: classes.dex */
    public class a extends p8<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterator f12059a;

        a(Iterator it) {
            this.f12059a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12059a.hasNext();
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
        @Override // java.util.Iterator
        public T next() {
            return this.f12059a.next();
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: classes.dex */
    class b extends com.google.common.collect.c<T> {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Iterator f12060c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ r f12061d;

        b(Iterator it, r rVar) {
            this.f12060c = it;
            this.f12061d = rVar;
        }

        /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
        @Override // com.google.common.collect.c
        protected T a() {
            while (this.f12060c.hasNext()) {
                ?? next = this.f12060c.next();
                if (this.f12061d.apply(next)) {
                    return next;
                }
            }
            return b();
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: classes.dex */
    class c extends n8<F, T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.common.base.h f12062b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Iterator it, com.google.common.base.h hVar) {
            super(it);
            this.f12062b = hVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
        @Override // com.google.common.collect.n8
        public T a(F f10) {
            return this.f12062b.apply(f10);
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: classes.dex */
    class d extends p8<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f12063a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f12064b;

        d(Object obj) {
            this.f12064b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f12063a;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
        @Override // java.util.Iterator
        public T next() {
            if (!this.f12063a) {
                this.f12063a = true;
                return this.f12064b;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Iterators.java */
    /* loaded from: classes.dex */
    public static final class e<T> extends com.google.common.collect.b<T> {

        /* renamed from: e  reason: collision with root package name */
        static final q8<Object> f12065e = new e(new Object[0], 0, 0, 0);

        /* renamed from: c  reason: collision with root package name */
        private final T[] f12066c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12067d;

        e(T[] tArr, int i10, int i11, int i12) {
            super(i11, i12);
            this.f12066c = tArr;
            this.f12067d = i10;
        }

        @Override // com.google.common.collect.b
        protected T a(int i10) {
            return this.f12066c[this.f12067d + i10];
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: classes.dex */
    private static class f<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private Iterator<? extends T> f12068a;

        /* renamed from: b  reason: collision with root package name */
        private Iterator<? extends T> f12069b = j5.h();

        /* renamed from: c  reason: collision with root package name */
        private Iterator<? extends Iterator<? extends T>> f12070c;

        /* renamed from: d  reason: collision with root package name */
        private Deque<Iterator<? extends Iterator<? extends T>>> f12071d;

        f(Iterator<? extends Iterator<? extends T>> it) {
            this.f12070c = (Iterator) p.o(it);
        }

        private Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f12070c;
                if (it != null && it.hasNext()) {
                    return this.f12070c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f12071d;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.f12070c = this.f12071d.removeFirst();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) p.o(this.f12069b)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> a10 = a();
                this.f12070c = a10;
                if (a10 == null) {
                    return false;
                }
                Iterator<? extends T> next = a10.next();
                this.f12069b = next;
                if (next instanceof f) {
                    f fVar = (f) next;
                    this.f12069b = fVar.f12069b;
                    if (this.f12071d == null) {
                        this.f12071d = new ArrayDeque();
                    }
                    this.f12071d.addFirst(this.f12070c);
                    if (fVar.f12071d != null) {
                        while (!fVar.f12071d.isEmpty()) {
                            this.f12071d.addFirst(fVar.f12071d.removeLast());
                        }
                    }
                    this.f12070c = fVar.f12070c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.f12069b;
                this.f12068a = it;
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(this.f12068a != null);
            this.f12068a.remove();
            this.f12068a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Iterators.java */
    /* loaded from: classes.dex */
    public enum g implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            p2.e(false);
        }
    }

    /* compiled from: Iterators.java */
    /* loaded from: classes.dex */
    private static class h<T> extends p8<T> {

        /* renamed from: a  reason: collision with root package name */
        final Queue<r6<T>> f12072a;

        /* compiled from: Iterators.java */
        /* loaded from: classes.dex */
        class a implements Comparator<r6<T>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Comparator f12073a;

            a(h hVar, Comparator comparator) {
                this.f12073a = comparator;
            }

            /* renamed from: a */
            public int compare(r6<T> r6Var, r6<T> r6Var2) {
                return this.f12073a.compare(r6Var.peek(), r6Var2.peek());
            }
        }

        public h(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.f12072a = new PriorityQueue(2, new a(this, comparator));
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f12072a.add(j5.r(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f12072a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            r6<T> remove = this.f12072a.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.f12072a.add(remove);
            }
            return next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Iterators.java */
    /* loaded from: classes.dex */
    public static class i<E> implements r6<E> {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<? extends E> f12074a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12075b;

        /* renamed from: c  reason: collision with root package name */
        private E f12076c;

        public i(Iterator<? extends E> it) {
            this.f12074a = (Iterator) p.o(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f12075b || this.f12074a.hasNext();
        }

        @Override // com.google.common.collect.r6, java.util.Iterator
        public E next() {
            if (!this.f12075b) {
                return this.f12074a.next();
            }
            E e10 = this.f12076c;
            this.f12075b = false;
            this.f12076c = null;
            return e10;
        }

        @Override // com.google.common.collect.r6
        public E peek() {
            if (!this.f12075b) {
                this.f12076c = this.f12074a.next();
                this.f12075b = true;
            }
            return this.f12076c;
        }

        @Override // java.util.Iterator
        public void remove() {
            p.v(!this.f12075b, "Can't remove after you've peeked at next");
            this.f12074a.remove();
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        p.o(collection);
        p.o(it);
        boolean z10 = false;
        while (it.hasNext()) {
            z10 |= collection.add(it.next());
        }
        return z10;
    }

    public static int b(Iterator<?> it, int i10) {
        p.o(it);
        int i11 = 0;
        p.e(i10 >= 0, "numberToAdvance must be nonnegative");
        while (i11 < i10 && it.hasNext()) {
            it.next();
            i11++;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ListIterator<T> c(Iterator<T> it) {
        return (ListIterator) it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Iterator<?> it) {
        p.o(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> e(Iterator<? extends Iterator<? extends T>> it) {
        return new f(it);
    }

    public static boolean f(Iterator<?> it, Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean g(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !m.a(it.next(), it2.next())) {
                return false;
            }
            while (it.hasNext()) {
            }
        }
        return !it2.hasNext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> p8<T> h() {
        return i();
    }

    static <T> q8<T> i() {
        return (q8<T>) e.f12065e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Iterator<T> j() {
        return g.INSTANCE;
    }

    public static <T> p8<T> k(Iterator<T> it, r<? super T> rVar) {
        p.o(it);
        p.o(rVar);
        return new b(it, rVar);
    }

    @SafeVarargs
    public static <T> p8<T> l(T... tArr) {
        return m(tArr, 0, tArr.length, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> q8<T> m(T[] tArr, int i10, int i11, int i12) {
        p.d(i11 >= 0);
        p.t(i10, i10 + i11, tArr.length);
        p.r(i12, i11);
        if (i11 == 0) {
            return i();
        }
        return new e(tArr, i10, i11, i12);
    }

    public static <T> T n(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> T o(Iterator<? extends T> it, T t10) {
        return it.hasNext() ? it.next() : t10;
    }

    public static <T> T p(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("expected one element but was: <");
        sb2.append(next);
        for (int i10 = 0; i10 < 4 && it.hasNext(); i10++) {
            sb2.append(", ");
            sb2.append(it.next());
        }
        if (it.hasNext()) {
            sb2.append(", ...");
        }
        sb2.append('>');
        throw new IllegalArgumentException(sb2.toString());
    }

    public static <T> p8<T> q(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        p.p(iterable, "iterators");
        p.p(comparator, "comparator");
        return new h(iterable, comparator);
    }

    public static <T> r6<T> r(Iterator<? extends T> it) {
        if (it instanceof i) {
            return (i) it;
        }
        return new i(it);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T s(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static boolean t(Iterator<?> it, Collection<?> collection) {
        p.o(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static boolean u(Iterator<?> it, Collection<?> collection) {
        p.o(collection);
        boolean z10 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z10 = true;
            }
        }
        return z10;
    }

    public static <T> p8<T> v(T t10) {
        return new d(t10);
    }

    public static int w(Iterator<?> it) {
        long j10 = 0;
        while (it.hasNext()) {
            it.next();
            j10++;
        }
        return com.google.common.primitives.d.h(j10);
    }

    public static String x(Iterator<?> it) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        boolean z10 = true;
        while (it.hasNext()) {
            if (!z10) {
                sb2.append(", ");
            }
            z10 = false;
            sb2.append(it.next());
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static <F, T> Iterator<T> y(Iterator<F> it, com.google.common.base.h<? super F, ? extends T> hVar) {
        p.o(hVar);
        return new c(it, hVar);
    }

    public static <T> p8<T> z(Iterator<? extends T> it) {
        p.o(it);
        if (it instanceof p8) {
            return (p8) it;
        }
        return new a(it);
    }
}
