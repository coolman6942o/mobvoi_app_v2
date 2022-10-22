package w;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import w.f;
import w.p;
/* compiled from: HorizontalWidgetRun.java */
/* loaded from: classes.dex */
public class l extends p {

    /* renamed from: k  reason: collision with root package name */
    private static int[] f35893k = new int[2];

    /* compiled from: HorizontalWidgetRun.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f35894a;

        static {
            int[] iArr = new int[p.b.values().length];
            f35894a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f35894a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f35894a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f35914h.f35881e = f.a.LEFT;
        this.f35915i.f35881e = f.a.RIGHT;
        this.f35912f = 0;
    }

    private void q(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 == -1) {
            int i17 = (int) ((i16 * f10) + 0.5f);
            int i18 = (int) ((i15 / f10) + 0.5f);
            if (i17 <= i15) {
                iArr[0] = i17;
                iArr[1] = i16;
            } else if (i18 <= i16) {
                iArr[0] = i15;
                iArr[1] = i18;
            }
        } else if (i14 == 0) {
            iArr[0] = (int) ((i16 * f10) + 0.5f);
            iArr[1] = i16;
        } else if (i14 == 1) {
            iArr[0] = i15;
            iArr[1] = (int) ((i15 * f10) + 0.5f);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x02b9, code lost:
        if (r14 != 1) goto L125;
     */
    @Override // w.p, w.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d dVar) {
        g gVar;
        int i10;
        float f10;
        float f11;
        float f12;
        ConstraintWidget constraintWidget;
        int i11 = a.f35894a[this.f35916j.ordinal()];
        if (i11 == 1) {
            p(dVar);
        } else if (i11 == 2) {
            o(dVar);
        } else if (i11 == 3) {
            ConstraintWidget constraintWidget2 = this.f35908b;
            n(dVar, constraintWidget2.K, constraintWidget2.M, 0);
            return;
        }
        if (!this.f35911e.f35886j && this.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f35908b;
            int i12 = constraintWidget3.f1621s;
            if (i12 == 2) {
                ConstraintWidget I = constraintWidget3.I();
                if (I != null) {
                    if (I.f1591d.f35911e.f35886j) {
                        this.f35911e.d((int) ((gVar.f35883g * this.f35908b.f1627x) + 0.5f));
                    }
                }
            } else if (i12 == 3) {
                int i13 = constraintWidget3.f1623t;
                if (i13 == 0 || i13 == 3) {
                    n nVar = constraintWidget3.f1593e;
                    f fVar = nVar.f35914h;
                    f fVar2 = nVar.f35915i;
                    boolean z10 = constraintWidget3.K.f1579f != null;
                    boolean z11 = constraintWidget3.L.f1579f != null;
                    boolean z12 = constraintWidget3.M.f1579f != null;
                    boolean z13 = constraintWidget3.N.f1579f != null;
                    int u10 = constraintWidget3.u();
                    if (z10 && z11 && z12 && z13) {
                        float t10 = this.f35908b.t();
                        if (!fVar.f35886j || !fVar2.f35886j) {
                            f fVar3 = this.f35914h;
                            if (fVar3.f35886j) {
                                f fVar4 = this.f35915i;
                                if (fVar4.f35886j) {
                                    if (fVar.f35879c && fVar2.f35879c) {
                                        q(f35893k, fVar3.f35883g + fVar3.f35882f, fVar4.f35883g - fVar4.f35882f, fVar.f35888l.get(0).f35883g + fVar.f35882f, fVar2.f35888l.get(0).f35883g - fVar2.f35882f, t10, u10);
                                        this.f35911e.d(f35893k[0]);
                                        this.f35908b.f1593e.f35911e.d(f35893k[1]);
                                    } else {
                                        return;
                                    }
                                }
                            }
                            f fVar5 = this.f35914h;
                            if (fVar5.f35879c && this.f35915i.f35879c && fVar.f35879c && fVar2.f35879c) {
                                q(f35893k, fVar5.f35888l.get(0).f35883g + this.f35914h.f35882f, this.f35915i.f35888l.get(0).f35883g - this.f35915i.f35882f, fVar.f35888l.get(0).f35883g + fVar.f35882f, fVar2.f35888l.get(0).f35883g - fVar2.f35882f, t10, u10);
                                this.f35911e.d(f35893k[0]);
                                this.f35908b.f1593e.f35911e.d(f35893k[1]);
                            } else {
                                return;
                            }
                        } else {
                            f fVar6 = this.f35914h;
                            if (fVar6.f35879c && this.f35915i.f35879c) {
                                q(f35893k, fVar6.f35888l.get(0).f35883g + this.f35914h.f35882f, this.f35915i.f35888l.get(0).f35883g - this.f35915i.f35882f, fVar.f35883g + fVar.f35882f, fVar2.f35883g - fVar2.f35882f, t10, u10);
                                this.f35911e.d(f35893k[0]);
                                this.f35908b.f1593e.f35911e.d(f35893k[1]);
                                return;
                            }
                            return;
                        }
                    } else if (!z10 || !z12) {
                        if (z11 && z13) {
                            if (fVar.f35879c && fVar2.f35879c) {
                                float t11 = this.f35908b.t();
                                int i14 = fVar.f35888l.get(0).f35883g + fVar.f35882f;
                                int i15 = fVar2.f35888l.get(0).f35883g - fVar2.f35882f;
                                if (u10 != -1) {
                                    if (u10 == 0) {
                                        int g10 = g(i15 - i14, 1);
                                        int i16 = (int) ((g10 * t11) + 0.5f);
                                        int g11 = g(i16, 0);
                                        if (i16 != g11) {
                                            g10 = (int) ((g11 / t11) + 0.5f);
                                        }
                                        this.f35911e.d(g11);
                                        this.f35908b.f1593e.f35911e.d(g10);
                                    }
                                }
                                int g12 = g(i15 - i14, 1);
                                int i17 = (int) ((g12 / t11) + 0.5f);
                                int g13 = g(i17, 0);
                                if (i17 != g13) {
                                    g12 = (int) ((g13 * t11) + 0.5f);
                                }
                                this.f35911e.d(g13);
                                this.f35908b.f1593e.f35911e.d(g12);
                            } else {
                                return;
                            }
                        }
                    } else if (this.f35914h.f35879c && this.f35915i.f35879c) {
                        float t12 = this.f35908b.t();
                        int i18 = this.f35914h.f35888l.get(0).f35883g + this.f35914h.f35882f;
                        int i19 = this.f35915i.f35888l.get(0).f35883g - this.f35915i.f35882f;
                        if (u10 == -1 || u10 == 0) {
                            int g14 = g(i19 - i18, 0);
                            int i20 = (int) ((g14 * t12) + 0.5f);
                            int g15 = g(i20, 1);
                            if (i20 != g15) {
                                g14 = (int) ((g15 / t12) + 0.5f);
                            }
                            this.f35911e.d(g14);
                            this.f35908b.f1593e.f35911e.d(g15);
                        } else if (u10 == 1) {
                            int g16 = g(i19 - i18, 0);
                            int i21 = (int) ((g16 / t12) + 0.5f);
                            int g17 = g(i21, 1);
                            if (i21 != g17) {
                                g16 = (int) ((g17 * t12) + 0.5f);
                            }
                            this.f35911e.d(g16);
                            this.f35908b.f1593e.f35911e.d(g17);
                        }
                    } else {
                        return;
                    }
                } else {
                    int u11 = constraintWidget3.u();
                    if (u11 == -1) {
                        ConstraintWidget constraintWidget4 = this.f35908b;
                        f11 = constraintWidget4.f1593e.f35911e.f35883g;
                        f12 = constraintWidget4.t();
                    } else if (u11 == 0) {
                        f10 = constraintWidget.f1593e.f35911e.f35883g / this.f35908b.t();
                        i10 = (int) (f10 + 0.5f);
                        this.f35911e.d(i10);
                    } else if (u11 != 1) {
                        i10 = 0;
                        this.f35911e.d(i10);
                    } else {
                        ConstraintWidget constraintWidget5 = this.f35908b;
                        f11 = constraintWidget5.f1593e.f35911e.f35883g;
                        f12 = constraintWidget5.t();
                    }
                    f10 = f11 * f12;
                    i10 = (int) (f10 + 0.5f);
                    this.f35911e.d(i10);
                }
            }
        }
        f fVar7 = this.f35914h;
        if (fVar7.f35879c) {
            f fVar8 = this.f35915i;
            if (fVar8.f35879c) {
                if (!fVar7.f35886j || !fVar8.f35886j || !this.f35911e.f35886j) {
                    if (!this.f35911e.f35886j && this.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        ConstraintWidget constraintWidget6 = this.f35908b;
                        if (constraintWidget6.f1621s == 0 && !constraintWidget6.d0()) {
                            int i22 = this.f35914h.f35888l.get(0).f35883g;
                            f fVar9 = this.f35914h;
                            int i23 = i22 + fVar9.f35882f;
                            int i24 = this.f35915i.f35888l.get(0).f35883g + this.f35915i.f35882f;
                            fVar9.d(i23);
                            this.f35915i.d(i24);
                            this.f35911e.d(i24 - i23);
                            return;
                        }
                    }
                    if (!this.f35911e.f35886j && this.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.f35907a == 1 && this.f35914h.f35888l.size() > 0 && this.f35915i.f35888l.size() > 0) {
                        int min = Math.min((this.f35915i.f35888l.get(0).f35883g + this.f35915i.f35882f) - (this.f35914h.f35888l.get(0).f35883g + this.f35914h.f35882f), this.f35911e.f35889m);
                        ConstraintWidget constraintWidget7 = this.f35908b;
                        int i25 = constraintWidget7.f1626w;
                        int max = Math.max(constraintWidget7.f1625v, min);
                        if (i25 > 0) {
                            max = Math.min(i25, max);
                        }
                        this.f35911e.d(max);
                    }
                    if (this.f35911e.f35886j) {
                        f fVar10 = this.f35914h.f35888l.get(0);
                        f fVar11 = this.f35915i.f35888l.get(0);
                        int i26 = fVar10.f35883g + this.f35914h.f35882f;
                        int i27 = fVar11.f35883g + this.f35915i.f35882f;
                        float w10 = this.f35908b.w();
                        if (fVar10 == fVar11) {
                            i26 = fVar10.f35883g;
                            i27 = fVar11.f35883g;
                            w10 = 0.5f;
                        }
                        this.f35914h.d((int) (i26 + 0.5f + (((i27 - i26) - this.f35911e.f35883g) * w10)));
                        this.f35915i.d(this.f35914h.f35883g + this.f35911e.f35883g);
                    }
                }
            }
        }
    }

    @Override // w.p
    void d() {
        ConstraintWidget I;
        ConstraintWidget I2;
        ConstraintWidget constraintWidget = this.f35908b;
        if (constraintWidget.f1585a) {
            this.f35911e.d(constraintWidget.R());
        }
        if (!this.f35911e.f35886j) {
            ConstraintWidget.DimensionBehaviour y10 = this.f35908b.y();
            this.f35910d = y10;
            if (y10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                if (y10 == dimensionBehaviour && (I2 = this.f35908b.I()) != null && (I2.y() == ConstraintWidget.DimensionBehaviour.FIXED || I2.y() == dimensionBehaviour)) {
                    int R = (I2.R() - this.f35908b.K.e()) - this.f35908b.M.e();
                    b(this.f35914h, I2.f1591d.f35914h, this.f35908b.K.e());
                    b(this.f35915i, I2.f1591d.f35915i, -this.f35908b.M.e());
                    this.f35911e.d(R);
                    return;
                } else if (this.f35910d == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.f35911e.d(this.f35908b.R());
                }
            }
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = this.f35910d;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
            if (dimensionBehaviour2 == dimensionBehaviour3 && (I = this.f35908b.I()) != null && (I.y() == ConstraintWidget.DimensionBehaviour.FIXED || I.y() == dimensionBehaviour3)) {
                b(this.f35914h, I.f1591d.f35914h, this.f35908b.K.e());
                b(this.f35915i, I.f1591d.f35915i, -this.f35908b.M.e());
                return;
            }
        }
        g gVar = this.f35911e;
        if (gVar.f35886j) {
            ConstraintWidget constraintWidget2 = this.f35908b;
            if (constraintWidget2.f1585a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget2.S;
                if (constraintAnchorArr[0].f1579f == null || constraintAnchorArr[1].f1579f == null) {
                    if (constraintAnchorArr[0].f1579f != null) {
                        f h10 = h(constraintAnchorArr[0]);
                        if (h10 != null) {
                            b(this.f35914h, h10, this.f35908b.S[0].e());
                            b(this.f35915i, this.f35914h, this.f35911e.f35883g);
                            return;
                        }
                        return;
                    } else if (constraintAnchorArr[1].f1579f != null) {
                        f h11 = h(constraintAnchorArr[1]);
                        if (h11 != null) {
                            b(this.f35915i, h11, -this.f35908b.S[1].e());
                            b(this.f35914h, this.f35915i, -this.f35911e.f35883g);
                            return;
                        }
                        return;
                    } else if (!(constraintWidget2 instanceof v.a) && constraintWidget2.I() != null && this.f35908b.m(ConstraintAnchor.Type.CENTER).f1579f == null) {
                        b(this.f35914h, this.f35908b.I().f1591d.f35914h, this.f35908b.S());
                        b(this.f35915i, this.f35914h, this.f35911e.f35883g);
                        return;
                    } else {
                        return;
                    }
                } else if (constraintWidget2.d0()) {
                    this.f35914h.f35882f = this.f35908b.S[0].e();
                    this.f35915i.f35882f = -this.f35908b.S[1].e();
                    return;
                } else {
                    f h12 = h(this.f35908b.S[0]);
                    if (h12 != null) {
                        b(this.f35914h, h12, this.f35908b.S[0].e());
                    }
                    f h13 = h(this.f35908b.S[1]);
                    if (h13 != null) {
                        b(this.f35915i, h13, -this.f35908b.S[1].e());
                    }
                    this.f35914h.f35878b = true;
                    this.f35915i.f35878b = true;
                    return;
                }
            }
        }
        if (this.f35910d == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            ConstraintWidget constraintWidget3 = this.f35908b;
            int i10 = constraintWidget3.f1621s;
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
            } else if (i10 == 3) {
                if (constraintWidget3.f1623t == 3) {
                    this.f35914h.f35877a = this;
                    this.f35915i.f35877a = this;
                    n nVar = constraintWidget3.f1593e;
                    nVar.f35914h.f35877a = this;
                    nVar.f35915i.f35877a = this;
                    gVar.f35877a = this;
                    if (constraintWidget3.f0()) {
                        this.f35911e.f35888l.add(this.f35908b.f1593e.f35911e);
                        this.f35908b.f1593e.f35911e.f35887k.add(this.f35911e);
                        n nVar2 = this.f35908b.f1593e;
                        nVar2.f35911e.f35877a = this;
                        this.f35911e.f35888l.add(nVar2.f35914h);
                        this.f35911e.f35888l.add(this.f35908b.f1593e.f35915i);
                        this.f35908b.f1593e.f35914h.f35887k.add(this.f35911e);
                        this.f35908b.f1593e.f35915i.f35887k.add(this.f35911e);
                    } else if (this.f35908b.d0()) {
                        this.f35908b.f1593e.f35911e.f35888l.add(this.f35911e);
                        this.f35911e.f35887k.add(this.f35908b.f1593e.f35911e);
                    } else {
                        this.f35908b.f1593e.f35911e.f35888l.add(this.f35911e);
                    }
                } else {
                    g gVar4 = constraintWidget3.f1593e.f35911e;
                    gVar.f35888l.add(gVar4);
                    gVar4.f35887k.add(this.f35911e);
                    this.f35908b.f1593e.f35914h.f35887k.add(this.f35911e);
                    this.f35908b.f1593e.f35915i.f35887k.add(this.f35911e);
                    g gVar5 = this.f35911e;
                    gVar5.f35878b = true;
                    gVar5.f35887k.add(this.f35914h);
                    this.f35911e.f35887k.add(this.f35915i);
                    this.f35914h.f35888l.add(this.f35911e);
                    this.f35915i.f35888l.add(this.f35911e);
                }
            }
        }
        ConstraintWidget constraintWidget4 = this.f35908b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget4.S;
        if (constraintAnchorArr2[0].f1579f == null || constraintAnchorArr2[1].f1579f == null) {
            if (constraintAnchorArr2[0].f1579f != null) {
                f h14 = h(constraintAnchorArr2[0]);
                if (h14 != null) {
                    b(this.f35914h, h14, this.f35908b.S[0].e());
                    c(this.f35915i, this.f35914h, 1, this.f35911e);
                }
            } else if (constraintAnchorArr2[1].f1579f != null) {
                f h15 = h(constraintAnchorArr2[1]);
                if (h15 != null) {
                    b(this.f35915i, h15, -this.f35908b.S[1].e());
                    c(this.f35914h, this.f35915i, -1, this.f35911e);
                }
            } else if (!(constraintWidget4 instanceof v.a) && constraintWidget4.I() != null) {
                b(this.f35914h, this.f35908b.I().f1591d.f35914h, this.f35908b.S());
                c(this.f35915i, this.f35914h, 1, this.f35911e);
            }
        } else if (constraintWidget4.d0()) {
            this.f35914h.f35882f = this.f35908b.S[0].e();
            this.f35915i.f35882f = -this.f35908b.S[1].e();
        } else {
            f h16 = h(this.f35908b.S[0]);
            f h17 = h(this.f35908b.S[1]);
            if (h16 != null) {
                h16.b(this);
            }
            if (h17 != null) {
                h17.b(this);
            }
            this.f35916j = p.b.CENTER;
        }
    }

    @Override // w.p
    public void e() {
        f fVar = this.f35914h;
        if (fVar.f35886j) {
            this.f35908b.d1(fVar.f35883g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // w.p
    public void f() {
        this.f35909c = null;
        this.f35914h.c();
        this.f35915i.c();
        this.f35911e.c();
        this.f35913g = false;
    }

    @Override // w.p
    boolean m() {
        return this.f35910d != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || this.f35908b.f1621s == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        this.f35913g = false;
        this.f35914h.c();
        this.f35914h.f35886j = false;
        this.f35915i.c();
        this.f35915i.f35886j = false;
        this.f35911e.f35886j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f35908b.r();
    }
}
