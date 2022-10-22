package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableCombineLatest.java */
/* loaded from: classes3.dex */
public final class t<T, R> extends k<R> {

    /* renamed from: a  reason: collision with root package name */
    final p<? extends T>[] f29039a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends p<? extends T>> f29040b;

    /* renamed from: c  reason: collision with root package name */
    final o<? super Object[], ? extends R> f29041c;

    /* renamed from: d  reason: collision with root package name */
    final int f29042d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f29043e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableCombineLatest.java */
    /* loaded from: classes3.dex */
    public static final class a<T, R> extends AtomicReference<xn.b> implements r<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final b<T, R> parent;

        a(b<T, R> bVar, int i10) {
            this.parent = bVar;
            this.index = i10;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.parent.d(this.index);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.parent.g(this.index, th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.parent.h(this.index, t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* compiled from: ObservableCombineLatest.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicInteger implements xn.b {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final o<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final r<? super R> downstream;
        final AtomicThrowable errors = new AtomicThrowable();
        Object[] latest;
        final a<T, R>[] observers;
        final io.reactivex.internal.queue.b<Object[]> queue;

        b(r<? super R> rVar, o<? super Object[], ? extends R> oVar, int i10, int i11, boolean z10) {
            this.downstream = rVar;
            this.combiner = oVar;
            this.delayError = z10;
            this.latest = new Object[i10];
            a<T, R>[] aVarArr = new a[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                aVarArr[i12] = new a<>(this, i12);
            }
            this.observers = aVarArr;
            this.queue = new io.reactivex.internal.queue.b<>(i11);
        }

        void a() {
            for (a<T, R> aVar : this.observers) {
                aVar.a();
            }
        }

        void b(io.reactivex.internal.queue.b<?> bVar) {
            synchronized (this) {
                this.latest = null;
            }
            bVar.clear();
        }

        void c() {
            if (getAndIncrement() == 0) {
                io.reactivex.internal.queue.b<Object[]> bVar = this.queue;
                r<? super R> rVar = this.downstream;
                boolean z10 = this.delayError;
                int i10 = 1;
                while (!this.cancelled) {
                    if (z10 || this.errors.get() == null) {
                        boolean z11 = this.done;
                        Object[] poll = bVar.poll();
                        boolean z12 = poll == null;
                        if (z11 && z12) {
                            b(bVar);
                            Throwable terminate = this.errors.terminate();
                            if (terminate == null) {
                                rVar.onComplete();
                                return;
                            } else {
                                rVar.onError(terminate);
                                return;
                            }
                        } else if (z12) {
                            i10 = addAndGet(-i10);
                            if (i10 == 0) {
                                return;
                            }
                        } else {
                            try {
                                rVar.onNext((Object) bo.b.e(this.combiner.apply(poll), "The combiner returned a null value"));
                            } catch (Throwable th2) {
                                io.reactivex.exceptions.a.b(th2);
                                this.errors.addThrowable(th2);
                                a();
                                b(bVar);
                                rVar.onError(this.errors.terminate());
                                return;
                            }
                        }
                    } else {
                        a();
                        b(bVar);
                        rVar.onError(this.errors.terminate());
                        return;
                    }
                }
                b(bVar);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0017, code lost:
            if (r2 == r0.length) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void d(int i10) {
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr != null) {
                    boolean z10 = objArr[i10] == null;
                    if (!z10) {
                        int i11 = this.complete + 1;
                        this.complete = i11;
                    }
                    this.done = true;
                    if (z10) {
                        a();
                    }
                    c();
                }
            }
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                a();
                if (getAndIncrement() == 0) {
                    b(this.queue);
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:17:0x0023, code lost:
            if (r1 == r4.length) goto L18;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void g(int i10, Throwable th2) {
            if (this.errors.addThrowable(th2)) {
                boolean z10 = true;
                if (this.delayError) {
                    synchronized (this) {
                        Object[] objArr = this.latest;
                        if (objArr != null) {
                            boolean z11 = objArr[i10] == null;
                            if (!z11) {
                                int i11 = this.complete + 1;
                                this.complete = i11;
                            }
                            this.done = true;
                            z10 = z11;
                        } else {
                            return;
                        }
                    }
                }
                if (z10) {
                    a();
                }
                c();
                return;
            }
            fo.a.s(th2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        void h(int i10, T t10) {
            boolean z10;
            synchronized (this) {
                Object[] objArr = this.latest;
                if (objArr != null) {
                    Object obj = objArr[i10];
                    int i11 = this.active;
                    if (obj == null) {
                        i11++;
                        this.active = i11;
                    }
                    objArr[i10] = t10;
                    if (i11 == objArr.length) {
                        this.queue.offer(objArr.clone());
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (z10) {
                        c();
                    }
                }
            }
        }

        public void i(p<? extends T>[] pVarArr) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            this.downstream.onSubscribe(this);
            for (int i10 = 0; i10 < length && !this.done && !this.cancelled; i10++) {
                pVarArr[i10].subscribe(aVarArr[i10]);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public t(p<? extends T>[] pVarArr, Iterable<? extends p<? extends T>> iterable, o<? super Object[], ? extends R> oVar, int i10, boolean z10) {
        this.f29039a = pVarArr;
        this.f29040b = iterable;
        this.f29041c = oVar;
        this.f29042d = i10;
        this.f29043e = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super R> rVar) {
        int i10;
        p<? extends T>[] pVarArr = this.f29039a;
        if (pVarArr == null) {
            pVarArr = new k[8];
            i10 = 0;
            for (p<? extends T> pVar : this.f29040b) {
                if (i10 == pVarArr.length) {
                    p<? extends T>[] pVarArr2 = new p[(i10 >> 2) + i10];
                    System.arraycopy(pVarArr, 0, pVarArr2, 0, i10);
                    pVarArr = pVarArr2;
                }
                i10++;
                pVarArr[i10] = pVar;
            }
        } else {
            i10 = pVarArr.length;
        }
        int i11 = i10;
        if (i11 == 0) {
            EmptyDisposable.complete(rVar);
        } else {
            new b(rVar, this.f29041c, i11, this.f29042d, this.f29043e).i(pVarArr);
        }
    }
}
