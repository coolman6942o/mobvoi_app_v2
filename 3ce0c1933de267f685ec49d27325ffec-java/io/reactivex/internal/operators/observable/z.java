package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableCount.java */
/* loaded from: classes3.dex */
public final class z<T> extends io.reactivex.internal.operators.observable.a<T, Long> {

    /* compiled from: ObservableCount.java */
    /* loaded from: classes3.dex */
    static final class a implements r<Object>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super Long> f29156a;

        /* renamed from: b  reason: collision with root package name */
        b f29157b;

        /* renamed from: c  reason: collision with root package name */
        long f29158c;

        a(r<? super Long> rVar) {
            this.f29156a = rVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f29157b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29157b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f29156a.onNext(Long.valueOf(this.f29158c));
            this.f29156a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29156a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(Object obj) {
            this.f29158c++;
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29157b, bVar)) {
                this.f29157b = bVar;
                this.f29156a.onSubscribe(this);
            }
        }
    }

    public z(p<T> pVar) {
        super(pVar);
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super Long> rVar) {
        this.f28426a.subscribe(new a(rVar));
    }
}
