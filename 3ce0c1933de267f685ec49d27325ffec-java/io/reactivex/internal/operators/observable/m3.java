package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableTakeLastOne.java */
/* loaded from: classes3.dex */
public final class m3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* compiled from: ObservableTakeLastOne.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28843a;

        /* renamed from: b  reason: collision with root package name */
        b f28844b;

        /* renamed from: c  reason: collision with root package name */
        T f28845c;

        a(r<? super T> rVar) {
            this.f28843a = rVar;
        }

        void a() {
            T t10 = this.f28845c;
            if (t10 != null) {
                this.f28845c = null;
                this.f28843a.onNext(t10);
            }
            this.f28843a.onComplete();
        }

        @Override // xn.b
        public void dispose() {
            this.f28845c = null;
            this.f28844b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28844b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28845c = null;
            this.f28843a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28845c = t10;
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28844b, bVar)) {
                this.f28844b = bVar;
                this.f28843a.onSubscribe(this);
            }
        }
    }

    public m3(p<T> pVar) {
        super(pVar);
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar));
    }
}
