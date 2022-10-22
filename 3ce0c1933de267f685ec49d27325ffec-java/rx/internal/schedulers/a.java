package rx.internal.schedulers;

import dq.e;
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
import rx.f;
import rx.internal.util.RxThreadFactory;
import rx.j;
/* compiled from: CachedThreadScheduler.java */
/* loaded from: classes3.dex */
public final class a extends f implements f {

    /* renamed from: e  reason: collision with root package name */
    static final c f34010e;

    /* renamed from: f  reason: collision with root package name */
    static final C0479a f34011f;

    /* renamed from: a  reason: collision with root package name */
    final ThreadFactory f34012a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<C0479a> f34013b = new AtomicReference<>(f34011f);

    /* renamed from: d  reason: collision with root package name */
    private static final TimeUnit f34009d = TimeUnit.SECONDS;

    /* renamed from: c  reason: collision with root package name */
    private static final long f34008c = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedThreadScheduler.java */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0479a {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadFactory f34014a;

        /* renamed from: b  reason: collision with root package name */
        private final long f34015b;

        /* renamed from: c  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f34016c;

        /* renamed from: d  reason: collision with root package name */
        private final dq.b f34017d;

        /* renamed from: e  reason: collision with root package name */
        private final ScheduledExecutorService f34018e;

        /* renamed from: f  reason: collision with root package name */
        private final Future<?> f34019f;

        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.internal.schedulers.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class ThreadFactoryC0480a implements ThreadFactory {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ThreadFactory f34020a;

            ThreadFactoryC0480a(C0479a aVar, ThreadFactory threadFactory) {
                this.f34020a = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f34020a.newThread(runnable);
                newThread.setName(newThread.getName() + " (Evictor)");
                return newThread;
            }
        }

        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.internal.schedulers.a$a$b */
        /* loaded from: classes3.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0479a.this.a();
            }
        }

        C0479a(ThreadFactory threadFactory, long j10, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f34014a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j10) : 0L;
            this.f34015b = nanos;
            this.f34016c = new ConcurrentLinkedQueue<>();
            this.f34017d = new dq.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC0480a(this, threadFactory));
                d.l(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new b(), nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f34018e = scheduledExecutorService;
            this.f34019f = scheduledFuture;
        }

        void a() {
            if (!this.f34016c.isEmpty()) {
                long c10 = c();
                Iterator<c> it = this.f34016c.iterator();
                while (it.hasNext()) {
                    c next = it.next();
                    if (next.m() > c10) {
                        return;
                    }
                    if (this.f34016c.remove(next)) {
                        this.f34017d.c(next);
                    }
                }
            }
        }

        c b() {
            if (this.f34017d.isUnsubscribed()) {
                return a.f34010e;
            }
            while (!this.f34016c.isEmpty()) {
                c poll = this.f34016c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f34014a);
            this.f34017d.a(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.n(c() + this.f34015b);
            this.f34016c.offer(cVar);
        }

        void e() {
            try {
                Future<?> future = this.f34019f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.f34018e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.f34017d.unsubscribe();
            }
        }
    }

    /* compiled from: CachedThreadScheduler.java */
    /* loaded from: classes3.dex */
    static final class b extends f.a implements yp.a {

        /* renamed from: b  reason: collision with root package name */
        private final C0479a f34023b;

        /* renamed from: c  reason: collision with root package name */
        private final c f34024c;

        /* renamed from: a  reason: collision with root package name */
        private final dq.b f34022a = new dq.b();

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f34025d = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.internal.schedulers.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0481a implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ yp.a f34026a;

            C0481a(yp.a aVar) {
                this.f34026a = aVar;
            }

            @Override // yp.a
            public void call() {
                if (!b.this.isUnsubscribed()) {
                    this.f34026a.call();
                }
            }
        }

        b(C0479a aVar) {
            this.f34023b = aVar;
            this.f34024c = aVar.b();
        }

        @Override // rx.f.a
        public j b(yp.a aVar) {
            return c(aVar, 0L, null);
        }

        @Override // rx.f.a
        public j c(yp.a aVar, long j10, TimeUnit timeUnit) {
            if (this.f34022a.isUnsubscribed()) {
                return e.c();
            }
            ScheduledAction i10 = this.f34024c.i(new C0481a(aVar), j10, timeUnit);
            this.f34022a.a(i10);
            i10.addParent(this.f34022a);
            return i10;
        }

        @Override // yp.a
        public void call() {
            this.f34023b.d(this.f34024c);
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return this.f34022a.isUnsubscribed();
        }

        @Override // rx.j
        public void unsubscribe() {
            if (this.f34025d.compareAndSet(false, true)) {
                this.f34024c.b(this);
            }
            this.f34022a.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedThreadScheduler.java */
    /* loaded from: classes3.dex */
    public static final class c extends d {

        /* renamed from: i  reason: collision with root package name */
        private long f34028i = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }

        public long m() {
            return this.f34028i;
        }

        public void n(long j10) {
            this.f34028i = j10;
        }
    }

    static {
        c cVar = new c(RxThreadFactory.NONE);
        f34010e = cVar;
        cVar.unsubscribe();
        C0479a aVar = new C0479a(null, 0L, null);
        f34011f = aVar;
        aVar.e();
    }

    public a(ThreadFactory threadFactory) {
        this.f34012a = threadFactory;
        c();
    }

    @Override // rx.f
    public f.a a() {
        return new b(this.f34013b.get());
    }

    public void c() {
        C0479a aVar = new C0479a(this.f34012a, f34008c, f34009d);
        if (!this.f34013b.compareAndSet(f34011f, aVar)) {
            aVar.e();
        }
    }

    @Override // rx.internal.schedulers.f
    public void shutdown() {
        C0479a aVar;
        C0479a aVar2;
        do {
            aVar = this.f34013b.get();
            aVar2 = f34011f;
            if (aVar == aVar2) {
                return;
            }
        } while (!this.f34013b.compareAndSet(aVar, aVar2));
        aVar.e();
    }
}
