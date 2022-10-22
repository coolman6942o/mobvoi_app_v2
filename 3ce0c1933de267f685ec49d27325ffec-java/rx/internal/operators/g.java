package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.c;
import rx.exceptions.MissingBackpressureException;
import rx.i;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.util.unsafe.f0;
import rx.internal.util.unsafe.z;
import rx.j;
/* compiled from: OnSubscribeCreate.java */
/* loaded from: classes3.dex */
public final class g<T> implements c.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final yp.b<Emitter<T>> f33816a;

    /* renamed from: b  reason: collision with root package name */
    final Emitter.BackpressureMode f33817b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f33818a;

        static {
            int[] iArr = new int[Emitter.BackpressureMode.values().length];
            f33818a = iArr;
            try {
                iArr[Emitter.BackpressureMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f33818a[Emitter.BackpressureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f33818a[Emitter.BackpressureMode.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f33818a[Emitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes3.dex */
    public static abstract class b<T> extends AtomicLong implements Emitter<T>, rx.e, j {
        private static final long serialVersionUID = 7326289992464377023L;
        final i<? super T> actual;
        final dq.d serial = new dq.d();

        public b(i<? super T> iVar) {
            this.actual = iVar;
        }

        @Override // rx.Emitter
        public final void a(yp.e eVar) {
            d(new CancellableSubscription(eVar));
        }

        void b() {
        }

        void c() {
        }

        public final void d(j jVar) {
            this.serial.a(jVar);
        }

        @Override // rx.j
        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onCompleted();
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (!this.actual.isUnsubscribed()) {
                try {
                    this.actual.onError(th2);
                } finally {
                    this.serial.unsubscribe();
                }
            }
        }

        @Override // rx.e
        public final void request(long j10) {
            if (rx.internal.operators.a.d(j10)) {
                rx.internal.operators.a.b(this, j10);
                b();
            }
        }

        @Override // rx.j
        public final void unsubscribe() {
            this.serial.unsubscribe();
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes3.dex */
    public static final class c<T> extends b<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;
        final Queue<Object> queue;
        final AtomicInteger wip;

        public c(i<? super T> iVar, int i10) {
            super(iVar);
            this.queue = f0.b() ? new z<>(i10) : new rx.internal.util.atomic.e<>(i10);
            this.wip = new AtomicInteger();
        }

        @Override // rx.internal.operators.g.b
        void b() {
            g();
        }

        @Override // rx.internal.operators.g.b
        void c() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void g() {
            int i10;
            if (this.wip.getAndIncrement() == 0) {
                i<? super T> iVar = this.actual;
                Queue<Object> queue = this.queue;
                int i11 = 1;
                do {
                    long j10 = get();
                    long j11 = 0;
                    while (true) {
                        i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                        if (i10 == 0) {
                            break;
                        } else if (iVar.isUnsubscribed()) {
                            queue.clear();
                            return;
                        } else {
                            boolean z10 = this.done;
                            Object poll = queue.poll();
                            boolean z11 = poll == null;
                            if (z10 && z11) {
                                Throwable th2 = this.error;
                                if (th2 != null) {
                                    super.onError(th2);
                                    return;
                                } else {
                                    super.onCompleted();
                                    return;
                                }
                            } else if (z11) {
                                break;
                            } else {
                                iVar.onNext((Object) rx.internal.operators.d.d(poll));
                                j11++;
                            }
                        }
                    }
                    if (i10 == 0) {
                        if (iVar.isUnsubscribed()) {
                            queue.clear();
                            return;
                        }
                        boolean z12 = this.done;
                        boolean isEmpty = queue.isEmpty();
                        if (z12 && isEmpty) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                super.onError(th3);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j11 != 0) {
                        rx.internal.operators.a.c(this, j11);
                    }
                    i11 = this.wip.addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        @Override // rx.internal.operators.g.b, rx.d
        public void onCompleted() {
            this.done = true;
            g();
        }

        @Override // rx.internal.operators.g.b, rx.d
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            g();
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.queue.offer(rx.internal.operators.d.g(t10));
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes3.dex */
    public static final class d<T> extends AbstractC0473g<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public d(i<? super T> iVar) {
            super(iVar);
        }

        @Override // rx.internal.operators.g.AbstractC0473g
        void g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes3.dex */
    public static final class e<T> extends AbstractC0473g<T> {
        private static final long serialVersionUID = 338953216916120960L;
        private boolean done;

        public e(i<? super T> iVar) {
            super(iVar);
        }

        @Override // rx.internal.operators.g.AbstractC0473g
        void g() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }

        @Override // rx.internal.operators.g.b, rx.d
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                super.onCompleted();
            }
        }

        @Override // rx.internal.operators.g.b, rx.d
        public void onError(Throwable th2) {
            if (this.done) {
                bq.c.i(th2);
                return;
            }
            this.done = true;
            super.onError(th2);
        }

        @Override // rx.internal.operators.g.AbstractC0473g, rx.d
        public void onNext(T t10) {
            if (!this.done) {
                super.onNext(t10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes3.dex */
    public static final class f<T> extends b<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;
        final AtomicReference<Object> queue = new AtomicReference<>();
        final AtomicInteger wip = new AtomicInteger();

        public f(i<? super T> iVar) {
            super(iVar);
        }

        @Override // rx.internal.operators.g.b
        void b() {
            g();
        }

        @Override // rx.internal.operators.g.b
        void c() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        void g() {
            int i10;
            boolean z10;
            if (this.wip.getAndIncrement() == 0) {
                i<? super T> iVar = this.actual;
                AtomicReference<Object> atomicReference = this.queue;
                int i11 = 1;
                do {
                    long j10 = get();
                    long j11 = 0;
                    while (true) {
                        i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                        z10 = false;
                        if (i10 == 0) {
                            break;
                        } else if (iVar.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        } else {
                            boolean z11 = this.done;
                            Object andSet = atomicReference.getAndSet(null);
                            boolean z12 = andSet == null;
                            if (z11 && z12) {
                                Throwable th2 = this.error;
                                if (th2 != null) {
                                    super.onError(th2);
                                    return;
                                } else {
                                    super.onCompleted();
                                    return;
                                }
                            } else if (z12) {
                                break;
                            } else {
                                iVar.onNext((Object) rx.internal.operators.d.d(andSet));
                                j11++;
                            }
                        }
                    }
                    if (i10 == 0) {
                        if (iVar.isUnsubscribed()) {
                            atomicReference.lazySet(null);
                            return;
                        }
                        boolean z13 = this.done;
                        if (atomicReference.get() == null) {
                            z10 = true;
                        }
                        if (z13 && z10) {
                            Throwable th3 = this.error;
                            if (th3 != null) {
                                super.onError(th3);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        }
                    }
                    if (j11 != 0) {
                        rx.internal.operators.a.c(this, j11);
                    }
                    i11 = this.wip.addAndGet(-i11);
                } while (i11 != 0);
            }
        }

        @Override // rx.internal.operators.g.b, rx.d
        public void onCompleted() {
            this.done = true;
            g();
        }

        @Override // rx.internal.operators.g.b, rx.d
        public void onError(Throwable th2) {
            this.error = th2;
            this.done = true;
            g();
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.queue.set(rx.internal.operators.d.g(t10));
            g();
        }
    }

    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.operators.g$g  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    static abstract class AbstractC0473g<T> extends b<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public AbstractC0473g(i<? super T> iVar) {
            super(iVar);
        }

        abstract void g();

        public void onNext(T t10) {
            if (!this.actual.isUnsubscribed()) {
                if (get() != 0) {
                    this.actual.onNext(t10);
                    rx.internal.operators.a.c(this, 1L);
                    return;
                }
                g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: classes3.dex */
    public static final class h<T> extends b<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public h(i<? super T> iVar) {
            super(iVar);
        }

        @Override // rx.d
        public void onNext(T t10) {
            long j10;
            if (!this.actual.isUnsubscribed()) {
                this.actual.onNext(t10);
                do {
                    j10 = get();
                    if (j10 == 0) {
                        return;
                    }
                } while (!compareAndSet(j10, j10 - 1));
            }
        }
    }

    public g(yp.b<Emitter<T>> bVar, Emitter.BackpressureMode backpressureMode) {
        this.f33816a = bVar;
        this.f33817b = backpressureMode;
    }

    /* renamed from: a */
    public void call(i<? super T> iVar) {
        b bVar;
        int i10 = a.f33818a[this.f33817b.ordinal()];
        if (i10 == 1) {
            bVar = new h(iVar);
        } else if (i10 == 2) {
            bVar = new e(iVar);
        } else if (i10 == 3) {
            bVar = new d(iVar);
        } else if (i10 != 4) {
            bVar = new c(iVar, rx.internal.util.f.f34130c);
        } else {
            bVar = new f(iVar);
        }
        iVar.add(bVar);
        iVar.setProducer(bVar);
        this.f33816a.call(bVar);
    }
}
