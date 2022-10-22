package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableDebounce.java */
/* loaded from: classes3.dex */
public final class c0<T, U> extends io.reactivex.internal.operators.observable.a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends p<U>> f28471b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableDebounce.java */
    /* loaded from: classes3.dex */
    public static final class a<T, U> implements r<T>, b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28472a;

        /* renamed from: b  reason: collision with root package name */
        final o<? super T, ? extends p<U>> f28473b;

        /* renamed from: c  reason: collision with root package name */
        b f28474c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<b> f28475d = new AtomicReference<>();

        /* renamed from: e  reason: collision with root package name */
        volatile long f28476e;

        /* renamed from: f  reason: collision with root package name */
        boolean f28477f;

        /* compiled from: ObservableDebounce.java */
        /* renamed from: io.reactivex.internal.operators.observable.c0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0327a<T, U> extends eo.b<U> {

            /* renamed from: b  reason: collision with root package name */
            final a<T, U> f28478b;

            /* renamed from: c  reason: collision with root package name */
            final long f28479c;

            /* renamed from: d  reason: collision with root package name */
            final T f28480d;

            /* renamed from: e  reason: collision with root package name */
            boolean f28481e;

            /* renamed from: f  reason: collision with root package name */
            final AtomicBoolean f28482f = new AtomicBoolean();

            C0327a(a<T, U> aVar, long j10, T t10) {
                this.f28478b = aVar;
                this.f28479c = j10;
                this.f28480d = t10;
            }

            void b() {
                if (this.f28482f.compareAndSet(false, true)) {
                    this.f28478b.a(this.f28479c, this.f28480d);
                }
            }

            @Override // io.reactivex.r
            public void onComplete() {
                if (!this.f28481e) {
                    this.f28481e = true;
                    b();
                }
            }

            @Override // io.reactivex.r
            public void onError(Throwable th2) {
                if (this.f28481e) {
                    fo.a.s(th2);
                    return;
                }
                this.f28481e = true;
                this.f28478b.onError(th2);
            }

            @Override // io.reactivex.r
            public void onNext(U u10) {
                if (!this.f28481e) {
                    this.f28481e = true;
                    dispose();
                    b();
                }
            }
        }

        a(r<? super T> rVar, o<? super T, ? extends p<U>> oVar) {
            this.f28472a = rVar;
            this.f28473b = oVar;
        }

        void a(long j10, T t10) {
            if (j10 == this.f28476e) {
                this.f28472a.onNext(t10);
            }
        }

        @Override // xn.b
        public void dispose() {
            this.f28474c.dispose();
            DisposableHelper.dispose(this.f28475d);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28474c.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28477f) {
                this.f28477f = true;
                b bVar = this.f28475d.get();
                if (bVar != DisposableHelper.DISPOSED) {
                    ((C0327a) bVar).b();
                    DisposableHelper.dispose(this.f28475d);
                    this.f28472a.onComplete();
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            DisposableHelper.dispose(this.f28475d);
            this.f28472a.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28477f) {
                long j10 = this.f28476e + 1;
                this.f28476e = j10;
                b bVar = this.f28475d.get();
                if (bVar != null) {
                    bVar.dispose();
                }
                try {
                    p pVar = (p) bo.b.e(this.f28473b.apply(t10), "The ObservableSource supplied is null");
                    C0327a aVar = new C0327a(this, j10, t10);
                    if (this.f28475d.compareAndSet(bVar, aVar)) {
                        pVar.subscribe(aVar);
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    dispose();
                    this.f28472a.onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28474c, bVar)) {
                this.f28474c = bVar;
                this.f28472a.onSubscribe(this);
            }
        }
    }

    public c0(p<T> pVar, o<? super T, ? extends p<U>> oVar) {
        super(pVar);
        this.f28471b = oVar;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        this.f28426a.subscribe(new a(new d(rVar), this.f28471b));
    }
}
