package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.t;
import io.reactivex.u;
import xn.b;
import zn.c;
/* compiled from: ObservableReduceSeedSingle.java */
/* loaded from: classes3.dex */
public final class j2<T, R> extends t<R> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28755a;

    /* renamed from: b  reason: collision with root package name */
    final R f28756b;

    /* renamed from: c  reason: collision with root package name */
    final c<R, ? super T, R> f28757c;

    /* compiled from: ObservableReduceSeedSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super R> f28758a;

        /* renamed from: b  reason: collision with root package name */
        final c<R, ? super T, R> f28759b;

        /* renamed from: c  reason: collision with root package name */
        R f28760c;

        /* renamed from: d  reason: collision with root package name */
        b f28761d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(u<? super R> uVar, c<R, ? super T, R> cVar, R r10) {
            this.f28758a = uVar;
            this.f28760c = r10;
            this.f28759b = cVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28761d.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28761d.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            R r10 = this.f28760c;
            if (r10 != null) {
                this.f28760c = null;
                this.f28758a.onSuccess(r10);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28760c != null) {
                this.f28760c = null;
                this.f28758a.onError(th2);
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            R r10 = this.f28760c;
            if (r10 != null) {
                try {
                    this.f28760c = (R) bo.b.e(this.f28759b.apply(r10, t10), "The reducer returned a null value");
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28761d.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28761d, bVar)) {
                this.f28761d = bVar;
                this.f28758a.onSubscribe(this);
            }
        }
    }

    public j2(p<T> pVar, R r10, c<R, ? super T, R> cVar) {
        this.f28755a = pVar;
        this.f28756b = r10;
        this.f28757c = cVar;
    }

    @Override // io.reactivex.t
    protected void e(u<? super R> uVar) {
        this.f28755a.subscribe(new a(uVar, this.f28757c, this.f28756b));
    }
}
