package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.c;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.f;
import rx.i;
import rx.internal.schedulers.h;
import rx.internal.util.unsafe.f0;
import rx.internal.util.unsafe.r;
/* compiled from: OperatorObserveOn.java */
/* loaded from: classes3.dex */
public final class a0<T> implements c.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final f f33711a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f33712b;

    /* renamed from: c  reason: collision with root package name */
    private final int f33713c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorObserveOn.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends i<T> implements yp.a {

        /* renamed from: a  reason: collision with root package name */
        final i<? super T> f33714a;

        /* renamed from: b  reason: collision with root package name */
        final f.a f33715b;

        /* renamed from: c  reason: collision with root package name */
        final boolean f33716c;

        /* renamed from: d  reason: collision with root package name */
        final Queue<Object> f33717d;

        /* renamed from: e  reason: collision with root package name */
        final int f33718e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f33719f;

        /* renamed from: g  reason: collision with root package name */
        final AtomicLong f33720g = new AtomicLong();

        /* renamed from: h  reason: collision with root package name */
        final AtomicLong f33721h = new AtomicLong();

        /* renamed from: i  reason: collision with root package name */
        Throwable f33722i;

        /* renamed from: j  reason: collision with root package name */
        long f33723j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorObserveOn.java */
        /* renamed from: rx.internal.operators.a0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0470a implements e {
            C0470a() {
            }

            @Override // rx.e
            public void request(long j10) {
                if (j10 > 0) {
                    rx.internal.operators.a.b(a.this.f33720g, j10);
                    a.this.d();
                }
            }
        }

        public a(f fVar, i<? super T> iVar, boolean z10, int i10) {
            this.f33714a = iVar;
            this.f33715b = fVar.a();
            this.f33716c = z10;
            i10 = i10 <= 0 ? rx.internal.util.f.f34130c : i10;
            this.f33718e = i10 - (i10 >> 2);
            if (f0.b()) {
                this.f33717d = new r(i10);
            } else {
                this.f33717d = new rx.internal.util.atomic.c(i10);
            }
            request(i10);
        }

        boolean b(boolean z10, boolean z11, i<? super T> iVar, Queue<Object> queue) {
            if (iVar.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (!z10) {
                return false;
            } else {
                if (!this.f33716c) {
                    Throwable th2 = this.f33722i;
                    if (th2 != null) {
                        queue.clear();
                        try {
                            iVar.onError(th2);
                            return true;
                        } finally {
                        }
                    } else if (!z11) {
                        return false;
                    } else {
                        try {
                            iVar.onCompleted();
                            return true;
                        } finally {
                        }
                    }
                } else if (!z11) {
                    return false;
                } else {
                    Throwable th3 = this.f33722i;
                    try {
                        if (th3 != null) {
                            iVar.onError(th3);
                        } else {
                            iVar.onCompleted();
                        }
                        return false;
                    } finally {
                    }
                }
            }
        }

        void c() {
            i<? super T> iVar = this.f33714a;
            iVar.setProducer(new C0470a());
            iVar.add(this.f33715b);
            iVar.add(this);
        }

        @Override // yp.a
        public void call() {
            int i10;
            long j10 = this.f33723j;
            Queue<Object> queue = this.f33717d;
            i<? super T> iVar = this.f33714a;
            long j11 = 1;
            do {
                long j12 = this.f33720g.get();
                while (true) {
                    i10 = (j12 > j10 ? 1 : (j12 == j10 ? 0 : -1));
                    if (i10 == 0) {
                        break;
                    }
                    boolean z10 = this.f33719f;
                    Object poll = queue.poll();
                    boolean z11 = poll == null;
                    if (!b(z10, z11, iVar, queue)) {
                        if (z11) {
                            break;
                        }
                        iVar.onNext((Object) d.d(poll));
                        j10++;
                        if (j10 == this.f33718e) {
                            j12 = rx.internal.operators.a.c(this.f33720g, j10);
                            request(j10);
                            j10 = 0;
                        }
                    } else {
                        return;
                    }
                }
                if (i10 != 0 || !b(this.f33719f, queue.isEmpty(), iVar, queue)) {
                    this.f33723j = j10;
                    j11 = this.f33721h.addAndGet(-j11);
                } else {
                    return;
                }
            } while (j11 != 0);
        }

        protected void d() {
            if (this.f33721h.getAndIncrement() == 0) {
                this.f33715b.b(this);
            }
        }

        @Override // rx.d
        public void onCompleted() {
            if (!isUnsubscribed() && !this.f33719f) {
                this.f33719f = true;
                d();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (isUnsubscribed() || this.f33719f) {
                bq.c.i(th2);
                return;
            }
            this.f33722i = th2;
            this.f33719f = true;
            d();
        }

        @Override // rx.d
        public void onNext(T t10) {
            if (!isUnsubscribed() && !this.f33719f) {
                if (!this.f33717d.offer(d.g(t10))) {
                    onError(new MissingBackpressureException());
                } else {
                    d();
                }
            }
        }
    }

    public a0(f fVar, boolean z10, int i10) {
        this.f33711a = fVar;
        this.f33712b = z10;
        this.f33713c = i10 <= 0 ? rx.internal.util.f.f34130c : i10;
    }

    /* renamed from: a */
    public i<? super T> call(i<? super T> iVar) {
        f fVar = this.f33711a;
        if (fVar instanceof h) {
            return iVar;
        }
        a aVar = new a(fVar, iVar, this.f33712b, this.f33713c);
        aVar.c();
        return aVar;
    }
}
