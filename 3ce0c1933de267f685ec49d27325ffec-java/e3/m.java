package e3;

import android.graphics.PointF;
import java.util.Collections;
import l3.a;
/* compiled from: SplitDimensionPathKeyframeAnimation.java */
/* loaded from: classes.dex */
public class m extends a<PointF, PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f25756i = new PointF();

    /* renamed from: j  reason: collision with root package name */
    private final a<Float, Float> f25757j;

    /* renamed from: k  reason: collision with root package name */
    private final a<Float, Float> f25758k;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.f25757j = aVar;
        this.f25758k = aVar2;
        l(f());
    }

    @Override // e3.a
    public void l(float f10) {
        this.f25757j.l(f10);
        this.f25758k.l(f10);
        this.f25756i.set(this.f25757j.h().floatValue(), this.f25758k.h().floatValue());
        for (int i10 = 0; i10 < this.f25728a.size(); i10++) {
            this.f25728a.get(i10).b();
        }
    }

    /* renamed from: o */
    public PointF h() {
        return i(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public PointF i(a<PointF> aVar, float f10) {
        return this.f25756i;
    }
}
