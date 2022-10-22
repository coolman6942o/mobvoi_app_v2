package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.c;
import rx.f;
import rx.i;
import rx.internal.producers.SingleProducer;
import rx.j;
/* compiled from: ScalarSynchronousObservable.java */
/* loaded from: classes3.dex */
public final class g<T> extends rx.c<T> {

    /* renamed from: c  reason: collision with root package name */
    static final boolean f34133c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: b  reason: collision with root package name */
    final T f34134b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public class a implements yp.g<yp.a, j> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.internal.schedulers.b f34135a;

        a(g gVar, rx.internal.schedulers.b bVar) {
            this.f34135a = bVar;
        }

        /* renamed from: a */
        public j call(yp.a aVar) {
            return this.f34135a.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public class b implements yp.g<yp.a, j> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.f f34136a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ScalarSynchronousObservable.java */
        /* loaded from: classes3.dex */
        public class a implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ yp.a f34137a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ f.a f34138b;

            a(b bVar, yp.a aVar, f.a aVar2) {
                this.f34137a = aVar;
                this.f34138b = aVar2;
            }

            @Override // yp.a
            public void call() {
                try {
                    this.f34137a.call();
                } finally {
                    this.f34138b.unsubscribe();
                }
            }
        }

        b(g gVar, rx.f fVar) {
            this.f34136a = fVar;
        }

        /* renamed from: a */
        public j call(yp.a aVar) {
            f.a a10 = this.f34136a.a();
            a10.b(new a(this, aVar, a10));
            return a10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public class c implements c.a<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ yp.g f34139a;

        c(yp.g gVar) {
            this.f34139a = gVar;
        }

        /* renamed from: a */
        public void call(i<? super R> iVar) {
            rx.c cVar = (rx.c) this.f34139a.call(g.this.f34134b);
            if (cVar instanceof g) {
                iVar.setProducer(g.n0(iVar, ((g) cVar).f34134b));
            } else {
                cVar.j0(aq.e.c(iVar));
            }
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    static final class d<T> implements c.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f34141a;

        d(T t10) {
            this.f34141a = t10;
        }

        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.setProducer(g.n0(iVar, this.f34141a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public static final class e<T> implements c.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f34142a;

        /* renamed from: b  reason: collision with root package name */
        final yp.g<yp.a, j> f34143b;

        e(T t10, yp.g<yp.a, j> gVar) {
            this.f34142a = t10;
            this.f34143b = gVar;
        }

        /* renamed from: a */
        public void call(i<? super T> iVar) {
            iVar.setProducer(new f(iVar, this.f34142a, this.f34143b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: classes3.dex */
    public static final class f<T> extends AtomicBoolean implements rx.e, yp.a {
        private static final long serialVersionUID = -2466317989629281651L;
        final i<? super T> actual;
        final yp.g<yp.a, j> onSchedule;
        final T value;

        public f(i<? super T> iVar, T t10, yp.g<yp.a, j> gVar) {
            this.actual = iVar;
            this.value = t10;
            this.onSchedule = gVar;
        }

        @Override // yp.a
        public void call() {
            i<? super T> iVar = this.actual;
            if (!iVar.isUnsubscribed()) {
                Object obj = (T) this.value;
                try {
                    iVar.onNext(obj);
                    if (!iVar.isUnsubscribed()) {
                        iVar.onCompleted();
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.g(th2, iVar, obj);
                }
            }
        }

        @Override // rx.e
        public void request(long j10) {
            int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
            if (i10 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j10);
            } else if (i10 != 0 && compareAndSet(false, true)) {
                this.actual.add(this.onSchedule.call(this));
            }
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + ", " + get() + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: rx.internal.util.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0486g<T> implements rx.e {

        /* renamed from: a  reason: collision with root package name */
        final i<? super T> f34144a;

        /* renamed from: b  reason: collision with root package name */
        final T f34145b;

        /* renamed from: c  reason: collision with root package name */
        boolean f34146c;

        public C0486g(i<? super T> iVar, T t10) {
            this.f34144a = iVar;
            this.f34145b = t10;
        }

        @Override // rx.e
        public void request(long j10) {
            if (!this.f34146c) {
                int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
                if (i10 < 0) {
                    throw new IllegalStateException("n >= required but it was " + j10);
                } else if (i10 != 0) {
                    this.f34146c = true;
                    i<? super T> iVar = this.f34144a;
                    if (!iVar.isUnsubscribed()) {
                        Object obj = (T) this.f34145b;
                        try {
                            iVar.onNext(obj);
                            if (!iVar.isUnsubscribed()) {
                                iVar.onCompleted();
                            }
                        } catch (Throwable th2) {
                            rx.exceptions.a.g(th2, iVar, obj);
                        }
                    }
                }
            }
        }
    }

    protected g(T t10) {
        super(bq.c.g(new d(t10)));
        this.f34134b = t10;
    }

    public static <T> g<T> m0(T t10) {
        return new g<>(t10);
    }

    static <T> rx.e n0(i<? super T> iVar, T t10) {
        if (f34133c) {
            return new SingleProducer(iVar, t10);
        }
        return new C0486g(iVar, t10);
    }

    public T o0() {
        return this.f34134b;
    }

    public <R> rx.c<R> p0(yp.g<? super T, ? extends rx.c<? extends R>> gVar) {
        return rx.c.i0(new c(gVar));
    }

    public rx.c<T> q0(rx.f fVar) {
        yp.g gVar;
        if (fVar instanceof rx.internal.schedulers.b) {
            gVar = new a(this, (rx.internal.schedulers.b) fVar);
        } else {
            gVar = new b(this, fVar);
        }
        return rx.c.i0(new e(this.f34134b, gVar));
    }
}
