package io.reactivex.internal.operators.observable;

import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import xn.b;
/* compiled from: ObservableSingleMaybe.java */
/* loaded from: classes3.dex */
public final class a3<T> extends g<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28436a;

    /* compiled from: ObservableSingleMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final h<? super T> f28437a;

        /* renamed from: b  reason: collision with root package name */
        b f28438b;

        /* renamed from: c  reason: collision with root package name */
        T f28439c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28440d;

        a(h<? super T> hVar) {
            this.f28437a = hVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f28438b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28438b.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28440d) {
                this.f28440d = true;
                T t10 = this.f28439c;
                this.f28439c = null;
                if (t10 == null) {
                    this.f28437a.onComplete();
                } else {
                    this.f28437a.onSuccess(t10);
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28440d) {
                fo.a.s(th2);
                return;
            }
            this.f28440d = true;
            this.f28437a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28440d) {
                if (this.f28439c != null) {
                    this.f28440d = true;
                    this.f28438b.dispose();
                    this.f28437a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f28439c = t10;
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28438b, bVar)) {
                this.f28438b = bVar;
                this.f28437a.onSubscribe(this);
            }
        }
    }

    public a3(p<T> pVar) {
        this.f28436a = pVar;
    }

    @Override // io.reactivex.g
    public void d(h<? super T> hVar) {
        this.f28436a.subscribe(new a(hVar));
    }
}
