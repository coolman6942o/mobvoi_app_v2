package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.observers.j;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.k;
import io.reactivex.p;
import io.reactivex.r;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import zn.o;
/* compiled from: ObservableWindowBoundarySelector.java */
/* loaded from: classes3.dex */
public final class d4<T, B, V> extends io.reactivex.internal.operators.observable.a<T, k<T>> {

    /* renamed from: b  reason: collision with root package name */
    final p<B> f28524b;

    /* renamed from: c  reason: collision with root package name */
    final o<? super B, ? extends p<V>> f28525c;

    /* renamed from: d  reason: collision with root package name */
    final int f28526d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    public static final class a<T, V> extends eo.b<V> {

        /* renamed from: b  reason: collision with root package name */
        final c<T, ?, V> f28527b;

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.subjects.d<T> f28528c;

        /* renamed from: d  reason: collision with root package name */
        boolean f28529d;

        a(c<T, ?, V> cVar, io.reactivex.subjects.d<T> dVar) {
            this.f28527b = cVar;
            this.f28528c = dVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28529d) {
                this.f28529d = true;
                this.f28527b.j(this);
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28529d) {
                fo.a.s(th2);
                return;
            }
            this.f28529d = true;
            this.f28527b.m(th2);
        }

        @Override // io.reactivex.r
        public void onNext(V v10) {
            dispose();
            onComplete();
        }
    }

    /* compiled from: ObservableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    static final class b<T, B> extends eo.b<B> {

        /* renamed from: b  reason: collision with root package name */
        final c<T, B, ?> f28530b;

        b(c<T, B, ?> cVar) {
            this.f28530b = cVar;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            this.f28530b.onComplete();
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            this.f28530b.m(th2);
        }

        @Override // io.reactivex.r
        public void onNext(B b10) {
            this.f28530b.n(b10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    public static final class c<T, B, V> extends j<T, Object, k<T>> implements xn.b {

        /* renamed from: g  reason: collision with root package name */
        final p<B> f28531g;

        /* renamed from: h  reason: collision with root package name */
        final o<? super B, ? extends p<V>> f28532h;

        /* renamed from: i  reason: collision with root package name */
        final int f28533i;

        /* renamed from: k  reason: collision with root package name */
        xn.b f28535k;

        /* renamed from: n  reason: collision with root package name */
        final AtomicLong f28538n;

        /* renamed from: l  reason: collision with root package name */
        final AtomicReference<xn.b> f28536l = new AtomicReference<>();

        /* renamed from: o  reason: collision with root package name */
        final AtomicBoolean f28539o = new AtomicBoolean();

        /* renamed from: j  reason: collision with root package name */
        final xn.a f28534j = new xn.a();

        /* renamed from: m  reason: collision with root package name */
        final List<io.reactivex.subjects.d<T>> f28537m = new ArrayList();

        c(r<? super k<T>> rVar, p<B> pVar, o<? super B, ? extends p<V>> oVar, int i10) {
            super(rVar, new io.reactivex.internal.queue.a());
            AtomicLong atomicLong = new AtomicLong();
            this.f28538n = atomicLong;
            this.f28531g = pVar;
            this.f28532h = oVar;
            this.f28533i = i10;
            atomicLong.lazySet(1L);
        }

        @Override // io.reactivex.internal.observers.j, io.reactivex.internal.util.h
        public void c(r<? super k<T>> rVar, Object obj) {
        }

        @Override // xn.b
        public void dispose() {
            if (this.f28539o.compareAndSet(false, true)) {
                DisposableHelper.dispose(this.f28536l);
                if (this.f28538n.decrementAndGet() == 0) {
                    this.f28535k.dispose();
                }
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.f28539o.get();
        }

        void j(a<T, V> aVar) {
            this.f28534j.a(aVar);
            this.f28374c.offer(new d(aVar.f28528c, null));
            if (f()) {
                l();
            }
        }

        void k() {
            this.f28534j.dispose();
            DisposableHelper.dispose(this.f28536l);
        }

        void l() {
            io.reactivex.internal.queue.a aVar = (io.reactivex.internal.queue.a) this.f28374c;
            r<? super V> rVar = this.f28373b;
            List<io.reactivex.subjects.d<T>> list = this.f28537m;
            int i10 = 1;
            while (true) {
                boolean z10 = this.f28376e;
                Object poll = aVar.poll();
                boolean z11 = poll == null;
                if (z10 && z11) {
                    k();
                    Throwable th2 = this.f28377f;
                    if (th2 != null) {
                        for (io.reactivex.subjects.d<T> dVar : list) {
                            dVar.onError(th2);
                        }
                    } else {
                        for (io.reactivex.subjects.d<T> dVar2 : list) {
                            dVar2.onComplete();
                        }
                    }
                    list.clear();
                    return;
                } else if (z11) {
                    i10 = e(-i10);
                    if (i10 == 0) {
                        return;
                    }
                } else if (poll instanceof d) {
                    d dVar3 = (d) poll;
                    io.reactivex.subjects.d<T> dVar4 = dVar3.f28540a;
                    if (dVar4 != null) {
                        if (list.remove(dVar4)) {
                            dVar3.f28540a.onComplete();
                            if (this.f28538n.decrementAndGet() == 0) {
                                k();
                                return;
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.f28539o.get()) {
                        io.reactivex.subjects.d<T> d10 = io.reactivex.subjects.d.d(this.f28533i);
                        list.add(d10);
                        rVar.onNext(d10);
                        try {
                            p pVar = (p) bo.b.e(this.f28532h.apply((B) dVar3.f28541b), "The ObservableSource supplied is null");
                            a aVar2 = new a(this, d10);
                            if (this.f28534j.b(aVar2)) {
                                this.f28538n.getAndIncrement();
                                pVar.subscribe(aVar2);
                            }
                        } catch (Throwable th3) {
                            io.reactivex.exceptions.a.b(th3);
                            this.f28539o.set(true);
                            rVar.onError(th3);
                        }
                    }
                } else {
                    for (io.reactivex.subjects.d<T> dVar5 : list) {
                        dVar5.onNext((T) NotificationLite.getValue(poll));
                    }
                }
            }
        }

        void m(Throwable th2) {
            this.f28535k.dispose();
            this.f28534j.dispose();
            onError(th2);
        }

        void n(B b10) {
            this.f28374c.offer(new d(null, b10));
            if (f()) {
                l();
            }
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.f28376e) {
                this.f28376e = true;
                if (f()) {
                    l();
                }
                if (this.f28538n.decrementAndGet() == 0) {
                    this.f28534j.dispose();
                }
                this.f28373b.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (this.f28376e) {
                fo.a.s(th2);
                return;
            }
            this.f28377f = th2;
            this.f28376e = true;
            if (f()) {
                l();
            }
            if (this.f28538n.decrementAndGet() == 0) {
                this.f28534j.dispose();
            }
            this.f28373b.onError(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (g()) {
                for (io.reactivex.subjects.d<T> dVar : this.f28537m) {
                    dVar.onNext(t10);
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
            l();
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.f28535k, bVar)) {
                this.f28535k = bVar;
                this.f28373b.onSubscribe(this);
                if (!this.f28539o.get()) {
                    b bVar2 = new b(this);
                    if (this.f28536l.compareAndSet(null, bVar2)) {
                        this.f28531g.subscribe(bVar2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableWindowBoundarySelector.java */
    /* loaded from: classes3.dex */
    public static final class d<T, B> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.subjects.d<T> f28540a;

        /* renamed from: b  reason: collision with root package name */
        final B f28541b;

        d(io.reactivex.subjects.d<T> dVar, B b10) {
            this.f28540a = dVar;
            this.f28541b = b10;
        }
    }

    public d4(p<T> pVar, p<B> pVar2, o<? super B, ? extends p<V>> oVar, int i10) {
        super(pVar);
        this.f28524b = pVar2;
        this.f28525c = oVar;
        this.f28526d = i10;
    }

    @Override // io.reactivex.k
    public void subscribeActual(r<? super k<T>> rVar) {
        this.f28426a.subscribe(new c(new eo.d(rVar), this.f28524b, this.f28525c, this.f28526d));
    }
}
