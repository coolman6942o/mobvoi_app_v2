package d3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import e3.a;
import e3.o;
import g3.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import k3.g;
import l3.c;
/* compiled from: RepeaterContent.java */
/* loaded from: classes.dex */
public class p implements e, m, j, a.b, k {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f25105a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f25106b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final f f25107c;

    /* renamed from: d  reason: collision with root package name */
    private final com.airbnb.lottie.model.layer.a f25108d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25109e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f25110f;

    /* renamed from: g  reason: collision with root package name */
    private final a<Float, Float> f25111g;

    /* renamed from: h  reason: collision with root package name */
    private final a<Float, Float> f25112h;

    /* renamed from: i  reason: collision with root package name */
    private final o f25113i;

    /* renamed from: j  reason: collision with root package name */
    private d f25114j;

    public p(f fVar, com.airbnb.lottie.model.layer.a aVar, i3.f fVar2) {
        this.f25107c = fVar;
        this.f25108d = aVar;
        this.f25109e = fVar2.c();
        this.f25110f = fVar2.f();
        a<Float, Float> a10 = fVar2.b().a();
        this.f25111g = a10;
        aVar.j(a10);
        a10.a(this);
        a<Float, Float> a11 = fVar2.d().a();
        this.f25112h = a11;
        aVar.j(a11);
        a11.a(this);
        o b10 = fVar2.e().b();
        this.f25113i = b10;
        b10.a(aVar);
        b10.b(this);
    }

    @Override // d3.m
    public Path a() {
        Path a10 = this.f25114j.a();
        this.f25106b.reset();
        float floatValue = this.f25111g.h().floatValue();
        float floatValue2 = this.f25112h.h().floatValue();
        for (int i10 = ((int) floatValue) - 1; i10 >= 0; i10--) {
            this.f25105a.set(this.f25113i.g(i10 + floatValue2));
            this.f25106b.addPath(a10, this.f25105a);
        }
        return this.f25106b;
    }

    @Override // e3.a.b
    public void b() {
        this.f25107c.invalidateSelf();
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
        this.f25114j.c(list, list2);
    }

    @Override // g3.e
    public <T> void d(T t10, c<T> cVar) {
        if (!this.f25113i.c(t10, cVar)) {
            if (t10 == k.f6524q) {
                this.f25111g.m(cVar);
            } else if (t10 == k.f6525r) {
                this.f25112h.m(cVar);
            }
        }
    }

    @Override // d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f25114j.e(rectF, matrix, z10);
    }

    @Override // d3.j
    public void f(ListIterator<c> listIterator) {
        if (this.f25114j == null) {
            while (listIterator.hasPrevious() && listIterator.previous() != this) {
            }
            ArrayList arrayList = new ArrayList();
            while (listIterator.hasPrevious()) {
                arrayList.add(listIterator.previous());
                listIterator.remove();
            }
            Collections.reverse(arrayList);
            this.f25114j = new d(this.f25107c, this.f25108d, "Repeater", this.f25110f, arrayList, null);
        }
    }

    @Override // d3.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        float floatValue = this.f25111g.h().floatValue();
        float floatValue2 = this.f25112h.h().floatValue();
        float floatValue3 = this.f25113i.i().h().floatValue() / 100.0f;
        float floatValue4 = this.f25113i.e().h().floatValue() / 100.0f;
        for (int i11 = ((int) floatValue) - 1; i11 >= 0; i11--) {
            this.f25105a.set(matrix);
            float f10 = i11;
            this.f25105a.preConcat(this.f25113i.g(f10 + floatValue2));
            this.f25114j.g(canvas, this.f25105a, (int) (i10 * g.j(floatValue3, floatValue4, f10 / floatValue)));
        }
    }

    @Override // d3.c
    public String getName() {
        return this.f25109e;
    }

    @Override // g3.e
    public void h(d dVar, int i10, List<d> list, d dVar2) {
        g.l(dVar, i10, list, dVar2, this);
    }
}
