package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
final class v7 extends y7 {
    private final int zzbra;
    private final int zzbrb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v7(byte[] bArr, int i10, int i11) {
        super(bArr);
        zzyw.b(i10, i10 + i11, bArr.length);
        this.zzbra = i10;
        this.zzbrb = i11;
    }

    @Override // com.google.android.gms.internal.measurement.y7
    protected final int g() {
        return this.zzbra;
    }

    @Override // com.google.android.gms.internal.measurement.y7, com.google.android.gms.internal.measurement.zzyw
    public final int size() {
        return this.zzbrb;
    }

    @Override // com.google.android.gms.internal.measurement.y7, com.google.android.gms.internal.measurement.zzyw
    public final byte zzae(int i10) {
        int size = size();
        if (((size - (i10 + 1)) | i10) >= 0) {
            return this.zzbrc[this.zzbra + i10];
        }
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append("Index < 0: ");
            sb2.append(i10);
            throw new ArrayIndexOutOfBoundsException(sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder(40);
        sb3.append("Index > length: ");
        sb3.append(i10);
        sb3.append(", ");
        sb3.append(size);
        throw new ArrayIndexOutOfBoundsException(sb3.toString());
    }
}
