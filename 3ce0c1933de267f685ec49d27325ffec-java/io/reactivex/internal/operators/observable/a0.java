package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.t;
import io.reactivex.u;
import xn.b;
/* compiled from: ObservableCountSingle.java */
/* loaded from: classes3.dex */
public final class a0<T> extends t<Long> implements co.a<Long> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28427a;

    /* compiled from: ObservableCountSingle.java */
    /* loaded from: classes3.dex */
    static final class a implements r<Object>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super Long> f28428a;

        /* renamed from: b  reason: collision with root package name */
        b f28429b;

        /* renamed from: c  reason: collision with root package name */
        long f28430c;

        a(u<? super Long> uVar) {
            this.f28428a = uVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28429b.dispose();
            this.f28429b = DisposableHelper.DISPOSED;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28429b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28429b = DisposableHelper.DISPOSED;
            this.f28428a.onSuccess(Long.valueOf(this.f28430c));
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28429b = DisposableHelper.DISPOSED;
            this.f28428a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(Object obj) {
            this.f28430c++;
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28429b, bVar)) {
                this.f28429b = bVar;
                this.f28428a.onSubscribe(this);
            }
        }
    }

    public a0(p<T> pVar) {
        this.f28427a = pVar;
    }

    @Override // co.a
    public k<Long> a() {
        return fo.a.o(new z(this.f28427a));
    }

    @Override // io.reactivex.t
    public void e(u<? super Long> uVar) {
        this.f28427a.subscribe(new a(uVar));
    }
}
