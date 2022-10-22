package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class f6 extends i<f6> {

    /* renamed from: h  reason: collision with root package name */
    private static volatile f6[] f9273h;

    /* renamed from: c  reason: collision with root package name */
    public String f9274c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f9275d = null;

    /* renamed from: e  reason: collision with root package name */
    public Long f9276e = null;

    /* renamed from: f  reason: collision with root package name */
    private Float f9277f = null;

    /* renamed from: g  reason: collision with root package name */
    public Double f9278g = null;

    public f6() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static f6[] h() {
        if (f9273h == null) {
            synchronized (m.f9497b) {
                if (f9273h == null) {
                    f9273h = new f6[0];
                }
            }
        }
        return f9273h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        String str = this.f9274c;
        if (str != null) {
            a10 += h.u(1, str);
        }
        String str2 = this.f9275d;
        if (str2 != null) {
            a10 += h.u(2, str2);
        }
        Long l10 = this.f9276e;
        if (l10 != null) {
            a10 += h.t(3, l10.longValue());
        }
        Float f10 = this.f9277f;
        if (f10 != null) {
            f10.floatValue();
            a10 += h.l(4) + 4;
        }
        Double d10 = this.f9278g;
        if (d10 == null) {
            return a10;
        }
        d10.doubleValue();
        return a10 + h.l(5) + 8;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        String str = this.f9274c;
        if (str != null) {
            hVar.r(1, str);
        }
        String str2 = this.f9275d;
        if (str2 != null) {
            hVar.r(2, str2);
        }
        Long l10 = this.f9276e;
        if (l10 != null) {
            hVar.q(3, l10.longValue());
        }
        Float f10 = this.f9277f;
        if (f10 != null) {
            hVar.c(4, f10.floatValue());
        }
        Double d10 = this.f9278g;
        if (d10 != null) {
            hVar.b(5, d10.doubleValue());
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
                this.f9274c = gVar.b();
            } else if (n10 == 18) {
                this.f9275d = gVar.b();
            } else if (n10 == 24) {
                this.f9276e = Long.valueOf(gVar.q());
            } else if (n10 == 37) {
                this.f9277f = Float.valueOf(Float.intBitsToFloat(gVar.r()));
            } else if (n10 == 41) {
                this.f9278g = Double.valueOf(Double.longBitsToDouble(gVar.s()));
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f6)) {
            return false;
        }
        f6 f6Var = (f6) obj;
        String str = this.f9274c;
        if (str == null) {
            if (f6Var.f9274c != null) {
                return false;
            }
        } else if (!str.equals(f6Var.f9274c)) {
            return false;
        }
        String str2 = this.f9275d;
        if (str2 == null) {
            if (f6Var.f9275d != null) {
                return false;
            }
        } else if (!str2.equals(f6Var.f9275d)) {
            return false;
        }
        Long l10 = this.f9276e;
        if (l10 == null) {
            if (f6Var.f9276e != null) {
                return false;
            }
        } else if (!l10.equals(f6Var.f9276e)) {
            return false;
        }
        Float f10 = this.f9277f;
        if (f10 == null) {
            if (f6Var.f9277f != null) {
                return false;
            }
        } else if (!f10.equals(f6Var.f9277f)) {
            return false;
        }
        Double d10 = this.f9278g;
        if (d10 == null) {
            if (f6Var.f9278g != null) {
                return false;
            }
        } else if (!d10.equals(f6Var.f9278g)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(f6Var.f9353b);
        }
        k kVar2 = f6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (f6.class.getName().hashCode() + 527) * 31;
        String str = this.f9274c;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f9275d;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l10 = this.f9276e;
        int hashCode4 = (hashCode3 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Float f10 = this.f9277f;
        int hashCode5 = (hashCode4 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Double d10 = this.f9278g;
        int hashCode6 = (hashCode5 + (d10 == null ? 0 : d10.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode6 + i10;
    }
}
