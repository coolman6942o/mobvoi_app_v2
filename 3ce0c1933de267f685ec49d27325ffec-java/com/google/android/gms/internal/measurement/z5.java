package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class z5 extends i<z5> {

    /* renamed from: c  reason: collision with root package name */
    public Integer f9855c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f9856d = null;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f9857e = null;

    /* renamed from: f  reason: collision with root package name */
    public String[] f9858f = q.f9599b;

    public z5() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public final z5 c(g gVar) throws IOException {
        while (true) {
            int n10 = gVar.n();
            if (n10 == 0) {
                return this;
            }
            if (n10 == 8) {
                int a10 = gVar.a();
                try {
                    int p10 = gVar.p();
                    if (p10 < 0 || p10 > 6) {
                        StringBuilder sb2 = new StringBuilder(41);
                        sb2.append(p10);
                        sb2.append(" is not a valid enum MatchType");
                        throw new IllegalArgumentException(sb2.toString());
                        break;
                    }
                    this.f9855c = Integer.valueOf(p10);
                } catch (IllegalArgumentException unused) {
                    gVar.i(a10);
                    g(gVar, n10);
                }
            } else if (n10 == 18) {
                this.f9856d = gVar.b();
            } else if (n10 == 24) {
                this.f9857e = Boolean.valueOf(gVar.o());
            } else if (n10 == 34) {
                int a11 = q.a(gVar, 34);
                String[] strArr = this.f9858f;
                int length = strArr == null ? 0 : strArr.length;
                int i10 = a11 + length;
                String[] strArr2 = new String[i10];
                if (length != 0) {
                    System.arraycopy(strArr, 0, strArr2, 0, length);
                }
                while (length < i10 - 1) {
                    strArr2[length] = gVar.b();
                    gVar.n();
                    length++;
                }
                strArr2[length] = gVar.b();
                this.f9858f = strArr2;
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        Integer num = this.f9855c;
        if (num != null) {
            a10 += h.w(1, num.intValue());
        }
        String str = this.f9856d;
        if (str != null) {
            a10 += h.u(2, str);
        }
        Boolean bool = this.f9857e;
        if (bool != null) {
            bool.booleanValue();
            a10 += h.l(3) + 1;
        }
        String[] strArr = this.f9858f;
        if (strArr == null || strArr.length <= 0) {
            return a10;
        }
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            String[] strArr2 = this.f9858f;
            if (i10 >= strArr2.length) {
                return a10 + i11 + (i12 * 1);
            }
            String str2 = strArr2[i10];
            if (str2 != null) {
                i12++;
                i11 += h.x(str2);
            }
            i10++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        Integer num = this.f9855c;
        if (num != null) {
            hVar.v(1, num.intValue());
        }
        String str = this.f9856d;
        if (str != null) {
            hVar.r(2, str);
        }
        Boolean bool = this.f9857e;
        if (bool != null) {
            hVar.f(3, bool.booleanValue());
        }
        String[] strArr = this.f9858f;
        if (strArr != null && strArr.length > 0) {
            int i10 = 0;
            while (true) {
                String[] strArr2 = this.f9858f;
                if (i10 >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i10];
                if (str2 != null) {
                    hVar.r(4, str2);
                }
                i10++;
            }
        }
        super.b(hVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z5)) {
            return false;
        }
        z5 z5Var = (z5) obj;
        Integer num = this.f9855c;
        if (num == null) {
            if (z5Var.f9855c != null) {
                return false;
            }
        } else if (!num.equals(z5Var.f9855c)) {
            return false;
        }
        String str = this.f9856d;
        if (str == null) {
            if (z5Var.f9856d != null) {
                return false;
            }
        } else if (!str.equals(z5Var.f9856d)) {
            return false;
        }
        Boolean bool = this.f9857e;
        if (bool == null) {
            if (z5Var.f9857e != null) {
                return false;
            }
        } else if (!bool.equals(z5Var.f9857e)) {
            return false;
        }
        if (!m.b(this.f9858f, z5Var.f9858f)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(z5Var.f9353b);
        }
        k kVar2 = z5Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (z5.class.getName().hashCode() + 527) * 31;
        Integer num = this.f9855c;
        int i10 = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        String str = this.f9856d;
        int hashCode2 = (intValue + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.f9857e;
        int hashCode3 = (((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + m.d(this.f9858f)) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode3 + i10;
    }
}
