package w;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.a;
import androidx.constraintlayout.core.widgets.d;
import androidx.constraintlayout.core.widgets.e;
import java.util.ArrayList;
import java.util.Iterator;
import v.b;
import w.b;
/* compiled from: Grouping.java */
/* loaded from: classes.dex */
public class i {
    public static o a(ConstraintWidget constraintWidget, int i10, ArrayList<o> arrayList, o oVar) {
        int i11;
        int j12;
        if (i10 == 0) {
            i11 = constraintWidget.f1620r0;
        } else {
            i11 = constraintWidget.f1622s0;
        }
        int i12 = 0;
        if (i11 != -1 && (oVar == null || i11 != oVar.f35903b)) {
            int i13 = 0;
            while (true) {
                if (i13 >= arrayList.size()) {
                    break;
                }
                o oVar2 = arrayList.get(i13);
                if (oVar2.c() == i11) {
                    if (oVar != null) {
                        oVar.g(i10, oVar2);
                        arrayList.remove(oVar);
                    }
                    oVar = oVar2;
                } else {
                    i13++;
                }
            }
        } else if (i11 != -1) {
            return oVar;
        }
        if (oVar == null) {
            if ((constraintWidget instanceof b) && (j12 = ((b) constraintWidget).j1(i10)) != -1) {
                int i14 = 0;
                while (true) {
                    if (i14 >= arrayList.size()) {
                        break;
                    }
                    o oVar3 = arrayList.get(i14);
                    if (oVar3.c() == j12) {
                        oVar = oVar3;
                        break;
                    }
                    i14++;
                }
            }
            if (oVar == null) {
                oVar = new o(i10);
            }
            arrayList.add(oVar);
        }
        if (oVar.a(constraintWidget)) {
            if (constraintWidget instanceof e) {
                e eVar = (e) constraintWidget;
                ConstraintAnchor i15 = eVar.i1();
                if (eVar.j1() == 0) {
                    i12 = 1;
                }
                i15.b(i12, arrayList, oVar);
            }
            if (i10 == 0) {
                constraintWidget.f1620r0 = oVar.c();
                constraintWidget.K.b(i10, arrayList, oVar);
                constraintWidget.M.b(i10, arrayList, oVar);
            } else {
                constraintWidget.f1622s0 = oVar.c();
                constraintWidget.L.b(i10, arrayList, oVar);
                constraintWidget.O.b(i10, arrayList, oVar);
                constraintWidget.N.b(i10, arrayList, oVar);
            }
            constraintWidget.R.b(i10, arrayList, oVar);
        }
        return oVar;
    }

