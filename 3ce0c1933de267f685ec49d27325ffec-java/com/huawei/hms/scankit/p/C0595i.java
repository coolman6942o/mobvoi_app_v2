package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.b;
import java.util.Arrays;
/* compiled from: BitMatrix.java */
/* renamed from: com.huawei.hms.scankit.p.i  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0595i implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private final int f14811a;

    /* renamed from: b  reason: collision with root package name */
    private final int f14812b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14813c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f14814d;

    public C0595i(int i10) {
        this(i10, i10);
    }

    public void a(int i10, int i11) {
        int i12 = (i11 * this.f14813c) + (i10 / 32);
        if (b.a(this.f14814d, i12)) {
            int[] iArr = this.f14814d;
            iArr[i12] = (1 << (i10 & 31)) ^ iArr[i12];
        }
    }

    public boolean b(int i10, int i11) {
        int i12 = (i11 * this.f14813c) + (i10 / 32);
        return b.a(this.f14814d, i12) && ((this.f14814d[i12] >>> (i10 & 31)) & 1) != 0;
    }

    public void c(int i10, int i11) {
        int i12 = (i11 * this.f14813c) + (i10 / 32);
        if (b.a(this.f14814d, i12)) {
            int[] iArr = this.f14814d;
            iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
        }
    }

    public int d() {
        return this.f14811a;
    }

    public void e() {
        int d10 = d();
        int b10 = b();
        C0591h hVar = new C0591h(d10);
        C0591h hVar2 = new C0591h(d10);
        for (int i10 = 0; i10 < (b10 + 1) / 2; i10++) {
            hVar = a(i10, hVar);
            int i11 = (b10 - 1) - i10;
            hVar2 = a(i11, hVar2);
            hVar.g();
            hVar2.g();
            b(i10, hVar2);
            b(i11, hVar);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0595i)) {
            return false;
        }
        C0595i iVar = (C0595i) obj;
        return this.f14811a == iVar.f14811a && this.f14812b == iVar.f14812b && this.f14813c == iVar.f14813c && Arrays.equals(this.f14814d, iVar.f14814d);
    }

    public int hashCode() {
        int i10 = this.f14811a;
        return (((((((i10 * 31) + i10) * 31) + this.f14812b) * 31) + this.f14813c) * 31) + Arrays.hashCode(this.f14814d);
    }

    public String toString() {
        return a("X ", "  ");
    }

    public C0595i(int i10, int i11) {
        if (i10 < 1 || i11 < 1) {
            try {
                throw new IllegalArgumentException("Both dimensions must be greater than 0");
            } catch (Exception e10) {
                throw e10;
            }
        } else {
            this.f14811a = i10;
            this.f14812b = i11;
            int i12 = (i10 + 31) / 32;
            this.f14813c = i12;
            this.f14814d = new int[i12 * i11];
        }
    }

    public C0595i clone() {
        return new C0595i(this.f14811a, this.f14812b, this.f14813c, (int[]) this.f14814d.clone());
    }

    public void a() {
        int length = this.f14814d.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f14814d[i10] = 0;
        }
    }

    public void b(int i10, C0591h hVar) {
        int[] c10 = hVar.c();
        int[] iArr = this.f14814d;
        int i11 = this.f14813c;
        System.arraycopy(c10, 0, iArr, i10 * i11, i11);
    }

    public C0595i c() {
        int[] iArr = new int[this.f14814d.length];
        int i10 = 0;
        while (true) {
            int[] iArr2 = this.f14814d;
            if (i10 >= iArr2.length) {
                return new C0595i(this.f14811a, this.f14812b, this.f14813c, iArr);
            }
            iArr[i10] = ~iArr2[i10];
            i10++;
        }
    }

    public int b() {
        return this.f14812b;
    }

    public void a(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            try {
                throw new IllegalArgumentException("Left and top must be nonnegative");
            } catch (Exception e10) {
                throw e10;
            }
        } else if (i13 < 1 || i12 < 1) {
            try {
                throw new IllegalArgumentException("Height and width must be at least 1");
            } catch (Exception e11) {
                throw e11;
            }
        } else {
            int i14 = i12 + i10;
            int i15 = i13 + i11;
            if (i15 > this.f14812b || i14 > this.f14811a) {
                try {
                    throw new IllegalArgumentException("The region must fit inside the matrix");
                } catch (Exception e12) {
                    throw e12;
                }
            } else {
                while (i11 < i15) {
                    int i16 = this.f14813c * i11;
                    for (int i17 = i10; i17 < i14; i17++) {
                        int[] iArr = this.f14814d;
                        int i18 = (i17 / 32) + i16;
                        iArr[i18] = iArr[i18] | (1 << (i17 & 31));
                    }
                    i11++;
                }
            }
        }
    }

    public C0595i(int i10, int i11, int i12, int[] iArr) {
        this.f14811a = i10;
        this.f14812b = i11;
        this.f14813c = i12;
        this.f14814d = iArr;
    }

    public C0591h a(int i10, C0591h hVar) {
        if (hVar == null || hVar.d() < this.f14811a) {
            hVar = new C0591h(this.f14811a);
        } else {
            hVar.a();
        }
        int i11 = i10 * this.f14813c;
        for (int i12 = 0; i12 < this.f14813c; i12++) {
            hVar.b(i12 * 32, this.f14814d[i11 + i12]);
        }
        return hVar;
    }

    public String a(String str, String str2) {
        return a(str, str2, "\n");
    }

    private String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f14812b * (this.f14811a + 1));
        for (int i10 = 0; i10 < this.f14812b; i10++) {
            for (int i11 = 0; i11 < this.f14811a; i11++) {
                sb2.append(b(i11, i10) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }
}
