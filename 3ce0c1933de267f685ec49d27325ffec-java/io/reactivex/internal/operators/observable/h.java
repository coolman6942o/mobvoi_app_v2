package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableAmb.java */
/* loaded from: classes3.dex */
public final class h<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<? extends T>[] f28682a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends p<? extends T>> f28683b;

    /* compiled from: ObservableAmb.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements xn.b {

        /* renamed from: a  reason: collision with root package name */
        final r<? super T> f28684a;

        /* renamed from: b  reason: collision with root package name */
        final b<T>[] f28685b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f28686c = new AtomicInteger();

        a(r<? super T> rVar, int i10) {
            this.f28684a = rVar;
            this.f28685b = new b[i10];
        }

        public void a(p<? extends T>[] pVarArr) {
            b<T>[] bVarArr = this.f28685b;
            int length = bVarArr.length;
            int i10 = 0;
            while (i10 < length) {
                int i11 = i10 + 1;
                bVarArr[i10] = new b<>(this, i11, this.f28684a);
                i10 = i11;
            }
            this.f28686c.lazySet(0);
            this.f28684a.onSubscribe(this);
            for (int i12 = 0; i12 < length && this.f28686c.get() == 0; i12++) {
                pVarArr[i12].subscribe(bVarArr[i12]);
            }
        }

        public boolean b(int i10) {
            int i11 = this.f28686c.get();
            int i12 = 0;
            if (i11 != 0) {
                return i11 == i10;
            }
            if (!this.f28686c.compareAndSet(0, i10)) {
                return false;
            }
            b<T>[] bVarArr = this.f28685b;
            int length = bVarArr.length;
            while (i12 < length) {
                int i13 = i12 + 1;
                if (i13 != i10) {
                    bVarArr[i12].a();
                }
                i12 = i13;
            }
            return true;
        }

        @Override // xn.b
        public void dispose() {
            if (this.f28686c.get() != -1) {
                this.f28686c.lazySet(-1);
                for (b<T> bVar : this.f28685b) {
                    bVar.a();
                }
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28686c.get() == -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableAmb.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicReference<xn.b> implements r<T> {
        private static final long serialVersionUID = -1185974347409665484L;
        final r<? super T> downstream;
        final int index;
        final a<T> parent;
        boolean won;

        b(a<T> aVar, int i10, r<? super T> rVar) {
            this.parent = aVar;
            this.index = i10;
            this.downstream = rVar;
        }

        public void a() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (this.won) {
                this.downstream.onComplete();
            } else if (this.parent.b(this.index)) {
                this.won = true;
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.won) {
                this.downstream.onError(th2);
            } else if (this.parent.b(this.index)) {
                this.won = true;
                this.downstream.onError(th2);
            } else {
                fo.a.s(th2);
            }
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (this.won) {
                this.downstream.onNext(t10);
            } else if (this.parent.b(this.index)) {
                this.won = true;
                this.downstream.onNext(t10);
            } else {
                get().dispose();
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public h(p<? extends T>[] pVarArr, Iterable<? extends p<? extends T>> iterable) {
        this.f28682a = pVarArr;
        this.f28683b = iterable;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super T> rVar) {
        int i10;
        p<? extends T>[] pVarArr = this.f28682a;
        if (pVarArr == null) {
            pVarArr = new k[8];
            try {
                i10 = 0;
                for (p<? extends T> pVar : this.f28683b) {
                    if (pVar == null) {
                        EmptyDisposable.error(new NullPointerException("One of the sources is null"), rVar);
                        return;
                    }
                    if (i10 == pVarArr.length) {
                        p<? extends T>[] pVarArr2 = new p[(i10 >> 2) + i10];
                        System.arraycopy(pVarArr, 0, pVarArr2, 0, i10);
                        pVarArr = pVarArr2;
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
            EmptyDisposable.complete(rVar);
        } else if (i10 == 1) {
            pVarArr[0].subscribe(rVar);
        } else {
            new a(rVar, i10).a(pVarArr);
        }
    }
}
