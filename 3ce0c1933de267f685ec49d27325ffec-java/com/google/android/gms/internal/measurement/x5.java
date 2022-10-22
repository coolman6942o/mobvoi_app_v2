package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class x5 extends i<x5> {

    /* renamed from: c  reason: collision with root package name */
    public Integer f9801c = null;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f9802d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f9803e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f9804f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f9805g = null;

    public x5() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public final x5 c(g gVar) throws IOException {
        while (true) {
            int n10 = gVar.n();
            if (n10 == 0) {
                return this;
            }
            if (n10 == 8) {
                int a10 = gVar.a();
                try {
                    int p10 = gVar.p();
                    if (p10 < 0 || p10 > 4) {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append(p10);
                        sb2.append(" is not a valid enum ComparisonType");
                        throw new IllegalArgumentException(sb2.toString());
                        break;
                    }
                    this.f9801c = Integer.valueOf(p10);
                } catch (IllegalArgumentException unused) {
                    gVar.i(a10);
                    g(gVar, n10);
                }
            } else if (n10 == 16) {
                this.f9802d = Boolean.valueOf(gVar.o());
            } else if (n10 == 26) {
                this.f9803e = gVar.b();
            } else if (n10 == 34) {
                this.f9804f = gVar.b();
            } else if (n10 == 42) {
                this.f9805g = gVar.b();
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        Integer num = this.f9801c;
        if (num != null) {
            a10 += h.w(1, num.intValue());
        }
        Boolean bool = this.f9802d;
        if (bool != null) {
            bool.booleanValue();
            a10 += h.l(2) + 1;
        }
        String str = this.f9803e;
        if (str != null) {
            a10 += h.u(3, str);
        }
        String str2 = this.f9804f;
        if (str2 != null) {
            a10 += h.u(4, str2);
        }
        String str3 = this.f9805g;
        return str3 != null ? a10 + h.u(5, str3) : a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        Integer num = this.f9801c;
        if (num != null) {
            hVar.v(1, num.intValue());
        }
        Boolean bool = this.f9802d;
        if (bool != null) {
            hVar.f(2, bool.booleanValue());
        }
        String str = this.f9803e;
        if (str != null) {
            hVar.r(3, str);
        }
        String str2 = this.f9804f;
        if (str2 != null) {
            hVar.r(4, str2);
        }
        String str3 = this.f9805g;
        if (str3 != null) {
            hVar.r(5, str3);
        }
        super.b(hVar);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x5)) {
            return false;
        }
        x5 x5Var = (x5) obj;
        Integer num = this.f9801c;
        if (num == null) {
            if (x5Var.f9801c != null) {
                return false;
            }
        } else if (!num.equals(x5Var.f9801c)) {
            return false;
        }
        Boolean bool = this.f9802d;
        if (bool == null) {
            if (x5Var.f9802d != null) {
                return false;
            }
        } else if (!bool.equals(x5Var.f9802d)) {
            return false;
        }
        String str = this.f9803e;
        if (str == null) {
            if (x5Var.f9803e != null) {
                return false;
            }
        } else if (!str.equals(x5Var.f9803e)) {
            return false;
        }
        String str2 = this.f9804f;
        if (str2 == null) {
            if (x5Var.f9804f != null) {
                return false;
            }
        } else if (!str2.equals(x5Var.f9804f)) {
            return false;
        }
        String str3 = this.f9805g;
        if (str3 == null) {
            if (x5Var.f9805g != null) {
                return false;
            }
        } else if (!str3.equals(x5Var.f9805g)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(x5Var.f9353b);
        }
        k kVar2 = x5Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (x5.class.getName().hashCode() + 527) * 31;
        Integer num = this.f9801c;
        int i10 = 0;
        int intValue = (hashCode + (num == null ? 0 : num.intValue())) * 31;
        Boolean bool = this.f9802d;
        int hashCode2 = (intValue + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.f9803e;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f9804f;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f9805g;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode5 + i10;
    }
}
