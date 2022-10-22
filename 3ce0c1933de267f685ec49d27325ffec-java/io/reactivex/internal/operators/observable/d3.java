package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import java.util.ArrayDeque;
import xn.b;
/* compiled from: ObservableSkipLast.java */
/* loaded from: classes3.dex */
public final class d3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final int f28523b;

    /* compiled from: ObservableSkipLast.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends ArrayDeque<T> implements r<T>, b {
        private static final long serialVersionUID = -3807491841935125653L;
        final r<? super T> downstream;
        final int skip;
        b upstream;

        a(r<? super T> rVar, int i10) {
            super(i10);
            this.downstream = rVar;
            this.skip = i10;
        }

        @Override // xn.b
        public void dispose() {
            this.upstream.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.skip == size()) {
                this.downstream.onNext((T) poll());
            }
            offer(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public d3(p<T> pVar, int i10) {
        super(pVar);
        this.f28523b = i10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28523b));
    }
}