    private static o b(ArrayList<o> arrayList, int i10) {
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            o oVar = arrayList.get(i11);
            if (i10 == oVar.f35903b) {
                return oVar;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0390 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean c(d dVar, b.AbstractC0518b bVar) {
        o oVar;
        boolean z10;
        boolean z11;
        o oVar2;
        ArrayList<ConstraintWidget> i12 = dVar.i1();
        int size = i12.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            ConstraintWidget constraintWidget = i12.get(i11);
            if (!d(dVar.y(), dVar.O(), constraintWidget.y(), constraintWidget.O())) {
                return false;
            }
        }
        int i13 = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        ArrayList arrayList4 = null;
        ArrayList arrayList5 = null;
        ArrayList arrayList6 = null;
        while (i13 < size) {
            ConstraintWidget constraintWidget2 = i12.get(i13);
            if (!d(dVar.y(), dVar.O(), constraintWidget2.y(), constraintWidget2.O())) {
                d.I1(i10, constraintWidget2, bVar, dVar.P0, b.a.f35854k);
            }
            boolean z12 = constraintWidget2 instanceof e;
            if (z12) {
                e eVar = (e) constraintWidget2;
                if (eVar.j1() == 0) {
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                    }
                    arrayList3.add(eVar);
                }
                if (eVar.j1() == 1) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(eVar);
                }
            }
            if (constraintWidget2 instanceof v.b) {
                if (constraintWidget2 instanceof a) {
                    a aVar = (a) constraintWidget2;
                    if (aVar.o1() == 0) {
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                        }
                        arrayList2.add(aVar);
                    }
                    if (aVar.o1() == 1) {
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        arrayList4.add(aVar);
                    }
                } else {
                    v.b bVar2 = (v.b) constraintWidget2;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList2.add(bVar2);
                    if (arrayList4 == null) {
                        arrayList4 = new ArrayList();
                    }
                    arrayList4.add(bVar2);
                }
            }
            if (constraintWidget2.K.f1579f == null && constraintWidget2.M.f1579f == null && !z12 && !(constraintWidget2 instanceof a)) {
                if (arrayList5 == null) {
                    arrayList5 = new ArrayList();
                }
                arrayList5.add(constraintWidget2);
            }
            if (constraintWidget2.L.f1579f == null && constraintWidget2.N.f1579f == null && constraintWidget2.O.f1579f == null && !z12 && !(constraintWidget2 instanceof a)) {
                if (arrayList6 == null) {
                    arrayList6 = new ArrayList();
                }
                arrayList6.add(constraintWidget2);
            }
            i13++;
            i10 = 0;
        }
        ArrayList<o> arrayList7 = new ArrayList<>();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                a((e) it.next(), 0, arrayList7, null);
            }
        }
        int i14 = 0;
        o oVar3 = null;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                v.b bVar3 = (v.b) it2.next();
                o a10 = a(bVar3, i14, arrayList7, oVar3);
                bVar3.i1(arrayList7, i14, a10);
                a10.b(arrayList7);
                i14 = 0;
                oVar3 = null;
            }
        }
        ConstraintAnchor m10 = dVar.m(ConstraintAnchor.Type.LEFT);
        if (m10.c() != null) {
            Iterator<ConstraintAnchor> it3 = m10.c().iterator();
            while (it3.hasNext()) {
                a(it3.next().f1577d, 0, arrayList7, null);
            }
        }
        ConstraintAnchor m11 = dVar.m(ConstraintAnchor.Type.RIGHT);
        if (m11.c() != null) {
            Iterator<ConstraintAnchor> it4 = m11.c().iterator();
            while (it4.hasNext()) {
                a(it4.next().f1577d, 0, arrayList7, null);
            }
        }
        ConstraintAnchor m12 = dVar.m(ConstraintAnchor.Type.CENTER);
        if (m12.c() != null) {
            Iterator<ConstraintAnchor> it5 = m12.c().iterator();
            while (it5.hasNext()) {
                a(it5.next().f1577d, 0, arrayList7, null);
            }
        }
        o oVar4 = null;
        if (arrayList5 != null) {
            Iterator it6 = arrayList5.iterator();
            while (it6.hasNext()) {
                a((ConstraintWidget) it6.next(), 0, arrayList7, null);
            }
        }
        if (arrayList3 != null) {
            Iterator it7 = arrayList3.iterator();
            while (it7.hasNext()) {
                a((e) it7.next(), 1, arrayList7, null);
            }
        }
        int i15 = 1;
        if (arrayList4 != null) {
            Iterator it8 = arrayList4.iterator();
            while (it8.hasNext()) {
                v.b bVar4 = (v.b) it8.next();
                o a11 = a(bVar4, i15, arrayList7, oVar4);
                bVar4.i1(arrayList7, i15, a11);
                a11.b(arrayList7);
                i15 = 1;
                oVar4 = null;
            }
        }
        ConstraintAnchor m13 = dVar.m(ConstraintAnchor.Type.TOP);
        if (m13.c() != null) {
            Iterator<ConstraintAnchor> it9 = m13.c().iterator();
            while (it9.hasNext()) {
                a(it9.next().f1577d, 1, arrayList7, null);
            }
        }
        ConstraintAnchor m14 = dVar.m(ConstraintAnchor.Type.BASELINE);
        if (m14.c() != null) {
            Iterator<ConstraintAnchor> it10 = m14.c().iterator();
            while (it10.hasNext()) {
                a(it10.next().f1577d, 1, arrayList7, null);
            }
        }
        ConstraintAnchor m15 = dVar.m(ConstraintAnchor.Type.BOTTOM);
        if (m15.c() != null) {
            Iterator<ConstraintAnchor> it11 = m15.c().iterator();
            while (it11.hasNext()) {
                a(it11.next().f1577d, 1, arrayList7, null);
            }
        }
        ConstraintAnchor m16 = dVar.m(ConstraintAnchor.Type.CENTER);
        if (m16.c() != null) {
            Iterator<ConstraintAnchor> it12 = m16.c().iterator();
            while (it12.hasNext()) {
                a(it12.next().f1577d, 1, arrayList7, null);
            }
        }
        if (arrayList6 != null) {
            Iterator it13 = arrayList6.iterator();
            while (it13.hasNext()) {
                a((ConstraintWidget) it13.next(), 1, arrayList7, null);
            }
        }
        for (int i16 = 0; i16 < size; i16++) {
            ConstraintWidget constraintWidget3 = i12.get(i16);
            if (constraintWidget3.n0()) {
                o b10 = b(arrayList7, constraintWidget3.f1620r0);
                o b11 = b(arrayList7, constraintWidget3.f1622s0);
                if (!(b10 == null || b11 == null)) {
                    b10.g(0, b11);
                    b11.i(2);
                    arrayList7.remove(b10);
                }
            }
        }
        if (arrayList7.size() <= 1) {
            return false;
        }
        if (dVar.y() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
            Iterator<o> it14 = arrayList7.iterator();
            oVar = null;
            int i17 = 0;
            while (it14.hasNext()) {
                o next = it14.next();
                if (next.d() != 1) {
                    next.h(false);
                    int f10 = next.f(dVar.B1(), 0);
                    if (f10 > i17) {
                        oVar = next;
                        i17 = f10;
                    }
                }
            }
            if (oVar != null) {
                dVar.G0(ConstraintWidget.DimensionBehaviour.FIXED);
                dVar.b1(i17);
                oVar.h(true);
                if (dVar.O() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
                    Iterator<o> it15 = arrayList7.iterator();
                    o oVar5 = null;
                    int i18 = 0;
                    while (it15.hasNext()) {
                        o next2 = it15.next();
                        if (next2.d() != 0) {
                            next2.h(false);
                            int f11 = next2.f(dVar.B1(), 1);
                            if (f11 > i18) {
                                oVar5 = next2;
                                i18 = f11;
                            }
                        }
                    }
                    z11 = false;
                    z10 = true;
                    if (oVar5 != null) {
                        dVar.X0(ConstraintWidget.DimensionBehaviour.FIXED);
                        dVar.C0(i18);
                        oVar5.h(true);
                        oVar2 = oVar5;
                        return (oVar == null || oVar2 != null) ? z10 : z11;
                    }
                } else {
                    z11 = false;
                    z10 = true;
                }
                oVar2 = null;
                if (oVar == null) {
                }
            }
        }
        oVar = null;
        if (dVar.O() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) {
        }
        oVar2 = null;
        if (oVar == null) {
        }
    }

    public static boolean d(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.FIXED;
        return (dimensionBehaviour3 == dimensionBehaviour7 || dimensionBehaviour3 == (dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != dimensionBehaviour6)) || (dimensionBehaviour4 == dimensionBehaviour7 || dimensionBehaviour4 == (dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || (dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != dimensionBehaviour5));
    }
}
