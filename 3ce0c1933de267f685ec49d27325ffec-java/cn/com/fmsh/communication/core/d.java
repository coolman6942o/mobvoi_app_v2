package cn.com.fmsh.communication.core;

import x2.e;
import x2.g;
import x2.h;
import y2.c;
import z2.a;
import z2.b;
/* loaded from: classes.dex */
class d {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ a f6091a = b.a().b();

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f6092b = d.class.getName();

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ byte f6093c;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ byte[] f6094d;

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ byte f6095e;

    /* renamed from: f  reason: collision with root package name */
    private /* synthetic */ byte[] f6096f;

    /* renamed from: g  reason: collision with root package name */
    private /* synthetic */ byte[] f6097g;

    /* renamed from: h  reason: collision with root package name */
    private /* synthetic */ byte[] f6098h;

    /* renamed from: i  reason: collision with root package name */
    private /* synthetic */ byte[] f6099i;

    /* renamed from: j  reason: collision with root package name */
    private /* synthetic */ byte[] f6100j;

    /* renamed from: k  reason: collision with root package name */
    private /* synthetic */ byte[] f6101k;

    /* renamed from: l  reason: collision with root package name */
    private /* synthetic */ byte[] f6102l;

    /* renamed from: m  reason: collision with root package name */
    private /* synthetic */ byte[] f6103m;

    private final /* bridge */ /* synthetic */ byte[] a() {
        byte[] bArr = this.f6100j;
        int length = (bArr == null || bArr.length <= 0) ? 1 : bArr.length + 1;
        int i10 = 63 + length;
        byte[] bArr2 = this.f6101k;
        int length2 = (bArr2 == null || bArr2.length <= 0) ? 1 : bArr2.length + 1;
        int i11 = i10 + length2 + 1;
        byte[] bArr3 = new byte[i11];
        for (int i12 = 0; i12 < 8; i12++) {
            bArr3[i12 + 0] = this.f6096f[i12];
        }
        byte[] bArr4 = this.f6097g;
        if (bArr4 == null || bArr4.length != 32) {
            a aVar = this.f6091a;
            if (aVar != null) {
                aVar.c(e.a(6, "\u0014.djTo~czywNzspmxz"), x2.d.c("\u00179?%Ohm|i>,\u0001!dsr{-j/#_wku-纚窬罂厲敦捩丕吁沏", 5));
            }
            return null;
        }
        for (int i13 = 0; i13 < 32; i13++) {
            bArr3[i13 + 8] = this.f6097g[i13];
        }
        byte[] bArr5 = this.f6098h;
        if (bArr5 == null || bArr5.length < 1) {
            this.f6098h = x2.d.f(h.c(x2.d.c("vy(;\u001e\tqb_@4'(?", 156)));
        }
        if (this.f6098h.length != 7) {
            a aVar2 = this.f6091a;
            if (aVar2 != null) {
                aVar2.c(g.a(5, 122, "\u001a?,-\u000e2\"8,pwAhvt~f{"), g.a(5, 112, "\u001a50+F`fv<*;\u0017pt``&1u1zGlq0i纝窪旣闱敥捫乘呍沀"));
            }
            return null;
        }
        for (int i14 = 0; i14 < 7; i14++) {
            bArr3[i14 + 40] = this.f6098h[i14];
        }
        for (int i15 = 0; i15 < 16; i15++) {
            bArr3[i15 + 47] = this.f6099i[i15];
        }
        if (length > 1) {
            bArr3[63] = (byte) (length - 1);
            for (int i16 = 1; i16 < length; i16++) {
                bArr3[i16 + 63] = this.f6100j[i16 - 1];
            }
        } else {
            bArr3[63] = 0;
        }
        if (length2 > 1) {
            bArr3[i10] = (byte) (length2 - 1);
            for (int i17 = 1; i17 < length2; i17++) {
                bArr3[i10 + i17] = this.f6101k[i17 - 1];
            }
        } else {
            bArr3[i10] = 0;
        }
        bArr3[i11 - 1] = x2.a.a(bArr3);
        return bArr3;
    }

    public byte b() {
        return this.f6093c;
    }

    public void c(byte[] bArr) {
        this.f6101k = bArr;
    }

    public void d(byte[] bArr) {
        this.f6103m = bArr;
    }

    public void e(byte b10) {
        this.f6095e = b10;
    }

    public void f(byte[] bArr) {
        this.f6102l = bArr;
    }

    public void g(byte[] bArr) {
        this.f6100j = bArr;
    }

    public void h(byte[] bArr) {
        this.f6099i = bArr;
    }

    public void i(byte[] bArr) {
        this.f6097g = bArr;
    }

    public void j(byte[] bArr) {
        this.f6096f = bArr;
    }

    public void k(byte[] bArr) {
        this.f6094d = bArr;
    }

    public byte[] l() {
        byte[] c10 = c.c(this.f6102l, this.f6103m, a(), true);
        if (c10 == null) {
            return null;
        }
        int length = c10.length;
        byte[] bArr = new byte[length + 5];
        byte[] bArr2 = this.f6094d;
        if (bArr2.length != 2) {
            a aVar = this.f6091a;
            if (aVar != null) {
                String str = this.f6092b;
                aVar.a(str, x2.a.b("rq{\":w`\u00067jfh", 2, 32) + x2.c.c(c10));
            }
            return null;
        }
        bArr[0] = 0;
        bArr[1] = bArr2[0];
        bArr[2] = bArr2[1];
        bArr[3] = b();
        bArr[4] = this.f6095e;
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10 + 5] = c10[i10];
        }
        return bArr;
    }
}
