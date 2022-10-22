package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.r;
import xn.b;
import zn.p;
/* compiled from: ObservableSkipWhile.java */
/* loaded from: classes3.dex */
public final class g3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<? super T> f28674b;

    /* compiled from: ObservableSkipWhile.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28675a;

        /* renamed from: b  reason: collision with root package name */
        final p<? super T> f28676b;

        /* renamed from: c  reason: collision with root package name */
        b f28677c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28678d;

        a(r<? super T> rVar, p<? super T> pVar) {
            this.f28675a = rVar;
            this.f28676b = pVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28677c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28677c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28675a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28675a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.f28678d) {
                this.f28675a.onNext(t10);
                return;
            }
            try {
                if (!this.f28676b.test(t10)) {
                    this.f28678d = true;
                    this.f28675a.onNext(t10);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f28677c.dispose();
                this.f28675a.onError(th2);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28677c, bVar)) {
                this.f28677c = bVar;
                this.f28675a.onSubscribe(this);
            }
        }
    }

    public g3(io.reactivex.p<T> pVar, p<? super T> pVar2) {
        super(pVar);
        this.f28674b = pVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28674b));
    }
}
