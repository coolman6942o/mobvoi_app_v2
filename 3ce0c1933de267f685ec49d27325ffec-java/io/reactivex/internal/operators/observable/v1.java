package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.Callable;
import xn.b;
import zn.o;
/* compiled from: ObservableMapNotification.java */
/* loaded from: classes3.dex */
public final class v1<T, R> extends io.reactivex.internal.operators.observable.a<T, p<? extends R>> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends p<? extends R>> f29079b;

    /* renamed from: c  reason: collision with root package name */
    final o<? super Throwable, ? extends p<? extends R>> f29080c;

    /* renamed from: d  reason: collision with root package name */
    final Callable<? extends p<? extends R>> f29081d;

    /* compiled from: ObservableMapNotification.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super p<? extends R>> f29082a;

        /* renamed from: b  reason: collision with root package name */
        final o<? super T, ? extends p<? extends R>> f29083b;

        /* renamed from: c  reason: collision with root package name */
        final o<? super Throwable, ? extends p<? extends R>> f29084c;

        /* renamed from: d  reason: collision with root package name */
        final Callable<? extends p<? extends R>> f29085d;

        /* renamed from: e  reason: collision with root package name */
        b f29086e;

        a(r<? super p<? extends R>> rVar, o<? super T, ? extends p<? extends R>> oVar, o<? super Throwable, ? extends p<? extends R>> oVar2, Callable<? extends p<? extends R>> callable) {
            this.f29082a = rVar;
            this.f29083b = oVar;
            this.f29084c = oVar2;
            this.f29085d = callable;
        }

        @Override // xn.b
        public void dispose() {
            this.f29086e.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29086e.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            try {
                this.f29082a.onNext((p) bo.b.e(this.f29085d.call(), "The onComplete ObservableSource returned is null"));
                this.f29082a.onComplete();
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f29082a.onError(th2);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            try {
                this.f29082a.onNext((p) bo.b.e(this.f29084c.apply(th2), "The onError ObservableSource returned is null"));
                this.f29082a.onComplete();
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                this.f29082a.onError(new CompositeException(th2, th3));
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            try {
                this.f29082a.onNext((p) bo.b.e(this.f29083b.apply(t10), "The onNext ObservableSource returned is null"));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f29082a.onError(th2);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29086e, bVar)) {
                this.f29086e = bVar;
                this.f29082a.onSubscribe(this);
            }
        }
    }

    public v1(p<T> pVar, o<? super T, ? extends p<? extends R>> oVar, o<? super Throwable, ? extends p<? extends R>> oVar2, Callable<? extends p<? extends R>> callable) {
        super(pVar);
        this.f29079b = oVar;
        this.f29080c = oVar2;
        this.f29081d = callable;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super p<? extends R>> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29079b, this.f29080c, this.f29081d));
    }
}
