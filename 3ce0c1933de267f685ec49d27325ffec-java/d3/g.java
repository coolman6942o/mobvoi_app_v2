package d3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import e3.a;
import e3.b;
import e3.p;
import g3.d;
import i3.h;
import java.util.ArrayList;
import java.util.List;
import l3.c;
/* compiled from: FillContent.java */
/* loaded from: classes.dex */
public class g implements e, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Path f25035a;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f25037c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25038d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25039e;

    /* renamed from: g  reason: collision with root package name */
    private final a<Integer, Integer> f25041g;

    /* renamed from: h  reason: collision with root package name */
    private final a<Integer, Integer> f25042h;

    /* renamed from: i  reason: collision with root package name */
    private a<ColorFilter, ColorFilter> f25043i;

    /* renamed from: j  reason: collision with root package name */
    private final f f25044j;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f25036b = new c3.a(1);

    /* renamed from: f  reason: collision with root package name */
    private final List<m> f25040f = new ArrayList();

    public g(f fVar, com.airbnb.lottie.model.layer.a aVar, h hVar) {
        Path path = new Path();
        this.f25035a = path;
        this.f25037c = aVar;
        this.f25038d = hVar.d();
        this.f25039e = hVar.f();
        this.f25044j = fVar;
        if (hVar.b() == null || hVar.e() == null) {
            this.f25041g = null;
            this.f25042h = null;
            return;
        }
        path.setFillType(hVar.c());
        a<Integer, Integer> a10 = hVar.b().a();
        this.f25041g = a10;
        a10.a(this);
        aVar.j(a10);
        a<Integer, Integer> a11 = hVar.e().a();
        this.f25042h = a11;
        a11.a(this);
        aVar.j(a11);
    }

    @Override // e3.a.b
    public void b() {
        this.f25044j.invalidateSelf();
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = list2.get(i10);
            if (cVar instanceof m) {
                this.f25040f.add((m) cVar);
            }
        }
    }

    @Override // g3.e
    public <T> void d(T t10, c<T> cVar) {
        if (t10 == k.f6508a) {
            this.f25041g.m(cVar);
        } else if (t10 == k.f6511d) {
            this.f25042h.m(cVar);
        } else if (t10 == k.C) {
            a<ColorFilter, ColorFilter> aVar = this.f25043i;
            if (aVar != null) {
                this.f25037c.D(aVar);
            }
            if (cVar == null) {
                this.f25043i = null;
                return;
            }
            p pVar = new p(cVar);
            this.f25043i = pVar;
            pVar.a(this);
            this.f25037c.j(this.f25043i);
        }
    }

    @Override // d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f25035a.reset();
        for (int i10 = 0; i10 < this.f25040f.size(); i10++) {
            this.f25035a.addPath(this.f25040f.get(i10).a(), matrix);
        }
        this.f25035a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // d3.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (!this.f25039e) {
            com.airbnb.lottie.c.a("FillContent#draw");
            this.f25036b.setColor(((b) this.f25041g).o());
            this.f25036b.setAlpha(k3.g.c((int) ((((i10 / 255.0f) * this.f25042h.h().intValue()) / 100.0f) * 255.0f), 0, 255));
            a<ColorFilter, ColorFilter> aVar = this.f25043i;
            if (aVar != null) {
                this.f25036b.setColorFilter(aVar.h());
            }
            this.f25035a.reset();
            for (int i11 = 0; i11 < this.f25040f.size(); i11++) {
                this.f25035a.addPath(this.f25040f.get(i11).a(), matrix);
            }
            canvas.drawPath(this.f25035a, this.f25036b);
            com.airbnb.lottie.c.b("FillContent#draw");
        }
    }

    @Override // d3.c
    public String getName() {
        return this.f25038d;
    }

    @Override // g3.e
    public void h(d dVar, int i10, List<d> list, d dVar2) {
        k3.g.l(dVar, i10, list, dVar2, this);
    }
}
