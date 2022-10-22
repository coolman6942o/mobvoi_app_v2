package io.reactivex.internal.operators.observable;

import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableElementAtMaybe.java */
/* loaded from: classes3.dex */
public final class q0<T> extends g<T> implements co.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28980a;

    /* renamed from: b  reason: collision with root package name */
    final long f28981b;

    /* compiled from: ObservableElementAtMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f28982a;

        /* renamed from: b  reason: collision with root package name */
        final long f28983b;

        /* renamed from: c  reason: collision with root package name */
        b f28984c;

        /* renamed from: d  reason: collision with root package name */
        long f28985d;

        /* renamed from: e  reason: collision with root package name */
        boolean f28986e;

        a(h<? super T> hVar, long j10) {
            this.f28982a = hVar;
            this.f28983b = j10;
        }

        @Override // xn.b
        public void dispose() {
            this.f28984c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28984c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28986e) {
                this.f28986e = true;
                this.f28982a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28986e) {
                fo.a.s(th2);
                return;
            }
            this.f28986e = true;
            this.f28982a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28986e) {
                long j10 = this.f28985d;
                if (j10 == this.f28983b) {
                    this.f28986e = true;
                    this.f28984c.dispose();
                    this.f28982a.onSuccess(t10);
                    return;
                }
                this.f28985d = j10 + 1;
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28984c, bVar)) {
                this.f28984c = bVar;
                this.f28982a.onSubscribe(this);
            }
        }
    }

    public q0(p<T> pVar, long j10) {
        this.f28980a = pVar;
        this.f28981b = j10;
    }

    @Override // co.a
    public k<T> a() {
        return fo.a.o(new p0(this.f28980a, this.f28981b, null, false));
    }

    @Override // io.reactivex.g
    public void d(h<? super T> hVar) {
        this.f28980a.subscribe(new a(hVar, this.f28981b));
    }
}
