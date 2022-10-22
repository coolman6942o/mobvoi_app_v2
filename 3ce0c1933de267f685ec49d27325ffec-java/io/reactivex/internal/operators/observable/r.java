package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p;
import java.util.concurrent.Callable;
import zn.b;
/* compiled from: ObservableCollect.java */
/* loaded from: classes3.dex */
public final class r<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends U> f28994b;

    /* renamed from: c  reason: collision with root package name */
    final b<? super U, ? super T> f28995c;

    /* compiled from: ObservableCollect.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> implements io.reactivex.r<T>, xn.b {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.r<? super U> f28996a;

        /* renamed from: b  reason: collision with root package name */
        final b<? super U, ? super T> f28997b;

        /* renamed from: c  reason: collision with root package name */
        final U f28998c;

        /* renamed from: d  reason: collision with root package name */
        xn.b f28999d;

        /* renamed from: e  reason: collision with root package name */
        boolean f29000e;

        a(io.reactivex.r<? super U> rVar, U u10, b<? super U, ? super T> bVar) {
            this.f28996a = rVar;
            this.f28997b = bVar;
            this.f28998c = u10;
        }

        @Override // xn.b
        public void dispose() {
            this.f28999d.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28999d.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f29000e) {
                this.f29000e = true;
                this.f28996a.onNext((U) this.f28998c);
                this.f28996a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f29000e) {
                fo.a.s(th2);
                return;
            }
            this.f29000e = true;
            this.f28996a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f29000e) {
                try {
                    this.f28997b.accept((U) this.f28998c, t10);
                } catch (Throwable th2) {
                    this.f28999d.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28999d, bVar)) {
                this.f28999d = bVar;
                this.f28996a.onSubscribe(this);
            }
        }
    }

    public r(p<T> pVar, Callable<? extends U> callable, b<? super U, ? super T> bVar) {
        super(pVar);
        this.f28994b = callable;
        this.f28995c = bVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(io.reactivex.r<? super U> rVar) {
        try {
            this.f28426a.subscribe(new a(rVar, bo.b.e(this.f28994b.call(), "The initialSupplier returned a null value"), this.f28995c));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, rVar);
        }
    }
}
