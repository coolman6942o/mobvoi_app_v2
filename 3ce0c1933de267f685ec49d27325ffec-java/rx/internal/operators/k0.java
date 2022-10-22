package rx.internal.operators;

import rx.f;
import rx.g;
import rx.h;
/* compiled from: SingleObserveOn.java */
/* loaded from: classes3.dex */
public final class k0<T> implements g.c<T> {

    /* renamed from: a  reason: collision with root package name */
    final g.c<T> f33853a;

    /* renamed from: b  reason: collision with root package name */
    final f f33854b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleObserveOn.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends h<T> implements yp.a {

        /* renamed from: b  reason: collision with root package name */
        final h<? super T> f33855b;

        /* renamed from: c  reason: collision with root package name */
        final f.a f33856c;

        /* renamed from: d  reason: collision with root package name */
        T f33857d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f33858e;

        public a(h<? super T> hVar, f.a aVar) {
            this.f33855b = hVar;
            this.f33856c = aVar;
        }

        @Override // rx.h
        public void b(Throwable th2) {
            this.f33858e = th2;
            this.f33856c.b(this);
        }

        @Override // rx.h
        public void c(T t10) {
            this.f33857d = t10;
            this.f33856c.b(this);
        }

        @Override // yp.a
        public void call() {
            try {
                Throwable th2 = this.f33858e;
                if (th2 != null) {
                    this.f33858e = null;
                    this.f33855b.b(th2);
                } else {
                    T t10 = this.f33857d;
                    this.f33857d = null;
                    this.f33855b.c(t10);
                }
            } finally {
                this.f33856c.unsubscribe();
            }
        }
    }

    public k0(g.c<T> cVar, f fVar) {
        this.f33853a = cVar;
        this.f33854b = fVar;
    }

    /* renamed from: a */
    public void call(h<? super T> hVar) {
        f.a a10 = this.f33854b.a();
        a aVar = new a(hVar, a10);
        hVar.a(a10);
        hVar.a(aVar);
        this.f33853a.call(aVar);
    }
}
