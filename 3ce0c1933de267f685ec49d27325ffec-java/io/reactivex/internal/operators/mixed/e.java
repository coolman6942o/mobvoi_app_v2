package io.reactivex.internal.operators.mixed;

import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableSwitchMapMaybe.java */
/* loaded from: classes2.dex */
public final class e<T, R> extends k<R> {

    /* renamed from: a  reason: collision with root package name */
    final k<T> f28413a;

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends i<? extends R>> f28414b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f28415c;

    /* compiled from: ObservableSwitchMapMaybe.java */
    /* loaded from: classes2.dex */
    static final class a<T, R> extends AtomicInteger implements r<T>, b {
        static final C0325a<Object> INNER_DISPOSED = new C0325a<>(null);
        private static final long serialVersionUID = -5402190102429853762L;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final r<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        final AtomicReference<C0325a<R>> inner = new AtomicReference<>();
        final o<? super T, ? extends i<? extends R>> mapper;
        b upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableSwitchMapMaybe.java */
        /* renamed from: io.reactivex.internal.operators.mixed.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0325a<R> extends AtomicReference<b> implements h<R> {
            private static final long serialVersionUID = 8042919737683345351L;
            volatile R item;
            final a<?, R> parent;

            C0325a(a<?, R> aVar) {
                this.parent = aVar;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.h
            public void onComplete() {
                this.parent.c(this);
            }

            @Override // io.reactivex.h
            public void onError(Throwable th2) {
                this.parent.d(this, th2);
            }

            @Override // io.reactivex.h
            public void onSubscribe(b bVar) {
                DisposableHelper.setOnce(this, bVar);
            }

            @Override // io.reactivex.h
            public void onSuccess(R r10) {
                this.item = r10;
                this.parent.b();
            }
        }

        a(r<? super R> rVar, o<? super T, ? extends i<? extends R>> oVar, boolean z10) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.delayErrors = z10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void a() {
            C0325a<Object> aVar = INNER_DISPOSED;
            C0325a<Object> aVar2 = (C0325a) this.inner.getAndSet(aVar);
            if (aVar2 != null && aVar2 != aVar) {
                aVar2.a();
            }
        }

        void b() {
            if (getAndIncrement() == 0) {
                r<? super R> rVar = this.downstream;
                AtomicThrowable atomicThrowable = this.errors;
                AtomicReference<C0325a<R>> atomicReference = this.inner;
                int i10 = 1;
                while (!this.cancelled) {
                    if (atomicThrowable.get() == null || this.delayErrors) {
                        boolean z10 = this.done;
                        C0325a<R> aVar = atomicReference.get();
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

        void c(C0325a<R> aVar) {
            if (this.inner.compareAndSet(aVar, null)) {
                b();
            }
        }

        void d(C0325a<R> aVar, Throwable th2) {
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
            C0325a<R> aVar;
            C0325a<R> aVar2 = this.inner.get();
            if (aVar2 != null) {
                aVar2.a();
            }
            try {
                i iVar = (i) bo.b.e(this.mapper.apply(t10), "The mapper returned a null MaybeSource");
                C0325a<R> aVar3 = new C0325a<>(this);
                do {
                    aVar = this.inner.get();
                    if (aVar == INNER_DISPOSED) {
                        return;
                    }
                } while (!this.inner.compareAndSet(aVar, aVar3));
                iVar.b(aVar3);
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

    public e(k<T> kVar, o<? super T, ? extends i<? extends R>> oVar, boolean z10) {
        this.f28413a = kVar;
        this.f28414b = oVar;
        this.f28415c = z10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        if (!g.b(this.f28413a, this.f28414b, rVar)) {
            this.f28413a.subscribe(new a(rVar, this.f28414b, this.f28415c));
        }
    }
}
