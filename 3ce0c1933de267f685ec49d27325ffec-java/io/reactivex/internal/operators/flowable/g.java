package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.f;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import vp.b;
import vp.c;
/* compiled from: FlowableOnBackpressureError.java */
/* loaded from: classes2.dex */
public final class g<T> extends io.reactivex.internal.operators.flowable.a<T, T> {

    /* compiled from: FlowableOnBackpressureError.java */
    /* loaded from: classes2.dex */
    static final class a<T> extends AtomicLong implements f<T>, c {
        private static final long serialVersionUID = -3176480756392482682L;
        boolean done;
        final b<? super T> downstream;
        c upstream;

        a(b<? super T> bVar) {
            this.downstream = bVar;
        }

        @Override // vp.c
        public void cancel() {
            this.upstream.cancel();
        }

        @Override // vp.b
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }

        @Override // vp.b
        public void onError(Throwable th2) {
            if (this.done) {
                fo.a.s(th2);
                return;
            }
            this.done = true;
            this.downstream.onError(th2);
        }

        @Override // vp.b
        public void onNext(T t10) {
            if (!this.done) {
                if (get() != 0) {
                    this.downstream.onNext(t10);
                    io.reactivex.internal.util.b.c(this, 1L);
                    return;
                }
                onError(new MissingBackpressureException("could not emit value due to lack of requests"));
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

        @Override // vp.c
        public void request(long j10) {
            if (SubscriptionHelper.validate(j10)) {
                io.reactivex.internal.util.b.a(this, j10);
            }
        }
    }

    public g(e<T> eVar) {
        super(eVar);
    }

    @Override // io.reactivex.e
    protected void h(b<? super T> bVar) {
        this.f28379b.g(new a(bVar));
    }
}
