package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.c;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.i;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.unsafe.f0;
import rx.internal.util.unsafe.r;
import yp.g;
/* compiled from: OnSubscribeConcatMap.java */
/* loaded from: classes3.dex */
public final class f<T, R> implements c.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.c<? extends T> f33784a;

    /* renamed from: b  reason: collision with root package name */
    final g<? super T, ? extends rx.c<? extends R>> f33785b;

    /* renamed from: c  reason: collision with root package name */
    final int f33786c;

    /* renamed from: d  reason: collision with root package name */
    final int f33787d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: classes3.dex */
    public class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f33788a;

        a(f fVar, d dVar) {
            this.f33788a = dVar;
        }

        @Override // rx.e
        public void request(long j10) {
            this.f33788a.h(j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class b<T, R> implements e {

        /* renamed from: a  reason: collision with root package name */
        final R f33789a;

        /* renamed from: b  reason: collision with root package name */
        final d<T, R> f33790b;

        /* renamed from: c  reason: collision with root package name */
        boolean f33791c;

        public b(R r10, d<T, R> dVar) {
            this.f33789a = r10;
            this.f33790b = dVar;
        }

        @Override // rx.e
        public void request(long j10) {
            if (!this.f33791c && j10 > 0) {
                this.f33791c = true;
                d<T, R> dVar = this.f33790b;
                dVar.f(this.f33789a);
                dVar.d(1L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class c<T, R> extends i<R> {

        /* renamed from: a  reason: collision with root package name */
        final d<T, R> f33792a;

        /* renamed from: b  reason: collision with root package name */
        long f33793b;

        public c(d<T, R> dVar) {
            this.f33792a = dVar;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f33792a.d(this.f33793b);
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f33792a.e(th2, this.f33793b);
        }

        @Override // rx.d
        public void onNext(R r10) {
            this.f33793b++;
            this.f33792a.f(r10);
        }

        @Override // rx.i
        public void setProducer(e eVar) {
            this.f33792a.f33797d.c(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeConcatMap.java */
    /* loaded from: classes3.dex */
    public static final class d<T, R> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final i<? super R> f33794a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super T, ? extends rx.c<? extends R>> f33795b;

        /* renamed from: c  reason: collision with root package name */
        final int f33796c;

        /* renamed from: e  reason: collision with root package name */
        final Queue<Object> f33798e;

        /* renamed from: h  reason: collision with root package name */
        final dq.d f33801h;

        /* renamed from: i  reason: collision with root package name */
        volatile boolean f33802i;

        /* renamed from: j  reason: collision with root package name */
        volatile boolean f33803j;

        /* renamed from: d  reason: collision with root package name */
        final rx.internal.producers.a f33797d = new rx.internal.producers.a();

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f33799f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        final AtomicReference<Throwable> f33800g = new AtomicReference<>();

        public d(i<? super R> iVar, g<? super T, ? extends rx.c<? extends R>> gVar, int i10, int i11) {
            Queue<Object> queue;
            this.f33794a = iVar;
            this.f33795b = gVar;
            this.f33796c = i11;
            if (f0.b()) {
                queue = new r<>(i10);
            } else {
                queue = new rx.internal.util.atomic.c<>(i10);
            }
            this.f33798e = queue;
            this.f33801h = new dq.d();
            request(i10);
        }

        void b() {
            if (this.f33799f.getAndIncrement() == 0) {
                int i10 = this.f33796c;
                while (!this.f33794a.isUnsubscribed()) {
                    if (!this.f33803j) {
                        if (i10 != 1 || this.f33800g.get() == null) {
                            boolean z10 = this.f33802i;
                            Object poll = this.f33798e.poll();
                            boolean z11 = poll == null;
                            if (z10 && z11) {
                                Throwable terminate = ExceptionsUtils.terminate(this.f33800g);
                                if (terminate == null) {
                                    this.f33794a.onCompleted();
                                    return;
                                } else if (!ExceptionsUtils.isTerminated(terminate)) {
                                    this.f33794a.onError(terminate);
                                    return;
                                } else {
                                    return;
                                }
                            } else if (!z11) {
                                try {
                                    rx.c<? extends R> call = this.f33795b.call((Object) rx.internal.operators.d.d(poll));
                                    if (call == null) {
                                        c(new NullPointerException("The source returned by the mapper was null"));
                                        return;
                                    } else if (call != rx.c.s()) {
                                        if (call instanceof rx.internal.util.g) {
                                            this.f33803j = true;
                                            this.f33797d.c(new b(((rx.internal.util.g) call).o0(), this));
                                        } else {
                                            c cVar = new c(this);
                                            this.f33801h.a(cVar);
                                            if (!cVar.isUnsubscribed()) {
                                                this.f33803j = true;
                                                call.j0(cVar);
                                            } else {
                                                return;
                                            }
                                        }
                                        request(1L);
                                    } else {
                                        request(1L);
                                    }
                                } catch (Throwable th2) {
                                    rx.exceptions.a.e(th2);
                                    c(th2);
                                    return;
                                }
                            }
                        } else {
                            Throwable terminate2 = ExceptionsUtils.terminate(this.f33800g);
                            if (!ExceptionsUtils.isTerminated(terminate2)) {
                                this.f33794a.onError(terminate2);
                                return;
                            }
                            return;
                        }
                    }
                    if (this.f33799f.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        void c(Throwable th2) {
            unsubscribe();
            if (ExceptionsUtils.addThrowable(this.f33800g, th2)) {
                Throwable terminate = ExceptionsUtils.terminate(this.f33800g);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.f33794a.onError(terminate);
                    return;
                }
                return;
            }
            g(th2);
        }

        void d(long j10) {
            if (j10 != 0) {
                this.f33797d.b(j10);
            }
            this.f33803j = false;
            b();
        }

        void e(Throwable th2, long j10) {
            if (!ExceptionsUtils.addThrowable(this.f33800g, th2)) {
                g(th2);
            } else if (this.f33796c == 0) {
                Throwable terminate = ExceptionsUtils.terminate(this.f33800g);
                if (!ExceptionsUtils.isTerminated(terminate)) {
                    this.f33794a.onError(terminate);
                }
                unsubscribe();
            } else {
                if (j10 != 0) {
                    this.f33797d.b(j10);
                }
                this.f33803j = false;
                b();
            }
        }

        void f(R r10) {
            this.f33794a.onNext(r10);
        }

        void g(Throwable th2) {
            bq.c.i(th2);
        }

        void h(long j10) {
            int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
            if (i10 > 0) {
                this.f33797d.request(j10);
            } else if (i10 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j10);
            }
        }

        @Override // rx.d
        public void onCompleted() {
            this.f33802i = true;
            b();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (ExceptionsUtils.addThrowable(this.f33800g, th2)) {
                this.f33802i = true;
                if (this.f33796c == 0) {
                    Throwable terminate = ExceptionsUtils.terminate(this.f33800g);
                    if (!ExceptionsUtils.isTerminated(terminate)) {
                        this.f33794a.onError(terminate);
                    }
                    this.f33801h.unsubscribe();
                    return;
                }
                b();
                return;
            }
            g(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            if (!this.f33798e.offer(rx.internal.operators.d.g(t10))) {
                unsubscribe();
                onError(new MissingBackpressureException());
                return;
            }
            b();
        }
    }

    public f(rx.c<? extends T> cVar, g<? super T, ? extends rx.c<? extends R>> gVar, int i10, int i11) {
        this.f33784a = cVar;
        this.f33785b = gVar;
        this.f33786c = i10;
        this.f33787d = i11;
    }

    /* renamed from: a */
    public void call(i<? super R> iVar) {
        d dVar = new d(this.f33787d == 0 ? new aq.d<>(iVar) : iVar, this.f33785b, this.f33786c, this.f33787d);
        iVar.add(dVar);
        iVar.add(dVar.f33801h);
        iVar.setProducer(new a(this, dVar));
        if (!iVar.isUnsubscribed()) {
            this.f33784a.j0(dVar);
        }
    }
}
