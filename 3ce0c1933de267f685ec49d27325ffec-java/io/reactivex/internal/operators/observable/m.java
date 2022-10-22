package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableBufferBoundary.java */
/* loaded from: classes3.dex */
public final class m<T, U extends Collection<? super T>, Open, Close> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final Callable<U> f28810b;

    /* renamed from: c  reason: collision with root package name */
    final p<? extends Open> f28811c;

    /* renamed from: d  reason: collision with root package name */
    final o<? super Open, ? extends p<? extends Close>> f28812d;

    /* compiled from: ObservableBufferBoundary.java */
    /* loaded from: classes3.dex */
    static final class a<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements r<T>, xn.b {
        private static final long serialVersionUID = -8466418554264089604L;
        final o<? super Open, ? extends p<? extends Close>> bufferClose;
        final p<? extends Open> bufferOpen;
        final Callable<C> bufferSupplier;
        volatile boolean cancelled;
        volatile boolean done;
        final r<? super C> downstream;
        long index;
        final io.reactivex.internal.queue.b<C> queue = new io.reactivex.internal.queue.b<>(k.bufferSize());
        final xn.a observers = new xn.a();
        final AtomicReference<xn.b> upstream = new AtomicReference<>();
        Map<Long, C> buffers = new LinkedHashMap();
        final AtomicThrowable errors = new AtomicThrowable();

        /* compiled from: ObservableBufferBoundary.java */
        /* renamed from: io.reactivex.internal.operators.observable.m$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0332a<Open> extends AtomicReference<xn.b> implements r<Open>, xn.b {
            private static final long serialVersionUID = -8498650778633225126L;
            final a<?, ?, Open, ?> parent;

            C0332a(a<?, ?, Open, ?> aVar) {
                this.parent = aVar;
            }

            @Override // xn.b
            public void dispose() {
                DisposableHelper.dispose(this);
            }

            @Override // xn.b
            public boolean isDisposed() {
                return get() == DisposableHelper.DISPOSED;
            }

            @Override // io.reactivex.r
            public void onComplete() {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.g(this);
            }

            @Override // io.reactivex.r
            public void onError(Throwable th2) {
                lazySet(DisposableHelper.DISPOSED);
                this.parent.a(this, th2);
            }

            @Override // io.reactivex.r
            public void onNext(Open open) {
                this.parent.d(open);
            }

            @Override // io.reactivex.r
            public void onSubscribe(xn.b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        a(r<? super C> rVar, p<? extends Open> pVar, o<? super Open, ? extends p<? extends Close>> oVar, Callable<C> callable) {
            this.downstream = rVar;
            this.bufferSupplier = callable;
            this.bufferOpen = pVar;
            this.bufferClose = oVar;
        }

        void a(xn.b bVar, Throwable th2) {
            DisposableHelper.dispose(this.upstream);
            this.observers.a(bVar);
            onError(th2);
        }

        void b(b<T, C> bVar, long j10) {
            boolean z10;
            this.observers.a(bVar);
            if (this.observers.f() == 0) {
                DisposableHelper.dispose(this.upstream);
                z10 = true;
            } else {
                z10 = false;
            }
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    this.queue.offer(map.remove(Long.valueOf(j10)));
                    if (z10) {
                        this.done = true;
                    }
                    c();
                }
            }
        }

        void c() {
            if (getAndIncrement() == 0) {
                r<? super C> rVar = this.downstream;
                io.reactivex.internal.queue.b<C> bVar = this.queue;
                int i10 = 1;
                while (!this.cancelled) {
                    boolean z10 = this.done;
                    if (!z10 || this.errors.get() == null) {
                        C poll = bVar.poll();
                        boolean z11 = poll == null;
                        if (z10 && z11) {
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
                    } else {
                        bVar.clear();
                        rVar.onError(this.errors.terminate());
                        return;
                    }
                }
                bVar.clear();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void d(Open open) {
            try {
                Collection collection = (Collection) bo.b.e(this.bufferSupplier.call(), "The bufferSupplier returned a null Collection");
                p pVar = (p) bo.b.e(this.bufferClose.apply(open), "The bufferClose returned a null ObservableSource");
                long j10 = this.index;
                this.index = 1 + j10;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map != 0) {
                        map.put(Long.valueOf(j10), collection);
                        b bVar = new b(this, j10);
                        this.observers.b(bVar);
                        pVar.subscribe(bVar);
                    }
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                DisposableHelper.dispose(this.upstream);
                onError(th2);
            }
        }

        @Override // xn.b
        public void dispose() {
            if (DisposableHelper.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        void g(C0332a<Open> aVar) {
            this.observers.a(aVar);
            if (this.observers.f() == 0) {
                DisposableHelper.dispose(this.upstream);
                this.done = true;
                c();
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.observers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    for (C c10 : map.values()) {
                        this.queue.offer(c10);
                    }
                    this.buffers = null;
                    this.done = true;
                    c();
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.errors.addThrowable(th2)) {
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                this.done = true;
                c();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    for (C c10 : map.values()) {
                        c10.add(t10);
                    }
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.setOnce(this.upstream, bVar)) {
                C0332a aVar = new C0332a(this);
                this.observers.b(aVar);
                this.bufferOpen.subscribe(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableBufferBoundary.java */
    /* loaded from: classes3.dex */
    public static final class b<T, C extends Collection<? super T>> extends AtomicReference<xn.b> implements r<Object>, xn.b {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final a<T, C, ?, ?> parent;

        b(a<T, C, ?, ?> aVar, long j10) {
            this.parent = aVar;
            this.index = j10;
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            xn.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.b(this, this.index);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            xn.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                lazySet(disposableHelper);
                this.parent.a(this, th2);
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(Object obj) {
            xn.b bVar = get();
            DisposableHelper disposableHelper = DisposableHelper.DISPOSED;
            if (bVar != disposableHelper) {
                lazySet(disposableHelper);
                bVar.dispose();
                this.parent.b(this, this.index);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public m(p<T> pVar, p<? extends Open> pVar2, o<? super Open, ? extends p<? extends Close>> oVar, Callable<U> callable) {
        super(pVar);
        this.f28811c = pVar2;
        this.f28812d = oVar;
        this.f28810b = callable;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super U> rVar) {
        a aVar = new a(rVar, this.f28811c, this.f28812d, this.f28810b);
        rVar.onSubscribe(aVar);
        this.f28426a.subscribe(aVar);
    }
}
