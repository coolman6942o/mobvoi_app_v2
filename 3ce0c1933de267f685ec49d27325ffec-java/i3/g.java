package i3;

import android.graphics.PointF;
import g3.a;
import java.util.ArrayList;
import java.util.List;
import k3.d;
/* compiled from: ShapeData.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f28047a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f28048b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f28049c;

    public g(PointF pointF, boolean z10, List<a> list) {
        this.f28048b = pointF;
        this.f28049c = z10;
        this.f28047a = new ArrayList(list);
    }

    private void e(float f10, float f11) {
        if (this.f28048b == null) {
            this.f28048b = new PointF();
        }
        this.f28048b.set(f10, f11);
    }

    public List<a> a() {
        return this.f28047a;
    }

    public PointF b() {
        return this.f28048b;
    }

    public void c(g gVar, g gVar2, float f10) {
        if (this.f28048b == null) {
            this.f28048b = new PointF();
        }
        this.f28049c = gVar.d() || gVar2.d();
        if (gVar.a().size() != gVar2.a().size()) {
            d.c("Curves must have the same number of control points. Shape 1: " + gVar.a().size() + "\tShape 2: " + gVar2.a().size());
        }
        int min = Math.min(gVar.a().size(), gVar2.a().size());
        if (this.f28047a.size() < min) {
            for (int size = this.f28047a.size(); size < min; size++) {
                this.f28047a.add(new a());
            }
        } else if (this.f28047a.size() > min) {
            for (int size2 = this.f28047a.size() - 1; size2 >= min; size2--) {
                List<a> list = this.f28047a;
                list.remove(list.size() - 1);
            }
        }
        PointF b10 = gVar.b();
        PointF b11 = gVar2.b();
        e(k3.g.j(b10.x, b11.x, f10), k3.g.j(b10.y, b11.y, f10));
        for (int size3 = this.f28047a.size() - 1; size3 >= 0; size3--) {
            a aVar = gVar.a().get(size3);
            a aVar2 = gVar2.a().get(size3);
            PointF a10 = aVar.a();
            PointF b12 = aVar.b();
            PointF c10 = aVar.c();
            PointF a11 = aVar2.a();
            PointF b13 = aVar2.b();
            PointF c11 = aVar2.c();
            this.f28047a.get(size3).d(k3.g.j(a10.x, a11.x, f10), k3.g.j(a10.y, a11.y, f10));
            this.f28047a.get(size3).e(k3.g.j(b12.x, b13.x, f10), k3.g.j(b12.y, b13.y, f10));
            this.f28047a.get(size3).f(k3.g.j(c10.x, c11.x, f10), k3.g.j(c10.y, c11.y, f10));
        }
    }

    public boolean d() {
        return this.f28049c;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f28047a.size() + "closed=" + this.f28049c + '}';
    }

    public g() {
        this.f28047a = new ArrayList();
    }
}
