package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
/* compiled from: Chain.java */
/* loaded from: classes.dex */
public class b {
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        if (r8 == 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
        if (r8 == 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0046, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x026d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02c8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0359  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03bb A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04ee A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x052b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:321:0x03b2 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:332:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v42, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r7v29 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static void a(d dVar, d dVar2, int i10, int i11, c cVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        SolverVariable solverVariable;
        ArrayList<ConstraintWidget> arrayList;
        SolverVariable solverVariable2;
        ConstraintWidget constraintWidget;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        int i12;
        ConstraintWidget constraintWidget2;
        int i13;
        ConstraintWidget constraintWidget3;
        SolverVariable solverVariable3;
        SolverVariable solverVariable4;
        ConstraintAnchor constraintAnchor4;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        ConstraintWidget constraintWidget6;
        ConstraintWidget constraintWidget7;
        SolverVariable solverVariable5;
        ConstraintAnchor constraintAnchor5;
        float f10;
        int size;
        int i14;
        ArrayList<ConstraintWidget> arrayList2;
        int i15;
        boolean z13;
        boolean z14;
        ConstraintWidget constraintWidget8;
        ConstraintWidget constraintWidget9;
        int i16;
        int i17 = i10;
        ConstraintWidget constraintWidget10 = cVar.f1636a;
        ConstraintWidget constraintWidget11 = cVar.f1638c;
        ConstraintWidget constraintWidget12 = cVar.f1637b;
        ConstraintWidget constraintWidget13 = cVar.f1639d;
        ConstraintWidget constraintWidget14 = cVar.f1640e;
        float f11 = cVar.f1646k;
        boolean z15 = dVar.V[i17] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (i17 == 0) {
            int i18 = constraintWidget14.f1610m0;
            z11 = i18 == 0;
            z10 = i18 == 1;
        } else {
            int i19 = constraintWidget14.f1612n0;
            z11 = i19 == 0;
            z10 = i19 == 1;
        }
        ConstraintWidget constraintWidget15 = constraintWidget10;
        boolean z16 = false;
        while (true) {
            solverVariable = null;
            if (z16) {
                break;
            }
            ConstraintAnchor constraintAnchor6 = constraintWidget15.S[i11];
            int i20 = z12 ? 1 : 4;
            int e10 = constraintAnchor6.e();
            f11 = f11;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget15.V[i17];
            z16 = z16;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
            if (dimensionBehaviour == dimensionBehaviour2 && constraintWidget15.f1624u[i17] == 0) {
                z13 = z11;
                z14 = true;
            } else {
                z13 = z11;
                z14 = false;
            }
            ConstraintAnchor constraintAnchor7 = constraintAnchor6.f1579f;
            if (!(constraintAnchor7 == null || constraintWidget15 == constraintWidget10)) {
                e10 += constraintAnchor7.e();
            }
            int i21 = e10;
            if (!z12 || constraintWidget15 == constraintWidget10 || constraintWidget15 == constraintWidget12) {
                constraintWidget8 = constraintWidget14;
            } else {
                constraintWidget8 = constraintWidget14;
                i20 = 8;
            }
            ConstraintAnchor constraintAnchor8 = constraintAnchor6.f1579f;
            if (constraintAnchor8 != null) {
                if (constraintWidget15 == constraintWidget12) {
                    constraintWidget9 = constraintWidget10;
                    dVar2.h(constraintAnchor6.f1582i, constraintAnchor8.f1582i, i21, 6);
                } else {
                    constraintWidget9 = constraintWidget10;
                    dVar2.h(constraintAnchor6.f1582i, constraintAnchor8.f1582i, i21, 8);
                }
                if (z14 && !z12) {
                    i20 = 5;
                }
                dVar2.e(constraintAnchor6.f1582i, constraintAnchor6.f1579f.f1582i, i21, (constraintWidget15 != constraintWidget12 || !z12 || !constraintWidget15.c0(i17)) ? i20 : 5);
            } else {
                constraintWidget9 = constraintWidget10;
            }
            if (z15) {
                if (constraintWidget15.Q() == 8 || constraintWidget15.V[i17] != dimensionBehaviour2) {
                    i16 = 0;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget15.S;
                    i16 = 0;
                    dVar2.h(constraintAnchorArr[i11 + 1].f1582i, constraintAnchorArr[i11].f1582i, 0, 5);
                }
                dVar2.h(constraintWidget15.S[i11].f1582i, dVar.S[i11].f1582i, i16, 8);
            }
            ConstraintAnchor constraintAnchor9 = constraintWidget15.S[i11 + 1].f1579f;
            if (constraintAnchor9 != null) {
                ?? r12 = constraintAnchor9.f1577d;
                ConstraintAnchor[] constraintAnchorArr2 = r12.S;
                if (constraintAnchorArr2[i11].f1579f != null && constraintAnchorArr2[i11].f1579f.f1577d == constraintWidget15) {
                    solverVariable = r12;
                }
            }
            if (solverVariable != null) {
                constraintWidget15 = solverVariable;
            } else {
                z16 = true;
            }
            constraintWidget14 = constraintWidget8;
            z11 = z13;
            constraintWidget10 = constraintWidget9;
        }
        ConstraintWidget constraintWidget16 = constraintWidget14;
        float f12 = f11;
        ConstraintWidget constraintWidget17 = constraintWidget10;
        boolean z17 = z11;
        if (constraintWidget13 != null) {
            int i22 = i11 + 1;
            if (constraintWidget11.S[i22].f1579f != null) {
                ConstraintAnchor constraintAnchor10 = constraintWidget13.S[i22];
                if ((constraintWidget13.V[i17] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget13.f1624u[i17] == 0) && !z12) {
                    ConstraintAnchor constraintAnchor11 = constraintAnchor10.f1579f;
                    if (constraintAnchor11.f1577d == dVar) {
                        dVar2.e(constraintAnchor10.f1582i, constraintAnchor11.f1582i, -constraintAnchor10.e(), 5);
                        dVar2.j(constraintAnchor10.f1582i, constraintWidget11.S[i22].f1579f.f1582i, -constraintAnchor10.e(), 6);
                        if (z15) {
                            int i23 = i11 + 1;
                            SolverVariable solverVariable6 = dVar.S[i23].f1582i;
                            ConstraintAnchor[] constraintAnchorArr3 = constraintWidget11.S;
                            dVar2.h(solverVariable6, constraintAnchorArr3[i23].f1582i, constraintAnchorArr3[i23].e(), 8);
                        }
                        arrayList = cVar.f1643h;
                        if (arrayList != null && (size = arrayList.size()) > 1) {
                            if (!cVar.f1652q && !cVar.f1654s) {
                                f12 = cVar.f1645j;
                            }
                            float f13 = 0.0f;
                            float f14 = 0.0f;
                            ConstraintWidget constraintWidget18 = null;
                            i14 = 0;
                            while (i14 < size) {
                                ConstraintWidget constraintWidget19 = arrayList.get(i14);
                                float f15 = constraintWidget19.f1614o0[i17];
                                if (f15 < f13) {
                                    if (cVar.f1654s) {
                                        ConstraintAnchor[] constraintAnchorArr4 = constraintWidget19.S;
                                        dVar2.e(constraintAnchorArr4[i11 + 1].f1582i, constraintAnchorArr4[i11].f1582i, 0, 4);
                                        arrayList2 = arrayList;
                                        i15 = size;
                                        i14++;
                                        size = i15;
                                        arrayList = arrayList2;
                                        f13 = 0.0f;
                                    } else {
                                        f15 = 1.0f;
                                        f13 = 0.0f;
                                    }
                                }
                                if (f15 == f13) {
                                    ConstraintAnchor[] constraintAnchorArr5 = constraintWidget19.S;
                                    dVar2.e(constraintAnchorArr5[i11 + 1].f1582i, constraintAnchorArr5[i11].f1582i, 0, 8);
                                    arrayList2 = arrayList;
                                    i15 = size;
                                    i14++;
                                    size = i15;
                                    arrayList = arrayList2;
                                    f13 = 0.0f;
                                } else {
                                    if (constraintWidget18 != null) {
                                        ConstraintAnchor[] constraintAnchorArr6 = constraintWidget18.S;
                                        SolverVariable solverVariable7 = constraintAnchorArr6[i11].f1582i;
                                        int i24 = i11 + 1;
                                        SolverVariable solverVariable8 = constraintAnchorArr6[i24].f1582i;
                                        ConstraintAnchor[] constraintAnchorArr7 = constraintWidget19.S;
                                        arrayList2 = arrayList;
                                        SolverVariable solverVariable9 = constraintAnchorArr7[i11].f1582i;
                                        SolverVariable solverVariable10 = constraintAnchorArr7[i24].f1582i;
                                        i15 = size;
                                        androidx.constraintlayout.core.b r10 = dVar2.r();
                                        r10.l(f14, f12, f15, solverVariable7, solverVariable8, solverVariable9, solverVariable10);
                                        dVar2.d(r10);
                                    } else {
                                        arrayList2 = arrayList;
                                        i15 = size;
                                    }
                                    f14 = f15;
                                    constraintWidget18 = constraintWidget19;
                                    i14++;
                                    size = i15;
                                    arrayList = arrayList2;
                                    f13 = 0.0f;
                                }
                            }
                        }
                        if (constraintWidget12 == null && (constraintWidget12 == constraintWidget13 || z12)) {
                            ConstraintAnchor constraintAnchor12 = constraintWidget17.S[i11];
                            int i25 = i11 + 1;
                            ConstraintAnchor constraintAnchor13 = constraintWidget11.S[i25];
                            ConstraintAnchor constraintAnchor14 = constraintAnchor12.f1579f;
                            SolverVariable solverVariable11 = constraintAnchor14 != null ? constraintAnchor14.f1582i : null;
                            ConstraintAnchor constraintAnchor15 = constraintAnchor13.f1579f;
                            SolverVariable solverVariable12 = constraintAnchor15 != null ? constraintAnchor15.f1582i : null;
                            ConstraintAnchor constraintAnchor16 = constraintWidget12.S[i11];
                            if (constraintWidget13 != null) {
                                constraintAnchor13 = constraintWidget13.S[i25];
                            }
                            if (!(solverVariable11 == null || solverVariable12 == null)) {
                                if (i17 == 0) {
                                    f10 = constraintWidget16.f1598g0;
                                } else {
                                    f10 = constraintWidget16.f1600h0;
                                }
                                dVar2.c(constraintAnchor16.f1582i, solverVariable11, constraintAnchor16.e(), f10, solverVariable12, constraintAnchor13.f1582i, constraintAnchor13.e(), 7);
                            }
                        } else if (z17 || constraintWidget12 == null) {
                            int i26 = 8;
                            if (z10 && constraintWidget12 != null) {
                                int i27 = cVar.f1645j;
                                boolean z18 = i27 <= 0 && cVar.f1644i == i27;
                                ConstraintWidget constraintWidget20 = constraintWidget12;
                                constraintWidget = constraintWidget20;
                                while (constraintWidget != null) {
                                    ConstraintWidget constraintWidget21 = constraintWidget.f1618q0[i17];
                                    while (constraintWidget21 != null && constraintWidget21.Q() == i26) {
                                        constraintWidget21 = constraintWidget21.f1618q0[i17];
                                    }
                                    if (constraintWidget == constraintWidget12 || constraintWidget == constraintWidget13 || constraintWidget21 == null) {
                                        constraintWidget2 = constraintWidget20;
                                        i13 = i26;
                                    } else {
                                        ConstraintWidget constraintWidget22 = constraintWidget21 == constraintWidget13 ? null : constraintWidget21;
                                        ConstraintAnchor constraintAnchor17 = constraintWidget.S[i11];
                                        SolverVariable solverVariable13 = constraintAnchor17.f1582i;
                                        ConstraintAnchor constraintAnchor18 = constraintAnchor17.f1579f;
                                        if (constraintAnchor18 != null) {
                                            SolverVariable solverVariable14 = constraintAnchor18.f1582i;
                                        }
                                        int i28 = i11 + 1;
                                        SolverVariable solverVariable15 = constraintWidget20.S[i28].f1582i;
                                        int e11 = constraintAnchor17.e();
                                        int e12 = constraintWidget.S[i28].e();
                                        if (constraintWidget22 != null) {
                                            constraintAnchor4 = constraintWidget22.S[i11];
                                            SolverVariable solverVariable16 = constraintAnchor4.f1582i;
                                            constraintWidget3 = constraintWidget22;
                                            ConstraintAnchor constraintAnchor19 = constraintAnchor4.f1579f;
                                            solverVariable3 = constraintAnchor19 != null ? constraintAnchor19.f1582i : null;
                                            solverVariable4 = solverVariable16;
                                        } else {
                                            constraintWidget3 = constraintWidget22;
                                            constraintAnchor4 = constraintWidget13.S[i11];
                                            solverVariable4 = constraintAnchor4 != null ? constraintAnchor4.f1582i : null;
                                            solverVariable3 = constraintWidget.S[i28].f1582i;
                                        }
                                        if (constraintAnchor4 != null) {
                                            e12 += constraintAnchor4.e();
                                        }
                                        int i29 = e12;
                                        int e13 = constraintWidget20.S[i28].e() + e11;
                                        int i30 = z18 ? 8 : 4;
                                        if (solverVariable13 == null || solverVariable15 == null || solverVariable4 == null || solverVariable3 == null) {
                                            constraintWidget4 = constraintWidget3;
                                            constraintWidget2 = constraintWidget20;
                                            i13 = 8;
                                        } else {
                                            constraintWidget4 = constraintWidget3;
                                            constraintWidget2 = constraintWidget20;
                                            i13 = 8;
                                            dVar2.c(solverVariable13, solverVariable15, e13, 0.5f, solverVariable4, solverVariable3, i29, i30);
                                        }
                                        constraintWidget21 = constraintWidget4;
                                    }
                                    constraintWidget20 = constraintWidget.Q() != i13 ? constraintWidget : constraintWidget2;
                                    constraintWidget = constraintWidget21;
                                    i26 = i13;
                                    i17 = i10;
                                }
                                ConstraintAnchor constraintAnchor20 = constraintWidget12.S[i11];
                                constraintAnchor = constraintWidget17.S[i11].f1579f;
                                int i31 = i11 + 1;
                                constraintAnchor2 = constraintWidget13.S[i31];
                                constraintAnchor3 = constraintWidget11.S[i31].f1579f;
                                if (constraintAnchor != null) {
                                    i12 = 5;
                                } else if (constraintWidget12 != constraintWidget13) {
                                    i12 = 5;
                                    dVar2.e(constraintAnchor20.f1582i, constraintAnchor.f1582i, constraintAnchor20.e(), 5);
                                } else {
                                    i12 = 5;
                                    if (constraintAnchor3 != null) {
                                        dVar2.c(constraintAnchor20.f1582i, constraintAnchor.f1582i, constraintAnchor20.e(), 0.5f, constraintAnchor2.f1582i, constraintAnchor3.f1582i, constraintAnchor2.e(), 5);
                                    }
                                }
                                if (!(constraintAnchor3 == null || constraintWidget12 == constraintWidget13)) {
                                    dVar2.e(constraintAnchor2.f1582i, constraintAnchor3.f1582i, -constraintAnchor2.e(), i12);
                                }
                            }
                        } else {
                            int i32 = cVar.f1645j;
                            boolean z19 = i32 > 0 && cVar.f1644i == i32;
                            ConstraintWidget constraintWidget23 = constraintWidget12;
                            ConstraintWidget constraintWidget24 = constraintWidget23;
                            while (constraintWidget24 != null) {
                                ConstraintWidget constraintWidget25 = constraintWidget24.f1618q0[i17];
                                while (constraintWidget25 != null && constraintWidget25.Q() == 8) {
                                    constraintWidget25 = constraintWidget25.f1618q0[i17];
                                }
                                if (constraintWidget25 != null || constraintWidget24 == constraintWidget13) {
                                    ConstraintAnchor constraintAnchor21 = constraintWidget24.S[i11];
                                    SolverVariable solverVariable17 = constraintAnchor21.f1582i;
                                    ConstraintAnchor constraintAnchor22 = constraintAnchor21.f1579f;
                                    SolverVariable solverVariable18 = constraintAnchor22 != null ? constraintAnchor22.f1582i : null;
                                    if (constraintWidget23 != constraintWidget24) {
                                        solverVariable18 = constraintWidget23.S[i11 + 1].f1582i;
                                    } else if (constraintWidget24 == constraintWidget12) {
                                        ConstraintAnchor[] constraintAnchorArr8 = constraintWidget17.S;
                                        solverVariable18 = constraintAnchorArr8[i11].f1579f != null ? constraintAnchorArr8[i11].f1579f.f1582i : null;
                                    }
                                    int e14 = constraintAnchor21.e();
                                    int i33 = i11 + 1;
                                    int e15 = constraintWidget24.S[i33].e();
                                    if (constraintWidget25 != null) {
                                        constraintAnchor5 = constraintWidget25.S[i11];
                                        solverVariable5 = constraintAnchor5.f1582i;
                                    } else {
                                        constraintAnchor5 = constraintWidget11.S[i33].f1579f;
                                        if (constraintAnchor5 != null) {
                                            solverVariable5 = constraintAnchor5.f1582i;
                                        } else {
                                            constraintWidget7 = constraintWidget25;
                                            solverVariable5 = null;
                                            SolverVariable solverVariable19 = constraintWidget24.S[i33].f1582i;
                                            if (constraintAnchor5 != null) {
                                                e15 += constraintAnchor5.e();
                                            }
                                            int e16 = e14 + constraintWidget23.S[i33].e();
                                            if (solverVariable17 != null || solverVariable18 == null || solverVariable5 == null || solverVariable19 == null) {
                                                constraintWidget5 = constraintWidget7;
                                            } else {
                                                if (constraintWidget24 == constraintWidget12) {
                                                    e16 = constraintWidget12.S[i11].e();
                                                }
                                                int i34 = e16;
                                                constraintWidget5 = constraintWidget7;
                                                constraintWidget6 = constraintWidget23;
                                                dVar2.c(solverVariable17, solverVariable18, i34, 0.5f, solverVariable5, solverVariable19, constraintWidget24 == constraintWidget13 ? constraintWidget13.S[i33].e() : e15, z19 ? 8 : 5);
                                                if (constraintWidget24.Q() != 8) {
                                                    constraintWidget24 = constraintWidget6;
                                                }
                                                constraintWidget23 = constraintWidget24;
                                                constraintWidget24 = constraintWidget5;
                                            }
                                        }
                                    }
                                    constraintWidget7 = constraintWidget25;
                                    SolverVariable solverVariable192 = constraintWidget24.S[i33].f1582i;
                                    if (constraintAnchor5 != null) {
                                    }
                                    int e162 = e14 + constraintWidget23.S[i33].e();
                                    if (solverVariable17 != null) {
                                    }
                                    constraintWidget5 = constraintWidget7;
                                } else {
                                    constraintWidget5 = constraintWidget25;
                                }
                                constraintWidget6 = constraintWidget23;
                                if (constraintWidget24.Q() != 8) {
                                }
                                constraintWidget23 = constraintWidget24;
                                constraintWidget24 = constraintWidget5;
                            }
                        }
                        if ((!z17 || z10) && constraintWidget12 != null && constraintWidget12 != constraintWidget13) {
                            ConstraintAnchor[] constraintAnchorArr9 = constraintWidget12.S;
                            ConstraintAnchor constraintAnchor23 = constraintAnchorArr9[i11];
                            if (constraintWidget13 == null) {
                                constraintWidget13 = constraintWidget12;
                            }
                            int i35 = i11 + 1;
                            ConstraintAnchor constraintAnchor24 = constraintWidget13.S[i35];
                            ConstraintAnchor constraintAnchor25 = constraintAnchor23.f1579f;
                            solverVariable2 = constraintAnchor25 != null ? constraintAnchor25.f1582i : null;
                            ConstraintAnchor constraintAnchor26 = constraintAnchor24.f1579f;
                            SolverVariable solverVariable20 = constraintAnchor26 != null ? constraintAnchor26.f1582i : null;
                            if (constraintWidget11 != constraintWidget13) {
                                ConstraintAnchor constraintAnchor27 = constraintWidget11.S[i35].f1579f;
                                if (constraintAnchor27 != null) {
                                    solverVariable = constraintAnchor27.f1582i;
                                }
                                solverVariable20 = solverVariable;
                            }
                            if (constraintWidget12 == constraintWidget13) {
                                constraintAnchor23 = constraintAnchorArr9[i11];
                                constraintAnchor24 = constraintAnchorArr9[i35];
                            }
                            if (solverVariable2 == null && solverVariable20 != null) {
                                dVar2.c(constraintAnchor23.f1582i, solverVariable2, constraintAnchor23.e(), 0.5f, solverVariable20, constraintAnchor24.f1582i, constraintWidget13.S[i35].e(), 5);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                if (z12) {
                    ConstraintAnchor constraintAnchor28 = constraintAnchor10.f1579f;
                    if (constraintAnchor28.f1577d == dVar) {
                        dVar2.e(constraintAnchor10.f1582i, constraintAnchor28.f1582i, -constraintAnchor10.e(), 4);
                    }
                }
                dVar2.j(constraintAnchor10.f1582i, constraintWidget11.S[i22].f1579f.f1582i, -constraintAnchor10.e(), 6);
                if (z15) {
                }
                arrayList = cVar.f1643h;
                if (arrayList != null) {
                    if (!cVar.f1652q) {
                    }
                    float f132 = 0.0f;
                    float f142 = 0.0f;
                    ConstraintWidget constraintWidget182 = null;
                    i14 = 0;
                    while (i14 < size) {
                    }
                }
                if (constraintWidget12 == null) {
                }
                if (z17) {
                }
                int i262 = 8;
                if (z10) {
                    int i272 = cVar.f1645j;
                    if (i272 <= 0) {
                    }
                    ConstraintWidget constraintWidget202 = constraintWidget12;
                    constraintWidget = constraintWidget202;
                    while (constraintWidget != null) {
                    }
                    ConstraintAnchor constraintAnchor202 = constraintWidget12.S[i11];
                    constraintAnchor = constraintWidget17.S[i11].f1579f;
                    int i312 = i11 + 1;
                    constraintAnchor2 = constraintWidget13.S[i312];
                    constraintAnchor3 = constraintWidget11.S[i312].f1579f;
                    if (constraintAnchor != null) {
                    }
                    if (constraintAnchor3 == null) {
                        dVar2.e(constraintAnchor2.f1582i, constraintAnchor3.f1582i, -constraintAnchor2.e(), i12);
                    }
                }
                if (!z17) {
                }
                ConstraintAnchor[] constraintAnchorArr92 = constraintWidget12.S;
                ConstraintAnchor constraintAnchor232 = constraintAnchorArr92[i11];
                if (constraintWidget13 == null) {
                }
                int i352 = i11 + 1;
                ConstraintAnchor constraintAnchor242 = constraintWidget13.S[i352];
                ConstraintAnchor constraintAnchor252 = constraintAnchor232.f1579f;
                if (constraintAnchor252 != null) {
                }
                ConstraintAnchor constraintAnchor262 = constraintAnchor242.f1579f;
                if (constraintAnchor262 != null) {
                }
                if (constraintWidget11 != constraintWidget13) {
                }
                if (constraintWidget12 == constraintWidget13) {
                }
                if (solverVariable2 == null) {
                    return;
                }
                return;
            }
        }
        if (z15) {
        }
        arrayList = cVar.f1643h;
        if (arrayList != null) {
        }
        if (constraintWidget12 == null) {
        }
        if (z17) {
        }
        int i2622 = 8;
        if (z10) {
        }
        if (!z17) {
        }
        ConstraintAnchor[] constraintAnchorArr922 = constraintWidget12.S;
        ConstraintAnchor constraintAnchor2322 = constraintAnchorArr922[i11];
        if (constraintWidget13 == null) {
        }
        int i3522 = i11 + 1;
        ConstraintAnchor constraintAnchor2422 = constraintWidget13.S[i3522];
        ConstraintAnchor constraintAnchor2522 = constraintAnchor2322.f1579f;
        if (constraintAnchor2522 != null) {
        }
        ConstraintAnchor constraintAnchor2622 = constraintAnchor2422.f1579f;
        if (constraintAnchor2622 != null) {
        }
        if (constraintWidget11 != constraintWidget13) {
        }
        if (constraintWidget12 == constraintWidget13) {
        }
        if (solverVariable2 == null) {
        }
    }

    public static void b(d dVar, d dVar2, ArrayList<ConstraintWidget> arrayList, int i10) {
        c[] cVarArr;
        int i11;
        int i12;
        if (i10 == 0) {
            i12 = dVar.D0;
            cVarArr = dVar.G0;
            i11 = 0;
        } else {
            i11 = 2;
            int i13 = dVar.E0;
            cVarArr = dVar.F0;
            i12 = i13;
        }
        for (int i14 = 0; i14 < i12; i14++) {
            c cVar = cVarArr[i14];
            cVar.a();
            if (arrayList == null || arrayList.contains(cVar.f1636a)) {
                a(dVar, dVar2, i10, i11, cVar);
            }
        }
    }
}
