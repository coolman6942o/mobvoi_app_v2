package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.t;
import io.reactivex.u;
import xn.b;
/* compiled from: ObservableAllSingle.java */
/* loaded from: classes3.dex */
public final class g<T> extends t<Boolean> implements co.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28658a;

    /* renamed from: b  reason: collision with root package name */
    final zn.p<? super T> f28659b;

    /* compiled from: ObservableAllSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super Boolean> f28660a;

        /* renamed from: b  reason: collision with root package name */
        final zn.p<? super T> f28661b;

        /* renamed from: c  reason: collision with root package name */
        b f28662c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28663d;

        a(u<? super Boolean> uVar, zn.p<? super T> pVar) {
            this.f28660a = uVar;
            this.f28661b = pVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28662c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28662c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28663d) {
                this.f28663d = true;
                this.f28660a.onSuccess(Boolean.TRUE);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28663d) {
                fo.a.s(th2);
                return;
            }
            this.f28663d = true;
            this.f28660a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28663d) {
                try {
                    if (!this.f28661b.test(t10)) {
                        this.f28663d = true;
                        this.f28662c.dispose();
                        this.f28660a.onSuccess(Boolean.FALSE);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28662c.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28662c, bVar)) {
                this.f28662c = bVar;
                this.f28660a.onSubscribe(this);
            }
        }
    }

    public g(p<T> pVar, zn.p<? super T> pVar2) {
        this.f28658a = pVar;
        this.f28659b = pVar2;
    }

    @Override // co.a
    public k<Boolean> a() {
        return fo.a.o(new f(this.f28658a, this.f28659b));
    }

    @Override // io.reactivex.t
    protected void e(u<? super Boolean> uVar) {
        this.f28658a.subscribe(new a(uVar, this.f28659b));
    }
}
