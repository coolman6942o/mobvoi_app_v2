package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class b6 extends i<b6> {

    /* renamed from: c  reason: collision with root package name */
    public Long f9184c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f9185d = null;

    /* renamed from: e  reason: collision with root package name */
    private Integer f9186e = null;

    /* renamed from: f  reason: collision with root package name */
    public c6[] f9187f = c6.h();

    /* renamed from: g  reason: collision with root package name */
    public a6[] f9188g = a6.h();

    /* renamed from: h  reason: collision with root package name */
    public u5[] f9189h = u5.h();

    public b6() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        Long l10 = this.f9184c;
        if (l10 != null) {
            a10 += h.t(1, l10.longValue());
        }
        String str = this.f9185d;
        if (str != null) {
            a10 += h.u(2, str);
        }
        Integer num = this.f9186e;
        if (num != null) {
            a10 += h.w(3, num.intValue());
        }
        c6[] c6VarArr = this.f9187f;
        int i10 = 0;
        if (c6VarArr != null && c6VarArr.length > 0) {
            int i11 = 0;
            while (true) {
                c6[] c6VarArr2 = this.f9187f;
                if (i11 >= c6VarArr2.length) {
                    break;
                }
                c6 c6Var = c6VarArr2[i11];
                if (c6Var != null) {
                    a10 += h.o(4, c6Var);
                }
                i11++;
            }
        }
        a6[] a6VarArr = this.f9188g;
        if (a6VarArr != null && a6VarArr.length > 0) {
            int i12 = 0;
            while (true) {
                a6[] a6VarArr2 = this.f9188g;
                if (i12 >= a6VarArr2.length) {
                    break;
                }
                a6 a6Var = a6VarArr2[i12];
                if (a6Var != null) {
                    a10 += h.o(5, a6Var);
                }
                i12++;
            }
        }
        u5[] u5VarArr = this.f9189h;
        if (u5VarArr != null && u5VarArr.length > 0) {
            while (true) {
                u5[] u5VarArr2 = this.f9189h;
                if (i10 >= u5VarArr2.length) {
                    break;
                }
                u5 u5Var = u5VarArr2[i10];
                if (u5Var != null) {
                    a10 += h.o(6, u5Var);
                }
                i10++;
            }
        }
        return a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        Long l10 = this.f9184c;
        if (l10 != null) {
            hVar.q(1, l10.longValue());
        }
        String str = this.f9185d;
        if (str != null) {
            hVar.r(2, str);
        }
        Integer num = this.f9186e;
        if (num != null) {
            hVar.v(3, num.intValue());
        }
        c6[] c6VarArr = this.f9187f;
        int i10 = 0;
        if (c6VarArr != null && c6VarArr.length > 0) {
            int i11 = 0;
            while (true) {
                c6[] c6VarArr2 = this.f9187f;
                if (i11 >= c6VarArr2.length) {
                    break;
                }
                c6 c6Var = c6VarArr2[i11];
                if (c6Var != null) {
                    hVar.e(4, c6Var);
                }
                i11++;
            }
        }
        a6[] a6VarArr = this.f9188g;
        if (a6VarArr != null && a6VarArr.length > 0) {
            int i12 = 0;
            while (true) {
                a6[] a6VarArr2 = this.f9188g;
                if (i12 >= a6VarArr2.length) {
                    break;
                }
                a6 a6Var = a6VarArr2[i12];
                if (a6Var != null) {
                    hVar.e(5, a6Var);
                }
                i12++;
            }
        }
        u5[] u5VarArr = this.f9189h;
        if (u5VarArr != null && u5VarArr.length > 0) {
            while (true) {
                u5[] u5VarArr2 = this.f9189h;
                if (i10 >= u5VarArr2.length) {
                    break;
                }
                u5 u5Var = u5VarArr2[i10];
                if (u5Var != null) {
                    hVar.e(6, u5Var);
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
                this.f9184c = Long.valueOf(gVar.q());
            } else if (n10 == 18) {
                this.f9185d = gVar.b();
            } else if (n10 == 24) {
                this.f9186e = Integer.valueOf(gVar.p());
            } else if (n10 == 34) {
                int a10 = q.a(gVar, 34);
                c6[] c6VarArr = this.f9187f;
                int length = c6VarArr == null ? 0 : c6VarArr.length;
                int i10 = a10 + length;
                c6[] c6VarArr2 = new c6[i10];
                if (length != 0) {
                    System.arraycopy(c6VarArr, 0, c6VarArr2, 0, length);
                }
                while (length < i10 - 1) {
                    c6VarArr2[length] = new c6();
                    gVar.d(c6VarArr2[length]);
                    gVar.n();
                    length++;
                }
                c6VarArr2[length] = new c6();
                gVar.d(c6VarArr2[length]);
                this.f9187f = c6VarArr2;
            } else if (n10 == 42) {
                int a11 = q.a(gVar, 42);
                a6[] a6VarArr = this.f9188g;
                int length2 = a6VarArr == null ? 0 : a6VarArr.length;
                int i11 = a11 + length2;
                a6[] a6VarArr2 = new a6[i11];
                if (length2 != 0) {
                    System.arraycopy(a6VarArr, 0, a6VarArr2, 0, length2);
                }
                while (length2 < i11 - 1) {
                    a6VarArr2[length2] = new a6();
                    gVar.d(a6VarArr2[length2]);
                    gVar.n();
                    length2++;
                }
                a6VarArr2[length2] = new a6();
                gVar.d(a6VarArr2[length2]);
                this.f9188g = a6VarArr2;
            } else if (n10 == 50) {
                int a12 = q.a(gVar, 50);
                u5[] u5VarArr = this.f9189h;
                int length3 = u5VarArr == null ? 0 : u5VarArr.length;
                int i12 = a12 + length3;
                u5[] u5VarArr2 = new u5[i12];
                if (length3 != 0) {
                    System.arraycopy(u5VarArr, 0, u5VarArr2, 0, length3);
                }
                while (length3 < i12 - 1) {
                    u5VarArr2[length3] = new u5();
                    gVar.d(u5VarArr2[length3]);
                    gVar.n();
                    length3++;
                }
                u5VarArr2[length3] = new u5();
                gVar.d(u5VarArr2[length3]);
                this.f9189h = u5VarArr2;
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b6)) {
            return false;
        }
        b6 b6Var = (b6) obj;
        Long l10 = this.f9184c;
        if (l10 == null) {
            if (b6Var.f9184c != null) {
                return false;
            }
        } else if (!l10.equals(b6Var.f9184c)) {
            return false;
        }
        String str = this.f9185d;
        if (str == null) {
            if (b6Var.f9185d != null) {
                return false;
            }
        } else if (!str.equals(b6Var.f9185d)) {
            return false;
        }
        Integer num = this.f9186e;
        if (num == null) {
            if (b6Var.f9186e != null) {
                return false;
            }
        } else if (!num.equals(b6Var.f9186e)) {
            return false;
        }
        if (!m.b(this.f9187f, b6Var.f9187f) || !m.b(this.f9188g, b6Var.f9188g) || !m.b(this.f9189h, b6Var.f9189h)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(b6Var.f9353b);
        }
        k kVar2 = b6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (b6.class.getName().hashCode() + 527) * 31;
        Long l10 = this.f9184c;
        int i10 = 0;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.f9185d;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.f9186e;
        int hashCode4 = (((((((hashCode3 + (num == null ? 0 : num.hashCode())) * 31) + m.d(this.f9187f)) * 31) + m.d(this.f9188g)) * 31) + m.d(this.f9189h)) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode4 + i10;
    }
}
