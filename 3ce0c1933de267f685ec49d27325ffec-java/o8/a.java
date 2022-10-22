package o8;
/* compiled from: BitSource.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f31455a;

    /* renamed from: b  reason: collision with root package name */
    private int f31456b;

    /* renamed from: c  reason: collision with root package name */
    private int f31457c;

    public a(byte[] bArr) {
        this.f31455a = bArr;
    }

    public int a() {
        return ((this.f31455a.length - this.f31456b) * 8) - this.f31457c;
    }

    public int b() {
        return this.f31457c;
    }

    public int c() {
        return this.f31456b;
    }

    public int d(int i10) {
        if (i10 <= 0 || i10 > 32 || i10 > a()) {
            throw new IllegalArgumentException(String.valueOf(i10));
        }
        int i11 = this.f31457c;
        int i12 = 0;
        if (i11 > 0) {
            int i13 = 8 - i11;
            int i14 = i10 < i13 ? i10 : i13;
            int i15 = i13 - i14;
            byte[] bArr = this.f31455a;
            int i16 = this.f31456b;
            i12 = (((255 >> (8 - i14)) << i15) & bArr[i16]) >> i15;
            i10 -= i14;
            int i17 = i11 + i14;
            this.f31457c = i17;
            if (i17 == 8) {
                this.f31457c = 0;
                this.f31456b = i16 + 1;
            }
        }
        if (i10 <= 0) {
            return i12;
        }
        while (i10 >= 8) {
            int i18 = i12 << 8;
            byte[] bArr2 = this.f31455a;
            int i19 = this.f31456b;
            i12 = (bArr2[i19] & 255) | i18;
            this.f31456b = i19 + 1;
            i10 -= 8;
        }
        if (i10 <= 0) {
            return i12;
        }
        int i20 = 8 - i10;
        int i21 = (i12 << i10) | ((((255 >> i20) << i20) & this.f31455a[this.f31456b]) >> i20);
        this.f31457c += i10;
        return i21;
    }
}
