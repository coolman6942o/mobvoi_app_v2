package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import v.b;
/* compiled from: Barrier.java */
/* loaded from: classes.dex */
public class a extends b {

    /* renamed from: w0  reason: collision with root package name */
    private int f1632w0 = 0;

    /* renamed from: x0  reason: collision with root package name */
    private boolean f1633x0 = true;

    /* renamed from: y0  reason: collision with root package name */
    private int f1634y0 = 0;

    /* renamed from: z0  reason: collision with root package name */
    boolean f1635z0 = false;

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(d dVar, boolean z10) {
        Object[] objArr;
        boolean z11;
        int i10;
        int i11;
        int i12;
        ConstraintAnchor[] constraintAnchorArr = this.S;
        constraintAnchorArr[0] = this.K;
        constraintAnchorArr[2] = this.L;
        constraintAnchorArr[1] = this.M;
        constraintAnchorArr[3] = this.N;
        int i13 = 0;
        while (true) {
            objArr = this.S;
            if (i13 >= objArr.length) {
                break;
            }
            objArr[i13].f1582i = dVar.q(objArr[i13]);
            i13++;
        }
        int i14 = this.f1632w0;
        if (i14 >= 0 && i14 < 4) {
            ConstraintAnchor constraintAnchor = objArr[i14];
            if (!this.f1635z0) {
                k1();
            }
            if (this.f1635z0) {
                this.f1635z0 = false;
                int i15 = this.f1632w0;
                if (i15 == 0 || i15 == 1) {
                    dVar.f(this.K.f1582i, this.f1588b0);
                    dVar.f(this.M.f1582i, this.f1588b0);
                } else if (i15 == 2 || i15 == 3) {
                    dVar.f(this.L.f1582i, this.f1590c0);
                    dVar.f(this.N.f1582i, this.f1590c0);
                }
            } else {
                for (int i16 = 0; i16 < this.f35552v0; i16++) {
                    ConstraintWidget constraintWidget = this.f35551u0[i16];
                    if ((this.f1633x0 || constraintWidget.h()) && ((((i11 = this.f1632w0) == 0 || i11 == 1) && constraintWidget.y() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.K.f1579f != null && constraintWidget.M.f1579f != null) || (((i12 = this.f1632w0) == 2 || i12 == 3) && constraintWidget.O() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.L.f1579f != null && constraintWidget.N.f1579f != null))) {
                        z11 = true;
                        break;
                    }
                }
                z11 = false;
                boolean z12 = this.K.k() || this.M.k();
                boolean z13 = this.L.k() || this.N.k();
                boolean z14 = !z11 && (((i10 = this.f1632w0) == 0 && z12) || ((i10 == 2 && z13) || ((i10 == 1 && z12) || (i10 == 3 && z13))));
                int i17 = 5;
                if (!z14) {
                    i17 = 4;
                }
                for (int i18 = 0; i18 < this.f35552v0; i18++) {
                    ConstraintWidget constraintWidget2 = this.f35551u0[i18];
                    if (this.f1633x0 || constraintWidget2.h()) {
                        SolverVariable q5 = dVar.q(constraintWidget2.S[this.f1632w0]);
                        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget2.S;
                        int i19 = this.f1632w0;
                        constraintAnchorArr2[i19].f1582i = q5;
                        int i20 = (constraintAnchorArr2[i19].f1579f == null || constraintAnchorArr2[i19].f1579f.f1577d != this) ? 0 : constraintAnchorArr2[i19].f1580g + 0;
                        if (i19 == 0 || i19 == 2) {
                            dVar.i(constraintAnchor.f1582i, q5, this.f1634y0 - i20, z11);
                        } else {
                            dVar.g(constraintAnchor.f1582i, q5, this.f1634y0 + i20, z11);
                        }
                        dVar.e(constraintAnchor.f1582i, q5, this.f1634y0 + i20, i17);
                    }
                }
                int i21 = this.f1632w0;
                if (i21 == 0) {
                    dVar.e(this.M.f1582i, this.K.f1582i, 0, 8);
                    dVar.e(this.K.f1582i, this.W.M.f1582i, 0, 4);
                    dVar.e(this.K.f1582i, this.W.K.f1582i, 0, 0);
                } else if (i21 == 1) {
                    dVar.e(this.K.f1582i, this.M.f1582i, 0, 8);
                    dVar.e(this.K.f1582i, this.W.K.f1582i, 0, 4);
                    dVar.e(this.K.f1582i, this.W.M.f1582i, 0, 0);
                } else if (i21 == 2) {
                    dVar.e(this.N.f1582i, this.L.f1582i, 0, 8);
                    dVar.e(this.L.f1582i, this.W.N.f1582i, 0, 4);
                    dVar.e(this.L.f1582i, this.W.L.f1582i, 0, 0);
                } else if (i21 == 3) {
                    dVar.e(this.L.f1582i, this.N.f1582i, 0, 8);
                    dVar.e(this.L.f1582i, this.W.L.f1582i, 0, 4);
                    dVar.e(this.L.f1582i, this.W.N.f1582i, 0, 0);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean i0() {
        return this.f1635z0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean j0() {
        return this.f1635z0;
    }

    public boolean k1() {
        int i10;
        int i11;
        int i12;
        int i13 = 0;
        boolean z10 = true;
        while (true) {
            i10 = this.f35552v0;
            if (i13 >= i10) {
                break;
            }
            ConstraintWidget constraintWidget = this.f35551u0[i13];
            if ((this.f1633x0 || constraintWidget.h()) && ((((i11 = this.f1632w0) == 0 || i11 == 1) && !constraintWidget.i0()) || (((i12 = this.f1632w0) == 2 || i12 == 3) && !constraintWidget.j0()))) {
                z10 = false;
            }
            i13++;
        }
        if (!z10 || i10 <= 0) {
            return false;
        }
        int i14 = 0;
        boolean z11 = false;
        for (int i15 = 0; i15 < this.f35552v0; i15++) {
            ConstraintWidget constraintWidget2 = this.f35551u0[i15];
            if (this.f1633x0 || constraintWidget2.h()) {
                if (!z11) {
                    int i16 = this.f1632w0;
                    if (i16 == 0) {
                        i14 = constraintWidget2.m(ConstraintAnchor.Type.LEFT).d();
                    } else if (i16 == 1) {
                        i14 = constraintWidget2.m(ConstraintAnchor.Type.RIGHT).d();
                    } else if (i16 == 2) {
                        i14 = constraintWidget2.m(ConstraintAnchor.Type.TOP).d();
                    } else if (i16 == 3) {
                        i14 = constraintWidget2.m(ConstraintAnchor.Type.BOTTOM).d();
                    }
                    z11 = true;
                }
                int i17 = this.f1632w0;
                if (i17 == 0) {
                    i14 = Math.min(i14, constraintWidget2.m(ConstraintAnchor.Type.LEFT).d());
                } else if (i17 == 1) {
                    i14 = Math.max(i14, constraintWidget2.m(ConstraintAnchor.Type.RIGHT).d());
                } else if (i17 == 2) {
                    i14 = Math.min(i14, constraintWidget2.m(ConstraintAnchor.Type.TOP).d());
                } else if (i17 == 3) {
                    i14 = Math.max(i14, constraintWidget2.m(ConstraintAnchor.Type.BOTTOM).d());
                }
            }
        }
        int i18 = i14 + this.f1634y0;
        int i19 = this.f1632w0;
        if (i19 == 0 || i19 == 1) {
            w0(i18, i18);
        } else {
            z0(i18, i18);
        }
        this.f1635z0 = true;
        return true;
    }

    public boolean l1() {
        return this.f1633x0;
    }

    public int m1() {
        return this.f1632w0;
    }

    public int n1() {
        return this.f1634y0;
    }

    public int o1() {
        int i10 = this.f1632w0;
        if (i10 == 0 || i10 == 1) {
            return 0;
        }
        return (i10 == 2 || i10 == 3) ? 1 : -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p1() {
        for (int i10 = 0; i10 < this.f35552v0; i10++) {
            ConstraintWidget constraintWidget = this.f35551u0[i10];
            if (this.f1633x0 || constraintWidget.h()) {
                int i11 = this.f1632w0;
                if (i11 == 0 || i11 == 1) {
                    constraintWidget.J0(0, true);
                } else if (i11 == 2 || i11 == 3) {
                    constraintWidget.J0(1, true);
                }
            }
        }
    }

    public void q1(boolean z10) {
        this.f1633x0 = z10;
    }

    public void r1(int i10) {
        this.f1632w0 = i10;
    }

    public void s1(int i10) {
        this.f1634y0 = i10;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + r() + " {";
        for (int i10 = 0; i10 < this.f35552v0; i10++) {
            ConstraintWidget constraintWidget = this.f35551u0[i10];
            if (i10 > 0) {
                str = str + ", ";
            }
            str = str + constraintWidget.r();
        }
        return str + "}";
    }
}
