package d3;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import e3.a;
import g3.d;
import java.util.List;
import k3.g;
import l3.c;
/* compiled from: EllipseContent.java */
/* loaded from: classes.dex */
public class f implements m, a.b, k {

    /* renamed from: b  reason: collision with root package name */
    private final String f25028b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.f f25029c;

    /* renamed from: d  reason: collision with root package name */
    private final a<?, PointF> f25030d;

    /* renamed from: e  reason: collision with root package name */
    private final a<?, PointF> f25031e;

    /* renamed from: f  reason: collision with root package name */
    private final i3.a f25032f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f25034h;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25027a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private b f25033g = new b();

    public f(com.airbnb.lottie.f fVar, com.airbnb.lottie.model.layer.a aVar, i3.a aVar2) {
        this.f25028b = aVar2.b();
        this.f25029c = fVar;
        a<PointF, PointF> a10 = aVar2.d().a();
        this.f25030d = a10;
        a<PointF, PointF> a11 = aVar2.c().a();
        this.f25031e = a11;
        this.f25032f = aVar2;
        aVar.j(a10);
        aVar.j(a11);
        a10.a(this);
        a11.a(this);
    }

    private void f() {
        this.f25034h = false;
        this.f25029c.invalidateSelf();
    }

    @Override // d3.m
    public Path a() {
        if (this.f25034h) {
            return this.f25027a;
        }
        this.f25027a.reset();
        if (this.f25032f.e()) {
            this.f25034h = true;
            return this.f25027a;
        }
        PointF h10 = this.f25030d.h();
        float f10 = h10.x / 2.0f;
        float f11 = h10.y / 2.0f;
        float f12 = f10 * 0.55228f;
        float f13 = 0.55228f * f11;
        this.f25027a.reset();
        if (this.f25032f.f()) {
            float f14 = -f11;
            this.f25027a.moveTo(0.0f, f14);
            float f15 = 0.0f - f12;
            float f16 = -f10;
            float f17 = 0.0f - f13;
            this.f25027a.cubicTo(f15, f14, f16, f17, f16, 0.0f);
            float f18 = f13 + 0.0f;
            this.f25027a.cubicTo(f16, f18, f15, f11, 0.0f, f11);
            float f19 = f12 + 0.0f;
            this.f25027a.cubicTo(f19, f11, f10, f18, f10, 0.0f);
            this.f25027a.cubicTo(f10, f17, f19, f14, 0.0f, f14);
        } else {
            float f20 = -f11;
            this.f25027a.moveTo(0.0f, f20);
            float f21 = f12 + 0.0f;
            float f22 = 0.0f - f13;
            this.f25027a.cubicTo(f21, f20, f10, f22, f10, 0.0f);
            float f23 = f13 + 0.0f;
            this.f25027a.cubicTo(f10, f23, f21, f11, 0.0f, f11);
            float f24 = 0.0f - f12;
            float f25 = -f10;
            this.f25027a.cubicTo(f24, f11, f25, f23, f25, 0.0f);
            this.f25027a.cubicTo(f25, f22, f24, f20, 0.0f, f20);
        }
        PointF h11 = this.f25031e.h();
        this.f25027a.offset(h11.x, h11.y);
        this.f25027a.close();
        this.f25033g.b(this.f25027a);
        this.f25034h = true;
        return this.f25027a;
    }

    @Override // e3.a.b
    public void b() {
        f();
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f25033g.a(sVar);
                    sVar.d(this);
                }
            }
        }
    }

    @Override // g3.e
    public <T> void d(T t10, c<T> cVar) {
        if (t10 == k.f6514g) {
            this.f25030d.m(cVar);
        } else if (t10 == k.f6517j) {
            this.f25031e.m(cVar);
        }
    }

    @Override // d3.c
    public String getName() {
        return this.f25028b;
    }

    @Override // g3.e
    public void h(d dVar, int i10, List<d> list, d dVar2) {
        g.l(dVar, i10, list, dVar2, this);
    }
}
