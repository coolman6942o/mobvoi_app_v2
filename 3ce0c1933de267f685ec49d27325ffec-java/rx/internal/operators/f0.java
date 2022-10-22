package rx.internal.operators;

import rx.c;
import rx.e;
import rx.f;
import rx.i;
/* compiled from: OperatorSubscribeOn.java */
/* loaded from: classes3.dex */
public final class f0<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final f f33804a;

    /* renamed from: b  reason: collision with root package name */
    final c<T> f33805b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f33806c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorSubscribeOn.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends i<T> implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        final i<? super T> f33807a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f33808b;

        /* renamed from: c  reason: collision with root package name */
        final f.a f33809c;

        /* renamed from: d  reason: collision with root package name */
        c<T> f33810d;

        /* renamed from: e  reason: collision with root package name */
        Thread f33811e;

        /* compiled from: OperatorSubscribeOn.java */
        /* renamed from: rx.internal.operators.f0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        class C0471a implements e {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f33812a;

            /* compiled from: OperatorSubscribeOn.java */
            /* renamed from: rx.internal.operators.f0$a$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            class C0472a implements yp.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ long f33814a;

                C0472a(long j10) {
                    this.f33814a = j10;
                }

                @Override // yp.a
                public void call() {
                    C0471a.this.f33812a.request(this.f33814a);
                }
            }

            C0471a(e eVar) {
                this.f33812a = eVar;
            }

            @Override // rx.e
            public void request(long j10) {
                if (a.this.f33811e != Thread.currentThread()) {
                    a aVar = a.this;
                    if (aVar.f33808b) {
                        aVar.f33809c.b(new C0472a(j10));
                        return;
                    }
                }
                this.f33812a.request(j10);
            }
        }

        a(i<? super T> iVar, boolean z10, f.a aVar, c<T> cVar) {
            this.f33807a = iVar;
            this.f33808b = z10;
            this.f33809c = aVar;
            this.f33810d = cVar;
        }

        @Override // yp.a
        public void call() {
            c<T> cVar = this.f33810d;
            this.f33810d = null;
            this.f33811e = Thread.currentThread();
            cVar.j0(this);
        }

        @Override // rx.d
        public void onCompleted() {
            try {
                this.f33807a.onCompleted();
            } finally {
                this.f33809c.unsubscribe();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            try {
                this.f33807a.onError(th2);
            } finally {
                this.f33809c.unsubscribe();
            }
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.f33807a.onNext(t10);
        }

        @Override // rx.i
        public void setProducer(e eVar) {
            this.f33807a.setProducer(new C0471a(eVar));
        }
    }

    public f0(c<T> cVar, f fVar, boolean z10) {
        this.f33804a = fVar;
        this.f33805b = cVar;
        this.f33806c = z10;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        f.a a10 = this.f33804a.a();
        a aVar = new a(iVar, this.f33806c, a10, this.f33805b);
        iVar.add(aVar);
        iVar.add(a10);
        a10.b(aVar);
    }
}
