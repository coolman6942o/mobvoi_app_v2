package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableTake.java */
/* loaded from: classes3.dex */
public final class k3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f28784b;

    /* compiled from: ObservableTake.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28785a;

        /* renamed from: b  reason: collision with root package name */
        boolean f28786b;

        /* renamed from: c  reason: collision with root package name */
        b f28787c;

        /* renamed from: d  reason: collision with root package name */
        long f28788d;

        a(r<? super T> rVar, long j10) {
            this.f28785a = rVar;
            this.f28788d = j10;
        }

        @Override // xn.b
        public void dispose() {
            this.f28787c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28787c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28786b) {
                this.f28786b = true;
                this.f28787c.dispose();
                this.f28785a.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28786b) {
                fo.a.s(th2);
                return;
            }
            this.f28786b = true;
            this.f28787c.dispose();
            this.f28785a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28786b) {
                long j10 = this.f28788d;
                long j11 = j10 - 1;
                this.f28788d = j11;
                if (j10 > 0) {
                    boolean z10 = j11 == 0;
                    this.f28785a.onNext(t10);
                    if (z10) {
                        onComplete();
                    }
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28787c, bVar)) {
                this.f28787c = bVar;
                if (this.f28788d == 0) {
                    this.f28786b = true;
                    bVar.dispose();
                    EmptyDisposable.complete(this.f28785a);
                    return;
                }
                this.f28785a.onSubscribe(this);
            }
        }
    }

    public k3(p<T> pVar, long j10) {
        super(pVar);
        this.f28784b = j10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28784b));
    }
}
