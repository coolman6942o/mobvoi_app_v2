package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.AtomicThrowable;
import io.reactivex.internal.util.g;
import io.reactivex.p;
import io.reactivex.r;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import zn.o;
/* compiled from: ObservableWithLatestFromMany.java */
/* loaded from: classes3.dex */
public final class h4<T, R> extends io.reactivex.internal.operators.observable.a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final p<?>[] f28706b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<? extends p<?>> f28707c;

    /* renamed from: d  reason: collision with root package name */
    final o<? super Object[], R> f28708d;

    /* compiled from: ObservableWithLatestFromMany.java */
    /* loaded from: classes3.dex */
    final class a implements o<T, R> {
        a() {
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object[], java.lang.Object] */
        @Override // zn.o
        public R apply(T t10) throws Exception {
            return (R) bo.b.e(h4.this.f28708d.apply(new Object[]{t10}), "The combiner returned a null value");
        }
    }

    /* compiled from: ObservableWithLatestFromMany.java */
    /* loaded from: classes3.dex */
    static final class b<T, R> extends AtomicInteger implements r<T>, xn.b {
        private static final long serialVersionUID = 1577321883966341961L;
        final o<? super Object[], R> combiner;
        volatile boolean done;
        final r<? super R> downstream;
        final AtomicThrowable error;
        final c[] observers;
        final AtomicReference<xn.b> upstream;
        final AtomicReferenceArray<Object> values;

        b(r<? super R> rVar, o<? super Object[], R> oVar, int i10) {
            this.downstream = rVar;
            this.combiner = oVar;
            c[] cVarArr = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                cVarArr[i11] = new c(this, i11);
            }
            this.observers = cVarArr;
            this.values = new AtomicReferenceArray<>(i10);
            this.upstream = new AtomicReference<>();
            this.error = new AtomicThrowable();
        }

        void a(int i10) {
            c[] cVarArr = this.observers;
            for (int i11 = 0; i11 < cVarArr.length; i11++) {
                if (i11 != i10) {
                    cVarArr[i11].a();
                }
            }
        }

        void b(int i10, boolean z10) {
            if (!z10) {
                this.done = true;
                a(i10);
                g.a(this.downstream, this, this.error);
            }
        }

        void c(int i10, Throwable th2) {
            this.done = true;
            DisposableHelper.dispose(this.upstream);
            a(i10);
            g.c(this.downstream, th2, this, this.error);
        }

        void d(int i10, Object obj) {
            this.values.set(i10, obj);
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.upstream);
            for (c cVar : this.observers) {
                cVar.a();
            }
        }

        void g(p<?>[] pVarArr, int i10) {
            c[] cVarArr = this.observers;
            AtomicReference<xn.b> atomicReference = this.upstream;
            for (int i11 = 0; i11 < i10 && !DisposableHelper.isDisposed(atomicReference.get()) && !this.done; i11++) {
                pVarArr[i11].subscribe(cVarArr[i11]);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(this.upstream.get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                a(-1);
                g.a(this.downstream, this, this.error);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.done) {
                fo.a.s(th2);
                return;
            }
            this.done = true;
            a(-1);
            g.c(this.downstream, th2, this, this.error);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.done) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.values;
                int length = atomicReferenceArray.length();
                Object[] objArr = new Object[length + 1];
                int i10 = 0;
                objArr[0] = t10;
                while (i10 < length) {
                    Object obj = atomicReferenceArray.get(i10);
                    if (obj != null) {
                        i10++;
                        objArr[i10] = obj;
                    } else {
                        return;
                    }
                }
                try {
                    g.e(this.downstream, bo.b.e(this.combiner.apply(objArr), "combiner returned a null value"), this, this.error);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    dispose();
                    onError(th2);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.upstream, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWithLatestFromMany.java */
    /* loaded from: classes3.dex */
    public static final class c extends AtomicReference<xn.b> implements r<Object> {
        private static final long serialVersionUID = 3256684027868224024L;
        boolean hasValue;
        final int index;
        final b<?, ?> parent;

        c(b<?, ?> bVar, int i10) {
            this.parent = bVar;
            this.index = i10;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.parent.b(this.index, this.hasValue);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.parent.c(this.index, th2);
        }

        @Override // io.reactivex.r
        public void onNext(Object obj) {
            if (!this.hasValue) {
                this.hasValue = true;
            }
            this.parent.d(this.index, obj);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public h4(p<T> pVar, p<?>[] pVarArr, o<? super Object[], R> oVar) {
        super(pVar);
        this.f28706b = pVarArr;
        this.f28707c = null;
        this.f28708d = oVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        int i10;
        p<?>[] pVarArr = this.f28706b;
        if (pVarArr == null) {
            pVarArr = new p[8];
            try {
                i10 = 0;
                for (p<?> pVar : this.f28707c) {
                    if (i10 == pVarArr.length) {
                        pVarArr = (p[]) Arrays.copyOf(pVarArr, (i10 >> 1) + i10);
                    }
                    i10++;
                    pVarArr[i10] = pVar;
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, rVar);
                return;
            }
        } else {
            i10 = pVarArr.length;
        }
        if (i10 == 0) {
            new u1(this.f28426a, new a()).subscribeActual(rVar);
            return;
        }
        b bVar = new b(rVar, this.f28708d, i10);
        rVar.onSubscribe(bVar);
        bVar.g(pVarArr, i10);
        this.f28426a.subscribe(bVar);
    }

    public h4(p<T> pVar, Iterable<? extends p<?>> iterable, o<? super Object[], R> oVar) {
        super(pVar);
        this.f28706b = null;
        this.f28707c = iterable;
        this.f28708d = oVar;
    }
}
