package io.reactivex.internal.operators.observable;

import co.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableSwitchMap.java */
/* loaded from: classes3.dex */
public final class j3<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends p<? extends R>> f28762b;

    /* renamed from: c  reason: collision with root package name */
    final int f28763c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f28764d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableSwitchMap.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends AtomicReference<xn.b> implements r<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final b<T, R> parent;
        volatile g<R> queue;

        a(b<T, R> bVar, long j10, int i10) {
            this.parent = bVar;
            this.index = j10;
            this.bufferSize = i10;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.b();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.parent.c(this, th2);
        }

        @Override // io.reactivex.r
        public void onNext(R r10) {
            if (this.index == this.parent.unique) {
                if (r10 != null) {
                    this.queue.offer(r10);
                }
                this.parent.b();
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                if (bVar instanceof co.b) {
                    co.b bVar2 = (co.b) bVar;
                    int requestFusion = bVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.queue = bVar2;
                        this.done = true;
                        this.parent.b();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = bVar2;
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
            }
        }
    }

    /* compiled from: ObservableSwitchMap.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicInteger implements r<T>, xn.b {
        static final a<Object, Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final r<? super R> downstream;
        final o<? super T, ? extends p<? extends R>> mapper;
        volatile long unique;
        xn.b upstream;
        final AtomicReference<a<T, R>> active = new AtomicReference<>();
        final AtomicThrowable errors = new AtomicThrowable();

        static {
            a<Object, Object> aVar = new a<>(null, -1L, 1);
            CANCELLED = aVar;
            aVar.a();
        }

        b(r<? super R> rVar, o<? super T, ? extends p<? extends R>> oVar, int i10, boolean z10) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.bufferSize = i10;
            this.delayErrors = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            a<Object, Object> aVar;
            a<T, R> aVar2 = this.active.get();
            a<Object, Object> aVar3 = CANCELLED;
            if (aVar2 != aVar3 && (aVar = (a) this.active.getAndSet(aVar3)) != aVar3 && aVar != null) {
                aVar.a();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:100:0x000f A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x00e9 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void b() {
            g<R> gVar;
            R r10;
            if (getAndIncrement() == 0) {
                r<? super R> rVar = this.downstream;
                AtomicReference<a<T, R>> atomicReference = this.active;
                boolean z10 = this.delayErrors;
                int i10 = 1;
                while (!this.cancelled) {
                    if (this.done) {
                        boolean z11 = atomicReference.get() == null;
                        if (z10) {
                            if (z11) {
                                Throwable th2 = this.errors.get();
                                if (th2 != null) {
                                    rVar.onError(th2);
                                    return;
                                } else {
                                    rVar.onComplete();
                                    return;
                                }
                            }
                        } else if (this.errors.get() != null) {
                            rVar.onError(this.errors.terminate());
                            return;
                        } else if (z11) {
                            rVar.onComplete();
                            return;
                        }
                    }
                    a<T, R> aVar = atomicReference.get();
                    if (!(aVar == null || (gVar = aVar.queue) == null)) {
                        if (aVar.done) {
                            boolean isEmpty = gVar.isEmpty();
                            if (z10) {
                                if (isEmpty) {
                                    atomicReference.compareAndSet(aVar, null);
                                }
                            } else if (this.errors.get() != null) {
                                rVar.onError(this.errors.terminate());
                                return;
                            } else if (isEmpty) {
                                atomicReference.compareAndSet(aVar, null);
                            }
                        }
                        boolean z12 = false;
                        while (!this.cancelled) {
                            if (aVar == atomicReference.get()) {
                                if (z10 || this.errors.get() == null) {
                                    boolean z13 = aVar.done;
                                    try {
                                        r10 = gVar.poll();
                                    } catch (Throwable th3) {
                                        io.reactivex.exceptions.a.b(th3);
                                        this.errors.addThrowable(th3);
                                        atomicReference.compareAndSet(aVar, null);
                                        if (!z10) {
                                            a();
                                            this.upstream.dispose();
                                            this.done = true;
                                        } else {
                                            aVar.a();
                                        }
                                        z12 = true;
                                        r10 = (Object) null;
                                    }
                                    boolean z14 = r10 == null;
                                    if (z13 && z14) {
                                        atomicReference.compareAndSet(aVar, null);
                                    } else if (!z14) {
                                        rVar.onNext(r10);
                                    } else if (!z12) {
                                        continue;
                                    }
                                } else {
                                    rVar.onError(this.errors.terminate());
                                    return;
                                }
                            }
                            z12 = true;
                            if (!z12) {
                            }
                        }
                        return;
                    }
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }

        void c(a<T, R> aVar, Throwable th2) {
            if (aVar.index != this.unique || !this.errors.addThrowable(th2)) {
                fo.a.s(th2);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
            }
            aVar.done = true;
            b();
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                a();
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                b();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.done || !this.errors.addThrowable(th2)) {
                fo.a.s(th2);
                return;
            }
            if (!this.delayErrors) {
                a();
            }
            this.done = true;
            b();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            a<T, R> aVar;
            long j10 = this.unique + 1;
            this.unique = j10;
            a<T, R> aVar2 = this.active.get();
            if (aVar2 != null) {
                aVar2.a();
            }
            try {
                p pVar = (p) bo.b.e(this.mapper.apply(t10), "The ObservableSource returned is null");
                a<T, R> aVar3 = new a<>(this, j10, this.bufferSize);
                do {
                    aVar = this.active.get();
                    if (aVar == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(aVar, aVar3));
                pVar.subscribe(aVar3);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.dispose();
                onError(th2);
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

    public j3(p<T> pVar, o<? super T, ? extends p<? extends R>> oVar, int i10, boolean z10) {
        super(pVar);
        this.f28762b = oVar;
        this.f28763c = i10;
        this.f28764d = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super R> rVar) {
        if (!ObservableScalarXMap.b(this.f28426a, rVar, this.f28762b)) {
            this.f28426a.subscribe(new b(rVar, this.f28762b, this.f28763c, this.f28764d));
        }
    }
}
