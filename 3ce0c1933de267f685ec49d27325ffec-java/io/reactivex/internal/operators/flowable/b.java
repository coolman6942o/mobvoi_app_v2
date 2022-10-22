package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.k;
import io.reactivex.r;
import vp.c;
/* compiled from: FlowableFromObservable.java */
/* loaded from: classes2.dex */
public final class b<T> extends e<T> {

    /* renamed from: b  reason: collision with root package name */
    private final k<T> f28380b;

    /* compiled from: FlowableFromObservable.java */
    /* loaded from: classes2.dex */
    static final class a<T> implements r<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final vp.b<? super T> f28381a;

        /* renamed from: b  reason: collision with root package name */
        xn.b f28382b;

        a(vp.b<? super T> bVar) {
            this.f28381a = bVar;
        }

        @Override // vp.c
        public void cancel() {
            this.f28382b.dispose();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28381a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28381a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28381a.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            this.f28382b = bVar;
            this.f28381a.onSubscribe(this);
        }

        @Override // vp.c
        public void request(long j10) {
        }
    }

    public b(k<T> kVar) {
        this.f28380b = kVar;
    }

    @Override // io.reactivex.e
    protected void h(vp.b<? super T> bVar) {
        this.f28380b.subscribe(new a(bVar));
    }
}
