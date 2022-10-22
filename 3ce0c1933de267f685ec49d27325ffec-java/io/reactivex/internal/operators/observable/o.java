package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.j;
import io.reactivex.internal.util.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.Collection;
import java.util.concurrent.Callable;
/* compiled from: ObservableBufferExactBoundary.java */
/* loaded from: classes3.dex */
public final class o<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final p<B> f28877b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f28878c;

    /* compiled from: ObservableBufferExactBoundary.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>, B> extends eo.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, U, B> f28879b;

        a(b<T, U, B> bVar) {
            this.f28879b = bVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28879b.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28879b.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(B b10) {
            this.f28879b.k();
        }
    }

    /* compiled from: ObservableBufferExactBoundary.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>, B> extends j<T, U, U> implements r<T> {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f28880g;

        /* renamed from: h  reason: collision with root package name */
        final p<B> f28881h;

        /* renamed from: i  reason: collision with root package name */
        xn.b f28882i;

        /* renamed from: j  reason: collision with root package name */
        xn.b f28883j;

        /* renamed from: k  reason: collision with root package name */
        U f28884k;

        b(r<? super U> rVar, Callable<U> callable, p<B> pVar) {
            super(rVar, new io.reactivex.internal.queue.a());
            this.f28880g = callable;
            this.f28881h = pVar;
        }

        public void dispose() {
            if (!this.f28375d) {
                this.f28375d = true;
                this.f28883j.dispose();
                this.f28882i.dispose();
                if (f()) {
                    this.f28374c.clear();
                }
            }
        }

        public boolean isDisposed() {
            return this.f28375d;
        }

        /* renamed from: j */
        public void c(r<? super U> rVar, U u10) {
            this.f28373b.onNext(u10);
        }

        void k() {
            try {
                U u10 = (U) bo.b.e(this.f28880g.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u11 = this.f28884k;
                    if (u11 != null) {
                        this.f28884k = u10;
                        h(u11, false, this);
                    }
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                dispose();
                this.f28373b.onError(th2);
            }
        }

        @Override // io.reactivex.r
        public void onComplete() {
            synchronized (this) {
                U u10 = this.f28884k;
                if (u10 != null) {
                    this.f28884k = null;
                    this.f28374c.offer(u10);
                    this.f28376e = true;
                    if (f()) {
                        k.c(this.f28374c, this.f28373b, false, this, this);
                    }
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            dispose();
            this.f28373b.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            synchronized (this) {
                U u10 = this.f28884k;
                if (u10 != null) {
                    u10.add(t10);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28882i, bVar)) {
                this.f28882i = bVar;
                try {
                    this.f28884k = (U) bo.b.e(this.f28880g.call(), "The buffer supplied is null");
                    a aVar = new a(this);
                    this.f28883j = aVar;
                    this.f28373b.onSubscribe(this);
                    if (!this.f28375d) {
                        this.f28881h.subscribe(aVar);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28375d = true;
                    bVar.dispose();
                    EmptyDisposable.error(th2, this.f28373b);
                }
            }
        }
    }

    public o(p<T> pVar, p<B> pVar2, Callable<U> callable) {
        super(pVar);
        this.f28877b = pVar2;
        this.f28878c = callable;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super U> rVar) {
        this.f28426a.subscribe(new b(new d(rVar), this.f28878c, this.f28877b));
    }
}
