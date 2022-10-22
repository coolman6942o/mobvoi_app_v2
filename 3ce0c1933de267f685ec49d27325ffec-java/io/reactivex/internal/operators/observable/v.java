package io.reactivex.internal.operators.observable;

import co.g;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.InnerQueuedObserver;
import io.reactivex.internal.observers.i;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.p;
import io.reactivex.r;
import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicInteger;
import xn.b;
import zn.o;
/* compiled from: ObservableConcatMapEager.java */
/* loaded from: classes3.dex */
public final class v<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends p<? extends R>> f29070b;

    /* renamed from: c  reason: collision with root package name */
    final ErrorMode f29071c;

    /* renamed from: d  reason: collision with root package name */
    final int f29072d;

    /* renamed from: e  reason: collision with root package name */
    final int f29073e;

    /* compiled from: ObservableConcatMapEager.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements r<T>, b, i<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        volatile boolean cancelled;
        InnerQueuedObserver<R> current;
        volatile boolean done;
        final r<? super R> downstream;
        final ErrorMode errorMode;
        final o<? super T, ? extends p<? extends R>> mapper;
        final int maxConcurrency;
        final int prefetch;
        g<T> queue;
        int sourceMode;
        b upstream;
        final AtomicThrowable error = new AtomicThrowable();
        final ArrayDeque<InnerQueuedObserver<R>> observers = new ArrayDeque<>();

        a(r<? super R> rVar, o<? super T, ? extends p<? extends R>> oVar, int i10, int i11, ErrorMode errorMode) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.maxConcurrency = i10;
            this.prefetch = i11;
            this.errorMode = errorMode;
        }

        @Override // io.reactivex.internal.observers.i
        public void a() {
            R poll;
            boolean z10;
            if (getAndIncrement() == 0) {
                g<T> gVar = this.queue;
                ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.observers;
                r<? super R> rVar = this.downstream;
                ErrorMode errorMode = this.errorMode;
                int i10 = 1;
                while (true) {
                    int i11 = this.activeCount;
                    while (i11 != this.maxConcurrency) {
                        if (this.cancelled) {
                            gVar.clear();
                            g();
                            return;
                        } else if (errorMode != ErrorMode.IMMEDIATE || this.error.get() == null) {
                            try {
                                T poll2 = gVar.poll();
                                if (poll2 == null) {
                                    break;
                                }
                                p pVar = (p) bo.b.e(this.mapper.apply(poll2), "The mapper returned a null ObservableSource");
                                InnerQueuedObserver<R> innerQueuedObserver = new InnerQueuedObserver<>(this, this.prefetch);
                                arrayDeque.offer(innerQueuedObserver);
                                pVar.subscribe(innerQueuedObserver);
                                i11++;
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                this.upstream.dispose();
                                gVar.clear();
                                g();
                                this.error.addThrowable(th2);
                                rVar.onError(this.error.terminate());
                                return;
                            }
                        } else {
                            gVar.clear();
                            g();
                            rVar.onError(this.error.terminate());
                            return;
                        }
                    }
                    this.activeCount = i11;
                    if (this.cancelled) {
                        gVar.clear();
                        g();
                        return;
                    } else if (errorMode != ErrorMode.IMMEDIATE || this.error.get() == null) {
                        InnerQueuedObserver<R> innerQueuedObserver2 = this.current;
                        if (innerQueuedObserver2 == null) {
                            if (errorMode != ErrorMode.BOUNDARY || this.error.get() == null) {
                                boolean z11 = this.done;
                                InnerQueuedObserver<R> poll3 = arrayDeque.poll();
                                boolean z12 = poll3 == null;
                                if (!z11 || !z12) {
                                    if (!z12) {
                                        this.current = poll3;
                                    }
                                    innerQueuedObserver2 = poll3;
                                } else if (this.error.get() != null) {
                                    gVar.clear();
                                    g();
                                    rVar.onError(this.error.terminate());
                                    return;
                                } else {
                                    rVar.onComplete();
                                    return;
                                }
                            } else {
                                gVar.clear();
                                g();
                                rVar.onError(this.error.terminate());
                                return;
                            }
                        }
                        if (innerQueuedObserver2 != null) {
                            g<R> queue = innerQueuedObserver2.queue();
                            while (!this.cancelled) {
                                boolean isDone = innerQueuedObserver2.isDone();
                                if (errorMode != ErrorMode.IMMEDIATE || this.error.get() == null) {
                                    try {
                                        poll = queue.poll();
                                        z10 = poll == null;
                                    } catch (Throwable th3) {
                                        io.reactivex.exceptions.a.b(th3);
                                        this.error.addThrowable(th3);
                                        this.current = null;
                                        this.activeCount--;
                                    }
                                    if (isDone && z10) {
                                        this.current = null;
                                        this.activeCount--;
                                    } else if (!z10) {
                                        rVar.onNext(poll);
                                    }
                                } else {
                                    gVar.clear();
                                    g();
                                    rVar.onError(this.error.terminate());
                                    return;
                                }
                            }
                            gVar.clear();
                            g();
                            return;
                        }
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        gVar.clear();
                        g();
                        rVar.onError(this.error.terminate());
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.observers.i
        public void b(InnerQueuedObserver<R> innerQueuedObserver, Throwable th2) {
            if (this.error.addThrowable(th2)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.upstream.dispose();
                }
                innerQueuedObserver.setDone();
                a();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.internal.observers.i
        public void c(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.setDone();
            a();
        }

        @Override // io.reactivex.internal.observers.i
        public void d(InnerQueuedObserver<R> innerQueuedObserver, R r10) {
            innerQueuedObserver.queue().offer(r10);
            a();
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                h();
            }
        }

        void g() {
            InnerQueuedObserver<R> innerQueuedObserver = this.current;
            if (innerQueuedObserver != null) {
                innerQueuedObserver.dispose();
            }
            while (true) {
                InnerQueuedObserver<R> poll = this.observers.poll();
                if (poll != null) {
                    poll.dispose();
                } else {
                    return;
                }
            }
        }

        void h() {
            if (getAndIncrement() == 0) {
                do {
                    this.queue.clear();
                    g();
                } while (decrementAndGet() != 0);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.error.addThrowable(th2)) {
                this.done = true;
                a();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.sourceMode == 0) {
                this.queue.offer(t10);
            }
            a();
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                if (bVar instanceof co.b) {
                    co.b bVar2 = (co.b) bVar;
                    int requestFusion = bVar2.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        a();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar2;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.internal.queue.b(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }
    }

    public v(p<T> pVar, o<? super T, ? extends p<? extends R>> oVar, ErrorMode errorMode, int i10, int i11) {
        super(pVar);
        this.f29070b = oVar;
        this.f29071c = errorMode;
        this.f29072d = i10;
        this.f29073e = i11;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f29070b, this.f29072d, this.f29073e, this.f29071c));
    }
}
