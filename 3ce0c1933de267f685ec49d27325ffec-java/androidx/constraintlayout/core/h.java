package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import com.mobvoi.wear.common.base.Constants;
import java.util.Arrays;
/* compiled from: SolverVariableValues.java */
/* loaded from: classes.dex */
public class h implements b.a {

    /* renamed from: m  reason: collision with root package name */
    private static float f1561m = 0.001f;

    /* renamed from: a  reason: collision with root package name */
    private int f1562a = 16;

    /* renamed from: b  reason: collision with root package name */
    private int f1563b = 16;

    /* renamed from: c  reason: collision with root package name */
    int[] f1564c = new int[16];

    /* renamed from: d  reason: collision with root package name */
    int[] f1565d = new int[16];

    /* renamed from: e  reason: collision with root package name */
    int[] f1566e = new int[16];

    /* renamed from: f  reason: collision with root package name */
    float[] f1567f = new float[16];

    /* renamed from: g  reason: collision with root package name */
    int[] f1568g = new int[16];

    /* renamed from: h  reason: collision with root package name */
    int[] f1569h = new int[16];

    /* renamed from: i  reason: collision with root package name */
    int f1570i = 0;

    /* renamed from: j  reason: collision with root package name */
    int f1571j = -1;

    /* renamed from: k  reason: collision with root package name */
    private final b f1572k;

