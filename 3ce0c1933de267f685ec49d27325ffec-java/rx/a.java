package rx;

import java.util.Objects;
import java.util.concurrent.Callable;
import rx.c;
import rx.f;
/* compiled from: Completable.java */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    static final a f33679b = new a(new b(), false);

    /* renamed from: a  reason: collision with root package name */
    private final j f33680a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* renamed from: rx.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0465a implements j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.c f33681a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0466a extends rx.i<Object> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.b f33682a;

            C0466a(C0465a aVar, rx.b bVar) {
                this.f33682a = bVar;
            }

            @Override // rx.d
            public void onCompleted() {
                this.f33682a.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th2) {
                this.f33682a.onError(th2);
            }

            @Override // rx.d
            public void onNext(Object obj) {
            }
        }

        C0465a(rx.c cVar) {
            this.f33681a = cVar;
        }

        /* renamed from: a */
        public void call(rx.b bVar) {
            C0466a aVar = new C0466a(this, bVar);
            bVar.a(aVar);
            this.f33681a.j0(aVar);
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    static class b implements j {
        b() {
        }

        /* renamed from: a */
        public void call(rx.b bVar) {
            bVar.a(dq.e.c());
            bVar.onCompleted();
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class c implements rx.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ dq.c f33683a;

        c(a aVar, dq.c cVar) {
            this.f33683a = cVar;
        }

        @Override // rx.b
        public void a(rx.j jVar) {
            this.f33683a.a(jVar);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f33683a.unsubscribe();
        }

        @Override // rx.b
        public void onError(Throwable th2) {
            bq.c.i(th2);
            this.f33683a.unsubscribe();
            a.d(th2);
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class d implements rx.b {

        /* renamed from: a  reason: collision with root package name */
        boolean f33684a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ yp.a f33685b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ dq.c f33686c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ yp.b f33687d;

        d(a aVar, yp.a aVar2, dq.c cVar, yp.b bVar) {
            this.f33685b = aVar2;
            this.f33686c = cVar;
            this.f33687d = bVar;
        }

        @Override // rx.b
        public void a(rx.j jVar) {
            this.f33686c.a(jVar);
        }

        void b(Throwable th2) {
            try {
                this.f33687d.call(th2);
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // rx.b
        public void onCompleted() {
            if (!this.f33684a) {
                this.f33684a = true;
                try {
                    this.f33685b.call();
                    this.f33686c.unsubscribe();
                } catch (Throwable th2) {
                    b(th2);
                }
            }
        }

        @Override // rx.b
        public void onError(Throwable th2) {
            if (!this.f33684a) {
                this.f33684a = true;
                b(th2);
                return;
            }
            bq.c.i(th2);
            a.d(th2);
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    static class e implements j {
        e() {
        }

        /* renamed from: a */
        public void call(rx.b bVar) {
            bVar.a(dq.e.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public class f implements rx.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.i f33688a;

        f(a aVar, rx.i iVar) {
            this.f33688a = iVar;
        }

        @Override // rx.b
        public void a(rx.j jVar) {
            this.f33688a.add(jVar);
        }

        @Override // rx.b
        public void onCompleted() {
            this.f33688a.onCompleted();
        }

        @Override // rx.b
        public void onError(Throwable th2) {
            this.f33688a.onError(th2);
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    class g implements j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.f f33689a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Completable.java */
        /* renamed from: rx.a$g$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0467a implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.b f33691a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ f.a f33692b;

            C0467a(rx.b bVar, f.a aVar) {
                this.f33691a = bVar;
                this.f33692b = aVar;
            }

            @Override // yp.a
            public void call() {
                try {
                    a.this.m(this.f33691a);
                } finally {
                    this.f33692b.unsubscribe();
                }
            }
        }

        g(rx.f fVar) {
            this.f33689a = fVar;
        }

        /* renamed from: a */
        public void call(rx.b bVar) {
            f.a a10 = this.f33689a.a();
            a10.b(new C0467a(bVar, a10));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public class h implements c.a<T> {
        h() {
        }

        /* renamed from: a */
        public void call(rx.i<? super T> iVar) {
            a.this.n(iVar);
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    static class i implements j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callable f33695a;

        i(Callable callable) {
            this.f33695a = callable;
        }

        /* renamed from: a */
        public void call(rx.b bVar) {
            dq.a aVar = new dq.a();
            bVar.a(aVar);
            try {
                this.f33695a.call();
                if (!aVar.isUnsubscribed()) {
                    bVar.onCompleted();
                }
            } catch (Throwable th2) {
                if (!aVar.isUnsubscribed()) {
                    bVar.onError(th2);
                }
            }
        }
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public interface j extends yp.b<rx.b> {
    }

    /* compiled from: Completable.java */
    /* loaded from: classes3.dex */
    public interface k extends yp.g<rx.b, rx.b> {
    }

    static {
        new a(new e(), false);
    }

    protected a(j jVar) {
        this.f33680a = bq.c.f(jVar);
    }

    public static a b() {
        a aVar = f33679b;
        j f10 = bq.c.f(aVar.f33680a);
        return f10 == aVar.f33680a ? aVar : new a(f10, false);
    }

    public static a c(j jVar) {
        g(jVar);
        try {
            return new a(jVar);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            bq.c.i(th2);
            throw k(th2);
        }
    }

    static void d(Throwable th2) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    public static a e(Callable<?> callable) {
        g(callable);
        return c(new i(callable));
    }

    public static a f(rx.c<?> cVar) {
        g(cVar);
        return c(new C0465a(cVar));
    }

    static <T> T g(T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    static NullPointerException k(Throwable th2) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th2);
        return nullPointerException;
    }

    private <T> void o(rx.i<T> iVar, boolean z10) {
        g(iVar);
        if (z10) {
            try {
                iVar.onStart();
            } catch (NullPointerException e10) {
                throw e10;
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                Throwable l10 = bq.c.l(th2);
                bq.c.i(l10);
                throw k(l10);
            }
        }
        m(new f(this, iVar));
        bq.c.n(iVar);
    }

    public final <T> rx.c<T> a(rx.c<T> cVar) {
        g(cVar);
        return cVar.n(l());
    }

    public final rx.j h() {
        dq.c cVar = new dq.c();
        m(new c(this, cVar));
        return cVar;
    }

    public final rx.j i(yp.a aVar, yp.b<? super Throwable> bVar) {
        g(aVar);
        g(bVar);
        dq.c cVar = new dq.c();
        m(new d(this, aVar, cVar, bVar));
        return cVar;
    }

    public final a j(rx.f fVar) {
        g(fVar);
        return c(new g(fVar));
    }

    public final <T> rx.c<T> l() {
        return rx.c.i0(new h());
    }

    public final void m(rx.b bVar) {
        g(bVar);
        try {
            bq.c.d(this, this.f33680a).call(bVar);
        } catch (NullPointerException e10) {
            throw e10;
        } catch (Throwable th2) {
            rx.exceptions.a.e(th2);
            Throwable c10 = bq.c.c(th2);
            bq.c.i(c10);
            throw k(c10);
        }
    }

    public final <T> void n(rx.i<T> iVar) {
        o(iVar, true);
    }

    protected a(j jVar, boolean z10) {
        this.f33680a = z10 ? bq.c.f(jVar) : jVar;
    }
}
