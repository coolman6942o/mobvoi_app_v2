package io.reactivex.internal.operators.observable;

import co.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.BasicIntQueueDisposable;
import io.reactivex.internal.schedulers.j;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import xn.b;
/* compiled from: ObservableObserveOn.java */
/* loaded from: classes3.dex */
public final class b2<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final s f28454b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f28455c;

    /* renamed from: d  reason: collision with root package name */
    final int f28456d;

    /* compiled from: ObservableObserveOn.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends BasicIntQueueDisposable<T> implements r<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final r<? super T> downstream;
        Throwable error;
        boolean outputFused;
        g<T> queue;
        int sourceMode;
        b upstream;
        final s.c worker;

        a(r<? super T> rVar, s.c cVar, boolean z10, int i10) {
            this.downstream = rVar;
            this.worker = cVar;
            this.delayError = z10;
            this.bufferSize = i10;
        }

        boolean a(boolean z10, boolean z11, r<? super T> rVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            } else if (!z10) {
                return false;
            } else {
                Throwable th2 = this.error;
                if (this.delayError) {
                    if (!z11) {
                        return false;
                    }
                    this.disposed = true;
                    if (th2 != null) {
                        rVar.onError(th2);
                    } else {
                        rVar.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                } else if (th2 != null) {
                    this.disposed = true;
                    this.queue.clear();
                    rVar.onError(th2);
                    this.worker.dispose();
                    return true;
                } else if (!z11) {
                    return false;
                } else {
                    this.disposed = true;
                    rVar.onComplete();
                    this.worker.dispose();
                    return true;
                }
            }
        }

        void b() {
            int i10 = 1;
            while (!this.disposed) {
                boolean z10 = this.done;
                Throwable th2 = this.error;
                if (this.delayError || !z10 || th2 == null) {
                    this.downstream.onNext(null);
                    if (z10) {
                        this.disposed = true;
                        Throwable th3 = this.error;
                        if (th3 != null) {
                            this.downstream.onError(th3);
                        } else {
                            this.downstream.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else {
                    this.disposed = true;
                    this.downstream.onError(this.error);
                    this.worker.dispose();
                    return;
                }
            }
        }

        void c() {
            g<T> gVar = this.queue;
            r<? super T> rVar = this.downstream;
            int i10 = 1;
            while (!a(this.done, gVar.isEmpty(), rVar)) {
                while (true) {
                    boolean z10 = this.done;
                    try {
                        Object obj = (T) gVar.poll();
                        boolean z11 = obj == null;
                        if (!a(z10, z11, rVar)) {
                            if (z11) {
                                i10 = addAndGet(-i10);
                                if (i10 == 0) {
                                    return;
                                }
                            } else {
                                rVar.onNext(obj);
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th2) {
                        io.reactivex.exceptions.a.b(th2);
                        this.disposed = true;
                        this.upstream.dispose();
                        gVar.clear();
                        rVar.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public void clear() {
            this.queue.clear();
        }

        void d() {
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.upstream.dispose();
                this.worker.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, xn.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public boolean isEmpty() {
            return this.queue.isEmpty();
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
                return;
            }
            this.error = th2;
            this.done = true;
            d();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t10);
                }
                d();
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof co.b) {
                    co.b bVar2 = (co.b) bVar;
                    int requestFusion = bVar2.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        d();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.b(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // io.reactivex.internal.observers.BasicIntQueueDisposable, co.c
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.outputFused) {
                b();
            } else {
                c();
            }
        }
    }

    public b2(p<T> pVar, s sVar, boolean z10, int i10) {
        super(pVar);
        this.f28454b = sVar;
        this.f28455c = z10;
        this.f28456d = i10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        s sVar = this.f28454b;
        if (sVar instanceof j) {
            this.f28426a.subscribe(rVar);
            return;
        }
        this.f28426a.subscribe(new a(rVar, sVar.a(), this.f28455c, this.f28456d));
    }
}
