package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.model.layer.Layer;
import e3.p;
import java.util.ArrayList;
import java.util.List;
import k3.h;
import l3.c;
/* compiled from: CompositionLayer.java */
/* loaded from: classes.dex */
public class b extends com.airbnb.lottie.model.layer.a {

    /* renamed from: x  reason: collision with root package name */
    private e3.a<Float, Float> f6650x;

    /* renamed from: y  reason: collision with root package name */
    private final List<com.airbnb.lottie.model.layer.a> f6651y = new ArrayList();

    /* renamed from: z  reason: collision with root package name */
    private final RectF f6652z = new RectF();
    private final RectF A = new RectF();
    private Paint B = new Paint();

    /* compiled from: CompositionLayer.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6653a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f6653a = iArr;
            try {
                iArr[Layer.MatteType.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6653a[Layer.MatteType.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(f fVar, Layer layer, List<Layer> list, d dVar) {
        super(fVar, layer);
        int i10;
        com.airbnb.lottie.model.layer.a aVar;
        h3.b s10 = layer.s();
        if (s10 != null) {
            e3.a<Float, Float> a10 = s10.a();
            this.f6650x = a10;
            j(a10);
            this.f6650x.a(this);
        } else {
            this.f6650x = null;
        }
        androidx.collection.d dVar2 = new androidx.collection.d(dVar.j().size());
        int size = list.size() - 1;
        com.airbnb.lottie.model.layer.a aVar2 = null;
        while (true) {
            if (size >= 0) {
                Layer layer2 = list.get(size);
                com.airbnb.lottie.model.layer.a v10 = com.airbnb.lottie.model.layer.a.v(layer2, fVar, dVar);
                if (v10 != null) {
                    dVar2.k(v10.w().b(), v10);
                    if (aVar2 != null) {
                        aVar2.F(v10);
                        aVar2 = null;
                    } else {
                        this.f6651y.add(0, v10);
                        int i11 = a.f6653a[layer2.f().ordinal()];
                        if (i11 == 1 || i11 == 2) {
                            aVar2 = v10;
                        }
                    }
                }
                size--;
            }
        }
        for (i10 = 0; i10 < dVar2.n(); i10++) {
            com.airbnb.lottie.model.layer.a aVar3 = (com.airbnb.lottie.model.layer.a) dVar2.f(dVar2.j(i10));
            if (!(aVar3 == null || (aVar = (com.airbnb.lottie.model.layer.a) dVar2.f(aVar3.w().h())) == null)) {
                aVar3.G(aVar);
            }
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    protected void E(g3.d dVar, int i10, List<g3.d> list, g3.d dVar2) {
        for (int i11 = 0; i11 < this.f6651y.size(); i11++) {
            this.f6651y.get(i11).h(dVar, i10, list, dVar2);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    public void H(float f10) {
        super.H(f10);
        if (this.f6650x != null) {
            f10 = ((this.f6650x.h().floatValue() * this.f6638o.a().h()) - this.f6638o.a().o()) / (this.f6637n.m().e() + 0.01f);
        }
        if (this.f6650x == null) {
            f10 -= this.f6638o.p();
        }
        if (this.f6638o.t() != 0.0f) {
            f10 /= this.f6638o.t();
        }
        for (int size = this.f6651y.size() - 1; size >= 0; size--) {
            this.f6651y.get(size).H(f10);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a, g3.e
    public <T> void d(T t10, c<T> cVar) {
        super.d(t10, cVar);
        if (t10 != k.A) {
            return;
        }
        if (cVar == null) {
            e3.a<Float, Float> aVar = this.f6650x;
            if (aVar != null) {
                aVar.m(null);
                return;
            }
            return;
        }
        p pVar = new p(cVar);
        this.f6650x = pVar;
        pVar.a(this);
        j(this.f6650x);
    }

    @Override // com.airbnb.lottie.model.layer.a, d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        super.e(rectF, matrix, z10);
        for (int size = this.f6651y.size() - 1; size >= 0; size--) {
            this.f6652z.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f6651y.get(size).e(this.f6652z, this.f6636m, true);
            rectF.union(this.f6652z);
        }
    }

    @Override // com.airbnb.lottie.model.layer.a
    void u(Canvas canvas, Matrix matrix, int i10) {
        com.airbnb.lottie.c.a("CompositionLayer#draw");
        this.A.set(0.0f, 0.0f, this.f6638o.j(), this.f6638o.i());
        matrix.mapRect(this.A);
        boolean z10 = this.f6637n.F() && this.f6651y.size() > 1 && i10 != 255;
        if (z10) {
            this.B.setAlpha(i10);
            h.m(canvas, this.A, this.B);
        } else {
            canvas.save();
        }
        if (z10) {
            i10 = 255;
        }
        for (int size = this.f6651y.size() - 1; size >= 0; size--) {
            if (!this.A.isEmpty() ? canvas.clipRect(this.A) : true) {
                this.f6651y.get(size).g(canvas, matrix, i10);
            }
        }
        canvas.restore();
        com.airbnb.lottie.c.b("CompositionLayer#draw");
    }
}
