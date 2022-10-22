package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
/* compiled from: CodaBarReader.java */
/* renamed from: com.huawei.hms.scankit.p.y  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0643y extends H {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f15007a = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f15008b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f15009c = {'A', 'B', 'C', 'D'};

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f15010d = new StringBuilder(20);

    /* renamed from: e  reason: collision with root package name */
    private int[] f15011e = new int[80];

    /* renamed from: f  reason: collision with root package name */
    private int f15012f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f15013g;

    private int b() throws C0550a {
        for (int i10 = 1; i10 < this.f15012f; i10 += 2) {
            int b10 = b(i10);
            if (b10 != -1 && a(f15009c, f15007a[b10])) {
                int i11 = 0;
                for (int i12 = i10; i12 < i10 + 7; i12++) {
                    i11 += this.f15011e[i12];
                }
                if (i10 == 1 || this.f15011e[i10 - 1] >= i11 / 2) {
                    return i10;
                }
            }
        }
        throw C0550a.a();
    }

    private void c(int i10) throws C0550a {
        int[] iArr = {0, 0, 0, 0};
        int[] iArr2 = {0, 0, 0, 0};
        int length = this.f15010d.length() - 1;
        int i11 = 0;
        int i12 = i10;
        int i13 = 0;
        while (true) {
            int i14 = f15008b[this.f15010d.charAt(i13)];
            for (int i15 = 6; i15 >= 0; i15--) {
                int i16 = (i15 & 1) + ((i14 & 1) * 2);
                iArr[i16] = iArr[i16] + this.f15011e[i12 + i15];
                iArr2[i16] = iArr2[i16] + 1;
                i14 >>= 1;
            }
            if (i13 >= length) {
                break;
            }
            i12 += 8;
            i13++;
        }
        float[] fArr = new float[4];
        float[] fArr2 = new float[4];
        for (int i17 = 0; i17 < 2; i17++) {
            fArr2[i17] = 0.0f;
            int i18 = i17 + 2;
            fArr2[i18] = ((iArr[i17] / iArr2[i17]) + (iArr[i18] / iArr2[i18])) / 2.0f;
            fArr[i17] = fArr2[i18];
            fArr[i18] = ((iArr[i18] * 2.0f) + 1.5f) / iArr2[i18];
        }
        loop3: while (true) {
            int i19 = f15008b[this.f15010d.charAt(i11)];
            for (int i20 = 6; i20 >= 0; i20--) {
                int i21 = (i20 & 1) + ((i19 & 1) * 2);
                float f10 = this.f15011e[i10 + i20];
                if (f10 < fArr2[i21] || f10 > fArr[i21]) {
                    break loop3;
                }
                i19 >>= 1;
            }
            if (i11 < length) {
                i10 += 8;
                i11++;
            } else {
                return;
            }
        }
        throw C0550a.a();
    }

    @Override // com.huawei.hms.scankit.p.H
    public x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a {
        Arrays.fill(this.f15011e, 0);
        a(hVar);
        int[] a10 = a();
        int i11 = a10[0];
        int i12 = a10[1];
        for (int i13 = 0; i13 < this.f15010d.length(); i13++) {
            StringBuilder sb2 = this.f15010d;
            sb2.setCharAt(i13, f15007a[sb2.charAt(i13)]);
        }
        char charAt = this.f15010d.charAt(0);
        char[] cArr = f15009c;
        if (a(cArr, charAt)) {
            StringBuilder sb3 = this.f15010d;
            if (!a(cArr, sb3.charAt(sb3.length() - 1))) {
                throw C0550a.a();
            } else if (this.f15010d.length() > 3) {
                int i14 = this.f15013g;
                for (int i15 = 0; i15 < i11; i15++) {
                    i14 += this.f15011e[i15];
                }
                float f10 = i14;
                while (i11 < i12 - 1) {
                    i14 += this.f15011e[i11];
                    i11++;
                }
                float f11 = i10;
                return new x(this.f15010d.toString(), null, new z[]{new z(f10, f11), new z(i14, f11)}, BarcodeFormat.CODABAR);
            } else {
                throw C0550a.a();
            }
        } else {
            throw C0550a.a();
        }
    }

    private int b(int i10) {
        int i11 = i10 + 7;
        if (i11 >= this.f15012f) {
            return -1;
        }
        int[] iArr = this.f15011e;
        HashSet<Integer> hashSet = new HashSet();
        for (int i12 = i10; i12 < i11; i12++) {
            hashSet.add(Integer.valueOf(iArr[i12]));
        }
        int i13 = 0;
        int i14 = 0;
        for (Integer num : hashSet) {
            i14 += num.intValue();
        }
        if (hashSet.size() > 0) {
            int size = i14 / hashSet.size();
            int i15 = 128;
            int i16 = 0;
            for (int i17 = 0; i17 < 7; i17++) {
                i15 >>= 1;
                if (iArr[i10 + i17] > size) {
                    i16 |= i15;
                }
            }
            while (true) {
                int[] iArr2 = f15008b;
                if (i13 >= iArr2.length) {
                    break;
                } else if (iArr2[i13] == i16) {
                    return i13;
                } else {
                    i13++;
                }
            }
        }
        return -1;
    }

    private int[] a() throws C0550a {
        int b10 = b();
        this.f15010d.setLength(0);
        int i10 = b10;
        do {
            int b11 = b(i10);
            if (b11 != -1) {
                this.f15010d.append((char) b11);
                i10 += 8;
                if (this.f15010d.length() > 1 && a(f15009c, f15007a[b11])) {
                    break;
                }
            } else {
                throw C0550a.a();
            }
        } while (i10 < this.f15012f);
        int i11 = this.f15011e[i10 - 1];
        int i12 = 0;
        for (int i13 = -8; i13 < -1; i13++) {
            i12 += this.f15011e[i10 + i13];
        }
        if (i10 >= this.f15012f || i11 >= i12 / 2) {
            c(b10);
            return new int[]{b10, i10};
        }
        throw C0550a.a();
    }

    private void a(C0591h hVar) throws C0550a {
        int i10 = 0;
        this.f15012f = 0;
        int c10 = hVar.c(0);
        this.f15013g = c10;
        int d10 = hVar.d();
        if (c10 < d10) {
            boolean z10 = true;
            while (c10 < d10) {
                if (hVar.a(c10) != z10) {
                    i10++;
                } else {
                    a(i10);
                    z10 = !z10;
                    i10 = 1;
                }
                c10++;
            }
            a(i10);
            return;
        }
        throw C0550a.a();
    }

    private void a(int i10) throws C0550a {
        try {
            int[] iArr = this.f15011e;
            int i11 = this.f15012f;
            iArr[i11] = i10;
            int i12 = i11 + 1;
            this.f15012f = i12;
            if (i12 >= iArr.length) {
                int[] iArr2 = new int[i12 * 2];
                System.arraycopy(iArr, 0, iArr2, 0, i12);
                this.f15011e = iArr2;
            }
        } catch (NumberFormatException unused) {
            throw C0550a.a();
        }
    }

    public static boolean a(char[] cArr, char c10) {
        if (cArr != null) {
            for (char c11 : cArr) {
                if (c11 == c10) {
                    return true;
                }
            }
        }
        return false;
    }
}
