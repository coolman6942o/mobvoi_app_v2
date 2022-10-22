package rx;

import dq.e;
import java.util.Objects;
import rx.f;
import rx.internal.operators.k0;
import rx.internal.util.h;
/* compiled from: Single.java */
/* loaded from: classes3.dex */
public class g<T> {

    /* renamed from: a  reason: collision with root package name */
    final c<T> f33700a;

    /* compiled from: Single.java */
    /* loaded from: classes3.dex */
    class a extends h<T> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ yp.b f33701b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ yp.b f33702c;

        a(g gVar, yp.b bVar, yp.b bVar2) {
            this.f33701b = bVar;
            this.f33702c = bVar2;
        }

        @Override // rx.h
        public final void b(Throwable th2) {
            try {
                this.f33701b.call(th2);
            } finally {
                unsubscribe();
            }
        }

        @Override // rx.h
        public final void c(T t10) {
            try {
                this.f33702c.call(t10);
            } finally {
                unsubscribe();
            }
        }
    }

    /* compiled from: Single.java */
    /* loaded from: classes3.dex */
    class b implements c<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f f33703a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Single.java */
        /* loaded from: classes3.dex */
        public class a implements yp.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h f33705a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ f.a f33706b;

            /* compiled from: Single.java */
            /* renamed from: rx.g$b$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0469a extends h<T> {
                C0469a() {
                }

                @Override // rx.h
                public void b(Throwable th2) {
                    try {
                        a.this.f33705a.b(th2);
                    } finally {
                        a.this.f33706b.unsubscribe();
                    }
                }

                @Override // rx.h
                public void c(T t10) {
                    try {
                        a.this.f33705a.c(t10);
                    } finally {
                        a.this.f33706b.unsubscribe();
                    }
                }
            }

            a(h hVar, f.a aVar) {
                this.f33705a = hVar;
                this.f33706b = aVar;
            }

            @Override // yp.a
            public void call() {
                C0469a aVar = new C0469a();
                this.f33705a.a(aVar);
                g.this.c(aVar);
            }
        }

        b(f fVar) {
            this.f33703a = fVar;
        }

        /* renamed from: a */
        public void call(h<? super T> hVar) {
            f.a a10 = this.f33703a.a();
            hVar.a(a10);
            a10.b(new a(hVar, a10));
        }
    }

    /* compiled from: Single.java */
    /* loaded from: classes3.dex */
    public interface c<T> extends yp.b<h<? super T>> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public g(c<T> cVar) {
        this.f33700a = bq.c.h(cVar);
    }

    public static <T> g<T> a(c<T> cVar) {
        return new g<>(cVar);
    }

    public final g<T> b(f fVar) {
        if (this instanceof h) {
            return ((h) this).f(fVar);
        }
        Objects.requireNonNull(fVar, "scheduler is null");
        return a(new k0(this.f33700a, fVar));
    }

    public final j c(h<? super T> hVar) {
        if (hVar != null) {
            try {
                bq.c.s(this, this.f33700a).call(hVar);
                return bq.c.r(hVar);
            } catch (Throwable th2) {
                rx.exceptions.a.e(th2);
                try {
                    hVar.b(bq.c.q(th2));
                    return e.b();
                } catch (Throwable th3) {
                    rx.exceptions.a.e(th3);
                    RuntimeException runtimeException = new RuntimeException("Error occurred attempting to subscribe [" + th2.getMessage() + "] and then again while trying to pass to onError.", th3);
                    bq.c.q(runtimeException);
                    throw runtimeException;
                }
            }
        } else {
            throw new IllegalArgumentException("te is null");
        }
    }

    public final j d(yp.b<? super T> bVar, yp.b<Throwable> bVar2) {
        if (bVar == null) {
            throw new IllegalArgumentException("onSuccess can not be null");
        } else if (bVar2 != null) {
            return c(new a(this, bVar2, bVar));
        } else {
            throw new IllegalArgumentException("onError can not be null");
        }
    }

    public final g<T> e(f fVar) {
        if (this instanceof h) {
            return ((h) this).f(fVar);
        }
        return a(new b(fVar));
    }
}
