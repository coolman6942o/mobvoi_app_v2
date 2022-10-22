package io.reactivex.internal.operators.observable;

import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableConcatWithCompletable.java */
/* loaded from: classes3.dex */
public final class w<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final c f29101b;

    /* compiled from: ObservableConcatWithCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicReference<b> implements r<T>, io.reactivex.b, b {
        private static final long serialVersionUID = -1953724749712440952L;
        final r<? super T> downstream;
        boolean inCompletable;
        c other;

        a(r<? super T> rVar, c cVar) {
            this.downstream = rVar;
            this.other = cVar;
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
            if (this.inCompletable) {
                this.downstream.onComplete();
                return;
            }
            this.inCompletable = true;
            DisposableHelper.replace(this, null);
            c cVar = this.other;
            this.other = null;
            cVar.b(this);
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
            if (DisposableHelper.setOnce(this, bVar) && !this.inCompletable) {
                this.downstream.onSubscribe(this);
            }
        }
    }

    public w(k<T> kVar, c cVar) {
        super(kVar);
        this.f29101b = cVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29101b));
    }
}
