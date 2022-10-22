package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p;
import io.reactivex.r;
import java.util.Collection;
import java.util.concurrent.Callable;
import xn.b;
/* compiled from: ObservableToList.java */
/* loaded from: classes3.dex */
public final class x3<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f29132b;

    /* compiled from: ObservableToList.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super U> f29133a;

        /* renamed from: b  reason: collision with root package name */
        b f29134b;

        /* renamed from: c  reason: collision with root package name */
        U f29135c;

        a(r<? super U> rVar, U u10) {
            this.f29133a = rVar;
            this.f29135c = u10;
        }

        @Override // xn.b
        public void dispose() {
            this.f29134b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29134b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            U u10 = this.f29135c;
            this.f29135c = null;
            this.f29133a.onNext(u10);
            this.f29133a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29135c = null;
            this.f29133a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f29135c.add(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29134b, bVar)) {
                this.f29134b = bVar;
                this.f29133a.onSubscribe(this);
            }
        }
    }

    public x3(p<T> pVar, int i10) {
        super(pVar);
        this.f29132b = bo.a.e(i10);
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super U> rVar) {
        try {
            this.f28426a.subscribe(new a(rVar, (Collection) bo.b.e(this.f29132b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, rVar);
        }
    }

    public x3(p<T> pVar, Callable<U> callable) {
        super(pVar);
        this.f29132b = callable;
    }
}
