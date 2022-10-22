package okio;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import io.m;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import rp.g;
/* compiled from: AsyncTimeout.kt */
/* loaded from: classes3.dex */
public class a extends u {

    /* renamed from: h  reason: collision with root package name */
    private static final long f32382h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f32383i;

    /* renamed from: j  reason: collision with root package name */
    private static a f32384j;

    /* renamed from: k  reason: collision with root package name */
    public static final C0445a f32385k = new C0445a(null);

    /* renamed from: e  reason: collision with root package name */
    private boolean f32386e;

    /* renamed from: f  reason: collision with root package name */
    private a f32387f;

    /* renamed from: g  reason: collision with root package name */
    private long f32388g;

    /* compiled from: AsyncTimeout.kt */
    /* renamed from: okio.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0445a {
        private C0445a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(a aVar) {
            synchronized (a.class) {
                for (a aVar2 = a.f32384j; aVar2 != null; aVar2 = aVar2.f32387f) {
                    if (aVar2.f32387f == aVar) {
                        aVar2.f32387f = aVar.f32387f;
                        aVar.f32387f = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(a aVar, long j10, boolean z10) {
            synchronized (a.class) {
                if (a.f32384j == null) {
                    a.f32384j = new a();
                    new b().start();
                }
                long nanoTime = System.nanoTime();
                int i10 = (j10 > 0L ? 1 : (j10 == 0L ? 0 : -1));
                if (i10 != 0 && z10) {
                    aVar.f32388g = Math.min(j10, aVar.c() - nanoTime) + nanoTime;
                } else if (i10 != 0) {
                    aVar.f32388g = j10 + nanoTime;
                } else if (z10) {
                    aVar.f32388g = aVar.c();
                } else {
                    throw new AssertionError();
                }
                long u10 = aVar.u(nanoTime);
                a aVar2 = a.f32384j;
                i.d(aVar2);
                while (aVar2.f32387f != null) {
                    a aVar3 = aVar2.f32387f;
                    i.d(aVar3);
                    if (u10 < aVar3.u(nanoTime)) {
                        break;
                    }
                    aVar2 = aVar2.f32387f;
                    i.d(aVar2);
                }
                aVar.f32387f = aVar2.f32387f;
                aVar2.f32387f = aVar;
                if (aVar2 == a.f32384j) {
                    a.class.notify();
                }
                m mVar = m.f28349a;
            }
        }

        public final a c() throws InterruptedException {
            a aVar = a.f32384j;
            i.d(aVar);
            a aVar2 = aVar.f32387f;
            if (aVar2 == null) {
                long nanoTime = System.nanoTime();
                a.class.wait(a.f32382h);
                a aVar3 = a.f32384j;
                i.d(aVar3);
                if (aVar3.f32387f != null || System.nanoTime() - nanoTime < a.f32383i) {
                    return null;
                }
                return a.f32384j;
            }
            long u10 = aVar2.u(System.nanoTime());
            if (u10 > 0) {
                long j10 = u10 / 1000000;
                a.class.wait(j10, (int) (u10 - (1000000 * j10)));
                return null;
            }
            a aVar4 = a.f32384j;
            i.d(aVar4);
            aVar4.f32387f = aVar2.f32387f;
            aVar2.f32387f = null;
            return aVar2;
        }

        public /* synthetic */ C0445a(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            a c10;
            while (true) {
                try {
                    synchronized (a.class) {
                        c10 = a.f32385k.c();
                        if (c10 == a.f32384j) {
                            a.f32384j = null;
                            return;
                        }
                        m mVar = m.f28349a;
                    }
                    if (c10 != null) {
                        c10.x();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes3.dex */
    public static final class c implements r {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f32390b;

        c(r rVar) {
            this.f32390b = rVar;
        }

        @Override // okio.r
        public void Z(okio.c source, long j10) {
            i.f(source, "source");
            rp.c.b(source.i0(), 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 > 0) {
                    g gVar = source.f32393a;
                    i.d(gVar);
                    while (true) {
                        if (j11 >= ((long) WXMediaMessage.THUMB_LENGTH_LIMIT)) {
                            break;
                        }
                        j11 += gVar.f33665c - gVar.f33664b;
                        if (j11 >= j10) {
                            j11 = j10;
                            break;
                        } else {
                            gVar = gVar.f33668f;
                            i.d(gVar);
                        }
                    }
                    a aVar = a.this;
                    aVar.r();
                    try {
                        this.f32390b.Z(source, j11);
                        m mVar = m.f28349a;
                        if (!aVar.s()) {
                            j10 -= j11;
                        } else {
                            throw aVar.m(null);
                        }
                    } catch (IOException e10) {
                        if (aVar.s()) {
                            throw aVar.m(e10);
                        }
                        throw e10;
                    } finally {
                        aVar.s();
                    }
                } else {
                    return;
                }
            }
        }

        /* renamed from: c */
        public a timeout() {
            return a.this;
        }

        @Override // okio.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a aVar = a.this;
            aVar.r();
            try {
                this.f32390b.close();
                m mVar = m.f28349a;
                if (aVar.s()) {
                    throw aVar.m(null);
                }
            } catch (IOException e10) {
                if (aVar.s()) {
                    throw aVar.m(e10);
                }
            } finally {
                aVar.s();
            }
        }

        @Override // okio.r, java.io.Flushable
        public void flush() {
            a aVar = a.this;
            aVar.r();
            try {
                this.f32390b.flush();
                m mVar = m.f28349a;
                if (aVar.s()) {
                    throw aVar.m(null);
                }
            } catch (IOException e10) {
                if (aVar.s()) {
                    throw aVar.m(e10);
                }
            } finally {
                aVar.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f32390b + ')';
        }
    }

    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes3.dex */
    public static final class d implements t {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ t f32392b;

        d(t tVar) {
            this.f32392b = tVar;
        }

        /* renamed from: c */
        public a timeout() {
            return a.this;
        }

        @Override // okio.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            a aVar = a.this;
            aVar.r();
            try {
                this.f32392b.close();
                m mVar = m.f28349a;
                if (aVar.s()) {
                    throw aVar.m(null);
                }
            } catch (IOException e10) {
                if (aVar.s()) {
                    throw aVar.m(e10);
                }
            } finally {
                aVar.s();
            }
        }

        @Override // okio.t
        public long read(okio.c sink, long j10) {
            i.f(sink, "sink");
            a aVar = a.this;
            aVar.r();
            try {
                long read = this.f32392b.read(sink, j10);
                if (!aVar.s()) {
                    return read;
                }
                throw aVar.m(null);
            } catch (IOException e10) {
                if (!aVar.s()) {
                    throw e10;
                }
                throw aVar.m(e10);
            } finally {
                aVar.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f32392b + ')';
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f32382h = millis;
        f32383i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long u(long j10) {
        return this.f32388g - j10;
    }

    public final IOException m(IOException iOException) {
        return t(iOException);
    }

    public final void r() {
        if (!this.f32386e) {
            long h10 = h();
            boolean e10 = e();
            if (h10 != 0 || e10) {
                this.f32386e = true;
                f32385k.e(this, h10, e10);
                return;
            }
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit".toString());
    }

    public final boolean s() {
        if (!this.f32386e) {
            return false;
        }
        this.f32386e = false;
        return f32385k.d(this);
    }

    protected IOException t(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final r v(r sink) {
        i.f(sink, "sink");
        return new c(sink);
    }

    public final t w(t source) {
        i.f(source, "source");
        return new d(source);
    }

    protected void x() {
    }
}
