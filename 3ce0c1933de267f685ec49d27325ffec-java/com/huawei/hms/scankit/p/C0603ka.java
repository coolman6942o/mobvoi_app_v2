package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
/* compiled from: BitMatrixParser.java */
/* renamed from: com.huawei.hms.scankit.p.ka  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0603ka {

    /* renamed from: a  reason: collision with root package name */
    private final C0595i f14846a;

    /* renamed from: b  reason: collision with root package name */
    private Ia f14847b;

    /* renamed from: c  reason: collision with root package name */
    private Ea f14848c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14849d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0603ka(C0595i iVar) throws C0550a {
        int b10 = iVar.b();
        if (b10 < 21 || (b10 & 3) != 1) {
            throw C0550a.a();
        }
        this.f14846a = iVar;
    }

    private int a(int i10, int i11, int i12) {
        return this.f14849d ? this.f14846a.b(i11, i10) : this.f14846a.b(i10, i11) ? (i12 << 1) | 1 : i12 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b() throws C0550a {
        Ea c10 = c();
        Ia d10 = d();
        EnumC0632ua uaVar = EnumC0632ua.values()[c10.a()];
        int b10 = this.f14846a.b();
        uaVar.a(this.f14846a, b10);
        C0595i a10 = d10.a();
        byte[] bArr = new byte[d10.d()];
        int i10 = b10 - 1;
        boolean z10 = true;
        int i11 = i10;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == 6) {
                i11--;
            }
            for (int i15 = 0; i15 < b10; i15++) {
                int i16 = z10 ? i10 - i15 : i15;
                for (int i17 = 0; i17 < 2; i17++) {
                    int i18 = i11 - i17;
                    if (!a10.b(i18, i16)) {
                        i14++;
                        i13 <<= 1;
                        if (this.f14846a.b(i18, i16)) {
                            i13 |= 1;
                        }
                        if (i14 == 8) {
                            i12++;
                            bArr[i12] = (byte) i13;
                            i13 = 0;
                            i14 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i11 -= 2;
        }
        if (i12 == d10.d()) {
            return bArr;
        }
        throw C0550a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ea c() throws C0550a {
        Ea ea2 = this.f14848c;
        if (ea2 != null) {
            return ea2;
        }
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < 6; i12++) {
            i11 = a(i12, 8, i11);
        }
        int a10 = a(8, 7, a(8, 8, a(7, 8, i11)));
        for (int i13 = 5; i13 >= 0; i13--) {
            a10 = a(8, i13, a10);
        }
        int b10 = this.f14846a.b();
        int i14 = b10 - 7;
        for (int i15 = b10 - 1; i15 >= i14; i15--) {
            i10 = a(8, i15, i10);
        }
        for (int i16 = b10 - 8; i16 < b10; i16++) {
            i10 = a(i16, 8, i10);
        }
        Ea a11 = Ea.a(a10, i10);
        this.f14848c = a11;
        if (a11 != null) {
            return a11;
        }
        throw C0550a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia d() throws C0550a {
        Ia ia2 = this.f14847b;
        if (ia2 != null) {
            return ia2;
        }
        int b10 = this.f14846a.b();
        int i10 = (b10 - 17) / 4;
        if (i10 <= 6) {
            return Ia.c(i10);
        }
        int i11 = b10 - 11;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = b10 - 9; i15 >= i11; i15--) {
                i13 = a(i15, i14, i13);
            }
        }
        Ia a10 = Ia.a(i13);
        if (a10 == null || a10.c() != b10) {
            for (int i16 = 5; i16 >= 0; i16--) {
                for (int i17 = b10 - 9; i17 >= i11; i17--) {
                    i12 = a(i16, i17, i12);
                }
            }
            Ia a11 = Ia.a(i12);
            if (a11 == null || a11.c() != b10) {
                throw C0550a.a();
            }
            this.f14847b = a11;
            return a11;
        }
        this.f14847b = a10;
        return a10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f14848c != null) {
            EnumC0632ua.values()[this.f14848c.a()].a(this.f14846a, this.f14846a.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z10) {
        this.f14847b = null;
        this.f14848c = null;
        this.f14849d = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        int i10 = 0;
        while (i10 < this.f14846a.d()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f14846a.b(); i12++) {
                if (this.f14846a.b(i10, i12) != this.f14846a.b(i12, i10)) {
                    this.f14846a.a(i12, i10);
                    this.f14846a.a(i10, i12);
                }
            }
            i10 = i11;
        }
    }
}
