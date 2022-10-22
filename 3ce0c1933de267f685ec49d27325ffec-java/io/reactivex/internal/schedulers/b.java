package io.reactivex.internal.schedulers;

import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.s;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ComputationScheduler.java */
/* loaded from: classes3.dex */
public final class b extends s {

    /* renamed from: d  reason: collision with root package name */
    static final C0347b f29181d;

    /* renamed from: e  reason: collision with root package name */
    static final RxThreadFactory f29182e;

    /* renamed from: f  reason: collision with root package name */
    static final int f29183f = f(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* renamed from: g  reason: collision with root package name */
    static final c f29184g;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f29185b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<C0347b> f29186c;

    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends s.c {

        /* renamed from: a  reason: collision with root package name */
        private final ao.b f29187a;

        /* renamed from: b  reason: collision with root package name */
        private final xn.a f29188b;

        /* renamed from: c  reason: collision with root package name */
        private final ao.b f29189c;

        /* renamed from: d  reason: collision with root package name */
        private final c f29190d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f29191e;

        a(c cVar) {
            this.f29190d = cVar;
            ao.b bVar = new ao.b();
            this.f29187a = bVar;
            xn.a aVar = new xn.a();
            this.f29188b = aVar;
            ao.b bVar2 = new ao.b();
            this.f29189c = bVar2;
            bVar2.b(bVar);
            bVar2.b(aVar);
        }

        @Override // io.reactivex.s.c
        public xn.b b(Runnable runnable) {
            if (this.f29191e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f29190d.e(runnable, 0L, TimeUnit.MILLISECONDS, this.f29187a);
        }

        @Override // io.reactivex.s.c
        public xn.b c(Runnable runnable, long j10, TimeUnit timeUnit) {
            if (this.f29191e) {
                return EmptyDisposable.INSTANCE;
            }
            return this.f29190d.e(runnable, j10, timeUnit, this.f29188b);
        }

        @Override // xn.b
        public void dispose() {
            if (!this.f29191e) {
                this.f29191e = true;
                this.f29189c.dispose();
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f29191e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* renamed from: io.reactivex.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0347b {

        /* renamed from: a  reason: collision with root package name */
        final int f29192a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f29193b;

        /* renamed from: c  reason: collision with root package name */
        long f29194c;

        C0347b(int i10, ThreadFactory threadFactory) {
            this.f29192a = i10;
            this.f29193b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f29193b[i11] = new c(threadFactory);
            }
        }

        public c a() {
            int i10 = this.f29192a;
            if (i10 == 0) {
                return b.f29184g;
            }
            c[] cVarArr = this.f29193b;
            long j10 = this.f29194c;
            this.f29194c = 1 + j10;
            return cVarArr[(int) (j10 % i10)];
        }

        public void b() {
            for (c cVar : this.f29193b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ComputationScheduler.java */
    /* loaded from: classes3.dex */
    public static final class c extends f {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new RxThreadFactory("RxComputationShutdown"));
        f29184g = cVar;
        cVar.dispose();
        RxThreadFactory rxThreadFactory = new RxThreadFactory("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f29182e = rxThreadFactory;
        C0347b bVar = new C0347b(0, rxThreadFactory);
        f29181d = bVar;
        bVar.b();
    }

    public b() {
        this(f29182e);
    }

    static int f(int i10, int i11) {
        return (i11 <= 0 || i11 > i10) ? i10 : i11;
    }

    @Override // io.reactivex.s
    public s.c a() {
        return new a(this.f29186c.get().a());
    }

    @Override // io.reactivex.s
    public xn.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        return this.f29186c.get().a().f(runnable, j10, timeUnit);
    }

    @Override // io.reactivex.s
    public xn.b e(Runnable runnable, long j10, long j11, TimeUnit timeUnit) {
        return this.f29186c.get().a().g(runnable, j10, j11, timeUnit);
    }

    public void g() {
        C0347b bVar = new C0347b(f29183f, this.f29185b);
        if (!this.f29186c.compareAndSet(f29181d, bVar)) {
            bVar.b();
        }
    }

    public b(ThreadFactory threadFactory) {
        this.f29185b = threadFactory;
        this.f29186c = new AtomicReference<>(f29181d);
        g();
    }
}
