package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.c;
import rx.d;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.i;
import rx.internal.util.f;
import yp.h;
import yp.j;
import yp.k;
/* compiled from: OperatorZip.java */
/* loaded from: classes3.dex */
public final class h0<R> implements c.b<R, rx.c<?>[]> {

    /* renamed from: a  reason: collision with root package name */
    final j<? extends R> f33825a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZip.java */
    /* loaded from: classes3.dex */
    public static final class a<R> extends AtomicLong {
        static final int THRESHOLD = (int) (f.f34130c * 0.7d);
        private static final long serialVersionUID = 5995274816189928317L;
        final d<? super R> child;
        private final dq.b childSubscription;
        int emitted;
        private AtomicLong requested;
        private volatile Object[] subscribers;
        private final j<? extends R> zipFunction;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorZip.java */
        /* renamed from: rx.internal.operators.h0$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public final class C0474a extends i {

            /* renamed from: a  reason: collision with root package name */
            final f f33826a = f.a();

            C0474a() {
            }

            public void b(long j10) {
                request(j10);
            }

            @Override // rx.d
            public void onCompleted() {
                this.f33826a.f();
                a.this.b();
            }

            @Override // rx.d
            public void onError(Throwable th2) {
                a.this.child.onError(th2);
            }

            @Override // rx.d
            public void onNext(Object obj) {
                try {
                    this.f33826a.g(obj);
                } catch (MissingBackpressureException e10) {
                    onError(e10);
                }
                a.this.b();
            }

            @Override // rx.i
            public void onStart() {
                request(f.f34130c);
            }
        }

        public a(i<? super R> iVar, j<? extends R> jVar) {
            dq.b bVar = new dq.b();
            this.childSubscription = bVar;
            this.child = iVar;
            this.zipFunction = jVar;
            iVar.add(bVar);
        }

        public void a(rx.c[] cVarArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[cVarArr.length];
            for (int i10 = 0; i10 < cVarArr.length; i10++) {
                C0474a aVar = new C0474a();
                objArr[i10] = aVar;
                this.childSubscription.a(aVar);
            }
            this.requested = atomicLong;
            this.subscribers = objArr;
            for (int i11 = 0; i11 < cVarArr.length; i11++) {
                cVarArr[i11].j0((C0474a) objArr[i11]);
            }
        }

        void b() {
            Object[] objArr = this.subscribers;
            if (objArr != null && getAndIncrement() == 0) {
                int length = objArr.length;
                d<? super R> dVar = this.child;
                AtomicLong atomicLong = this.requested;
                while (true) {
                    Object[] objArr2 = new Object[length];
                    boolean z10 = true;
                    for (int i10 = 0; i10 < length; i10++) {
                        f fVar = ((C0474a) objArr[i10]).f33826a;
                        Object h10 = fVar.h();
                        if (h10 == null) {
                            z10 = false;
                        } else if (fVar.d(h10)) {
                            dVar.onCompleted();
                            this.childSubscription.unsubscribe();
                            return;
                        } else {
                            objArr2[i10] = fVar.c(h10);
                        }
                    }
                    if (z10 && atomicLong.get() > 0) {
                        try {
                            dVar.onNext((R) this.zipFunction.call(objArr2));
                            atomicLong.decrementAndGet();
                            this.emitted++;
                            for (Object obj : objArr) {
                                f fVar2 = ((C0474a) obj).f33826a;
                                fVar2.i();
                                if (fVar2.d(fVar2.h())) {
                                    dVar.onCompleted();
                                    this.childSubscription.unsubscribe();
                                    return;
                                }
                            }
                            if (this.emitted > THRESHOLD) {
                                for (Object obj2 : objArr) {
                                    ((C0474a) obj2).b(this.emitted);
                                }
                                this.emitted = 0;
                            }
                        } catch (Throwable th2) {
                            rx.exceptions.a.g(th2, dVar, objArr2);
                            return;
                        }
                    } else if (decrementAndGet() <= 0) {
                        return;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZip.java */
    /* loaded from: classes3.dex */
    public static final class b<R> extends AtomicLong implements e {
        private static final long serialVersionUID = -1216676403723546796L;
        final a<R> zipper;

        public b(a<R> aVar) {
            this.zipper = aVar;
        }

        @Override // rx.e
        public void request(long j10) {
            rx.internal.operators.a.b(this, j10);
            this.zipper.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZip.java */
    /* loaded from: classes3.dex */
    public final class c extends i<rx.c[]> {

        /* renamed from: a  reason: collision with root package name */
        final i<? super R> f33828a;

        /* renamed from: b  reason: collision with root package name */
        final a<R> f33829b;

        /* renamed from: c  reason: collision with root package name */
        final b<R> f33830c;

        /* renamed from: d  reason: collision with root package name */
        boolean f33831d;

        public c(h0 h0Var, i<? super R> iVar, a<R> aVar, b<R> bVar) {
            this.f33828a = iVar;
            this.f33829b = aVar;
            this.f33830c = bVar;
        }

        /* renamed from: b */
        public void onNext(rx.c[] cVarArr) {
            if (cVarArr == null || cVarArr.length == 0) {
                this.f33828a.onCompleted();
                return;
            }
            this.f33831d = true;
            this.f33829b.a(cVarArr, this.f33830c);
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33831d) {
                this.f33828a.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f33828a.onError(th2);
        }
    }

    public h0(h hVar) {
        this.f33825a = k.a(hVar);
    }

    /* renamed from: a */
    public i<? super rx.c[]> call(i<? super R> iVar) {
        a aVar = new a(iVar, this.f33825a);
        b bVar = new b(aVar);
        c cVar = new c(this, iVar, aVar, bVar);
        iVar.add(cVar);
        iVar.setProducer(bVar);
        return cVar;
    }

    public h0(yp.i iVar) {
        this.f33825a = k.b(iVar);
    }
}
