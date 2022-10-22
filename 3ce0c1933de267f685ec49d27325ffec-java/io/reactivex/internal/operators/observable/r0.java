package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.t;
import io.reactivex.u;
import java.util.NoSuchElementException;
import xn.b;
/* compiled from: ObservableElementAtSingle.java */
/* loaded from: classes3.dex */
public final class r0<T> extends t<T> implements co.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f29001a;

    /* renamed from: b  reason: collision with root package name */
    final long f29002b;

    /* renamed from: c  reason: collision with root package name */
    final T f29003c;

    /* compiled from: ObservableElementAtSingle.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final u<? super T> f29004a;

        /* renamed from: b  reason: collision with root package name */
        final long f29005b;

        /* renamed from: c  reason: collision with root package name */
        final T f29006c;

        /* renamed from: d  reason: collision with root package name */
        b f29007d;

        /* renamed from: e  reason: collision with root package name */
        long f29008e;

        /* renamed from: f  reason: collision with root package name */
        boolean f29009f;

        a(u<? super T> uVar, long j10, T t10) {
            this.f29004a = uVar;
            this.f29005b = j10;
            this.f29006c = t10;
        }

        @Override // xn.b
        public void dispose() {
            this.f29007d.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29007d.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f29009f) {
                this.f29009f = true;
                T t10 = this.f29006c;
                if (t10 != null) {
                    this.f29004a.onSuccess(t10);
                } else {
                    this.f29004a.onError(new NoSuchElementException());
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f29009f) {
                fo.a.s(th2);
                return;
            }
            this.f29009f = true;
            this.f29004a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f29009f) {
                long j10 = this.f29008e;
                if (j10 == this.f29005b) {
                    this.f29009f = true;
                    this.f29007d.dispose();
                    this.f29004a.onSuccess(t10);
                    return;
                }
                this.f29008e = j10 + 1;
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f29007d, bVar)) {
                this.f29007d = bVar;
                this.f29004a.onSubscribe(this);
            }
        }
    }

    public r0(p<T> pVar, long j10, T t10) {
        this.f29001a = pVar;
        this.f29002b = j10;
        this.f29003c = t10;
    }

    @Override // co.a
    public k<T> a() {
        return fo.a.o(new p0(this.f29001a, this.f29002b, this.f29003c, true));
    }

    @Override // io.reactivex.t
    public void e(u<? super T> uVar) {
        this.f29001a.subscribe(new a(uVar, this.f29002b, this.f29003c));
    }
}
