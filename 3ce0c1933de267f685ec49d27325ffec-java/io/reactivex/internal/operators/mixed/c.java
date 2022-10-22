package io.reactivex.internal.operators.mixed;

import co.f;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.u;
import io.reactivex.v;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.o;
/* compiled from: ObservableConcatMapSingle.java */
/* loaded from: classes2.dex */
public final class c<T, R> extends k<R> {

    /* renamed from: a  reason: collision with root package name */
    final k<T> f28398a;

    /* renamed from: b  reason: collision with root package name */
    final o<? super T, ? extends v<? extends R>> f28399b;

    /* renamed from: c  reason: collision with root package name */
    final ErrorMode f28400c;

    /* renamed from: d  reason: collision with root package name */
    final int f28401d;

    /* compiled from: ObservableConcatMapSingle.java */
    /* loaded from: classes2.dex */
    static final class a<T, R> extends AtomicInteger implements r<T>, b {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final r<? super R> downstream;
        final ErrorMode errorMode;
        final AtomicThrowable errors = new AtomicThrowable();
        final C0323a<R> inner = new C0323a<>(this);
        R item;
        final o<? super T, ? extends v<? extends R>> mapper;
        final f<T> queue;
        volatile int state;
        b upstream;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableConcatMapSingle.java */
        /* renamed from: io.reactivex.internal.operators.mixed.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0323a<R> extends AtomicReference<b> implements u<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final a<?, R> parent;

            C0323a(a<?, R> aVar) {
                this.parent = aVar;
            }

            void a() {
                DisposableHelper.dispose(this);
            }

            @Override // io.reactivex.u
            public void onError(Throwable th2) {
                this.parent.b(th2);
            }

            @Override // io.reactivex.u
            public void onSubscribe(b bVar) {
                DisposableHelper.replace(this, bVar);
            }

            @Override // io.reactivex.u
            public void onSuccess(R r10) {
                this.parent.c(r10);
            }
        }

        a(r<? super R> rVar, o<? super T, ? extends v<? extends R>> oVar, int i10, ErrorMode errorMode) {
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
                                        v vVar = (v) bo.b.e(this.mapper.apply(poll), "The mapper returned a null SingleSource");
                                        this.state = 1;
                                        vVar.b(this.inner);
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

        void b(Throwable th2) {
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

        void c(R r10) {
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
        public void onSubscribe(b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public c(k<T> kVar, o<? super T, ? extends v<? extends R>> oVar, ErrorMode errorMode, int i10) {
        this.f28398a = kVar;
        this.f28399b = oVar;
        this.f28400c = errorMode;
        this.f28401d = i10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        if (!g.c(this.f28398a, this.f28399b, rVar)) {
            this.f28398a.subscribe(new a(rVar, this.f28399b, this.f28401d, this.f28400c));
        }
    }
}
