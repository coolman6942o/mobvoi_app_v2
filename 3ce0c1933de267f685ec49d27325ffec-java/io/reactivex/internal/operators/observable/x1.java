package io.reactivex.internal.operators.observable;

import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.g;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableMergeWithCompletable.java */
/* loaded from: classes3.dex */
public final class x1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final c f29120b;

    /* compiled from: ObservableMergeWithCompletable.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T>, b {
        private static final long serialVersionUID = -4592979584110982903L;
        final r<? super T> downstream;
        volatile boolean mainDone;
        volatile boolean otherDone;
        final AtomicReference<b> mainDisposable = new AtomicReference<>();
        final C0339a otherObserver = new C0339a(this);
        final AtomicThrowable error = new AtomicThrowable();

        /* compiled from: ObservableMergeWithCompletable.java */
        /* renamed from: io.reactivex.internal.operators.observable.x1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0339a extends AtomicReference<b> implements io.reactivex.b {
            private static final long serialVersionUID = -2935427570954647017L;
            final a<?> parent;

            C0339a(a<?> aVar) {
                this.parent = aVar;
            }

            @Override // io.reactivex.b
            public void onComplete() {
                this.parent.a();
            }

            @Override // io.reactivex.b
            public void onError(Throwable th2) {
                this.parent.b(th2);
            }

            @Override // io.reactivex.b
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        a(r<? super T> rVar) {
            this.downstream = rVar;
        }

        void a() {
            this.otherDone = true;
            if (this.mainDone) {
                g.a(this.downstream, this, this.error);
            }
        }

        void b(Throwable th2) {
            DisposableHelper.dispose(this.mainDisposable);
            g.c(this.downstream, th2, this, this.error);
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.mainDone = true;
            if (this.otherDone) {
                g.a(this.downstream, this, this.error);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.mainDisposable);
            g.c(this.downstream, th2, this, this.error);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            g.e(this.downstream, t10, this, this.error);
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.mainDisposable, bVar);
        }
    }

    public x1(k<T> kVar, c cVar) {
        super(kVar);
        this.f29120b = cVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        a aVar = new a(rVar);
        rVar.onSubscribe(aVar);
        this.f28426a.subscribe(aVar);
        this.f29120b.b(aVar.otherObserver);
    }
}
