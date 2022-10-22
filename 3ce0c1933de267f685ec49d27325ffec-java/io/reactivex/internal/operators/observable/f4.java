package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.j;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.subjects.d;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableWindowTimed.java */
/* loaded from: classes3.dex */
public final class f4<T> extends io.reactivex.internal.operators.observable.a<T, k<T>> {

    /* renamed from: b  reason: collision with root package name */
    final long f28615b;

    /* renamed from: c  reason: collision with root package name */
    final long f28616c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f28617d;

    /* renamed from: e  reason: collision with root package name */
    final s f28618e;

    /* renamed from: f  reason: collision with root package name */
    final long f28619f;

    /* renamed from: g  reason: collision with root package name */
    final int f28620g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f28621h;

    /* compiled from: ObservableWindowTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T> extends j<T, Object, k<T>> implements xn.b {

        /* renamed from: g  reason: collision with root package name */
        final long f28622g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f28623h;

        /* renamed from: i  reason: collision with root package name */
        final s f28624i;

        /* renamed from: j  reason: collision with root package name */
        final int f28625j;

        /* renamed from: k  reason: collision with root package name */
        final boolean f28626k;

        /* renamed from: l  reason: collision with root package name */
        final long f28627l;

        /* renamed from: m  reason: collision with root package name */
        final s.c f28628m;

        /* renamed from: n  reason: collision with root package name */
        long f28629n;

        /* renamed from: o  reason: collision with root package name */
        long f28630o;

        /* renamed from: p  reason: collision with root package name */
        xn.b f28631p;

        /* renamed from: q  reason: collision with root package name */
        d<T> f28632q;

        /* renamed from: r  reason: collision with root package name */
        volatile boolean f28633r;

        /* renamed from: s  reason: collision with root package name */
        final AtomicReference<xn.b> f28634s = new AtomicReference<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableWindowTimed.java */
        /* renamed from: io.reactivex.internal.operators.observable.f4$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class RunnableC0330a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final long f28635a;

            /* renamed from: b  reason: collision with root package name */
            final a<?> f28636b;

