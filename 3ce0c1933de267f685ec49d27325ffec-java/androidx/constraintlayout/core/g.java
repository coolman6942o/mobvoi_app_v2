package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
import java.util.Comparator;
/* compiled from: PriorityGoalRow.java */
/* loaded from: classes.dex */
public class g extends androidx.constraintlayout.core.b {

    /* renamed from: g  reason: collision with root package name */
    private int f1554g = 128;

    /* renamed from: h  reason: collision with root package name */
    private SolverVariable[] f1555h = new SolverVariable[128];

    /* renamed from: i  reason: collision with root package name */
    private SolverVariable[] f1556i = new SolverVariable[128];

    /* renamed from: j  reason: collision with root package name */
    private int f1557j = 0;

    /* renamed from: k  reason: collision with root package name */
    b f1558k = new b(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PriorityGoalRow.java */
    /* loaded from: classes.dex */
    public class a implements Comparator<SolverVariable> {
        a(g gVar) {
        }

        /* renamed from: a */
        public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
            return solverVariable.f1490c - solverVariable2.f1490c;
        }
    }

    /* compiled from: PriorityGoalRow.java */
    /* loaded from: classes.dex */
    class b {

        /* renamed from: a  reason: collision with root package name */
        SolverVariable f1559a;

        public b(g gVar) {
        }

        public boolean a(SolverVariable solverVariable, float f10) {
            boolean z10 = true;
            if (this.f1559a.f1488a) {
                for (int i10 = 0; i10 < 9; i10++) {
                    float[] fArr = this.f1559a.f1496i;
                    fArr[i10] = fArr[i10] + (solverVariable.f1496i[i10] * f10);
                    if (Math.abs(fArr[i10]) < 1.0E-4f) {
                        this.f1559a.f1496i[i10] = 0.0f;
                    } else {
                        z10 = false;
                    }
                }
                if (z10) {
                    g.this.G(this.f1559a);
                }
                return false;
            }
            for (int i11 = 0; i11 < 9; i11++) {
                float f11 = solverVariable.f1496i[i11];
                if (f11 != 0.0f) {
                    float f12 = f11 * f10;
                    if (Math.abs(f12) < 1.0E-4f) {
                        f12 = 0.0f;
                    }
                    this.f1559a.f1496i[i11] = f12;
                } else {
                    this.f1559a.f1496i[i11] = 0.0f;
                }
            }
            return true;
        }

        public void b(SolverVariable solverVariable) {
            this.f1559a = solverVariable;
        }

        public final boolean c() {
            for (int i10 = 8; i10 >= 0; i10--) {
                float f10 = this.f1559a.f1496i[i10];
                if (f10 > 0.0f) {
                    return false;
                }
                if (f10 < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean d(SolverVariable solverVariable) {
            int i10 = 8;
            while (true) {
                if (i10 < 0) {
                    break;
                }
                float f10 = solverVariable.f1496i[i10];
                float f11 = this.f1559a.f1496i[i10];
                if (f11 == f10) {
                    i10--;
                } else if (f11 < f10) {
                    return true;
                }
            }
            return false;
        }

        public void e() {
            Arrays.fill(this.f1559a.f1496i, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.f1559a != null) {
                for (int i10 = 0; i10 < 9; i10++) {
                    str = str + this.f1559a.f1496i[i10] + " ";
                }
            }
            return str + "] " + this.f1559a;
        }
    }

    public g(c cVar) {
        super(cVar);
    }

    private final void F(SolverVariable solverVariable) {
        int i10;
        int i11 = this.f1557j + 1;
        SolverVariable[] solverVariableArr = this.f1555h;
        if (i11 > solverVariableArr.length) {
            SolverVariable[] solverVariableArr2 = (SolverVariable[]) Arrays.copyOf(solverVariableArr, solverVariableArr.length * 2);
            this.f1555h = solverVariableArr2;
            this.f1556i = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
        }
        SolverVariable[] solverVariableArr3 = this.f1555h;
        int i12 = this.f1557j;
        solverVariableArr3[i12] = solverVariable;
        int i13 = i12 + 1;
        this.f1557j = i13;
        if (i13 > 1 && solverVariableArr3[i13 - 1].f1490c > solverVariable.f1490c) {
            int i14 = 0;
            while (true) {
                i10 = this.f1557j;
                if (i14 >= i10) {
                    break;
                }
                this.f1556i[i14] = this.f1555h[i14];
                i14++;
            }
            Arrays.sort(this.f1556i, 0, i10, new a(this));
            for (int i15 = 0; i15 < this.f1557j; i15++) {
                this.f1555h[i15] = this.f1556i[i15];
            }
        }
        solverVariable.f1488a = true;
        solverVariable.a(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        r5.f1557j = r2 - 1;
        r6.f1488a = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        r2 = r5.f1557j;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r1 >= (r2 - 1)) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r2 = r5.f1555h;
        r3 = r1 + 1;
        r2[r1] = r2[r3];
        r1 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void G(SolverVariable solverVariable) {
        int i10 = 0;
        while (i10 < this.f1557j) {
            if (this.f1555h[i10] == solverVariable) {
                break;
            }
            i10++;
        }
    }

    @Override // androidx.constraintlayout.core.b
    public void B(d dVar, androidx.constraintlayout.core.b bVar, boolean z10) {
        SolverVariable solverVariable = bVar.f1516a;
        if (solverVariable != null) {
            b.a aVar = bVar.f1520e;
            int a10 = aVar.a();
            for (int i10 = 0; i10 < a10; i10++) {
                SolverVariable e10 = aVar.e(i10);
                float h10 = aVar.h(i10);
                this.f1558k.b(e10);
                if (this.f1558k.a(solverVariable, h10)) {
                    F(e10);
                }
                this.f1517b += bVar.f1517b * h10;
            }
            G(solverVariable);
        }
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public SolverVariable b(d dVar, boolean[] zArr) {
        int i10 = -1;
        for (int i11 = 0; i11 < this.f1557j; i11++) {
            SolverVariable solverVariable = this.f1555h[i11];
            if (!zArr[solverVariable.f1490c]) {
                this.f1558k.b(solverVariable);
                if (i10 == -1) {
                    if (!this.f1558k.c()) {
                    }
                    i10 = i11;
                } else {
                    if (!this.f1558k.d(this.f1555h[i10])) {
                    }
                    i10 = i11;
                }
            }
        }
        if (i10 == -1) {
            return null;
        }
        return this.f1555h[i10];
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void c(SolverVariable solverVariable) {
        this.f1558k.b(solverVariable);
        this.f1558k.e();
        solverVariable.f1496i[solverVariable.f1492e] = 1.0f;
        F(solverVariable);
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public void clear() {
        this.f1557j = 0;
        this.f1517b = 0.0f;
    }

    @Override // androidx.constraintlayout.core.b, androidx.constraintlayout.core.d.a
    public boolean isEmpty() {
        return this.f1557j == 0;
    }

    @Override // androidx.constraintlayout.core.b
    public String toString() {
        String str = " goal -> (" + this.f1517b + ") : ";
        for (int i10 = 0; i10 < this.f1557j; i10++) {
            this.f1558k.b(this.f1555h[i10]);
            str = str + this.f1558k + " ";
        }
        return str;
    }
}
