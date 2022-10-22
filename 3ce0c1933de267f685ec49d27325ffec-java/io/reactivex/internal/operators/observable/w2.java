package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.Callable;
import xn.b;
import zn.c;
/* compiled from: ObservableScanSeed.java */
/* loaded from: classes3.dex */
public final class w2<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final c<R, ? super T, R> f29106b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<R> f29107c;

    /* compiled from: ObservableScanSeed.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super R> f29108a;

        /* renamed from: b  reason: collision with root package name */
        final c<R, ? super T, R> f29109b;

        /* renamed from: c  reason: collision with root package name */
        R f29110c;

        /* renamed from: d  reason: collision with root package name */
        b f29111d;

        /* renamed from: e  reason: collision with root package name */
        boolean f29112e;

        a(r<? super R> rVar, c<R, ? super T, R> cVar, R r10) {
            this.f29108a = rVar;
            this.f29109b = cVar;
            this.f29110c = r10;
        }

        @Override // xn.b
        public void dispose() {
            this.f29111d.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29111d.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f29112e) {
                this.f29112e = true;
                this.f29108a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f29112e) {
                fo.a.s(th2);
                return;
            }
            this.f29112e = true;
            this.f29108a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f29112e) {
                try {
                    R r10 = (R) bo.b.e(this.f29109b.apply(this.f29110c, t10), "The accumulator returned a null value");
                    this.f29110c = r10;
                    this.f29108a.onNext(r10);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f29111d.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29111d, bVar)) {
                this.f29111d = bVar;
                this.f29108a.onSubscribe(this);
                this.f29108a.onNext((R) this.f29110c);
            }
        }
    }

    public w2(p<T> pVar, Callable<R> callable, c<R, ? super T, R> cVar) {
        super(pVar);
        this.f29106b = cVar;
        this.f29107c = callable;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super R> rVar) {
        try {
            this.f28426a.subscribe(new a(rVar, this.f29106b, bo.b.e(this.f29107c.call(), "The seed supplied is null")));
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, rVar);
        }
    }
}
