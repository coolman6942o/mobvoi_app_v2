package e3;

import android.graphics.PointF;
import java.util.List;
import l3.a;
import l3.c;
/* compiled from: PointKeyframeAnimation.java */
/* loaded from: classes.dex */
public class j extends f<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f25752i = new PointF();

    public j(List<a<PointF>> list) {
        super(list);
    }

    /* renamed from: o */
    public PointF i(a<PointF> aVar, float f10) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = aVar.f30404b;
        if (pointF3 == null || (pointF = aVar.f30405c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF4 = pointF3;
        PointF pointF5 = pointF;
        c<A> cVar = this.f25732e;
        if (cVar != 0 && (pointF2 = (PointF) cVar.b(aVar.f30407e, aVar.f30408f.floatValue(), pointF4, pointF5, f10, e(), f())) != null) {
            return pointF2;
        }
        PointF pointF6 = this.f25752i;
        float f11 = pointF4.x;
        float f12 = pointF4.y;
        pointF6.set(f11 + ((pointF5.x - f11) * f10), f12 + (f10 * (pointF5.y - f12)));
        return this.f25752i;
    }
}
