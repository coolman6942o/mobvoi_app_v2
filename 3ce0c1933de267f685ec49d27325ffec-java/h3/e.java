package h3;

import android.graphics.PointF;
import e3.i;
import e3.j;
import java.util.List;
import l3.a;
/* compiled from: AnimatablePathValue.java */
/* loaded from: classes.dex */
public class e implements m<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<a<PointF>> f27712a;

    public e(List<a<PointF>> list) {
        this.f27712a = list;
    }

    @Override // h3.m
    public e3.a<PointF, PointF> a() {
        if (this.f27712a.get(0).h()) {
            return new j(this.f27712a);
        }
        return new i(this.f27712a);
    }

    @Override // h3.m
    public List<a<PointF>> b() {
        return this.f27712a;
    }

    @Override // h3.m
    public boolean c() {
        return this.f27712a.size() == 1 && this.f27712a.get(0).h();
    }
}
