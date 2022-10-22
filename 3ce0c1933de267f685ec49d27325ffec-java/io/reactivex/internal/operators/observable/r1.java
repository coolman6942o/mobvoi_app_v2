package io.reactivex.internal.operators.observable;

import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableLastMaybe.java */
/* loaded from: classes3.dex */
public final class r1<T> extends g<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f29010a;

    /* compiled from: ObservableLastMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f29011a;

        /* renamed from: b  reason: collision with root package name */
        b f29012b;

        /* renamed from: c  reason: collision with root package name */
        T f29013c;

        a(h<? super T> hVar) {
            this.f29011a = hVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f29012b.dispose();
            this.f29012b = DisposableHelper.DISPOSED;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29012b == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f29012b = DisposableHelper.DISPOSED;
            T t10 = this.f29013c;
            if (t10 != null) {
                this.f29013c = null;
                this.f29011a.onSuccess(t10);
                return;
            }
            this.f29011a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29012b = DisposableHelper.DISPOSED;
            this.f29013c = null;
            this.f29011a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f29013c = t10;
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29012b, bVar)) {
                this.f29012b = bVar;
                this.f29011a.onSubscribe(this);
            }
        }
    }

    public r1(p<T> pVar) {
        this.f29010a = pVar;
    }

    @Override // io.reactivex.g
    protected void d(h<? super T> hVar) {
        this.f29010a.subscribe(new a(hVar));
    }
}
