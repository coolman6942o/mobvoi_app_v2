package io.reactivex.internal.operators.mixed;

import co.f;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableConcatMapMaybe.java */
/* loaded from: classes2.dex */
public final class b<T, R> extends k<R> {

    /* renamed from: a  reason: collision with root package name */
    final k<T> f28394a;

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends i<? extends R>> f28395b;

    /* renamed from: c  reason: collision with root package name */
    final ErrorMode f28396c;

    /* renamed from: d  reason: collision with root package name */
    final int f28397d;

    /* compiled from: ObservableConcatMapMaybe.java */
    /* loaded from: classes2.dex */
    static final class a<T, R> extends AtomicInteger implements r<T>, xn.b {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final r<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final C0322a<R> inner = new C0322a<>(this);
        R item;
        final o<? super T, ? extends i<? extends R>> mapper;
        final f<T> queue;
        volatile int state;
        xn.b upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMapMaybe.java */
        /* renamed from: io.reactivex.internal.operators.mixed.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0322a<R> extends AtomicReference<xn.b> implements h<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final a<?, R> parent;

            C0322a(a<?, R> aVar) {
                this.parent = aVar;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.h
            public void onComplete() {
                this.parent.b();
            }

            @Override // io.reactivex.h
            public void onError(Throwable th2) {
                this.parent.c(th2);
            }

            @Override // io.reactivex.h
            public void onSubscribe(xn.b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.h
            public void onSuccess(R r10) {
                this.parent.d(r10);
            }
        }

        a(r<? super R> rVar, o<? super T, ? extends i<? extends R>> oVar, int i10, ErrorMode errorMode) {
            this.downstream = rVar;
            this.mapper = oVar;
            this.errorMode = errorMode;
            this.queue = new io.reactivex.internal.queue.b(i10);
        }

        void a() {
            if (getAndIncrement() == 0) {
                r<? super R> rVar = this.downstream;
                ErrorMode errorMode = this.errorMode;
                f<T> fVar = this.queue;
                AtomicThrowable atomicThrowable = this.errors;
                int i10 = 1;
                while (true) {
                    if (this.cancelled) {
                        fVar.clear();
                        this.item = null;
                    } else {
                        int i11 = this.state;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i11 == 0))) {
                            boolean z10 = false;
                            if (i11 == 0) {
                                boolean z11 = this.done;
                                T poll = fVar.poll();
                                if (poll == null) {
                                    z10 = true;
                                }
                                if (z11 && z10) {
                                    Throwable terminate = atomicThrowable.terminate();
                                    if (terminate == null) {
                                        rVar.onComplete();
                                        return;
                                    } else {
                                        rVar.onError(terminate);
                                        return;
                                    }
                                } else if (!z10) {
                                    try {
                                        i iVar = (i) bo.b.e(this.mapper.apply(poll), "The mapper returned a null MaybeSource");
                                        this.state = 1;
                                        iVar.b(this.inner);
                                    } catch (Throwable th2) {
                                        io.reactivex.exceptions.a.b(th2);
                                        this.upstream.dispose();
                                        fVar.clear();
                                        atomicThrowable.addThrowable(th2);
                                        rVar.onError(atomicThrowable.terminate());
                                        return;
                                    }
                                }
                            } else if (i11 == 2) {
                                this.item = null;
                                rVar.onNext((R) this.item);
                                this.state = 0;
                            }
                        }
                    }
                    i10 = addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
                fVar.clear();
                this.item = null;
                rVar.onError(atomicThrowable.terminate());
            }
        }

        void b() {
            this.state = 0;
            a();
        }

        void c(Throwable th2) {
            if (this.errors.addThrowable(th2)) {
                if (this.errorMode != ErrorMode.END) {
                    this.upstream.dispose();
                }
                this.state = 0;
                a();
                return;
            }
            fo.a.s(th2);
        }

        void d(R r10) {
            this.item = r10;
            this.state = 2;
            a();
        }

        @Override // xn.b
        public void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.a();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.done = true;
            a();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.errors.addThrowable(th2)) {
                if (this.errorMode == ErrorMode.IMMEDIATE) {
                    this.inner.a();
                }
                this.done = true;
                a();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.queue.offer(t10);
            a();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public b(k<T> kVar, o<? super T, ? extends i<? extends R>> oVar, ErrorMode errorMode, int i10) {
        this.f28394a = kVar;
        this.f28395b = oVar;
        this.f28396c = errorMode;
        this.f28397d = i10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        if (!g.b(this.f28394a, this.f28395b, rVar)) {
            this.f28394a.subscribe(new a(rVar, this.f28395b, this.f28397d, this.f28396c));
        }
    }
}
