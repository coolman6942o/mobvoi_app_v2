package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.util.NotificationLite;
import io.reactivex.r;
import io.reactivex.s;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
/* compiled from: ObservableReplay.java */
/* loaded from: classes3.dex */
public final class p2<T> extends p001do.a<T> implements ao.c {

    /* renamed from: e  reason: collision with root package name */
    static final b f28945e = new o();

    /* renamed from: a  reason: collision with root package name */
    final io.reactivex.p<T> f28946a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<j<T>> f28947b;

    /* renamed from: c  reason: collision with root package name */
    final b<T> f28948c;

    /* renamed from: d  reason: collision with root package name */
    final io.reactivex.p<T> f28949d;

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static abstract class a<T> extends AtomicReference<f> implements h<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        int size;
        f tail;

        a() {
            f fVar = new f(null);
            this.tail = fVar;
            set(fVar);
        }

        @Override // io.reactivex.internal.operators.observable.p2.h
        public final void a() {
            g(new f(h(NotificationLite.complete())));
            o();
        }

        @Override // io.reactivex.internal.operators.observable.p2.h
        public final void b(T t10) {
            g(new f(h(NotificationLite.next(t10))));
            n();
        }

        @Override // io.reactivex.internal.operators.observable.p2.h
        public final void c(Throwable th2) {
            g(new f(h(NotificationLite.error(th2))));
            o();
        }

        @Override // io.reactivex.internal.operators.observable.p2.h
        public final void d(d<T> dVar) {
            if (dVar.getAndIncrement() == 0) {
                int i10 = 1;
                do {
                    f fVar = (f) dVar.a();
                    if (fVar == null) {
                        fVar = i();
                        dVar.index = fVar;
                    }
                    while (!dVar.isDisposed()) {
                        f fVar2 = fVar.get();
                        if (fVar2 == null) {
                            dVar.index = fVar;
                            i10 = dVar.addAndGet(-i10);
                        } else if (NotificationLite.accept(j(fVar2.value), dVar.child)) {
                            dVar.index = null;
                            return;
                        } else {
                            fVar = fVar2;
                        }
                    }
                    dVar.index = null;
                    return;
                } while (i10 != 0);
            }
        }

        final void g(f fVar) {
            this.tail.set(fVar);
            this.tail = fVar;
            this.size++;
        }

        Object h(Object obj) {
            return obj;
        }

        f i() {
            return get();
        }

        Object j(Object obj) {
            return obj;
        }

        final void k() {
            this.size--;
            l(get().get());
        }

        final void l(f fVar) {
            set(fVar);
        }

        final void m() {
            f fVar = get();
            if (fVar.value != null) {
                f fVar2 = new f(null);
                fVar2.lazySet(fVar.get());
                set(fVar2);
            }
        }

        abstract void n();

