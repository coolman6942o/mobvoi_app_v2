package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableZip.java */
/* loaded from: classes3.dex */
public final class i4<T, R> extends k<R> {

    /* renamed from: a  reason: collision with root package name */
    final p<? extends T>[] f28733a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends p<? extends T>> f28734b;

    /* renamed from: c  reason: collision with root package name */
    final o<? super Object[], ? extends R> f28735c;

    /* renamed from: d  reason: collision with root package name */
    final int f28736d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f28737e;

    /* compiled from: ObservableZip.java */
    /* loaded from: classes3.dex */
    static final class a<T, R> extends AtomicInteger implements xn.b {
        private static final long serialVersionUID = 2983708048395377667L;
        volatile boolean cancelled;
        final boolean delayError;
        final r<? super R> downstream;
        final b<T, R>[] observers;
        final T[] row;
        final o<? super Object[], ? extends R> zipper;

        a(r<? super R> rVar, o<? super Object[], ? extends R> oVar, int i10, boolean z10) {
            this.downstream = rVar;
            this.zipper = oVar;
            this.observers = new b[i10];
            this.row = (T[]) new Object[i10];
            this.delayError = z10;
        }

        void a() {
            d();
            b();
        }

        void b() {
            for (b<T, R> bVar : this.observers) {
                bVar.a();
            }
        }

        boolean c(boolean z10, boolean z11, r<? super R> rVar, boolean z12, b<?, ?> bVar) {
            if (this.cancelled) {
                a();
                return true;
            } else if (!z10) {
                return false;
            } else {
                if (!z12) {
                    Throwable th2 = bVar.f28741d;
                    if (th2 != null) {
                        this.cancelled = true;
                        a();
                        rVar.onError(th2);
                        return true;
                    } else if (!z11) {
                        return false;
                    } else {
                        this.cancelled = true;
                        a();
                        rVar.onComplete();
                        return true;
                    }
                } else if (!z11) {
                    return false;
                } else {
                    Throwable th3 = bVar.f28741d;
                    this.cancelled = true;
                    a();
                    if (th3 != null) {
                        rVar.onError(th3);
                    } else {
                        rVar.onComplete();
                    }
                    return true;
                }
            }
        }

        void d() {
            for (b<T, R> bVar : this.observers) {
                bVar.f28739b.clear();
            }
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                b();
                if (getAndIncrement() == 0) {
                    d();
                }
            }
        }

        public void g() {
            Throwable th2;
            if (getAndIncrement() == 0) {
                b<T, R>[] bVarArr = this.observers;
                r<? super R> rVar = this.downstream;
                T[] tArr = this.row;
                boolean z10 = this.delayError;
                int i10 = 1;
                while (true) {
                    int i11 = 0;
                    int i12 = 0;
                    for (b<T, R> bVar : bVarArr) {
                        if (tArr[i12] == null) {
                            boolean z11 = bVar.f28740c;
                            T poll = bVar.f28739b.poll();
                            boolean z12 = poll == null;
                            if (c(z11, z12, rVar, z10, bVar)) {
                                return;
                            }
                            if (!z12) {
                                tArr[i12] = poll;
                            } else {
                                i11++;
                            }
                        } else if (bVar.f28740c && !z10 && (th2 = bVar.f28741d) != null) {
                            this.cancelled = true;
                            a();
                            rVar.onError(th2);
                            return;
                        }
                        i12++;
                    }
                    if (i11 != 0) {
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        try {
                            rVar.onNext((Object) bo.b.e(this.zipper.apply(tArr.clone()), "The zipper returned a null value"));
                            Arrays.fill(tArr, (Object) null);
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            a();
                            rVar.onError(th3);
                            return;
                        }
                    }
                }
            }
        }

        public void h(p<? extends T>[] pVarArr, int i10) {
            b<T, R>[] bVarArr = this.observers;
            int length = bVarArr.length;
            for (int i11 = 0; i11 < length; i11++) {
                bVarArr[i11] = new b<>(this, i10);
            }
            lazySet(0);
            this.downstream.onSubscribe(this);
            for (int i12 = 0; i12 < length && !this.cancelled; i12++) {
                pVarArr[i12].subscribe(bVarArr[i12]);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableZip.java */
    /* loaded from: classes3.dex */
    public static final class b<T, R> implements r<T> {

        /* renamed from: a  reason: collision with root package name */
        final a<T, R> f28738a;

        /* renamed from: b  reason: collision with root package name */
        final io.reactivex.internal.queue.b<T> f28739b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f28740c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f28741d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReference<xn.b> f28742e = new AtomicReference<>();

        b(a<T, R> aVar, int i10) {
            this.f28738a = aVar;
            this.f28739b = new io.reactivex.internal.queue.b<>(i10);
        }

        public void a() {
            DisposableHelper.dispose(this.f28742e);
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28740c = true;
            this.f28738a.g();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28741d = th2;
            this.f28740c = true;
            this.f28738a.g();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f28739b.offer(t10);
            this.f28738a.g();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this.f28742e, bVar);
        }
    }

    public i4(p<? extends T>[] pVarArr, Iterable<? extends p<? extends T>> iterable, o<? super Object[], ? extends R> oVar, int i10, boolean z10) {
        this.f28733a = pVarArr;
        this.f28734b = iterable;
        this.f28735c = oVar;
        this.f28736d = i10;
        this.f28737e = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super R> rVar) {
        int i10;
        p<? extends T>[] pVarArr = this.f28733a;
        if (pVarArr == null) {
            pVarArr = new k[8];
            i10 = 0;
            for (p<? extends T> pVar : this.f28734b) {
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
        if (i10 == 0) {
            EmptyDisposable.complete(rVar);
        } else {
            new a(rVar, this.f28735c, i10, this.f28737e).h(pVarArr, this.f28736d);
        }
    }
}
