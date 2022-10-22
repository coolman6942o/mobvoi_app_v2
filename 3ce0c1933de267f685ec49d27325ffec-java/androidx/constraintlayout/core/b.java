package androidx.constraintlayout.core;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.d;
import java.util.ArrayList;
/* compiled from: ArrayRow.java */
/* loaded from: classes.dex */
public class b implements d.a {

    /* renamed from: c  reason: collision with root package name */
    boolean f1518c;

    /* renamed from: e  reason: collision with root package name */
    public a f1520e;

    /* renamed from: a  reason: collision with root package name */
    SolverVariable f1516a = null;

    /* renamed from: b  reason: collision with root package name */
    float f1517b = 0.0f;

    /* renamed from: d  reason: collision with root package name */
    ArrayList<SolverVariable> f1519d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    boolean f1521f = false;

    /* compiled from: ArrayRow.java */
    /* loaded from: classes.dex */
    public interface a {
        int a();

        boolean b(SolverVariable solverVariable);

        float c(b bVar, boolean z10);

        void clear();

        void d(SolverVariable solverVariable, float f10);

        SolverVariable e(int i10);

        void f(SolverVariable solverVariable, float f10, boolean z10);

        void g();

        float h(int i10);

        float i(SolverVariable solverVariable, boolean z10);

        float j(SolverVariable solverVariable);

        void k(float f10);
    }

    public b() {
    }

    private boolean u(SolverVariable solverVariable, d dVar) {
        return solverVariable.f1500m <= 1;
    }

    private SolverVariable w(boolean[] zArr, SolverVariable solverVariable) {
        SolverVariable.Type type;
        int a10 = this.f1520e.a();
        SolverVariable solverVariable2 = null;
        float f10 = 0.0f;
        for (int i10 = 0; i10 < a10; i10++) {
            float h10 = this.f1520e.h(i10);
            if (h10 < 0.0f) {
                SolverVariable e10 = this.f1520e.e(i10);
                if ((zArr == null || !zArr[e10.f1490c]) && e10 != solverVariable && (((type = e10.f1497j) == SolverVariable.Type.SLACK || type == SolverVariable.Type.ERROR) && h10 < f10)) {
                    f10 = h10;
                    solverVariable2 = e10;
                }
            }
        }
        return solverVariable2;
    }