        void o() {
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public interface b<T> {
        h<T> call();
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class c<R> implements zn.g<xn.b> {

        /* renamed from: a  reason: collision with root package name */
        private final ObserverResourceWrapper<R> f28950a;

        c(ObserverResourceWrapper<R> observerResourceWrapper) {
            this.f28950a = observerResourceWrapper;
        }

        /* renamed from: a */
        public void accept(xn.b bVar) {
            this.f28950a.setResource(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class d<T> extends AtomicInteger implements xn.b {
        private static final long serialVersionUID = 2728361546769921047L;
        volatile boolean cancelled;
        final r<? super T> child;
        Object index;
        final j<T> parent;

        d(j<T> jVar, r<? super T> rVar) {
            this.parent = jVar;
            this.child = rVar;
        }

        <U> U a() {
            return (U) this.index;
        }

        @Override // xn.b
        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.parent.b(this);
                this.index = null;
            }
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class e<R, U> extends io.reactivex.k<R> {

        /* renamed from: a  reason: collision with root package name */
        private final Callable<? extends p001do.a<U>> f28951a;

        /* renamed from: b  reason: collision with root package name */
        private final zn.o<? super io.reactivex.k<U>, ? extends io.reactivex.p<R>> f28952b;

        e(Callable<? extends p001do.a<U>> callable, zn.o<? super io.reactivex.k<U>, ? extends io.reactivex.p<R>> oVar) {
            this.f28951a = callable;
            this.f28952b = oVar;
        }

        @Override // io.reactivex.k
        protected void subscribeActual(r<? super R> rVar) {
            try {
                p001do.a aVar = (p001do.a) bo.b.e(this.f28951a.call(), "The connectableFactory returned a null ConnectableObservable");
                io.reactivex.p pVar = (io.reactivex.p) bo.b.e(this.f28952b.apply(aVar), "The selector returned a null ObservableSource");
                ObserverResourceWrapper observerResourceWrapper = new ObserverResourceWrapper(rVar);
                pVar.subscribe(observerResourceWrapper);
                aVar.b(new c(observerResourceWrapper));
            } catch (Throwable th2) {
                io.reactivex.exceptions.a.b(th2);
                EmptyDisposable.error(th2, rVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class f extends AtomicReference<f> {
        private static final long serialVersionUID = 245354315435971818L;
        final Object value;

        f(Object obj) {
            this.value = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class g<T> extends p001do.a<T> {

        /* renamed from: a  reason: collision with root package name */
        private final p001do.a<T> f28953a;

        /* renamed from: b  reason: collision with root package name */
        private final io.reactivex.k<T> f28954b;

        g(p001do.a<T> aVar, io.reactivex.k<T> kVar) {
            this.f28953a = aVar;
            this.f28954b = kVar;
        }

        @Override // p001do.a
        public void b(zn.g<? super xn.b> gVar) {
            this.f28953a.b(gVar);
        }

        @Override // io.reactivex.k
        protected void subscribeActual(r<? super T> rVar) {
            this.f28954b.subscribe(rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public interface h<T> {
        void a();

        void b(T t10);

        void c(Throwable th2);

        void d(d<T> dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class i<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f28955a;

        i(int i10) {
            this.f28955a = i10;
        }

        @Override // io.reactivex.internal.operators.observable.p2.b
        public h<T> call() {
            return new n(this.f28955a);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class j<T> extends AtomicReference<xn.b> implements r<T>, xn.b {
        static final d[] EMPTY = new d[0];
        static final d[] TERMINATED = new d[0];
        private static final long serialVersionUID = -533785617179540163L;
        final h<T> buffer;
        boolean done;
        final AtomicReference<d[]> observers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        j(h<T> hVar) {
            this.buffer = hVar;
        }

        boolean a(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.observers.get();
                if (dVarArr == TERMINATED) {
                    return false;
                }
                int length = dVarArr.length;
                dVarArr2 = new d[length + 1];
                System.arraycopy(dVarArr, 0, dVarArr2, 0, length);
                dVarArr2[length] = dVar;
            } while (!this.observers.compareAndSet(dVarArr, dVarArr2));
            return true;
        }

        void b(d<T> dVar) {
            d[] dVarArr;
            d[] dVarArr2;
            do {
                dVarArr = this.observers.get();
                int length = dVarArr.length;
                if (length != 0) {
                    int i10 = -1;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        } else if (dVarArr[i11].equals(dVar)) {
                            i10 = i11;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i10 >= 0) {
                        if (length == 1) {
                            dVarArr2 = EMPTY;
                        } else {
                            d[] dVarArr3 = new d[length - 1];
                            System.arraycopy(dVarArr, 0, dVarArr3, 0, i10);
                            System.arraycopy(dVarArr, i10 + 1, dVarArr3, i10, (length - i10) - 1);
                            dVarArr2 = dVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.observers.compareAndSet(dVarArr, dVarArr2));
        }

        void c() {
            for (d<T> dVar : this.observers.get()) {
                this.buffer.d(dVar);
            }
        }

        void d() {
            for (d<T> dVar : this.observers.getAndSet(TERMINATED)) {
                this.buffer.d(dVar);
            }
        }

        @Override // xn.b
        public void dispose() {
            this.observers.set(TERMINATED);
            DisposableHelper.dispose(this);
        }

        @Override // xn.b
        public boolean isDisposed() {
            return this.observers.get() == TERMINATED;
        }

        @Override // io.reactivex.r
        public void onComplete() {
            if (!this.done) {
                this.done = true;
                this.buffer.a();
                d();
            }
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            if (!this.done) {
                this.done = true;
                this.buffer.c(th2);
                d();
                return;
            }
            fo.a.s(th2);
        }

        @Override // io.reactivex.r
        public void onNext(T t10) {
            if (!this.done) {
                this.buffer.b(t10);
                c();
            }
        }

        @Override // io.reactivex.r
        public void onSubscribe(xn.b bVar) {
            if (DisposableHelper.setOnce(this, bVar)) {
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class k<T> implements io.reactivex.p<T> {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicReference<j<T>> f28956a;

        /* renamed from: b  reason: collision with root package name */
        private final b<T> f28957b;

        k(AtomicReference<j<T>> atomicReference, b<T> bVar) {
            this.f28956a = atomicReference;
            this.f28957b = bVar;
        }

        @Override // io.reactivex.p
        public void subscribe(r<? super T> rVar) {
            j<T> jVar;
            while (true) {
                jVar = this.f28956a.get();
                if (jVar != null) {
                    break;
                }
                j<T> jVar2 = new j<>(this.f28957b.call());
                if (this.f28956a.compareAndSet(null, jVar2)) {
                    jVar = jVar2;
                    break;
                }
            }
            d<T> dVar = new d<>(jVar, rVar);
            rVar.onSubscribe(dVar);
            jVar.a(dVar);
            if (dVar.isDisposed()) {
                jVar.b(dVar);
            } else {
                jVar.buffer.d(dVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    public static final class l<T> implements b<T> {

        /* renamed from: a  reason: collision with root package name */
        private final int f28958a;

        /* renamed from: b  reason: collision with root package name */
        private final long f28959b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f28960c;

        /* renamed from: d  reason: collision with root package name */
        private final s f28961d;

        l(int i10, long j10, TimeUnit timeUnit, s sVar) {
            this.f28958a = i10;
            this.f28959b = j10;
            this.f28960c = timeUnit;
            this.f28961d = sVar;
        }

        @Override // io.reactivex.internal.operators.observable.p2.b
        public h<T> call() {
            return new m(this.f28958a, this.f28959b, this.f28960c, this.f28961d);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class m<T> extends a<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAge;
        final s scheduler;
        final TimeUnit unit;

        m(int i10, long j10, TimeUnit timeUnit, s sVar) {
            this.scheduler = sVar;
            this.limit = i10;
            this.maxAge = j10;
            this.unit = timeUnit;
        }

        @Override // io.reactivex.internal.operators.observable.p2.a
        Object h(Object obj) {
            return new go.b(obj, this.scheduler.b(this.unit), this.unit);
        }

        @Override // io.reactivex.internal.operators.observable.p2.a
        f i() {
            f fVar;
            long b10 = this.scheduler.b(this.unit) - this.maxAge;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            while (true) {
                fVar2 = fVar3;
                fVar = fVar2;
                if (fVar2 != null) {
                    go.b bVar = (go.b) fVar2.value;
                    if (NotificationLite.isComplete(bVar.b()) || NotificationLite.isError(bVar.b()) || bVar.a() > b10) {
                        break;
                    }
                    fVar3 = fVar2.get();
                } else {
                    break;
                }
            }
            return fVar;
        }

        @Override // io.reactivex.internal.operators.observable.p2.a
        Object j(Object obj) {
            return ((go.b) obj).b();
        }

        @Override // io.reactivex.internal.operators.observable.p2.a
        void n() {
            f fVar;
            long b10 = this.scheduler.b(this.unit) - this.maxAge;
            f fVar2 = get();
            f fVar3 = fVar2.get();
            int i10 = 0;
            while (true) {
                fVar2 = fVar3;
                fVar = fVar2;
                if (fVar2 != null) {
                    int i11 = this.size;
                    if (i11 <= this.limit) {
                        if (((go.b) fVar2.value).a() > b10) {
                            break;
                        }
                        i10++;
                        this.size--;
                        fVar3 = fVar2.get();
                    } else {
                        i10++;
                        this.size = i11 - 1;
                        fVar3 = fVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i10 != 0) {
                l(fVar);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
            l(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0041, code lost:
            return;
         */
        @Override // io.reactivex.internal.operators.observable.p2.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void o() {
            long b10 = this.scheduler.b(this.unit) - this.maxAge;
            f fVar = get();
            f fVar2 = fVar.get();
            int i10 = 0;
            while (true) {
                fVar = fVar2;
                f fVar3 = fVar;
                if (fVar == null || this.size <= 1 || ((go.b) fVar.value).a() > b10) {
                    break;
                }
                i10++;
                this.size--;
                fVar2 = fVar.get();
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class n<T> extends a<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        n(int i10) {
            this.limit = i10;
        }

        @Override // io.reactivex.internal.operators.observable.p2.a
        void n() {
            if (this.size > this.limit) {
                k();
            }
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class o implements b<Object> {
        o() {
        }

        @Override // io.reactivex.internal.operators.observable.p2.b
        public h<Object> call() {
            return new p(16);
        }
    }

    /* compiled from: ObservableReplay.java */
    /* loaded from: classes3.dex */
    static final class p<T> extends ArrayList<Object> implements h<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        p(int i10) {
            super(i10);
        }

        @Override // io.reactivex.internal.operators.observable.p2.h
        public void a() {
            add(NotificationLite.complete());
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.p2.h
        public void b(T t10) {
            add(NotificationLite.next(t10));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.p2.h
        public void c(Throwable th2) {
            add(NotificationLite.error(th2));
            this.size++;
        }

        @Override // io.reactivex.internal.operators.observable.p2.h
        public void d(d<T> dVar) {
            if (dVar.getAndIncrement() == 0) {
                r<? super T> rVar = dVar.child;
                int i10 = 1;
                while (!dVar.isDisposed()) {
                    int i11 = this.size;
                    Integer num = (Integer) dVar.a();
                    int intValue = num != null ? num.intValue() : 0;
                    while (intValue < i11) {
                        if (!NotificationLite.accept(get(intValue), rVar) && !dVar.isDisposed()) {
                            intValue++;
                        } else {
                            return;
                        }
                    }
                    dVar.index = Integer.valueOf(intValue);
                    i10 = dVar.addAndGet(-i10);
                    if (i10 == 0) {
                        return;
                    }
                }
            }
        }
    }

    private p2(io.reactivex.p<T> pVar, io.reactivex.p<T> pVar2, AtomicReference<j<T>> atomicReference, b<T> bVar) {
        this.f28949d = pVar;
        this.f28946a = pVar2;
        this.f28947b = atomicReference;
        this.f28948c = bVar;
    }

    public static <T> p001do.a<T> d(io.reactivex.p<T> pVar, int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return h(pVar);
        }
        return g(pVar, new i(i10));
    }

    public static <T> p001do.a<T> e(io.reactivex.p<T> pVar, long j10, TimeUnit timeUnit, s sVar) {
        return f(pVar, j10, timeUnit, sVar, Integer.MAX_VALUE);
    }

    public static <T> p001do.a<T> f(io.reactivex.p<T> pVar, long j10, TimeUnit timeUnit, s sVar, int i10) {
        return g(pVar, new l(i10, j10, timeUnit, sVar));
    }

    static <T> p001do.a<T> g(io.reactivex.p<T> pVar, b<T> bVar) {
        AtomicReference atomicReference = new AtomicReference();
        return fo.a.k(new p2(new k(atomicReference, bVar), pVar, atomicReference, bVar));
    }

    public static <T> p001do.a<T> h(io.reactivex.p<? extends T> pVar) {
        return g(pVar, f28945e);
    }

    public static <U, R> io.reactivex.k<R> i(Callable<? extends p001do.a<U>> callable, zn.o<? super io.reactivex.k<U>, ? extends io.reactivex.p<R>> oVar) {
        return fo.a.o(new e(callable, oVar));
    }

    public static <T> p001do.a<T> j(p001do.a<T> aVar, s sVar) {
        return fo.a.k(new g(aVar, aVar.observeOn(sVar)));
    }

    @Override // ao.c
    public void a(xn.b bVar) {
        this.f28947b.compareAndSet((j) bVar, null);
    }

    @Override // p001do.a
    public void b(zn.g<? super xn.b> gVar) {
        j<T> jVar;
        while (true) {
            jVar = this.f28947b.get();
            if (jVar != null && !jVar.isDisposed()) {
                break;
            }
            j<T> jVar2 = new j<>(this.f28948c.call());
            if (this.f28947b.compareAndSet(jVar, jVar2)) {
                jVar = jVar2;
                break;
            }
        }
        boolean z10 = !jVar.shouldConnect.get() && jVar.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(jVar);
            if (z10) {
                this.f28946a.subscribe(jVar);
            }
        } catch (Throwable th2) {
            if (z10) {
                jVar.shouldConnect.compareAndSet(true, false);
            }
            io.reactivex.exceptions.a.b(th2);
            throw io.reactivex.internal.util.f.d(th2);
        }
    }

    @Override // io.reactivex.k
    protected void subscribeActual(r<? super T> rVar) {
        this.f28949d.subscribe(rVar);
    }
}
