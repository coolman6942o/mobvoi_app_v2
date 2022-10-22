package com.google.zxing;
/* compiled from: RGBLuminanceSource.java */
/* loaded from: classes.dex */
public final class f extends c {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f13442c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13443d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13444e;

    /* renamed from: f  reason: collision with root package name */
    private final int f13445f = 0;

    /* renamed from: g  reason: collision with root package name */
    private final int f13446g = 0;

    public f(int i10, int i11, int[] iArr) {
        super(i10, i11);
        this.f13443d = i10;
        this.f13444e = i11;
        int i12 = i10 * i11;
        this.f13442c = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr[i13];
            this.f13442c[i13] = (byte) (((((i14 >> 16) & 255) + ((i14 >> 7) & 510)) + (i14 & 255)) / 4);
        }
    }

    @Override // com.google.zxing.c
    public byte[] b() {
        int d10 = d();
        int a10 = a();
        int i10 = this.f13443d;
        if (d10 == i10 && a10 == this.f13444e) {
            return this.f13442c;
        }
        int i11 = d10 * a10;
        byte[] bArr = new byte[i11];
        int i12 = (this.f13446g * i10) + this.f13445f;
        if (d10 == i10) {
            System.arraycopy(this.f13442c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < a10; i13++) {
            System.arraycopy(this.f13442c, i12, bArr, i13 * d10, d10);
            i12 += this.f13443d;
        }
        return bArr;
    }

    @Override // com.google.zxing.c
    public byte[] c(int i10, byte[] bArr) {
        if (i10 < 0 || i10 >= a()) {
            throw new IllegalArgumentException("Requested row is outside the image: " + i10);
        }
        int d10 = d();
        if (bArr == null || bArr.length < d10) {
            bArr = new byte[d10];
        }
        System.arraycopy(this.f13442c, ((i10 + this.f13446g) * this.f13443d) + this.f13445f, bArr, 0, d10);
        return bArr;
    }
}
