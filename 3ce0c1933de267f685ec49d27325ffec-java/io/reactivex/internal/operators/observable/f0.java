package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
/* compiled from: ObservableDelay.java */
/* loaded from: classes3.dex */
public final class f0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f28584b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f28585c;

    /* renamed from: d  reason: collision with root package name */
    final s f28586d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f28587e;

    /* compiled from: ObservableDelay.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T>, xn.b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28588a;

        /* renamed from: b  reason: collision with root package name */
        final long f28589b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f28590c;

        /* renamed from: d  reason: collision with root package name */
        final s.c f28591d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f28592e;

        /* renamed from: f  reason: collision with root package name */
        xn.b f28593f;

        /* compiled from: ObservableDelay.java */
        /* renamed from: io.reactivex.internal.operators.observable.f0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class RunnableC0329a implements Runnable {
            RunnableC0329a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f28588a.onComplete();
                } finally {
                    a.this.f28591d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* loaded from: classes3.dex */
        final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f28595a;

            b(Throwable th2) {
                this.f28595a = th2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    a.this.f28588a.onError(this.f28595a);
                } finally {
                    a.this.f28591d.dispose();
                }
            }
        }

        /* compiled from: ObservableDelay.java */
        /* loaded from: classes3.dex */
        final class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final T f28597a;

            c(T t10) {
                this.f28597a = t10;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f28588a.onNext((T) this.f28597a);
            }
        }

        a(r<? super T> rVar, long j10, TimeUnit timeUnit, s.c cVar, boolean z10) {
            this.f28588a = rVar;
            this.f28589b = j10;
            this.f28590c = timeUnit;
            this.f28591d = cVar;
            this.f28592e = z10;
        }

        @Override // xn.b
        public void dispose() {
            this.f28593f.dispose();
            this.f28591d.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28591d.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28591d.c(new RunnableC0329a(), this.f28589b, this.f28590c);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28591d.c(new b(th2), this.f28592e ? this.f28589b : 0L, this.f28590c);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28591d.c(new c(t10), this.f28589b, this.f28590c);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28593f, bVar)) {
                this.f28593f = bVar;
                this.f28588a.onSubscribe(this);
            }
        }
    }

    public f0(p<T> pVar, long j10, TimeUnit timeUnit, s sVar, boolean z10) {
        super(pVar);
        this.f28584b = j10;
        this.f28585c = timeUnit;
        this.f28586d = sVar;
        this.f28587e = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(this.f28587e ? rVar : new d(rVar), this.f28584b, this.f28585c, this.f28586d.a(), this.f28587e));
    }
}
