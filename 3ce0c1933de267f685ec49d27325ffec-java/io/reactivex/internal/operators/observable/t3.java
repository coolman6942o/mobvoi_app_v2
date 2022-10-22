package io.reactivex.internal.operators.observable;

import go.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
/* compiled from: ObservableTimeInterval.java */
/* loaded from: classes3.dex */
public final class t3<T> extends io.reactivex.internal.operators.observable.a<T, b<T>> {

    /* renamed from: b  reason: collision with root package name */
    final s f29050b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f29051c;

    /* compiled from: ObservableTimeInterval.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, xn.b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super b<T>> f29052a;

        /* renamed from: b  reason: collision with root package name */
        final TimeUnit f29053b;

        /* renamed from: c  reason: collision with root package name */
        final s f29054c;

        /* renamed from: d  reason: collision with root package name */
        long f29055d;

        /* renamed from: e  reason: collision with root package name */
        xn.b f29056e;

        a(r<? super b<T>> rVar, TimeUnit timeUnit, s sVar) {
            this.f29052a = rVar;
            this.f29054c = sVar;
            this.f29053b = timeUnit;
        }

        @Override // xn.b
        public void dispose() {
            this.f29056e.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29056e.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f29052a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29052a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            long b10 = this.f29054c.b(this.f29053b);
            long j10 = this.f29055d;
            this.f29055d = b10;
            this.f29052a.onNext(new b(t10, b10 - j10, this.f29053b));
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f29056e, bVar)) {
                this.f29056e = bVar;
                this.f29055d = this.f29054c.b(this.f29053b);
                this.f29052a.onSubscribe(this);
            }
        }
    }

    public t3(p<T> pVar, TimeUnit timeUnit, s sVar) {
        super(pVar);
        this.f29050b = sVar;
        this.f29051c = timeUnit;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super b<T>> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29051c, this.f29050b));
    }
}
