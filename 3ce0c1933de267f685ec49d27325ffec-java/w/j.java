package w;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GuidelineReference.java */
/* loaded from: classes.dex */
public class j extends p {
    public j(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.f1591d.f();
        constraintWidget.f1593e.f();
        this.f35912f = ((e) constraintWidget).j1();
    }

    private void q(f fVar) {
        this.f35914h.f35887k.add(fVar);
        fVar.f35888l.add(this.f35914h);
    }

    @Override // w.p, w.d
    public void a(d dVar) {
        f fVar = this.f35914h;
        if (fVar.f35879c && !fVar.f35886j) {
            this.f35914h.d((int) ((fVar.f35888l.get(0).f35883g * ((e) this.f35908b).m1()) + 0.5f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public void d() {
        e eVar = (e) this.f35908b;
        int k12 = eVar.k1();
        int l12 = eVar.l1();
        eVar.m1();
        if (eVar.j1() == 1) {
            if (k12 != -1) {
                this.f35914h.f35888l.add(this.f35908b.W.f1591d.f35914h);
                this.f35908b.W.f1591d.f35914h.f35887k.add(this.f35914h);
                this.f35914h.f35882f = k12;
            } else if (l12 != -1) {
                this.f35914h.f35888l.add(this.f35908b.W.f1591d.f35915i);
                this.f35908b.W.f1591d.f35915i.f35887k.add(this.f35914h);
                this.f35914h.f35882f = -l12;
            } else {
                f fVar = this.f35914h;
                fVar.f35878b = true;
                fVar.f35888l.add(this.f35908b.W.f1591d.f35915i);
                this.f35908b.W.f1591d.f35915i.f35887k.add(this.f35914h);
            }
            q(this.f35908b.f1591d.f35914h);
            q(this.f35908b.f1591d.f35915i);
            return;
        }
        if (k12 != -1) {
            this.f35914h.f35888l.add(this.f35908b.W.f1593e.f35914h);
            this.f35908b.W.f1593e.f35914h.f35887k.add(this.f35914h);
            this.f35914h.f35882f = k12;
        } else if (l12 != -1) {
            this.f35914h.f35888l.add(this.f35908b.W.f1593e.f35915i);
            this.f35908b.W.f1593e.f35915i.f35887k.add(this.f35914h);
            this.f35914h.f35882f = -l12;
        } else {
            f fVar2 = this.f35914h;
            fVar2.f35878b = true;
            fVar2.f35888l.add(this.f35908b.W.f1593e.f35915i);
            this.f35908b.W.f1593e.f35915i.f35887k.add(this.f35914h);
        }
        q(this.f35908b.f1593e.f35914h);
        q(this.f35908b.f1593e.f35915i);
    }

    @Override // w.p
    public void e() {
        if (((e) this.f35908b).j1() == 1) {
            this.f35908b.d1(this.f35914h.f35883g);
        } else {
            this.f35908b.e1(this.f35914h.f35883g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public void f() {
        this.f35914h.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public boolean m() {
        return false;
    }
}
