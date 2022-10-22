package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.util.b;
/* compiled from: BitSource.java */
/* renamed from: com.huawei.hms.scankit.p.j  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0599j {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f14824a;

    /* renamed from: b  reason: collision with root package name */
    private int f14825b;

    /* renamed from: c  reason: collision with root package name */
    private int f14826c;

    public C0599j(byte[] bArr) {
        this.f14824a = bArr;
    }

    public int a(int i10) {
        if (i10 < 1 || i10 > 32 || i10 > a()) {
            try {
                throw new IllegalArgumentException(String.valueOf(i10));
            } catch (Exception e10) {
                throw e10;
            }
        } else {
            int i11 = this.f14826c;
            int i12 = 0;
            if (i11 > 0) {
                int i13 = 8 - i11;
                int i14 = i10 < i13 ? i10 : i13;
                int i15 = i13 - i14;
                int i16 = b.a(this.f14824a, this.f14825b) ? (((255 >> (8 - i14)) << i15) & this.f14824a[this.f14825b]) >> i15 : 0;
                i10 -= i14;
                int i17 = this.f14826c + i14;
                this.f14826c = i17;
                if (i17 == 8) {
                    this.f14826c = 0;
                    this.f14825b++;
                }
                i12 = i16;
            }
            if (i10 > 0) {
                while (i10 >= 8) {
                    if (b.a(this.f14824a, this.f14825b)) {
                        i12 = (i12 << 8) | (this.f14824a[this.f14825b] & 255);
                    }
                    this.f14825b++;
                    i10 -= 8;
                }
                if (i10 > 0) {
                    int i18 = 8 - i10;
                    int i19 = (255 >> i18) << i18;
                    if (b.a(this.f14824a, this.f14825b)) {
                        i12 = ((i19 & this.f14824a[this.f14825b]) >> i18) | (i12 << i10);
                    }
                    this.f14826c += i10;
                }
            }
            return i12;
        }
    }

    public int b() {
        return this.f14826c;
    }

    public int c() {
        return this.f14825b;
    }

    public int a() {
        return ((this.f14824a.length - this.f14825b) * 8) - this.f14826c;
    }
}
