package io.reactivex.internal.operators.observable;

import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableConcatWithMaybe.java */
/* loaded from: classes3.dex */
public final class x<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final i<? extends T> f29116b;

    /* compiled from: ObservableConcatWithMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<b> implements r<T>, h<T>, b {
        private static final long serialVersionUID = -1953724749712440952L;
        final r<? super T> downstream;
        boolean inMaybe;
        i<? extends T> other;

        a(r<? super T> rVar, i<? extends T> iVar) {
            this.downstream = rVar;
            this.other = iVar;
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
            if (this.inMaybe) {
                this.downstream.onComplete();
                return;
            }
            this.inMaybe = true;
            DisposableHelper.replace(this, null);
            i<? extends T> iVar = this.other;
            this.other = null;
            iVar.b(this);
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
            if (DisposableHelper.setOnce(this, bVar) && !this.inMaybe) {
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.h
        public void onSuccess(T t10) {
            this.downstream.onNext(t10);
            this.downstream.onComplete();
        }
    }

    public x(k<T> kVar, i<? extends T> iVar) {
        super(kVar);
        this.f29116b = iVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29116b));
    }
}
