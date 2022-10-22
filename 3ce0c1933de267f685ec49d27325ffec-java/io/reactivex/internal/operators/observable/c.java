package io.reactivex.internal.operators.observable;

import eo.b;
import io.reactivex.internal.util.f;
import io.reactivex.j;
import io.reactivex.k;
import io.reactivex.p;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: BlockingObservableLatest.java */
/* loaded from: classes3.dex */
public final class c<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28467a;

    /* compiled from: BlockingObservableLatest.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends b<j<T>> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        j<T> f28468b;

        /* renamed from: c  reason: collision with root package name */
        final Semaphore f28469c = new Semaphore(0);

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<j<T>> f28470d = new AtomicReference<>();

        a() {
        }

        /* renamed from: b */
        public void onNext(j<T> jVar) {
            if (this.f28470d.getAndSet(jVar) == null) {
                this.f28469c.release();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            j<T> jVar = this.f28468b;
            if (jVar == null || !jVar.g()) {
                if (this.f28468b == null) {
                    try {
                        io.reactivex.internal.util.c.b();
                        this.f28469c.acquire();
                        j<T> andSet = this.f28470d.getAndSet(null);
                        this.f28468b = andSet;
                        if (andSet.g()) {
                            throw f.d(andSet.d());
                        }
                    } catch (InterruptedException e10) {
                        dispose();
                        this.f28468b = j.b(e10);
                        throw f.d(e10);
                    }
                }
                return this.f28468b.h();
            }
            throw f.d(this.f28468b.d());
        }

        @Override // java.util.Iterator
        public T next() {
            if (hasNext()) {
                T e10 = this.f28468b.e();
                this.f28468b = null;
                return e10;
            }
            throw new NoSuchElementException();
        }

        @Override // io.reactivex.r
        public void onComplete() {
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            fo.a.s(th2);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read-only iterator.");
        }
    }

    public c(p<T> pVar) {
        this.f28467a = pVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        a aVar = new a();
        k.wrap(this.f28467a).materialize().subscribe(aVar);
        return aVar;
    }
}
