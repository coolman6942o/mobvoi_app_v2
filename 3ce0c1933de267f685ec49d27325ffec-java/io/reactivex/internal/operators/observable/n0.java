package io.reactivex.internal.operators.observable;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
import zn.g;
/* compiled from: ObservableDoOnEach.java */
/* loaded from: classes3.dex */
public final class n0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final g<? super T> f28855b;

    /* renamed from: c  reason: collision with root package name */
    final g<? super Throwable> f28856c;

    /* renamed from: d  reason: collision with root package name */
    final zn.a f28857d;

    /* renamed from: e  reason: collision with root package name */
    final zn.a f28858e;

    /* compiled from: ObservableDoOnEach.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28859a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super T> f28860b;

        /* renamed from: c  reason: collision with root package name */
        final g<? super Throwable> f28861c;

        /* renamed from: d  reason: collision with root package name */
        final zn.a f28862d;

        /* renamed from: e  reason: collision with root package name */
        final zn.a f28863e;

        /* renamed from: f  reason: collision with root package name */
        b f28864f;

        /* renamed from: g  reason: collision with root package name */
        boolean f28865g;

        a(r<? super T> rVar, g<? super T> gVar, g<? super Throwable> gVar2, zn.a aVar, zn.a aVar2) {
            this.f28859a = rVar;
            this.f28860b = gVar;
            this.f28861c = gVar2;
            this.f28862d = aVar;
            this.f28863e = aVar2;
        }

        @Override // xn.b
        public void dispose() {
            this.f28864f.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28864f.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28865g) {
                try {
                    this.f28862d.run();
                    this.f28865g = true;
                    this.f28859a.onComplete();
                    try {
                        this.f28863e.run();
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        fo.a.s(th2);
                    }
                } catch (Throwable th3) {
                    io.reactivex.exceptions.a.b(th3);
                    onError(th3);
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28865g) {
                fo.a.s(th2);
                return;
            }
            this.f28865g = true;
            try {
                this.f28861c.accept(th2);
            } catch (Throwable th3) {
                io.reactivex.exceptions.a.b(th3);
                th2 = new CompositeException(th2, th3);
            }
            this.f28859a.onError(th2);
            try {
                this.f28863e.run();
            } catch (Throwable th4) {
                io.reactivex.exceptions.a.b(th4);
                fo.a.s(th4);
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28865g) {
                try {
                    this.f28860b.accept(t10);
                    this.f28859a.onNext(t10);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28864f.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28864f, bVar)) {
                this.f28864f = bVar;
                this.f28859a.onSubscribe(this);
            }
        }
    }

    public n0(p<T> pVar, g<? super T> gVar, g<? super Throwable> gVar2, zn.a aVar, zn.a aVar2) {
        super(pVar);
        this.f28855b = gVar;
        this.f28856c = gVar2;
        this.f28857d = aVar;
        this.f28858e = aVar2;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28855b, this.f28856c, this.f28857d, this.f28858e));
    }
}
