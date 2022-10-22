package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
class y7 extends x7 {
    protected final byte[] zzbrc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y7(byte[] bArr) {
        this.zzbrc = bArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzyw
    protected final int a(int i10, int i11, int i12) {
        return d8.a(i10, this.zzbrc, g(), i12);
    }

    @Override // com.google.android.gms.internal.measurement.x7
    final boolean d(zzyw zzywVar, int i10, int i11) {
        if (i11 > zzywVar.size()) {
            int size = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i11);
            sb2.append(size);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i11 > zzywVar.size()) {
            int size2 = zzywVar.size();
            StringBuilder sb3 = new StringBuilder(59);
            sb3.append("Ran off end of other: 0, ");
            sb3.append(i11);
            sb3.append(", ");
            sb3.append(size2);
            throw new IllegalArgumentException(sb3.toString());
        } else if (!(zzywVar instanceof y7)) {
            return zzywVar.zzb(0, i11).equals(zzb(0, i11));
        } else {
            y7 y7Var = (y7) zzywVar;
            byte[] bArr = this.zzbrc;
            byte[] bArr2 = y7Var.zzbrc;
            int g10 = g() + i11;
            int g11 = g();
            int g12 = y7Var.g();
            while (g11 < g10) {
                if (bArr[g11] != bArr2[g12]) {
                    return false;
                }
                g11++;
                g12++;
            }
            return true;
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzyw
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzyw) || size() != ((zzyw) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof y7)) {
            return obj.equals(this);
        }
        y7 y7Var = (y7) obj;
        int c10 = c();
        int c11 = y7Var.c();
        if (c10 == 0 || c11 == 0 || c10 == c11) {
            return d(y7Var, 0, size());
        }
        return false;
    }

    protected int g() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzyw
    public int size() {
        return this.zzbrc.length;
    }

    @Override // com.google.android.gms.internal.measurement.zzyw
    public byte zzae(int i10) {
        return this.zzbrc[i10];
    }

    @Override // com.google.android.gms.internal.measurement.zzyw
    public final zzyw zzb(int i10, int i11) {
        int b10 = zzyw.b(0, i11, size());
        return b10 == 0 ? zzyw.zzbqx : new v7(this.zzbrc, g(), b10);
    }
}
