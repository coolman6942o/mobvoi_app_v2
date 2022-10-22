package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableDelaySubscriptionOther.java */
/* loaded from: classes3.dex */
public final class g0<T, U> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<? extends T> f28664a;

    /* renamed from: b  reason: collision with root package name */
    final p<U> f28665b;

    /* compiled from: ObservableDelaySubscriptionOther.java */
    /* loaded from: classes3.dex */
    final class a implements r<U> {

        /* renamed from: a  reason: collision with root package name */
        final SequentialDisposable f28666a;

        /* renamed from: b  reason: collision with root package name */
        final r<? super T> f28667b;

        /* renamed from: c  reason: collision with root package name */
        boolean f28668c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableDelaySubscriptionOther.java */
        /* renamed from: io.reactivex.internal.operators.observable.g0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0331a implements r<T> {
            C0331a() {
            }

            @Override // io.reactivex.r
            public void onComplete() {
                a.this.f28667b.onComplete();
            }

            @Override // io.reactivex.r
            public void onError(Throwable th2) {
                a.this.f28667b.onError(th2);
            }

            @Override // io.reactivex.r
            public void onNext(T t10) {
                a.this.f28667b.onNext(t10);
            }

            @Override // io.reactivex.r
            public void onSubscribe(b bVar) {
                a.this.f28666a.update(bVar);
            }
        }

        a(SequentialDisposable sequentialDisposable, r<? super T> rVar) {
            this.f28666a = sequentialDisposable;
            this.f28667b = rVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28668c) {
                this.f28668c = true;
                g0.this.f28664a.subscribe(new C0331a());
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28668c) {
                fo.a.s(th2);
                return;
            }
            this.f28668c = true;
            this.f28667b.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(U u10) {
            onComplete();
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            this.f28666a.update(bVar);
        }
    }

    public g0(p<? extends T> pVar, p<U> pVar2) {
        this.f28664a = pVar;
        this.f28665b = pVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        rVar.onSubscribe(sequentialDisposable);
        this.f28665b.subscribe(new a(sequentialDisposable, rVar));
    }
}
