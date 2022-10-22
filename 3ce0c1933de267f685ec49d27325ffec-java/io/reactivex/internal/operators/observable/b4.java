package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.subjects.d;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ObservableWindow.java */
/* loaded from: classes3.dex */
public final class b4<T> extends io.reactivex.internal.operators.observable.a<T, k<T>> {

    /* renamed from: b  reason: collision with root package name */
    final long f28464b;

    /* renamed from: c  reason: collision with root package name */
    final long f28465c;

    /* renamed from: d  reason: collision with root package name */
    final int f28466d;

    /* compiled from: ObservableWindow.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T>, xn.b, Runnable {
        private static final long serialVersionUID = -7481782523886138128L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final r<? super k<T>> downstream;
        long size;
        xn.b upstream;
        d<T> window;

        a(r<? super k<T>> rVar, long j10, int i10) {
            this.downstream = rVar;
            this.count = j10;
            this.capacityHint = i10;
        }

        @Override // xn.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            d<T> dVar = this.window;
            if (dVar != null) {
                this.window = null;
                dVar.onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            d<T> dVar = this.window;
            if (dVar != null) {
                this.window = null;
                dVar.onError(th2);
            }
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            d<T> dVar = this.window;
            if (dVar == null && !this.cancelled) {
                dVar = d.e(this.capacityHint, this);
                this.window = dVar;
                this.downstream.onNext(dVar);
            }
            if (dVar != null) {
                dVar.onNext(t10);
                long j10 = this.size + 1;
                this.size = j10;
                if (j10 >= this.count) {
                    this.size = 0L;
                    this.window = null;
                    dVar.onComplete();
                    if (this.cancelled) {
                        this.upstream.dispose();
                    }
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    /* compiled from: ObservableWindow.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicBoolean implements r<T>, xn.b, Runnable {
        private static final long serialVersionUID = 3366976432059579510L;
        volatile boolean cancelled;
        final int capacityHint;
        final long count;
        final r<? super k<T>> downstream;
        long firstEmission;
        long index;
        final long skip;
        xn.b upstream;
        final AtomicInteger wip = new AtomicInteger();
        final ArrayDeque<d<T>> windows = new ArrayDeque<>();

        b(r<? super k<T>> rVar, long j10, long j11, int i10) {
            this.downstream = rVar;
            this.count = j10;
            this.skip = j11;
            this.capacityHint = i10;
        }

        @Override // xn.b
        public void dispose() {
            this.cancelled = true;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            ArrayDeque<d<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onComplete();
            }
            this.downstream.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            ArrayDeque<d<T>> arrayDeque = this.windows;
            while (!arrayDeque.isEmpty()) {
                arrayDeque.poll().onError(th2);
            }
            this.downstream.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            ArrayDeque<d<T>> arrayDeque = this.windows;
            long j10 = this.index;
            long j11 = this.skip;
            if (j10 % j11 == 0 && !this.cancelled) {
                this.wip.getAndIncrement();
                d<T> e10 = d.e(this.capacityHint, this);
                arrayDeque.offer(e10);
                this.downstream.onNext(e10);
            }
            long j12 = this.firstEmission + 1;
            Iterator<d<T>> it = arrayDeque.iterator();
            while (it.hasNext()) {
                it.next().onNext(t10);
            }
            if (j12 >= this.count) {
                arrayDeque.poll().onComplete();
                if (!arrayDeque.isEmpty() || !this.cancelled) {
                    this.firstEmission = j12 - j11;
                } else {
                    this.upstream.dispose();
                    return;
                }
            } else {
                this.firstEmission = j12;
            }
            this.index = j10 + 1;
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wip.decrementAndGet() == 0 && this.cancelled) {
                this.upstream.dispose();
            }
        }
    }

    public b4(p<T> pVar, long j10, long j11, int i10) {
        super(pVar);
        this.f28464b = j10;
        this.f28465c = j11;
        this.f28466d = i10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super k<T>> rVar) {
        if (this.f28464b == this.f28465c) {
            this.f28426a.subscribe(new a(rVar, this.f28464b, this.f28466d));
        } else {
            this.f28426a.subscribe(new b(rVar, this.f28464b, this.f28465c, this.f28466d));
        }
    }
}
