package rx.internal.operators;

import dq.d;
import rx.c;
import rx.e;
import rx.i;
import yp.g;
/* compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* loaded from: classes3.dex */
public final class d0<T> implements c.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final g<? super Throwable, ? extends rx.c<? extends T>> f33743a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* loaded from: classes3.dex */
    public static class a implements g<Throwable, rx.c<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f33744a;

        a(g gVar) {
            this.f33744a = gVar;
        }

        /* renamed from: a */
        public rx.c<? extends T> call(Throwable th2) {
            return rx.c.A(this.f33744a.call(th2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* loaded from: classes3.dex */
    public static class b implements g<Throwable, rx.c<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.c f33745a;

        b(rx.c cVar) {
            this.f33745a = cVar;
        }

        /* renamed from: a */
        public rx.c<? extends T> call(Throwable th2) {
            return this.f33745a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* loaded from: classes3.dex */
    public class c extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f33746a;

        /* renamed from: b  reason: collision with root package name */
        long f33747b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ i f33748c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.internal.producers.a f33749d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ d f33750e;

        /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
        /* loaded from: classes3.dex */
        class a extends i<T> {
            a() {
            }

            @Override // rx.d
            public void onCompleted() {
                c.this.f33748c.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th2) {
                c.this.f33748c.onError(th2);
            }

            @Override // rx.d
            public void onNext(T t10) {
                c.this.f33748c.onNext(t10);
            }

            @Override // rx.i
            public void setProducer(e eVar) {
                c.this.f33749d.c(eVar);
            }
        }

        c(i iVar, rx.internal.producers.a aVar, d dVar) {
            this.f33748c = iVar;
            this.f33749d = aVar;
            this.f33750e = dVar;
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33746a) {
                this.f33746a = true;
                this.f33748c.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (this.f33746a) {
                rx.exceptions.a.e(th2);
                bq.c.i(th2);
                return;
            }
            this.f33746a = true;
            try {
                unsubscribe();
                a aVar = new a();
                this.f33750e.a(aVar);
                long j10 = this.f33747b;
                if (j10 != 0) {
                    this.f33749d.b(j10);
                }
                d0.this.f33743a.call(th2).j0(aVar);
            } catch (Throwable th3) {
                rx.exceptions.a.f(th3, this.f33748c);
            }
        }

        @Override // rx.d
        public void onNext(T t10) {
            if (!this.f33746a) {
                this.f33747b++;
                this.f33748c.onNext(t10);
            }
        }

        @Override // rx.i
        public void setProducer(e eVar) {
            this.f33749d.c(eVar);
        }
    }

    public d0(g<? super Throwable, ? extends rx.c<? extends T>> gVar) {
        this.f33743a = gVar;
    }

    public static <T> d0<T> b(rx.c<? extends T> cVar) {
        return new d0<>(new b(cVar));
    }

    public static <T> d0<T> c(g<? super Throwable, ? extends T> gVar) {
        return new d0<>(new a(gVar));
    }

    /* renamed from: a */
    public i<? super T> call(i<? super T> iVar) {
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        d dVar = new d();
        c cVar = new c(iVar, aVar, dVar);
        dVar.a(cVar);
        iVar.add(dVar);
        iVar.setProducer(aVar);
        return cVar;
    }
}
