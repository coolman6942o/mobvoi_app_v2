package e3;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.layer.a;
import e3.a;
import h3.l;
import java.util.Collections;
import l3.c;
import l3.d;
/* compiled from: TransformKeyframeAnimation.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f25759a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f25760b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f25761c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f25762d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f25763e;

    /* renamed from: f  reason: collision with root package name */
    private a<PointF, PointF> f25764f;

    /* renamed from: g  reason: collision with root package name */
    private a<?, PointF> f25765g;

    /* renamed from: h  reason: collision with root package name */
    private a<d, d> f25766h;

    /* renamed from: i  reason: collision with root package name */
    private a<Float, Float> f25767i;

    /* renamed from: j  reason: collision with root package name */
    private a<Integer, Integer> f25768j;

    /* renamed from: k  reason: collision with root package name */
    private c f25769k;

    /* renamed from: l  reason: collision with root package name */
    private c f25770l;

    /* renamed from: m  reason: collision with root package name */
    private a<?, Float> f25771m;

    /* renamed from: n  reason: collision with root package name */
    private a<?, Float> f25772n;

    public o(l lVar) {
        this.f25764f = lVar.c() == null ? null : lVar.c().a();
        this.f25765g = lVar.f() == null ? null : lVar.f().a();
        this.f25766h = lVar.h() == null ? null : lVar.h().a();
        this.f25767i = lVar.g() == null ? null : lVar.g().a();
        c cVar = lVar.i() == null ? null : (c) lVar.i().a();
        this.f25769k = cVar;
        if (cVar != null) {
            this.f25760b = new Matrix();
            this.f25761c = new Matrix();
            this.f25762d = new Matrix();
            this.f25763e = new float[9];
        } else {
            this.f25760b = null;
            this.f25761c = null;
            this.f25762d = null;
            this.f25763e = null;
        }
        this.f25770l = lVar.j() == null ? null : (c) lVar.j().a();
        if (lVar.e() != null) {
            this.f25768j = lVar.e().a();
        }
        if (lVar.k() != null) {
            this.f25771m = lVar.k().a();
        } else {
            this.f25771m = null;
        }
        if (lVar.d() != null) {
            this.f25772n = lVar.d().a();
        } else {
            this.f25772n = null;
        }
    }

    private void d() {
        for (int i10 = 0; i10 < 9; i10++) {
            this.f25763e[i10] = 0.0f;
        }
    }

    public void a(a aVar) {
        aVar.j(this.f25768j);
        aVar.j(this.f25771m);
        aVar.j(this.f25772n);
        aVar.j(this.f25764f);
        aVar.j(this.f25765g);
        aVar.j(this.f25766h);
        aVar.j(this.f25767i);
        aVar.j(this.f25769k);
        aVar.j(this.f25770l);
    }

    public void b(a.b bVar) {
        a<Integer, Integer> aVar = this.f25768j;
        if (aVar != null) {
            aVar.a(bVar);
        }
        a<?, Float> aVar2 = this.f25771m;
        if (aVar2 != null) {
            aVar2.a(bVar);
        }
        a<?, Float> aVar3 = this.f25772n;
        if (aVar3 != null) {
            aVar3.a(bVar);
        }
        a<PointF, PointF> aVar4 = this.f25764f;
        if (aVar4 != null) {
            aVar4.a(bVar);
        }
        a<?, PointF> aVar5 = this.f25765g;
        if (aVar5 != null) {
            aVar5.a(bVar);
        }
        a<d, d> aVar6 = this.f25766h;
        if (aVar6 != null) {
            aVar6.a(bVar);
        }
        a<Float, Float> aVar7 = this.f25767i;
        if (aVar7 != null) {
            aVar7.a(bVar);
        }
        c cVar = this.f25769k;
        if (cVar != null) {
            cVar.a(bVar);
        }
        c cVar2 = this.f25770l;
        if (cVar2 != null) {
            cVar2.a(bVar);
        }
    }

    public <T> boolean c(T t10, c<T> cVar) {
        c cVar2;
        c cVar3;
        a<?, Float> aVar;
        a<?, Float> aVar2;
        if (t10 == k.f6512e) {
            a<PointF, PointF> aVar3 = this.f25764f;
            if (aVar3 == null) {
                this.f25764f = new p(cVar, new PointF());
                return true;
            }
            aVar3.m(cVar);
            return true;
        } else if (t10 == k.f6513f) {
            a<?, PointF> aVar4 = this.f25765g;
            if (aVar4 == null) {
                this.f25765g = new p(cVar, new PointF());
                return true;
            }
            aVar4.m(cVar);
            return true;
        } else if (t10 == k.f6518k) {
            a<d, d> aVar5 = this.f25766h;
            if (aVar5 == null) {
                this.f25766h = new p(cVar, new d());
                return true;
            }
            aVar5.m(cVar);
            return true;
        } else if (t10 == k.f6519l) {
            a<Float, Float> aVar6 = this.f25767i;
            if (aVar6 == null) {
                this.f25767i = new p(cVar, Float.valueOf(0.0f));
                return true;
            }
            aVar6.m(cVar);
            return true;
        } else if (t10 == k.f6510c) {
            a<Integer, Integer> aVar7 = this.f25768j;
            if (aVar7 == null) {
                this.f25768j = new p(cVar, 100);
                return true;
            }
            aVar7.m(cVar);
            return true;
        } else if (t10 != k.f6532y || (aVar2 = this.f25771m) == null) {
            if (t10 != k.f6533z || (aVar = this.f25772n) == null) {
                if (t10 == k.f6520m && (cVar3 = this.f25769k) != null) {
                    if (cVar3 == null) {
                        this.f25769k = new c(Collections.singletonList(new l3.a(Float.valueOf(0.0f))));
                    }
                    this.f25769k.m(cVar);
                    return true;
                } else if (t10 != k.f6521n || (cVar2 = this.f25770l) == null) {
                    return false;
                } else {
                    if (cVar2 == null) {
                        this.f25770l = new c(Collections.singletonList(new l3.a(Float.valueOf(0.0f))));
                    }
                    this.f25770l.m(cVar);
                    return true;
                }
            } else if (aVar == null) {
                this.f25772n = new p(cVar, 100);
                return true;
            } else {
                aVar.m(cVar);
                return true;
            }
        } else if (aVar2 == null) {
            this.f25771m = new p(cVar, 100);
            return true;
        } else {
            aVar2.m(cVar);
            return true;
        }
    }

    public a<?, Float> e() {
        return this.f25772n;
    }

    public Matrix f() {
        float f10;
        this.f25759a.reset();
        a<?, PointF> aVar = this.f25765g;
        if (aVar != null) {
            PointF h10 = aVar.h();
            float f11 = h10.x;
            if (!(f11 == 0.0f && h10.y == 0.0f)) {
                this.f25759a.preTranslate(f11, h10.y);
            }
        }
        a<Float, Float> aVar2 = this.f25767i;
        if (aVar2 != null) {
            if (aVar2 instanceof p) {
                f10 = aVar2.h().floatValue();
            } else {
                f10 = ((c) aVar2).o();
            }
            if (f10 != 0.0f) {
                this.f25759a.preRotate(f10);
            }
        }
        if (this.f25769k != null) {
            c cVar = this.f25770l;
            float cos = cVar == null ? 0.0f : (float) Math.cos(Math.toRadians((-cVar.o()) + 90.0f));
            c cVar2 = this.f25770l;
            float sin = cVar2 == null ? 1.0f : (float) Math.sin(Math.toRadians((-cVar2.o()) + 90.0f));
            d();
            float[] fArr = this.f25763e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f12 = -sin;
            fArr[3] = f12;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f25760b.setValues(fArr);
            d();
            float[] fArr2 = this.f25763e;
            fArr2[0] = 1.0f;
            fArr2[3] = (float) Math.tan(Math.toRadians(this.f25769k.o()));
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f25761c.setValues(fArr2);
            d();
            float[] fArr3 = this.f25763e;
            fArr3[0] = cos;
            fArr3[1] = f12;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f25762d.setValues(fArr3);
            this.f25761c.preConcat(this.f25760b);
            this.f25762d.preConcat(this.f25761c);
            this.f25759a.preConcat(this.f25762d);
        }
        a<d, d> aVar3 = this.f25766h;
        if (aVar3 != null) {
            d h11 = aVar3.h();
            if (!(h11.b() == 1.0f && h11.c() == 1.0f)) {
                this.f25759a.preScale(h11.b(), h11.c());
            }
        }
        a<PointF, PointF> aVar4 = this.f25764f;
        if (aVar4 != null) {
            PointF h12 = aVar4.h();
            float f13 = h12.x;
            if (!(f13 == 0.0f && h12.y == 0.0f)) {
                this.f25759a.preTranslate(-f13, -h12.y);
            }
        }
        return this.f25759a;
    }

    public Matrix g(float f10) {
        a<?, PointF> aVar = this.f25765g;
        PointF pointF = null;
        PointF h10 = aVar == null ? null : aVar.h();
        a<d, d> aVar2 = this.f25766h;
        d h11 = aVar2 == null ? null : aVar2.h();
        this.f25759a.reset();
        if (h10 != null) {
            this.f25759a.preTranslate(h10.x * f10, h10.y * f10);
        }
        if (h11 != null) {
            double d10 = f10;
            this.f25759a.preScale((float) Math.pow(h11.b(), d10), (float) Math.pow(h11.c(), d10));
        }
        a<Float, Float> aVar3 = this.f25767i;
        if (aVar3 != null) {
            float floatValue = aVar3.h().floatValue();
            a<PointF, PointF> aVar4 = this.f25764f;
            if (aVar4 != null) {
                pointF = aVar4.h();
            }
            Matrix matrix = this.f25759a;
            float f11 = floatValue * f10;
            float f12 = 0.0f;
            float f13 = pointF == null ? 0.0f : pointF.x;
            if (pointF != null) {
                f12 = pointF.y;
            }
            matrix.preRotate(f11, f13, f12);
        }
        return this.f25759a;
    }

    public a<?, Integer> h() {
        return this.f25768j;
    }

    public a<?, Float> i() {
        return this.f25771m;
    }

    public void j(float f10) {
        a<Integer, Integer> aVar = this.f25768j;
        if (aVar != null) {
            aVar.l(f10);
        }
        a<?, Float> aVar2 = this.f25771m;
        if (aVar2 != null) {
            aVar2.l(f10);
        }
        a<?, Float> aVar3 = this.f25772n;
        if (aVar3 != null) {
            aVar3.l(f10);
        }
        a<PointF, PointF> aVar4 = this.f25764f;
        if (aVar4 != null) {
            aVar4.l(f10);
        }
        a<?, PointF> aVar5 = this.f25765g;
        if (aVar5 != null) {
            aVar5.l(f10);
        }
        a<d, d> aVar6 = this.f25766h;
        if (aVar6 != null) {
            aVar6.l(f10);
        }
        a<Float, Float> aVar7 = this.f25767i;
        if (aVar7 != null) {
            aVar7.l(f10);
        }
        c cVar = this.f25769k;
        if (cVar != null) {
            cVar.l(f10);
        }
        c cVar2 = this.f25770l;
        if (cVar2 != null) {
            cVar2.l(f10);
        }
    }
}
