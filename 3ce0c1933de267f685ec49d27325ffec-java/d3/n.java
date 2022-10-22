package d3;

import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.content.PolystarShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import e3.a;
import g3.d;
import java.util.List;
import k3.g;
import l3.c;
/* compiled from: PolystarContent.java */
/* loaded from: classes.dex */
public class n implements m, a.b, k {

    /* renamed from: b  reason: collision with root package name */
    private final String f25081b;

    /* renamed from: c  reason: collision with root package name */
    private final f f25082c;

    /* renamed from: d  reason: collision with root package name */
    private final PolystarShape.Type f25083d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25084e;

    /* renamed from: f  reason: collision with root package name */
    private final e3.a<?, Float> f25085f;

    /* renamed from: g  reason: collision with root package name */
    private final e3.a<?, PointF> f25086g;

    /* renamed from: h  reason: collision with root package name */
    private final e3.a<?, Float> f25087h;

    /* renamed from: i  reason: collision with root package name */
    private final e3.a<?, Float> f25088i;

    /* renamed from: j  reason: collision with root package name */
    private final e3.a<?, Float> f25089j;

    /* renamed from: k  reason: collision with root package name */
    private final e3.a<?, Float> f25090k;

    /* renamed from: l  reason: collision with root package name */
    private final e3.a<?, Float> f25091l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f25093n;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25080a = new Path();

    /* renamed from: m  reason: collision with root package name */
    private b f25092m = new b();

