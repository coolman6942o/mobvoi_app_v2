package e3;

import java.util.List;
import k3.g;
import l3.a;
/* compiled from: FloatKeyframeAnimation.java */
/* loaded from: classes.dex */
public class c extends f<Float> {
    public c(List<a<Float>> list) {
        super(list);
    }

    public float o() {
        return p(b(), d());
    }

    float p(a<Float> aVar, float f10) {
        Float f11;
        if (aVar.f30404b == null || aVar.f30405c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        l3.c<A> cVar = this.f25732e;
        if (cVar == 0 || (f11 = (Float) cVar.b(aVar.f30407e, aVar.f30408f.floatValue(), aVar.f30404b, aVar.f30405c, f10, e(), f())) == null) {
            return g.j(aVar.f(), aVar.c(), f10);
        }
        return f11.floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public Float i(a<Float> aVar, float f10) {
        return Float.valueOf(p(aVar, f10));
    }
}
