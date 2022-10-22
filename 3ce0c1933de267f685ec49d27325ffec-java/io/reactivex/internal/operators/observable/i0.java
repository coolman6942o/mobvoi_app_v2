package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EmptyComponent;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableDetach.java */
/* loaded from: classes3.dex */
public final class i0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* compiled from: ObservableDetach.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        r<? super T> f28715a;

        /* renamed from: b  reason: collision with root package name */
        b f28716b;

        a(r<? super T> rVar) {
            this.f28715a = rVar;
        }

        @Override // xn.b
        public void dispose() {
            b bVar = this.f28716b;
            this.f28716b = EmptyComponent.INSTANCE;
            this.f28715a = EmptyComponent.asObserver();
            bVar.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28716b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            r<? super T> rVar = this.f28715a;
            this.f28716b = EmptyComponent.INSTANCE;
            this.f28715a = EmptyComponent.asObserver();
            rVar.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            r<? super T> rVar = this.f28715a;
            this.f28716b = EmptyComponent.INSTANCE;
            this.f28715a = EmptyComponent.asObserver();
            rVar.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28715a.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28716b, bVar)) {
                this.f28716b = bVar;
                this.f28715a.onSubscribe(this);
            }
        }
    }

    public i0(p<T> pVar) {
        super(pVar);
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar));
    }
}
