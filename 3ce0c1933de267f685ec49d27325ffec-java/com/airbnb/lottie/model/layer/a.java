package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import com.airbnb.lottie.d;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import d3.e;
import e3.a;
import e3.c;
import e3.g;
import e3.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import k3.h;
/* compiled from: BaseLayer.java */
/* loaded from: classes.dex */
public abstract class a implements e, a.b, g3.e {

    /* renamed from: f  reason: collision with root package name */
    private final Paint f6629f;

    /* renamed from: l  reason: collision with root package name */
    private final String f6635l;

    /* renamed from: n  reason: collision with root package name */
    final f f6637n;

    /* renamed from: o  reason: collision with root package name */
    final Layer f6638o;

    /* renamed from: p  reason: collision with root package name */
    private g f6639p;

    /* renamed from: q  reason: collision with root package name */
    private c f6640q;

    /* renamed from: r  reason: collision with root package name */
    private a f6641r;

    /* renamed from: s  reason: collision with root package name */
    private a f6642s;

    /* renamed from: t  reason: collision with root package name */
    private List<a> f6643t;

    /* renamed from: v  reason: collision with root package name */
    final o f6645v;

    /* renamed from: a  reason: collision with root package name */
    private final Path f6624a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f6625b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private final Paint f6626c = new c3.a(1);

    /* renamed from: d  reason: collision with root package name */
    private final Paint f6627d = new c3.a(1, PorterDuff.Mode.DST_IN);

    /* renamed from: e  reason: collision with root package name */
    private final Paint f6628e = new c3.a(1, PorterDuff.Mode.DST_OUT);

    /* renamed from: g  reason: collision with root package name */
    private final Paint f6630g = new c3.a(PorterDuff.Mode.CLEAR);

    /* renamed from: h  reason: collision with root package name */
    private final RectF f6631h = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private final RectF f6632i = new RectF();

    /* renamed from: j  reason: collision with root package name */
    private final RectF f6633j = new RectF();

    /* renamed from: k  reason: collision with root package name */
    private final RectF f6634k = new RectF();

    /* renamed from: m  reason: collision with root package name */
    final Matrix f6636m = new Matrix();

    /* renamed from: u  reason: collision with root package name */
    private final List<e3.a<?, ?>> f6644u = new ArrayList();

