package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.Arrays;
import java.util.HashMap;
/* compiled from: LinearSystem.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: r  reason: collision with root package name */
    public static boolean f1526r = false;

    /* renamed from: s  reason: collision with root package name */
    public static boolean f1527s = true;

    /* renamed from: t  reason: collision with root package name */
    public static boolean f1528t = true;

    /* renamed from: u  reason: collision with root package name */
    public static boolean f1529u = true;

    /* renamed from: v  reason: collision with root package name */
    public static boolean f1530v = false;

    /* renamed from: w  reason: collision with root package name */
    private static int f1531w = 1000;

    /* renamed from: x  reason: collision with root package name */
    public static r.a f1532x;

    /* renamed from: y  reason: collision with root package name */
    public static long f1533y;

    /* renamed from: z  reason: collision with root package name */
    public static long f1534z;

    /* renamed from: d  reason: collision with root package name */
    private a f1538d;

    /* renamed from: g  reason: collision with root package name */
    androidx.constraintlayout.core.b[] f1541g;

    /* renamed from: n  reason: collision with root package name */
    final c f1548n;

    /* renamed from: q  reason: collision with root package name */
    private a f1551q;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1535a = false;

    /* renamed from: b  reason: collision with root package name */
    int f1536b = 0;

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, SolverVariable> f1537c = null;

    /* renamed from: e  reason: collision with root package name */
    private int f1539e = 32;

    /* renamed from: f  reason: collision with root package name */
    private int f1540f = 32;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1542h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1543i = false;

    /* renamed from: j  reason: collision with root package name */
    private boolean[] f1544j = new boolean[32];

    /* renamed from: k  reason: collision with root package name */
    int f1545k = 1;

    /* renamed from: l  reason: collision with root package name */
    int f1546l = 0;

    /* renamed from: m  reason: collision with root package name */
    private int f1547m = 32;

    /* renamed from: o  reason: collision with root package name */
    private SolverVariable[] f1549o = new SolverVariable[f1531w];

    /* renamed from: p  reason: collision with root package name */
    private int f1550p = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(a aVar);

        SolverVariable b(d dVar, boolean[] zArr);

        void c(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LinearSystem.java */
    /* loaded from: classes.dex */
    public class b extends androidx.constraintlayout.core.b {
        public b(d dVar, c cVar) {
            this.f1520e = new h(this, cVar);
        }
    }

    public d() {
        this.f1541g = null;
        this.f1541g = new androidx.constraintlayout.core.b[32];
        C();
        c cVar = new c();
        this.f1548n = cVar;
        this.f1538d = new g(cVar);
        if (f1530v) {
            this.f1551q = new b(this, cVar);
        } else {
            this.f1551q = new androidx.constraintlayout.core.b(cVar);
        }
    }

    private final int B(a aVar, boolean z10) {
        for (int i10 = 0; i10 < this.f1545k; i10++) {
            this.f1544j[i10] = false;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            if (i11 >= this.f1545k * 2) {
                return i11;
            }
            if (aVar.getKey() != null) {
                this.f1544j[aVar.getKey().f1490c] = true;
            }
            SolverVariable b10 = aVar.b(this, this.f1544j);
            if (b10 != null) {
                boolean[] zArr = this.f1544j;
                int i12 = b10.f1490c;
                if (zArr[i12]) {
                    return i11;
                }
                zArr[i12] = true;
            }
            if (b10 != null) {
                float f10 = Float.MAX_VALUE;
                int i13 = -1;
                for (int i14 = 0; i14 < this.f1546l; i14++) {
                    androidx.constraintlayout.core.b bVar = this.f1541g[i14];
                    if (bVar.f1516a.f1497j != SolverVariable.Type.UNRESTRICTED && !bVar.f1521f && bVar.t(b10)) {
                        float j10 = bVar.f1520e.j(b10);
                        if (j10 < 0.0f) {
                            float f11 = (-bVar.f1517b) / j10;
                            if (f11 < f10) {
                                i13 = i14;
                                f10 = f11;
                            }
                        }
                    }
                }
                if (i13 > -1) {
                    androidx.constraintlayout.core.b bVar2 = this.f1541g[i13];
                    bVar2.f1516a.f1491d = -1;
                    bVar2.x(b10);
                    SolverVariable solverVariable = bVar2.f1516a;
                    solverVariable.f1491d = i13;
                    solverVariable.h(this, bVar2);
                }
            } else {
                z11 = true;
            }
        }
        return i11;
    }

    private void C() {
        int i10 = 0;
        if (f1530v) {
            while (i10 < this.f1546l) {
                androidx.constraintlayout.core.b bVar = this.f1541g[i10];
                if (bVar != null) {
                    this.f1548n.f1522a.a(bVar);
                }
                this.f1541g[i10] = null;
                i10++;
            }
            return;
        }
        while (i10 < this.f1546l) {
            androidx.constraintlayout.core.b bVar2 = this.f1541g[i10];
            if (bVar2 != null) {
                this.f1548n.f1523b.a(bVar2);
            }
            this.f1541g[i10] = null;
            i10++;
        }
    }

    private SolverVariable a(SolverVariable.Type type, String str) {
        SolverVariable b10 = this.f1548n.f1524c.b();
        if (b10 == null) {
            b10 = new SolverVariable(type, str);
            b10.g(type, str);
        } else {
            b10.e();
            b10.g(type, str);
        }
        int i10 = this.f1550p;
        int i11 = f1531w;
        if (i10 >= i11) {
            int i12 = i11 * 2;
            f1531w = i12;
            this.f1549o = (SolverVariable[]) Arrays.copyOf(this.f1549o, i12);
        }
        SolverVariable[] solverVariableArr = this.f1549o;
        int i13 = this.f1550p;
        this.f1550p = i13 + 1;
        solverVariableArr[i13] = b10;
        return b10;
    }

    private final void l(androidx.constraintlayout.core.b bVar) {
        int i10;
        if (!f1528t || !bVar.f1521f) {
            androidx.constraintlayout.core.b[] bVarArr = this.f1541g;
            int i11 = this.f1546l;
            bVarArr[i11] = bVar;
            SolverVariable solverVariable = bVar.f1516a;
            solverVariable.f1491d = i11;
            this.f1546l = i11 + 1;
            solverVariable.h(this, bVar);
        } else {
            bVar.f1516a.f(this, bVar.f1517b);
        }
        if (f1528t && this.f1535a) {
            int i12 = 0;
            while (i12 < this.f1546l) {
                if (this.f1541g[i12] == null) {
                    System.out.println("WTF");
                }
                androidx.constraintlayout.core.b[] bVarArr2 = this.f1541g;
                if (bVarArr2[i12] != null && bVarArr2[i12].f1521f) {
                    androidx.constraintlayout.core.b bVar2 = bVarArr2[i12];
                    bVar2.f1516a.f(this, bVar2.f1517b);
                    if (f1530v) {
                        this.f1548n.f1522a.a(bVar2);
                    } else {
                        this.f1548n.f1523b.a(bVar2);
                    }
                    this.f1541g[i12] = null;
                    int i13 = i12 + 1;
                    int i14 = i13;
                    while (true) {
                        i10 = this.f1546l;
                        if (i13 >= i10) {
                            break;
                        }
                        androidx.constraintlayout.core.b[] bVarArr3 = this.f1541g;
                        int i15 = i13 - 1;
                        bVarArr3[i15] = bVarArr3[i13];
                        if (bVarArr3[i15].f1516a.f1491d == i13) {
                            bVarArr3[i15].f1516a.f1491d = i15;
                        }
                        i13++;
                        i14 = i13;
                    }
                    if (i14 < i10) {
                        this.f1541g[i14] = null;
                    }
                    this.f1546l = i10 - 1;
                    i12--;
                }
                i12++;
            }
            this.f1535a = false;
        }
    }

    private void n() {
        for (int i10 = 0; i10 < this.f1546l; i10++) {
            androidx.constraintlayout.core.b bVar = this.f1541g[i10];
            bVar.f1516a.f1493f = bVar.f1517b;
        }
    }

    public static androidx.constraintlayout.core.b s(d dVar, SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        return dVar.r().j(solverVariable, solverVariable2, f10);
    }

    private int u(a aVar) throws Exception {
        boolean z10;
        int i10 = 0;
        while (true) {
            if (i10 >= this.f1546l) {
                z10 = false;
                break;
            }
            androidx.constraintlayout.core.b[] bVarArr = this.f1541g;
            if (bVarArr[i10].f1516a.f1497j != SolverVariable.Type.UNRESTRICTED && bVarArr[i10].f1517b < 0.0f) {
                z10 = true;
                break;
            }
            i10++;
        }
        if (!z10) {
            return 0;
        }
        boolean z11 = false;
        int i11 = 0;
        while (!z11) {
            i11++;
            float f10 = Float.MAX_VALUE;
            int i12 = -1;
            int i13 = -1;
            int i14 = 0;
            for (int i15 = 0; i15 < this.f1546l; i15++) {
                androidx.constraintlayout.core.b bVar = this.f1541g[i15];
                if (bVar.f1516a.f1497j != SolverVariable.Type.UNRESTRICTED && !bVar.f1521f && bVar.f1517b < 0.0f) {
                    int i16 = 9;
                    if (f1529u) {
                        int a10 = bVar.f1520e.a();
                        int i17 = 0;
                        while (i17 < a10) {
                            SolverVariable e10 = bVar.f1520e.e(i17);
                            float j10 = bVar.f1520e.j(e10);
                            if (j10 > 0.0f) {
                                int i18 = 0;
                                while (i18 < i16) {
                                    float f11 = e10.f1495h[i18] / j10;
                                    if ((f11 < f10 && i18 == i14) || i18 > i14) {
                                        i13 = e10.f1490c;
                                        i14 = i18;
                                        i12 = i15;
                                        f10 = f11;
                                    }
                                    i18++;
                                    i16 = 9;
                                }
                            }
                            i17++;
                            i16 = 9;
                        }
                    } else {
                        for (int i19 = 1; i19 < this.f1545k; i19++) {
                            SolverVariable solverVariable = this.f1548n.f1525d[i19];
                            float j11 = bVar.f1520e.j(solverVariable);
                            if (j11 > 0.0f) {
                                for (int i20 = 0; i20 < 9; i20++) {
                                    float f12 = solverVariable.f1495h[i20] / j11;
                                    if ((f12 < f10 && i20 == i14) || i20 > i14) {
                                        i13 = i19;
                                        i12 = i15;
                                        i14 = i20;
                                        f10 = f12;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (i12 != -1) {
                androidx.constraintlayout.core.b bVar2 = this.f1541g[i12];
                bVar2.f1516a.f1491d = -1;
                bVar2.x(this.f1548n.f1525d[i13]);
                SolverVariable solverVariable2 = bVar2.f1516a;
                solverVariable2.f1491d = i12;
                solverVariable2.h(this, bVar2);
            } else {
                z11 = true;
            }
            if (i11 > this.f1545k / 2) {
                z11 = true;
            }
        }
        return i11;
    }

    public static r.a w() {
        return f1532x;
    }

    private void y() {
        int i10 = this.f1539e * 2;
        this.f1539e = i10;
        this.f1541g = (androidx.constraintlayout.core.b[]) Arrays.copyOf(this.f1541g, i10);
        c cVar = this.f1548n;
        cVar.f1525d = (SolverVariable[]) Arrays.copyOf(cVar.f1525d, this.f1539e);
        int i11 = this.f1539e;
        this.f1544j = new boolean[i11];
        this.f1540f = i11;
        this.f1547m = i11;
    }

    void A(a aVar) throws Exception {
        u(aVar);
        B(aVar, false);
        n();
    }

    public void D() {
        c cVar;
        int i10 = 0;
        while (true) {
            cVar = this.f1548n;
            SolverVariable[] solverVariableArr = cVar.f1525d;
            if (i10 >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i10];
            if (solverVariable != null) {
                solverVariable.e();
            }
            i10++;
        }
        cVar.f1524c.c(this.f1549o, this.f1550p);
        this.f1550p = 0;
        Arrays.fill(this.f1548n.f1525d, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.f1537c;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f1536b = 0;
        this.f1538d.clear();
        this.f1545k = 1;
        for (int i11 = 0; i11 < this.f1546l; i11++) {
            androidx.constraintlayout.core.b[] bVarArr = this.f1541g;
            if (bVarArr[i11] != null) {
                bVarArr[i11].f1518c = false;
            }
        }
        C();
        this.f1546l = 0;
        if (f1530v) {
            this.f1551q = new b(this, this.f1548n);
        } else {
            this.f1551q = new androidx.constraintlayout.core.b(this.f1548n);
        }
    }

    public void b(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f10, int i10) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable q5 = q(constraintWidget.m(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable q10 = q(constraintWidget.m(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable q11 = q(constraintWidget.m(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable q12 = q(constraintWidget.m(type4));
        SolverVariable q13 = q(constraintWidget2.m(type));
        SolverVariable q14 = q(constraintWidget2.m(type2));
        SolverVariable q15 = q(constraintWidget2.m(type3));
        SolverVariable q16 = q(constraintWidget2.m(type4));
        androidx.constraintlayout.core.b r10 = r();
        double d10 = f10;
        double d11 = i10;
        r10.q(q10, q12, q14, q16, (float) (Math.sin(d10) * d11));
        d(r10);
        androidx.constraintlayout.core.b r11 = r();
        r11.q(q5, q11, q13, q15, (float) (Math.cos(d10) * d11));
        d(r11);
    }

    public void c(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11, int i12) {
        androidx.constraintlayout.core.b r10 = r();
        r10.h(solverVariable, solverVariable2, i10, f10, solverVariable3, solverVariable4, i11);
        if (i12 != 8) {
            r10.d(this, i12);
        }
        d(r10);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0082 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void d(androidx.constraintlayout.core.b bVar) {
        SolverVariable v10;
        if (bVar != null) {
            boolean z10 = true;
            if (this.f1546l + 1 >= this.f1547m || this.f1545k + 1 >= this.f1540f) {
                y();
            }
            boolean z11 = false;
            if (!bVar.f1521f) {
                bVar.D(this);
                if (!bVar.isEmpty()) {
                    bVar.r();
                    if (bVar.f(this)) {
                        SolverVariable p10 = p();
                        bVar.f1516a = p10;
                        int i10 = this.f1546l;
                        l(bVar);
                        if (this.f1546l == i10 + 1) {
                            this.f1551q.a(bVar);
                            B(this.f1551q, true);
                            if (p10.f1491d == -1) {
                                if (bVar.f1516a == p10 && (v10 = bVar.v(p10)) != null) {
                                    bVar.x(v10);
                                }
                                if (!bVar.f1521f) {
                                    bVar.f1516a.h(this, bVar);
                                }
                                if (f1530v) {
                                    this.f1548n.f1522a.a(bVar);
                                } else {
                                    this.f1548n.f1523b.a(bVar);
                                }
                                this.f1546l--;
                            }
                            if (!bVar.s()) {
                                z11 = z10;
                            } else {
                                return;
                            }
                        }
                    }
                    z10 = false;
                    if (!bVar.s()) {
                    }
                } else {
                    return;
                }
            }
            if (!z11) {
                l(bVar);
            }
        }
    }

    public androidx.constraintlayout.core.b e(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        if (!f1527s || i11 != 8 || !solverVariable2.f1494g || solverVariable.f1491d != -1) {
            androidx.constraintlayout.core.b r10 = r();
            r10.n(solverVariable, solverVariable2, i10);
            if (i11 != 8) {
                r10.d(this, i11);
            }
            d(r10);
            return r10;
        }
        solverVariable.f(this, solverVariable2.f1493f + i10);
        return null;
    }

    public void f(SolverVariable solverVariable, int i10) {
        if (!f1527s || solverVariable.f1491d != -1) {
            int i11 = solverVariable.f1491d;
            if (i11 != -1) {
                androidx.constraintlayout.core.b bVar = this.f1541g[i11];
                if (bVar.f1521f) {
                    bVar.f1517b = i10;
                } else if (bVar.f1520e.a() == 0) {
                    bVar.f1521f = true;
                    bVar.f1517b = i10;
                } else {
                    androidx.constraintlayout.core.b r10 = r();
                    r10.m(solverVariable, i10);
                    d(r10);
                }
            } else {
                androidx.constraintlayout.core.b r11 = r();
                r11.i(solverVariable, i10);
                d(r11);
            }
        } else {
            float f10 = i10;
            solverVariable.f(this, f10);
            for (int i12 = 0; i12 < this.f1536b + 1; i12++) {
                SolverVariable solverVariable2 = this.f1548n.f1525d[i12];
                if (solverVariable2 != null && solverVariable2.f1501n && solverVariable2.f1502o == solverVariable.f1490c) {
                    solverVariable2.f(this, solverVariable2.f1503p + f10);
                }
            }
        }
    }

    public void g(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        androidx.constraintlayout.core.b r10 = r();
        SolverVariable t10 = t();
        t10.f1492e = 0;
        r10.o(solverVariable, solverVariable2, t10, i10);
        d(r10);
    }

    public void h(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        androidx.constraintlayout.core.b r10 = r();
        SolverVariable t10 = t();
        t10.f1492e = 0;
        r10.o(solverVariable, solverVariable2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f1520e.j(t10) * (-1.0f)), i11);
        }
        d(r10);
    }

    public void i(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, boolean z10) {
        androidx.constraintlayout.core.b r10 = r();
        SolverVariable t10 = t();
        t10.f1492e = 0;
        r10.p(solverVariable, solverVariable2, t10, i10);
        d(r10);
    }

    public void j(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, int i11) {
        androidx.constraintlayout.core.b r10 = r();
        SolverVariable t10 = t();
        t10.f1492e = 0;
        r10.p(solverVariable, solverVariable2, t10, i10);
        if (i11 != 8) {
            m(r10, (int) (r10.f1520e.j(t10) * (-1.0f)), i11);
        }
        d(r10);
    }

    public void k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10, int i10) {
        androidx.constraintlayout.core.b r10 = r();
        r10.k(solverVariable, solverVariable2, solverVariable3, solverVariable4, f10);
        if (i10 != 8) {
            r10.d(this, i10);
        }
        d(r10);
    }

    void m(androidx.constraintlayout.core.b bVar, int i10, int i11) {
        bVar.e(o(i11, null), i10);
    }

    public SolverVariable o(int i10, String str) {
        if (this.f1545k + 1 >= this.f1540f) {
            y();
        }
        SolverVariable a10 = a(SolverVariable.Type.ERROR, str);
        int i11 = this.f1536b + 1;
        this.f1536b = i11;
        this.f1545k++;
        a10.f1490c = i11;
        a10.f1492e = i10;
        this.f1548n.f1525d[i11] = a10;
        this.f1538d.c(a10);
        return a10;
    }

    public SolverVariable p() {
        if (this.f1545k + 1 >= this.f1540f) {
            y();
        }
        SolverVariable a10 = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f1536b + 1;
        this.f1536b = i10;
        this.f1545k++;
        a10.f1490c = i10;
        this.f1548n.f1525d[i10] = a10;
        return a10;
    }

    public SolverVariable q(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.f1545k + 1 >= this.f1540f) {
            y();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.h();
            if (solverVariable == null) {
                constraintAnchor.r(this.f1548n);
                solverVariable = constraintAnchor.h();
            }
            int i10 = solverVariable.f1490c;
            if (i10 == -1 || i10 > this.f1536b || this.f1548n.f1525d[i10] == null) {
                if (i10 != -1) {
                    solverVariable.e();
                }
                int i11 = this.f1536b + 1;
                this.f1536b = i11;
                this.f1545k++;
                solverVariable.f1490c = i11;
                solverVariable.f1497j = SolverVariable.Type.UNRESTRICTED;
                this.f1548n.f1525d[i11] = solverVariable;
            }
        }
        return solverVariable;
    }

    public androidx.constraintlayout.core.b r() {
        androidx.constraintlayout.core.b bVar;
        if (f1530v) {
            bVar = this.f1548n.f1522a.b();
            if (bVar == null) {
                bVar = new b(this, this.f1548n);
                f1534z++;
            } else {
                bVar.y();
            }
        } else {
            bVar = this.f1548n.f1523b.b();
            if (bVar == null) {
                bVar = new androidx.constraintlayout.core.b(this.f1548n);
                f1533y++;
            } else {
                bVar.y();
            }
        }
        SolverVariable.c();
        return bVar;
    }

    public SolverVariable t() {
        if (this.f1545k + 1 >= this.f1540f) {
            y();
        }
        SolverVariable a10 = a(SolverVariable.Type.SLACK, null);
        int i10 = this.f1536b + 1;
        this.f1536b = i10;
        this.f1545k++;
        a10.f1490c = i10;
        this.f1548n.f1525d[i10] = a10;
        return a10;
    }

    public c v() {
        return this.f1548n;
    }

    public int x(Object obj) {
        SolverVariable h10 = ((ConstraintAnchor) obj).h();
        if (h10 != null) {
            return (int) (h10.f1493f + 0.5f);
        }
        return 0;
    }

    public void z() throws Exception {
        if (this.f1538d.isEmpty()) {
            n();
        } else if (this.f1542h || this.f1543i) {
            boolean z10 = false;
            int i10 = 0;
            while (true) {
                if (i10 >= this.f1546l) {
                    z10 = true;
                    break;
                } else if (!this.f1541g[i10].f1521f) {
                    break;
                } else {
                    i10++;
                }
            }
            if (!z10) {
                A(this.f1538d);
            } else {
                n();
            }
        } else {
            A(this.f1538d);
        }
    }
}
