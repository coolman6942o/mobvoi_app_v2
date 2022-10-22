package io.reactivex.internal.operators.flowable;

import io.reactivex.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import vp.b;
import vp.c;
import zn.g;
/* compiled from: FlowableOnBackpressureDrop.java */
/* loaded from: classes2.dex */
public final class f<T> extends io.reactivex.internal.operators.flowable.a<T, T> implements g<T> {

    /* renamed from: c  reason: collision with root package name */
    final g<? super T> f28388c = this;

    /* compiled from: FlowableOnBackpressureDrop.java */
    /* loaded from: classes2.dex */
    static final class a<T> extends AtomicLong implements io.reactivex.f<T>, c {
        private static final long serialVersionUID = -6246093802440953054L;
        boolean done;
        final b<? super T> downstream;
        final g<? super T> onDrop;
        c upstream;

        a(b<? super T> bVar, g<? super T> gVar) {
            this.downstream = bVar;
            this.onDrop = gVar;
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
                try {
                    this.onDrop.accept(t10);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    cancel();
                    onError(th2);
                }
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

    public f(e<T> eVar) {
        super(eVar);
    }

    @Override // zn.g
    public void accept(T t10) {
    }

    @Override // io.reactivex.e
    protected void h(b<? super T> bVar) {
        this.f28379b.g(new a(bVar, this.f28388c));
    }
}
