package rx.internal.schedulers;

import dq.e;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.f;
import rx.j;
/* compiled from: TrampolineScheduler.java */
/* loaded from: classes3.dex */
public final class h extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final h f34068a = new h();

    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    static final class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        final AtomicInteger f34069a = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        final PriorityBlockingQueue<b> f34070b = new PriorityBlockingQueue<>();

        /* renamed from: c  reason: collision with root package name */
        private final dq.a f34071c = new dq.a();

        /* renamed from: d  reason: collision with root package name */
        private final AtomicInteger f34072d = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: TrampolineScheduler.java */
        /* renamed from: rx.internal.schedulers.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0485a implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f34073a;

            C0485a(b bVar) {
                this.f34073a = bVar;
            }

            @Override // yp.a
            public void call() {
                a.this.f34070b.remove(this.f34073a);
            }
        }

        a() {
        }

        private j e(yp.a aVar, long j10) {
            if (this.f34071c.isUnsubscribed()) {
                return e.c();
            }
            b bVar = new b(aVar, Long.valueOf(j10), this.f34069a.incrementAndGet());
            this.f34070b.add(bVar);
            if (this.f34072d.getAndIncrement() != 0) {
                return e.a(new C0485a(bVar));
            }
            do {
                b poll = this.f34070b.poll();
                if (poll != null) {
                    poll.f34075a.call();
                }
            } while (this.f34072d.decrementAndGet() > 0);
            return e.c();
        }

        @Override // rx.f.a
        public j b(yp.a aVar) {
            return e(aVar, a());
        }

        @Override // rx.f.a
        public j c(yp.a aVar, long j10, TimeUnit timeUnit) {
            long a10 = a() + timeUnit.toMillis(j10);
            return e(new g(aVar, this, a10), a10);
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return this.f34071c.isUnsubscribed();
        }

        @Override // rx.j
        public void unsubscribe() {
            this.f34071c.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TrampolineScheduler.java */
    /* loaded from: classes3.dex */
    public static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final yp.a f34075a;

        /* renamed from: b  reason: collision with root package name */
        final Long f34076b;

        /* renamed from: c  reason: collision with root package name */
        final int f34077c;

        b(yp.a aVar, Long l10, int i10) {
            this.f34075a = aVar;
            this.f34076b = l10;
            this.f34077c = i10;
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            int compareTo = this.f34076b.compareTo(bVar.f34076b);
            return compareTo == 0 ? h.c(this.f34077c, bVar.f34077c) : compareTo;
        }
    }

    private h() {
    }

    static int c(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 == i11 ? 0 : 1;
    }

    @Override // rx.f
    public f.a a() {
        return new a();
    }
}
