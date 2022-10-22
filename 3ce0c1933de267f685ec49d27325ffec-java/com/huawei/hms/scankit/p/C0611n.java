package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.C0631u;
/* compiled from: DataBlock.java */
/* renamed from: com.huawei.hms.scankit.p.n  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0611n {

    /* renamed from: a  reason: collision with root package name */
    private final int f14882a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f14883b;

    private C0611n(int i10, byte[] bArr) {
        this.f14882a = i10;
        this.f14883b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C0611n[] a(byte[] bArr, C0631u uVar) {
        C0631u.b c10 = uVar.c();
        C0631u.a[] a10 = c10.a();
        int i10 = 0;
        for (C0631u.a aVar : a10) {
            i10 += aVar.a();
        }
        C0611n[] nVarArr = new C0611n[i10];
        int i11 = 0;
        for (C0631u.a aVar2 : a10) {
            for (int i12 = 0; i12 < aVar2.a(); i12++) {
                int b10 = aVar2.b();
                i11++;
                nVarArr[i11] = new C0611n(b10, new byte[c10.b() + b10]);
            }
        }
        int length = nVarArr[0].f14883b.length - c10.b();
        int i13 = length - 1;
        int i14 = 0;
        for (int i15 = 0; i15 < i13; i15++) {
            for (int i16 = 0; i16 < i11; i16++) {
                i14++;
                nVarArr[i16].f14883b[i15] = bArr[i14];
            }
        }
        boolean z10 = uVar.g() == 24;
        int i17 = z10 ? 8 : i11;
        for (int i18 = 0; i18 < i17; i18++) {
            i14++;
            nVarArr[i18].f14883b[i13] = bArr[i14];
        }
        int length2 = nVarArr[0].f14883b.length;
        while (length < length2) {
            for (int i19 = 0; i19 < i11; i19++) {
                int i20 = z10 ? (i19 + 8) % i11 : i19;
                i14++;
                nVarArr[i20].f14883b[(!z10 || i20 <= 7) ? length : length - 1] = bArr[i14];
            }
            length++;
        }
        if (i14 == bArr.length) {
            return nVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f14882a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f14883b;
    }
}
