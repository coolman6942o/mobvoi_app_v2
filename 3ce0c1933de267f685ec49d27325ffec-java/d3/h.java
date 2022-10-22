package d3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.GradientType;
import e3.a;
import e3.p;
import i3.c;
import java.util.ArrayList;
import java.util.List;
import k3.g;
/* compiled from: GradientFillContent.java */
/* loaded from: classes.dex */
public class h implements e, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final String f25045a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f25046b;

    /* renamed from: c  reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f25047c;

    /* renamed from: f  reason: collision with root package name */
    private final Path f25050f;

    /* renamed from: j  reason: collision with root package name */
    private final GradientType f25054j;

    /* renamed from: k  reason: collision with root package name */
    private final a<c, c> f25055k;

    /* renamed from: l  reason: collision with root package name */
    private final a<Integer, Integer> f25056l;

    /* renamed from: m  reason: collision with root package name */
    private final a<PointF, PointF> f25057m;

    /* renamed from: n  reason: collision with root package name */
    private final a<PointF, PointF> f25058n;

    /* renamed from: o  reason: collision with root package name */
    private a<ColorFilter, ColorFilter> f25059o;

    /* renamed from: p  reason: collision with root package name */
    private p f25060p;

    /* renamed from: q  reason: collision with root package name */
    private final f f25061q;

    /* renamed from: r  reason: collision with root package name */
    private final int f25062r;

    /* renamed from: d  reason: collision with root package name */
    private final d<LinearGradient> f25048d = new d<>();

    /* renamed from: e  reason: collision with root package name */
    private final d<RadialGradient> f25049e = new d<>();

    /* renamed from: g  reason: collision with root package name */
    private final Paint f25051g = new c3.a(1);

    /* renamed from: h  reason: collision with root package name */
    private final RectF f25052h = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private final List<m> f25053i = new ArrayList();

    public h(f fVar, com.airbnb.lottie.model.layer.a aVar, i3.d dVar) {
        Path path = new Path();
        this.f25050f = path;
        this.f25047c = aVar;
        this.f25045a = dVar.f();
        this.f25046b = dVar.i();
        this.f25061q = fVar;
        this.f25054j = dVar.e();
        path.setFillType(dVar.c());
        this.f25062r = (int) (fVar.m().d() / 32.0f);
        a<c, c> a10 = dVar.d().a();
        this.f25055k = a10;
        a10.a(this);
        aVar.j(a10);
        a<Integer, Integer> a11 = dVar.g().a();
        this.f25056l = a11;
        a11.a(this);
        aVar.j(a11);
        a<PointF, PointF> a12 = dVar.h().a();
        this.f25057m = a12;
        a12.a(this);
        aVar.j(a12);
        a<PointF, PointF> a13 = dVar.b().a();
        this.f25058n = a13;
        a13.a(this);
        aVar.j(a13);
    }

    private int[] f(int[] iArr) {
        p pVar = this.f25060p;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.h();
            int i10 = 0;
            if (iArr.length == numArr.length) {
                while (i10 < iArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i10 < numArr.length) {
                    iArr[i10] = numArr[i10].intValue();
                    i10++;
                }
            }
        }
        return iArr;
    }

    private int i() {
        int round = Math.round(this.f25057m.f() * this.f25062r);
        int round2 = Math.round(this.f25058n.f() * this.f25062r);
        int round3 = Math.round(this.f25055k.f() * this.f25062r);
        int i10 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i10 = i10 * 31 * round2;
        }
        return round3 != 0 ? i10 * 31 * round3 : i10;
    }

    private LinearGradient j() {
        long i10 = i();
        LinearGradient f10 = this.f25048d.f(i10);
        if (f10 != null) {
            return f10;
        }
        PointF h10 = this.f25057m.h();
        PointF h11 = this.f25058n.h();
        c h12 = this.f25055k.h();
        LinearGradient linearGradient = new LinearGradient(h10.x, h10.y, h11.x, h11.y, f(h12.a()), h12.b(), Shader.TileMode.CLAMP);
        this.f25048d.k(i10, linearGradient);
        return linearGradient;
    }

    private RadialGradient k() {
        long i10 = i();
        RadialGradient f10 = this.f25049e.f(i10);
        if (f10 != null) {
            return f10;
        }
        PointF h10 = this.f25057m.h();
        PointF h11 = this.f25058n.h();
        c h12 = this.f25055k.h();
        int[] f11 = f(h12.a());
        float[] b10 = h12.b();
        float f12 = h10.x;
        float f13 = h10.y;
        float hypot = (float) Math.hypot(h11.x - f12, h11.y - f13);
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient = new RadialGradient(f12, f13, hypot, f11, b10, Shader.TileMode.CLAMP);
        this.f25049e.k(i10, radialGradient);
        return radialGradient;
    }

    @Override // e3.a.b
    public void b() {
        this.f25061q.invalidateSelf();
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list2.size(); i10++) {
            c cVar = list2.get(i10);
            if (cVar instanceof m) {
                this.f25053i.add((m) cVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // g3.e
    public <T> void d(T t10, l3.c<T> cVar) {
        if (t10 == k.f6511d) {
            this.f25056l.m(cVar);
        } else if (t10 == k.C) {
            a<ColorFilter, ColorFilter> aVar = this.f25059o;
            if (aVar != null) {
                this.f25047c.D(aVar);
            }
            if (cVar == null) {
                this.f25059o = null;
                return;
            }
            p pVar = new p(cVar);
            this.f25059o = pVar;
            pVar.a(this);
            this.f25047c.j(this.f25059o);
        } else if (t10 == k.D) {
            p pVar2 = this.f25060p;
            if (pVar2 != null) {
                this.f25047c.D(pVar2);
            }
            if (cVar == null) {
                this.f25060p = null;
                return;
            }
            p pVar3 = new p(cVar);
            this.f25060p = pVar3;
            pVar3.a(this);
            this.f25047c.j(this.f25060p);
        }
    }

    @Override // d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f25050f.reset();
        for (int i10 = 0; i10 < this.f25053i.size(); i10++) {
            this.f25050f.addPath(this.f25053i.get(i10).a(), matrix);
        }
        this.f25050f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // d3.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        Shader shader;
        if (!this.f25046b) {
            com.airbnb.lottie.c.a("GradientFillContent#draw");
            this.f25050f.reset();
            for (int i11 = 0; i11 < this.f25053i.size(); i11++) {
                this.f25050f.addPath(this.f25053i.get(i11).a(), matrix);
            }
            this.f25050f.computeBounds(this.f25052h, false);
            if (this.f25054j == GradientType.LINEAR) {
                shader = j();
            } else {
                shader = k();
            }
            shader.setLocalMatrix(matrix);
            this.f25051g.setShader(shader);
            a<ColorFilter, ColorFilter> aVar = this.f25059o;
            if (aVar != null) {
                this.f25051g.setColorFilter(aVar.h());
            }
            this.f25051g.setAlpha(g.c((int) ((((i10 / 255.0f) * this.f25056l.h().intValue()) / 100.0f) * 255.0f), 0, 255));
            canvas.drawPath(this.f25050f, this.f25051g);
            com.airbnb.lottie.c.b("GradientFillContent#draw");
        }
    }

    @Override // d3.c
    public String getName() {
        return this.f25045a;
    }

    @Override // g3.e
    public void h(g3.d dVar, int i10, List<g3.d> list, g3.d dVar2) {
        g.l(dVar, i10, list, dVar2, this);
    }
}
