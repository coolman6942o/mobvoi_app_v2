package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.b;
import java.util.Arrays;
/* compiled from: BitArray.java */
/* renamed from: com.huawei.hms.scankit.p.h  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0591h implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int[] f14805a;

    /* renamed from: b  reason: collision with root package name */
    private int[] f14806b;

    /* renamed from: c  reason: collision with root package name */
    private int f14807c;

    public C0591h() {
        this.f14807c = 0;
        this.f14805a = new int[1];
    }

    private void f(int i10) {
        if (i10 > this.f14805a.length * 32) {
            int[] h10 = h(i10);
            int[] iArr = this.f14805a;
            System.arraycopy(iArr, 0, h10, 0, iArr.length);
            this.f14805a = h10;
        }
    }

    private int g(int i10) {
        int i11 = 0;
        while (i10 > 0) {
            i10 &= i10 - 1;
            i11++;
        }
        return i11;
    }

    public boolean a(int i10) {
        return ((1 << (i10 & 31)) & this.f14805a[i10 / 32]) != 0;
    }

    public void b() {
        this.f14806b = this.f14805a;
    }

    public int c(int i10) {
        int i11 = this.f14807c;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        if (!b.a(this.f14805a, i12)) {
            return -1;
        }
        int i13 = (-(1 << (i10 & 31))) & (~this.f14805a[i12]);
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f14805a;
            if (i12 == iArr.length) {
                return this.f14807c;
            }
            if (b.a(iArr, i12)) {
                i13 = ~this.f14805a[i12];
            }
        }
        int numberOfTrailingZeros = (i12 * 32) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.f14807c;
        return numberOfTrailingZeros > i14 ? i14 : numberOfTrailingZeros;
    }

    public int d() {
        return this.f14807c;
    }

    public int e() {
        return (this.f14807c + 7) / 8;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0591h)) {
            return false;
        }
        C0591h hVar = (C0591h) obj;
        return this.f14807c == hVar.f14807c && Arrays.equals(this.f14805a, hVar.f14805a);
    }

    public void g() {
        int[] iArr = new int[this.f14805a.length];
        int i10 = (this.f14807c - 1) / 32;
        int i11 = i10 + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            long j10 = this.f14805a[i12];
            long j11 = ((j10 & 1431655765) << 1) | ((j10 >> 1) & 1431655765);
            long j12 = ((j11 & 858993459) << 2) | ((j11 >> 2) & 858993459);
            long j13 = ((j12 & 252645135) << 4) | ((j12 >> 4) & 252645135);
            long j14 = ((j13 & 16711935) << 8) | ((j13 >> 8) & 16711935);
            iArr[i10 - i12] = (int) (((j14 & 65535) << 16) | ((j14 >> 16) & 65535));
        }
        int i13 = this.f14807c;
        int i14 = i11 * 32;
        if (i13 != i14) {
            int i15 = i14 - i13;
            int i16 = iArr[0] >>> i15;
            for (int i17 = 1; i17 < i11; i17++) {
                int i18 = iArr[i17];
                iArr[i17 - 1] = i16 | (i18 << (32 - i15));
                i16 = i18 >>> i15;
            }
            iArr[i11 - 1] = i16;
        }
        this.f14805a = iArr;
    }

    public void h() {
        for (int i10 = 0; i10 < this.f14807c - 1; i10++) {
            if (!a(i10) && a(i10 + 1)) {
                d(i10);
            }
        }
    }

    public int hashCode() {
        return (this.f14807c * 31) + Arrays.hashCode(this.f14805a);
    }

    public void i() {
        for (int i10 = 0; i10 < this.f14807c - 1; i10++) {
            if (a(i10) && !a(i10 + 1)) {
                e(i10);
            }
        }
    }

    public String toString() {
        int i10 = this.f14807c;
        StringBuilder sb2 = new StringBuilder(i10 + (i10 / 8) + 1);
        for (int i11 = 0; i11 < this.f14807c; i11++) {
            if ((i11 & 7) == 0) {
                sb2.append(' ');
            }
            sb2.append(a(i11) ? 'X' : '.');
        }
        return sb2.toString();
    }

    public void a() {
        int length = this.f14805a.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f14805a[i10] = 0;
        }
    }

    public int b(int i10) {
        int i11 = this.f14807c;
        if (i10 >= i11) {
            return i11;
        }
        int i12 = i10 / 32;
        if (!b.a(this.f14805a, i12)) {
            return -1;
        }
        int i13 = (-(1 << (i10 & 31))) & this.f14805a[i12];
        while (i13 == 0) {
            i12++;
            int[] iArr = this.f14805a;
            if (i12 == iArr.length) {
                return this.f14807c;
            }
            if (b.a(iArr, i12)) {
                i13 = this.f14805a[i12];
            }
        }
        int numberOfTrailingZeros = (i12 * 32) + Integer.numberOfTrailingZeros(i13);
        int i14 = this.f14807c;
        return numberOfTrailingZeros > i14 ? i14 : numberOfTrailingZeros;
    }

    public C0591h clone() {
        return new C0591h((int[]) this.f14805a.clone(), this.f14807c);
    }

    public void d(int i10) {
        int[] iArr = this.f14805a;
        int i11 = i10 / 32;
        iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
    }

    public void e(int i10) {
        int[] iArr = this.f14805a;
        int i11 = i10 / 32;
        iArr[i11] = iArr[i11] - (1 << (i10 & 31));
    }

    public C0591h(int i10) {
        this.f14807c = i10;
        this.f14805a = h(i10);
    }

    private static int[] h(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public boolean a(int i10, int i11, boolean z10, boolean z11) {
        if (i11 < i10 || i10 < 0 || i11 > this.f14807c) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e10) {
                throw e10;
            }
        } else if (i11 == i10) {
            return true;
        } else {
            int i12 = i11 - 1;
            int i13 = i10 / 32;
            int i14 = i12 / 32;
            int i15 = i13;
            int i16 = 0;
            while (i15 <= i14) {
                int i17 = (2 << (i15 < i14 ? 31 : i12 & 31)) - (1 << (i15 > i13 ? 0 : i10 & 31));
                if (!z11 && (i16 = i16 + g(this.f14805a[i15] & i17)) > (i12 - i10) / 10) {
                    return false;
                }
                if (z11) {
                    int i18 = this.f14805a[i15] & i17;
                    if (!z10) {
                        i17 = 0;
                    }
                    if (i18 != i17) {
                        return false;
                    }
                }
                i15++;
            }
            return true;
        }
    }

    public void f() {
        this.f14805a = this.f14806b;
    }

    C0591h(int[] iArr, int i10) {
        this.f14805a = iArr;
        this.f14807c = i10;
    }

    public void c(int i10, int i11) {
        if (i11 < i10 || i10 < 0 || i11 > this.f14807c) {
            try {
                throw new IllegalArgumentException();
            } catch (Exception e10) {
                throw e10;
            }
        } else if (i11 != i10) {
            int i12 = i11 - 1;
            int i13 = i10 / 32;
            int i14 = i12 / 32;
            int i15 = i13;
            while (i15 <= i14) {
                int i16 = 31;
                int i17 = i15 > i13 ? 0 : i10 & 31;
                if (i15 >= i14) {
                    i16 = 31 & i12;
                }
                int i18 = (2 << i16) - (1 << i17);
                int[] iArr = this.f14805a;
                iArr[i15] = i18 | iArr[i15];
                i15++;
            }
        }
    }

    public void a(boolean z10) {
        f(this.f14807c + 1);
        if (z10) {
            int[] iArr = this.f14805a;
            int i10 = this.f14807c;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f14807c++;
    }

    public void b(int i10, int i11) {
        this.f14805a[i10 / 32] = i11;
    }

    public void b(C0591h hVar) {
        if (this.f14807c == hVar.f14807c) {
            int i10 = 0;
            while (true) {
                int[] iArr = this.f14805a;
                if (i10 < iArr.length) {
                    iArr[i10] = iArr[i10] ^ hVar.f14805a[i10];
                    i10++;
                } else {
                    return;
                }
            }
        } else {
            try {
                throw new IllegalArgumentException("Sizes don't match");
            } catch (Exception e10) {
                throw e10;
            }
        }
    }

    public void a(int i10, int i11) {
        if (i11 < 0 || i11 > 32) {
            try {
                throw new IllegalArgumentException("Num bits must be between 0 and 32");
            } catch (Exception e10) {
                throw e10;
            }
        } else {
            f(this.f14807c + i11);
            while (i11 > 0) {
                boolean z10 = true;
                if (((i10 >> (i11 - 1)) & 1) != 1) {
                    z10 = false;
                }
                a(z10);
                i11--;
            }
        }
    }

    public int[] c() {
        return this.f14805a;
    }

    public void a(C0591h hVar) {
        int i10 = hVar.f14807c;
        f(this.f14807c + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(hVar.a(i11));
        }
    }

    public void a(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (a(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }
}
