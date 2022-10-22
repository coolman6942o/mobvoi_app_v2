package io.reactivex;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.schedulers.f;
import java.util.concurrent.TimeUnit;
/* compiled from: Scheduler.java */
/* loaded from: classes2.dex */
public abstract class s {

    /* renamed from: a  reason: collision with root package name */
    static final long f29275a = TimeUnit.MINUTES.toNanos(Long.getLong("rx2.scheduler.drift-tolerance", 15).longValue());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Scheduler.java */
    /* loaded from: classes2.dex */
    public static final class a implements xn.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f29276a;

        /* renamed from: b  reason: collision with root package name */
        final c f29277b;

        /* renamed from: c  reason: collision with root package name */
        Thread f29278c;

        a(Runnable runnable, c cVar) {
            this.f29276a = runnable;
            this.f29277b = cVar;
        }

        @Override // xn.b
        public void dispose() {
            if (this.f29278c == Thread.currentThread()) {
                c cVar = this.f29277b;
                if (cVar instanceof f) {
                    ((f) cVar).h();
                    return;
                }
            }
            this.f29277b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29277b.isDisposed();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f29278c = Thread.currentThread();
            try {
                this.f29276a.run();
            } finally {
                dispose();
                this.f29278c = null;
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes2.dex */
    static final class b implements xn.b, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f29279a;

        /* renamed from: b  reason: collision with root package name */
        final c f29280b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f29281c;

        b(Runnable runnable, c cVar) {
            this.f29279a = runnable;
            this.f29280b = cVar;
        }

        @Override // xn.b
        public void dispose() {
            this.f29281c = true;
            this.f29280b.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29281c;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f29281c) {
                try {
                    this.f29279a.run();
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f29280b.dispose();
                    throw io.reactivex.internal.util.f.d(th2);
                }
            }
        }
    }

    /* compiled from: Scheduler.java */
    /* loaded from: classes2.dex */
    public static abstract class c implements xn.b {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Scheduler.java */
        /* loaded from: classes2.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final Runnable f29282a;

            /* renamed from: b  reason: collision with root package name */
            final SequentialDisposable f29283b;

            /* renamed from: c  reason: collision with root package name */
            final long f29284c;

            /* renamed from: d  reason: collision with root package name */
            long f29285d;

            /* renamed from: e  reason: collision with root package name */
            long f29286e;

            /* renamed from: f  reason: collision with root package name */
            long f29287f;

            a(long j10, Runnable runnable, long j11, SequentialDisposable sequentialDisposable, long j12) {
                this.f29282a = runnable;
                this.f29283b = sequentialDisposable;
                this.f29284c = j12;
                this.f29286e = j11;
                this.f29287f = j10;
            }

            @Override // java.lang.Runnable
            public void run() {
                long j10;
                this.f29282a.run();
                if (!this.f29283b.isDisposed()) {
                    c cVar = c.this;
                    TimeUnit timeUnit = TimeUnit.NANOSECONDS;
                    long a10 = cVar.a(timeUnit);
                    long j11 = s.f29275a;
                    long j12 = this.f29286e;
                    if (a10 + j11 >= j12) {
                        long j13 = this.f29284c;
                        if (a10 < j12 + j13 + j11) {
                            long j14 = this.f29287f;
                            long j15 = this.f29285d + 1;
                            this.f29285d = j15;
                            j10 = j14 + (j15 * j13);
                            this.f29286e = a10;
                            this.f29283b.replace(c.this.c(this, j10 - a10, timeUnit));
                        }
                    }
                    long j16 = this.f29284c;
                    long j17 = a10 + j16;
                    long j18 = this.f29285d + 1;
                    this.f29285d = j18;
                    this.f29287f = j17 - (j16 * j18);
                    j10 = j17;
                    this.f29286e = a10;
                    this.f29283b.replace(c.this.c(this, j10 - a10, timeUnit));
                }
            }
        }

        public long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        public xn.b b(Runnable runnable) {
            return c(runnable, 0L, TimeUnit.NANOSECONDS);
        }

        public abstract xn.b c(Runnable runnable, long j10, TimeUnit timeUnit);

        public xn.b d(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
            SequentialDisposable sequentialDisposable = new SequentialDisposable();
            SequentialDisposable sequentialDisposable2 = new SequentialDisposable(sequentialDisposable);
            Runnable u10 = fo.a.u(runnable);
            long nanos = timeUnit.toNanos(j11);
            long a10 = a(TimeUnit.NANOSECONDS);
            xn.b c10 = c(new a(a10 + timeUnit.toNanos(j10), u10, a10, sequentialDisposable2, nanos), j10, timeUnit);
            if (c10 == EmptyDisposable.INSTANCE) {
                return c10;
            }
            sequentialDisposable.replace(c10);
            return sequentialDisposable2;
        }
    }

    public abstract c a();

    public long b(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public xn.b c(Runnable runnable) {
        return d(runnable, 0L, TimeUnit.NANOSECONDS);
    }

    public xn.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        c a10 = a();
        a aVar = new a(fo.a.u(runnable), a10);
        a10.c(aVar, j10, timeUnit);
        return aVar;
    }

    public xn.b e(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        c a10 = a();
        b bVar = new b(fo.a.u(runnable), a10);
        xn.b d10 = a10.d(bVar, j10, j11, timeUnit);
        return d10 == EmptyDisposable.INSTANCE ? d10 : bVar;
    }
}
