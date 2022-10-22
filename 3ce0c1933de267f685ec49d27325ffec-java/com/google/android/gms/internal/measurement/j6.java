package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class j6 extends i<j6> {

    /* renamed from: i  reason: collision with root package name */
    private static volatile j6[] f9411i;

    /* renamed from: c  reason: collision with root package name */
    public Long f9412c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f9413d = null;

    /* renamed from: e  reason: collision with root package name */
    public String f9414e = null;

    /* renamed from: f  reason: collision with root package name */
    public Long f9415f = null;

    /* renamed from: g  reason: collision with root package name */
    private Float f9416g = null;

    /* renamed from: h  reason: collision with root package name */
    public Double f9417h = null;

    public j6() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static j6[] h() {
        if (f9411i == null) {
            synchronized (m.f9497b) {
                if (f9411i == null) {
                    f9411i = new j6[0];
                }
            }
        }
        return f9411i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        Long l10 = this.f9412c;
        if (l10 != null) {
            a10 += h.t(1, l10.longValue());
        }
        String str = this.f9413d;
        if (str != null) {
            a10 += h.u(2, str);
        }
        String str2 = this.f9414e;
        if (str2 != null) {
            a10 += h.u(3, str2);
        }
        Long l11 = this.f9415f;
        if (l11 != null) {
            a10 += h.t(4, l11.longValue());
        }
        Float f10 = this.f9416g;
        if (f10 != null) {
            f10.floatValue();
            a10 += h.l(5) + 4;
        }
        Double d10 = this.f9417h;
        if (d10 == null) {
            return a10;
        }
        d10.doubleValue();
        return a10 + h.l(6) + 8;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        Long l10 = this.f9412c;
        if (l10 != null) {
            hVar.q(1, l10.longValue());
        }
        String str = this.f9413d;
        if (str != null) {
            hVar.r(2, str);
        }
        String str2 = this.f9414e;
        if (str2 != null) {
            hVar.r(3, str2);
        }
        Long l11 = this.f9415f;
        if (l11 != null) {
            hVar.q(4, l11.longValue());
        }
        Float f10 = this.f9416g;
        if (f10 != null) {
            hVar.c(5, f10.floatValue());
        }
        Double d10 = this.f9417h;
        if (d10 != null) {
            hVar.b(6, d10.doubleValue());
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
                this.f9412c = Long.valueOf(gVar.q());
            } else if (n10 == 18) {
                this.f9413d = gVar.b();
            } else if (n10 == 26) {
                this.f9414e = gVar.b();
            } else if (n10 == 32) {
                this.f9415f = Long.valueOf(gVar.q());
            } else if (n10 == 45) {
                this.f9416g = Float.valueOf(Float.intBitsToFloat(gVar.r()));
            } else if (n10 == 49) {
                this.f9417h = Double.valueOf(Double.longBitsToDouble(gVar.s()));
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j6)) {
            return false;
        }
        j6 j6Var = (j6) obj;
        Long l10 = this.f9412c;
        if (l10 == null) {
            if (j6Var.f9412c != null) {
                return false;
            }
        } else if (!l10.equals(j6Var.f9412c)) {
            return false;
        }
        String str = this.f9413d;
        if (str == null) {
            if (j6Var.f9413d != null) {
                return false;
            }
        } else if (!str.equals(j6Var.f9413d)) {
            return false;
        }
        String str2 = this.f9414e;
        if (str2 == null) {
            if (j6Var.f9414e != null) {
                return false;
            }
        } else if (!str2.equals(j6Var.f9414e)) {
            return false;
        }
        Long l11 = this.f9415f;
        if (l11 == null) {
            if (j6Var.f9415f != null) {
                return false;
            }
        } else if (!l11.equals(j6Var.f9415f)) {
            return false;
        }
        Float f10 = this.f9416g;
        if (f10 == null) {
            if (j6Var.f9416g != null) {
                return false;
            }
        } else if (!f10.equals(j6Var.f9416g)) {
            return false;
        }
        Double d10 = this.f9417h;
        if (d10 == null) {
            if (j6Var.f9417h != null) {
                return false;
            }
        } else if (!d10.equals(j6Var.f9417h)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(j6Var.f9353b);
        }
        k kVar2 = j6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (j6.class.getName().hashCode() + 527) * 31;
        Long l10 = this.f9412c;
        int i10 = 0;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        String str = this.f9413d;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f9414e;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l11 = this.f9415f;
        int hashCode5 = (hashCode4 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Float f10 = this.f9416g;
        int hashCode6 = (hashCode5 + (f10 == null ? 0 : f10.hashCode())) * 31;
        Double d10 = this.f9417h;
        int hashCode7 = (hashCode6 + (d10 == null ? 0 : d10.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode7 + i10;
    }
}
