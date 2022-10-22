package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservablePublishSelector.java */
/* loaded from: classes3.dex */
public final class f2<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super k<T>, ? extends p<R>> f28602b;

    /* compiled from: ObservablePublishSelector.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements r<T> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.subjects.a<T> f28603a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<xn.b> f28604b;

        a(io.reactivex.subjects.a<T> aVar, AtomicReference<xn.b> atomicReference) {
            this.f28603a = aVar;
            this.f28604b = atomicReference;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28603a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28603a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28603a.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.f28604b, bVar);
        }
    }

    /* compiled from: ObservablePublishSelector.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicReference<xn.b> implements r<R>, xn.b {
        private static final long serialVersionUID = 854110278590336484L;
        final r<? super R> downstream;
        xn.b upstream;

        b(r<? super R> rVar) {
            this.downstream = rVar;
        }

        @Override // xn.b
        public void dispose() {
            this.upstream.dispose();
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            DisposableHelper.dispose(this);
            this.downstream.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this);
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(R r10) {
            this.downstream.onNext(r10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public f2(p<T> pVar, o<? super k<T>, ? extends p<R>> oVar) {
        super(pVar);
        this.f28602b = oVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        io.reactivex.subjects.a d10 = io.reactivex.subjects.a.d();
        try {
            p pVar = (p) bo.b.e(this.f28602b.apply(d10), "The selector returned a null ObservableSource");
            b bVar = new b(rVar);
            pVar.subscribe(bVar);
            this.f28426a.subscribe(new a(d10, bVar));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, rVar);
        }
    }
}