    /* renamed from: w  reason: collision with root package name */
    private boolean f6646w = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseLayer.java */
    /* renamed from: com.airbnb.lottie.model.layer.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0089a implements a.b {
        C0089a() {
        }

        @Override // e3.a.b
        public void b() {
            a aVar = a.this;
            aVar.I(aVar.f6640q.o() == 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseLayer.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6648a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f6649b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f6649b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6649b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6649b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6649b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f6648a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6648a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6648a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6648a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6648a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6648a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f6648a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(f fVar, Layer layer) {
        c3.a aVar = new c3.a(1);
        this.f6629f = aVar;
        this.f6637n = fVar;
        this.f6638o = layer;
        this.f6635l = layer.g() + "#draw";
        if (layer.f() == Layer.MatteType.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        o b10 = layer.u().b();
        this.f6645v = b10;
        b10.b(this);
        if (layer.e() != null && !layer.e().isEmpty()) {
            g gVar = new g(layer.e());
            this.f6639p = gVar;
            for (e3.a<i3.g, Path> aVar2 : gVar.a()) {
                aVar2.a(this);
            }
            for (e3.a<Integer, Integer> aVar3 : this.f6639p.c()) {
                j(aVar3);
                aVar3.a(this);
            }
        }
        J();
    }

    private void A(RectF rectF, Matrix matrix) {
        if (y() && this.f6638o.f() != Layer.MatteType.INVERT) {
            this.f6633j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f6641r.e(this.f6633j, matrix, true);
            if (!rectF.intersect(this.f6633j)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    private void B() {
        this.f6637n.invalidateSelf();
    }

    private void C(float f10) {
        this.f6637n.m().m().a(this.f6638o.g(), f10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(boolean z10) {
        if (z10 != this.f6646w) {
            this.f6646w = z10;
            B();
        }
    }

    private void J() {
        boolean z10 = true;
        if (!this.f6638o.c().isEmpty()) {
            c cVar = new c(this.f6638o.c());
            this.f6640q = cVar;
            cVar.k();
            this.f6640q.a(new C0089a());
            if (this.f6640q.h().floatValue() != 1.0f) {
                z10 = false;
            }
            I(z10);
            j(this.f6640q);
            return;
        }
        I(true);
    }

    private void k(Canvas canvas, Matrix matrix, Mask mask, e3.a<i3.g, Path> aVar, e3.a<Integer, Integer> aVar2) {
        this.f6624a.set(aVar.h());
        this.f6624a.transform(matrix);
        this.f6626c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f6624a, this.f6626c);
    }

    private void l(Canvas canvas, Matrix matrix, Mask mask, e3.a<i3.g, Path> aVar, e3.a<Integer, Integer> aVar2) {
        h.m(canvas, this.f6631h, this.f6627d);
        this.f6624a.set(aVar.h());
        this.f6624a.transform(matrix);
        this.f6626c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f6624a, this.f6626c);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, Mask mask, e3.a<i3.g, Path> aVar, e3.a<Integer, Integer> aVar2) {
        h.m(canvas, this.f6631h, this.f6626c);
        canvas.drawRect(this.f6631h, this.f6626c);
        this.f6624a.set(aVar.h());
        this.f6624a.transform(matrix);
        this.f6626c.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        canvas.drawPath(this.f6624a, this.f6628e);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, Mask mask, e3.a<i3.g, Path> aVar, e3.a<Integer, Integer> aVar2) {
        h.m(canvas, this.f6631h, this.f6627d);
        canvas.drawRect(this.f6631h, this.f6626c);
        this.f6628e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f6624a.set(aVar.h());
        this.f6624a.transform(matrix);
        canvas.drawPath(this.f6624a, this.f6628e);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix, Mask mask, e3.a<i3.g, Path> aVar, e3.a<Integer, Integer> aVar2) {
        h.m(canvas, this.f6631h, this.f6628e);
        canvas.drawRect(this.f6631h, this.f6626c);
        this.f6628e.setAlpha((int) (aVar2.h().intValue() * 2.55f));
        this.f6624a.set(aVar.h());
        this.f6624a.transform(matrix);
        canvas.drawPath(this.f6624a, this.f6628e);
        canvas.restore();
    }

    private void p(Canvas canvas, Matrix matrix) {
        com.airbnb.lottie.c.a("Layer#saveLayer");
        h.n(canvas, this.f6631h, this.f6627d, 19);
        if (Build.VERSION.SDK_INT < 28) {
            t(canvas);
        }
        com.airbnb.lottie.c.b("Layer#saveLayer");
        for (int i10 = 0; i10 < this.f6639p.b().size(); i10++) {
            Mask mask = this.f6639p.b().get(i10);
            e3.a<i3.g, Path> aVar = this.f6639p.a().get(i10);
            e3.a<Integer, Integer> aVar2 = this.f6639p.c().get(i10);
            int i11 = b.f6649b[mask.a().ordinal()];
            if (i11 != 1) {
                if (i11 == 2) {
                    if (i10 == 0) {
                        this.f6626c.setColor(-16777216);
                        this.f6626c.setAlpha(255);
                        canvas.drawRect(this.f6631h, this.f6626c);
                    }
                    if (mask.d()) {
                        o(canvas, matrix, mask, aVar, aVar2);
                    } else {
                        q(canvas, matrix, mask, aVar, aVar2);
                    }
                } else if (i11 != 3) {
                    if (i11 == 4) {
                        if (mask.d()) {
                            m(canvas, matrix, mask, aVar, aVar2);
                        } else {
                            k(canvas, matrix, mask, aVar, aVar2);
                        }
                    }
                } else if (mask.d()) {
                    n(canvas, matrix, mask, aVar, aVar2);
                } else {
                    l(canvas, matrix, mask, aVar, aVar2);
                }
            } else if (r()) {
                this.f6626c.setAlpha(255);
                canvas.drawRect(this.f6631h, this.f6626c);
            }
        }
        com.airbnb.lottie.c.a("Layer#restoreLayer");
        canvas.restore();
        com.airbnb.lottie.c.b("Layer#restoreLayer");
    }

    private void q(Canvas canvas, Matrix matrix, Mask mask, e3.a<i3.g, Path> aVar, e3.a<Integer, Integer> aVar2) {
        this.f6624a.set(aVar.h());
        this.f6624a.transform(matrix);
        canvas.drawPath(this.f6624a, this.f6628e);
    }

    private boolean r() {
        if (this.f6639p.a().isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < this.f6639p.b().size(); i10++) {
            if (this.f6639p.b().get(i10).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void s() {
        if (this.f6643t == null) {
            if (this.f6642s == null) {
                this.f6643t = Collections.emptyList();
                return;
            }
            this.f6643t = new ArrayList();
            for (a aVar = this.f6642s; aVar != null; aVar = aVar.f6642s) {
                this.f6643t.add(aVar);
            }
        }
    }

    private void t(Canvas canvas) {
        com.airbnb.lottie.c.a("Layer#clearLayer");
        RectF rectF = this.f6631h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f6630g);
        com.airbnb.lottie.c.b("Layer#clearLayer");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a v(Layer layer, f fVar, d dVar) {
        switch (b.f6648a[layer.d().ordinal()]) {
            case 1:
                return new e(fVar, layer);
            case 2:
                return new com.airbnb.lottie.model.layer.b(fVar, layer, dVar.n(layer.k()), dVar);
            case 3:
                return new f(fVar, layer);
            case 4:
                return new c(fVar, layer);
            case 5:
                return new d(fVar, layer);
            case 6:
                return new g(fVar, layer);
            default:
                k3.d.c("Unknown layer type " + layer.d());
                return null;
        }
    }

    private void z(RectF rectF, Matrix matrix) {
        this.f6632i.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (x()) {
            int size = this.f6639p.b().size();
            for (int i10 = 0; i10 < size; i10++) {
                Mask mask = this.f6639p.b().get(i10);
                this.f6624a.set(this.f6639p.a().get(i10).h());
                this.f6624a.transform(matrix);
                int i11 = b.f6649b[mask.a().ordinal()];
                if (i11 != 1 && i11 != 2) {
                    if ((i11 != 3 && i11 != 4) || !mask.d()) {
                        this.f6624a.computeBounds(this.f6634k, false);
                        if (i10 == 0) {
                            this.f6632i.set(this.f6634k);
                        } else {
                            RectF rectF2 = this.f6632i;
                            rectF2.set(Math.min(rectF2.left, this.f6634k.left), Math.min(this.f6632i.top, this.f6634k.top), Math.max(this.f6632i.right, this.f6634k.right), Math.max(this.f6632i.bottom, this.f6634k.bottom));
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            if (!rectF.intersect(this.f6632i)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
    }

    public void D(e3.a<?, ?> aVar) {
        this.f6644u.remove(aVar);
    }

    void E(g3.d dVar, int i10, List<g3.d> list, g3.d dVar2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(a aVar) {
        this.f6641r = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(a aVar) {
        this.f6642s = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H(float f10) {
        this.f6645v.j(f10);
        if (this.f6639p != null) {
            for (int i10 = 0; i10 < this.f6639p.a().size(); i10++) {
                this.f6639p.a().get(i10).l(f10);
            }
        }
        if (this.f6638o.t() != 0.0f) {
            f10 /= this.f6638o.t();
        }
        c cVar = this.f6640q;
        if (cVar != null) {
            cVar.l(f10 / this.f6638o.t());
        }
        a aVar = this.f6641r;
        if (aVar != null) {
            this.f6641r.H(aVar.f6638o.t() * f10);
        }
        for (int i11 = 0; i11 < this.f6644u.size(); i11++) {
            this.f6644u.get(i11).l(f10);
        }
    }

    @Override // e3.a.b
    public void b() {
        B();
    }

    @Override // d3.c
    public void c(List<d3.c> list, List<d3.c> list2) {
    }

    @Override // g3.e
    public <T> void d(T t10, l3.c<T> cVar) {
        this.f6645v.c(t10, cVar);
    }

    @Override // d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f6631h.set(0.0f, 0.0f, 0.0f, 0.0f);
        s();
        this.f6636m.set(matrix);
        if (z10) {
            List<a> list = this.f6643t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f6636m.preConcat(this.f6643t.get(size).f6645v.f());
                }
            } else {
                a aVar = this.f6642s;
                if (aVar != null) {
                    this.f6636m.preConcat(aVar.f6645v.f());
                }
            }
        }
        this.f6636m.preConcat(this.f6645v.f());
    }

    @Override // d3.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        com.airbnb.lottie.c.a(this.f6635l);
        if (!this.f6646w || this.f6638o.v()) {
            com.airbnb.lottie.c.b(this.f6635l);
            return;
        }
        s();
        com.airbnb.lottie.c.a("Layer#parentMatrix");
        this.f6625b.reset();
        this.f6625b.set(matrix);
        for (int size = this.f6643t.size() - 1; size >= 0; size--) {
            this.f6625b.preConcat(this.f6643t.get(size).f6645v.f());
        }
        com.airbnb.lottie.c.b("Layer#parentMatrix");
        int intValue = (int) ((((i10 / 255.0f) * (this.f6645v.h() == null ? 100 : this.f6645v.h().h().intValue())) / 100.0f) * 255.0f);
        if (y() || x()) {
            com.airbnb.lottie.c.a("Layer#computeBounds");
            e(this.f6631h, this.f6625b, false);
            A(this.f6631h, matrix);
            this.f6625b.preConcat(this.f6645v.f());
            z(this.f6631h, this.f6625b);
            if (!this.f6631h.intersect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight())) {
                this.f6631h.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
            com.airbnb.lottie.c.b("Layer#computeBounds");
            if (!this.f6631h.isEmpty()) {
                com.airbnb.lottie.c.a("Layer#saveLayer");
                this.f6626c.setAlpha(255);
                h.m(canvas, this.f6631h, this.f6626c);
                com.airbnb.lottie.c.b("Layer#saveLayer");
                t(canvas);
                com.airbnb.lottie.c.a("Layer#drawLayer");
                u(canvas, this.f6625b, intValue);
                com.airbnb.lottie.c.b("Layer#drawLayer");
                if (x()) {
                    p(canvas, this.f6625b);
                }
                if (y()) {
                    com.airbnb.lottie.c.a("Layer#drawMatte");
                    com.airbnb.lottie.c.a("Layer#saveLayer");
                    h.n(canvas, this.f6631h, this.f6629f, 19);
                    com.airbnb.lottie.c.b("Layer#saveLayer");
                    t(canvas);
                    this.f6641r.g(canvas, matrix, intValue);
                    com.airbnb.lottie.c.a("Layer#restoreLayer");
                    canvas.restore();
                    com.airbnb.lottie.c.b("Layer#restoreLayer");
                    com.airbnb.lottie.c.b("Layer#drawMatte");
                }
                com.airbnb.lottie.c.a("Layer#restoreLayer");
                canvas.restore();
                com.airbnb.lottie.c.b("Layer#restoreLayer");
            }
            C(com.airbnb.lottie.c.b(this.f6635l));
            return;
        }
        this.f6625b.preConcat(this.f6645v.f());
        com.airbnb.lottie.c.a("Layer#drawLayer");
        u(canvas, this.f6625b, intValue);
        com.airbnb.lottie.c.b("Layer#drawLayer");
        C(com.airbnb.lottie.c.b(this.f6635l));
    }

    @Override // d3.c
    public String getName() {
        return this.f6638o.g();
    }

    @Override // g3.e
    public void h(g3.d dVar, int i10, List<g3.d> list, g3.d dVar2) {
        if (dVar.g(getName(), i10)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i10)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i10)) {
                E(dVar, i10 + dVar.e(getName(), i10), list, dVar2);
            }
        }
    }

    public void j(e3.a<?, ?> aVar) {
        if (aVar != null) {
            this.f6644u.add(aVar);
        }
    }

    abstract void u(Canvas canvas, Matrix matrix, int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer w() {
        return this.f6638o;
    }

    boolean x() {
        g gVar = this.f6639p;
        return gVar != null && !gVar.a().isEmpty();
    }

    boolean y() {
        return this.f6641r != null;
    }
}
