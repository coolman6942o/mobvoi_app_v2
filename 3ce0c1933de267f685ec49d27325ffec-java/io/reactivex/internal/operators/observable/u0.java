package io.reactivex.internal.operators.observable;

import io.reactivex.r;
import zn.p;
/* compiled from: ObservableFilter.java */
/* loaded from: classes3.dex */
public final class u0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<? super T> f29060b;

    /* compiled from: ObservableFilter.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends io.reactivex.internal.observers.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final p<? super T> f29061f;

        a(r<? super T> rVar, p<? super T> pVar) {
            super(rVar);
            this.f29061f = pVar;
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.f28357e == 0) {
                try {
                    if (this.f29061f.test(t10)) {
                        this.f28353a.onNext(t10);
                    }
                } catch (Throwable th2) {
                    c(th2);
                }
            } else {
                this.f28353a.onNext(null);
            }
        }

        @Override // co.g
        public T poll() throws Exception {
            T poll;
            do {
                poll = this.f28355c.poll();
                if (poll == null) {
                    break;
                }
            } while (!this.f29061f.test(poll));
            return poll;
        }

        @Override // co.c
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public u0(io.reactivex.p<T> pVar, p<? super T> pVar2) {
        super(pVar);
        this.f29060b = pVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29060b));
    }
}
