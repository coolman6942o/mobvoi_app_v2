package com.google.zxing;
/* compiled from: LuminanceSource.java */
/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a  reason: collision with root package name */
    private final int f13404a;

    /* renamed from: b  reason: collision with root package name */
    private final int f13405b;

    /* JADX INFO: Access modifiers changed from: protected */
    public c(int i10, int i11) {
        this.f13404a = i10;
        this.f13405b = i11;
    }

    public final int a() {
        return this.f13405b;
    }

    public abstract byte[] b();

    public abstract byte[] c(int i10, byte[] bArr);

    public final int d() {
        return this.f13404a;
    }

    public boolean e() {
        return false;
    }

    public c f() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i10 = this.f13404a;
        byte[] bArr = new byte[i10];
        StringBuilder sb2 = new StringBuilder(this.f13405b * (i10 + 1));
        for (int i11 = 0; i11 < this.f13405b; i11++) {
            bArr = c(i11, bArr);
            for (int i12 = 0; i12 < this.f13404a; i12++) {
                int i13 = bArr[i12] & 255;
                sb2.append(i13 < 64 ? '#' : i13 < 128 ? '+' : i13 < 192 ? '.' : ' ');
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
