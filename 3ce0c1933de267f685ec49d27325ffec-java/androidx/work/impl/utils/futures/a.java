package androidx.work.impl.utils.futures;

import com.google.common.util.concurrent.j;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
/* compiled from: AbstractFuture.java */
/* loaded from: classes.dex */
public abstract class a<V> implements j<V> {

    /* renamed from: d  reason: collision with root package name */
    static final boolean f4851d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: e  reason: collision with root package name */
    private static final Logger f4852e = Logger.getLogger(a.class.getName());

    /* renamed from: f  reason: collision with root package name */
    static final b f4853f;

    /* renamed from: g  reason: collision with root package name */
    private static final Object f4854g;

    /* renamed from: a  reason: collision with root package name */
    volatile Object f4855a;

    /* renamed from: b  reason: collision with root package name */
    volatile e f4856b;

    /* renamed from: c  reason: collision with root package name */
    volatile i f4857c;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        private b() {
        }

        abstract boolean a(a<?> aVar, e eVar, e eVar2);

        abstract boolean b(a<?> aVar, Object obj, Object obj2);

        abstract boolean c(a<?> aVar, i iVar, i iVar2);

        abstract void d(i iVar, i iVar2);

        abstract void e(i iVar, Thread thread);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        static final c f4858c;

        /* renamed from: d  reason: collision with root package name */
        static final c f4859d;

        /* renamed from: a  reason: collision with root package name */
        final boolean f4860a;

        /* renamed from: b  reason: collision with root package name */
        final Throwable f4861b;

        static {
            if (a.f4851d) {
                f4859d = null;
                f4858c = null;
                return;
            }
            f4859d = new c(false, null);
            f4858c = new c(true, null);
        }

