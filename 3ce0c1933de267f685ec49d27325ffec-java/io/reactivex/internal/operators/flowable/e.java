package io.reactivex.internal.operators.flowable;

import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.f;
import io.reactivex.internal.queue.SpscArrayQueue;
import io.reactivex.internal.subscriptions.BasicIntQueueSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import vp.b;
import vp.c;
/* compiled from: FlowableOnBackpressureBuffer.java */
/* loaded from: classes2.dex */
public final class e<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final int f28384c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f28385d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f28386e;

    /* renamed from: f  reason: collision with root package name */
    final zn.a f28387f;

    /* compiled from: FlowableOnBackpressureBuffer.java */
    /* loaded from: classes2.dex */
    static final class a<T> extends BasicIntQueueSubscription<T> implements f<T> {
        private static final long serialVersionUID = -2514538129242366402L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final b<? super T> downstream;
        Throwable error;
        final zn.a onOverflow;
        boolean outputFused;
        final co.f<T> queue;
        final AtomicLong requested = new AtomicLong();
        c upstream;

        a(b<? super T> bVar, int i10, boolean z10, boolean z11, zn.a aVar) {
            co.f<T> fVar;
            this.downstream = bVar;
            this.onOverflow = aVar;
            this.delayError = z11;
            if (z10) {
                fVar = new io.reactivex.internal.queue.b<>(i10);
            } else {
                fVar = new SpscArrayQueue<>(i10);
            }
            this.queue = fVar;
        }

        boolean b(boolean z10, boolean z11, b<? super T> bVar) {
            if (this.cancelled) {
                this.queue.clear();
                return true;
            } else if (!z10) {
                return false;
            } else {
                if (!this.delayError) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        this.queue.clear();
                        bVar.onError(th2);
                        return true;
                    } else if (!z11) {
                        return false;
                    } else {
                        bVar.onComplete();
                        return true;
                    }
                } else if (!z11) {
                    return false;
                } else {
                    Throwable th3 = this.error;
                    if (th3 != null) {
                        bVar.onError(th3);
                    } else {
                        bVar.onComplete();
                    }
                    return true;
                }
            }
        }

        void c() {
            int i10;
            if (getAndIncrement() == 0) {
                co.f<T> fVar = this.queue;
                b<? super T> bVar = this.downstream;
                int i11 = 1;
                while (!b(this.done, fVar.isEmpty(), bVar)) {
                    long j10 = this.requested.get();
                    long j11 = 0;
                    while (true) {
                        i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                        if (i10 == 0) {
                            break;
                        }
                        boolean z10 = this.done;
                        Object obj = (T) fVar.poll();
                        boolean z11 = obj == null;
                        if (!b(z10, z11, bVar)) {
                            if (z11) {
                                break;
                            }
                            bVar.onNext(obj);
                            j11++;
                        } else {
                            return;
                        }
                    }
                    if (i10 != 0 || !b(this.done, fVar.isEmpty(), bVar)) {
                        if (!(j11 == 0 || j10 == Long.MAX_VALUE)) {
                            this.requested.addAndGet(-j11);
                        }
                        i11 = addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vp.c
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.g
        public void clear() {
            this.queue.clear();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.g
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // vp.b
        public void onComplete() {
            this.done = true;
            if (this.outputFused) {
                this.downstream.onComplete();
            } else {
                c();
            }
        }

        @Override // vp.b
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            if (this.outputFused) {
                this.downstream.onError(th2);
            } else {
                c();
            }
        }

        @Override // vp.b
        public void onNext(T t10) {
            if (!this.queue.offer(t10)) {
                this.upstream.cancel();
                MissingBackpressureException missingBackpressureException = new MissingBackpressureException("Buffer is full");
                try {
                    this.onOverflow.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    missingBackpressureException.initCause(th2);
                }
                onError(missingBackpressureException);
            } else if (this.outputFused) {
                this.downstream.onNext(null);
            } else {
                c();
            }
        }

        @Override // vp.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.g
        public T poll() throws Exception {
            return this.queue.poll();
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, vp.c
        public void request(long j10) {
            if (!this.outputFused && SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                c();
            }
        }

        @Override // io.reactivex.internal.subscriptions.BasicIntQueueSubscription, co.c
        public int requestFusion(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }
    }

    public e(io.reactivex.e<T> eVar, int i10, boolean z10, boolean z11, zn.a aVar) {
        super(eVar);
        this.f28384c = i10;
        this.f28385d = z10;
        this.f28386e = z11;
        this.f28387f = aVar;
    }

    @Override // io.reactivex.e
    protected void h(b<? super T> bVar) {
        this.f28379b.g(new a(bVar, this.f28384c, this.f28385d, this.f28386e, this.f28387f));
    }
}
