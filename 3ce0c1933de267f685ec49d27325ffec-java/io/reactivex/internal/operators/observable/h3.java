package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableSubscribeOn.java */
/* loaded from: classes3.dex */
public final class h3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final s f28703b;

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<xn.b> implements r<T>, xn.b {
        private static final long serialVersionUID = 8094547886072529208L;
        final r<? super T> downstream;
        final AtomicReference<xn.b> upstream = new AtomicReference<>();

        a(r<? super T> rVar) {
            this.downstream = rVar;
        }

        void a(xn.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    /* compiled from: ObservableSubscribeOn.java */
    /* loaded from: classes3.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final a<T> f28704a;

        b(a<T> aVar) {
            this.f28704a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            h3.this.f28426a.subscribe(this.f28704a);
        }
    }

    public h3(p<T> pVar, s sVar) {
        super(pVar);
        this.f28703b = sVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        a aVar = new a(rVar);
        rVar.onSubscribe(aVar);
        aVar.a(this.f28703b.c(new b(aVar)));
    }
}
