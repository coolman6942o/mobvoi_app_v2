package w;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import w.f;
import w.p;
/* compiled from: VerticalWidgetRun.java */
/* loaded from: classes.dex */
public class n extends p {

    /* renamed from: k  reason: collision with root package name */
    public f f35898k;

    /* renamed from: l  reason: collision with root package name */
    g f35899l = null;

    /* compiled from: VerticalWidgetRun.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35900a;

        static {
            int[] iArr = new int[p.b.values().length];
            f35900a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35900a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35900a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        f fVar = new f(this);
        this.f35898k = fVar;
        this.f35914h.f35881e = f.a.TOP;
        this.f35915i.f35881e = f.a.BOTTOM;
        fVar.f35881e = f.a.BASELINE;
        this.f35912f = 1;
    }

    @Override // w.p, w.d
    public void a(d dVar) {
        g gVar;
        int i10;
        float f10;
        float f11;
        float f12;
        ConstraintWidget constraintWidget;
        int i11 = a.f35900a[this.f35916j.ordinal()];
        if (i11 == 1) {
            p(dVar);
        } else if (i11 == 2) {
            o(dVar);
        } else if (i11 == 3) {
            ConstraintWidget constraintWidget2 = this.f35908b;
            n(dVar, constraintWidget2.L, constraintWidget2.N, 1);
            return;
        }
        g gVar2 = this.f35911e;
        if (gVar2.f35879c && !gVar2.f35886j && this.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f35908b;
            int i12 = constraintWidget3.f1623t;
            if (i12 == 2) {
                ConstraintWidget I = constraintWidget3.I();
                if (I != null) {
                    if (I.f1593e.f35911e.f35886j) {
                        this.f35911e.d((int) ((gVar.f35883g * this.f35908b.A) + 0.5f));
                    }
                }
            } else if (i12 == 3 && constraintWidget3.f1591d.f35911e.f35886j) {
                int u10 = constraintWidget3.u();
                if (u10 == -1) {
                    ConstraintWidget constraintWidget4 = this.f35908b;
                    f12 = constraintWidget4.f1591d.f35911e.f35883g;
                    f11 = constraintWidget4.t();
                } else if (u10 == 0) {
                    f10 = constraintWidget.f1591d.f35911e.f35883g * this.f35908b.t();
                    i10 = (int) (f10 + 0.5f);
                    this.f35911e.d(i10);
                } else if (u10 != 1) {
                    i10 = 0;
                    this.f35911e.d(i10);
                } else {
                    ConstraintWidget constraintWidget5 = this.f35908b;
                    f12 = constraintWidget5.f1591d.f35911e.f35883g;
                    f11 = constraintWidget5.t();
                }
                f10 = f12 / f11;
                i10 = (int) (f10 + 0.5f);
                this.f35911e.d(i10);
            }
        }
        f fVar = this.f35914h;
        if (fVar.f35879c) {
            f fVar2 = this.f35915i;
            if (fVar2.f35879c) {
                if (!fVar.f35886j || !fVar2.f35886j || !this.f35911e.f35886j) {
                    if (!this.f35911e.f35886j && this.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.f35908b;
                        if (constraintWidget6.f1621s == 0 && !constraintWidget6.f0()) {
                            int i13 = this.f35914h.f35888l.get(0).f35883g;
                            f fVar3 = this.f35914h;
                            int i14 = i13 + fVar3.f35882f;
                            int i15 = this.f35915i.f35888l.get(0).f35883g + this.f35915i.f35882f;
                            fVar3.d(i14);
                            this.f35915i.d(i15);
                            this.f35911e.d(i15 - i14);
                            return;
                        }
                    }
                    if (!this.f35911e.f35886j && this.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f35907a == 1 && this.f35914h.f35888l.size() > 0 && this.f35915i.f35888l.size() > 0) {
                        int i16 = (this.f35915i.f35888l.get(0).f35883g + this.f35915i.f35882f) - (this.f35914h.f35888l.get(0).f35883g + this.f35914h.f35882f);
                        g gVar3 = this.f35911e;
                        int i17 = gVar3.f35889m;
                        if (i16 < i17) {
                            gVar3.d(i16);
                        } else {
                            gVar3.d(i17);
                        }
                    }
                    if (this.f35911e.f35886j && this.f35914h.f35888l.size() > 0 && this.f35915i.f35888l.size() > 0) {
                        f fVar4 = this.f35914h.f35888l.get(0);
                        f fVar5 = this.f35915i.f35888l.get(0);
                        int i18 = fVar4.f35883g + this.f35914h.f35882f;
                        int i19 = fVar5.f35883g + this.f35915i.f35882f;
                        float M = this.f35908b.M();
                        if (fVar4 == fVar5) {
                            i18 = fVar4.f35883g;
                            i19 = fVar5.f35883g;
                            M = 0.5f;
                        }
                        this.f35914h.d((int) (i18 + 0.5f + (((i19 - i18) - this.f35911e.f35883g) * M)));
                        this.f35915i.d(this.f35914h.f35883g + this.f35911e.f35883g);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public void d() {
        ConstraintWidget I;
        ConstraintWidget I2;
        ConstraintWidget constraintWidget = this.f35908b;
        if (constraintWidget.f1585a) {
            this.f35911e.d(constraintWidget.v());
        }
        if (!this.f35911e.f35886j) {
            this.f35910d = this.f35908b.O();
            if (this.f35908b.U()) {
                this.f35899l = new w.a(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = this.f35910d;
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (I2 = this.f35908b.I()) != null && I2.O() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int v10 = (I2.v() - this.f35908b.L.e()) - this.f35908b.N.e();
                    b(this.f35914h, I2.f1593e.f35914h, this.f35908b.L.e());
                    b(this.f35915i, I2.f1593e.f35915i, -this.f35908b.N.e());
                    this.f35911e.d(v10);
                    return;
                } else if (this.f35910d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f35911e.d(this.f35908b.v());
                }
            }
        } else if (this.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (I = this.f35908b.I()) != null && I.O() == ConstraintWidget.DimensionBehaviour.FIXED) {
            b(this.f35914h, I.f1593e.f35914h, this.f35908b.L.e());
            b(this.f35915i, I.f1593e.f35915i, -this.f35908b.N.e());
            return;
        }
        g gVar = this.f35911e;
        boolean z10 = gVar.f35886j;
        if (z10) {
            ConstraintWidget constraintWidget2 = this.f35908b;
            if (constraintWidget2.f1585a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.S;
                if (constraintAnchorArr[2].f1579f != null && constraintAnchorArr[3].f1579f != null) {
                    if (constraintWidget2.f0()) {
                        this.f35914h.f35882f = this.f35908b.S[2].e();
                        this.f35915i.f35882f = -this.f35908b.S[3].e();
                    } else {
                        f h10 = h(this.f35908b.S[2]);
                        if (h10 != null) {
                            b(this.f35914h, h10, this.f35908b.S[2].e());
                        }
                        f h11 = h(this.f35908b.S[3]);
                        if (h11 != null) {
                            b(this.f35915i, h11, -this.f35908b.S[3].e());
                        }
                        this.f35914h.f35878b = true;
                        this.f35915i.f35878b = true;
                    }
                    if (this.f35908b.U()) {
                        b(this.f35898k, this.f35914h, this.f35908b.n());
                        return;
                    }
                    return;
                } else if (constraintAnchorArr[2].f1579f != null) {
                    f h12 = h(constraintAnchorArr[2]);
                    if (h12 != null) {
                        b(this.f35914h, h12, this.f35908b.S[2].e());
                        b(this.f35915i, this.f35914h, this.f35911e.f35883g);
                        if (this.f35908b.U()) {
                            b(this.f35898k, this.f35914h, this.f35908b.n());
                            return;
                        }
                        return;
                    }
                    return;
                } else if (constraintAnchorArr[3].f1579f != null) {
                    f h13 = h(constraintAnchorArr[3]);
                    if (h13 != null) {
                        b(this.f35915i, h13, -this.f35908b.S[3].e());
                        b(this.f35914h, this.f35915i, -this.f35911e.f35883g);
                    }
                    if (this.f35908b.U()) {
                        b(this.f35898k, this.f35914h, this.f35908b.n());
                        return;
                    }
                    return;
                } else if (constraintAnchorArr[4].f1579f != null) {
                    f h14 = h(constraintAnchorArr[4]);
                    if (h14 != null) {
                        b(this.f35898k, h14, 0);
                        b(this.f35914h, this.f35898k, -this.f35908b.n());
                        b(this.f35915i, this.f35914h, this.f35911e.f35883g);
                        return;
                    }
                    return;
                } else if (!(constraintWidget2 instanceof v.a) && constraintWidget2.I() != null && this.f35908b.m(ConstraintAnchor.Type.CENTER).f1579f == null) {
                    b(this.f35914h, this.f35908b.I().f1593e.f35914h, this.f35908b.T());
                    b(this.f35915i, this.f35914h, this.f35911e.f35883g);
                    if (this.f35908b.U()) {
                        b(this.f35898k, this.f35914h, this.f35908b.n());
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
        }
        if (z10 || this.f35910d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            ConstraintWidget constraintWidget3 = this.f35908b;
            int i10 = constraintWidget3.f1623t;
            if (i10 == 2) {
                ConstraintWidget I3 = constraintWidget3.I();
                if (I3 != null) {
                    g gVar2 = I3.f1593e.f35911e;
                    this.f35911e.f35888l.add(gVar2);
                    gVar2.f35887k.add(this.f35911e);
                    g gVar3 = this.f35911e;
                    gVar3.f35878b = true;
                    gVar3.f35887k.add(this.f35914h);
                    this.f35911e.f35887k.add(this.f35915i);
                }
            } else if (i10 == 3 && !constraintWidget3.f0()) {
                ConstraintWidget constraintWidget4 = this.f35908b;
                if (constraintWidget4.f1621s != 3) {
                    g gVar4 = constraintWidget4.f1591d.f35911e;
                    this.f35911e.f35888l.add(gVar4);
                    gVar4.f35887k.add(this.f35911e);
                    g gVar5 = this.f35911e;
                    gVar5.f35878b = true;
                    gVar5.f35887k.add(this.f35914h);
                    this.f35911e.f35887k.add(this.f35915i);
                }
            }
        }
        ConstraintWidget constraintWidget5 = this.f35908b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget5.S;
        if (constraintAnchorArr2[2].f1579f != null && constraintAnchorArr2[3].f1579f != null) {
            if (constraintWidget5.f0()) {
                this.f35914h.f35882f = this.f35908b.S[2].e();
                this.f35915i.f35882f = -this.f35908b.S[3].e();
            } else {
                f h15 = h(this.f35908b.S[2]);
                f h16 = h(this.f35908b.S[3]);
                if (h15 != null) {
                    h15.b(this);
                }
                if (h16 != null) {
                    h16.b(this);
                }
                this.f35916j = p.b.CENTER;
            }
            if (this.f35908b.U()) {
                c(this.f35898k, this.f35914h, 1, this.f35899l);
            }
        } else if (constraintAnchorArr2[2].f1579f != null) {
            f h17 = h(constraintAnchorArr2[2]);
            if (h17 != null) {
                b(this.f35914h, h17, this.f35908b.S[2].e());
                c(this.f35915i, this.f35914h, 1, this.f35911e);
                if (this.f35908b.U()) {
                    c(this.f35898k, this.f35914h, 1, this.f35899l);
                }
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f35910d;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (dimensionBehaviour2 == dimensionBehaviour3 && this.f35908b.t() > 0.0f) {
                    l lVar = this.f35908b.f1591d;
                    if (lVar.f35910d == dimensionBehaviour3) {
                        lVar.f35911e.f35887k.add(this.f35911e);
                        this.f35911e.f35888l.add(this.f35908b.f1591d.f35911e);
                        this.f35911e.f35877a = this;
                    }
                }
            }
        } else if (constraintAnchorArr2[3].f1579f != null) {
            f h18 = h(constraintAnchorArr2[3]);
            if (h18 != null) {
                b(this.f35915i, h18, -this.f35908b.S[3].e());
                c(this.f35914h, this.f35915i, -1, this.f35911e);
                if (this.f35908b.U()) {
                    c(this.f35898k, this.f35914h, 1, this.f35899l);
                }
            }
        } else if (constraintAnchorArr2[4].f1579f != null) {
            f h19 = h(constraintAnchorArr2[4]);
            if (h19 != null) {
                b(this.f35898k, h19, 0);
                c(this.f35914h, this.f35898k, -1, this.f35899l);
                c(this.f35915i, this.f35914h, 1, this.f35911e);
            }
        } else if (!(constraintWidget5 instanceof v.a) && constraintWidget5.I() != null) {
            b(this.f35914h, this.f35908b.I().f1593e.f35914h, this.f35908b.T());
            c(this.f35915i, this.f35914h, 1, this.f35911e);
            if (this.f35908b.U()) {
                c(this.f35898k, this.f35914h, 1, this.f35899l);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f35910d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour4 == dimensionBehaviour5 && this.f35908b.t() > 0.0f) {
                l lVar2 = this.f35908b.f1591d;
                if (lVar2.f35910d == dimensionBehaviour5) {
                    lVar2.f35911e.f35887k.add(this.f35911e);
                    this.f35911e.f35888l.add(this.f35908b.f1591d.f35911e);
                    this.f35911e.f35877a = this;
                }
            }
        }
        if (this.f35911e.f35888l.size() == 0) {
            this.f35911e.f35879c = true;
        }
    }

    @Override // w.p
    public void e() {
        f fVar = this.f35914h;
        if (fVar.f35886j) {
            this.f35908b.e1(fVar.f35883g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public void f() {
        this.f35909c = null;
        this.f35914h.c();
        this.f35915i.c();
        this.f35898k.c();
        this.f35911e.c();
        this.f35913g = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public boolean m() {
        return this.f35910d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f35908b.f1623t == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q() {
        this.f35913g = false;
        this.f35914h.c();
        this.f35914h.f35886j = false;
        this.f35915i.c();
        this.f35915i.f35886j = false;
        this.f35898k.c();
        this.f35898k.f35886j = false;
        this.f35911e.f35886j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f35908b.r();
    }
}
