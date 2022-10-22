package y4;

import android.net.Uri;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import q4.e;
import x4.g;
import x4.n;
import x4.o;
import x4.r;
/* compiled from: HttpUriLoader.java */
/* loaded from: classes.dex */
public class b implements n<Uri, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f36751b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a  reason: collision with root package name */
    private final n<g, InputStream> f36752a;

    /* compiled from: HttpUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        @Override // x4.o
        public n<Uri, InputStream> b(r rVar) {
            return new b(rVar.d(g.class, InputStream.class));
        }
    }

    public b(n<g, InputStream> nVar) {
        this.f36752a = nVar;
    }

    /* renamed from: c */
    public n.a<InputStream> b(Uri uri, int i10, int i11, e eVar) {
        return this.f36752a.b(new g(uri.toString()), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return f36751b.contains(uri.getScheme());
    }
}
