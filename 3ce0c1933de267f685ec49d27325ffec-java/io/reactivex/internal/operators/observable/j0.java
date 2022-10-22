package io.reactivex.internal.operators.observable;

import bo.b;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p;
import io.reactivex.r;
import java.util.Collection;
import java.util.concurrent.Callable;
import zn.o;
/* compiled from: ObservableDistinct.java */
/* loaded from: classes3.dex */
public final class j0<T, K> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, K> f28749b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<? extends Collection<? super K>> f28750c;

    /* compiled from: ObservableDistinct.java */
    /* loaded from: classes3.dex */
    static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final Collection<? super K> f28751f;

        /* renamed from: g  reason: collision with root package name */
        final o<? super T, K> f28752g;

        a(r<? super T> rVar, o<? super T, K> oVar, Collection<? super K> collection) {
            super(rVar);
            this.f28752g = oVar;
            this.f28751f = collection;
        }

        @Override // io.reactivex.internal.observers.a, co.g
        public void clear() {
            this.f28751f.clear();
            super.clear();
        }

        @Override // io.reactivex.internal.observers.a, io.reactivex.r
        public void onComplete() {
            if (!this.f28356d) {
                this.f28356d = true;
                this.f28751f.clear();
                this.f28353a.onComplete();
            }
        }

        @Override // io.reactivex.internal.observers.a, io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28356d) {
                fo.a.s(th2);
                return;
            }
            this.f28356d = true;
            this.f28751f.clear();
            this.f28353a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28356d) {
                if (this.f28357e == 0) {
                    try {
                        if (this.f28751f.add(b.e(this.f28752g.apply(t10), "The keySelector returned a null key"))) {
                            this.f28353a.onNext(t10);
                        }
                    } catch (Throwable th2) {
                        c(th2);
                    }
                } else {
                    this.f28353a.onNext(null);
                }
            }
        }

        @Override // co.g
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f28355c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f28751f.add((Object) b.e(this.f28752g.apply(poll), "The keySelector returned a null key")));
            return poll;
        }

        @Override // co.c
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public j0(p<T> pVar, o<? super T, K> oVar, Callable<? extends Collection<? super K>> callable) {
        super(pVar);
        this.f28749b = oVar;
        this.f28750c = callable;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        try {
            this.f28426a.subscribe(new a(rVar, this.f28749b, (Collection) b.e(this.f28750c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, rVar);
        }
    }
}
