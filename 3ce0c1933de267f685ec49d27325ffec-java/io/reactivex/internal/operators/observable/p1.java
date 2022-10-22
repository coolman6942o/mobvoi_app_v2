package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.i1;
import io.reactivex.internal.util.f;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import xn.b;
import zn.c;
import zn.o;
/* compiled from: ObservableJoin.java */
/* loaded from: classes3.dex */
public final class p1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends io.reactivex.internal.operators.observable.a<TLeft, R> {

    /* renamed from: b  reason: collision with root package name */
    final p<? extends TRight> f28941b;

    /* renamed from: c  reason: collision with root package name */
    final o<? super TLeft, ? extends p<TLeftEnd>> f28942c;

    /* renamed from: d  reason: collision with root package name */
    final o<? super TRight, ? extends p<TRightEnd>> f28943d;

    /* renamed from: e  reason: collision with root package name */
    final c<? super TLeft, ? super TRight, ? extends R> f28944e;

    /* compiled from: ObservableJoin.java */
    /* loaded from: classes3.dex */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements b, i1.b {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final r<? super R> downstream;
        final o<? super TLeft, ? extends p<TLeftEnd>> leftEnd;
        int leftIndex;
        final c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final o<? super TRight, ? extends p<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final xn.a disposables = new xn.a();
        final io.reactivex.internal.queue.b<Object> queue = new io.reactivex.internal.queue.b<>(k.bufferSize());
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(r<? super R> rVar, o<? super TLeft, ? extends p<TLeftEnd>> oVar, o<? super TRight, ? extends p<TRightEnd>> oVar2, c<? super TLeft, ? super TRight, ? extends R> cVar) {
            this.downstream = rVar;
            this.leftEnd = oVar;
            this.rightEnd = oVar2;
            this.resultSelector = cVar;
        }

        @Override // io.reactivex.internal.operators.observable.i1.b
        public void a(boolean z10, i1.c cVar) {
            synchronized (this) {
                this.queue.l(z10 ? LEFT_CLOSE : RIGHT_CLOSE, cVar);
            }
            i();
        }

        @Override // io.reactivex.internal.operators.observable.i1.b
        public void b(Throwable th2) {
            if (f.a(this.error, th2)) {
                i();
            } else {
                fo.a.s(th2);
            }
        }

        @Override // io.reactivex.internal.operators.observable.i1.b
        public void c(i1.d dVar) {
            this.disposables.a(dVar);
            this.active.decrementAndGet();
            i();
        }

        @Override // io.reactivex.internal.operators.observable.i1.b
        public void d(boolean z10, Object obj) {
            synchronized (this) {
                this.queue.l(z10 ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            i();
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                h();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        @Override // io.reactivex.internal.operators.observable.i1.b
        public void g(Throwable th2) {
            if (f.a(this.error, th2)) {
                this.active.decrementAndGet();
                i();
                return;
            }
            fo.a.s(th2);
        }

        void h() {
            this.disposables.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void i() {
            if (getAndIncrement() == 0) {
                io.reactivex.internal.queue.b<?> bVar = this.queue;
                r<? super R> rVar = this.downstream;
                int i10 = 1;
                while (!this.cancelled) {
                    if (this.error.get() != null) {
                        bVar.clear();
                        h();
                        j(rVar);
                        return;
                    }
                    boolean z10 = this.active.get() == 0;
                    Integer num = (Integer) bVar.poll();
                    boolean z11 = num == null;
                    if (z10 && z11) {
                        this.lefts.clear();
                        this.rights.clear();
                        this.disposables.dispose();
                        rVar.onComplete();
                        return;
                    } else if (z11) {
                        i10 = addAndGet(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else {
                        Object poll = bVar.poll();
                        if (num == LEFT_VALUE) {
                            int i11 = this.leftIndex;
                            this.leftIndex = i11 + 1;
                            this.lefts.put(Integer.valueOf(i11), poll);
                            try {
                                p pVar = (p) bo.b.e(this.leftEnd.apply(poll), "The leftEnd returned a null ObservableSource");
                                i1.c cVar = new i1.c(this, true, i11);
                                this.disposables.b(cVar);
                                pVar.subscribe(cVar);
                                if (this.error.get() != null) {
                                    bVar.clear();
                                    h();
                                    j(rVar);
                                    return;
                                }
                                for (TRight tright : this.rights.values()) {
                                    try {
                                        rVar.onNext((Object) bo.b.e(this.resultSelector.apply(poll, tright), "The resultSelector returned a null value"));
                                    } catch (Throwable th2) {
                                        k(th2, rVar, bVar);
                                        return;
                                    }
                                }
                                continue;
                            } catch (Throwable th3) {
                                k(th3, rVar, bVar);
                                return;
                            }
                        } else if (num == RIGHT_VALUE) {
                            int i12 = this.rightIndex;
                            this.rightIndex = i12 + 1;
                            this.rights.put(Integer.valueOf(i12), poll);
                            try {
                                p pVar2 = (p) bo.b.e(this.rightEnd.apply(poll), "The rightEnd returned a null ObservableSource");
                                i1.c cVar2 = new i1.c(this, false, i12);
                                this.disposables.b(cVar2);
                                pVar2.subscribe(cVar2);
                                if (this.error.get() != null) {
                                    bVar.clear();
                                    h();
                                    j(rVar);
                                    return;
                                }
                                for (TLeft tleft : this.lefts.values()) {
                                    try {
                                        rVar.onNext((Object) bo.b.e(this.resultSelector.apply(tleft, poll), "The resultSelector returned a null value"));
                                    } catch (Throwable th4) {
                                        k(th4, rVar, bVar);
                                        return;
                                    }
                                }
                                continue;
                            } catch (Throwable th5) {
                                k(th5, rVar, bVar);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            i1.c cVar3 = (i1.c) poll;
                            this.lefts.remove(Integer.valueOf(cVar3.index));
                            this.disposables.c(cVar3);
                        } else {
                            i1.c cVar4 = (i1.c) poll;
                            this.rights.remove(Integer.valueOf(cVar4.index));
                            this.disposables.c(cVar4);
                        }
                    }
                }
                bVar.clear();
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }

        void j(r<?> rVar) {
            Throwable b10 = f.b(this.error);
            this.lefts.clear();
            this.rights.clear();
            rVar.onError(b10);
        }

        void k(Throwable th2, r<?> rVar, io.reactivex.internal.queue.b<?> bVar) {
            io.reactivex.exceptions.a.b(th2);
            f.a(this.error, th2);
            bVar.clear();
            h();
            j(rVar);
        }
    }

    public p1(p<TLeft> pVar, p<? extends TRight> pVar2, o<? super TLeft, ? extends p<TLeftEnd>> oVar, o<? super TRight, ? extends p<TRightEnd>> oVar2, c<? super TLeft, ? super TRight, ? extends R> cVar) {
        super(pVar);
        this.f28941b = pVar2;
        this.f28942c = oVar;
        this.f28943d = oVar2;
        this.f28944e = cVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        a aVar = new a(rVar, this.f28942c, this.f28943d, this.f28944e);
        rVar.onSubscribe(aVar);
        i1.d dVar = new i1.d(aVar, true);
        aVar.disposables.b(dVar);
        i1.d dVar2 = new i1.d(aVar, false);
        aVar.disposables.b(dVar2);
        this.f28426a.subscribe(dVar);
        this.f28941b.subscribe(dVar2);
    }
}
