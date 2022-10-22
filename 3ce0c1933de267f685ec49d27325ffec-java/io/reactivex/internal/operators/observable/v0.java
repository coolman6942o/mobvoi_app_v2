package io.reactivex.internal.operators.observable;

import co.f;
import co.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.p;
import io.reactivex.r;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableFlatMap.java */
/* loaded from: classes3.dex */
public final class v0<T, U> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends p<? extends U>> f29074b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f29075c;

    /* renamed from: d  reason: collision with root package name */
    final int f29076d;

    /* renamed from: e  reason: collision with root package name */
    final int f29077e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, U> extends AtomicReference<xn.b> implements r<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;

        /* renamed from: id  reason: collision with root package name */
        final long f29078id;
        final b<T, U> parent;
        volatile g<U> queue;

        a(b<T, U> bVar, long j10) {
            this.f29078id = j10;
            this.parent = bVar;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.done = true;
            this.parent.d();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.parent.errors.addThrowable(th2)) {
                b<T, U> bVar = this.parent;
                if (!bVar.delayErrors) {
                    bVar.c();
                }
                this.done = true;
                this.parent.d();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(U u10) {
            if (this.fusionMode == 0) {
                this.parent.j(u10, this);
            } else {
                this.parent.d();
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.setOnce(this, bVar) && (bVar instanceof co.b)) {
                co.b bVar2 = (co.b) bVar;
                int requestFusion = bVar2.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                    this.done = true;
                    this.parent.d();
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = bVar2;
                }
            }
        }
    }

    /* compiled from: ObservableFlatMap.java */
    /* loaded from: classes3.dex */
    static final class b<T, U> extends AtomicInteger implements xn.b, r<T> {
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final r<? super U> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        long lastId;
        int lastIndex;
        final o<? super T, ? extends p<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<a<?, ?>[]> observers;
        volatile f<U> queue;
        Queue<p<? extends U>> sources;
        long uniqueId;
        xn.b upstream;
        int wip;
        static final a<?, ?>[] EMPTY = new a[0];
        static final a<?, ?>[] CANCELLED = new a[0];

        b(r<? super U> rVar, o<? super T, ? extends p<? extends U>> oVar, boolean z10, int i10, int i11) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.delayErrors = z10;
            this.maxConcurrency = i10;
            this.bufferSize = i11;
            if (i10 != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i10);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        /* JADX WARN: Multi-variable type inference failed */
        boolean a(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = this.observers.get();
                if (aVarArr == CANCELLED) {
                    aVar.a();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.observers.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        boolean b() {
            if (this.cancelled) {
                return true;
            }
            Throwable th2 = this.errors.get();
            if (this.delayErrors || th2 == null) {
                return false;
            }
            c();
            Throwable terminate = this.errors.terminate();
            if (terminate != io.reactivex.internal.util.f.f29256a) {
                this.downstream.onError(terminate);
            }
            return true;
        }

        boolean c() {
            a<?, ?>[] andSet;
            this.upstream.dispose();
            a<?, ?>[] aVarArr = this.observers.get();
            a<?, ?>[] aVarArr2 = CANCELLED;
            if (aVarArr == aVarArr2 || (andSet = this.observers.getAndSet(aVarArr2)) == aVarArr2) {
                return false;
            }
            for (a<?, ?> aVar : andSet) {
                aVar.a();
            }
            return true;
        }

        void d() {
            if (getAndIncrement() == 0) {
                g();
            }
        }

        @Override // xn.b
        public void dispose() {
            Throwable terminate;
            if (!this.cancelled) {
                this.cancelled = true;
                if (c() && (terminate = this.errors.terminate()) != null && terminate != io.reactivex.internal.util.f.f29256a) {
                    fo.a.s(terminate);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:123:0x0004, code lost:
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void g() {
            int i10;
            r<? super U> rVar = this.downstream;
            int i11 = 1;
            while (!b()) {
                f<U> fVar = this.queue;
                if (fVar != null) {
                    while (!b()) {
                        Object obj = (U) fVar.poll();
                        if (obj != null) {
                            rVar.onNext(obj);
                        }
                    }
                    return;
                }
                boolean z10 = this.done;
                f<U> fVar2 = this.queue;
                a<?, ?>[] aVarArr = this.observers.get();
                int length = aVarArr.length;
                int i12 = 0;
                if (this.maxConcurrency != Integer.MAX_VALUE) {
                    synchronized (this) {
                        i10 = this.sources.size();
                    }
                } else {
                    i10 = 0;
                }
                if (!z10 || !((fVar2 == null || fVar2.isEmpty()) && length == 0 && i10 == 0)) {
                    if (length != 0) {
                        long j10 = this.lastId;
                        int i13 = this.lastIndex;
                        if (length <= i13 || aVarArr[i13].f29078id != j10) {
                            if (length <= i13) {
                                i13 = 0;
                            }
                            for (int i14 = 0; i14 < length && aVarArr[i13].f29078id != j10; i14++) {
                                i13++;
                                if (i13 == length) {
                                    i13 = 0;
                                }
                            }
                            this.lastIndex = i13;
                            this.lastId = aVarArr[i13].f29078id;
                        }
                        int i15 = 0;
                        for (int i16 = 0; i16 < length; i16++) {
                            if (!b()) {
                                a<T, U> aVar = aVarArr[i13];
                                g<U> gVar = aVar.queue;
                                if (gVar != null) {
                                    while (true) {
                                        try {
                                            Object obj2 = (U) gVar.poll();
                                            if (obj2 == null) {
                                                break;
                                            }
                                            rVar.onNext(obj2);
                                            if (b()) {
                                                return;
                                            }
                                        } catch (Throwable th2) {
                                            io.reactivex.exceptions.a.b(th2);
                                            aVar.a();
                                            this.errors.addThrowable(th2);
                                            if (!b()) {
                                                h(aVar);
                                                i15++;
                                                i13++;
                                                if (i13 != length) {
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                    }
                                }
                                boolean z11 = aVar.done;
                                g<U> gVar2 = aVar.queue;
                                if (z11 && (gVar2 == null || gVar2.isEmpty())) {
                                    h(aVar);
                                    if (!b()) {
                                        i15++;
                                    } else {
                                        return;
                                    }
                                }
                                i13++;
                                if (i13 != length) {
                                }
                                i13 = 0;
                            } else {
                                return;
                            }
                        }
                        this.lastIndex = i13;
                        this.lastId = aVarArr[i13].f29078id;
                        i12 = i15;
                    }
                    if (i12 == 0) {
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                        while (true) {
                            i12--;
                            if (i12 != 0) {
                                synchronized (this) {
                                    p<? extends U> poll = this.sources.poll();
                                    if (poll == null) {
                                        this.wip--;
                                    } else {
                                        i(poll);
                                    }
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    Throwable terminate = this.errors.terminate();
                    if (terminate == io.reactivex.internal.util.f.f29256a) {
                        return;
                    }
                    if (terminate == null) {
                        rVar.onComplete();
                        return;
                    } else {
                        rVar.onError(terminate);
                        return;
                    }
                }
            }
        }

        void h(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = this.observers.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i10 = -1;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        } else if (aVarArr[i11] == aVar) {
                            i10 = i11;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i10 >= 0) {
                        if (length == 1) {
                            aVarArr2 = EMPTY;
                        } else {
                            a<?, ?>[] aVarArr3 = new a[length - 1];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                            System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(aVarArr, aVarArr2));
        }

        void i(p<? extends U> pVar) {
            p<? extends U> poll;
            while (pVar instanceof Callable) {
                if (k((Callable) pVar) && this.maxConcurrency != Integer.MAX_VALUE) {
                    boolean z10 = false;
                    synchronized (this) {
                        poll = this.sources.poll();
                        if (poll == null) {
                            this.wip--;
                            z10 = true;
                        }
                    }
                    if (z10) {
                        d();
                        return;
                    }
                    pVar = poll;
                } else {
                    return;
                }
            }
            long j10 = this.uniqueId;
            this.uniqueId = 1 + j10;
            a<T, U> aVar = new a<>(this, j10);
            if (a(aVar)) {
                pVar.subscribe(aVar);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void j(U u10, a<T, U> aVar) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                g gVar = aVar.queue;
                if (gVar == null) {
                    gVar = new io.reactivex.internal.queue.b(this.bufferSize);
                    aVar.queue = gVar;
                }
                gVar.offer(u10);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.downstream.onNext(u10);
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            g();
        }

        boolean k(Callable<? extends U> callable) {
            try {
                U call = callable.call();
                if (call == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    f<U> fVar = this.queue;
                    if (fVar == null) {
                        if (this.maxConcurrency == Integer.MAX_VALUE) {
                            fVar = new io.reactivex.internal.queue.b<>(this.bufferSize);
                        } else {
                            fVar = new SpscArrayQueue<>(this.maxConcurrency);
                        }
                        this.queue = fVar;
                    }
                    if (!fVar.offer(call)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return true;
                    } else if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.downstream.onNext(call);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                g();
                return true;
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.errors.addThrowable(th2);
                d();
                return true;
            }
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                d();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.done) {
                fo.a.s(th2);
            } else if (this.errors.addThrowable(th2)) {
                this.done = true;
                d();
            } else {
                fo.a.s(th2);
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.done) {
                try {
                    p<? extends U> pVar = (p) bo.b.e(this.mapper.apply(t10), "The mapper returned a null ObservableSource");
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            int i10 = this.wip;
                            if (i10 == this.maxConcurrency) {
                                this.sources.offer(pVar);
                                return;
                            }
                            this.wip = i10 + 1;
                        }
                    }
                    i(pVar);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.upstream.dispose();
                    onError(th2);
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
    }

    public v0(p<T> pVar, o<? super T, ? extends p<? extends U>> oVar, boolean z10, int i10, int i11) {
        super(pVar);
        this.f29074b = oVar;
        this.f29075c = z10;
        this.f29076d = i10;
        this.f29077e = i11;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super U> rVar) {
        if (!ObservableScalarXMap.b(this.f28426a, rVar, this.f29074b)) {
            this.f28426a.subscribe(new b(rVar, this.f29074b, this.f29075c, this.f29076d, this.f29077e));
        }
    }
}
