package w;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.a;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.e;
import java.util.ArrayList;
import java.util.Iterator;
import w.b;
/* compiled from: Direct.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static b.a f35890a = new b.a();

    /* renamed from: b  reason: collision with root package name */
    private static int f35891b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static int f35892c = 0;

    private static boolean a(int i10, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget.DimensionBehaviour y10 = constraintWidget.y();
        ConstraintWidget.DimensionBehaviour O = constraintWidget.O();
        d dVar = constraintWidget.I() != null ? (d) constraintWidget.I() : null;
        if (dVar != null) {
            dVar.y();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (dVar != null) {
            dVar.O();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean z10 = y10 == dimensionBehaviour5 || constraintWidget.i0() || y10 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (y10 == (dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f1621s == 0 && constraintWidget.Z == 0.0f && constraintWidget.V(0)) || (y10 == dimensionBehaviour2 && constraintWidget.f1621s == 1 && constraintWidget.Y(0, constraintWidget.R()));
        boolean z11 = O == dimensionBehaviour5 || constraintWidget.j0() || O == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || (O == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) && constraintWidget.f1623t == 0 && constraintWidget.Z == 0.0f && constraintWidget.V(1)) || (y10 == dimensionBehaviour && constraintWidget.f1623t == 1 && constraintWidget.Y(1, constraintWidget.v()));
        if (constraintWidget.Z <= 0.0f || (!z10 && !z11)) {
            return z10 && z11;
        }
        return true;
    }

    private static void b(int i10, ConstraintWidget constraintWidget, b.AbstractC0518b bVar, boolean z10) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        if (!constraintWidget.b0()) {
            f35891b++;
            if (!(constraintWidget instanceof d) && constraintWidget.h0()) {
                int i11 = i10 + 1;
                if (a(i11, constraintWidget)) {
                    d.I1(i11, constraintWidget, bVar, new b.a(), b.a.f35854k);
                }
            }
            ConstraintAnchor m10 = constraintWidget.m(ConstraintAnchor.Type.LEFT);
            ConstraintAnchor m11 = constraintWidget.m(ConstraintAnchor.Type.RIGHT);
            int d10 = m10.d();
            int d11 = m11.d();
            if (m10.c() != null && m10.m()) {
                Iterator<ConstraintAnchor> it = m10.c().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget2 = next.f1577d;
                    int i12 = i10 + 1;
                    boolean a10 = a(i12, constraintWidget2);
                    if (constraintWidget2.h0() && a10) {
                        d.I1(i12, constraintWidget2, bVar, new b.a(), b.a.f35854k);
                    }
                    ConstraintWidget.DimensionBehaviour y10 = constraintWidget2.y();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (y10 != dimensionBehaviour || a10) {
                        if (!constraintWidget2.h0()) {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.K;
                            if (next == constraintAnchor6 && constraintWidget2.M.f1579f == null) {
                                int e10 = constraintAnchor6.e() + d10;
                                constraintWidget2.w0(e10, constraintWidget2.R() + e10);
                                b(i12, constraintWidget2, bVar, z10);
                            } else {
                                ConstraintAnchor constraintAnchor7 = constraintWidget2.M;
                                if (next == constraintAnchor7 && constraintAnchor6.f1579f == null) {
                                    int e11 = d10 - constraintAnchor7.e();
                                    constraintWidget2.w0(e11 - constraintWidget2.R(), e11);
                                    b(i12, constraintWidget2, bVar, z10);
                                } else if (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor7.f1579f) != null && constraintAnchor3.m() && !constraintWidget2.d0()) {
                                    d(i12, bVar, constraintWidget2, z10);
                                }
                            }
                        }
                    } else if (constraintWidget2.y() == dimensionBehaviour && constraintWidget2.f1626w >= 0 && constraintWidget2.f1625v >= 0 && (constraintWidget2.Q() == 8 || (constraintWidget2.f1621s == 0 && constraintWidget2.t() == 0.0f))) {
                        if (!constraintWidget2.d0() && !constraintWidget2.g0()) {
                            if (((next == constraintWidget2.K && (constraintAnchor5 = constraintWidget2.M.f1579f) != null && constraintAnchor5.m()) || (next == constraintWidget2.M && (constraintAnchor4 = constraintWidget2.K.f1579f) != null && constraintAnchor4.m())) && !constraintWidget2.d0()) {
                                e(i12, constraintWidget, bVar, constraintWidget2, z10);
                            }
                        }
                    }
                }
            }
            if (!(constraintWidget instanceof e)) {
                if (m11.c() != null && m11.m()) {
                    Iterator<ConstraintAnchor> it2 = m11.c().iterator();
                    while (it2.hasNext()) {
                        ConstraintAnchor next2 = it2.next();
                        ConstraintWidget constraintWidget3 = next2.f1577d;
                        int i13 = i10 + 1;
                        boolean a11 = a(i13, constraintWidget3);
                        if (constraintWidget3.h0() && a11) {
                            d.I1(i13, constraintWidget3, bVar, new b.a(), b.a.f35854k);
                        }
                        boolean z11 = (next2 == constraintWidget3.K && (constraintAnchor2 = constraintWidget3.M.f1579f) != null && constraintAnchor2.m()) || (next2 == constraintWidget3.M && (constraintAnchor = constraintWidget3.K.f1579f) != null && constraintAnchor.m());
                        ConstraintWidget.DimensionBehaviour y11 = constraintWidget3.y();
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (y11 != dimensionBehaviour2 || a11) {
                            if (!constraintWidget3.h0()) {
                                ConstraintAnchor constraintAnchor8 = constraintWidget3.K;
                                if (next2 == constraintAnchor8 && constraintWidget3.M.f1579f == null) {
                                    int e12 = constraintAnchor8.e() + d11;
                                    constraintWidget3.w0(e12, constraintWidget3.R() + e12);
                                    b(i13, constraintWidget3, bVar, z10);
                                } else {
                                    ConstraintAnchor constraintAnchor9 = constraintWidget3.M;
                                    if (next2 == constraintAnchor9 && constraintAnchor8.f1579f == null) {
                                        int e13 = d11 - constraintAnchor9.e();
                                        constraintWidget3.w0(e13 - constraintWidget3.R(), e13);
                                        b(i13, constraintWidget3, bVar, z10);
                                    } else if (z11 && !constraintWidget3.d0()) {
                                        d(i13, bVar, constraintWidget3, z10);
                                    }
                                }
                            }
                        } else if (constraintWidget3.y() == dimensionBehaviour2 && constraintWidget3.f1626w >= 0 && constraintWidget3.f1625v >= 0 && (constraintWidget3.Q() == 8 || (constraintWidget3.f1621s == 0 && constraintWidget3.t() == 0.0f))) {
                            if (!constraintWidget3.d0() && !constraintWidget3.g0() && z11 && !constraintWidget3.d0()) {
                                e(i13, constraintWidget, bVar, constraintWidget3, z10);
                            }
                        }
                    }
                }
                constraintWidget.l0();
            }
        }
    }

    private static void c(int i10, a aVar, b.AbstractC0518b bVar, int i11, boolean z10) {
        if (!aVar.k1()) {
            return;
        }
        if (i11 == 0) {
            b(i10 + 1, aVar, bVar, z10);
        } else {
            i(i10 + 1, aVar, bVar);
        }
    }

    private static void d(int i10, b.AbstractC0518b bVar, ConstraintWidget constraintWidget, boolean z10) {
        float w10 = constraintWidget.w();
        int d10 = constraintWidget.K.f1579f.d();
        int d11 = constraintWidget.M.f1579f.d();
        d10 = constraintWidget.K.e() + d10;
        d11 -= constraintWidget.M.e();
        if (d10 == d11) {
            w10 = 0.5f;
        }
        int R = constraintWidget.R();
        int i11 = (d11 - d10) - R;
        if (d10 > d11) {
            i11 = (d10 - d11) - R;
        }
        int i12 = ((int) (i11 > 0 ? (w10 * i11) + 0.5f : w10 * i11)) + d10;
        int i13 = i12 + R;
        if (d10 > d11) {
            i13 = i12 - R;
        }
        constraintWidget.w0(i12, i13);
        b(i10 + 1, constraintWidget, bVar, z10);
    }

    private static void e(int i10, ConstraintWidget constraintWidget, b.AbstractC0518b bVar, ConstraintWidget constraintWidget2, boolean z10) {
        int i11;
        float w10 = constraintWidget2.w();
        int d10 = constraintWidget2.K.f1579f.d() + constraintWidget2.K.e();
        int d11 = constraintWidget2.M.f1579f.d() - constraintWidget2.M.e();
        if (d11 >= d10) {
            int R = constraintWidget2.R();
            if (constraintWidget2.Q() != 8) {
                int i12 = constraintWidget2.f1621s;
                if (i12 == 2) {
                    if (constraintWidget instanceof d) {
                        i11 = constraintWidget.R();
                    } else {
                        i11 = constraintWidget.I().R();
                    }
                    R = (int) (constraintWidget2.w() * 0.5f * i11);
                } else if (i12 == 0) {
                    R = d11 - d10;
                }
                R = Math.max(constraintWidget2.f1625v, R);
                int i13 = constraintWidget2.f1626w;
                if (i13 > 0) {
                    R = Math.min(i13, R);
                }
            }
            int i14 = d10 + ((int) ((w10 * ((d11 - d10) - R)) + 0.5f));
            constraintWidget2.w0(i14, R + i14);
            b(i10 + 1, constraintWidget2, bVar, z10);
        }
    }

    private static void f(int i10, b.AbstractC0518b bVar, ConstraintWidget constraintWidget) {
        float M = constraintWidget.M();
        int d10 = constraintWidget.L.f1579f.d();
        int d11 = constraintWidget.N.f1579f.d();
        d10 = constraintWidget.L.e() + d10;
        d11 -= constraintWidget.N.e();
        if (d10 == d11) {
            M = 0.5f;
        }
        int v10 = constraintWidget.v();
        int i11 = (d11 - d10) - v10;
        if (d10 > d11) {
            i11 = (d10 - d11) - v10;
        }
        int i12 = (int) (i11 > 0 ? (M * i11) + 0.5f : M * i11);
        int i13 = d10 + i12;
        int i14 = i13 + v10;
        if (d10 > d11) {
            i13 = d10 - i12;
            i14 = i13 - v10;
        }
        constraintWidget.z0(i13, i14);
        i(i10 + 1, constraintWidget, bVar);
    }

    private static void g(int i10, ConstraintWidget constraintWidget, b.AbstractC0518b bVar, ConstraintWidget constraintWidget2) {
        int i11;
        float M = constraintWidget2.M();
        int d10 = constraintWidget2.L.f1579f.d() + constraintWidget2.L.e();
        int d11 = constraintWidget2.N.f1579f.d() - constraintWidget2.N.e();
        if (d11 >= d10) {
            int v10 = constraintWidget2.v();
            if (constraintWidget2.Q() != 8) {
                int i12 = constraintWidget2.f1623t;
                if (i12 == 2) {
                    if (constraintWidget instanceof d) {
                        i11 = constraintWidget.v();
                    } else {
                        i11 = constraintWidget.I().v();
                    }
                    v10 = (int) (M * 0.5f * i11);
                } else if (i12 == 0) {
                    v10 = d11 - d10;
                }
                v10 = Math.max(constraintWidget2.f1628y, v10);
                int i13 = constraintWidget2.f1629z;
                if (i13 > 0) {
                    v10 = Math.min(i13, v10);
                }
            }
            int i14 = d10 + ((int) ((M * ((d11 - d10) - v10)) + 0.5f));
            constraintWidget2.z0(i14, v10 + i14);
            i(i10 + 1, constraintWidget2, bVar);
        }
    }

    public static void h(d dVar, b.AbstractC0518b bVar) {
        ConstraintWidget.DimensionBehaviour y10 = dVar.y();
        ConstraintWidget.DimensionBehaviour O = dVar.O();
        f35891b = 0;
        f35892c = 0;
        dVar.p0();
        ArrayList<ConstraintWidget> i12 = dVar.i1();
        int size = i12.size();
        for (int i10 = 0; i10 < size; i10++) {
            i12.get(i10).p0();
        }
        boolean F1 = dVar.F1();
        if (y10 == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.w0(0, dVar.R());
        } else {
            dVar.x0(0);
        }
        boolean z10 = false;
        boolean z11 = false;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = i12.get(i11);
            if (constraintWidget instanceof e) {
                e eVar = (e) constraintWidget;
                if (eVar.j1() == 1) {
                    if (eVar.k1() != -1) {
                        eVar.n1(eVar.k1());
                    } else if (eVar.l1() != -1 && dVar.i0()) {
                        eVar.n1(dVar.R() - eVar.l1());
                    } else if (dVar.i0()) {
                        eVar.n1((int) ((eVar.m1() * dVar.R()) + 0.5f));
                    }
                    z10 = true;
                }
            } else if ((constraintWidget instanceof a) && ((a) constraintWidget).o1() == 0) {
                z11 = true;
            }
        }
        if (z10) {
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget2 = i12.get(i13);
                if (constraintWidget2 instanceof e) {
                    e eVar2 = (e) constraintWidget2;
                    if (eVar2.j1() == 1) {
                        b(0, eVar2, bVar, F1);
                    }
                }
            }
        }
        b(0, dVar, bVar, F1);
        if (z11) {
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget3 = i12.get(i14);
                if (constraintWidget3 instanceof a) {
                    a aVar = (a) constraintWidget3;
                    if (aVar.o1() == 0) {
                        c(0, aVar, bVar, 0, F1);
                    }
                }
            }
        }
        if (O == ConstraintWidget.DimensionBehaviour.FIXED) {
            dVar.z0(0, dVar.v());
        } else {
            dVar.y0(0);
        }
        boolean z12 = false;
        boolean z13 = false;
        for (int i15 = 0; i15 < size; i15++) {
            ConstraintWidget constraintWidget4 = i12.get(i15);
            if (constraintWidget4 instanceof e) {
                e eVar3 = (e) constraintWidget4;
                if (eVar3.j1() == 0) {
                    if (eVar3.k1() != -1) {
                        eVar3.n1(eVar3.k1());
                    } else if (eVar3.l1() != -1 && dVar.j0()) {
                        eVar3.n1(dVar.v() - eVar3.l1());
                    } else if (dVar.j0()) {
                        eVar3.n1((int) ((eVar3.m1() * dVar.v()) + 0.5f));
                    }
                    z12 = true;
                }
            } else if ((constraintWidget4 instanceof a) && ((a) constraintWidget4).o1() == 1) {
                z13 = true;
            }
        }
        if (z12) {
            for (int i16 = 0; i16 < size; i16++) {
                ConstraintWidget constraintWidget5 = i12.get(i16);
                if (constraintWidget5 instanceof e) {
                    e eVar4 = (e) constraintWidget5;
                    if (eVar4.j1() == 0) {
                        i(1, eVar4, bVar);
                    }
                }
            }
        }
        i(0, dVar, bVar);
        if (z13) {
            for (int i17 = 0; i17 < size; i17++) {
                ConstraintWidget constraintWidget6 = i12.get(i17);
                if (constraintWidget6 instanceof a) {
                    a aVar2 = (a) constraintWidget6;
                    if (aVar2.o1() == 1) {
                        c(0, aVar2, bVar, 1, F1);
                    }
                }
            }
        }
        for (int i18 = 0; i18 < size; i18++) {
            ConstraintWidget constraintWidget7 = i12.get(i18);
            if (constraintWidget7.h0() && a(0, constraintWidget7)) {
                d.I1(0, constraintWidget7, bVar, f35890a, b.a.f35854k);
                if (!(constraintWidget7 instanceof e)) {
                    b(0, constraintWidget7, bVar, F1);
                    i(0, constraintWidget7, bVar);
                } else if (((e) constraintWidget7).j1() == 0) {
                    i(0, constraintWidget7, bVar);
                } else {
                    b(0, constraintWidget7, bVar, F1);
                }
            }
        }
    }

    private static void i(int i10, ConstraintWidget constraintWidget, b.AbstractC0518b bVar) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        ConstraintAnchor constraintAnchor5;
        if (!constraintWidget.k0()) {
            f35892c++;
            if (!(constraintWidget instanceof d) && constraintWidget.h0()) {
                int i11 = i10 + 1;
                if (a(i11, constraintWidget)) {
                    d.I1(i11, constraintWidget, bVar, new b.a(), b.a.f35854k);
                }
            }
            ConstraintAnchor m10 = constraintWidget.m(ConstraintAnchor.Type.TOP);
            ConstraintAnchor m11 = constraintWidget.m(ConstraintAnchor.Type.BOTTOM);
            int d10 = m10.d();
            int d11 = m11.d();
            if (m10.c() != null && m10.m()) {
                Iterator<ConstraintAnchor> it = m10.c().iterator();
                while (it.hasNext()) {
                    ConstraintAnchor next = it.next();
                    ConstraintWidget constraintWidget2 = next.f1577d;
                    int i12 = i10 + 1;
                    boolean a10 = a(i12, constraintWidget2);
                    if (constraintWidget2.h0() && a10) {
                        d.I1(i12, constraintWidget2, bVar, new b.a(), b.a.f35854k);
                    }
                    ConstraintWidget.DimensionBehaviour O = constraintWidget2.O();
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (O != dimensionBehaviour || a10) {
                        if (!constraintWidget2.h0()) {
                            ConstraintAnchor constraintAnchor6 = constraintWidget2.L;
                            if (next == constraintAnchor6 && constraintWidget2.N.f1579f == null) {
                                int e10 = constraintAnchor6.e() + d10;
                                constraintWidget2.z0(e10, constraintWidget2.v() + e10);
                                i(i12, constraintWidget2, bVar);
                            } else {
                                ConstraintAnchor constraintAnchor7 = constraintWidget2.N;
                                if (next == constraintAnchor7 && constraintAnchor7.f1579f == null) {
                                    int e11 = d10 - constraintAnchor7.e();
                                    constraintWidget2.z0(e11 - constraintWidget2.v(), e11);
                                    i(i12, constraintWidget2, bVar);
                                } else if (next == constraintAnchor6 && (constraintAnchor3 = constraintAnchor7.f1579f) != null && constraintAnchor3.m()) {
                                    f(i12, bVar, constraintWidget2);
                                }
                            }
                        }
                    } else if (constraintWidget2.O() == dimensionBehaviour && constraintWidget2.f1629z >= 0 && constraintWidget2.f1628y >= 0 && (constraintWidget2.Q() == 8 || (constraintWidget2.f1623t == 0 && constraintWidget2.t() == 0.0f))) {
                        if (!constraintWidget2.f0() && !constraintWidget2.g0()) {
                            if (((next == constraintWidget2.L && (constraintAnchor5 = constraintWidget2.N.f1579f) != null && constraintAnchor5.m()) || (next == constraintWidget2.N && (constraintAnchor4 = constraintWidget2.L.f1579f) != null && constraintAnchor4.m())) && !constraintWidget2.f0()) {
                                g(i12, constraintWidget, bVar, constraintWidget2);
                            }
                        }
                    }
                }
            }
            if (!(constraintWidget instanceof e)) {
                if (m11.c() != null && m11.m()) {
                    Iterator<ConstraintAnchor> it2 = m11.c().iterator();
                    while (it2.hasNext()) {
                        ConstraintAnchor next2 = it2.next();
                        ConstraintWidget constraintWidget3 = next2.f1577d;
                        int i13 = i10 + 1;
                        boolean a11 = a(i13, constraintWidget3);
                        if (constraintWidget3.h0() && a11) {
                            d.I1(i13, constraintWidget3, bVar, new b.a(), b.a.f35854k);
                        }
                        boolean z10 = (next2 == constraintWidget3.L && (constraintAnchor2 = constraintWidget3.N.f1579f) != null && constraintAnchor2.m()) || (next2 == constraintWidget3.N && (constraintAnchor = constraintWidget3.L.f1579f) != null && constraintAnchor.m());
                        ConstraintWidget.DimensionBehaviour O2 = constraintWidget3.O();
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                        if (O2 != dimensionBehaviour2 || a11) {
                            if (!constraintWidget3.h0()) {
                                ConstraintAnchor constraintAnchor8 = constraintWidget3.L;
                                if (next2 == constraintAnchor8 && constraintWidget3.N.f1579f == null) {
                                    int e12 = constraintAnchor8.e() + d11;
                                    constraintWidget3.z0(e12, constraintWidget3.v() + e12);
                                    i(i13, constraintWidget3, bVar);
                                } else {
                                    ConstraintAnchor constraintAnchor9 = constraintWidget3.N;
                                    if (next2 == constraintAnchor9 && constraintAnchor8.f1579f == null) {
                                        int e13 = d11 - constraintAnchor9.e();
                                        constraintWidget3.z0(e13 - constraintWidget3.v(), e13);
                                        i(i13, constraintWidget3, bVar);
                                    } else if (z10 && !constraintWidget3.f0()) {
                                        f(i13, bVar, constraintWidget3);
                                    }
                                }
                            }
                        } else if (constraintWidget3.O() == dimensionBehaviour2 && constraintWidget3.f1629z >= 0 && constraintWidget3.f1628y >= 0 && (constraintWidget3.Q() == 8 || (constraintWidget3.f1623t == 0 && constraintWidget3.t() == 0.0f))) {
                            if (!constraintWidget3.f0() && !constraintWidget3.g0() && z10 && !constraintWidget3.f0()) {
                                g(i13, constraintWidget, bVar, constraintWidget3);
                            }
                        }
                    }
                }
                ConstraintAnchor m12 = constraintWidget.m(ConstraintAnchor.Type.BASELINE);
                if (m12.c() != null && m12.m()) {
                    int d12 = m12.d();
                    Iterator<ConstraintAnchor> it3 = m12.c().iterator();
                    while (it3.hasNext()) {
                        ConstraintAnchor next3 = it3.next();
                        ConstraintWidget constraintWidget4 = next3.f1577d;
                        int i14 = i10 + 1;
                        boolean a12 = a(i14, constraintWidget4);
                        if (constraintWidget4.h0() && a12) {
                            d.I1(i14, constraintWidget4, bVar, new b.a(), b.a.f35854k);
                        }
                        if (constraintWidget4.O() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || a12) {
                            if (!constraintWidget4.h0() && next3 == constraintWidget4.O) {
                                constraintWidget4.v0(next3.e() + d12);
                                i(i14, constraintWidget4, bVar);
                            }
                        }
                    }
                }
                constraintWidget.m0();
            }
        }
    }
}
