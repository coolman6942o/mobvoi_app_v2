package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
/* compiled from: ObservableSkipUntil.java */
/* loaded from: classes3.dex */
public final class f3<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<U> f28605b;

    /* compiled from: ObservableSkipUntil.java */
    /* loaded from: classes3.dex */
    final class a implements r<U> {

        /* renamed from: a  reason: collision with root package name */
        final ArrayCompositeDisposable f28606a;

        /* renamed from: b  reason: collision with root package name */
        final b<T> f28607b;

        /* renamed from: c  reason: collision with root package name */
        final d<T> f28608c;

        /* renamed from: d  reason: collision with root package name */
        xn.b f28609d;

        a(f3 f3Var, ArrayCompositeDisposable arrayCompositeDisposable, b<T> bVar, d<T> dVar) {
            this.f28606a = arrayCompositeDisposable;
            this.f28607b = bVar;
            this.f28608c = dVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28607b.f28613d = true;
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28606a.dispose();
            this.f28608c.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(U u10) {
            this.f28609d.dispose();
            this.f28607b.f28613d = true;
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28609d, bVar)) {
                this.f28609d = bVar;
                this.f28606a.setResource(1, bVar);
            }
        }
    }

    /* compiled from: ObservableSkipUntil.java */
    /* loaded from: classes3.dex */
    static final class b<T> implements r<T> {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28610a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayCompositeDisposable f28611b;

        /* renamed from: c  reason: collision with root package name */
        xn.b f28612c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f28613d;

        /* renamed from: e  reason: collision with root package name */
        boolean f28614e;

        b(r<? super T> rVar, ArrayCompositeDisposable arrayCompositeDisposable) {
            this.f28610a = rVar;
            this.f28611b = arrayCompositeDisposable;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28611b.dispose();
            this.f28610a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28611b.dispose();
            this.f28610a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.f28614e) {
                this.f28610a.onNext(t10);
            } else if (this.f28613d) {
                this.f28614e = true;
                this.f28610a.onNext(t10);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28612c, bVar)) {
                this.f28612c = bVar;
                this.f28611b.setResource(0, bVar);
            }
        }
    }

    public f3(p<T> pVar, p<U> pVar2) {
        super(pVar);
        this.f28605b = pVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        d dVar = new d(rVar);
        ArrayCompositeDisposable arrayCompositeDisposable = new ArrayCompositeDisposable(2);
        dVar.onSubscribe(arrayCompositeDisposable);
        b bVar = new b(dVar, arrayCompositeDisposable);
        this.f28605b.subscribe(new a(this, arrayCompositeDisposable, bVar, dVar));
        this.f28426a.subscribe(bVar);
    }
}
