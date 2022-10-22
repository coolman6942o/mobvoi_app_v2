package nf;

import nf.j;
/* compiled from: Observation.java */
/* loaded from: classes2.dex */
public class j<T> implements l {

    /* renamed from: a  reason: collision with root package name */
    private h<T> f31240a;

    /* renamed from: b  reason: collision with root package name */
    private k<T> f31241b;

    /* compiled from: Observation.java */
    /* loaded from: classes2.dex */
    public interface a<T> {
        void call(T t10);
    }

    public static <T> j<T> b(h<T> hVar, final a<T> aVar) {
        return c(hVar, new k() { // from class: nf.i
            @Override // nf.k
            public final void i(h hVar2, Object obj) {
                j.a.this.call(obj);
            }
        });
    }

    public static <T> j<T> c(h<T> hVar, k<T> kVar) {
        return new j().f(hVar, kVar);
    }

    private j<T> f(h<T> hVar, k<T> kVar) {
        this.f31240a = hVar;
        this.f31241b = kVar;
        hVar.a(kVar);
        return this;
    }

    @Override // nf.l
    public void clear() {
        if (!d()) {
            this.f31240a.c(this.f31241b);
            this.f31240a = null;
            this.f31241b = null;
        }
    }

    @Override // nf.l
    public boolean d() {
        return this.f31240a == null || this.f31241b == null;
    }
}
