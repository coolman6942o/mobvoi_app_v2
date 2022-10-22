package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class d6 extends i<d6> {

    /* renamed from: g  reason: collision with root package name */
    private static volatile d6[] f9233g;

    /* renamed from: c  reason: collision with root package name */
    public Integer f9234c = null;

    /* renamed from: d  reason: collision with root package name */
    public i6 f9235d = null;

    /* renamed from: e  reason: collision with root package name */
    public i6 f9236e = null;

    /* renamed from: f  reason: collision with root package name */
    public Boolean f9237f = null;

    public d6() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static d6[] h() {
        if (f9233g == null) {
            synchronized (m.f9497b) {
                if (f9233g == null) {
                    f9233g = new d6[0];
                }
            }
        }
        return f9233g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        Integer num = this.f9234c;
        if (num != null) {
            a10 += h.w(1, num.intValue());
        }
        i6 i6Var = this.f9235d;
        if (i6Var != null) {
            a10 += h.o(2, i6Var);
        }
        i6 i6Var2 = this.f9236e;
        if (i6Var2 != null) {
            a10 += h.o(3, i6Var2);
        }
        Boolean bool = this.f9237f;
        if (bool == null) {
            return a10;
        }
        bool.booleanValue();
        return a10 + h.l(4) + 1;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        Integer num = this.f9234c;
        if (num != null) {
            hVar.v(1, num.intValue());
        }
        i6 i6Var = this.f9235d;
        if (i6Var != null) {
            hVar.e(2, i6Var);
        }
        i6 i6Var2 = this.f9236e;
        if (i6Var2 != null) {
            hVar.e(3, i6Var2);
        }
        Boolean bool = this.f9237f;
        if (bool != null) {
            hVar.f(4, bool.booleanValue());
        }
        super.b(hVar);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final /* synthetic */ n c(g gVar) throws IOException {
        i6 i6Var;
        while (true) {
            int n10 = gVar.n();
            if (n10 == 0) {
                return this;
            }
            if (n10 != 8) {
                if (n10 == 18) {
                    if (this.f9235d == null) {
                        this.f9235d = new i6();
                    }
                    i6Var = this.f9235d;
                } else if (n10 == 26) {
                    if (this.f9236e == null) {
                        this.f9236e = new i6();
                    }
                    i6Var = this.f9236e;
                } else if (n10 == 32) {
                    this.f9237f = Boolean.valueOf(gVar.o());
                } else if (!super.g(gVar, n10)) {
                    return this;
                }
                gVar.d(i6Var);
            } else {
                this.f9234c = Integer.valueOf(gVar.p());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d6)) {
            return false;
        }
        d6 d6Var = (d6) obj;
        Integer num = this.f9234c;
        if (num == null) {
            if (d6Var.f9234c != null) {
                return false;
            }
        } else if (!num.equals(d6Var.f9234c)) {
            return false;
        }
        i6 i6Var = this.f9235d;
        if (i6Var == null) {
            if (d6Var.f9235d != null) {
                return false;
            }
        } else if (!i6Var.equals(d6Var.f9235d)) {
            return false;
        }
        i6 i6Var2 = this.f9236e;
        if (i6Var2 == null) {
            if (d6Var.f9236e != null) {
                return false;
            }
        } else if (!i6Var2.equals(d6Var.f9236e)) {
            return false;
        }
        Boolean bool = this.f9237f;
        if (bool == null) {
            if (d6Var.f9237f != null) {
                return false;
            }
        } else if (!bool.equals(d6Var.f9237f)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(d6Var.f9353b);
        }
        k kVar2 = d6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (d6.class.getName().hashCode() + 527) * 31;
        Integer num = this.f9234c;
        int i10 = 0;
        int hashCode2 = hashCode + (num == null ? 0 : num.hashCode());
        i6 i6Var = this.f9235d;
        int hashCode3 = (hashCode2 * 31) + (i6Var == null ? 0 : i6Var.hashCode());
        i6 i6Var2 = this.f9236e;
        int hashCode4 = ((hashCode3 * 31) + (i6Var2 == null ? 0 : i6Var2.hashCode())) * 31;
        Boolean bool = this.f9237f;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode5 + i10;
    }
}
