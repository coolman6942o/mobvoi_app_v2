package com.huawei.hms.scankit.aiscan.common;
/* compiled from: LuminanceSource.java */
/* loaded from: classes2.dex */
public abstract class m {

    /* renamed from: a  reason: collision with root package name */
    private final int f14253a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14254b;

    /* JADX INFO: Access modifiers changed from: protected */
    public m(int i10, int i11) {
        this.f14253a = i10;
        this.f14254b = i11;
    }

    public final int a() {
        return this.f14254b;
    }

    public abstract m a(int i10, int i11, int i12, int i13);

    public abstract byte[] a(int i10, byte[] bArr);

    public abstract m b(int i10, int i11, int i12, int i13);

    public abstract byte[] b();

    public final int c() {
        return this.f14253a;
    }

    public final String toString() {
        int i10 = this.f14253a;
        byte[] bArr = new byte[i10];
        StringBuilder sb2 = new StringBuilder(this.f14254b * (i10 + 1));
        for (int i11 = 0; i11 < this.f14254b; i11++) {
            bArr = a(i11, bArr);
            for (int i12 = 0; i12 < this.f14253a; i12++) {
                int i13 = bArr[i12] & 255;
                sb2.append(i13 < 64 ? '#' : i13 < 128 ? '+' : i13 < 192 ? '.' : ' ');
            }
            sb2.append('\n');
        }
        return sb2.toString();
    }
}
