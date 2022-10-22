package com.google.zxing.qrcode.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.common.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitMatrixParser.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final b f13454a;

    /* renamed from: b  reason: collision with root package name */
    private h f13455b;

    /* renamed from: c  reason: collision with root package name */
    private f f13456c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13457d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(b bVar) throws FormatException {
        int g10 = bVar.g();
        if (g10 < 21 || (g10 & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f13454a = bVar;
    }

    private int a(int i10, int i11, int i12) {
        return this.f13457d ? this.f13454a.d(i11, i10) : this.f13454a.d(i10, i11) ? (i12 << 1) | 1 : i12 << 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        int i10 = 0;
        while (i10 < this.f13454a.k()) {
            int i11 = i10 + 1;
            for (int i12 = i11; i12 < this.f13454a.g(); i12++) {
                if (this.f13454a.d(i10, i12) != this.f13454a.d(i12, i10)) {
                    this.f13454a.c(i12, i10);
                    this.f13454a.c(i10, i12);
                }
            }
            i10 = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] c() throws FormatException {
        f d10 = d();
        h e10 = e();
        c cVar = c.values()[d10.c()];
        int g10 = this.f13454a.g();
        cVar.b(this.f13454a, g10);
        b a10 = e10.a();
        byte[] bArr = new byte[e10.h()];
        int i10 = g10 - 1;
        boolean z10 = true;
        int i11 = i10;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 > 0) {
            if (i11 == 6) {
                i11--;
            }
            for (int i15 = 0; i15 < g10; i15++) {
                int i16 = z10 ? i10 - i15 : i15;
                for (int i17 = 0; i17 < 2; i17++) {
                    int i18 = i11 - i17;
                    if (!a10.d(i18, i16)) {
                        i13++;
                        i14 <<= 1;
                        if (this.f13454a.d(i18, i16)) {
                            i14 |= 1;
                        }
                        if (i13 == 8) {
                            i12++;
                            bArr[i12] = (byte) i14;
                            i13 = 0;
                            i14 = 0;
                        }
                    }
                }
            }
            z10 = !z10;
            i11 -= 2;
        }
        if (i12 == e10.h()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f d() throws FormatException {
        f fVar = this.f13456c;
        if (fVar != null) {
            return fVar;
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
        int g10 = this.f13454a.g();
        int i14 = g10 - 7;
        for (int i15 = g10 - 1; i15 >= i14; i15--) {
            i10 = a(8, i15, i10);
        }
        for (int i16 = g10 - 8; i16 < g10; i16++) {
            i10 = a(i16, 8, i10);
        }
        f a11 = f.a(a10, i10);
        this.f13456c = a11;
        if (a11 != null) {
            return a11;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h e() throws FormatException {
        h hVar = this.f13455b;
        if (hVar != null) {
            return hVar;
        }
        int g10 = this.f13454a.g();
        int i10 = (g10 - 17) / 4;
        if (i10 <= 6) {
            return h.i(i10);
        }
        int i11 = g10 - 11;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 5; i14 >= 0; i14--) {
            for (int i15 = g10 - 9; i15 >= i11; i15--) {
                i13 = a(i15, i14, i13);
            }
        }
        h c10 = h.c(i13);
        if (c10 == null || c10.e() != g10) {
            for (int i16 = 5; i16 >= 0; i16--) {
                for (int i17 = g10 - 9; i17 >= i11; i17--) {
                    i12 = a(i16, i17, i12);
                }
            }
            h c11 = h.c(i12);
            if (c11 == null || c11.e() != g10) {
                throw FormatException.getFormatInstance();
            }
            this.f13455b = c11;
            return c11;
        }
        this.f13455b = c10;
        return c10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        if (this.f13456c != null) {
            c.values()[this.f13456c.c()].b(this.f13454a, this.f13454a.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(boolean z10) {
        this.f13455b = null;
        this.f13456c = null;
        this.f13457d = z10;
    }
}
