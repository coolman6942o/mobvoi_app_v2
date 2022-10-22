package e3;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.d;
import l3.a;
/* compiled from: PathKeyframe.java */
/* loaded from: classes.dex */
public class h extends a<PointF> {

    /* renamed from: o  reason: collision with root package name */
    private Path f25746o;

    /* renamed from: p  reason: collision with root package name */
    private final a<PointF> f25747p;

    public h(d dVar, a<PointF> aVar) {
        super(dVar, aVar.f30404b, aVar.f30405c, aVar.f30406d, aVar.f30407e, aVar.f30408f);
        this.f25747p = aVar;
        i();
    }

    public void i() {
        T t10;
        T t11 = this.f30405c;
        boolean z10 = (t11 == 0 || (t10 = this.f30404b) == 0 || !((PointF) t10).equals(((PointF) t11).x, ((PointF) t11).y)) ? false : true;
        T t12 = this.f30405c;
        if (t12 != 0 && !z10) {
            a<PointF> aVar = this.f25747p;
            this.f25746o = k3.h.d((PointF) this.f30404b, (PointF) t12, aVar.f30415m, aVar.f30416n);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path j() {
        return this.f25746o;
    }
}
