package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableConcatWithSingle.java */
/* loaded from: classes3.dex */
public final class y<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final v<? extends T> f29136b;

    /* compiled from: ObservableConcatWithSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<b> implements r<T>, u<T>, b {
        private static final long serialVersionUID = -1953724749712440952L;
        final r<? super T> downstream;
        boolean inSingle;
        v<? extends T> other;

        a(r<? super T> rVar, v<? extends T> vVar) {
            this.downstream = rVar;
            this.other = vVar;
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.inSingle = true;
            DisposableHelper.replace(this, null);
            v<? extends T> vVar = this.other;
            this.other = null;
            vVar.b(this);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && !this.inSingle) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.u
        public void onSuccess(T t10) {
            this.downstream.onNext(t10);
            this.downstream.onComplete();
        }
    }

    public y(k<T> kVar, v<? extends T> vVar) {
        super(kVar);
        this.f29136b = vVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29136b));
    }
}
