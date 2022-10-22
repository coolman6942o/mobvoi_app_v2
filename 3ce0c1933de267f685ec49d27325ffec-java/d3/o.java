package d3;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import e3.a;
import e3.c;
import g3.d;
import i3.e;
import java.util.List;
import k3.g;
/* compiled from: RectangleContent.java */
/* loaded from: classes.dex */
public class o implements a.b, k, m {

    /* renamed from: c  reason: collision with root package name */
    private final String f25097c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f25098d;

    /* renamed from: e  reason: collision with root package name */
    private final f f25099e;

    /* renamed from: f  reason: collision with root package name */
    private final a<?, PointF> f25100f;

    /* renamed from: g  reason: collision with root package name */
    private final a<?, PointF> f25101g;

    /* renamed from: h  reason: collision with root package name */
    private final a<?, Float> f25102h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f25104j;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25095a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f25096b = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private b f25103i = new b();

    public o(f fVar, com.airbnb.lottie.model.layer.a aVar, e eVar) {
        this.f25097c = eVar.c();
        this.f25098d = eVar.f();
        this.f25099e = fVar;
        a<PointF, PointF> a10 = eVar.d().a();
        this.f25100f = a10;
        a<PointF, PointF> a11 = eVar.e().a();
        this.f25101g = a11;
        a<Float, Float> a12 = eVar.b().a();
        this.f25102h = a12;
        aVar.j(a10);
        aVar.j(a11);
        aVar.j(a12);
        a10.a(this);
        a11.a(this);
        a12.a(this);
    }

    private void f() {
        this.f25104j = false;
        this.f25099e.invalidateSelf();
    }

    @Override // d3.m
    public Path a() {
        if (this.f25104j) {
            return this.f25095a;
        }
        this.f25095a.reset();
        if (this.f25098d) {
            this.f25104j = true;
            return this.f25095a;
        }
        PointF h10 = this.f25101g.h();
        float f10 = h10.x / 2.0f;
        float f11 = h10.y / 2.0f;
        a<?, Float> aVar = this.f25102h;
        float o10 = aVar == null ? 0.0f : ((c) aVar).o();
        float min = Math.min(f10, f11);
        if (o10 > min) {
            o10 = min;
        }
        PointF h11 = this.f25100f.h();
        this.f25095a.moveTo(h11.x + f10, (h11.y - f11) + o10);
        this.f25095a.lineTo(h11.x + f10, (h11.y + f11) - o10);
        int i10 = (o10 > 0.0f ? 1 : (o10 == 0.0f ? 0 : -1));
        if (i10 > 0) {
            RectF rectF = this.f25096b;
            float f12 = h11.x;
            float f13 = o10 * 2.0f;
            float f14 = h11.y;
            rectF.set((f12 + f10) - f13, (f14 + f11) - f13, f12 + f10, f14 + f11);
            this.f25095a.arcTo(this.f25096b, 0.0f, 90.0f, false);
        }
        this.f25095a.lineTo((h11.x - f10) + o10, h11.y + f11);
        if (i10 > 0) {
            RectF rectF2 = this.f25096b;
            float f15 = h11.x;
            float f16 = h11.y;
            float f17 = o10 * 2.0f;
            rectF2.set(f15 - f10, (f16 + f11) - f17, (f15 - f10) + f17, f16 + f11);
            this.f25095a.arcTo(this.f25096b, 90.0f, 90.0f, false);
        }
        this.f25095a.lineTo(h11.x - f10, (h11.y - f11) + o10);
        if (i10 > 0) {
            RectF rectF3 = this.f25096b;
            float f18 = h11.x;
            float f19 = h11.y;
            float f20 = o10 * 2.0f;
            rectF3.set(f18 - f10, f19 - f11, (f18 - f10) + f20, (f19 - f11) + f20);
            this.f25095a.arcTo(this.f25096b, 180.0f, 90.0f, false);
        }
        this.f25095a.lineTo((h11.x + f10) - o10, h11.y - f11);
        if (i10 > 0) {
            RectF rectF4 = this.f25096b;
            float f21 = h11.x;
            float f22 = o10 * 2.0f;
            float f23 = h11.y;
            rectF4.set((f21 + f10) - f22, f23 - f11, f21 + f10, (f23 - f11) + f22);
            this.f25095a.arcTo(this.f25096b, 270.0f, 90.0f, false);
        }
        this.f25095a.close();
        this.f25103i.b(this.f25095a);
        this.f25104j = true;
        return this.f25095a;
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
                    this.f25103i.a(sVar);
                    sVar.d(this);
                }
            }
        }
    }

    @Override // g3.e
    public <T> void d(T t10, l3.c<T> cVar) {
        if (t10 == k.f6515h) {
            this.f25101g.m(cVar);
        } else if (t10 == k.f6517j) {
            this.f25100f.m(cVar);
        } else if (t10 == k.f6516i) {
            this.f25102h.m(cVar);
        }
    }

    @Override // d3.c
    public String getName() {
        return this.f25097c;
    }

    @Override // g3.e
    public void h(d dVar, int i10, List<d> list, d dVar2) {
        g.l(dVar, i10, list, dVar2, this);
    }
}
