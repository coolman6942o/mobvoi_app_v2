package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.util.b;
/* compiled from: PlanarYUVLuminanceSource.java */
/* loaded from: classes2.dex */
public final class r extends m {

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f14280c;

    /* renamed from: d  reason: collision with root package name */
    private final int f14281d;

    /* renamed from: e  reason: collision with root package name */
    private final int f14282e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14283f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14284g;

    public r(byte[] bArr, int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        super(i14, i15);
        if (i12 + i14 > i10 || i13 + i15 > i11) {
            try {
                throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
            } catch (Exception e10) {
                throw e10;
            }
        } else {
            this.f14280c = bArr;
            this.f14281d = i10;
            this.f14282e = i11;
            this.f14283f = i12;
            this.f14284g = i13;
            if (z10) {
                a(i14, i15);
            }
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
            System.arraycopy(this.f14280c, ((i10 + this.f14284g) * this.f14281d) + this.f14283f, bArr, 0, c10);
            return bArr;
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public byte[] b() {
        int c10 = c();
        int a10 = a();
        int i10 = this.f14281d;
        if (c10 == i10 && a10 == this.f14282e) {
            return this.f14280c;
        }
        int i11 = c10 * a10;
        byte[] bArr = new byte[i11];
        int i12 = (this.f14284g * i10) + this.f14283f;
        if (c10 == i10) {
            try {
                System.arraycopy(this.f14280c, i12, bArr, 0, i11);
                return bArr;
            } catch (ArrayIndexOutOfBoundsException | Exception unused) {
                return null;
            }
        } else {
            for (int i13 = 0; i13 < a10; i13++) {
                try {
                    System.arraycopy(this.f14280c, i12, bArr, i13 * c10, c10);
                    i12 += this.f14281d;
                } catch (ArrayIndexOutOfBoundsException | Exception unused2) {
                    return null;
                }
            }
            return bArr;
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public m a(int i10, int i11, int i12, int i13) {
        return new r(this.f14280c, this.f14281d, this.f14282e, this.f14283f + i10, this.f14284g + i11, i12, i13, false);
    }

    private void a(int i10, int i11) {
        byte[] bArr = this.f14280c;
        int i12 = (this.f14284g * this.f14281d) + this.f14283f;
        int i13 = 0;
        while (i13 < i11) {
            int i14 = (i10 / 2) + i12;
            int i15 = (i12 + i10) - 1;
            int i16 = i12;
            while (i16 < i14) {
                if (b.a(bArr, i16) && b.a(bArr, i15)) {
                    byte b10 = bArr[i16];
                    bArr[i16] = bArr[i15];
                    bArr[i15] = b10;
                }
                i16++;
                i15--;
            }
            i13++;
            i12 += this.f14281d;
        }
    }

    @Override // com.huawei.hms.scankit.aiscan.common.m
    public m b(int i10, int i11, int i12, int i13) {
        int i14 = this.f14282e;
        int i15 = this.f14281d;
        if (i14 > i15) {
            byte[] bArr = new byte[i10 * i11];
            for (int i16 = 0; i16 < this.f14282e; i16++) {
                byte[] bArr2 = this.f14280c;
                int i17 = this.f14281d;
                System.arraycopy(bArr2, i16 * i17, bArr, (i16 * i10) + i12, i17);
            }
            return new r(bArr, i10, i11, this.f14283f, this.f14284g, i10, i11, false);
        }
        byte[] bArr3 = new byte[i10 * i11];
        System.arraycopy(this.f14280c, 0, bArr3, i13 * i10, i14 * i15);
        int i18 = this.f14281d;
        return new r(bArr3, i18, i11, this.f14283f, this.f14284g, i18, i11, false);
    }
}
