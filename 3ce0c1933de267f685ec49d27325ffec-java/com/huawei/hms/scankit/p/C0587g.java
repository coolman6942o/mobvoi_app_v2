package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
/* compiled from: BinaryBitmap.java */
/* renamed from: com.huawei.hms.scankit.p.g  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0587g {

    /* renamed from: a  reason: collision with root package name */
    private final AbstractC0583f f14792a;

    /* renamed from: b  reason: collision with root package name */
    private C0595i f14793b;

    public C0587g(AbstractC0583f fVar) {
        if (fVar != null) {
            this.f14792a = fVar;
            return;
        }
        try {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        } catch (Exception e10) {
            throw e10;
        }
    }

    public C0591h a(int i10, int i11) throws C0550a {
        int i12;
        int e10 = e();
        if (e10 >= 45) {
            C0591h hVar = new C0591h(e10);
            byte[] bArr = new byte[e10];
            a().c().a(i10, bArr);
            int[] iArr = new int[e10];
            int[] iArr2 = new int[e10];
            iArr[0] = bArr[0] & 255;
            iArr2[0] = iArr[0] * iArr[0];
            for (int i13 = 1; i13 < e10; i13++) {
                iArr[i13] = iArr[i13 - 1] + (bArr[i13] & 255);
            }
            if (i11 != 0) {
                return a(45, e10, iArr, iArr2, bArr, 22);
            }
            int i14 = 23;
            while (true) {
                i12 = e10 - 22;
                if (i14 >= i12) {
                    break;
                }
                if ((bArr[i14] & 255) + 5 < (iArr[i14 + 22] - iArr[(i14 - 22) - 1]) / 45) {
                    hVar.d(i14);
                }
                i14++;
            }
            if (hVar.a(23)) {
                hVar.c(0, 23);
            }
            if (hVar.a(i12 - 1)) {
                hVar.c(i12, e10);
            }
            return hVar;
        }
        throw C0550a.a();
    }

    public C0595i b() throws C0550a {
        if (this.f14793b == null) {
            this.f14793b = this.f14792a.a();
        }
        return this.f14793b;
    }

    public int c() {
        return this.f14792a.b();
    }

    public byte[] d() {
        return this.f14792a.c().b();
    }

    public int e() {
        return this.f14792a.d();
    }

    private C0591h a(int i10, int i11, int[] iArr, int[] iArr2, byte[] bArr, int i12) {
        int i13;
        int i14;
        int i15;
        C0591h hVar = new C0591h(i11);
        for (int i16 = 1; i16 < i11; i16++) {
            iArr2[i16] = iArr2[i16 - 1] + ((bArr[i16] & 255) * (bArr[i16] & 255));
        }
        int i17 = i12 + 1;
        int i18 = i17;
        while (true) {
            i13 = i11 - i12;
            if (i18 >= i13) {
                break;
            }
            double d10 = iArr[i18 + i12] - iArr[(i18 - i12) - 1];
            double d11 = i10;
            if ((bArr[i18] & 255) <= (d10 / d11) * ((0.5f * (Math.sqrt(((iArr2[i14] - iArr2[i15]) - ((d10 * d10) / d11)) / (i10 - 1)) / 127)) + 1.0d)) {
                hVar.d(i18);
            }
            i18++;
        }
        if (hVar.a(i17)) {
            hVar.c(0, i17);
        }
        if (hVar.a(i13 - 1)) {
            hVar.c(i13, i11);
        }
        return hVar;
    }

    public C0591h a(int i10, C0591h hVar) throws C0550a {
        return this.f14792a.a(i10, hVar);
    }

    public void a(C0595i iVar) {
        this.f14793b = iVar;
    }

    public C0587g a(int i10, int i11, int i12, int i13) {
        return new C0587g(this.f14792a.a(this.f14792a.c().a(i10, i11, i12, i13)));
    }

    public AbstractC0583f a() {
        return this.f14792a;
    }
}
