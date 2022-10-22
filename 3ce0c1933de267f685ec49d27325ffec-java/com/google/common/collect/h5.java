package com.google.common.collect;

import com.google.common.base.h;
import com.google.common.base.p;
import com.google.common.base.r;
import com.google.common.collect.h5;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;
/* compiled from: Iterables.java */
/* loaded from: classes.dex */
public final class h5 {

    /* compiled from: Iterables.java */
    /* loaded from: classes.dex */
    class a extends l3<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterable f12002b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ r f12003c;

        a(Iterable iterable, r rVar) {
            this.f12002b = iterable;
            this.f12003c = rVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void h(r rVar, Consumer consumer, Object obj) {
            if (rVar.test(obj)) {
                consumer.accept(obj);
            }
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> consumer) {
            p.o(consumer);
            Iterable iterable = this.f12002b;
            final r rVar = this.f12003c;
            iterable.forEach(new Consumer() { // from class: com.google.common.collect.g5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    h5.a.h(r.this, consumer, obj);
                }
            });
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return j5.k(this.f12002b.iterator(), this.f12003c);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return s2.a(this.f12002b.spliterator(), this.f12003c);
        }
    }

    /* compiled from: Iterables.java */
    /* loaded from: classes.dex */
    class b extends l3<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterable f12004b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ h f12005c;

        b(Iterable iterable, h hVar) {
            this.f12004b = iterable;
            this.f12005c = hVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void h(Consumer consumer, h hVar, Object obj) {
            consumer.accept(hVar.apply(obj));
        }

        @Override // java.lang.Iterable
        public void forEach(final Consumer<? super T> consumer) {
            p.o(consumer);
            Iterable iterable = this.f12004b;
            final h hVar = this.f12005c;
            iterable.forEach(new Consumer() { // from class: com.google.common.collect.i5
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    h5.b.h(consumer, hVar, obj);
                }
            });
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return j5.y(this.f12004b.iterator(), this.f12005c);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            return s2.e(this.f12004b.spliterator(), this.f12005c);
        }
    }

    /* compiled from: Iterables.java */
    /* loaded from: classes.dex */
    class c extends l3<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterable f12006b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f12007c;

        /* compiled from: Iterables.java */
        /* loaded from: classes.dex */
        class a implements Iterator<T> {

            /* renamed from: a  reason: collision with root package name */
            boolean f12008a = true;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Iterator f12009b;

            a(c cVar, Iterator it) {
                this.f12009b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f12009b.hasNext();
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
            @Override // java.util.Iterator
            public T next() {
                ?? next = this.f12009b.next();
                this.f12008a = false;
                return next;
            }

            @Override // java.util.Iterator
            public void remove() {
                p2.e(!this.f12008a);
                this.f12009b.remove();
            }
        }

        c(Iterable iterable, int i10) {
            this.f12006b = iterable;
            this.f12007c = i10;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            Iterable iterable = this.f12006b;
            if (iterable instanceof List) {
                List list = (List) iterable;
                return list.subList(Math.min(list.size(), this.f12007c), list.size()).iterator();
            }
            Iterator it = iterable.iterator();
            j5.b(it, this.f12007c);
            return new a(this, it);
        }

        @Override // java.lang.Iterable
        public Spliterator<T> spliterator() {
            Iterable iterable = this.f12006b;
            if (!(iterable instanceof List)) {
                return b8.a(iterable).skip(this.f12007c).spliterator();
            }
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.f12007c), list.size()).spliterator();
        }
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        return j5.a(collection, ((Iterable) p.o(iterable)).iterator());
    }

    private static <E> Collection<E> b(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return s5.i(iterable.iterator());
    }

    public static <T> Iterable<T> c(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return l3.a(iterable, iterable2);
    }

    public static <T> Iterable<T> d(Iterable<T> iterable, r<? super T> rVar) {
        p.o(iterable);
        p.o(rVar);
        return new a(iterable, rVar);
    }

    public static <T> T e(Iterable<? extends T> iterable, T t10) {
        return (T) j5.o(iterable.iterator(), t10);
    }

    public static <T> T f(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return (T) j5.n(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return (T) g(list);
        }
        throw new NoSuchElementException();
    }

    private static <T> T g(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> T h(Iterable<T> iterable) {
        return (T) j5.p(iterable.iterator());
    }

    public static boolean i(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> j(Iterable<T> iterable, int i10) {
        p.o(iterable);
        p.e(i10 >= 0, "number to skip cannot be negative");
        return new c(iterable, i10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] k(Iterable<?> iterable) {
        return b(iterable).toArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] l(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) b(iterable).toArray(tArr);
    }

    public static String m(Iterable<?> iterable) {
        return j5.x(iterable.iterator());
    }

    public static <F, T> Iterable<T> n(Iterable<F> iterable, h<? super F, ? extends T> hVar) {
        p.o(iterable);
        p.o(hVar);
        return new b(iterable, hVar);
    }
}
