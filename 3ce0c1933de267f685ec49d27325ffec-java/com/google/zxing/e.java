package com.google.zxing;
/* compiled from: PlanarYUVLuminanceSource.java */
/* loaded from: classes.dex */
public final class e extends c {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f13437c;

    /* renamed from: d  reason: collision with root package name */
    private final int f13438d;

    /* renamed from: e  reason: collision with root package name */
    private final int f13439e;

    /* renamed from: f  reason: collision with root package name */
    private final int f13440f;

    /* renamed from: g  reason: collision with root package name */
    private final int f13441g;

    public e(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        super(i14, i15);
        if (i12 + i14 > i10 || i13 + i15 > i11) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f13437c = bArr;
        this.f13438d = i10;
        this.f13439e = i11;
        this.f13440f = i12;
        this.f13441g = i13;
        if (z10) {
            g(i14, i15);
        }
    }

    private void g(int i10, int i11) {
        byte[] bArr = this.f13437c;
        int i12 = (this.f13441g * this.f13438d) + this.f13440f;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = (i10 / 2) + i12;
            int i15 = (i12 + i10) - 1;
            int i16 = i12;
            while (i16 < i14) {
                byte b10 = bArr[i16];
                bArr[i16] = bArr[i15];
                bArr[i15] = b10;
                i16++;
                i15--;
            }
            i13++;
            i12 += this.f13438d;
        }
    }

    @Override // com.google.zxing.c
    public byte[] b() {
        int d10 = d();
        int a10 = a();
        int i10 = this.f13438d;
        if (d10 == i10 && a10 == this.f13439e) {
            return this.f13437c;
        }
        int i11 = d10 * a10;
        byte[] bArr = new byte[i11];
        int i12 = (this.f13441g * i10) + this.f13440f;
        if (d10 == i10) {
            System.arraycopy(this.f13437c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < a10; i13++) {
            System.arraycopy(this.f13437c, i12, bArr, i13 * d10, d10);
            i12 += this.f13438d;
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
        System.arraycopy(this.f13437c, ((i10 + this.f13441g) * this.f13438d) + this.f13440f, bArr, 0, d10);
        return bArr;
    }
}
