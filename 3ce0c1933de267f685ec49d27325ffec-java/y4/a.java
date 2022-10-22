package y4;

import java.io.InputStream;
import q4.d;
import q4.e;
import r4.j;
import x4.g;
import x4.m;
import x4.n;
import x4.o;
import x4.r;
/* compiled from: HttpGlideUrlLoader.java */
/* loaded from: classes.dex */
public class a implements n<g, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final d<Integer> f36748b = d.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* renamed from: a  reason: collision with root package name */
    private final m<g, g> f36749a;

    /* compiled from: HttpGlideUrlLoader.java */
    /* renamed from: y4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0537a implements o<g, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final m<g, g> f36750a = new m<>(500);

        @Override // x4.o
        public n<g, InputStream> b(r rVar) {
            return new a(this.f36750a);
        }
    }

    public a(m<g, g> mVar) {
        this.f36749a = mVar;
    }

    /* renamed from: c */
    public n.a<InputStream> b(g gVar, int i10, int i11, e eVar) {
        m<g, g> mVar = this.f36749a;
        if (mVar != null) {
            g a10 = mVar.a(gVar, 0, 0);
            if (a10 == null) {
                this.f36749a.b(gVar, 0, 0, gVar);
            } else {
                gVar = a10;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) eVar.c(f36748b)).intValue()));
    }

    /* renamed from: d */
    public boolean a(g gVar) {
        return true;
    }
}
