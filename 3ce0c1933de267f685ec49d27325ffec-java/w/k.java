package w;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.a;
import w.f;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HelperReferences.java */
/* loaded from: classes.dex */
public class k extends p {
    public k(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void q(f fVar) {
        this.f35914h.f35887k.add(fVar);
        fVar.f35888l.add(this.f35914h);
    }

    @Override // w.p, w.d
    public void a(d dVar) {
        a aVar = (a) this.f35908b;
        int m12 = aVar.m1();
        int i10 = 0;
        int i11 = -1;
        for (f fVar : this.f35914h.f35888l) {
            int i12 = fVar.f35883g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (m12 == 0 || m12 == 2) {
            this.f35914h.d(i11 + aVar.n1());
        } else {
            this.f35914h.d(i10 + aVar.n1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public void d() {
        ConstraintWidget constraintWidget = this.f35908b;
        if (constraintWidget instanceof a) {
            this.f35914h.f35878b = true;
            a aVar = (a) constraintWidget;
            int m12 = aVar.m1();
            boolean l12 = aVar.l1();
            int i10 = 0;
            if (m12 == 0) {
                this.f35914h.f35881e = f.a.LEFT;
                while (i10 < aVar.f35552v0) {
                    ConstraintWidget constraintWidget2 = aVar.f35551u0[i10];
                    if (l12 || constraintWidget2.Q() != 8) {
                        f fVar = constraintWidget2.f1591d.f35914h;
                        fVar.f35887k.add(this.f35914h);
                        this.f35914h.f35888l.add(fVar);
                    }
                    i10++;
                }
                q(this.f35908b.f1591d.f35914h);
                q(this.f35908b.f1591d.f35915i);
            } else if (m12 == 1) {
                this.f35914h.f35881e = f.a.RIGHT;
                while (i10 < aVar.f35552v0) {
                    ConstraintWidget constraintWidget3 = aVar.f35551u0[i10];
                    if (l12 || constraintWidget3.Q() != 8) {
                        f fVar2 = constraintWidget3.f1591d.f35915i;
                        fVar2.f35887k.add(this.f35914h);
                        this.f35914h.f35888l.add(fVar2);
                    }
                    i10++;
                }
                q(this.f35908b.f1591d.f35914h);
                q(this.f35908b.f1591d.f35915i);
            } else if (m12 == 2) {
                this.f35914h.f35881e = f.a.TOP;
                while (i10 < aVar.f35552v0) {
                    ConstraintWidget constraintWidget4 = aVar.f35551u0[i10];
                    if (l12 || constraintWidget4.Q() != 8) {
                        f fVar3 = constraintWidget4.f1593e.f35914h;
                        fVar3.f35887k.add(this.f35914h);
                        this.f35914h.f35888l.add(fVar3);
                    }
                    i10++;
                }
                q(this.f35908b.f1593e.f35914h);
                q(this.f35908b.f1593e.f35915i);
            } else if (m12 == 3) {
                this.f35914h.f35881e = f.a.BOTTOM;
                while (i10 < aVar.f35552v0) {
                    ConstraintWidget constraintWidget5 = aVar.f35551u0[i10];
                    if (l12 || constraintWidget5.Q() != 8) {
                        f fVar4 = constraintWidget5.f1593e.f35915i;
                        fVar4.f35887k.add(this.f35914h);
                        this.f35914h.f35888l.add(fVar4);
                    }
                    i10++;
                }
                q(this.f35908b.f1593e.f35914h);
                q(this.f35908b.f1593e.f35915i);
            }
        }
    }

    @Override // w.p
    public void e() {
        ConstraintWidget constraintWidget = this.f35908b;
        if (constraintWidget instanceof a) {
            int m12 = ((a) constraintWidget).m1();
            if (m12 == 0 || m12 == 1) {
                this.f35908b.d1(this.f35914h.f35883g);
            } else {
                this.f35908b.e1(this.f35914h.f35883g);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public void f() {
        this.f35909c = null;
        this.f35914h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public boolean m() {
        return false;
    }
}
