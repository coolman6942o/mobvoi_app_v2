package kotlinx.coroutines.scheduling;

import io.m;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.random.Random;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
/* compiled from: CoroutineScheduler.kt */
/* loaded from: classes3.dex */
public final class CoroutineScheduler implements Executor, Closeable {
    private volatile /* synthetic */ int _isTerminated;

    /* renamed from: a */
    public final int f30290a;

    /* renamed from: b */
    public final int f30291b;

    /* renamed from: c */
    public final long f30292c;
    volatile /* synthetic */ long controlState;

    /* renamed from: d */
    public final String f30293d;

    /* renamed from: e */
    public final kotlinx.coroutines.scheduling.c f30294e;

    /* renamed from: f */
    public final kotlinx.coroutines.scheduling.c f30295f;

    /* renamed from: g */
    public final AtomicReferenceArray<c> f30296g;
    private volatile /* synthetic */ long parkedWorkersStack;

    /* renamed from: k */
    public static final w f30289k = new w("NOT_IN_STACK");

    /* renamed from: h */
    private static final /* synthetic */ AtomicLongFieldUpdater f30286h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack");

    /* renamed from: i */
    static final /* synthetic */ AtomicLongFieldUpdater f30287i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState");

    /* renamed from: j */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f30288j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated");

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public enum WorkerState {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f30297a;

        static {
            int[] iArr = new int[WorkerState.values().length];
            iArr[WorkerState.PARKING.ordinal()] = 1;
            iArr[WorkerState.BLOCKING.ordinal()] = 2;
            iArr[WorkerState.CPU_ACQUIRED.ordinal()] = 3;
            iArr[WorkerState.DORMANT.ordinal()] = 4;
            iArr[WorkerState.TERMINATED.ordinal()] = 5;
            f30297a = iArr;
        }
    }

    static {
        new a(null);
    }

