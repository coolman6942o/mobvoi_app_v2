package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.Callable;
import zn.b;
/* compiled from: ObservableCollectSingle.java */
/* loaded from: classes3.dex */
public final class s<T, U> extends t<U> implements co.a<U> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f29019a;

    /* renamed from: b  reason: collision with root package name */
    final Callable<? extends U> f29020b;

    /* renamed from: c  reason: collision with root package name */
    final b<? super U, ? super T> f29021c;

    /* compiled from: ObservableCollectSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, U> implements r<T>, xn.b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super U> f29022a;

        /* renamed from: b  reason: collision with root package name */
        final b<? super U, ? super T> f29023b;

        /* renamed from: c  reason: collision with root package name */
        final U f29024c;

        /* renamed from: d  reason: collision with root package name */
        xn.b f29025d;

        /* renamed from: e  reason: collision with root package name */
        boolean f29026e;

        a(u<? super U> uVar, U u10, b<? super U, ? super T> bVar) {
            this.f29022a = uVar;
            this.f29023b = bVar;
            this.f29024c = u10;
        }

        @Override // xn.b
        public void dispose() {
            this.f29025d.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29025d.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f29026e) {
                this.f29026e = true;
                this.f29022a.onSuccess((U) this.f29024c);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f29026e) {
                fo.a.s(th2);
                return;
            }
            this.f29026e = true;
            this.f29022a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f29026e) {
                try {
                    this.f29023b.accept((U) this.f29024c, t10);
                } catch (Throwable th2) {
                    this.f29025d.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f29025d, bVar)) {
                this.f29025d = bVar;
                this.f29022a.onSubscribe(this);
            }
        }
    }

    public s(p<T> pVar, Callable<? extends U> callable, b<? super U, ? super T> bVar) {
        this.f29019a = pVar;
        this.f29020b = callable;
        this.f29021c = bVar;
    }

    @Override // co.a
    public k<U> a() {
        return fo.a.o(new r(this.f29019a, this.f29020b, this.f29021c));
    }

    @Override // io.reactivex.t
    protected void e(u<? super U> uVar) {
        try {
            this.f29019a.subscribe(new a(uVar, bo.b.e(this.f29020b.call(), "The initialSupplier returned a null value"), this.f29021c));
        } catch (Throwable th2) {
            EmptyDisposable.error(th2, uVar);
        }
    }
}
