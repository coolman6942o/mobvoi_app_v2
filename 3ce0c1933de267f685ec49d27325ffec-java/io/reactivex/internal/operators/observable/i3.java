package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableSwitchIfEmpty.java */
/* loaded from: classes3.dex */
public final class i3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final p<? extends T> f28728b;

    /* compiled from: ObservableSwitchIfEmpty.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T> {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28729a;

        /* renamed from: b  reason: collision with root package name */
        final p<? extends T> f28730b;

        /* renamed from: d  reason: collision with root package name */
        boolean f28732d = true;

        /* renamed from: c  reason: collision with root package name */
        final SequentialDisposable f28731c = new SequentialDisposable();

        a(r<? super T> rVar, p<? extends T> pVar) {
            this.f28729a = rVar;
            this.f28730b = pVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (this.f28732d) {
                this.f28732d = false;
                this.f28730b.subscribe(this);
                return;
            }
            this.f28729a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28729a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.f28732d) {
                this.f28732d = false;
            }
            this.f28729a.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            this.f28731c.update(bVar);
        }
    }

    public i3(p<T> pVar, p<? extends T> pVar2) {
        super(pVar);
        this.f28728b = pVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        a aVar = new a(rVar, this.f28728b);
        rVar.onSubscribe(aVar.f28731c);
        this.f28426a.subscribe(aVar);
    }
}
