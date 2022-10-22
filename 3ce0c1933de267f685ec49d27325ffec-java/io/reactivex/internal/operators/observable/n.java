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
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableBufferBoundarySupplier.java */
/* loaded from: classes3.dex */
public final class n<T, U extends Collection<? super T>, B> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends p<B>> f28846b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<U> f28847c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableBufferBoundarySupplier.java */
    /* loaded from: classes3.dex */
    public static final class a<T, U extends Collection<? super T>, B> extends eo.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final b<T, U, B> f28848b;

        /* renamed from: c  reason: collision with root package name */
        boolean f28849c;

        a(b<T, U, B> bVar) {
            this.f28848b = bVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28849c) {
                this.f28849c = true;
                this.f28848b.l();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28849c) {
                fo.a.s(th2);
                return;
            }
            this.f28849c = true;
            this.f28848b.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(B b10) {
            if (!this.f28849c) {
                this.f28849c = true;
                dispose();
                this.f28848b.l();
            }
        }
    }

    /* compiled from: ObservableBufferBoundarySupplier.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>, B> extends j<T, U, U> implements r<T> {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f28850g;

        /* renamed from: h  reason: collision with root package name */
        final Callable<? extends p<B>> f28851h;

        /* renamed from: i  reason: collision with root package name */
        xn.b f28852i;

        /* renamed from: j  reason: collision with root package name */
        final AtomicReference<xn.b> f28853j = new AtomicReference<>();

        /* renamed from: k  reason: collision with root package name */
        U f28854k;

        b(r<? super U> rVar, Callable<U> callable, Callable<? extends p<B>> callable2) {
            super(rVar, new io.reactivex.internal.queue.a());
            this.f28850g = callable;
            this.f28851h = callable2;
        }

        public void dispose() {
            if (!this.f28375d) {
                this.f28375d = true;
                this.f28852i.dispose();
                k();
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
            DisposableHelper.dispose(this.f28853j);
        }

        void l() {
            try {
                U u10 = (U) bo.b.e(this.f28850g.call(), "The buffer supplied is null");
                try {
                    p pVar = (p) bo.b.e(this.f28851h.call(), "The boundary ObservableSource supplied is null");
                    a aVar = new a(this);
                    if (DisposableHelper.replace(this.f28853j, aVar)) {
                        synchronized (this) {
                            U u11 = this.f28854k;
                            if (u11 != null) {
                                this.f28854k = u10;
                                pVar.subscribe(aVar);
                                h(u11, false, this);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28375d = true;
                    this.f28852i.dispose();
                    this.f28373b.onError(th2);
                }
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                dispose();
                this.f28373b.onError(th3);
            }
        }

        @Override // io.reactivex.r
        public void onComplete() {
            synchronized (this) {
                U u10 = this.f28854k;
                if (u10 != null) {
                    this.f28854k = null;
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
                U u10 = this.f28854k;
                if (u10 != null) {
                    u10.add(t10);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28852i, bVar)) {
                this.f28852i = bVar;
                r<? super V> rVar = this.f28373b;
                try {
                    this.f28854k = (U) bo.b.e(this.f28850g.call(), "The buffer supplied is null");
                    try {
                        p pVar = (p) bo.b.e(this.f28851h.call(), "The boundary ObservableSource supplied is null");
                        a aVar = new a(this);
                        this.f28853j.set(aVar);
                        rVar.onSubscribe(this);
                        if (!this.f28375d) {
                            pVar.subscribe(aVar);
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.f28375d = true;
                        bVar.dispose();
                        EmptyDisposable.error(th2, rVar);
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    this.f28375d = true;
                    bVar.dispose();
                    EmptyDisposable.error(th3, rVar);
                }
            }
        }
    }

    public n(p<T> pVar, Callable<? extends p<B>> callable, Callable<U> callable2) {
        super(pVar);
        this.f28846b = callable;
        this.f28847c = callable2;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super U> rVar) {
        this.f28426a.subscribe(new b(new d(rVar), this.f28847c, this.f28846b));
    }
}
