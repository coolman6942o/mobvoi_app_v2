package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class a6 extends i<a6> {

    /* renamed from: g  reason: collision with root package name */
    private static volatile a6[] f9167g;

    /* renamed from: c  reason: collision with root package name */
    public String f9168c = null;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f9169d = null;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f9170e = null;

    /* renamed from: f  reason: collision with root package name */
    public Integer f9171f = null;

    public a6() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static a6[] h() {
        if (f9167g == null) {
            synchronized (m.f9497b) {
                if (f9167g == null) {
                    f9167g = new a6[0];
                }
            }
        }
        return f9167g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        String str = this.f9168c;
        if (str != null) {
            a10 += h.u(1, str);
        }
        Boolean bool = this.f9169d;
        if (bool != null) {
            bool.booleanValue();
            a10 += h.l(2) + 1;
        }
        Boolean bool2 = this.f9170e;
        if (bool2 != null) {
            bool2.booleanValue();
            a10 += h.l(3) + 1;
        }
        Integer num = this.f9171f;
        return num != null ? a10 + h.w(4, num.intValue()) : a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        String str = this.f9168c;
        if (str != null) {
            hVar.r(1, str);
        }
        Boolean bool = this.f9169d;
        if (bool != null) {
            hVar.f(2, bool.booleanValue());
        }
        Boolean bool2 = this.f9170e;
        if (bool2 != null) {
            hVar.f(3, bool2.booleanValue());
        }
        Integer num = this.f9171f;
        if (num != null) {
            hVar.v(4, num.intValue());
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
            if (n10 == 10) {
                this.f9168c = gVar.b();
            } else if (n10 == 16) {
                this.f9169d = Boolean.valueOf(gVar.o());
            } else if (n10 == 24) {
                this.f9170e = Boolean.valueOf(gVar.o());
            } else if (n10 == 32) {
                this.f9171f = Integer.valueOf(gVar.p());
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a6)) {
            return false;
        }
        a6 a6Var = (a6) obj;
        String str = this.f9168c;
        if (str == null) {
            if (a6Var.f9168c != null) {
                return false;
            }
        } else if (!str.equals(a6Var.f9168c)) {
            return false;
        }
        Boolean bool = this.f9169d;
        if (bool == null) {
            if (a6Var.f9169d != null) {
                return false;
            }
        } else if (!bool.equals(a6Var.f9169d)) {
            return false;
        }
        Boolean bool2 = this.f9170e;
        if (bool2 == null) {
            if (a6Var.f9170e != null) {
                return false;
            }
        } else if (!bool2.equals(a6Var.f9170e)) {
            return false;
        }
        Integer num = this.f9171f;
        if (num == null) {
            if (a6Var.f9171f != null) {
                return false;
            }
        } else if (!num.equals(a6Var.f9171f)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(a6Var.f9353b);
        }
        k kVar2 = a6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (a6.class.getName().hashCode() + 527) * 31;
        String str = this.f9168c;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Boolean bool = this.f9169d;
        int hashCode3 = (hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.f9170e;
        int hashCode4 = (hashCode3 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Integer num = this.f9171f;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode5 + i10;
    }
}
