package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.c;
import rx.exceptions.OnErrorThrowable;
/* compiled from: OperatorReplay.java */
/* loaded from: classes3.dex */
public final class e0<T> extends zp.a<T> implements rx.j {

    /* renamed from: e  reason: collision with root package name */
    static final yp.f f33757e = new a();

    /* renamed from: b  reason: collision with root package name */
    final rx.c<? extends T> f33758b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<i<T>> f33759c;

    /* renamed from: d  reason: collision with root package name */
    final yp.f<? extends h<T>> f33760d;

    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    static class a implements yp.f {
        a() {
        }

        @Override // yp.f, java.util.concurrent.Callable
        public Object call() {
            return new l(16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    public static class b implements yp.f<h<T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f33761a;

        b(int i10) {
            this.f33761a = i10;
        }

        /* renamed from: a */
        public h<T> call() {
            return new k(this.f33761a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    public static class c implements yp.f<h<T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f33762a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f33763b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.f f33764c;

        c(int i10, long j10, rx.f fVar) {
            this.f33762a = i10;
            this.f33763b = j10;
            this.f33764c = fVar;
        }

        /* renamed from: a */
        public h<T> call() {
            return new j(this.f33762a, this.f33763b, this.f33764c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    public static class d implements c.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f33765a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ yp.f f33766b;

        d(AtomicReference atomicReference, yp.f fVar) {
            this.f33765a = atomicReference;
            this.f33766b = fVar;
        }

        /* renamed from: a */
        public void call(rx.i<? super T> iVar) {
            i iVar2;
            while (true) {
                iVar2 = (i) this.f33765a.get();
                if (iVar2 != null) {
                    break;
                }
                i iVar3 = new i((h) this.f33766b.call());
                iVar3.d();
                if (this.f33765a.compareAndSet(iVar2, iVar3)) {
                    iVar2 = iVar3;
                    break;
                }
            }
            f<T> fVar = new f<>(iVar2, iVar);
            iVar2.b(fVar);
            iVar.add(fVar);
            iVar2.f33768a.d(fVar);
            iVar.setProducer(fVar);
        }
    }

    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    static class e<T> extends AtomicReference<g> implements h<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;
        int size;
        g tail;

        public e() {
            g gVar = new g(null, 0L);
            this.tail = gVar;
            set(gVar);
        }

        @Override // rx.internal.operators.e0.h
        public final void a() {
            Object h10 = h(rx.internal.operators.d.b());
            long j10 = this.index + 1;
            this.index = j10;
            g(new g(h10, j10));
            n();
        }

        @Override // rx.internal.operators.e0.h
        public final void b(T t10) {
            Object h10 = h(rx.internal.operators.d.g(t10));
            long j10 = this.index + 1;
            this.index = j10;
            g(new g(h10, j10));
            m();
        }

        @Override // rx.internal.operators.e0.h
        public final void c(Throwable th2) {
            Object h10 = h(rx.internal.operators.d.c(th2));
            long j10 = this.index + 1;
            this.index = j10;
            g(new g(h10, j10));
            n();
        }

        @Override // rx.internal.operators.e0.h
        public final void d(f<T> fVar) {
            rx.i<? super T> iVar;
            g gVar;
            synchronized (fVar) {
                if (fVar.emitting) {
                    fVar.missed = true;
                    return;
                }
                fVar.emitting = true;
                while (!fVar.isUnsubscribed()) {
                    g gVar2 = (g) fVar.b();
                    if (gVar2 == null) {
                        gVar2 = i();
                        fVar.index = gVar2;
                        fVar.a(gVar2.index);
                    }
                    if (!fVar.isUnsubscribed() && (iVar = fVar.child) != null) {
                        long j10 = fVar.get();
                        long j11 = 0;
                        while (j11 != j10 && (gVar = gVar2.get()) != null) {
                            Object j12 = j(gVar.value);
                            try {
                                if (rx.internal.operators.d.a(iVar, j12)) {
                                    fVar.index = null;
                                    return;
                                }
                                j11++;
                                if (!fVar.isUnsubscribed()) {
                                    gVar2 = gVar;
                                } else {
                                    return;
                                }
                            } catch (Throwable th2) {
                                fVar.index = null;
                                rx.exceptions.a.e(th2);
                                fVar.unsubscribe();
                                if (!rx.internal.operators.d.f(j12) && !rx.internal.operators.d.e(j12)) {
                                    iVar.onError(OnErrorThrowable.addValueAsLastCause(th2, rx.internal.operators.d.d(j12)));
                                    return;
                                }
                                return;
                            }
                        }
                        if (j11 != 0) {
                            fVar.index = gVar2;
                            if (j10 != Long.MAX_VALUE) {
                                fVar.c(j11);
                            }
                        }
                        synchronized (fVar) {
                            if (!fVar.missed) {
                                fVar.emitting = false;
                                return;
                            }
                            fVar.missed = false;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        final void g(g gVar) {
            this.tail.set(gVar);
            this.tail = gVar;
            this.size++;
        }

        Object h(Object obj) {
            return obj;
        }

        g i() {
            return get();
        }

        Object j(Object obj) {
            return obj;
        }

        final void k() {
            g gVar = get().get();
            if (gVar != null) {
                this.size--;
                l(gVar);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        final void l(g gVar) {
            set(gVar);
        }

        void m() {
        }

        void n() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    public static final class f<T> extends AtomicLong implements rx.e, rx.j {
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        rx.i<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final i<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        public f(i<T> iVar, rx.i<? super T> iVar2) {
            this.parent = iVar;
            this.child = iVar2;
        }

        void a(long j10) {
            long j11;
            long j12;
            do {
                j11 = this.totalRequested.get();
                j12 = j11 + j10;
                if (j12 < 0) {
                    j12 = Long.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(j11, j12));
        }

        <U> U b() {
            return (U) this.index;
        }

        public long c(long j10) {
            long j11;
            long j12;
            if (j10 > 0) {
                do {
                    j11 = get();
                    if (j11 == UNSUBSCRIBED) {
                        return UNSUBSCRIBED;
                    }
                    j12 = j11 - j10;
                    if (j12 < 0) {
                        throw new IllegalStateException("More produced (" + j10 + ") than requested (" + j11 + ")");
                    }
                } while (!compareAndSet(j11, j12));
                return j12;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        @Override // rx.j
        public boolean isUnsubscribed() {
            return get() == UNSUBSCRIBED;
        }

        @Override // rx.e
        public void request(long j10) {
            long j11;
            long j12;
            int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
            if (i10 >= 0) {
                do {
                    j11 = get();
                    if (j11 != UNSUBSCRIBED) {
                        if (j11 < 0 || i10 != 0) {
                            j12 = j11 + j10;
                            if (j12 < 0) {
                                j12 = Long.MAX_VALUE;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!compareAndSet(j11, j12));
                a(j10);
                this.parent.f(this);
                this.parent.f33768a.d(this);
            }
        }

        @Override // rx.j
        public void unsubscribe() {
            if (get() != UNSUBSCRIBED && getAndSet(UNSUBSCRIBED) != UNSUBSCRIBED) {
                this.parent.g(this);
                this.parent.f(this);
                this.child = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    public static final class g extends AtomicReference<g> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public g(Object obj, long j10) {
            this.value = obj;
            this.index = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    public interface h<T> {
        void a();

        void b(T t10);

        void c(Throwable th2);

        void d(f<T> fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    public static final class i<T> extends rx.i<T> {

        /* renamed from: p  reason: collision with root package name */
        static final f[] f33767p = new f[0];

        /* renamed from: a  reason: collision with root package name */
        final h<T> f33768a;

        /* renamed from: b  reason: collision with root package name */
        boolean f33769b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f33770c;

        /* renamed from: f  reason: collision with root package name */
        volatile long f33773f;

        /* renamed from: g  reason: collision with root package name */
        long f33774g;

        /* renamed from: i  reason: collision with root package name */
        boolean f33776i;

        /* renamed from: j  reason: collision with root package name */
        boolean f33777j;

        /* renamed from: k  reason: collision with root package name */
        long f33778k;

        /* renamed from: l  reason: collision with root package name */
        long f33779l;

        /* renamed from: m  reason: collision with root package name */
        volatile rx.e f33780m;

        /* renamed from: n  reason: collision with root package name */
        List<f<T>> f33781n;

        /* renamed from: o  reason: collision with root package name */
        boolean f33782o;

        /* renamed from: d  reason: collision with root package name */
        final rx.internal.util.d<f<T>> f33771d = new rx.internal.util.d<>();

        /* renamed from: e  reason: collision with root package name */
        f<T>[] f33772e = f33767p;

        /* renamed from: h  reason: collision with root package name */
        final AtomicBoolean f33775h = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorReplay.java */
        /* loaded from: classes3.dex */
        public class a implements yp.a {
            a() {
            }

            @Override // yp.a
            public void call() {
                if (!i.this.f33770c) {
                    synchronized (i.this.f33771d) {
                        if (!i.this.f33770c) {
                            i.this.f33771d.g();
                            i.this.f33773f++;
                            i.this.f33770c = true;
                        }
                    }
                }
            }
        }

        public i(h<T> hVar) {
            this.f33768a = hVar;
            request(0L);
        }

        boolean b(f<T> fVar) {
            Objects.requireNonNull(fVar);
            if (this.f33770c) {
                return false;
            }
            synchronized (this.f33771d) {
                if (this.f33770c) {
                    return false;
                }
                this.f33771d.a(fVar);
                this.f33773f++;
                return true;
            }
        }

        f<T>[] c() {
            f<T>[] fVarArr;
            synchronized (this.f33771d) {
                f<T>[] h10 = this.f33771d.h();
                int length = h10.length;
                fVarArr = new f[length];
                System.arraycopy(h10, 0, fVarArr, 0, length);
            }
            return fVarArr;
        }

        void d() {
            add(dq.e.a(new a()));
        }

        void e(long j10, long j11) {
            long j12 = this.f33779l;
            rx.e eVar = this.f33780m;
            long j13 = j10 - j11;
            if (j13 != 0) {
                this.f33778k = j10;
                if (eVar == null) {
                    long j14 = j12 + j13;
                    if (j14 < 0) {
                        j14 = Long.MAX_VALUE;
                    }
                    this.f33779l = j14;
                } else if (j12 != 0) {
                    this.f33779l = 0L;
                    eVar.request(j12 + j13);
                } else {
                    eVar.request(j13);
                }
            } else if (j12 != 0 && eVar != null) {
                this.f33779l = 0L;
                eVar.request(j12);
            }
        }

        void f(f<T> fVar) {
            long j10;
            List<f<T>> list;
            boolean z10;
            long j11;
            f<T>[] c10;
            f<T>[] c11;
            if (!isUnsubscribed()) {
                synchronized (this) {
                    if (this.f33776i) {
                        if (fVar != null) {
                            List list2 = this.f33781n;
                            if (list2 == null) {
                                list2 = new ArrayList();
                                this.f33781n = list2;
                            }
                            list2.add(fVar);
                        } else {
                            this.f33782o = true;
                        }
                        this.f33777j = true;
                        return;
                    }
                    this.f33776i = true;
                    long j12 = this.f33778k;
                    if (fVar != null) {
                        j10 = Math.max(j12, fVar.totalRequested.get());
                    } else {
                        long j13 = j12;
                        for (f<T> fVar2 : c()) {
                            if (fVar2 != null) {
                                j13 = Math.max(j13, fVar2.totalRequested.get());
                            }
                        }
                        j10 = j13;
                    }
                    e(j10, j12);
                    while (!isUnsubscribed()) {
                        synchronized (this) {
                            if (!this.f33777j) {
                                this.f33776i = false;
                                return;
                            }
                            this.f33777j = false;
                            list = this.f33781n;
                            this.f33781n = null;
                            z10 = this.f33782o;
                            this.f33782o = false;
                        }
                        long j14 = this.f33778k;
                        if (list != null) {
                            j11 = j14;
                            for (f<T> fVar3 : list) {
                                j11 = Math.max(j11, fVar3.totalRequested.get());
                            }
                        } else {
                            j11 = j14;
                        }
                        if (z10) {
                            for (f<T> fVar4 : c()) {
                                if (fVar4 != null) {
                                    j11 = Math.max(j11, fVar4.totalRequested.get());
                                }
                            }
                        }
                        e(j11, j14);
                    }
                }
            }
        }

        void g(f<T> fVar) {
            if (!this.f33770c) {
                synchronized (this.f33771d) {
                    if (!this.f33770c) {
                        this.f33771d.e(fVar);
                        if (this.f33771d.b()) {
                            this.f33772e = f33767p;
                        }
                        this.f33773f++;
                    }
                }
            }
        }

        void h() {
            f<T>[] fVarArr = this.f33772e;
            if (this.f33774g != this.f33773f) {
                synchronized (this.f33771d) {
                    fVarArr = this.f33772e;
                    f<T>[] h10 = this.f33771d.h();
                    int length = h10.length;
                    if (fVarArr.length != length) {
                        fVarArr = new f[length];
                        this.f33772e = fVarArr;
                    }
                    System.arraycopy(h10, 0, fVarArr, 0, length);
                    this.f33774g = this.f33773f;
                }
            }
            h<T> hVar = this.f33768a;
            for (f<T> fVar : fVarArr) {
                if (fVar != null) {
                    hVar.d(fVar);
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
            if (!this.f33769b) {
                this.f33769b = true;
                try {
                    this.f33768a.a();
                    h();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            if (!this.f33769b) {
                this.f33769b = true;
                try {
                    this.f33768a.c(th2);
                    h();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.d
        public void onNext(T t10) {
            if (!this.f33769b) {
                this.f33768a.b(t10);
                h();
            }
        }

        @Override // rx.i
        public void setProducer(rx.e eVar) {
            if (this.f33780m == null) {
                this.f33780m = eVar;
                f(null);
                h();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    public static final class j<T> extends e<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAgeInMillis;
        final rx.f scheduler;

        public j(int i10, long j10, rx.f fVar) {
            this.scheduler = fVar;
            this.limit = i10;
            this.maxAgeInMillis = j10;
        }

        @Override // rx.internal.operators.e0.e
        Object h(Object obj) {
            return new cq.b(this.scheduler.b(), obj);
        }

        @Override // rx.internal.operators.e0.e
        g i() {
            g gVar;
            long b10 = this.scheduler.b() - this.maxAgeInMillis;
            g gVar2 = get();
            g gVar3 = gVar2.get();
            while (true) {
                gVar2 = gVar3;
                gVar = gVar2;
                if (gVar2 == null) {
                    break;
                }
                Object obj = gVar2.value;
                Object j10 = j(obj);
                if (rx.internal.operators.d.e(j10) || rx.internal.operators.d.f(j10) || ((cq.b) obj).a() > b10) {
                    break;
                }
                gVar3 = gVar2.get();
            }
            return gVar;
        }

        @Override // rx.internal.operators.e0.e
        Object j(Object obj) {
            return ((cq.b) obj).b();
        }

        @Override // rx.internal.operators.e0.e
        void m() {
            g gVar;
            long b10 = this.scheduler.b() - this.maxAgeInMillis;
            g gVar2 = get();
            g gVar3 = gVar2.get();
            int i10 = 0;
            while (true) {
                gVar2 = gVar3;
                gVar = gVar2;
                if (gVar2 != null) {
                    int i11 = this.size;
                    if (i11 <= this.limit) {
                        if (((cq.b) gVar2.value).a() > b10) {
                            break;
                        }
                        i10++;
                        this.size--;
                        gVar3 = gVar2.get();
                    } else {
                        i10++;
                        this.size = i11 - 1;
                        gVar3 = gVar2.get();
                    }
                } else {
                    break;
                }
            }
            if (i10 != 0) {
                l(gVar);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
            l(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
            return;
         */
        @Override // rx.internal.operators.e0.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void n() {
            long b10 = this.scheduler.b() - this.maxAgeInMillis;
            g gVar = get();
            g gVar2 = gVar.get();
            int i10 = 0;
            while (true) {
                gVar = gVar2;
                g gVar3 = gVar;
                if (gVar == null || this.size <= 1 || ((cq.b) gVar.value).a() > b10) {
                    break;
                }
                i10++;
                this.size--;
                gVar2 = gVar.get();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    public static final class k<T> extends e<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public k(int i10) {
            this.limit = i10;
        }

        @Override // rx.internal.operators.e0.e
        void m() {
            if (this.size > this.limit) {
                k();
            }
        }
    }

    /* compiled from: OperatorReplay.java */
    /* loaded from: classes3.dex */
    static final class l<T> extends ArrayList<Object> implements h<T> {
        private static final long serialVersionUID = 7063189396499112664L;
        volatile int size;

        public l(int i10) {
            super(i10);
        }

        @Override // rx.internal.operators.e0.h
        public void a() {
            add(rx.internal.operators.d.b());
            this.size++;
        }

        @Override // rx.internal.operators.e0.h
        public void b(T t10) {
            add(rx.internal.operators.d.g(t10));
            this.size++;
        }

        @Override // rx.internal.operators.e0.h
        public void c(Throwable th2) {
            add(rx.internal.operators.d.c(th2));
            this.size++;
        }

        @Override // rx.internal.operators.e0.h
        public void d(f<T> fVar) {
            synchronized (fVar) {
                if (fVar.emitting) {
                    fVar.missed = true;
                    return;
                }
                fVar.emitting = true;
                while (!fVar.isUnsubscribed()) {
                    int i10 = this.size;
                    Integer num = (Integer) fVar.b();
                    int intValue = num != null ? num.intValue() : 0;
                    rx.i<? super T> iVar = fVar.child;
                    if (iVar != null) {
                        long j10 = fVar.get();
                        long j11 = 0;
                        while (j11 != j10 && intValue < i10) {
                            Object obj = get(intValue);
                            try {
                                if (!rx.internal.operators.d.a(iVar, obj) && !fVar.isUnsubscribed()) {
                                    intValue++;
                                    j11++;
                                } else {
                                    return;
                                }
                            } catch (Throwable th2) {
                                rx.exceptions.a.e(th2);
                                fVar.unsubscribe();
                                if (!rx.internal.operators.d.f(obj) && !rx.internal.operators.d.e(obj)) {
                                    iVar.onError(OnErrorThrowable.addValueAsLastCause(th2, rx.internal.operators.d.d(obj)));
                                    return;
                                }
                                return;
                            }
                        }
                        if (j11 != 0) {
                            fVar.index = Integer.valueOf(intValue);
                            if (j10 != Long.MAX_VALUE) {
                                fVar.c(j11);
                            }
                        }
                        synchronized (fVar) {
                            if (!fVar.missed) {
                                fVar.emitting = false;
                                return;
                            }
                            fVar.missed = false;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private e0(c.a<T> aVar, rx.c<? extends T> cVar, AtomicReference<i<T>> atomicReference, yp.f<? extends h<T>> fVar) {
        super(aVar);
        this.f33758b = cVar;
        this.f33759c = atomicReference;
        this.f33760d = fVar;
    }

    public static <T> zp.a<T> n0(rx.c<? extends T> cVar) {
        return r0(cVar, f33757e);
    }

    public static <T> zp.a<T> o0(rx.c<? extends T> cVar, int i10) {
        if (i10 == Integer.MAX_VALUE) {
            return n0(cVar);
        }
        return r0(cVar, new b(i10));
    }

    public static <T> zp.a<T> p0(rx.c<? extends T> cVar, long j10, TimeUnit timeUnit, rx.f fVar) {
        return q0(cVar, j10, timeUnit, fVar, Integer.MAX_VALUE);
    }

    public static <T> zp.a<T> q0(rx.c<? extends T> cVar, long j10, TimeUnit timeUnit, rx.f fVar, int i10) {
        return r0(cVar, new c(i10, timeUnit.toMillis(j10), fVar));
    }

    static <T> zp.a<T> r0(rx.c<? extends T> cVar, yp.f<? extends h<T>> fVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new e0(new d(atomicReference, fVar), cVar, atomicReference, fVar);
    }

    @Override // rx.j
    public boolean isUnsubscribed() {
        i<T> iVar = this.f33759c.get();
        return iVar == null || iVar.isUnsubscribed();
    }

    @Override // zp.a
    public void m0(yp.b<? super rx.j> bVar) {
        i<T> iVar;
        while (true) {
            iVar = this.f33759c.get();
            if (iVar != null && !iVar.isUnsubscribed()) {
                break;
            }
            i<T> iVar2 = new i<>(this.f33760d.call());
            iVar2.d();
            if (this.f33759c.compareAndSet(iVar, iVar2)) {
                iVar = iVar2;
                break;
            }
        }
        boolean z10 = true;
        if (iVar.f33775h.get() || !iVar.f33775h.compareAndSet(false, true)) {
            z10 = false;
        }
        bVar.call(iVar);
        if (z10) {
            this.f33758b.j0(iVar);
        }
    }

    @Override // rx.j
    public void unsubscribe() {
        this.f33759c.lazySet(null);
    }
}
