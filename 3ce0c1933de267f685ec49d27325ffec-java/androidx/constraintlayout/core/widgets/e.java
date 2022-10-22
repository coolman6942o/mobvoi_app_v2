package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
/* compiled from: Guideline.java */
/* loaded from: classes.dex */
public class e extends ConstraintWidget {

    /* renamed from: u0  reason: collision with root package name */
    protected float f1661u0 = -1.0f;

    /* renamed from: v0  reason: collision with root package name */
    protected int f1662v0 = -1;

    /* renamed from: w0  reason: collision with root package name */
    protected int f1663w0 = -1;

    /* renamed from: x0  reason: collision with root package name */
    private ConstraintAnchor f1664x0 = this.L;

    /* renamed from: y0  reason: collision with root package name */
    private int f1665y0 = 0;

    /* renamed from: z0  reason: collision with root package name */
    private boolean f1666z0;

    /* compiled from: Guideline.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1667a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f1667a = iArr;
            try {
                iArr[ConstraintAnchor.Type.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1667a[ConstraintAnchor.Type.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1667a[ConstraintAnchor.Type.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1667a[ConstraintAnchor.Type.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1667a[ConstraintAnchor.Type.BASELINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1667a[ConstraintAnchor.Type.CENTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1667a[ConstraintAnchor.Type.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1667a[ConstraintAnchor.Type.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1667a[ConstraintAnchor.Type.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public e() {
        this.T.clear();
        this.T.add(this.f1664x0);
        int length = this.S.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.S[i10] = this.f1664x0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g(d dVar, boolean z10) {
        d dVar2 = (d) I();
        if (dVar2 != null) {
            ConstraintAnchor m10 = dVar2.m(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor m11 = dVar2.m(ConstraintAnchor.Type.RIGHT);
            ConstraintWidget constraintWidget = this.W;
            boolean z11 = true;
            boolean z12 = constraintWidget != null && constraintWidget.V[0] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (this.f1665y0 == 0) {
                m10 = dVar2.m(ConstraintAnchor.Type.TOP);
                m11 = dVar2.m(ConstraintAnchor.Type.BOTTOM);
                ConstraintWidget constraintWidget2 = this.W;
                if (constraintWidget2 == null || constraintWidget2.V[1] != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    z11 = false;
                }
                z12 = z11;
            }
            if (this.f1666z0 && this.f1664x0.m()) {
                SolverVariable q5 = dVar.q(this.f1664x0);
                dVar.f(q5, this.f1664x0.d());
                if (this.f1662v0 != -1) {
                    if (z12) {
                        dVar.h(dVar.q(m11), q5, 0, 5);
                    }
                } else if (this.f1663w0 != -1 && z12) {
                    SolverVariable q10 = dVar.q(m11);
                    dVar.h(q5, dVar.q(m10), 0, 5);
                    dVar.h(q10, q5, 0, 5);
                }
                this.f1666z0 = false;
            } else if (this.f1662v0 != -1) {
                SolverVariable q11 = dVar.q(this.f1664x0);
                dVar.e(q11, dVar.q(m10), this.f1662v0, 8);
                if (z12) {
                    dVar.h(dVar.q(m11), q11, 0, 5);
                }
            } else if (this.f1663w0 != -1) {
                SolverVariable q12 = dVar.q(this.f1664x0);
                SolverVariable q13 = dVar.q(m11);
                dVar.e(q12, q13, -this.f1663w0, 8);
                if (z12) {
                    dVar.h(q12, dVar.q(m10), 0, 5);
                    dVar.h(q13, q12, 0, 5);
                }
            } else if (this.f1661u0 != -1.0f) {
                dVar.d(d.s(dVar, dVar.q(this.f1664x0), dVar.q(m11), this.f1661u0));
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean h() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void h1(d dVar, boolean z10) {
        if (I() != null) {
            int x10 = dVar.x(this.f1664x0);
            if (this.f1665y0 == 1) {
                d1(x10);
                e1(0);
                C0(I().v());
                b1(0);
                return;
            }
            d1(0);
            e1(x10);
            b1(I().R());
            C0(0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean i0() {
        return this.f1666z0;
    }

    public ConstraintAnchor i1() {
        return this.f1664x0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean j0() {
        return this.f1666z0;
    }

    public int j1() {
        return this.f1665y0;
    }

    public int k1() {
        return this.f1662v0;
    }

    public int l1() {
        return this.f1663w0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public ConstraintAnchor m(ConstraintAnchor.Type type) {
        int i10 = a.f1667a[type.ordinal()];
        if (i10 == 1 || i10 == 2) {
            if (this.f1665y0 == 1) {
                return this.f1664x0;
            }
            return null;
        } else if ((i10 == 3 || i10 == 4) && this.f1665y0 == 0) {
            return this.f1664x0;
        } else {
            return null;
        }
    }

    public float m1() {
        return this.f1661u0;
    }

    public void n1(int i10) {
        this.f1664x0.s(i10);
        this.f1666z0 = true;
    }

    public void o1(int i10) {
        if (i10 > -1) {
            this.f1661u0 = -1.0f;
            this.f1662v0 = i10;
            this.f1663w0 = -1;
        }
    }

    public void p1(int i10) {
        if (i10 > -1) {
            this.f1661u0 = -1.0f;
            this.f1662v0 = -1;
            this.f1663w0 = i10;
        }
    }

    public void q1(float f10) {
        if (f10 > -1.0f) {
            this.f1661u0 = f10;
            this.f1662v0 = -1;
            this.f1663w0 = -1;
        }
    }

    public void r1(int i10) {
        if (this.f1665y0 != i10) {
            this.f1665y0 = i10;
            this.T.clear();
            if (this.f1665y0 == 1) {
                this.f1664x0 = this.K;
            } else {
                this.f1664x0 = this.L;
            }
            this.T.add(this.f1664x0);
            int length = this.S.length;
            for (int i11 = 0; i11 < length; i11++) {
                this.S[i11] = this.f1664x0;
            }
        }
    }
}
