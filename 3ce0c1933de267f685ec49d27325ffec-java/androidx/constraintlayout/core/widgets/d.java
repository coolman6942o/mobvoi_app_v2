package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import com.realsil.sdk.dfu.DfuException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import v.c;
import w.b;
import w.e;
import w.h;
import w.i;
/* compiled from: ConstraintWidgetContainer.java */
/* loaded from: classes.dex */
public class d extends c {
    int B0;
    int C0;

    /* renamed from: x0  reason: collision with root package name */
    private int f1658x0;

    /* renamed from: v0  reason: collision with root package name */
    b f1656v0 = new b(this);

    /* renamed from: w0  reason: collision with root package name */
    public e f1657w0 = new e(this);

    /* renamed from: y0  reason: collision with root package name */
    protected b.AbstractC0518b f1659y0 = null;

    /* renamed from: z0  reason: collision with root package name */
    private boolean f1660z0 = false;
    protected androidx.constraintlayout.core.d A0 = new androidx.constraintlayout.core.d();
    public int D0 = 0;
    public int E0 = 0;
    c[] F0 = new c[4];
    c[] G0 = new c[4];
    private int H0 = DfuException.ERROR_FILE_IO_EXCEPTION;
    private boolean I0 = false;
    private boolean J0 = false;
    private WeakReference<ConstraintAnchor> K0 = null;
    private WeakReference<ConstraintAnchor> L0 = null;
    private WeakReference<ConstraintAnchor> M0 = null;
    private WeakReference<ConstraintAnchor> N0 = null;
    HashSet<ConstraintWidget> O0 = new HashSet<>();
    public b.a P0 = new b.a();

