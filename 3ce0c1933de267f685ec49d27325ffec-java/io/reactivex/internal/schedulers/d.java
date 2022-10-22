package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: IoScheduler.java */
/* loaded from: classes3.dex */
public final class d extends s {

    /* renamed from: d  reason: collision with root package name */
    static final RxThreadFactory f29201d;

    /* renamed from: e  reason: collision with root package name */
    static final RxThreadFactory f29202e;

    /* renamed from: h  reason: collision with root package name */
    static final c f29205h;

    /* renamed from: i  reason: collision with root package name */
    static final a f29206i;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f29207b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<a> f29208c;

    /* renamed from: g  reason: collision with root package name */
    private static final TimeUnit f29204g = TimeUnit.SECONDS;

    /* renamed from: f  reason: collision with root package name */
    private static final long f29203f = Long.getLong("rx2.io-keep-alive-time", 60).longValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes3.dex */
    public static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final long f29209a;

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f29210b;

        /* renamed from: c  reason: collision with root package name */
        final xn.a f29211c;

        /* renamed from: d  reason: collision with root package name */
        private final ScheduledExecutorService f29212d;

        /* renamed from: e  reason: collision with root package name */
        private final Future<?> f29213e;

        /* renamed from: f  reason: collision with root package name */
        private final ThreadFactory f29214f;

        a(long j10, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            long nanos = timeUnit != null ? timeUnit.toNanos(j10) : 0L;
            this.f29209a = nanos;
            this.f29210b = new ConcurrentLinkedQueue<>();
            this.f29211c = new xn.a();
            this.f29214f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, d.f29202e);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f29212d = scheduledExecutorService;
            this.f29213e = scheduledFuture;
        }

        void a() {
            if (!this.f29210b.isEmpty()) {
                long c10 = c();
                Iterator<c> it = this.f29210b.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.i() > c10) {
                        return;
                    }
                    if (this.f29210b.remove(next)) {
                        this.f29211c.c(next);
                    }
                }
            }
        }

        c b() {
            if (this.f29211c.isDisposed()) {
                return d.f29205h;
            }
            while (!this.f29210b.isEmpty()) {
                c poll = this.f29210b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f29214f);
            this.f29211c.b(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.j(c() + this.f29209a);
            this.f29210b.offer(cVar);
        }

        void e() {
            this.f29211c.dispose();
            Future<?> future = this.f29213e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f29212d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }
    }

    /* compiled from: IoScheduler.java */
    /* loaded from: classes3.dex */
    static final class b extends s.c {

        /* renamed from: b  reason: collision with root package name */
        private final a f29216b;

        /* renamed from: c  reason: collision with root package name */
        private final c f29217c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f29218d = new AtomicBoolean();

        /* renamed from: a  reason: collision with root package name */
        private final xn.a f29215a = new xn.a();

        b(a aVar) {
            this.f29216b = aVar;
            this.f29217c = aVar.b();
        }

        @Override // io.reactivex.s.c
        public xn.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f29215a.isDisposed()) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f29217c.e(runnable, j10, timeUnit, this.f29215a);
        }

        @Override // xn.b
        public void dispose() {
            if (this.f29218d.compareAndSet(false, true)) {
                this.f29215a.dispose();
                this.f29216b.d(this.f29217c);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29218d.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IoScheduler.java */
    /* loaded from: classes3.dex */
    public static final class c extends f {

        /* renamed from: c  reason: collision with root package name */
        private long f29219c = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long i() {
            return this.f29219c;
        }

        public void j(long j10) {
            this.f29219c = j10;
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxCachedThreadSchedulerShutdown"));
        f29205h = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx2.io-priority", 5).intValue()));
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxCachedThreadScheduler", max);
        f29201d = rxThreadFactory;
        f29202e = new RxThreadFactory("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0L, null, rxThreadFactory);
        f29206i = aVar;
        aVar.e();
    }

    public d() {
        this(f29201d);
    }

    @Override // io.reactivex.s
    public s.c a() {
        return new b(this.f29208c.get());
    }

    public void f() {
        a aVar = new a(f29203f, f29204g, this.f29207b);
        if (!this.f29208c.compareAndSet(f29206i, aVar)) {
            aVar.e();
        }
    }

    public d(ThreadFactory threadFactory) {
        this.f29207b = threadFactory;
        this.f29208c = new AtomicReference<>(f29206i);
        f();
    }
}
