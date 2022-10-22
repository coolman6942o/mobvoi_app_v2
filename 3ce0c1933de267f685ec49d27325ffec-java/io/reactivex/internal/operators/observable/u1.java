package io.reactivex.internal.operators.observable;

import bo.b;
import io.reactivex.p;
import io.reactivex.r;
import zn.o;
/* compiled from: ObservableMap.java */
/* loaded from: classes3.dex */
public final class u1<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends U> f29062b;

    /* compiled from: ObservableMap.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> extends io.reactivex.internal.observers.a<T, U> {

        /* renamed from: f  reason: collision with root package name */
        final o<? super T, ? extends U> f29063f;

        a(r<? super U> rVar, o<? super T, ? extends U> oVar) {
            super(rVar);
            this.f29063f = oVar;
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28356d) {
                if (this.f28357e != 0) {
                    this.f28353a.onNext(null);
                    return;
                }
                try {
                    this.f28353a.onNext(b.e(this.f29063f.apply(t10), "The mapper function returned a null value."));
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Override // co.g
        public U poll() throws Exception {
            T poll = this.f28355c.poll();
            if (poll != null) {
                return (U) b.e(this.f29063f.apply(poll), "The mapper function returned a null value.");
            }
            return null;
        }

        @Override // co.c
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public u1(p<T> pVar, o<? super T, ? extends U> oVar) {
        super(pVar);
        this.f29062b = oVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super U> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29062b));
    }
}
