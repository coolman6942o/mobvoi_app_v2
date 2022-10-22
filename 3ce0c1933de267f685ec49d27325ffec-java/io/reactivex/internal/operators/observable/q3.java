package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import xn.b;
import zn.p;
/* compiled from: ObservableTakeWhile.java */
/* loaded from: classes3.dex */
public final class q3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<? super T> f28989b;

    /* compiled from: ObservableTakeWhile.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28990a;

        /* renamed from: b  reason: collision with root package name */
        final p<? super T> f28991b;

        /* renamed from: c  reason: collision with root package name */
        b f28992c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28993d;

        a(r<? super T> rVar, p<? super T> pVar) {
            this.f28990a = rVar;
            this.f28991b = pVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28992c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28992c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28993d) {
                this.f28993d = true;
                this.f28990a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28993d) {
                fo.a.s(th2);
                return;
            }
            this.f28993d = true;
            this.f28990a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28993d) {
                try {
                    if (!this.f28991b.test(t10)) {
                        this.f28993d = true;
                        this.f28992c.dispose();
                        this.f28990a.onComplete();
                        return;
                    }
                    this.f28990a.onNext(t10);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28992c.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28992c, bVar)) {
                this.f28992c = bVar;
                this.f28990a.onSubscribe(this);
            }
        }
    }

    public q3(io.reactivex.p<T> pVar, p<? super T> pVar2) {
        super(pVar);
        this.f28989b = pVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28989b));
    }
}
