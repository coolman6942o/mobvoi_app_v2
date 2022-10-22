package io.reactivex.internal.operators.observable;

import co.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.p;
import io.reactivex.r;
/* compiled from: ObservableDoFinally.java */
/* loaded from: classes3.dex */
public final class m0<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final zn.a f28813b;

    /* compiled from: ObservableDoFinally.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends BasicIntQueueDisposable<T> implements r<T> {
        private static final long serialVersionUID = 4109457741734051389L;
        final r<? super T> downstream;
        final zn.a onFinally;

        /* renamed from: qd  reason: collision with root package name */
        b<T> f28814qd;
        boolean syncFused;
        xn.b upstream;

        a(r<? super T> rVar, zn.a aVar) {
            this.downstream = rVar;
            this.onFinally = aVar;
        }

        void a() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    fo.a.s(th2);
                }
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public void clear() {
            this.f28814qd.clear();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public void dispose() {
            this.upstream.dispose();
            a();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public boolean isEmpty() {
            return this.f28814qd.isEmpty();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.downstream.onComplete();
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.downstream.onError(th2);
            a();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof b) {
                    this.f28814qd = (b) bVar;
                }
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public T poll() throws Exception {
            T poll = this.f28814qd.poll();
            if (poll == null && this.syncFused) {
                a();
            }
            return poll;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.c
        public int requestFusion(int i10) {
            b<T> bVar = this.f28814qd;
            boolean z10 = false;
            if (bVar == null || (i10 & 4) != 0) {
                return 0;
            }
            int requestFusion = bVar.requestFusion(i10);
            if (requestFusion != 0) {
                if (requestFusion == 1) {
                    z10 = true;
                }
                this.syncFused = z10;
            }
            return requestFusion;
        }
    }

    public m0(p<T> pVar, zn.a aVar) {
        super(pVar);
        this.f28813b = aVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28813b));
    }
}