            RunnableC0330a(long j10, a<?> aVar) {
                this.f28635a = j10;
                this.f28636b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f28636b;
                if (!((j) aVar).f28375d) {
                    ((j) aVar).f28374c.offer(this);
                } else {
                    aVar.f28633r = true;
                    aVar.l();
                }
                if (aVar.f()) {
                    aVar.m();
                }
            }
        }

        a(r<? super k<T>> rVar, long j10, TimeUnit timeUnit, s sVar, int i10, long j11, boolean z10) {
            super(rVar, new io.reactivex.internal.queue.a());
            this.f28622g = j10;
            this.f28623h = timeUnit;
            this.f28624i = sVar;
            this.f28625j = i10;
            this.f28627l = j11;
            this.f28626k = z10;
            if (z10) {
                this.f28628m = sVar.a();
            } else {
                this.f28628m = null;
            }
        }

        @Override // xn.b
        public void dispose() {
            this.f28375d = true;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28375d;
        }

        void l() {
            DisposableHelper.dispose(this.f28634s);
            s.c cVar = this.f28628m;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void m() {
            io.reactivex.internal.queue.a aVar = (io.reactivex.internal.queue.a) this.f28374c;
            r<? super V> rVar = this.f28373b;
            d<T> dVar = this.f28632q;
            int i10 = 1;
            while (!this.f28633r) {
                boolean z10 = this.f28376e;
                Object poll = aVar.poll();
                boolean z11 = poll == null;
                boolean z12 = poll instanceof RunnableC0330a;
                if (z10 && (z11 || z12)) {
                    this.f28632q = null;
                    aVar.clear();
                    l();
                    Throwable th2 = this.f28377f;
                    if (th2 != null) {
                        dVar.onError(th2);
                        return;
                    } else {
                        dVar.onComplete();
                        return;
                    }
                } else if (z11) {
                    i10 = e(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else if (z12) {
                    RunnableC0330a aVar2 = (RunnableC0330a) poll;
                    if (this.f28626k || this.f28630o == aVar2.f28635a) {
                        dVar.onComplete();
                        this.f28629n = 0L;
                        dVar = (d<T>) d.d(this.f28625j);
                        this.f28632q = dVar;
                        rVar.onNext(dVar);
                    }
                } else {
                    dVar.onNext(NotificationLite.getValue(poll));
                    long j10 = this.f28629n + 1;
                    if (j10 >= this.f28627l) {
                        this.f28630o++;
                        this.f28629n = 0L;
                        dVar.onComplete();
                        dVar = (d<T>) d.d(this.f28625j);
                        this.f28632q = dVar;
                        this.f28373b.onNext(dVar);
                        if (this.f28626k) {
                            xn.b bVar = this.f28634s.get();
                            bVar.dispose();
                            s.c cVar = this.f28628m;
                            RunnableC0330a aVar3 = new RunnableC0330a(this.f28630o, this);
                            long j11 = this.f28622g;
                            xn.b d10 = cVar.d(aVar3, j11, j11, this.f28623h);
                            if (!this.f28634s.compareAndSet(bVar, d10)) {
                                d10.dispose();
                            }
                        }
                    } else {
                        this.f28629n = j10;
                    }
                }
            }
            this.f28631p.dispose();
            aVar.clear();
            l();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28376e = true;
            if (f()) {
                m();
            }
            this.f28373b.onComplete();
            l();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28377f = th2;
            this.f28376e = true;
            if (f()) {
                m();
            }
            this.f28373b.onError(th2);
            l();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28633r) {
                if (g()) {
                    d<T> dVar = this.f28632q;
                    dVar.onNext(t10);
                    long j10 = this.f28629n + 1;
                    if (j10 >= this.f28627l) {
                        this.f28630o++;
                        this.f28629n = 0L;
                        dVar.onComplete();
                        d<T> d10 = d.d(this.f28625j);
                        this.f28632q = d10;
                        this.f28373b.onNext(d10);
                        if (this.f28626k) {
                            this.f28634s.get().dispose();
                            s.c cVar = this.f28628m;
                            RunnableC0330a aVar = new RunnableC0330a(this.f28630o, this);
                            long j11 = this.f28622g;
                            DisposableHelper.replace(this.f28634s, cVar.d(aVar, j11, j11, this.f28623h));
                        }
                    } else {
                        this.f28629n = j10;
                    }
                    if (e(-1) == 0) {
                        return;
                    }
                } else {
                    this.f28374c.offer(NotificationLite.next(t10));
                    if (!f()) {
                        return;
                    }
                }
                m();
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            xn.b bVar2;
            if (DisposableHelper.validate(this.f28631p, bVar)) {
                this.f28631p = bVar;
                r<? super V> rVar = this.f28373b;
                rVar.onSubscribe(this);
                if (!this.f28375d) {
                    d<T> d10 = d.d(this.f28625j);
                    this.f28632q = d10;
                    rVar.onNext(d10);
                    RunnableC0330a aVar = new RunnableC0330a(this.f28630o, this);
                    if (this.f28626k) {
                        s.c cVar = this.f28628m;
                        long j10 = this.f28622g;
                        bVar2 = cVar.d(aVar, j10, j10, this.f28623h);
                    } else {
                        s sVar = this.f28624i;
                        long j11 = this.f28622g;
                        bVar2 = sVar.e(aVar, j11, j11, this.f28623h);
                    }
                    DisposableHelper.replace(this.f28634s, bVar2);
                }
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends j<T, Object, k<T>> implements r<T>, xn.b {

        /* renamed from: o  reason: collision with root package name */
        static final Object f28637o = new Object();

        /* renamed from: g  reason: collision with root package name */
        final long f28638g;

        /* renamed from: h  reason: collision with root package name */
        final TimeUnit f28639h;

        /* renamed from: i  reason: collision with root package name */
        final s f28640i;

        /* renamed from: j  reason: collision with root package name */
        final int f28641j;

        /* renamed from: k  reason: collision with root package name */
        xn.b f28642k;

        /* renamed from: l  reason: collision with root package name */
        d<T> f28643l;

        /* renamed from: m  reason: collision with root package name */
        final AtomicReference<xn.b> f28644m = new AtomicReference<>();

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f28645n;

        b(r<? super k<T>> rVar, long j10, TimeUnit timeUnit, s sVar, int i10) {
            super(rVar, new io.reactivex.internal.queue.a());
            this.f28638g = j10;
            this.f28639h = timeUnit;
            this.f28640i = sVar;
            this.f28641j = i10;
        }

        @Override // xn.b
        public void dispose() {
            this.f28375d = true;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28375d;
        }

        void j() {
            DisposableHelper.dispose(this.f28644m);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
            r7.f28643l = null;
            r0.clear();
            j();
            r0 = r7.f28377f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void k() {
            io.reactivex.internal.queue.a aVar = (io.reactivex.internal.queue.a) this.f28374c;
            r<? super V> rVar = this.f28373b;
            d<T> dVar = this.f28643l;
            int i10 = 1;
            while (true) {
                boolean z10 = this.f28645n;
                boolean z11 = this.f28376e;
                Object poll = aVar.poll();
                if (!z11 || !(poll == null || poll == f28637o)) {
                    if (poll == null) {
                        i10 = e(-i10);
                        if (i10 == 0) {
                            return;
                        }
                    } else if (poll == f28637o) {
                        dVar.onComplete();
                        if (!z10) {
                            dVar = (d<T>) d.d(this.f28641j);
                            this.f28643l = dVar;
                            rVar.onNext(dVar);
                        } else {
                            this.f28642k.dispose();
                        }
                    } else {
                        dVar.onNext(NotificationLite.getValue(poll));
                    }
                }
            }
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28376e = true;
            if (f()) {
                k();
            }
            j();
            this.f28373b.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28377f = th2;
            this.f28376e = true;
            if (f()) {
                k();
            }
            j();
            this.f28373b.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.f28645n) {
                if (g()) {
                    this.f28643l.onNext(t10);
                    if (e(-1) == 0) {
                        return;
                    }
                } else {
                    this.f28374c.offer(NotificationLite.next(t10));
                    if (!f()) {
                        return;
                    }
                }
                k();
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28642k, bVar)) {
                this.f28642k = bVar;
                this.f28643l = d.d(this.f28641j);
                r<? super V> rVar = this.f28373b;
                rVar.onSubscribe(this);
                rVar.onNext(this.f28643l);
                if (!this.f28375d) {
                    s sVar = this.f28640i;
                    long j10 = this.f28638g;
                    DisposableHelper.replace(this.f28644m, sVar.e(this, j10, j10, this.f28639h));
                }
            }
        }

        public void run() {
            if (this.f28375d) {
                this.f28645n = true;
                j();
            }
            this.f28374c.offer(f28637o);
            if (f()) {
                k();
            }
        }
    }

    /* compiled from: ObservableWindowTimed.java */
    /* loaded from: classes3.dex */
    static final class c<T> extends j<T, Object, k<T>> implements xn.b, Runnable {

        /* renamed from: g  reason: collision with root package name */
        final long f28646g;

        /* renamed from: h  reason: collision with root package name */
        final long f28647h;

        /* renamed from: i  reason: collision with root package name */
        final TimeUnit f28648i;

        /* renamed from: j  reason: collision with root package name */
        final s.c f28649j;

        /* renamed from: k  reason: collision with root package name */
        final int f28650k;

        /* renamed from: l  reason: collision with root package name */
        final List<d<T>> f28651l = new LinkedList();

        /* renamed from: m  reason: collision with root package name */
        xn.b f28652m;

        /* renamed from: n  reason: collision with root package name */
        volatile boolean f28653n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableWindowTimed.java */
        /* loaded from: classes3.dex */
        public final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final d<T> f28654a;

            a(d<T> dVar) {
                this.f28654a = dVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.j(this.f28654a);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ObservableWindowTimed.java */
        /* loaded from: classes3.dex */
        public static final class b<T> {

            /* renamed from: a  reason: collision with root package name */
            final d<T> f28656a;

            /* renamed from: b  reason: collision with root package name */
            final boolean f28657b;

            b(d<T> dVar, boolean z10) {
                this.f28656a = dVar;
                this.f28657b = z10;
            }
        }

        c(r<? super k<T>> rVar, long j10, long j11, TimeUnit timeUnit, s.c cVar, int i10) {
            super(rVar, new io.reactivex.internal.queue.a());
            this.f28646g = j10;
            this.f28647h = j11;
            this.f28648i = timeUnit;
            this.f28649j = cVar;
            this.f28650k = i10;
        }

        @Override // xn.b
        public void dispose() {
            this.f28375d = true;
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28375d;
        }

        void j(d<T> dVar) {
            this.f28374c.offer(new b(dVar, false));
            if (f()) {
                l();
            }
        }

        void k() {
            this.f28649j.dispose();
        }

        void l() {
            io.reactivex.internal.queue.a aVar = (io.reactivex.internal.queue.a) this.f28374c;
            r<? super V> rVar = this.f28373b;
            List<d<T>> list = this.f28651l;
            int i10 = 1;
            while (!this.f28653n) {
                boolean z10 = this.f28376e;
                T t10 = (T) aVar.poll();
                boolean z11 = t10 == null;
                boolean z12 = t10 instanceof b;
                if (z10 && (z11 || z12)) {
                    aVar.clear();
                    Throwable th2 = this.f28377f;
                    if (th2 != null) {
                        for (d<T> dVar : list) {
                            dVar.onError(th2);
                        }
                    } else {
                        for (d<T> dVar2 : list) {
                            dVar2.onComplete();
                        }
                    }
                    k();
                    list.clear();
                    return;
                } else if (z11) {
                    i10 = e(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else if (z12) {
                    b bVar = (b) t10;
                    if (!bVar.f28657b) {
                        list.remove(bVar.f28656a);
                        bVar.f28656a.onComplete();
                        if (list.isEmpty() && this.f28375d) {
                            this.f28653n = true;
                        }
                    } else if (!this.f28375d) {
                        d<T> d10 = d.d(this.f28650k);
                        list.add(d10);
                        rVar.onNext(d10);
                        this.f28649j.c(new a(d10), this.f28646g, this.f28648i);
                    }
                } else {
                    for (d<T> dVar3 : list) {
                        dVar3.onNext(t10);
                    }
                }
            }
            this.f28652m.dispose();
            k();
            aVar.clear();
            list.clear();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28376e = true;
            if (f()) {
                l();
            }
            this.f28373b.onComplete();
            k();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28377f = th2;
            this.f28376e = true;
            if (f()) {
                l();
            }
            this.f28373b.onError(th2);
            k();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (g()) {
                for (d<T> dVar : this.f28651l) {
                    dVar.onNext(t10);
                }
                if (e(-1) == 0) {
                    return;
                }
            } else {
                this.f28374c.offer(t10);
                if (!f()) {
                    return;
                }
            }
            l();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28652m, bVar)) {
                this.f28652m = bVar;
                this.f28373b.onSubscribe(this);
                if (!this.f28375d) {
                    d<T> d10 = d.d(this.f28650k);
                    this.f28651l.add(d10);
                    this.f28373b.onNext(d10);
                    this.f28649j.c(new a(d10), this.f28646g, this.f28648i);
                    s.c cVar = this.f28649j;
                    long j10 = this.f28647h;
                    cVar.d(this, j10, j10, this.f28648i);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = new b(d.d(this.f28650k), true);
            if (!this.f28375d) {
                this.f28374c.offer(bVar);
            }
            if (f()) {
                l();
            }
        }
    }

    public f4(p<T> pVar, long j10, long j11, TimeUnit timeUnit, s sVar, long j12, int i10, boolean z10) {
        super(pVar);
        this.f28615b = j10;
        this.f28616c = j11;
        this.f28617d = timeUnit;
        this.f28618e = sVar;
        this.f28619f = j12;
        this.f28620g = i10;
        this.f28621h = z10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super k<T>> rVar) {
        eo.d dVar = new eo.d(rVar);
        long j10 = this.f28615b;
        long j11 = this.f28616c;
        if (j10 == j11) {
            long j12 = this.f28619f;
            if (j12 == Long.MAX_VALUE) {
                this.f28426a.subscribe(new b(dVar, this.f28615b, this.f28617d, this.f28618e, this.f28620g));
            } else {
                this.f28426a.subscribe(new a(dVar, j10, this.f28617d, this.f28618e, this.f28620g, j12, this.f28621h));
            }
        } else {
            this.f28426a.subscribe(new c(dVar, j10, j11, this.f28617d, this.f28618e.a(), this.f28620g));
        }
    }
}
