package d3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.a;
import e3.b;
import e3.p;
import l3.c;
/* compiled from: StrokeContent.java */
/* loaded from: classes.dex */
public class r extends a {

    /* renamed from: o  reason: collision with root package name */
    private final a f25121o;

    /* renamed from: p  reason: collision with root package name */
    private final String f25122p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f25123q;

    /* renamed from: r  reason: collision with root package name */
    private final e3.a<Integer, Integer> f25124r;

    /* renamed from: s  reason: collision with root package name */
    private e3.a<ColorFilter, ColorFilter> f25125s;

    public r(f fVar, a aVar, ShapeStroke shapeStroke) {
        super(fVar, aVar, shapeStroke.b().toPaintCap(), shapeStroke.e().toPaintJoin(), shapeStroke.g(), shapeStroke.i(), shapeStroke.j(), shapeStroke.f(), shapeStroke.d());
        this.f25121o = aVar;
        this.f25122p = shapeStroke.h();
        this.f25123q = shapeStroke.k();
        e3.a<Integer, Integer> a10 = shapeStroke.c().a();
        this.f25124r = a10;
        a10.a(this);
        aVar.j(a10);
    }

    @Override // d3.a, g3.e
    public <T> void d(T t10, c<T> cVar) {
        super.d(t10, cVar);
        if (t10 == k.f6509b) {
            this.f25124r.m(cVar);
        } else if (t10 == k.C) {
            e3.a<ColorFilter, ColorFilter> aVar = this.f25125s;
            if (aVar != null) {
                this.f25121o.D(aVar);
            }
            if (cVar == null) {
                this.f25125s = null;
                return;
            }
            p pVar = new p(cVar);
            this.f25125s = pVar;
            pVar.a(this);
            this.f25121o.j(this.f25124r);
        }
    }

    @Override // d3.a, d3.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (!this.f25123q) {
            this.f25007i.setColor(((b) this.f25124r).o());
            e3.a<ColorFilter, ColorFilter> aVar = this.f25125s;
            if (aVar != null) {
                this.f25007i.setColorFilter(aVar.h());
            }
            super.g(canvas, matrix, i10);
        }
    }

    @Override // d3.c
    public String getName() {
        return this.f25122p;
    }
}
