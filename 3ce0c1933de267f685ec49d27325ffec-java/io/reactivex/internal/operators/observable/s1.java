package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.t;
import io.reactivex.u;
import java.util.NoSuchElementException;
import xn.b;
/* compiled from: ObservableLastSingle.java */
/* loaded from: classes3.dex */
public final class s1<T> extends t<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f29028a;

    /* renamed from: b  reason: collision with root package name */
    final T f29029b;

    /* compiled from: ObservableLastSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f29030a;

        /* renamed from: b  reason: collision with root package name */
        final T f29031b;

        /* renamed from: c  reason: collision with root package name */
        b f29032c;

        /* renamed from: d  reason: collision with root package name */
        T f29033d;

        a(u<? super T> uVar, T t10) {
            this.f29030a = uVar;
            this.f29031b = t10;
        }

        @Override // xn.b
        public void dispose() {
            this.f29032c.dispose();
            this.f29032c = DisposableHelper.DISPOSED;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29032c == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f29032c = DisposableHelper.DISPOSED;
            T t10 = this.f29033d;
            if (t10 != null) {
                this.f29033d = null;
                this.f29030a.onSuccess(t10);
                return;
            }
            T t11 = this.f29031b;
            if (t11 != null) {
                this.f29030a.onSuccess(t11);
            } else {
                this.f29030a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29032c = DisposableHelper.DISPOSED;
            this.f29033d = null;
            this.f29030a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f29033d = t10;
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29032c, bVar)) {
                this.f29032c = bVar;
                this.f29030a.onSubscribe(this);
            }
        }
    }

    public s1(p<T> pVar, T t10) {
        this.f29028a = pVar;
        this.f29029b = t10;
    }

    @Override // io.reactivex.t
    protected void e(u<? super T> uVar) {
        this.f29028a.subscribe(new a(uVar, this.f29029b));
    }
}