    public static boolean I1(int i10, ConstraintWidget constraintWidget, b.AbstractC0518b bVar, b.a aVar, int i11) {
        int i12;
        int i13;
        if (bVar == null) {
            return false;
        }
        if (constraintWidget.Q() == 8 || (constraintWidget instanceof e) || (constraintWidget instanceof a)) {
            aVar.f35861e = 0;
            aVar.f35862f = 0;
            return false;
        }
        aVar.f35857a = constraintWidget.y();
        aVar.f35858b = constraintWidget.O();
        aVar.f35859c = constraintWidget.R();
        aVar.f35860d = constraintWidget.v();
        aVar.f35865i = false;
        aVar.f35866j = i11;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = aVar.f35857a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean z10 = dimensionBehaviour == dimensionBehaviour2;
        boolean z11 = aVar.f35858b == dimensionBehaviour2;
        boolean z12 = z10 && constraintWidget.Z > 0.0f;
        boolean z13 = z11 && constraintWidget.Z > 0.0f;
        if (z10 && constraintWidget.V(0) && constraintWidget.f1621s == 0 && !z12) {
            aVar.f35857a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z11 && constraintWidget.f1623t == 0) {
                aVar.f35857a = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z10 = false;
        }
        if (z11 && constraintWidget.V(1) && constraintWidget.f1623t == 0 && !z13) {
            aVar.f35858b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (z10 && constraintWidget.f1621s == 0) {
                aVar.f35858b = ConstraintWidget.DimensionBehaviour.FIXED;
            }
            z11 = false;
        }
        if (constraintWidget.i0()) {
            aVar.f35857a = ConstraintWidget.DimensionBehaviour.FIXED;
            z10 = false;
        }
        if (constraintWidget.j0()) {
            aVar.f35858b = ConstraintWidget.DimensionBehaviour.FIXED;
            z11 = false;
        }
        if (z12) {
            if (constraintWidget.f1624u[0] == 4) {
                aVar.f35857a = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z11) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = aVar.f35858b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour3 == dimensionBehaviour4) {
                    i13 = aVar.f35860d;
                } else {
                    aVar.f35857a = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    bVar.b(constraintWidget, aVar);
                    i13 = aVar.f35862f;
                }
                aVar.f35857a = dimensionBehaviour4;
                aVar.f35859c = (int) (constraintWidget.t() * i13);
            }
        }
        if (z13) {
            if (constraintWidget.f1624u[1] == 4) {
                aVar.f35858b = ConstraintWidget.DimensionBehaviour.FIXED;
            } else if (!z10) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = aVar.f35857a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.FIXED;
                if (dimensionBehaviour5 == dimensionBehaviour6) {
                    i12 = aVar.f35859c;
                } else {
                    aVar.f35858b = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    bVar.b(constraintWidget, aVar);
                    i12 = aVar.f35861e;
                }
                aVar.f35858b = dimensionBehaviour6;
                if (constraintWidget.u() == -1) {
                    aVar.f35860d = (int) (i12 / constraintWidget.t());
                } else {
                    aVar.f35860d = (int) (constraintWidget.t() * i12);
                }
            }
        }
        bVar.b(constraintWidget, aVar);
        constraintWidget.b1(aVar.f35861e);
        constraintWidget.C0(aVar.f35862f);
        constraintWidget.B0(aVar.f35864h);
        constraintWidget.r0(aVar.f35863g);
        aVar.f35866j = b.a.f35854k;
        return aVar.f35865i;
    }

    private void K1() {
        this.D0 = 0;
        this.E0 = 0;
    }

    private void o1(ConstraintWidget constraintWidget) {
        int i10 = this.D0 + 1;
        c[] cVarArr = this.G0;
        if (i10 >= cVarArr.length) {
            this.G0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.G0[this.D0] = new c(constraintWidget, 0, F1());
        this.D0++;
    }

    private void r1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.A0.h(solverVariable, this.A0.q(constraintAnchor), 0, 5);
    }

    private void s1(ConstraintAnchor constraintAnchor, SolverVariable solverVariable) {
        this.A0.h(this.A0.q(constraintAnchor), solverVariable, 0, 5);
    }

    private void t1(ConstraintWidget constraintWidget) {
        int i10 = this.E0 + 1;
        c[] cVarArr = this.F0;
        if (i10 >= cVarArr.length) {
            this.F0 = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        this.F0[this.E0] = new c(constraintWidget, 1, F1());
        this.E0++;
    }

    public int A1() {
        return this.H0;
    }

    public androidx.constraintlayout.core.d B1() {
        return this.A0;
    }

    public void C1() {
        this.f1657w0.j();
    }

    public void D1() {
        this.f1657w0.k();
    }

    public boolean E1() {
        return this.J0;
    }

    public boolean F1() {
        return this.f1660z0;
    }

    public boolean G1() {
        return this.I0;
    }

    public long H1(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        this.B0 = i17;
        this.C0 = i18;
        return this.f1656v0.d(this, i10, i17, i18, i11, i12, i13, i14, i15, i16);
    }

    public boolean J1(int i10) {
        return (this.H0 & i10) == i10;
    }

    public void L1(b.AbstractC0518b bVar) {
        this.f1659y0 = bVar;
        this.f1657w0.n(bVar);
    }

    public void M1(int i10) {
        this.H0 = i10;
        androidx.constraintlayout.core.d.f1526r = J1(512);
    }

    public void N1(int i10) {
        this.f1658x0 = i10;
    }

    public void O1(boolean z10) {
        this.f1660z0 = z10;
    }

    public boolean P1(androidx.constraintlayout.core.d dVar, boolean[] zArr) {
        zArr[2] = false;
        boolean J1 = J1(64);
        h1(dVar, J1);
        int size = this.f35553u0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f35553u0.get(i10);
            constraintWidget.h1(dVar, J1);
            if (constraintWidget.X()) {
                z10 = true;
            }
        }
        return z10;
    }

    public void Q1() {
        this.f1656v0.e(this);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void g1(boolean z10, boolean z11) {
        super.g1(z10, z11);
        int size = this.f35553u0.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f35553u0.get(i10).g1(z10, z11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0312  */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    @Override // v.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void j1() {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        boolean z12;
        ?? r62;
        boolean z13;
        boolean z14;
        int i12;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        int i13 = 0;
        this.f1588b0 = 0;
        this.f1590c0 = 0;
        this.I0 = false;
        this.J0 = false;
        int size = this.f35553u0.size();
        int max = Math.max(0, R());
        int max2 = Math.max(0, v());
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = this.V;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = dimensionBehaviourArr[0];
        if (this.f1658x0 == 0 && f.b(this.H0, 1)) {
            h.h(this, z1());
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget = this.f35553u0.get(i14);
                if (constraintWidget.h0() && !(constraintWidget instanceof e) && !(constraintWidget instanceof a) && !(constraintWidget instanceof g) && !constraintWidget.g0()) {
                    ConstraintWidget.DimensionBehaviour s10 = constraintWidget.s(0);
                    ConstraintWidget.DimensionBehaviour s11 = constraintWidget.s(1);
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    if (((s10 != dimensionBehaviour4 || constraintWidget.f1621s == 1 || s11 != dimensionBehaviour4 || constraintWidget.f1623t == 1) ? null : 1) == null) {
                        I1(0, constraintWidget, this.f1659y0, new b.a(), b.a.f35854k);
                    }
                }
            }
        }
        if (size <= 2 || (!(dimensionBehaviour3 == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) || dimensionBehaviour2 == dimensionBehaviour) || !f.b(this.H0, 1024) || !i.c(this, z1()))) {
            i10 = max2;
            i11 = max;
            z10 = false;
        } else {
            if (dimensionBehaviour3 == dimensionBehaviour) {
                if (max >= R() || max <= 0) {
                    max = R();
                } else {
                    b1(max);
                    this.I0 = true;
                }
            }
            if (dimensionBehaviour2 == dimensionBehaviour) {
                if (max2 >= v() || max2 <= 0) {
                    max2 = v();
                } else {
                    C0(max2);
                    this.J0 = true;
                }
            }
            i10 = max2;
            i11 = max;
            z10 = true;
        }
        Object[] objArr = (J1(64) || J1(128)) ? 1 : null;
        androidx.constraintlayout.core.d dVar = this.A0;
        dVar.f1542h = false;
        dVar.f1543i = false;
        if (!(this.H0 == 0 || objArr == null)) {
            dVar.f1543i = true;
        }
        ArrayList<ConstraintWidget> arrayList = this.f35553u0;
        ConstraintWidget.DimensionBehaviour y10 = y();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        Object[] objArr2 = (y10 == dimensionBehaviour5 || O() == dimensionBehaviour5) ? 1 : null;
        K1();
        for (int i15 = 0; i15 < size; i15++) {
            ConstraintWidget constraintWidget2 = this.f35553u0.get(i15);
            if (constraintWidget2 instanceof c) {
                ((c) constraintWidget2).j1();
            }
        }
        boolean J1 = J1(64);
        boolean z15 = z10;
        int i16 = 0;
        boolean z16 = true;
        while (z16) {
            int i17 = i16 + 1;
            try {
                this.A0.D();
                K1();
                k(this.A0);
                for (int i18 = i13; i18 < size; i18++) {
                    this.f35553u0.get(i18).k(this.A0);
                }
                z16 = n1(this.A0);
                WeakReference<ConstraintAnchor> weakReference = this.K0;
                if (!(weakReference == null || weakReference.get() == null)) {
                    s1(this.K0.get(), this.A0.q(this.L));
                    this.K0 = null;
                }
                WeakReference<ConstraintAnchor> weakReference2 = this.M0;
                if (!(weakReference2 == null || weakReference2.get() == null)) {
                    r1(this.M0.get(), this.A0.q(this.N));
                    this.M0 = null;
                }
                WeakReference<ConstraintAnchor> weakReference3 = this.L0;
                if (!(weakReference3 == null || weakReference3.get() == null)) {
                    s1(this.L0.get(), this.A0.q(this.K));
                    this.L0 = null;
                }
                WeakReference<ConstraintAnchor> weakReference4 = this.N0;
                if (!(weakReference4 == null || weakReference4.get() == null)) {
                    r1(this.N0.get(), this.A0.q(this.M));
                    this.N0 = null;
                }
                if (z16) {
                    this.A0.z();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
                System.out.println("EXCEPTION : " + e10);
            }
            if (z16) {
                z11 = P1(this.A0, f.f1668a);
            } else {
                h1(this.A0, J1);
                for (int i19 = 0; i19 < size; i19++) {
                    this.f35553u0.get(i19).h1(this.A0, J1);
                }
                z11 = false;
            }
            if (objArr2 == null || i17 >= 8 || !f.f1668a[2]) {
                z12 = z11;
            } else {
                int i20 = 0;
                int i21 = 0;
                for (int i22 = 0; i22 < size; i22++) {
                    ConstraintWidget constraintWidget3 = this.f35553u0.get(i22);
                    z11 = z11;
                    i21 = Math.max(i21, constraintWidget3.f1588b0 + constraintWidget3.R());
                    i20 = Math.max(i20, constraintWidget3.f1590c0 + constraintWidget3.v());
                }
                z12 = z11;
                int max3 = Math.max(this.f1594e0, i21);
                int max4 = Math.max(this.f1596f0, i20);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour3 == dimensionBehaviour6 && R() < max3) {
                    b1(max3);
                    this.V[0] = dimensionBehaviour6;
                    z15 = true;
                    z12 = true;
                }
                if (dimensionBehaviour2 == dimensionBehaviour6 && v() < max4) {
                    C0(max4);
                    this.V[1] = dimensionBehaviour6;
                    z15 = true;
                    z12 = true;
                }
            }
            int max5 = Math.max(this.f1594e0, R());
            if (max5 > R()) {
                b1(max5);
                this.V[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                z15 = true;
                z12 = true;
            }
            int max6 = Math.max(this.f1596f0, v());
            if (max6 > v()) {
                C0(max6);
                r62 = 1;
                this.V[1] = ConstraintWidget.DimensionBehaviour.FIXED;
                z13 = true;
                z12 = true;
            } else {
                r62 = 1;
                z13 = z15;
            }
            if (!z13) {
                ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = this.V[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (dimensionBehaviour7 == dimensionBehaviour8 && i11 > 0 && R() > i11) {
                    this.I0 = r62;
                    this.V[0] = ConstraintWidget.DimensionBehaviour.FIXED;
                    b1(i11);
                    boolean z17 = r62 == true ? 1 : 0;
                    Object[] objArr3 = r62 == true ? 1 : 0;
                    z13 = z17;
                    z12 = z13;
                }
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = this.V;
                char c10 = r62 == true ? 1 : 0;
                char c11 = r62 == true ? 1 : 0;
                if (dimensionBehaviourArr2[c10] == dimensionBehaviour8 && i10 > 0 && v() > i10) {
                    this.J0 = r62;
                    this.V[r62] = ConstraintWidget.DimensionBehaviour.FIXED;
                    C0(i10);
                    i12 = 8;
                    z14 = true;
                    z15 = true;
                    z16 = i17 <= i12 ? false : z14;
                    i16 = i17;
                    i13 = 0;
                }
            }
            z15 = z13;
            z14 = z12;
            i12 = 8;
            if (i17 <= i12) {
            }
            i16 = i17;
            i13 = 0;
        }
        this.f35553u0 = arrayList;
        if (z15) {
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr3 = this.V;
            dimensionBehaviourArr3[0] = dimensionBehaviour3;
            dimensionBehaviourArr3[1] = dimensionBehaviour2;
        }
        q0(this.A0.v());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m1(ConstraintWidget constraintWidget, int i10) {
        if (i10 == 0) {
            o1(constraintWidget);
        } else if (i10 == 1) {
            t1(constraintWidget);
        }
    }

    public boolean n1(androidx.constraintlayout.core.d dVar) {
        boolean J1 = J1(64);
        g(dVar, J1);
        int size = this.f35553u0.size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size; i10++) {
            ConstraintWidget constraintWidget = this.f35553u0.get(i10);
            constraintWidget.J0(0, false);
            constraintWidget.J0(1, false);
            if (constraintWidget instanceof a) {
                z10 = true;
            }
        }
        if (z10) {
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget2 = this.f35553u0.get(i11);
                if (constraintWidget2 instanceof a) {
                    ((a) constraintWidget2).p1();
                }
            }
        }
        this.O0.clear();
        for (int i12 = 0; i12 < size; i12++) {
            ConstraintWidget constraintWidget3 = this.f35553u0.get(i12);
            if (constraintWidget3.f()) {
                if (constraintWidget3 instanceof g) {
                    this.O0.add(constraintWidget3);
                } else {
                    constraintWidget3.g(dVar, J1);
                }
            }
        }
        while (this.O0.size() > 0) {
            int size2 = this.O0.size();
            Iterator<ConstraintWidget> it = this.O0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g gVar = (g) it.next();
                if (gVar.l1(this.O0)) {
                    gVar.g(dVar, J1);
                    this.O0.remove(gVar);
                    break;
                }
            }
            if (size2 == this.O0.size()) {
                Iterator<ConstraintWidget> it2 = this.O0.iterator();
                while (it2.hasNext()) {
                    it2.next().g(dVar, J1);
                }
                this.O0.clear();
            }
        }
        if (androidx.constraintlayout.core.d.f1526r) {
            HashSet<ConstraintWidget> hashSet = new HashSet<>();
            for (int i13 = 0; i13 < size; i13++) {
                ConstraintWidget constraintWidget4 = this.f35553u0.get(i13);
                if (!constraintWidget4.f()) {
                    hashSet.add(constraintWidget4);
                }
            }
            e(this, dVar, hashSet, y() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1, false);
            Iterator<ConstraintWidget> it3 = hashSet.iterator();
            while (it3.hasNext()) {
                ConstraintWidget next = it3.next();
                f.a(this, dVar, next);
                next.g(dVar, J1);
            }
        } else {
            for (int i14 = 0; i14 < size; i14++) {
                ConstraintWidget constraintWidget5 = this.f35553u0.get(i14);
                if (constraintWidget5 instanceof d) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget5.V;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.G0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.X0(ConstraintWidget.DimensionBehaviour.FIXED);
                    }
                    constraintWidget5.g(dVar, J1);
                    if (dimensionBehaviour == dimensionBehaviour3) {
                        constraintWidget5.G0(dimensionBehaviour);
                    }
                    if (dimensionBehaviour2 == dimensionBehaviour3) {
                        constraintWidget5.X0(dimensionBehaviour2);
                    }
                } else {
                    f.a(this, dVar, constraintWidget5);
                    if (!constraintWidget5.f()) {
                        constraintWidget5.g(dVar, J1);
                    }
                }
            }
        }
        if (this.D0 > 0) {
            b.b(this, dVar, null, 0);
        }
        if (this.E0 > 0) {
            b.b(this, dVar, null, 1);
        }
        return true;
    }

    @Override // v.c, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void o0() {
        this.A0.D();
        this.B0 = 0;
        this.C0 = 0;
        super.o0();
    }

    public void p1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.N0;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.d() > this.N0.get().d()) {
            this.N0 = new WeakReference<>(constraintAnchor);
        }
    }

    public void q1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.L0;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.d() > this.L0.get().d()) {
            this.L0 = new WeakReference<>(constraintAnchor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.M0;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.d() > this.M0.get().d()) {
            this.M0 = new WeakReference<>(constraintAnchor);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v1(ConstraintAnchor constraintAnchor) {
        WeakReference<ConstraintAnchor> weakReference = this.K0;
        if (weakReference == null || weakReference.get() == null || constraintAnchor.d() > this.K0.get().d()) {
            this.K0 = new WeakReference<>(constraintAnchor);
        }
    }

    public boolean w1(boolean z10) {
        return this.f1657w0.f(z10);
    }

    public boolean x1(boolean z10) {
        return this.f1657w0.g(z10);
    }

    public boolean y1(boolean z10, int i10) {
        return this.f1657w0.h(z10, i10);
    }

    public b.AbstractC0518b z1() {
        return this.f1659y0;
    }
}
