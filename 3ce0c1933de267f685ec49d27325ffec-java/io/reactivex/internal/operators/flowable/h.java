package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import vp.b;
import vp.c;
/* compiled from: FlowableOnBackpressureLatest.java */
/* loaded from: classes2.dex */
public final class h<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* compiled from: FlowableOnBackpressureLatest.java */
    /* loaded from: classes2.dex */
    static final class a<T> extends AtomicInteger implements f<T>, c {
        private static final long serialVersionUID = 163080509307634843L;
        volatile boolean cancelled;
        volatile boolean done;
        final b<? super T> downstream;
        Throwable error;
        c upstream;
        final AtomicLong requested = new AtomicLong();
        final AtomicReference<T> current = new AtomicReference<>();

        a(b<? super T> bVar) {
            this.downstream = bVar;
        }

        boolean a(boolean z10, boolean z11, b<?> bVar, AtomicReference<T> atomicReference) {
            if (this.cancelled) {
                atomicReference.lazySet(null);
                return true;
            } else if (!z10) {
                return false;
            } else {
                Throwable th2 = this.error;
                if (th2 != null) {
                    atomicReference.lazySet(null);
                    bVar.onError(th2);
                    return true;
                } else if (!z11) {
                    return false;
                } else {
                    bVar.onComplete();
                    return true;
                }
            }
        }

        void b() {
            boolean z10;
            if (getAndIncrement() == 0) {
                b<? super T> bVar = this.downstream;
                AtomicLong atomicLong = this.requested;
                AtomicReference<T> atomicReference = this.current;
                int i10 = 1;
                do {
                    long j10 = 0;
                    while (true) {
                        z10 = false;
                        if (j10 == atomicLong.get()) {
                            break;
                        }
                        boolean z11 = this.done;
                        Object obj = (T) atomicReference.getAndSet(null);
                        boolean z12 = obj == null;
                        if (!a(z11, z12, bVar, atomicReference)) {
                            if (z12) {
                                break;
                            }
                            bVar.onNext(obj);
                            j10++;
                        } else {
                            return;
                        }
                    }
                    if (j10 == atomicLong.get()) {
                        boolean z13 = this.done;
                        if (atomicReference.get() == null) {
                            z10 = true;
                        }
                        if (a(z13, z10, bVar, atomicReference)) {
                            return;
                        }
                    }
                    if (j10 != 0) {
                        io.reactivex.internal.util.b.c(atomicLong, j10);
                    }
                    i10 = addAndGet(-i10);
                } while (i10 != 0);
            }
        }

        @Override // vp.c
        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                if (getAndIncrement() == 0) {
                    this.current.lazySet(null);
                }
            }
        }

        @Override // vp.b
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // vp.b
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            b();
        }

        @Override // vp.b
        public void onNext(T t10) {
            this.current.lazySet(t10);
            b();
        }

        @Override // vp.b
        public void onSubscribe(c cVar) {
            if (SubscriptionHelper.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // vp.c
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this.requested, j10);
                b();
            }
        }
    }

    public h(e<T> eVar) {
        super(eVar);
    }

    @Override // io.reactivex.e
    protected void h(b<? super T> bVar) {
        this.f28379b.g(new a(bVar));
    }
}
