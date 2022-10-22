package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class g6 extends i<g6> {

    /* renamed from: c  reason: collision with root package name */
    public h6[] f9304c = h6.h();

    public g6() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        h6[] h6VarArr = this.f9304c;
        if (h6VarArr != null && h6VarArr.length > 0) {
            int i10 = 0;
            while (true) {
                h6[] h6VarArr2 = this.f9304c;
                if (i10 >= h6VarArr2.length) {
                    break;
                }
                h6 h6Var = h6VarArr2[i10];
                if (h6Var != null) {
                    a10 += h.o(1, h6Var);
                }
                i10++;
            }
        }
        return a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        h6[] h6VarArr = this.f9304c;
        if (h6VarArr != null && h6VarArr.length > 0) {
            int i10 = 0;
            while (true) {
                h6[] h6VarArr2 = this.f9304c;
                if (i10 >= h6VarArr2.length) {
                    break;
                }
                h6 h6Var = h6VarArr2[i10];
                if (h6Var != null) {
                    hVar.e(1, h6Var);
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
            if (n10 == 10) {
                int a10 = q.a(gVar, 10);
                h6[] h6VarArr = this.f9304c;
                int length = h6VarArr == null ? 0 : h6VarArr.length;
                int i10 = a10 + length;
                h6[] h6VarArr2 = new h6[i10];
                if (length != 0) {
                    System.arraycopy(h6VarArr, 0, h6VarArr2, 0, length);
                }
                while (length < i10 - 1) {
                    h6VarArr2[length] = new h6();
                    gVar.d(h6VarArr2[length]);
                    gVar.n();
                    length++;
                }
                h6VarArr2[length] = new h6();
                gVar.d(h6VarArr2[length]);
                this.f9304c = h6VarArr2;
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g6)) {
            return false;
        }
        g6 g6Var = (g6) obj;
        if (!m.b(this.f9304c, g6Var.f9304c)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(g6Var.f9353b);
        }
        k kVar2 = g6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (((g6.class.getName().hashCode() + 527) * 31) + m.d(this.f9304c)) * 31;
        k kVar = this.f9353b;
        return hashCode + ((kVar == null || kVar.b()) ? 0 : this.f9353b.hashCode());
    }
}
