package e3;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import java.util.List;
import l3.a;
import l3.c;
/* compiled from: PathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class i extends f<PointF> {

    /* renamed from: k  reason: collision with root package name */
    private h f25750k;

    /* renamed from: i  reason: collision with root package name */
    private final PointF f25748i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private final float[] f25749j = new float[2];

    /* renamed from: l  reason: collision with root package name */
    private PathMeasure f25751l = new PathMeasure();

    public i(List<? extends a<PointF>> list) {
        super(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: o */
    public PointF i(a<PointF> aVar, float f10) {
        PointF pointF;
        h hVar = (h) aVar;
        Path j10 = hVar.j();
        if (j10 == null) {
            return aVar.f30404b;
        }
        c<A> cVar = this.f25732e;
        if (cVar != 0 && (pointF = (PointF) cVar.b(hVar.f30407e, hVar.f30408f.floatValue(), hVar.f30404b, hVar.f30405c, e(), f10, f())) != null) {
            return pointF;
        }
        if (this.f25750k != hVar) {
            this.f25751l.setPath(j10, false);
            this.f25750k = hVar;
        }
        PathMeasure pathMeasure = this.f25751l;
        pathMeasure.getPosTan(f10 * pathMeasure.getLength(), this.f25749j, null);
        PointF pointF2 = this.f25748i;
        float[] fArr = this.f25749j;
        pointF2.set(fArr[0], fArr[1]);
        return this.f25748i;
    }
}