    /* compiled from: PolystarContent.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25094a;

        static {
            int[] iArr = new int[PolystarShape.Type.values().length];
            f25094a = iArr;
            try {
                iArr[PolystarShape.Type.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25094a[PolystarShape.Type.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public n(f fVar, com.airbnb.lottie.model.layer.a aVar, PolystarShape polystarShape) {
        this.f25082c = fVar;
        this.f25081b = polystarShape.d();
        PolystarShape.Type j10 = polystarShape.j();
        this.f25083d = j10;
        this.f25084e = polystarShape.k();
        e3.a<Float, Float> a10 = polystarShape.g().a();
        this.f25085f = a10;
        e3.a<PointF, PointF> a11 = polystarShape.h().a();
        this.f25086g = a11;
        e3.a<Float, Float> a12 = polystarShape.i().a();
        this.f25087h = a12;
        e3.a<Float, Float> a13 = polystarShape.e().a();
        this.f25089j = a13;
        e3.a<Float, Float> a14 = polystarShape.f().a();
        this.f25091l = a14;
        PolystarShape.Type type = PolystarShape.Type.STAR;
        if (j10 == type) {
            this.f25088i = polystarShape.b().a();
            this.f25090k = polystarShape.c().a();
        } else {
            this.f25088i = null;
            this.f25090k = null;
        }
        aVar.j(a10);
        aVar.j(a11);
        aVar.j(a12);
        aVar.j(a13);
        aVar.j(a14);
        if (j10 == type) {
            aVar.j(this.f25088i);
            aVar.j(this.f25090k);
        }
        a10.a(this);
        a11.a(this);
        a12.a(this);
        a13.a(this);
        a14.a(this);
        if (j10 == type) {
            this.f25088i.a(this);
            this.f25090k.a(this);
        }
    }

    private void f() {
        e3.a<?, Float> aVar;
        double d10;
        double d11;
        double d12;
        int i10;
        int floor = (int) Math.floor(this.f25085f.h().floatValue());
        double radians = Math.toRadians((this.f25087h == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d13 = floor;
        float floatValue = this.f25091l.h().floatValue() / 100.0f;
        float floatValue2 = this.f25089j.h().floatValue();
        double d14 = floatValue2;
        float cos = (float) (Math.cos(radians) * d14);
        float sin = (float) (Math.sin(radians) * d14);
        this.f25080a.moveTo(cos, sin);
        double d15 = (float) (6.283185307179586d / d13);
        double d16 = radians + d15;
        double ceil = Math.ceil(d13);
        int i11 = 0;
        while (i11 < ceil) {
            float cos2 = (float) (Math.cos(d16) * d14);
            ceil = ceil;
            float sin2 = (float) (d14 * Math.sin(d16));
            if (floatValue != 0.0f) {
                d12 = d14;
                i10 = i11;
                d11 = d16;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d10 = d15;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f10 = floatValue2 * floatValue * 0.25f;
                this.f25080a.cubicTo(cos - (cos3 * f10), sin - (((float) Math.sin(atan2)) * f10), cos2 + (((float) Math.cos(atan22)) * f10), sin2 + (f10 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                d11 = d16;
                d12 = d14;
                d10 = d15;
                i10 = i11;
                this.f25080a.lineTo(cos2, sin2);
            }
            d16 = d11 + d10;
            i11 = i10 + 1;
            sin = sin2;
            cos = cos2;
            d14 = d12;
            d15 = d10;
        }
        PointF h10 = this.f25086g.h();
        this.f25080a.offset(h10.x, h10.y);
        this.f25080a.close();
    }

    private void i() {
        e3.a<?, Float> aVar;
        double d10;
        int i10;
        float f10;
        float f11;
        float f12;
        double d11;
        float f13;
        float f14;
        double d12;
        float f15;
        float f16;
        float f17;
        float f18;
        float floatValue = this.f25085f.h().floatValue();
        double radians = Math.toRadians((this.f25087h == null ? 0.0d : aVar.h().floatValue()) - 90.0d);
        double d13 = floatValue;
        float f19 = (float) (6.283185307179586d / d13);
        float f20 = f19 / 2.0f;
        float f21 = floatValue - ((int) floatValue);
        int i11 = (f21 > 0.0f ? 1 : (f21 == 0.0f ? 0 : -1));
        if (i11 != 0) {
            radians += (1.0f - f21) * f20;
        }
        float floatValue2 = this.f25089j.h().floatValue();
        float floatValue3 = this.f25088i.h().floatValue();
        e3.a<?, Float> aVar2 = this.f25090k;
        float floatValue4 = aVar2 != null ? aVar2.h().floatValue() / 100.0f : 0.0f;
        e3.a<?, Float> aVar3 = this.f25091l;
        float floatValue5 = aVar3 != null ? aVar3.h().floatValue() / 100.0f : 0.0f;
        if (i11 != 0) {
            f10 = ((floatValue2 - floatValue3) * f21) + floatValue3;
            i10 = i11;
            double d14 = f10;
            d10 = d13;
            f12 = (float) (d14 * Math.cos(radians));
            f11 = (float) (d14 * Math.sin(radians));
            this.f25080a.moveTo(f12, f11);
            d11 = radians + ((f19 * f21) / 2.0f);
        } else {
            d10 = d13;
            i10 = i11;
            double d15 = floatValue2;
            float cos = (float) (Math.cos(radians) * d15);
            float sin = (float) (d15 * Math.sin(radians));
            this.f25080a.moveTo(cos, sin);
            d11 = radians + f20;
            f12 = cos;
            f11 = sin;
            f10 = 0.0f;
        }
        double ceil = Math.ceil(d10) * 2.0d;
        int i12 = 0;
        boolean z10 = false;
        while (true) {
            double d16 = i12;
            if (d16 < ceil) {
                float f22 = z10 ? floatValue2 : floatValue3;
                int i13 = (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1));
                if (i13 == 0 || d16 != ceil - 2.0d) {
                    f13 = f19;
                    f14 = f20;
                } else {
                    f14 = (f19 * f21) / 2.0f;
                    f13 = f19;
                }
                if (i13 == 0 || d16 != ceil - 1.0d) {
                    f15 = f20;
                    d12 = d16;
                    f16 = f22;
                } else {
                    f15 = f20;
                    d12 = d16;
                    f16 = f10;
                }
                double d17 = f16;
                double d18 = ceil;
                float cos2 = (float) (d17 * Math.cos(d11));
                float sin2 = (float) (d17 * Math.sin(d11));
                if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                    this.f25080a.lineTo(cos2, sin2);
                    f18 = floatValue4;
                    f17 = f10;
                } else {
                    f18 = floatValue4;
                    f17 = f10;
                    double atan2 = (float) (Math.atan2(f11, f12) - 1.5707963267948966d);
                    float cos3 = (float) Math.cos(atan2);
                    float sin3 = (float) Math.sin(atan2);
                    double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan22);
                    float sin4 = (float) Math.sin(atan22);
                    float f23 = z10 ? f18 : floatValue5;
                    float f24 = z10 ? floatValue5 : f18;
                    float f25 = (z10 ? floatValue3 : floatValue2) * f23 * 0.47829f;
                    float f26 = cos3 * f25;
                    float f27 = f25 * sin3;
                    float f28 = (z10 ? floatValue2 : floatValue3) * f24 * 0.47829f;
                    float f29 = cos4 * f28;
                    float f30 = f28 * sin4;
                    if (i10 != 0) {
                        if (i12 == 0) {
                            f26 *= f21;
                            f27 *= f21;
                        } else if (d12 == d18 - 1.0d) {
                            f29 *= f21;
                            f30 *= f21;
                        }
                    }
                    this.f25080a.cubicTo(f12 - f26, f11 - f27, cos2 + f29, sin2 + f30, cos2, sin2);
                }
                d11 += f14;
                z10 = !z10;
                i12++;
                f12 = cos2;
                f11 = sin2;
                floatValue4 = f18;
                f10 = f17;
                f20 = f15;
                f19 = f13;
                ceil = d18;
            } else {
                PointF h10 = this.f25086g.h();
                this.f25080a.offset(h10.x, h10.y);
                this.f25080a.close();
                return;
            }
        }
    }

    private void j() {
        this.f25093n = false;
        this.f25082c.invalidateSelf();
    }

    @Override // d3.m
    public Path a() {
        if (this.f25093n) {
            return this.f25080a;
        }
        this.f25080a.reset();
        if (this.f25084e) {
            this.f25093n = true;
            return this.f25080a;
        }
        int i10 = a.f25094a[this.f25083d.ordinal()];
        if (i10 == 1) {
            i();
        } else if (i10 == 2) {
            f();
        }
        this.f25080a.close();
        this.f25092m.b(this.f25080a);
        this.f25093n = true;
        return this.f25080a;
    }

    @Override // e3.a.b
    public void b() {
        j();
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            c cVar = list.get(i10);
            if (cVar instanceof s) {
                s sVar = (s) cVar;
                if (sVar.j() == ShapeTrimPath.Type.SIMULTANEOUSLY) {
                    this.f25092m.a(sVar);
                    sVar.d(this);
                }
            }
        }
    }

    @Override // g3.e
    public <T> void d(T t10, c<T> cVar) {
        e3.a<?, Float> aVar;
        e3.a<?, Float> aVar2;
        if (t10 == k.f6526s) {
            this.f25085f.m(cVar);
        } else if (t10 == k.f6527t) {
            this.f25087h.m(cVar);
        } else if (t10 == k.f6517j) {
            this.f25086g.m(cVar);
        } else if (t10 == k.f6528u && (aVar2 = this.f25088i) != null) {
            aVar2.m(cVar);
        } else if (t10 == k.f6529v) {
            this.f25089j.m(cVar);
        } else if (t10 == k.f6530w && (aVar = this.f25090k) != null) {
            aVar.m(cVar);
        } else if (t10 == k.f6531x) {
            this.f25091l.m(cVar);
        }
    }

    @Override // d3.c
    public String getName() {
        return this.f25081b;
    }

    @Override // g3.e
    public void h(d dVar, int i10, List<d> list, d dVar2) {
        g.l(dVar, i10, list, dVar2, this);
    }
}
