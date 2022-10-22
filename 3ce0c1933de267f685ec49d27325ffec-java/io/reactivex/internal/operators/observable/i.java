package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import xn.b;
import zn.p;
/* compiled from: ObservableAny.java */
/* loaded from: classes3.dex */
public final class i<T> extends io.reactivex.internal.operators.observable.a<T, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final p<? super T> f28710b;

    /* compiled from: ObservableAny.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super Boolean> f28711a;

        /* renamed from: b  reason: collision with root package name */
        final p<? super T> f28712b;

        /* renamed from: c  reason: collision with root package name */
        b f28713c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28714d;

        a(r<? super Boolean> rVar, p<? super T> pVar) {
            this.f28711a = rVar;
            this.f28712b = pVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28713c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28713c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28714d) {
                this.f28714d = true;
                this.f28711a.onNext(Boolean.FALSE);
                this.f28711a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28714d) {
                fo.a.s(th2);
                return;
            }
            this.f28714d = true;
            this.f28711a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28714d) {
                try {
                    if (this.f28712b.test(t10)) {
                        this.f28714d = true;
                        this.f28713c.dispose();
                        this.f28711a.onNext(Boolean.TRUE);
                        this.f28711a.onComplete();
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28713c.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28713c, bVar)) {
                this.f28713c = bVar;
                this.f28711a.onSubscribe(this);
            }
        }
    }

    public i(io.reactivex.p<T> pVar, p<? super T> pVar2) {
        super(pVar);
        this.f28710b = pVar2;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super Boolean> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28710b));
    }
}
