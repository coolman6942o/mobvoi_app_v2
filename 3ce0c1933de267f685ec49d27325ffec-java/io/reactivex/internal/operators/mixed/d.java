package io.reactivex.internal.operators.mixed;

import io.reactivex.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.f;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableSwitchMapCompletable.java */
/* loaded from: classes2.dex */
public final class d<T> extends io.reactivex.a {

    /* renamed from: a  reason: collision with root package name */
    final k<T> f28402a;

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends c> f28403b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f28404c;

    /* compiled from: ObservableSwitchMapCompletable.java */
    /* loaded from: classes2.dex */
    static final class a<T> implements r<T>, b {

        /* renamed from: h  reason: collision with root package name */
        static final C0324a f28405h = new C0324a(null);

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.b f28406a;

        /* renamed from: b  reason: collision with root package name */
        final o<? super T, ? extends c> f28407b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f28408c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicThrowable f28409d = new AtomicThrowable();

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<C0324a> f28410e = new AtomicReference<>();

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f28411f;

        /* renamed from: g  reason: collision with root package name */
        b f28412g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableSwitchMapCompletable.java */
        /* renamed from: io.reactivex.internal.operators.mixed.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0324a extends AtomicReference<b> implements io.reactivex.b {
            private static final long serialVersionUID = -8003404460084760287L;
            final a<?> parent;

            C0324a(a<?> aVar) {
                this.parent = aVar;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.b
            public void onComplete() {
                this.parent.b(this);
            }

            @Override // io.reactivex.b
            public void onError(Throwable th2) {
                this.parent.c(this, th2);
            }

            @Override // io.reactivex.b
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }
        }

        a(io.reactivex.b bVar, o<? super T, ? extends c> oVar, boolean z10) {
            this.f28406a = bVar;
            this.f28407b = oVar;
            this.f28408c = z10;
        }

        void a() {
            AtomicReference<C0324a> atomicReference = this.f28410e;
            C0324a aVar = f28405h;
            C0324a andSet = atomicReference.getAndSet(aVar);
            if (andSet != null && andSet != aVar) {
                andSet.a();
            }
        }

        void b(C0324a aVar) {
            if (this.f28410e.compareAndSet(aVar, null) && this.f28411f) {
                Throwable terminate = this.f28409d.terminate();
                if (terminate == null) {
                    this.f28406a.onComplete();
                } else {
                    this.f28406a.onError(terminate);
                }
            }
        }

        void c(C0324a aVar, Throwable th2) {
            if (!this.f28410e.compareAndSet(aVar, null) || !this.f28409d.addThrowable(th2)) {
                fo.a.s(th2);
            } else if (!this.f28408c) {
                dispose();
                Throwable terminate = this.f28409d.terminate();
                if (terminate != f.f29256a) {
                    this.f28406a.onError(terminate);
                }
            } else if (this.f28411f) {
                this.f28406a.onError(this.f28409d.terminate());
            }
        }

        @Override // xn.b
        public void dispose() {
            this.f28412g.dispose();
            a();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28410e.get() == f28405h;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28411f = true;
            if (this.f28410e.get() == null) {
                Throwable terminate = this.f28409d.terminate();
                if (terminate == null) {
                    this.f28406a.onComplete();
                } else {
                    this.f28406a.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (!this.f28409d.addThrowable(th2)) {
                fo.a.s(th2);
            } else if (this.f28408c) {
                onComplete();
            } else {
                a();
                Throwable terminate = this.f28409d.terminate();
                if (terminate != f.f29256a) {
                    this.f28406a.onError(terminate);
                }
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            C0324a aVar;
            try {
                c cVar = (c) bo.b.e(this.f28407b.apply(t10), "The mapper returned a null CompletableSource");
                C0324a aVar2 = new C0324a(this);
                do {
                    aVar = this.f28410e.get();
                    if (aVar == f28405h) {
                        return;
                    }
                } while (!this.f28410e.compareAndSet(aVar, aVar2));
                if (aVar != null) {
                    aVar.a();
                }
                cVar.b(aVar2);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f28412g.dispose();
                onError(th2);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.f28412g, bVar)) {
                this.f28412g = bVar;
                this.f28406a.onSubscribe(this);
            }
        }
    }

    public d(k<T> kVar, o<? super T, ? extends c> oVar, boolean z10) {
        this.f28402a = kVar;
        this.f28403b = oVar;
        this.f28404c = z10;
    }

    @Override // io.reactivex.a
    protected void c(io.reactivex.b bVar) {
        if (!g.a(this.f28402a, this.f28403b, bVar)) {
            this.f28402a.subscribe(new a(bVar, this.f28403b, this.f28404c));
        }
    }
}
