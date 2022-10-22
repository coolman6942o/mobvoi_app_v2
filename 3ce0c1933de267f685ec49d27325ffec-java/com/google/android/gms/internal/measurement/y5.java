package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class y5 extends i<y5> {

    /* renamed from: f  reason: collision with root package name */
    private static volatile y5[] f9820f;

    /* renamed from: c  reason: collision with root package name */
    public Integer f9821c = null;

    /* renamed from: d  reason: collision with root package name */
    public String f9822d = null;

    /* renamed from: e  reason: collision with root package name */
    public w5 f9823e = null;

    public y5() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static y5[] h() {
        if (f9820f == null) {
            synchronized (m.f9497b) {
                if (f9820f == null) {
                    f9820f = new y5[0];
                }
            }
        }
        return f9820f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        Integer num = this.f9821c;
        if (num != null) {
            a10 += h.w(1, num.intValue());
        }
        String str = this.f9822d;
        if (str != null) {
            a10 += h.u(2, str);
        }
        w5 w5Var = this.f9823e;
        return w5Var != null ? a10 + h.o(3, w5Var) : a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        Integer num = this.f9821c;
        if (num != null) {
            hVar.v(1, num.intValue());
        }
        String str = this.f9822d;
        if (str != null) {
            hVar.r(2, str);
        }
        w5 w5Var = this.f9823e;
        if (w5Var != null) {
            hVar.e(3, w5Var);
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
                this.f9821c = Integer.valueOf(gVar.p());
            } else if (n10 == 18) {
                this.f9822d = gVar.b();
            } else if (n10 == 26) {
                if (this.f9823e == null) {
                    this.f9823e = new w5();
                }
                gVar.d(this.f9823e);
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y5)) {
            return false;
        }
        y5 y5Var = (y5) obj;
        Integer num = this.f9821c;
        if (num == null) {
            if (y5Var.f9821c != null) {
                return false;
            }
        } else if (!num.equals(y5Var.f9821c)) {
            return false;
        }
        String str = this.f9822d;
        if (str == null) {
            if (y5Var.f9822d != null) {
                return false;
            }
        } else if (!str.equals(y5Var.f9822d)) {
            return false;
        }
        w5 w5Var = this.f9823e;
        if (w5Var == null) {
            if (y5Var.f9823e != null) {
                return false;
            }
        } else if (!w5Var.equals(y5Var.f9823e)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(y5Var.f9353b);
        }
        k kVar2 = y5Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (y5.class.getName().hashCode() + 527) * 31;
        Integer num = this.f9821c;
        int i10 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.f9822d;
        int hashCode3 = hashCode2 + (str == null ? 0 : str.hashCode());
        w5 w5Var = this.f9823e;
        int hashCode4 = ((hashCode3 * 31) + (w5Var == null ? 0 : w5Var.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode4 + i10;
    }
}
