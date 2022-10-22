package e3;

import java.util.List;
import k3.g;
import l3.a;
import l3.c;
/* compiled from: ColorKeyframeAnimation.java */
/* loaded from: classes.dex */
public class b extends f<Integer> {
    public b(List<a<Integer>> list) {
        super(list);
    }

    public int o() {
        return p(b(), d());
    }

    public int p(a<Integer> aVar, float f10) {
        Integer num;
        Integer num2 = aVar.f30404b;
        if (num2 == null || aVar.f30405c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        int intValue = num2.intValue();
        int intValue2 = aVar.f30405c.intValue();
        c<A> cVar = this.f25732e;
        if (cVar == 0 || (num = (Integer) cVar.b(aVar.f30407e, aVar.f30408f.floatValue(), Integer.valueOf(intValue), Integer.valueOf(intValue2), f10, e(), f())) == null) {
            return k3.b.c(g.b(f10, 0.0f, 1.0f), intValue, intValue2);
        }
        return num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public Integer i(a<Integer> aVar, float f10) {
        return Integer.valueOf(p(aVar, f10));
    }
}
