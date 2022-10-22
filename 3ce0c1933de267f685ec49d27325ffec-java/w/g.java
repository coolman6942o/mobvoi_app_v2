package w;

import w.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DimensionDependency.java */
/* loaded from: classes.dex */
public class g extends f {

    /* renamed from: m  reason: collision with root package name */
    public int f35889m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f35881e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f35881e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // w.f
    public void d(int i10) {
        if (!this.f35886j) {
            this.f35886j = true;
            this.f35883g = i10;
            for (d dVar : this.f35887k) {
                dVar.a(dVar);
            }
        }
    }
}
