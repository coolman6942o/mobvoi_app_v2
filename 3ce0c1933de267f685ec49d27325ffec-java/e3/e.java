package e3;

import java.util.List;
import k3.g;
import l3.a;
import l3.c;
/* compiled from: IntegerKeyframeAnimation.java */
/* loaded from: classes.dex */
public class e extends f<Integer> {
    public e(List<a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    int p(a<Integer> aVar, float f10) {
        Integer num;
        if (aVar.f30404b == null || aVar.f30405c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        c<A> cVar = this.f25732e;
        if (cVar == 0 || (num = (Integer) cVar.b(aVar.f30407e, aVar.f30408f.floatValue(), aVar.f30404b, aVar.f30405c, f10, e(), f())) == null) {
            return g.k(aVar.g(), aVar.d(), f10);
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public Integer i(a<Integer> aVar, float f10) {
        return Integer.valueOf(p(aVar, f10));
    }
}
