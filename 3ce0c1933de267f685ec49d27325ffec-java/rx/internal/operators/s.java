package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import rx.c;
import rx.e;
import rx.f;
import rx.i;
import rx.internal.subscriptions.SequentialSubscription;
import rx.j;
/* compiled from: OnSubscribeTimeoutTimedWithFallback.java */
/* loaded from: classes3.dex */
public final class s<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f33903a;

    /* renamed from: b  reason: collision with root package name */
    final long f33904b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f33905c;

    /* renamed from: d  reason: collision with root package name */
    final f f33906d;

    /* renamed from: e  reason: collision with root package name */
    final c<? extends T> f33907e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeTimeoutTimedWithFallback.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final i<? super T> f33908a;

        /* renamed from: b  reason: collision with root package name */
        final rx.internal.producers.a f33909b;

        a(i<? super T> iVar, rx.internal.producers.a aVar) {
            this.f33908a = iVar;
            this.f33909b = aVar;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f33908a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f33908a.onError(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.f33908a.onNext(t10);
        }

        @Override // rx.i
        public void setProducer(e eVar) {
            this.f33909b.c(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeTimeoutTimedWithFallback.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final i<? super T> f33910a;

        /* renamed from: b  reason: collision with root package name */
        final long f33911b;

        /* renamed from: c  reason: collision with root package name */
        final TimeUnit f33912c;

        /* renamed from: d  reason: collision with root package name */
        final f.a f33913d;

        /* renamed from: e  reason: collision with root package name */
        final c<? extends T> f33914e;

        /* renamed from: h  reason: collision with root package name */
        final SequentialSubscription f33917h;

        /* renamed from: j  reason: collision with root package name */
        long f33919j;

        /* renamed from: f  reason: collision with root package name */
        final rx.internal.producers.a f33915f = new rx.internal.producers.a();

        /* renamed from: g  reason: collision with root package name */
        final AtomicLong f33916g = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        final SequentialSubscription f33918i = new SequentialSubscription(this);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeTimeoutTimedWithFallback.java */
        /* loaded from: classes3.dex */
        public final class a implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final long f33920a;

            a(long j10) {
                this.f33920a = j10;
            }

            @Override // yp.a
            public void call() {
                b.this.b(this.f33920a);
            }
        }

        b(i<? super T> iVar, long j10, TimeUnit timeUnit, f.a aVar, c<? extends T> cVar) {
            this.f33910a = iVar;
            this.f33911b = j10;
            this.f33912c = timeUnit;
            this.f33913d = aVar;
            this.f33914e = cVar;
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            this.f33917h = sequentialSubscription;
            add(aVar);
            add(sequentialSubscription);
        }

        void b(long j10) {
            if (this.f33916g.compareAndSet(j10, Long.MAX_VALUE)) {
                unsubscribe();
                if (this.f33914e == null) {
                    this.f33910a.onError(new TimeoutException());
                    return;
                }
                long j11 = this.f33919j;
                if (j11 != 0) {
                    this.f33915f.b(j11);
                }
                a aVar = new a(this.f33910a, this.f33915f);
                if (this.f33918i.replace(aVar)) {
                    this.f33914e.V(aVar);
                }
            }
        }

        void c(long j10) {
            this.f33917h.replace(this.f33913d.c(new a(j10), this.f33911b, this.f33912c));
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f33916g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f33917h.unsubscribe();
                this.f33910a.onCompleted();
                this.f33913d.unsubscribe();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (this.f33916g.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.f33917h.unsubscribe();
                this.f33910a.onError(th2);
                this.f33913d.unsubscribe();
                return;
            }
            bq.c.i(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            long j10 = this.f33916g.get();
            if (j10 != Long.MAX_VALUE) {
                long j11 = j10 + 1;
                if (this.f33916g.compareAndSet(j10, j11)) {
                    j jVar = this.f33917h.get();
                    if (jVar != null) {
                        jVar.unsubscribe();
                    }
                    this.f33919j++;
                    this.f33910a.onNext(t10);
                    c(j11);
                }
            }
        }

        @Override // rx.i
        public void setProducer(e eVar) {
            this.f33915f.c(eVar);
        }
    }

    public s(c<T> cVar, long j10, TimeUnit timeUnit, f fVar, c<? extends T> cVar2) {
        this.f33903a = cVar;
        this.f33904b = j10;
        this.f33905c = timeUnit;
        this.f33906d = fVar;
        this.f33907e = cVar2;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        b bVar = new b(iVar, this.f33904b, this.f33905c, this.f33906d.a(), this.f33907e);
        iVar.add(bVar.f33918i);
        iVar.setProducer(bVar.f33915f);
        bVar.c(0L);
        this.f33903a.V(bVar);
    }
}
