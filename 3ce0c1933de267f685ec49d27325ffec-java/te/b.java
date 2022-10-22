package te;

import android.text.TextUtils;
import java.io.IOException;
import okhttp3.a0;
import okhttp3.b0;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import okio.c;
import okio.d;
import okio.j;
import okio.n;
/* compiled from: GzipRequestInterceptor.java */
/* loaded from: classes2.dex */
public class b implements v {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GzipRequestInterceptor.java */
    /* loaded from: classes2.dex */
    public class a extends a0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a0 f35142a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ c f35143b;

        a(b bVar, a0 a0Var, c cVar) {
            this.f35142a = a0Var;
            this.f35143b = cVar;
        }

        @Override // okhttp3.a0
        public long contentLength() throws IOException {
            return this.f35143b.i0();
        }

        @Override // okhttp3.a0
        public w contentType() {
            return this.f35142a.contentType();
        }

        @Override // okhttp3.a0
        public void writeTo(d dVar) throws IOException {
            dVar.v0(this.f35143b.j0());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GzipRequestInterceptor.java */
    /* renamed from: te.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0507b extends a0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a0 f35144a;

        C0507b(b bVar, a0 a0Var) {
            this.f35144a = a0Var;
        }

        @Override // okhttp3.a0
        public long contentLength() {
            return -1L;
        }

        @Override // okhttp3.a0
        public w contentType() {
            return this.f35144a.contentType();
        }

        @Override // okhttp3.a0
        public void writeTo(d dVar) throws IOException {
            d c10 = n.c(new j(dVar));
            this.f35144a.writeTo(c10);
            c10.close();
        }
    }

    private a0 a(a0 a0Var) throws IOException {
        c cVar = new c();
        a0Var.writeTo(cVar);
        return new a(this, a0Var, cVar);
    }

    private a0 b(a0 a0Var) {
        return new C0507b(this, a0Var);
    }

    @Override // okhttp3.v
    public b0 intercept(v.a aVar) throws IOException {
        z request = aVar.request();
        if (request.a() == null || !TextUtils.equals(request.d("Content-Encoding"), "gzip")) {
            return aVar.a(request);
        }
        return aVar.a(request.i().j(request.h(), a(b(request.a()))).b());
    }
}
