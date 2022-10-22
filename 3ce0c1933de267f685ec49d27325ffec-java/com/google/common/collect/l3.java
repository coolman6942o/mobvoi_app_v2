package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.p;
import com.google.common.base.r;
import java.util.Iterator;
/* compiled from: FluentIterable.java */
/* loaded from: classes.dex */
public abstract class l3<E> implements Iterable<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Optional<Iterable<E>> f12091a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FluentIterable.java */
    /* loaded from: classes.dex */
    public class a extends l3<E> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterable f12092b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Iterable iterable, Iterable iterable2) {
            super(iterable);
            this.f12092b = iterable2;
        }

        @Override // java.lang.Iterable
        public Iterator<E> iterator() {
            return this.f12092b.iterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FluentIterable.java */
    /* loaded from: classes.dex */
    public class b extends l3<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Iterable[] f12093b;

        /* compiled from: FluentIterable.java */
        /* loaded from: classes.dex */
        class a extends com.google.common.collect.b<Iterator<? extends T>> {
            a(int i10) {
                super(i10);
            }

            /* renamed from: b */
            public Iterator<? extends T> a(int i10) {
                return b.this.f12093b[i10].iterator();
            }
        }

        b(Iterable[] iterableArr) {
            this.f12093b = iterableArr;
        }

        @Override // java.lang.Iterable
        public Iterator<T> iterator() {
            return j5.e(new a(this.f12093b.length));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public l3() {
        this.f12091a = Optional.absent();
    }

    public static <T> l3<T> a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return b(iterable, iterable2);
    }

    private static <T> l3<T> b(Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            p.o(iterable);
        }
        return new b(iterableArr);
    }

    public static <E> l3<E> d(Iterable<E> iterable) {
        if (iterable instanceof l3) {
            return (l3) iterable;
        }
        return new a(iterable, iterable);
    }

    private Iterable<E> e() {
        return this.f12091a.or((Optional<Iterable<E>>) this);
    }

    public final l3<E> c(r<? super E> rVar) {
        return d(h5.d(e(), rVar));
    }

    public final ImmutableSet<E> f() {
        return ImmutableSet.copyOf(e());
    }

    public String toString() {
        return h5.m(e());
    }

    l3(Iterable<E> iterable) {
        p.o(iterable);
        this.f12091a = Optional.fromNullable(this == iterable ? null : iterable);
    }
}
