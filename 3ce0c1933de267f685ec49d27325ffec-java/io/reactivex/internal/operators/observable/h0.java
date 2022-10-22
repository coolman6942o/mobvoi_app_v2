package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.j;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
import zn.o;
/* compiled from: ObservableDematerialize.java */
/* loaded from: classes3.dex */
public final class h0<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends j<R>> f28687b;

    /* compiled from: ObservableDematerialize.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super R> f28688a;

        /* renamed from: b  reason: collision with root package name */
        final o<? super T, ? extends j<R>> f28689b;

        /* renamed from: c  reason: collision with root package name */
        boolean f28690c;

        /* renamed from: d  reason: collision with root package name */
        b f28691d;

        a(r<? super R> rVar, o<? super T, ? extends j<R>> oVar) {
            this.f28688a = rVar;
            this.f28689b = oVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28691d.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28691d.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28690c) {
                this.f28690c = true;
                this.f28688a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28690c) {
                fo.a.s(th2);
                return;
            }
            this.f28690c = true;
            this.f28688a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28690c) {
                try {
                    j jVar = (j) bo.b.e(this.f28689b.apply(t10), "The selector returned a null Notification");
                    if (jVar.g()) {
                        this.f28691d.dispose();
                        onError(jVar.d());
                    } else if (jVar.f()) {
                        this.f28691d.dispose();
                        onComplete();
                    } else {
                        this.f28688a.onNext((Object) jVar.e());
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28691d.dispose();
                    onError(th2);
                }
            } else if (t10 instanceof j) {
                j jVar2 = (j) t10;
                if (jVar2.g()) {
                    fo.a.s(jVar2.d());
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28691d, bVar)) {
                this.f28691d = bVar;
                this.f28688a.onSubscribe(this);
            }
        }
    }

    public h0(p<T> pVar, o<? super T, ? extends j<R>> oVar) {
        super(pVar);
        this.f28687b = oVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super R> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28687b));
    }
}
