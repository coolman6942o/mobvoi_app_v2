package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.concurrent.atomic.AtomicInteger;
import zn.d;
/* compiled from: ObservableSequenceEqual.java */
/* loaded from: classes3.dex */
public final class x2<T> extends k<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final p<? extends T> f29121a;

    /* renamed from: b  reason: collision with root package name */
    final p<? extends T> f29122b;

    /* renamed from: c  reason: collision with root package name */
    final d<? super T, ? super T> f29123c;

    /* renamed from: d  reason: collision with root package name */
    final int f29124d;

    /* compiled from: ObservableSequenceEqual.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends AtomicInteger implements xn.b {
        private static final long serialVersionUID = -6178010334400373240L;
        volatile boolean cancelled;
        final d<? super T, ? super T> comparer;
        final r<? super Boolean> downstream;
        final p<? extends T> first;
        final b<T>[] observers;
        final ArrayCompositeDisposable resources = new ArrayCompositeDisposable(2);
        final p<? extends T> second;

        /* renamed from: v1  reason: collision with root package name */
        T f29125v1;

        /* renamed from: v2  reason: collision with root package name */
        T f29126v2;

        a(r<? super Boolean> rVar, int i10, p<? extends T> pVar, p<? extends T> pVar2, d<? super T, ? super T> dVar) {
            this.downstream = rVar;
            this.first = pVar;
            this.second = pVar2;
            this.comparer = dVar;
            this.observers = r3;
            b<T>[] bVarArr = {new b<>(this, 0, i10), new b<>(this, 1, i10)};
        }

        void a(io.reactivex.internal.queue.b<T> bVar, io.reactivex.internal.queue.b<T> bVar2) {
            this.cancelled = true;
            bVar.clear();
            bVar2.clear();
        }

        void b() {
            Throwable th2;
            Throwable th3;
            if (getAndIncrement() == 0) {
                b<T>[] bVarArr = this.observers;
                b<T> bVar = bVarArr[0];
                io.reactivex.internal.queue.b<T> bVar2 = bVar.f29128b;
                b<T> bVar3 = bVarArr[1];
                io.reactivex.internal.queue.b<T> bVar4 = bVar3.f29128b;
                int i10 = 1;
                while (!this.cancelled) {
                    boolean z10 = bVar.f29130d;
                    if (!z10 || (th3 = bVar.f29131e) == null) {
                        boolean z11 = bVar3.f29130d;
                        if (!z11 || (th2 = bVar3.f29131e) == null) {
                            if (this.f29125v1 == null) {
                                this.f29125v1 = bVar2.poll();
                            }
                            boolean z12 = this.f29125v1 == null;
                            if (this.f29126v2 == null) {
                                this.f29126v2 = bVar4.poll();
                            }
                            T t10 = this.f29126v2;
                            boolean z13 = t10 == null;
                            if (z10 && z11 && z12 && z13) {
                                this.downstream.onNext(Boolean.TRUE);
                                this.downstream.onComplete();
                                return;
                            } else if (!z10 || !z11 || z12 == z13) {
                                if (!z12 && !z13) {
                                    try {
                                        if (!this.comparer.test((T) this.f29125v1, t10)) {
                                            a(bVar2, bVar4);
                                            this.downstream.onNext(Boolean.FALSE);
                                            this.downstream.onComplete();
                                            return;
                                        }
                                        this.f29125v1 = null;
                                        this.f29126v2 = null;
                                    } catch (Throwable th4) {
                                        io.reactivex.exceptions.a.b(th4);
                                        a(bVar2, bVar4);
                                        this.downstream.onError(th4);
                                        return;
                                    }
                                }
                                if (z12 || z13) {
                                    i10 = addAndGet(-i10);
                                    if (i10 == 0) {
                                        return;
                                    }
                                }
                            } else {
                                a(bVar2, bVar4);
                                this.downstream.onNext(Boolean.FALSE);
                                this.downstream.onComplete();
                                return;
                            }
                        } else {
                            a(bVar2, bVar4);
                            this.downstream.onError(th2);
                            return;
                        }
                    } else {
                        a(bVar2, bVar4);
                        this.downstream.onError(th3);
                        return;
                    }
                }
                bVar2.clear();
                bVar4.clear();
            }
        }

        boolean c(xn.b bVar, int i10) {
            return this.resources.setResource(i10, bVar);
        }

        void d() {
            b<T>[] bVarArr = this.observers;
            this.first.subscribe(bVarArr[0]);
            this.second.subscribe(bVarArr[1]);
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.resources.dispose();
                if (getAndIncrement() == 0) {
                    b<T>[] bVarArr = this.observers;
                    bVarArr[0].f29128b.clear();
                    bVarArr[1].f29128b.clear();
                }
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableSequenceEqual.java */
    /* loaded from: classes3.dex */
    public static final class b<T> implements r<T> {

        /* renamed from: a  reason: collision with root package name */
        final a<T> f29127a;

        /* renamed from: b  reason: collision with root package name */
        final io.reactivex.internal.queue.b<T> f29128b;

        /* renamed from: c  reason: collision with root package name */
        final int f29129c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f29130d;

        /* renamed from: e  reason: collision with root package name */
        Throwable f29131e;

        b(a<T> aVar, int i10, int i11) {
            this.f29127a = aVar;
            this.f29129c = i10;
            this.f29128b = new io.reactivex.internal.queue.b<>(i11);
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f29130d = true;
            this.f29127a.b();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f29131e = th2;
            this.f29130d = true;
            this.f29127a.b();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.f29128b.offer(t10);
            this.f29127a.b();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            this.f29127a.c(bVar, this.f29129c);
        }
    }

    public x2(p<? extends T> pVar, p<? extends T> pVar2, d<? super T, ? super T> dVar, int i10) {
        this.f29121a = pVar;
        this.f29122b = pVar2;
        this.f29123c = dVar;
        this.f29124d = i10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super Boolean> rVar) {
        a aVar = new a(rVar, this.f29124d, this.f29121a, this.f29122b, this.f29123c);
        rVar.onSubscribe(aVar);
        aVar.d();
    }
}
