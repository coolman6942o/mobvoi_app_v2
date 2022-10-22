package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import zn.c;
/* compiled from: ObservableWithLatestFrom.java */
/* loaded from: classes3.dex */
public final class g4<T, U, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final c<? super T, ? super U, ? extends R> f28679b;

    /* renamed from: c  reason: collision with root package name */
    final p<? extends U> f28680c;

    /* compiled from: ObservableWithLatestFrom.java */
    /* loaded from: classes3.dex */
    static final class a<T, U, R> extends AtomicReference<U> implements r<T>, xn.b {
        private static final long serialVersionUID = -312246233408980075L;
        final c<? super T, ? super U, ? extends R> combiner;
        final r<? super R> downstream;
        final AtomicReference<xn.b> upstream = new AtomicReference<>();
        final AtomicReference<xn.b> other = new AtomicReference<>();

        a(r<? super R> rVar, c<? super T, ? super U, ? extends R> cVar) {
            this.downstream = rVar;
            this.combiner = cVar;
        }

        public void a(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            this.downstream.onError(th2);
        }

        public boolean b(xn.b bVar) {
            return DisposableHelper.setOnce(this.other, bVar);
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.other);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            DisposableHelper.dispose(this.other);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.other);
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            U u10 = get();
            if (u10 != null) {
                try {
                    this.downstream.onNext(bo.b.e(this.combiner.apply(t10, u10), "The combiner returned a null value"));
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    dispose();
                    this.downstream.onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    /* compiled from: ObservableWithLatestFrom.java */
    /* loaded from: classes3.dex */
    final class b implements r<U> {

        /* renamed from: a  reason: collision with root package name */
        private final a<T, U, R> f28681a;

        b(g4 g4Var, a<T, U, R> aVar) {
            this.f28681a = aVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28681a.a(th2);
        }

        @Override // io.reactivex.r
        public void onNext(U u10) {
            this.f28681a.lazySet(u10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            this.f28681a.b(bVar);
        }
    }

    public g4(p<T> pVar, c<? super T, ? super U, ? extends R> cVar, p<? extends U> pVar2) {
        super(pVar);
        this.f28679b = cVar;
        this.f28680c = pVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super R> rVar) {
        d dVar = new d(rVar);
        a aVar = new a(dVar, this.f28679b);
        dVar.onSubscribe(aVar);
        this.f28680c.subscribe(new b(this, aVar));
        this.f28426a.subscribe(aVar);
    }
}
