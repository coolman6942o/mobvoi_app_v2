package androidx.databinding;

import androidx.databinding.c;
import androidx.databinding.g;
/* compiled from: ListChangeRegistry.java */
/* loaded from: classes.dex */
public class e extends c<g.a, g, b> {

    /* renamed from: f  reason: collision with root package name */
    private static final j0.g<b> f2730f = new j0.g<>(10);

    /* renamed from: g  reason: collision with root package name */
    private static final c.a<g.a, g, b> f2731g = new a();

    /* compiled from: ListChangeRegistry.java */
    /* loaded from: classes.dex */
    class a extends c.a<g.a, g, b> {
        a() {
        }

        /* renamed from: b */
        public void a(g.a aVar, g gVar, int i10, b bVar) {
            if (i10 == 1) {
                aVar.b(gVar, bVar.f2732a, bVar.f2733b);
            } else if (i10 == 2) {
                aVar.c(gVar, bVar.f2732a, bVar.f2733b);
            } else if (i10 == 3) {
                aVar.d(gVar, bVar.f2732a, bVar.f2734c, bVar.f2733b);
            } else if (i10 != 4) {
                aVar.a(gVar);
            } else {
                aVar.e(gVar, bVar.f2732a, bVar.f2733b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ListChangeRegistry.java */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f2732a;

        /* renamed from: b  reason: collision with root package name */
        public int f2733b;

        /* renamed from: c  reason: collision with root package name */
        public int f2734c;

        b() {
        }
    }

    public e() {
        super(f2731g);
    }

    private static b m(int i10, int i11, int i12) {
        b b10 = f2730f.b();
        if (b10 == null) {
            b10 = new b();
        }
        b10.f2732a = i10;
        b10.f2734c = i11;
        b10.f2733b = i12;
        return b10;
    }

    /* renamed from: n */
    public synchronized void d(g gVar, int i10, b bVar) {
        super.d(gVar, i10, bVar);
        if (bVar != null) {
            f2730f.a(bVar);
        }
    }

    public void o(g gVar, int i10, int i11) {
        d(gVar, 1, m(i10, 0, i11));
    }

    public void p(g gVar, int i10, int i11) {
        d(gVar, 2, m(i10, 0, i11));
    }

    public void q(g gVar, int i10, int i11) {
        d(gVar, 4, m(i10, 0, i11));
    }
}
