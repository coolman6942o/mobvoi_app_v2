package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.g;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableTakeUntil.java */
/* loaded from: classes3.dex */
public final class o3<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<? extends U> f28894b;

    /* compiled from: ObservableTakeUntil.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends AtomicInteger implements r<T>, b {
        private static final long serialVersionUID = 1418547743690811973L;
        final r<? super T> downstream;
        final AtomicReference<b> upstream = new AtomicReference<>();
        final a<T, U>.C0334a otherObserver = new C0334a();
        final AtomicThrowable error = new AtomicThrowable();

        /* compiled from: ObservableTakeUntil.java */
        /* renamed from: io.reactivex.internal.operators.observable.o3$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0334a extends AtomicReference<b> implements r<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            C0334a() {
            }

            @Override // io.reactivex.r
            public void onComplete() {
                a.this.a();
            }

            @Override // io.reactivex.r
            public void onError(Throwable th2) {
                a.this.b(th2);
            }

            @Override // io.reactivex.r
            public void onNext(U u10) {
                DisposableHelper.dispose(this);
                a.this.a();
            }

            @Override // io.reactivex.r
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        a(r<? super T> rVar) {
            this.downstream = rVar;
        }

        void a() {
            DisposableHelper.dispose(this.upstream);
            g.a(this.downstream, this, this.error);
        }

        void b(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            g.c(this.downstream, th2, this, this.error);
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            DisposableHelper.dispose(this.otherObserver);
            g.a(this.downstream, this, this.error);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.otherObserver);
            g.c(this.downstream, th2, this, this.error);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            g.e(this.downstream, t10, this, this.error);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public o3(p<T> pVar, p<? extends U> pVar2) {
        super(pVar);
        this.f28894b = pVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        a aVar = new a(rVar);
        rVar.onSubscribe(aVar);
        this.f28894b.subscribe(aVar.otherObserver);
        this.f28426a.subscribe(aVar);
    }
}
