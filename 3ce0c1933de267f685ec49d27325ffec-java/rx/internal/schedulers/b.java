package rx.internal.schedulers;

import dq.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.f;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.i;
import rx.j;
/* compiled from: EventLoopsScheduler.java */
/* loaded from: classes3.dex */
public final class b extends f implements f {

    /* renamed from: c  reason: collision with root package name */
    static final int f34029c;

    /* renamed from: d  reason: collision with root package name */
    static final c f34030d;

    /* renamed from: e  reason: collision with root package name */
    static final C0484b f34031e;

    /* renamed from: a  reason: collision with root package name */
    final ThreadFactory f34032a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<C0484b> f34033b = new AtomicReference<>(f34031e);

    /* compiled from: EventLoopsScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        private final i f34034a;

        /* renamed from: b  reason: collision with root package name */
        private final dq.b f34035b;

        /* renamed from: c  reason: collision with root package name */
        private final i f34036c;

        /* renamed from: d  reason: collision with root package name */
        private final c f34037d;

        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: rx.internal.schedulers.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0482a implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ yp.a f34038a;

            C0482a(yp.a aVar) {
                this.f34038a = aVar;
            }

            @Override // yp.a
            public void call() {
                if (!a.this.isUnsubscribed()) {
                    this.f34038a.call();
                }
            }
        }

        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: rx.internal.schedulers.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0483b implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ yp.a f34040a;

            C0483b(yp.a aVar) {
                this.f34040a = aVar;
            }

            @Override // yp.a
            public void call() {
                if (!a.this.isUnsubscribed()) {
                    this.f34040a.call();
                }
            }
        }

        a(c cVar) {
            i iVar = new i();
            this.f34034a = iVar;
            dq.b bVar = new dq.b();
            this.f34035b = bVar;
            this.f34036c = new i(iVar, bVar);
            this.f34037d = cVar;
        }

        @Override // rx.f.a
        public j b(yp.a aVar) {
            if (isUnsubscribed()) {
                return e.c();
            }
            return this.f34037d.k(new C0482a(aVar), 0L, null, this.f34034a);
        }

        @Override // rx.f.a
        public j c(yp.a aVar, long j10, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return e.c();
            }
            return this.f34037d.j(new C0483b(aVar), j10, timeUnit, this.f34035b);
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return this.f34036c.isUnsubscribed();
        }

        @Override // rx.j
        public void unsubscribe() {
            this.f34036c.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0484b {

        /* renamed from: a  reason: collision with root package name */
        final int f34042a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f34043b;

        /* renamed from: c  reason: collision with root package name */
        long f34044c;

        C0484b(ThreadFactory threadFactory, int i10) {
            this.f34042a = i10;
            this.f34043b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f34043b[i11] = new c(threadFactory);
            }
        }

        public c a() {
            int i10 = this.f34042a;
            if (i10 == 0) {
                return b.f34030d;
            }
            c[] cVarArr = this.f34043b;
            long j10 = this.f34044c;
            this.f34044c = 1 + j10;
            return cVarArr[(int) (j10 % i10)];
        }

        public void b() {
            for (c cVar : this.f34043b) {
                cVar.unsubscribe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: EventLoopsScheduler.java */
    /* loaded from: classes3.dex */
    public static final class c extends d {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f34029c = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f34030d = cVar;
        cVar.unsubscribe();
        f34031e = new C0484b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f34032a = threadFactory;
        d();
    }

    @Override // rx.f
    public f.a a() {
        return new a(this.f34033b.get().a());
    }

    public j c(yp.a aVar) {
        return this.f34033b.get().a().i(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    public void d() {
        C0484b bVar = new C0484b(this.f34032a, f34029c);
        if (!this.f34033b.compareAndSet(f34031e, bVar)) {
            bVar.b();
        }
    }

    @Override // rx.internal.schedulers.f
    public void shutdown() {
        C0484b bVar;
        C0484b bVar2;
        do {
            bVar = this.f34033b.get();
            bVar2 = f34031e;
            if (bVar == bVar2) {
                return;
            }
        } while (!this.f34033b.compareAndSet(bVar, bVar2));
        bVar.b();
    }
}
