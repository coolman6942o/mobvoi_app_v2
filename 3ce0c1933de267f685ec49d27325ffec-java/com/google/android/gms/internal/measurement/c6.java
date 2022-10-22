package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class c6 extends i<c6> {

    /* renamed from: e  reason: collision with root package name */
    private static volatile c6[] f9204e;

    /* renamed from: c  reason: collision with root package name */
    public String f9205c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f9206d = null;

    public c6() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static c6[] h() {
        if (f9204e == null) {
            synchronized (m.f9497b) {
                if (f9204e == null) {
                    f9204e = new c6[0];
                }
            }
        }
        return f9204e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        String str = this.f9205c;
        if (str != null) {
            a10 += h.u(1, str);
        }
        String str2 = this.f9206d;
        return str2 != null ? a10 + h.u(2, str2) : a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        String str = this.f9205c;
        if (str != null) {
            hVar.r(1, str);
        }
        String str2 = this.f9206d;
        if (str2 != null) {
            hVar.r(2, str2);
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
                this.f9205c = gVar.b();
            } else if (n10 == 18) {
                this.f9206d = gVar.b();
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c6)) {
            return false;
        }
        c6 c6Var = (c6) obj;
        String str = this.f9205c;
        if (str == null) {
            if (c6Var.f9205c != null) {
                return false;
            }
        } else if (!str.equals(c6Var.f9205c)) {
            return false;
        }
        String str2 = this.f9206d;
        if (str2 == null) {
            if (c6Var.f9206d != null) {
                return false;
            }
        } else if (!str2.equals(c6Var.f9206d)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(c6Var.f9353b);
        }
        k kVar2 = c6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (c6.class.getName().hashCode() + 527) * 31;
        String str = this.f9205c;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f9206d;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode3 + i10;
    }
}
