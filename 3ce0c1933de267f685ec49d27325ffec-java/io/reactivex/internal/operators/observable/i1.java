package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.f;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableGroupJoin.java */
/* loaded from: classes3.dex */
public final class i1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends io.reactivex.internal.operators.observable.a<TLeft, R> {

    /* renamed from: b  reason: collision with root package name */
    final p<? extends TRight> f28717b;

    /* renamed from: c  reason: collision with root package name */
    final o<? super TLeft, ? extends p<TLeftEnd>> f28718c;

    /* renamed from: d  reason: collision with root package name */
    final o<? super TRight, ? extends p<TRightEnd>> f28719d;

    /* renamed from: e  reason: collision with root package name */
    final zn.c<? super TLeft, ? super k<TRight>, ? extends R> f28720e;

    /* compiled from: ObservableGroupJoin.java */
    /* loaded from: classes3.dex */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements xn.b, b {
        private static final long serialVersionUID = -6071216598687999801L;
        volatile boolean cancelled;
        final r<? super R> downstream;
        final o<? super TLeft, ? extends p<TLeftEnd>> leftEnd;
        int leftIndex;
        final zn.c<? super TLeft, ? super k<TRight>, ? extends R> resultSelector;
        final o<? super TRight, ? extends p<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final xn.a disposables = new xn.a();
        final io.reactivex.internal.queue.b<Object> queue = new io.reactivex.internal.queue.b<>(k.bufferSize());
        final Map<Integer, io.reactivex.subjects.d<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(r<? super R> rVar, o<? super TLeft, ? extends p<TLeftEnd>> oVar, o<? super TRight, ? extends p<TRightEnd>> oVar2, zn.c<? super TLeft, ? super k<TRight>, ? extends R> cVar) {
            this.downstream = rVar;
            this.leftEnd = oVar;
            this.rightEnd = oVar2;
            this.resultSelector = cVar;
        }

        @Override // io.reactivex.internal.operators.observable.i1.b
        public void a(boolean z10, c cVar) {
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
        public void c(d dVar) {
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
                        for (io.reactivex.subjects.d<TRight> dVar : this.lefts.values()) {
                            dVar.onComplete();
                        }
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
                            io.reactivex.subjects.d<TRight> c10 = io.reactivex.subjects.d.c();
                            int i11 = this.leftIndex;
                            this.leftIndex = i11 + 1;
                            this.lefts.put(Integer.valueOf(i11), c10);
                            try {
                                p pVar = (p) bo.b.e(this.leftEnd.apply(poll), "The leftEnd returned a null ObservableSource");
                                c cVar = new c(this, true, i11);
                                this.disposables.b(cVar);
                                pVar.subscribe(cVar);
                                if (this.error.get() != null) {
                                    bVar.clear();
                                    h();
                                    j(rVar);
                                    return;
                                }
                                try {
                                    rVar.onNext((Object) bo.b.e(this.resultSelector.apply(poll, c10), "The resultSelector returned a null value"));
                                    for (TRight tright : this.rights.values()) {
                                        c10.onNext(tright);
                                    }
                                } catch (Throwable th2) {
                                    k(th2, rVar, bVar);
                                    return;
                                }
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
                                c cVar2 = new c(this, false, i12);
                                this.disposables.b(cVar2);
                                pVar2.subscribe(cVar2);
                                if (this.error.get() != null) {
                                    bVar.clear();
                                    h();
                                    j(rVar);
                                    return;
                                }
                                for (io.reactivex.subjects.d<TRight> dVar2 : this.lefts.values()) {
                                    dVar2.onNext(poll);
                                }
                            } catch (Throwable th4) {
                                k(th4, rVar, bVar);
                                return;
                            }
                        } else if (num == LEFT_CLOSE) {
                            c cVar3 = (c) poll;
                            io.reactivex.subjects.d<TRight> remove = this.lefts.remove(Integer.valueOf(cVar3.index));
                            this.disposables.c(cVar3);
                            if (remove != null) {
                                remove.onComplete();
                            }
                        } else if (num == RIGHT_CLOSE) {
                            c cVar4 = (c) poll;
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
            for (io.reactivex.subjects.d<TRight> dVar : this.lefts.values()) {
                dVar.onError(b10);
            }
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableGroupJoin.java */
    /* loaded from: classes3.dex */
    public interface b {
        void a(boolean z10, c cVar);

        void b(Throwable th2);

        void c(d dVar);

        void d(boolean z10, Object obj);

        void g(Throwable th2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableGroupJoin.java */
    /* loaded from: classes3.dex */
    public static final class c extends AtomicReference<xn.b> implements r<Object>, xn.b {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final b parent;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(b bVar, boolean z10, int i10) {
            this.parent = bVar;
            this.isLeft = z10;
            this.index = i10;
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.parent.a(this.isLeft, this);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.parent.b(th2);
        }

        @Override // io.reactivex.r
        public void onNext(Object obj) {
            if (DisposableHelper.dispose(this)) {
                this.parent.a(this.isLeft, this);
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    /* compiled from: ObservableGroupJoin.java */
    /* loaded from: classes3.dex */
    static final class d extends AtomicReference<xn.b> implements r<Object>, xn.b {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final b parent;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(b bVar, boolean z10) {
            this.parent = bVar;
            this.isLeft = z10;
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return DisposableHelper.isDisposed(get());
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.parent.c(this);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.parent.g(th2);
        }

        @Override // io.reactivex.r
        public void onNext(Object obj) {
            this.parent.d(this.isLeft, obj);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public i1(p<TLeft> pVar, p<? extends TRight> pVar2, o<? super TLeft, ? extends p<TLeftEnd>> oVar, o<? super TRight, ? extends p<TRightEnd>> oVar2, zn.c<? super TLeft, ? super k<TRight>, ? extends R> cVar) {
        super(pVar);
        this.f28717b = pVar2;
        this.f28718c = oVar;
        this.f28719d = oVar2;
        this.f28720e = cVar;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super R> rVar) {
        a aVar = new a(rVar, this.f28718c, this.f28719d, this.f28720e);
        rVar.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.disposables.b(dVar);
        d dVar2 = new d(aVar, false);
        aVar.disposables.b(dVar2);
        this.f28426a.subscribe(dVar);
        this.f28717b.subscribe(dVar2);
    }
}
