package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.g;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.subjects.c;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableRepeatWhen.java */
/* loaded from: classes3.dex */
public final class o2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super k<Object>, ? extends p<?>> f28893b;

    /* compiled from: ObservableRepeatWhen.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T>, b {
        private static final long serialVersionUID = 802743776666017014L;
        volatile boolean active;
        final r<? super T> downstream;
        final c<Object> signaller;
        final p<T> source;
        final AtomicInteger wip = new AtomicInteger();
        final AtomicThrowable error = new AtomicThrowable();
        final a<T>.C0333a inner = new C0333a();
        final AtomicReference<b> upstream = new AtomicReference<>();

        /* compiled from: ObservableRepeatWhen.java */
        /* renamed from: io.reactivex.internal.operators.observable.o2$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        final class C0333a extends AtomicReference<b> implements r<Object> {
            private static final long serialVersionUID = 3254781284376480842L;

            C0333a() {
            }

            @Override // io.reactivex.r
            public void onComplete() {
                a.this.a();
            }

            @Override // io.reactivex.r
            public void onError(Throwable th2) {
                a.this.b(th2);
            }

            @Override // io.reactivex.r
            public void onNext(Object obj) {
                a.this.c();
            }

            @Override // io.reactivex.r
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        a(r<? super T> rVar, c<Object> cVar, p<T> pVar) {
            this.downstream = rVar;
            this.signaller = cVar;
            this.source = pVar;
        }

        void a() {
            DisposableHelper.dispose(this.upstream);
            g.a(this.downstream, this, this.error);
        }

        void b(Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            g.c(this.downstream, th2, this, this.error);
        }

        void c() {
            d();
        }

        void d() {
            if (this.wip.getAndIncrement() == 0) {
                while (!isDisposed()) {
                    if (!this.active) {
                        this.active = true;
                        this.source.subscribe(this);
                    }
                    if (this.wip.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this.inner);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            DisposableHelper.replace(this.upstream, null);
            this.active = false;
            this.signaller.onNext(0);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.inner);
            g.c(this.downstream, th2, this, this.error);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            g.e(this.downstream, t10, this, this.error);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    public o2(p<T> pVar, o<? super k<Object>, ? extends p<?>> oVar) {
        super(pVar);
        this.f28893b = oVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        c<T> b10 = io.reactivex.subjects.a.d().b();
        try {
            p pVar = (p) bo.b.e(this.f28893b.apply(b10), "The handler returned a null ObservableSource");
            a aVar = new a(rVar, b10, this.f28426a);
            rVar.onSubscribe(aVar);
            pVar.subscribe(aVar.inner);
            aVar.d();
        } catch (Throwable th2) {
            io.reactivex.exceptions.a.b(th2);
            EmptyDisposable.error(th2, rVar);
        }
    }
}
