package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class v5 extends i<v5> {

    /* renamed from: h  reason: collision with root package name */
    private static volatile v5[] f9749h;

    /* renamed from: c  reason: collision with root package name */
    public Integer f9750c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f9751d = null;

    /* renamed from: e  reason: collision with root package name */
    public w5[] f9752e = w5.h();

    /* renamed from: f  reason: collision with root package name */
    private Boolean f9753f = null;

    /* renamed from: g  reason: collision with root package name */
    public x5 f9754g = null;

    public v5() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static v5[] h() {
        if (f9749h == null) {
            synchronized (m.f9497b) {
                if (f9749h == null) {
                    f9749h = new v5[0];
                }
            }
        }
        return f9749h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        Integer num = this.f9750c;
        if (num != null) {
            a10 += h.w(1, num.intValue());
        }
        String str = this.f9751d;
        if (str != null) {
            a10 += h.u(2, str);
        }
        w5[] w5VarArr = this.f9752e;
        if (w5VarArr != null && w5VarArr.length > 0) {
            int i10 = 0;
            while (true) {
                w5[] w5VarArr2 = this.f9752e;
                if (i10 >= w5VarArr2.length) {
                    break;
                }
                w5 w5Var = w5VarArr2[i10];
                if (w5Var != null) {
                    a10 += h.o(3, w5Var);
                }
                i10++;
            }
        }
        Boolean bool = this.f9753f;
        if (bool != null) {
            bool.booleanValue();
            a10 += h.l(4) + 1;
        }
        x5 x5Var = this.f9754g;
        return x5Var != null ? a10 + h.o(5, x5Var) : a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        Integer num = this.f9750c;
        if (num != null) {
            hVar.v(1, num.intValue());
        }
        String str = this.f9751d;
        if (str != null) {
            hVar.r(2, str);
        }
        w5[] w5VarArr = this.f9752e;
        if (w5VarArr != null && w5VarArr.length > 0) {
            int i10 = 0;
            while (true) {
                w5[] w5VarArr2 = this.f9752e;
                if (i10 >= w5VarArr2.length) {
                    break;
                }
                w5 w5Var = w5VarArr2[i10];
                if (w5Var != null) {
                    hVar.e(3, w5Var);
                }
                i10++;
            }
        }
        Boolean bool = this.f9753f;
        if (bool != null) {
            hVar.f(4, bool.booleanValue());
        }
        x5 x5Var = this.f9754g;
        if (x5Var != null) {
            hVar.e(5, x5Var);
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
                this.f9750c = Integer.valueOf(gVar.p());
            } else if (n10 == 18) {
                this.f9751d = gVar.b();
            } else if (n10 == 26) {
                int a10 = q.a(gVar, 26);
                w5[] w5VarArr = this.f9752e;
                int length = w5VarArr == null ? 0 : w5VarArr.length;
                int i10 = a10 + length;
                w5[] w5VarArr2 = new w5[i10];
                if (length != 0) {
                    System.arraycopy(w5VarArr, 0, w5VarArr2, 0, length);
                }
                while (length < i10 - 1) {
                    w5VarArr2[length] = new w5();
                    gVar.d(w5VarArr2[length]);
                    gVar.n();
                    length++;
                }
                w5VarArr2[length] = new w5();
                gVar.d(w5VarArr2[length]);
                this.f9752e = w5VarArr2;
            } else if (n10 == 32) {
                this.f9753f = Boolean.valueOf(gVar.o());
            } else if (n10 == 42) {
                if (this.f9754g == null) {
                    this.f9754g = new x5();
                }
                gVar.d(this.f9754g);
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof v5)) {
            return false;
        }
        v5 v5Var = (v5) obj;
        Integer num = this.f9750c;
        if (num == null) {
            if (v5Var.f9750c != null) {
                return false;
            }
        } else if (!num.equals(v5Var.f9750c)) {
            return false;
        }
        String str = this.f9751d;
        if (str == null) {
            if (v5Var.f9751d != null) {
                return false;
            }
        } else if (!str.equals(v5Var.f9751d)) {
            return false;
        }
        if (!m.b(this.f9752e, v5Var.f9752e)) {
            return false;
        }
        Boolean bool = this.f9753f;
        if (bool == null) {
            if (v5Var.f9753f != null) {
                return false;
            }
        } else if (!bool.equals(v5Var.f9753f)) {
            return false;
        }
        x5 x5Var = this.f9754g;
        if (x5Var == null) {
            if (v5Var.f9754g != null) {
                return false;
            }
        } else if (!x5Var.equals(v5Var.f9754g)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(v5Var.f9353b);
        }
        k kVar2 = v5Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (v5.class.getName().hashCode() + 527) * 31;
        Integer num = this.f9750c;
        int i10 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.f9751d;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + m.d(this.f9752e)) * 31;
        Boolean bool = this.f9753f;
        int hashCode4 = hashCode3 + (bool == null ? 0 : bool.hashCode());
        x5 x5Var = this.f9754g;
        int hashCode5 = ((hashCode4 * 31) + (x5Var == null ? 0 : x5Var.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode5 + i10;
    }
}
