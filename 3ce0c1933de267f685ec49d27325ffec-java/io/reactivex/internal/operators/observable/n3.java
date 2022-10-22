package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import xn.b;
/* compiled from: ObservableTakeLastTimed.java */
/* loaded from: classes3.dex */
public final class n3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f28871b;

    /* renamed from: c  reason: collision with root package name */
    final long f28872c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f28873d;

    /* renamed from: e  reason: collision with root package name */
    final s f28874e;

    /* renamed from: f  reason: collision with root package name */
    final int f28875f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f28876g;

    /* compiled from: ObservableTakeLastTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicBoolean implements r<T>, b {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final r<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.b<Object> queue;
        final s scheduler;
        final long time;
        final TimeUnit unit;
        b upstream;

        a(r<? super T> rVar, long j10, long j11, TimeUnit timeUnit, s sVar, int i10, boolean z10) {
            this.downstream = rVar;
            this.count = j10;
            this.time = j11;
            this.unit = timeUnit;
            this.scheduler = sVar;
            this.queue = new io.reactivex.internal.queue.b<>(i10);
            this.delayError = z10;
        }

        void a() {
            Throwable th2;
            if (compareAndSet(false, true)) {
                r<? super T> rVar = this.downstream;
                io.reactivex.internal.queue.b<Object> bVar = this.queue;
                boolean z10 = this.delayError;
                while (!this.cancelled) {
                    if (z10 || (th2 = this.error) == null) {
                        Object poll = bVar.poll();
                        if (poll == null) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                rVar.onError(th3);
                                return;
                            } else {
                                rVar.onComplete();
                                return;
                            }
                        } else {
                            Object poll2 = bVar.poll();
                            if (((Long) poll).longValue() >= this.scheduler.b(this.unit) - this.time) {
                                rVar.onNext(poll2);
                            }
                        }
                    } else {
                        bVar.clear();
                        rVar.onError(th2);
                        return;
                    }
                }
                bVar.clear();
            }
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                if (compareAndSet(false, true)) {
                    this.queue.clear();
                }
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.error = th2;
            a();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            io.reactivex.internal.queue.b<Object> bVar = this.queue;
            long b10 = this.scheduler.b(this.unit);
            long j10 = this.time;
            long j11 = this.count;
            boolean z10 = j11 == Long.MAX_VALUE;
            bVar.l(Long.valueOf(b10), t10);
            while (!bVar.isEmpty()) {
                if (((Long) bVar.m()).longValue() <= b10 - j10 || (!z10 && (bVar.o() >> 1) > j11)) {
                    bVar.poll();
                    bVar.poll();
                } else {
                    return;
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public n3(p<T> pVar, long j10, long j11, TimeUnit timeUnit, s sVar, int i10, boolean z10) {
        super(pVar);
        this.f28871b = j10;
        this.f28872c = j11;
        this.f28873d = timeUnit;
        this.f28874e = sVar;
        this.f28875f = i10;
        this.f28876g = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28871b, this.f28872c, this.f28873d, this.f28874e, this.f28875f, this.f28876g));
    }
}
