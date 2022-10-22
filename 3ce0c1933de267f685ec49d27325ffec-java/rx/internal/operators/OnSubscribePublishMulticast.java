package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.c;
import rx.d;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.i;
import rx.internal.util.unsafe.f0;
import rx.internal.util.unsafe.r;
import rx.j;
/* loaded from: classes3.dex */
public final class OnSubscribePublishMulticast<T> extends AtomicInteger implements c.a<T>, d<T>, j {
    static final b<?>[] EMPTY = new b[0];
    static final b<?>[] TERMINATED = new b[0];
    private static final long serialVersionUID = -3741892510772238743L;
    final boolean delayError;
    volatile boolean done;
    Throwable error;
    final a<T> parent;
    final int prefetch;
    volatile e producer;
    final Queue<T> queue;
    volatile b<T>[] subscribers;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        final OnSubscribePublishMulticast<T> f33710a;

        public a(OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.f33710a = onSubscribePublishMulticast;
        }

        @Override // rx.d
        public void onCompleted() {
            this.f33710a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f33710a.onError(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.f33710a.onNext(t10);
        }

        @Override // rx.i
        public void setProducer(e eVar) {
            this.f33710a.h(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicLong implements e, j {
        private static final long serialVersionUID = 960704844171597367L;
        final i<? super T> actual;
        final AtomicBoolean once = new AtomicBoolean();
        final OnSubscribePublishMulticast<T> parent;

        public b(i<? super T> iVar, OnSubscribePublishMulticast<T> onSubscribePublishMulticast) {
            this.actual = iVar;
            this.parent = onSubscribePublishMulticast;
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return this.once.get();
        }

        @Override // rx.e
        public void request(long j10) {
            int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
            if (i10 < 0) {
                throw new IllegalArgumentException("n >= 0 required but it was " + j10);
            } else if (i10 != 0) {
                rx.internal.operators.a.b(this, j10);
                this.parent.d();
            }
        }

        @Override // rx.j
        public void unsubscribe() {
            if (this.once.compareAndSet(false, true)) {
                this.parent.g(this);
            }
        }
    }

    public OnSubscribePublishMulticast(int i10, boolean z10) {
        if (i10 > 0) {
            this.prefetch = i10;
            this.delayError = z10;
            if (f0.b()) {
                this.queue = new r(i10);
            } else {
                this.queue = new rx.internal.util.atomic.c(i10);
            }
            this.subscribers = (b<T>[]) EMPTY;
            this.parent = new a<>(this);
            return;
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i10);
    }

    boolean b(b<T> bVar) {
        b<T>[] bVarArr = this.subscribers;
        b<?>[] bVarArr2 = TERMINATED;
        if (bVarArr == bVarArr2) {
            return false;
        }
        synchronized (this) {
            b<T>[] bVarArr3 = this.subscribers;
            if (bVarArr3 == bVarArr2) {
                return false;
            }
            int length = bVarArr3.length;
            b<T>[] bVarArr4 = new b[length + 1];
            System.arraycopy(bVarArr3, 0, bVarArr4, 0, length);
            bVarArr4[length] = bVar;
            this.subscribers = bVarArr4;
            return true;
        }
    }

    boolean c(boolean z10, boolean z11) {
        int i10 = 0;
        if (z10) {
            if (!this.delayError) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    this.queue.clear();
                    b<T>[] i11 = i();
                    int length = i11.length;
                    while (i10 < length) {
                        i11[i10].actual.onError(th2);
                        i10++;
                    }
                    return true;
                } else if (z11) {
                    b<T>[] i12 = i();
                    int length2 = i12.length;
                    while (i10 < length2) {
                        i12[i10].actual.onCompleted();
                        i10++;
                    }
                    return true;
                }
            } else if (z11) {
                b<T>[] i13 = i();
                Throwable th3 = this.error;
                if (th3 != null) {
                    int length3 = i13.length;
                    while (i10 < length3) {
                        i13[i10].actual.onError(th3);
                        i10++;
                    }
                } else {
                    int length4 = i13.length;
                    while (i10 < length4) {
                        i13[i10].actual.onCompleted();
                        i10++;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // yp.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((i) ((i) obj));
    }

    void d() {
        int i10;
        if (getAndIncrement() == 0) {
            Queue<T> queue = this.queue;
            int i11 = 0;
            do {
                long j10 = Long.MAX_VALUE;
                b<T>[] bVarArr = this.subscribers;
                int length = bVarArr.length;
                for (b<T> bVar : bVarArr) {
                    j10 = Math.min(j10, bVar.get());
                }
                if (length != 0) {
                    long j11 = 0;
                    while (true) {
                        i10 = (j11 > j10 ? 1 : (j11 == j10 ? 0 : -1));
                        if (i10 == 0) {
                            break;
                        }
                        boolean z10 = this.done;
                        T poll = queue.poll();
                        boolean z11 = poll == null;
                        if (!c(z10, z11)) {
                            if (z11) {
                                break;
                            }
                            for (b<T> bVar2 : bVarArr) {
                                bVar2.actual.onNext(poll);
                            }
                            j11++;
                        } else {
                            return;
                        }
                    }
                    if (i10 == 0 && c(this.done, queue.isEmpty())) {
                        return;
                    }
                    if (j11 != 0) {
                        e eVar = this.producer;
                        if (eVar != null) {
                            eVar.request(j11);
                        }
                        for (b<T> bVar3 : bVarArr) {
                            rx.internal.operators.a.c(bVar3, j11);
                        }
                    }
                }
                i11 = addAndGet(-i11);
            } while (i11 != 0);
        }
    }

    void g(b<T> bVar) {
        b<?>[] bVarArr;
        b[] bVarArr2;
        b<T>[] bVarArr3 = this.subscribers;
        b<?>[] bVarArr4 = TERMINATED;
        if (bVarArr3 != bVarArr4 && bVarArr3 != (bVarArr = EMPTY)) {
            synchronized (this) {
                b<T>[] bVarArr5 = this.subscribers;
                if (!(bVarArr5 == bVarArr4 || bVarArr5 == bVarArr)) {
                    int i10 = -1;
                    int length = bVarArr5.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        } else if (bVarArr5[i11] == bVar) {
                            i10 = i11;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i10 >= 0) {
                        if (length == 1) {
                            bVarArr2 = EMPTY;
                        } else {
                            b[] bVarArr6 = new b[length - 1];
                            System.arraycopy(bVarArr5, 0, bVarArr6, 0, i10);
                            System.arraycopy(bVarArr5, i10 + 1, bVarArr6, i10, (length - i10) - 1);
                            bVarArr2 = bVarArr6;
                        }
                        this.subscribers = bVarArr2;
                    }
                }
            }
        }
    }

    void h(e eVar) {
        this.producer = eVar;
        eVar.request(this.prefetch);
    }

    b<T>[] i() {
        b<T>[] bVarArr = this.subscribers;
        b<T>[] bVarArr2 = (b<T>[]) TERMINATED;
        if (bVarArr != bVarArr2) {
            synchronized (this) {
                bVarArr = this.subscribers;
                if (bVarArr != bVarArr2) {
                    this.subscribers = bVarArr2;
                }
            }
        }
        return bVarArr;
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        return this.parent.isUnsubscribed();
    }

    @Override // rx.d
    public void onCompleted() {
        this.done = true;
        d();
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        this.error = th2;
        this.done = true;
        d();
    }

    @Override // rx.d
    public void onNext(T t10) {
        if (!this.queue.offer(t10)) {
            this.parent.unsubscribe();
            this.error = new MissingBackpressureException("Queue full?!");
            this.done = true;
        }
        d();
    }

    public i<T> subscriber() {
        return this.parent;
    }

    @Override // rx.j
    public void unsubscribe() {
        this.parent.unsubscribe();
    }

    public void call(i<? super T> iVar) {
        b<T> bVar = new b<>(iVar, this);
        iVar.add(bVar);
        iVar.setProducer(bVar);
        if (!b(bVar)) {
            Throwable th2 = this.error;
            if (th2 != null) {
                iVar.onError(th2);
            } else {
                iVar.onCompleted();
            }
        } else if (bVar.isUnsubscribed()) {
            g(bVar);
        } else {
            d();
        }
    }
}
