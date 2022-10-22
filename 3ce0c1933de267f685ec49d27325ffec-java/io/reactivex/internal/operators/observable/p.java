package io.reactivex.internal.operators.observable;

import eo.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.observers.j;
import io.reactivex.internal.util.k;
import io.reactivex.r;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableBufferTimed.java */
/* loaded from: classes3.dex */
public final class p<T, U extends Collection<? super T>> extends io.reactivex.internal.operators.observable.a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final long f28895b;

    /* renamed from: c  reason: collision with root package name */
    final long f28896c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f28897d;

    /* renamed from: e  reason: collision with root package name */
    final s f28898e;

    /* renamed from: f  reason: collision with root package name */
    final Callable<U> f28899f;

    /* renamed from: g  reason: collision with root package name */
    final int f28900g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f28901h;

    /* compiled from: ObservableBufferTimed.java */
    /* loaded from: classes3.dex */
    static final class a<T, U extends Collection<? super T>> extends j<T, U, U> implements Runnable, xn.b {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f28902g;

        /* renamed from: h  reason: collision with root package name */
        final long f28903h;

        /* renamed from: i  reason: collision with root package name */
        final TimeUnit f28904i;

        /* renamed from: j  reason: collision with root package name */
        final int f28905j;

        /* renamed from: k  reason: collision with root package name */
        final boolean f28906k;

        /* renamed from: l  reason: collision with root package name */
        final s.c f28907l;

        /* renamed from: m  reason: collision with root package name */
        U f28908m;

        /* renamed from: n  reason: collision with root package name */
        xn.b f28909n;

        /* renamed from: o  reason: collision with root package name */
        xn.b f28910o;

        /* renamed from: p  reason: collision with root package name */
        long f28911p;

        /* renamed from: q  reason: collision with root package name */
        long f28912q;

        a(r<? super U> rVar, Callable<U> callable, long j10, TimeUnit timeUnit, int i10, boolean z10, s.c cVar) {
            super(rVar, new io.reactivex.internal.queue.a());
            this.f28902g = callable;
            this.f28903h = j10;
            this.f28904i = timeUnit;
            this.f28905j = i10;
            this.f28906k = z10;
            this.f28907l = cVar;
        }

        @Override // xn.b
        public void dispose() {
            if (!this.f28375d) {
                this.f28375d = true;
                this.f28910o.dispose();
                this.f28907l.dispose();
                synchronized (this) {
                    this.f28908m = null;
                }
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28375d;
        }

        /* renamed from: j */
        public void c(r<? super U> rVar, U u10) {
            rVar.onNext(u10);
        }

        @Override // io.reactivex.r
        public void onComplete() {
            U u10;
            this.f28907l.dispose();
            synchronized (this) {
                u10 = this.f28908m;
                this.f28908m = null;
            }
            this.f28374c.offer(u10);
            this.f28376e = true;
            if (f()) {
                k.c(this.f28374c, this.f28373b, false, this, this);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            synchronized (this) {
                this.f28908m = null;
            }
            this.f28373b.onError(th2);
            this.f28907l.dispose();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            synchronized (this) {
                U u10 = this.f28908m;
                if (u10 != null) {
                    u10.add(t10);
                    if (u10.size() >= this.f28905j) {
                        this.f28908m = null;
                        this.f28911p++;
                        if (this.f28906k) {
                            this.f28909n.dispose();
                        }
                        i(u10, false, this);
                        try {
                            U u11 = (U) bo.b.e(this.f28902g.call(), "The buffer supplied is null");
                            synchronized (this) {
                                this.f28908m = u11;
                                this.f28912q++;
                            }
                            if (this.f28906k) {
                                s.c cVar = this.f28907l;
                                long j10 = this.f28903h;
                                this.f28909n = cVar.d(this, j10, j10, this.f28904i);
                            }
                        } catch (Throwable th2) {
                            io.reactivex.exceptions.a.b(th2);
                            this.f28373b.onError(th2);
                            dispose();
                        }
                    }
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28910o, bVar)) {
                this.f28910o = bVar;
                try {
                    this.f28908m = (U) bo.b.e(this.f28902g.call(), "The buffer supplied is null");
                    this.f28373b.onSubscribe(this);
                    s.c cVar = this.f28907l;
                    long j10 = this.f28903h;
                    this.f28909n = cVar.d(this, j10, j10, this.f28904i);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    bVar.dispose();
                    EmptyDisposable.error(th2, this.f28373b);
                    this.f28907l.dispose();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u10 = (U) bo.b.e(this.f28902g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    U u11 = this.f28908m;
                    if (u11 != null && this.f28911p == this.f28912q) {
                        this.f28908m = u10;
                        i(u11, false, this);
                    }
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                dispose();
                this.f28373b.onError(th2);
            }
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    /* loaded from: classes3.dex */
    static final class b<T, U extends Collection<? super T>> extends j<T, U, U> implements Runnable, xn.b {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f28913g;

        /* renamed from: h  reason: collision with root package name */
        final long f28914h;

        /* renamed from: i  reason: collision with root package name */
        final TimeUnit f28915i;

        /* renamed from: j  reason: collision with root package name */
        final s f28916j;

        /* renamed from: k  reason: collision with root package name */
        xn.b f28917k;

        /* renamed from: l  reason: collision with root package name */
        U f28918l;

        /* renamed from: m  reason: collision with root package name */
        final AtomicReference<xn.b> f28919m = new AtomicReference<>();

        b(r<? super U> rVar, Callable<U> callable, long j10, TimeUnit timeUnit, s sVar) {
            super(rVar, new io.reactivex.internal.queue.a());
            this.f28913g = callable;
            this.f28914h = j10;
            this.f28915i = timeUnit;
            this.f28916j = sVar;
        }

        @Override // xn.b
        public void dispose() {
            DisposableHelper.dispose(this.f28919m);
            this.f28917k.dispose();
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28919m.get() == DisposableHelper.DISPOSED;
        }

        /* renamed from: j */
        public void c(r<? super U> rVar, U u10) {
            this.f28373b.onNext(u10);
        }

        @Override // io.reactivex.r
        public void onComplete() {
            U u10;
            synchronized (this) {
                u10 = this.f28918l;
                this.f28918l = null;
            }
            if (u10 != null) {
                this.f28374c.offer(u10);
                this.f28376e = true;
                if (f()) {
                    k.c(this.f28374c, this.f28373b, false, null, this);
                }
            }
            DisposableHelper.dispose(this.f28919m);
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            synchronized (this) {
                this.f28918l = null;
            }
            this.f28373b.onError(th2);
            DisposableHelper.dispose(this.f28919m);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            synchronized (this) {
                U u10 = this.f28918l;
                if (u10 != null) {
                    u10.add(t10);
                }
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28917k, bVar)) {
                this.f28917k = bVar;
                try {
                    this.f28918l = (U) bo.b.e(this.f28913g.call(), "The buffer supplied is null");
                    this.f28373b.onSubscribe(this);
                    if (!this.f28375d) {
                        s sVar = this.f28916j;
                        long j10 = this.f28914h;
                        xn.b e10 = sVar.e(this, j10, j10, this.f28915i);
                        if (!this.f28919m.compareAndSet(null, e10)) {
                            e10.dispose();
                        }
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    dispose();
                    EmptyDisposable.error(th2, this.f28373b);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            U u10;
            try {
                U u11 = (U) bo.b.e(this.f28913g.call(), "The bufferSupplier returned a null buffer");
                synchronized (this) {
                    u10 = this.f28918l;
                    if (u10 != null) {
                        this.f28918l = u11;
                    }
                }
                if (u10 == null) {
                    DisposableHelper.dispose(this.f28919m);
                } else {
                    h(u10, false, this);
                }
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                this.f28373b.onError(th2);
                dispose();
            }
        }
    }

    /* compiled from: ObservableBufferTimed.java */
    /* loaded from: classes3.dex */
    static final class c<T, U extends Collection<? super T>> extends j<T, U, U> implements Runnable, xn.b {

        /* renamed from: g  reason: collision with root package name */
        final Callable<U> f28920g;

        /* renamed from: h  reason: collision with root package name */
        final long f28921h;

        /* renamed from: i  reason: collision with root package name */
        final long f28922i;

        /* renamed from: j  reason: collision with root package name */
        final TimeUnit f28923j;

        /* renamed from: k  reason: collision with root package name */
        final s.c f28924k;

        /* renamed from: l  reason: collision with root package name */
        final List<U> f28925l = new LinkedList();

        /* renamed from: m  reason: collision with root package name */
        xn.b f28926m;

        /* compiled from: ObservableBufferTimed.java */
        /* loaded from: classes3.dex */
        final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final U f28927a;

            a(U u10) {
                this.f28927a = u10;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.f28925l.remove(this.f28927a);
                }
                c cVar = c.this;
                cVar.i(this.f28927a, false, cVar.f28924k);
            }
        }

        /* compiled from: ObservableBufferTimed.java */
        /* loaded from: classes3.dex */
        final class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            private final U f28929a;

            b(U u10) {
                this.f28929a = u10;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.f28925l.remove(this.f28929a);
                }
                c cVar = c.this;
                cVar.i(this.f28929a, false, cVar.f28924k);
            }
        }

        c(r<? super U> rVar, Callable<U> callable, long j10, long j11, TimeUnit timeUnit, s.c cVar) {
            super(rVar, new io.reactivex.internal.queue.a());
            this.f28920g = callable;
            this.f28921h = j10;
            this.f28922i = j11;
            this.f28923j = timeUnit;
            this.f28924k = cVar;
        }

        @Override // xn.b
        public void dispose() {
            if (!this.f28375d) {
                this.f28375d = true;
                m();
                this.f28926m.dispose();
                this.f28924k.dispose();
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28375d;
        }

        /* renamed from: j */
        public void c(r<? super U> rVar, U u10) {
            rVar.onNext(u10);
        }

        void m() {
            synchronized (this) {
                this.f28925l.clear();
            }
        }

        @Override // io.reactivex.r
        public void onComplete() {
            ArrayList<Collection> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.f28925l);
                this.f28925l.clear();
            }
            for (Collection collection : arrayList) {
                this.f28374c.offer(collection);
            }
            this.f28376e = true;
            if (f()) {
                k.c(this.f28374c, this.f28373b, false, this.f28924k, this);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28376e = true;
            m();
            this.f28373b.onError(th2);
            this.f28924k.dispose();
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            synchronized (this) {
                for (U u10 : this.f28925l) {
                    u10.add(t10);
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28926m, bVar)) {
                this.f28926m = bVar;
                try {
                    Collection collection = (Collection) bo.b.e(this.f28920g.call(), "The buffer supplied is null");
                    this.f28925l.add(collection);
                    this.f28373b.onSubscribe(this);
                    s.c cVar = this.f28924k;
                    long j10 = this.f28922i;
                    cVar.d(this, j10, j10, this.f28923j);
                    this.f28924k.c(new b(collection), this.f28921h, this.f28923j);
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    bVar.dispose();
                    EmptyDisposable.error(th2, this.f28373b);
                    this.f28924k.dispose();
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            if (!this.f28375d) {
                try {
                    Collection collection = (Collection) bo.b.e(this.f28920g.call(), "The bufferSupplier returned a null buffer");
                    synchronized (this) {
                        if (!this.f28375d) {
                            this.f28925l.add(collection);
                            this.f28924k.c(new a(collection), this.f28921h, this.f28923j);
                        }
                    }
                } catch (Throwable th2) {
                    io.reactivex.exceptions.a.b(th2);
                    this.f28373b.onError(th2);
                    dispose();
                }
            }
        }
    }

    public p(io.reactivex.p<T> pVar, long j10, long j11, TimeUnit timeUnit, s sVar, Callable<U> callable, int i10, boolean z10) {
        super(pVar);
        this.f28895b = j10;
        this.f28896c = j11;
        this.f28897d = timeUnit;
        this.f28898e = sVar;
        this.f28899f = callable;
        this.f28900g = i10;
        this.f28901h = z10;
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super U> rVar) {
        if (this.f28895b == this.f28896c && this.f28900g == Integer.MAX_VALUE) {
            this.f28426a.subscribe(new b(new d(rVar), this.f28899f, this.f28895b, this.f28897d, this.f28898e));
            return;
        }
        s.c a10 = this.f28898e.a();
        if (this.f28895b == this.f28896c) {
            this.f28426a.subscribe(new a(new d(rVar), this.f28899f, this.f28895b, this.f28897d, this.f28900g, this.f28901h, a10));
        } else {
            this.f28426a.subscribe(new c(new d(rVar), this.f28899f, this.f28895b, this.f28896c, this.f28897d, a10));
        }
    }
}
