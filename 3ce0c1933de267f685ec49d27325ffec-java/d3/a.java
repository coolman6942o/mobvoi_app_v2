package d3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.airbnb.lottie.c;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import e3.a;
import e3.e;
import e3.p;
import h3.d;
import java.util.ArrayList;
import java.util.List;
import k3.g;
import k3.h;
/* compiled from: BaseStrokeContent.java */
/* loaded from: classes.dex */
public abstract class a implements a.b, k, e {

    /* renamed from: e  reason: collision with root package name */
    private final f f25003e;

    /* renamed from: f  reason: collision with root package name */
    protected final com.airbnb.lottie.model.layer.a f25004f;

    /* renamed from: h  reason: collision with root package name */
    private final float[] f25006h;

    /* renamed from: i  reason: collision with root package name */
    final Paint f25007i;

    /* renamed from: j  reason: collision with root package name */
    private final e3.a<?, Float> f25008j;

    /* renamed from: k  reason: collision with root package name */
    private final e3.a<?, Integer> f25009k;

    /* renamed from: l  reason: collision with root package name */
    private final List<e3.a<?, Float>> f25010l;

    /* renamed from: m  reason: collision with root package name */
    private final e3.a<?, Float> f25011m;

    /* renamed from: n  reason: collision with root package name */
    private e3.a<ColorFilter, ColorFilter> f25012n;

    /* renamed from: a  reason: collision with root package name */
    private final PathMeasure f24999a = new PathMeasure();

    /* renamed from: b  reason: collision with root package name */
    private final Path f25000b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final Path f25001c = new Path();

    /* renamed from: d  reason: collision with root package name */
    private final RectF f25002d = new RectF();

    /* renamed from: g  reason: collision with root package name */
    private final List<b> f25005g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BaseStrokeContent.java */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<m> f25013a;

        /* renamed from: b  reason: collision with root package name */
        private final s f25014b;

        private b(s sVar) {
            this.f25013a = new ArrayList();
            this.f25014b = sVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f fVar, com.airbnb.lottie.model.layer.a aVar, Paint.Cap cap, Paint.Join join, float f10, d dVar, h3.b bVar, List<h3.b> list, h3.b bVar2) {
        c3.a aVar2 = new c3.a(1);
        this.f25007i = aVar2;
        this.f25003e = fVar;
        this.f25004f = aVar;
        aVar2.setStyle(Paint.Style.STROKE);
        aVar2.setStrokeCap(cap);
        aVar2.setStrokeJoin(join);
        aVar2.setStrokeMiter(f10);
        this.f25009k = dVar.a();
        this.f25008j = bVar.a();
        if (bVar2 == null) {
            this.f25011m = null;
        } else {
            this.f25011m = bVar2.a();
        }
        this.f25010l = new ArrayList(list.size());
        this.f25006h = new float[list.size()];
        for (int i10 = 0; i10 < list.size(); i10++) {
            this.f25010l.add(list.get(i10).a());
        }
        aVar.j(this.f25009k);
        aVar.j(this.f25008j);
        for (int i11 = 0; i11 < this.f25010l.size(); i11++) {
            aVar.j(this.f25010l.get(i11));
        }
        e3.a<?, Float> aVar3 = this.f25011m;
        if (aVar3 != null) {
            aVar.j(aVar3);
        }
        this.f25009k.a(this);
        this.f25008j.a(this);
        for (int i12 = 0; i12 < list.size(); i12++) {
            this.f25010l.get(i12).a(this);
        }
        e3.a<?, Float> aVar4 = this.f25011m;
        if (aVar4 != null) {
            aVar4.a(this);
        }
    }

    private void f(Matrix matrix) {
        c.a("StrokeContent#applyDashPattern");
        if (this.f25010l.isEmpty()) {
            c.b("StrokeContent#applyDashPattern");
            return;
        }
        float g10 = h.g(matrix);
        for (int i10 = 0; i10 < this.f25010l.size(); i10++) {
            this.f25006h[i10] = this.f25010l.get(i10).h().floatValue();
            if (i10 % 2 == 0) {
                float[] fArr = this.f25006h;
                if (fArr[i10] < 1.0f) {
                    fArr[i10] = 1.0f;
                }
            } else {
                float[] fArr2 = this.f25006h;
                if (fArr2[i10] < 0.1f) {
                    fArr2[i10] = 0.1f;
                }
            }
            float[] fArr3 = this.f25006h;
            fArr3[i10] = fArr3[i10] * g10;
        }
        e3.a<?, Float> aVar = this.f25011m;
        this.f25007i.setPathEffect(new DashPathEffect(this.f25006h, aVar == null ? 0.0f : g10 * aVar.h().floatValue()));
        c.b("StrokeContent#applyDashPattern");
    }

