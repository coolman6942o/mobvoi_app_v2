package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
import zn.o;
/* compiled from: ObservableFlattenIterable.java */
/* loaded from: classes3.dex */
public final class a1<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends Iterable<? extends R>> f28431b;

    /* compiled from: ObservableFlattenIterable.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super R> f28432a;

        /* renamed from: b  reason: collision with root package name */
        final o<? super T, ? extends Iterable<? extends R>> f28433b;

        /* renamed from: c  reason: collision with root package name */
        b f28434c;

        a(r<? super R> rVar, o<? super T, ? extends Iterable<? extends R>> oVar) {
            this.f28432a = rVar;
            this.f28433b = oVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28434c.dispose();
            this.f28434c = DisposableHelper.DISPOSED;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28434c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            b bVar = this.f28434c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                this.f28434c = disposableHelper;
                this.f28432a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            b bVar = this.f28434c;
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar == disposableHelper) {
                fo.a.s(th2);
                return;
            }
            this.f28434c = disposableHelper;
            this.f28432a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.f28434c != DisposableHelper.DISPOSED) {
                try {
                    r<? super R> rVar = this.f28432a;
                    for (R r10 : this.f28433b.apply(t10)) {
                        try {
                            try {
                                rVar.onNext((Object) bo.b.e(r10, "The iterator returned a null value"));
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                this.f28434c.dispose();
                                onError(th2);
                                return;
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.f28434c.dispose();
                            onError(th3);
                            return;
                        }
                    }
                } catch (Throwable th4) {
                    io.reactivex.exceptions.a.b(th4);
                    this.f28434c.dispose();
                    onError(th4);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28434c, bVar)) {
                this.f28434c = bVar;
                this.f28432a.onSubscribe(this);
            }
        }
    }

    public a1(p<T> pVar, o<? super T, ? extends Iterable<? extends R>> oVar) {
        super(pVar);
        this.f28431b = oVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28431b));
    }
}
