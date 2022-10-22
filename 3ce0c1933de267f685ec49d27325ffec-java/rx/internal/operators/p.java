package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.c;
import rx.f;
import rx.i;
import yp.g;
/* compiled from: OnSubscribeRedo.java */
/* loaded from: classes3.dex */
public final class p<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.c<T> f33869a;

    /* renamed from: b  reason: collision with root package name */
    private final g<? super rx.c<? extends Notification<?>>, ? extends rx.c<?>> f33870b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f33871c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f33872d;

    /* renamed from: e  reason: collision with root package name */
    private final f f33873e;

    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    static class a implements g<rx.c<? extends Notification<?>>, rx.c<?>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeRedo.java */
        /* renamed from: rx.internal.operators.p$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0475a implements g<Notification<?>, Notification<?>> {
            C0475a(a aVar) {
            }

            /* renamed from: a */
            public Notification<?> call(Notification<?> notification) {
                return Notification.c(null);
            }
        }

        a() {
        }

        /* renamed from: a */
        public rx.c<?> call(rx.c<? extends Notification<?>> cVar) {
            return cVar.D(new C0475a(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    public class b implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i f33874a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.subjects.d f33875b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.internal.producers.a f33876c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicLong f33877d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ dq.d f33878e;

        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: classes3.dex */
        class a extends i<T> {

            /* renamed from: a  reason: collision with root package name */
            boolean f33880a;

            a() {
            }

            private void b() {
                long j10;
                do {
                    j10 = b.this.f33877d.get();
                    if (j10 == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f33877d.compareAndSet(j10, j10 - 1));
            }

            @Override // rx.d
            public void onCompleted() {
                if (!this.f33880a) {
                    this.f33880a = true;
                    unsubscribe();
                    b.this.f33875b.onNext(Notification.a());
                }
            }

            @Override // rx.d
            public void onError(Throwable th2) {
                if (!this.f33880a) {
                    this.f33880a = true;
                    unsubscribe();
                    b.this.f33875b.onNext(Notification.b(th2));
                }
            }

            @Override // rx.d
            public void onNext(T t10) {
                if (!this.f33880a) {
                    b.this.f33874a.onNext(t10);
                    b();
                    b.this.f33876c.b(1L);
                }
            }

            @Override // rx.i
            public void setProducer(rx.e eVar) {
                b.this.f33876c.c(eVar);
            }
        }

        b(i iVar, rx.subjects.d dVar, rx.internal.producers.a aVar, AtomicLong atomicLong, dq.d dVar2) {
            this.f33874a = iVar;
            this.f33875b = dVar;
            this.f33876c = aVar;
            this.f33877d = atomicLong;
            this.f33878e = dVar2;
        }

        @Override // yp.a
        public void call() {
            if (!this.f33874a.isUnsubscribed()) {
                a aVar = new a();
                this.f33878e.a(aVar);
                p.this.f33869a.j0(aVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    public class c implements c.b<Notification<?>, Notification<?>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: classes3.dex */
        public class a extends i<Notification<?>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i f33883a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(i iVar, i iVar2) {
                super(iVar);
                this.f33883a = iVar2;
            }

            /* renamed from: b */
            public void onNext(Notification<?> notification) {
                if (notification.i() && p.this.f33871c) {
                    this.f33883a.onCompleted();
                } else if (!notification.j() || !p.this.f33872d) {
                    this.f33883a.onNext(notification);
                } else {
                    this.f33883a.onError(notification.e());
                }
            }

            @Override // rx.d
            public void onCompleted() {
                this.f33883a.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th2) {
                this.f33883a.onError(th2);
            }

            @Override // rx.i
            public void setProducer(rx.e eVar) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        c() {
        }

        /* renamed from: a */
        public i<? super Notification<?>> call(i<? super Notification<?>> iVar) {
            return new a(iVar, iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    public class d implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.c f33885a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f33886b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicLong f33887c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f.a f33888d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ yp.a f33889e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f33890f;

        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: classes3.dex */
        class a extends i<Object> {
            a(i iVar) {
                super(iVar);
            }

            @Override // rx.d
            public void onCompleted() {
                d.this.f33886b.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th2) {
                d.this.f33886b.onError(th2);
            }

            @Override // rx.d
            public void onNext(Object obj) {
                if (d.this.f33886b.isUnsubscribed()) {
                    return;
                }
                if (d.this.f33887c.get() > 0) {
                    d dVar = d.this;
                    dVar.f33888d.b(dVar.f33889e);
                    return;
                }
                d.this.f33890f.compareAndSet(false, true);
            }

            @Override // rx.i
            public void setProducer(rx.e eVar) {
                eVar.request(Long.MAX_VALUE);
            }
        }

        d(p pVar, rx.c cVar, i iVar, AtomicLong atomicLong, f.a aVar, yp.a aVar2, AtomicBoolean atomicBoolean) {
            this.f33885a = cVar;
            this.f33886b = iVar;
            this.f33887c = atomicLong;
            this.f33888d = aVar;
            this.f33889e = aVar2;
            this.f33890f = atomicBoolean;
        }

        @Override // yp.a
        public void call() {
            this.f33885a.j0(new a(this.f33886b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: classes3.dex */
    public class e implements rx.e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicLong f33892a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.internal.producers.a f33893b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f33894c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ f.a f33895d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ yp.a f33896e;

        e(p pVar, AtomicLong atomicLong, rx.internal.producers.a aVar, AtomicBoolean atomicBoolean, f.a aVar2, yp.a aVar3) {
            this.f33892a = atomicLong;
            this.f33893b = aVar;
            this.f33894c = atomicBoolean;
            this.f33895d = aVar2;
            this.f33896e = aVar3;
        }

        @Override // rx.e
        public void request(long j10) {
            if (j10 > 0) {
                rx.internal.operators.a.b(this.f33892a, j10);
                this.f33893b.request(j10);
                if (this.f33894c.compareAndSet(true, false)) {
                    this.f33895d.b(this.f33896e);
                }
            }
        }
    }

    static {
        new a();
    }

    private p(rx.c<T> cVar, g<? super rx.c<? extends Notification<?>>, ? extends rx.c<?>> gVar, boolean z10, boolean z11, f fVar) {
        this.f33869a = cVar;
        this.f33870b = gVar;
        this.f33871c = z10;
        this.f33872d = z11;
        this.f33873e = fVar;
    }

    public static <T> rx.c<T> b(rx.c<T> cVar, g<? super rx.c<? extends Notification<?>>, ? extends rx.c<?>> gVar) {
        return rx.c.i0(new p(cVar, gVar, true, false, cq.a.f()));
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        f.a a10 = this.f33873e.a();
        iVar.add(a10);
        dq.d dVar = new dq.d();
        iVar.add(dVar);
        rx.subjects.c<T, T> n02 = rx.subjects.a.o0().n0();
        n02.V(aq.e.a());
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        b bVar = new b(iVar, n02, aVar, atomicLong, dVar);
        a10.b(new d(this, this.f33870b.call(n02.C(new c())), iVar, atomicLong, a10, bVar, atomicBoolean));
        iVar.setProducer(new e(this, atomicLong, aVar, atomicBoolean, a10, bVar));
    }
}
