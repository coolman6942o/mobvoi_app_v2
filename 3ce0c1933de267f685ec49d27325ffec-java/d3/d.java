package d3;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.f;
import e3.a;
import e3.o;
import g3.e;
import h3.l;
import i3.b;
import i3.i;
import java.util.ArrayList;
import java.util.List;
import k3.h;
import l3.c;
/* compiled from: ContentGroup.java */
/* loaded from: classes.dex */
public class d implements e, m, a.b, e {

    /* renamed from: a  reason: collision with root package name */
    private Paint f25016a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f25017b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f25018c;

    /* renamed from: d  reason: collision with root package name */
    private final Path f25019d;

    /* renamed from: e  reason: collision with root package name */
    private final RectF f25020e;

    /* renamed from: f  reason: collision with root package name */
    private final String f25021f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f25022g;

    /* renamed from: h  reason: collision with root package name */
    private final List<c> f25023h;

    /* renamed from: i  reason: collision with root package name */
    private final f f25024i;

    /* renamed from: j  reason: collision with root package name */
    private List<m> f25025j;

    /* renamed from: k  reason: collision with root package name */
    private o f25026k;

    public d(f fVar, com.airbnb.lottie.model.layer.a aVar, i iVar) {
        this(fVar, aVar, iVar.c(), iVar.d(), f(fVar, aVar, iVar.b()), i(iVar.b()));
    }

    private static List<c> f(f fVar, com.airbnb.lottie.model.layer.a aVar, List<b> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i10 = 0; i10 < list.size(); i10++) {
            c a10 = list.get(i10).a(fVar, aVar);
            if (a10 != null) {
                arrayList.add(a10);
            }
        }
        return arrayList;
    }

    static l i(List<b> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            b bVar = list.get(i10);
            if (bVar instanceof l) {
                return (l) bVar;
            }
        }
        return null;
    }

    private boolean l() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f25023h.size(); i11++) {
            if ((this.f25023h.get(i11) instanceof e) && (i10 = i10 + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    @Override // d3.m
    public Path a() {
        this.f25018c.reset();
        o oVar = this.f25026k;
        if (oVar != null) {
            this.f25018c.set(oVar.f());
        }
        this.f25019d.reset();
        if (this.f25022g) {
            return this.f25019d;
        }
        for (int size = this.f25023h.size() - 1; size >= 0; size--) {
            c cVar = this.f25023h.get(size);
            if (cVar instanceof m) {
                this.f25019d.addPath(((m) cVar).a(), this.f25018c);
            }
        }
        return this.f25019d;
    }

    @Override // e3.a.b
    public void b() {
        this.f25024i.invalidateSelf();
    }

    @Override // d3.c
    public void c(List<c> list, List<c> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.f25023h.size());
        arrayList.addAll(list);
        for (int size = this.f25023h.size() - 1; size >= 0; size--) {
            c cVar = this.f25023h.get(size);
            cVar.c(arrayList, this.f25023h.subList(0, size));
            arrayList.add(cVar);
        }
    }

    @Override // g3.e
    public <T> void d(T t10, c<T> cVar) {
        o oVar = this.f25026k;
        if (oVar != null) {
            oVar.c(t10, cVar);
        }
    }

    @Override // d3.e
    public void e(RectF rectF, Matrix matrix, boolean z10) {
        this.f25018c.set(matrix);
        o oVar = this.f25026k;
        if (oVar != null) {
            this.f25018c.preConcat(oVar.f());
        }
        this.f25020e.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.f25023h.size() - 1; size >= 0; size--) {
            c cVar = this.f25023h.get(size);
            if (cVar instanceof e) {
                ((e) cVar).e(this.f25020e, this.f25018c, z10);
                rectF.union(this.f25020e);
            }
        }
    }

    @Override // d3.e
    public void g(Canvas canvas, Matrix matrix, int i10) {
        if (!this.f25022g) {
            this.f25018c.set(matrix);
            o oVar = this.f25026k;
            if (oVar != null) {
                this.f25018c.preConcat(oVar.f());
                i10 = (int) (((((this.f25026k.h() == null ? 100 : this.f25026k.h().h().intValue()) / 100.0f) * i10) / 255.0f) * 255.0f);
            }
            boolean z10 = this.f25024i.F() && l() && i10 != 255;
            if (z10) {
                this.f25017b.set(0.0f, 0.0f, 0.0f, 0.0f);
                e(this.f25017b, this.f25018c, true);
                this.f25016a.setAlpha(i10);
                h.m(canvas, this.f25017b, this.f25016a);
            }
            if (z10) {
                i10 = 255;
            }
            for (int size = this.f25023h.size() - 1; size >= 0; size--) {
                c cVar = this.f25023h.get(size);
                if (cVar instanceof e) {
                    ((e) cVar).g(canvas, this.f25018c, i10);
                }
            }
            if (z10) {
                canvas.restore();
            }
        }
    }

    @Override // d3.c
    public String getName() {
        return this.f25021f;
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
                int e10 = i10 + dVar.e(getName(), i10);
                for (int i11 = 0; i11 < this.f25023h.size(); i11++) {
                    c cVar = this.f25023h.get(i11);
                    if (cVar instanceof e) {
                        ((e) cVar).h(dVar, e10, list, dVar2);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<m> j() {
        if (this.f25025j == null) {
            this.f25025j = new ArrayList();
            for (int i10 = 0; i10 < this.f25023h.size(); i10++) {
                c cVar = this.f25023h.get(i10);
                if (cVar instanceof m) {
                    this.f25025j.add((m) cVar);
                }
            }
        }
        return this.f25025j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Matrix k() {
        o oVar = this.f25026k;
        if (oVar != null) {
            return oVar.f();
        }
        this.f25018c.reset();
        return this.f25018c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(f fVar, com.airbnb.lottie.model.layer.a aVar, String str, boolean z10, List<c> list, l lVar) {
        this.f25016a = new c3.a();
        this.f25017b = new RectF();
        this.f25018c = new Matrix();
        this.f25019d = new Path();
        this.f25020e = new RectF();
        this.f25021f = str;
        this.f25024i = fVar;
        this.f25022g = z10;
        this.f25023h = list;
        if (lVar != null) {
            o b10 = lVar.b();
            this.f25026k = b10;
            b10.a(aVar);
            this.f25026k.b(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            c cVar = list.get(size);
            if (cVar instanceof j) {
                arrayList.add((j) cVar);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((j) arrayList.get(size2)).f(list.listIterator(list.size()));
        }
    }
}
