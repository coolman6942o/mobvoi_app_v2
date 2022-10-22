package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.Ia;
import com.huawei.hms.scankit.util.b;
/* compiled from: DataBlock.java */
/* renamed from: com.huawei.hms.scankit.p.la  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
final class C0606la {

    /* renamed from: a  reason: collision with root package name */
    private final int f14863a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f14864b;

    private C0606la(int i10, byte[] bArr) {
        this.f14863a = i10;
        this.f14864b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static C0606la[] a(byte[] bArr, Ia ia2, EnumC0647za zaVar) {
        if (bArr.length == ia2.d()) {
            Ia.b a10 = ia2.a(zaVar);
            Ia.a[] a11 = a10.a();
            int i10 = 0;
            for (Ia.a aVar : a11) {
                i10 += aVar.a();
            }
            C0606la[] laVarArr = new C0606la[i10];
            int i11 = 0;
            for (Ia.a aVar2 : a11) {
                for (int i12 = 0; i12 < aVar2.a(); i12++) {
                    int b10 = aVar2.b();
                    i11++;
                    laVarArr[i11] = new C0606la(b10, new byte[a10.b() + b10]);
                }
            }
            int length = laVarArr[0].f14864b.length;
            int i13 = i10 - 1;
            while (i13 >= 0 && laVarArr[i13].f14864b.length != length) {
                i13--;
            }
            return a(laVarArr, bArr, length, a10, i11, i13 + 1);
        }
        try {
            throw new IllegalArgumentException();
        } catch (Exception e10) {
            throw e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f14863a;
    }

    private static C0606la[] a(C0606la[] laVarArr, byte[] bArr, int i10, Ia.b bVar, int i11, int i12) {
        int b10 = i10 - bVar.b();
        int i13 = 0;
        for (int i14 = 0; i14 < b10; i14++) {
            for (int i15 = 0; i15 < i11; i15++) {
                i13++;
                laVarArr[i15].f14864b[i14] = bArr[i13];
            }
        }
        for (int i16 = i12; i16 < i11; i16++) {
            i13++;
            laVarArr[i16].f14864b[b10] = bArr[i13];
        }
        int length = laVarArr[0].f14864b.length;
        while (b10 < length) {
            int i17 = 0;
            while (i17 < i11) {
                int i18 = i17 < i12 ? b10 : b10 + 1;
                if (i17 >= 0) {
                    try {
                        if (i17 < laVarArr.length && b.a(laVarArr[i17].f14864b, i18) && b.a(bArr, i13)) {
                            i13++;
                            laVarArr[i17].f14864b[i18] = bArr[i13];
                            i17++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e10) {
                        throw e10;
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            b10++;
        }
        return laVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f14864b;
    }
}
