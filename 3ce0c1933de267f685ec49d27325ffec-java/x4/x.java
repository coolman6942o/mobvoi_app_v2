package x4;

import android.net.Uri;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import q4.e;
import x4.n;
/* compiled from: UrlUriLoader.java */
/* loaded from: classes.dex */
public class x<Data> implements n<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f36443b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));

    /* renamed from: a  reason: collision with root package name */
    private final n<g, Data> f36444a;

    /* compiled from: UrlUriLoader.java */
    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        @Override // x4.o
        public n<Uri, InputStream> b(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.f36444a = nVar;
    }

    /* renamed from: c */
    public n.a<Data> b(Uri uri, int i10, int i11, e eVar) {
        return this.f36444a.b(new g(uri.toString()), i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean a(Uri uri) {
        return f36443b.contains(uri.getScheme());
    }
}
