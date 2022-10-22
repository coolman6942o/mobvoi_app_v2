package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import xn.b;
/* compiled from: ObservableSkipLastTimed.java */
/* loaded from: classes3.dex */
public final class e3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f28570b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f28571c;

    /* renamed from: d  reason: collision with root package name */
    final s f28572d;

    /* renamed from: e  reason: collision with root package name */
    final int f28573e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f28574f;

    /* compiled from: ObservableSkipLastTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements r<T>, b {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final r<? super T> downstream;
        Throwable error;
        final io.reactivex.internal.queue.b<Object> queue;
        final s scheduler;
        final long time;
        final TimeUnit unit;
        b upstream;

        a(r<? super T> rVar, long j10, TimeUnit timeUnit, s sVar, int i10, boolean z10) {
            this.downstream = rVar;
            this.time = j10;
            this.unit = timeUnit;
            this.scheduler = sVar;
            this.queue = new io.reactivex.internal.queue.b<>(i10);
            this.delayError = z10;
        }

        void a() {
            if (getAndIncrement() == 0) {
                r<? super T> rVar = this.downstream;
                io.reactivex.internal.queue.b<Object> bVar = this.queue;
                boolean z10 = this.delayError;
                TimeUnit timeUnit = this.unit;
                s sVar = this.scheduler;
                long j10 = this.time;
                int i10 = 1;
                while (!this.cancelled) {
                    boolean z11 = this.done;
                    Long l10 = (Long) bVar.m();
                    boolean z12 = l10 == null;
                    long b10 = sVar.b(timeUnit);
                    if (!z12 && l10.longValue() > b10 - j10) {
                        z12 = true;
                    }
                    if (z11) {
                        if (!z10) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                this.queue.clear();
                                rVar.onError(th2);
                                return;
                            } else if (z12) {
                                rVar.onComplete();
                                return;
                            }
                        } else if (z12) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                rVar.onError(th3);
                                return;
                            } else {
                                rVar.onComplete();
                                return;
                            }
                        }
                    }
                    if (z12) {
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        bVar.poll();
                        rVar.onNext(bVar.poll());
                    }
                }
                this.queue.clear();
            }
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                if (getAndIncrement() == 0) {
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
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.queue.l(Long.valueOf(this.scheduler.b(this.unit)), t10);
            a();
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public e3(p<T> pVar, long j10, TimeUnit timeUnit, s sVar, int i10, boolean z10) {
        super(pVar);
        this.f28570b = j10;
        this.f28571c = timeUnit;
        this.f28572d = sVar;
        this.f28573e = i10;
        this.f28574f = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(rVar, this.f28570b, this.f28571c, this.f28572d, this.f28573e, this.f28574f));
    }
}
