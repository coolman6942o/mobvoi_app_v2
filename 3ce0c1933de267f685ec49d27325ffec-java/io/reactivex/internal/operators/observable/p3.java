package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import xn.b;
import zn.p;
/* compiled from: ObservableTakeUntilPredicate.java */
/* loaded from: classes3.dex */
public final class p3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<? super T> f28962b;

    /* compiled from: ObservableTakeUntilPredicate.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28963a;

        /* renamed from: b  reason: collision with root package name */
        final p<? super T> f28964b;

        /* renamed from: c  reason: collision with root package name */
        b f28965c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28966d;

        a(r<? super T> rVar, p<? super T> pVar) {
            this.f28963a = rVar;
            this.f28964b = pVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28965c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28965c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28966d) {
                this.f28966d = true;
                this.f28963a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (!this.f28966d) {
                this.f28966d = true;
                this.f28963a.onError(th2);
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28966d) {
                this.f28963a.onNext(t10);
                try {
                    if (this.f28964b.test(t10)) {
                        this.f28966d = true;
                        this.f28965c.dispose();
                        this.f28963a.onComplete();
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28965c.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28965c, bVar)) {
                this.f28965c = bVar;
                this.f28963a.onSubscribe(this);
            }
        }
    }

    public p3(io.reactivex.p<T> pVar, p<? super T> pVar2) {
        super(pVar);
        this.f28962b = pVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28962b));
    }
}
