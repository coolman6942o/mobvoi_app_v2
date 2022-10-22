package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import xn.b;
import zn.p;
/* compiled from: ObservableAll.java */
/* loaded from: classes3.dex */
public final class f<T> extends io.reactivex.internal.operators.observable.a<T, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final p<? super T> f28579b;

    /* compiled from: ObservableAll.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super Boolean> f28580a;

        /* renamed from: b  reason: collision with root package name */
        final p<? super T> f28581b;

        /* renamed from: c  reason: collision with root package name */
        b f28582c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28583d;

        a(r<? super Boolean> rVar, p<? super T> pVar) {
            this.f28580a = rVar;
            this.f28581b = pVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28582c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28582c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28583d) {
                this.f28583d = true;
                this.f28580a.onNext(Boolean.TRUE);
                this.f28580a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28583d) {
                fo.a.s(th2);
                return;
            }
            this.f28583d = true;
            this.f28580a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28583d) {
                try {
                    if (!this.f28581b.test(t10)) {
                        this.f28583d = true;
                        this.f28582c.dispose();
                        this.f28580a.onNext(Boolean.FALSE);
                        this.f28580a.onComplete();
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28582c.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28582c, bVar)) {
                this.f28582c = bVar;
                this.f28580a.onSubscribe(this);
            }
        }
    }

    public f(io.reactivex.p<T> pVar, p<? super T> pVar2) {
        super(pVar);
        this.f28579b = pVar2;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super Boolean> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28579b));
    }
}
