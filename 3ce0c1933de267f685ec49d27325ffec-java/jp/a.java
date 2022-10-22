package jp;

import gp.b;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.m;
import okhttp3.n;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import okio.k;
/* compiled from: BridgeInterceptor.kt */
/* loaded from: classes3.dex */
public final class a implements v {

    /* renamed from: a  reason: collision with root package name */
    private final n f29654a;

    public a(n cookieJar) {
        i.f(cookieJar, "cookieJar");
        this.f29654a = cookieJar;
    }

    private final String a(List<m> list) {
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        for (Object obj : list) {
            i10++;
            if (i10 < 0) {
                kotlin.collections.m.o();
            }
            m mVar = (m) obj;
            if (i10 > 0) {
                sb2.append("; ");
            }
            sb2.append(mVar.e());
            sb2.append('=');
            sb2.append(mVar.g());
        }
        String sb3 = sb2.toString();
        i.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    @Override // okhttp3.v
    public b0 intercept(v.a chain) throws IOException {
        boolean p10;
        c0 c10;
        i.f(chain, "chain");
        z request = chain.request();
        z.a i10 = request.i();
        a0 a10 = request.a();
        if (a10 != null) {
            w contentType = a10.contentType();
            if (contentType != null) {
                i10.h("Content-Type", contentType.toString());
            }
            long contentLength = a10.contentLength();
            if (contentLength != -1) {
                i10.h("Content-Length", String.valueOf(contentLength));
                i10.m("Transfer-Encoding");
            } else {
                i10.h("Transfer-Encoding", "chunked");
                i10.m("Content-Length");
            }
        }
        boolean z10 = false;
        if (request.d("Host") == null) {
            i10.h("Host", b.N(request.l(), false, 1, null));
        }
        if (request.d("Connection") == null) {
            i10.h("Connection", "Keep-Alive");
        }
        if (request.d("Accept-Encoding") == null && request.d("Range") == null) {
            i10.h("Accept-Encoding", "gzip");
            z10 = true;
        }
        List<m> b10 = this.f29654a.b(request.l());
        if (!b10.isEmpty()) {
            i10.h("Cookie", a(b10));
        }
        if (request.d("User-Agent") == null) {
            i10.h("User-Agent", "okhttp/4.9.1");
        }
        b0 a11 = chain.a(i10.b());
        e.f(this.f29654a, request.l(), a11.x());
        b0.a s10 = a11.Q().s(request);
        if (z10) {
            p10 = t.p("gzip", b0.w(a11, "Content-Encoding", null, 2, null), true);
            if (p10 && e.b(a11) && (c10 = a11.c()) != null) {
                k kVar = new k(c10.source());
                s10.k(a11.x().newBuilder().i("Content-Encoding").i("Content-Length").f());
                s10.b(new h(b0.w(a11, "Content-Type", null, 2, null), -1L, okio.n.d(kVar)));
            }
        }
        return s10.c();
    }
}
