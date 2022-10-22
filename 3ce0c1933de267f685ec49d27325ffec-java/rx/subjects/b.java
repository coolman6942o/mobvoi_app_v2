package rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.c;
import rx.d;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.i;
import rx.j;
/* compiled from: PublishSubject.java */
/* loaded from: classes3.dex */
public final class b<T> extends d<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final C0488b<T> f34186b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublishSubject.java */
    /* loaded from: classes3.dex */
    public static final class a<T> extends AtomicLong implements e, j, d<T> {
        private static final long serialVersionUID = 6451806817170721536L;
        final i<? super T> actual;
        final C0488b<T> parent;
        long produced;

        public a(C0488b<T> bVar, i<? super T> iVar) {
            this.parent = bVar;
            this.actual = iVar;
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.d
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.actual.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (get() != Long.MIN_VALUE) {
                this.actual.onError(th2);
            }
        }

        @Override // rx.d
        public void onNext(T t10) {
            long j10 = get();
            if (j10 != Long.MIN_VALUE) {
                long j11 = this.produced;
                if (j10 != j11) {
                    this.produced = j11 + 1;
                    this.actual.onNext(t10);
                    return;
                }
                unsubscribe();
                this.actual.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        @Override // rx.e
        public void request(long j10) {
            long j11;
            if (rx.internal.operators.a.d(j10)) {
                do {
                    j11 = get();
                    if (j11 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j11, rx.internal.operators.a.a(j11, j10)));
            }
        }

        @Override // rx.j
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.d(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublishSubject.java */
    /* renamed from: rx.subjects.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0488b<T> extends AtomicReference<a<T>[]> implements c.a<T>, d<T> {
        static final a[] EMPTY = new a[0];
        static final a[] TERMINATED = new a[0];
        private static final long serialVersionUID = -7568940796666027140L;
        Throwable error;

        public C0488b() {
            lazySet(EMPTY);
        }

        boolean b(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == TERMINATED) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* renamed from: c */
        public void call(i<? super T> iVar) {
            a<T> aVar = new a<>(this, iVar);
            iVar.add(aVar);
            iVar.setProducer(aVar);
            if (!b(aVar)) {
                Throwable th2 = this.error;
                if (th2 != null) {
                    iVar.onError(th2);
                } else {
                    iVar.onCompleted();
                }
            } else if (aVar.isUnsubscribed()) {
                d(aVar);
            }
        }

        void d(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr != TERMINATED && aVarArr != EMPTY) {
                    int length = aVarArr.length;
                    int i10 = -1;
                    int i11 = 0;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        } else if (aVarArr[i11] == aVar) {
                            i10 = i11;
                            break;
                        } else {
                            i11++;
                        }
                    }
                    if (i10 >= 0) {
                        if (length == 1) {
                            aVarArr2 = EMPTY;
                        } else {
                            a[] aVarArr3 = new a[length - 1];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                            System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        @Override // rx.d
        public void onCompleted() {
            for (a<T> aVar : getAndSet(TERMINATED)) {
                aVar.onCompleted();
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.error = th2;
            ArrayList arrayList = null;
            for (a<T> aVar : getAndSet(TERMINATED)) {
                try {
                    aVar.onError(th2);
                } catch (Throwable th3) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th3);
                }
            }
            rx.exceptions.a.d(arrayList);
        }

        @Override // rx.d
        public void onNext(T t10) {
            for (a<T> aVar : get()) {
                aVar.onNext(t10);
            }
        }
    }

    protected b(C0488b<T> bVar) {
        super(bVar);
        this.f34186b = bVar;
    }

    public static <T> b<T> o0() {
        return new b<>(new C0488b());
    }

    @Override // rx.subjects.d
    public boolean m0() {
        return this.f34186b.get().length != 0;
    }

    @Override // rx.d
    public void onCompleted() {
        this.f34186b.onCompleted();
    }

    @Override // rx.d
    public void onError(Throwable th2) {
        this.f34186b.onError(th2);
    }

    @Override // rx.d
    public void onNext(T t10) {
        this.f34186b.onNext(t10);
    }
}
