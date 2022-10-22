package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TrampolineScheduler.java */
/* loaded from: classes3.dex */
public final class j extends s {

    /* renamed from: b  reason: collision with root package name */
    private static final j f29236b = new j();

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f29237a;

        /* renamed from: b  reason: collision with root package name */
        private final c f29238b;

        /* renamed from: c  reason: collision with root package name */
        private final long f29239c;

        a(Runnable runnable, c cVar, long j10) {
            this.f29237a = runnable;
            this.f29238b = cVar;
            this.f29239c = j10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f29238b.f29247d) {
                long a10 = this.f29238b.a(TimeUnit.MILLISECONDS);
                long j10 = this.f29239c;
                if (j10 > a10) {
                    try {
                        Thread.sleep(j10 - a10);
                    } catch (InterruptedException e10) {
                        Thread.currentThread().interrupt();
                        fo.a.s(e10);
                        return;
                    }
                }
                if (!this.f29238b.f29247d) {
                    this.f29237a.run();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f29240a;

        /* renamed from: b  reason: collision with root package name */
        final long f29241b;

        /* renamed from: c  reason: collision with root package name */
        final int f29242c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f29243d;

        b(Runnable runnable, Long l10, int i10) {
            this.f29240a = runnable;
            this.f29241b = l10.longValue();
            this.f29242c = i10;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int b10 = bo.b.b(this.f29241b, bVar.f29241b);
            return b10 == 0 ? bo.b.a(this.f29242c, bVar.f29242c) : b10;
        }
    }

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    static final class c extends s.c {

        /* renamed from: a  reason: collision with root package name */
        final PriorityBlockingQueue<b> f29244a = new PriorityBlockingQueue<>();

        /* renamed from: b  reason: collision with root package name */
        private final AtomicInteger f29245b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f29246c = new AtomicInteger();

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f29247d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* loaded from: classes3.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final b f29248a;

            a(b bVar) {
                this.f29248a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f29248a.f29243d = true;
                c.this.f29244a.remove(this.f29248a);
            }
        }

        c() {
        }

        @Override // io.reactivex.s.c
        public xn.b b(Runnable runnable) {
            return e(runnable, a(TimeUnit.MILLISECONDS));
        }

        @Override // io.reactivex.s.c
        public xn.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            long a10 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j10);
            return e(new a(runnable, this, a10), a10);
        }

        @Override // xn.b
        public void dispose() {
            this.f29247d = true;
        }

        xn.b e(Runnable runnable, long j10) {
            if (this.f29247d) {
                return EmptyDisposable.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j10), this.f29246c.incrementAndGet());
            this.f29244a.add(bVar);
            if (this.f29245b.getAndIncrement() != 0) {
                return xn.c.b(new a(bVar));
            }
            int i10 = 1;
            while (!this.f29247d) {
                b poll = this.f29244a.poll();
                if (poll == null) {
                    i10 = this.f29245b.addAndGet(-i10);
                    if (i10 == 0) {
                        return EmptyDisposable.INSTANCE;
                    }
                } else if (!poll.f29243d) {
                    poll.f29240a.run();
                }
            }
            this.f29244a.clear();
            return EmptyDisposable.INSTANCE;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29247d;
        }
    }

    j() {
    }

    public static j f() {
        return f29236b;
    }

    @Override // io.reactivex.s
    public s.c a() {
        return new c();
    }

    @Override // io.reactivex.s
    public xn.b c(Runnable runnable) {
        fo.a.u(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    @Override // io.reactivex.s
    public xn.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j10);
            fo.a.u(runnable).run();
        } catch (InterruptedException e10) {
            Thread.currentThread().interrupt();
            fo.a.s(e10);
        }
        return EmptyDisposable.INSTANCE;
    }
}
