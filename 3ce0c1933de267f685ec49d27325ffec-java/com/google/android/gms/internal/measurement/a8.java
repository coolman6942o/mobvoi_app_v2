package com.google.android.gms.internal.measurement;
/* loaded from: classes.dex */
public abstract class a8 {
    private a8() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a8 a(byte[] bArr, int i10, int i11, boolean z10) {
        c8 c8Var = new c8(bArr, i10, i11);
        try {
            c8Var.c(i11);
            return c8Var;
        } catch (zzzt e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public abstract int b();
}
