package h3;

import android.graphics.PointF;
import e3.a;
import e3.m;
import java.util.List;
/* compiled from: AnimatableSplitDimensionPathValue.java */
/* loaded from: classes.dex */
public class i implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final b f27713a;

    /* renamed from: b  reason: collision with root package name */
    private final b f27714b;

    public i(b bVar, b bVar2) {
        this.f27713a = bVar;
        this.f27714b = bVar2;
    }

    @Override // h3.m
    public a<PointF, PointF> a() {
        return new m(this.f27713a.a(), this.f27714b.a());
    }

    @Override // h3.m
    public List<l3.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // h3.m
    public boolean c() {
        return this.f27713a.c() && this.f27714b.c();
    }
}