    private void i(Canvas canvas, b bVar, Matrix matrix) {
        c.a("StrokeContent#applyTrimPath");
        if (bVar.f25014b == null) {
            c.b("StrokeContent#applyTrimPath");
            return;
        }
        this.f25000b.reset();
        for (int size = bVar.f25013a.size() - 1; size >= 0; size--) {
            this.f25000b.addPath(((m) bVar.f25013a.get(size)).a(), matrix);
        }
        this.f24999a.setPath(this.f25000b, false);
        float length = this.f24999a.getLength();
        while (this.f24999a.nextContour()) {
            length += this.f24999a.getLength();
        }
        float floatValue = (bVar.f25014b.h().h().floatValue() * length) / 360.0f;
        float floatValue2 = ((bVar.f25014b.i().h().floatValue() * length) / 100.0f) + floatValue;
        float floatValue3 = ((bVar.f25014b.f().h().floatValue() * length) / 100.0f) + floatValue;
        float f10 = 0.0f;
        for (int size2 = bVar.f25013a.size() - 1; size2 >= 0; size2--) {
            this.f25001c.set(((m) bVar.f25013a.get(size2)).a());
            this.f25001c.transform(matrix);
            this.f24999a.setPath(this.f25001c, false);
            float length2 = this.f24999a.getLength();
            float f11 = 1.0f;
            if (floatValue3 > length) {
                float f12 = floatValue3 - length;
                if (f12 < f10 + length2 && f10 < f12) {
                    h.a(this.f25001c, floatValue2 > length ? (floatValue2 - length) / length2 : 0.0f, Math.min(f12 / length2, 1.0f), 0.0f);
                    canvas.drawPath(this.f25001c, this.f25007i);
                    f10 += length2;
                }
            }
            float f13 = f10 + length2;
            if (f13 >= floatValue2 && f10 <= floatValue3) {
                if (f13 > floatValue3 || floatValue2 >= f10) {
                    float f14 = floatValue2 < f10 ? 0.0f : (floatValue2 - f10) / length2;
                    if (floatValue3 <= f13) {
                        f11 = (floatValue3 - f10) / length2;
                    }
                    h.a(this.f25001c, f14, f11, 0.0f);
                    canvas.drawPath(this.f25001c, this.f25007i);
                } else {
                    canvas.drawPath(this.f25001c, this.f25007i);
                }
            }
            f10 += length2;
        }
        c.b("StrokeContent#applyTrimPath");
    }

    @Override // e3.a.b
    public void b() {
        this.f25003e.invalidateSelf();
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
        s sVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof s) {
                s sVar2 = (s) cVar;
                if (sVar2.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    sVar = sVar2;
                }
            }
        }
        if (sVar != null) {
            sVar.d(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            c cVar2 = list2.get(size2);
            if (cVar2 instanceof s) {
                s sVar3 = (s) cVar2;
                if (sVar3.j() == ShapeTrimPath.Type.INDIVIDUALLY) {
                    if (bVar != null) {
                        this.f25005g.add(bVar);
                    }
                    bVar = new b(sVar3);
                    sVar3.d(this);
                }
            }
            if (cVar2 instanceof m) {
                if (bVar == null) {
                    bVar = new b(sVar);
                }
                bVar.f25013a.add((m) cVar2);
            }
        }
        if (bVar != null) {
            this.f25005g.add(bVar);
        }
    }

    @Override // g3.e
    public <T> void d(T t10, l3.c<T> cVar) {
        if (t10 == k.f6511d) {
            this.f25009k.m(cVar);
        } else if (t10 == k.f6522o) {
            this.f25008j.m(cVar);
        } else if (t10 == k.C) {
            e3.a<ColorFilter, ColorFilter> aVar = this.f25012n;
            if (aVar != null) {
                this.f25004f.D(aVar);
            }
            if (cVar == null) {
                this.f25012n = null;
                return;
            }
            p pVar = new p(cVar);
            this.f25012n = pVar;
            pVar.a(this);
            this.f25004f.j(this.f25012n);
        }
    }

    @Override // d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        c.a("StrokeContent#getBounds");
        this.f25000b.reset();
        for (int i10 = 0; i10 < this.f25005g.size(); i10++) {
            b bVar = this.f25005g.get(i10);
            for (int i11 = 0; i11 < bVar.f25013a.size(); i11++) {
                this.f25000b.addPath(((m) bVar.f25013a.get(i11)).a(), matrix);
            }
        }
        this.f25000b.computeBounds(this.f25002d, false);
        float o10 = ((e3.c) this.f25008j).o();
        RectF rectF2 = this.f25002d;
        float f10 = o10 / 2.0f;
        rectF2.set(rectF2.left - f10, rectF2.top - f10, rectF2.right + f10, rectF2.bottom + f10);
        rectF.set(this.f25002d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        c.b("StrokeContent#getBounds");
    }

    @Override // d3.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        c.a("StrokeContent#draw");
        if (h.h(matrix)) {
            c.b("StrokeContent#draw");
            return;
        }
        this.f25007i.setAlpha(g.c((int) ((((i10 / 255.0f) * ((e) this.f25009k).o()) / 100.0f) * 255.0f), 0, 255));
        this.f25007i.setStrokeWidth(((e3.c) this.f25008j).o() * h.g(matrix));
        if (this.f25007i.getStrokeWidth() <= 0.0f) {
            c.b("StrokeContent#draw");
            return;
        }
        f(matrix);
        e3.a<ColorFilter, ColorFilter> aVar = this.f25012n;
        if (aVar != null) {
            this.f25007i.setColorFilter(aVar.h());
        }
        for (int i11 = 0; i11 < this.f25005g.size(); i11++) {
            b bVar = this.f25005g.get(i11);
            if (bVar.f25014b != null) {
                i(canvas, bVar, matrix);
            } else {
                c.a("StrokeContent#buildPath");
                this.f25000b.reset();
                for (int size = bVar.f25013a.size() - 1; size >= 0; size--) {
                    this.f25000b.addPath(((m) bVar.f25013a.get(size)).a(), matrix);
                }
                c.b("StrokeContent#buildPath");
                c.a("StrokeContent#drawPath");
                canvas.drawPath(this.f25000b, this.f25007i);
                c.b("StrokeContent#drawPath");
            }
        }
        c.b("StrokeContent#draw");
    }

    @Override // g3.e
    public void h(g3.d dVar, int i10, List<g3.d> list, g3.d dVar2) {
        g.l(dVar, i10, list, dVar2, this);
    }
}
