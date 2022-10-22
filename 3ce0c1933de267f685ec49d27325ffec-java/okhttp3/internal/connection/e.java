package okhttp3.internal.connection;

import io.m;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import jp.j;
import kotlin.jvm.internal.i;
import okhttp3.b0;
import okhttp3.f;
import okhttp3.g;
import okhttp3.internal.platform.h;
import okhttp3.p;
import okhttp3.r;
import okhttp3.u;
import okhttp3.y;
import okhttp3.z;
/* compiled from: RealCall.kt */
/* loaded from: classes3.dex */
public final class e implements okhttp3.e {

    /* renamed from: a  reason: collision with root package name */
    private final h f31976a;

    /* renamed from: b  reason: collision with root package name */
    private final r f31977b;

    /* renamed from: c  reason: collision with root package name */
    private final c f31978c;

    /* renamed from: e  reason: collision with root package name */
    private Object f31980e;

    /* renamed from: f  reason: collision with root package name */
    private d f31981f;

    /* renamed from: g  reason: collision with root package name */
    private f f31982g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f31983h;

    /* renamed from: i  reason: collision with root package name */
    private okhttp3.internal.connection.c f31984i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f31985j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f31986k;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f31988m;

    /* renamed from: n  reason: collision with root package name */
    private volatile okhttp3.internal.connection.c f31989n;

    /* renamed from: o  reason: collision with root package name */
    private volatile f f31990o;

    /* renamed from: p  reason: collision with root package name */
    private final y f31991p;

    /* renamed from: q  reason: collision with root package name */
    private final z f31992q;

    /* renamed from: r  reason: collision with root package name */
    private final boolean f31993r;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f31979d = new AtomicBoolean();

    /* renamed from: l  reason: collision with root package name */
    private boolean f31987l = true;

    /* compiled from: RealCall.kt */
    /* loaded from: classes3.dex */
    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private volatile AtomicInteger f31994a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        private final f f31995b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f31996c;

        public a(e eVar, f responseCallback) {
            i.f(responseCallback, "responseCallback");
            this.f31996c = eVar;
            this.f31995b = responseCallback;
        }

