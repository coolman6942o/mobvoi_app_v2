package io.reactivex.internal.operators.observable;

import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
import zn.c;
/* compiled from: ObservableReduceMaybe.java */
/* loaded from: classes3.dex */
public final class i2<T> extends g<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28721a;

    /* renamed from: b  reason: collision with root package name */
    final c<T, T, T> f28722b;

    /* compiled from: ObservableReduceMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f28723a;

        /* renamed from: b  reason: collision with root package name */
        final c<T, T, T> f28724b;

        /* renamed from: c  reason: collision with root package name */
        boolean f28725c;

        /* renamed from: d  reason: collision with root package name */
        T f28726d;

        /* renamed from: e  reason: collision with root package name */
        b f28727e;

        a(h<? super T> hVar, c<T, T, T> cVar) {
            this.f28723a = hVar;
            this.f28724b = cVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28727e.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28727e.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28725c) {
                this.f28725c = true;
                T t10 = this.f28726d;
                this.f28726d = null;
                if (t10 != null) {
                    this.f28723a.onSuccess(t10);
                } else {
                    this.f28723a.onComplete();
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28725c) {
                fo.a.s(th2);
                return;
            }
            this.f28725c = true;
            this.f28726d = null;
            this.f28723a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28725c) {
                T t11 = this.f28726d;
                if (t11 == null) {
                    this.f28726d = t10;
                    return;
                }
                try {
                    this.f28726d = (T) bo.b.e(this.f28724b.apply(t11, t10), "The reducer returned a null value");
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28727e.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28727e, bVar)) {
                this.f28727e = bVar;
                this.f28723a.onSubscribe(this);
            }
        }
    }

    public i2(p<T> pVar, c<T, T, T> cVar) {
        this.f28721a = pVar;
        this.f28722b = cVar;
    }

    @Override // io.reactivex.g
    protected void d(h<? super T> hVar) {
        this.f28721a.subscribe(new a(hVar, this.f28722b));
    }
}
