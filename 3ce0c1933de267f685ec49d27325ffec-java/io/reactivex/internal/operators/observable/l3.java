package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import java.util.ArrayDeque;
import xn.b;
/* compiled from: ObservableTakeLast.java */
/* loaded from: classes3.dex */
public final class l3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final int f28809b;

    /* compiled from: ObservableTakeLast.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends ArrayDeque<T> implements r<T>, b {
        private static final long serialVersionUID = 7240042530241604978L;
        volatile boolean cancelled;
        final int count;
        final r<? super T> downstream;
        b upstream;

        a(r<? super T> rVar, int i10) {
            this.downstream = rVar;
            this.count = i10;
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            r<? super T> rVar = this.downstream;
            while (!this.cancelled) {
                Object obj = (T) poll();
                if (obj != null) {
                    rVar.onNext(obj);
                } else if (!this.cancelled) {
                    rVar.onComplete();
                    return;
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.count == size()) {
                poll();
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

    public l3(p<T> pVar, int i10) {
        super(pVar);
        this.f28809b = i10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28809b));
    }
}
