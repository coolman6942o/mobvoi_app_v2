package y4;

import java.io.InputStream;
import java.net.URL;
import x4.g;
import x4.n;
import x4.o;
import x4.r;
/* compiled from: UrlLoader.java */
/* loaded from: classes.dex */
public class e implements n<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f36757a;

    /* compiled from: UrlLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<URL, InputStream> {
        @Override // x4.o
        public n<URL, InputStream> b(r rVar) {
            return new e(rVar.d(g.class, InputStream.class));
        }
    }

    public e(n<g, InputStream> nVar) {
        this.f36757a = nVar;
    }

    /* renamed from: c */
    public n.a<InputStream> b(URL url, int i10, int i11, q4.e eVar) {
        return this.f36757a.b(new g(url), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean a(URL url) {
        return true;
    }
}
