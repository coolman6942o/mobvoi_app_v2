package w;

import java.util.ArrayList;
import java.util.List;
/* compiled from: DependencyNode.java */
/* loaded from: classes.dex */
public class f implements d {

    /* renamed from: d  reason: collision with root package name */
    p f35880d;

    /* renamed from: f  reason: collision with root package name */
    int f35882f;

    /* renamed from: g  reason: collision with root package name */
    public int f35883g;

    /* renamed from: a  reason: collision with root package name */
    public d f35877a = null;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35878b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35879c = false;

    /* renamed from: e  reason: collision with root package name */
    a f35881e = a.UNKNOWN;

    /* renamed from: h  reason: collision with root package name */
    int f35884h = 1;

    /* renamed from: i  reason: collision with root package name */
    g f35885i = null;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35886j = false;

    /* renamed from: k  reason: collision with root package name */
    List<d> f35887k = new ArrayList();

    /* renamed from: l  reason: collision with root package name */
    List<f> f35888l = new ArrayList();

    /* compiled from: DependencyNode.java */
    /* loaded from: classes.dex */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f35880d = pVar;
    }

    @Override // w.d
    public void a(d dVar) {
        for (f fVar : this.f35888l) {
            if (!fVar.f35886j) {
                return;
            }
        }
        this.f35879c = true;
        d dVar2 = this.f35877a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f35878b) {
            this.f35880d.a(this);
            return;
        }
        f fVar2 = null;
        int i10 = 0;
        for (f fVar3 : this.f35888l) {
            if (!(fVar3 instanceof g)) {
                i10++;
                fVar2 = fVar3;
            }
        }
        if (fVar2 != null && i10 == 1 && fVar2.f35886j) {
            g gVar = this.f35885i;
            if (gVar != null) {
                if (gVar.f35886j) {
                    this.f35882f = this.f35884h * gVar.f35883g;
                } else {
                    return;
                }
            }
            d(fVar2.f35883g + this.f35882f);
        }
        d dVar3 = this.f35877a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f35887k.add(dVar);
        if (this.f35886j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.f35888l.clear();
        this.f35887k.clear();
        this.f35886j = false;
        this.f35883g = 0;
        this.f35879c = false;
        this.f35878b = false;
    }

    public void d(int i10) {
        if (!this.f35886j) {
            this.f35886j = true;
            this.f35883g = i10;
            for (d dVar : this.f35887k) {
                dVar.a(dVar);
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f35880d.f35908b.r());
        sb2.append(":");
        sb2.append(this.f35881e);
        sb2.append("(");
        sb2.append(this.f35886j ? Integer.valueOf(this.f35883g) : "unresolved");
        sb2.append(") <t=");
        sb2.append(this.f35888l.size());
        sb2.append(":d=");
        sb2.append(this.f35887k.size());
        sb2.append(">");
        return sb2.toString();
    }
}
