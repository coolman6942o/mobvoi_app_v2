package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.t;
import io.reactivex.u;
import java.util.Collection;
import java.util.concurrent.Callable;
import xn.b;
/* compiled from: ObservableToListSingle.java */
/* loaded from: classes3.dex */
public final class y3<T, U extends Collection<? super T>> extends t<U> implements co.a<U> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f29151a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f29152b;

    /* compiled from: ObservableToListSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super U> f29153a;

        /* renamed from: b  reason: collision with root package name */
        U f29154b;

        /* renamed from: c  reason: collision with root package name */
        b f29155c;

        a(u<? super U> uVar, U u10) {
            this.f29153a = uVar;
            this.f29154b = u10;
        }

        @Override // xn.b
        public void dispose() {
            this.f29155c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29155c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            U u10 = this.f29154b;
            this.f29154b = null;
            this.f29153a.onSuccess(u10);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29154b = null;
            this.f29153a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f29154b.add(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29155c, bVar)) {
                this.f29155c = bVar;
                this.f29153a.onSubscribe(this);
            }
        }
    }

    public y3(p<T> pVar, int i10) {
        this.f29151a = pVar;
        this.f29152b = bo.a.e(i10);
    }

    @Override // co.a
    public k<U> a() {
        return fo.a.o(new x3(this.f29151a, this.f29152b));
    }

    @Override // io.reactivex.t
    public void e(u<? super U> uVar) {
        try {
            this.f29151a.subscribe(new a(uVar, (Collection) bo.b.e(this.f29152b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, uVar);
        }
    }

    public y3(p<T> pVar, Callable<U> callable) {
        this.f29151a = pVar;
        this.f29152b = callable;
    }
}
