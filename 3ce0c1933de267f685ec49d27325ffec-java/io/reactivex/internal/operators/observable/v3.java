package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.util.f;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableTimeoutTimed.java */
/* loaded from: classes3.dex */
public final class v3<T> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f29093b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f29094c;

    /* renamed from: d  reason: collision with root package name */
    final s f29095d;

    /* renamed from: e  reason: collision with root package name */
    final p<? extends T> f29096e;

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements r<T> {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f29097a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<xn.b> f29098b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(r<? super T> rVar, AtomicReference<xn.b> atomicReference) {
            this.f29097a = rVar;
            this.f29098b = atomicReference;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f29097a.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29097a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f29097a.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.replace(this.f29098b, bVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicReference<xn.b> implements r<T>, xn.b, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final r<? super T> downstream;
        p<? extends T> fallback;
        final long timeout;
        final TimeUnit unit;
        final s.c worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicLong index = new AtomicLong();
        final AtomicReference<xn.b> upstream = new AtomicReference<>();

        b(r<? super T> rVar, long j10, TimeUnit timeUnit, s.c cVar, p<? extends T> pVar) {
            this.downstream = rVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
            this.fallback = pVar;
        }

        @Override // io.reactivex.internal.operators.observable.v3.d
        public void a(long j10) {
            if (this.index.compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                p<? extends T> pVar = this.fallback;
                this.fallback = null;
                pVar.subscribe(new a(this.downstream, this));
                this.worker.dispose();
            }
        }

        void c(long j10) {
            this.task.replace(this.worker.c(new e(j10, this), this.timeout, this.unit));
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            DisposableHelper.dispose(this);
            this.worker.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th2);
                this.worker.dispose();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            long j10 = this.index.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (this.index.compareAndSet(j10, j11)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t10);
                    c(j11);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends AtomicLong implements r<T>, xn.b, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final r<? super T> downstream;
        final long timeout;
        final TimeUnit unit;
        final s.c worker;
        final SequentialDisposable task = new SequentialDisposable();
        final AtomicReference<xn.b> upstream = new AtomicReference<>();

        c(r<? super T> rVar, long j10, TimeUnit timeUnit, s.c cVar) {
            this.downstream = rVar;
            this.timeout = j10;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        @Override // io.reactivex.internal.operators.observable.v3.d
        public void a(long j10) {
            if (compareAndSet(j10, Long.MAX_VALUE)) {
                DisposableHelper.dispose(this.upstream);
                this.downstream.onError(new TimeoutException(f.c(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        void c(long j10) {
            this.task.replace(this.worker.c(new e(j10, this), this.timeout, this.unit));
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            this.worker.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th2);
                this.worker.dispose();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            long j10 = get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = 1 + j10;
                if (compareAndSet(j10, j11)) {
                    this.task.get().dispose();
                    this.downstream.onNext(t10);
                    c(j11);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    public interface d {
        void a(long j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableTimeoutTimed.java */
    /* loaded from: classes3.dex */
    public static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final d f29099a;

        /* renamed from: b  reason: collision with root package name */
        final long f29100b;

        e(long j10, d dVar) {
            this.f29100b = j10;
            this.f29099a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f29099a.a(this.f29100b);
        }
    }

    public v3(k<T> kVar, long j10, TimeUnit timeUnit, s sVar, p<? extends T> pVar) {
        super(kVar);
        this.f29093b = j10;
        this.f29094c = timeUnit;
        this.f29095d = sVar;
        this.f29096e = pVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        if (this.f29096e == null) {
            c cVar = new c(rVar, this.f29093b, this.f29094c, this.f29095d.a());
            rVar.onSubscribe(cVar);
            cVar.c(0L);
            this.f28426a.subscribe(cVar);
            return;
        }
        b bVar = new b(rVar, this.f29093b, this.f29094c, this.f29095d.a(), this.f29096e);
        rVar.onSubscribe(bVar);
        bVar.c(0L);
        this.f28426a.subscribe(bVar);
    }
}