    public void A(d dVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable != null && solverVariable.f1494g) {
            this.f1517b += solverVariable.f1493f * this.f1520e.j(solverVariable);
            this.f1520e.i(solverVariable, z10);
            if (z10) {
                solverVariable.d(this);
            }
            if (d.f1528t && this.f1520e.a() == 0) {
                this.f1521f = true;
                dVar.f1535a = true;
            }
        }
    }

    public void B(d dVar, b bVar, boolean z10) {
        this.f1517b += bVar.f1517b * this.f1520e.c(bVar, z10);
        if (z10) {
            bVar.f1516a.d(this);
        }
        if (d.f1528t && this.f1516a != null && this.f1520e.a() == 0) {
            this.f1521f = true;
            dVar.f1535a = true;
        }
    }

    public void C(d dVar, SolverVariable solverVariable, boolean z10) {
        if (solverVariable != null && solverVariable.f1501n) {
            float j10 = this.f1520e.j(solverVariable);
            this.f1517b += solverVariable.f1503p * j10;
            this.f1520e.i(solverVariable, z10);
            if (z10) {
                solverVariable.d(this);
            }
            this.f1520e.f(dVar.f1548n.f1525d[solverVariable.f1502o], j10, z10);
            if (d.f1528t && this.f1520e.a() == 0) {
                this.f1521f = true;
                dVar.f1535a = true;
            }
        }
    }

    public void D(d dVar) {
        if (dVar.f1541g.length != 0) {
            boolean z10 = false;
            while (!z10) {
                int a10 = this.f1520e.a();
                for (int i10 = 0; i10 < a10; i10++) {
                    SolverVariable e10 = this.f1520e.e(i10);
                    if (e10.f1491d != -1 || e10.f1494g || e10.f1501n) {
                        this.f1519d.add(e10);
                    }
                }
                int size = this.f1519d.size();
                if (size > 0) {
                    for (int i11 = 0; i11 < size; i11++) {
                        SolverVariable solverVariable = this.f1519d.get(i11);
                        if (solverVariable.f1494g) {
                            A(dVar, solverVariable, true);
                        } else if (solverVariable.f1501n) {
                            C(dVar, solverVariable, true);
                        } else {
                            B(dVar, dVar.f1541g[solverVariable.f1491d], true);
                        }
                    }
                    this.f1519d.clear();
                } else {
                    z10 = true;
                }
            }
            if (d.f1528t && this.f1516a != null && this.f1520e.a() == 0) {
                this.f1521f = true;
                dVar.f1535a = true;
            }
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public void a(d.a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.f1516a = null;
            this.f1520e.clear();
            for (int i10 = 0; i10 < bVar.f1520e.a(); i10++) {
                this.f1520e.f(bVar.f1520e.e(i10), bVar.f1520e.h(i10), true);
            }
        }
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable b(d dVar, boolean[] zArr) {
        return w(zArr, null);
    }

    @Override // androidx.constraintlayout.core.d.a
    public void c(SolverVariable solverVariable) {
        int i10 = solverVariable.f1492e;
        float f10 = 1.0f;
        if (i10 != 1) {
            if (i10 == 2) {
                f10 = 1000.0f;
            } else if (i10 == 3) {
                f10 = 1000000.0f;
            } else if (i10 == 4) {
                f10 = 1.0E9f;
            } else if (i10 == 5) {
                f10 = 1.0E12f;
            }
        }
        this.f1520e.d(solverVariable, f10);
    }

    @Override // androidx.constraintlayout.core.d.a
    public void clear() {
        this.f1520e.clear();
        this.f1516a = null;
        this.f1517b = 0.0f;
    }

    public b d(d dVar, int i10) {
        this.f1520e.d(dVar.o(i10, "ep"), 1.0f);
        this.f1520e.d(dVar.o(i10, "em"), -1.0f);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b e(SolverVariable solverVariable, int i10) {
        this.f1520e.d(solverVariable, i10);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(d dVar) {
        boolean z10;
        SolverVariable g10 = g(dVar);
        if (g10 == null) {
            z10 = true;
        } else {
            x(g10);
            z10 = false;
        }
        if (this.f1520e.a() == 0) {
            this.f1521f = true;
        }
        return z10;
    }

    SolverVariable g(d dVar) {
        boolean u10;
        boolean u11;
        int a10 = this.f1520e.a();
        SolverVariable solverVariable = null;
        boolean z10 = false;
        boolean z11 = false;
        float f10 = 0.0f;
        float f11 = 0.0f;
        SolverVariable solverVariable2 = null;
        for (int i10 = 0; i10 < a10; i10++) {
            float h10 = this.f1520e.h(i10);
            SolverVariable e10 = this.f1520e.e(i10);
            if (e10.f1497j == SolverVariable.Type.UNRESTRICTED) {
                if (solverVariable == null) {
                    u11 = u(e10, dVar);
                } else if (f10 > h10) {
                    u11 = u(e10, dVar);
                } else if (!z10 && u(e10, dVar)) {
                    f10 = h10;
                    solverVariable = e10;
                    z10 = true;
                }
                z10 = u11;
                f10 = h10;
                solverVariable = e10;
            } else if (solverVariable == null && h10 < 0.0f) {
                if (solverVariable2 == null) {
                    u10 = u(e10, dVar);
                } else if (f11 > h10) {
                    u10 = u(e10, dVar);
                } else if (!z11 && u(e10, dVar)) {
                    f11 = h10;
                    solverVariable2 = e10;
                    z11 = true;
                }
                z11 = u10;
                f11 = h10;
                solverVariable2 = e10;
            }
        }
        return solverVariable != null ? solverVariable : solverVariable2;
    }

    @Override // androidx.constraintlayout.core.d.a
    public SolverVariable getKey() {
        return this.f1516a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b h(SolverVariable solverVariable, SolverVariable solverVariable2, int i10, float f10, SolverVariable solverVariable3, SolverVariable solverVariable4, int i11) {
        if (solverVariable2 == solverVariable3) {
            this.f1520e.d(solverVariable, 1.0f);
            this.f1520e.d(solverVariable4, 1.0f);
            this.f1520e.d(solverVariable2, -2.0f);
            return this;
        }
        if (f10 == 0.5f) {
            this.f1520e.d(solverVariable, 1.0f);
            this.f1520e.d(solverVariable2, -1.0f);
            this.f1520e.d(solverVariable3, -1.0f);
            this.f1520e.d(solverVariable4, 1.0f);
            if (i10 > 0 || i11 > 0) {
                this.f1517b = (-i10) + i11;
            }
        } else if (f10 <= 0.0f) {
            this.f1520e.d(solverVariable, -1.0f);
            this.f1520e.d(solverVariable2, 1.0f);
            this.f1517b = i10;
        } else if (f10 >= 1.0f) {
            this.f1520e.d(solverVariable4, -1.0f);
            this.f1520e.d(solverVariable3, 1.0f);
            this.f1517b = -i11;
        } else {
            float f11 = 1.0f - f10;
            this.f1520e.d(solverVariable, f11 * 1.0f);
            this.f1520e.d(solverVariable2, f11 * (-1.0f));
            this.f1520e.d(solverVariable3, (-1.0f) * f10);
            this.f1520e.d(solverVariable4, 1.0f * f10);
            if (i10 > 0 || i11 > 0) {
                this.f1517b = ((-i10) * f11) + (i11 * f10);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b i(SolverVariable solverVariable, int i10) {
        this.f1516a = solverVariable;
        float f10 = i10;
        solverVariable.f1493f = f10;
        this.f1517b = f10;
        this.f1521f = true;
        return this;
    }

    @Override // androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.f1516a == null && this.f1517b == 0.0f && this.f1520e.a() == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b j(SolverVariable solverVariable, SolverVariable solverVariable2, float f10) {
        this.f1520e.d(solverVariable, -1.0f);
        this.f1520e.d(solverVariable2, f10);
        return this;
    }

    public b k(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f1520e.d(solverVariable, -1.0f);
        this.f1520e.d(solverVariable2, 1.0f);
        this.f1520e.d(solverVariable3, f10);
        this.f1520e.d(solverVariable4, -f10);
        return this;
    }

    public b l(float f10, float f11, float f12, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.f1517b = 0.0f;
        if (f11 == 0.0f || f10 == f12) {
            this.f1520e.d(solverVariable, 1.0f);
            this.f1520e.d(solverVariable2, -1.0f);
            this.f1520e.d(solverVariable4, 1.0f);
            this.f1520e.d(solverVariable3, -1.0f);
        } else if (f10 == 0.0f) {
            this.f1520e.d(solverVariable, 1.0f);
            this.f1520e.d(solverVariable2, -1.0f);
        } else if (f12 == 0.0f) {
            this.f1520e.d(solverVariable3, 1.0f);
            this.f1520e.d(solverVariable4, -1.0f);
        } else {
            float f13 = (f10 / f11) / (f12 / f11);
            this.f1520e.d(solverVariable, 1.0f);
            this.f1520e.d(solverVariable2, -1.0f);
            this.f1520e.d(solverVariable4, f13);
            this.f1520e.d(solverVariable3, -f13);
        }
        return this;
    }

    public b m(SolverVariable solverVariable, int i10) {
        if (i10 < 0) {
            this.f1517b = i10 * (-1);
            this.f1520e.d(solverVariable, 1.0f);
        } else {
            this.f1517b = i10;
            this.f1520e.d(solverVariable, -1.0f);
        }
        return this;
    }

    public b n(SolverVariable solverVariable, SolverVariable solverVariable2, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f1517b = i10;
        }
        if (!z10) {
            this.f1520e.d(solverVariable, -1.0f);
            this.f1520e.d(solverVariable2, 1.0f);
        } else {
            this.f1520e.d(solverVariable, 1.0f);
            this.f1520e.d(solverVariable2, -1.0f);
        }
        return this;
    }

    public b o(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f1517b = i10;
        }
        if (!z10) {
            this.f1520e.d(solverVariable, -1.0f);
            this.f1520e.d(solverVariable2, 1.0f);
            this.f1520e.d(solverVariable3, 1.0f);
        } else {
            this.f1520e.d(solverVariable, 1.0f);
            this.f1520e.d(solverVariable2, -1.0f);
            this.f1520e.d(solverVariable3, -1.0f);
        }
        return this;
    }

    public b p(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int i10) {
        boolean z10 = false;
        if (i10 != 0) {
            if (i10 < 0) {
                i10 *= -1;
                z10 = true;
            }
            this.f1517b = i10;
        }
        if (!z10) {
            this.f1520e.d(solverVariable, -1.0f);
            this.f1520e.d(solverVariable2, 1.0f);
            this.f1520e.d(solverVariable3, -1.0f);
        } else {
            this.f1520e.d(solverVariable, 1.0f);
            this.f1520e.d(solverVariable2, -1.0f);
            this.f1520e.d(solverVariable3, 1.0f);
        }
        return this;
    }

    public b q(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f10) {
        this.f1520e.d(solverVariable3, 0.5f);
        this.f1520e.d(solverVariable4, 0.5f);
        this.f1520e.d(solverVariable, -0.5f);
        this.f1520e.d(solverVariable2, -0.5f);
        this.f1517b = -f10;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r() {
        float f10 = this.f1517b;
        if (f10 < 0.0f) {
            this.f1517b = f10 * (-1.0f);
            this.f1520e.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s() {
        SolverVariable solverVariable = this.f1516a;
        return solverVariable != null && (solverVariable.f1497j == SolverVariable.Type.UNRESTRICTED || this.f1517b >= 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(SolverVariable solverVariable) {
        return this.f1520e.b(solverVariable);
    }

    public String toString() {
        return z();
    }

    public SolverVariable v(SolverVariable solverVariable) {
        return w(null, solverVariable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.f1516a;
        if (solverVariable2 != null) {
            this.f1520e.d(solverVariable2, -1.0f);
            this.f1516a.f1491d = -1;
            this.f1516a = null;
        }
        float i10 = this.f1520e.i(solverVariable, true) * (-1.0f);
        this.f1516a = solverVariable;
        if (i10 != 1.0f) {
            this.f1517b /= i10;
            this.f1520e.k(i10);
        }
    }

    public void y() {
        this.f1516a = null;
        this.f1520e.clear();
        this.f1517b = 0.0f;
        this.f1521f = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    String z() {
        boolean z10;
        float h10;
        int i10;
        String str = (this.f1516a == null ? "0" : "" + this.f1516a) + " = ";
        if (this.f1517b != 0.0f) {
            str = str + this.f1517b;
            z10 = true;
        } else {
            z10 = false;
        }
        int a10 = this.f1520e.a();
        for (int i11 = 0; i11 < a10; i11++) {
            SolverVariable e10 = this.f1520e.e(i11);
            if (!(e10 == null || (h10 = this.f1520e.h(i11)) == 0.0f)) {
                String solverVariable = e10.toString();
                if (!z10) {
                    if (h10 < 0.0f) {
                        str = str + "- ";
                        h10 *= -1.0f;
                    }
                    str = h10 == 1.0f ? str + solverVariable : str + h10 + " " + solverVariable;
                    z10 = true;
                } else if (i10 > 0) {
                    str = str + " + ";
                    if (h10 == 1.0f) {
                    }
                    z10 = true;
                } else {
                    str = str + " - ";
                    h10 *= -1.0f;
                    if (h10 == 1.0f) {
                    }
                    z10 = true;
                }
            }
        }
        if (z10) {
            return str;
        }
        return str + "0.0";
    }

    public b(c cVar) {
        this.f1520e = new androidx.constraintlayout.core.a(this, cVar);
    }
}
