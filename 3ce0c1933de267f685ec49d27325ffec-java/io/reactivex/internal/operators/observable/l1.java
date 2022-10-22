package io.reactivex.internal.operators.observable;

import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableIgnoreElementsCompletable.java */
/* loaded from: classes3.dex */
public final class l1<T> extends io.reactivex.a implements co.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28800a;

    /* compiled from: ObservableIgnoreElementsCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.b f28801a;

        /* renamed from: b  reason: collision with root package name */
        b f28802b;

        a(io.reactivex.b bVar) {
            this.f28801a = bVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28802b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28802b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28801a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28801a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            this.f28802b = bVar;
            this.f28801a.onSubscribe(this);
        }
    }

    public l1(p<T> pVar) {
        this.f28800a = pVar;
    }

    @Override // co.a
    public k<T> a() {
        return fo.a.o(new k1(this.f28800a));
    }

    @Override // io.reactivex.a
    public void c(io.reactivex.b bVar) {
        this.f28800a.subscribe(new a(bVar));
    }
}
