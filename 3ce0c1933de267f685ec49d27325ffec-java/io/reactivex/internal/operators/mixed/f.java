package io.reactivex.internal.operators.mixed;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableSwitchMapSingle.java */
/* loaded from: classes2.dex */
public final class f<T, R> extends k<R> {

    /* renamed from: a  reason: collision with root package name */
    final k<T> f28416a;

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends v<? extends R>> f28417b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f28418c;

    /* compiled from: ObservableSwitchMapSingle.java */
    /* loaded from: classes2.dex */
    static final class a<T, R> extends AtomicInteger implements r<T>, b {
        static final C0326a<Object> INNER_DISPOSED = new C0326a<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final r<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<C0326a<R>> inner = new AtomicReference<>();
        final o<? super T, ? extends v<? extends R>> mapper;
        b upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableSwitchMapSingle.java */
        /* renamed from: io.reactivex.internal.operators.mixed.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0326a<R> extends AtomicReference<b> implements u<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final a<?, R> parent;

            C0326a(a<?, R> aVar) {
                this.parent = aVar;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.u
            public void onError(Throwable th2) {
                this.parent.c(this, th2);
            }

            @Override // io.reactivex.u
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.u
            public void onSuccess(R r10) {
                this.item = r10;
                this.parent.b();
            }
        }

        a(r<? super R> rVar, o<? super T, ? extends v<? extends R>> oVar, boolean z10) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.delayErrors = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            C0326a<Object> aVar = INNER_DISPOSED;
            C0326a<Object> aVar2 = (C0326a) this.inner.getAndSet(aVar);
            if (aVar2 != null && aVar2 != aVar) {
                aVar2.a();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                r<? super R> rVar = this.downstream;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicReference<C0326a<R>> atomicReference = this.inner;
                int i10 = 1;
                while (!this.cancelled) {
                    if (atomicThrowable.get() == null || this.delayErrors) {
                        boolean z10 = this.done;
                        C0326a<R> aVar = atomicReference.get();
                        boolean z11 = aVar == null;
                        if (z10 && z11) {
                            Throwable terminate = atomicThrowable.terminate();
                            if (terminate != null) {
                                rVar.onError(terminate);
                                return;
                            } else {
                                rVar.onComplete();
                                return;
                            }
                        } else if (z11 || aVar.item == null) {
                            i10 = addAndGet(-i10);
                            if (i10 == 0) {
                                return;
                            }
                        } else {
                            atomicReference.compareAndSet(aVar, null);
                            rVar.onNext((R) aVar.item);
                        }
                    } else {
                        rVar.onError(atomicThrowable.terminate());
                        return;
                    }
                }
            }
        }

        void c(C0326a<R> aVar, Throwable th2) {
            if (!this.inner.compareAndSet(aVar, null) || !this.errors.addThrowable(th2)) {
                fo.a.s(th2);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                a();
            }
            b();
        }

        @Override // xn.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            a();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.done = true;
            b();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.errors.addThrowable(th2)) {
                if (!this.delayErrors) {
                    a();
                }
                this.done = true;
                b();
                return;
            }
            fo.a.s(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.r
        public void onNext(T t10) {
            C0326a<R> aVar;
            C0326a<R> aVar2 = this.inner.get();
            if (aVar2 != null) {
                aVar2.a();
            }
            try {
                v vVar = (v) bo.b.e(this.mapper.apply(t10), "The mapper returned a null SingleSource");
                C0326a<R> aVar3 = new C0326a<>(this);
                do {
                    aVar = this.inner.get();
                    if (aVar == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(aVar, aVar3));
                vVar.b(aVar3);
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.upstream.dispose();
                this.inner.getAndSet(INNER_DISPOSED);
                onError(th2);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public f(k<T> kVar, o<? super T, ? extends v<? extends R>> oVar, boolean z10) {
        this.f28416a = kVar;
        this.f28417b = oVar;
        this.f28418c = z10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        if (!g.c(this.f28416a, this.f28417b, rVar)) {
            this.f28416a.subscribe(new a(rVar, this.f28417b, this.f28418c));
        }
    }
}
