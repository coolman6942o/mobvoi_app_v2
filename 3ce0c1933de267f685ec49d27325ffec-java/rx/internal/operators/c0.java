package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.c;
import rx.d;
import rx.e;
import rx.i;
import rx.j;
/* compiled from: OperatorOnBackpressureLatest.java */
/* loaded from: classes3.dex */
public final class c0<T> implements c.b<T, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureLatest.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final c0<Object> f33738a = new c0<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureLatest.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicLong implements e, j, d<T> {
        static final Object EMPTY = new Object();
        static final long NOT_REQUESTED = -4611686018427387904L;
        private static final long serialVersionUID = -1364393685005146274L;
        final i<? super T> child;
        volatile boolean done;
        boolean emitting;
        boolean missed;
        c<? super T> parent;
        Throwable terminal;
        final AtomicReference<Object> value = new AtomicReference<>(EMPTY);

        public b(i<? super T> iVar) {
            this.child = iVar;
            lazySet(NOT_REQUESTED);
        }

        void b() {
            boolean z10;
            Throwable th2;
            Object obj;
            synchronized (this) {
                boolean z11 = true;
                if (this.emitting) {
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                this.missed = false;
                while (true) {
                    try {
                        long j10 = get();
                        if (j10 != Long.MIN_VALUE) {
                            Object obj2 = this.value.get();
                            if (j10 > 0 && obj2 != (obj = EMPTY)) {
                                this.child.onNext(obj2);
                                this.value.compareAndSet(obj2, obj);
                                c(1L);
                                obj2 = obj;
                            }
                            if (obj2 == EMPTY && this.done) {
                                Throwable th3 = this.terminal;
                                if (th3 != null) {
                                    this.child.onError(th3);
                                } else {
                                    this.child.onCompleted();
                                }
                            }
                            try {
                                synchronized (this) {
                                    try {
                                        if (!this.missed) {
                                            this.emitting = false;
                                            return;
                                        }
                                        this.missed = false;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        z11 = false;
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                            try {
                                throw th;
                            } catch (Throwable th6) {
                                th2 = th6;
                                z10 = z11;
                                if (!z10) {
                                    synchronized (this) {
                                        this.emitting = false;
                                    }
                                }
                                throw th2;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        z10 = false;
                    }
                }
            }
        }

        long c(long j10) {
            long j11;
            long j12;
            do {
                j11 = get();
                if (j11 < 0) {
                    return j11;
                }
                j12 = j11 - j10;
            } while (!compareAndSet(j11, j12));
            return j12;
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.d
        public void onCompleted() {
            this.done = true;
            b();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.terminal = th2;
            this.done = true;
            b();
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.value.lazySet(t10);
            b();
        }

        @Override // rx.e
        public void request(long j10) {
            long j11;
            int i10;
            long j12;
            if (j10 >= 0) {
                do {
                    j11 = get();
                    if (j11 != Long.MIN_VALUE) {
                        i10 = (j11 > NOT_REQUESTED ? 1 : (j11 == NOT_REQUESTED ? 0 : -1));
                        if (i10 == 0) {
                            j12 = j10;
                        } else {
                            j12 = j11 + j10;
                            if (j12 < 0) {
                                j12 = Long.MAX_VALUE;
                            }
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j11, j12));
                if (i10 == 0) {
                    this.parent.b(Long.MAX_VALUE);
                }
                b();
            }
        }

        @Override // rx.j
        public void unsubscribe() {
            if (get() >= 0) {
                getAndSet(Long.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorOnBackpressureLatest.java */
    /* loaded from: classes3.dex */
    public static final class c<T> extends i<T> {

        /* renamed from: a  reason: collision with root package name */
        private final b<T> f33739a;

        c(b<T> bVar) {
            this.f33739a = bVar;
        }

        void b(long j10) {
            request(j10);
        }

        @Override // rx.d
        public void onCompleted() {
            this.f33739a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f33739a.onError(th2);
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.f33739a.onNext(t10);
        }

        @Override // rx.i
        public void onStart() {
            request(0L);
        }
    }

    public static <T> c0<T> b() {
        return (c0<T>) a.f33738a;
    }

    /* renamed from: a */
    public i<? super T> call(i<? super T> iVar) {
        b bVar = new b(iVar);
        c<? super T> cVar = new c<>(bVar);
        bVar.parent = cVar;
        iVar.add(cVar);
        iVar.add(bVar);
        iVar.setProducer(bVar);
        return cVar;
    }
}
