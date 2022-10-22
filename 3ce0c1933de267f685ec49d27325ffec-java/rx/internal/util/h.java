package rx.internal.util;

import rx.f;
import rx.g;
/* compiled from: ScalarSynchronousSingle.java */
/* loaded from: classes3.dex */
public final class h<T> extends g<T> {

    /* renamed from: b  reason: collision with root package name */
    final T f34147b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: classes3.dex */
    public static final class a<T> implements g.c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.internal.schedulers.b f34148a;

        /* renamed from: b  reason: collision with root package name */
        private final T f34149b;

        a(rx.internal.schedulers.b bVar, T t10) {
            this.f34148a = bVar;
            this.f34149b = t10;
        }

        /* renamed from: a */
        public void call(rx.h<? super T> hVar) {
            hVar.a(this.f34148a.c(new c(hVar, this.f34149b)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements g.c<T> {

        /* renamed from: a  reason: collision with root package name */
        private final f f34150a;

        /* renamed from: b  reason: collision with root package name */
        private final T f34151b;

        b(f fVar, T t10) {
            this.f34150a = fVar;
            this.f34151b = t10;
        }

        /* renamed from: a */
        public void call(rx.h<? super T> hVar) {
            f.a a10 = this.f34150a.a();
            hVar.a(a10);
            a10.b(new c(hVar, this.f34151b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: classes3.dex */
    public static final class c<T> implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        private final rx.h<? super T> f34152a;

        /* renamed from: b  reason: collision with root package name */
        private final T f34153b;

        c(rx.h<? super T> hVar, T t10) {
            this.f34152a = hVar;
            this.f34153b = t10;
        }

        @Override // yp.a
        public void call() {
            try {
                this.f34152a.c((T) this.f34153b);
            } catch (Throwable th2) {
                this.f34152a.b(th2);
            }
        }
    }

    public g<T> f(f fVar) {
        if (fVar instanceof rx.internal.schedulers.b) {
            return g.a(new a((rx.internal.schedulers.b) fVar, this.f34147b));
        }
        return g.a(new b(fVar, this.f34147b));
    }
}
