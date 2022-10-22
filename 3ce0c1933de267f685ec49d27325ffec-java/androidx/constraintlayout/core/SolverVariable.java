package androidx.constraintlayout.core;

import java.util.Arrays;
/* loaded from: classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {

    /* renamed from: q  reason: collision with root package name */
    private static int f1487q = 1;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1488a;

    /* renamed from: b  reason: collision with root package name */
    private String f1489b;

    /* renamed from: f  reason: collision with root package name */
    public float f1493f;

    /* renamed from: j  reason: collision with root package name */
    Type f1497j;

    /* renamed from: c  reason: collision with root package name */
    public int f1490c = -1;

    /* renamed from: d  reason: collision with root package name */
    int f1491d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f1492e = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f1494g = false;

    /* renamed from: h  reason: collision with root package name */
    float[] f1495h = new float[9];

    /* renamed from: i  reason: collision with root package name */
    float[] f1496i = new float[9];

    /* renamed from: k  reason: collision with root package name */
    b[] f1498k = new b[16];

    /* renamed from: l  reason: collision with root package name */
    int f1499l = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f1500m = 0;

    /* renamed from: n  reason: collision with root package name */
    boolean f1501n = false;

    /* renamed from: o  reason: collision with root package name */
    int f1502o = -1;

    /* renamed from: p  reason: collision with root package name */
    float f1503p = 0.0f;

    /* loaded from: classes.dex */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(Type type, String str) {
        this.f1497j = type;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c() {
        f1487q++;
    }

    public final void a(b bVar) {
        int i10 = 0;
        while (true) {
            int i11 = this.f1499l;
            if (i10 >= i11) {
                b[] bVarArr = this.f1498k;
                if (i11 >= bVarArr.length) {
                    this.f1498k = (b[]) Arrays.copyOf(bVarArr, bVarArr.length * 2);
                }
                b[] bVarArr2 = this.f1498k;
                int i12 = this.f1499l;
                bVarArr2[i12] = bVar;
                this.f1499l = i12 + 1;
                return;
            } else if (this.f1498k[i10] != bVar) {
                i10++;
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public int compareTo(SolverVariable solverVariable) {
        return this.f1490c - solverVariable.f1490c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001f, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 >= (r0 - 1)) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000f, code lost:
        r5 = r4.f1498k;
        r2 = r1 + 1;
        r5[r1] = r5[r2];
        r1 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0019, code lost:
        r4.f1499l--;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(b bVar) {
        int i10 = this.f1499l;
        int i11 = 0;
        while (i11 < i10) {
            if (this.f1498k[i11] == bVar) {
                break;
            }
            i11++;
        }
    }

    public void e() {
        this.f1489b = null;
        this.f1497j = Type.UNKNOWN;
        this.f1492e = 0;
        this.f1490c = -1;
        this.f1491d = -1;
        this.f1493f = 0.0f;
        this.f1494g = false;
        this.f1501n = false;
        this.f1502o = -1;
        this.f1503p = 0.0f;
        int i10 = this.f1499l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1498k[i11] = null;
        }
        this.f1499l = 0;
        this.f1500m = 0;
        this.f1488a = false;
        Arrays.fill(this.f1496i, 0.0f);
    }

    public void f(d dVar, float f10) {
        this.f1493f = f10;
        this.f1494g = true;
        this.f1501n = false;
        this.f1502o = -1;
        this.f1503p = 0.0f;
        int i10 = this.f1499l;
        this.f1491d = -1;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1498k[i11].A(dVar, this, false);
        }
        this.f1499l = 0;
    }

    public void g(Type type, String str) {
        this.f1497j = type;
    }

    public final void h(d dVar, b bVar) {
        int i10 = this.f1499l;
        for (int i11 = 0; i11 < i10; i11++) {
            this.f1498k[i11].B(dVar, bVar, false);
        }
        this.f1499l = 0;
    }

    public String toString() {
        if (this.f1489b != null) {
            return "" + this.f1489b;
        }
        return "" + this.f1490c;
    }
}
