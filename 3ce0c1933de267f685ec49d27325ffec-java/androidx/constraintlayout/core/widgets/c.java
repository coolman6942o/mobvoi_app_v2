package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
/* compiled from: ChainHead.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    protected ConstraintWidget f1636a;

    /* renamed from: b  reason: collision with root package name */
    protected ConstraintWidget f1637b;

    /* renamed from: c  reason: collision with root package name */
    protected ConstraintWidget f1638c;

    /* renamed from: d  reason: collision with root package name */
    protected ConstraintWidget f1639d;

    /* renamed from: e  reason: collision with root package name */
    protected ConstraintWidget f1640e;

    /* renamed from: f  reason: collision with root package name */
    protected ConstraintWidget f1641f;

    /* renamed from: g  reason: collision with root package name */
    protected ConstraintWidget f1642g;

    /* renamed from: h  reason: collision with root package name */
    protected ArrayList<ConstraintWidget> f1643h;

    /* renamed from: i  reason: collision with root package name */
    protected int f1644i;

    /* renamed from: j  reason: collision with root package name */
    protected int f1645j;

    /* renamed from: k  reason: collision with root package name */
    protected float f1646k = 0.0f;

    /* renamed from: l  reason: collision with root package name */
    int f1647l;

    /* renamed from: m  reason: collision with root package name */
    int f1648m;

    /* renamed from: n  reason: collision with root package name */
    int f1649n;

    /* renamed from: o  reason: collision with root package name */
    private int f1650o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f1651p;

    /* renamed from: q  reason: collision with root package name */
    protected boolean f1652q;

    /* renamed from: r  reason: collision with root package name */
    protected boolean f1653r;

    /* renamed from: s  reason: collision with root package name */
    protected boolean f1654s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f1655t;

    public c(ConstraintWidget constraintWidget, int i10, boolean z10) {
        this.f1651p = false;
        this.f1636a = constraintWidget;
        this.f1650o = i10;
        this.f1651p = z10;
    }

    private void b() {
        int i10 = this.f1650o * 2;
        ConstraintWidget constraintWidget = this.f1636a;
        boolean z10 = false;
        ConstraintWidget constraintWidget2 = constraintWidget;
        boolean z11 = false;
        while (!z11) {
            this.f1644i++;
            ConstraintWidget[] constraintWidgetArr = constraintWidget.f1618q0;
            int i11 = this.f1650o;
            ConstraintWidget constraintWidget3 = null;
            constraintWidgetArr[i11] = null;
            constraintWidget.f1616p0[i11] = null;
            if (constraintWidget.Q() != 8) {
                this.f1647l++;
                ConstraintWidget.DimensionBehaviour s10 = constraintWidget.s(this.f1650o);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                if (s10 != dimensionBehaviour) {
                    this.f1648m += constraintWidget.C(this.f1650o);
                }
                int e10 = this.f1648m + constraintWidget.S[i10].e();
                this.f1648m = e10;
                int i12 = i10 + 1;
                this.f1648m = e10 + constraintWidget.S[i12].e();
                int e11 = this.f1649n + constraintWidget.S[i10].e();
                this.f1649n = e11;
                this.f1649n = e11 + constraintWidget.S[i12].e();
                if (this.f1637b == null) {
                    this.f1637b = constraintWidget;
                }
                this.f1639d = constraintWidget;
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.V;
                int i13 = this.f1650o;
                if (dimensionBehaviourArr[i13] == dimensionBehaviour) {
                    int[] iArr = constraintWidget.f1624u;
                    if (iArr[i13] == 0 || iArr[i13] == 3 || iArr[i13] == 2) {
                        this.f1645j++;
                        float[] fArr = constraintWidget.f1614o0;
                        float f10 = fArr[i13];
                        if (f10 > 0.0f) {
                            this.f1646k += fArr[i13];
                        }
                        if (c(constraintWidget, i13)) {
                            if (f10 < 0.0f) {
                                this.f1652q = true;
                            } else {
                                this.f1653r = true;
                            }
                            if (this.f1643h == null) {
                                this.f1643h = new ArrayList<>();
                            }
                            this.f1643h.add(constraintWidget);
                        }
                        if (this.f1641f == null) {
                            this.f1641f = constraintWidget;
                        }
                        ConstraintWidget constraintWidget4 = this.f1642g;
                        if (constraintWidget4 != null) {
                            constraintWidget4.f1616p0[this.f1650o] = constraintWidget;
                        }
                        this.f1642g = constraintWidget;
                    }
                    if (this.f1650o == 0) {
                        if (constraintWidget.f1621s == 0 && constraintWidget.f1625v == 0) {
                            int i14 = constraintWidget.f1626w;
                        }
                    } else if (constraintWidget.f1623t == 0 && constraintWidget.f1628y == 0) {
                        int i15 = constraintWidget.f1629z;
                    }
                }
            }
            if (constraintWidget2 != constraintWidget) {
                constraintWidget2.f1618q0[this.f1650o] = constraintWidget;
            }
            ConstraintAnchor constraintAnchor = constraintWidget.S[i10 + 1].f1579f;
            if (constraintAnchor != null) {
                ConstraintWidget constraintWidget5 = constraintAnchor.f1577d;
                ConstraintAnchor[] constraintAnchorArr = constraintWidget5.S;
                if (constraintAnchorArr[i10].f1579f != null && constraintAnchorArr[i10].f1579f.f1577d == constraintWidget) {
                    constraintWidget3 = constraintWidget5;
                }
            }
            if (constraintWidget3 == null) {
                constraintWidget3 = constraintWidget;
                z11 = true;
            }
            constraintWidget2 = constraintWidget;
            constraintWidget = constraintWidget3;
        }
        ConstraintWidget constraintWidget6 = this.f1637b;
        if (constraintWidget6 != null) {
            this.f1648m -= constraintWidget6.S[i10].e();
        }
        ConstraintWidget constraintWidget7 = this.f1639d;
        if (constraintWidget7 != null) {
            this.f1648m -= constraintWidget7.S[i10 + 1].e();
        }
        this.f1638c = constraintWidget;
        if (this.f1650o != 0 || !this.f1651p) {
            this.f1640e = this.f1636a;
        } else {
            this.f1640e = constraintWidget;
        }
        if (this.f1653r && this.f1652q) {
            z10 = true;
        }
        this.f1654s = z10;
    }

    private static boolean c(ConstraintWidget constraintWidget, int i10) {
        if (constraintWidget.Q() != 8 && constraintWidget.V[i10] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int[] iArr = constraintWidget.f1624u;
            if (iArr[i10] == 0 || iArr[i10] == 3) {
                return true;
            }
        }
        return false;
    }

    public void a() {
        if (!this.f1655t) {
            b();
        }
        this.f1655t = true;
    }
}
