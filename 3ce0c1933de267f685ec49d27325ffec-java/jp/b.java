package jp;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.internal.connection.c;
import okhttp3.v;
import okhttp3.z;
import okio.d;
import okio.n;
/* compiled from: CallServerInterceptor.kt */
/* loaded from: classes3.dex */
public final class b implements v {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f29655a;

    public b(boolean z10) {
        this.f29655a = z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x013b, code lost:
        if (r1 != false) goto L42;
     */
    @Override // okhttp3.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b0 intercept(v.a chain) throws IOException {
        boolean z10;
        b0.a aVar;
        b0 b0Var;
        boolean p10;
        boolean p11;
        boolean p12;
        i.f(chain, "chain");
        g gVar = (g) chain;
        c g10 = gVar.g();
        i.d(g10);
        z i10 = gVar.i();
        a0 a10 = i10.a();
        long currentTimeMillis = System.currentTimeMillis();
        g10.t(i10);
        Long l10 = null;
        if (!f.b(i10.h()) || a10 == null) {
            g10.n();
            aVar = null;
            z10 = true;
        } else {
            p12 = t.p("100-continue", i10.d("Expect"), true);
            if (p12) {
                g10.f();
                aVar = g10.p(true);
                g10.r();
                z10 = false;
            } else {
                aVar = null;
                z10 = true;
            }
            if (aVar != null) {
                g10.n();
                if (!g10.h().w()) {
                    g10.m();
                }
            } else if (a10.isDuplex()) {
                g10.f();
                a10.writeTo(n.c(g10.c(i10, true)));
            } else {
                d c10 = n.c(g10.c(i10, false));
                a10.writeTo(c10);
                c10.close();
            }
        }
        if (a10 == null || !a10.isDuplex()) {
            g10.e();
        }
        if (aVar == null) {
            aVar = g10.p(false);
            i.d(aVar);
            if (z10) {
                g10.r();
                z10 = false;
            }
        }
        b0 c11 = aVar.s(i10).i(g10.h().s()).t(currentTimeMillis).q(System.currentTimeMillis()).c();
        int n10 = c11.n();
        if (n10 == 100) {
            b0.a p13 = g10.p(false);
            i.d(p13);
            if (z10) {
                g10.r();
            }
            c11 = p13.s(i10).i(g10.h().s()).t(currentTimeMillis).q(System.currentTimeMillis()).c();
            n10 = c11.n();
        }
        g10.q(c11);
        if (!this.f29655a || n10 != 101) {
            b0Var = c11.Q().b(g10.o(c11)).c();
        } else {
            b0Var = c11.Q().b(gp.b.f27627c).c();
        }
        p10 = t.p("close", b0Var.g0().d("Connection"), true);
        if (!p10) {
            p11 = t.p("close", b0.w(b0Var, "Connection", null, 2, null), true);
        }
        g10.m();
        if (n10 == 204 || n10 == 205) {
            c0 c12 = b0Var.c();
            if ((c12 != null ? c12.contentLength() : -1L) > 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("HTTP ");
                sb2.append(n10);
                sb2.append(" had non-zero Content-Length: ");
                c0 c13 = b0Var.c();
                if (c13 != null) {
                    l10 = Long.valueOf(c13.contentLength());
                }
                sb2.append(l10);
                throw new ProtocolException(sb2.toString());
            }
        }
        return b0Var;
    }
}
