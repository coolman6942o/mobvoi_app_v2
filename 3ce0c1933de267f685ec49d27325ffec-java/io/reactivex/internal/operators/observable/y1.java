package io.reactivex.internal.operators.observable;

import co.f;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
/* compiled from: ObservableMergeWithMaybe.java */
/* loaded from: classes3.dex */
public final class y1<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final i<? extends T> f29139b;

    /* compiled from: ObservableMergeWithMaybe.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T>, b {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean disposed;
        final r<? super T> downstream;
        volatile boolean mainDone;
        volatile int otherState;
        volatile f<T> queue;
        T singleItem;
        final AtomicReference<b> mainDisposable = new AtomicReference<>();
        final C0341a<T> otherObserver = new C0341a<>(this);
        final AtomicThrowable error = new AtomicThrowable();

        /* compiled from: ObservableMergeWithMaybe.java */
        /* renamed from: io.reactivex.internal.operators.observable.y1$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0341a<T> extends AtomicReference<b> implements h<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final a<T> parent;

            C0341a(a<T> aVar) {
                this.parent = aVar;
            }

            @Override // io.reactivex.h
            public void onComplete() {
                this.parent.d();
            }

            @Override // io.reactivex.h
            public void onError(Throwable th2) {
                this.parent.g(th2);
            }

            @Override // io.reactivex.h
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.h
            public void onSuccess(T t10) {
                this.parent.h(t10);
            }
        }

        a(r<? super T> rVar) {
            this.downstream = rVar;
        }

        void a() {
            if (getAndIncrement() == 0) {
                b();
            }
        }

        void b() {
            r<? super T> rVar = this.downstream;
            int i10 = 1;
            while (!this.disposed) {
                if (this.error.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    rVar.onError(this.error.terminate());
                    return;
                }
                int i11 = this.otherState;
                if (i11 == 1) {
                    this.singleItem = null;
                    this.otherState = 2;
                    rVar.onNext((T) this.singleItem);
                    i11 = 2;
                }
                boolean z10 = this.mainDone;
                f<T> fVar = this.queue;
                T poll = fVar != null ? fVar.poll() : (Object) null;
                boolean z11 = poll == null;
                if (z10 && z11 && i11 == 2) {
                    this.queue = null;
                    rVar.onComplete();
                    return;
                } else if (z11) {
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    rVar.onNext(poll);
                }
            }
            this.singleItem = null;
            this.queue = null;
        }

        f<T> c() {
            f<T> fVar = this.queue;
            if (fVar != null) {
                return fVar;
            }
            io.reactivex.internal.queue.b bVar = new io.reactivex.internal.queue.b(k.bufferSize());
            this.queue = bVar;
            return bVar;
        }

        void d() {
            this.otherState = 2;
            a();
        }

        @Override // xn.b
        public void dispose() {
            this.disposed = true;
            DisposableHelper.dispose(this.mainDisposable);
            DisposableHelper.dispose(this.otherObserver);
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        void g(Throwable th2) {
            if (this.error.addThrowable(th2)) {
                DisposableHelper.dispose(this.mainDisposable);
                a();
                return;
            }
            fo.a.s(th2);
        }

        void h(T t10) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t10);
                this.otherState = 2;
            } else {
                this.singleItem = t10;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.mainDisposable.get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.mainDone = true;
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.error.addThrowable(th2)) {
                DisposableHelper.dispose(this.mainDisposable);
                a();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t10);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                c().offer(t10);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            b();
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            DisposableHelper.setOnce(this.mainDisposable, bVar);
        }
    }

    public y1(k<T> kVar, i<? extends T> iVar) {
        super(kVar);
        this.f29139b = iVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        a aVar = new a(rVar);
        rVar.onSubscribe(aVar);
        this.f28426a.subscribe(aVar);
        this.f29139b.b(aVar.otherObserver);
    }
}
