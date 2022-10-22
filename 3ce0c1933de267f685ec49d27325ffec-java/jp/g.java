package jp;

import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.i;
import okhttp3.b0;
import okhttp3.internal.connection.c;
import okhttp3.internal.connection.e;
import okhttp3.j;
import okhttp3.v;
import okhttp3.z;
/* compiled from: RealInterceptorChain.kt */
/* loaded from: classes3.dex */
public final class g implements v.a {

    /* renamed from: a  reason: collision with root package name */
    private int f29662a;

    /* renamed from: b  reason: collision with root package name */
    private final e f29663b;

    /* renamed from: c  reason: collision with root package name */
    private final List<v> f29664c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29665d;

    /* renamed from: e  reason: collision with root package name */
    private final c f29666e;

    /* renamed from: f  reason: collision with root package name */
    private final z f29667f;

    /* renamed from: g  reason: collision with root package name */
    private final int f29668g;

    /* renamed from: h  reason: collision with root package name */
    private final int f29669h;

    /* renamed from: i  reason: collision with root package name */
    private final int f29670i;

    /* JADX WARN: Multi-variable type inference failed */
    public g(e call, List<? extends v> interceptors, int i10, c cVar, z request, int i11, int i12, int i13) {
        i.f(call, "call");
        i.f(interceptors, "interceptors");
        i.f(request, "request");
        this.f29663b = call;
        this.f29664c = interceptors;
        this.f29665d = i10;
        this.f29666e = cVar;
        this.f29667f = request;
        this.f29668g = i11;
        this.f29669h = i12;
        this.f29670i = i13;
    }

    public static /* synthetic */ g d(g gVar, int i10, c cVar, z zVar, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            i10 = gVar.f29665d;
        }
        if ((i14 & 2) != 0) {
            cVar = gVar.f29666e;
        }
        c cVar2 = cVar;
        if ((i14 & 4) != 0) {
            zVar = gVar.f29667f;
        }
        z zVar2 = zVar;
        if ((i14 & 8) != 0) {
            i11 = gVar.f29668g;
        }
        int i15 = i11;
        if ((i14 & 16) != 0) {
            i12 = gVar.f29669h;
        }
        int i16 = i12;
        if ((i14 & 32) != 0) {
            i13 = gVar.f29670i;
        }
        return gVar.c(i10, cVar2, zVar2, i15, i16, i13);
    }

    @Override // okhttp3.v.a
    public b0 a(z request) throws IOException {
        i.f(request, "request");
        boolean z10 = false;
        if (this.f29665d < this.f29664c.size()) {
            this.f29662a++;
            c cVar = this.f29666e;
            if (cVar != null) {
                if (cVar.j().g(request.l())) {
                    if (!(this.f29662a == 1)) {
                        throw new IllegalStateException(("network interceptor " + this.f29664c.get(this.f29665d - 1) + " must call proceed() exactly once").toString());
                    }
                } else {
                    throw new IllegalStateException(("network interceptor " + this.f29664c.get(this.f29665d - 1) + " must retain the same host and port").toString());
                }
            }
            g d10 = d(this, this.f29665d + 1, null, request, 0, 0, 0, 58, null);
            v vVar = this.f29664c.get(this.f29665d);
            b0 intercept = vVar.intercept(d10);
            if (intercept != null) {
                if (this.f29666e != null) {
                    if (!(this.f29665d + 1 >= this.f29664c.size() || d10.f29662a == 1)) {
                        throw new IllegalStateException(("network interceptor " + vVar + " must call proceed() exactly once").toString());
                    }
                }
                if (intercept.c() != null) {
                    z10 = true;
                }
                if (z10) {
                    return intercept;
                }
                throw new IllegalStateException(("interceptor " + vVar + " returned a response with no body").toString());
            }
            throw new NullPointerException("interceptor " + vVar + " returned null");
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    @Override // okhttp3.v.a
    public j b() {
        c cVar = this.f29666e;
        if (cVar != null) {
            return cVar.h();
        }
        return null;
    }

    public final g c(int i10, c cVar, z request, int i11, int i12, int i13) {
        i.f(request, "request");
        return new g(this.f29663b, this.f29664c, i10, cVar, request, i11, i12, i13);
    }

    @Override // okhttp3.v.a
    public okhttp3.e call() {
        return this.f29663b;
    }

    public final e e() {
        return this.f29663b;
    }

    public final int f() {
        return this.f29668g;
    }

    public final c g() {
        return this.f29666e;
    }

    public final int h() {
        return this.f29669h;
    }

    public final z i() {
        return this.f29667f;
    }

    public final int j() {
        return this.f29670i;
    }

    public int k() {
        return this.f29669h;
    }

    @Override // okhttp3.v.a
    public z request() {
        return this.f29667f;
    }
}
