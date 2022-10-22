package io.reactivex.internal.operators.observable;

import ao.c;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.s;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import zn.g;
/* compiled from: ObservableRefCount.java */
/* loaded from: classes3.dex */
public final class l2<T> extends k<T> {

    /* renamed from: a  reason: collision with root package name */
    final p001do.a<T> f28803a;

    /* renamed from: b  reason: collision with root package name */
    final int f28804b;

    /* renamed from: c  reason: collision with root package name */
    final long f28805c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f28806d;

    /* renamed from: e  reason: collision with root package name */
    final s f28807e;

    /* renamed from: f  reason: collision with root package name */
    a f28808f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes3.dex */
    public static final class a extends AtomicReference<xn.b> implements Runnable, g<xn.b> {
        private static final long serialVersionUID = -4552101107598366241L;
        boolean connected;
        boolean disconnectedEarly;
        final l2<?> parent;
        long subscriberCount;
        xn.b timer;

        a(l2<?> l2Var) {
            this.parent = l2Var;
        }

        /* renamed from: a */
        public void accept(xn.b bVar) throws Exception {
            DisposableHelper.replace(this, bVar);
            synchronized (this.parent) {
                if (this.disconnectedEarly) {
                    ((c) this.parent.f28803a).a(bVar);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.parent.d(this);
        }
    }

    /* compiled from: ObservableRefCount.java */
    /* loaded from: classes3.dex */
    static final class b<T> extends AtomicBoolean implements r<T>, xn.b {
        private static final long serialVersionUID = -7419642935409022375L;
        final a connection;
        final r<? super T> downstream;
        final l2<T> parent;
        xn.b upstream;

        b(r<? super T> rVar, l2<T> l2Var, a aVar) {
            this.downstream = rVar;
            this.parent = l2Var;
            this.connection = aVar;
        }

        @Override // xn.b
        public void dispose() {
            this.upstream.dispose();
            if (compareAndSet(false, true)) {
                this.parent.b(this.connection);
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (compareAndSet(false, true)) {
                this.parent.c(this.connection);
                this.downstream.onComplete();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (compareAndSet(false, true)) {
                this.parent.c(this.connection);
                this.downstream.onError(th2);
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            this.downstream.onNext(t10);
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                this.downstream.onSubscribe(this);
            }
        }
    }

    public l2(p001do.a<T> aVar) {
        this(aVar, 1, 0L, TimeUnit.NANOSECONDS, null);
    }

    void b(a aVar) {
        synchronized (this) {
            a aVar2 = this.f28808f;
            if (aVar2 != null && aVar2 == aVar) {
                long j10 = aVar.subscriberCount - 1;
                aVar.subscriberCount = j10;
                if (j10 == 0 && aVar.connected) {
                    if (this.f28805c == 0) {
                        d(aVar);
                        return;
                    }
                    SequentialDisposable sequentialDisposable = new SequentialDisposable();
                    aVar.timer = sequentialDisposable;
                    sequentialDisposable.replace(this.f28807e.d(aVar, this.f28805c, this.f28806d));
                }
            }
        }
    }

    void c(a aVar) {
        synchronized (this) {
            a aVar2 = this.f28808f;
            if (aVar2 != null && aVar2 == aVar) {
                this.f28808f = null;
                xn.b bVar = aVar.timer;
                if (bVar != null) {
                    bVar.dispose();
                }
            }
            long j10 = aVar.subscriberCount - 1;
            aVar.subscriberCount = j10;
            if (j10 == 0) {
                p001do.a<T> aVar3 = this.f28803a;
                if (aVar3 instanceof xn.b) {
                    ((xn.b) aVar3).dispose();
                } else if (aVar3 instanceof c) {
                    ((c) aVar3).a(aVar.get());
                }
            }
        }
    }

    void d(a aVar) {
        synchronized (this) {
            if (aVar.subscriberCount == 0 && aVar == this.f28808f) {
                this.f28808f = null;
                xn.b bVar = aVar.get();
                DisposableHelper.dispose(aVar);
                p001do.a<T> aVar2 = this.f28803a;
                if (aVar2 instanceof xn.b) {
                    ((xn.b) aVar2).dispose();
                } else if (aVar2 instanceof c) {
                    if (bVar == null) {
                        aVar.disconnectedEarly = true;
                    } else {
                        ((c) aVar2).a(bVar);
                    }
                }
            }
        }
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        a aVar;
        boolean z10;
        xn.b bVar;
        synchronized (this) {
            aVar = this.f28808f;
            if (aVar == null) {
                aVar = new a(this);
                this.f28808f = aVar;
            }
            long j10 = aVar.subscriberCount;
            if (j10 == 0 && (bVar = aVar.timer) != null) {
                bVar.dispose();
            }
            long j11 = j10 + 1;
            aVar.subscriberCount = j11;
            z10 = true;
            if (aVar.connected || j11 != this.f28804b) {
                z10 = false;
            } else {
                aVar.connected = true;
            }
        }
        this.f28803a.subscribe(new b(rVar, this, aVar));
        if (z10) {
            this.f28803a.b(aVar);
        }
    }

    public l2(p001do.a<T> aVar, int i10, long j10, TimeUnit timeUnit, s sVar) {
        this.f28803a = aVar;
        this.f28804b = i10;
        this.f28805c = j10;
        this.f28806d = timeUnit;
        this.f28807e = sVar;
    }
}
