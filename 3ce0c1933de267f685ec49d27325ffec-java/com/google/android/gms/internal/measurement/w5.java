package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class w5 extends i<w5> {

    /* renamed from: g  reason: collision with root package name */
    private static volatile w5[] f9779g;

    /* renamed from: c  reason: collision with root package name */
    public z5 f9780c = null;

    /* renamed from: d  reason: collision with root package name */
    public x5 f9781d = null;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f9782e = null;

    /* renamed from: f  reason: collision with root package name */
    public String f9783f = null;

    public w5() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static w5[] h() {
        if (f9779g == null) {
            synchronized (m.f9497b) {
                if (f9779g == null) {
                    f9779g = new w5[0];
                }
            }
        }
        return f9779g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        z5 z5Var = this.f9780c;
        if (z5Var != null) {
            a10 += h.o(1, z5Var);
        }
        x5 x5Var = this.f9781d;
        if (x5Var != null) {
            a10 += h.o(2, x5Var);
        }
        Boolean bool = this.f9782e;
        if (bool != null) {
            bool.booleanValue();
            a10 += h.l(3) + 1;
        }
        String str = this.f9783f;
        return str != null ? a10 + h.u(4, str) : a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        z5 z5Var = this.f9780c;
        if (z5Var != null) {
            hVar.e(1, z5Var);
        }
        x5 x5Var = this.f9781d;
        if (x5Var != null) {
            hVar.e(2, x5Var);
        }
        Boolean bool = this.f9782e;
        if (bool != null) {
            hVar.f(3, bool.booleanValue());
        }
        String str = this.f9783f;
        if (str != null) {
            hVar.r(4, str);
        }
        super.b(hVar);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final /* synthetic */ n c(g gVar) throws IOException {
        n nVar;
        while (true) {
            int n10 = gVar.n();
            if (n10 == 0) {
                return this;
            }
            if (n10 == 10) {
                if (this.f9780c == null) {
                    this.f9780c = new z5();
                }
                nVar = this.f9780c;
            } else if (n10 == 18) {
                if (this.f9781d == null) {
                    this.f9781d = new x5();
                }
                nVar = this.f9781d;
            } else if (n10 == 24) {
                this.f9782e = Boolean.valueOf(gVar.o());
            } else if (n10 == 34) {
                this.f9783f = gVar.b();
            } else if (!super.g(gVar, n10)) {
                return this;
            }
            gVar.d(nVar);
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w5)) {
            return false;
        }
        w5 w5Var = (w5) obj;
        z5 z5Var = this.f9780c;
        if (z5Var == null) {
            if (w5Var.f9780c != null) {
                return false;
            }
        } else if (!z5Var.equals(w5Var.f9780c)) {
            return false;
        }
        x5 x5Var = this.f9781d;
        if (x5Var == null) {
            if (w5Var.f9781d != null) {
                return false;
            }
        } else if (!x5Var.equals(w5Var.f9781d)) {
            return false;
        }
        Boolean bool = this.f9782e;
        if (bool == null) {
            if (w5Var.f9782e != null) {
                return false;
            }
        } else if (!bool.equals(w5Var.f9782e)) {
            return false;
        }
        String str = this.f9783f;
        if (str == null) {
            if (w5Var.f9783f != null) {
                return false;
            }
        } else if (!str.equals(w5Var.f9783f)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(w5Var.f9353b);
        }
        k kVar2 = w5Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        z5 z5Var = this.f9780c;
        int i10 = 0;
        int hashCode = ((w5.class.getName().hashCode() + 527) * 31) + (z5Var == null ? 0 : z5Var.hashCode());
        x5 x5Var = this.f9781d;
        int hashCode2 = ((hashCode * 31) + (x5Var == null ? 0 : x5Var.hashCode())) * 31;
        Boolean bool = this.f9782e;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str = this.f9783f;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode4 + i10;
    }
}
