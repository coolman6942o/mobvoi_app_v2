package io.reactivex.internal.operators.observable;

import io.reactivex.p;
import io.reactivex.r;
import zn.g;
/* compiled from: ObservableDoAfterNext.java */
/* loaded from: classes3.dex */
public final class l0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final g<? super T> f28798b;

    /* compiled from: ObservableDoAfterNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends io.reactivex.internal.observers.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final g<? super T> f28799f;

        a(r<? super T> rVar, g<? super T> gVar) {
            super(rVar);
            this.f28799f = gVar;
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28353a.onNext(t10);
            if (this.f28357e == 0) {
                try {
                    this.f28799f.accept(t10);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Override // co.g
        public T poll() throws Exception {
            T poll = this.f28355c.poll();
            if (poll != null) {
                this.f28799f.accept(poll);
            }
            return poll;
        }

        @Override // co.c
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public l0(p<T> pVar, g<? super T> gVar) {
        super(pVar);
        this.f28798b = gVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28798b));
    }
}
