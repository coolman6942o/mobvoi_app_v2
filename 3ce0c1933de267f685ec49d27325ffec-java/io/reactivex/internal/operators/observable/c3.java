package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableSkip.java */
/* loaded from: classes3.dex */
public final class c3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f28492b;

    /* compiled from: ObservableSkip.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28493a;

        /* renamed from: b  reason: collision with root package name */
        long f28494b;

        /* renamed from: c  reason: collision with root package name */
        b f28495c;

        a(r<? super T> rVar, long j10) {
            this.f28493a = rVar;
            this.f28494b = j10;
        }

        @Override // xn.b
        public void dispose() {
            this.f28495c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28495c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28493a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28493a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            long j10 = this.f28494b;
            if (j10 != 0) {
                this.f28494b = j10 - 1;
            } else {
                this.f28493a.onNext(t10);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28495c, bVar)) {
                this.f28495c = bVar;
                this.f28493a.onSubscribe(this);
            }
        }
    }

    public c3(p<T> pVar, long j10) {
        super(pVar);
        this.f28492b = j10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28492b));
    }
}
