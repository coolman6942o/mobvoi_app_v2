package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
import zn.o;
/* compiled from: ObservableOnErrorReturn.java */
/* loaded from: classes3.dex */
public final class d2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super Throwable, ? extends T> f28519b;

    /* compiled from: ObservableOnErrorReturn.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28520a;

        /* renamed from: b  reason: collision with root package name */
        final o<? super Throwable, ? extends T> f28521b;

        /* renamed from: c  reason: collision with root package name */
        b f28522c;

        a(r<? super T> rVar, o<? super Throwable, ? extends T> oVar) {
            this.f28520a = rVar;
            this.f28521b = oVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28522c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28522c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28520a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            try {
                T apply = this.f28521b.apply(th2);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th2);
                    this.f28520a.onError(nullPointerException);
                    return;
                }
                this.f28520a.onNext(apply);
                this.f28520a.onComplete();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f28520a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28520a.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28522c, bVar)) {
                this.f28522c = bVar;
                this.f28520a.onSubscribe(this);
            }
        }
    }

    public d2(p<T> pVar, o<? super Throwable, ? extends T> oVar) {
        super(pVar);
        this.f28519b = oVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28519b));
    }
}
