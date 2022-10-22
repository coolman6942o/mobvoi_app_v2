package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.t;
import io.reactivex.u;
import java.util.NoSuchElementException;
import xn.b;
/* compiled from: ObservableSingleSingle.java */
/* loaded from: classes3.dex */
public final class b3<T> extends t<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<? extends T> f28457a;

    /* renamed from: b  reason: collision with root package name */
    final T f28458b;

    /* compiled from: ObservableSingleSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f28459a;

        /* renamed from: b  reason: collision with root package name */
        final T f28460b;

        /* renamed from: c  reason: collision with root package name */
        b f28461c;

        /* renamed from: d  reason: collision with root package name */
        T f28462d;

        /* renamed from: e  reason: collision with root package name */
        boolean f28463e;

        a(u<? super T> uVar, T t10) {
            this.f28459a = uVar;
            this.f28460b = t10;
        }

        @Override // xn.b
        public void dispose() {
            this.f28461c.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28461c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28463e) {
                this.f28463e = true;
                T t10 = this.f28462d;
                this.f28462d = null;
                if (t10 == null) {
                    t10 = this.f28460b;
                }
                if (t10 != null) {
                    this.f28459a.onSuccess(t10);
                } else {
                    this.f28459a.onError(new NoSuchElementException());
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28463e) {
                fo.a.s(th2);
                return;
            }
            this.f28463e = true;
            this.f28459a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28463e) {
                if (this.f28462d != null) {
                    this.f28463e = true;
                    this.f28461c.dispose();
                    this.f28459a.onError(new IllegalArgumentException("Sequence contains more than one element!"));
                    return;
                }
                this.f28462d = t10;
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28461c, bVar)) {
                this.f28461c = bVar;
                this.f28459a.onSubscribe(this);
            }
        }
    }

    public b3(p<? extends T> pVar, T t10) {
        this.f28457a = pVar;
        this.f28458b = t10;
    }

    @Override // io.reactivex.t
    public void e(u<? super T> uVar) {
        this.f28457a.subscribe(new a(uVar, this.f28458b));
    }
}
