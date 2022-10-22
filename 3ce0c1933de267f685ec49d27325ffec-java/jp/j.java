package jp;

import gp.b;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.collections.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.d0;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.e;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.u;
import okhttp3.v;
import okhttp3.y;
import okhttp3.z;
/* compiled from: RetryAndFollowUpInterceptor.kt */
/* loaded from: classes3.dex */
public final class j implements v {

    /* renamed from: a  reason: collision with root package name */
    private final y f29675a;

    /* compiled from: RetryAndFollowUpInterceptor.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public j(y client) {
        i.f(client, "client");
        this.f29675a = client;
    }

    private final z a(b0 b0Var, String str) {
        String w10;
        u s10;
        a0 a0Var = null;
        if (!this.f29675a.p() || (w10 = b0.w(b0Var, "Location", null, 2, null)) == null || (s10 = b0Var.g0().l().s(w10)) == null) {
            return null;
        }
        if (!i.b(s10.t(), b0Var.g0().l().t()) && !this.f29675a.q()) {
            return null;
        }
        z.a i10 = b0Var.g0().i();
        if (f.b(str)) {
            int n10 = b0Var.n();
            f fVar = f.f29661a;
            boolean z10 = fVar.d(str) || n10 == 308 || n10 == 307;
            if (!fVar.c(str) || n10 == 308 || n10 == 307) {
                if (z10) {
                    a0Var = b0Var.g0().a();
                }
                i10.j(str, a0Var);
            } else {
                i10.j("GET", null);
            }
            if (!z10) {
                i10.m("Transfer-Encoding");
                i10.m("Content-Length");
                i10.m("Content-Type");
            }
        }
        if (!b.g(b0Var.g0().l(), s10)) {
            i10.m("Authorization");
        }
        return i10.q(s10).b();
    }

    private final z b(b0 b0Var, c cVar) throws IOException {
        okhttp3.internal.connection.f h10;
        d0 A = (cVar == null || (h10 = cVar.h()) == null) ? null : h10.A();
        int n10 = b0Var.n();
        String h11 = b0Var.g0().h();
        if (!(n10 == 307 || n10 == 308)) {
            if (n10 == 401) {
                return this.f29675a.d().a(A, b0Var);
            }
            if (n10 == 421) {
                a0 a10 = b0Var.g0().a();
                if ((a10 != null && a10.isOneShot()) || cVar == null || !cVar.k()) {
                    return null;
                }
                cVar.h().y();
                return b0Var.g0();
            } else if (n10 == 503) {
                b0 T = b0Var.T();
                if ((T == null || T.n() != 503) && f(b0Var, Integer.MAX_VALUE) == 0) {
                    return b0Var.g0();
                }
                return null;
            } else if (n10 == 407) {
                i.d(A);
                if (A.b().type() == Proxy.Type.HTTP) {
                    return this.f29675a.y().a(A, b0Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            } else if (n10 != 408) {
                switch (n10) {
                    case 300:
                    case 301:
                    case 302:
                    case 303:
                        break;
                    default:
                        return null;
                }
            } else if (!this.f29675a.B()) {
                return null;
            } else {
                a0 a11 = b0Var.g0().a();
                if (a11 != null && a11.isOneShot()) {
                    return null;
                }
                b0 T2 = b0Var.T();
                if ((T2 == null || T2.n() != 408) && f(b0Var, 0) <= 0) {
                    return b0Var.g0();
                }
                return null;
            }
        }
        return a(b0Var, h11);
    }

    private final boolean c(IOException iOException, boolean z10) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z10 : (!(iOException instanceof SSLHandshakeException) || !(iOException.getCause() instanceof CertificateException)) && !(iOException instanceof SSLPeerUnverifiedException);
    }

    private final boolean d(IOException iOException, e eVar, z zVar, boolean z10) {
        if (!this.f29675a.B()) {
            return false;
        }
        return (!z10 || !e(iOException, zVar)) && c(iOException, z10) && eVar.w();
    }

    private final boolean e(IOException iOException, z zVar) {
        a0 a10 = zVar.a();
        return (a10 != null && a10.isOneShot()) || (iOException instanceof FileNotFoundException);
    }

    private final int f(b0 b0Var, int i10) {
        String w10 = b0.w(b0Var, "Retry-After", null, 2, null);
        if (w10 == null) {
            return i10;
        }
        if (!new Regex("\\d+").matches(w10)) {
            return Integer.MAX_VALUE;
        }
        Integer valueOf = Integer.valueOf(w10);
        i.e(valueOf, "Integer.valueOf(header)");
        return valueOf.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // okhttp3.v
    public b0 intercept(v.a chain) throws IOException {
        List g10;
        c o10;
        z b10;
        i.f(chain, "chain");
        g gVar = (g) chain;
        z i10 = gVar.i();
        e e10 = gVar.e();
        g10 = m.g();
        boolean z10 = true;
        boolean z11 = false;
        b0 b0Var = null;
        boolean z12 = z10;
        int i11 = z11;
        while (true) {
            e10.i(i10, z12);
            try {
                if (!e10.isCanceled()) {
                    try {
                        b0 a10 = gVar.a(i10);
                        if (b0Var != null) {
                            a10 = a10.Q().o(b0Var.Q().b(null).c()).c();
                        }
                        b0Var = a10;
                        o10 = e10.o();
                        b10 = b(b0Var, o10);
                    } catch (IOException e11) {
                        if (d(e11, e10, i10, !(e11 instanceof ConnectionShutdownException) ? z10 : z11)) {
                            g10 = kotlin.collections.u.O(g10, e11);
                            e10.j(z10);
                            z12 = z11;
                        } else {
                            throw b.U(e11, g10);
                        }
                    } catch (RouteException e12) {
                        if (d(e12.getLastConnectException(), e10, i10, z11)) {
                            g10 = kotlin.collections.u.O(g10, e12.getFirstConnectException());
                            e10.j(z10);
                            z12 = z11;
                        } else {
                            throw b.U(e12.getFirstConnectException(), g10);
                        }
                    }
                    if (b10 == null) {
                        if (o10 != null && o10.l()) {
                            e10.y();
                        }
                        return b0Var;
                    }
                    a0 a11 = b10.a();
                    if (a11 != null && a11.isOneShot()) {
                        return b0Var;
                    }
                    c0 c10 = b0Var.c();
                    if (c10 != null) {
                        b.j(c10);
                    }
                    i11 = (i11 == true ? 1 : 0) + 1;
                    if (i11 <= 20) {
                        e10.j(z10);
                        i10 = b10;
                        z12 = z10;
                    } else {
                        throw new ProtocolException("Too many follow-up requests: " + i11);
                    }
                } else {
                    throw new IOException("Canceled");
                }
            } finally {
                e10.j(z10);
            }
        }
    }
}
