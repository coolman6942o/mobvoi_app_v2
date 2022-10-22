package w;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import w.b;
/* compiled from: DependencyGraph.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private d f35869a;

    /* renamed from: d  reason: collision with root package name */
    private d f35872d;

    /* renamed from: b  reason: collision with root package name */
    private boolean f35870b = true;

    /* renamed from: c  reason: collision with root package name */
    private boolean f35871c = true;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<p> f35873e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private b.AbstractC0518b f35874f = null;

    /* renamed from: g  reason: collision with root package name */
    private b.a f35875g = new b.a();

    /* renamed from: h  reason: collision with root package name */
    ArrayList<m> f35876h = new ArrayList<>();

    public e(d dVar) {
        new ArrayList();
        this.f35869a = dVar;
        this.f35872d = dVar;
    }

    private void a(f fVar, int i10, int i11, f fVar2, ArrayList<m> arrayList, m mVar) {
        p pVar = fVar.f35880d;
        if (pVar.f35909c == null) {
            d dVar = this.f35869a;
            if (!(pVar == dVar.f1591d || pVar == dVar.f1593e)) {
                if (mVar == null) {
                    mVar = new m(pVar, i11);
                    arrayList.add(mVar);
                }
                pVar.f35909c = mVar;
                mVar.a(pVar);
                for (d dVar2 : pVar.f35914h.f35887k) {
                    if (dVar2 instanceof f) {
                        a((f) dVar2, i10, 0, fVar2, arrayList, mVar);
                    }
                }
                for (d dVar3 : pVar.f35915i.f35887k) {
                    if (dVar3 instanceof f) {
                        a((f) dVar3, i10, 1, fVar2, arrayList, mVar);
                    }
                }
                if (i10 == 1 && (pVar instanceof n)) {
                    for (d dVar4 : ((n) pVar).f35898k.f35887k) {
                        if (dVar4 instanceof f) {
                            a((f) dVar4, i10, 2, fVar2, arrayList, mVar);
                        }
                    }
                }
                for (f fVar3 : pVar.f35914h.f35888l) {
                    a(fVar3, i10, 0, fVar2, arrayList, mVar);
                }
                for (f fVar4 : pVar.f35915i.f35888l) {
                    a(fVar4, i10, 1, fVar2, arrayList, mVar);
                }
                if (i10 == 1 && (pVar instanceof n)) {
                    for (f fVar5 : ((n) pVar).f35898k.f35888l) {
                        a(fVar5, i10, 2, fVar2, arrayList, mVar);
                    }
                }
            }
        }
    }

    private boolean b(d dVar) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        int i10;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        int i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        Iterator<ConstraintWidget> it = dVar.f35553u0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.V;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = dimensionBehaviourArr[1];
            if (next.Q() == 8) {
                next.f1585a = true;
            } else {
                if (next.f1627x < 1.0f && dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.f1621s = 2;
                }
                if (next.A < 1.0f && dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    next.f1623t = 2;
                }
                if (next.t() > 0.0f) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (dimensionBehaviour5 == dimensionBehaviour7 && (dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour6 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.f1621s = 3;
                    } else if (dimensionBehaviour6 == dimensionBehaviour7 && (dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour5 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        next.f1623t = 3;
                    } else if (dimensionBehaviour5 == dimensionBehaviour7 && dimensionBehaviour6 == dimensionBehaviour7) {
                        if (next.f1621s == 0) {
                            next.f1621s = 3;
                        }
                        if (next.f1623t == 0) {
                            next.f1623t = 3;
                        }
                    }
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour5 == dimensionBehaviour8 && next.f1621s == 1 && (next.K.f1579f == null || next.M.f1579f == null)) {
                    dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = dimensionBehaviour5;
                if (dimensionBehaviour6 == dimensionBehaviour8 && next.f1623t == 1 && (next.L.f1579f == null || next.N.f1579f == null)) {
                    dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = dimensionBehaviour6;
                l lVar = next.f1591d;
                lVar.f35910d = dimensionBehaviour9;
                int i12 = next.f1621s;
                lVar.f35907a = i12;
                n nVar = next.f1593e;
                nVar.f35910d = dimensionBehaviour10;
                int i13 = next.f1623t;
                nVar.f35907a = i13;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if ((dimensionBehaviour9 == dimensionBehaviour11 || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) && (dimensionBehaviour10 == dimensionBehaviour11 || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT)) {
                    int R = next.R();
                    if (dimensionBehaviour9 == dimensionBehaviour11) {
                        i10 = (dVar.R() - next.K.f1580g) - next.M.f1580g;
                        dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i10 = R;
                        dimensionBehaviour3 = dimensionBehaviour9;
                    }
                    int v10 = next.v();
                    if (dimensionBehaviour10 == dimensionBehaviour11) {
                        i11 = (dVar.v() - next.L.f1580g) - next.N.f1580g;
                        dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    } else {
                        i11 = v10;
                        dimensionBehaviour4 = dimensionBehaviour10;
                    }
                    l(next, dimensionBehaviour3, i10, dimensionBehaviour4, i11);
                    next.f1591d.f35911e.d(next.R());
                    next.f1593e.f35911e.d(next.v());
                    next.f1585a = true;
                } else {
                    if (dimensionBehaviour9 == dimensionBehaviour8 && (dimensionBehaviour10 == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour10 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i12 == 3) {
                            if (dimensionBehaviour10 == dimensionBehaviour2) {
                                l(next, dimensionBehaviour2, 0, dimensionBehaviour2, 0);
                            }
                            int v11 = next.v();
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(next, dimensionBehaviour12, (int) ((v11 * next.Z) + 0.5f), dimensionBehaviour12, v11);
                            next.f1591d.f35911e.d(next.R());
                            next.f1593e.f35911e.d(next.v());
                            next.f1585a = true;
                        } else if (i12 == 1) {
                            l(next, dimensionBehaviour2, 0, dimensionBehaviour10, 0);
                            next.f1591d.f35911e.f35889m = next.R();
                        } else if (i12 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dVar.V;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = dimensionBehaviourArr2[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour13 == dimensionBehaviour14 || dimensionBehaviourArr2[0] == dimensionBehaviour11) {
                                l(next, dimensionBehaviour14, (int) ((next.f1627x * dVar.R()) + 0.5f), dimensionBehaviour10, next.v());
                                next.f1591d.f35911e.d(next.R());
                                next.f1593e.f35911e.d(next.v());
                                next.f1585a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr = next.S;
                            if (constraintAnchorArr[0].f1579f == null || constraintAnchorArr[1].f1579f == null) {
                                l(next, dimensionBehaviour2, 0, dimensionBehaviour10, 0);
                                next.f1591d.f35911e.d(next.R());
                                next.f1593e.f35911e.d(next.v());
                                next.f1585a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour10 == dimensionBehaviour8 && (dimensionBehaviour9 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour9 == ConstraintWidget.DimensionBehaviour.FIXED)) {
                        if (i13 == 3) {
                            if (dimensionBehaviour9 == dimensionBehaviour) {
                                l(next, dimensionBehaviour, 0, dimensionBehaviour, 0);
                            }
                            int R2 = next.R();
                            float f10 = next.Z;
                            if (next.u() == -1) {
                                f10 = 1.0f / f10;
                            }
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = ConstraintWidget.DimensionBehaviour.FIXED;
                            l(next, dimensionBehaviour15, R2, dimensionBehaviour15, (int) ((R2 * f10) + 0.5f));
                            next.f1591d.f35911e.d(next.R());
                            next.f1593e.f35911e.d(next.v());
                            next.f1585a = true;
                        } else if (i13 == 1) {
                            l(next, dimensionBehaviour9, 0, dimensionBehaviour, 0);
                            next.f1593e.f35911e.f35889m = next.v();
                        } else if (i13 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = dVar.V;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = dimensionBehaviourArr3[1];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour16 == dimensionBehaviour17 || dimensionBehaviourArr3[1] == dimensionBehaviour11) {
                                l(next, dimensionBehaviour9, next.R(), dimensionBehaviour17, (int) ((next.A * dVar.v()) + 0.5f));
                                next.f1591d.f35911e.d(next.R());
                                next.f1593e.f35911e.d(next.v());
                                next.f1585a = true;
                            }
                        } else {
                            ConstraintAnchor[] constraintAnchorArr2 = next.S;
                            if (constraintAnchorArr2[2].f1579f == null || constraintAnchorArr2[3].f1579f == null) {
                                l(next, dimensionBehaviour, 0, dimensionBehaviour10, 0);
                                next.f1591d.f35911e.d(next.R());
                                next.f1593e.f35911e.d(next.v());
                                next.f1585a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour9 == dimensionBehaviour8 && dimensionBehaviour10 == dimensionBehaviour8) {
                        if (i12 == 1 || i13 == 1) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour18 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                            l(next, dimensionBehaviour18, 0, dimensionBehaviour18, 0);
                            next.f1591d.f35911e.f35889m = next.R();
                            next.f1593e.f35911e.f35889m = next.v();
                        } else if (i13 == 2 && i12 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr4 = dVar.V;
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour19 = dimensionBehaviourArr4[0];
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour20 = ConstraintWidget.DimensionBehaviour.FIXED;
                            if (dimensionBehaviour19 == dimensionBehaviour20 && dimensionBehaviourArr4[1] == dimensionBehaviour20) {
                                l(next, dimensionBehaviour20, (int) ((next.f1627x * dVar.R()) + 0.5f), dimensionBehaviour20, (int) ((next.A * dVar.v()) + 0.5f));
                                next.f1591d.f35911e.d(next.R());
                                next.f1593e.f35911e.d(next.v());
                                next.f1585a = true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    private int e(d dVar, int i10) {
        int size = this.f35876h.size();
        long j10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            j10 = Math.max(j10, this.f35876h.get(i11).b(dVar, i10));
        }
        return (int) j10;
    }

    private void i(p pVar, int i10, ArrayList<m> arrayList) {
        for (d dVar : pVar.f35914h.f35887k) {
            if (dVar instanceof f) {
                a((f) dVar, i10, 0, pVar.f35915i, arrayList, null);
            } else if (dVar instanceof p) {
                a(((p) dVar).f35914h, i10, 0, pVar.f35915i, arrayList, null);
            }
        }
        for (d dVar2 : pVar.f35915i.f35887k) {
            if (dVar2 instanceof f) {
                a((f) dVar2, i10, 1, pVar.f35914h, arrayList, null);
            } else if (dVar2 instanceof p) {
                a(((p) dVar2).f35915i, i10, 1, pVar.f35914h, arrayList, null);
            }
        }
        if (i10 == 1) {
            for (d dVar3 : ((n) pVar).f35898k.f35887k) {
                if (dVar3 instanceof f) {
                    a((f) dVar3, i10, 2, null, arrayList, null);
                }
            }
        }
    }

    private void l(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i10, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i11) {
        b.a aVar = this.f35875g;
        aVar.f35857a = dimensionBehaviour;
        aVar.f35858b = dimensionBehaviour2;
        aVar.f35859c = i10;
        aVar.f35860d = i11;
        this.f35874f.b(constraintWidget, aVar);
        constraintWidget.b1(this.f35875g.f35861e);
        constraintWidget.C0(this.f35875g.f35862f);
        constraintWidget.B0(this.f35875g.f35864h);
        constraintWidget.r0(this.f35875g.f35863g);
    }

    public void c() {
        d(this.f35873e);
        this.f35876h.clear();
        m.f35895c = 0;
        i(this.f35869a.f1591d, 0, this.f35876h);
        i(this.f35869a.f1593e, 1, this.f35876h);
        this.f35870b = false;
    }

    public void d(ArrayList<p> arrayList) {
        arrayList.clear();
        this.f35872d.f1591d.f();
        this.f35872d.f1593e.f();
        arrayList.add(this.f35872d.f1591d);
        arrayList.add(this.f35872d.f1593e);
        Iterator<ConstraintWidget> it = this.f35872d.f35553u0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (next instanceof androidx.constraintlayout.core.widgets.e) {
                arrayList.add(new j(next));
            } else {
                if (next.d0()) {
                    if (next.f1587b == null) {
                        next.f1587b = new c(next, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f1587b);
                } else {
                    arrayList.add(next.f1591d);
                }
                if (next.f0()) {
                    if (next.f1589c == null) {
                        next.f1589c = new c(next, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(next.f1589c);
                } else {
                    arrayList.add(next.f1593e);
                }
                if (next instanceof v.b) {
                    arrayList.add(new k(next));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator<p> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            it2.next().f();
        }
        Iterator<p> it3 = arrayList.iterator();
        while (it3.hasNext()) {
            p next2 = it3.next();
            if (next2.f35908b != this.f35872d) {
                next2.d();
            }
        }
    }

    public boolean f(boolean z10) {
        boolean z11;
        boolean z12 = true;
        boolean z13 = z10 & true;
        if (this.f35870b || this.f35871c) {
            Iterator<ConstraintWidget> it = this.f35869a.f35553u0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.l();
                next.f1585a = false;
                next.f1591d.r();
                next.f1593e.q();
            }
            this.f35869a.l();
            d dVar = this.f35869a;
            dVar.f1585a = false;
            dVar.f1591d.r();
            this.f35869a.f1593e.q();
            this.f35871c = false;
        }
        if (b(this.f35872d)) {
            return false;
        }
        this.f35869a.d1(0);
        this.f35869a.e1(0);
        ConstraintWidget.DimensionBehaviour s10 = this.f35869a.s(0);
        ConstraintWidget.DimensionBehaviour s11 = this.f35869a.s(1);
        if (this.f35870b) {
            c();
        }
        int S = this.f35869a.S();
        int T = this.f35869a.T();
        this.f35869a.f1591d.f35914h.d(S);
        this.f35869a.f1593e.f35914h.d(T);
        m();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (s10 == dimensionBehaviour || s11 == dimensionBehaviour) {
            if (z13) {
                Iterator<p> it2 = this.f35873e.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!it2.next().m()) {
                            z13 = false;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            if (z13 && s10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f35869a.G0(ConstraintWidget.DimensionBehaviour.FIXED);
                d dVar2 = this.f35869a;
                dVar2.b1(e(dVar2, 0));
                d dVar3 = this.f35869a;
                dVar3.f1591d.f35911e.d(dVar3.R());
            }
            if (z13 && s11 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f35869a.X0(ConstraintWidget.DimensionBehaviour.FIXED);
                d dVar4 = this.f35869a;
                dVar4.C0(e(dVar4, 1));
                d dVar5 = this.f35869a;
                dVar5.f1593e.f35911e.d(dVar5.v());
            }
        }
        d dVar6 = this.f35869a;
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = dVar6.V;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        if (dimensionBehaviour2 == dimensionBehaviour3 || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int R = dVar6.R() + S;
            this.f35869a.f1591d.f35915i.d(R);
            this.f35869a.f1591d.f35911e.d(R - S);
            m();
            d dVar7 = this.f35869a;
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dVar7.V;
            if (dimensionBehaviourArr2[1] == dimensionBehaviour3 || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int v10 = dVar7.v() + T;
                this.f35869a.f1593e.f35915i.d(v10);
                this.f35869a.f1593e.f35911e.d(v10 - T);
            }
            m();
            z11 = true;
        } else {
            z11 = false;
        }
        Iterator<p> it3 = this.f35873e.iterator();
        while (it3.hasNext()) {
            p next2 = it3.next();
            if (next2.f35908b != this.f35869a || next2.f35913g) {
                next2.e();
            }
        }
        Iterator<p> it4 = this.f35873e.iterator();
        while (it4.hasNext()) {
            p next3 = it4.next();
            if (z11 || next3.f35908b != this.f35869a) {
                if (!next3.f35914h.f35886j || ((!next3.f35915i.f35886j && !(next3 instanceof j)) || (!next3.f35911e.f35886j && !(next3 instanceof c) && !(next3 instanceof j)))) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f35869a.G0(s10);
        this.f35869a.X0(s11);
        return z12;
    }

    public boolean g(boolean z10) {
        if (this.f35870b) {
            Iterator<ConstraintWidget> it = this.f35869a.f35553u0.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                next.l();
                next.f1585a = false;
                l lVar = next.f1591d;
                lVar.f35911e.f35886j = false;
                lVar.f35913g = false;
                lVar.r();
                n nVar = next.f1593e;
                nVar.f35911e.f35886j = false;
                nVar.f35913g = false;
                nVar.q();
            }
            this.f35869a.l();
            d dVar = this.f35869a;
            dVar.f1585a = false;
            l lVar2 = dVar.f1591d;
            lVar2.f35911e.f35886j = false;
            lVar2.f35913g = false;
            lVar2.r();
            n nVar2 = this.f35869a.f1593e;
            nVar2.f35911e.f35886j = false;
            nVar2.f35913g = false;
            nVar2.q();
            c();
        }
        if (b(this.f35872d)) {
            return false;
        }
        this.f35869a.d1(0);
        this.f35869a.e1(0);
        this.f35869a.f1591d.f35914h.d(0);
        this.f35869a.f1593e.f35914h.d(0);
        return true;
    }

    public boolean h(boolean z10, int i10) {
        boolean z11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        boolean z12 = true;
        boolean z13 = z10 & true;
        ConstraintWidget.DimensionBehaviour s10 = this.f35869a.s(0);
        ConstraintWidget.DimensionBehaviour s11 = this.f35869a.s(1);
        int S = this.f35869a.S();
        int T = this.f35869a.T();
        if (z13 && (s10 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || s11 == dimensionBehaviour)) {
            Iterator<p> it = this.f35873e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p next = it.next();
                if (next.f35912f == i10 && !next.m()) {
                    z13 = false;
                    break;
                }
            }
            if (i10 == 0) {
                if (z13 && s10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    this.f35869a.G0(ConstraintWidget.DimensionBehaviour.FIXED);
                    d dVar = this.f35869a;
                    dVar.b1(e(dVar, 0));
                    d dVar2 = this.f35869a;
                    dVar2.f1591d.f35911e.d(dVar2.R());
                }
            } else if (z13 && s11 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                this.f35869a.X0(ConstraintWidget.DimensionBehaviour.FIXED);
                d dVar3 = this.f35869a;
                dVar3.C0(e(dVar3, 1));
                d dVar4 = this.f35869a;
                dVar4.f1593e.f35911e.d(dVar4.v());
            }
        }
        if (i10 == 0) {
            d dVar5 = this.f35869a;
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = dVar5.V;
            if (dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int R = dVar5.R() + S;
                this.f35869a.f1591d.f35915i.d(R);
                this.f35869a.f1591d.f35911e.d(R - S);
                z11 = true;
            }
            z11 = false;
        } else {
            d dVar6 = this.f35869a;
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = dVar6.V;
            if (dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviourArr2[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
                int v10 = dVar6.v() + T;
                this.f35869a.f1593e.f35915i.d(v10);
                this.f35869a.f1593e.f35911e.d(v10 - T);
                z11 = true;
            }
            z11 = false;
        }
        m();
        Iterator<p> it2 = this.f35873e.iterator();
        while (it2.hasNext()) {
            p next2 = it2.next();
            if (next2.f35912f == i10 && (next2.f35908b != this.f35869a || next2.f35913g)) {
                next2.e();
            }
        }
        Iterator<p> it3 = this.f35873e.iterator();
        while (it3.hasNext()) {
            p next3 = it3.next();
            if (next3.f35912f == i10 && (z11 || next3.f35908b != this.f35869a)) {
                if (!next3.f35914h.f35886j || !next3.f35915i.f35886j || (!(next3 instanceof c) && !next3.f35911e.f35886j)) {
                    z12 = false;
                    break;
                }
            }
        }
        this.f35869a.G0(s10);
        this.f35869a.X0(s11);
        return z12;
    }

    public void j() {
        this.f35870b = true;
    }

    public void k() {
        this.f35871c = true;
    }

    public void m() {
        g gVar;
        Iterator<ConstraintWidget> it = this.f35869a.f35553u0.iterator();
        while (it.hasNext()) {
            ConstraintWidget next = it.next();
            if (!next.f1585a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = next.V;
                boolean z10 = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i10 = next.f1621s;
                int i11 = next.f1623t;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                boolean z11 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i10 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && i11 == 1)) {
                    z10 = true;
                }
                g gVar2 = next.f1591d.f35911e;
                boolean z12 = gVar2.f35886j;
                g gVar3 = next.f1593e.f35911e;
                boolean z13 = gVar3.f35886j;
                if (z12 && z13) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                    l(next, dimensionBehaviour4, gVar2.f35883g, dimensionBehaviour4, gVar3.f35883g);
                    next.f1585a = true;
                } else if (z12 && z10) {
                    l(next, ConstraintWidget.DimensionBehaviour.FIXED, gVar2.f35883g, dimensionBehaviour3, gVar3.f35883g);
                    if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f1593e.f35911e.f35889m = next.v();
                    } else {
                        next.f1593e.f35911e.d(next.v());
                        next.f1585a = true;
                    }
                } else if (z13 && z11) {
                    l(next, dimensionBehaviour3, gVar2.f35883g, ConstraintWidget.DimensionBehaviour.FIXED, gVar3.f35883g);
                    if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        next.f1591d.f35911e.f35889m = next.R();
                    } else {
                        next.f1591d.f35911e.d(next.R());
                        next.f1585a = true;
                    }
                }
                if (next.f1585a && (gVar = next.f1593e.f35899l) != null) {
                    gVar.d(next.n());
                }
            }
        }
    }

    public void n(b.AbstractC0518b bVar) {
        this.f35874f = bVar;
    }
}
