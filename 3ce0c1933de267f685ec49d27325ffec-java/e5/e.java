package e5;

import c5.b;
/* compiled from: GifDrawableResource.java */
/* loaded from: classes.dex */
public class e extends b<c> {
    public e(c cVar) {
        super(cVar);
    }

    @Override // c5.b, t4.b
    public void a() {
        ((c) this.f5578a).e().prepareToDraw();
    }

    @Override // t4.c
    public void b() {
        ((c) this.f5578a).stop();
        ((c) this.f5578a).k();
    }

    @Override // t4.c
    public int c() {
        return ((c) this.f5578a).i();
    }

    @Override // t4.c
    public Class<c> d() {
        return c.class;
    }
}
