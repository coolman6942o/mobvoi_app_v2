package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
import zn.c;
/* compiled from: ObservableScan.java */
/* loaded from: classes3.dex */
public final class v2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final c<T, T, T> f29087b;

    /* compiled from: ObservableScan.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f29088a;

        /* renamed from: b  reason: collision with root package name */
        final c<T, T, T> f29089b;

        /* renamed from: c  reason: collision with root package name */
        b f29090c;

        /* renamed from: d  reason: collision with root package name */
        T f29091d;

        /* renamed from: e  reason: collision with root package name */
        boolean f29092e;

        a(r<? super T> rVar, c<T, T, T> cVar) {
            this.f29088a = rVar;
            this.f29089b = cVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f29090c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29090c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f29092e) {
                this.f29092e = true;
                this.f29088a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f29092e) {
                fo.a.s(th2);
                return;
            }
            this.f29092e = true;
            this.f29088a.onError(th2);
        }

        /* JADX WARN: Type inference failed for: r4v3, types: [T, java.lang.Object] */
        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f29092e) {
                r<? super T> rVar = this.f29088a;
                T t11 = this.f29091d;
                if (t11 == null) {
                    this.f29091d = t10;
                    rVar.onNext(t10);
                    return;
                }
                try {
                    ?? r42 = (T) bo.b.e(this.f29089b.apply(t11, t10), "The value returned by the accumulator is null");
                    this.f29091d = r42;
                    rVar.onNext(r42);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f29090c.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29090c, bVar)) {
                this.f29090c = bVar;
                this.f29088a.onSubscribe(this);
            }
        }
    }

    public v2(p<T> pVar, c<T, T, T> cVar) {
        super(pVar);
        this.f29087b = cVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29087b));
    }
}
