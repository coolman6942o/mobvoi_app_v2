package io.reactivex.internal.operators.observable;

import io.reactivex.p;
import io.reactivex.r;
import zn.d;
import zn.o;
/* compiled from: ObservableDistinctUntilChanged.java */
/* loaded from: classes3.dex */
public final class k0<T, K> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, K> f28773b;

    /* renamed from: c  reason: collision with root package name */
    final d<? super K, ? super K> f28774c;

    /* compiled from: ObservableDistinctUntilChanged.java */
    /* loaded from: classes3.dex */
    static final class a<T, K> extends io.reactivex.internal.observers.a<T, T> {

        /* renamed from: f  reason: collision with root package name */
        final o<? super T, K> f28775f;

        /* renamed from: g  reason: collision with root package name */
        final d<? super K, ? super K> f28776g;

        /* renamed from: h  reason: collision with root package name */
        K f28777h;

        /* renamed from: i  reason: collision with root package name */
        boolean f28778i;

        a(r<? super T> rVar, o<? super T, K> oVar, d<? super K, ? super K> dVar) {
            super(rVar);
            this.f28775f = oVar;
            this.f28776g = dVar;
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28356d) {
                if (this.f28357e != 0) {
                    this.f28353a.onNext(t10);
                    return;
                }
                try {
                    K apply = this.f28775f.apply(t10);
                    if (this.f28778i) {
                        boolean test = this.f28776g.test((K) this.f28777h, apply);
                        this.f28777h = apply;
                        if (test) {
                            return;
                        }
                    } else {
                        this.f28778i = true;
                        this.f28777h = apply;
                    }
                    this.f28353a.onNext(t10);
                } catch (Throwable th2) {
                    c(th2);
                }
            }
        }

        @Override // co.g
        public T poll() throws Exception {
            while (true) {
                T poll = this.f28355c.poll();
                if (poll == null) {
                    return null;
                }
                K apply = this.f28775f.apply(poll);
                if (!this.f28778i) {
                    this.f28778i = true;
                    this.f28777h = apply;
                    return poll;
                } else if (!this.f28776g.test((K) this.f28777h, apply)) {
                    this.f28777h = apply;
                    return poll;
                } else {
                    this.f28777h = apply;
                }
            }
        }

        @Override // co.c
        public int requestFusion(int i10) {
            return d(i10);
        }
    }

    public k0(p<T> pVar, o<? super T, K> oVar, d<? super K, ? super K> dVar) {
        super(pVar);
        this.f28773b = oVar;
        this.f28774c = dVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28773b, this.f28774c));
    }
}