        public final void a(ExecutorService executorService) {
            i.f(executorService, "executorService");
            p m10 = this.f31996c.k().m();
            if (!gp.b.f27632h || !Thread.holdsLock(m10)) {
                try {
                    try {
                        executorService.execute(this);
                    } catch (RejectedExecutionException e10) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e10);
                        this.f31996c.t(interruptedIOException);
                        this.f31995b.onFailure(this.f31996c, interruptedIOException);
                        this.f31996c.k().m().g(this);
                    }
                } catch (Throwable th2) {
                    this.f31996c.k().m().g(this);
                    throw th2;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Thread ");
                Thread currentThread = Thread.currentThread();
                i.e(currentThread, "Thread.currentThread()");
                sb2.append(currentThread.getName());
                sb2.append(" MUST NOT hold lock on ");
                sb2.append(m10);
                throw new AssertionError(sb2.toString());
            }
        }

        public final e b() {
            return this.f31996c;
        }

        public final AtomicInteger c() {
            return this.f31994a;
        }

        public final String d() {
            return this.f31996c.p().l().h();
        }

        public final void e(a other) {
            i.f(other, "other");
            this.f31994a = other.f31994a;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z10;
            IOException e10;
            p m10;
            Throwable th2;
            Thread currentThread = Thread.currentThread();
            i.e(currentThread, "currentThread");
            String name = currentThread.getName();
            currentThread.setName("OkHttp " + this.f31996c.u());
            try {
                this.f31996c.f31978c.r();
                try {
                    z10 = true;
                } catch (IOException e11) {
                    e10 = e11;
                    z10 = false;
                } catch (Throwable th3) {
                    th2 = th3;
                    z10 = false;
                }
                try {
                    this.f31995b.onResponse(this.f31996c, this.f31996c.q());
                    m10 = this.f31996c.k().m();
                } catch (IOException e12) {
                    e10 = e12;
                    if (z10) {
                        h.f32213c.g().k("Callback failure for " + this.f31996c.A(), 4, e10);
                    } else {
                        this.f31995b.onFailure(this.f31996c, e10);
                    }
                    m10 = this.f31996c.k().m();
                    m10.g(this);
                } catch (Throwable th4) {
                    th2 = th4;
                    this.f31996c.cancel();
                    if (!z10) {
                        IOException iOException = new IOException("canceled due to " + th2);
                        io.b.a(iOException, th2);
                        this.f31995b.onFailure(this.f31996c, iOException);
                    }
                    throw th2;
                }
                m10.g(this);
            } finally {
                currentThread.setName(name);
            }
        }
    }

    /* compiled from: RealCall.kt */
    /* loaded from: classes3.dex */
    public static final class b extends WeakReference<e> {

        /* renamed from: a  reason: collision with root package name */
        private final Object f31997a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e referent, Object obj) {
            super(referent);
            i.f(referent, "referent");
            this.f31997a = obj;
        }

        public final Object a() {
            return this.f31997a;
        }
    }

    /* compiled from: RealCall.kt */
    /* loaded from: classes3.dex */
    public static final class c extends okio.a {
        c() {
        }

        @Override // okio.a
        protected void x() {
            e.this.cancel();
        }
    }

    public e(y client, z originalRequest, boolean z10) {
        i.f(client, "client");
        i.f(originalRequest, "originalRequest");
        this.f31991p = client;
        this.f31992q = originalRequest;
        this.f31993r = z10;
        this.f31976a = client.j().a();
        this.f31977b = client.o().a(this);
        c cVar = new c();
        cVar.g(client.f(), TimeUnit.MILLISECONDS);
        m mVar = m.f28349a;
        this.f31978c = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String A() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(isCanceled() ? "canceled " : "");
        sb2.append(this.f31993r ? "web socket" : "call");
        sb2.append(" to ");
        sb2.append(u());
        return sb2.toString();
    }

    private final <E extends IOException> E d(E e10) {
        Socket v10;
        boolean z10 = gp.b.f27632h;
        if (!z10 || !Thread.holdsLock(this)) {
            f fVar = this.f31982g;
            if (fVar != null) {
                if (!z10 || !Thread.holdsLock(fVar)) {
                    synchronized (fVar) {
                        v10 = v();
                    }
                    if (this.f31982g == null) {
                        if (v10 != null) {
                            gp.b.k(v10);
                        }
                        this.f31977b.l(this, fVar);
                    } else {
                        if (!(v10 == null)) {
                            throw new IllegalStateException("Check failed.".toString());
                        }
                    }
                } else {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Thread ");
                    Thread currentThread = Thread.currentThread();
                    i.e(currentThread, "Thread.currentThread()");
                    sb2.append(currentThread.getName());
                    sb2.append(" MUST NOT hold lock on ");
                    sb2.append(fVar);
                    throw new AssertionError(sb2.toString());
                }
            }
            E e11 = (E) z(e10);
            if (e10 != null) {
                r rVar = this.f31977b;
                i.d(e11);
                rVar.e(this, e11);
            } else {
                this.f31977b.d(this);
            }
            return e11;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Thread ");
        Thread currentThread2 = Thread.currentThread();
        i.e(currentThread2, "Thread.currentThread()");
        sb3.append(currentThread2.getName());
        sb3.append(" MUST NOT hold lock on ");
        sb3.append(this);
        throw new AssertionError(sb3.toString());
    }

    private final void e() {
        this.f31980e = h.f32213c.g().i("response.body().close()");
        this.f31977b.f(this);
    }

    private final okhttp3.a g(u uVar) {
        g gVar;
        HostnameVerifier hostnameVerifier;
        SSLSocketFactory sSLSocketFactory = null;
        if (uVar.i()) {
            sSLSocketFactory = this.f31991p.D();
            hostnameVerifier = this.f31991p.s();
            gVar = this.f31991p.g();
        } else {
            hostnameVerifier = null;
            gVar = null;
        }
        return new okhttp3.a(uVar.h(), uVar.n(), this.f31991p.n(), this.f31991p.C(), sSLSocketFactory, hostnameVerifier, gVar, this.f31991p.y(), this.f31991p.x(), this.f31991p.w(), this.f31991p.k(), this.f31991p.z());
    }

    private final <E extends IOException> E z(E e10) {
        if (this.f31983h || !this.f31978c.s()) {
            return e10;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (e10 != null) {
            interruptedIOException.initCause(e10);
        }
        return interruptedIOException;
    }

    public final void c(f connection) {
        i.f(connection, "connection");
        if (!gp.b.f27632h || Thread.holdsLock(connection)) {
            if (this.f31982g == null) {
                this.f31982g = connection;
                connection.o().add(new b(this, this.f31980e));
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(connection);
        throw new AssertionError(sb2.toString());
    }

    @Override // okhttp3.e
    public void cancel() {
        if (!this.f31988m) {
            this.f31988m = true;
            okhttp3.internal.connection.c cVar = this.f31989n;
            if (cVar != null) {
                cVar.b();
            }
            f fVar = this.f31990o;
            if (fVar != null) {
                fVar.e();
            }
            this.f31977b.g(this);
        }
    }

    @Override // okhttp3.e
    public b0 execute() {
        if (this.f31979d.compareAndSet(false, true)) {
            this.f31978c.r();
            e();
            try {
                this.f31991p.m().c(this);
                return q();
            } finally {
                this.f31991p.m().h(this);
            }
        } else {
            throw new IllegalStateException("Already Executed".toString());
        }
    }

    /* renamed from: f */
    public e clone() {
        return new e(this.f31991p, this.f31992q, this.f31993r);
    }

    @Override // okhttp3.e
    public void h(f responseCallback) {
        i.f(responseCallback, "responseCallback");
        if (this.f31979d.compareAndSet(false, true)) {
            e();
            this.f31991p.m().b(new a(this, responseCallback));
            return;
        }
        throw new IllegalStateException("Already Executed".toString());
    }

    public final void i(z request, boolean z10) {
        i.f(request, "request");
        if (this.f31984i == null) {
            synchronized (this) {
                if (!(!this.f31986k)) {
                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                } else if (!this.f31985j) {
                    m mVar = m.f28349a;
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
            if (z10) {
                this.f31981f = new d(this.f31976a, g(request.l()), this, this.f31977b);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.e
    public boolean isCanceled() {
        return this.f31988m;
    }

    public final void j(boolean z10) {
        okhttp3.internal.connection.c cVar;
        synchronized (this) {
            if (this.f31987l) {
                m mVar = m.f28349a;
            } else {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z10 && (cVar = this.f31989n) != null) {
            cVar.d();
        }
        this.f31984i = null;
    }

    public final y k() {
        return this.f31991p;
    }

    public final f l() {
        return this.f31982g;
    }

    public final r m() {
        return this.f31977b;
    }

    public final boolean n() {
        return this.f31993r;
    }

    public final okhttp3.internal.connection.c o() {
        return this.f31984i;
    }

    public final z p() {
        return this.f31992q;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final b0 q() throws IOException {
        Throwable th2;
        ArrayList arrayList = new ArrayList();
        kotlin.collections.r.s(arrayList, this.f31991p.t());
        arrayList.add(new j(this.f31991p));
        arrayList.add(new jp.a(this.f31991p.l()));
        arrayList.add(new okhttp3.internal.cache.a(this.f31991p.e()));
        arrayList.add(okhttp3.internal.connection.a.f31944a);
        if (!this.f31993r) {
            kotlin.collections.r.s(arrayList, this.f31991p.u());
        }
        arrayList.add(new jp.b(this.f31993r));
        boolean z10 = false;
        try {
            b0 a10 = new jp.g(this, arrayList, 0, null, this.f31992q, this.f31991p.i(), this.f31991p.A(), this.f31991p.F()).a(this.f31992q);
            if (!isCanceled()) {
                t(null);
                return a10;
            }
            gp.b.j(a10);
            throw new IOException("Canceled");
        } catch (IOException e10) {
            z10 = true;
            try {
                IOException t10 = t(e10);
                if (t10 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
                }
                throw t10;
            } catch (Throwable th3) {
                th2 = th3;
                if (!z10) {
                    t(null);
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            if (!z10) {
            }
            throw th2;
        }
    }

    public final okhttp3.internal.connection.c r(jp.g chain) {
        i.f(chain, "chain");
        synchronized (this) {
            if (!this.f31987l) {
                throw new IllegalStateException("released".toString());
            } else if (!(!this.f31986k)) {
                throw new IllegalStateException("Check failed.".toString());
            } else if (!this.f31985j) {
                m mVar = m.f28349a;
            } else {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        d dVar = this.f31981f;
        i.d(dVar);
        okhttp3.internal.connection.c cVar = new okhttp3.internal.connection.c(this, this.f31977b, dVar, dVar.a(this.f31991p, chain));
        this.f31984i = cVar;
        this.f31989n = cVar;
        synchronized (this) {
            this.f31985j = true;
            this.f31986k = true;
        }
        if (!this.f31988m) {
            return cVar;
        }
        throw new IOException("Canceled");
    }

    @Override // okhttp3.e
    public z request() {
        return this.f31992q;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0023 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:8:0x0014, B:14:0x001d, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:35:0x0043), top: B:46:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0027 A[Catch: all -> 0x0019, TryCatch #0 {all -> 0x0019, blocks: (B:8:0x0014, B:14:0x001d, B:17:0x0023, B:19:0x0027, B:20:0x0029, B:22:0x002d, B:27:0x0036, B:29:0x003a, B:35:0x0043), top: B:46:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final <E extends IOException> E s(okhttp3.internal.connection.c exchange, boolean z10, boolean z11, E e10) {
        boolean z12;
        boolean z13;
        i.f(exchange, "exchange");
        boolean z14 = true;
        if (!i.b(exchange, this.f31989n)) {
            return e10;
        }
        synchronized (this) {
            z12 = false;
            if (z10) {
                try {
                    if (!this.f31985j) {
                    }
                    if (z10) {
                        this.f31985j = false;
                    }
                    if (z11) {
                        this.f31986k = false;
                    }
                    z13 = this.f31985j;
                    boolean z15 = z13 && !this.f31986k;
                    if (!z13 || this.f31986k || this.f31987l) {
                        z14 = false;
                    }
                    z12 = z15;
                    m mVar = m.f28349a;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (!z11 || !this.f31986k) {
                z14 = false;
                m mVar2 = m.f28349a;
            }
            if (z10) {
            }
            if (z11) {
            }
            z13 = this.f31985j;
            if (z13) {
            }
            if (!z13) {
            }
            z14 = false;
            z12 = z15;
            m mVar22 = m.f28349a;
        }
        if (z12) {
            this.f31989n = null;
            f fVar = this.f31982g;
            if (fVar != null) {
                fVar.t();
            }
        }
        return z14 ? (E) d(e10) : e10;
    }

    public final IOException t(IOException iOException) {
        boolean z10;
        synchronized (this) {
            z10 = false;
            if (this.f31987l) {
                this.f31987l = false;
                if (!this.f31985j && !this.f31986k) {
                    z10 = true;
                }
            }
            m mVar = m.f28349a;
        }
        return z10 ? d(iOException) : iOException;
    }

    public final String u() {
        return this.f31992q.l().r();
    }

    public final Socket v() {
        f fVar = this.f31982g;
        i.d(fVar);
        if (!gp.b.f27632h || Thread.holdsLock(fVar)) {
            List<Reference<e>> o10 = fVar.o();
            Iterator<Reference<e>> it = o10.iterator();
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                } else if (i.b(it.next().get(), this)) {
                    break;
                } else {
                    i10++;
                }
            }
            if (i10 != -1) {
                z10 = true;
            }
            if (z10) {
                o10.remove(i10);
                this.f31982g = null;
                if (o10.isEmpty()) {
                    fVar.C(System.nanoTime());
                    if (this.f31976a.c(fVar)) {
                        return fVar.E();
                    }
                }
                return null;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(fVar);
        throw new AssertionError(sb2.toString());
    }

    public final boolean w() {
        d dVar = this.f31981f;
        i.d(dVar);
        return dVar.e();
    }

    public final void x(f fVar) {
        this.f31990o = fVar;
    }

    public final void y() {
        if (!this.f31983h) {
            this.f31983h = true;
            this.f31978c.s();
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
