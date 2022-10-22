package androidx.constraintlayout.core;

import androidx.constraintlayout.core.b;
import java.util.Arrays;
/* compiled from: ArrayLinkedVariables.java */
/* loaded from: classes.dex */
public class a implements b.a {

    /* renamed from: l  reason: collision with root package name */
    private static float f1504l = 0.001f;

    /* renamed from: b  reason: collision with root package name */
    private final b f1506b;

    /* renamed from: c  reason: collision with root package name */
    protected final c f1507c;

    /* renamed from: a  reason: collision with root package name */
    int f1505a = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1508d = 8;

    /* renamed from: e  reason: collision with root package name */
    private SolverVariable f1509e = null;

    /* renamed from: f  reason: collision with root package name */
    private int[] f1510f = new int[8];

    /* renamed from: g  reason: collision with root package name */
    private int[] f1511g = new int[8];

    /* renamed from: h  reason: collision with root package name */
    private float[] f1512h = new float[8];

    /* renamed from: i  reason: collision with root package name */
    private int f1513i = -1;

    /* renamed from: j  reason: collision with root package name */
    private int f1514j = -1;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1515k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar, c cVar) {
        this.f1506b = bVar;
        this.f1507c = cVar;
    }

    @Override // androidx.constraintlayout.core.b.a
    public int a() {
        return this.f1505a;
    }

    @Override // androidx.constraintlayout.core.b.a
    public boolean b(SolverVariable solverVariable) {
        int i10 = this.f1513i;
        if (i10 == -1) {
            return false;
        }
        for (int i11 = 0; i10 != -1 && i11 < this.f1505a; i11++) {
            if (this.f1510f[i10] == solverVariable.f1490c) {
                return true;
            }
            i10 = this.f1511g[i10];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.b.a
    public float c(b bVar, boolean z10) {
        float j10 = j(bVar.f1516a);
        i(bVar.f1516a, z10);
        b.a aVar = bVar.f1520e;
        int a10 = aVar.a();
        for (int i10 = 0; i10 < a10; i10++) {
            SolverVariable e10 = aVar.e(i10);
            f(e10, aVar.j(e10) * j10, z10);
        }
        return j10;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void clear() {
        int i10 = this.f1513i;
        for (int i11 = 0; i10 != -1 && i11 < this.f1505a; i11++) {
            SolverVariable solverVariable = this.f1507c.f1525d[this.f1510f[i10]];
            if (solverVariable != null) {
                solverVariable.d(this.f1506b);
            }
            i10 = this.f1511g[i10];
        }
        this.f1513i = -1;
        this.f1514j = -1;
        this.f1515k = false;
        this.f1505a = 0;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final void d(SolverVariable solverVariable, float f10) {
        if (f10 == 0.0f) {
            i(solverVariable, true);
            return;
        }
        int i10 = this.f1513i;
        if (i10 == -1) {
            this.f1513i = 0;
            this.f1512h[0] = f10;
            this.f1510f[0] = solverVariable.f1490c;
            this.f1511g[0] = -1;
            solverVariable.f1500m++;
            solverVariable.a(this.f1506b);
            this.f1505a++;
            if (!this.f1515k) {
                int i11 = this.f1514j + 1;
                this.f1514j = i11;
                int[] iArr = this.f1510f;
                if (i11 >= iArr.length) {
                    this.f1515k = true;
                    this.f1514j = iArr.length - 1;
                    return;
                }
                return;
            }
            return;
        }
        int i12 = -1;
        for (int i13 = 0; i10 != -1 && i13 < this.f1505a; i13++) {
            int[] iArr2 = this.f1510f;
            int i14 = iArr2[i10];
            int i15 = solverVariable.f1490c;
            if (i14 == i15) {
                this.f1512h[i10] = f10;
                return;
            }
            if (iArr2[i10] < i15) {
                i12 = i10;
            }
            i10 = this.f1511g[i10];
        }
        int i16 = this.f1514j;
        i16++;
        if (this.f1515k) {
            int[] iArr3 = this.f1510f;
            if (iArr3[i16] != -1) {
                i16 = iArr3.length;
            }
        }
        int[] iArr4 = this.f1510f;
        if (i16 >= iArr4.length && this.f1505a < iArr4.length) {
            int i17 = 0;
            while (true) {
                int[] iArr5 = this.f1510f;
                if (i17 >= iArr5.length) {
                    break;
                } else if (iArr5[i17] == -1) {
                    i16 = i17;
                    break;
                } else {
                    i17++;
                }
            }
        }
        int[] iArr6 = this.f1510f;
        if (i16 >= iArr6.length) {
            i16 = iArr6.length;
            int i18 = this.f1508d * 2;
            this.f1508d = i18;
            this.f1515k = false;
            this.f1514j = i16 - 1;
            this.f1512h = Arrays.copyOf(this.f1512h, i18);
            this.f1510f = Arrays.copyOf(this.f1510f, this.f1508d);
            this.f1511g = Arrays.copyOf(this.f1511g, this.f1508d);
        }
        this.f1510f[i16] = solverVariable.f1490c;
        this.f1512h[i16] = f10;
        if (i12 != -1) {
            int[] iArr7 = this.f1511g;
            iArr7[i16] = iArr7[i12];
            iArr7[i12] = i16;
        } else {
            this.f1511g[i16] = this.f1513i;
            this.f1513i = i16;
        }
        solverVariable.f1500m++;
        solverVariable.a(this.f1506b);
        int i19 = this.f1505a + 1;
        this.f1505a = i19;
        if (!this.f1515k) {
            this.f1514j++;
        }
        int[] iArr8 = this.f1510f;
        if (i19 >= iArr8.length) {
            this.f1515k = true;
        }
        if (this.f1514j >= iArr8.length) {
            this.f1515k = true;
            this.f1514j = iArr8.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public SolverVariable e(int i10) {
        int i11 = this.f1513i;
        for (int i12 = 0; i11 != -1 && i12 < this.f1505a; i12++) {
            if (i12 == i10) {
                return this.f1507c.f1525d[this.f1510f[i11]];
            }
            i11 = this.f1511g[i11];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void f(SolverVariable solverVariable, float f10, boolean z10) {
        float f11 = f1504l;
        if (f10 <= (-f11) || f10 >= f11) {
            int i10 = this.f1513i;
            if (i10 == -1) {
                this.f1513i = 0;
                this.f1512h[0] = f10;
                this.f1510f[0] = solverVariable.f1490c;
                this.f1511g[0] = -1;
                solverVariable.f1500m++;
                solverVariable.a(this.f1506b);
                this.f1505a++;
                if (!this.f1515k) {
                    int i11 = this.f1514j + 1;
                    this.f1514j = i11;
                    int[] iArr = this.f1510f;
                    if (i11 >= iArr.length) {
                        this.f1515k = true;
                        this.f1514j = iArr.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int i12 = -1;
            for (int i13 = 0; i10 != -1 && i13 < this.f1505a; i13++) {
                int[] iArr2 = this.f1510f;
                int i14 = iArr2[i10];
                int i15 = solverVariable.f1490c;
                if (i14 == i15) {
                    float[] fArr = this.f1512h;
                    float f12 = fArr[i10] + f10;
                    float f13 = f1504l;
                    if (f12 > (-f13) && f12 < f13) {
                        f12 = 0.0f;
                    }
                    fArr[i10] = f12;
                    if (f12 == 0.0f) {
                        if (i10 == this.f1513i) {
                            this.f1513i = this.f1511g[i10];
                        } else {
                            int[] iArr3 = this.f1511g;
                            iArr3[i12] = iArr3[i10];
                        }
                        if (z10) {
                            solverVariable.d(this.f1506b);
                        }
                        if (this.f1515k) {
                            this.f1514j = i10;
                        }
                        solverVariable.f1500m--;
                        this.f1505a--;
                        return;
                    }
                    return;
                }
                if (iArr2[i10] < i15) {
                    i12 = i10;
                }
                i10 = this.f1511g[i10];
            }
            int i16 = this.f1514j;
            i16++;
            if (this.f1515k) {
                int[] iArr4 = this.f1510f;
                if (iArr4[i16] != -1) {
                    i16 = iArr4.length;
                }
            }
            int[] iArr5 = this.f1510f;
            if (i16 >= iArr5.length && this.f1505a < iArr5.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr6 = this.f1510f;
                    if (i17 >= iArr6.length) {
                        break;
                    } else if (iArr6[i17] == -1) {
                        i16 = i17;
                        break;
                    } else {
                        i17++;
                    }
                }
            }
            int[] iArr7 = this.f1510f;
            if (i16 >= iArr7.length) {
                i16 = iArr7.length;
                int i18 = this.f1508d * 2;
                this.f1508d = i18;
                this.f1515k = false;
                this.f1514j = i16 - 1;
                this.f1512h = Arrays.copyOf(this.f1512h, i18);
                this.f1510f = Arrays.copyOf(this.f1510f, this.f1508d);
                this.f1511g = Arrays.copyOf(this.f1511g, this.f1508d);
            }
            this.f1510f[i16] = solverVariable.f1490c;
            this.f1512h[i16] = f10;
            if (i12 != -1) {
                int[] iArr8 = this.f1511g;
                iArr8[i16] = iArr8[i12];
                iArr8[i12] = i16;
            } else {
                this.f1511g[i16] = this.f1513i;
                this.f1513i = i16;
            }
            solverVariable.f1500m++;
            solverVariable.a(this.f1506b);
            this.f1505a++;
            if (!this.f1515k) {
                this.f1514j++;
            }
            int i19 = this.f1514j;
            int[] iArr9 = this.f1510f;
            if (i19 >= iArr9.length) {
                this.f1515k = true;
                this.f1514j = iArr9.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public void g() {
        int i10 = this.f1513i;
        for (int i11 = 0; i10 != -1 && i11 < this.f1505a; i11++) {
            float[] fArr = this.f1512h;
            fArr[i10] = fArr[i10] * (-1.0f);
            i10 = this.f1511g[i10];
        }
    }

    @Override // androidx.constraintlayout.core.b.a
    public float h(int i10) {
        int i11 = this.f1513i;
        for (int i12 = 0; i11 != -1 && i12 < this.f1505a; i12++) {
            if (i12 == i10) {
                return this.f1512h[i11];
            }
            i11 = this.f1511g[i11];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float i(SolverVariable solverVariable, boolean z10) {
        if (this.f1509e == solverVariable) {
            this.f1509e = null;
        }
        int i10 = this.f1513i;
        if (i10 == -1) {
            return 0.0f;
        }
        int i11 = 0;
        int i12 = -1;
        while (i10 != -1 && i11 < this.f1505a) {
            if (this.f1510f[i10] == solverVariable.f1490c) {
                if (i10 == this.f1513i) {
                    this.f1513i = this.f1511g[i10];
                } else {
                    int[] iArr = this.f1511g;
                    iArr[i12] = iArr[i10];
                }
                if (z10) {
                    solverVariable.d(this.f1506b);
                }
                solverVariable.f1500m--;
                this.f1505a--;
                this.f1510f[i10] = -1;
                if (this.f1515k) {
                    this.f1514j = i10;
                }
                return this.f1512h[i10];
            }
            i10 = this.f1511g[i10];
            i11++;
            i12 = i10;
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public final float j(SolverVariable solverVariable) {
        int i10 = this.f1513i;
        for (int i11 = 0; i10 != -1 && i11 < this.f1505a; i11++) {
            if (this.f1510f[i10] == solverVariable.f1490c) {
                return this.f1512h[i10];
            }
            i10 = this.f1511g[i10];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.b.a
    public void k(float f10) {
        int i10 = this.f1513i;
        for (int i11 = 0; i10 != -1 && i11 < this.f1505a; i11++) {
            float[] fArr = this.f1512h;
            fArr[i10] = fArr[i10] / f10;
            i10 = this.f1511g[i10];
        }
    }

    public String toString() {
        int i10 = this.f1513i;
        String str = "";
        for (int i11 = 0; i10 != -1 && i11 < this.f1505a; i11++) {
            str = ((str + " -> ") + this.f1512h[i10] + " : ") + this.f1507c.f1525d[this.f1510f[i10]];
            i10 = this.f1511g[i10];
        }
        return str;
    }
}
