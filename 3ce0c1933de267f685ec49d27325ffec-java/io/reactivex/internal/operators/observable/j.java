package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.t;
import io.reactivex.u;
import xn.b;
/* compiled from: ObservableAnySingle.java */
/* loaded from: classes3.dex */
public final class j<T> extends t<Boolean> implements co.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28743a;

    /* renamed from: b  reason: collision with root package name */
    final zn.p<? super T> f28744b;

    /* compiled from: ObservableAnySingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super Boolean> f28745a;

        /* renamed from: b  reason: collision with root package name */
        final zn.p<? super T> f28746b;

        /* renamed from: c  reason: collision with root package name */
        b f28747c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28748d;

        a(u<? super Boolean> uVar, zn.p<? super T> pVar) {
            this.f28745a = uVar;
            this.f28746b = pVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28747c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28747c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28748d) {
                this.f28748d = true;
                this.f28745a.onSuccess(Boolean.FALSE);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28748d) {
                fo.a.s(th2);
                return;
            }
            this.f28748d = true;
            this.f28745a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28748d) {
                try {
                    if (this.f28746b.test(t10)) {
                        this.f28748d = true;
                        this.f28747c.dispose();
                        this.f28745a.onSuccess(Boolean.TRUE);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28747c.dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28747c, bVar)) {
                this.f28747c = bVar;
                this.f28745a.onSubscribe(this);
            }
        }
    }

    public j(p<T> pVar, zn.p<? super T> pVar2) {
        this.f28743a = pVar;
        this.f28744b = pVar2;
    }

    @Override // co.a
    public k<Boolean> a() {
        return fo.a.o(new i(this.f28743a, this.f28744b));
    }

    @Override // io.reactivex.t
    protected void e(u<? super Boolean> uVar) {
        this.f28743a.subscribe(new a(uVar, this.f28744b));
    }
}
