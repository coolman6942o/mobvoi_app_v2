package okhttp3.internal.connection;

import gp.b;
import io.m;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import jp.g;
import kotlin.jvm.internal.i;
import okhttp3.a;
import okhttp3.d0;
import okhttp3.internal.connection.j;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.r;
import okhttp3.u;
import okhttp3.y;
/* compiled from: ExchangeFinder.kt */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private j.b f31966a;

    /* renamed from: b  reason: collision with root package name */
    private j f31967b;

    /* renamed from: c  reason: collision with root package name */
    private int f31968c;

    /* renamed from: d  reason: collision with root package name */
    private int f31969d;

    /* renamed from: e  reason: collision with root package name */
    private int f31970e;

    /* renamed from: f  reason: collision with root package name */
    private d0 f31971f;

    /* renamed from: g  reason: collision with root package name */
    private final h f31972g;

    /* renamed from: h  reason: collision with root package name */
    private final a f31973h;

    /* renamed from: i  reason: collision with root package name */
    private final e f31974i;

    /* renamed from: j  reason: collision with root package name */
    private final r f31975j;

    public d(h connectionPool, a address, e call, r eventListener) {
        i.f(connectionPool, "connectionPool");
        i.f(address, "address");
        i.f(call, "call");
        i.f(eventListener, "eventListener");
        this.f31972g = connectionPool;
        this.f31973h = address;
        this.f31974i = call;
        this.f31975j = eventListener;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final f b(int i10, int i11, int i12, int i13, boolean z10) throws IOException {
        List<d0> list;
        Socket socket;
        if (!this.f31974i.isCanceled()) {
            f l10 = this.f31974i.l();
            boolean z11 = true;
            if (l10 != null) {
                synchronized (l10) {
                    if (!l10.q() && g(l10.A().a().l())) {
                        socket = null;
                        m mVar = m.f28349a;
                    }
                    socket = this.f31974i.v();
                    m mVar2 = m.f28349a;
                }
                if (this.f31974i.l() != null) {
                    if (socket != null) {
                        z11 = false;
                    }
                    if (z11) {
                        return l10;
                    }
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (socket != null) {
                    b.k(socket);
                }
                this.f31975j.l(this.f31974i, l10);
            }
            this.f31968c = 0;
            this.f31969d = 0;
            this.f31970e = 0;
            if (this.f31972g.a(this.f31973h, this.f31974i, null, false)) {
                f l11 = this.f31974i.l();
                i.d(l11);
                this.f31975j.k(this.f31974i, l11);
                return l11;
            }
            d0 d0Var = this.f31971f;
            try {
                if (d0Var != null) {
                    i.d(d0Var);
                    this.f31971f = null;
                } else {
                    j.b bVar = this.f31966a;
                    if (bVar != null) {
                        i.d(bVar);
                        if (bVar.b()) {
                            j.b bVar2 = this.f31966a;
                            i.d(bVar2);
                            d0Var = bVar2.c();
                        }
                    }
                    j jVar = this.f31967b;
                    if (jVar == null) {
                        jVar = new j(this.f31973h, this.f31974i.k().r(), this.f31974i, this.f31975j);
                        this.f31967b = jVar;
                    }
                    j.b d10 = jVar.d();
                    this.f31966a = d10;
                    list = d10.a();
                    if (this.f31974i.isCanceled()) {
                        throw new IOException("Canceled");
                    } else if (this.f31972g.a(this.f31973h, this.f31974i, list, false)) {
                        f l12 = this.f31974i.l();
                        i.d(l12);
                        this.f31975j.k(this.f31974i, l12);
                        return l12;
                    } else {
                        d0Var = d10.c();
                        f fVar = new f(this.f31972g, d0Var);
                        this.f31974i.x(fVar);
                        fVar.g(i10, i11, i12, i13, z10, this.f31974i, this.f31975j);
                        this.f31974i.x(null);
                        this.f31974i.k().r().a(fVar.A());
                        if (!this.f31972g.a(this.f31973h, this.f31974i, list, true)) {
                            f l13 = this.f31974i.l();
                            i.d(l13);
                            this.f31971f = d0Var;
                            b.k(fVar.E());
                            this.f31975j.k(this.f31974i, l13);
                            return l13;
                        }
                        synchronized (fVar) {
                            this.f31972g.e(fVar);
                            this.f31974i.c(fVar);
                            m mVar3 = m.f28349a;
                        }
                        this.f31975j.k(this.f31974i, fVar);
                        return fVar;
                    }
                }
                fVar.g(i10, i11, i12, i13, z10, this.f31974i, this.f31975j);
                this.f31974i.x(null);
                this.f31974i.k().r().a(fVar.A());
                if (!this.f31972g.a(this.f31973h, this.f31974i, list, true)) {
                }
            } catch (Throwable th2) {
                this.f31974i.x(null);
                throw th2;
            }
            list = null;
            f fVar2 = new f(this.f31972g, d0Var);
            this.f31974i.x(fVar2);
        } else {
            throw new IOException("Canceled");
        }
    }

    private final f c(int i10, int i11, int i12, int i13, boolean z10, boolean z11) throws IOException {
        while (true) {
            f b10 = b(i10, i11, i12, i13, z10);
            if (b10.v(z11)) {
                return b10;
            }
            b10.z();
            if (this.f31971f == null) {
                j.b bVar = this.f31966a;
                boolean z12 = true;
                if (!(bVar != null ? bVar.b() : true)) {
                    j jVar = this.f31967b;
                    if (jVar != null) {
                        z12 = jVar.b();
                    }
                    if (!z12) {
                        throw new IOException("exhausted all routes");
                    }
                } else {
                    continue;
                }
            }
        }
    }

    private final d0 f() {
        f l10;
        if (this.f31968c > 1 || this.f31969d > 1 || this.f31970e > 0 || (l10 = this.f31974i.l()) == null) {
            return null;
        }
        synchronized (l10) {
            if (l10.r() != 0) {
                return null;
            }
            if (!b.g(l10.A().a().l(), this.f31973h.l())) {
                return null;
            }
            return l10.A();
        }
    }

    public final jp.d a(y client, g chain) {
        i.f(client, "client");
        i.f(chain, "chain");
        try {
            return c(chain.f(), chain.h(), chain.j(), client.v(), client.B(), !i.b(chain.i().h(), "GET")).x(client, chain);
        } catch (IOException e10) {
            h(e10);
            throw new RouteException(e10);
        } catch (RouteException e11) {
            h(e11.getLastConnectException());
            throw e11;
        }
    }

    public final a d() {
        return this.f31973h;
    }

    public final boolean e() {
        j jVar;
        if (this.f31968c == 0 && this.f31969d == 0 && this.f31970e == 0) {
            return false;
        }
        if (this.f31971f != null) {
            return true;
        }
        d0 f10 = f();
        if (f10 != null) {
            this.f31971f = f10;
            return true;
        }
        j.b bVar = this.f31966a;
        if ((bVar == null || !bVar.b()) && (jVar = this.f31967b) != null) {
            return jVar.b();
        }
        return true;
    }

    public final boolean g(u url) {
        i.f(url, "url");
        u l10 = this.f31973h.l();
        return url.n() == l10.n() && i.b(url.h(), l10.h());
    }

    public final void h(IOException e10) {
        i.f(e10, "e");
        this.f31971f = null;
        if ((e10 instanceof StreamResetException) && ((StreamResetException) e10).errorCode == ErrorCode.REFUSED_STREAM) {
            this.f31968c++;
        } else if (e10 instanceof ConnectionShutdownException) {
            this.f31969d++;
        } else {
            this.f31970e++;
        }
    }
}
