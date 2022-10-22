package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.c;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.i;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.f;
import rx.internal.util.g;
import rx.internal.util.unsafe.f0;
import rx.internal.util.unsafe.r;
/* compiled from: OperatorMerge.java */
/* loaded from: classes3.dex */
public final class z<T> implements c.b<T, rx.c<? extends T>> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f33969a;

    /* renamed from: b  reason: collision with root package name */
    final int f33970b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final z<Object> f33971a = new z<>(true, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final z<Object> f33972a = new z<>(false, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class c<T> extends i<T> {

        /* renamed from: f  reason: collision with root package name */
        static final int f33973f = f.f34130c / 4;

        /* renamed from: a  reason: collision with root package name */
        final e<T> f33974a;

        /* renamed from: b  reason: collision with root package name */
        final long f33975b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f33976c;

        /* renamed from: d  reason: collision with root package name */
        volatile f f33977d;

        /* renamed from: e  reason: collision with root package name */
        int f33978e;

        public c(e<T> eVar, long j10) {
            this.f33974a = eVar;
            this.f33975b = j10;
        }

        public void b(long j10) {
            int i10 = this.f33978e - ((int) j10);
            if (i10 > f33973f) {
                this.f33978e = i10;
                return;
            }
            int i11 = f.f34130c;
            this.f33978e = i11;
            int i12 = i11 - i10;
            if (i12 > 0) {
                request(i12);
            }
        }

        @Override // rx.d
        public void onCompleted() {
            this.f33976c = true;
            this.f33974a.d();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            this.f33976c = true;
            this.f33974a.j().offer(th2);
            this.f33974a.d();
        }

        @Override // rx.d
        public void onNext(T t10) {
            this.f33974a.r(this, t10);
        }

        @Override // rx.i
        public void onStart() {
            int i10 = f.f34130c;
            this.f33978e = i10;
            request(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class d<T> extends AtomicLong implements rx.e {
        private static final long serialVersionUID = -1214379189873595503L;
        final e<T> subscriber;

        public d(e<T> eVar) {
            this.subscriber = eVar;
        }

        public long a(int i10) {
            return addAndGet(-i10);
        }

        @Override // rx.e
        public void request(long j10) {
            int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
            if (i10 > 0) {
                if (get() != Long.MAX_VALUE) {
                    rx.internal.operators.a.b(this, j10);
                    this.subscriber.d();
                }
            } else if (i10 < 0) {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class e<T> extends i<rx.c<? extends T>> {

        /* renamed from: r  reason: collision with root package name */
        static final c<?>[] f33979r = new c[0];

        /* renamed from: a  reason: collision with root package name */
        final i<? super T> f33980a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f33981b;

        /* renamed from: c  reason: collision with root package name */
        final int f33982c;

        /* renamed from: d  reason: collision with root package name */
        d<T> f33983d;

        /* renamed from: e  reason: collision with root package name */
        volatile Queue<Object> f33984e;

        /* renamed from: f  reason: collision with root package name */
        volatile dq.b f33985f;

        /* renamed from: g  reason: collision with root package name */
        volatile ConcurrentLinkedQueue<Throwable> f33986g;

        /* renamed from: h  reason: collision with root package name */
        volatile boolean f33987h;

        /* renamed from: i  reason: collision with root package name */
        boolean f33988i;

        /* renamed from: j  reason: collision with root package name */
        boolean f33989j;

        /* renamed from: k  reason: collision with root package name */
        final Object f33990k = new Object();

        /* renamed from: l  reason: collision with root package name */
        volatile c<?>[] f33991l = f33979r;

        /* renamed from: m  reason: collision with root package name */
        long f33992m;

        /* renamed from: n  reason: collision with root package name */
        long f33993n;

        /* renamed from: o  reason: collision with root package name */
        int f33994o;

        /* renamed from: p  reason: collision with root package name */
        final int f33995p;

        /* renamed from: q  reason: collision with root package name */
        int f33996q;

        public e(i<? super T> iVar, boolean z10, int i10) {
            this.f33980a = iVar;
            this.f33981b = z10;
            this.f33982c = i10;
            if (i10 == Integer.MAX_VALUE) {
                this.f33995p = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
                return;
            }
            this.f33995p = Math.max(1, i10 >> 1);
            request(i10);
        }

        private void o() {
            ArrayList arrayList = new ArrayList(this.f33986g);
            if (arrayList.size() == 1) {
                this.f33980a.onError((Throwable) arrayList.get(0));
            } else {
                this.f33980a.onError(new CompositeException(arrayList));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void b(c<T> cVar) {
            i().a(cVar);
            synchronized (this.f33990k) {
                c<?>[] cVarArr = this.f33991l;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.f33991l = cVarArr2;
            }
        }

        boolean c() {
            if (this.f33980a.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f33986g;
            if (this.f33981b || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                o();
                return true;
            } finally {
                unsubscribe();
            }
        }

        void d() {
            synchronized (this) {
                if (this.f33988i) {
                    this.f33989j = true;
                    return;
                }
                this.f33988i = true;
                f();
            }
        }

        void e() {
            int i10 = this.f33996q + 1;
            if (i10 == this.f33995p) {
                this.f33996q = 0;
                p(i10);
                return;
            }
            this.f33996q = i10;
        }

        void f() {
            boolean z10;
            Throwable th2;
            long j10;
            int i10;
            boolean z11;
            Throwable th3;
            int i11;
            try {
                i<? super T> iVar = this.f33980a;
                while (!c()) {
                    Queue<Object> queue = this.f33984e;
                    long j11 = this.f33983d.get();
                    boolean z12 = j11 == Long.MAX_VALUE;
                    if (queue != null) {
                        int i12 = 0;
                        while (true) {
                            j10 = j11;
                            i10 = i12;
                            int i13 = 0;
                            Object obj = null;
                            while (true) {
                                if (j10 <= 0) {
                                    break;
                                }
                                Object poll = queue.poll();
                                if (!c()) {
                                    if (poll == null) {
                                        obj = poll;
                                        break;
                                    }
                                    iVar.onNext((Object) rx.internal.operators.d.d(poll));
                                    i10++;
                                    i13++;
                                    j10--;
                                    obj = poll;
                                } else {
                                    return;
                                }
                            }
                            if (i13 > 0) {
                                j10 = z12 ? Long.MAX_VALUE : this.f33983d.a(i13);
                            }
                            if (j10 == 0 || obj == null) {
                                break;
                            }
                            i12 = i10;
                            j11 = j10;
                        }
                    } else {
                        j10 = j11;
                        i10 = 0;
                    }
                    boolean z13 = this.f33987h;
                    Queue<Object> queue2 = this.f33984e;
                    c<?>[] cVarArr = this.f33991l;
                    int length = cVarArr.length;
                    if (!z13 || ((queue2 != null && !queue2.isEmpty()) || length != 0)) {
                        if (length > 0) {
                            long j12 = this.f33993n;
                            int i14 = this.f33994o;
                            if (length <= i14 || cVarArr[i14].f33975b != j12) {
                                if (length <= i14) {
                                    i14 = 0;
                                }
                                for (int i15 = 0; i15 < length && cVarArr[i14].f33975b != j12; i15++) {
                                    i14++;
                                    if (i14 == length) {
                                        i14 = 0;
                                    }
                                }
                                this.f33994o = i14;
                                this.f33993n = cVarArr[i14].f33975b;
                            }
                            z11 = false;
                            for (int i16 = 0; i16 < length; i16++) {
                                if (!c()) {
                                    c<?> cVar = cVarArr[i14];
                                    Object obj2 = null;
                                    do {
                                        int i17 = 0;
                                        while (j10 > 0) {
                                            if (!c()) {
                                                f fVar = cVar.f33977d;
                                                if (fVar == null || (obj2 = fVar.i()) == null) {
                                                    break;
                                                }
                                                try {
                                                    iVar.onNext((Object) rx.internal.operators.d.d(obj2));
                                                    j10--;
                                                    i17++;
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                        if (i17 > 0) {
                                            j10 = !z12 ? this.f33983d.a(i17) : Long.MAX_VALUE;
                                            cVar.b(i17);
                                        }
                                        i11 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
                                        if (i11 == 0) {
                                            break;
                                        }
                                    } while (obj2 != null);
                                    boolean z14 = cVar.f33976c;
                                    f fVar2 = cVar.f33977d;
                                    if (z14 && (fVar2 == null || fVar2.e())) {
                                        n(cVar);
                                        if (!c()) {
                                            i10++;
                                            z11 = true;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (i11 == 0) {
                                        break;
                                    }
                                    i14++;
                                    if (i14 == length) {
                                        i14 = 0;
                                    }
                                } else {
                                    return;
                                }
                            }
                            this.f33994o = i14;
                            this.f33993n = cVarArr[i14].f33975b;
                        } else {
                            z11 = false;
                        }
                        if (i10 > 0) {
                            request(i10);
                        }
                        if (!z11) {
                            synchronized (this) {
                                try {
                                    if (!this.f33989j) {
                                        try {
                                            this.f33988i = false;
                                            return;
                                        } catch (Throwable th4) {
                                            th3 = th4;
                                            z10 = true;
                                            while (true) {
                                                try {
                                                    break;
                                                } catch (Throwable th5) {
                                                    th3 = th5;
                                                }
                                            }
                                            throw th3;
                                        }
                                    } else {
                                        this.f33989j = false;
                                    }
                                } catch (Throwable th6) {
                                    th3 = th6;
                                    z10 = false;
                                }
                            }
                            try {
                                break;
                                throw th3;
                            } catch (Throwable th7) {
                                th2 = th7;
                                if (!z10) {
                                    synchronized (this) {
                                        this.f33988i = false;
                                    }
                                }
                                throw th2;
                            }
                        }
                    } else {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f33986g;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            o();
                            return;
                        }
                        iVar.onCompleted();
                        return;
                    }
                }
            } catch (Throwable th8) {
                th2 = th8;
                z10 = false;
            }
        }

        protected void g(T t10, long j10) {
            try {
                this.f33980a.onNext(t10);
                if (j10 != Long.MAX_VALUE) {
                    this.f33983d.a(1);
                }
                int i10 = this.f33996q + 1;
                if (i10 == this.f33995p) {
                    this.f33996q = 0;
                    p(i10);
                } else {
                    this.f33996q = i10;
                }
                synchronized (this) {
                    try {
                        if (!this.f33989j) {
                            this.f33988i = false;
                            return;
                        }
                        this.f33989j = false;
                        f();
                    }
                }
            }
        }

        protected void h(c<T> cVar, T t10, long j10) {
            try {
                this.f33980a.onNext(t10);
                if (j10 != Long.MAX_VALUE) {
                    this.f33983d.a(1);
                }
                cVar.b(1L);
                synchronized (this) {
                    try {
                        if (!this.f33989j) {
                            this.f33988i = false;
                            return;
                        }
                        this.f33989j = false;
                        f();
                    }
                }
            }
        }

        dq.b i() {
            dq.b bVar;
            dq.b bVar2 = this.f33985f;
            if (bVar2 != null) {
                return bVar2;
            }
            boolean z10 = false;
            synchronized (this) {
                bVar = this.f33985f;
                if (bVar == null) {
                    dq.b bVar3 = new dq.b();
                    this.f33985f = bVar3;
                    z10 = true;
                    bVar = bVar3;
                }
            }
            if (z10) {
                add(bVar);
            }
            return bVar;
        }

        Queue<Throwable> j() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.f33986g;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.f33986g;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.f33986g = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: k */
        public void onNext(rx.c<? extends T> cVar) {
            if (cVar != null) {
                if (cVar == rx.c.s()) {
                    e();
                } else if (cVar instanceof g) {
                    q(((g) cVar).o0());
                } else {
                    long j10 = this.f33992m;
                    this.f33992m = 1 + j10;
                    c cVar2 = new c(this, j10);
                    b(cVar2);
                    cVar.j0(cVar2);
                    d();
                }
            }
        }

        protected void l(T t10) {
            Queue<Object> queue;
            Queue<Object> queue2 = this.f33984e;
            if (queue2 == null) {
                int i10 = this.f33982c;
                if (i10 == Integer.MAX_VALUE) {
                    queue2 = new rx.internal.util.atomic.e<>(f.f34130c);
                } else {
                    if (!rx.internal.util.unsafe.i.a(i10)) {
                        queue = new SpscExactAtomicArrayQueue<>(i10);
                    } else if (f0.b()) {
                        queue = new r<>(i10);
                    } else {
                        queue = new rx.internal.util.atomic.c<>(i10);
                    }
                    queue2 = queue;
                }
                this.f33984e = queue2;
            }
            if (!queue2.offer(rx.internal.operators.d.g(t10))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t10));
            }
        }

        protected void m(c<T> cVar, T t10) {
            f fVar = cVar.f33977d;
            if (fVar == null) {
                fVar = f.b();
                cVar.add(fVar);
                cVar.f33977d = fVar;
            }
            try {
                fVar.g(rx.internal.operators.d.g(t10));
            } catch (IllegalStateException e10) {
                if (!cVar.isUnsubscribed()) {
                    cVar.unsubscribe();
                    cVar.onError(e10);
                }
            } catch (MissingBackpressureException e11) {
                cVar.unsubscribe();
                cVar.onError(e11);
            }
        }

        void n(c<T> cVar) {
            f fVar = cVar.f33977d;
            if (fVar != null) {
                fVar.j();
            }
            this.f33985f.c(cVar);
            synchronized (this.f33990k) {
                c<?>[] cVarArr = this.f33991l;
                int length = cVarArr.length;
                int i10 = -1;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    } else if (cVar.equals(cVarArr[i11])) {
                        i10 = i11;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (i10 >= 0) {
                    if (length == 1) {
                        this.f33991l = f33979r;
                        return;
                    }
                    c<?>[] cVarArr2 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr2, 0, i10);
                    System.arraycopy(cVarArr, i10 + 1, cVarArr2, i10, (length - i10) - 1);
                    this.f33991l = cVarArr2;
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
            this.f33987h = true;
            d();
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            j().offer(th2);
            this.f33987h = true;
            d();
        }

        public void p(long j10) {
            request(j10);
        }

        void q(T t10) {
            long j10 = this.f33983d.get();
            boolean z10 = false;
            if (j10 != 0) {
                synchronized (this) {
                    j10 = this.f33983d.get();
                    if (!this.f33988i && j10 != 0) {
                        this.f33988i = true;
                        z10 = true;
                    }
                }
            }
            if (z10) {
                Queue<Object> queue = this.f33984e;
                if (queue == null || queue.isEmpty()) {
                    g(t10, j10);
                    return;
                }
                l(t10);
                f();
                return;
            }
            l(t10);
            d();
        }

        void r(c<T> cVar, T t10) {
            long j10 = this.f33983d.get();
            boolean z10 = false;
            if (j10 != 0) {
                synchronized (this) {
                    j10 = this.f33983d.get();
                    if (!this.f33988i && j10 != 0) {
                        this.f33988i = true;
                        z10 = true;
                    }
                }
            }
            if (z10) {
                f fVar = cVar.f33977d;
                if (fVar == null || fVar.e()) {
                    h(cVar, t10, j10);
                    return;
                }
                m(cVar, t10);
                f();
                return;
            }
            m(cVar, t10);
            d();
        }
    }

    z(boolean z10, int i10) {
        this.f33969a = z10;
        this.f33970b = i10;
    }

    public static <T> z<T> b(boolean z10) {
        if (z10) {
            return (z<T>) a.f33971a;
        }
        return (z<T>) b.f33972a;
    }

    /* renamed from: a */
    public i<rx.c<? extends T>> call(i<? super T> iVar) {
        e eVar = new e(iVar, this.f33969a, this.f33970b);
        d<T> dVar = new d<>(eVar);
        eVar.f33983d = dVar;
        iVar.add(eVar);
        iVar.setProducer(dVar);
        return eVar;
    }
}
