package d3;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
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
/* compiled from: GradientStrokeContent.java */
/* loaded from: classes.dex */
public class i extends a {

    /* renamed from: o  reason: collision with root package name */
    private final String f25063o;

    /* renamed from: p  reason: collision with root package name */
    private final boolean f25064p;

    /* renamed from: q  reason: collision with root package name */
    private final d<LinearGradient> f25065q = new d<>();

    /* renamed from: r  reason: collision with root package name */
    private final d<RadialGradient> f25066r = new d<>();

    /* renamed from: s  reason: collision with root package name */
    private final RectF f25067s = new RectF();

    /* renamed from: t  reason: collision with root package name */
    private final GradientType f25068t;

    /* renamed from: u  reason: collision with root package name */
    private final int f25069u;

    /* renamed from: v  reason: collision with root package name */
    private final a<c, c> f25070v;

    /* renamed from: w  reason: collision with root package name */
    private final a<PointF, PointF> f25071w;

    /* renamed from: x  reason: collision with root package name */
    private final a<PointF, PointF> f25072x;

    /* renamed from: y  reason: collision with root package name */
    private p f25073y;

    public i(f fVar, com.airbnb.lottie.model.layer.a aVar, com.airbnb.lottie.model.content.a aVar2) {
        super(fVar, aVar, aVar2.b().toPaintCap(), aVar2.g().toPaintJoin(), aVar2.i(), aVar2.k(), aVar2.m(), aVar2.h(), aVar2.c());
        this.f25063o = aVar2.j();
        this.f25068t = aVar2.f();
        this.f25064p = aVar2.n();
        this.f25069u = (int) (fVar.m().d() / 32.0f);
        a<c, c> a10 = aVar2.e().a();
        this.f25070v = a10;
        a10.a(this);
        aVar.j(a10);
        a<PointF, PointF> a11 = aVar2.l().a();
        this.f25071w = a11;
        a11.a(this);
        aVar.j(a11);
        a<PointF, PointF> a12 = aVar2.d().a();
        this.f25072x = a12;
        a12.a(this);
        aVar.j(a12);
    }

    private int[] j(int[] iArr) {
        p pVar = this.f25073y;
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

    private int k() {
        int round = Math.round(this.f25071w.f() * this.f25069u);
        int round2 = Math.round(this.f25072x.f() * this.f25069u);
        int round3 = Math.round(this.f25070v.f() * this.f25069u);
        int i10 = round != 0 ? 527 * round : 17;
        if (round2 != 0) {
            i10 = i10 * 31 * round2;
        }
        return round3 != 0 ? i10 * 31 * round3 : i10;
    }

    private LinearGradient l() {
        long k10 = k();
        LinearGradient f10 = this.f25065q.f(k10);
        if (f10 != null) {
            return f10;
        }
        PointF h10 = this.f25071w.h();
        PointF h11 = this.f25072x.h();
        c h12 = this.f25070v.h();
        LinearGradient linearGradient = new LinearGradient(h10.x, h10.y, h11.x, h11.y, j(h12.a()), h12.b(), Shader.TileMode.CLAMP);
        this.f25065q.k(k10, linearGradient);
        return linearGradient;
    }

    private RadialGradient m() {
        float f10;
        float f11;
        long k10 = k();
        RadialGradient f12 = this.f25066r.f(k10);
        if (f12 != null) {
            return f12;
        }
        PointF h10 = this.f25071w.h();
        PointF h11 = this.f25072x.h();
        c h12 = this.f25070v.h();
        int[] j10 = j(h12.a());
        float[] b10 = h12.b();
        RadialGradient radialGradient = new RadialGradient(h10.x, h10.y, (float) Math.hypot(h11.x - f10, h11.y - f11), j10, b10, Shader.TileMode.CLAMP);
        this.f25066r.k(k10, radialGradient);
        return radialGradient;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // d3.a, g3.e
    public <T> void d(T t10, l3.c<T> cVar) {
        super.d(t10, cVar);
        if (t10 == k.D) {
            p pVar = this.f25073y;
            if (pVar != null) {
                this.f25004f.D(pVar);
            }
            if (cVar == null) {
                this.f25073y = null;
                return;
            }
            p pVar2 = new p(cVar);
            this.f25073y = pVar2;
            pVar2.a(this);
            this.f25004f.j(this.f25073y);
        }
    }

    @Override // d3.a, d3.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        Shader shader;
        if (!this.f25064p) {
            e(this.f25067s, matrix, false);
            if (this.f25068t == GradientType.LINEAR) {
                shader = l();
            } else {
                shader = m();
            }
            shader.setLocalMatrix(matrix);
            this.f25007i.setShader(shader);
            super.g(canvas, matrix, i10);
        }
    }

    @Override // d3.c
    public String getName() {
        return this.f25063o;
    }
}
