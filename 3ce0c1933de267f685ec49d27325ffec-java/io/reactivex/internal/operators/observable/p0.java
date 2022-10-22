package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import java.util.NoSuchElementException;
import xn.b;
/* compiled from: ObservableElementAt.java */
/* loaded from: classes3.dex */
public final class p0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f28931b;

    /* renamed from: c  reason: collision with root package name */
    final T f28932c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f28933d;

    /* compiled from: ObservableElementAt.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28934a;

        /* renamed from: b  reason: collision with root package name */
        final long f28935b;

        /* renamed from: c  reason: collision with root package name */
        final T f28936c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f28937d;

        /* renamed from: e  reason: collision with root package name */
        b f28938e;

        /* renamed from: f  reason: collision with root package name */
        long f28939f;

        /* renamed from: g  reason: collision with root package name */
        boolean f28940g;

        a(r<? super T> rVar, long j10, T t10, boolean z10) {
            this.f28934a = rVar;
            this.f28935b = j10;
            this.f28936c = t10;
            this.f28937d = z10;
        }

        @Override // xn.b
        public void dispose() {
            this.f28938e.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28938e.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28940g) {
                this.f28940g = true;
                T t10 = this.f28936c;
                if (t10 != null || !this.f28937d) {
                    if (t10 != null) {
                        this.f28934a.onNext(t10);
                    }
                    this.f28934a.onComplete();
                    return;
                }
                this.f28934a.onError(new NoSuchElementException());
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28940g) {
                fo.a.s(th2);
                return;
            }
            this.f28940g = true;
            this.f28934a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28940g) {
                long j10 = this.f28939f;
                if (j10 == this.f28935b) {
                    this.f28940g = true;
                    this.f28938e.dispose();
                    this.f28934a.onNext(t10);
                    this.f28934a.onComplete();
                    return;
                }
                this.f28939f = j10 + 1;
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28938e, bVar)) {
                this.f28938e = bVar;
                this.f28934a.onSubscribe(this);
            }
        }
    }

    public p0(p<T> pVar, long j10, T t10, boolean z10) {
        super(pVar);
        this.f28931b = j10;
        this.f28932c = t10;
        this.f28933d = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28931b, this.f28932c, this.f28933d));
    }
}
