package io.reactivex.internal.operators.observable;

import io.reactivex.k;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableCache.java */
/* loaded from: classes3.dex */
public final class q<T> extends io.reactivex.internal.operators.observable.a<T, T> implements r<T> {

    /* renamed from: k  reason: collision with root package name */
    static final a[] f28967k = new a[0];

    /* renamed from: l  reason: collision with root package name */
    static final a[] f28968l = new a[0];

    /* renamed from: c  reason: collision with root package name */
    final int f28970c;

    /* renamed from: e  reason: collision with root package name */
    volatile long f28972e;

    /* renamed from: f  reason: collision with root package name */
    final b<T> f28973f;

    /* renamed from: g  reason: collision with root package name */
    b<T> f28974g;

    /* renamed from: h  reason: collision with root package name */
    int f28975h;

    /* renamed from: i  reason: collision with root package name */
    Throwable f28976i;

    /* renamed from: j  reason: collision with root package name */
    volatile boolean f28977j;

    /* renamed from: b  reason: collision with root package name */
    final AtomicBoolean f28969b = new AtomicBoolean();

    /* renamed from: d  reason: collision with root package name */
    final AtomicReference<a<T>[]> f28971d = new AtomicReference<>(f28967k);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableCache.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicInteger implements xn.b {
        private static final long serialVersionUID = 6770240836423125754L;
        volatile boolean disposed;
        final r<? super T> downstream;
        long index;
        b<T> node;
        int offset;
        final q<T> parent;

        a(r<? super T> rVar, q<T> qVar) {
            this.downstream = rVar;
            this.parent = qVar;
            this.node = qVar.f28973f;
        }

        @Override // xn.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.parent.c(this);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableCache.java */
    /* loaded from: classes3.dex */
    public static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        final T[] f28978a;

        /* renamed from: b  reason: collision with root package name */
        volatile b<T> f28979b;

        b(int i10) {
            this.f28978a = (T[]) new Object[i10];
        }
    }

    public q(k<T> kVar, int i10) {
        super(kVar);
        this.f28970c = i10;
        b<T> bVar = new b<>(i10);
        this.f28973f = bVar;
        this.f28974g = bVar;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f28971d.get();
            if (aVarArr != f28968l) {
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } else {
                return;
            }
        } while (!this.f28971d.compareAndSet(aVarArr, aVarArr2));
    }

    void c(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f28971d.get();
            int length = aVarArr.length;
            if (length != 0) {
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (aVarArr[i11] == aVar) {
                        i10 = i11;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i10 >= 0) {
                    if (length == 1) {
                        aVarArr2 = f28967k;
                    } else {
                        a<T>[] aVarArr3 = new a[length - 1];
                        System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                        System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                        aVarArr2 = aVarArr3;
                    }
                } else {
                    return;
                }
            } else {
                return;
            }
        } while (!this.f28971d.compareAndSet(aVarArr, aVarArr2));
    }

    void d(a<T> aVar) {
        if (aVar.getAndIncrement() == 0) {
            long j10 = aVar.index;
            int i10 = aVar.offset;
            b<T> bVar = aVar.node;
            r<? super T> rVar = aVar.downstream;
            int i11 = this.f28970c;
            int i12 = 1;
            while (!aVar.disposed) {
                boolean z10 = this.f28977j;
                boolean z11 = this.f28972e == j10;
                if (z10 && z11) {
                    aVar.node = null;
                    Throwable th2 = this.f28976i;
                    if (th2 != null) {
                        rVar.onError(th2);
                        return;
                    } else {
                        rVar.onComplete();
                        return;
                    }
                } else if (!z11) {
                    if (i10 == i11) {
                        bVar = bVar.f28979b;
                        i10 = 0;
                    }
                    rVar.onNext((Object) bVar.f28978a[i10]);
                    i10++;
                    j10++;
                } else {
                    aVar.index = j10;
                    aVar.offset = i10;
                    aVar.node = bVar;
                    i12 = aVar.addAndGet(-i12);
                    if (i12 == 0) {
                        return;
                    }
                }
            }
            aVar.node = null;
        }
    }

    @Override // io.reactivex.r
    public void onComplete() {
        this.f28977j = true;
        for (a<T> aVar : this.f28971d.getAndSet(f28968l)) {
            d(aVar);
        }
    }

    @Override // io.reactivex.r
    public void onError(Throwable th2) {
        this.f28976i = th2;
        this.f28977j = true;
        for (a<T> aVar : this.f28971d.getAndSet(f28968l)) {
            d(aVar);
        }
    }

    @Override // io.reactivex.r
    public void onNext(T t10) {
        int i10 = this.f28975h;
        if (i10 == this.f28970c) {
            b<T> bVar = new b<>(i10);
            bVar.f28978a[0] = t10;
            this.f28975h = 1;
            this.f28974g.f28979b = bVar;
            this.f28974g = bVar;
        } else {
            this.f28974g.f28978a[i10] = t10;
            this.f28975h = i10 + 1;
        }
        this.f28972e++;
        for (a<T> aVar : this.f28971d.get()) {
            d(aVar);
        }
    }

    @Override // io.reactivex.r
    public void onSubscribe(xn.b bVar) {
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        a<T> aVar = new a<>(rVar, this);
        rVar.onSubscribe(aVar);
        b(aVar);
        if (this.f28969b.get() || !this.f28969b.compareAndSet(false, true)) {
            d(aVar);
        } else {
            this.f28426a.subscribe(this);
        }
    }
}