        c(boolean z10, Throwable th2) {
            this.f4860a = z10;
            this.f4861b = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: b  reason: collision with root package name */
        static final d f4862b = new d(new C0058a("Failure occurred while trying to finish a future."));

        /* renamed from: a  reason: collision with root package name */
        final Throwable f4863a;

        /* compiled from: AbstractFuture.java */
        /* renamed from: androidx.work.impl.utils.futures.a$d$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0058a extends Throwable {
            C0058a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        d(Throwable th2) {
            this.f4863a = (Throwable) a.e(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: d  reason: collision with root package name */
        static final e f4864d = new e(null, null);

        /* renamed from: a  reason: collision with root package name */
        final Runnable f4865a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f4866b;

        /* renamed from: c  reason: collision with root package name */
        e f4867c;

        e(Runnable runnable, Executor executor) {
            this.f4865a = runnable;
            this.f4866b = executor;
        }
    }

    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    private static final class f extends b {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, Thread> f4868a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<i, i> f4869b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, i> f4870c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, e> f4871d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicReferenceFieldUpdater<a, Object> f4872e;

        f(AtomicReferenceFieldUpdater<i, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<i, i> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<a, i> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<a, e> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<a, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f4868a = atomicReferenceFieldUpdater;
            this.f4869b = atomicReferenceFieldUpdater2;
            this.f4870c = atomicReferenceFieldUpdater3;
            this.f4871d = atomicReferenceFieldUpdater4;
            this.f4872e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            return this.f4871d.compareAndSet(aVar, eVar, eVar2);
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            return this.f4872e.compareAndSet(aVar, obj, obj2);
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            return this.f4870c.compareAndSet(aVar, iVar, iVar2);
        }

        @Override // androidx.work.impl.utils.futures.a.b
        void d(i iVar, i iVar2) {
            this.f4869b.lazySet(iVar, iVar2);
        }

        @Override // androidx.work.impl.utils.futures.a.b
        void e(i iVar, Thread thread) {
            this.f4868a.lazySet(iVar, thread);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class g<V> implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final a<V> f4873a;

        /* renamed from: b  reason: collision with root package name */
        final j<? extends V> f4874b;

        g(a<V> aVar, j<? extends V> jVar) {
            this.f4873a = aVar;
            this.f4874b = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4873a.f4855a == this) {
                if (a.f4853f.b(this.f4873a, this, a.j(this.f4874b))) {
                    a.g(this.f4873a);
                }
            }
        }
    }

    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    private static final class h extends b {
        h() {
            super();
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean a(a<?> aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                if (aVar.f4856b != eVar) {
                    return false;
                }
                aVar.f4856b = eVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean b(a<?> aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                if (aVar.f4855a != obj) {
                    return false;
                }
                aVar.f4855a = obj2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.a.b
        boolean c(a<?> aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                if (aVar.f4857c != iVar) {
                    return false;
                }
                aVar.f4857c = iVar2;
                return true;
            }
        }

        @Override // androidx.work.impl.utils.futures.a.b
        void d(i iVar, i iVar2) {
            iVar.f4877b = iVar2;
        }

        @Override // androidx.work.impl.utils.futures.a.b
        void e(i iVar, Thread thread) {
            iVar.f4876a = thread;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractFuture.java */
    /* loaded from: classes.dex */
    public static final class i {

        /* renamed from: c  reason: collision with root package name */
        static final i f4875c = new i(false);

        /* renamed from: a  reason: collision with root package name */
        volatile Thread f4876a;

        /* renamed from: b  reason: collision with root package name */
        volatile i f4877b;

        i(boolean z10) {
        }

        void a(i iVar) {
            a.f4853f.d(this, iVar);
        }

        void b() {
            Thread thread = this.f4876a;
            if (thread != null) {
                this.f4876a = null;
                LockSupport.unpark(thread);
            }
        }

        i() {
            a.f4853f.e(this, Thread.currentThread());
        }
    }

    static {
        b bVar;
        Throwable th2;
        try {
            bVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th2 = null;
        } catch (Throwable th3) {
            th2 = th3;
            bVar = new h();
        }
        f4853f = bVar;
        if (th2 != null) {
            f4852e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
        f4854g = new Object();
    }

    private void b(StringBuilder sb2) {
        try {
            Object k10 = k(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(s(k10));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    private static CancellationException d(String str, Throwable th2) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th2);
        return cancellationException;
    }

    static <T> T e(T t10) {
        Objects.requireNonNull(t10);
        return t10;
    }

    private e f(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f4856b;
        } while (!f4853f.a(this, eVar2, e.f4864d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f4867c;
            eVar4.f4867c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.work.impl.utils.futures.a$b] */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.work.impl.utils.futures.a<?>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.work.impl.utils.futures.a] */
    /* JADX WARN: Type inference failed for: r4v6, types: [androidx.work.impl.utils.futures.a<V>, androidx.work.impl.utils.futures.a] */
    static void g(a<?> aVar) {
        e eVar = null;
        while (true) {
            aVar.n();
            aVar.c();
            e f10 = aVar.f(eVar);
            while (f10 != null) {
                eVar = f10.f4867c;
                Runnable runnable = f10.f4865a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f4873a;
                    if (aVar.f4855a == gVar) {
                        if (f4853f.b(aVar, gVar, j(gVar.f4874b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, f10.f4866b);
                }
                f10 = eVar;
            }
            return;
        }
    }

    private static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            Logger logger = f4852e;
            Level level = Level.SEVERE;
            logger.log(level, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V i(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw d("Task was cancelled.", ((c) obj).f4861b);
        } else if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f4863a);
        } else if (obj == f4854g) {
            return null;
        } else {
            return obj;
        }
    }

    static Object j(j<?> jVar) {
        if (jVar instanceof a) {
            Object obj = ((a) jVar).f4855a;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f4860a ? cVar.f4861b != null ? new c(false, cVar.f4861b) : c.f4859d : obj;
        }
        boolean isCancelled = jVar.isCancelled();
        if ((!f4851d) && isCancelled) {
            return c.f4859d;
        }
        try {
            Object k10 = k(jVar);
            return k10 == null ? f4854g : k10;
        } catch (CancellationException e10) {
            if (isCancelled) {
                return new c(false, e10);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + jVar, e10));
        } catch (ExecutionException e11) {
            return new d(e11.getCause());
        } catch (Throwable th2) {
            return new d(th2);
        }
    }

    private static <V> V k(Future<V> future) throws ExecutionException {
        V v10;
        boolean z10 = false;
        while (true) {
            try {
                v10 = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return v10;
    }

    private void n() {
        i iVar;
        do {
            iVar = this.f4857c;
        } while (!f4853f.c(this, iVar, i.f4875c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f4877b;
        }
    }

    private void o(i iVar) {
        iVar.f4876a = null;
        while (true) {
            i iVar2 = this.f4857c;
            if (iVar2 != i.f4875c) {
                i iVar3 = null;
                while (iVar2 != null) {
                    i iVar4 = iVar2.f4877b;
                    if (iVar2.f4876a != null) {
                        iVar3 = iVar2;
                    } else if (iVar3 != null) {
                        iVar3.f4877b = iVar4;
                        if (iVar3.f4876a == null) {
                            break;
                        }
                    } else if (!f4853f.c(this, iVar2, iVar4)) {
                        break;
                    }
                    iVar2 = iVar4;
                }
                return;
            }
            return;
        }
    }

    private String s(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    @Override // com.google.common.util.concurrent.j
    public final void a(Runnable runnable, Executor executor) {
        e(runnable);
        e(executor);
        e eVar = this.f4856b;
        if (eVar != e.f4864d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f4867c = eVar;
                if (!f4853f.a(this, eVar, eVar2)) {
                    eVar = this.f4856b;
                } else {
                    return;
                }
            } while (eVar != e.f4864d);
            h(runnable, executor);
        }
        h(runnable, executor);
    }

    protected void c() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        c cVar;
        Object obj = this.f4855a;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        if (f4851d) {
            cVar = new c(z10, new CancellationException("Future.cancel() was called."));
        } else if (z10) {
            cVar = c.f4858c;
        } else {
            cVar = c.f4859d;
        }
        a<V> aVar = this;
        boolean z11 = false;
        while (true) {
            if (f4853f.b(aVar, obj, cVar)) {
                if (z10) {
                    aVar.l();
                }
                g(aVar);
                if (!(obj instanceof g)) {
                    return true;
                }
                j<? extends V> jVar = ((g) obj).f4874b;
                if (jVar instanceof a) {
                    aVar = (a) jVar;
                    obj = aVar.f4855a;
                    if (!(obj == null) && !(obj instanceof g)) {
                        return true;
                    }
                    z11 = true;
                } else {
                    jVar.cancel(z10);
                    return true;
                }
            } else {
                obj = aVar.f4855a;
                if (!(obj instanceof g)) {
                    return z11;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        java.util.concurrent.locks.LockSupport.parkNanos(r19, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (java.lang.Thread.interrupted() != false) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0055, code lost:
        r4 = r19.f4855a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
        if (r4 == null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0059, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
        r5 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0060, code lost:
        if ((r5 & (!(r4 instanceof androidx.work.impl.utils.futures.a.g))) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0066, code lost:
        return i(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0067, code lost:
        r4 = r11 - java.lang.System.nanoTime();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x006f, code lost:
        if (r4 >= 1000) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
        o(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
        o(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x007d, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        Locale locale;
        long nanos = timeUnit.toNanos(j10);
        if (!Thread.interrupted()) {
            Object obj = this.f4855a;
            if ((obj != null) && (!(obj instanceof g))) {
                return i(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                i iVar = this.f4857c;
                if (iVar == i.f4875c) {
                    return i(this.f4855a);
                }
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f4853f.c(this, iVar, iVar2)) {
                        break;
                    }
                    iVar = this.f4857c;
                } while (iVar != i.f4875c);
                return i(this.f4855a);
            }
            while (nanos > 0) {
                Object obj2 = this.f4855a;
                if ((obj2 != null) && (!(obj2 instanceof g))) {
                    return i(obj2);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            String aVar = toString();
            String lowerCase = timeUnit.toString().toLowerCase(Locale.ROOT);
            String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
            if (nanos + 1000 < 0) {
                String str2 = str + " (plus ";
                long j11 = -nanos;
                long convert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
                long nanos2 = j11 - timeUnit.toNanos(convert);
                int i10 = (convert > 0L ? 1 : (convert == 0L ? 0 : -1));
                boolean z10 = i10 == 0 || nanos2 > 1000;
                if (i10 > 0) {
                    String str3 = str2 + convert + " " + lowerCase;
                    if (z10) {
                        str3 = str3 + ",";
                    }
                    str2 = str3 + " ";
                }
                if (z10) {
                    str2 = str2 + nanos2 + " nanoseconds ";
                }
                str = str2 + "delay)";
            }
            if (isDone()) {
                throw new TimeoutException(str + " but future completed as timeout expired");
            }
            throw new TimeoutException(str + " for " + aVar);
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f4855a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f4855a;
        return (!(obj instanceof g)) & (obj != null);
    }

    protected void l() {
    }

    protected String m() {
        Object obj = this.f4855a;
        if (obj instanceof g) {
            return "setFuture=[" + s(((g) obj).f4874b) + "]";
        } else if (!(this instanceof ScheduledFuture)) {
            return null;
        } else {
            return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(V v10) {
        if (v10 == null) {
            v10 = (V) f4854g;
        }
        if (!f4853f.b(this, null, v10)) {
            return false;
        }
        g(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean q(Throwable th2) {
        if (!f4853f.b(this, null, new d((Throwable) e(th2)))) {
            return false;
        }
        g(this);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean r(j<? extends V> jVar) {
        d dVar;
        e(jVar);
        Object obj = this.f4855a;
        if (obj == null) {
            if (jVar.isDone()) {
                if (!f4853f.b(this, null, j(jVar))) {
                    return false;
                }
                g(this);
                return true;
            }
            g gVar = new g(this, jVar);
            if (f4853f.b(this, null, gVar)) {
                try {
                    jVar.a(gVar, androidx.work.impl.utils.futures.b.INSTANCE);
                } catch (Throwable th2) {
                    try {
                        dVar = new d(th2);
                    } catch (Throwable unused) {
                        dVar = d.f4862b;
                    }
                    f4853f.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.f4855a;
        }
        if (obj instanceof c) {
            jVar.cancel(((c) obj).f4860a);
        }
        return false;
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            try {
                str = m();
            } catch (RuntimeException e10) {
                str = "Exception thrown from implementation: " + e10.getClass();
            }
            if (str != null && !str.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(str);
                sb2.append("]");
            } else if (isDone()) {
                b(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
        java.util.concurrent.locks.LockSupport.park(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (java.lang.Thread.interrupted() != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0039, code lost:
        r0 = r6.f4855a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
        if (r0 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        r4 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        if ((r4 & (!(r0 instanceof androidx.work.impl.utils.futures.a.g))) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004a, code lost:
        return i(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004b, code lost:
        o(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        throw new java.lang.InterruptedException();
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final V get() throws InterruptedException, ExecutionException {
        if (!Thread.interrupted()) {
            Object obj = this.f4855a;
            if ((obj != null) && (!(obj instanceof g))) {
                return i(obj);
            }
            i iVar = this.f4857c;
            if (iVar == i.f4875c) {
                return i(this.f4855a);
            }
            i iVar2 = new i();
            do {
                iVar2.a(iVar);
                if (f4853f.c(this, iVar, iVar2)) {
                    break;
                }
                iVar = this.f4857c;
            } while (iVar != i.f4875c);
            return i(this.f4855a);
        }
        throw new InterruptedException();
    }
}
