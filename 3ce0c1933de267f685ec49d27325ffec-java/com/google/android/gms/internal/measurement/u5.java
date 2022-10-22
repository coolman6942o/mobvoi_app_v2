package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class u5 extends i<u5> {

    /* renamed from: f  reason: collision with root package name */
    private static volatile u5[] f9708f;

    /* renamed from: c  reason: collision with root package name */
    public Integer f9709c = null;

    /* renamed from: d  reason: collision with root package name */
    public y5[] f9710d = y5.h();

    /* renamed from: e  reason: collision with root package name */
    public v5[] f9711e = v5.h();

    public u5() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static u5[] h() {
        if (f9708f == null) {
            synchronized (m.f9497b) {
                if (f9708f == null) {
                    f9708f = new u5[0];
                }
            }
        }
        return f9708f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        Integer num = this.f9709c;
        if (num != null) {
            a10 += h.w(1, num.intValue());
        }
        y5[] y5VarArr = this.f9710d;
        int i10 = 0;
        if (y5VarArr != null && y5VarArr.length > 0) {
            int i11 = 0;
            while (true) {
                y5[] y5VarArr2 = this.f9710d;
                if (i11 >= y5VarArr2.length) {
                    break;
                }
                y5 y5Var = y5VarArr2[i11];
                if (y5Var != null) {
                    a10 += h.o(2, y5Var);
                }
                i11++;
            }
        }
        v5[] v5VarArr = this.f9711e;
        if (v5VarArr != null && v5VarArr.length > 0) {
            while (true) {
                v5[] v5VarArr2 = this.f9711e;
                if (i10 >= v5VarArr2.length) {
                    break;
                }
                v5 v5Var = v5VarArr2[i10];
                if (v5Var != null) {
                    a10 += h.o(3, v5Var);
                }
                i10++;
            }
        }
        return a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        Integer num = this.f9709c;
        if (num != null) {
            hVar.v(1, num.intValue());
        }
        y5[] y5VarArr = this.f9710d;
        int i10 = 0;
        if (y5VarArr != null && y5VarArr.length > 0) {
            int i11 = 0;
            while (true) {
                y5[] y5VarArr2 = this.f9710d;
                if (i11 >= y5VarArr2.length) {
                    break;
                }
                y5 y5Var = y5VarArr2[i11];
                if (y5Var != null) {
                    hVar.e(2, y5Var);
                }
                i11++;
            }
        }
        v5[] v5VarArr = this.f9711e;
        if (v5VarArr != null && v5VarArr.length > 0) {
            while (true) {
                v5[] v5VarArr2 = this.f9711e;
                if (i10 >= v5VarArr2.length) {
                    break;
                }
                v5 v5Var = v5VarArr2[i10];
                if (v5Var != null) {
                    hVar.e(3, v5Var);
                }
                i10++;
            }
        }
        super.b(hVar);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final /* synthetic */ n c(g gVar) throws IOException {
        while (true) {
            int n10 = gVar.n();
            if (n10 == 0) {
                return this;
            }
            if (n10 == 8) {
                this.f9709c = Integer.valueOf(gVar.p());
            } else if (n10 == 18) {
                int a10 = q.a(gVar, 18);
                y5[] y5VarArr = this.f9710d;
                int length = y5VarArr == null ? 0 : y5VarArr.length;
                int i10 = a10 + length;
                y5[] y5VarArr2 = new y5[i10];
                if (length != 0) {
                    System.arraycopy(y5VarArr, 0, y5VarArr2, 0, length);
                }
                while (length < i10 - 1) {
                    y5VarArr2[length] = new y5();
                    gVar.d(y5VarArr2[length]);
                    gVar.n();
                    length++;
                }
                y5VarArr2[length] = new y5();
                gVar.d(y5VarArr2[length]);
                this.f9710d = y5VarArr2;
            } else if (n10 == 26) {
                int a11 = q.a(gVar, 26);
                v5[] v5VarArr = this.f9711e;
                int length2 = v5VarArr == null ? 0 : v5VarArr.length;
                int i11 = a11 + length2;
                v5[] v5VarArr2 = new v5[i11];
                if (length2 != 0) {
                    System.arraycopy(v5VarArr, 0, v5VarArr2, 0, length2);
                }
                while (length2 < i11 - 1) {
                    v5VarArr2[length2] = new v5();
                    gVar.d(v5VarArr2[length2]);
                    gVar.n();
                    length2++;
                }
                v5VarArr2[length2] = new v5();
                gVar.d(v5VarArr2[length2]);
                this.f9711e = v5VarArr2;
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u5)) {
            return false;
        }
        u5 u5Var = (u5) obj;
        Integer num = this.f9709c;
        if (num == null) {
            if (u5Var.f9709c != null) {
                return false;
            }
        } else if (!num.equals(u5Var.f9709c)) {
            return false;
        }
        if (!m.b(this.f9710d, u5Var.f9710d) || !m.b(this.f9711e, u5Var.f9711e)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(u5Var.f9353b);
        }
        k kVar2 = u5Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (u5.class.getName().hashCode() + 527) * 31;
        Integer num = this.f9709c;
        int i10 = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + m.d(this.f9710d)) * 31) + m.d(this.f9711e)) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode2 + i10;
    }
}