    public CoroutineScheduler(int i10, int i11, long j10, String str) {
        this.f30290a = i10;
        this.f30291b = i11;
        this.f30292c = j10;
        this.f30293d = str;
        if (i10 >= 1) {
            if (i11 >= i10) {
                if (i11 <= 2097150) {
                    if (j10 > 0) {
                        this.f30294e = new kotlinx.coroutines.scheduling.c();
                        this.f30295f = new kotlinx.coroutines.scheduling.c();
                        this.parkedWorkersStack = 0L;
                        this.f30296g = new AtomicReferenceArray<>(i11 + 1);
                        this.controlState = i10 << 42;
                        this._isTerminated = 0;
                        return;
                    }
                    throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
                }
                throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
            }
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
    }

    private final void I(boolean z10) {
        long addAndGet = f30287i.addAndGet(this, 2097152L);
        if (!z10 && !W() && !T(addAndGet)) {
            W();
        }
    }

    private final h Q(c cVar, h hVar, boolean z10) {
        if (cVar == null || cVar.f30300b == WorkerState.TERMINATED) {
            return hVar;
        }
        if (hVar.f30323b.u() == 0 && cVar.f30300b == WorkerState.BLOCKING) {
            return hVar;
        }
        cVar.f30304f = true;
        return cVar.f30299a.a(hVar, z10);
    }

    private final boolean T(long j10) {
        int c10;
        c10 = vo.f.c(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0);
        if (c10 < this.f30290a) {
            int d10 = d();
            if (d10 == 1 && this.f30290a > 1) {
                d();
            }
            if (d10 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean V(CoroutineScheduler coroutineScheduler, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = coroutineScheduler.controlState;
        }
        return coroutineScheduler.T(j10);
    }

    private final boolean W() {
        c u10;
        do {
            u10 = u();
            if (u10 == null) {
                return false;
            }
        } while (!c.f30298h.compareAndSet(u10, -1, 0));
        LockSupport.unpark(u10);
        return true;
    }

    private final boolean c(h hVar) {
        boolean z10 = true;
        if (hVar.f30323b.u() != 1) {
            z10 = false;
        }
        if (z10) {
            return this.f30295f.a(hVar);
        }
        return this.f30294e.a(hVar);
    }

    private final int d() {
        int c10;
        synchronized (this.f30296g) {
            if (isTerminated()) {
                return -1;
            }
            long j10 = this.controlState;
            int i10 = (int) (j10 & 2097151);
            boolean z10 = false;
            c10 = vo.f.c(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
            if (c10 >= this.f30290a) {
                return 0;
            }
            if (i10 >= this.f30291b) {
                return 0;
            }
            int i11 = ((int) (this.controlState & 2097151)) + 1;
            if (i11 > 0 && this.f30296g.get(i11) == null) {
                c cVar = new c(i11);
                this.f30296g.set(i11, cVar);
                if (i11 == ((int) (2097151 & f30287i.incrementAndGet(this)))) {
                    z10 = true;
                }
                if (z10) {
                    cVar.start();
                    return c10 + 1;
                }
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    private final c i() {
        Thread currentThread = Thread.currentThread();
        c cVar = currentThread instanceof c ? (c) currentThread : null;
        if (cVar != null && i.b(CoroutineScheduler.this, this)) {
            return cVar;
        }
        return null;
    }

    public static /* synthetic */ void o(CoroutineScheduler coroutineScheduler, Runnable runnable, i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = f.f30320a;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        coroutineScheduler.n(runnable, iVar, z10);
    }

    private final int q(c cVar) {
        Object g10 = cVar.g();
        while (g10 != f30289k) {
            if (g10 == null) {
                return 0;
            }
            c cVar2 = (c) g10;
            int f10 = cVar2.f();
            if (f10 != 0) {
                return f10;
            }
            g10 = cVar2.g();
        }
        return -1;
    }

    private final c u() {
        while (true) {
            long j10 = this.parkedWorkersStack;
            c cVar = this.f30296g.get((int) (2097151 & j10));
            if (cVar == null) {
                return null;
            }
            long j11 = (2097152 + j10) & (-2097152);
            int q5 = q(cVar);
            if (q5 >= 0 && f30286h.compareAndSet(this, j10, q5 | j11)) {
                cVar.o(f30289k);
                return cVar;
            }
        }
    }

    public final void E(long j10) {
        int i10;
        boolean z10 = false;
        if (f30288j.compareAndSet(this, 0, 1)) {
            c i11 = i();
            synchronized (this.f30296g) {
                i10 = (int) (this.controlState & 2097151);
            }
            if (1 <= i10) {
                int i12 = 1;
                while (true) {
                    i12++;
                    c cVar = this.f30296g.get(i12);
                    i.d(cVar);
                    c cVar2 = cVar;
                    if (cVar2 != i11) {
                        while (cVar2.isAlive()) {
                            LockSupport.unpark(cVar2);
                            cVar2.join(j10);
                        }
                        WorkerState workerState = cVar2.f30300b;
                        if (n0.a()) {
                            if (!(workerState == WorkerState.TERMINATED)) {
                                throw new AssertionError();
                            }
                        }
                        cVar2.f30299a.g(this.f30295f);
                    }
                    if (i12 == i10) {
                        break;
                    }
                }
            }
            this.f30295f.b();
            this.f30294e.b();
            while (true) {
                h e10 = i11 == null ? null : i11.e(true);
                if (e10 == null && (e10 = this.f30294e.d()) == null && (e10 = this.f30295f.d()) == null) {
                    break;
                }
                x(e10);
            }
            if (i11 != null) {
                i11.r(WorkerState.TERMINATED);
            }
            if (n0.a()) {
                if (((int) ((this.controlState & 9223367638808264704L) >> 42)) == this.f30290a) {
                    z10 = true;
                }
                if (!z10) {
                    throw new AssertionError();
                }
            }
            this.parkedWorkersStack = 0L;
            this.controlState = 0L;
        }
    }

    public final void O() {
        if (!W() && !V(this, 0L, 1, null)) {
            W();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        E(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        o(this, runnable, null, false, 6, null);
    }

    public final h h(Runnable runnable, i iVar) {
        long a10 = k.f30329e.a();
        if (!(runnable instanceof h)) {
            return new j(runnable, a10, iVar);
        }
        h hVar = (h) runnable;
        hVar.f30322a = a10;
        hVar.f30323b = iVar;
        return hVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean isTerminated() {
        return this._isTerminated;
    }

    public final void n(Runnable runnable, i iVar, boolean z10) {
        kotlinx.coroutines.c.a();
        h h10 = h(runnable, iVar);
        c i10 = i();
        h Q = Q(i10, h10, z10);
        if (Q == null || c(Q)) {
            boolean z11 = z10 && i10 != null;
            if (h10.f30323b.u() != 0) {
                I(z11);
            } else if (!z11) {
                O();
            }
        } else {
            throw new RejectedExecutionException(i.n(this.f30293d, " was terminated"));
        }
    }

    public String toString() {
        int i10;
        int i11;
        int i12;
        int i13;
        ArrayList arrayList = new ArrayList();
        int length = this.f30296g.length();
        int i14 = 0;
        if (1 < length) {
            i12 = 0;
            int i15 = 0;
            i11 = 0;
            i10 = 0;
            int i16 = 1;
            while (true) {
                int i17 = i16 + 1;
                c cVar = this.f30296g.get(i16);
                if (cVar != null) {
                    int f10 = cVar.f30299a.f();
                    int i18 = b.f30297a[cVar.f30300b.ordinal()];
                    if (i18 == 1) {
                        i14++;
                    } else if (i18 == 2) {
                        i12++;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(f10);
                        sb2.append('b');
                        arrayList.add(sb2.toString());
                    } else if (i18 == 3) {
                        i15++;
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(f10);
                        sb3.append('c');
                        arrayList.add(sb3.toString());
                    } else if (i18 == 4) {
                        i11++;
                        if (f10 > 0) {
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(f10);
                            sb4.append('d');
                            arrayList.add(sb4.toString());
                        }
                    } else if (i18 == 5) {
                        i10++;
                    }
                }
                if (i17 >= length) {
                    break;
                }
                i16 = i17;
            }
            i13 = i14;
            i14 = i15;
        } else {
            i13 = 0;
            i12 = 0;
            i11 = 0;
            i10 = 0;
        }
        long j10 = this.controlState;
        return this.f30293d + '@' + o0.b(this) + "[Pool Size {core = " + this.f30290a + ", max = " + this.f30291b + "}, Worker States {CPU = " + i14 + ", blocking = " + i12 + ", parked = " + i13 + ", dormant = " + i11 + ", terminated = " + i10 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f30294e.c() + ", global blocking queue size = " + this.f30295f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f30290a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final boolean v(c cVar) {
        long j10;
        long j11;
        int f10;
        if (cVar.g() != f30289k) {
            return false;
        }
        do {
            j10 = this.parkedWorkersStack;
            int i10 = (int) (2097151 & j10);
            j11 = (2097152 + j10) & (-2097152);
            f10 = cVar.f();
            if (n0.a()) {
                if (!(f10 != 0)) {
                    throw new AssertionError();
                }
            }
            cVar.o(this.f30296g.get(i10));
        } while (!f30286h.compareAndSet(this, j10, f10 | j11));
        return true;
    }

    public final void w(c cVar, int i10, int i11) {
        while (true) {
            long j10 = this.parkedWorkersStack;
            int i12 = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (i12 == i10) {
                i12 = i11 == 0 ? q(cVar) : i11;
            }
            if (i12 >= 0 && f30286h.compareAndSet(this, j10, j11 | i12)) {
                return;
            }
        }
    }

    public final void x(h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* compiled from: CoroutineScheduler.kt */
    /* loaded from: classes3.dex */
    public final class c extends Thread {

        /* renamed from: h */
        static final /* synthetic */ AtomicIntegerFieldUpdater f30298h = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* renamed from: a */
        public final l f30299a;

        /* renamed from: b */
        public WorkerState f30300b;

        /* renamed from: c */
        private long f30301c;

        /* renamed from: d */
        private long f30302d;

        /* renamed from: e */
        private int f30303e;

        /* renamed from: f */
        public boolean f30304f;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        volatile /* synthetic */ int workerCtl;

        private c() {
            CoroutineScheduler.this = r1;
            setDaemon(true);
            this.f30299a = new l();
            this.f30300b = WorkerState.DORMANT;
            this.workerCtl = 0;
            this.nextParkedWorker = CoroutineScheduler.f30289k;
            this.f30303e = Random.Default.nextInt();
        }

        private final void a(int i10) {
            if (i10 != 0) {
                CoroutineScheduler.f30287i.addAndGet(CoroutineScheduler.this, -2097152L);
                WorkerState workerState = this.f30300b;
                if (workerState != WorkerState.TERMINATED) {
                    if (n0.a()) {
                        if (!(workerState == WorkerState.BLOCKING)) {
                            throw new AssertionError();
                        }
                    }
                    this.f30300b = WorkerState.DORMANT;
                }
            }
        }

        private final void b(int i10) {
            if (i10 != 0 && r(WorkerState.BLOCKING)) {
                CoroutineScheduler.this.O();
            }
        }

        private final void c(h hVar) {
            int u10 = hVar.f30323b.u();
            h(u10);
            b(u10);
            CoroutineScheduler.this.x(hVar);
            a(u10);
        }

        private final h d(boolean z10) {
            h l10;
            h l11;
            if (z10) {
                boolean z11 = j(CoroutineScheduler.this.f30290a * 2) == 0;
                if (z11 && (l11 = l()) != null) {
                    return l11;
                }
                h h10 = this.f30299a.h();
                if (h10 != null) {
                    return h10;
                }
                if (!z11 && (l10 = l()) != null) {
                    return l10;
                }
            } else {
                h l12 = l();
                if (l12 != null) {
                    return l12;
                }
            }
            return s(false);
        }

        private final void h(int i10) {
            this.f30301c = 0L;
            if (this.f30300b == WorkerState.PARKING) {
                if (n0.a()) {
                    boolean z10 = true;
                    if (i10 != 1) {
                        z10 = false;
                    }
                    if (!z10) {
                        throw new AssertionError();
                    }
                }
                this.f30300b = WorkerState.BLOCKING;
            }
        }

        private final boolean i() {
            return this.nextParkedWorker != CoroutineScheduler.f30289k;
        }

        private final void k() {
            if (this.f30301c == 0) {
                this.f30301c = System.nanoTime() + CoroutineScheduler.this.f30292c;
            }
            LockSupport.parkNanos(CoroutineScheduler.this.f30292c);
            if (System.nanoTime() - this.f30301c >= 0) {
                this.f30301c = 0L;
                t();
            }
        }

        private final h l() {
            if (j(2) == 0) {
                h d10 = CoroutineScheduler.this.f30294e.d();
                return d10 == null ? CoroutineScheduler.this.f30295f.d() : d10;
            }
            h d11 = CoroutineScheduler.this.f30295f.d();
            return d11 == null ? CoroutineScheduler.this.f30294e.d() : d11;
        }

        private final void m() {
            loop0: while (true) {
                boolean z10 = false;
                while (!CoroutineScheduler.this.isTerminated() && this.f30300b != WorkerState.TERMINATED) {
                    h e10 = e(this.f30304f);
                    if (e10 != null) {
                        this.f30302d = 0L;
                        c(e10);
                    } else {
                        this.f30304f = false;
                        if (this.f30302d == 0) {
                            q();
                        } else if (!z10) {
                            z10 = true;
                        } else {
                            r(WorkerState.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f30302d);
                            this.f30302d = 0L;
                        }
                    }
                }
            }
            r(WorkerState.TERMINATED);
        }

        private final boolean p() {
            boolean z10;
            if (this.f30300b != WorkerState.CPU_ACQUIRED) {
                CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
                while (true) {
                    long j10 = coroutineScheduler.controlState;
                    if (((int) ((9223367638808264704L & j10) >> 42)) != 0) {
                        if (CoroutineScheduler.f30287i.compareAndSet(coroutineScheduler, j10, j10 - 4398046511104L)) {
                            z10 = true;
                            break;
                        }
                    } else {
                        z10 = false;
                        break;
                    }
                }
                if (!z10) {
                    return false;
                }
                this.f30300b = WorkerState.CPU_ACQUIRED;
            }
            return true;
        }

        private final void q() {
            if (!i()) {
                CoroutineScheduler.this.v(this);
                return;
            }
            if (n0.a()) {
                if (!(this.f30299a.f() == 0)) {
                    throw new AssertionError();
                }
            }
            this.workerCtl = -1;
            while (i() && this.workerCtl == -1 && !CoroutineScheduler.this.isTerminated() && this.f30300b != WorkerState.TERMINATED) {
                r(WorkerState.PARKING);
                Thread.interrupted();
                k();
            }
        }

        private final h s(boolean z10) {
            long j10;
            if (n0.a()) {
                if (!(this.f30299a.f() == 0)) {
                    throw new AssertionError();
                }
            }
            int i10 = (int) (CoroutineScheduler.this.controlState & 2097151);
            if (i10 < 2) {
                return null;
            }
            int j11 = j(i10);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            long j12 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < i10; i11++) {
                j11++;
                if (j11 > i10) {
                    j11 = 1;
                }
                c cVar = coroutineScheduler.f30296g.get(j11);
                if (!(cVar == null || cVar == this)) {
                    if (n0.a()) {
                        if (!(this.f30299a.f() == 0)) {
                            throw new AssertionError();
                        }
                    }
                    if (z10) {
                        j10 = this.f30299a.k(cVar.f30299a);
                    } else {
                        j10 = this.f30299a.l(cVar.f30299a);
                    }
                    if (j10 == -1) {
                        return this.f30299a.h();
                    }
                    if (j10 > 0) {
                        j12 = Math.min(j12, j10);
                    }
                }
            }
            if (j12 == Long.MAX_VALUE) {
                j12 = 0;
            }
            this.f30302d = j12;
            return null;
        }

        private final void t() {
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            synchronized (coroutineScheduler.f30296g) {
                if (!coroutineScheduler.isTerminated()) {
                    if (((int) (coroutineScheduler.controlState & 2097151)) > coroutineScheduler.f30290a) {
                        if (f30298h.compareAndSet(this, -1, 1)) {
                            int f10 = f();
                            n(0);
                            coroutineScheduler.w(this, f10, 0);
                            int andDecrement = (int) (CoroutineScheduler.f30287i.getAndDecrement(coroutineScheduler) & 2097151);
                            if (andDecrement != f10) {
                                c cVar = coroutineScheduler.f30296g.get(andDecrement);
                                i.d(cVar);
                                c cVar2 = cVar;
                                coroutineScheduler.f30296g.set(f10, cVar2);
                                cVar2.n(f10);
                                coroutineScheduler.w(cVar2, andDecrement, f10);
                            }
                            coroutineScheduler.f30296g.set(andDecrement, null);
                            m mVar = m.f28349a;
                            this.f30300b = WorkerState.TERMINATED;
                        }
                    }
                }
            }
        }

        public final h e(boolean z10) {
            h hVar;
            if (p()) {
                return d(z10);
            }
            if (z10) {
                hVar = this.f30299a.h();
                if (hVar == null) {
                    hVar = CoroutineScheduler.this.f30295f.d();
                }
            } else {
                hVar = CoroutineScheduler.this.f30295f.d();
            }
            return hVar == null ? s(true) : hVar;
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final int j(int i10) {
            int i11 = this.f30303e;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f30303e = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
        }

        public final void n(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(CoroutineScheduler.this.f30293d);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean r(WorkerState workerState) {
            WorkerState workerState2 = this.f30300b;
            boolean z10 = workerState2 == WorkerState.CPU_ACQUIRED;
            if (z10) {
                CoroutineScheduler.f30287i.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f30300b = workerState;
            }
            return z10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public c(int i10) {
            this();
            CoroutineScheduler.this = r1;
            n(i10);
        }
    }
}
