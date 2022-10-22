package com.huawei.hms.scankit.aiscan.common;
/* compiled from: RGBLuminanceSource.java */
/* loaded from: classes2.dex */
public final class s extends m {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f14285c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14286d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14287e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14288f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14289g;

    public s(int i10, int i11, int[] iArr) {
        super(i10, i11);
        this.f14286d = i10;
        this.f14287e = i11;
        this.f14288f = 0;
        this.f14289g = 0;
        int i12 = i10 * i11;
        this.f14285c = new byte[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = iArr[i13];
            if (((-16777216) & i14) == 0) {
                i14 = -1;
            }
            this.f14285c[i13] = (byte) (((((((i14 >> 16) & 255) * 306) + (((i14 >> 8) & 255) * 601)) + ((i14 & 255) * 117)) + 512) >> 10);
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public byte[] a(int i10, byte[] bArr) {
        if (i10 < 0 || i10 >= a()) {
            try {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Requested row is outside the image: ");
                sb2.append(i10);
                throw new IllegalArgumentException(sb2.toString());
            } catch (Exception e10) {
                throw e10;
            }
        } else {
            int c10 = c();
            if (bArr == null || bArr.length < c10) {
                bArr = new byte[c10];
            }
            System.arraycopy(this.f14285c, ((i10 + this.f14289g) * this.f14286d) + this.f14288f, bArr, 0, c10);
            return bArr;
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public byte[] b() {
        int c10 = c();
        int a10 = a();
        int i10 = this.f14286d;
        if (c10 == i10 && a10 == this.f14287e) {
            return this.f14285c;
        }
        int i11 = c10 * a10;
        byte[] bArr = new byte[i11];
        int i12 = (this.f14289g * i10) + this.f14288f;
        if (c10 == i10) {
            System.arraycopy(this.f14285c, i12, bArr, 0, i11);
            return bArr;
        }
        for (int i13 = 0; i13 < a10; i13++) {
            System.arraycopy(this.f14285c, i12, bArr, i13 * c10, c10);
            i12 += this.f14286d;
        }
        return bArr;
    }

    private s(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i14, i15);
        if (i14 + i12 > i10 || i15 + i13 > i11) {
            try {
                throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
            } catch (Exception e10) {
                throw e10;
            }
        } else {
            this.f14285c = bArr;
            this.f14286d = i10;
            this.f14287e = i11;
            this.f14288f = i12;
            this.f14289g = i13;
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public m a(int i10, int i11, int i12, int i13) {
        return new s(this.f14285c, this.f14286d, this.f14287e, this.f14288f + i10, this.f14289g + i11, i12, i13);
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public m b(int i10, int i11, int i12, int i13) {
        int i14 = this.f14287e;
        int i15 = this.f14286d;
        if (i14 > i15) {
            byte[] bArr = new byte[i10 * i11];
            for (int i16 = 0; i16 < this.f14287e; i16++) {
                byte[] bArr2 = this.f14285c;
                int i17 = this.f14286d;
                System.arraycopy(bArr2, i16 * i17, bArr, (i16 * i10) + i12, i17);
            }
            return new r(bArr, i10, i11, this.f14288f, this.f14289g, i10, i11, false);
        }
        byte[] bArr3 = new byte[i10 * i11];
        System.arraycopy(this.f14285c, 0, bArr3, i13 * i10, i14 * i15);
        int i18 = this.f14286d;
        return new r(bArr3, i18, i11, this.f14288f, this.f14289g, i18, i11, false);
    }
}
