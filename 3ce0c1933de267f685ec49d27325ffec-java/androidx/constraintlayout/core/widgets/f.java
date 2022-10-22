package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
/* compiled from: Optimizer.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    static boolean[] f1668a = new boolean[3];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(d dVar, d dVar2, ConstraintWidget constraintWidget) {
        constraintWidget.f1615p = -1;
        constraintWidget.f1617q = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dVar.V[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.V[0] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i10 = constraintWidget.K.f1580g;
            int R = dVar.R() - constraintWidget.M.f1580g;
            ConstraintAnchor constraintAnchor = constraintWidget.K;
            constraintAnchor.f1582i = dVar2.q(constraintAnchor);
            ConstraintAnchor constraintAnchor2 = constraintWidget.M;
            constraintAnchor2.f1582i = dVar2.q(constraintAnchor2);
            dVar2.f(constraintWidget.K.f1582i, i10);
            dVar2.f(constraintWidget.M.f1582i, R);
            constraintWidget.f1615p = 2;
            constraintWidget.F0(i10, R);
        }
        if (dVar.V[1] != dimensionBehaviour2 && constraintWidget.V[1] == ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            int i11 = constraintWidget.L.f1580g;
            int v10 = dVar.v() - constraintWidget.N.f1580g;
            ConstraintAnchor constraintAnchor3 = constraintWidget.L;
            constraintAnchor3.f1582i = dVar2.q(constraintAnchor3);
            ConstraintAnchor constraintAnchor4 = constraintWidget.N;
            constraintAnchor4.f1582i = dVar2.q(constraintAnchor4);
            dVar2.f(constraintWidget.L.f1582i, i11);
            dVar2.f(constraintWidget.N.f1582i, v10);
            if (constraintWidget.f1592d0 > 0 || constraintWidget.Q() == 8) {
                ConstraintAnchor constraintAnchor5 = constraintWidget.O;
                constraintAnchor5.f1582i = dVar2.q(constraintAnchor5);
                dVar2.f(constraintWidget.O.f1582i, constraintWidget.f1592d0 + i11);
            }
            constraintWidget.f1617q = 2;
            constraintWidget.W0(i11, v10);
        }
    }

    public static final boolean b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