    /* renamed from: l  reason: collision with root package name */
    protected final c f1573l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, c cVar) {
        this.f1572k = bVar;
        this.f1573l = cVar;
        clear();
    }

    private void l(SolverVariable solverVariable, int i10) {
        int[] iArr;
        int i11 = solverVariable.f1490c % this.f1563b;
        int[] iArr2 = this.f1564c;
        int i12 = iArr2[i11];
        if (i12 == -1) {
            iArr2[i11] = i10;
        } else {
            while (true) {
                iArr = this.f1565d;
                if (iArr[i12] == -1) {
                    break;
                }
                i12 = iArr[i12];
            }
            iArr[i12] = i10;
        }
        this.f1565d[i10] = -1;
    }

    private void m(int i10, SolverVariable solverVariable, float f10) {
        this.f1566e[i10] = solverVariable.f1490c;
        this.f1567f[i10] = f10;
        this.f1568g[i10] = -1;
        this.f1569h[i10] = -1;
        solverVariable.a(this.f1572k);
        solverVariable.f1500m++;
        this.f1570i++;
    }

    private int n() {
        for (int i10 = 0; i10 < this.f1562a; i10++) {
            if (this.f1566e[i10] == -1) {
                return i10;
            }
        }
        return -1;
    }

    private void o() {
        int i10 = this.f1562a * 2;
        this.f1566e = Arrays.copyOf(this.f1566e, i10);
        this.f1567f = Arrays.copyOf(this.f1567f, i10);
        this.f1568g = Arrays.copyOf(this.f1568g, i10);
        this.f1569h = Arrays.copyOf(this.f1569h, i10);
        this.f1565d = Arrays.copyOf(this.f1565d, i10);
        for (int i11 = this.f1562a; i11 < i10; i11++) {
            this.f1566e[i11] = -1;
            this.f1565d[i11] = -1;
        }
        this.f1562a = i10;
    }

    private void q(int i10, SolverVariable solverVariable, float f10) {
        int n10 = n();
        m(n10, solverVariable, f10);
        if (i10 != -1) {
            this.f1568g[n10] = i10;
            int[] iArr = this.f1569h;
            iArr[n10] = iArr[i10];
            iArr[i10] = n10;
        } else {
            this.f1568g[n10] = -1;
            if (this.f1570i > 0) {
                this.f1569h[n10] = this.f1571j;
                this.f1571j = n10;
            } else {
                this.f1569h[n10] = -1;
            }
        }
        int[] iArr2 = this.f1569h;
        if (iArr2[n10] != -1) {
            this.f1568g[iArr2[n10]] = n10;
        }
        l(solverVariable, n10);
    }

    private void r(SolverVariable solverVariable) {
        int[] iArr;
        int i10 = solverVariable.f1490c;
        int i11 = i10 % this.f1563b;
        int[] iArr2 = this.f1564c;
        int i12 = iArr2[i11];
        if (i12 != -1) {
            if (this.f1566e[i12] == i10) {
                int[] iArr3 = this.f1565d;
                iArr2[i11] = iArr3[i12];
                iArr3[i12] = -1;
                return;
            }
            while (true) {
                iArr = this.f1565d;
                if (iArr[i12] == -1 || this.f1566e[iArr[i12]] == i10) {
                    break;
                }
                i12 = iArr[i12];
            }
            int i13 = iArr[i12];
            if (i13 != -1 && this.f1566e[i13] == i10) {
                iArr[i12] = iArr[i13];
                iArr[i13] = -1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public int a() {
        return this.f1570i;
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean b(SolverVariable solverVariable) {
        return p(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float c(b bVar, boolean z10) {
        float j10 = j(bVar.f1516a);
        i(bVar.f1516a, z10);
        h hVar = (h) bVar.f1520e;
        int a10 = hVar.a();
        int i10 = 0;
        int i11 = 0;
        while (i10 < a10) {
            int[] iArr = hVar.f1566e;
            if (iArr[i11] != -1) {
                f(this.f1573l.f1525d[iArr[i11]], hVar.f1567f[i11] * j10, z10);
                i10++;
            }
            i11++;
        }
        return j10;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void clear() {
        int i10 = this.f1570i;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable e10 = e(i11);
            if (e10 != null) {
                e10.d(this.f1572k);
            }
        }
        for (int i12 = 0; i12 < this.f1562a; i12++) {
            this.f1566e[i12] = -1;
            this.f1565d[i12] = -1;
        }
        for (int i13 = 0; i13 < this.f1563b; i13++) {
            this.f1564c[i13] = -1;
        }
        this.f1570i = 0;
        this.f1571j = -1;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void d(SolverVariable solverVariable, float f10) {
        float f11 = f1561m;
        if (f10 <= (-f11) || f10 >= f11) {
            if (this.f1570i == 0) {
                m(0, solverVariable, f10);
                l(solverVariable, 0);
                this.f1571j = 0;
                return;
            }
            int p10 = p(solverVariable);
            if (p10 != -1) {
                this.f1567f[p10] = f10;
                return;
            }
            if (this.f1570i + 1 >= this.f1562a) {
                o();
            }
            int i10 = this.f1570i;
            int i11 = this.f1571j;
            int i12 = -1;
            for (int i13 = 0; i13 < i10; i13++) {
                int[] iArr = this.f1566e;
                int i14 = iArr[i11];
                int i15 = solverVariable.f1490c;
                if (i14 == i15) {
                    this.f1567f[i11] = f10;
                    return;
                }
                if (iArr[i11] < i15) {
                    i12 = i11;
                }
                i11 = this.f1569h[i11];
                if (i11 == -1) {
                    break;
                }
            }
            q(i12, solverVariable, f10);
            return;
        }
        i(solverVariable, true);
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable e(int i10) {
        int i11 = this.f1570i;
        if (i11 == 0) {
            return null;
        }
        int i12 = this.f1571j;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10 && i12 != -1) {
                return this.f1573l.f1525d[this.f1566e[i12]];
            }
            i12 = this.f1569h[i12];
            if (i12 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void f(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f1561m;
        if (f10 <= (-f11) || f10 >= f11) {
            int p10 = p(solverVariable);
            if (p10 == -1) {
                d(solverVariable, f10);
                return;
            }
            float[] fArr = this.f1567f;
            fArr[p10] = fArr[p10] + f10;
            float f12 = fArr[p10];
            float f13 = f1561m;
            if (f12 > (-f13) && fArr[p10] < f13) {
                fArr[p10] = 0.0f;
                i(solverVariable, z10);
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public void g() {
        int i10 = this.f1570i;
        int i11 = this.f1571j;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f1567f;
            fArr[i11] = fArr[i11] * (-1.0f);
            i11 = this.f1569h[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public float h(int i10) {
        int i11 = this.f1570i;
        int i12 = this.f1571j;
        for (int i13 = 0; i13 < i11; i13++) {
            if (i13 == i10) {
                return this.f1567f[i12];
            }
            i12 = this.f1569h[i12];
            if (i12 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float i(SolverVariable solverVariable, boolean z10) {
        int p10 = p(solverVariable);
        if (p10 == -1) {
            return 0.0f;
        }
        r(solverVariable);
        float f10 = this.f1567f[p10];
        if (this.f1571j == p10) {
            this.f1571j = this.f1569h[p10];
        }
        this.f1566e[p10] = -1;
        int[] iArr = this.f1568g;
        if (iArr[p10] != -1) {
            int[] iArr2 = this.f1569h;
            iArr2[iArr[p10]] = iArr2[p10];
        }
        int[] iArr3 = this.f1569h;
        if (iArr3[p10] != -1) {
            iArr[iArr3[p10]] = iArr[p10];
        }
        this.f1570i--;
        solverVariable.f1500m--;
        if (z10) {
            solverVariable.d(this.f1572k);
        }
        return f10;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float j(SolverVariable solverVariable) {
        int p10 = p(solverVariable);
        if (p10 != -1) {
            return this.f1567f[p10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void k(float f10) {
        int i10 = this.f1570i;
        int i11 = this.f1571j;
        for (int i12 = 0; i12 < i10; i12++) {
            float[] fArr = this.f1567f;
            fArr[i11] = fArr[i11] / f10;
            i11 = this.f1569h[i11];
            if (i11 == -1) {
                return;
            }
        }
    }

    public int p(SolverVariable solverVariable) {
        int[] iArr;
        if (!(this.f1570i == 0 || solverVariable == null)) {
            int i10 = solverVariable.f1490c;
            int i11 = this.f1564c[i10 % this.f1563b];
            if (i11 == -1) {
                return -1;
            }
            if (this.f1566e[i11] == i10) {
                return i11;
            }
            while (true) {
                iArr = this.f1565d;
                if (iArr[i11] == -1 || this.f1566e[iArr[i11]] == i10) {
                    break;
                }
                i11 = iArr[i11];
            }
            if (iArr[i11] != -1 && this.f1566e[iArr[i11]] == i10) {
                return iArr[i11];
            }
        }
        return -1;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i10 = this.f1570i;
        for (int i11 = 0; i11 < i10; i11++) {
            SolverVariable e10 = e(i11);
            if (e10 != null) {
                String str2 = str + e10 + " = " + h(i11) + " ";
                int p10 = p(e10);
                String str3 = str2 + "[p: ";
                String str4 = (this.f1568g[p10] != -1 ? str3 + this.f1573l.f1525d[this.f1566e[this.f1568g[p10]]] : str3 + Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_NONE) + ", n: ";
                str = (this.f1569h[p10] != -1 ? str4 + this.f1573l.f1525d[this.f1566e[this.f1569h[p10]]] : str4 + Constants.Setting.SUPER_POWER_SAVE_MODE_REASON_NONE) + "]";
            }
        }
        return str + " }";
    }
}
