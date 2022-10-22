package e3;

import java.util.List;
import k3.g;
import l3.a;
import l3.c;
import l3.d;
/* compiled from: ScaleKeyframeAnimation.java */
/* loaded from: classes.dex */
public class k extends f<d> {

    /* renamed from: i  reason: collision with root package name */
    private final d f25753i = new d();

    public k(List<a<d>> list) {
        super(list);
    }

    /* renamed from: o */
    public d i(a<d> aVar, float f10) {
        d dVar;
        d dVar2;
        d dVar3 = aVar.f30404b;
        if (dVar3 == null || (dVar = aVar.f30405c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        d dVar4 = dVar3;
        d dVar5 = dVar;
        c<A> cVar = this.f25732e;
        if (cVar != 0 && (dVar2 = (d) cVar.b(aVar.f30407e, aVar.f30408f.floatValue(), dVar4, dVar5, f10, e(), f())) != null) {
            return dVar2;
        }
        this.f25753i.d(g.j(dVar4.b(), dVar5.b(), f10), g.j(dVar4.c(), dVar5.c(), f10));
        return this.f25753i;
    }
}
