package e3;

import java.util.Collections;
import l3.a;
import l3.b;
import l3.c;
/* compiled from: ValueCallbackKeyframeAnimation.java */
/* loaded from: classes.dex */
public class p<K, A> extends a<K, A> {

    /* renamed from: i  reason: collision with root package name */
    private final A f25773i;

    public p(c<A> cVar) {
        this(cVar, null);
    }

    @Override // e3.a
    float c() {
        return 1.0f;
    }

    @Override // e3.a
    public A h() {
        c<A> cVar = this.f25732e;
        A a10 = this.f25773i;
        return cVar.b(0.0f, 0.0f, a10, a10, f(), f(), f());
    }

    @Override // e3.a
    A i(a<K> aVar, float f10) {
        return h();
    }

    @Override // e3.a
    public void j() {
        if (this.f25732e != null) {
            super.j();
        }
    }

    @Override // e3.a
    public void l(float f10) {
        this.f25731d = f10;
    }

    public p(c<A> cVar, A a10) {
        super(Collections.emptyList());
        new b();
        m(cVar);
        this.f25773i = a10;
    }
}
